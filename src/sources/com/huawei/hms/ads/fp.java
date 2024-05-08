package com.huawei.hms.ads;

import android.opengl.GLES20;
import java.nio.Buffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class fp {
    private int C;
    private int D;
    private int F;
    private int L;
    private int S;

    /* renamed from: a, reason: collision with root package name */
    private int f29221a;

    /* renamed from: b, reason: collision with root package name */
    private int f29222b;

    /* renamed from: c, reason: collision with root package name */
    private int f29223c;

    /* renamed from: d, reason: collision with root package name */
    private int f29224d = 36197;

    /* renamed from: e, reason: collision with root package name */
    private final float[] f29225e = new float[9];

    /* renamed from: f, reason: collision with root package name */
    private float[] f29226f = {-0.00390625f, -0.00390625f, 0.0f, -0.00390625f, 0.00390625f, -0.00390625f, -0.00390625f, 0.0f, 0.0f, 0.0f, 0.00390625f, 0.0f, -0.00390625f, 0.00390625f, 0.0f, 0.00390625f, 0.00390625f, 0.00390625f};

    /* renamed from: g, reason: collision with root package name */
    private float f29227g;

    public fp() {
        int I = I();
        this.C = I;
        if (I == 0) {
            throw new IllegalStateException("fail to create program");
        }
        B();
        if (this.D >= 0) {
            Z();
            return;
        }
        this.D = -1;
        this.L = -1;
        this.f29221a = -1;
    }

    private void B() {
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.C, "positionLocation");
        this.f29222b = glGetAttribLocation;
        Code(glGetAttribLocation, "positionLocation");
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.C, "textureCoordLocation");
        this.f29223c = glGetAttribLocation2;
        Code(glGetAttribLocation2, "textureCoordLocation");
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.C, "matrixLocation");
        this.S = glGetUniformLocation;
        Code(glGetUniformLocation, "matrixLocation");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.C, "texMatrixLocation");
        this.F = glGetUniformLocation2;
        Code(glGetUniformLocation2, "texMatrixLocation");
        this.D = GLES20.glGetUniformLocation(this.C, "coreLocation");
    }

    private void C() {
        int i10 = this.D;
        if (i10 >= 0) {
            GLES20.glUniform1fv(i10, 9, this.f29225e, 0);
            GLES20.glUniform2fv(this.L, 9, this.f29226f, 0);
            GLES20.glUniform1f(this.f29221a, this.f29227g);
        }
    }

    private static int Code(int i10, int i11) {
        int glCreateProgram = GLES20.glCreateProgram();
        Code("create program");
        if (glCreateProgram == 0) {
            gl.I("TexProgram", "fail not create program");
        }
        GLES20.glAttachShader(glCreateProgram, i10);
        Code("attach shader");
        GLES20.glAttachShader(glCreateProgram, i11);
        Code("attach shader");
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 1) {
            return glCreateProgram;
        }
        gl.I("TexProgram", "fail to link");
        GLES20.glDeleteProgram(glCreateProgram);
        return 0;
    }

    public static void Code(int i10, String str) {
        if (i10 >= 0) {
            return;
        }
        throw new IllegalStateException("program fail to find " + str);
    }

    public static void Code(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError == 0) {
            return;
        }
        String str2 = str + " error: " + Integer.toHexString(glGetError);
        gl.I("TexProgram", str2);
        throw new IllegalStateException(str2);
    }

    private static int I() {
        int V;
        int V2 = V(35633, "uniform mat4 matrixLocation; uniform mat4 texMatrixLocation; attribute vec4 positionLocation; attribute vec4 textureCoordLocation; varying vec2 textureCoordination; void main() { gl_Position = matrixLocation * positionLocation; textureCoordination = (texMatrixLocation * textureCoordLocation).xy;}");
        if (V2 == 0 || (V = V(35632, "#extension GL_OES_EGL_image_external : require\n precision mediump float; varying vec2 textureCoordination; uniform samplerExternalOES sTexture; void main() {gl_FragColor = texture2D(sTexture, textureCoordination);}")) == 0) {
            return 0;
        }
        return Code(V2, V);
    }

    private void I(fq fqVar) {
        GLES20.glEnableVertexAttribArray(this.f29222b);
        Code("rv - 1");
        GLES20.glVertexAttribPointer(this.f29222b, fqVar.B(), 5126, false, fqVar.C(), (Buffer) fqVar.V());
        Code("rv - 2");
        GLES20.glEnableVertexAttribArray(this.f29223c);
        Code("rv - 3");
        GLES20.glVertexAttribPointer(this.f29223c, 2, 5126, false, fqVar.L(), (Buffer) fqVar.F());
        Code("rv - 4");
    }

    private static int V(int i10, String str) {
        int glCreateShader = GLES20.glCreateShader(i10);
        Code("create shader " + i10);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        gl.I("TexProgram", "fail to compile shader: " + i10 + " " + GLES20.glGetShaderInfoLog(glCreateShader));
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }

    private void V(fq fqVar) {
        GLES20.glUseProgram(this.C);
        Code("rtm - 1");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.f29224d, fqVar.D());
        GLES20.glUniformMatrix4fv(this.S, 1, false, fqVar.Code(), 0);
        Code("rtm - 2");
        GLES20.glUniformMatrix4fv(this.F, 1, false, fqVar.S(), 0);
        Code("rtm - 3");
    }

    private void Z() {
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.C, "textureOffsetLocation");
        this.L = glGetUniformLocation;
        Code(glGetUniformLocation, "textureOffsetLocation");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.C, "colorAdjustLocation");
        this.f29221a = glGetUniformLocation2;
        Code(glGetUniformLocation2, "colorAdjustLocation");
        System.arraycopy((Object) new float[]{0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f}, 0, (Object) this.f29225e, 0, 9);
        this.f29227g = 0.0f;
    }

    private void Z(fq fqVar) {
        GLES20.glDrawArrays(5, fqVar.I(), fqVar.Z());
        Code("pr4 - 1");
        GLES20.glDisableVertexAttribArray(this.f29222b);
        GLES20.glDisableVertexAttribArray(this.f29223c);
        GLES20.glBindTexture(this.f29224d, 0);
        GLES20.glUseProgram(0);
    }

    public void Code() {
        try {
            GLES20.glDeleteProgram(this.C);
            this.C = -1;
        } catch (Throwable th) {
            gl.Code(5, "TexProgram", "release", th);
        }
    }

    public void Code(fq fqVar) {
        Code("render - 1");
        V(fqVar);
        I(fqVar);
        C();
        Z(fqVar);
    }

    public int V() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        Code("fail to generate texture");
        int i10 = iArr[0];
        GLES20.glBindTexture(this.f29224d, i10);
        Code("fail to bind texture ");
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        Code("fail to create texture");
        return i10;
    }
}
