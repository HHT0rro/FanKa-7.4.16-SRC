package com.alibaba.wireless.security.open;

import java.io.PrintStream;
import java.io.PrintWriter;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class SecException extends Exception {
    public static final int ERROR_NULL_CONTEXT = -100;

    /* renamed from: а, reason: contains not printable characters */
    private int f162;

    public SecException(int i10) {
        this.f162 = i10;
    }

    public SecException(String str, int i10) {
        super(str);
        this.f162 = i10;
    }

    public SecException(String str, Throwable th, int i10) {
        super(str, th);
        this.f162 = i10;
    }

    public SecException(Throwable th, int i10) {
        super(th);
        this.f162 = i10;
    }

    public int getErrorCode() {
        return this.f162;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        printStream.println("ErrorCode = " + getErrorCode());
        super.printStackTrace(printStream);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        printWriter.println("ErrorCode = " + getErrorCode());
        super.printStackTrace(printWriter);
    }

    public void setErrorCode(int i10) {
        this.f162 = i10;
    }
}
