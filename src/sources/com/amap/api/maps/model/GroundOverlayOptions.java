package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class GroundOverlayOptions extends BaseOptions implements Parcelable, Cloneable {

    @JBindingExclude
    private static final String CLASSNAME = "GroundOverlayOptions";

    @JBindingExclude
    public static final GroundOverlayOptionsCreator CREATOR = new GroundOverlayOptionsCreator();

    @JBindingExclude
    public static final float NO_DIMENSION = -1.0f;

    @JBindingExclude
    private final double NF_PI;

    @JBindingExclude
    private final double R;
    private float anchorU;
    private float anchorV;
    private float bearing;
    private BitmapDescriptor bitmapDescriptor;
    private float height;
    private boolean isVisible;
    private LatLng latLng;

    @JBindingExclude
    private LatLngBounds latlngBounds;

    @JBindingExclude
    private final int mVersionCode;
    private LatLng northeast;
    private LatLng southwest;
    private float transparency;
    private float width;
    private float zIndex;

    @JBindingExclude
    public GroundOverlayOptions(int i10, LatLng latLng, float f10, float f11, LatLngBounds latLngBounds, float f12, float f13, boolean z10, float f14, float f15, float f16) {
        this.zIndex = 0.0f;
        this.isVisible = true;
        this.transparency = 0.0f;
        this.anchorU = 0.5f;
        this.anchorV = 0.5f;
        this.NF_PI = 0.01745329251994329d;
        this.R = 6371000.79d;
        this.mVersionCode = i10;
        this.bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(null);
        this.latLng = latLng;
        this.width = f10;
        this.height = f11;
        this.latlngBounds = latLngBounds;
        this.bearing = f12;
        this.zIndex = f13;
        this.isVisible = z10;
        this.transparency = f14;
        this.anchorU = f15;
        this.anchorV = f16;
        this.southwest = latLngBounds.southwest;
        this.northeast = latLngBounds.northeast;
        this.type = CLASSNAME;
    }

    private GroundOverlayOptions a(LatLng latLng, float f10, float f11) {
        this.latLng = latLng;
        this.width = f10;
        this.height = f11;
        b();
        return this;
    }

    private void b() {
        LatLng latLng = this.latLng;
        if (latLng == null) {
            return;
        }
        double cos = this.width / ((Math.cos(latLng.latitude * 0.01745329251994329d) * 6371000.79d) * 0.01745329251994329d);
        double d10 = this.height / 111194.94043265979d;
        try {
            LatLng latLng2 = this.latLng;
            LatLng latLng3 = new LatLng(latLng2.latitude - ((1.0f - this.anchorV) * d10), latLng2.longitude - (this.anchorU * cos));
            LatLng latLng4 = this.latLng;
            LatLngBounds latLngBounds = new LatLngBounds(latLng3, new LatLng(latLng4.latitude + (this.anchorV * d10), latLng4.longitude + ((1.0f - this.anchorU) * cos)));
            this.latlngBounds = latLngBounds;
            this.southwest = latLngBounds.southwest;
            this.northeast = latLngBounds.northeast;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final GroundOverlayOptions anchor(float f10, float f11) {
        this.anchorU = f10;
        this.anchorV = f11;
        if (this.latlngBounds != null) {
            a();
        } else if (this.latLng != null) {
            b();
        }
        return this;
    }

    public final GroundOverlayOptions bearing(float f10) {
        this.bearing = f10;
        return this;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final float getAnchorU() {
        return this.anchorU;
    }

    public final float getAnchorV() {
        return this.anchorV;
    }

    public final float getBearing() {
        return this.bearing;
    }

    public final LatLngBounds getBounds() {
        return this.latlngBounds;
    }

    public final float getHeight() {
        return this.height;
    }

    public final BitmapDescriptor getImage() {
        return this.bitmapDescriptor;
    }

    public final LatLng getLocation() {
        return this.latLng;
    }

    public final float getTransparency() {
        return this.transparency;
    }

    public final float getWidth() {
        return this.width;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    public final GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor) {
        this.bitmapDescriptor = bitmapDescriptor;
        return this;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final GroundOverlayOptions position(LatLng latLng, float f10) {
        return a(latLng, f10, f10);
    }

    public final GroundOverlayOptions positionFromBounds(LatLngBounds latLngBounds) {
        this.latlngBounds = latLngBounds;
        this.southwest = latLngBounds.southwest;
        this.northeast = latLngBounds.northeast;
        a();
        return this;
    }

    public final GroundOverlayOptions transparency(float f10) {
        if (f10 < 0.0f) {
            f10 = 0.0f;
        }
        this.transparency = f10;
        return this;
    }

    public final GroundOverlayOptions visible(boolean z10) {
        this.isVisible = z10;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mVersionCode);
        parcel.writeParcelable(this.bitmapDescriptor, i10);
        parcel.writeParcelable(this.latLng, i10);
        parcel.writeFloat(this.width);
        parcel.writeFloat(this.height);
        parcel.writeParcelable(this.latlngBounds, i10);
        parcel.writeFloat(this.bearing);
        parcel.writeFloat(this.zIndex);
        parcel.writeByte(this.isVisible ? (byte) 1 : (byte) 0);
        parcel.writeFloat(this.transparency);
        parcel.writeFloat(this.anchorU);
        parcel.writeFloat(this.anchorV);
    }

    public final GroundOverlayOptions zIndex(float f10) {
        this.zIndex = f10;
        return this;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final GroundOverlayOptions m1963clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
        }
        GroundOverlayOptions groundOverlayOptions = new GroundOverlayOptions();
        groundOverlayOptions.bitmapDescriptor = this.bitmapDescriptor;
        groundOverlayOptions.latLng = this.latLng;
        groundOverlayOptions.width = this.width;
        groundOverlayOptions.height = this.height;
        groundOverlayOptions.latlngBounds = this.latlngBounds;
        groundOverlayOptions.bearing = this.bearing;
        groundOverlayOptions.zIndex = this.zIndex;
        groundOverlayOptions.isVisible = this.isVisible;
        groundOverlayOptions.transparency = this.transparency;
        groundOverlayOptions.anchorU = this.anchorU;
        groundOverlayOptions.anchorV = this.anchorV;
        groundOverlayOptions.southwest = this.southwest;
        groundOverlayOptions.northeast = this.northeast;
        return groundOverlayOptions;
    }

    public final GroundOverlayOptions position(LatLng latLng, float f10, float f11) {
        if (f10 > 0.0f) {
            int i10 = (f11 > 0.0f ? 1 : (f11 == 0.0f ? 0 : -1));
        }
        return a(latLng, f10, f11);
    }

    private void a() {
        if (this.southwest == null || this.northeast == null) {
            return;
        }
        LatLng latLng = this.southwest;
        double d10 = latLng.latitude;
        double d11 = 1.0f - this.anchorV;
        LatLng latLng2 = this.northeast;
        double d12 = d10 + (d11 * (latLng2.latitude - d10));
        double d13 = latLng.longitude;
        LatLng latLng3 = new LatLng(d12, d13 + (this.anchorU * (latLng2.longitude - d13)));
        this.latLng = latLng3;
        double cos = Math.cos(latLng3.latitude * 0.01745329251994329d) * 6371000.79d;
        LatLng latLng4 = this.northeast;
        double d14 = latLng4.longitude;
        LatLng latLng5 = this.southwest;
        this.width = (float) (cos * (d14 - latLng5.longitude) * 0.01745329251994329d);
        this.height = (float) ((latLng4.latitude - latLng5.latitude) * 6371000.79d * 0.01745329251994329d);
    }

    public GroundOverlayOptions() {
        this.zIndex = 0.0f;
        this.isVisible = true;
        this.transparency = 0.0f;
        this.anchorU = 0.5f;
        this.anchorV = 0.5f;
        this.NF_PI = 0.01745329251994329d;
        this.R = 6371000.79d;
        this.mVersionCode = 1;
        this.type = CLASSNAME;
    }
}
