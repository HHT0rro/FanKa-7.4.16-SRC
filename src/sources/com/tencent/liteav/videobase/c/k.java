package com.tencent.liteav.videobase.c;

import android.opengl.GLES20;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final j f43362a;

    private k(j jVar) {
        this.f43362a = jVar;
    }

    public static Runnable a(j jVar) {
        return new k(jVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        j jVar = this.f43362a;
        GLES20.glUseProgram(jVar.getProgramId());
        GLES20.glUniform1f(jVar.f43360a, jVar.mOutputSize.width);
        GLES20.glUniform1f(jVar.f43361b, jVar.mOutputSize.height);
    }
}
