package com.huawei.hms.ads;

import android.content.Context;
import com.android.internal.logging.nano.MetricsProto;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.openalliance.ad.utils.c;
import sun.util.locale.LanguageTag;

@GlobalApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class BannerAdSize extends AdSize {

    @GlobalApi
    public static final BannerAdSize BANNER_SIZE_360_57 = new BannerAdSize(360, 57);

    @GlobalApi
    public static final BannerAdSize BANNER_SIZE_360_144 = new BannerAdSize(360, 144);

    @GlobalApi
    public static final BannerAdSize BANNER_SIZE_320_50 = new BannerAdSize(320, 50);

    @GlobalApi
    public static final BannerAdSize BANNER_SIZE_DYNAMIC = new BannerAdSize(-3, -4);

    @GlobalApi
    public static final BannerAdSize BANNER_SIZE_468_60 = new BannerAdSize(MetricsProto.MetricsEvent.ACTION_DELETION_HELPER_CANCEL, 60);

    @GlobalApi
    public static final BannerAdSize BANNER_SIZE_INVALID = new BannerAdSize(0, 0);

    @GlobalApi
    public static final BannerAdSize BANNER_SIZE_320_100 = new BannerAdSize(320, 100);

    @GlobalApi
    public static final BannerAdSize BANNER_SIZE_728_90 = new BannerAdSize(MetricsProto.MetricsEvent.ACTION_PERMISSION_DENIED_READ_EXTERNAL_STORAGE, 90);

    @GlobalApi
    public static final BannerAdSize BANNER_SIZE_300_250 = new BannerAdSize(300, 250);

    @GlobalApi
    public static final BannerAdSize BANNER_SIZE_SMART = new BannerAdSize(-1, -2);

    @GlobalApi
    public static final BannerAdSize BANNER_SIZE_160_600 = new BannerAdSize(160, 600);

    @GlobalApi
    public static final BannerAdSize BANNER_SIZE_ADVANCED = new BannerAdSize(-1, -5, 1);

    @GlobalApi
    public BannerAdSize(int i10, int i11) {
        super(i10, i11);
    }

    private BannerAdSize(int i10, int i11, int i12) {
        super(i10, i11);
        this.F = i12;
    }

    private static BannerAdSize Code(Context context, int i10, int i11) {
        int Z = c.Z(context, i11);
        return Z == 0 ? BANNER_SIZE_INVALID : new BannerAdSize(i10, c.Code(i10, Z), 1);
    }

    private boolean Code() {
        return this.C == -1 && this.S == -2;
    }

    private boolean V() {
        return this.C == 0 && this.S == 0;
    }

    @GlobalApi
    public static BannerAdSize getCurrentDirectionBannerSize(Context context, int i10) {
        return Code(context, i10, 0);
    }

    @GlobalApi
    public static BannerAdSize getLandscapeBannerSize(Context context, int i10) {
        return Code(context, i10, 2);
    }

    @GlobalApi
    public static BannerAdSize getPortraitBannerSize(Context context, int i10) {
        return Code(context, i10, 1);
    }

    @Override // com.huawei.hms.ads.AdSize
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.huawei.hms.ads.AdSize
    @GlobalApi
    public final int getHeight() {
        return super.getHeight();
    }

    @Override // com.huawei.hms.ads.AdSize
    @GlobalApi
    public final int getHeightPx(Context context) {
        return super.getHeightPx(context);
    }

    @Override // com.huawei.hms.ads.AdSize
    @GlobalApi
    public final int getWidth() {
        return super.getWidth();
    }

    @Override // com.huawei.hms.ads.AdSize
    @GlobalApi
    public final int getWidthPx(Context context) {
        return super.getWidthPx(context);
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    @GlobalApi
    public final boolean isAutoHeightSize() {
        return this.S == -2;
    }

    @GlobalApi
    public final boolean isDynamicSize() {
        return this.C == -3 && this.S == -4;
    }

    @GlobalApi
    public final boolean isFullWidthSize() {
        return this.C == -1;
    }

    public final String toString() {
        if (isDynamicSize()) {
            return "fluid";
        }
        if (Code()) {
            return "smart_banner";
        }
        if (V()) {
            return "invalid";
        }
        return (isFullWidthSize() ? "FULL_WIDTH" : String.valueOf(this.C)) + LanguageTag.PRIVATEUSE + (isAutoHeightSize() ? "AUTO_HEIGHT" : String.valueOf(this.S));
    }
}
