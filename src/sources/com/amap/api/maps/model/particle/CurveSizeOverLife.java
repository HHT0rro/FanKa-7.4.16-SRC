package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class CurveSizeOverLife extends SizeOverLife {

    /* renamed from: x, reason: collision with root package name */
    private float f8242x;

    /* renamed from: y, reason: collision with root package name */
    private float f8243y;

    /* renamed from: z, reason: collision with root package name */
    private float f8244z;

    public CurveSizeOverLife(float f10, float f11, float f12) {
        this.f8242x = f10;
        this.f8243y = f11;
        this.f8244z = f12;
        this.type = 0;
    }

    @Override // com.amap.api.maps.model.particle.SizeOverLife
    public float getSizeX(float f10) {
        return 0.0f;
    }

    @Override // com.amap.api.maps.model.particle.SizeOverLife
    public float getSizeY(float f10) {
        return 0.0f;
    }

    @Override // com.amap.api.maps.model.particle.SizeOverLife
    public float getSizeZ(float f10) {
        return 0.0f;
    }
}
