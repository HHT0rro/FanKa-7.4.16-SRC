package io.grpc.internal;

import com.google.common.base.j;
import com.google.common.base.l;
import com.google.common.collect.ImmutableSet;
import io.grpc.Status;
import java.util.Collection;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class HedgingPolicy {
    public final long hedgingDelayNanos;
    public final int maxAttempts;
    public final Set<Status.Code> nonFatalStatusCodes;

    public HedgingPolicy(int i10, long j10, Set<Status.Code> set) {
        this.maxAttempts = i10;
        this.hedgingDelayNanos = j10;
        this.nonFatalStatusCodes = ImmutableSet.copyOf((Collection) set);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || HedgingPolicy.class != obj.getClass()) {
            return false;
        }
        HedgingPolicy hedgingPolicy = (HedgingPolicy) obj;
        return this.maxAttempts == hedgingPolicy.maxAttempts && this.hedgingDelayNanos == hedgingPolicy.hedgingDelayNanos && l.a(this.nonFatalStatusCodes, hedgingPolicy.nonFatalStatusCodes);
    }

    public int hashCode() {
        return l.b(Integer.valueOf(this.maxAttempts), Long.valueOf(this.hedgingDelayNanos), this.nonFatalStatusCodes);
    }

    public String toString() {
        return j.c(this).b("maxAttempts", this.maxAttempts).c("hedgingDelayNanos", this.hedgingDelayNanos).d("nonFatalStatusCodes", this.nonFatalStatusCodes).toString();
    }
}
