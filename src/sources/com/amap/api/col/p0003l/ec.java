package com.amap.api.col.p0003l;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: OverlayerStrategy.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ec implements ea {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, a> f5432a = new ConcurrentHashMap();

    /* compiled from: OverlayerStrategy.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public String f5433a;

        /* renamed from: b, reason: collision with root package name */
        public String f5434b;

        /* renamed from: c, reason: collision with root package name */
        public int f5435c;

        /* renamed from: d, reason: collision with root package name */
        public final AtomicInteger f5436d = new AtomicInteger(0);

        public a(int i10, String str, String str2) {
            this.f5433a = str;
            this.f5434b = str2;
            this.f5435c = i10;
        }

        public final int a() {
            return this.f5436d.incrementAndGet();
        }
    }

    private static String b(int i10, String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i10);
        if (str == null) {
            str = "";
        }
        sb2.append(str);
        if (str2 == null) {
            str2 = "";
        }
        sb2.append(str2);
        return sb2.toString();
    }

    private static void c(int i10, String str, String str2) {
        if (i10 == 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(" ");
            sb2.append(str2);
            return;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append(" ");
        sb3.append(str2);
    }

    @Override // com.amap.api.col.p0003l.ea
    public final void a(int i10, String str, String str2) {
        try {
            String b4 = b(i10, str, str2);
            a aVar = f5432a.get(b4);
            if (aVar == null) {
                aVar = new a(i10, str, str2);
                f5432a.put(b4, aVar);
            }
            if (aVar.a() > 100) {
                a(aVar.f5435c, aVar.f5433a, aVar.f5434b, aVar.f5436d.get());
                f5432a.remove(b4);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.amap.api.col.p0003l.ea
    public final void a() {
        try {
            Iterator<Map.Entry<String, a>> iterator2 = f5432a.entrySet().iterator2();
            while (iterator2.hasNext()) {
                a value = iterator2.next().getValue();
                if (value != null) {
                    a(value.f5435c, value.f5433a, value.f5434b, value.f5436d.get());
                }
            }
            f5432a.clear();
            gf.a(dx.a()).a();
        } catch (Throwable unused) {
        }
    }

    private static void a(int i10, String str, String str2, int i11) {
        if (i10 == 0) {
            gf.a(dx.a()).a(ge.a(str, str2 + " counter " + i11));
        } else {
            gf.a(dx.a()).a(ge.a(str, str2 + " counter " + i11));
        }
        if (dy.f5396b) {
            c(i10, str, str2 + " counter " + i11);
        }
    }
}
