package io.grpc.internal;

import com.google.common.base.j;
import com.google.common.base.l;
import com.google.common.collect.ImmutableSet;
import io.grpc.Status;
import java.util.Collection;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class RetryPolicy {
    public final double backoffMultiplier;
    public final long initialBackoffNanos;
    public final int maxAttempts;
    public final long maxBackoffNanos;
    public final Long perAttemptRecvTimeoutNanos;
    public final Set<Status.Code> retryableStatusCodes;

    public RetryPolicy(int i10, long j10, long j11, double d10, Long l10, Set<Status.Code> set) {
        this.maxAttempts = i10;
        this.initialBackoffNanos = j10;
        this.maxBackoffNanos = j11;
        this.backoffMultiplier = d10;
        this.perAttemptRecvTimeoutNanos = l10;
        this.retryableStatusCodes = ImmutableSet.copyOf((Collection) set);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RetryPolicy)) {
            return false;
        }
        RetryPolicy retryPolicy = (RetryPolicy) obj;
        return this.maxAttempts == retryPolicy.maxAttempts && this.initialBackoffNanos == retryPolicy.initialBackoffNanos && this.maxBackoffNanos == retryPolicy.maxBackoffNanos && Double.compare(this.backoffMultiplier, retryPolicy.backoffMultiplier) == 0 && l.a(this.perAttemptRecvTimeoutNanos, retryPolicy.perAttemptRecvTimeoutNanos) && l.a(this.retryableStatusCodes, retryPolicy.retryableStatusCodes);
    }

    public int hashCode() {
        return l.b(Integer.valueOf(this.maxAttempts), Long.valueOf(this.initialBackoffNanos), Long.valueOf(this.maxBackoffNanos), Double.valueOf(this.backoffMultiplier), this.perAttemptRecvTimeoutNanos, this.retryableStatusCodes);
    }

    public String toString() {
        return j.c(this).b("maxAttempts", this.maxAttempts).c("initialBackoffNanos", this.initialBackoffNanos).c("maxBackoffNanos", this.maxBackoffNanos).a("backoffMultiplier", this.backoffMultiplier).d("perAttemptRecvTimeoutNanos", this.perAttemptRecvTimeoutNanos).d("retryableStatusCodes", this.retryableStatusCodes).toString();
    }
}
