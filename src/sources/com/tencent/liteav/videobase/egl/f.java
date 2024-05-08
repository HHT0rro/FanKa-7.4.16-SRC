package com.tencent.liteav.videobase.egl;

import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class f extends IOException {
    private static final long serialVersionUID = 2723743254380545567L;
    public final int mErrorCode;
    private final String mErrorMessage;

    public f(int i10) {
        this(i10, "");
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        if (this.mErrorMessage != null) {
            return "EGL error code: " + this.mErrorCode + ", " + this.mErrorMessage;
        }
        return "EGL error code: " + this.mErrorCode + ", " + super.getMessage();
    }

    public f(int i10, String str) {
        super(str);
        this.mErrorCode = i10;
        this.mErrorMessage = str;
    }

    public f(int i10, String str, Throwable th) {
        super(str, th);
        this.mErrorCode = i10;
        this.mErrorMessage = str;
    }
}
