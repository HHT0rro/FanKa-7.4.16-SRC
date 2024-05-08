package com.cupidapp.live.match.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MapModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AddressModel implements Serializable {

    @Nullable
    private String adName;

    @Nullable
    private String address;

    @Nullable
    private String cityname;

    @Nullable
    private String clickCount;

    @Nullable
    private String distance;

    /* renamed from: id, reason: collision with root package name */
    @NotNull
    private String f16834id;

    @SerializedName("lat")
    @Nullable
    private Double latitude;

    @SerializedName("lon")
    @Nullable
    private Double longitude;

    @Nullable
    private String name;

    public AddressModel(@NotNull String id2, @Nullable String str, @Nullable String str2, @Nullable Double d10, @Nullable Double d11, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        s.i(id2, "id");
        this.f16834id = id2;
        this.address = str;
        this.name = str2;
        this.latitude = d10;
        this.longitude = d11;
        this.cityname = str3;
        this.adName = str4;
        this.distance = str5;
        this.clickCount = str6;
    }

    @NotNull
    public final String component1() {
        return this.f16834id;
    }

    @Nullable
    public final String component2() {
        return this.address;
    }

    @Nullable
    public final String component3() {
        return this.name;
    }

    @Nullable
    public final Double component4() {
        return this.latitude;
    }

    @Nullable
    public final Double component5() {
        return this.longitude;
    }

    @Nullable
    public final String component6() {
        return this.cityname;
    }

    @Nullable
    public final String component7() {
        return this.adName;
    }

    @Nullable
    public final String component8() {
        return this.distance;
    }

    @Nullable
    public final String component9() {
        return this.clickCount;
    }

    @NotNull
    public final AddressModel copy(@NotNull String id2, @Nullable String str, @Nullable String str2, @Nullable Double d10, @Nullable Double d11, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        s.i(id2, "id");
        return new AddressModel(id2, str, str2, d10, d11, str3, str4, str5, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AddressModel)) {
            return false;
        }
        AddressModel addressModel = (AddressModel) obj;
        return s.d(this.f16834id, addressModel.f16834id) && s.d(this.address, addressModel.address) && s.d(this.name, addressModel.name) && s.d(this.latitude, addressModel.latitude) && s.d(this.longitude, addressModel.longitude) && s.d(this.cityname, addressModel.cityname) && s.d(this.adName, addressModel.adName) && s.d(this.distance, addressModel.distance) && s.d(this.clickCount, addressModel.clickCount);
    }

    @Nullable
    public final String getAdName() {
        return this.adName;
    }

    @Nullable
    public final String getAddress() {
        return this.address;
    }

    @Nullable
    public final String getCityname() {
        return this.cityname;
    }

    @Nullable
    public final String getClickCount() {
        return this.clickCount;
    }

    @Nullable
    public final String getDistance() {
        return this.distance;
    }

    @NotNull
    public final String getId() {
        return this.f16834id;
    }

    @Nullable
    public final Double getLatitude() {
        return this.latitude;
    }

    @Nullable
    public final Double getLongitude() {
        return this.longitude;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        int hashCode = this.f16834id.hashCode() * 31;
        String str = this.address;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.name;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Double d10 = this.latitude;
        int hashCode4 = (hashCode3 + (d10 == null ? 0 : d10.hashCode())) * 31;
        Double d11 = this.longitude;
        int hashCode5 = (hashCode4 + (d11 == null ? 0 : d11.hashCode())) * 31;
        String str3 = this.cityname;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.adName;
        int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.distance;
        int hashCode8 = (hashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.clickCount;
        return hashCode8 + (str6 != null ? str6.hashCode() : 0);
    }

    public final void setAdName(@Nullable String str) {
        this.adName = str;
    }

    public final void setAddress(@Nullable String str) {
        this.address = str;
    }

    public final void setCityname(@Nullable String str) {
        this.cityname = str;
    }

    public final void setClickCount(@Nullable String str) {
        this.clickCount = str;
    }

    public final void setDistance(@Nullable String str) {
        this.distance = str;
    }

    public final void setId(@NotNull String str) {
        s.i(str, "<set-?>");
        this.f16834id = str;
    }

    public final void setLatitude(@Nullable Double d10) {
        this.latitude = d10;
    }

    public final void setLongitude(@Nullable Double d10) {
        this.longitude = d10;
    }

    public final void setName(@Nullable String str) {
        this.name = str;
    }

    @NotNull
    public String toString() {
        String str = this.f16834id;
        String str2 = this.address;
        String str3 = this.name;
        Double d10 = this.latitude;
        Double d11 = this.longitude;
        return "AddressModel(id=" + str + ", address=" + str2 + ", name=" + str3 + ", latitude=" + ((Object) d10) + ", longitude=" + ((Object) d11) + ", cityname=" + this.cityname + ", adName=" + this.adName + ", distance=" + this.distance + ", clickCount=" + this.clickCount + ")";
    }
}
