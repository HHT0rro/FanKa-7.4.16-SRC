package com.tencent.cloud.huiyansdkface.okhttp3;

import com.tencent.cloud.huiyansdkface.okhttp3.RealCall;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class Dispatcher {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ boolean f41389a = true;

    /* renamed from: d, reason: collision with root package name */
    private Runnable f41392d;

    /* renamed from: e, reason: collision with root package name */
    private ExecutorService f41393e;

    /* renamed from: b, reason: collision with root package name */
    private int f41390b = 64;

    /* renamed from: c, reason: collision with root package name */
    private int f41391c = 5;

    /* renamed from: f, reason: collision with root package name */
    private final Deque<RealCall.AsyncCall> f41394f = new ArrayDeque();

    /* renamed from: g, reason: collision with root package name */
    private final Deque<RealCall.AsyncCall> f41395g = new ArrayDeque();

    /* renamed from: h, reason: collision with root package name */
    private final Deque<RealCall> f41396h = new ArrayDeque();

    public Dispatcher() {
    }

    public Dispatcher(ExecutorService executorService) {
        this.f41393e = executorService;
    }

    private <T> void a(Deque<T> deque, T t2) {
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(t2)) {
                throw new AssertionError((Object) "Call wasn't in-flight!");
            }
            runnable = this.f41392d;
        }
        if (a() || runnable == null) {
            return;
        }
        runnable.run();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean a() {
        int i10;
        boolean z10;
        if (!f41389a && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<RealCall.AsyncCall> iterator2 = this.f41394f.iterator2();
            while (iterator2.hasNext()) {
                RealCall.AsyncCall next = iterator2.next();
                if (this.f41395g.size() >= this.f41390b) {
                    break;
                }
                if (c(next) < this.f41391c) {
                    iterator2.remove();
                    arrayList.add(next);
                    this.f41395g.add(next);
                }
            }
            z10 = runningCallsCount() > 0;
        }
        int size = arrayList.size();
        for (i10 = 0; i10 < size; i10++) {
            ((RealCall.AsyncCall) arrayList.get(i10)).a(executorService());
        }
        return z10;
    }

    private int c(RealCall.AsyncCall asyncCall) {
        int i10 = 0;
        for (RealCall.AsyncCall asyncCall2 : this.f41395g) {
            if (!asyncCall2.b().f41529e && asyncCall2.a().equals(asyncCall.a())) {
                i10++;
            }
        }
        return i10;
    }

    public void a(RealCall.AsyncCall asyncCall) {
        synchronized (this) {
            this.f41394f.add(asyncCall);
        }
        a();
    }

    public synchronized void a(RealCall realCall) {
        this.f41396h.add(realCall);
    }

    public void b(RealCall.AsyncCall asyncCall) {
        a(this.f41395g, asyncCall);
    }

    public void b(RealCall realCall) {
        a(this.f41396h, realCall);
    }

    public synchronized void cancelAll() {
        Iterator<RealCall.AsyncCall> iterator2 = this.f41394f.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().b().cancel();
        }
        Iterator<RealCall.AsyncCall> iterator22 = this.f41395g.iterator2();
        while (iterator22.hasNext()) {
            iterator22.next().b().cancel();
        }
        Iterator<RealCall> iterator23 = this.f41396h.iterator2();
        while (iterator23.hasNext()) {
            iterator23.next().cancel();
        }
    }

    public synchronized ExecutorService executorService() {
        if (this.f41393e == null) {
            this.f41393e = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Dispatcher", false));
        }
        return this.f41393e;
    }

    public synchronized int getMaxRequests() {
        return this.f41390b;
    }

    public synchronized int getMaxRequestsPerHost() {
        return this.f41391c;
    }

    public synchronized List<Call> queuedCalls() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<RealCall.AsyncCall> iterator2 = this.f41394f.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(iterator2.next().b());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public synchronized int queuedCallsCount() {
        return this.f41394f.size();
    }

    public synchronized List<Call> runningCalls() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        arrayList.addAll(this.f41396h);
        Iterator<RealCall.AsyncCall> iterator2 = this.f41395g.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(iterator2.next().b());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public synchronized int runningCallsCount() {
        return this.f41395g.size() + this.f41396h.size();
    }

    public synchronized void setIdleCallback(Runnable runnable) {
        this.f41392d = runnable;
    }

    public void setMaxRequests(int i10) {
        if (i10 >= 1) {
            synchronized (this) {
                this.f41390b = i10;
            }
            a();
        } else {
            throw new IllegalArgumentException("max < 1: " + i10);
        }
    }

    public void setMaxRequestsPerHost(int i10) {
        if (i10 >= 1) {
            synchronized (this) {
                this.f41391c = i10;
            }
            a();
        } else {
            throw new IllegalArgumentException("max < 1: " + i10);
        }
    }
}
