package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.beauty.b.f;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final f.a f43028a;

    private g(f.a aVar) {
        this.f43028a = aVar;
    }

    public static Runnable a(f.a aVar) {
        return new g(aVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.a aVar = this.f43028a;
        GLES20.glUseProgram(aVar.getProgramId());
        GLES20.glUniform1f(aVar.f43024a, aVar.f43026c / aVar.mOutputSize.width);
        GLES20.glUniform1f(aVar.f43025b, aVar.f43027d / aVar.mOutputSize.height);
    }
}
