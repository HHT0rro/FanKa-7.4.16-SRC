package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.base.ae.gmap.bean.TileProviderInner;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MVTTileOverlayOptions extends BaseOptions implements Parcelable {
    public static final Parcelable.Creator<MVTTileOverlayOptions> CREATOR = new Parcelable.Creator<MVTTileOverlayOptions>() { // from class: com.amap.api.maps.model.MVTTileOverlayOptions.1
        private static MVTTileOverlayOptions a(Parcel parcel) {
            TileProvider tileProvider = (TileProvider) parcel.readValue(TileProvider.class.getClassLoader());
            MVTTileOverlayOptions mVTTileOverlayOptions = new MVTTileOverlayOptions(parcel.readString(), parcel.readString(), parcel.readString());
            if (tileProvider != null) {
                mVTTileOverlayOptions.setTileProvider(tileProvider);
            }
            return mVTTileOverlayOptions;
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MVTTileOverlayOptions createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MVTTileOverlayOptions[] newArray(int i10) {
            return a(i10);
        }

        private static MVTTileOverlayOptions[] a(int i10) {
            return new MVTTileOverlayOptions[i10];
        }
    };

    @JBindingInclude
    private String layerId;
    private TileProvider tileProvider;

    @JBindingInclude
    private TileProviderInner tileProviderInner;

    @JBindingInclude
    private boolean visible;

    @JBindingInclude
    private float zIndex;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class Builder {

        /* renamed from: id, reason: collision with root package name */
        private String f8207id;
        private String key;
        private String url;
        private float zIndex = 0.0f;
        private boolean visible = true;

        public MVTTileOverlayOptions build() {
            MVTTileOverlayOptions mVTTileOverlayOptions = new MVTTileOverlayOptions(this.url, this.key, this.f8207id);
            mVTTileOverlayOptions.setZIndex(this.zIndex);
            mVTTileOverlayOptions.setVisible(this.visible);
            return mVTTileOverlayOptions;
        }

        public Builder id(String str) {
            this.f8207id = str;
            return this;
        }

        public Builder key(String str) {
            this.key = str;
            return this;
        }

        public Builder url(String str) {
            this.url = str;
            return this;
        }

        public Builder visible(boolean z10) {
            this.visible = z10;
            return this;
        }

        public Builder zIndex(float f10) {
            this.zIndex = f10;
            return this;
        }
    }

    public MVTTileOverlayOptions(String str, String str2, String str3) {
        this.type = "MVTTileOverlayOptions";
        MVTTileProvider mVTTileProvider = new MVTTileProvider(str, str2, str3);
        this.tileProvider = mVTTileProvider;
        this.tileProviderInner = new TileProviderInner(mVTTileProvider);
        this.layerId = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TileProviderInner getTileProviderInner() {
        return this.tileProviderInner;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public void setTileProvider(TileProvider tileProvider) {
        this.tileProvider = tileProvider;
    }

    public void setVisible(boolean z10) {
        this.visible = z10;
    }

    public void setZIndex(float f10) {
        this.zIndex = f10;
    }

    public boolean visible() {
        return this.visible;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeValue(this.tileProviderInner);
    }
}
