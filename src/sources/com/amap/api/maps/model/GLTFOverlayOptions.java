package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.ArrayList;
import java.util.List;

@JBindingInclude
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class GLTFOverlayOptions extends BaseOptions implements Parcelable, Cloneable {

    @JBindingExclude
    public static final GLTFOverlayOptionsCreator CREATOR = new GLTFOverlayOptionsCreator();
    private int currentAnimationIndex;
    private BitmapDescriptor infoWindowView;
    private boolean isClick;
    private boolean isClickable;
    private boolean isDraggable;
    private boolean isGlbFormat;
    private double mAltitude;
    private LatLng mLatLng;
    private byte[] mModelData;
    private double mScale;
    private List<GLTFResourceIterm> mUriResources;
    private double mXDegree;
    private double mYDegree;
    private double mZDegree;
    private float maxZoom;
    private float minZoom;
    private String title;
    private float zIndex;

    public GLTFOverlayOptions() {
        this.mLatLng = new LatLng(ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45);
        this.mZDegree = ShadowDrawableWrapper.COS_45;
        this.mXDegree = ShadowDrawableWrapper.COS_45;
        this.mYDegree = ShadowDrawableWrapper.COS_45;
        this.mAltitude = ShadowDrawableWrapper.COS_45;
        this.mScale = 1.0d;
        this.mUriResources = new ArrayList();
        this.isClickable = false;
        this.isDraggable = false;
        this.isClick = false;
        this.currentAnimationIndex = 0;
        this.minZoom = 3.0f;
        this.maxZoom = 20.0f;
        this.isGlbFormat = false;
        this.zIndex = 0.0f;
        this.type = "GLTFOverlayOptions";
    }

    public GLTFOverlayOptions altitude(double d10) {
        this.mAltitude = d10;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public double getAltitude() {
        return this.mAltitude;
    }

    public int getCurrentAnimationIndex() {
        return this.currentAnimationIndex;
    }

    public BitmapDescriptor getInfoWindowView() {
        return this.infoWindowView;
    }

    public LatLng getLatLng() {
        return this.mLatLng;
    }

    public float getMaxZoom() {
        return this.maxZoom;
    }

    public float getMinZoom() {
        return this.minZoom;
    }

    public byte[] getModelData() {
        return this.mModelData;
    }

    public double getScale() {
        return this.mScale;
    }

    public List<GLTFResourceIterm> getUriResources() {
        return this.mUriResources;
    }

    public double getXDegree() {
        return this.mXDegree;
    }

    public double getYDegree() {
        return this.mYDegree;
    }

    public double getZDegree() {
        return this.mZDegree;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public void glbFormat(boolean z10) {
        this.isGlbFormat = z10;
    }

    public void infoWindowView(BitmapDescriptor bitmapDescriptor) {
        this.infoWindowView = bitmapDescriptor;
    }

    public boolean isClickable() {
        return this.isClickable;
    }

    public boolean isDraggable() {
        return this.isDraggable;
    }

    public boolean isGlbFormat() {
        return this.isGlbFormat;
    }

    public boolean isInfoWindowShow() {
        return this.isClick;
    }

    public GLTFOverlayOptions latLng(LatLng latLng) {
        this.mLatLng = latLng;
        return this;
    }

    public GLTFOverlayOptions modelData(byte[] bArr) {
        if (bArr != null) {
            this.mModelData = bArr;
        }
        return this;
    }

    public GLTFOverlayOptions rotationDegree(double d10, double d11, double d12) {
        this.mXDegree = d10;
        this.mYDegree = d11;
        this.mZDegree = d12;
        return this;
    }

    public GLTFOverlayOptions scale(double d10) {
        this.mScale = d10;
        return this;
    }

    public void setClickable(boolean z10) {
        this.isClickable = z10;
    }

    public void setCurrentAnimationIndex(int i10) {
        this.currentAnimationIndex = i10;
    }

    public void setDraggable(boolean z10) {
        this.isDraggable = z10;
    }

    public void setZIndex(float f10) {
        this.zIndex = f10;
    }

    public void setZoomRange(float f10, float f11) {
        this.minZoom = f10;
        this.maxZoom = f11;
    }

    public void tapClick() {
        this.isClick = !this.isClick;
    }

    public GLTFOverlayOptions uriResources(List<GLTFResourceIterm> list) {
        this.mUriResources = list;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.mLatLng, i10);
        parcel.writeDouble(this.mZDegree);
        parcel.writeDouble(this.mXDegree);
        parcel.writeDouble(this.mYDegree);
        parcel.writeDouble(this.mAltitude);
        parcel.writeDouble(this.mScale);
        parcel.writeByteArray(this.mModelData);
        parcel.writeList(this.mUriResources);
        parcel.writeBooleanArray(new boolean[]{this.isClickable, this.isDraggable, this.isGlbFormat});
        BitmapDescriptor bitmapDescriptor = this.infoWindowView;
        if (bitmapDescriptor != null) {
            parcel.writeParcelable(bitmapDescriptor, i10);
        }
        String str = this.title;
        if (str != null) {
            parcel.writeString(str);
        }
        parcel.writeInt(this.currentAnimationIndex);
        parcel.writeFloat(this.minZoom);
        parcel.writeFloat(this.maxZoom);
        parcel.writeFloat(this.zIndex);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public GLTFOverlayOptions m1962clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
        }
        GLTFOverlayOptions gLTFOverlayOptions = new GLTFOverlayOptions();
        gLTFOverlayOptions.mLatLng = this.mLatLng.m1964clone();
        gLTFOverlayOptions.mZDegree = this.mZDegree;
        gLTFOverlayOptions.mXDegree = this.mXDegree;
        gLTFOverlayOptions.mYDegree = this.mYDegree;
        gLTFOverlayOptions.mAltitude = this.mAltitude;
        gLTFOverlayOptions.mScale = this.mScale;
        gLTFOverlayOptions.mModelData = this.mModelData;
        gLTFOverlayOptions.mUriResources = this.mUriResources;
        gLTFOverlayOptions.isClickable = this.isClickable;
        gLTFOverlayOptions.isDraggable = this.isDraggable;
        BitmapDescriptor bitmapDescriptor = this.infoWindowView;
        if (bitmapDescriptor != null) {
            gLTFOverlayOptions.infoWindowView = bitmapDescriptor.m1960clone();
        }
        String str = this.title;
        if (str != null) {
            gLTFOverlayOptions.title = str;
        }
        gLTFOverlayOptions.currentAnimationIndex = this.currentAnimationIndex;
        gLTFOverlayOptions.minZoom = this.minZoom;
        gLTFOverlayOptions.maxZoom = this.maxZoom;
        gLTFOverlayOptions.isGlbFormat = this.isGlbFormat;
        gLTFOverlayOptions.zIndex = this.zIndex;
        return gLTFOverlayOptions;
    }

    @JBindingExclude
    public GLTFOverlayOptions(LatLng latLng, double d10, double d11, String str, List<GLTFResourceIterm> list) {
        this.mLatLng = new LatLng(ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45);
        this.mZDegree = ShadowDrawableWrapper.COS_45;
        this.mXDegree = ShadowDrawableWrapper.COS_45;
        this.mYDegree = ShadowDrawableWrapper.COS_45;
        this.mAltitude = ShadowDrawableWrapper.COS_45;
        this.mScale = 1.0d;
        this.mUriResources = new ArrayList();
        this.isClickable = false;
        this.isDraggable = false;
        this.isClick = false;
        this.currentAnimationIndex = 0;
        this.minZoom = 3.0f;
        this.maxZoom = 20.0f;
        this.isGlbFormat = false;
        this.zIndex = 0.0f;
        this.mLatLng = latLng;
        this.mAltitude = d10;
        this.mScale = d11;
        if (str != null) {
            this.mModelData = str.getBytes();
        } else {
            this.mModelData = "".getBytes();
        }
        this.mUriResources = list;
    }

    @JBindingExclude
    public GLTFOverlayOptions(Parcel parcel) {
        this.mLatLng = new LatLng(ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45);
        this.mZDegree = ShadowDrawableWrapper.COS_45;
        this.mXDegree = ShadowDrawableWrapper.COS_45;
        this.mYDegree = ShadowDrawableWrapper.COS_45;
        this.mAltitude = ShadowDrawableWrapper.COS_45;
        this.mScale = 1.0d;
        this.mUriResources = new ArrayList();
        this.isClickable = false;
        this.isDraggable = false;
        this.isClick = false;
        this.currentAnimationIndex = 0;
        this.minZoom = 3.0f;
        this.maxZoom = 20.0f;
        this.isGlbFormat = false;
        this.zIndex = 0.0f;
        this.mLatLng = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.mZDegree = parcel.readDouble();
        this.mXDegree = parcel.readDouble();
        this.mYDegree = parcel.readDouble();
        this.mAltitude = parcel.readDouble();
        this.mScale = parcel.readDouble();
        parcel.readByteArray(this.mModelData);
        this.mUriResources = parcel.readArrayList(GLTFResourceIterm.class.getClassLoader());
        boolean[] zArr = new boolean[3];
        parcel.readBooleanArray(zArr);
        this.isClickable = zArr[0];
        this.isDraggable = zArr[1];
        this.isGlbFormat = zArr[2];
        this.infoWindowView = (BitmapDescriptor) parcel.readParcelable(BitmapDescriptor.class.getClassLoader());
        this.title = parcel.readString();
        this.currentAnimationIndex = parcel.readInt();
        this.minZoom = parcel.readFloat();
        this.maxZoom = parcel.readFloat();
        this.zIndex = parcel.readFloat();
    }
}
