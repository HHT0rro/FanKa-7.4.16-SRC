package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class SinglePointParticleShape extends ParticleShapeModule {
    private float[] point_3;

    public SinglePointParticleShape(float f10, float f11, float f12, boolean z10) {
        this.point_3 = r0;
        float[] fArr = {f10, f11, f12};
        this.isUseRatio = z10;
        this.type = 0;
    }

    @Override // com.amap.api.maps.model.particle.ParticleShapeModule
    public float[] getPoint() {
        return this.point_3;
    }

    public SinglePointParticleShape(float f10, float f11, float f12) {
        this(f10, f11, f12, false);
    }
}
