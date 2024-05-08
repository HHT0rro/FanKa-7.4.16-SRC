package com.amap.api.col.p0003l;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: AmapDelegateListenerManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<Integer, a> f6897a = new ConcurrentHashMap<>();

    /* compiled from: AmapDelegateListenerManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class a<T> {

        /* renamed from: a, reason: collision with root package name */
        public List<T> f6898a = Collections.synchronizedList(new ArrayList());

        /* renamed from: b, reason: collision with root package name */
        public T f6899b = null;

        public a() {
        }
    }

    public final <T> void a(Integer num, T t2) {
        ConcurrentHashMap<Integer, a> concurrentHashMap;
        if (t2 != null && (concurrentHashMap = this.f6897a) != null) {
            try {
                a aVar = concurrentHashMap.get(num);
                if (aVar == null) {
                    aVar = new a();
                    this.f6897a.putIfAbsent(num, aVar);
                }
                List<T> list = aVar.f6898a;
                if (list == null || list.contains(t2)) {
                } else {
                    aVar.f6898a.add(t2);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public final <T> void b(Integer num, T t2) {
        ConcurrentHashMap<Integer, a> concurrentHashMap;
        a aVar;
        List<T> list;
        if (t2 != null && (concurrentHashMap = this.f6897a) != null) {
            try {
                if (!concurrentHashMap.containsKey(num) || (aVar = this.f6897a.get(num)) == null || (list = aVar.f6898a) == null || !list.contains(t2)) {
                } else {
                    aVar.f6898a.remove(t2);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public final <T> void a(Integer num) {
        a aVar;
        List<T> list;
        try {
            if (!this.f6897a.containsKey(num) || (aVar = this.f6897a.get(num)) == null || (list = aVar.f6898a) == null) {
                return;
            }
            list.clear();
        } catch (Throwable unused) {
        }
    }

    public final <T> List<T> a(int i10) {
        try {
            a aVar = this.f6897a.get(Integer.valueOf(i10));
            if (aVar != null) {
                return aVar.f6898a;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final <T> void a(int i10, T t2) {
        ConcurrentHashMap<Integer, a> concurrentHashMap = this.f6897a;
        if (concurrentHashMap == null) {
            return;
        }
        try {
            a aVar = concurrentHashMap.get(Integer.valueOf(i10));
            if (aVar == null) {
                aVar = new a();
                this.f6897a.putIfAbsent(Integer.valueOf(i10), aVar);
            }
            if (aVar.f6899b == t2) {
                return;
            }
            b(Integer.valueOf(i10), aVar.f6899b);
            aVar.f6899b = t2;
            a(Integer.valueOf(i10), (Integer) t2);
        } catch (Throwable unused) {
        }
    }

    public final <T> void a() {
        ConcurrentHashMap<Integer, a> concurrentHashMap = this.f6897a;
        if (concurrentHashMap == null) {
            return;
        }
        try {
            Iterator<Map.Entry<Integer, a>> iterator2 = concurrentHashMap.entrySet().iterator2();
            while (iterator2.hasNext()) {
                a value = iterator2.next().getValue();
                value.f6898a.clear();
                value.f6899b = null;
            }
            this.f6897a.clear();
        } catch (Throwable unused) {
        }
    }
}
