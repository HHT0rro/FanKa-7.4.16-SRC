package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class IndoorData implements Parcelable {
    public static final Parcelable.Creator<IndoorData> CREATOR = new Parcelable.Creator<IndoorData>() { // from class: com.amap.api.services.poisearch.IndoorData.1
        private static IndoorData a(Parcel parcel) {
            return new IndoorData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ IndoorData createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ IndoorData[] newArray(int i10) {
            return a(i10);
        }

        private static IndoorData[] a(int i10) {
            return new IndoorData[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f8615a;

    /* renamed from: b, reason: collision with root package name */
    private int f8616b;

    /* renamed from: c, reason: collision with root package name */
    private String f8617c;

    public IndoorData(String str, int i10, String str2) {
        this.f8615a = str;
        this.f8616b = i10;
        this.f8617c = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getFloor() {
        return this.f8616b;
    }

    public String getFloorName() {
        return this.f8617c;
    }

    public String getPoiId() {
        return this.f8615a;
    }

    public void setFloor(int i10) {
        this.f8616b = i10;
    }

    public void setFloorName(String str) {
        this.f8617c = str;
    }

    public void setPoiId(String str) {
        this.f8615a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8615a);
        parcel.writeInt(this.f8616b);
        parcel.writeString(this.f8617c);
    }

    public IndoorData(Parcel parcel) {
        this.f8615a = parcel.readString();
        this.f8616b = parcel.readInt();
        this.f8617c = parcel.readString();
    }
}
