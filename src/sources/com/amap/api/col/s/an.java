package com.amap.api.col.s;

import com.amap.api.col.s.am;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* compiled from: RequestCacheWorker.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
class an {

    /* renamed from: a, reason: collision with root package name */
    private boolean f7102a = true;

    /* renamed from: b, reason: collision with root package name */
    private long f7103b = 86400;

    /* renamed from: c, reason: collision with root package name */
    private int f7104c = 10;

    /* renamed from: d, reason: collision with root package name */
    private long f7105d = 0;

    /* renamed from: e, reason: collision with root package name */
    private final LinkedHashMap<am.b, Object> f7106e = new LinkedHashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private final Object f7107f = new Object();

    /* renamed from: g, reason: collision with root package name */
    private final LinkedHashMap<am.b, Object> f7108g = new LinkedHashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private final Object f7109h = new Object();

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<String> f7110i = new ArrayList<>();

    public an(String... strArr) {
        a(strArr);
    }

    private void a(String... strArr) {
        this.f7105d = System.currentTimeMillis();
        this.f7106e.clear();
        this.f7110i.clear();
        for (String str : strArr) {
            if (str != null) {
                this.f7110i.add(str);
            }
        }
    }

    public Object b(LinkedHashMap<am.b, Object> linkedHashMap, am.b bVar) {
        if (linkedHashMap == null || bVar == null) {
            return null;
        }
        return linkedHashMap.get(bVar);
    }

    public Object c(LinkedHashMap<am.b, Object> linkedHashMap, am.b bVar) {
        if (linkedHashMap == null || bVar == null) {
            return null;
        }
        return linkedHashMap.remove(bVar);
    }

    private void b(am.b bVar, Object obj) {
        synchronized (this.f7107f) {
            a();
            b();
            this.f7106e.put(bVar, obj);
        }
    }

    public boolean a(LinkedHashMap<am.b, Object> linkedHashMap, am.b bVar) {
        if (linkedHashMap == null || bVar == null) {
            return false;
        }
        return linkedHashMap.containsKey(bVar);
    }

    private void b() {
        long currentTimeMillis = System.currentTimeMillis();
        if ((currentTimeMillis - this.f7105d) / 1000 > this.f7103b) {
            this.f7106e.clear();
            this.f7105d = currentTimeMillis;
        }
    }

    public final am.c a(am.b bVar) {
        if (!this.f7102a || bVar == null || !b(bVar)) {
            return null;
        }
        b();
        synchronized (this.f7107f) {
            if (a(this.f7106e, bVar)) {
                return new am.c(b(this.f7106e, bVar), true);
            }
            synchronized (this.f7109h) {
                if (a(this.f7108g, bVar)) {
                    while (!a(this.f7106e, bVar) && a(this.f7108g, bVar)) {
                        try {
                            this.f7109h.wait(1000L);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    }
                } else {
                    this.f7108g.put(bVar, null);
                }
            }
            return new am.c(b(this.f7106e, bVar), false);
        }
    }

    public final boolean b(am.b bVar) {
        if (bVar != null && bVar.f7098a != null) {
            Iterator<String> iterator2 = this.f7110i.iterator2();
            while (iterator2.hasNext()) {
                String next = iterator2.next();
                if (next != null && bVar.f7098a.contains(next)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void a(am.b bVar, Object obj) {
        if (this.f7102a && bVar != null && b(bVar)) {
            b(bVar, obj);
            synchronized (this.f7109h) {
                c(this.f7108g, bVar);
                this.f7109h.notify();
            }
        }
    }

    private void a() {
        int size = this.f7106e.size();
        if (size <= 0 || size < this.f7104c) {
            return;
        }
        am.b bVar = null;
        Iterator<am.b> iterator2 = this.f7106e.h().iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                break;
            }
            am.b next = iterator2.next();
            if (next != null) {
                bVar = next;
                break;
            }
        }
        c(this.f7106e, bVar);
    }

    public void a(am.a aVar) {
        if (aVar != null) {
            this.f7102a = aVar.a();
            this.f7103b = aVar.b();
            this.f7104c = aVar.c();
        }
    }
}
