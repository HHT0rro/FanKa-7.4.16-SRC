package com.effectsar.labcv.effectsdk;

import android.content.Context;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class TaintSceneDetect {
    private long mNativePtr;
    private boolean mInited = false;
    private boolean mFirstFrame = true;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class TaintDetectParam {
        public int backendType;
        public int detectFrequency;
        public String kernelBinPath;
        public String modelPath;
        public int numThread;

        public TaintDetectParam(int i10, String str, String str2, int i11, int i12) {
            this.detectFrequency = i10;
            this.modelPath = str;
            this.kernelBinPath = str2;
            this.backendType = i11;
            this.numThread = i12;
        }

        public int getBackendType() {
            return this.backendType;
        }

        public int getDetectFrequency() {
            return this.detectFrequency;
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

        public void setBackendType(int i10) {
            this.backendType = i10;
        }

        public void setDetectFrequency(int i10) {
            this.detectFrequency = i10;
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
    }

    static {
        try {
            System.loadLibrary("effect");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }

    private native int nativeCheckLicense(Context context, String str, boolean z10);

    private native int nativeCreate(TaintDetectParam taintDetectParam);

    private native float nativeProcess(ByteBuffer byteBuffer, boolean z10);

    private native int nativeRelease();

    public int init(Context context, TaintDetectParam taintDetectParam, String str, boolean z10) {
        int nativeCreate = nativeCreate(taintDetectParam);
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

    public float process(ByteBuffer byteBuffer) {
        if (!this.mInited) {
            return -1.0f;
        }
        float nativeProcess = nativeProcess(byteBuffer, this.mFirstFrame);
        this.mFirstFrame = false;
        return nativeProcess;
    }

    public int release() {
        if (!this.mInited) {
            return -1;
        }
        nativeRelease();
        this.mInited = false;
        return 0;
    }
}
