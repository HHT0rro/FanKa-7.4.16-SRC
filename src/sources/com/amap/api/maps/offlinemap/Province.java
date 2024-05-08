package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class Province implements Parcelable {
    public static final Parcelable.Creator<Province> CREATOR = new Parcelable.Creator<Province>() { // from class: com.amap.api.maps.offlinemap.Province.1
        private static Province a(Parcel parcel) {
            return new Province(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Province createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Province[] newArray(int i10) {
            return a(i10);
        }

        private static Province[] a(int i10) {
            return new Province[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f8307a;

    /* renamed from: b, reason: collision with root package name */
    private String f8308b;

    /* renamed from: c, reason: collision with root package name */
    private String f8309c;

    /* renamed from: d, reason: collision with root package name */
    private String f8310d;

    public Province() {
        this.f8307a = "";
        this.f8310d = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getJianpin() {
        return this.f8308b;
    }

    public String getPinyin() {
        return this.f8309c;
    }

    public String getProvinceCode() {
        return this.f8310d;
    }

    public String getProvinceName() {
        return this.f8307a;
    }

    public void setJianpin(String str) {
        this.f8308b = str;
    }

    public void setPinyin(String str) {
        this.f8309c = str;
    }

    public void setProvinceCode(String str) {
        this.f8310d = str;
    }

    public void setProvinceName(String str) {
        this.f8307a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8307a);
        parcel.writeString(this.f8308b);
        parcel.writeString(this.f8309c);
        parcel.writeString(this.f8310d);
    }

    public Province(Parcel parcel) {
        this.f8307a = "";
        this.f8310d = "";
        this.f8307a = parcel.readString();
        this.f8308b = parcel.readString();
        this.f8309c = parcel.readString();
        this.f8310d = parcel.readString();
    }
}
