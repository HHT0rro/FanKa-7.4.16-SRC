package com.amap.api.maps.model;

import android.os.RemoteException;
import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MVTTileOverlay extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private MVTTileOverlayOptions mMVTTileOverlayOptions;

    public MVTTileOverlay(IGlOverlayLayer iGlOverlayLayer, MVTTileOverlayOptions mVTTileOverlayOptions, String str) {
        super(str);
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.mMVTTileOverlayOptions = mVTTileOverlayOptions;
        if (mVTTileOverlayOptions != null) {
            mVTTileOverlayOptions.getTileProviderInner().init(iGlOverlayLayer, str);
        }
    }

    public final float getZIndex() {
        return this.mMVTTileOverlayOptions.getZIndex();
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
        this.mMVTTileOverlayOptions.setVisible(z10);
        updateOption();
    }

    public final void setZIndex(float f10) {
        this.mMVTTileOverlayOptions.setZIndex(f10);
        updateOption();
    }

    public final void updateOption() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return;
            }
            iGlOverlayLayer.updateOption(this.overlayName, this.mMVTTileOverlayOptions);
        } catch (Throwable unused) {
        }
    }

    public final boolean visible() {
        return this.mMVTTileOverlayOptions.visible();
    }
}
