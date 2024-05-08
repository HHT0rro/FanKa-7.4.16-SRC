package com.tencent.liteav.videobase.b;

import com.tencent.liteav.videobase.utils.OpenGlUtils;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d extends com.tencent.liteav.videobase.a.b {

    /* renamed from: a, reason: collision with root package name */
    private int f43283a = -1;

    /* renamed from: b, reason: collision with root package name */
    private int f43284b = -1;

    /* renamed from: c, reason: collision with root package name */
    private int f43285c = -1;

    public final void a(Buffer buffer, int i10, int i11) {
        if (this.f43283a != i10 || this.f43284b != i11) {
            this.f43283a = i10;
            this.f43284b = i11;
            OpenGlUtils.deleteTexture(this.f43285c);
            this.f43285c = -1;
        }
        this.f43285c = OpenGlUtils.loadTexture(6408, buffer, i10, i11, this.f43285c);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onDraw(int i10, com.tencent.liteav.videobase.frame.d dVar, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        super.onDraw(this.f43285c, dVar, floatBuffer, floatBuffer2);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onUninit() {
        super.onUninit();
        OpenGlUtils.deleteTexture(this.f43285c);
        this.f43285c = -1;
    }
}
