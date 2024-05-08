package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.base.ae.gmap.bean.TileProviderInner;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class TileOverlayOptions extends BaseOptions implements Parcelable {
    public static final TileOverlayOptionsCreator CREATOR = new TileOverlayOptionsCreator();
    private TileProvider _tileProvider;

    @JBindingInclude
    private String diskCacheDir;

    @JBindingInclude
    private boolean diskCacheEnabled;

    @JBindingInclude
    private long diskCacheSize;

    @JBindingInclude
    private TileProviderInner mTileProvider;
    private final int mVersionCode;

    @JBindingInclude
    private boolean mVisible;

    @JBindingInclude
    private float mZIndex;

    @JBindingInclude
    private int memCacheSize;

    @JBindingInclude
    private boolean memoryCacheEnabled;

    public TileOverlayOptions() {
        this.mVisible = true;
        this.memCacheSize = 5242880;
        this.diskCacheSize = 20971520L;
        this.diskCacheDir = null;
        this.memoryCacheEnabled = true;
        this.diskCacheEnabled = true;
        this.mVersionCode = 1;
        this.type = "TileOverlayOptions";
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final TileOverlayOptions diskCacheDir(String str) {
        this.diskCacheDir = str;
        return this;
    }

    public final TileOverlayOptions diskCacheEnabled(boolean z10) {
        this.diskCacheEnabled = z10;
        return this;
    }

    public final TileOverlayOptions diskCacheSize(int i10) {
        this.diskCacheSize = i10 * 1024;
        return this;
    }

    public final String getDiskCacheDir() {
        return this.diskCacheDir;
    }

    public final boolean getDiskCacheEnabled() {
        return this.diskCacheEnabled;
    }

    public final long getDiskCacheSize() {
        return this.diskCacheSize;
    }

    public final int getMemCacheSize() {
        return this.memCacheSize;
    }

    public final boolean getMemoryCacheEnabled() {
        return this.memoryCacheEnabled;
    }

    public final TileProvider getTileProvider() {
        return this._tileProvider;
    }

    public final TileProviderInner getTileProviderInner() {
        return this.mTileProvider;
    }

    public final float getZIndex() {
        return this.mZIndex;
    }

    public final boolean isVisible() {
        return this.mVisible;
    }

    public final TileOverlayOptions memCacheSize(int i10) {
        this.memCacheSize = i10;
        return this;
    }

    public final TileOverlayOptions memoryCacheEnabled(boolean z10) {
        this.memoryCacheEnabled = z10;
        return this;
    }

    public final TileOverlayOptions tileProvider(TileProvider tileProvider) {
        this._tileProvider = tileProvider;
        this.mTileProvider = new TileProviderInner(tileProvider);
        return this;
    }

    public final TileOverlayOptions visible(boolean z10) {
        this.mVisible = z10;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mVersionCode);
        parcel.writeValue(this.mTileProvider);
        parcel.writeByte(this.mVisible ? (byte) 1 : (byte) 0);
        parcel.writeFloat(this.mZIndex);
        parcel.writeInt(this.memCacheSize);
        parcel.writeLong(this.diskCacheSize);
        parcel.writeString(this.diskCacheDir);
        parcel.writeByte(this.memoryCacheEnabled ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.diskCacheEnabled ? (byte) 1 : (byte) 0);
    }

    public final TileOverlayOptions zIndex(float f10) {
        this.mZIndex = f10;
        return this;
    }

    public TileOverlayOptions(int i10, boolean z10, float f10) {
        this.memCacheSize = 5242880;
        this.diskCacheSize = 20971520L;
        this.diskCacheDir = null;
        this.memoryCacheEnabled = true;
        this.diskCacheEnabled = true;
        this.mVersionCode = i10;
        this.mVisible = z10;
        this.mZIndex = f10;
        this.type = "TileOverlayOptions";
    }
}
