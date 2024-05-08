package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.base.amap.mapcore.jbinding.JBinding2cFieldOrMethod;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ArcOptions extends BaseOptions implements Parcelable, Cloneable {

    @JBindingExclude
    public static final ArcOptionsCreator CREATOR = new ArcOptionsCreator();

    /* renamed from: a, reason: collision with root package name */
    @JBindingExclude
    public String f8196a;
    private LatLng endpoint;
    private LatLng passedpoint;
    private LatLng startpoint;
    private float strokeWidth = 10.0f;
    private int strokeColor = -16777216;
    private float zIndex = 0.0f;
    private boolean isVisible = true;

    public ArcOptions() {
        this.type = "ArcOptions";
    }

    @Override // android.os.Parcelable
    @JBinding2cFieldOrMethod
    public final int describeContents() {
        return 0;
    }

    public final LatLng getEnd() {
        return this.endpoint;
    }

    public final LatLng getPassed() {
        return this.passedpoint;
    }

    public final LatLng getStart() {
        return this.startpoint;
    }

    public final int getStrokeColor() {
        return this.strokeColor;
    }

    public final float getStrokeWidth() {
        return this.strokeWidth;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final ArcOptions point(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        this.startpoint = latLng;
        this.passedpoint = latLng2;
        this.endpoint = latLng3;
        return this;
    }

    public final ArcOptions strokeColor(int i10) {
        this.strokeColor = i10;
        return this;
    }

    public final ArcOptions strokeWidth(float f10) {
        this.strokeWidth = f10;
        return this;
    }

    public final ArcOptions visible(boolean z10) {
        this.isVisible = z10;
        return this;
    }

    @Override // android.os.Parcelable
    @JBindingExclude
    public final void writeToParcel(Parcel parcel, int i10) {
        Bundle bundle = new Bundle();
        LatLng latLng = this.startpoint;
        if (latLng != null) {
            bundle.putDouble("startlat", latLng.latitude);
            bundle.putDouble("startlng", this.startpoint.longitude);
        }
        LatLng latLng2 = this.passedpoint;
        if (latLng2 != null) {
            bundle.putDouble("passedlat", latLng2.latitude);
            bundle.putDouble("passedlng", this.passedpoint.longitude);
        }
        LatLng latLng3 = this.endpoint;
        if (latLng3 != null) {
            bundle.putDouble("endlat", latLng3.latitude);
            bundle.putDouble("endlng", this.endpoint.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeFloat(this.strokeWidth);
        parcel.writeInt(this.strokeColor);
        parcel.writeFloat(this.zIndex);
        parcel.writeByte(this.isVisible ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f8196a);
    }

    public final ArcOptions zIndex(float f10) {
        this.zIndex = f10;
        return this;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final ArcOptions m1959clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
        }
        ArcOptions arcOptions = new ArcOptions();
        arcOptions.f8196a = this.f8196a;
        arcOptions.startpoint = this.startpoint;
        arcOptions.passedpoint = this.passedpoint;
        arcOptions.endpoint = this.endpoint;
        arcOptions.strokeWidth = this.strokeWidth;
        arcOptions.strokeColor = this.strokeColor;
        arcOptions.zIndex = this.zIndex;
        arcOptions.isVisible = this.isVisible;
        return arcOptions;
    }
}
