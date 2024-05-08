package com.tencent.liteav.videobase.frame;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.frame.k;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class a<T extends k> {

    /* renamed from: a, reason: collision with root package name */
    private static final long f43427a = TimeUnit.SECONDS.toMillis(1);

    /* renamed from: c, reason: collision with root package name */
    private final Map<InterfaceC0640a, Deque<T>> f43429c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f43430d = false;

    /* renamed from: e, reason: collision with root package name */
    private final com.tencent.liteav.base.b.a f43431e = new com.tencent.liteav.base.b.a(f43427a);

    /* renamed from: f, reason: collision with root package name */
    private final g<T> f43432f = new g(this) { // from class: com.tencent.liteav.videobase.frame.b

        /* renamed from: a, reason: collision with root package name */
        private final a f43433a;

        {
            this.f43433a = this;
        }

        @Override // com.tencent.liteav.videobase.frame.g
        public final void a(k kVar) {
            a.a(this.f43433a, kVar);
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private final String f43428b = null;

    /* renamed from: com.tencent.liteav.videobase.frame.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface InterfaceC0640a {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void a(a aVar, k kVar) {
        if (kVar == 0) {
            return;
        }
        synchronized (aVar.f43429c) {
            if (aVar.f43430d) {
                aVar.a((a) kVar);
                return;
            }
            Deque<T> b4 = aVar.b(aVar.b((a) kVar));
            kVar.updateLastUsedTimestamp(SystemClock.elapsedRealtime());
            b4.addFirst(kVar);
            aVar.c();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c() {
        T peekLast;
        if (this.f43431e.a()) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            ArrayList arrayList = new ArrayList();
            synchronized (this.f43429c) {
                for (Deque<T> deque : this.f43429c.values()) {
                    while (!deque.isEmpty() && ((peekLast = deque.peekLast()) == null || elapsedRealtime - peekLast.getLastUsedTimestamp() >= f43427a)) {
                        deque.pollLast();
                        arrayList.add(peekLast);
                    }
                }
            }
            Iterator<E> iterator2 = arrayList.iterator2();
            while (iterator2.hasNext()) {
                a((a<T>) iterator2.next());
            }
        }
    }

    public abstract T a(g<T> gVar, InterfaceC0640a interfaceC0640a);

    public abstract void a(T t2);

    public abstract InterfaceC0640a b(T t2);

    public void b() {
        this.f43430d = true;
        a();
    }

    public void finalize() throws Throwable {
        super.finalize();
        if (this.f43430d) {
            return;
        }
        LiteavLog.e("FramePool", "%s must call destroy() before finalize()!\n%s", getClass().getName(), this.f43428b);
    }

    private Deque<T> b(InterfaceC0640a interfaceC0640a) {
        Deque<T> deque = this.f43429c.get(interfaceC0640a);
        if (deque != null) {
            return deque;
        }
        LinkedList linkedList = new LinkedList();
        this.f43429c.put(interfaceC0640a, linkedList);
        return linkedList;
    }

    @NonNull
    public final T a(InterfaceC0640a interfaceC0640a) {
        T removeFirst;
        synchronized (this.f43429c) {
            Deque<T> b4 = b(interfaceC0640a);
            removeFirst = !b4.isEmpty() ? b4.removeFirst() : null;
        }
        c();
        if (removeFirst == null) {
            removeFirst = a(this.f43432f, interfaceC0640a);
        }
        if (removeFirst.retain() != 1) {
            LiteavLog.e("FramePool", "invalid reference count for %s", removeFirst);
        }
        return removeFirst;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f43429c) {
            Iterator<Deque<T>> iterator2 = this.f43429c.values().iterator2();
            while (iterator2.hasNext()) {
                arrayList.addAll(iterator2.next());
            }
            this.f43429c.clear();
        }
        Iterator<E> iterator22 = arrayList.iterator2();
        while (iterator22.hasNext()) {
            a((a<T>) iterator22.next());
        }
    }
}
