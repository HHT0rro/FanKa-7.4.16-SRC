package io.grpc.internal;

import io.grpc.Attributes;
import io.grpc.NameResolver;
import io.grpc.Status;
import io.grpc.SynchronizationContext;
import io.grpc.internal.RetryingNameResolver;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class RetryingNameResolver extends ForwardingNameResolver {
    public static final Attributes.Key<ResolutionResultListener> RESOLUTION_RESULT_LISTENER_KEY = Attributes.Key.create("io.grpc.internal.RetryingNameResolver.RESOLUTION_RESULT_LISTENER_KEY");
    private final NameResolver retriedNameResolver;
    private final RetryScheduler retryScheduler;
    private final SynchronizationContext syncContext;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class DelayedNameResolverRefresh implements Runnable {
        public DelayedNameResolverRefresh() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RetryingNameResolver.this.refresh();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class ResolutionResultListener {
        public ResolutionResultListener() {
        }

        public void resolutionAttempted(boolean z10) {
            if (z10) {
                RetryingNameResolver.this.retryScheduler.reset();
            } else {
                RetryingNameResolver.this.retryScheduler.schedule(new DelayedNameResolverRefresh());
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class RetryingListener extends NameResolver.Listener2 {
        private NameResolver.Listener2 delegateListener;

        public RetryingListener(NameResolver.Listener2 listener2) {
            this.delegateListener = listener2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onError$0() {
            RetryingNameResolver.this.retryScheduler.schedule(new DelayedNameResolverRefresh());
        }

        @Override // io.grpc.NameResolver.Listener2, io.grpc.NameResolver.Listener
        public void onError(Status status) {
            this.delegateListener.onError(status);
            RetryingNameResolver.this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.b
                @Override // java.lang.Runnable
                public final void run() {
                    RetryingNameResolver.RetryingListener.this.lambda$onError$0();
                }
            });
        }

        @Override // io.grpc.NameResolver.Listener2
        public void onResult(NameResolver.ResolutionResult resolutionResult) {
            Attributes attributes = resolutionResult.getAttributes();
            Attributes.Key<ResolutionResultListener> key = RetryingNameResolver.RESOLUTION_RESULT_LISTENER_KEY;
            if (attributes.get(key) == null) {
                this.delegateListener.onResult(resolutionResult.toBuilder().setAttributes(resolutionResult.getAttributes().toBuilder().set(key, new ResolutionResultListener()).build()).build());
                return;
            }
            throw new IllegalStateException("RetryingNameResolver can only be used once to wrap a NameResolver");
        }
    }

    public RetryingNameResolver(NameResolver nameResolver, RetryScheduler retryScheduler, SynchronizationContext synchronizationContext) {
        super(nameResolver);
        this.retriedNameResolver = nameResolver;
        this.retryScheduler = retryScheduler;
        this.syncContext = synchronizationContext;
    }

    public NameResolver getRetriedNameResolver() {
        return this.retriedNameResolver;
    }

    @Override // io.grpc.internal.ForwardingNameResolver, io.grpc.NameResolver
    public void shutdown() {
        super.shutdown();
        this.retryScheduler.reset();
    }

    @Override // io.grpc.internal.ForwardingNameResolver, io.grpc.NameResolver
    public void start(NameResolver.Listener2 listener2) {
        super.start((NameResolver.Listener2) new RetryingListener(listener2));
    }
}
