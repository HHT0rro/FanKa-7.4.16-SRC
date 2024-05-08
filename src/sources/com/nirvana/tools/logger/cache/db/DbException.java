package com.nirvana.tools.logger.cache.db;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DbException extends Throwable {
    private Throwable originalThrowable;

    public DbException(String str, Throwable th) {
        super(str);
        this.originalThrowable = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        Throwable th = this.originalThrowable;
        return th != null ? th.getCause() : this;
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        Throwable th = this.originalThrowable;
        return th != null ? th.getLocalizedMessage() : super.getLocalizedMessage();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        Throwable th = this.originalThrowable;
        return th != null ? th.getMessage() : super.getMessage();
    }

    @Override // java.lang.Throwable
    public StackTraceElement[] getStackTrace() {
        Throwable th = this.originalThrowable;
        return th != null ? th.getStackTrace() : super.getStackTrace();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        Throwable th = this.originalThrowable;
        if (th != null) {
            th.printStackTrace();
        } else {
            super.printStackTrace();
        }
    }
}
