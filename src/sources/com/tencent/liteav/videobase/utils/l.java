package com.tencent.liteav.videobase.utils;

import android.opengl.GLES20;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final String f43529a;

    /* renamed from: b, reason: collision with root package name */
    public final String f43530b;

    public l(String str, String str2) {
        this.f43529a = str;
        this.f43530b = str2;
    }

    public static int a(String str, int i10) {
        int[] iArr = new int[1];
        int glCreateShader = GLES20.glCreateShader(i10);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        OpenGlUtils.checkGlError("glCompileShader");
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }
}
