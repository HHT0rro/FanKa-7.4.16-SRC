package com.nirvana.tools.requestqueue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class TimeoutResponse implements Response {
    private boolean isTimeout;

    public TimeoutResponse(boolean z10) {
        this.isTimeout = z10;
    }

    public abstract boolean isResultTimeout();

    @Override // com.nirvana.tools.requestqueue.Response
    public final boolean isTimeout() {
        if (this.isTimeout) {
            return true;
        }
        return isResultTimeout();
    }

    public void setTimeout(boolean z10) {
        this.isTimeout = z10;
    }
}
