package com.alibaba.security.biometrics.service.detector;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface OnLocalRecapPreparedListener {
    void onFailed(int i10, Throwable th);

    void onProgressUpdate(int i10);

    void onSucceeded(ILocalFaceRecap iLocalFaceRecap);
}
