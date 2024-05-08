package com.cupidapp.live.liveshow.beauty.databeauty.opengl;

import android.opengl.GLES20;
import com.cupidapp.live.liveshow.beauty.databeauty.opengl.Drawable2d;
import java.nio.Buffer;
import java.nio.ByteBuffer;

/* compiled from: ProgramTexture2d.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class a extends o2.b {

    /* renamed from: h, reason: collision with root package name */
    public int f14868h;

    /* renamed from: i, reason: collision with root package name */
    public int f14869i;

    /* renamed from: j, reason: collision with root package name */
    public int f14870j;

    /* renamed from: k, reason: collision with root package name */
    public int f14871k;

    /* renamed from: l, reason: collision with root package name */
    public int f14872l;

    /* renamed from: m, reason: collision with root package name */
    public int f14873m;

    /* renamed from: n, reason: collision with root package name */
    public ByteBuffer f14874n;

    public a() {
        super("uniform mat4 uMVPMatrix;\nattribute vec4 aPosition;\nattribute vec2 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = aTextureCoord;\n}\n", "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
        this.f14872l = 0;
        this.f14873m = 0;
        this.f14874n = null;
    }

    @Override // o2.b
    public int c(int i10, int i11, int i12, float[] fArr) {
        o2.a.a("draw start");
        g(i11, i12);
        o2.a.a("initFrameBufferIfNeed");
        GLES20.glUseProgram(this.f52257a);
        o2.a.a("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i10);
        o2.a.a("glBindTexture");
        GLES20.glBindFramebuffer(36160, this.f52259c[0]);
        o2.a.a("glBindFramebuffer");
        GLES20.glUniformMatrix4fv(this.f14868h, 1, false, fArr, 0);
        o2.a.a("glUniformMatrix4fv");
        GLES20.glEnableVertexAttribArray(this.f14869i);
        o2.a.a("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.f14869i, 2, 5126, false, 8, (Buffer) this.f52258b.c());
        o2.a.a("glVertexAttribPointer");
        GLES20.glEnableVertexAttribArray(this.f14870j);
        o2.a.a("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.f14870j, 2, 5126, false, 8, (Buffer) this.f52258b.a());
        o2.a.a("glVertexAttribPointer");
        GLES20.glViewport(0, 0, i11, i12);
        GLES20.glDrawArrays(5, 0, this.f52258b.d());
        o2.a.a("glDrawArrays");
        GLES20.glDisableVertexAttribArray(this.f14869i);
        GLES20.glDisableVertexAttribArray(this.f14870j);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glUseProgram(0);
        return this.f52260d[0];
    }

    @Override // o2.b
    public void d(int i10, int i11, int i12, float[] fArr) {
        o2.a.a("draw start");
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glUseProgram(this.f52257a);
        o2.a.a("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i10);
        GLES20.glUniformMatrix4fv(this.f14868h, 1, false, fArr, 0);
        o2.a.a("glUniformMatrix4fv");
        GLES20.glEnableVertexAttribArray(this.f14869i);
        o2.a.a("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.f14869i, 2, 5126, false, 8, (Buffer) this.f52258b.c());
        o2.a.a("glVertexAttribPointer");
        GLES20.glEnableVertexAttribArray(this.f14870j);
        o2.a.a("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.f14870j, 2, 5126, false, 8, (Buffer) this.f52258b.b());
        o2.a.a("glVertexAttribPointer");
        GLES20.glViewport(0, 0, i11, i12);
        GLES20.glDrawArrays(5, 0, this.f52258b.d());
        o2.a.a("glDrawArrays");
        GLES20.glDisableVertexAttribArray(this.f14869i);
        GLES20.glDisableVertexAttribArray(this.f14870j);
        GLES20.glBindTexture(3553, 0);
        GLES20.glUseProgram(0);
    }

    @Override // o2.b
    public Drawable2d e() {
        return new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    }

    @Override // o2.b
    public void f() {
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.f52257a, "aPosition");
        this.f14869i = glGetAttribLocation;
        o2.a.b(glGetAttribLocation, "aPosition");
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.f52257a, "aTextureCoord");
        this.f14870j = glGetAttribLocation2;
        o2.a.b(glGetAttribLocation2, "aTextureCoord");
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f52257a, "uMVPMatrix");
        this.f14868h = glGetUniformLocation;
        o2.a.b(glGetUniformLocation, "uMVPMatrix");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.f52257a, "sTexture");
        this.f14871k = glGetUniformLocation2;
        o2.a.b(glGetUniformLocation2, "sTexture");
    }
}
