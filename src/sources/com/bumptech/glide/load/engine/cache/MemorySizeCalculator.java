package com.bumptech.glide.load.engine.cache;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.Preconditions;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MemorySizeCalculator {

    @VisibleForTesting
    public static final int BYTES_PER_ARGB_8888_PIXEL = 4;
    private static final int LOW_MEMORY_BYTE_ARRAY_POOL_DIVISOR = 2;
    private static final String TAG = "MemorySizeCalculator";
    private final int arrayPoolSize;
    private final int bitmapPoolSize;
    private final Context context;
    private final int memoryCacheSize;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class Builder {
        public static final int ARRAY_POOL_SIZE_BYTES = 4194304;
        public static final int BITMAP_POOL_TARGET_SCREENS;
        public static final float LOW_MEMORY_MAX_SIZE_MULTIPLIER = 0.33f;
        public static final float MAX_SIZE_MULTIPLIER = 0.4f;

        @VisibleForTesting
        public static final int MEMORY_CACHE_TARGET_SCREENS = 2;
        public ActivityManager activityManager;
        public float bitmapPoolScreens;
        public final Context context;
        public ScreenDimensions screenDimensions;
        public float memoryCacheScreens = 2.0f;
        public float maxSizeMultiplier = 0.4f;
        public float lowMemoryMaxSizeMultiplier = 0.33f;
        public int arrayPoolSizeBytes = 4194304;

        static {
            BITMAP_POOL_TARGET_SCREENS = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public Builder(Context context) {
            this.bitmapPoolScreens = BITMAP_POOL_TARGET_SCREENS;
            this.context = context;
            this.activityManager = (ActivityManager) context.getSystemService("activity");
            this.screenDimensions = new DisplayMetricsScreenDimensions(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT < 26 || !MemorySizeCalculator.isLowMemoryDevice(this.activityManager)) {
                return;
            }
            this.bitmapPoolScreens = 0.0f;
        }

        public MemorySizeCalculator build() {
            return new MemorySizeCalculator(this);
        }

        @VisibleForTesting
        public Builder setActivityManager(ActivityManager activityManager) {
            this.activityManager = activityManager;
            return this;
        }

        public Builder setArrayPoolSize(int i10) {
            this.arrayPoolSizeBytes = i10;
            return this;
        }

        public Builder setBitmapPoolScreens(float f10) {
            Preconditions.checkArgument(f10 >= 0.0f, "Bitmap pool screens must be greater than or equal to 0");
            this.bitmapPoolScreens = f10;
            return this;
        }

        public Builder setLowMemoryMaxSizeMultiplier(float f10) {
            Preconditions.checkArgument(f10 >= 0.0f && f10 <= 1.0f, "Low memory max size multiplier must be between 0 and 1");
            this.lowMemoryMaxSizeMultiplier = f10;
            return this;
        }

        public Builder setMaxSizeMultiplier(float f10) {
            Preconditions.checkArgument(f10 >= 0.0f && f10 <= 1.0f, "Size multiplier must be between 0 and 1");
            this.maxSizeMultiplier = f10;
            return this;
        }

        public Builder setMemoryCacheScreens(float f10) {
            Preconditions.checkArgument(f10 >= 0.0f, "Memory cache screens must be greater than or equal to 0");
            this.memoryCacheScreens = f10;
            return this;
        }

        @VisibleForTesting
        public Builder setScreenDimensions(ScreenDimensions screenDimensions) {
            this.screenDimensions = screenDimensions;
            return this;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class DisplayMetricsScreenDimensions implements ScreenDimensions {
        private final DisplayMetrics displayMetrics;

        public DisplayMetricsScreenDimensions(DisplayMetrics displayMetrics) {
            this.displayMetrics = displayMetrics;
        }

        @Override // com.bumptech.glide.load.engine.cache.MemorySizeCalculator.ScreenDimensions
        public int getHeightPixels() {
            return this.displayMetrics.heightPixels;
        }

        @Override // com.bumptech.glide.load.engine.cache.MemorySizeCalculator.ScreenDimensions
        public int getWidthPixels() {
            return this.displayMetrics.widthPixels;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface ScreenDimensions {
        int getHeightPixels();

        int getWidthPixels();
    }

    public MemorySizeCalculator(Builder builder) {
        int i10;
        this.context = builder.context;
        if (isLowMemoryDevice(builder.activityManager)) {
            i10 = builder.arrayPoolSizeBytes / 2;
        } else {
            i10 = builder.arrayPoolSizeBytes;
        }
        this.arrayPoolSize = i10;
        int maxSize = getMaxSize(builder.activityManager, builder.maxSizeMultiplier, builder.lowMemoryMaxSizeMultiplier);
        float widthPixels = builder.screenDimensions.getWidthPixels() * builder.screenDimensions.getHeightPixels() * 4;
        int round = Math.round(builder.bitmapPoolScreens * widthPixels);
        int round2 = Math.round(widthPixels * builder.memoryCacheScreens);
        int i11 = maxSize - i10;
        int i12 = round2 + round;
        if (i12 <= i11) {
            this.memoryCacheSize = round2;
            this.bitmapPoolSize = round;
        } else {
            float f10 = i11;
            float f11 = builder.bitmapPoolScreens;
            float f12 = builder.memoryCacheScreens;
            float f13 = f10 / (f11 + f12);
            this.memoryCacheSize = Math.round(f12 * f13);
            this.bitmapPoolSize = Math.round(f13 * builder.bitmapPoolScreens);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Calculation complete, Calculated memory cache size: ");
            sb2.append(toMb(this.memoryCacheSize));
            sb2.append(", pool size: ");
            sb2.append(toMb(this.bitmapPoolSize));
            sb2.append(", byte array size: ");
            sb2.append(toMb(i10));
            sb2.append(", memory class limited? ");
            sb2.append(i12 > maxSize);
            sb2.append(", max size: ");
            sb2.append(toMb(maxSize));
            sb2.append(", memoryClass: ");
            sb2.append(builder.activityManager.getMemoryClass());
            sb2.append(", isLowMemoryDevice: ");
            sb2.append(isLowMemoryDevice(builder.activityManager));
        }
    }

    private static int getMaxSize(ActivityManager activityManager, float f10, float f11) {
        float memoryClass = activityManager.getMemoryClass() * 1024 * 1024;
        if (isLowMemoryDevice(activityManager)) {
            f10 = f11;
        }
        return Math.round(memoryClass * f10);
    }

    public static boolean isLowMemoryDevice(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }

    private String toMb(int i10) {
        return Formatter.formatFileSize(this.context, i10);
    }

    public int getArrayPoolSizeInBytes() {
        return this.arrayPoolSize;
    }

    public int getBitmapPoolSize() {
        return this.bitmapPoolSize;
    }

    public int getMemoryCacheSize() {
        return this.memoryCacheSize;
    }
}
