package com.alibaba.security.biometrics.service.detector;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class FaceRecapNetImpl implements ILocalFaceRecap<Object> {
    @Override // com.alibaba.security.biometrics.service.detector.ILocalFaceRecap
    public float[] calcSimilarScore(Object obj, Object obj2) {
        return new float[0];
    }

    @Override // com.alibaba.security.biometrics.service.detector.ILocalFaceRecap
    public float getRecapResult() {
        return 0.0f;
    }

    @Override // com.alibaba.security.biometrics.service.detector.ILocalFaceRecap
    public void inference(byte[] bArr, int i10, int i11, int i12) {
    }

    @Override // com.alibaba.security.biometrics.service.detector.ILocalFaceRecap
    public void prepare(Context context, OnLocalRecapPreparedListener onLocalRecapPreparedListener) {
        if (onLocalRecapPreparedListener != null) {
            onLocalRecapPreparedListener.onSucceeded(this);
        }
    }

    @Override // com.alibaba.security.biometrics.service.detector.ILocalFaceRecap
    public void release() {
    }
}
