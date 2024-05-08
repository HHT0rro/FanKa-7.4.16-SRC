package com.autonavi.amap.mapcore.interfaces;

import com.amap.api.maps.model.animation.Animation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface IInfoWindowManager {
    void setInfoWindowAnimation(Animation animation, Animation.AnimationListener animationListener);

    void setInfoWindowAppearAnimation(Animation animation);

    void setInfoWindowBackColor(int i10);

    void setInfoWindowBackEnable(boolean z10);

    void setInfoWindowBackScale(float f10, float f11);

    void setInfoWindowDisappearAnimation(Animation animation);

    void setInfoWindowMovingAnimation(Animation animation);

    void startAnimation();
}
