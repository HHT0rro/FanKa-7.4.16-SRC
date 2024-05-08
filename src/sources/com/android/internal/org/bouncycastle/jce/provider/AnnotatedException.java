package com.android.internal.org.bouncycastle.jce.provider;

import com.android.internal.org.bouncycastle.jce.exception.ExtException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class AnnotatedException extends Exception implements ExtException {
    private Throwable _underlyingException;

    public AnnotatedException(String string, Throwable e2) {
        super(string);
        this._underlyingException = e2;
    }

    public AnnotatedException(String string) {
        this(string, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Throwable getUnderlyingException() {
        return this._underlyingException;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this._underlyingException;
    }
}
