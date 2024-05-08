package org.greenrobot.eventbus.util;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ThrowableFailureEvent {
    private Object executionContext;
    public final boolean suppressErrorUi;
    public final Throwable throwable;

    public ThrowableFailureEvent(Throwable th) {
        this.throwable = th;
        this.suppressErrorUi = false;
    }

    public Object getExecutionScope() {
        return this.executionContext;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public boolean isSuppressErrorUi() {
        return this.suppressErrorUi;
    }

    public void setExecutionScope(Object obj) {
        this.executionContext = obj;
    }

    public ThrowableFailureEvent(Throwable th, boolean z10) {
        this.throwable = th;
        this.suppressErrorUi = z10;
    }
}
