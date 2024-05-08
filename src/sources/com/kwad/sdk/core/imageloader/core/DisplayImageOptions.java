package com.kwad.sdk.core.imageloader.core;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.kwad.sdk.core.imageloader.core.assist.ImageScaleType;
import com.kwad.sdk.core.imageloader.core.display.BitmapDisplayer;
import com.kwad.sdk.core.imageloader.core.process.BitmapProcessor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class DisplayImageOptions {
    private final boolean cacheInMemory;
    private final boolean cacheOnDisk;
    private final boolean considerExifParams;
    private final BitmapFactory.Options decodingOptions;
    private final int delayBeforeLoading;
    private final BitmapDisplayer displayer;
    private final Object extraForDownloader;
    private final Handler handler;
    private final Drawable imageForEmptyUri;
    private final Drawable imageOnFail;
    private final Drawable imageOnLoading;
    private final int imageResForEmptyUri;
    private final int imageResOnFail;
    private final int imageResOnLoading;
    private final ImageScaleType imageScaleType;
    private final boolean isSyncLoading;
    private final BitmapProcessor postProcessor;
    private final BitmapProcessor preProcessor;
    private final boolean resetViewBeforeLoading;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class Builder {
        private int imageResOnLoading = 0;
        private int imageResForEmptyUri = 0;
        private int imageResOnFail = 0;
        private Drawable imageOnLoading = null;
        private Drawable imageForEmptyUri = null;
        private Drawable imageOnFail = null;
        private boolean resetViewBeforeLoading = false;
        private boolean cacheInMemory = false;
        private boolean cacheOnDisk = false;
        private ImageScaleType imageScaleType = ImageScaleType.IN_SAMPLE_POWER_OF_2;
        private BitmapFactory.Options decodingOptions = new BitmapFactory.Options();
        private int delayBeforeLoading = 0;
        private boolean considerExifParams = false;
        private Object extraForDownloader = null;
        private BitmapProcessor preProcessor = null;
        private BitmapProcessor postProcessor = null;
        private BitmapDisplayer displayer = DefaultConfigurationFactory.createBitmapDisplayer();
        private Handler handler = null;
        private boolean isSyncLoading = false;

        public Builder bitmapConfig(Bitmap.Config config) {
            if (config != null) {
                this.decodingOptions.inPreferredConfig = config;
                return this;
            }
            throw new IllegalArgumentException("bitmapConfig can't be null");
        }

        public DisplayImageOptions build() {
            return new DisplayImageOptions(this);
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

        public Builder cloneFrom(DisplayImageOptions displayImageOptions) {
            this.imageResOnLoading = displayImageOptions.imageResOnLoading;
            this.imageResForEmptyUri = displayImageOptions.imageResForEmptyUri;
            this.imageResOnFail = displayImageOptions.imageResOnFail;
            this.imageOnLoading = displayImageOptions.imageOnLoading;
            this.imageForEmptyUri = displayImageOptions.imageForEmptyUri;
            this.imageOnFail = displayImageOptions.imageOnFail;
            this.resetViewBeforeLoading = displayImageOptions.resetViewBeforeLoading;
            this.cacheInMemory = displayImageOptions.cacheInMemory;
            this.cacheOnDisk = displayImageOptions.cacheOnDisk;
            this.imageScaleType = displayImageOptions.imageScaleType;
            this.decodingOptions = displayImageOptions.decodingOptions;
            this.delayBeforeLoading = displayImageOptions.delayBeforeLoading;
            this.considerExifParams = displayImageOptions.considerExifParams;
            this.extraForDownloader = displayImageOptions.extraForDownloader;
            this.preProcessor = displayImageOptions.preProcessor;
            this.postProcessor = displayImageOptions.postProcessor;
            this.displayer = displayImageOptions.displayer;
            this.handler = displayImageOptions.handler;
            this.isSyncLoading = displayImageOptions.isSyncLoading;
            return this;
        }

        public Builder considerExifParams(boolean z10) {
            this.considerExifParams = z10;
            return this;
        }

        public Builder decodingOptions(BitmapFactory.Options options) {
            if (options != null) {
                this.decodingOptions = options;
                return this;
            }
            throw new IllegalArgumentException("decodingOptions can't be null");
        }

        public Builder delayBeforeLoading(int i10) {
            this.delayBeforeLoading = i10;
            return this;
        }

        public Builder displayer(BitmapDisplayer bitmapDisplayer) {
            if (bitmapDisplayer != null) {
                this.displayer = bitmapDisplayer;
                return this;
            }
            throw new IllegalArgumentException("displayer can't be null");
        }

        public Builder extraForDownloader(Object obj) {
            this.extraForDownloader = obj;
            return this;
        }

        public Builder handler(Handler handler) {
            this.handler = handler;
            return this;
        }

        public Builder imageScaleType(ImageScaleType imageScaleType) {
            this.imageScaleType = imageScaleType;
            return this;
        }

        public Builder postProcessor(BitmapProcessor bitmapProcessor) {
            this.postProcessor = bitmapProcessor;
            return this;
        }

        public Builder preProcessor(BitmapProcessor bitmapProcessor) {
            this.preProcessor = bitmapProcessor;
            return this;
        }

        public Builder resetViewBeforeLoading() {
            this.resetViewBeforeLoading = true;
            return this;
        }

        public Builder setBlurRadius(int i10) {
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

        public Builder syncLoading(boolean z10) {
            this.isSyncLoading = z10;
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

        public Builder resetViewBeforeLoading(boolean z10) {
            this.resetViewBeforeLoading = z10;
            return this;
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

    public static DisplayImageOptions createSimple() {
        return new Builder().build();
    }

    public final BitmapFactory.Options getDecodingOptions() {
        return this.decodingOptions;
    }

    public final int getDelayBeforeLoading() {
        return this.delayBeforeLoading;
    }

    public final BitmapDisplayer getDisplayer() {
        return this.displayer;
    }

    public final Object getExtraForDownloader() {
        return this.extraForDownloader;
    }

    public final Handler getHandler() {
        return this.handler;
    }

    public final Drawable getImageForEmptyUri(Resources resources) {
        int i10 = this.imageResForEmptyUri;
        return i10 != 0 ? resources.getDrawable(i10) : this.imageForEmptyUri;
    }

    public final Drawable getImageOnFail(Resources resources) {
        int i10 = this.imageResOnFail;
        return i10 != 0 ? resources.getDrawable(i10) : this.imageOnFail;
    }

    public final Drawable getImageOnLoading(Resources resources) {
        int i10 = this.imageResOnLoading;
        return i10 != 0 ? resources.getDrawable(i10) : this.imageOnLoading;
    }

    public final ImageScaleType getImageScaleType() {
        return this.imageScaleType;
    }

    public final BitmapProcessor getPostProcessor() {
        return this.postProcessor;
    }

    public final BitmapProcessor getPreProcessor() {
        return this.preProcessor;
    }

    public final boolean isCacheInMemory() {
        return this.cacheInMemory;
    }

    public final boolean isCacheOnDisk() {
        return this.cacheOnDisk;
    }

    public final boolean isConsiderExifParams() {
        return this.considerExifParams;
    }

    public final boolean isResetViewBeforeLoading() {
        return this.resetViewBeforeLoading;
    }

    public final boolean isSyncLoading() {
        return this.isSyncLoading;
    }

    public final boolean shouldDelayBeforeLoading() {
        return this.delayBeforeLoading > 0;
    }

    public final boolean shouldPostProcess() {
        return this.postProcessor != null;
    }

    public final boolean shouldPreProcess() {
        return this.preProcessor != null;
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

    private DisplayImageOptions(Builder builder) {
        this.imageResOnLoading = builder.imageResOnLoading;
        this.imageResForEmptyUri = builder.imageResForEmptyUri;
        this.imageResOnFail = builder.imageResOnFail;
        this.imageOnLoading = builder.imageOnLoading;
        this.imageForEmptyUri = builder.imageForEmptyUri;
        this.imageOnFail = builder.imageOnFail;
        this.resetViewBeforeLoading = builder.resetViewBeforeLoading;
        this.cacheInMemory = builder.cacheInMemory;
        this.cacheOnDisk = builder.cacheOnDisk;
        this.imageScaleType = builder.imageScaleType;
        this.decodingOptions = builder.decodingOptions;
        this.delayBeforeLoading = builder.delayBeforeLoading;
        this.considerExifParams = builder.considerExifParams;
        this.extraForDownloader = builder.extraForDownloader;
        this.preProcessor = builder.preProcessor;
        this.postProcessor = builder.postProcessor;
        this.displayer = builder.displayer;
        this.handler = builder.handler;
        this.isSyncLoading = builder.isSyncLoading;
    }
}
