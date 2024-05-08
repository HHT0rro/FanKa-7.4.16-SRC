package com.amap.api.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.shadow.ShadowDrawableWrapper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class DPoint implements Parcelable {
    public static final Parcelable.Creator<DPoint> CREATOR = new Parcelable.Creator<DPoint>() { // from class: com.amap.api.location.DPoint.1
        private static DPoint a(Parcel parcel) {
            return new DPoint(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DPoint createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DPoint[] newArray(int i10) {
            return a(i10);
        }

        private static DPoint[] a(int i10) {
            return new DPoint[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private double f8142a;

    /* renamed from: b, reason: collision with root package name */
    private double f8143b;

    public DPoint() {
        this.f8142a = ShadowDrawableWrapper.COS_45;
        this.f8143b = ShadowDrawableWrapper.COS_45;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DPoint)) {
            return false;
        }
        DPoint dPoint = (DPoint) obj;
        return this.f8143b == dPoint.f8143b && this.f8142a == dPoint.f8142a;
    }

    public double getLatitude() {
        return this.f8143b;
    }

    public double getLongitude() {
        return this.f8142a;
    }

    public int hashCode() {
        return Double.valueOf((this.f8143b + this.f8142a) * 1000000.0d).intValue();
    }

    public void setLatitude(double d10) {
        if (d10 > 90.0d) {
            d10 = 90.0d;
        }
        if (d10 < -90.0d) {
            d10 = -90.0d;
        }
        this.f8143b = d10;
    }

    public void setLongitude(double d10) {
        if (d10 > 180.0d) {
            d10 = 180.0d;
        }
        if (d10 < -180.0d) {
            d10 = -180.0d;
        }
        this.f8142a = d10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeDouble(this.f8142a);
        parcel.writeDouble(this.f8143b);
    }

    public DPoint(double d10, double d11) {
        this.f8142a = ShadowDrawableWrapper.COS_45;
        this.f8143b = ShadowDrawableWrapper.COS_45;
        d11 = d11 > 180.0d ? 180.0d : d11;
        d11 = d11 < -180.0d ? -180.0d : d11;
        d10 = d10 > 90.0d ? 90.0d : d10;
        d10 = d10 < -90.0d ? -90.0d : d10;
        this.f8142a = d11;
        this.f8143b = d10;
    }

    public DPoint(Parcel parcel) {
        this.f8142a = ShadowDrawableWrapper.COS_45;
        this.f8143b = ShadowDrawableWrapper.COS_45;
        this.f8142a = parcel.readDouble();
        this.f8143b = parcel.readDouble();
    }
}
