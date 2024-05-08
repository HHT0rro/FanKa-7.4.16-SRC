package com.alimm.tanx.ui.image.glide.load.engine.cache;

import android.app.ActivityManager;
import android.content.Context;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import nd.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class MemorySizeCalculator {
    public static final int BITMAP_POOL_TARGET_SCREENS = 4;
    public static final int BYTES_PER_ARGB_8888_PIXEL = 4;
    public static final float LOW_MEMORY_MAX_SIZE_MULTIPLIER = 0.33f;
    public static final float MAX_SIZE_MULTIPLIER = 0.4f;
    public static final int MEMORY_CACHE_TARGET_SCREENS = 2;
    public static final String TAG = "MemorySizeCalculator";
    public final int bitmapPoolSize;
    public final Context context;
    public final int memoryCacheSize;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class DisplayMetricsScreenDimensions implements ScreenDimensions {
        public final DisplayMetrics displayMetrics;

        public DisplayMetricsScreenDimensions(DisplayMetrics displayMetrics) {
            this.displayMetrics = displayMetrics;
        }

        @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.MemorySizeCalculator.ScreenDimensions
        public int getHeightPixels() {
            return this.displayMetrics.heightPixels;
        }

        @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.MemorySizeCalculator.ScreenDimensions
        public int getWidthPixels() {
            return this.displayMetrics.widthPixels;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface ScreenDimensions {
        int getHeightPixels();

        int getWidthPixels();
    }

    public MemorySizeCalculator(Context context) {
        this(context, (ActivityManager) context.getSystemService("activity"), new DisplayMetricsScreenDimensions(context.getResources().getDisplayMetrics()));
    }

    public static int getMaxSize(ActivityManager activityManager) {
        return Math.round(activityManager.getMemoryClass() * 1024 * 1024 * (isLowMemoryDevice(activityManager) ? 0.33f : 0.4f));
    }

    public static boolean isLowMemoryDevice(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }

    private String toMb(int i10) {
        return Formatter.formatFileSize(this.context, i10);
    }

    public int getBitmapPoolSize() {
        return this.bitmapPoolSize;
    }

    public int getMemoryCacheSize() {
        return this.memoryCacheSize;
    }

    public MemorySizeCalculator(Context context, ActivityManager activityManager, ScreenDimensions screenDimensions) {
        this.context = context;
        int maxSize = getMaxSize(activityManager);
        int widthPixels = screenDimensions.getWidthPixels() * screenDimensions.getHeightPixels() * 4;
        int i10 = widthPixels * 4;
        int i11 = widthPixels * 2;
        int i12 = i11 + i10;
        if (i12 <= maxSize) {
            this.memoryCacheSize = i11;
            this.bitmapPoolSize = i10;
        } else {
            int round = Math.round(maxSize / 6.0f);
            this.memoryCacheSize = round * 2;
            this.bitmapPoolSize = round * 4;
        }
        if (Log.isLoggable(TAG, 3)) {
            StringBuilder a10 = a.a("Calculated memory cache size: ");
            a10.append(toMb(this.memoryCacheSize));
            a10.append(" pool size: ");
            a10.append(toMb(this.bitmapPoolSize));
            a10.append(" memory class limited? ");
            a10.append(i12 > maxSize);
            a10.append(" max size: ");
            a10.append(toMb(maxSize));
            a10.append(" memoryClass: ");
            a10.append(activityManager.getMemoryClass());
            a10.append(" isLowMemoryDevice: ");
            a10.append(isLowMemoryDevice(activityManager));
        }
    }
}
