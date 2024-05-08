package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.AMapException;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LatLng implements Parcelable, Cloneable {

    @JBindingExclude
    public static final LatLngCreator CREATOR = new LatLngCreator();
    public final double latitude;
    public final double longitude;

    public LatLng(double d10, double d11) {
        this(d10, d11, true);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLng)) {
            return false;
        }
        LatLng latLng = (LatLng) obj;
        return Double.doubleToLongBits(this.latitude) == Double.doubleToLongBits(latLng.latitude) && Double.doubleToLongBits(this.longitude) == Double.doubleToLongBits(latLng.longitude);
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.latitude);
        int i10 = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.longitude);
        return (i10 * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public final String toString() {
        return "lat/lng: (" + this.latitude + "," + this.longitude + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeDouble(this.longitude);
        parcel.writeDouble(this.latitude);
    }

    @JBindingExclude
    public LatLng(double d10, double d11, boolean z10) {
        if (z10) {
            if (-180.0d <= d11 && d11 < 180.0d) {
                this.longitude = d11;
            } else {
                this.longitude = ((((d11 - 180.0d) % 360.0d) + 360.0d) % 360.0d) - 180.0d;
            }
            if (d10 < -90.0d || d10 > 90.0d) {
                try {
                    throw new AMapException(AMapException.ERROR_ILLEGAL_VALUE);
                } catch (AMapException e2) {
                    e2.printStackTrace();
                }
            }
            this.latitude = Math.max(-90.0d, Math.min(90.0d, d10));
            return;
        }
        this.latitude = d10;
        this.longitude = d11;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final LatLng m1964clone() {
        return new LatLng(this.latitude, this.longitude);
    }
}
