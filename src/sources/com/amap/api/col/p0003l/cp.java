package com.amap.api.col.p0003l;

import android.opengl.GLES20;

/* compiled from: GlShader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class cp {

    /* renamed from: a, reason: collision with root package name */
    public int f5224a;

    /* renamed from: b, reason: collision with root package name */
    public int f5225b;

    /* renamed from: c, reason: collision with root package name */
    public int f5226c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f5227d;

    public final void a() {
        int i10 = this.f5224a;
        if (i10 >= 0) {
            GLES20.glDeleteProgram(i10);
        }
        int i11 = this.f5225b;
        if (i11 >= 0) {
            GLES20.glDeleteShader(i11);
        }
        int i12 = this.f5226c;
        if (i12 >= 0) {
            GLES20.glDeleteShader(i12);
        }
        this.f5227d = true;
    }
}
