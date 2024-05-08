package com.amap.api.maps.model.amap3dmodeltile;

import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class AMap3DTileBuildingMaterialOptions {
    public float metallicFactor;
    public float roughnessFactor;
    public String type;

    public AMap3DTileBuildingMaterialOptions(String str, float f10, float f11) {
        this.type = str;
        this.metallicFactor = f10;
        this.roughnessFactor = f11;
    }
}
