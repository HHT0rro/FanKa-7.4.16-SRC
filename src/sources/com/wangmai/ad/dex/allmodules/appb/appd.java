package com.wangmai.ad.dex.allmodules.appb;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: MoveAndBounceAnimation.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appd extends Animation {

    /* renamed from: appa, reason: collision with root package name */
    private appb f46714appa;
    private int[] appb;
    private Camera appc;
    private int appd = 0;
    private float appe;
    private int appf;
    private float appg;
    private int[] apph;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: MoveAndBounceAnimation.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    static /* synthetic */ class appa {

        /* renamed from: appa, reason: collision with root package name */
        static final /* synthetic */ int[] f46715appa = new int[appb.values().length];

        static {
            try {
                f46715appa[appb.EHorizontal.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46715appa[appb.EVertical.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: MoveAndBounceAnimation.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public enum appb {
        EHorizontal,
        EVertical
    }

    public appd(appb appbVar, int[] iArr) {
        this.appe = 0.0f;
        this.appf = 0;
        this.appg = 0.0f;
        this.f46714appa = appbVar;
        this.appb = iArr;
        if (iArr == null && iArr.length == 0) {
            throw new Exception("aPoints不能为空");
        }
        this.appf = 0;
        this.appg = 0.0f;
        this.apph = new int[iArr.length];
        int i10 = 0;
        while (i10 < iArr.length - 1) {
            int i11 = this.appf;
            int i12 = iArr[i10];
            i10++;
            this.appf = i11 + Math.abs(i12 - iArr[i10]);
            this.apph[i10] = this.appf;
        }
        this.appe = iArr[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.animation.Animation
    public void applyTransformation(float f10, Transformation transformation) {
        super.applyTransformation(f10, transformation);
        Camera camera = this.appc;
        this.appg = this.appf * f10;
        int i10 = this.appd;
        int[] iArr = this.appb;
        if (i10 > iArr.length - 1) {
            return;
        }
        if (this.appg >= this.apph[i10]) {
            this.appd = i10 + 1;
            if (this.appd > iArr.length - 1) {
                return;
            }
        }
        int[] iArr2 = this.appb;
        int i11 = this.appd;
        int i12 = iArr2[i11 + (-1)] > iArr2[i11] ? -1 : 1;
        Matrix matrix = transformation.getMatrix();
        camera.save();
        int[] iArr3 = this.appb;
        int i13 = this.appd;
        this.appe = iArr3[i13 - 1] + (i12 * ((this.appf * f10) - this.apph[i13 - 1]));
        int i14 = appa.f46715appa[this.f46714appa.ordinal()];
        if (i14 == 1) {
            camera.translate(this.appe, 0.0f, 0.0f);
        } else if (i14 == 2) {
            camera.translate(0.0f, this.appe * (-1.0f), 0.0f);
        }
        camera.getMatrix(matrix);
        camera.restore();
    }

    @Override // android.view.animation.Animation
    public void initialize(int i10, int i11, int i12, int i13) {
        super.initialize(i10, i11, i12, i13);
        this.appc = new Camera();
    }
}
