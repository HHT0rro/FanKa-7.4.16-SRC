package com.cupidapp.live.base.network.model;

import android.text.TextUtils;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LocationModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LocationModel implements Serializable {

    @Nullable
    private String address;

    /* renamed from: id, reason: collision with root package name */
    @NotNull
    private String f12010id;

    @Nullable
    private Double latitude;

    @Nullable
    private Double longitude;

    @Nullable
    private String name;

    public LocationModel(@NotNull String id2, @Nullable String str, @Nullable String str2, @Nullable Double d10, @Nullable Double d11) {
        s.i(id2, "id");
        this.f12010id = id2;
        this.address = str;
        this.name = str2;
        this.latitude = d10;
        this.longitude = d11;
    }

    public static /* synthetic */ LocationModel copy$default(LocationModel locationModel, String str, String str2, String str3, Double d10, Double d11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = locationModel.f12010id;
        }
        if ((i10 & 2) != 0) {
            str2 = locationModel.address;
        }
        String str4 = str2;
        if ((i10 & 4) != 0) {
            str3 = locationModel.name;
        }
        String str5 = str3;
        if ((i10 & 8) != 0) {
            d10 = locationModel.latitude;
        }
        Double d12 = d10;
        if ((i10 & 16) != 0) {
            d11 = locationModel.longitude;
        }
        return locationModel.copy(str, str4, str5, d12, d11);
    }

    @NotNull
    public final String component1() {
        return this.f12010id;
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

    @NotNull
    public final LocationModel copy(@NotNull String id2, @Nullable String str, @Nullable String str2, @Nullable Double d10, @Nullable Double d11) {
        s.i(id2, "id");
        return new LocationModel(id2, str, str2, d10, d11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationModel)) {
            return false;
        }
        LocationModel locationModel = (LocationModel) obj;
        return s.d(this.f12010id, locationModel.f12010id) && s.d(this.address, locationModel.address) && s.d(this.name, locationModel.name) && s.d(this.latitude, locationModel.latitude) && s.d(this.longitude, locationModel.longitude);
    }

    @Nullable
    public final String getAddress() {
        return this.address;
    }

    @NotNull
    public final String getId() {
        return this.f12010id;
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
        int hashCode = this.f12010id.hashCode() * 31;
        String str = this.address;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.name;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Double d10 = this.latitude;
        int hashCode4 = (hashCode3 + (d10 == null ? 0 : d10.hashCode())) * 31;
        Double d11 = this.longitude;
        return hashCode4 + (d11 != null ? d11.hashCode() : 0);
    }

    public final boolean isEmpty() {
        return TextUtils.isEmpty(this.f12010id) || this.latitude == null || this.longitude == null;
    }

    public final void setAddress(@Nullable String str) {
        this.address = str;
    }

    public final void setId(@NotNull String str) {
        s.i(str, "<set-?>");
        this.f12010id = str;
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
        return "LocationModel(id=" + this.f12010id + ", address=" + this.address + ", name=" + this.name + ", latitude=" + ((Object) this.latitude) + ", longitude=" + ((Object) this.longitude) + ")";
    }
}
