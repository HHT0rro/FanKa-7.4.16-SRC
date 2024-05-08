package com.effectsar.labcv.effectsdk;

import android.content.Context;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class Vida {
    private boolean mInited = false;
    private long mNativePtr;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class VidaInitConfig {
        public int backendType;
        public String kernelBinPath;
        public String modelPath;
        public int numThread;
        public int vidaType;

        public VidaInitConfig(String str, String str2, int i10, int i11, int i12) {
            this.modelPath = str;
            this.kernelBinPath = str2;
            this.backendType = i10;
            this.vidaType = i11;
            this.numThread = i12;
        }

        public int getBackendType() {
            return this.backendType;
        }

        public String getKernelBinPath() {
            return this.kernelBinPath;
        }

        public String getModelPath() {
            return this.modelPath;
        }

        public int getNumThread() {
            return this.numThread;
        }

        public int getVidaType() {
            return this.vidaType;
        }

        public void setBackendType(int i10) {
            this.backendType = i10;
        }

        public void setKernelBinPath(String str) {
            this.kernelBinPath = str;
        }

        public void setModelPath(String str) {
            this.modelPath = str;
        }

        public void setNumThread(int i10) {
            this.numThread = i10;
        }

        public void setVidaType(int i10) {
            this.vidaType = i10;
        }
    }

    static {
        try {
            System.loadLibrary("effect");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }

    private native int nativeCheckLicense(Context context, String str, boolean z10);

    private native int nativeCreate(VidaInitConfig vidaInitConfig);

    private native float nativeProcess(ByteBuffer byteBuffer, int i10, int i11);

    private native int nativeRelease();

    public int destroy() {
        if (!this.mInited) {
            return -1;
        }
        nativeRelease();
        this.mInited = false;
        return 0;
    }

    public int init(Context context, VidaInitConfig vidaInitConfig, String str, boolean z10) {
        int nativeCreate = nativeCreate(vidaInitConfig);
        if (nativeCreate != 0) {
            return nativeCreate;
        }
        int nativeCheckLicense = nativeCheckLicense(context, str, z10);
        if (nativeCheckLicense != 0) {
            return nativeCheckLicense;
        }
        this.mInited = true;
        return 0;
    }

    public float process(ByteBuffer byteBuffer, int i10, int i11) {
        if (this.mInited) {
            return nativeProcess(byteBuffer, i10, i11);
        }
        return -1.0f;
    }
}
