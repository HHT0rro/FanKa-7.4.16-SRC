package com.alibaba.security.biometrics.service.detector;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface ILocalFaceRecap<T> {
    float[] calcSimilarScore(T t2, T t10);

    float getRecapResult();

    void inference(byte[] bArr, int i10, int i11, int i12);

    void prepare(Context context, OnLocalRecapPreparedListener onLocalRecapPreparedListener);

    void release();
}
