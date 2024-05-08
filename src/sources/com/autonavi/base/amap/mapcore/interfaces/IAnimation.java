package com.autonavi.base.amap.mapcore.interfaces;

import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.animation.GLAnimation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface IAnimation {
    void setAnimation(GLAnimation gLAnimation);

    void setAnimationListener(Animation.AnimationListener animationListener);

    boolean startAnimation();
}
