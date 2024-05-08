package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.Random;

@JBindingInclude
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class RandomVelocityBetweenTwoConstants extends VelocityGenerate {

    @JBindingExclude
    private Random random = new Random();

    /* renamed from: x1, reason: collision with root package name */
    private float f8253x1;

    /* renamed from: x2, reason: collision with root package name */
    private float f8254x2;
    private float y1;

    /* renamed from: y2, reason: collision with root package name */
    private float f8255y2;
    private float z1;

    /* renamed from: z2, reason: collision with root package name */
    private float f8256z2;

    public RandomVelocityBetweenTwoConstants(float f10, float f11, float f12, float f13, float f14, float f15) {
        this.f8253x1 = f10;
        this.y1 = f11;
        this.z1 = f12;
        this.f8254x2 = f13;
        this.f8255y2 = f14;
        this.f8256z2 = f15;
        this.type = 0;
    }

    @Override // com.amap.api.maps.model.particle.VelocityGenerate
    public float getX() {
        float nextFloat = this.random.nextFloat();
        float f10 = this.f8254x2;
        float f11 = this.f8253x1;
        return (nextFloat * (f10 - f11)) + f11;
    }

    @Override // com.amap.api.maps.model.particle.VelocityGenerate
    public float getY() {
        float nextFloat = this.random.nextFloat();
        float f10 = this.f8255y2;
        float f11 = this.y1;
        return (nextFloat * (f10 - f11)) + f11;
    }

    @Override // com.amap.api.maps.model.particle.VelocityGenerate
    public float getZ() {
        float nextFloat = this.random.nextFloat();
        float f10 = this.f8256z2;
        float f11 = this.z1;
        return (nextFloat * (f10 - f11)) + f11;
    }
}
