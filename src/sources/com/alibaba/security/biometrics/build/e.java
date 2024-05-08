package com.alibaba.security.biometrics.build;

import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;

/* compiled from: SystemCameraException.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class e extends Exception {
    private int mErrorCode;

    public e() {
    }

    private int a() {
        return this.mErrorCode;
    }

    private e(String str) {
        super(str);
        this.mErrorCode = GlobalErrorCode.ERROR_DEVICE_CAMERA_INIT;
    }

    private e(int i10, String str) {
        super(str);
        this.mErrorCode = i10;
    }

    private e(Throwable th) {
        super(th);
        this.mErrorCode = GlobalErrorCode.ERROR_DEVICE_CAMERA_INIT;
    }

    private e(String str, Throwable th) {
        super(str, th);
        this.mErrorCode = GlobalErrorCode.ERROR_DEVICE_CAMERA_INIT;
    }
}
