package com.cupidapp.live.base.network.model;

import com.cupidapp.live.profile.model.UserVipDetailModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LocationChangeModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LocationChangeModel {

    @Nullable
    private final String button;

    @Nullable
    private final String cityCode;

    @Nullable
    private final String cityName;

    @Nullable
    private final String subTitle;

    @Nullable
    private final String title;
    private final int vipType;

    public LocationChangeModel(int i10, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        this.vipType = i10;
        this.title = str;
        this.subTitle = str2;
        this.button = str3;
        this.cityCode = str4;
        this.cityName = str5;
    }

    public static /* synthetic */ LocationChangeModel copy$default(LocationChangeModel locationChangeModel, int i10, String str, String str2, String str3, String str4, String str5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = locationChangeModel.vipType;
        }
        if ((i11 & 2) != 0) {
            str = locationChangeModel.title;
        }
        String str6 = str;
        if ((i11 & 4) != 0) {
            str2 = locationChangeModel.subTitle;
        }
        String str7 = str2;
        if ((i11 & 8) != 0) {
            str3 = locationChangeModel.button;
        }
        String str8 = str3;
        if ((i11 & 16) != 0) {
            str4 = locationChangeModel.cityCode;
        }
        String str9 = str4;
        if ((i11 & 32) != 0) {
            str5 = locationChangeModel.cityName;
        }
        return locationChangeModel.copy(i10, str6, str7, str8, str9, str5);
    }

    public final int component1() {
        return this.vipType;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final String component3() {
        return this.subTitle;
    }

    @Nullable
    public final String component4() {
        return this.button;
    }

    @Nullable
    public final String component5() {
        return this.cityCode;
    }

    @Nullable
    public final String component6() {
        return this.cityName;
    }

    @NotNull
    public final LocationChangeModel copy(int i10, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        return new LocationChangeModel(i10, str, str2, str3, str4, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationChangeModel)) {
            return false;
        }
        LocationChangeModel locationChangeModel = (LocationChangeModel) obj;
        return this.vipType == locationChangeModel.vipType && s.d(this.title, locationChangeModel.title) && s.d(this.subTitle, locationChangeModel.subTitle) && s.d(this.button, locationChangeModel.button) && s.d(this.cityCode, locationChangeModel.cityCode) && s.d(this.cityName, locationChangeModel.cityName);
    }

    @Nullable
    public final String getButton() {
        return this.button;
    }

    @Nullable
    public final String getCityCode() {
        return this.cityCode;
    }

    @Nullable
    public final String getCityName() {
        return this.cityName;
    }

    @Nullable
    public final String getSubTitle() {
        return this.subTitle;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public final int getVipType() {
        return this.vipType;
    }

    public int hashCode() {
        int i10 = this.vipType * 31;
        String str = this.title;
        int hashCode = (i10 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.subTitle;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.button;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.cityCode;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.cityName;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    @NotNull
    public final UserVipDetailModel mapUserVipDetailModel() {
        return new UserVipDetailModel(this.vipType == UserVipType.Vip.getValue(), this.vipType == UserVipType.VipAnnual.getValue(), this.vipType == UserVipType.SVip.getValue(), this.vipType == UserVipType.SVipAnnual.getValue(), this.vipType == UserVipType.SSVip.getValue(), this.vipType == UserVipType.SSVipAnnual.getValue(), false, 64, null);
    }

    @NotNull
    public String toString() {
        return "LocationChangeModel(vipType=" + this.vipType + ", title=" + this.title + ", subTitle=" + this.subTitle + ", button=" + this.button + ", cityCode=" + this.cityCode + ", cityName=" + this.cityName + ")";
    }
}
