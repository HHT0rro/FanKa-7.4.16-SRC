package com.huawei.hms.scankit.p;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: FinderPatternFinder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class i3 {

    /* renamed from: h, reason: collision with root package name */
    private static boolean f31114h;

    /* renamed from: i, reason: collision with root package name */
    private static boolean f31115i;

    /* renamed from: a, reason: collision with root package name */
    private final s f31117a;

    /* renamed from: e, reason: collision with root package name */
    private final v6 f31121e;

    /* renamed from: f, reason: collision with root package name */
    private static final int[] f31112f = {1, 3, 1, 1};

    /* renamed from: g, reason: collision with root package name */
    private static final int[] f31113g = {1, 1, 3, 1};

    /* renamed from: j, reason: collision with root package name */
    private static final d f31116j = new d();

    /* renamed from: b, reason: collision with root package name */
    private final List<e3> f31118b = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private final int[] f31120d = new int[5];

    /* renamed from: c, reason: collision with root package name */
    private final List<e3> f31119c = new ArrayList();

    /* compiled from: FinderPatternFinder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class b implements Comparator<e3>, Serializable {

        /* renamed from: a, reason: collision with root package name */
        private final float f31122a;

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(e3 e3Var, e3 e3Var2) {
            int compare = Integer.compare(e3Var2.a(), e3Var.a());
            return compare == 0 ? Float.compare(Math.abs(e3Var.e() - this.f31122a), Math.abs(e3Var2.e() - this.f31122a)) : compare;
        }

        private b(float f10) {
            this.f31122a = f10;
        }
    }

    /* compiled from: FinderPatternFinder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class c implements Comparator<e3>, Serializable {
        private c() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(e3 e3Var, e3 e3Var2) {
            return Integer.compare(e3Var2.a(), e3Var.a());
        }
    }

    /* compiled from: FinderPatternFinder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class d implements Comparator<e3>, Serializable {
        private d() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(e3 e3Var, e3 e3Var2) {
            return Float.compare(e3Var.e(), e3Var2.e());
        }
    }

    /* compiled from: FinderPatternFinder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class e implements Comparator<e3>, Serializable {

        /* renamed from: a, reason: collision with root package name */
        private final float f31123a;

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(e3 e3Var, e3 e3Var2) {
            return Float.compare(Math.abs(e3Var2.e() - this.f31123a), Math.abs(e3Var.e() - this.f31123a));
        }

        private e(float f10) {
            this.f31123a = f10;
        }
    }

    /* compiled from: FinderPatternFinder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class f implements Comparator<e3>, Serializable {
        private f() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(e3 e3Var, e3 e3Var2) {
            return Float.compare(e3Var.b(), e3Var2.b());
        }
    }

    /* compiled from: FinderPatternFinder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class g implements Comparator<e3>, Serializable {
        private g() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(e3 e3Var, e3 e3Var2) {
            return Float.compare(e3Var.c(), e3Var2.c());
        }
    }

    public i3(s sVar, v6 v6Var) {
        this.f31117a = sVar;
        this.f31121e = v6Var;
    }

    public static float a(int[] iArr, int[] iArr2, float f10) {
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            i10 += iArr[i12];
            i11 += iArr2[i12];
        }
        if (i10 < i11) {
            return Float.POSITIVE_INFINITY;
        }
        float f11 = i10;
        float f12 = f11 / i11;
        float f13 = f10 * f12;
        float f14 = 0.0f;
        for (int i13 = 0; i13 < length; i13++) {
            float f15 = iArr2[i13] * f12;
            float f16 = iArr[i13];
            float f17 = f16 > f15 ? f16 - f15 : f15 - f16;
            if (f17 > f13) {
                return Float.POSITIVE_INFINITY;
            }
            f14 += f17;
        }
        return f14 / f11;
    }

    private e3[] c() throws com.huawei.hms.scankit.p.a {
        boolean z10;
        boolean z11;
        if (this.f31118b.size() > 2) {
            try {
                return f();
            } catch (com.huawei.hms.scankit.p.a unused) {
                if (this.f31119c.size() > 0) {
                    Collections.sort(this.f31119c, new c());
                    int min = Math.min(3, this.f31119c.size());
                    for (int i10 = 0; i10 < min; i10++) {
                        e3 e3Var = this.f31119c.get(i10);
                        float e2 = e3Var.e();
                        float c4 = e3Var.c();
                        float b4 = e3Var.b();
                        int i11 = 0;
                        while (true) {
                            if (i11 >= this.f31118b.size()) {
                                z10 = false;
                                break;
                            }
                            e3 e3Var2 = this.f31118b.get(i11);
                            if (e3Var2.b(e2, c4, b4)) {
                                this.f31118b.set(i11, e3Var2.a(c4, b4, e2, false));
                                z10 = true;
                                break;
                            }
                            i11++;
                        }
                        if (!z10) {
                            this.f31118b.add(e3Var);
                        }
                    }
                    return f();
                }
                throw com.huawei.hms.scankit.p.a.a();
            }
        }
        if (this.f31118b.size() == 2) {
            int i12 = this.f31118b.get(0).e() > this.f31118b.get(1).e() ? 0 : 1;
            if (Math.max(this.f31118b.get(0).e(), this.f31118b.get(1).e()) / Math.min(this.f31118b.get(0).e(), this.f31118b.get(1).e()) > 1.5d) {
                e3 e3Var3 = this.f31118b.get(i12);
                this.f31118b.clear();
                this.f31118b.add(e3Var3);
            }
        }
        if (this.f31118b.size() <= 1 && this.f31119c.size() >= 1) {
            for (int i13 = 0; i13 < this.f31118b.size(); i13++) {
                e3 e3Var4 = this.f31118b.get(i13);
                float e10 = e3Var4.e();
                float c10 = e3Var4.c();
                float b10 = e3Var4.b();
                int i14 = 0;
                while (true) {
                    if (i14 >= this.f31119c.size()) {
                        z11 = false;
                        break;
                    }
                    e3 e3Var5 = this.f31119c.get(i14);
                    if (e3Var5.b(e10, c10, b10)) {
                        this.f31119c.set(i14, e3Var4.a(e3Var5.c(), e3Var5.b(), e3Var5.e(), false));
                        z11 = true;
                        break;
                    }
                    i14++;
                }
                if (!z11) {
                    this.f31119c.add(e3Var4);
                }
            }
            this.f31118b.clear();
            this.f31118b.addAll(this.f31119c);
            this.f31119c.clear();
        }
        if (this.f31118b.size() == 2) {
            try {
                return g();
            } catch (com.huawei.hms.scankit.p.a unused2) {
                return a();
            }
        }
        if (this.f31118b.size() > 1) {
            return f();
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    private int[] d() {
        a(this.f31120d);
        return this.f31120d;
    }

    private static void e() {
        f31114h = false;
        f31115i = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private e3[] f() throws com.huawei.hms.scankit.p.a {
        int size = this.f31118b.size();
        if (size < 3) {
            throw com.huawei.hms.scankit.p.a.a();
        }
        e3[] e3VarArr = new e3[3];
        if (size == 3) {
            e3VarArr[0] = this.f31118b.get(0);
            e3VarArr[1] = this.f31118b.get(1);
            e3VarArr[2] = this.f31118b.get(2);
            if (b(e3VarArr[0], e3VarArr[1], e3VarArr[2], new float[3])) {
                return e3VarArr;
            }
            throw com.huawei.hms.scankit.p.a.a();
        }
        Collections.sort(this.f31118b, new c());
        if (this.f31118b.get(2).a() - this.f31118b.get(3).a() > 1 && this.f31118b.get(2).a() > 1) {
            e3VarArr[0] = this.f31118b.get(0);
            e3VarArr[1] = this.f31118b.get(1);
            e3VarArr[2] = this.f31118b.get(2);
            return e3VarArr;
        }
        float f10 = 0.0f;
        if (this.f31118b.get(3).a() > 1) {
            float f11 = 0.0f;
            for (int i10 = 0; i10 < 4; i10++) {
                f11 += this.f31118b.get(i10).e();
            }
            float f12 = f11 / 4.0f;
            int i11 = 0;
            for (int i12 = 0; i12 < 4; i12++) {
                float abs = Math.abs(this.f31118b.get(i12).e() - f12);
                if (abs > f10) {
                    i11 = i12;
                    f10 = abs;
                }
            }
            if (i11 == 0) {
                e3VarArr[0] = this.f31118b.get(1);
                e3VarArr[1] = this.f31118b.get(2);
                e3VarArr[2] = this.f31118b.get(3);
            } else if (i11 == 1) {
                e3VarArr[0] = this.f31118b.get(0);
                e3VarArr[1] = this.f31118b.get(2);
                e3VarArr[2] = this.f31118b.get(3);
            } else if (i11 != 2) {
                e3VarArr[0] = this.f31118b.get(0);
                e3VarArr[1] = this.f31118b.get(1);
                e3VarArr[2] = this.f31118b.get(2);
            } else {
                e3VarArr[0] = this.f31118b.get(0);
                e3VarArr[1] = this.f31118b.get(1);
                e3VarArr[2] = this.f31118b.get(3);
            }
            if (b(e3VarArr[0], e3VarArr[1], e3VarArr[2], new float[3])) {
                return e3VarArr;
            }
            throw com.huawei.hms.scankit.p.a.a();
        }
        if (this.f31118b.get(1).a() > 1 && this.f31118b.get(2).a() == 1) {
            ArrayList arrayList = new ArrayList();
            float e2 = (this.f31118b.get(0).e() + this.f31118b.get(1).e()) / 2.0f;
            for (int i13 = 2; i13 < size; i13++) {
                if (Math.abs(this.f31118b.get(i13).e() - e2) < e2 * 0.5d) {
                    arrayList.add(this.f31118b.get(i13));
                }
            }
            int i14 = 0;
            for (int i15 = 0; i15 < arrayList.size(); i15++) {
                float[] fArr = new float[3];
                if (b(this.f31118b.get(0), this.f31118b.get(1), (e3) arrayList.get(i15), fArr) && fArr[0] >= f10) {
                    f10 = fArr[0];
                    i14 = i15;
                }
            }
            e3VarArr[0] = this.f31118b.get(0);
            e3VarArr[1] = this.f31118b.get(1);
            if (i14 < arrayList.size()) {
                e3VarArr[2] = (e3) arrayList.get(i14);
                return e3VarArr;
            }
            throw com.huawei.hms.scankit.p.a.a();
        }
        if (size > 3) {
            float f13 = 0.0f;
            float f14 = 0.0f;
            for (int i16 = 0; i16 < size; i16++) {
                float e10 = this.f31118b.get(i16).e();
                f13 += e10;
                f14 += e10 * e10;
            }
            float f15 = f13 / size;
            float sqrt = (float) Math.sqrt((f14 / r1) - (f15 * f15));
            Collections.sort(this.f31118b, new e(f15));
            float max = Math.max(0.5f * f15, sqrt);
            int i17 = 0;
            while (i17 < this.f31118b.size() && this.f31118b.size() > 3) {
                if (Math.abs(this.f31118b.get(i17).e() - f15) > max) {
                    this.f31118b.remove(i17);
                    i17--;
                }
                i17++;
            }
        }
        if (this.f31118b.size() > 15) {
            Collections.sort(this.f31118b, new c());
            List<e3> list = this.f31118b;
            list.subList(15, list.size()).clear();
        } else if (this.f31118b.size() > 12) {
            Collections.sort(this.f31118b, new c());
            List<e3> list2 = this.f31118b;
            list2.subList(12, list2.size()).clear();
        }
        if (this.f31118b.size() >= 6) {
            Collections.sort(this.f31118b, new f());
            List<e3> list3 = this.f31118b;
            list3.subList(4, list3.size() - 2).clear();
            Collections.sort(this.f31118b, new g());
            this.f31118b.subList(1, 3).clear();
            Collections.sort(this.f31118b, new g());
            List<e3> list4 = this.f31118b;
            list4.subList(list4.size() - 1, this.f31118b.size()).clear();
        } else if (this.f31118b.size() > 3) {
            for (int i18 = 0; i18 < this.f31118b.size(); i18++) {
                f10 += this.f31118b.get(i18).e();
            }
            Collections.sort(this.f31118b, new b(f10 / this.f31118b.size()));
            List<e3> list5 = this.f31118b;
            list5.subList(3, list5.size()).clear();
        }
        e3VarArr[0] = this.f31118b.get(0);
        e3VarArr[1] = this.f31118b.get(1);
        e3VarArr[2] = this.f31118b.get(2);
        if (b(e3VarArr[0], e3VarArr[1], e3VarArr[2], new float[3])) {
            return e3VarArr;
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x01bc, code lost:
    
        if (r2 == false) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.hms.scankit.p.e3[] g() throws com.huawei.hms.scankit.p.a {
        /*
            Method dump skipped, instructions count: 551
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.i3.g():com.huawei.hms.scankit.p.e3[]");
    }

    public final k3 b() throws com.huawei.hms.scankit.p.a {
        int c4 = this.f31117a.c();
        int e2 = this.f31117a.e();
        int i10 = (c4 * 3) / 388;
        if (i10 < 3) {
            i10 = 3;
        }
        if (r3.f31459n) {
            i10 = 2;
        }
        a(i10, c4, e2);
        e3[] c10 = c();
        if (c10 != null) {
            u6.a(c10);
            if ((this.f31117a.c() * this.f31117a.e()) / (Math.sqrt(a(c10[0], c10[1])) * Math.sqrt(a(c10[1], c10[2]))) <= 900.0d) {
                return new k3(c10);
            }
            throw com.huawei.hms.scankit.p.a.a();
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    public final void d(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }

    /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
        jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private void a(int r11, int r12, int r13) {
        /*
            r10 = this;
            r0 = 5
            int[] r1 = new int[r0]
            int r2 = r11 + (-1)
        L5:
            if (r2 >= r12) goto L5e
            r10.a(r1)
            int[] r3 = new int[r0]
            r4 = 0
            r3[r4] = r4
            r5 = 1
            r3[r5] = r2
            r6 = 2
            r3[r6] = r4
            r7 = 3
            r3[r7] = r13
            r7 = 4
            r3[r7] = r11
            r8 = 0
        L1c:
            if (r8 >= r13) goto L39
            r3[r6] = r8
            com.huawei.hms.scankit.p.s r9 = r10.f31117a
            boolean r9 = r9.b(r8, r2)
            if (r9 == 0) goto L2c
            r10.a(r1, r3)
            goto L33
        L2c:
            boolean r9 = r10.b(r1, r3)
            if (r9 == 0) goto L33
            goto L37
        L33:
            r8 = r3[r6]
            r11 = r3[r7]
        L37:
            int r8 = r8 + r5
            goto L1c
        L39:
            boolean r5 = b(r1)
            if (r5 == 0) goto L4e
            r3 = r3[r4]
            r5 = r13
        L42:
            if (r3 <= r6) goto L4a
            r7 = r1[r3]
            int r5 = r5 - r7
            int r3 = r3 + (-1)
            goto L42
        L4a:
            r10.b(r1, r2, r5)
            goto L4f
        L4e:
            r5 = r13
        L4f:
            boolean r3 = a(r1, r4)
            if (r3 == 0) goto L5c
            boolean r3 = r10.a(r1, r2, r5, r4)
            if (r3 == 0) goto L5c
            r11 = 2
        L5c:
            int r2 = r2 + r11
            goto L5
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.i3.a(int, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001c, code lost:
    
        if (r8[3] <= r7) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0020, code lost:
    
        if (r5 < 0) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0026, code lost:
    
        if (r0.b(r6, r5) == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002a, code lost:
    
        if (r8[2] > r7) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002c, code lost:
    
        r8[2] = r8[2] + 1;
        r5 = r5 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0034, code lost:
    
        if (r5 < 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0038, code lost:
    
        if (r8[2] <= r7) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003b, code lost:
    
        if (r5 < 0) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0041, code lost:
    
        if (r0.b(r6, r5) != false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0045, code lost:
    
        if (r8[1] > r7) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0047, code lost:
    
        r8[1] = r8[1] + 1;
        r5 = r5 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004f, code lost:
    
        if (r5 < 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0053, code lost:
    
        if (r8[1] <= r7) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0057, code lost:
    
        if (r5 < 0) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x005d, code lost:
    
        if (r0.b(r6, r5) == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0061, code lost:
    
        if (r8[0] > r7) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0063, code lost:
    
        r8[0] = r8[0] + 1;
        r5 = r5 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x006d, code lost:
    
        if (r8[0] <= r7) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x006f, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0070, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean d(int r5, int r6, int r7, int[] r8) {
        /*
            r4 = this;
            com.huawei.hms.scankit.p.s r0 = r4.f31117a
        L2:
            r1 = 3
            r2 = 1
            if (r5 < 0) goto L18
            boolean r3 = r0.b(r6, r5)
            if (r3 != 0) goto L18
            r3 = r8[r1]
            if (r3 > r7) goto L18
            r3 = r8[r1]
            int r3 = r3 + r2
            r8[r1] = r3
            int r5 = r5 + (-1)
            goto L2
        L18:
            if (r5 < 0) goto L71
            r1 = r8[r1]
            if (r1 <= r7) goto L1f
            goto L71
        L1f:
            r1 = 2
            if (r5 < 0) goto L34
            boolean r3 = r0.b(r6, r5)
            if (r3 == 0) goto L34
            r3 = r8[r1]
            if (r3 > r7) goto L34
            r3 = r8[r1]
            int r3 = r3 + r2
            r8[r1] = r3
            int r5 = r5 + (-1)
            goto L1f
        L34:
            if (r5 < 0) goto L71
            r1 = r8[r1]
            if (r1 <= r7) goto L3b
            goto L71
        L3b:
            if (r5 < 0) goto L4f
            boolean r1 = r0.b(r6, r5)
            if (r1 != 0) goto L4f
            r1 = r8[r2]
            if (r1 > r7) goto L4f
            r1 = r8[r2]
            int r1 = r1 + r2
            r8[r2] = r1
            int r5 = r5 + (-1)
            goto L3b
        L4f:
            if (r5 < 0) goto L71
            r1 = r8[r2]
            if (r1 <= r7) goto L56
            goto L71
        L56:
            r1 = 0
            if (r5 < 0) goto L6b
            boolean r3 = r0.b(r6, r5)
            if (r3 == 0) goto L6b
            r3 = r8[r1]
            if (r3 > r7) goto L6b
            r3 = r8[r1]
            int r3 = r3 + r2
            r8[r1] = r3
            int r5 = r5 + (-1)
            goto L56
        L6b:
            r5 = r8[r1]
            if (r5 <= r7) goto L70
            return r2
        L70:
            return r1
        L71:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.i3.d(int, int, int, int[]):boolean");
    }

    private void a(int[] iArr, int[] iArr2) {
        if ((iArr2[0] & 1) == 1) {
            iArr2[0] = iArr2[0] + 1;
        }
        if (iArr2[0] >= 0 && iArr2[0] < iArr.length) {
            int i10 = iArr2[0];
            iArr[i10] = iArr[i10] + 1;
        }
        if (iArr2[2] == iArr2[3] - 1 && iArr2[0] == 4) {
            if (a(iArr, false)) {
                boolean a10 = a(iArr, iArr2[1], iArr2[2], false);
                if (a10) {
                    iArr2[4] = 2;
                }
                if (!a10) {
                    a10 = a(iArr, iArr2[1], iArr2[2]);
                }
                if (a10) {
                    iArr2[0] = 0;
                    a(iArr);
                    while (iArr2[2] < this.f31117a.e() && !this.f31117a.b(iArr2[2], iArr2[1])) {
                        iArr2[2] = iArr2[2] + 1;
                    }
                }
            }
            if (r3.f31453h && a(iArr, true) && a(iArr, iArr2[1], iArr2[2], true)) {
                iArr2[0] = 0;
                a(iArr);
            }
        }
    }

    private boolean b(int[] iArr, int[] iArr2) {
        if ((iArr2[0] & 1) == 0) {
            if (iArr2[0] == 4) {
                if (a(iArr, false)) {
                    boolean a10 = a(iArr, iArr2[1], iArr2[2], false);
                    if (a10) {
                        iArr2[4] = 2;
                    }
                    if (!a10) {
                        a10 = a(iArr, iArr2[1], iArr2[2]);
                    }
                    if (a10) {
                        iArr2[0] = 0;
                        a(iArr);
                        return true;
                    }
                }
                if (b(iArr)) {
                    int i10 = iArr2[2];
                    for (int i11 = iArr2[0]; i11 > 2; i11--) {
                        i10 -= iArr[i11];
                    }
                    if (b(iArr, iArr2[1], i10)) {
                        d(iArr);
                        iArr2[0] = 3;
                        return true;
                    }
                }
                if (r3.f31453h && a(iArr, true) && a(iArr, iArr2[1], iArr2[2], true)) {
                    iArr2[0] = 0;
                    a(iArr);
                    return true;
                }
                d(iArr);
                iArr2[0] = 3;
            } else {
                int i12 = iArr2[0] + 1;
                iArr2[0] = i12;
                iArr[i12] = iArr[i12] + 1;
            }
        } else {
            int i13 = iArr2[0];
            iArr[i13] = iArr[i13] + 1;
        }
        return false;
    }

    private static float a(int[] iArr, int i10) {
        return ((i10 - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    public static boolean a(int[] iArr, boolean z10) {
        float f10;
        float f11;
        e();
        int i10 = 0;
        for (int i11 = 0; i11 < 5; i11++) {
            int i12 = iArr[i11];
            if (i12 == 0) {
                return false;
            }
            i10 += i12;
        }
        if (i10 < 7) {
            return false;
        }
        if (z10 && r3.f31453h) {
            f10 = 0.75f;
            f11 = 1.0f;
        } else {
            f10 = 0.5f;
            f11 = 3.0f;
        }
        float f12 = i10 / 7.0f;
        float f13 = f10 * f12;
        if (Math.abs(f12 - iArr[0]) < f13 && Math.abs(f12 - iArr[1]) < f13 && Math.abs((3.0f * f12) - iArr[2]) < f11 * f13 && Math.abs(f12 - iArr[3]) < f13 && Math.abs(f12 - iArr[4]) < f13) {
            return true;
        }
        if (!z10) {
            return false;
        }
        int[] iArr2 = new int[iArr.length - 1];
        int i13 = 0;
        while (i13 < iArr.length - 1) {
            int i14 = i13 + 1;
            iArr2[i13] = iArr[i14];
            i13 = i14;
        }
        int[] iArr3 = new int[iArr.length - 1];
        for (int i15 = 0; i15 < iArr.length - 1; i15++) {
            iArr3[i15] = iArr[i15];
        }
        float a10 = a(iArr2, f31112f, 0.5f);
        float a11 = a(iArr3, f31113g, 0.5f);
        boolean z11 = a10 < 0.3f;
        f31114h = z11;
        boolean z12 = a11 < 0.3f;
        f31115i = z12;
        return z11 || z12;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0042, code lost:
    
        if (r2[3] < r12) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0046, code lost:
    
        if (r10 >= r1) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004c, code lost:
    
        if (r0.b(r11, r10) == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0050, code lost:
    
        if (r2[4] >= r12) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0052, code lost:
    
        r2[4] = r2[4] + 1;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005e, code lost:
    
        if (a(r2, r14) != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0060, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0061, code lost:
    
        r11 = (((r2[0] + r2[1]) + r2[2]) + r2[3]) + r2[4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0070, code lost:
    
        if (r14 == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x007b, code lost:
    
        if ((java.lang.Math.abs(r11 - r13) * 5) < (r13 * 3)) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x007f, code lost:
    
        if (com.huawei.hms.scankit.p.i3.f31115i != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0083, code lost:
    
        if (com.huawei.hms.scankit.p.i3.f31114h != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0085, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0093, code lost:
    
        return a(r2, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0088, code lost:
    
        if (r11 >= (r13 * 3)) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008c, code lost:
    
        if ((r11 * 3) > r13) goto L48;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float b(int r10, int r11, int r12, int r13, boolean r14) {
        /*
            r9 = this;
            com.huawei.hms.scankit.p.s r0 = r9.f31117a
            int r1 = r0.c()
            int[] r2 = r9.d()
            boolean r3 = r9.b(r10, r11, r12, r2)
            r4 = 2143289344(0x7fc00000, float:NaN)
            if (r3 == 0) goto L13
            return r4
        L13:
            r3 = 1
            int r10 = r10 + r3
        L15:
            r5 = 2
            if (r10 >= r1) goto L26
            boolean r6 = r0.b(r11, r10)
            if (r6 == 0) goto L26
            r6 = r2[r5]
            int r6 = r6 + r3
            r2[r5] = r6
            int r10 = r10 + 1
            goto L15
        L26:
            if (r10 != r1) goto L29
            return r4
        L29:
            r6 = 3
            if (r10 >= r1) goto L3e
            boolean r7 = r0.b(r11, r10)
            if (r7 != 0) goto L3e
            r7 = r2[r6]
            if (r7 >= r12) goto L3e
            r7 = r2[r6]
            int r7 = r7 + r3
            r2[r6] = r7
            int r10 = r10 + 1
            goto L29
        L3e:
            if (r10 == r1) goto L94
            r7 = r2[r6]
            if (r7 < r12) goto L45
            goto L94
        L45:
            r7 = 4
            if (r10 >= r1) goto L5a
            boolean r8 = r0.b(r11, r10)
            if (r8 == 0) goto L5a
            r8 = r2[r7]
            if (r8 >= r12) goto L5a
            r8 = r2[r7]
            int r8 = r8 + r3
            r2[r7] = r8
            int r10 = r10 + 1
            goto L45
        L5a:
            boolean r11 = a(r2, r14)
            if (r11 != 0) goto L61
            return r4
        L61:
            r11 = 0
            r11 = r2[r11]
            r12 = r2[r3]
            int r11 = r11 + r12
            r12 = r2[r5]
            int r11 = r11 + r12
            r12 = r2[r6]
            int r11 = r11 + r12
            r12 = r2[r7]
            int r11 = r11 + r12
            if (r14 == 0) goto L86
            int r11 = r11 - r13
            int r11 = java.lang.Math.abs(r11)
            int r11 = r11 * 5
            int r13 = r13 * 3
            if (r11 < r13) goto L8f
            boolean r11 = com.huawei.hms.scankit.p.i3.f31115i
            if (r11 != 0) goto L8f
            boolean r11 = com.huawei.hms.scankit.p.i3.f31114h
            if (r11 != 0) goto L8f
            return r4
        L86:
            int r12 = r13 * 3
            if (r11 >= r12) goto L94
            int r11 = r11 * 3
            if (r11 > r13) goto L8f
            goto L94
        L8f:
            float r10 = a(r2, r10)
            return r10
        L94:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.i3.b(int, int, int, int, boolean):float");
    }

    public static boolean c(int[] iArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 5; i11++) {
            int i12 = iArr[i11];
            if (i12 == 0) {
                return false;
            }
            i10 += i12;
        }
        if (i10 < 7) {
            return false;
        }
        float f10 = i10 / 7.0f;
        float f11 = 0.75f * f10;
        return Math.abs(f10 - ((float) iArr[0])) < f11 && Math.abs(f10 - ((float) iArr[1])) < f11 && Math.abs((f10 * 3.0f) - ((float) iArr[2])) < 3.0f * f11 && Math.abs(f10 - ((float) iArr[3])) < f11 && Math.abs(f10 - ((float) iArr[4])) < f11;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001b, code lost:
    
        if (r8[1] <= r7) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001f, code lost:
    
        if (r5 < 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0025, code lost:
    
        if (r0.b(r6, r5) == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0029, code lost:
    
        if (r8[0] > r7) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002b, code lost:
    
        r8[0] = r8[0] + 1;
        r5 = r5 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0035, code lost:
    
        if (r8[0] <= r7) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0037, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0038, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean c(int r5, int r6, int r7, int[] r8) {
        /*
            r4 = this;
            com.huawei.hms.scankit.p.s r0 = r4.f31117a
        L2:
            r1 = 1
            if (r5 < 0) goto L17
            boolean r2 = r0.b(r6, r5)
            if (r2 != 0) goto L17
            r2 = r8[r1]
            if (r2 > r7) goto L17
            r2 = r8[r1]
            int r2 = r2 + r1
            r8[r1] = r2
            int r5 = r5 + (-1)
            goto L2
        L17:
            if (r5 < 0) goto L39
            r2 = r8[r1]
            if (r2 <= r7) goto L1e
            goto L39
        L1e:
            r2 = 0
            if (r5 < 0) goto L33
            boolean r3 = r0.b(r6, r5)
            if (r3 == 0) goto L33
            r3 = r8[r2]
            if (r3 > r7) goto L33
            r3 = r8[r2]
            int r3 = r3 + r1
            r8[r2] = r3
            int r5 = r5 + (-1)
            goto L1e
        L33:
            r5 = r8[r2]
            if (r5 <= r7) goto L38
            return r1
        L38:
            return r2
        L39:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.i3.c(int, int, int, int[]):boolean");
    }

    public final void a(int[] iArr) {
        for (int i10 = 0; i10 < iArr.length; i10++) {
            iArr[i10] = 0;
        }
    }

    private boolean a(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int[] d10 = d();
        int i15 = 0;
        while (i10 >= i15 && i11 >= i15 && this.f31117a.b(i11 - i15, i10 - i15)) {
            d10[2] = d10[2] + 1;
            i15++;
        }
        if (d10[2] == 0) {
            return false;
        }
        while (i10 >= i15 && i11 >= i15 && !this.f31117a.b(i11 - i15, i10 - i15)) {
            d10[1] = d10[1] + 1;
            i15++;
        }
        if (d10[1] == 0) {
            return false;
        }
        while (i10 >= i15 && i11 >= i15 && this.f31117a.b(i11 - i15, i10 - i15)) {
            d10[0] = d10[0] + 1;
            i15++;
        }
        if (d10[0] == 0) {
            return false;
        }
        int c4 = this.f31117a.c();
        int e2 = this.f31117a.e();
        int i16 = 1;
        while (true) {
            int i17 = i10 + i16;
            if (i17 >= c4 || (i14 = i11 + i16) >= e2 || !this.f31117a.b(i14, i17)) {
                break;
            }
            d10[2] = d10[2] + 1;
            i16++;
        }
        while (true) {
            int i18 = i10 + i16;
            if (i18 >= c4 || (i13 = i11 + i16) >= e2 || this.f31117a.b(i13, i18)) {
                break;
            }
            d10[3] = d10[3] + 1;
            i16++;
        }
        if (d10[3] == 0) {
            return false;
        }
        while (true) {
            int i19 = i10 + i16;
            if (i19 >= c4 || (i12 = i11 + i16) >= e2 || !this.f31117a.b(i12, i19)) {
                break;
            }
            d10[4] = d10[4] + 1;
            i16++;
        }
        if (d10[4] == 0) {
            return false;
        }
        return c(d10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002f, code lost:
    
        if (r8[1] <= r7) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0033, code lost:
    
        if (r5 < 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0039, code lost:
    
        if (r0.b(r6, r5) == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003d, code lost:
    
        if (r8[0] > r7) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003f, code lost:
    
        r8[0] = r8[0] + 1;
        r5 = r5 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0047, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean b(int r5, int r6, int r7, int[] r8) {
        /*
            r4 = this;
            com.huawei.hms.scankit.p.s r0 = r4.f31117a
        L2:
            r1 = 1
            if (r5 < 0) goto L14
            boolean r2 = r0.b(r6, r5)
            if (r2 == 0) goto L14
            r2 = 2
            r3 = r8[r2]
            int r3 = r3 + r1
            r8[r2] = r3
            int r5 = r5 + (-1)
            goto L2
        L14:
            if (r5 >= 0) goto L17
            return r1
        L17:
            if (r5 < 0) goto L2b
            boolean r2 = r0.b(r6, r5)
            if (r2 != 0) goto L2b
            r2 = r8[r1]
            if (r2 > r7) goto L2b
            r2 = r8[r1]
            int r2 = r2 + r1
            r8[r1] = r2
            int r5 = r5 + (-1)
            goto L17
        L2b:
            if (r5 < 0) goto L48
            r2 = r8[r1]
            if (r2 <= r7) goto L32
            goto L48
        L32:
            r2 = 0
            if (r5 < 0) goto L47
            boolean r3 = r0.b(r6, r5)
            if (r3 == 0) goto L47
            r3 = r8[r2]
            if (r3 > r7) goto L47
            r3 = r8[r2]
            int r3 = r3 + r1
            r8[r2] = r3
            int r5 = r5 + (-1)
            goto L32
        L47:
            return r2
        L48:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.i3.b(int, int, int, int[]):boolean");
    }

    private static boolean b(e3 e3Var, e3 e3Var2, e3 e3Var3, float[] fArr) {
        a(e3Var, e3Var2, e3Var3, fArr);
        float sqrt = (float) Math.sqrt(fArr[1]);
        float sqrt2 = (float) Math.sqrt(fArr[2]);
        float sqrt3 = (float) Math.sqrt(fArr[0]);
        if (Math.min(Math.min(sqrt, sqrt2), sqrt3) <= Math.max(Math.max(e3Var.e(), e3Var2.e()), e3Var3.e()) * 7.0f) {
            return false;
        }
        float f10 = ((fArr[1] + fArr[2]) - fArr[0]) / ((sqrt * 2.0f) * sqrt2);
        float f11 = sqrt3 * 2.0f;
        float f12 = ((fArr[0] + fArr[1]) - fArr[2]) / (sqrt * f11);
        float f13 = ((fArr[0] + fArr[2]) - fArr[1]) / (f11 * sqrt2);
        return Math.abs(f10) <= 0.45f && f12 >= 0.2588f && f12 <= 0.94f && f13 >= 0.2588f && f13 <= 0.94f;
    }

    public static boolean b(int[] iArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 3; i11++) {
            int i12 = iArr[i11];
            if (i12 == 0) {
                return false;
            }
            i10 += i12;
        }
        if (i10 < 7) {
            return false;
        }
        float f10 = i10 / 7.0f;
        float f11 = 0.5f * f10;
        return Math.abs(f10 - ((float) iArr[0])) < f11 && Math.abs((5.0f * f10) - ((float) iArr[1])) < f11 && Math.abs(f10 - ((float) iArr[2])) < f11;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0042, code lost:
    
        if (r2[3] < r12) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0046, code lost:
    
        if (r10 >= r1) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004c, code lost:
    
        if (r0.b(r10, r11) == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0050, code lost:
    
        if (r2[4] >= r12) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0052, code lost:
    
        r2[4] = r2[4] + 1;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005e, code lost:
    
        if (a(r2, r14) != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0060, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0077, code lost:
    
        if ((java.lang.Math.abs(((((r2[0] + r2[1]) + r2[2]) + r2[3]) + r2[4]) - r13) * 5) < r13) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x007b, code lost:
    
        if (com.huawei.hms.scankit.p.i3.f31115i != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x007f, code lost:
    
        if (com.huawei.hms.scankit.p.i3.f31114h != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0081, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0086, code lost:
    
        return a(r2, r10);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float a(int r10, int r11, int r12, int r13, boolean r14) {
        /*
            r9 = this;
            com.huawei.hms.scankit.p.s r0 = r9.f31117a
            int r1 = r0.e()
            int[] r2 = r9.d()
            boolean r3 = r9.a(r10, r11, r12, r2)
            r4 = 2143289344(0x7fc00000, float:NaN)
            if (r3 == 0) goto L13
            return r4
        L13:
            r3 = 1
            int r10 = r10 + r3
        L15:
            r5 = 2
            if (r10 >= r1) goto L26
            boolean r6 = r0.b(r10, r11)
            if (r6 == 0) goto L26
            r6 = r2[r5]
            int r6 = r6 + r3
            r2[r5] = r6
            int r10 = r10 + 1
            goto L15
        L26:
            if (r10 != r1) goto L29
            return r4
        L29:
            r6 = 3
            if (r10 >= r1) goto L3e
            boolean r7 = r0.b(r10, r11)
            if (r7 != 0) goto L3e
            r7 = r2[r6]
            if (r7 >= r12) goto L3e
            r7 = r2[r6]
            int r7 = r7 + r3
            r2[r6] = r7
            int r10 = r10 + 1
            goto L29
        L3e:
            if (r10 == r1) goto L87
            r7 = r2[r6]
            if (r7 < r12) goto L45
            goto L87
        L45:
            r7 = 4
            if (r10 >= r1) goto L5a
            boolean r8 = r0.b(r10, r11)
            if (r8 == 0) goto L5a
            r8 = r2[r7]
            if (r8 >= r12) goto L5a
            r8 = r2[r7]
            int r8 = r8 + r3
            r2[r7] = r8
            int r10 = r10 + 1
            goto L45
        L5a:
            boolean r11 = a(r2, r14)
            if (r11 != 0) goto L61
            return r4
        L61:
            r11 = 0
            r11 = r2[r11]
            r12 = r2[r3]
            int r11 = r11 + r12
            r12 = r2[r5]
            int r11 = r11 + r12
            r12 = r2[r6]
            int r11 = r11 + r12
            r12 = r2[r7]
            int r11 = r11 + r12
            int r11 = r11 - r13
            int r11 = java.lang.Math.abs(r11)
            int r11 = r11 * 5
            if (r11 < r13) goto L82
            boolean r11 = com.huawei.hms.scankit.p.i3.f31115i
            if (r11 != 0) goto L82
            boolean r11 = com.huawei.hms.scankit.p.i3.f31114h
            if (r11 != 0) goto L82
            return r4
        L82:
            float r10 = a(r2, r10)
            return r10
        L87:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.i3.a(int, int, int, int, boolean):float");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002e, code lost:
    
        if (r2[3] <= r11) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
    
        if (r9 >= r1) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0038, code lost:
    
        if (r0.b(r10, r9) == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003a, code lost:
    
        r2[4] = r2[4] + 1;
        r9 = r9 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0044, code lost:
    
        if (r2[4] <= r11) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0046, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0060, code lost:
    
        if ((java.lang.Math.abs(((((r2[0] + r2[1]) + r2[2]) + r2[3]) + r2[4]) - r12) * 5) < (r12 * 2)) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0062, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0067, code lost:
    
        if (a(r2, true) == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006d, code lost:
    
        return a(r2, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:?, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:?, code lost:
    
        return Float.NaN;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float b(int r9, int r10, int r11, int r12) {
        /*
            r8 = this;
            com.huawei.hms.scankit.p.s r0 = r8.f31117a
            int r1 = r0.c()
            int[] r2 = r8.d()
            boolean r3 = r8.d(r9, r10, r11, r2)
            r4 = 2143289344(0x7fc00000, float:NaN)
            if (r3 == 0) goto L13
            return r4
        L13:
            r3 = 1
            int r9 = r9 + r3
        L15:
            r5 = 3
            if (r9 >= r1) goto L2a
            boolean r6 = r0.b(r10, r9)
            if (r6 != 0) goto L2a
            r6 = r2[r5]
            if (r6 > r11) goto L2a
            r6 = r2[r5]
            int r6 = r6 + r3
            r2[r5] = r6
            int r9 = r9 + 1
            goto L15
        L2a:
            if (r9 < 0) goto L6d
            r6 = r2[r5]
            if (r6 <= r11) goto L31
            goto L6d
        L31:
            r6 = 4
            if (r9 >= r1) goto L42
            boolean r7 = r0.b(r10, r9)
            if (r7 == 0) goto L42
            r7 = r2[r6]
            int r7 = r7 + r3
            r2[r6] = r7
            int r9 = r9 + 1
            goto L31
        L42:
            r10 = r2[r6]
            if (r10 <= r11) goto L47
            return r4
        L47:
            r10 = 0
            r10 = r2[r10]
            r11 = r2[r3]
            int r10 = r10 + r11
            r11 = 2
            r0 = r2[r11]
            int r10 = r10 + r0
            r0 = r2[r5]
            int r10 = r10 + r0
            r0 = r2[r6]
            int r10 = r10 + r0
            int r10 = r10 - r12
            int r10 = java.lang.Math.abs(r10)
            int r10 = r10 * 5
            int r12 = r12 * 2
            if (r10 < r12) goto L63
            return r4
        L63:
            boolean r10 = a(r2, r3)
            if (r10 == 0) goto L6d
            float r4 = a(r2, r9)
        L6d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.i3.b(int, int, int, int):float");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002f, code lost:
    
        if (r8[1] <= r7) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0033, code lost:
    
        if (r5 < 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0039, code lost:
    
        if (r0.b(r5, r6) == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003d, code lost:
    
        if (r8[0] > r7) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003f, code lost:
    
        r8[0] = r8[0] + 1;
        r5 = r5 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0047, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(int r5, int r6, int r7, int[] r8) {
        /*
            r4 = this;
            com.huawei.hms.scankit.p.s r0 = r4.f31117a
        L2:
            r1 = 1
            if (r5 < 0) goto L14
            boolean r2 = r0.b(r5, r6)
            if (r2 == 0) goto L14
            r2 = 2
            r3 = r8[r2]
            int r3 = r3 + r1
            r8[r2] = r3
            int r5 = r5 + (-1)
            goto L2
        L14:
            if (r5 >= 0) goto L17
            return r1
        L17:
            if (r5 < 0) goto L2b
            boolean r2 = r0.b(r5, r6)
            if (r2 != 0) goto L2b
            r2 = r8[r1]
            if (r2 > r7) goto L2b
            r2 = r8[r1]
            int r2 = r2 + r1
            r8[r1] = r2
            int r5 = r5 + (-1)
            goto L17
        L2b:
            if (r5 < 0) goto L48
            r2 = r8[r1]
            if (r2 <= r7) goto L32
            goto L48
        L32:
            r2 = 0
            if (r5 < 0) goto L47
            boolean r3 = r0.b(r5, r6)
            if (r3 == 0) goto L47
            r3 = r8[r2]
            if (r3 > r7) goto L47
            r3 = r8[r2]
            int r3 = r3 + r1
            r8[r2] = r3
            int r5 = r5 + (-1)
            goto L32
        L47:
            return r2
        L48:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.i3.a(int, int, int, int[]):boolean");
    }

    public final boolean b(int[] iArr, int i10, int i11) {
        int i12 = iArr[0] + iArr[1] + iArr[2];
        float f10 = i11 - (i12 / 2);
        int i13 = (int) f10;
        float a10 = a(i10, i13, iArr[1], i12);
        if (Float.isNaN(a10)) {
            a10 = a(i10, (int) (f10 - ((iArr[1] * 2) / 5)), (int) (((iArr[1] * 2) / 5) + f10), iArr[1], i12);
            if (Float.isNaN(a10) && r3.f31453h) {
                a10 = b(i10, i13, iArr[1], i12);
            }
        }
        if (Float.isNaN(a10)) {
            return false;
        }
        return a(false, a10, f10, i12 / 7.0f);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(int[] r19, int r20, int r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 201
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.i3.a(int[], int, int, boolean):boolean");
    }

    private static double a(e3 e3Var, e3 e3Var2) {
        double b4 = e3Var.b() - e3Var2.b();
        double c4 = e3Var.c() - e3Var2.c();
        return (b4 * b4) + (c4 * c4);
    }

    private static void a(e3 e3Var, e3 e3Var2, e3 e3Var3, float[] fArr) {
        float b4 = e3Var.b() - e3Var2.b();
        float c4 = e3Var.c() - e3Var2.c();
        float f10 = (b4 * b4) + (c4 * c4);
        float b10 = e3Var.b() - e3Var3.b();
        float c10 = e3Var.c() - e3Var3.c();
        float f11 = (b10 * b10) + (c10 * c10);
        float b11 = e3Var2.b() - e3Var3.b();
        float c11 = e3Var2.c() - e3Var3.c();
        float f12 = (b11 * b11) + (c11 * c11);
        if (f10 > f12 && f10 > f11) {
            fArr[0] = f10;
            fArr[1] = f11;
            fArr[2] = f12;
        } else if (f12 > f10 && f12 > f11) {
            fArr[0] = f12;
            fArr[1] = f10;
            fArr[2] = f11;
        } else {
            fArr[0] = f11;
            fArr[1] = f10;
            fArr[2] = f12;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
    
        if (r2[1] <= r12) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0032, code lost:
    
        if (r10 >= r1) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0038, code lost:
    
        if (r0.b(r11, r10) == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003a, code lost:
    
        r2[2] = r2[2] + 1;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0042, code lost:
    
        if (r10 != r1) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0044, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0046, code lost:
    
        if (r10 >= r1) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004c, code lost:
    
        if (r0.b(r11, r10) != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0050, code lost:
    
        if (r2[3] >= r12) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0052, code lost:
    
        r2[3] = r2[3] + 1;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005a, code lost:
    
        if (r10 == r1) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005e, code lost:
    
        if (r2[3] < r12) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0062, code lost:
    
        if (r10 >= r1) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0068, code lost:
    
        if (r0.b(r11, r10) == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x006c, code lost:
    
        if (r2[4] >= r12) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x006e, code lost:
    
        r2[4] = r2[4] + 1;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0078, code lost:
    
        if (r2[4] < r12) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x007a, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0093, code lost:
    
        if ((java.lang.Math.abs(((((r2[0] + r2[1]) + r2[2]) + r2[3]) + r2[4]) - r13) * 5) < (r13 * 2)) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0095, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0098, code lost:
    
        if (com.huawei.hms.scankit.p.r3.f31453h == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x009e, code lost:
    
        if (a(r2, true) == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00a4, code lost:
    
        return a(r2, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:?, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00a9, code lost:
    
        if (a(r2, false) == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00af, code lost:
    
        return a(r2, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:?, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:?, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:?, code lost:
    
        return Float.NaN;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float a(int r10, int r11, int r12, int r13) {
        /*
            r9 = this;
            com.huawei.hms.scankit.p.s r0 = r9.f31117a
            int r1 = r0.c()
            int[] r2 = r9.d()
            boolean r3 = r9.c(r10, r11, r12, r2)
            r4 = 2143289344(0x7fc00000, float:NaN)
            if (r3 == 0) goto L13
            return r4
        L13:
            r3 = 1
            int r10 = r10 + r3
        L15:
            if (r10 >= r1) goto L29
            boolean r5 = r0.b(r11, r10)
            if (r5 != 0) goto L29
            r5 = r2[r3]
            if (r5 > r12) goto L29
            r5 = r2[r3]
            int r5 = r5 + r3
            r2[r3] = r5
            int r10 = r10 + 1
            goto L15
        L29:
            if (r10 < 0) goto Laf
            r5 = r2[r3]
            if (r5 <= r12) goto L31
            goto Laf
        L31:
            r5 = 2
            if (r10 >= r1) goto L42
            boolean r6 = r0.b(r11, r10)
            if (r6 == 0) goto L42
            r6 = r2[r5]
            int r6 = r6 + r3
            r2[r5] = r6
            int r10 = r10 + 1
            goto L31
        L42:
            if (r10 != r1) goto L45
            return r4
        L45:
            r6 = 3
            if (r10 >= r1) goto L5a
            boolean r7 = r0.b(r11, r10)
            if (r7 != 0) goto L5a
            r7 = r2[r6]
            if (r7 >= r12) goto L5a
            r7 = r2[r6]
            int r7 = r7 + r3
            r2[r6] = r7
            int r10 = r10 + 1
            goto L45
        L5a:
            if (r10 == r1) goto Laf
            r7 = r2[r6]
            if (r7 < r12) goto L61
            goto Laf
        L61:
            r7 = 4
            if (r10 >= r1) goto L76
            boolean r8 = r0.b(r11, r10)
            if (r8 == 0) goto L76
            r8 = r2[r7]
            if (r8 >= r12) goto L76
            r8 = r2[r7]
            int r8 = r8 + r3
            r2[r7] = r8
            int r10 = r10 + 1
            goto L61
        L76:
            r11 = r2[r7]
            if (r11 < r12) goto L7b
            return r4
        L7b:
            r11 = 0
            r12 = r2[r11]
            r0 = r2[r3]
            int r12 = r12 + r0
            r0 = r2[r5]
            int r12 = r12 + r0
            r0 = r2[r6]
            int r12 = r12 + r0
            r0 = r2[r7]
            int r12 = r12 + r0
            int r12 = r12 - r13
            int r12 = java.lang.Math.abs(r12)
            int r12 = r12 * 5
            int r13 = r13 * 2
            if (r12 < r13) goto L96
            return r4
        L96:
            boolean r12 = com.huawei.hms.scankit.p.r3.f31453h
            if (r12 == 0) goto La5
            boolean r11 = a(r2, r3)
            if (r11 == 0) goto La4
            float r4 = a(r2, r10)
        La4:
            return r4
        La5:
            boolean r11 = a(r2, r11)
            if (r11 == 0) goto Laf
            float r4 = a(r2, r10)
        Laf:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.i3.a(int, int, int, int):float");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002c, code lost:
    
        r11 = r19 * 1.5d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0036, code lost:
    
        if (r6[1] <= r11) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003b, code lost:
    
        if (r7 < 0) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
    
        if (r3.b(r5, r7) == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0045, code lost:
    
        if (r6[0] > r19) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0047, code lost:
    
        r6[0] = r6[0] + 1;
        r7 = r7 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0053, code lost:
    
        if (r6[0] <= (r19 / 2)) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
    
        r7 = r16 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0058, code lost:
    
        if (r7 >= r4) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005e, code lost:
    
        if (r3.b(r5, r7) != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0062, code lost:
    
        if (r6[1] > r19) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0064, code lost:
    
        r6[1] = r6[1] + 1;
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006c, code lost:
    
        if (r7 < 0) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0073, code lost:
    
        if (r6[1] <= r11) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0077, code lost:
    
        if (r7 >= r4) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x007d, code lost:
    
        if (r3.b(r5, r7) == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x007f, code lost:
    
        r6[2] = r6[2] + 1;
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0099, code lost:
    
        if ((java.lang.Math.abs(((r6[0] + r6[1]) + r6[2]) - r20) * 5) < (r20 * 2)) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a0, code lost:
    
        if (b(r6) == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00aa, code lost:
    
        return (r7 - (r6[1] / 2)) - r6[2];
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00ab, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ab, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ab, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ab, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00ab, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float a(int r16, int r17, int r18, int r19, int r20) {
        /*
            r15 = this;
            r0 = r18
            r1 = r19
            r2 = r15
            com.huawei.hms.scankit.p.s r3 = r2.f31117a
            int r4 = r3.c()
            r5 = r17
        Ld:
            if (r5 > r0) goto Lb0
            int[] r6 = r15.d()
            r7 = r16
        L15:
            r8 = 1
            if (r7 < 0) goto L2a
            boolean r9 = r3.b(r5, r7)
            if (r9 != 0) goto L2a
            r9 = r6[r8]
            if (r9 > r1) goto L2a
            r9 = r6[r8]
            int r9 = r9 + r8
            r6[r8] = r9
            int r7 = r7 + (-1)
            goto L15
        L2a:
            if (r7 < 0) goto Lab
            r9 = r6[r8]
            double r9 = (double) r9
            double r11 = (double) r1
            r13 = 4609434218613702656(0x3ff8000000000000, double:1.5)
            double r11 = r11 * r13
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 <= 0) goto L3a
            goto Lab
        L3a:
            r9 = 0
            if (r7 < 0) goto L4f
            boolean r10 = r3.b(r5, r7)
            if (r10 == 0) goto L4f
            r10 = r6[r9]
            if (r10 > r1) goto L4f
            r10 = r6[r9]
            int r10 = r10 + r8
            r6[r9] = r10
            int r7 = r7 + (-1)
            goto L3a
        L4f:
            r7 = r6[r9]
            int r10 = r1 / 2
            if (r7 <= r10) goto L56
            goto Lab
        L56:
            int r7 = r16 + 1
        L58:
            if (r7 >= r4) goto L6c
            boolean r10 = r3.b(r5, r7)
            if (r10 != 0) goto L6c
            r10 = r6[r8]
            if (r10 > r1) goto L6c
            r10 = r6[r8]
            int r10 = r10 + r8
            r6[r8] = r10
            int r7 = r7 + 1
            goto L58
        L6c:
            if (r7 < 0) goto Lab
            r10 = r6[r8]
            double r13 = (double) r10
            int r10 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r10 <= 0) goto L76
            goto Lab
        L76:
            r10 = 2
            if (r7 >= r4) goto L87
            boolean r11 = r3.b(r5, r7)
            if (r11 == 0) goto L87
            r11 = r6[r10]
            int r11 = r11 + r8
            r6[r10] = r11
            int r7 = r7 + 1
            goto L76
        L87:
            r9 = r6[r9]
            r11 = r6[r8]
            int r9 = r9 + r11
            r11 = r6[r10]
            int r9 = r9 + r11
            int r9 = r9 - r20
            int r9 = java.lang.Math.abs(r9)
            int r9 = r9 * 5
            int r11 = r20 * 2
            if (r9 < r11) goto L9c
            goto Lab
        L9c:
            boolean r9 = b(r6)
            if (r9 == 0) goto Lab
            r0 = r6[r8]
            int r0 = r0 / r10
            int r7 = r7 - r0
            r0 = r6[r10]
            int r7 = r7 - r0
            float r0 = (float) r7
            return r0
        Lab:
            int r6 = r0 - r17
            int r5 = r5 + r6
            goto Ld
        Lb0:
            r0 = 2143289344(0x7fc00000, float:NaN)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.i3.a(int, int, int, int, int):float");
    }

    public final boolean a(int[] iArr, int i10, int i11) {
        int i12 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        float a10 = a(iArr, i11);
        float b4 = b(i10, (int) a10, iArr[2], i12, false);
        if (Float.isNaN(b4)) {
            b4 = a(i10, (int) ((a10 - (iArr[2] / 2)) - (iArr[1] / 2)), (int) ((iArr[2] / 2) + a10 + (iArr[3] / 2)), iArr[1] + iArr[2] + iArr[3], i12);
        }
        if (Float.isNaN(b4)) {
            return false;
        }
        return a(false, b4, a10, i12 / 7.0f);
    }

    private boolean a(boolean z10, float f10, float f11, float f12) {
        int i10 = 0;
        while (true) {
            if (i10 >= this.f31119c.size()) {
                break;
            }
            e3 e3Var = this.f31119c.get(i10);
            if (e3Var.b(f12, f10, f11)) {
                this.f31119c.set(i10, e3Var.a(f10, f11, f12, false));
                z10 = true;
                break;
            }
            i10++;
        }
        if (!z10) {
            e3 e3Var2 = new e3(f11, f10, f12, false);
            this.f31119c.add(e3Var2);
            v6 v6Var = this.f31121e;
            if (v6Var != null) {
                v6Var.a(e3Var2);
            }
        }
        return true;
    }

    private e3[] a() throws com.huawei.hms.scankit.p.a {
        e3 e3Var = this.f31118b.get(0);
        e3 e3Var2 = this.f31118b.get(1);
        float[] fArr = e3Var.b() < e3Var2.b() ? new float[]{e3Var.b(), e3Var2.b()} : new float[]{e3Var2.b(), e3Var.b()};
        float[] fArr2 = e3Var.b() < e3Var2.b() ? new float[]{e3Var.c(), e3Var2.c()} : new float[]{e3Var2.c(), e3Var.c()};
        float e2 = (e3Var.e() + e3Var2.e()) / 2.0f;
        float e10 = ((e3Var.e() + e3Var2.e()) * 7.0f) / 1.5f;
        if (Math.abs(fArr[0] - fArr[1]) > e10 && Math.abs(fArr2[0] - fArr2[1]) <= e10) {
            this.f31118b.add(new e3((fArr[0] + fArr2[0]) - fArr2[1], (fArr2[0] + fArr[1]) - fArr[0], e2, false, 0));
        } else if (Math.abs(fArr[0] - fArr[1]) > e10 || Math.abs(fArr2[0] - fArr2[1]) <= e10) {
            if (Math.abs(fArr[0] - fArr[1]) > e10 && Math.abs(fArr2[0] - fArr2[1]) > e10) {
                this.f31118b.add(new e3((((fArr[0] + fArr[1]) + fArr2[1]) - fArr2[0]) / 2.0f, (((fArr2[0] + fArr2[1]) + fArr[0]) - fArr[1]) / 2.0f, e2, false, 0));
            }
        } else if (fArr[0] < fArr[1]) {
            this.f31118b.add(new e3((fArr[1] + fArr2[0]) - fArr2[1], (fArr2[1] + fArr[1]) - fArr[0], e2, false, 0));
        } else {
            this.f31118b.add(new e3((fArr[0] + fArr2[1]) - fArr2[0], (fArr2[0] + fArr[0]) - fArr[1], e2, false, 0));
        }
        if (this.f31118b.size() == 3) {
            return new e3[]{this.f31118b.get(0), this.f31118b.get(1), this.f31118b.get(2)};
        }
        throw com.huawei.hms.scankit.p.a.a();
    }
}
