package com.amap.api.col.p0003l;

import android.graphics.Point;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;

/* compiled from: AbstractCameraScrollMessage.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class aj extends AbstractCameraUpdateMessage {
    private static void a(IGLMapState iGLMapState, int i10, int i11, Point point) {
        iGLMapState.screenToP20Point(i10, i11, point);
    }

    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public final void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
    }

    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public final void runCameraUpdate(IGLMapState iGLMapState) {
        float f10 = this.xPixel;
        float f11 = (this.width / 2.0f) + f10;
        float f12 = (this.height / 2.0f) + this.yPixel;
        a(iGLMapState, (int) f11, (int) f12, new Point());
        iGLMapState.setMapGeoCenter(r1.x, r1.y);
    }
}
