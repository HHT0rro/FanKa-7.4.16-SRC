package com.amap.api.maps.model;

import android.os.RemoteException;
import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.autonavi.base.ae.gmap.bean.TileProviderInner;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class TileOverlay extends BaseOverlay {
    public WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    public TileOverlayOptions options;

    public TileOverlay(IGlOverlayLayer iGlOverlayLayer, TileOverlayOptions tileOverlayOptions, String str) {
        super(str);
        TileProviderInner tileProviderInner;
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.options = tileOverlayOptions;
        if (tileOverlayOptions == null || (tileProviderInner = tileOverlayOptions.getTileProviderInner()) == null) {
            return;
        }
        tileProviderInner.init(iGlOverlayLayer, str);
    }

    public final Object callNativeFunction(String str, Object[] objArr) {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return null;
            }
            return iGlOverlayLayer.getNativeProperties(this.overlayName, str, objArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public final void clearTileCache() {
        callNativeFunction("clearTileCache", null);
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof TileOverlay)) {
            try {
                TileOverlayOptions tileOverlayOptions = this.options;
                if (tileOverlayOptions != null && tileOverlayOptions.equals(((TileOverlay) obj).options)) {
                    if (this.overlayName.equals(((TileOverlay) obj).overlayName)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public final String getId() {
        return this.overlayName;
    }

    public final float getZIndex() {
        return this.options.getZIndex();
    }

    public final int hashCode() {
        if (this.options != null) {
            String str = this.overlayName;
            return (((str == null ? 0 : str.hashCode()) + 31) * 31) + this.options.hashCode();
        }
        return super.hashCode();
    }

    public final boolean isVisible() {
        return this.options.isVisible();
    }

    public final void remove() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    public final void setVisible(boolean z10) {
        this.options.visible(z10);
        updateOption();
    }

    public final void setZIndex(float f10) {
        this.options.zIndex(f10);
        updateOption();
    }

    public final void updateOption() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return;
            }
            iGlOverlayLayer.updateOption(this.overlayName, this.options);
        } catch (Throwable unused) {
        }
    }
}
