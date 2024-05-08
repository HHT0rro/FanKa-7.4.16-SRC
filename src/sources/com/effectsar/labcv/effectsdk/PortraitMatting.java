package com.effectsar.labcv.effectsdk;

import android.content.Context;
import com.effectsar.labcv.effectsdk.EffectsSDKEffectConstants;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class PortraitMatting {
    private boolean inited = false;
    private long mNativePtr;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class MattingMask {
        private byte[] buffer;
        private int height;
        private int width;

        public MattingMask() {
        }

        public byte[] getBuffer() {
            return this.buffer;
        }

        public int getHeight() {
            return this.height;
        }

        public int getWidth() {
            return this.width;
        }

        public String toString() {
            return String.format("l: %d w:%d, h:%d", Integer.valueOf(this.buffer.length), Integer.valueOf(this.width), Integer.valueOf(this.height));
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

    private native int nativeCreateHandle();

    private native int nativeInit(String str, int i10);

    private native int nativeMatting(ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, int i14, boolean z10, MattingMask mattingMask);

    private native int nativeRelease();

    private native int nativeSetParam(int i10, int i11);

    public MattingMask detectMatting(ByteBuffer byteBuffer, EffectsSDKEffectConstants.PixlFormat pixlFormat, int i10, int i11, int i12, EffectsSDKEffectConstants.Rotation rotation, boolean z10) {
        MattingMask mattingMask = new MattingMask();
        int nativeMatting = nativeMatting(byteBuffer, pixlFormat.getValue(), i10, i11, i12, rotation.f19187id, z10, mattingMask);
        if (nativeMatting == 0) {
            return mattingMask;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("nativeMatting return ");
        sb2.append(nativeMatting);
        return null;
    }

    public int init(Context context, String str, EffectsSDKEffectConstants.PortraitMatting portraitMatting, String str2, boolean z10) {
        if (this.inited) {
            return -1;
        }
        int nativeCreateHandle = nativeCreateHandle();
        if (nativeCreateHandle == 0) {
            nativeCreateHandle = nativeCheckLicense(context, str2, z10);
        }
        if (nativeCreateHandle == 0) {
            nativeCreateHandle = nativeInit(str, portraitMatting.getValue());
            setParam(EffectsSDKEffectConstants.PorraitMattingParamType.BEF_MP_EdgeMode, 1);
        }
        this.inited = nativeCreateHandle == 0;
        return nativeCreateHandle;
    }

    public boolean isInited() {
        return this.inited;
    }

    public void release() {
        if (this.inited) {
            nativeRelease();
        }
        this.inited = false;
    }

    public int setParam(EffectsSDKEffectConstants.PorraitMattingParamType porraitMattingParamType, int i10) {
        return nativeSetParam(porraitMattingParamType.getValue(), i10);
    }

    public int init(Context context, String str, EffectsSDKEffectConstants.PortraitMatting portraitMatting, String str2) {
        return init(context, str, portraitMatting, str2, false);
    }
}
