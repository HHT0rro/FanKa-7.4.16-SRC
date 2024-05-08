package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class City implements Parcelable {
    public static final Parcelable.Creator<City> CREATOR = new Parcelable.Creator<City>() { // from class: com.amap.api.maps.offlinemap.City.1
        private static City a(Parcel parcel) {
            return new City(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ City createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ City[] newArray(int i10) {
            return a(i10);
        }

        private static City[] a(int i10) {
            return new City[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f8257a;

    /* renamed from: b, reason: collision with root package name */
    private String f8258b;

    /* renamed from: c, reason: collision with root package name */
    private String f8259c;

    /* renamed from: d, reason: collision with root package name */
    private String f8260d;

    /* renamed from: e, reason: collision with root package name */
    private String f8261e;

    public City() {
        this.f8257a = "";
        this.f8258b = "";
        this.f8261e = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdcode() {
        return this.f8261e;
    }

    public String getCity() {
        return this.f8257a;
    }

    public String getCode() {
        return this.f8258b;
    }

    public String getJianpin() {
        return this.f8259c;
    }

    public String getPinyin() {
        return this.f8260d;
    }

    public void setAdcode(String str) {
        this.f8261e = str;
    }

    public void setCity(String str) {
        this.f8257a = str;
    }

    public void setCode(String str) {
        if (str == null || "[]".equals(str)) {
            return;
        }
        this.f8258b = str;
    }

    public void setJianpin(String str) {
        this.f8259c = str;
    }

    public void setPinyin(String str) {
        this.f8260d = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8257a);
        parcel.writeString(this.f8258b);
        parcel.writeString(this.f8259c);
        parcel.writeString(this.f8260d);
        parcel.writeString(this.f8261e);
    }

    public City(Parcel parcel) {
        this.f8257a = "";
        this.f8258b = "";
        this.f8261e = "";
        this.f8257a = parcel.readString();
        this.f8258b = parcel.readString();
        this.f8259c = parcel.readString();
        this.f8260d = parcel.readString();
        this.f8261e = parcel.readString();
    }
}
