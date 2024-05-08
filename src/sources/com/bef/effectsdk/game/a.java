package com.bef.effectsdk.game;

import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: RenderTextureUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static float[] f10514a = {-1.0f, 1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f};

    /* renamed from: b, reason: collision with root package name */
    public static float[] f10515b = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};

    /* renamed from: c, reason: collision with root package name */
    public static float[] f10516c = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};

    public static int a(int i10, int i11) {
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(i10 * i11 * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        asFloatBuffer.put(0.0f);
        asFloatBuffer.position(0);
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glTexImage2D(3553, 0, 6408, i10, i11, 0, 6408, 5121, asFloatBuffer);
        GLES20.glBindTexture(3553, 0);
        return iArr[0];
    }

    public static FloatBuffer b(float[] fArr) {
        FloatBuffer put = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr);
        put.position(0);
        return put;
    }

    public static FloatBuffer c() {
        return b(f10515b);
    }

    public static FloatBuffer d(float f10, float f11, float f12, float f13) {
        return b(new float[]{f10, f12, f11, f12, f10, f13, f11, f13});
    }
}
