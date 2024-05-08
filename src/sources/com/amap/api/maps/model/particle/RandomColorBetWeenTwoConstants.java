package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.Random;

@JBindingInclude
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class RandomColorBetWeenTwoConstants extends ColorGenerate {

    /* renamed from: a, reason: collision with root package name */
    private float f8245a;

    /* renamed from: a1, reason: collision with root package name */
    private float f8246a1;

    /* renamed from: b, reason: collision with root package name */
    private float f8247b;

    /* renamed from: b1, reason: collision with root package name */
    private float f8248b1;

    /* renamed from: g, reason: collision with root package name */
    private float f8249g;

    /* renamed from: g1, reason: collision with root package name */
    private float f8250g1;

    /* renamed from: r, reason: collision with root package name */
    private float f8251r;

    /* renamed from: r1, reason: collision with root package name */
    private float f8252r1;

    @JBindingExclude
    private float[] color = {1.0f, 1.0f, 1.0f, 1.0f};

    @JBindingExclude
    private Random random = new Random();

    @JBindingExclude
    public RandomColorBetWeenTwoConstants(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        this.f8251r = f10 / 255.0f;
        this.f8249g = f11 / 255.0f;
        this.f8247b = f12 / 255.0f;
        this.f8245a = f13 / 255.0f;
        this.f8252r1 = f14 / 255.0f;
        this.f8250g1 = f15 / 255.0f;
        this.f8248b1 = f16 / 255.0f;
        this.f8246a1 = f17 / 255.0f;
        this.type = 0;
    }

    @Override // com.amap.api.maps.model.particle.ColorGenerate
    public float[] getColor() {
        float[] fArr = this.color;
        float nextFloat = this.random.nextFloat();
        float f10 = this.f8252r1;
        float f11 = this.f8251r;
        fArr[0] = (nextFloat * (f10 - f11)) + f11;
        float[] fArr2 = this.color;
        float nextFloat2 = this.random.nextFloat();
        float f12 = this.f8250g1;
        float f13 = this.f8249g;
        fArr2[1] = (nextFloat2 * (f12 - f13)) + f13;
        float[] fArr3 = this.color;
        float nextFloat3 = this.random.nextFloat();
        float f14 = this.f8248b1;
        float f15 = this.f8247b;
        fArr3[2] = (nextFloat3 * (f14 - f15)) + f15;
        float[] fArr4 = this.color;
        float nextFloat4 = this.random.nextFloat();
        float f16 = this.f8246a1;
        float f17 = this.f8245a;
        fArr4[3] = (nextFloat4 * (f16 - f17)) + f17;
        return this.color;
    }
}
