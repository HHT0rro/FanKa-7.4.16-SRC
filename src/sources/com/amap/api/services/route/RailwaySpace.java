package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class RailwaySpace implements Parcelable {
    public static final Parcelable.Creator<RailwaySpace> CREATOR = new Parcelable.Creator<RailwaySpace>() { // from class: com.amap.api.services.route.RailwaySpace.1
        private static RailwaySpace a(Parcel parcel) {
            return new RailwaySpace(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RailwaySpace createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RailwaySpace[] newArray(int i10) {
            return a(i10);
        }

        private static RailwaySpace[] a(int i10) {
            return new RailwaySpace[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f8838a;

    /* renamed from: b, reason: collision with root package name */
    private float f8839b;

    public RailwaySpace(String str, float f10) {
        this.f8838a = str;
        this.f8839b = f10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCode() {
        return this.f8838a;
    }

    public float getCost() {
        return this.f8839b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8838a);
        parcel.writeFloat(this.f8839b);
    }

    public RailwaySpace(Parcel parcel) {
        this.f8838a = parcel.readString();
        this.f8839b = parcel.readFloat();
    }
}
