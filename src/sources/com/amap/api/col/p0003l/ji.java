package com.amap.api.col.p0003l;

import android.os.SystemClock;
import com.amap.api.col.p0003l.jl;
import java.util.List;

/* compiled from: FpsBufferBuilder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ji extends jh {
    public ji() {
        super(2048);
    }

    private static void b(List<ks> list) {
        for (ks ksVar : list) {
            ksVar.f6691g = kh.b(ksVar.f6685a);
        }
    }

    public final byte[] a(kr krVar, jl.a aVar, long j10, List<ks> list) {
        List<kl> list2;
        super.a();
        try {
            int a10 = a(krVar);
            int i10 = -1;
            int a11 = (aVar == null || (list2 = aVar.f6574f) == null || list2.size() <= 0) ? -1 : a(aVar);
            if (list != null && list.size() > 0) {
                i10 = a(j10, list);
            }
            jq.a(this.f6561a);
            jq.a(this.f6561a, a10);
            if (a11 > 0) {
                jq.c(this.f6561a, a11);
            }
            if (i10 > 0) {
                jq.b(this.f6561a, i10);
            }
            this.f6561a.c(jq.b(this.f6561a));
            return this.f6561a.c();
        } catch (Throwable th) {
            kv.a(th);
            return null;
        }
    }

    private int a(kr krVar) {
        return jx.a(this.f6561a, krVar.f6675c, krVar.f6683k, (int) (krVar.f6677e * 1000000.0d), (int) (krVar.f6676d * 1000000.0d), (int) krVar.f6678f, (int) krVar.f6681i, (int) krVar.f6679g, (short) krVar.f6680h, krVar.f6684l);
    }

    private int a(jl.a aVar) {
        int i10;
        int i11;
        int i12;
        byte b4;
        int i13;
        int a10;
        int a11;
        a(aVar.f6574f);
        int size = aVar.f6574f.size();
        int[] iArr = new int[size];
        for (int i14 = 0; i14 < size; i14++) {
            kl klVar = aVar.f6574f.get(i14);
            if (klVar instanceof kn) {
                kn knVar = (kn) klVar;
                if (!knVar.f6652i) {
                    a11 = jy.a(this.f6561a, knVar.f6658j, knVar.f6659k, knVar.f6646c, knVar.f6660l);
                } else {
                    a11 = jy.a(this.f6561a, knVar.b(), knVar.c(), knVar.f6658j, knVar.f6659k, knVar.f6646c, knVar.f6661m, knVar.f6662n, knVar.f6647d, knVar.f6660l);
                }
                i13 = a11;
                i12 = -1;
                b4 = 1;
            } else if (klVar instanceof ko) {
                ko koVar = (ko) klVar;
                i13 = jz.a(this.f6561a, koVar.b(), koVar.c(), koVar.f6664j, koVar.f6665k, koVar.f6666l, koVar.f6646c, koVar.f6667m, koVar.f6647d);
                i12 = -1;
                b4 = 3;
            } else if (klVar instanceof km) {
                km kmVar = (km) klVar;
                if (!kmVar.f6652i) {
                    a10 = js.a(this.f6561a, kmVar.f6653j, kmVar.f6654k, kmVar.f6655l, kmVar.f6656m, kmVar.f6657n, kmVar.f6646c);
                } else {
                    a10 = js.a(this.f6561a, kmVar.f6653j, kmVar.f6654k, kmVar.f6655l, kmVar.f6656m, kmVar.f6657n, kmVar.f6646c, kmVar.f6647d);
                }
                i13 = a10;
                i12 = -1;
                b4 = 2;
            } else if (klVar instanceof kp) {
                kp kpVar = (kp) klVar;
                i13 = kc.a(this.f6561a, kpVar.b(), kpVar.c(), kpVar.f6669j, kpVar.f6670k, kpVar.f6671l, kpVar.f6646c, kpVar.f6672m, kpVar.f6647d);
                i12 = -1;
                b4 = 4;
            } else {
                i12 = -1;
                b4 = 0;
                i13 = -1;
            }
            if (i13 == i12) {
                return i12;
            }
            iArr[i14] = jv.a(this.f6561a, klVar.f6651h ? (byte) 1 : (byte) 0, klVar.f6652i ? (byte) 1 : (byte) 0, (short) klVar.f6650g, b4, i13);
        }
        int a12 = this.f6561a.a(aVar.f6570b);
        int a13 = jt.a(this.f6561a, iArr);
        int size2 = aVar.f6575g.size();
        int[] iArr2 = new int[size2];
        for (int i15 = 0; i15 < size2; i15++) {
            kl klVar2 = aVar.f6575g.get(i15);
            long elapsedRealtime = (SystemClock.elapsedRealtime() - klVar2.f6648e) / 1000;
            if (elapsedRealtime > 32767 || elapsedRealtime < 0) {
                elapsedRealtime = 32767;
            }
            if (klVar2 instanceof kn) {
                kn knVar2 = (kn) klVar2;
                i10 = kb.a(this.f6561a, knVar2.f6658j, knVar2.f6659k, (short) elapsedRealtime);
            } else if (klVar2 instanceof ko) {
                ko koVar2 = (ko) klVar2;
                i10 = kb.a(this.f6561a, koVar2.f6664j, koVar2.f6665k, (short) elapsedRealtime);
            } else {
                if (klVar2 instanceof km) {
                    km kmVar2 = (km) klVar2;
                    i10 = ka.a(this.f6561a, kmVar2.f6653j, kmVar2.f6654k, kmVar2.f6655l, (short) elapsedRealtime);
                    i11 = 2;
                } else if (klVar2 instanceof kp) {
                    kp kpVar2 = (kp) klVar2;
                    i10 = kb.a(this.f6561a, kpVar2.f6669j, kpVar2.f6670k, (short) elapsedRealtime);
                } else {
                    i10 = 0;
                    i11 = 0;
                }
                iArr2[i15] = ju.a(this.f6561a, (byte) i11, i10);
            }
            i11 = 1;
            iArr2[i15] = ju.a(this.f6561a, (byte) i11, i10);
        }
        return jt.a(this.f6561a, a12, aVar.f6569a, a13, jt.b(this.f6561a, iArr2));
    }

    private int a(long j10, List<ks> list) {
        b(list);
        int size = list.size();
        if (size <= 0) {
            return -1;
        }
        int[] iArr = new int[size];
        for (int i10 = 0; i10 < size; i10++) {
            ks ksVar = list.get(i10);
            int a10 = this.f6561a.a(ksVar.f6686b);
            long j11 = ksVar.f6685a;
            iArr[i10] = ke.a(this.f6561a, j11 == j10 && j11 != -1, j11, (short) ksVar.f6687c, a10, ksVar.f6691g, (short) ksVar.f6688d);
        }
        return kd.a(this.f6561a, kd.a(this.f6561a, iArr));
    }

    private static void a(List<kl> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (kl klVar : list) {
            if (klVar instanceof kn) {
                kn knVar = (kn) klVar;
                klVar.f6650g = kh.a(kh.a(knVar.f6658j, knVar.f6659k));
            } else if (klVar instanceof ko) {
                ko koVar = (ko) klVar;
                klVar.f6650g = kh.a(kh.a(koVar.f6664j, koVar.f6665k));
            } else if (klVar instanceof kp) {
                kp kpVar = (kp) klVar;
                klVar.f6650g = kh.a(kh.a(kpVar.f6669j, kpVar.f6670k));
            } else if (klVar instanceof km) {
                km kmVar = (km) klVar;
                klVar.f6650g = kh.a(kh.a(kmVar.f6654k, kmVar.f6655l));
            }
        }
    }
}
