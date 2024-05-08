package com.effectsar.labcv.effectsdk;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class NightScene {
    private boolean mInited;
    private long mNativePtr;

    static {
        try {
            System.loadLibrary("effect");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }

    private native int nativeCreate(String str, boolean z10);

    private native int nativeProcess(int i10, Integer num, int i11, int i12);

    private native int nativeRelease();

    public int init(String str, boolean z10) {
        int nativeCreate = nativeCreate(str, z10);
        if (nativeCreate != 0) {
            this.mInited = false;
            return nativeCreate;
        }
        this.mInited = true;
        return nativeCreate;
    }

    public boolean isInited() {
        return this.mInited;
    }

    public int process(int i10, Integer num, int i11, int i12) {
        if (!this.mInited) {
            return -1;
        }
        int nativeProcess = nativeProcess(i10, num, i11, i12);
        if (nativeProcess != 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("nativeNightSceneProcess ");
            sb2.append(nativeProcess);
        }
        return nativeProcess;
    }

    public void release() {
        if (this.mInited) {
            nativeRelease();
        }
        this.mInited = false;
    }

    public int init(String str) {
        return init(str, false);
    }
}
