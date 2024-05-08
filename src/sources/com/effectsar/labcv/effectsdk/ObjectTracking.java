package com.effectsar.labcv.effectsdk;

import android.content.Context;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class ObjectTracking {
    private boolean mInited = false;
    private long mNativePtr;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class ObjectTrackingBoundBox {
        public float centerX;
        public float centerY;
        public float height;
        public float rotateAngle;
        public int status;
        public float timestamp;
        public float width;

        public String toString() {
            return "ObjectTrackingBoundBox{centerX=" + this.centerX + ", centerY=" + this.centerY + ", width=" + this.width + ", height=" + this.height + ", rotateAngle=" + this.rotateAngle + ", timestamp=" + this.timestamp + ", status=" + this.status + '}';
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class ObjectTrackingInitParam {
        public float detectAngleStep;
        public float detectConfirmCandidateThresh;
        public int detectHorizontalGridNum;
        public int detectNumAngle;
        public int detectNumScale;
        public float detectProposeCandidateThresh;
        public float detectScaleStep;
        public int detectVerticalGridNum;
        public boolean needInitialBboxEvaluation;
        public boolean needRedetection;
        public boolean needReset;
        public float padding;
        public int speed;
        public float trackAngleStep;
        public int trackNumAngle;
        public int trackNumScale;
        public float trackScaleStep;
        public float trackThresh;
    }

    static {
        try {
            System.loadLibrary("effect");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }

    private native int nativeCheckLicense(Context context, String str, boolean z10);

    private native int nativeCreate();

    private native int nativeDestroy();

    private native void nativeGetDefaultParam(ObjectTrackingInitParam objectTrackingInitParam);

    private native int nativeInit(String str, ObjectTrackingInitParam objectTrackingInitParam);

    private native int nativeSetInitBox(ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, int i14, ObjectTrackingBoundBox objectTrackingBoundBox);

    private native int nativeTrackFrame(ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, int i14, float f10, ObjectTrackingBoundBox objectTrackingBoundBox);

    public int destroy() {
        if (this.mInited) {
            return nativeDestroy();
        }
        return 0;
    }

    public int init(Context context, String str, String str2, boolean z10) {
        int nativeCreate = nativeCreate();
        if (nativeCreate != 0) {
            return nativeCreate;
        }
        int nativeCheckLicense = nativeCheckLicense(context, str2, z10);
        if (nativeCheckLicense != 0) {
            return nativeCheckLicense;
        }
        ObjectTrackingInitParam objectTrackingInitParam = new ObjectTrackingInitParam();
        nativeGetDefaultParam(objectTrackingInitParam);
        int nativeInit = nativeInit(str, objectTrackingInitParam);
        this.mInited = nativeInit == 0;
        return nativeInit;
    }

    public int setInitBox(ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, int i14, ObjectTrackingBoundBox objectTrackingBoundBox) {
        if (!this.mInited || objectTrackingBoundBox == null) {
            return -1;
        }
        return nativeSetInitBox(byteBuffer, i10, i11, i12, i13, i14, objectTrackingBoundBox);
    }

    public int trackFrame(ByteBuffer byteBuffer, int i10, int i11, int i12, int i13, int i14, double d10, ObjectTrackingBoundBox objectTrackingBoundBox) {
        if (!this.mInited || objectTrackingBoundBox == null) {
            return -1;
        }
        return nativeTrackFrame(byteBuffer, i10, i11, i12, i13, i14, (float) d10, objectTrackingBoundBox);
    }
}
