package com.amap.api.services.help;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class Tip implements Parcelable {
    public static final Parcelable.Creator<Tip> CREATOR = new Parcelable.Creator<Tip>() { // from class: com.amap.api.services.help.Tip.1
        private static Tip a(Parcel parcel) {
            return new Tip(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Tip createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Tip[] newArray(int i10) {
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f8578a;

    /* renamed from: b, reason: collision with root package name */
    private LatLonPoint f8579b;

    /* renamed from: c, reason: collision with root package name */
    private String f8580c;

    /* renamed from: d, reason: collision with root package name */
    private String f8581d;

    /* renamed from: e, reason: collision with root package name */
    private String f8582e;

    /* renamed from: f, reason: collision with root package name */
    private String f8583f;

    /* renamed from: g, reason: collision with root package name */
    private String f8584g;

    /* renamed from: h, reason: collision with root package name */
    private String f8585h;

    public /* synthetic */ Tip(Parcel parcel, byte b4) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdcode() {
        return this.f8582e;
    }

    public String getAddress() {
        return this.f8583f;
    }

    public String getDistrict() {
        return this.f8581d;
    }

    public String getName() {
        return this.f8580c;
    }

    public String getPoiID() {
        return this.f8578a;
    }

    public LatLonPoint getPoint() {
        return this.f8579b;
    }

    public String getTypeCode() {
        return this.f8584g;
    }

    public void setAdcode(String str) {
        this.f8582e = str;
    }

    public void setAddress(String str) {
        this.f8583f = str;
    }

    public void setDistrict(String str) {
        this.f8581d = str;
    }

    public void setID(String str) {
        this.f8578a = str;
    }

    public void setName(String str) {
        this.f8580c = str;
    }

    public void setPostion(LatLonPoint latLonPoint) {
        this.f8579b = latLonPoint;
    }

    public void setTypeCode(String str) {
        this.f8584g = str;
    }

    public String toString() {
        return "name:" + this.f8580c + " district:" + this.f8581d + " adcode:" + this.f8582e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8580c);
        parcel.writeString(this.f8582e);
        parcel.writeString(this.f8581d);
        parcel.writeString(this.f8578a);
        parcel.writeValue(this.f8579b);
        parcel.writeString(this.f8583f);
        parcel.writeString(this.f8584g);
        parcel.writeString(this.f8585h);
    }

    public Tip() {
        this.f8585h = "";
    }

    private Tip(Parcel parcel) {
        this.f8585h = "";
        this.f8580c = parcel.readString();
        this.f8582e = parcel.readString();
        this.f8581d = parcel.readString();
        this.f8578a = parcel.readString();
        this.f8579b = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f8583f = parcel.readString();
        this.f8584g = parcel.readString();
        this.f8585h = parcel.readString();
    }
}
