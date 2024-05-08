package com.huawei.appgallery.agd.common.gcd;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class DispatchWorkQueue {

    /* renamed from: a, reason: collision with root package name */
    public ThreadPoolExecutor f27352a;

    /* renamed from: b, reason: collision with root package name */
    public ThreadPoolExecutor f27353b;

    /* renamed from: c, reason: collision with root package name */
    public AtomicInteger f27354c;

    public DispatchWorkQueue(String str) {
        this.f27352a = null;
        this.f27353b = null;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.f27352a = new ThreadPoolExecutor(0, 1, 10L, timeUnit, new LinkedBlockingQueue(), new QueueThreadFactory("Serial" + str));
        this.f27353b = new ThreadPoolExecutor(0, 4, 10L, timeUnit, new PriorityBlockingQueue(), new QueueThreadFactory("Concurrent" + str));
        this.f27354c = new AtomicInteger();
    }

    public void async(DispatchQoS dispatchQoS, DispatchBlock dispatchBlock) {
        async(new DispatchWorkItem(dispatchQoS, DispatchPriority.NORMAL, dispatchBlock));
    }

    public void async(DispatchWorkItem dispatchWorkItem) {
        ThreadPoolExecutor threadPoolExecutor;
        if (dispatchWorkItem.getBlock() == null) {
            return;
        }
        if (dispatchWorkItem.getQos() == DispatchQoS.SERIAL) {
            threadPoolExecutor = this.f27352a;
        } else {
            dispatchWorkItem.setBlockID(this.f27354c.incrementAndGet());
            threadPoolExecutor = this.f27353b;
        }
        dispatchWorkItem.executeOnExecutor(threadPoolExecutor);
    }
}
