package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: MoreExecutors.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class p {

    /* compiled from: MoreExecutors.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements Executor {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Executor f26823b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AbstractFuture f26824c;

        public a(Executor executor, AbstractFuture abstractFuture) {
            this.f26823b = executor;
            this.f26824c = abstractFuture;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            try {
                this.f26823b.execute(runnable);
            } catch (RejectedExecutionException e2) {
                this.f26824c.setException(e2);
            }
        }
    }

    public static Executor a() {
        return DirectExecutor.INSTANCE;
    }

    public static Executor b(Executor executor, AbstractFuture<?> abstractFuture) {
        com.google.common.base.o.r(executor);
        com.google.common.base.o.r(abstractFuture);
        return executor == a() ? executor : new a(executor, abstractFuture);
    }
}
