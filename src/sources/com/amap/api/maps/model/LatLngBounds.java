package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.p0003l.dx;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LatLngBounds implements Parcelable {
    private static final String CLASSNAME = "LatLngBounds";
    public static final LatLngBoundsCreator CREATOR = new LatLngBoundsCreator();
    private final int mVersionCode;
    public final LatLng northeast;
    public final LatLng southwest;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class Builder {
        private double mSouth = Double.POSITIVE_INFINITY;
        private double mNorth = Double.NEGATIVE_INFINITY;
        private double mWest = Double.NaN;
        private double mEast = Double.NaN;

        private boolean a(double d10) {
            double d11 = this.mWest;
            double d12 = this.mEast;
            return d11 <= d12 ? d11 <= d10 && d10 <= d12 : d11 <= d10 || d10 <= d12;
        }

        public final LatLngBounds build() {
            if (Double.isNaN(this.mWest)) {
                return null;
            }
            double d10 = this.mWest;
            double d11 = this.mEast;
            if (d10 > d11) {
                this.mWest = d11;
                this.mEast = d10;
            }
            double d12 = this.mSouth;
            double d13 = this.mNorth;
            if (d12 > d13) {
                this.mSouth = d13;
                this.mNorth = d12;
            }
            return new LatLngBounds(new LatLng(this.mSouth, this.mWest, false), new LatLng(this.mNorth, this.mEast, false));
        }

        public final Builder include(LatLng latLng) {
            if (latLng == null) {
                return this;
            }
            this.mSouth = Math.min(this.mSouth, latLng.latitude);
            this.mNorth = Math.max(this.mNorth, latLng.latitude);
            double d10 = latLng.longitude;
            if (Double.isNaN(this.mWest)) {
                this.mWest = d10;
            } else {
                if (!a(d10)) {
                    if (LatLngBounds.c(this.mWest, d10) < LatLngBounds.d(this.mEast, d10)) {
                        this.mWest = d10;
                    }
                }
                return this;
            }
            this.mEast = d10;
            return this;
        }
    }

    public LatLngBounds(int i10, LatLng latLng, LatLng latLng2) {
        boolean z10;
        try {
        } catch (Throwable th) {
            th.printStackTrace();
            z10 = false;
        }
        if (latLng == null) {
            throw new RuntimeRemoteException("null southwest");
        }
        if (latLng2 == null) {
            throw new RuntimeRemoteException("null northeast");
        }
        if (latLng2.latitude < latLng.latitude) {
            throw new RuntimeRemoteException("southern latitude exceeds northern latitude (" + latLng.latitude + " > " + latLng2.latitude + ")");
        }
        z10 = true;
        this.mVersionCode = z10 ? i10 : 0;
        this.southwest = z10 ? latLng : null;
        this.northeast = z10 ? latLng2 : null;
    }

    public static Builder builder() {
        return new Builder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double c(double d10, double d11) {
        return ((d10 - d11) + 360.0d) % 360.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double d(double d10, double d11) {
        return ((d11 - d10) + 360.0d) % 360.0d;
    }

    public final boolean contains(LatLng latLng) {
        return (latLng == null || this.northeast == null || this.southwest == null || !a(latLng.latitude) || !b(latLng.longitude)) ? false : true;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        return this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast);
    }

    public final int hashCode() {
        return dx.a(new Object[]{this.southwest, this.northeast});
    }

    public final LatLngBounds including(LatLng latLng) {
        LatLng latLng2;
        double d10;
        if (latLng != null && this.northeast != null && (latLng2 = this.southwest) != null) {
            double min = Math.min(latLng2.latitude, latLng.latitude);
            double max = Math.max(this.northeast.latitude, latLng.latitude);
            double d11 = this.northeast.longitude;
            double d12 = this.southwest.longitude;
            double d13 = latLng.longitude;
            try {
                if (!b(d13)) {
                    if (c(d12, d13) >= d(d11, d13)) {
                        d10 = d13;
                        return new LatLngBounds(new LatLng(min, d12, false), new LatLng(max, d10, false));
                    }
                    d12 = d13;
                }
                return new LatLngBounds(new LatLng(min, d12, false), new LatLng(max, d10, false));
            } catch (Throwable th) {
                th.printStackTrace();
            }
            d10 = d11;
        }
        return this;
    }

    public final boolean intersects(LatLngBounds latLngBounds) {
        if (latLngBounds == null || this.northeast == null || this.southwest == null) {
            return false;
        }
        return a(latLngBounds) || latLngBounds.a(this);
    }

    public final String toString() {
        return dx.a(dx.a("southwest", this.southwest), dx.a("northeast", this.northeast));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        LatLngBoundsCreator.a(this, parcel, i10);
    }

    private boolean b(double d10) {
        double d11 = this.southwest.longitude;
        double d12 = this.northeast.longitude;
        return d11 <= d12 ? d11 <= d10 && d10 <= d12 : d11 <= d10 || d10 <= d12;
    }

    public final int a() {
        return this.mVersionCode;
    }

    private boolean a(LatLngBounds latLngBounds) {
        LatLng latLng;
        LatLng latLng2;
        if (latLngBounds == null || (latLng = latLngBounds.northeast) == null || (latLng2 = latLngBounds.southwest) == null) {
            return false;
        }
        double d10 = latLng.longitude;
        double d11 = latLng2.longitude;
        LatLng latLng3 = this.northeast;
        double d12 = latLng3.longitude;
        LatLng latLng4 = this.southwest;
        double d13 = latLng4.longitude;
        double d14 = ((d10 + d11) - d12) - d13;
        double d15 = ((d12 - d13) + d10) - d11;
        double d16 = latLng.latitude;
        double d17 = latLng2.latitude;
        double d18 = latLng3.latitude;
        double d19 = latLng4.latitude;
        return Math.abs(d14) < d15 && Math.abs(((d16 + d17) - d18) - d19) < ((d18 - d19) + d16) - d17;
    }

    public final boolean contains(LatLngBounds latLngBounds) {
        return latLngBounds != null && contains(latLngBounds.southwest) && contains(latLngBounds.northeast);
    }

    private boolean a(double d10) {
        return this.southwest.latitude <= d10 && d10 <= this.northeast.latitude;
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        this(1, latLng, latLng2);
    }
}
