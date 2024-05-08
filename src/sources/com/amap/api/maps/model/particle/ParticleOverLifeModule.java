package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ParticleOverLifeModule {

    @JBindingExclude
    private static final int TYPE_COLOR = 3;

    @JBindingExclude
    private static final int TYPE_ROTATE = 1;

    @JBindingExclude
    private static final int TYPE_SCALE = 2;

    @JBindingExclude
    private static final int TYPE_VEL = 0;

    @JBindingExclude
    private ColorGenerate colorGenerate;
    private Object colorGenerateObject;

    @JBindingExclude
    private RotationOverLife rotateOverLife;
    private Object rotateOverLifeObject;

    @JBindingExclude
    private SizeOverLife sizeOverLife;
    private Object sizeOverLifeObject;
    private Object velocityOverLifeObject;

    @JBindingExclude
    private VelocityGenerate overLife = null;

    @JBindingExclude
    private VelocityGenerate velocityOverLife = null;

    @JBindingExclude
    private boolean isNeedReloadVelocityGenerate = false;

    @JBindingExclude
    private boolean isNeedReloadRotationOverLife = false;

    @JBindingExclude
    private boolean isNeedReloadSizeOverLife = false;

    @JBindingExclude
    private boolean isNeedReloadColorGenerate = false;

    public void setColorGenerate(ColorGenerate colorGenerate) {
        this.colorGenerate = colorGenerate;
        this.colorGenerateObject = colorGenerate;
        this.isNeedReloadColorGenerate = true;
    }

    public void setRotateOverLife(RotationOverLife rotationOverLife) {
        this.rotateOverLife = rotationOverLife;
        this.rotateOverLifeObject = rotationOverLife;
        this.isNeedReloadRotationOverLife = true;
    }

    public void setSizeOverLife(SizeOverLife sizeOverLife) {
        this.sizeOverLife = sizeOverLife;
        this.sizeOverLifeObject = sizeOverLife;
        this.isNeedReloadSizeOverLife = true;
    }

    public void setVelocityOverLife(VelocityGenerate velocityGenerate) {
        this.overLife = velocityGenerate;
        this.velocityOverLife = velocityGenerate;
        this.velocityOverLifeObject = velocityGenerate;
        this.isNeedReloadVelocityGenerate = true;
    }
}
