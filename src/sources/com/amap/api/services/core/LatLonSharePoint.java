package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class LatLonSharePoint extends LatLonPoint {
    public static final Parcelable.Creator<LatLonSharePoint> CREATOR = new Parcelable.Creator<LatLonSharePoint>() { // from class: com.amap.api.services.core.LatLonSharePoint.1
        private static LatLonSharePoint a(Parcel parcel) {
            return new LatLonSharePoint(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LatLonSharePoint createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LatLonSharePoint[] newArray(int i10) {
            return a(i10);
        }

        private static LatLonSharePoint[] a(int i10) {
            return new LatLonSharePoint[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f8437a;

    public LatLonSharePoint(double d10, double d11, String str) {
        super(d10, d11);
        this.f8437a = str;
    }

    @Override // com.amap.api.services.core.LatLonPoint, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.amap.api.services.core.LatLonPoint
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        LatLonSharePoint latLonSharePoint = (LatLonSharePoint) obj;
        String str = this.f8437a;
        if (str == null) {
            if (latLonSharePoint.f8437a != null) {
                return false;
            }
        } else if (!str.equals(latLonSharePoint.f8437a)) {
            return false;
        }
        return true;
    }

    public String getSharePointName() {
        return this.f8437a;
    }

    @Override // com.amap.api.services.core.LatLonPoint
    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.f8437a;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public void setSharePointName(String str) {
        this.f8437a = str;
    }

    @Override // com.amap.api.services.core.LatLonPoint
    public String toString() {
        return super.toString() + "," + this.f8437a;
    }

    @Override // com.amap.api.services.core.LatLonPoint, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeString(this.f8437a);
    }

    public LatLonSharePoint(Parcel parcel) {
        super(parcel);
        this.f8437a = parcel.readString();
    }
}
