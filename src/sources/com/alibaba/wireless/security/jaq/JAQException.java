package com.alibaba.wireless.security.jaq;

import java.io.PrintStream;
import java.io.PrintWriter;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class JAQException extends Exception {

    /* renamed from: а, reason: contains not printable characters */
    private int f147;

    public JAQException(int i10) {
        this.f147 = i10;
    }

    public JAQException(String str, int i10) {
        super(str);
        this.f147 = i10;
    }

    public JAQException(String str, Throwable th, int i10) {
        super(str, th);
        this.f147 = i10;
    }

    public JAQException(Throwable th, int i10) {
        super(th);
        this.f147 = i10;
    }

    public int getErrorCode() {
        return this.f147;
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
        this.f147 = i10;
    }
}
