package com.bef.effectsdk.game;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class NativeInterface {

    /* renamed from: a, reason: collision with root package name */
    public static final List<String> f10513a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface NativeMessageListener {
    }

    static {
        List<String> asList = Arrays.asList("effect");
        f10513a = asList;
        try {
            Iterator<String> iterator2 = asList.iterator2();
            while (iterator2.hasNext()) {
                System.loadLibrary(iterator2.next());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static int a(long j10, NativeMessageListener nativeMessageListener) {
        return nativeAddMessageListener(j10, nativeMessageListener);
    }

    public static void b(long[] jArr) {
        nativeCreateHandle(jArr);
    }

    public static int c(long j10) {
        return nativeDestroy(j10);
    }

    public static int d(long j10, int i10, int i11) {
        return nativeInit(j10, i10, i11);
    }

    public static int e(long j10, int i10, int i11, double d10) {
        return nativeProcess(j10, i10, i11, d10);
    }

    public static int f(long j10, String str) {
        return nativeSetStickerPath(j10, str);
    }

    public static int g(long j10, int i10, int i11) {
        return nativeSetSize(j10, i10, i11);
    }

    public static int h(long j10, int[] iArr, float[] fArr, float[] fArr2) {
        return nativeTouchesBegin(j10, iArr, fArr, fArr2);
    }

    public static int i(long j10, int[] iArr, float[] fArr, float[] fArr2) {
        return nativeTouchesEnd(j10, iArr, fArr, fArr2);
    }

    public static int j(long j10, int[] iArr, float[] fArr, float[] fArr2) {
        return nativeTouchesMove(j10, iArr, fArr, fArr2);
    }

    private static native int nativeAddMessageListener(long j10, NativeMessageListener nativeMessageListener);

    private static native void nativeCreateHandle(long[] jArr);

    private static native int nativeDestroy(long j10);

    private static native int nativeInit(long j10, int i10, int i11);

    private static native int nativePause(long j10);

    private static native int nativePostMessage(long j10, long j11, long j12, long j13, String str);

    private static native int nativeProcess(long j10, int i10, int i11, double d10);

    private static native int nativeRemoveMessageListener(long j10, NativeMessageListener nativeMessageListener);

    private static native int nativeResume(long j10);

    private static native int nativeSetSize(long j10, int i10, int i11);

    private static native int nativeSetStickerPath(long j10, String str);

    private static native int nativeTouchesBegin(long j10, int[] iArr, float[] fArr, float[] fArr2);

    private static native int nativeTouchesEnd(long j10, int[] iArr, float[] fArr, float[] fArr2);

    private static native int nativeTouchesMove(long j10, int[] iArr, float[] fArr, float[] fArr2);
}
