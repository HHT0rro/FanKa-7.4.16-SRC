package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class LatLonPoint implements Parcelable {
    public static final Parcelable.Creator<LatLonPoint> CREATOR = new Parcelable.Creator<LatLonPoint>() { // from class: com.amap.api.services.core.LatLonPoint.1
        private static LatLonPoint a(Parcel parcel) {
            return new LatLonPoint(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LatLonPoint createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LatLonPoint[] newArray(int i10) {
            return a(i10);
        }

        private static LatLonPoint[] a(int i10) {
            return new LatLonPoint[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private double f8435a;

    /* renamed from: b, reason: collision with root package name */
    private double f8436b;

    public LatLonPoint(double d10, double d11) {
        this.f8435a = d10;
        this.f8436b = d11;
    }

    public LatLonPoint copy() {
        return new LatLonPoint(this.f8435a, this.f8436b);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LatLonPoint latLonPoint = (LatLonPoint) obj;
        return Double.doubleToLongBits(this.f8435a) == Double.doubleToLongBits(latLonPoint.f8435a) && Double.doubleToLongBits(this.f8436b) == Double.doubleToLongBits(latLonPoint.f8436b);
    }

    public double getLatitude() {
        return this.f8435a;
    }

    public double getLongitude() {
        return this.f8436b;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f8435a);
        int i10 = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.f8436b);
        return (i10 * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public void setLatitude(double d10) {
        this.f8435a = d10;
    }

    public void setLongitude(double d10) {
        this.f8436b = d10;
    }

    public String toString() {
        return this.f8435a + "," + this.f8436b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeDouble(this.f8435a);
        parcel.writeDouble(this.f8436b);
    }

    public LatLonPoint(Parcel parcel) {
        this.f8435a = parcel.readDouble();
        this.f8436b = parcel.readDouble();
    }
}
