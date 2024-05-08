package com.zego.zegoavkit2.screencapture.ve_gl;

import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class GlUtil {
    private GlUtil() {
    }

    public static void checkNoGLES2Error(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError == 0) {
            return;
        }
        throw new RuntimeException(str + ": GLES20 error: " + glGetError);
    }

    public static FloatBuffer createFloatBuffer(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    public static int generateFrameBuffer(int i10) {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        int i11 = iArr[0];
        GLES20.glBindFramebuffer(36160, i11);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i10, 0);
        if (GLES20.glCheckFramebufferStatus(36160) != 36053) {
            return -1;
        }
        checkNoGLES2Error("generateFrameBuffer");
        return i11;
    }

    public static int generateTexture(int i10) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i11 = iArr[0];
        GLES20.glBindTexture(i10, i11);
        GLES20.glTexParameterf(i10, 10241, 9729.0f);
        GLES20.glTexParameterf(i10, 10240, 9729.0f);
        GLES20.glTexParameterf(i10, 10242, 33071.0f);
        GLES20.glTexParameterf(i10, 10243, 33071.0f);
        checkNoGLES2Error("generateTexture");
        return i11;
    }
}
