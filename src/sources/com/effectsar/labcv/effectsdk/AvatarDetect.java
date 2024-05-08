package com.effectsar.labcv.effectsdk;

import com.effectsar.labcv.effectsdk.EffectsSDKEffectConstants;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class AvatarDetect {
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

    private native int nativeDetect(ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, int i14, BefAvatarInfo befAvatarInfo);

    private native int nativeDetect(ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, int i14, BefFaceInfo befFaceInfo, BefAvatarInfo befAvatarInfo);

    private native int nativeRelease();

    private native int nativeSetEscale(int i10);

    private native int nativeSetModel(String str, int i10, int i11);

    public BefAvatarInfo detect(ByteBuffer byteBuffer, EffectsSDKEffectConstants.PixlFormat pixlFormat, int i10, int i11, int i12, EffectsSDKEffectConstants.Rotation rotation) {
        if (!this.mInited) {
            return null;
        }
        BefAvatarInfo befAvatarInfo = new BefAvatarInfo();
        int nativeDetect = nativeDetect(byteBuffer, pixlFormat.getValue(), i10, i11, i12, rotation.f19187id, befAvatarInfo);
        if (nativeDetect == 0) {
            return befAvatarInfo;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("native detect return ");
        sb2.append(nativeDetect);
        return null;
    }

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

    public void release() {
        if (this.mInited) {
            nativeRelease();
        }
        this.mInited = false;
    }

    public int setEscale(int i10) {
        return nativeSetEscale(i10);
    }

    public int setModel(String str, int i10, int i11) {
        return nativeSetModel(str, i10, i11);
    }

    public int init(String str) {
        return init(str, false);
    }

    public BefAvatarInfo detect(ByteBuffer byteBuffer, EffectsSDKEffectConstants.PixlFormat pixlFormat, int i10, int i11, int i12, EffectsSDKEffectConstants.Rotation rotation, BefFaceInfo befFaceInfo) {
        if (!this.mInited) {
            return null;
        }
        BefAvatarInfo befAvatarInfo = new BefAvatarInfo();
        int nativeDetect = nativeDetect(byteBuffer, pixlFormat.getValue(), i10, i11, i12, rotation.f19187id, befFaceInfo, befAvatarInfo);
        if (nativeDetect == 0) {
            return befAvatarInfo;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("native detect return ");
        sb2.append(nativeDetect);
        return null;
    }
}
