package com.cupidapp.live.startup.model;

import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.VideoModel;
import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: StartupModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKStartupMediaBaseInfoModel implements Serializable {

    @Nullable
    private final String adAppId;

    @Nullable
    private final String adAppKey;

    @NotNull
    private final String adId;

    @Nullable
    private final Integer adPrice;

    @Nullable
    private final Integer adTimeout;

    @Nullable
    private final Boolean bidding;
    private final boolean byApi;

    @Nullable
    private final List<String> clickMonitorLink;

    @Nullable
    private final Integer displayTime;

    @Nullable
    private final List<String> exposureMonitorLink;

    @Nullable
    private final ImageModel imageStartup;

    @Nullable
    private final String jumpLink;

    @Nullable
    private final Integer materialType;

    @Nullable
    private final String thirdPartyId;

    @Nullable
    private final String thirdPartySource;
    private final int type;

    @Nullable
    private final VideoModel video;

    public FKStartupMediaBaseInfoModel(@NotNull String adId, int i10, @Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable ImageModel imageModel, @Nullable VideoModel videoModel, @Nullable String str3, @Nullable List<String> list, @Nullable List<String> list2, @Nullable Integer num2, @Nullable String str4, @Nullable String str5, boolean z10, @Nullable Integer num3, @Nullable Boolean bool, @Nullable Integer num4) {
        s.i(adId, "adId");
        this.adId = adId;
        this.type = i10;
        this.thirdPartySource = str;
        this.thirdPartyId = str2;
        this.materialType = num;
        this.imageStartup = imageModel;
        this.video = videoModel;
        this.jumpLink = str3;
        this.exposureMonitorLink = list;
        this.clickMonitorLink = list2;
        this.displayTime = num2;
        this.adAppId = str4;
        this.adAppKey = str5;
        this.byApi = z10;
        this.adPrice = num3;
        this.bidding = bool;
        this.adTimeout = num4;
    }

    private final Integer component15() {
        return this.adPrice;
    }

    @NotNull
    public final String component1() {
        return this.adId;
    }

    @Nullable
    public final List<String> component10() {
        return this.clickMonitorLink;
    }

    @Nullable
    public final Integer component11() {
        return this.displayTime;
    }

    @Nullable
    public final String component12() {
        return this.adAppId;
    }

    @Nullable
    public final String component13() {
        return this.adAppKey;
    }

    public final boolean component14() {
        return this.byApi;
    }

    @Nullable
    public final Boolean component16() {
        return this.bidding;
    }

    @Nullable
    public final Integer component17() {
        return this.adTimeout;
    }

    public final int component2() {
        return this.type;
    }

    @Nullable
    public final String component3() {
        return this.thirdPartySource;
    }

    @Nullable
    public final String component4() {
        return this.thirdPartyId;
    }

    @Nullable
    public final Integer component5() {
        return this.materialType;
    }

    @Nullable
    public final ImageModel component6() {
        return this.imageStartup;
    }

    @Nullable
    public final VideoModel component7() {
        return this.video;
    }

    @Nullable
    public final String component8() {
        return this.jumpLink;
    }

    @Nullable
    public final List<String> component9() {
        return this.exposureMonitorLink;
    }

    @NotNull
    public final FKStartupMediaBaseInfoModel copy(@NotNull String adId, int i10, @Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable ImageModel imageModel, @Nullable VideoModel videoModel, @Nullable String str3, @Nullable List<String> list, @Nullable List<String> list2, @Nullable Integer num2, @Nullable String str4, @Nullable String str5, boolean z10, @Nullable Integer num3, @Nullable Boolean bool, @Nullable Integer num4) {
        s.i(adId, "adId");
        return new FKStartupMediaBaseInfoModel(adId, i10, str, str2, num, imageModel, videoModel, str3, list, list2, num2, str4, str5, z10, num3, bool, num4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKStartupMediaBaseInfoModel)) {
            return false;
        }
        FKStartupMediaBaseInfoModel fKStartupMediaBaseInfoModel = (FKStartupMediaBaseInfoModel) obj;
        return s.d(this.adId, fKStartupMediaBaseInfoModel.adId) && this.type == fKStartupMediaBaseInfoModel.type && s.d(this.thirdPartySource, fKStartupMediaBaseInfoModel.thirdPartySource) && s.d(this.thirdPartyId, fKStartupMediaBaseInfoModel.thirdPartyId) && s.d(this.materialType, fKStartupMediaBaseInfoModel.materialType) && s.d(this.imageStartup, fKStartupMediaBaseInfoModel.imageStartup) && s.d(this.video, fKStartupMediaBaseInfoModel.video) && s.d(this.jumpLink, fKStartupMediaBaseInfoModel.jumpLink) && s.d(this.exposureMonitorLink, fKStartupMediaBaseInfoModel.exposureMonitorLink) && s.d(this.clickMonitorLink, fKStartupMediaBaseInfoModel.clickMonitorLink) && s.d(this.displayTime, fKStartupMediaBaseInfoModel.displayTime) && s.d(this.adAppId, fKStartupMediaBaseInfoModel.adAppId) && s.d(this.adAppKey, fKStartupMediaBaseInfoModel.adAppKey) && this.byApi == fKStartupMediaBaseInfoModel.byApi && s.d(this.adPrice, fKStartupMediaBaseInfoModel.adPrice) && s.d(this.bidding, fKStartupMediaBaseInfoModel.bidding) && s.d(this.adTimeout, fKStartupMediaBaseInfoModel.adTimeout);
    }

    @Nullable
    public final String getAdAppId() {
        return this.adAppId;
    }

    @Nullable
    public final String getAdAppKey() {
        return this.adAppKey;
    }

    @NotNull
    public final String getAdId() {
        return this.adId;
    }

    @Nullable
    public final Integer getAdTimeout() {
        return this.adTimeout;
    }

    @Nullable
    public final Boolean getBidding() {
        return this.bidding;
    }

    public final boolean getByApi() {
        return this.byApi;
    }

    @Nullable
    public final List<String> getClickMonitorLink() {
        return this.clickMonitorLink;
    }

    @Nullable
    public final Integer getDisplayTime() {
        return this.displayTime;
    }

    @Nullable
    public final List<String> getExposureMonitorLink() {
        return this.exposureMonitorLink;
    }

    @Nullable
    public final ImageModel getImageStartup() {
        return this.imageStartup;
    }

    @Nullable
    public final String getJumpLink() {
        return this.jumpLink;
    }

    @Nullable
    public final Integer getMaterialType() {
        return this.materialType;
    }

    public final int getPrice() {
        Integer num = this.adPrice;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Nullable
    public final String getThirdPartyId() {
        return this.thirdPartyId;
    }

    @Nullable
    public final String getThirdPartySource() {
        return this.thirdPartySource;
    }

    public final int getType() {
        return this.type;
    }

    @Nullable
    public final VideoModel getVideo() {
        return this.video;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.adId.hashCode() * 31) + this.type) * 31;
        String str = this.thirdPartySource;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.thirdPartyId;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.materialType;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        ImageModel imageModel = this.imageStartup;
        int hashCode5 = (hashCode4 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        VideoModel videoModel = this.video;
        int hashCode6 = (hashCode5 + (videoModel == null ? 0 : videoModel.hashCode())) * 31;
        String str3 = this.jumpLink;
        int hashCode7 = (hashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<String> list = this.exposureMonitorLink;
        int hashCode8 = (hashCode7 + (list == null ? 0 : list.hashCode())) * 31;
        List<String> list2 = this.clickMonitorLink;
        int hashCode9 = (hashCode8 + (list2 == null ? 0 : list2.hashCode())) * 31;
        Integer num2 = this.displayTime;
        int hashCode10 = (hashCode9 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str4 = this.adAppId;
        int hashCode11 = (hashCode10 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.adAppKey;
        int hashCode12 = (hashCode11 + (str5 == null ? 0 : str5.hashCode())) * 31;
        boolean z10 = this.byApi;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode12 + i10) * 31;
        Integer num3 = this.adPrice;
        int hashCode13 = (i11 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Boolean bool = this.bidding;
        int hashCode14 = (hashCode13 + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num4 = this.adTimeout;
        return hashCode14 + (num4 != null ? num4.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.adId;
        int i10 = this.type;
        String str2 = this.thirdPartySource;
        String str3 = this.thirdPartyId;
        Integer num = this.materialType;
        ImageModel imageModel = this.imageStartup;
        VideoModel videoModel = this.video;
        String str4 = this.jumpLink;
        List<String> list = this.exposureMonitorLink;
        List<String> list2 = this.clickMonitorLink;
        Integer num2 = this.displayTime;
        return "FKStartupMediaBaseInfoModel(adId=" + str + ", type=" + i10 + ", thirdPartySource=" + str2 + ", thirdPartyId=" + str3 + ", materialType=" + ((Object) num) + ", imageStartup=" + ((Object) imageModel) + ", video=" + ((Object) videoModel) + ", jumpLink=" + str4 + ", exposureMonitorLink=" + ((Object) list) + ", clickMonitorLink=" + ((Object) list2) + ", displayTime=" + ((Object) num2) + ", adAppId=" + this.adAppId + ", adAppKey=" + this.adAppKey + ", byApi=" + this.byApi + ", adPrice=" + ((Object) this.adPrice) + ", bidding=" + ((Object) this.bidding) + ", adTimeout=" + ((Object) this.adTimeout) + ")";
    }
}
