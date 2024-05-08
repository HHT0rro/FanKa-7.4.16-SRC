package com.huawei.appgallery.agd.common.gcd;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class DispatchWorkItem implements Runnable, Comparable<DispatchWorkItem> {

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f27346b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    public volatile int f27347c = 0;

    /* renamed from: d, reason: collision with root package name */
    public DispatchQoS f27348d;

    /* renamed from: e, reason: collision with root package name */
    public DispatchBlock f27349e;

    /* renamed from: f, reason: collision with root package name */
    public int f27350f;

    /* renamed from: g, reason: collision with root package name */
    public DispatchPriority f27351g;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface Status {
        public static final int FINISHED = 2;
        public static final int PENDING = 0;
        public static final int RUNNING = 1;
    }

    public DispatchWorkItem(DispatchQoS dispatchQoS, DispatchPriority dispatchPriority, DispatchBlock dispatchBlock) {
        this.f27348d = dispatchQoS;
        this.f27351g = dispatchPriority;
        this.f27349e = dispatchBlock;
    }

    public final void a() {
    }

    public void cancel() {
        this.f27346b.set(true);
    }

    @Override // java.lang.Comparable
    public final int compareTo(DispatchWorkItem dispatchWorkItem) {
        if (this.f27351g.intValue() > dispatchWorkItem.f27351g.intValue()) {
            return -1;
        }
        if (this.f27351g.intValue() < dispatchWorkItem.f27351g.intValue()) {
            return 1;
        }
        int i10 = this.f27350f;
        int i11 = dispatchWorkItem.f27350f;
        if (i10 < i11) {
            return -1;
        }
        return i10 > i11 ? 1 : 0;
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final void executeOnExecutor(ThreadPoolExecutor threadPoolExecutor) {
        if (this.f27347c != 0) {
            return;
        }
        this.f27347c = 1;
        threadPoolExecutor.execute(this);
    }

    public DispatchBlock getBlock() {
        return this.f27349e;
    }

    public DispatchQoS getQos() {
        return this.f27348d;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean isCancelled() {
        return this.f27346b.get();
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f27349e.run();
        this.f27347c = 2;
        if (isCancelled()) {
            a();
        }
    }

    public void setBlockID(int i10) {
        this.f27350f = i10;
    }
}
