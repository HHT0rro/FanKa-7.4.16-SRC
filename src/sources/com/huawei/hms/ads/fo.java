package com.huawei.hms.ads;

import android.opengl.Matrix;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class fo {
    private static final float[] Code;
    private float B;
    private float C;
    private float S;
    private final fn V;
    private float Z;
    private int I = -1;
    private final float[] F = new float[16];
    private boolean D = false;
    private final float[] L = new float[16];

    static {
        float[] fArr = new float[16];
        Code = fArr;
        Matrix.setIdentityM(fArr, 0);
    }

    public fo(fn fnVar) {
        this.V = fnVar;
    }

    private void Code() {
        float[] fArr = this.F;
        Matrix.setIdentityM(fArr, 0);
        Matrix.translateM(fArr, 0, this.C, this.S, 0.0f);
        Matrix.scaleM(fArr, 0, this.Z, this.B, 1.0f);
        this.D = true;
    }

    private float[] V() {
        if (!this.D) {
            Code();
        }
        return this.F;
    }

    public void Code(float f10, float f11) {
        this.Z = f10;
        this.B = f11;
        this.D = false;
    }

    public void Code(int i10) {
        this.I = i10;
    }

    public void Code(fp fpVar, float[] fArr) {
        Matrix.multiplyMM(this.L, 0, fArr, 0, V(), 0);
        fpVar.Code(new fq(this.L, this.V.Code(), 0, this.V.I(), this.V.C(), this.V.Z(), Code, this.V.V(), this.I, this.V.B()));
    }

    public void V(float f10, float f11) {
        this.C = f10;
        this.S = f11;
        this.D = false;
    }
}
