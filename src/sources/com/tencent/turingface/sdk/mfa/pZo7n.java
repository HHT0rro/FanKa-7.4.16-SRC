package com.tencent.turingface.sdk.mfa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class pZo7n {

    /* renamed from: a, reason: collision with root package name */
    public static final kwCJn<pZo7n> f45901a = new spXPg();

    /* renamed from: b, reason: collision with root package name */
    public Map<String, ShGzN> f45902b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public Map<String, SkEpO> f45903c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public JD1Ej f45904d;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public final class SkEpO implements Ww1Z6 {

        /* renamed from: a, reason: collision with root package name */
        public int f45913a;

        public SkEpO(int i10) {
            this.f45913a = i10;
        }

        @Override // com.tencent.turingface.sdk.mfa.Ww1Z6
        public final void a(String str) {
            pZo7n.a(pZo7n.this, str, this.f45913a, 3, null);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class spXPg extends kwCJn<pZo7n> {
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class wmqhz {

        /* renamed from: a, reason: collision with root package name */
        public final int f45915a;

        /* renamed from: b, reason: collision with root package name */
        public final float f45916b;

        /* renamed from: c, reason: collision with root package name */
        public final float f45917c;

        /* renamed from: d, reason: collision with root package name */
        public final float f45918d;

        /* renamed from: e, reason: collision with root package name */
        public final float f45919e;

        public wmqhz(int i10, float f10, float f11, float f12, float f13) {
            this.f45915a = i10;
            this.f45916b = f10;
            this.f45917c = f11;
            this.f45918d = f12;
            this.f45919e = f13;
        }
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [T, com.tencent.turingface.sdk.mfa.pZo7n] */
    public static pZo7n a() {
        pZo7n pzo7n;
        kwCJn<pZo7n> kwcjn = f45901a;
        pZo7n pzo7n2 = kwcjn.f45892a;
        pZo7n pzo7n3 = pzo7n2;
        if (pzo7n2 == null) {
            synchronized (kwcjn) {
                pZo7n pzo7n4 = kwcjn.f45892a;
                pzo7n = pzo7n4;
                if (pzo7n4 == null) {
                    ?? pzo7n5 = new pZo7n();
                    kwcjn.f45892a = pzo7n5;
                    pzo7n = pzo7n5;
                }
            }
            pzo7n3 = pzo7n;
        }
        return pzo7n3;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class ShGzN implements yMdp8 {

        /* renamed from: a, reason: collision with root package name */
        public int f45905a;

        /* renamed from: c, reason: collision with root package name */
        public long f45907c;

        /* renamed from: e, reason: collision with root package name */
        public String f45909e;

        /* renamed from: b, reason: collision with root package name */
        public long f45906b = -1;

        /* renamed from: d, reason: collision with root package name */
        public List<wmqhz> f45908d = new ArrayList();

        /* renamed from: f, reason: collision with root package name */
        public boolean f45910f = false;

        /* renamed from: g, reason: collision with root package name */
        public boolean f45911g = false;

        public ShGzN(String str, int i10) {
            this.f45905a = i10;
            this.f45909e = str;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List<com.tencent.turingface.sdk.mfa.pZo7n$wmqhz>, java.util.ArrayList] */
        public final void a() {
            this.f45906b = -1L;
            this.f45907c = 0L;
            this.f45908d.clear();
            this.f45910f = false;
            this.f45911g = false;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List<com.tencent.turingface.sdk.mfa.pZo7n$wmqhz>, java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r1v15, types: [java.util.List<com.tencent.turingface.sdk.mfa.pZo7n$wmqhz>, java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List<com.tencent.turingface.sdk.mfa.pZo7n$wmqhz>, java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r2v12, types: [java.util.List, java.util.List<com.tencent.turingface.sdk.mfa.pZo7n$wmqhz>, java.util.Collection, java.util.ArrayList] */
        @Override // com.tencent.turingface.sdk.mfa.yMdp8
        public final void a(QmgHg qmgHg) {
            wmqhz wmqhzVar;
            if (this.f45909e.equals(qmgHg.f45693m)) {
                this.f45910f = qmgHg.f45687g <= 0;
                this.f45911g = qmgHg.f45688h == 0;
                int i10 = qmgHg.f45686f;
                if (i10 == 0) {
                    a();
                    this.f45906b = System.currentTimeMillis();
                    this.f45908d.add(new wmqhz(0, qmgHg.f45689i, qmgHg.f45690j, qmgHg.f45691k, qmgHg.f45692l));
                    return;
                }
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            return;
                        }
                        a();
                        return;
                    } else {
                        if (this.f45906b != -1) {
                            wmqhzVar = new wmqhz(2, qmgHg.f45689i, qmgHg.f45690j, qmgHg.f45691k, qmgHg.f45692l);
                        } else {
                            a();
                            wmqhzVar = new wmqhz(0, qmgHg.f45689i, qmgHg.f45690j, qmgHg.f45691k, qmgHg.f45692l);
                            this.f45906b = System.currentTimeMillis();
                        }
                        this.f45908d.add(wmqhzVar);
                        return;
                    }
                }
                this.f45907c = System.currentTimeMillis() - this.f45906b;
                this.f45908d.add(new wmqhz(1, qmgHg.f45689i, qmgHg.f45690j, qmgHg.f45691k, qmgHg.f45692l));
                pZo7n pzo7n = pZo7n.this;
                ?? r22 = this.f45908d;
                pzo7n.getClass();
                ArrayList arrayList = new ArrayList();
                if (r22.size() <= 8) {
                    arrayList.addAll(r22);
                } else {
                    wmqhz wmqhzVar2 = (wmqhz) r22.get(0);
                    wmqhz wmqhzVar3 = (wmqhz) r22.get(r22.size() - 1);
                    r22.remove(wmqhzVar2);
                    r22.remove(wmqhzVar3);
                    int ceil = (int) Math.ceil(r22.size() / 6);
                    arrayList.add(wmqhzVar2);
                    for (int i11 = 1; i11 < r22.size(); i11 += ceil) {
                        arrayList.add(r22.get(i11));
                    }
                    arrayList.add(wmqhzVar3);
                }
                pZo7n pzo7n2 = pZo7n.this;
                long j10 = this.f45906b;
                long j11 = this.f45907c;
                pzo7n2.getClass();
                OCkqn oCkqn = new OCkqn();
                oCkqn.f45644c = (int) j11;
                oCkqn.f45643b = j10;
                ArrayList<XnM3A> arrayList2 = new ArrayList<>();
                Iterator iterator2 = arrayList.iterator2();
                while (iterator2.hasNext()) {
                    wmqhz wmqhzVar4 = (wmqhz) iterator2.next();
                    XnM3A xnM3A = new XnM3A();
                    int i12 = wmqhzVar4.f45915a;
                    if (i12 == 0) {
                        xnM3A.f45722a = 1;
                    } else if (i12 == 1) {
                        xnM3A.f45722a = 3;
                    } else if (i12 == 2) {
                        xnM3A.f45722a = 2;
                    } else if (i12 != 3) {
                        xnM3A.f45722a = 0;
                    } else {
                        xnM3A.f45722a = 4;
                    }
                    xnM3A.f45723b = wmqhzVar4.f45916b;
                    xnM3A.f45724c = wmqhzVar4.f45917c;
                    xnM3A.f45725d = wmqhzVar4.f45918d;
                    xnM3A.f45726e = wmqhzVar4.f45919e;
                    arrayList2.add(xnM3A);
                }
                oCkqn.f45645d = arrayList2;
                boolean z10 = this.f45910f;
                if (!z10 && !this.f45911g) {
                    pZo7n.a(pZo7n.this, this.f45909e, this.f45905a, 1, oCkqn);
                } else {
                    if (z10) {
                        oCkqn.f45646e |= 1;
                    }
                    if (this.f45911g) {
                        oCkqn.f45646e |= 2;
                    }
                    pZo7n.a(pZo7n.this, this.f45909e, this.f45905a, 2, oCkqn);
                }
                a();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.HashMap, java.util.Map<java.lang.String, com.tencent.turingface.sdk.mfa.pZo7n$ShGzN>] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Set<com.tencent.turingface.sdk.mfa.yMdp8>, java.util.concurrent.CopyOnWriteArraySet] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Set<com.tencent.turingface.sdk.mfa.Ww1Z6>, java.util.concurrent.CopyOnWriteArraySet] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Map<java.lang.String, com.tencent.turingface.sdk.mfa.pZo7n$SkEpO>, java.util.HashMap] */
    public final void a(String str, int i10, JD1Ej jD1Ej) {
        this.f45904d = jD1Ej;
        if (this.f45902b.get(str) == null) {
            ShGzN shGzN = new ShGzN(str, i10);
            this.f45902b.put(str, shGzN);
            gELYz.f45801c.add(shGzN);
        }
        if (this.f45903c.get(str) == null) {
            SkEpO skEpO = new SkEpO(i10);
            this.f45903c.put(str, skEpO);
            gELYz.f45802d.add(skEpO);
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.Set<com.tencent.turingface.sdk.mfa.yMdp8>, java.util.concurrent.CopyOnWriteArraySet] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Set<com.tencent.turingface.sdk.mfa.Ww1Z6>, java.util.concurrent.CopyOnWriteArraySet] */
    public final void a(String str) {
        gELYz.f45801c.remove(this.f45902b.get(str));
        this.f45902b.remove(str);
        gELYz.f45802d.remove(this.f45903c.get(str));
        this.f45903c.remove(str);
    }

    public static void a(pZo7n pzo7n, String str, int i10, int i11, OCkqn oCkqn) {
        JD1Ej jD1Ej = pzo7n.f45904d;
        if (jD1Ej != null) {
            jD1Ej.a(str, i10, i11, oCkqn);
        }
    }
}
