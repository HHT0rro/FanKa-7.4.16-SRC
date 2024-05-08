package com.huawei.hms.ads.nativead;

import com.huawei.hms.ads.AdSize;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.s;
import com.huawei.hms.ads.u;

@AllApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class NativeAdConfiguration {
    public s Code;

    @AllApi
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class Builder {
        public s Code = new u();

        @AllApi
        public final NativeAdConfiguration build() {
            return new NativeAdConfiguration(this);
        }

        @GlobalApi
        public final Builder setAdSize(AdSize adSize) {
            this.Code.Code(adSize);
            return this;
        }

        @GlobalApi
        public final Builder setAdType(int i10) {
            this.Code.Z(i10);
            return this;
        }

        @GlobalApi
        public final Builder setChoicesPosition(int i10) {
            this.Code.I(i10);
            return this;
        }

        @GlobalApi
        public final Builder setMediaAspect(int i10) {
            this.Code.V(i10);
            return this;
        }

        @GlobalApi
        public final Builder setMediaDirection(int i10) {
            this.Code.Code(i10);
            return this;
        }

        @GlobalApi
        public final Builder setRequestCustomDislikeThisAd(boolean z10) {
            this.Code.I(z10);
            return this;
        }

        @AllApi
        public final Builder setRequestMultiImages(boolean z10) {
            this.Code.V(z10);
            return this;
        }

        @AllApi
        public final Builder setReturnUrlsForImages(boolean z10) {
            this.Code.Code(z10);
            return this;
        }

        @GlobalApi
        public final Builder setVideoConfiguration(VideoConfiguration videoConfiguration) {
            this.Code.Code(videoConfiguration);
            return this;
        }
    }

    @AllApi
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface ChoicesPosition {
        public static final int BOTTOM_LEFT = 3;
        public static final int BOTTOM_RIGHT = 2;
        public static final int INVISIBLE = 4;
        public static final int TOP_LEFT = 0;
        public static final int TOP_RIGHT = 1;
    }

    @GlobalApi
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface Direction {
        public static final int ANY = 0;
        public static final int LANDSCAPE = 2;
        public static final int PORTRAIT = 1;
    }

    @GlobalApi
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface MediaAspect {
        public static final int ASPECT_ANY = 1;
        public static final int ASPECT_CUSTOM_SIZE = -1;
        public static final int ASPECT_LANDSCAPE = 2;
        public static final int ASPECT_PORTRAIT = 3;
        public static final int ASPECT_SQUARE = 4;
        public static final int ASPECT_UNKNOWN = 0;
    }

    private NativeAdConfiguration(Builder builder) {
        this.Code = builder.Code;
    }

    public final boolean Code() {
        return this.Code.S();
    }

    public Integer V() {
        return this.Code.F();
    }

    @GlobalApi
    public final AdSize getAdSize() {
        return this.Code.D();
    }

    @GlobalApi
    public final int getAdType() {
        return this.Code.L();
    }

    @GlobalApi
    public final int getChoicesPosition() {
        return this.Code.B();
    }

    @GlobalApi
    public final int getMediaAspect() {
        return this.Code.I();
    }

    @GlobalApi
    public final int getMediaDirection() {
        return this.Code.V();
    }

    @GlobalApi
    public final VideoConfiguration getVideoConfiguration() {
        return this.Code.C();
    }

    @AllApi
    public final boolean isRequestMultiImages() {
        return this.Code.Z();
    }

    @AllApi
    public final boolean isReturnUrlsForImages() {
        return this.Code.Code();
    }
}
