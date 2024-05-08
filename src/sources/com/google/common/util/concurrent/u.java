package com.google.common.util.concurrent;

import java.lang.Thread;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: ThreadFactoryBuilder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public String f26825a = null;

    /* renamed from: b, reason: collision with root package name */
    public Boolean f26826b = null;

    /* renamed from: c, reason: collision with root package name */
    public Integer f26827c = null;

    /* renamed from: d, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f26828d = null;

    /* renamed from: e, reason: collision with root package name */
    public ThreadFactory f26829e = null;

    /* compiled from: ThreadFactoryBuilder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements ThreadFactory {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ThreadFactory f26830b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f26831c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AtomicLong f26832d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Boolean f26833e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Integer f26834f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Thread.UncaughtExceptionHandler f26835g;

        public a(ThreadFactory threadFactory, String str, AtomicLong atomicLong, Boolean bool, Integer num, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f26830b = threadFactory;
            this.f26831c = str;
            this.f26832d = atomicLong;
            this.f26833e = bool;
            this.f26834f = num;
            this.f26835g = uncaughtExceptionHandler;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread newThread = this.f26830b.newThread(runnable);
            String str = this.f26831c;
            if (str != null) {
                AtomicLong atomicLong = this.f26832d;
                Objects.requireNonNull(atomicLong);
                newThread.setName(u.d(str, Long.valueOf(atomicLong.getAndIncrement())));
            }
            Boolean bool = this.f26833e;
            if (bool != null) {
                newThread.setDaemon(bool.booleanValue());
            }
            Integer num = this.f26834f;
            if (num != null) {
                newThread.setPriority(num.intValue());
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f26835g;
            if (uncaughtExceptionHandler != null) {
                newThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
            }
            return newThread;
        }
    }

    public static ThreadFactory c(u uVar) {
        String str = uVar.f26825a;
        Boolean bool = uVar.f26826b;
        Integer num = uVar.f26827c;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = uVar.f26828d;
        ThreadFactory threadFactory = uVar.f26829e;
        if (threadFactory == null) {
            threadFactory = Executors.defaultThreadFactory();
        }
        return new a(threadFactory, str, str != null ? new AtomicLong(0L) : null, bool, num, uncaughtExceptionHandler);
    }

    public static String d(String str, Object... objArr) {
        return String.format(Locale.ROOT, str, objArr);
    }

    public ThreadFactory b() {
        return c(this);
    }

    public u e(boolean z10) {
        this.f26826b = Boolean.valueOf(z10);
        return this;
    }

    public u f(String str) {
        d(str, 0);
        this.f26825a = str;
        return this;
    }
}
