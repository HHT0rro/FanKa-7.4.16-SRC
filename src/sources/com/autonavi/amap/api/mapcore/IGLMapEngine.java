package com.autonavi.amap.api.mapcore;

import com.amap.api.maps.AMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface IGLMapEngine {
    void addGroupAnimation(int i10, int i11, float f10, int i12, int i13, int i14, int i15, AMap.CancelableCallback cancelableCallback);

    IGLMapState getNewMapState(int i10);
}
