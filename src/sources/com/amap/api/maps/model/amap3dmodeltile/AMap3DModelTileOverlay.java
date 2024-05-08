package com.amap.api.maps.model.amap3dmodeltile;

import android.os.RemoteException;
import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BaseOverlay;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AMap3DModelTileOverlay extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private AMap3DModelTileOverlayOptions mAMap3DModelTileOverlayOptions;

    public AMap3DModelTileOverlay(IGlOverlayLayer iGlOverlayLayer, AMap3DModelTileOverlayOptions aMap3DModelTileOverlayOptions, String str) {
        super(str);
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.mAMap3DModelTileOverlayOptions = aMap3DModelTileOverlayOptions;
        if (aMap3DModelTileOverlayOptions != null) {
            aMap3DModelTileOverlayOptions.getTileProviderInner().init(iGlOverlayLayer, str);
        }
    }

    private void a() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return;
            }
            iGlOverlayLayer.updateOption(this.overlayName, this.mAMap3DModelTileOverlayOptions);
        } catch (Throwable unused) {
        }
    }

    public final float getZIndex() {
        return this.mAMap3DModelTileOverlayOptions.getZIndex();
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
        this.mAMap3DModelTileOverlayOptions.setVisible(z10);
        a();
    }

    public final void setZIndex(float f10) {
        this.mAMap3DModelTileOverlayOptions.setZIndex(f10);
        a();
    }

    public final boolean visible() {
        return this.mAMap3DModelTileOverlayOptions.visible();
    }
}
