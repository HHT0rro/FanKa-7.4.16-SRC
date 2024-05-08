package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import sun.util.locale.LanguageTag;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class LruBitmapPool implements BitmapPool {
    private static final Bitmap.Config DEFAULT_CONFIG = Bitmap.Config.ARGB_8888;
    private static final String TAG = "LruBitmapPool";
    private final Set<Bitmap.Config> allowedConfigs;
    private long currentSize;
    private int evictions;
    private int hits;
    private final long initialMaxSize;
    private long maxSize;
    private int misses;
    private int puts;
    private final LruPoolStrategy strategy;
    private final BitmapTracker tracker;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface BitmapTracker {
        void add(Bitmap bitmap);

        void remove(Bitmap bitmap);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class NullBitmapTracker implements BitmapTracker {
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void add(Bitmap bitmap) {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void remove(Bitmap bitmap) {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class ThrowingBitmapTracker implements BitmapTracker {
        private final Set<Bitmap> bitmaps = Collections.synchronizedSet(new HashSet());

        private ThrowingBitmapTracker() {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void add(Bitmap bitmap) {
            if (!this.bitmaps.contains(bitmap)) {
                this.bitmaps.add(bitmap);
                return;
            }
            throw new IllegalStateException("Can't add already added bitmap: " + ((Object) bitmap) + " [" + bitmap.getWidth() + LanguageTag.PRIVATEUSE + bitmap.getHeight() + "]");
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void remove(Bitmap bitmap) {
            if (this.bitmaps.contains(bitmap)) {
                this.bitmaps.remove(bitmap);
                return;
            }
            throw new IllegalStateException("Cannot remove bitmap not in tracker");
        }
    }

    public LruBitmapPool(long j10, LruPoolStrategy lruPoolStrategy, Set<Bitmap.Config> set) {
        this.initialMaxSize = j10;
        this.maxSize = j10;
        this.strategy = lruPoolStrategy;
        this.allowedConfigs = set;
        this.tracker = new NullBitmapTracker();
    }

    private static void assertNotHardwareConfig(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + ((Object) config) + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    @NonNull
    private static Bitmap createBitmap(int i10, int i11, @Nullable Bitmap.Config config) {
        if (config == null) {
            config = DEFAULT_CONFIG;
        }
        return Bitmap.createBitmap(i10, i11, config);
    }

    private void dump() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            dumpUnchecked();
        }
    }

    private void dumpUnchecked() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Hits=");
        sb2.append(this.hits);
        sb2.append(", misses=");
        sb2.append(this.misses);
        sb2.append(", puts=");
        sb2.append(this.puts);
        sb2.append(", evictions=");
        sb2.append(this.evictions);
        sb2.append(", currentSize=");
        sb2.append(this.currentSize);
        sb2.append(", maxSize=");
        sb2.append(this.maxSize);
        sb2.append("\nStrategy=");
        sb2.append((Object) this.strategy);
    }

    private void evict() {
        trimToSize(this.maxSize);
    }

    private static Set<Bitmap.Config> getDefaultAllowedConfigs() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i10 = Build.VERSION.SDK_INT;
        hashSet.add(null);
        if (i10 >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static LruPoolStrategy getDefaultStrategy() {
        return new SizeConfigStrategy();
    }

    @Nullable
    private synchronized Bitmap getDirtyOrNull(int i10, int i11, @Nullable Bitmap.Config config) {
        Bitmap bitmap;
        assertNotHardwareConfig(config);
        bitmap = this.strategy.get(i10, i11, config != null ? config : DEFAULT_CONFIG);
        if (bitmap == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Missing bitmap=");
                sb2.append(this.strategy.logBitmap(i10, i11, config));
            }
            this.misses++;
        } else {
            this.hits++;
            this.currentSize -= this.strategy.getSize(bitmap);
            this.tracker.remove(bitmap);
            normalize(bitmap);
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Get bitmap=");
            sb3.append(this.strategy.logBitmap(i10, i11, config));
        }
        dump();
        return bitmap;
    }

    private static void maybeSetPreMultiplied(Bitmap bitmap) {
        bitmap.setPremultiplied(true);
    }

    private static void normalize(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        maybeSetPreMultiplied(bitmap);
    }

    private synchronized void trimToSize(long j10) {
        while (this.currentSize > j10) {
            Bitmap removeLast = this.strategy.removeLast();
            if (removeLast == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    dumpUnchecked();
                }
                this.currentSize = 0L;
                return;
            }
            this.tracker.remove(removeLast);
            this.currentSize -= this.strategy.getSize(removeLast);
            this.evictions++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Evicting bitmap=");
                sb2.append(this.strategy.logBitmap(removeLast));
            }
            dump();
            removeLast.recycle();
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void clearMemory() {
        Log.isLoggable("LruBitmapPool", 3);
        trimToSize(0L);
    }

    public long evictionCount() {
        return this.evictions;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    @NonNull
    public Bitmap get(int i10, int i11, Bitmap.Config config) {
        Bitmap dirtyOrNull = getDirtyOrNull(i10, i11, config);
        if (dirtyOrNull != null) {
            dirtyOrNull.eraseColor(0);
            return dirtyOrNull;
        }
        return createBitmap(i10, i11, config);
    }

    public long getCurrentSize() {
        return this.currentSize;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    @NonNull
    public Bitmap getDirty(int i10, int i11, Bitmap.Config config) {
        Bitmap dirtyOrNull = getDirtyOrNull(i10, i11, config);
        return dirtyOrNull == null ? createBitmap(i10, i11, config) : dirtyOrNull;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public long getMaxSize() {
        return this.maxSize;
    }

    public long hitCount() {
        return this.hits;
    }

    public long missCount() {
        return this.misses;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public synchronized void put(Bitmap bitmap) {
        try {
            if (bitmap != null) {
                if (!bitmap.isRecycled()) {
                    if (bitmap.isMutable() && this.strategy.getSize(bitmap) <= this.maxSize && this.allowedConfigs.contains(bitmap.getConfig())) {
                        int size = this.strategy.getSize(bitmap);
                        this.strategy.put(bitmap);
                        this.tracker.add(bitmap);
                        this.puts++;
                        this.currentSize += size;
                        if (Log.isLoggable("LruBitmapPool", 2)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Put bitmap in pool=");
                            sb2.append(this.strategy.logBitmap(bitmap));
                        }
                        dump();
                        evict();
                        return;
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Reject bitmap from pool, bitmap: ");
                        sb3.append(this.strategy.logBitmap(bitmap));
                        sb3.append(", is mutable: ");
                        sb3.append(bitmap.isMutable());
                        sb3.append(", is allowed config: ");
                        sb3.append(this.allowedConfigs.contains(bitmap.getConfig()));
                    }
                    bitmap.recycle();
                    return;
                }
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            throw new NullPointerException("Bitmap must not be null");
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public synchronized void setSizeMultiplier(float f10) {
        this.maxSize = Math.round(((float) this.initialMaxSize) * f10);
        evict();
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void trimMemory(int i10) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("trimMemory, level=");
            sb2.append(i10);
        }
        if (i10 >= 40 || (Build.VERSION.SDK_INT >= 23 && i10 >= 20)) {
            clearMemory();
        } else if (i10 >= 20 || i10 == 15) {
            trimToSize(getMaxSize() / 2);
        }
    }

    public LruBitmapPool(long j10) {
        this(j10, getDefaultStrategy(), getDefaultAllowedConfigs());
    }

    public LruBitmapPool(long j10, Set<Bitmap.Config> set) {
        this(j10, getDefaultStrategy(), set);
    }
}
