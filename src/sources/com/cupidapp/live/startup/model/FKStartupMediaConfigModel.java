package com.cupidapp.live.startup.model;

import java.io.File;
import java.io.Serializable;
import java.util.Locale;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: StartupModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKStartupMediaConfigModel implements Serializable {

    @NotNull
    private final FKStartupMediaBaseInfoModel advertisementBaseInfo;
    private final int clickHotArea;
    private final boolean isDisplayHotButton;

    @Nullable
    private FKAdType mAdType;
    private int reqCount;

    @Nullable
    private String resourcePath;
    private final boolean vipButtonEnabled;

    public FKStartupMediaConfigModel(@NotNull FKStartupMediaBaseInfoModel advertisementBaseInfo, int i10, boolean z10, boolean z11, int i11) {
        s.i(advertisementBaseInfo, "advertisementBaseInfo");
        this.advertisementBaseInfo = advertisementBaseInfo;
        this.clickHotArea = i10;
        this.isDisplayHotButton = z10;
        this.vipButtonEnabled = z11;
        this.reqCount = i11;
    }

    public static /* synthetic */ FKStartupMediaConfigModel copy$default(FKStartupMediaConfigModel fKStartupMediaConfigModel, FKStartupMediaBaseInfoModel fKStartupMediaBaseInfoModel, int i10, boolean z10, boolean z11, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            fKStartupMediaBaseInfoModel = fKStartupMediaConfigModel.advertisementBaseInfo;
        }
        if ((i12 & 2) != 0) {
            i10 = fKStartupMediaConfigModel.clickHotArea;
        }
        int i13 = i10;
        if ((i12 & 4) != 0) {
            z10 = fKStartupMediaConfigModel.isDisplayHotButton;
        }
        boolean z12 = z10;
        if ((i12 & 8) != 0) {
            z11 = fKStartupMediaConfigModel.vipButtonEnabled;
        }
        boolean z13 = z11;
        if ((i12 & 16) != 0) {
            i11 = fKStartupMediaConfigModel.reqCount;
        }
        return fKStartupMediaConfigModel.copy(fKStartupMediaBaseInfoModel, i13, z12, z13, i11);
    }

    public final boolean canShow() {
        String str = this.resourcePath;
        if (str == null || str.length() == 0) {
            return false;
        }
        String str2 = this.resourcePath;
        s.f(str2);
        return new File(str2).exists();
    }

    @NotNull
    public final FKStartupMediaBaseInfoModel component1() {
        return this.advertisementBaseInfo;
    }

    public final int component2() {
        return this.clickHotArea;
    }

    public final boolean component3() {
        return this.isDisplayHotButton;
    }

    public final boolean component4() {
        return this.vipButtonEnabled;
    }

    public final int component5() {
        return this.reqCount;
    }

    @NotNull
    public final FKStartupMediaConfigModel copy(@NotNull FKStartupMediaBaseInfoModel advertisementBaseInfo, int i10, boolean z10, boolean z11, int i11) {
        s.i(advertisementBaseInfo, "advertisementBaseInfo");
        return new FKStartupMediaConfigModel(advertisementBaseInfo, i10, z10, z11, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKStartupMediaConfigModel)) {
            return false;
        }
        FKStartupMediaConfigModel fKStartupMediaConfigModel = (FKStartupMediaConfigModel) obj;
        return s.d(this.advertisementBaseInfo, fKStartupMediaConfigModel.advertisementBaseInfo) && this.clickHotArea == fKStartupMediaConfigModel.clickHotArea && this.isDisplayHotButton == fKStartupMediaConfigModel.isDisplayHotButton && this.vipButtonEnabled == fKStartupMediaConfigModel.vipButtonEnabled && this.reqCount == fKStartupMediaConfigModel.reqCount;
    }

    @NotNull
    public final FKAdType getAdType() {
        String thirdPartySource = this.advertisementBaseInfo.getThirdPartySource();
        if (thirdPartySource == null || thirdPartySource.length() == 0) {
            Integer materialType = this.advertisementBaseInfo.getMaterialType();
            int type = FKStartupMaterialType.Image.getType();
            if (materialType != null && materialType.intValue() == type) {
                return FKAdType.Image;
            }
            return (materialType != null && materialType.intValue() == FKStartupMaterialType.Video.getType()) ? FKAdType.Video : FKAdType.Unknow;
        }
        return FKAdType.Companion.a(this.advertisementBaseInfo.getThirdPartySource());
    }

    @NotNull
    public final FKStartupMediaBaseInfoModel getAdvertisementBaseInfo() {
        return this.advertisementBaseInfo;
    }

    public final int getClickHotArea() {
        return this.clickHotArea;
    }

    @NotNull
    public final EventTrackClickType getClickType() {
        int i10 = this.clickHotArea;
        if (i10 == FKClickArea.JumpButton.getArea()) {
            return EventTrackClickType.HOT_CLICK;
        }
        if (i10 == FKClickArea.Programmatic.getArea()) {
            return EventTrackClickType.PROGRAM_DEFAULT;
        }
        if (i10 == FKClickArea.FullScreen.getArea()) {
            if (this.isDisplayHotButton) {
                return EventTrackClickType.SEMI_COMPLIANT_HOT;
            }
            return EventTrackClickType.FULL_CLICK;
        }
        return EventTrackClickType.UNKNOWN;
    }

    @Nullable
    public final FKAdType getMAdType() {
        if (this.mAdType == null) {
            this.mAdType = getAdType();
        }
        return this.mAdType;
    }

    public final int getReqCount() {
        return this.reqCount;
    }

    @NotNull
    public final EventTrackRequestType getRequestType() {
        if (s.d(this.advertisementBaseInfo.getBidding(), Boolean.TRUE)) {
            return EventTrackRequestType.BIDDING;
        }
        return EventTrackRequestType.WATER_FALL;
    }

    @Nullable
    public final String getResourcePath() {
        return this.resourcePath;
    }

    @NotNull
    public final String getSensorAdType() {
        FKAdType fKAdType;
        String thirdPartySource = this.advertisementBaseInfo.getThirdPartySource();
        if (thirdPartySource == null || thirdPartySource.length() == 0) {
            Integer materialType = this.advertisementBaseInfo.getMaterialType();
            int type = FKStartupMaterialType.Image.getType();
            if (materialType != null && materialType.intValue() == type) {
                fKAdType = FKAdType.Image;
            } else {
                fKAdType = (materialType != null && materialType.intValue() == FKStartupMaterialType.Video.getType()) ? FKAdType.Video : FKAdType.Unknow;
            }
            return fKAdType.getType();
        }
        FKAdType a10 = FKAdType.Companion.a(this.advertisementBaseInfo.getThirdPartySource());
        if (a10 != FKAdType.APIAD && a10 != FKAdType.Unknow) {
            return a10.getType();
        }
        String thirdPartySource2 = this.advertisementBaseInfo.getThirdPartySource();
        Locale ENGLISH = Locale.ENGLISH;
        s.h(ENGLISH, "ENGLISH");
        String upperCase = thirdPartySource2.toUpperCase(ENGLISH);
        s.h(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }

    public final boolean getVipButtonEnabled() {
        return this.vipButtonEnabled;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.advertisementBaseInfo.hashCode() * 31) + this.clickHotArea) * 31;
        boolean z10 = this.isDisplayHotButton;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode + i10) * 31;
        boolean z11 = this.vipButtonEnabled;
        return ((i11 + (z11 ? 1 : z11 ? 1 : 0)) * 31) + this.reqCount;
    }

    public final boolean isCompliance() {
        return this.clickHotArea == FKClickArea.JumpButton.getArea();
    }

    public final boolean isDisplayHotButton() {
        return this.isDisplayHotButton;
    }

    public final boolean isSelfOperatedAdvertising() {
        return this.advertisementBaseInfo.getType() == FKStartupType.DirectCustomerAdvertising.getType() || this.advertisementBaseInfo.getType() == FKStartupType.OperatingAdvertising.getType();
    }

    public final boolean isThirdAdvertising() {
        return this.advertisementBaseInfo.getType() == FKStartupType.ProgrammaticAdvertising.getType();
    }

    public final void setMAdType(@Nullable FKAdType fKAdType) {
        this.mAdType = fKAdType;
    }

    public final void setReqCount(int i10) {
        this.reqCount = i10;
    }

    public final void setResourcePath(@Nullable String str) {
        this.resourcePath = str;
    }

    public final boolean showJumpButton() {
        return this.isDisplayHotButton && !s.d(this.advertisementBaseInfo.getThirdPartySource(), FKAdType.JD.getSource());
    }

    @NotNull
    public String toString() {
        FKStartupMediaBaseInfoModel fKStartupMediaBaseInfoModel = this.advertisementBaseInfo;
        return "FKStartupMediaConfigModel(advertisementBaseInfo=" + ((Object) fKStartupMediaBaseInfoModel) + ", clickHotArea=" + this.clickHotArea + ", isDisplayHotButton=" + this.isDisplayHotButton + ", vipButtonEnabled=" + this.vipButtonEnabled + ", reqCount=" + this.reqCount + ")";
    }

    public /* synthetic */ FKStartupMediaConfigModel(FKStartupMediaBaseInfoModel fKStartupMediaBaseInfoModel, int i10, boolean z10, boolean z11, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(fKStartupMediaBaseInfoModel, i10, z10, z11, (i12 & 16) != 0 ? 0 : i11);
    }
}
