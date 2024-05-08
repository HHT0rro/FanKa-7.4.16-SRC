package io.grpc.internal;

import io.grpc.SynchronizationContext;
import io.grpc.internal.BackoffPolicy;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class BackoffPolicyRetryScheduler implements RetryScheduler {
    private static final Logger logger = Logger.getLogger(BackoffPolicyRetryScheduler.class.getName());
    private BackoffPolicy policy;
    private final BackoffPolicy.Provider policyProvider;
    private final ScheduledExecutorService scheduledExecutorService;
    private SynchronizationContext.ScheduledHandle scheduledHandle;
    private final SynchronizationContext syncContext;

    public BackoffPolicyRetryScheduler(BackoffPolicy.Provider provider, ScheduledExecutorService scheduledExecutorService, SynchronizationContext synchronizationContext) {
        this.policyProvider = provider;
        this.scheduledExecutorService = scheduledExecutorService;
        this.syncContext = synchronizationContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reset$0() {
        SynchronizationContext.ScheduledHandle scheduledHandle = this.scheduledHandle;
        if (scheduledHandle != null && scheduledHandle.isPending()) {
            this.scheduledHandle.cancel();
        }
        this.policy = null;
    }

    @Override // io.grpc.internal.RetryScheduler
    public void reset() {
        this.syncContext.throwIfNotInThisSynchronizationContext();
        this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.a
            @Override // java.lang.Runnable
            public final void run() {
                BackoffPolicyRetryScheduler.this.lambda$reset$0();
            }
        });
    }

    @Override // io.grpc.internal.RetryScheduler
    public void schedule(Runnable runnable) {
        this.syncContext.throwIfNotInThisSynchronizationContext();
        if (this.policy == null) {
            this.policy = this.policyProvider.get();
        }
        SynchronizationContext.ScheduledHandle scheduledHandle = this.scheduledHandle;
        if (scheduledHandle == null || !scheduledHandle.isPending()) {
            long nextBackoffNanos = this.policy.nextBackoffNanos();
            this.scheduledHandle = this.syncContext.schedule(runnable, nextBackoffNanos, TimeUnit.NANOSECONDS, this.scheduledExecutorService);
            logger.log(Level.FINE, "Scheduling DNS resolution backoff for {0}ns", Long.valueOf(nextBackoffNanos));
        }
    }
}
