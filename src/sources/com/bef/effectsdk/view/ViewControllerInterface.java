package com.bef.effectsdk.view;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ViewControllerInterface {

    /* renamed from: a, reason: collision with root package name */
    public static final List<String> f10594a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface NativeMessageListener {
    }

    static {
        List<String> asList = Arrays.asList("effect");
        f10594a = asList;
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

    public static int b(long j10, long j11) {
        return nativeAttachEffect(j10, j11);
    }

    public static void c(long[] jArr, int i10) {
        nativeCreateHandle(jArr, i10);
    }

    public static int d(int i10) {
        return nativeDeleteTexture(i10);
    }

    public static int e(long j10) {
        return nativeDestroy(j10);
    }

    public static int f(long j10, int i10, int i11) {
        return nativeInit(j10, i10, i11);
    }

    public static void g(long j10) {
        nativeOnPause(j10);
    }

    public static void h(long j10) {
        nativeOnResume(j10);
    }

    public static int i(long j10, long j11, long j12, long j13, String str) {
        return nativePostMessage(j10, j11, j12, j13, str);
    }

    public static int j(long j10, int i10, int i11, int i12, float[] fArr, float[] fArr2, double d10) {
        return nativeProcess(j10, i10, i11, i12, fArr, fArr2, d10);
    }

    public static int k(long j10, NativeMessageListener nativeMessageListener) {
        return nativeRemoveMessageListener(j10, nativeMessageListener);
    }

    public static int l(long j10, String str, String str2) {
        return nativeSetRenderCacheData(j10, str, str2);
    }

    public static int m(long j10, String str, String str2) {
        return nativeSetRenderCacheTexture(j10, str, str2);
    }

    public static int n(long j10, String str, byte[] bArr, int i10, int i11) {
        return nativeSetRenderCacheTextureWithBuffer(j10, str, bArr, i10, i11);
    }

    private static native int nativeAddMessageListener(long j10, NativeMessageListener nativeMessageListener);

    private static native int nativeAttachEffect(long j10, long j11);

    private static native void nativeCreateHandle(long[] jArr);

    private static native void nativeCreateHandle(long[] jArr, int i10);

    private static native int nativeCreateTexture(int i10, int i11, int i12, int i13, int i14);

    private static native int nativeDeleteTexture(int i10);

    private static native int nativeDestroy(long j10);

    private static native int nativeInit(long j10, int i10, int i11);

    private static native void nativeOnPause(long j10);

    private static native void nativeOnResume(long j10);

    private static native int nativePostMessage(long j10, long j11, long j12, long j13, String str);

    private static native int nativeProcess(long j10, int i10, int i11, int i12, float[] fArr, float[] fArr2, double d10);

    private static native int nativeRemoveMessageListener(long j10, NativeMessageListener nativeMessageListener);

    private static native int nativeSetRenderCacheData(long j10, String str, String str2);

    private static native int nativeSetRenderCacheTexture(long j10, String str, String str2);

    private static native int nativeSetRenderCacheTextureWithBuffer(long j10, String str, byte[] bArr, int i10, int i11);

    private static native int nativeSetResourceFinder(long j10, long j11, long j12);

    private static native int nativeSetStickerPath(long j10, String str);

    private static native int nativeTouchEvent(long j10, int i10, int[] iArr, float[] fArr, float[] fArr2, int i11);

    public static int o(long j10, long j11, long j12) {
        return nativeSetResourceFinder(j10, j11, j12);
    }

    public static int p(long j10, String str) {
        return nativeSetStickerPath(j10, str);
    }

    public static int q(long j10, int[] iArr, float[] fArr, float[] fArr2, int i10) {
        return nativeTouchEvent(j10, 0, iArr, fArr, fArr2, i10);
    }

    public static int r(long j10, int[] iArr, float[] fArr, float[] fArr2, int i10) {
        return nativeTouchEvent(j10, 1, iArr, fArr, fArr2, i10);
    }

    public static int s(long j10, int[] iArr, float[] fArr, float[] fArr2, int i10) {
        return nativeTouchEvent(j10, 2, iArr, fArr, fArr2, i10);
    }
}
