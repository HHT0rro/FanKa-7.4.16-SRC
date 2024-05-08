package com.tencent.liteav.beauty.b.b;

import android.opengl.GLES20;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.liteav.videobase.b.f;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b extends f {

    /* renamed from: a, reason: collision with root package name */
    public int f42977a;

    /* renamed from: b, reason: collision with root package name */
    public int f42978b;

    /* renamed from: c, reason: collision with root package name */
    public float f42979c;

    /* renamed from: d, reason: collision with root package name */
    public float f42980d;

    /* renamed from: e, reason: collision with root package name */
    private int f42981e;

    /* renamed from: f, reason: collision with root package name */
    private float f42982f;

    public b() {
        super(null);
        this.f42981e = -1;
        this.f42977a = -1;
        this.f42978b = -1;
        this.f42979c = 0.0f;
        this.f42980d = 0.0f;
        this.f42982f = 0.0f;
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final int buildProgram() {
        return NativeLoad.nativeLoadGLProgram(12);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final boolean canBeSkipped() {
        return isLessOrEqualZero(this.f42979c) && isLessOrEqualZero(this.f42980d) && isLessOrEqualZero(this.f42982f);
    }

    @Override // com.tencent.liteav.videobase.b.f, com.tencent.liteav.videobase.a.b
    public final void onInit(com.tencent.liteav.videobase.frame.e eVar) {
        super.onInit(eVar);
        this.f42977a = GLES20.glGetUniformLocation(getProgramId(), "whiteDegree");
        this.f42981e = GLES20.glGetUniformLocation(getProgramId(), "contrast");
        this.f42978b = GLES20.glGetUniformLocation(getProgramId(), "ruddyDegree");
    }
}
