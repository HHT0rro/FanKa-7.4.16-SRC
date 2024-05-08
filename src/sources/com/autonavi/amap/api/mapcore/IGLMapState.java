package com.autonavi.amap.api.mapcore;

import android.graphics.Point;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface IGLMapState {
    float calculateMapZoomer(int i10, int i11, int i12, int i13, int i14);

    float getCameraDegree();

    float getMapAngle();

    DPoint getMapGeoCenter();

    void getMapGeoCenter(IPoint iPoint);

    float getMapZoomer();

    void recalculate();

    void recycle();

    void screenToP20Point(int i10, int i11, Point point);

    void setCameraDegree(float f10);

    void setMapAngle(float f10);

    void setMapGeoCenter(double d10, double d11);

    void setMapZoomer(float f10);
}
