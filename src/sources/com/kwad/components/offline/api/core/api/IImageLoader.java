package com.kwad.components.offline.api.core.api;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface IImageLoader {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class DisplayImageOptionsCompat {
        private final int blurRadius;
        private final boolean cacheInMemory;
        private final boolean cacheOnDisk;
        private final boolean considerExifParams;
        private final int cornerRound;
        private final BitmapFactory.Options decodingOptions;
        private final int delayBeforeLoading;
        private final Drawable imageForEmptyUri;
        private final Drawable imageOnFail;
        private final Drawable imageOnLoading;
        private final int imageResForEmptyUri;
        private final int imageResOnFail;
        private final int imageResOnLoading;
        private final boolean isCircle;
        private final boolean isFrameSequence;
        private final boolean isSyncLoading;
        private final boolean resetViewBeforeLoading;
        private final Resources resources;
        private final int strokeColor;
        private final float strokeWidth;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
        public static class Builder {
            private int blurRadius;
            private int cornerRound;
            private boolean isCircle;
            private boolean isFrameSequence;
            private Resources resources;
            private int strokeColor;
            private float strokeWidth;
            private int imageResOnLoading = 0;
            private int imageResForEmptyUri = 0;
            private int imageResOnFail = 0;
            private Drawable imageOnLoading = null;
            private Drawable imageForEmptyUri = null;
            private Drawable imageOnFail = null;
            private boolean resetViewBeforeLoading = false;
            private boolean cacheInMemory = false;
            private boolean cacheOnDisk = false;
            private BitmapFactory.Options decodingOptions = new BitmapFactory.Options();
            private int delayBeforeLoading = 0;
            private boolean considerExifParams = false;
            private boolean isSyncLoading = false;

            public Builder bitmapConfig(Bitmap.Config config) {
                if (config != null) {
                    this.decodingOptions.inPreferredConfig = config;
                    return this;
                }
                throw new IllegalArgumentException("bitmapConfig can't be null");
            }

            public DisplayImageOptionsCompat build() {
                return new DisplayImageOptionsCompat(this);
            }

            @Deprecated
            public Builder cacheInMemory() {
                this.cacheInMemory = true;
                return this;
            }

            @Deprecated
            public Builder cacheOnDisc() {
                return cacheOnDisk(true);
            }

            public Builder cacheOnDisk(boolean z10) {
                this.cacheOnDisk = z10;
                return this;
            }

            public Builder cloneFrom(DisplayImageOptionsCompat displayImageOptionsCompat) {
                this.imageResOnLoading = displayImageOptionsCompat.imageResOnLoading;
                this.imageResForEmptyUri = displayImageOptionsCompat.imageResForEmptyUri;
                this.imageResOnFail = displayImageOptionsCompat.imageResOnFail;
                this.imageOnLoading = displayImageOptionsCompat.imageOnLoading;
                this.imageForEmptyUri = displayImageOptionsCompat.imageForEmptyUri;
                this.imageOnFail = displayImageOptionsCompat.imageOnFail;
                this.resetViewBeforeLoading = displayImageOptionsCompat.resetViewBeforeLoading;
                this.cacheInMemory = displayImageOptionsCompat.cacheInMemory;
                this.cacheOnDisk = displayImageOptionsCompat.cacheOnDisk;
                this.decodingOptions = displayImageOptionsCompat.decodingOptions;
                this.delayBeforeLoading = displayImageOptionsCompat.delayBeforeLoading;
                this.considerExifParams = displayImageOptionsCompat.considerExifParams;
                this.isSyncLoading = displayImageOptionsCompat.isSyncLoading;
                this.blurRadius = displayImageOptionsCompat.blurRadius;
                this.isFrameSequence = displayImageOptionsCompat.isFrameSequence;
                this.cornerRound = displayImageOptionsCompat.cornerRound;
                this.isCircle = displayImageOptionsCompat.isCircle;
                this.strokeColor = displayImageOptionsCompat.strokeColor;
                this.strokeWidth = displayImageOptionsCompat.strokeWidth;
                this.resources = displayImageOptionsCompat.resources;
                return this;
            }

            public Builder considerExifParams(boolean z10) {
                this.considerExifParams = z10;
                return this;
            }

            public Builder setBlurRadius(int i10) {
                this.blurRadius = i10;
                return this;
            }

            public Builder setCircle(boolean z10) {
                this.isCircle = z10;
                return this;
            }

            public Builder setCornerRound(int i10) {
                this.cornerRound = i10;
                return this;
            }

            public Builder setFrameSequence(boolean z10) {
                this.isFrameSequence = z10;
                return this;
            }

            public Builder setResources(Resources resources) {
                this.resources = resources;
                return this;
            }

            public Builder setStrokeColor(int i10) {
                this.strokeColor = i10;
                return this;
            }

            public Builder setStrokeWidth(float f10) {
                if (f10 > 0.0f) {
                    this.strokeWidth = f10;
                    this.isCircle = true;
                }
                return this;
            }

            public Builder showImageForEmptyUri(int i10) {
                this.imageResForEmptyUri = i10;
                return this;
            }

            public Builder showImageOnFail(int i10) {
                this.imageResOnFail = i10;
                return this;
            }

            public Builder showImageOnLoading(int i10) {
                this.imageResOnLoading = i10;
                return this;
            }

            @Deprecated
            public Builder showStubImage(int i10) {
                this.imageResOnLoading = i10;
                return this;
            }

            public Builder cacheInMemory(boolean z10) {
                this.cacheInMemory = z10;
                return this;
            }

            @Deprecated
            public Builder cacheOnDisc(boolean z10) {
                return cacheOnDisk(z10);
            }

            public Builder showImageForEmptyUri(Drawable drawable) {
                this.imageForEmptyUri = drawable;
                return this;
            }

            public Builder showImageOnFail(Drawable drawable) {
                this.imageOnFail = drawable;
                return this;
            }

            public Builder showImageOnLoading(Drawable drawable) {
                this.imageOnLoading = drawable;
                return this;
            }
        }

        public static DisplayImageOptionsCompat createSimple() {
            return new Builder().build();
        }

        public final int getBlurRadius() {
            return this.blurRadius;
        }

        public final int getCornerRound() {
            return this.cornerRound;
        }

        public final BitmapFactory.Options getDecodingOptions() {
            return this.decodingOptions;
        }

        public final int getDelayBeforeLoading() {
            return this.delayBeforeLoading;
        }

        public final Drawable getImageForEmptyUri() {
            int i10 = this.imageResForEmptyUri;
            return i10 != 0 ? this.resources.getDrawable(i10) : this.imageForEmptyUri;
        }

        public final Drawable getImageOnFail() {
            int i10 = this.imageResOnFail;
            return i10 != 0 ? this.resources.getDrawable(i10) : this.imageOnFail;
        }

        public final Drawable getImageOnLoading() {
            int i10 = this.imageResOnLoading;
            return i10 != 0 ? this.resources.getDrawable(i10) : this.imageOnLoading;
        }

        public final int getStrokeColor() {
            return this.strokeColor;
        }

        public final float getStrokeWidth() {
            return this.strokeWidth;
        }

        public final boolean isCacheInMemory() {
            return this.cacheInMemory;
        }

        public final boolean isCacheOnDisk() {
            return this.cacheOnDisk;
        }

        public final boolean isCircle() {
            return this.isCircle;
        }

        public final boolean isConsiderExifParams() {
            return this.considerExifParams;
        }

        public final boolean isFrameSequence() {
            return this.isFrameSequence;
        }

        public final boolean isResetViewBeforeLoading() {
            return this.resetViewBeforeLoading;
        }

        public final boolean shouldDelayBeforeLoading() {
            return this.delayBeforeLoading > 0;
        }

        public final boolean shouldShowImageForEmptyUri() {
            return (this.imageForEmptyUri == null && this.imageResForEmptyUri == 0) ? false : true;
        }

        public final boolean shouldShowImageOnFail() {
            return (this.imageOnFail == null && this.imageResOnFail == 0) ? false : true;
        }

        public final boolean shouldShowImageOnLoading() {
            return (this.imageOnLoading == null && this.imageResOnLoading == 0) ? false : true;
        }

        private DisplayImageOptionsCompat(Builder builder) {
            this.imageResOnLoading = builder.imageResOnLoading;
            this.imageResForEmptyUri = builder.imageResForEmptyUri;
            this.imageResOnFail = builder.imageResOnFail;
            this.imageOnLoading = builder.imageOnLoading;
            this.imageForEmptyUri = builder.imageForEmptyUri;
            this.imageOnFail = builder.imageOnFail;
            this.resetViewBeforeLoading = builder.resetViewBeforeLoading;
            this.cacheInMemory = builder.cacheInMemory;
            this.cacheOnDisk = builder.cacheOnDisk;
            this.decodingOptions = builder.decodingOptions;
            this.delayBeforeLoading = builder.delayBeforeLoading;
            this.considerExifParams = builder.considerExifParams;
            this.isSyncLoading = builder.isSyncLoading;
            this.blurRadius = builder.blurRadius;
            this.isFrameSequence = builder.isFrameSequence;
            this.cornerRound = builder.cornerRound;
            this.isCircle = builder.isCircle;
            this.strokeColor = builder.strokeColor;
            this.strokeWidth = builder.strokeWidth;
            this.resources = builder.resources;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface ImageLoadingListener {
        boolean onDecode(String str, InputStream inputStream, Bitmap bitmap);

        void onLoadingCancelled(String str, View view);

        void onLoadingComplete(String str, View view, Bitmap bitmap);

        void onLoadingFailed(String str, View view, String str2, Throwable th);

        void onLoadingStarted(String str, View view);
    }

    void loadImage(ImageView imageView, @Nullable String str);

    void loadImage(ImageView imageView, @Nullable String str, DisplayImageOptionsCompat displayImageOptionsCompat);

    void loadImage(ImageView imageView, @Nullable String str, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener);

    void loadImage(ImageView imageView, @Nullable String str, ImageLoadingListener imageLoadingListener);

    void loadImage(@Nullable String str, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener);
}
