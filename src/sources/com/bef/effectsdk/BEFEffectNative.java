package com.bef.effectsdk;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class BEFEffectNative {
    public static final int BEF_CLOCKWISE_ROTATE_0 = 0;
    public static final int BEF_CLOCKWISE_ROTATE_180 = 2;
    public static final int BEF_CLOCKWISE_ROTATE_270 = 3;
    public static final int BEF_CLOCKWISE_ROTATE_90 = 1;
    private static final List<String> list;

    static {
        List<String> asList = Arrays.asList("effect");
        list = asList;
        try {
            Iterator<String> iterator2 = asList.iterator2();
            while (iterator2.hasNext()) {
                System.loadLibrary(iterator2.next());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static long createHandle(boolean z10) {
        return nativeCreateHandle(z10);
    }

    public static int destroyHandle(long j10) {
        return nativeDestroyHandle(j10);
    }

    public static String getEffectSDKVersion() {
        return nativeGetEffectSDKVersion();
    }

    public static int initResourceFinder(long j10, ResourceFinder resourceFinder, int i10, int i11, String str) {
        return nativeInitResourceFinder(j10, resourceFinder, i10, i11, str);
    }

    private static native long nativeCreateHandle(boolean z10);

    private static native int nativeDestroyHandle(long j10);

    private static native String nativeGetEffectSDKVersion();

    private static native int nativeInitResourceFinder(long j10, ResourceFinder resourceFinder, int i10, int i11, String str);

    private static native int nativeProcessAlgorithm(long j10, int i10, int i11, int i12, double d10);

    private static native int nativeProcessFrame(long j10, int i10, int i11, int i12, int i13, double d10);

    private static native int nativeReleaseResourceFinder(long j10, ResourceFinder resourceFinder);

    private static native int nativeSendMessage(long j10, long j11, long j12, long j13, String str);

    private static native void nativeSetCameraPosition(long j10, boolean z10);

    private static native void nativeSetFrameOrientation(long j10, int i10);

    private static native void nativeSetOrientation(long j10, int i10);

    private static native int nativeSetStickerPath(long j10, String str);

    private static native int nativeTouchEvent(long j10, int i10, int[] iArr, float[] fArr, float[] fArr2);

    public static int processAlgorithm(long j10, int i10, int i11, int i12, double d10) {
        return nativeProcessAlgorithm(j10, i10, i11, i12, d10);
    }

    public static int processFrame(long j10, int i10, int i11, int i12, int i13, double d10) {
        return nativeProcessFrame(j10, i10, i11, i12, i13, d10);
    }

    public static int releaseResourceFinder(long j10, ResourceFinder resourceFinder) {
        return nativeReleaseResourceFinder(j10, resourceFinder);
    }

    public static int sendMessage(long j10, long j11, long j12, long j13, String str) {
        return nativeSendMessage(j10, j11, j12, j13, str);
    }

    public static void setCameraPosition(long j10, boolean z10) {
        nativeSetCameraPosition(j10, z10);
    }

    public static void setFrameOrientation(long j10, int i10) {
        nativeSetFrameOrientation(j10, i10);
    }

    public static void setOrientation(long j10, int i10) {
        nativeSetOrientation(j10, i10);
    }

    public static int setStickerPath(long j10, String str) {
        return nativeSetStickerPath(j10, str);
    }

    public static int touchBeginEvent(long j10, int[] iArr, float[] fArr, float[] fArr2) {
        return nativeTouchEvent(j10, 0, iArr, fArr, fArr2);
    }

    public static int touchEndEvent(long j10, int[] iArr, float[] fArr, float[] fArr2) {
        return nativeTouchEvent(j10, 2, iArr, fArr, fArr2);
    }

    public static int touchMoveEvent(long j10, int[] iArr, float[] fArr, float[] fArr2) {
        return nativeTouchEvent(j10, 1, iArr, fArr, fArr2);
    }
}
