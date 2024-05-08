package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.p0003l.dq;
import com.amap.api.col.p0003l.dx;
import com.amap.api.col.p0003l.gy;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.huawei.quickcard.base.Attributes;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class CameraPosition implements Parcelable {
    private static final String CLASSNAME = "CameraPosition";
    public static final CameraPositionCreator CREATOR = new CameraPositionCreator();
    public final float bearing;
    public final boolean isAbroad;
    public final LatLng target;
    public final float tilt;
    public final float zoom;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class Builder {
        private float bearing;
        private LatLng target;
        private float tilt;
        private float zoom;

        public Builder() {
        }

        public final Builder bearing(float f10) {
            this.bearing = f10;
            return this;
        }

        public final CameraPosition build() {
            try {
                if (this.target == null) {
                    return null;
                }
                return new CameraPosition(this.target, this.zoom, this.tilt, this.bearing);
            } catch (Throwable th) {
                gy.b(th, CameraPosition.CLASSNAME, "build");
                return null;
            }
        }

        public final Builder target(LatLng latLng) {
            this.target = latLng;
            return this;
        }

        public final Builder tilt(float f10) {
            this.tilt = f10;
            return this;
        }

        public final Builder zoom(float f10) {
            this.zoom = f10;
            return this;
        }

        public Builder(CameraPosition cameraPosition) {
            target(cameraPosition.target).bearing(cameraPosition.bearing).tilt(cameraPosition.tilt).zoom(cameraPosition.zoom);
        }
    }

    public CameraPosition(LatLng latLng, float f10, float f11, float f12) {
        this.target = latLng;
        this.zoom = f10;
        this.tilt = f11;
        this.bearing = (((double) f12) <= ShadowDrawableWrapper.COS_45 ? (f12 % 360.0f) + 360.0f : f12) % 360.0f;
        if (latLng != null) {
            this.isAbroad = !dq.a(latLng.latitude, latLng.longitude);
        } else {
            this.isAbroad = false;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final CameraPosition fromLatLngZoom(LatLng latLng, float f10) {
        return new CameraPosition(latLng, f10, 0.0f, 0.0f);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        return this.target.equals(cameraPosition.target) && Float.floatToIntBits(this.zoom) == Float.floatToIntBits(cameraPosition.zoom) && Float.floatToIntBits(this.tilt) == Float.floatToIntBits(cameraPosition.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(cameraPosition.bearing);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final String toString() {
        return dx.a(dx.a(Attributes.Style.TARGET, this.target), dx.a("zoom", Float.valueOf(this.zoom)), dx.a("tilt", Float.valueOf(this.tilt)), dx.a("bearing", Float.valueOf(this.bearing)));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeFloat(this.bearing);
        parcel.writeFloat((float) this.target.latitude);
        parcel.writeFloat((float) this.target.longitude);
        parcel.writeFloat(this.tilt);
        parcel.writeFloat(this.zoom);
    }

    public static Builder builder(CameraPosition cameraPosition) {
        return new Builder(cameraPosition);
    }
}
