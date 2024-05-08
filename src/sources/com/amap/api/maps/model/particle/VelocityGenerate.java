package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class VelocityGenerate {

    @JBindingExclude
    public final int TYPE_DEFAULT = -1;

    @JBindingExclude
    public final int TYPE_RANDOMVELOCITYBETWEENTWOCONSTANTS = 0;
    public int type = -1;

    public abstract float getX();

    public abstract float getY();

    public abstract float getZ();
}
