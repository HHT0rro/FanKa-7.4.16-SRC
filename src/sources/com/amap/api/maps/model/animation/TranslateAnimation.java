package com.amap.api.maps.model.animation;

import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.animation.GLTranslateAnimation;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class TranslateAnimation extends Animation {

    /* renamed from: x, reason: collision with root package name */
    @JBindingInclude
    private double f8240x;

    /* renamed from: y, reason: collision with root package name */
    @JBindingInclude
    private double f8241y;

    public TranslateAnimation(LatLng latLng) {
        this.glAnimation = new GLTranslateAnimation(latLng);
        this.f8240x = latLng.latitude;
        this.f8241y = latLng.longitude;
    }

    @Override // com.amap.api.maps.model.animation.Animation
    public String getAnimationType() {
        return "TranslateAnimation";
    }
}
