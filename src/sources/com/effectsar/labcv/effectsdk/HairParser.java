package com.effectsar.labcv.effectsdk;

import android.content.Context;
import com.effectsar.labcv.effectsdk.EffectsSDKEffectConstants;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class HairParser {
    private boolean inited = false;
    private long mNativePtr;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class HairMask {
        private byte[] buffer;
        private int channel;
        private int height;
        private int width;

        public HairMask() {
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

    private native int nativeGetShape(int[] iArr);

    private native int nativeInit(String str);

    private native int nativeParse(ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, int i14, boolean z10, byte[] bArr);

    private native int nativeRelease();

    private native int nativeSetParam(int i10, int i11, boolean z10, boolean z11);

    public int init(Context context, String str, String str2, boolean z10) {
        if (this.inited) {
            return -1;
        }
        int nativeCreateHandle = nativeCreateHandle();
        if (nativeCreateHandle == 0) {
            nativeCreateHandle = nativeCheckLicense(context, str2, z10);
        }
        if (nativeCreateHandle == 0) {
            nativeCreateHandle = nativeInit(str);
        }
        this.inited = nativeCreateHandle == 0;
        return nativeCreateHandle;
    }

    public boolean isInited() {
        return this.inited;
    }

    public HairMask parseHair(ByteBuffer byteBuffer, EffectsSDKEffectConstants.PixlFormat pixlFormat, int i10, int i11, int i12, EffectsSDKEffectConstants.Rotation rotation, boolean z10) {
        HairMask hairMask = new HairMask();
        int[] iArr = new int[3];
        int nativeGetShape = nativeGetShape(iArr);
        if (nativeGetShape == 0) {
            hairMask.width = iArr[0];
            hairMask.height = iArr[1];
            hairMask.channel = iArr[2];
            hairMask.buffer = new byte[hairMask.width * hairMask.height * hairMask.channel];
            Arrays.fill(hairMask.buffer, (byte) 0);
            int nativeParse = nativeParse(byteBuffer, pixlFormat.getValue(), i10, i11, i12, rotation.f19187id, z10, hairMask.buffer);
            if (nativeParse == 0) {
                return hairMask;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("nativeDetect return ");
            sb2.append(nativeParse);
            return null;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("nativeDetect return ");
        sb3.append(nativeGetShape);
        return null;
    }

    public void release() {
        if (this.inited) {
            nativeRelease();
        }
        this.inited = false;
    }

    public int setParam(int i10, int i11, boolean z10, boolean z11) {
        return nativeSetParam(i10, i11, z10, z11);
    }

    public int init(Context context, String str, String str2) {
        return init(context, str, str2, false);
    }
}
