package com.effectsar.labcv.effectsdk;

import android.content.Context;
import com.effectsar.labcv.effectsdk.EffectsSDKEffectConstants;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class CineMove {
    public static String TAG;
    private boolean mInited;
    private boolean mIsFirstFrame;
    private long mNativePtr;
    private ByteBuffer mResultBuffer = null;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum CINE_MOVE_FEATURE_TYPE {
        CINE_MOVE_FEATURE_FACE_RECT(0),
        CINE_MOVE_FEATURE_BODY_RECT(1),
        CINE_MOVE_FEATURE_FACE_POINT(2),
        CINE_MOVE_FEATURE_BODY_POINT(3),
        CINE_MOVE_FEATURE_MOTION_POINT(4),
        CINE_MOVE_FEATURE_OBJECT_POINT(5);

        private final int type;

        CINE_MOVE_FEATURE_TYPE(int i10) {
            this.type = i10;
        }

        public int getType() {
            return this.type;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum CINE_MOVE_TYPE {
        CINE_MOVE_ALG_START(0),
        CINE_MOVE_ALG_V1(1),
        CINE_MOVE_ALG_V2(2),
        CINE_MOVE_ALG_V3(3),
        CINE_MOVE_ALG_RHYTHMIC_V4(4),
        CINE_MOVE_ALG_CENTER_FOCUS(5),
        CINE_MOVE_ALG_Y_COOR_V6(6),
        CINE_MOVE_ALG_ROT_V7(7),
        CINE_MOVE_ALG_SNAKE_V8(8),
        CINE_MOVE_ALG_HEART_BEAT_V9(9),
        CINE_MOVE_ALG_BREATH_V10(10),
        CINE_MOVE_ALG_ROT360_V11(11),
        CINE_MOVE_ALG_END(12);

        private final int type;

        CINE_MOVE_TYPE(int i10) {
            this.type = i10;
        }

        public int getType() {
            return this.type;
        }
    }

    static {
        try {
            System.loadLibrary("effect");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
        TAG = "CineMove";
    }

    private native int nativeCreate(int i10, String str, boolean z10);

    private native int nativeProcess(int i10, int i11, int i12, int i13, int i14, boolean z10, boolean z11, Integer num);

    private native int nativeRelease();

    public int init(Context context, int i10, String str, boolean z10) {
        int nativeCreate = nativeCreate(i10, str, z10);
        this.mInited = nativeCreate == 0;
        this.mIsFirstFrame = true;
        return nativeCreate;
    }

    public boolean isInited() {
        return this.mInited;
    }

    public int process(int i10, EffectsSDKEffectConstants.PixlFormat pixlFormat, int i11, int i12, int i13, boolean z10, Integer num) {
        if (!this.mInited) {
            return -1;
        }
        int nativeProcess = nativeProcess(i10, pixlFormat.getValue(), i11, i12, i13, this.mIsFirstFrame, z10, num);
        if (nativeProcess != 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("native detect return ");
            sb2.append(nativeProcess);
        }
        if (this.mIsFirstFrame) {
            this.mIsFirstFrame = false;
        }
        return nativeProcess;
    }

    public void release() {
        if (this.mInited) {
            nativeRelease();
        }
        this.mInited = false;
        this.mIsFirstFrame = true;
    }
}
