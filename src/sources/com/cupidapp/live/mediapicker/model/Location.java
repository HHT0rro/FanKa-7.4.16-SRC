package com.cupidapp.live.mediapicker.model;

import android.text.TextUtils;
import java.io.Serializable;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VideoContentModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class Location implements Serializable {

    @Nullable
    private String address;

    @Nullable
    private String cityname;

    /* renamed from: id, reason: collision with root package name */
    @NotNull
    private String f17257id;

    @Nullable
    private Double latitude;

    @Nullable
    private Double longitude;

    @Nullable
    private String name;

    public Location(@NotNull String id2, @Nullable String str, @Nullable String str2, @Nullable Double d10, @Nullable Double d11, @Nullable String str3) {
        s.i(id2, "id");
        this.f17257id = id2;
        this.address = str;
        this.name = str2;
        this.latitude = d10;
        this.longitude = d11;
        this.cityname = str3;
    }

    public static /* synthetic */ Location copy$default(Location location, String str, String str2, String str3, Double d10, Double d11, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = location.f17257id;
        }
        if ((i10 & 2) != 0) {
            str2 = location.address;
        }
        String str5 = str2;
        if ((i10 & 4) != 0) {
            str3 = location.name;
        }
        String str6 = str3;
        if ((i10 & 8) != 0) {
            d10 = location.latitude;
        }
        Double d12 = d10;
        if ((i10 & 16) != 0) {
            d11 = location.longitude;
        }
        Double d13 = d11;
        if ((i10 & 32) != 0) {
            str4 = location.cityname;
        }
        return location.copy(str, str5, str6, d12, d13, str4);
    }

    @NotNull
    public final String component1() {
        return this.f17257id;
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

    @NotNull
    public final Location copy(@NotNull String id2, @Nullable String str, @Nullable String str2, @Nullable Double d10, @Nullable Double d11, @Nullable String str3) {
        s.i(id2, "id");
        return new Location(id2, str, str2, d10, d11, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Location)) {
            return false;
        }
        Location location = (Location) obj;
        return s.d(this.f17257id, location.f17257id) && s.d(this.address, location.address) && s.d(this.name, location.name) && s.d(this.latitude, location.latitude) && s.d(this.longitude, location.longitude) && s.d(this.cityname, location.cityname);
    }

    @Nullable
    public final String getAddress() {
        return this.address;
    }

    @Nullable
    public final String getCityname() {
        return this.cityname;
    }

    @NotNull
    public final String getId() {
        return this.f17257id;
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
        int hashCode = this.f17257id.hashCode() * 31;
        String str = this.address;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.name;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Double d10 = this.latitude;
        int hashCode4 = (hashCode3 + (d10 == null ? 0 : d10.hashCode())) * 31;
        Double d11 = this.longitude;
        int hashCode5 = (hashCode4 + (d11 == null ? 0 : d11.hashCode())) * 31;
        String str3 = this.cityname;
        return hashCode5 + (str3 != null ? str3.hashCode() : 0);
    }

    public final boolean isEmpty() {
        return TextUtils.isEmpty(this.f17257id) || this.latitude == null || this.longitude == null;
    }

    public final void setAddress(@Nullable String str) {
        this.address = str;
    }

    public final void setCityname(@Nullable String str) {
        this.cityname = str;
    }

    public final void setId(@NotNull String str) {
        s.i(str, "<set-?>");
        this.f17257id = str;
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
        String str = this.f17257id;
        String str2 = this.address;
        String str3 = this.name;
        Double d10 = this.latitude;
        Double d11 = this.longitude;
        return "Location(id=" + str + ", address=" + str2 + ", name=" + str3 + ", latitude=" + ((Object) d10) + ", longitude=" + ((Object) d11) + ", cityname=" + this.cityname + ")";
    }
}
