package com.alimm.tanx.ui.image.glide.load.engine.prefill;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.alimm.tanx.ui.image.glide.load.Key;
import com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool;
import com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache;
import com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapResource;
import com.alimm.tanx.ui.image.glide.util.Util;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import nd.a;
import sun.util.locale.LanguageTag;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class BitmapPreFillRunner implements Runnable {
    public static final int BACKOFF_RATIO = 4;
    public static final long INITIAL_BACKOFF_MS = 40;
    public static final long MAX_DURATION_MS = 32;
    public static final String TAG = "PreFillRunner";
    public final BitmapPool bitmapPool;
    public final Clock clock;
    public long currentDelay;
    public final Handler handler;
    public boolean isCancelled;
    public final MemoryCache memoryCache;
    public final Set<PreFillType> seenTypes;
    public final PreFillQueue toPrefill;
    public static final Clock DEFAULT_CLOCK = new Clock();
    public static final long MAX_BACKOFF_MS = TimeUnit.SECONDS.toMillis(1);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Clock {
        public long now() {
            return SystemClock.currentThreadTimeMillis();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class UniqueKey implements Key {
        public UniqueKey() {
        }

        @Override // com.alimm.tanx.ui.image.glide.load.Key
        public void updateDiskCacheKey(MessageDigest messageDigest) throws UnsupportedEncodingException {
        }

        public /* synthetic */ UniqueKey(AnonymousClass1 anonymousClass1) {
        }
    }

    public BitmapPreFillRunner(BitmapPool bitmapPool, MemoryCache memoryCache, PreFillQueue preFillQueue) {
        this(bitmapPool, memoryCache, preFillQueue, DEFAULT_CLOCK, new Handler(Looper.getMainLooper()));
    }

    private void addToBitmapPool(PreFillType preFillType, Bitmap bitmap) {
        Bitmap bitmap2;
        if (this.seenTypes.add(preFillType) && (bitmap2 = this.bitmapPool.get(preFillType.getWidth(), preFillType.getHeight(), preFillType.getConfig())) != null) {
            this.bitmapPool.put(bitmap2);
        }
        this.bitmapPool.put(bitmap);
    }

    private boolean allocate() {
        long now = this.clock.now();
        while (!this.toPrefill.isEmpty() && !isGcDetected(now)) {
            PreFillType remove = this.toPrefill.remove();
            Bitmap createBitmap = Bitmap.createBitmap(remove.getWidth(), remove.getHeight(), remove.getConfig());
            if (getFreeMemoryCacheBytes() >= Util.getBitmapByteSize(createBitmap)) {
                this.memoryCache.put(new UniqueKey(null), BitmapResource.obtain(createBitmap, this.bitmapPool));
            } else {
                addToBitmapPool(remove, createBitmap);
            }
            if (Log.isLoggable("PreFillRunner", 3)) {
                StringBuilder a10 = a.a("allocated [");
                a10.append(remove.getWidth());
                a10.append(LanguageTag.PRIVATEUSE);
                a10.append(remove.getHeight());
                a10.append("] ");
                a10.append((Object) remove.getConfig());
                a10.append(" size: ");
                a10.append(Util.getBitmapByteSize(createBitmap));
            }
        }
        return (this.isCancelled || this.toPrefill.isEmpty()) ? false : true;
    }

    private int getFreeMemoryCacheBytes() {
        return this.memoryCache.getMaxSize() - this.memoryCache.getCurrentSize();
    }

    private long getNextDelay() {
        long j10 = this.currentDelay;
        this.currentDelay = Math.min(4 * j10, MAX_BACKOFF_MS);
        return j10;
    }

    private boolean isGcDetected(long j10) {
        return this.clock.now() - j10 >= 32;
    }

    public void cancel() {
        this.isCancelled = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (allocate()) {
            this.handler.postDelayed(this, getNextDelay());
        }
    }

    public BitmapPreFillRunner(BitmapPool bitmapPool, MemoryCache memoryCache, PreFillQueue preFillQueue, Clock clock, Handler handler) {
        this.seenTypes = new HashSet();
        this.currentDelay = 40L;
        this.bitmapPool = bitmapPool;
        this.memoryCache = memoryCache;
        this.toPrefill = preFillQueue;
        this.clock = clock;
        this.handler = handler;
    }
}
