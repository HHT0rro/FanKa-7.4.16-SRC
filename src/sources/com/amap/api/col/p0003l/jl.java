package com.amap.api.col.p0003l;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CellCollector.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class jl {

    /* renamed from: a, reason: collision with root package name */
    private kl f6564a;

    /* renamed from: b, reason: collision with root package name */
    private kl f6565b;

    /* renamed from: c, reason: collision with root package name */
    private kr f6566c;

    /* renamed from: d, reason: collision with root package name */
    private a f6567d = new a();

    /* renamed from: e, reason: collision with root package name */
    private final List<kl> f6568e = new ArrayList(3);

    public final a a(kr krVar, boolean z10, byte b4, String str, List<kl> list) {
        if (z10) {
            this.f6567d.a();
            return null;
        }
        this.f6567d.a(b4, str, list);
        if (this.f6567d.f6571c == null) {
            return null;
        }
        if (!(this.f6566c == null || a(krVar) || !a.a(this.f6567d.f6572d, this.f6564a) || !a.a(this.f6567d.f6573e, this.f6565b))) {
            return null;
        }
        a aVar = this.f6567d;
        this.f6564a = aVar.f6572d;
        this.f6565b = aVar.f6573e;
        this.f6566c = krVar;
        kh.a(aVar.f6574f);
        a(this.f6567d);
        return this.f6567d;
    }

    /* compiled from: CellCollector.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public byte f6569a;

        /* renamed from: b, reason: collision with root package name */
        public String f6570b;

        /* renamed from: c, reason: collision with root package name */
        public kl f6571c;

        /* renamed from: d, reason: collision with root package name */
        public kl f6572d;

        /* renamed from: e, reason: collision with root package name */
        public kl f6573e;

        /* renamed from: f, reason: collision with root package name */
        public List<kl> f6574f = new ArrayList();

        /* renamed from: g, reason: collision with root package name */
        public List<kl> f6575g = new ArrayList();

        public final void a() {
            this.f6569a = (byte) 0;
            this.f6570b = "";
            this.f6571c = null;
            this.f6572d = null;
            this.f6573e = null;
            this.f6574f.clear();
            this.f6575g.clear();
        }

        public final String toString() {
            return "CellInfo{radio=" + ((int) this.f6569a) + ", operator='" + this.f6570b + "', mainCell=" + ((Object) this.f6571c) + ", mainOldInterCell=" + ((Object) this.f6572d) + ", mainNewInterCell=" + ((Object) this.f6573e) + ", cells=" + ((Object) this.f6574f) + ", historyMainCellList=" + ((Object) this.f6575g) + '}';
        }

        public final void a(byte b4, String str, List<kl> list) {
            a();
            this.f6569a = b4;
            this.f6570b = str;
            if (list != null) {
                this.f6574f.addAll(list);
                for (kl klVar : this.f6574f) {
                    boolean z10 = klVar.f6652i;
                    if (!z10 && klVar.f6651h) {
                        this.f6572d = klVar;
                    } else if (z10 && klVar.f6651h) {
                        this.f6573e = klVar;
                    }
                }
            }
            kl klVar2 = this.f6572d;
            if (klVar2 == null) {
                klVar2 = this.f6573e;
            }
            this.f6571c = klVar2;
        }

        public static boolean a(kl klVar, kl klVar2) {
            if (klVar == null || klVar2 == null) {
                return (klVar == null) == (klVar2 == null);
            }
            if ((klVar instanceof kn) && (klVar2 instanceof kn)) {
                kn knVar = (kn) klVar;
                kn knVar2 = (kn) klVar2;
                return knVar.f6658j == knVar2.f6658j && knVar.f6659k == knVar2.f6659k;
            }
            if ((klVar instanceof km) && (klVar2 instanceof km)) {
                km kmVar = (km) klVar;
                km kmVar2 = (km) klVar2;
                return kmVar.f6655l == kmVar2.f6655l && kmVar.f6654k == kmVar2.f6654k && kmVar.f6653j == kmVar2.f6653j;
            }
            if ((klVar instanceof ko) && (klVar2 instanceof ko)) {
                ko koVar = (ko) klVar;
                ko koVar2 = (ko) klVar2;
                return koVar.f6664j == koVar2.f6664j && koVar.f6665k == koVar2.f6665k;
            }
            if ((klVar instanceof kp) && (klVar2 instanceof kp)) {
                kp kpVar = (kp) klVar;
                kp kpVar2 = (kp) klVar2;
                if (kpVar.f6669j == kpVar2.f6669j && kpVar.f6670k == kpVar2.f6670k) {
                    return true;
                }
            }
            return false;
        }
    }

    private boolean a(kr krVar) {
        float f10 = krVar.f6679g;
        return krVar.a(this.f6566c) > ((double) ((f10 > 10.0f ? 1 : (f10 == 10.0f ? 0 : -1)) > 0 ? 2000.0f : (f10 > 2.0f ? 1 : (f10 == 2.0f ? 0 : -1)) > 0 ? 500.0f : 100.0f));
    }

    private void a(a aVar) {
        synchronized (this.f6568e) {
            for (kl klVar : aVar.f6574f) {
                if (klVar != null && klVar.f6651h) {
                    kl clone = klVar.clone();
                    clone.f6648e = SystemClock.elapsedRealtime();
                    a(clone);
                }
            }
            this.f6567d.f6575g.clear();
            this.f6567d.f6575g.addAll(this.f6568e);
        }
    }

    private void a(kl klVar) {
        if (klVar == null) {
            return;
        }
        int size = this.f6568e.size();
        if (size == 0) {
            this.f6568e.add(klVar);
            return;
        }
        long j10 = Long.MAX_VALUE;
        int i10 = 0;
        int i11 = -1;
        int i12 = -1;
        while (true) {
            if (i10 >= size) {
                i11 = i12;
                break;
            }
            kl klVar2 = this.f6568e.get(i10);
            if (klVar.equals(klVar2)) {
                int i13 = klVar.f6646c;
                if (i13 != klVar2.f6646c) {
                    klVar2.f6648e = i13;
                    klVar2.f6646c = i13;
                }
            } else {
                j10 = Math.min(j10, klVar2.f6648e);
                if (j10 == klVar2.f6648e) {
                    i12 = i10;
                }
                i10++;
            }
        }
        if (i11 >= 0) {
            if (size < 3) {
                this.f6568e.add(klVar);
            } else {
                if (klVar.f6648e <= j10 || i11 >= size) {
                    return;
                }
                this.f6568e.remove(i11);
                this.f6568e.add(klVar);
            }
        }
    }
}
