package com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import nd.a;
import sun.util.locale.LanguageTag;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class LruBitmapPool implements BitmapPool {
    public static final Bitmap.Config DEFAULT_CONFIG = Bitmap.Config.ARGB_8888;
    public static final String TAG = "LruBitmapPool";
    public final Set<Bitmap.Config> allowedConfigs;
    public int currentSize;
    public int evictions;
    public int hits;
    public final int initialMaxSize;
    public int maxSize;
    public int misses;
    public int puts;
    public final LruPoolStrategy strategy;
    public final BitmapTracker tracker;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface BitmapTracker {
        void add(Bitmap bitmap);

        void remove(Bitmap bitmap);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class NullBitmapTracker implements BitmapTracker {
        public NullBitmapTracker() {
        }

        @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void add(Bitmap bitmap) {
        }

        @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void remove(Bitmap bitmap) {
        }

        public /* synthetic */ NullBitmapTracker(AnonymousClass1 anonymousClass1) {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class ThrowingBitmapTracker implements BitmapTracker {
        public final Set<Bitmap> bitmaps = Collections.synchronizedSet(new HashSet());

        @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void add(Bitmap bitmap) {
            if (!this.bitmaps.contains(bitmap)) {
                this.bitmaps.add(bitmap);
                return;
            }
            throw new IllegalStateException("Can't add already added bitmap: " + ((Object) bitmap) + " [" + bitmap.getWidth() + LanguageTag.PRIVATEUSE + bitmap.getHeight() + "]");
        }

        @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void remove(Bitmap bitmap) {
            if (this.bitmaps.contains(bitmap)) {
                this.bitmaps.remove(bitmap);
                return;
            }
            throw new IllegalStateException("Cannot remove bitmap not in tracker");
        }
    }

    public LruBitmapPool(int i10, LruPoolStrategy lruPoolStrategy, Set<Bitmap.Config> set) {
        this.initialMaxSize = i10;
        this.maxSize = i10;
        this.strategy = lruPoolStrategy;
        this.allowedConfigs = set;
        this.tracker = new NullBitmapTracker(null);
    }

    private void dump() {
        if (Log.isLoggable(TAG, 2)) {
            dumpUnchecked();
        }
    }

    private void dumpUnchecked() {
        StringBuilder a10 = a.a("Hits=");
        a10.append(this.hits);
        a10.append(", misses=");
        a10.append(this.misses);
        a10.append(", puts=");
        a10.append(this.puts);
        a10.append(", evictions=");
        a10.append(this.evictions);
        a10.append(", currentSize=");
        a10.append(this.currentSize);
        a10.append(", maxSize=");
        a10.append(this.maxSize);
        a10.append("\nStrategy=");
        a10.append((Object) this.strategy);
    }

    private void evict() {
        trimToSize(this.maxSize);
    }

    public static Set<Bitmap.Config> getDefaultAllowedConfigs() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(Arrays.asList(Bitmap.Config.values()));
        hashSet.add(null);
        return Collections.unmodifiableSet(hashSet);
    }

    public static LruPoolStrategy getDefaultStrategy() {
        return new SizeConfigStrategy();
    }

    private synchronized void trimToSize(int i10) {
        while (this.currentSize > i10) {
            Bitmap removeLast = this.strategy.removeLast();
            if (removeLast == null) {
                if (Log.isLoggable(TAG, 5)) {
                    dumpUnchecked();
                }
                this.currentSize = 0;
                return;
            } else {
                this.tracker.remove(removeLast);
                this.currentSize -= this.strategy.getSize(removeLast);
                removeLast.recycle();
                this.evictions++;
                if (Log.isLoggable(TAG, 3)) {
                    a.a("Evicting bitmap=").append(this.strategy.logBitmap(removeLast));
                }
                dump();
            }
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    public void clearMemory() {
        Log.isLoggable(TAG, 3);
        trimToSize(0);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    public synchronized Bitmap get(int i10, int i11, Bitmap.Config config) {
        Bitmap dirty;
        dirty = getDirty(i10, i11, config);
        if (dirty != null) {
            dirty.eraseColor(0);
        }
        return dirty;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    public synchronized Bitmap getDirty(int i10, int i11, Bitmap.Config config) {
        Bitmap bitmap;
        bitmap = this.strategy.get(i10, i11, config != null ? config : DEFAULT_CONFIG);
        if (bitmap == null) {
            if (Log.isLoggable(TAG, 3)) {
                a.a("Missing bitmap=").append(this.strategy.logBitmap(i10, i11, config));
            }
            this.misses++;
        } else {
            this.hits++;
            this.currentSize -= this.strategy.getSize(bitmap);
            this.tracker.remove(bitmap);
            bitmap.setHasAlpha(true);
        }
        if (Log.isLoggable(TAG, 2)) {
            a.a("Get bitmap=").append(this.strategy.logBitmap(i10, i11, config));
        }
        dump();
        return bitmap;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    public int getMaxSize() {
        return this.maxSize;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    public synchronized boolean put(Bitmap bitmap) {
        if (bitmap != null) {
            if (bitmap.isMutable() && this.strategy.getSize(bitmap) <= this.maxSize && this.allowedConfigs.contains(bitmap.getConfig())) {
                int size = this.strategy.getSize(bitmap);
                this.strategy.put(bitmap);
                this.tracker.add(bitmap);
                this.puts++;
                this.currentSize += size;
                if (Log.isLoggable(TAG, 2)) {
                    a.a("Put bitmap in pool=").append(this.strategy.logBitmap(bitmap));
                }
                dump();
                evict();
                return true;
            }
            if (Log.isLoggable(TAG, 2)) {
                StringBuilder a10 = a.a("Reject bitmap from pool, bitmap: ");
                a10.append(this.strategy.logBitmap(bitmap));
                a10.append(", is mutable: ");
                a10.append(bitmap.isMutable());
                a10.append(", is allowed config: ");
                a10.append(this.allowedConfigs.contains(bitmap.getConfig()));
            }
            return false;
        }
        throw new NullPointerException("Bitmap must not be null");
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    public synchronized void setSizeMultiplier(float f10) {
        this.maxSize = Math.round(this.initialMaxSize * f10);
        evict();
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool
    public void trimMemory(int i10) {
        if (Log.isLoggable(TAG, 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("trimMemory, level=");
            sb2.append(i10);
        }
        if (i10 >= 60) {
            clearMemory();
        } else if (i10 >= 40) {
            trimToSize(this.maxSize / 2);
        }
    }

    public LruBitmapPool(int i10) {
        this(i10, getDefaultStrategy(), getDefaultAllowedConfigs());
    }

    public LruBitmapPool(int i10, Set<Bitmap.Config> set) {
        this(i10, getDefaultStrategy(), set);
    }
}
