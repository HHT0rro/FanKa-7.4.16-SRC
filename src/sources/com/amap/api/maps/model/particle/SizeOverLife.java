package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class SizeOverLife {

    @JBindingExclude
    public final int TYPE_DEFAULT = -1;

    @JBindingExclude
    public final int TYPE_CURVESIZEOVERLIFE = 0;
    public int type = -1;

    @JBindingExclude
    public final int DEFAULT_SIZE = 0;

    public abstract float getSizeX(float f10);

    public abstract float getSizeY(float f10);

    public abstract float getSizeZ(float f10);
}
