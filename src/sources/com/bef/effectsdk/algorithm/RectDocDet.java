package com.bef.effectsdk.algorithm;

import android.graphics.Bitmap;
import h0.a;

@a
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class RectDocDet {
    @a
    private native long nativeCreate();

    @a
    private native int nativeDestroy(long j10);

    @a
    private native int nativeInit(long j10, long j11, int i10);

    @a
    private native int nativeInitWithPath(long j10, String str, int i10);

    @a
    private native RectDocDetResult nativeProcess(long j10, Bitmap bitmap, int i10);

    @a
    private native int nativeSetParamF(long j10, int i10, float f10);
}
