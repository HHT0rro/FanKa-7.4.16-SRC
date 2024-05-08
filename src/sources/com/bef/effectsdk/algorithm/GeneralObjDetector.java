package com.bef.effectsdk.algorithm;

import android.graphics.Bitmap;
import h0.a;

@a
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class GeneralObjDetector {

    /* renamed from: a, reason: collision with root package name */
    public final int f10442a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final int f10443b = 1;

    @a
    private native long nativeCreate();

    @a
    private native int nativeDestroy(long j10);

    @a
    private native int nativeInit(long j10, long j11, int i10);

    @a
    private native int nativeInitWithPath(long j10, String str, int i10);

    @a
    private native GeneralObjDetectResult nativeProcess(long j10, Bitmap bitmap, int i10);

    @a
    private native int nativeSetParamF(long j10, int i10, float f10);

    @a
    private native int nativeSetParamS(long j10, int i10, String str);
}
