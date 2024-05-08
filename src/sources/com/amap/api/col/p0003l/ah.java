package com.amap.api.col.p0003l;

import android.graphics.Point;
import android.util.Pair;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.IPoint;

/* compiled from: AbstractCameraBoundsMessage.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ah extends AbstractCameraUpdateMessage {
    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public final void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
    }

    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public final void runCameraUpdate(IGLMapState iGLMapState) {
        Pair<Float, IPoint> a10 = dx.a(this, this.mapConfig);
        if (a10 == null) {
            return;
        }
        iGLMapState.setMapZoomer(((Float) a10.first).floatValue());
        Object obj = a10.second;
        iGLMapState.setMapGeoCenter(((Point) ((IPoint) obj)).x, ((Point) ((IPoint) obj)).y);
        iGLMapState.setCameraDegree(0.0f);
        iGLMapState.setMapAngle(0.0f);
    }
}
