package com.autonavi.base.amap.mapcore.interfaces;

import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.MapPoi;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface IAMapListener {
    void afterAnimation();

    void afterDrawFrame(int i10, GLMapState gLMapState);

    void afterDrawLabel(int i10, GLMapState gLMapState);

    void afterRendererOver(int i10, GLMapState gLMapState);

    void beforeDrawLabel(int i10, GLMapState gLMapState);

    void onMapBlankClick(double d10, double d11);

    void onMapPOIClick(MapPoi mapPoi);
}
