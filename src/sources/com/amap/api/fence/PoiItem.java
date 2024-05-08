package com.amap.api.fence;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.shadow.ShadowDrawableWrapper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class PoiItem implements Parcelable {
    public static final Parcelable.Creator<PoiItem> CREATOR = new Parcelable.Creator<PoiItem>() { // from class: com.amap.api.fence.PoiItem.1
        private static PoiItem a(Parcel parcel) {
            return new PoiItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PoiItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PoiItem[] newArray(int i10) {
            return a(i10);
        }

        private static PoiItem[] a(int i10) {
            return new PoiItem[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f8046a;

    /* renamed from: b, reason: collision with root package name */
    private String f8047b;

    /* renamed from: c, reason: collision with root package name */
    private String f8048c;

    /* renamed from: d, reason: collision with root package name */
    private String f8049d;

    /* renamed from: e, reason: collision with root package name */
    private String f8050e;

    /* renamed from: f, reason: collision with root package name */
    private double f8051f;

    /* renamed from: g, reason: collision with root package name */
    private double f8052g;

    /* renamed from: h, reason: collision with root package name */
    private String f8053h;

    /* renamed from: i, reason: collision with root package name */
    private String f8054i;

    /* renamed from: j, reason: collision with root package name */
    private String f8055j;

    /* renamed from: k, reason: collision with root package name */
    private String f8056k;

    public PoiItem() {
        this.f8046a = "";
        this.f8047b = "";
        this.f8048c = "";
        this.f8049d = "";
        this.f8050e = "";
        this.f8051f = ShadowDrawableWrapper.COS_45;
        this.f8052g = ShadowDrawableWrapper.COS_45;
        this.f8053h = "";
        this.f8054i = "";
        this.f8055j = "";
        this.f8056k = "";
    }

    public static Parcelable.Creator<PoiItem> getCreator() {
        return CREATOR;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.f8050e;
    }

    public String getAdname() {
        return this.f8056k;
    }

    public String getCity() {
        return this.f8055j;
    }

    public double getLatitude() {
        return this.f8051f;
    }

    public double getLongitude() {
        return this.f8052g;
    }

    public String getPoiId() {
        return this.f8047b;
    }

    public String getPoiName() {
        return this.f8046a;
    }

    public String getPoiType() {
        return this.f8048c;
    }

    public String getProvince() {
        return this.f8054i;
    }

    public String getTel() {
        return this.f8053h;
    }

    public String getTypeCode() {
        return this.f8049d;
    }

    public void setAddress(String str) {
        this.f8050e = str;
    }

    public void setAdname(String str) {
        this.f8056k = str;
    }

    public void setCity(String str) {
        this.f8055j = str;
    }

    public void setLatitude(double d10) {
        this.f8051f = d10;
    }

    public void setLongitude(double d10) {
        this.f8052g = d10;
    }

    public void setPoiId(String str) {
        this.f8047b = str;
    }

    public void setPoiName(String str) {
        this.f8046a = str;
    }

    public void setPoiType(String str) {
        this.f8048c = str;
    }

    public void setProvince(String str) {
        this.f8054i = str;
    }

    public void setTel(String str) {
        this.f8053h = str;
    }

    public void setTypeCode(String str) {
        this.f8049d = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8046a);
        parcel.writeString(this.f8047b);
        parcel.writeString(this.f8048c);
        parcel.writeString(this.f8049d);
        parcel.writeString(this.f8050e);
        parcel.writeDouble(this.f8051f);
        parcel.writeDouble(this.f8052g);
        parcel.writeString(this.f8053h);
        parcel.writeString(this.f8054i);
        parcel.writeString(this.f8055j);
        parcel.writeString(this.f8056k);
    }

    public PoiItem(Parcel parcel) {
        this.f8046a = "";
        this.f8047b = "";
        this.f8048c = "";
        this.f8049d = "";
        this.f8050e = "";
        this.f8051f = ShadowDrawableWrapper.COS_45;
        this.f8052g = ShadowDrawableWrapper.COS_45;
        this.f8053h = "";
        this.f8054i = "";
        this.f8055j = "";
        this.f8056k = "";
        this.f8046a = parcel.readString();
        this.f8047b = parcel.readString();
        this.f8048c = parcel.readString();
        this.f8049d = parcel.readString();
        this.f8050e = parcel.readString();
        this.f8051f = parcel.readDouble();
        this.f8052g = parcel.readDouble();
        this.f8053h = parcel.readString();
        this.f8054i = parcel.readString();
        this.f8055j = parcel.readString();
        this.f8056k = parcel.readString();
    }
}
