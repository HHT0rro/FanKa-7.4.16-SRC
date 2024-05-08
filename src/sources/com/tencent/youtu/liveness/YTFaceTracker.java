package com.tencent.youtu.liveness;

import android.content.res.AssetManager;
import android.graphics.Rect;
import com.tencent.cloud.huiyansdkface.facelight.c.c.c;
import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class YTFaceTracker {
    private static IYtLoggerListener loggerListener;
    private long nativePtr;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface IYtLoggerListener {
        void log(String str, String str2);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class Param {
        public int biggerFaceMode;
        public int detInterval;
        public int maxFaceSize;
        public int minFaceSize;
        public boolean nonSquareRect;
        public float threshold;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TrackedFace {
        public Rect faceRect;
        public float[] faceShape;
        public float[] faceVisible;
        public int frameId;
        public float pitch;
        public float roll;
        public int traceId;
        public float yaw;
    }

    static {
        System.loadLibrary("YTLiveness");
    }

    public YTFaceTracker(AssetManager assetManager, String str, String str2) throws Exception {
        c.a().a("YTFaceTracker", "asset start NativeConstructor");
        long currentTimeMillis = System.currentTimeMillis();
        int NativeConstructor = NativeConstructor(assetManager, str, str2);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        c.a().a("YTFaceTracker", "asset end NativeConstructor:" + currentTimeMillis2);
        KycWaSDK.getInstance().trackCustomKVEvent(null, "facepage_model_init_yttrack", "asset NativeConstructor:" + currentTimeMillis2 + ",code:" + NativeConstructor, null);
        if (NativeConstructor == 0) {
            return;
        }
        throw new IllegalAccessException("error model dirpath and config filaneme: " + NativeConstructor);
    }

    public YTFaceTracker(String str, String str2) throws Exception {
        c.a().a("YTFaceTracker", "start NativeConstructor");
        long currentTimeMillis = System.currentTimeMillis();
        int NativeConstructor = NativeConstructor(str, str2);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        c.a().a("YTFaceTracker", "end NativeConstructor:" + currentTimeMillis2);
        KycWaSDK.getInstance().trackCustomKVEvent(null, "facepage_model_init_yttrack", "file:" + str + ",code:" + NativeConstructor + ",NativeConstructor:" + currentTimeMillis2, null);
        if (NativeConstructor == 0) {
            return;
        }
        throw new IllegalAccessException("error model dirpath and config filaneme: " + NativeConstructor);
    }

    private native int NativeConstructor(AssetManager assetManager, String str, String str2);

    private native int NativeConstructor(String str, String str2);

    private native void NativeDestructor();

    public static native String getVersion();

    public static void nativeLog(int i10, String str) {
        IYtLoggerListener iYtLoggerListener = loggerListener;
        if (iYtLoggerListener != null) {
            iYtLoggerListener.log("[YTFaceTracker.nativeLog]", str);
        }
    }

    public static native void setLoggerLevel(int i10);

    public static void setLoggerListener(IYtLoggerListener iYtLoggerListener) {
        loggerListener = iYtLoggerListener;
    }

    public void destroy() {
        c.a().a("YTFaceTracker", "start NativeDestructor");
        long currentTimeMillis = System.currentTimeMillis();
        NativeDestructor();
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        c.a().a("YTFaceTracker", "end NativeDestructor:" + currentTimeMillis2);
        KycWaSDK.getInstance().trackCustomKVEvent(null, "facepage_model_release_yttrack", currentTimeMillis2 + "ms", null);
    }

    public void finalize() {
        NativeDestructor();
    }

    public native Param getParam();

    public native void reset();

    public native void setParam(Param param);

    public native TrackedFace[] track(int i10, byte[] bArr, int i11, int i12, int i13, boolean z10, byte[] bArr2) throws Exception;
}
