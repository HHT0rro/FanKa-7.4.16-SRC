package com.cupidapp.live.match.model;

import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.profile.model.UserVipDetailModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NearByModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NearbyUserModel implements Serializable {

    @Nullable
    private final String age;
    private final boolean annualSsvip;
    private final boolean annualSvip;
    private boolean annualVip;

    @Nullable
    private final ImageModel avatarImage;

    @Nullable
    private final String distance;

    @Nullable
    private final ImageModel faceAvatarImage;
    private final boolean fromSpecialExposure;
    private final boolean hide;
    private final boolean hot;

    /* renamed from: id, reason: collision with root package name */
    @Nullable
    private final String f16838id;

    @Nullable
    private final String name;

    @Nullable
    private final Boolean newHere;
    private final boolean online;
    private final boolean ssvip;

    @Nullable
    private final String summaryInfo;
    private final boolean svip;

    @Nullable
    private final String travelCity;

    @Nullable
    private final String userSpecialLabel;
    private final boolean vip;
    private final boolean vipIconHide;

    public NearbyUserModel(@Nullable String str, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, @Nullable ImageModel imageModel, @Nullable String str2, @Nullable String str3, @Nullable String str4, boolean z15, boolean z16, boolean z17, @Nullable String str5, @Nullable String str6, @Nullable ImageModel imageModel2, @Nullable Boolean bool, boolean z18, boolean z19, boolean z20, @Nullable String str7) {
        this.f16838id = str;
        this.vip = z10;
        this.annualVip = z11;
        this.svip = z12;
        this.annualSvip = z13;
        this.vipIconHide = z14;
        this.avatarImage = imageModel;
        this.name = str2;
        this.age = str3;
        this.distance = str4;
        this.hide = z15;
        this.hot = z16;
        this.online = z17;
        this.userSpecialLabel = str5;
        this.summaryInfo = str6;
        this.faceAvatarImage = imageModel2;
        this.newHere = bool;
        this.ssvip = z18;
        this.annualSsvip = z19;
        this.fromSpecialExposure = z20;
        this.travelCity = str7;
    }

    @Nullable
    public final String component1() {
        return this.f16838id;
    }

    @Nullable
    public final String component10() {
        return this.distance;
    }

    public final boolean component11() {
        return this.hide;
    }

    public final boolean component12() {
        return this.hot;
    }

    public final boolean component13() {
        return this.online;
    }

    @Nullable
    public final String component14() {
        return this.userSpecialLabel;
    }

    @Nullable
    public final String component15() {
        return this.summaryInfo;
    }

    @Nullable
    public final ImageModel component16() {
        return this.faceAvatarImage;
    }

    @Nullable
    public final Boolean component17() {
        return this.newHere;
    }

    public final boolean component18() {
        return this.ssvip;
    }

    public final boolean component19() {
        return this.annualSsvip;
    }

    public final boolean component2() {
        return this.vip;
    }

    public final boolean component20() {
        return this.fromSpecialExposure;
    }

    @Nullable
    public final String component21() {
        return this.travelCity;
    }

    public final boolean component3() {
        return this.annualVip;
    }

    public final boolean component4() {
        return this.svip;
    }

    public final boolean component5() {
        return this.annualSvip;
    }

    public final boolean component6() {
        return this.vipIconHide;
    }

    @Nullable
    public final ImageModel component7() {
        return this.avatarImage;
    }

    @Nullable
    public final String component8() {
        return this.name;
    }

    @Nullable
    public final String component9() {
        return this.age;
    }

    @NotNull
    public final NearbyUserModel copy(@Nullable String str, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, @Nullable ImageModel imageModel, @Nullable String str2, @Nullable String str3, @Nullable String str4, boolean z15, boolean z16, boolean z17, @Nullable String str5, @Nullable String str6, @Nullable ImageModel imageModel2, @Nullable Boolean bool, boolean z18, boolean z19, boolean z20, @Nullable String str7) {
        return new NearbyUserModel(str, z10, z11, z12, z13, z14, imageModel, str2, str3, str4, z15, z16, z17, str5, str6, imageModel2, bool, z18, z19, z20, str7);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NearbyUserModel)) {
            return false;
        }
        NearbyUserModel nearbyUserModel = (NearbyUserModel) obj;
        return s.d(this.f16838id, nearbyUserModel.f16838id) && this.vip == nearbyUserModel.vip && this.annualVip == nearbyUserModel.annualVip && this.svip == nearbyUserModel.svip && this.annualSvip == nearbyUserModel.annualSvip && this.vipIconHide == nearbyUserModel.vipIconHide && s.d(this.avatarImage, nearbyUserModel.avatarImage) && s.d(this.name, nearbyUserModel.name) && s.d(this.age, nearbyUserModel.age) && s.d(this.distance, nearbyUserModel.distance) && this.hide == nearbyUserModel.hide && this.hot == nearbyUserModel.hot && this.online == nearbyUserModel.online && s.d(this.userSpecialLabel, nearbyUserModel.userSpecialLabel) && s.d(this.summaryInfo, nearbyUserModel.summaryInfo) && s.d(this.faceAvatarImage, nearbyUserModel.faceAvatarImage) && s.d(this.newHere, nearbyUserModel.newHere) && this.ssvip == nearbyUserModel.ssvip && this.annualSsvip == nearbyUserModel.annualSsvip && this.fromSpecialExposure == nearbyUserModel.fromSpecialExposure && s.d(this.travelCity, nearbyUserModel.travelCity);
    }

    @Nullable
    public final String getAge() {
        return this.age;
    }

    public final boolean getAnnualSsvip() {
        return this.annualSsvip;
    }

    public final boolean getAnnualSvip() {
        return this.annualSvip;
    }

    public final boolean getAnnualVip() {
        return this.annualVip;
    }

    @Nullable
    public final ImageModel getAvatarImage() {
        return this.avatarImage;
    }

    @Nullable
    public final String getDistance() {
        return this.distance;
    }

    @Nullable
    public final ImageModel getFaceAvatarImage() {
        return this.faceAvatarImage;
    }

    public final boolean getFromSpecialExposure() {
        return this.fromSpecialExposure;
    }

    public final boolean getHide() {
        return this.hide;
    }

    public final boolean getHot() {
        return this.hot;
    }

    @Nullable
    public final String getId() {
        return this.f16838id;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final Boolean getNewHere() {
        return this.newHere;
    }

    public final boolean getOnline() {
        return this.online;
    }

    public final boolean getSsvip() {
        return this.ssvip;
    }

    @Nullable
    public final String getSummaryInfo() {
        return this.summaryInfo;
    }

    public final boolean getSvip() {
        return this.svip;
    }

    @Nullable
    public final String getTravelCity() {
        return this.travelCity;
    }

    @Nullable
    public final String getUserSpecialLabel() {
        return this.userSpecialLabel;
    }

    public final boolean getVip() {
        return this.vip;
    }

    public final boolean getVipIconHide() {
        return this.vipIconHide;
    }

    @NotNull
    public final UserVipDetailModel getVipModel() {
        return new UserVipDetailModel(this.vip, this.annualVip, this.svip, this.annualSvip, this.ssvip, this.annualSsvip, this.vipIconHide);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.f16838id;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        boolean z10 = this.vip;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode + i10) * 31;
        boolean z11 = this.annualVip;
        int i12 = z11;
        if (z11 != 0) {
            i12 = 1;
        }
        int i13 = (i11 + i12) * 31;
        boolean z12 = this.svip;
        int i14 = z12;
        if (z12 != 0) {
            i14 = 1;
        }
        int i15 = (i13 + i14) * 31;
        boolean z13 = this.annualSvip;
        int i16 = z13;
        if (z13 != 0) {
            i16 = 1;
        }
        int i17 = (i15 + i16) * 31;
        boolean z14 = this.vipIconHide;
        int i18 = z14;
        if (z14 != 0) {
            i18 = 1;
        }
        int i19 = (i17 + i18) * 31;
        ImageModel imageModel = this.avatarImage;
        int hashCode2 = (i19 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str2 = this.name;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.age;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.distance;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        boolean z15 = this.hide;
        int i20 = z15;
        if (z15 != 0) {
            i20 = 1;
        }
        int i21 = (hashCode5 + i20) * 31;
        boolean z16 = this.hot;
        int i22 = z16;
        if (z16 != 0) {
            i22 = 1;
        }
        int i23 = (i21 + i22) * 31;
        boolean z17 = this.online;
        int i24 = z17;
        if (z17 != 0) {
            i24 = 1;
        }
        int i25 = (i23 + i24) * 31;
        String str5 = this.userSpecialLabel;
        int hashCode6 = (i25 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.summaryInfo;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        ImageModel imageModel2 = this.faceAvatarImage;
        int hashCode8 = (hashCode7 + (imageModel2 == null ? 0 : imageModel2.hashCode())) * 31;
        Boolean bool = this.newHere;
        int hashCode9 = (hashCode8 + (bool == null ? 0 : bool.hashCode())) * 31;
        boolean z18 = this.ssvip;
        int i26 = z18;
        if (z18 != 0) {
            i26 = 1;
        }
        int i27 = (hashCode9 + i26) * 31;
        boolean z19 = this.annualSsvip;
        int i28 = z19;
        if (z19 != 0) {
            i28 = 1;
        }
        int i29 = (i27 + i28) * 31;
        boolean z20 = this.fromSpecialExposure;
        int i30 = (i29 + (z20 ? 1 : z20 ? 1 : 0)) * 31;
        String str7 = this.travelCity;
        return i30 + (str7 != null ? str7.hashCode() : 0);
    }

    public final void setAnnualVip(boolean z10) {
        this.annualVip = z10;
    }

    @NotNull
    public String toString() {
        String str = this.f16838id;
        boolean z10 = this.vip;
        boolean z11 = this.annualVip;
        boolean z12 = this.svip;
        boolean z13 = this.annualSvip;
        boolean z14 = this.vipIconHide;
        ImageModel imageModel = this.avatarImage;
        String str2 = this.name;
        String str3 = this.age;
        String str4 = this.distance;
        boolean z15 = this.hide;
        boolean z16 = this.hot;
        boolean z17 = this.online;
        String str5 = this.userSpecialLabel;
        String str6 = this.summaryInfo;
        ImageModel imageModel2 = this.faceAvatarImage;
        Boolean bool = this.newHere;
        return "NearbyUserModel(id=" + str + ", vip=" + z10 + ", annualVip=" + z11 + ", svip=" + z12 + ", annualSvip=" + z13 + ", vipIconHide=" + z14 + ", avatarImage=" + ((Object) imageModel) + ", name=" + str2 + ", age=" + str3 + ", distance=" + str4 + ", hide=" + z15 + ", hot=" + z16 + ", online=" + z17 + ", userSpecialLabel=" + str5 + ", summaryInfo=" + str6 + ", faceAvatarImage=" + ((Object) imageModel2) + ", newHere=" + ((Object) bool) + ", ssvip=" + this.ssvip + ", annualSsvip=" + this.annualSsvip + ", fromSpecialExposure=" + this.fromSpecialExposure + ", travelCity=" + this.travelCity + ")";
    }

    public /* synthetic */ NearbyUserModel(String str, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, ImageModel imageModel, String str2, String str3, String str4, boolean z15, boolean z16, boolean z17, String str5, String str6, ImageModel imageModel2, Boolean bool, boolean z18, boolean z19, boolean z20, String str7, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i10 & 2) != 0 ? false : z10, (i10 & 4) != 0 ? false : z11, (i10 & 8) != 0 ? false : z12, (i10 & 16) != 0 ? false : z13, (i10 & 32) != 0 ? false : z14, (i10 & 64) != 0 ? null : imageModel, (i10 & 128) != 0 ? null : str2, (i10 & 256) != 0 ? null : str3, (i10 & 512) != 0 ? null : str4, (i10 & 1024) != 0 ? false : z15, (i10 & 2048) != 0 ? false : z16, (i10 & 4096) != 0 ? false : z17, (i10 & 8192) != 0 ? null : str5, (i10 & 16384) != 0 ? null : str6, (i10 & 32768) != 0 ? null : imageModel2, (i10 & 65536) != 0 ? Boolean.FALSE : bool, (i10 & 131072) != 0 ? false : z18, (i10 & 262144) != 0 ? false : z19, (i10 & 524288) != 0 ? false : z20, (i10 & 1048576) == 0 ? str7 : null);
    }
}
