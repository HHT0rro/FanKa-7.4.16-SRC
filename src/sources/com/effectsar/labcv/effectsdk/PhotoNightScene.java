package com.effectsar.labcv.effectsdk;

import android.content.Context;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class PhotoNightScene {
    public static String TAG;
    private long mNativePtr = 0;
    private boolean mInited = false;
    private int mWidth = 0;
    private int mHeight = 0;
    private ByteBuffer mResultBuffer = null;

    static {
        try {
            System.loadLibrary("effect");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
        TAG = "PhotoNightScene";
    }

    private native int nativeCheckLicense(Context context, String str, boolean z10);

    private native int nativeCreate(String str, int i10, int i11, int i12, int i13);

    private native int nativeProcess(ByteBuffer[] byteBufferArr, ByteBuffer byteBuffer);

    private native void nativeRelease();

    public void destroy() {
        nativeRelease();
    }

    public int getHeight() {
        return this.mHeight;
    }

    public ByteBuffer getResultBuffer() {
        return this.mResultBuffer;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int init(Context context, String str, String str2, int i10, int i11, int i12, int i13, boolean z10) {
        if (this.mInited) {
            return 0;
        }
        int nativeCreate = nativeCreate(str2, i10, i11, i12, i13);
        if (nativeCreate != 0) {
            return nativeCreate;
        }
        int nativeCheckLicense = nativeCheckLicense(context, str, z10);
        if (nativeCheckLicense == 0) {
            this.mInited = true;
        }
        this.mWidth = i10;
        this.mHeight = i11;
        return nativeCheckLicense;
    }

    public ByteBuffer process(ByteBuffer[] byteBufferArr) {
        if (!this.mInited) {
            return null;
        }
        if (this.mResultBuffer == null) {
            this.mResultBuffer = ByteBuffer.allocateDirect((int) (this.mHeight * this.mWidth * 1.5f)).order(ByteOrder.nativeOrder());
        }
        this.mResultBuffer.position(0);
        if ((byteBufferArr.length == 4 || byteBufferArr.length == 6) && nativeProcess(byteBufferArr, this.mResultBuffer) == 0) {
            return this.mResultBuffer;
        }
        return null;
    }
}
