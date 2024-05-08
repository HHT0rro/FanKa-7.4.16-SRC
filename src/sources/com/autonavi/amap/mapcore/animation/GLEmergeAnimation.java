package com.autonavi.amap.mapcore.animation;

import com.amap.api.maps.model.LatLng;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class GLEmergeAnimation extends GLAnimation {
    public LatLng mStartPoint;

    public GLEmergeAnimation(LatLng latLng) {
        this.mStartPoint = latLng;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void applyTransformation(float f10, GLTransformation gLTransformation) {
    }
}
