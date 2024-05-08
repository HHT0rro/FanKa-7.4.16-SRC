package com.tencent.liteav.videobase.c;

import android.opengl.GLES20;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class j extends com.tencent.liteav.videobase.a.b {

    /* renamed from: a, reason: collision with root package name */
    public int f43360a;

    /* renamed from: b, reason: collision with root package name */
    public int f43361b;

    public j(String str, String str2) {
        super(str, str2);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onInit(com.tencent.liteav.videobase.frame.e eVar) {
        super.onInit(eVar);
        this.f43360a = GLES20.glGetUniformLocation(getProgramId(), "width");
        this.f43361b = GLES20.glGetUniformLocation(getProgramId(), "height");
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onOutputSizeChanged(int i10, int i11) {
        super.onOutputSizeChanged(i10, i11);
        runOnDraw(k.a(this));
    }
}
