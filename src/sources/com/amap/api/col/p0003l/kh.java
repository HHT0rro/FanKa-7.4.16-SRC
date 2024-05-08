package com.amap.api.col.p0003l;

import java.util.ArrayList;
import java.util.List;

/* compiled from: RssiManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class kh {

    /* compiled from: RssiManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a implements kf {

        /* renamed from: a, reason: collision with root package name */
        private int f6637a;

        /* renamed from: b, reason: collision with root package name */
        private int f6638b;

        /* renamed from: c, reason: collision with root package name */
        private int f6639c;

        public a(int i10, int i11, int i12) {
            this.f6637a = i10;
            this.f6638b = i11;
            this.f6639c = i12;
        }

        @Override // com.amap.api.col.p0003l.kf
        public final long a() {
            return kh.a(this.f6637a, this.f6638b);
        }

        @Override // com.amap.api.col.p0003l.kf
        public final int b() {
            return this.f6639c;
        }
    }

    /* compiled from: RssiManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class b implements kf {

        /* renamed from: a, reason: collision with root package name */
        private long f6640a;

        /* renamed from: b, reason: collision with root package name */
        private int f6641b;

        public b(long j10, int i10) {
            this.f6640a = j10;
            this.f6641b = i10;
        }

        @Override // com.amap.api.col.p0003l.kf
        public final long a() {
            return this.f6640a;
        }

        @Override // com.amap.api.col.p0003l.kf
        public final int b() {
            return this.f6641b;
        }
    }

    public static long a(int i10, int i11) {
        return (i11 & 4294967295L) | ((i10 & 4294967295L) << 32);
    }

    public static synchronized void a(List<kl> list) {
        synchronized (kh.class) {
            if (list != null) {
                if (!list.isEmpty()) {
                    ArrayList arrayList = new ArrayList(list.size());
                    for (kl klVar : list) {
                        if (klVar instanceof kn) {
                            kn knVar = (kn) klVar;
                            arrayList.add(new a(knVar.f6658j, knVar.f6659k, knVar.f6646c));
                        } else if (klVar instanceof ko) {
                            ko koVar = (ko) klVar;
                            arrayList.add(new a(koVar.f6664j, koVar.f6665k, koVar.f6646c));
                        } else if (klVar instanceof kp) {
                            kp kpVar = (kp) klVar;
                            arrayList.add(new a(kpVar.f6669j, kpVar.f6670k, kpVar.f6646c));
                        } else if (klVar instanceof km) {
                            km kmVar = (km) klVar;
                            arrayList.add(new a(kmVar.f6654k, kmVar.f6655l, kmVar.f6646c));
                        }
                    }
                    kg.a().a(arrayList);
                }
            }
        }
    }

    public static synchronized void b(List<ks> list) {
        synchronized (kh.class) {
            if (list != null) {
                if (!list.isEmpty()) {
                    ArrayList arrayList = new ArrayList(list.size());
                    for (ks ksVar : list) {
                        arrayList.add(new b(ksVar.f6685a, ksVar.f6687c));
                    }
                    kg.a().b(arrayList);
                }
            }
        }
    }

    public static synchronized short b(long j10) {
        short b4;
        synchronized (kh.class) {
            b4 = kg.a().b(j10);
        }
        return b4;
    }

    public static synchronized short a(long j10) {
        short a10;
        synchronized (kh.class) {
            a10 = kg.a().a(j10);
        }
        return a10;
    }
}
