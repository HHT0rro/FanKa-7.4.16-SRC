package com.tencent.cloud.huiyansdkface.okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ForwardingTimeout extends Timeout {
    private Timeout delegate;

    public ForwardingTimeout(Timeout timeout) {
        if (timeout == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.delegate = timeout;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.Timeout
    public Timeout clearDeadline() {
        return this.delegate.clearDeadline();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.Timeout
    public Timeout clearTimeout() {
        return this.delegate.clearTimeout();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.Timeout
    public long deadlineNanoTime() {
        return this.delegate.deadlineNanoTime();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.Timeout
    public Timeout deadlineNanoTime(long j10) {
        return this.delegate.deadlineNanoTime(j10);
    }

    public final Timeout delegate() {
        return this.delegate;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.Timeout
    public boolean hasDeadline() {
        return this.delegate.hasDeadline();
    }

    public final ForwardingTimeout setDelegate(Timeout timeout) {
        if (timeout == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.delegate = timeout;
        return this;
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.Timeout
    public void throwIfReached() throws IOException {
        this.delegate.throwIfReached();
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.Timeout
    public Timeout timeout(long j10, TimeUnit timeUnit) {
        return this.delegate.timeout(j10, timeUnit);
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.Timeout
    public long timeoutNanos() {
        return this.delegate.timeoutNanos();
    }
}
