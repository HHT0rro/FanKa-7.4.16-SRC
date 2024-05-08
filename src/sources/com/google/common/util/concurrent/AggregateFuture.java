package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.i1;
import java.util.logging.Logger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class AggregateFuture<InputT, OutputT> extends c<OutputT> {

    /* renamed from: g, reason: collision with root package name */
    public static final Logger f26783g = Logger.getLogger(AggregateFuture.class.getName());

    /* renamed from: f, reason: collision with root package name */
    public ImmutableCollection<? extends n<? extends InputT>> f26784f;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum ReleaseResourcesReason {
        OUTPUT_FUTURE_DONE,
        ALL_INPUT_FUTURES_PROCESSED
    }

    public void a(ReleaseResourcesReason releaseResourcesReason) {
        com.google.common.base.o.r(releaseResourcesReason);
        this.f26784f = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        super.afterDone();
        ImmutableCollection<? extends n<? extends InputT>> immutableCollection = this.f26784f;
        a(ReleaseResourcesReason.OUTPUT_FUTURE_DONE);
        if (isCancelled() && (immutableCollection != null)) {
            boolean wasInterrupted = wasInterrupted();
            i1<? extends n<? extends InputT>> iterator2 = immutableCollection.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().cancel(wasInterrupted);
            }
        }
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final String pendingToString() {
        ImmutableCollection<? extends n<? extends InputT>> immutableCollection = this.f26784f;
        if (immutableCollection != null) {
            String valueOf = String.valueOf(immutableCollection);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 8);
            sb2.append("futures=");
            sb2.append(valueOf);
            return sb2.toString();
        }
        return super.pendingToString();
    }
}
