package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.road.Crossroad;
import com.amap.api.services.road.Road;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class RegeocodeAddress implements Parcelable {
    public static final Parcelable.Creator<RegeocodeAddress> CREATOR = new Parcelable.Creator<RegeocodeAddress>() { // from class: com.amap.api.services.geocoder.RegeocodeAddress.1
        private static RegeocodeAddress a(Parcel parcel) {
            return new RegeocodeAddress(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RegeocodeAddress createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RegeocodeAddress[] newArray(int i10) {
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f8536a;

    /* renamed from: b, reason: collision with root package name */
    private String f8537b;

    /* renamed from: c, reason: collision with root package name */
    private String f8538c;

    /* renamed from: d, reason: collision with root package name */
    private String f8539d;

    /* renamed from: e, reason: collision with root package name */
    private String f8540e;

    /* renamed from: f, reason: collision with root package name */
    private String f8541f;

    /* renamed from: g, reason: collision with root package name */
    private String f8542g;

    /* renamed from: h, reason: collision with root package name */
    private StreetNumber f8543h;

    /* renamed from: i, reason: collision with root package name */
    private String f8544i;

    /* renamed from: j, reason: collision with root package name */
    private String f8545j;

    /* renamed from: k, reason: collision with root package name */
    private String f8546k;

    /* renamed from: l, reason: collision with root package name */
    private List<RegeocodeRoad> f8547l;

    /* renamed from: m, reason: collision with root package name */
    private List<Crossroad> f8548m;

    /* renamed from: n, reason: collision with root package name */
    private List<PoiItem> f8549n;

    /* renamed from: o, reason: collision with root package name */
    private List<BusinessArea> f8550o;

    /* renamed from: p, reason: collision with root package name */
    private List<AoiItem> f8551p;

    /* renamed from: q, reason: collision with root package name */
    private String f8552q;

    /* renamed from: r, reason: collision with root package name */
    private String f8553r;

    public /* synthetic */ RegeocodeAddress(Parcel parcel, byte b4) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getAdCode() {
        return this.f8545j;
    }

    public final List<AoiItem> getAois() {
        return this.f8551p;
    }

    public final String getBuilding() {
        return this.f8542g;
    }

    public final List<BusinessArea> getBusinessAreas() {
        return this.f8550o;
    }

    public final String getCity() {
        return this.f8538c;
    }

    public final String getCityCode() {
        return this.f8544i;
    }

    public final String getCountry() {
        return this.f8552q;
    }

    public final String getCountryCode() {
        return this.f8553r;
    }

    public final List<Crossroad> getCrossroads() {
        return this.f8548m;
    }

    public final String getDistrict() {
        return this.f8539d;
    }

    public final String getFormatAddress() {
        return this.f8536a;
    }

    public final String getNeighborhood() {
        return this.f8541f;
    }

    public final List<PoiItem> getPois() {
        return this.f8549n;
    }

    public final String getProvince() {
        return this.f8537b;
    }

    public final List<RegeocodeRoad> getRoads() {
        return this.f8547l;
    }

    public final StreetNumber getStreetNumber() {
        return this.f8543h;
    }

    public final String getTowncode() {
        return this.f8546k;
    }

    public final String getTownship() {
        return this.f8540e;
    }

    public final void setAdCode(String str) {
        this.f8545j = str;
    }

    public final void setAois(List<AoiItem> list) {
        this.f8551p = list;
    }

    public final void setBuilding(String str) {
        this.f8542g = str;
    }

    public final void setBusinessAreas(List<BusinessArea> list) {
        this.f8550o = list;
    }

    public final void setCity(String str) {
        this.f8538c = str;
    }

    public final void setCityCode(String str) {
        this.f8544i = str;
    }

    public final void setCountry(String str) {
        this.f8552q = str;
    }

    public final void setCountryCode(String str) {
        this.f8553r = str;
    }

    public final void setCrossroads(List<Crossroad> list) {
        this.f8548m = list;
    }

    public final void setDistrict(String str) {
        this.f8539d = str;
    }

    public final void setFormatAddress(String str) {
        this.f8536a = str;
    }

    public final void setNeighborhood(String str) {
        this.f8541f = str;
    }

    public final void setPois(List<PoiItem> list) {
        this.f8549n = list;
    }

    public final void setProvince(String str) {
        this.f8537b = str;
    }

    public final void setRoads(List<RegeocodeRoad> list) {
        this.f8547l = list;
    }

    public final void setStreetNumber(StreetNumber streetNumber) {
        this.f8543h = streetNumber;
    }

    public final void setTowncode(String str) {
        this.f8546k = str;
    }

    public final void setTownship(String str) {
        this.f8540e = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8536a);
        parcel.writeString(this.f8537b);
        parcel.writeString(this.f8538c);
        parcel.writeString(this.f8539d);
        parcel.writeString(this.f8540e);
        parcel.writeString(this.f8541f);
        parcel.writeString(this.f8542g);
        parcel.writeValue(this.f8543h);
        parcel.writeList(this.f8547l);
        parcel.writeList(this.f8548m);
        parcel.writeList(this.f8549n);
        parcel.writeString(this.f8544i);
        parcel.writeString(this.f8545j);
        parcel.writeList(this.f8550o);
        parcel.writeList(this.f8551p);
        parcel.writeString(this.f8546k);
        parcel.writeString(this.f8552q);
        parcel.writeString(this.f8553r);
    }

    public RegeocodeAddress() {
        this.f8547l = new ArrayList();
        this.f8548m = new ArrayList();
        this.f8549n = new ArrayList();
        this.f8550o = new ArrayList();
        this.f8551p = new ArrayList();
    }

    private RegeocodeAddress(Parcel parcel) {
        this.f8547l = new ArrayList();
        this.f8548m = new ArrayList();
        this.f8549n = new ArrayList();
        this.f8550o = new ArrayList();
        this.f8551p = new ArrayList();
        this.f8536a = parcel.readString();
        this.f8537b = parcel.readString();
        this.f8538c = parcel.readString();
        this.f8539d = parcel.readString();
        this.f8540e = parcel.readString();
        this.f8541f = parcel.readString();
        this.f8542g = parcel.readString();
        this.f8543h = (StreetNumber) parcel.readValue(StreetNumber.class.getClassLoader());
        this.f8547l = parcel.readArrayList(Road.class.getClassLoader());
        this.f8548m = parcel.readArrayList(Crossroad.class.getClassLoader());
        this.f8549n = parcel.readArrayList(PoiItem.class.getClassLoader());
        this.f8544i = parcel.readString();
        this.f8545j = parcel.readString();
        this.f8550o = parcel.readArrayList(BusinessArea.class.getClassLoader());
        this.f8551p = parcel.readArrayList(AoiItem.class.getClassLoader());
        this.f8546k = parcel.readString();
        this.f8552q = parcel.readString();
        this.f8553r = parcel.readString();
    }
}
