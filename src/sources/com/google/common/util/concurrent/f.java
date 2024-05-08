package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: ExecutionList.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class f {

    /* renamed from: c, reason: collision with root package name */
    public static final Logger f26812c = Logger.getLogger(f.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public a f26813a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f26814b;

    /* compiled from: ExecutionList.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Runnable f26815a;

        /* renamed from: b, reason: collision with root package name */
        public final Executor f26816b;

        /* renamed from: c, reason: collision with root package name */
        public a f26817c;

        public a(Runnable runnable, Executor executor, a aVar) {
            this.f26815a = runnable;
            this.f26816b = executor;
            this.f26817c = aVar;
        }
    }

    public static void c(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = f26812c;
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 57 + valueOf2.length());
            sb2.append("RuntimeException while executing runnable ");
            sb2.append(valueOf);
            sb2.append(" with executor ");
            sb2.append(valueOf2);
            logger.log(level, sb2.toString(), (Throwable) e2);
        }
    }

    public void a(Runnable runnable, Executor executor) {
        com.google.common.base.o.s(runnable, "Runnable was null.");
        com.google.common.base.o.s(executor, "Executor was null.");
        synchronized (this) {
            if (!this.f26814b) {
                this.f26813a = new a(runnable, executor, this.f26813a);
            } else {
                c(runnable, executor);
            }
        }
    }

    public void b() {
        synchronized (this) {
            if (this.f26814b) {
                return;
            }
            this.f26814b = true;
            a aVar = this.f26813a;
            a aVar2 = null;
            this.f26813a = null;
            while (aVar != null) {
                a aVar3 = aVar.f26817c;
                aVar.f26817c = aVar2;
                aVar2 = aVar;
                aVar = aVar3;
            }
            while (aVar2 != null) {
                c(aVar2.f26815a, aVar2.f26816b);
                aVar2 = aVar2.f26817c;
            }
        }
    }
}
