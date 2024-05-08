package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class ParticleShapeModule {

    @JBindingExclude
    public final int TYPE_DEFAULT = -1;

    @JBindingExclude
    public final int TYPE_SINGLEPOINT = 0;

    @JBindingExclude
    public final int TYPE_RECT = 1;
    public int type = -1;
    public boolean isUseRatio = false;

    public abstract float[] getPoint();

    public boolean isUseRatio() {
        return this.isUseRatio;
    }
}
