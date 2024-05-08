package com.autonavi.amap.mapcore.interfaces;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface IMapConfig {
    int getAbroadState();

    int getAnchorX();

    int getAnchorY();

    int getMapHeight();

    int getMapWidth();

    float getMapZoomScale();

    float getMaxZoomLevel();

    float getMinZoomLevel();

    double getSX();

    double getSY();

    float getSZ();

    boolean isAbroadEnable();

    boolean isTerrainEnable();

    void setAbroadEnable(boolean z10);

    void setAbroadState(int i10);

    void setTerrainEnable(boolean z10);
}
