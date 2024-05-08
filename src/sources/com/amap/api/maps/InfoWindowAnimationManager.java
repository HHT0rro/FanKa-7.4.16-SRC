package com.amap.api.maps;

import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.interfaces.IInfoWindowManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class InfoWindowAnimationManager {

    /* renamed from: a, reason: collision with root package name */
    public IInfoWindowManager f8188a;

    public InfoWindowAnimationManager(IInfoWindowManager iInfoWindowManager) {
        this.f8188a = iInfoWindowManager;
    }

    public void setInfoWindowAnimation(Animation animation, Animation.AnimationListener animationListener) {
        this.f8188a.setInfoWindowAnimation(animation, animationListener);
    }

    public void setInfoWindowAppearAnimation(Animation animation) {
        this.f8188a.setInfoWindowAppearAnimation(animation);
    }

    public void setInfoWindowBackColor(int i10) {
        this.f8188a.setInfoWindowBackColor(i10);
    }

    public void setInfoWindowBackEnable(boolean z10) {
        this.f8188a.setInfoWindowBackEnable(z10);
    }

    public void setInfoWindowBackScale(float f10, float f11) {
        this.f8188a.setInfoWindowBackScale(f10, f11);
    }

    public void setInfoWindowDisappearAnimation(Animation animation) {
        this.f8188a.setInfoWindowDisappearAnimation(animation);
    }

    public void setInfoWindowMovingAnimation(Animation animation) {
        this.f8188a.setInfoWindowMovingAnimation(animation);
    }

    public void startAnimation() {
        this.f8188a.startAnimation();
    }
}
