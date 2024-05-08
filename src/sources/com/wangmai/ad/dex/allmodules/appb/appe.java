package com.wangmai.ad.dex.allmodules.appb;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: Rotate3dAnimation.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appe extends Animation {

    /* renamed from: appa, reason: collision with root package name */
    private final float f46717appa;
    private final float appb;
    private final float appc;
    private final float appd;
    private final float appe;
    private final boolean appf;
    private Camera appg;

    public appe(float f10, float f11, float f12, float f13, float f14, boolean z10) {
        this.f46717appa = f10;
        this.appb = f11;
        this.appc = f12;
        this.appd = f13;
        this.appe = f14;
        this.appf = z10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.animation.Animation
    public void applyTransformation(float f10, Transformation transformation) {
        float f11 = this.f46717appa;
        float f12 = f11 + ((this.appb - f11) * f10);
        float f13 = this.appc;
        float f14 = this.appd;
        Camera camera = this.appg;
        Matrix matrix = transformation.getMatrix();
        camera.save();
        if (this.appf) {
            camera.translate(0.0f, 0.0f, this.appe * f10);
        } else {
            camera.translate(0.0f, 0.0f, this.appe * (1.0f - f10));
        }
        camera.rotateY(f12);
        camera.getMatrix(matrix);
        matrix.preTranslate(-f13, -f14);
        matrix.postTranslate(f13, f14);
        camera.restore();
    }

    @Override // android.view.animation.Animation
    public void initialize(int i10, int i11, int i12, int i13) {
        super.initialize(i10, i11, i12, i13);
        this.appg = new Camera();
    }
}
