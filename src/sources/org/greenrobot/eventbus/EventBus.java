package org.greenrobot.eventbus;

import he.e;
import he.f;
import he.g;
import he.i;
import he.k;
import he.l;
import he.m;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class EventBus {

    /* renamed from: s, reason: collision with root package name */
    public static volatile EventBus f52402s;

    /* renamed from: t, reason: collision with root package name */
    public static final he.c f52403t = new he.c();

    /* renamed from: u, reason: collision with root package name */
    public static final Map<Class<?>, List<Class<?>>> f52404u = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, CopyOnWriteArrayList<m>> f52405a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<Object, List<Class<?>>> f52406b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<Class<?>, Object> f52407c;

    /* renamed from: d, reason: collision with root package name */
    public final ThreadLocal<c> f52408d;

    /* renamed from: e, reason: collision with root package name */
    public final f f52409e;

    /* renamed from: f, reason: collision with root package name */
    public final i f52410f;

    /* renamed from: g, reason: collision with root package name */
    public final he.b f52411g;

    /* renamed from: h, reason: collision with root package name */
    public final he.a f52412h;

    /* renamed from: i, reason: collision with root package name */
    public final l f52413i;

    /* renamed from: j, reason: collision with root package name */
    public final ExecutorService f52414j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f52415k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f52416l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f52417m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f52418n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f52419o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f52420p;

    /* renamed from: q, reason: collision with root package name */
    public final int f52421q;

    /* renamed from: r, reason: collision with root package name */
    public final e f52422r;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class a extends ThreadLocal<c> {
        public a() {
        }

        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c initialValue() {
            return new c();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f52424a;

        static {
            int[] iArr = new int[ThreadMode.values().length];
            f52424a = iArr;
            try {
                iArr[ThreadMode.POSTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f52424a[ThreadMode.MAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f52424a[ThreadMode.MAIN_ORDERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f52424a[ThreadMode.BACKGROUND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f52424a[ThreadMode.ASYNC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final List<Object> f52425a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public boolean f52426b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f52427c;

        /* renamed from: d, reason: collision with root package name */
        public m f52428d;

        /* renamed from: e, reason: collision with root package name */
        public Object f52429e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f52430f;
    }

    public EventBus() {
        this(f52403t);
    }

    public static void a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, cls.getInterfaces());
            }
        }
    }

    public static EventBus c() {
        if (f52402s == null) {
            synchronized (EventBus.class) {
                if (f52402s == null) {
                    f52402s = new EventBus();
                }
            }
        }
        return f52402s;
    }

    public static List<Class<?>> k(Class<?> cls) {
        List<Class<?>> list;
        Map<Class<?>, List<Class<?>>> map = f52404u;
        synchronized (map) {
            list = map.get(cls);
            if (list == null) {
                list = new ArrayList<>();
                for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    list.add(cls2);
                    a(list, cls2.getInterfaces());
                }
                f52404u.put(cls, list);
            }
        }
        return list;
    }

    public final void b(m mVar, Object obj) {
        if (obj != null) {
            p(mVar, obj, i());
        }
    }

    public ExecutorService d() {
        return this.f52414j;
    }

    public e e() {
        return this.f52422r;
    }

    public final void f(m mVar, Object obj, Throwable th) {
        if (obj instanceof SubscriberExceptionEvent) {
            if (this.f52416l) {
                e eVar = this.f52422r;
                Level level = Level.SEVERE;
                eVar.b(level, "SubscriberExceptionEvent subscriber " + ((Object) mVar.f49653a.getClass()) + " threw an exception", th);
                SubscriberExceptionEvent subscriberExceptionEvent = (SubscriberExceptionEvent) obj;
                this.f52422r.b(level, "Initial event " + subscriberExceptionEvent.causingEvent + " caused exception in " + subscriberExceptionEvent.causingSubscriber, subscriberExceptionEvent.throwable);
                return;
            }
            return;
        }
        if (!this.f52415k) {
            if (this.f52416l) {
                this.f52422r.b(Level.SEVERE, "Could not dispatch event: " + ((Object) obj.getClass()) + " to subscribing class " + ((Object) mVar.f49653a.getClass()), th);
            }
            if (this.f52418n) {
                l(new SubscriberExceptionEvent(this, th, obj, mVar.f49653a));
                return;
            }
            return;
        }
        throw new EventBusException("Invoking subscriber failed", th);
    }

    public void g(g gVar) {
        Object obj = gVar.f49629a;
        m mVar = gVar.f49630b;
        g.b(gVar);
        if (mVar.f49655c) {
            h(mVar, obj);
        }
    }

    public void h(m mVar, Object obj) {
        try {
            mVar.f49654b.f49634a.invoke(mVar.f49653a, obj);
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unexpected exception", e2);
        } catch (InvocationTargetException e10) {
            f(mVar, obj, e10.getCause());
        }
    }

    public final boolean i() {
        f fVar = this.f52409e;
        if (fVar != null) {
            return fVar.a();
        }
        return true;
    }

    public synchronized boolean j(Object obj) {
        return this.f52406b.containsKey(obj);
    }

    public void l(Object obj) {
        c cVar = this.f52408d.get();
        List<Object> list = cVar.f52425a;
        list.add(obj);
        if (cVar.f52426b) {
            return;
        }
        cVar.f52427c = i();
        cVar.f52426b = true;
        if (cVar.f52430f) {
            throw new EventBusException("Internal error. Abort state was not reset");
        }
        while (true) {
            try {
                if (list.isEmpty()) {
                    return;
                } else {
                    m(list.remove(0), cVar);
                }
            } finally {
                cVar.f52426b = false;
                cVar.f52427c = false;
            }
        }
    }

    public final void m(Object obj, c cVar) throws Error {
        boolean n10;
        Class<?> cls = obj.getClass();
        if (this.f52420p) {
            List<Class<?>> k10 = k(cls);
            int size = k10.size();
            n10 = false;
            for (int i10 = 0; i10 < size; i10++) {
                n10 |= n(obj, cVar, k10.get(i10));
            }
        } else {
            n10 = n(obj, cVar, cls);
        }
        if (n10) {
            return;
        }
        if (this.f52417m) {
            this.f52422r.a(Level.FINE, "No subscribers registered for event " + ((Object) cls));
        }
        if (!this.f52419o || cls == NoSubscriberEvent.class || cls == SubscriberExceptionEvent.class) {
            return;
        }
        l(new NoSubscriberEvent(this, obj));
    }

    public final boolean n(Object obj, c cVar, Class<?> cls) {
        CopyOnWriteArrayList<m> copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.f52405a.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator<m> iterator2 = copyOnWriteArrayList.iterator2();
        while (iterator2.hasNext()) {
            m next = iterator2.next();
            cVar.f52429e = obj;
            cVar.f52428d = next;
            try {
                p(next, obj, cVar.f52427c);
                if (cVar.f52430f) {
                    return true;
                }
            } finally {
                cVar.f52429e = null;
                cVar.f52428d = null;
                cVar.f52430f = false;
            }
        }
        return true;
    }

    public void o(Object obj) {
        synchronized (this.f52407c) {
            this.f52407c.put(obj.getClass(), obj);
        }
        l(obj);
    }

    public final void p(m mVar, Object obj, boolean z10) {
        int i10 = b.f52424a[mVar.f49654b.f49635b.ordinal()];
        if (i10 == 1) {
            h(mVar, obj);
            return;
        }
        if (i10 == 2) {
            if (z10) {
                h(mVar, obj);
                return;
            } else {
                this.f52410f.a(mVar, obj);
                return;
            }
        }
        if (i10 == 3) {
            i iVar = this.f52410f;
            if (iVar != null) {
                iVar.a(mVar, obj);
                return;
            } else {
                h(mVar, obj);
                return;
            }
        }
        if (i10 == 4) {
            if (z10) {
                this.f52411g.a(mVar, obj);
                return;
            } else {
                h(mVar, obj);
                return;
            }
        }
        if (i10 == 5) {
            this.f52412h.a(mVar, obj);
            return;
        }
        throw new IllegalStateException("Unknown thread mode: " + ((Object) mVar.f49654b.f49635b));
    }

    public void q(Object obj) {
        List<k> a10 = this.f52413i.a(obj.getClass());
        synchronized (this) {
            Iterator<k> iterator2 = a10.iterator2();
            while (iterator2.hasNext()) {
                s(obj, iterator2.next());
            }
        }
    }

    public boolean r(Object obj) {
        synchronized (this.f52407c) {
            Class<?> cls = obj.getClass();
            if (!obj.equals(this.f52407c.get(cls))) {
                return false;
            }
            this.f52407c.remove(cls);
            return true;
        }
    }

    public final void s(Object obj, k kVar) {
        Class<?> cls = kVar.f49636c;
        m mVar = new m(obj, kVar);
        CopyOnWriteArrayList<m> copyOnWriteArrayList = this.f52405a.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.f52405a.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(mVar)) {
            throw new EventBusException("Subscriber " + ((Object) obj.getClass()) + " already registered to event " + ((Object) cls));
        }
        int size = copyOnWriteArrayList.size();
        for (int i10 = 0; i10 <= size; i10++) {
            if (i10 == size || kVar.f49637d > copyOnWriteArrayList.get(i10).f49654b.f49637d) {
                copyOnWriteArrayList.add(i10, mVar);
                break;
            }
        }
        List<Class<?>> list = this.f52406b.get(obj);
        if (list == null) {
            list = new ArrayList<>();
            this.f52406b.put(obj, list);
        }
        list.add(cls);
        if (kVar.f49638e) {
            if (this.f52420p) {
                for (Map.Entry<Class<?>, Object> entry : this.f52407c.entrySet()) {
                    if (cls.isAssignableFrom(entry.getKey())) {
                        b(mVar, entry.getValue());
                    }
                }
                return;
            }
            b(mVar, this.f52407c.get(cls));
        }
    }

    public synchronized void t(Object obj) {
        List<Class<?>> list = this.f52406b.get(obj);
        if (list != null) {
            Iterator<Class<?>> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                u(obj, iterator2.next());
            }
            this.f52406b.remove(obj);
        } else {
            this.f52422r.a(Level.WARNING, "Subscriber to unregister was not registered before: " + ((Object) obj.getClass()));
        }
    }

    public String toString() {
        return "EventBus[indexCount=" + this.f52421q + ", eventInheritance=" + this.f52420p + "]";
    }

    public final void u(Object obj, Class<?> cls) {
        CopyOnWriteArrayList<m> copyOnWriteArrayList = this.f52405a.get(cls);
        if (copyOnWriteArrayList != null) {
            int size = copyOnWriteArrayList.size();
            int i10 = 0;
            while (i10 < size) {
                m mVar = copyOnWriteArrayList.get(i10);
                if (mVar.f49653a == obj) {
                    mVar.f49655c = false;
                    copyOnWriteArrayList.remove(i10);
                    i10--;
                    size--;
                }
                i10++;
            }
        }
    }

    public EventBus(he.c cVar) {
        this.f52408d = new a();
        this.f52422r = cVar.b();
        this.f52405a = new HashMap();
        this.f52406b = new HashMap();
        this.f52407c = new ConcurrentHashMap();
        f c4 = cVar.c();
        this.f52409e = c4;
        this.f52410f = c4 != null ? c4.b(this) : null;
        this.f52411g = new he.b(this);
        this.f52412h = new he.a(this);
        List<ie.b> list = cVar.f49618j;
        this.f52421q = list != null ? list.size() : 0;
        this.f52413i = new l(cVar.f49618j, cVar.f49616h, cVar.f49615g);
        this.f52416l = cVar.f49609a;
        this.f52417m = cVar.f49610b;
        this.f52418n = cVar.f49611c;
        this.f52419o = cVar.f49612d;
        this.f52415k = cVar.f49613e;
        this.f52420p = cVar.f49614f;
        this.f52414j = cVar.f49617i;
    }
}
