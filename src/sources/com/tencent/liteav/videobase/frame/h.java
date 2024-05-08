package com.tencent.liteav.videobase.frame;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.frame.k;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class h<T extends k> {

    /* renamed from: a, reason: collision with root package name */
    public final Deque<T> f43447a = new LinkedList();

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f43449c = false;

    /* renamed from: d, reason: collision with root package name */
    private final g<T> f43450d = (g<T>) new g<T>() { // from class: com.tencent.liteav.videobase.frame.h.1
        @Override // com.tencent.liteav.videobase.frame.g
        public final void a(T t2) {
            h.this.f43448b.release();
            synchronized (h.this) {
                if (h.this.f43449c) {
                    return;
                }
                h.this.f43447a.addFirst(t2);
            }
        }
    };

    /* renamed from: b, reason: collision with root package name */
    public final Semaphore f43448b = new Semaphore(1);

    public final T a() throws InterruptedException {
        T a10;
        this.f43448b.acquire();
        synchronized (this) {
            if (!this.f43447a.isEmpty()) {
                a10 = this.f43447a.removeFirst();
            } else {
                a10 = a(this.f43450d);
            }
        }
        if (a10.retain() != 1) {
            LiteavLog.e("LimitedFramePool", "invalid reference count for %s", a10);
        }
        return a10;
    }

    public abstract T a(g<T> gVar);

    public final void b() {
        ArrayList arrayList;
        this.f43449c = true;
        synchronized (this) {
            arrayList = new ArrayList(this.f43447a);
            this.f43447a.clear();
        }
        Iterator<E> iterator2 = arrayList.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next();
        }
    }
}
