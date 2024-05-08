package com.amap.api.col.p0003l;

import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;

/* compiled from: AbstractCameraZoomMessage.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ak extends AbstractCameraUpdateMessage {
    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public final void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
        abstractCameraUpdateMessage.zoom += this.amount;
    }

    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public final void runCameraUpdate(IGLMapState iGLMapState) {
        float mapZoomer = iGLMapState.getMapZoomer() + this.amount;
        this.zoom = mapZoomer;
        this.zoom = dx.a(this.mapConfig, mapZoomer);
        normalChange(iGLMapState);
    }
}
