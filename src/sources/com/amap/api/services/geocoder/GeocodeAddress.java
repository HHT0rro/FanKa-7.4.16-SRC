package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class GeocodeAddress implements Parcelable {
    public static final Parcelable.Creator<GeocodeAddress> CREATOR = new Parcelable.Creator<GeocodeAddress>() { // from class: com.amap.api.services.geocoder.GeocodeAddress.1
        private static GeocodeAddress a(Parcel parcel) {
            return new GeocodeAddress(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ GeocodeAddress createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ GeocodeAddress[] newArray(int i10) {
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f8518a;

    /* renamed from: b, reason: collision with root package name */
    private String f8519b;

    /* renamed from: c, reason: collision with root package name */
    private String f8520c;

    /* renamed from: d, reason: collision with root package name */
    private String f8521d;

    /* renamed from: e, reason: collision with root package name */
    private String f8522e;

    /* renamed from: f, reason: collision with root package name */
    private String f8523f;

    /* renamed from: g, reason: collision with root package name */
    private String f8524g;

    /* renamed from: h, reason: collision with root package name */
    private String f8525h;

    /* renamed from: i, reason: collision with root package name */
    private LatLonPoint f8526i;

    /* renamed from: j, reason: collision with root package name */
    private String f8527j;

    /* renamed from: k, reason: collision with root package name */
    private String f8528k;

    /* renamed from: l, reason: collision with root package name */
    private String f8529l;

    public /* synthetic */ GeocodeAddress(Parcel parcel, byte b4) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getAdcode() {
        return this.f8525h;
    }

    public final String getBuilding() {
        return this.f8524g;
    }

    public final String getCity() {
        return this.f8520c;
    }

    public final String getCountry() {
        return this.f8528k;
    }

    public final String getDistrict() {
        return this.f8521d;
    }

    public final String getFormatAddress() {
        return this.f8518a;
    }

    public final LatLonPoint getLatLonPoint() {
        return this.f8526i;
    }

    public final String getLevel() {
        return this.f8527j;
    }

    public final String getNeighborhood() {
        return this.f8523f;
    }

    public final String getPostcode() {
        return this.f8529l;
    }

    public final String getProvince() {
        return this.f8519b;
    }

    public final String getTownship() {
        return this.f8522e;
    }

    public final void setAdcode(String str) {
        this.f8525h = str;
    }

    public final void setBuilding(String str) {
        this.f8524g = str;
    }

    public final void setCity(String str) {
        this.f8520c = str;
    }

    public final void setCountry(String str) {
        this.f8528k = str;
    }

    public final void setDistrict(String str) {
        this.f8521d = str;
    }

    public final void setFormatAddress(String str) {
        this.f8518a = str;
    }

    public final void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f8526i = latLonPoint;
    }

    public final void setLevel(String str) {
        this.f8527j = str;
    }

    public final void setNeighborhood(String str) {
        this.f8523f = str;
    }

    public final void setPostcode(String str) {
        this.f8529l = str;
    }

    public final void setProvince(String str) {
        this.f8519b = str;
    }

    public final void setTownship(String str) {
        this.f8522e = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8518a);
        parcel.writeString(this.f8519b);
        parcel.writeString(this.f8520c);
        parcel.writeString(this.f8521d);
        parcel.writeString(this.f8522e);
        parcel.writeString(this.f8523f);
        parcel.writeString(this.f8524g);
        parcel.writeString(this.f8525h);
        parcel.writeValue(this.f8526i);
        parcel.writeString(this.f8527j);
        parcel.writeString(this.f8528k);
        parcel.writeString(this.f8529l);
    }

    public GeocodeAddress() {
    }

    private GeocodeAddress(Parcel parcel) {
        this.f8518a = parcel.readString();
        this.f8519b = parcel.readString();
        this.f8520c = parcel.readString();
        this.f8521d = parcel.readString();
        this.f8522e = parcel.readString();
        this.f8523f = parcel.readString();
        this.f8524g = parcel.readString();
        this.f8525h = parcel.readString();
        this.f8526i = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f8527j = parcel.readString();
        this.f8528k = parcel.readString();
        this.f8529l = parcel.readString();
    }
}
