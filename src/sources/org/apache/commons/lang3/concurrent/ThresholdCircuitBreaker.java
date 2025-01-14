package org.apache.commons.lang3.concurrent;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ThresholdCircuitBreaker extends AbstractCircuitBreaker<Long> {
    private static final long INITIAL_COUNT = 0;
    private final long threshold;
    private final AtomicLong used = new AtomicLong(0);

    public ThresholdCircuitBreaker(long j10) {
        this.threshold = j10;
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker, org.apache.commons.lang3.concurrent.CircuitBreaker
    public boolean checkState() {
        return isOpen();
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker, org.apache.commons.lang3.concurrent.CircuitBreaker
    public void close() {
        super.close();
        this.used.set(0L);
    }

    public long getThreshold() {
        return this.threshold;
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker, org.apache.commons.lang3.concurrent.CircuitBreaker
    public boolean incrementAndCheckState(Long l10) {
        if (this.threshold == 0) {
            open();
        }
        if (this.used.addAndGet(l10.longValue()) > this.threshold) {
            open();
        }
        return checkState();
    }
}
