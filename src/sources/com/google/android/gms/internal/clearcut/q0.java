package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.t0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class q0<FieldDescriptorType extends t0<FieldDescriptorType>> {

    /* renamed from: d, reason: collision with root package name */
    public static final q0 f24031d = new q0(true);

    /* renamed from: b, reason: collision with root package name */
    public boolean f24033b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f24034c = false;

    /* renamed from: a, reason: collision with root package name */
    public final u2<FieldDescriptorType, Object> f24032a = u2.f(16);

    public q0() {
    }

    public q0(boolean z10) {
        t();
    }

    public static int f(zzfl zzflVar, int i10, Object obj) {
        int B0 = zzbn.B0(i10);
        if (zzflVar == zzfl.zzql) {
            z0.i((a2) obj);
            B0 <<= 1;
        }
        return B0 + o(zzflVar, obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
    
        if ((r3 instanceof com.google.android.gms.internal.clearcut.a1) == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
    
        if ((r3 instanceof byte[]) == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:
    
        if ((r3 instanceof com.google.android.gms.internal.clearcut.d1) == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001e, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0011. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void j(com.google.android.gms.internal.clearcut.zzfl r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.clearcut.z0.a(r3)
            int[] r0 = com.google.android.gms.internal.clearcut.r0.f24039a
            com.google.android.gms.internal.clearcut.zzfq r2 = r2.zzek()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L41;
                case 2: goto L3e;
                case 3: goto L3b;
                case 4: goto L38;
                case 5: goto L35;
                case 6: goto L32;
                case 7: goto L29;
                case 8: goto L20;
                case 9: goto L15;
                default: goto L14;
            }
        L14:
            goto L44
        L15:
            boolean r2 = r3 instanceof com.google.android.gms.internal.clearcut.a2
            if (r2 != 0) goto L43
            boolean r2 = r3 instanceof com.google.android.gms.internal.clearcut.d1
            if (r2 == 0) goto L1e
            goto L43
        L1e:
            r0 = 0
            goto L43
        L20:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L43
            boolean r2 = r3 instanceof com.google.android.gms.internal.clearcut.a1
            if (r2 == 0) goto L1e
            goto L43
        L29:
            boolean r2 = r3 instanceof com.google.android.gms.internal.clearcut.zzbb
            if (r2 != 0) goto L43
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L1e
            goto L43
        L32:
            boolean r0 = r3 instanceof java.lang.String
            goto L43
        L35:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L43
        L38:
            boolean r0 = r3 instanceof java.lang.Double
            goto L43
        L3b:
            boolean r0 = r3 instanceof java.lang.Float
            goto L43
        L3e:
            boolean r0 = r3 instanceof java.lang.Long
            goto L43
        L41:
            boolean r0 = r3 instanceof java.lang.Integer
        L43:
            r1 = r0
        L44:
            if (r1 == 0) goto L47
            return
        L47:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.q0.j(com.google.android.gms.internal.clearcut.zzfl, java.lang.Object):void");
    }

    public static <T extends t0<T>> q0<T> k() {
        return f24031d;
    }

    public static int n(t0<?> t0Var, Object obj) {
        zzfl f02 = t0Var.f0();
        int zzc = t0Var.zzc();
        if (!t0Var.c0()) {
            return f(f02, zzc, obj);
        }
        int i10 = 0;
        List list = (List) obj;
        if (t0Var.a0()) {
            Iterator iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                i10 += o(f02, iterator2.next());
            }
            return zzbn.B0(zzc) + i10 + zzbn.J0(i10);
        }
        Iterator iterator22 = list.iterator2();
        while (iterator22.hasNext()) {
            i10 += f(f02, zzc, iterator22.next());
        }
        return i10;
    }

    public static int o(zzfl zzflVar, Object obj) {
        switch (r0.f24040b[zzflVar.ordinal()]) {
            case 1:
                return zzbn.w(((Double) obj).doubleValue());
            case 2:
                return zzbn.x(((Float) obj).floatValue());
            case 3:
                return zzbn.e0(((Long) obj).longValue());
            case 4:
                return zzbn.h0(((Long) obj).longValue());
            case 5:
                return zzbn.C0(((Integer) obj).intValue());
            case 6:
                return zzbn.p0(((Long) obj).longValue());
            case 7:
                return zzbn.F0(((Integer) obj).intValue());
            case 8:
                return zzbn.F(((Boolean) obj).booleanValue());
            case 9:
                return zzbn.Z((a2) obj);
            case 10:
                return obj instanceof d1 ? zzbn.e((d1) obj) : zzbn.R((a2) obj);
            case 11:
                return obj instanceof zzbb ? zzbn.D((zzbb) obj) : zzbn.q0((String) obj);
            case 12:
                return obj instanceof zzbb ? zzbn.D((zzbb) obj) : zzbn.a0((byte[]) obj);
            case 13:
                return zzbn.D0(((Integer) obj).intValue());
            case 14:
                return zzbn.G0(((Integer) obj).intValue());
            case 15:
                return zzbn.s0(((Long) obj).longValue());
            case 16:
                return zzbn.E0(((Integer) obj).intValue());
            case 17:
                return zzbn.l0(((Long) obj).longValue());
            case 18:
                return obj instanceof a1 ? zzbn.H0(((a1) obj).zzc()) : zzbn.H0(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static boolean p(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.b0() == zzfq.MESSAGE) {
            boolean c02 = key.c0();
            Object value = entry.getValue();
            if (c02) {
                Iterator iterator2 = ((List) value).iterator2();
                while (iterator2.hasNext()) {
                    if (!((a2) iterator2.next()).isInitialized()) {
                        return false;
                    }
                }
            } else {
                if (!(value instanceof a2)) {
                    if (value instanceof d1) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
                if (!((a2) value).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int r(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (key.b0() != zzfq.MESSAGE || key.c0() || key.a0()) {
            return n(key, value);
        }
        boolean z10 = value instanceof d1;
        int zzc = entry.getKey().zzc();
        return z10 ? zzbn.A(zzc, (d1) value) : zzbn.Y(zzc, (a2) value);
    }

    public static Object s(Object obj) {
        if (obj instanceof g2) {
            return ((g2) obj).C();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy((Object) bArr, 0, (Object) bArr2, 0, bArr.length);
        return bArr2;
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> a() {
        return this.f24034c ? new g1(this.f24032a.n().iterator2()) : this.f24032a.n().iterator2();
    }

    public final boolean b() {
        return this.f24032a.isEmpty();
    }

    public final boolean c() {
        return this.f24033b;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        q0 q0Var = new q0();
        for (int i10 = 0; i10 < this.f24032a.l(); i10++) {
            Map.Entry<FieldDescriptorType, Object> g3 = this.f24032a.g(i10);
            q0Var.i(g3.getKey(), g3.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f24032a.m()) {
            q0Var.i(entry.getKey(), entry.getValue());
        }
        q0Var.f24034c = this.f24034c;
        return q0Var;
    }

    public final boolean d() {
        for (int i10 = 0; i10 < this.f24032a.l(); i10++) {
            if (!p(this.f24032a.g(i10))) {
                return false;
            }
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> iterator2 = this.f24032a.m().iterator2();
        while (iterator2.hasNext()) {
            if (!p(iterator2.next())) {
                return false;
            }
        }
        return true;
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> e() {
        return this.f24034c ? new g1(this.f24032a.entrySet().iterator2()) : this.f24032a.entrySet().iterator2();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q0) {
            return this.f24032a.equals(((q0) obj).f24032a);
        }
        return false;
    }

    public final Object g(FieldDescriptorType fielddescriptortype) {
        Object obj = this.f24032a.get(fielddescriptortype);
        return obj instanceof d1 ? d1.e() : obj;
    }

    public final void h(q0<FieldDescriptorType> q0Var) {
        for (int i10 = 0; i10 < q0Var.f24032a.l(); i10++) {
            q(q0Var.f24032a.g(i10));
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> iterator2 = q0Var.f24032a.m().iterator2();
        while (iterator2.hasNext()) {
            q(iterator2.next());
        }
    }

    public final int hashCode() {
        return this.f24032a.hashCode();
    }

    public final void i(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.c0()) {
            j(fielddescriptortype.f0(), obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj2 = arrayList.get(i10);
                i10++;
                j(fielddescriptortype.f0(), obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof d1) {
            this.f24034c = true;
        }
        this.f24032a.put(fielddescriptortype, obj);
    }

    public final int l() {
        int i10 = 0;
        for (int i11 = 0; i11 < this.f24032a.l(); i11++) {
            Map.Entry<FieldDescriptorType, Object> g3 = this.f24032a.g(i11);
            i10 += n(g3.getKey(), g3.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f24032a.m()) {
            i10 += n(entry.getKey(), entry.getValue());
        }
        return i10;
    }

    public final int m() {
        int i10 = 0;
        for (int i11 = 0; i11 < this.f24032a.l(); i11++) {
            i10 += r(this.f24032a.g(i11));
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> iterator2 = this.f24032a.m().iterator2();
        while (iterator2.hasNext()) {
            i10 += r(iterator2.next());
        }
        return i10;
    }

    public final void q(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof d1) {
            value = d1.e();
        }
        if (key.c0()) {
            Object g3 = g(key);
            if (g3 == null) {
                g3 = new ArrayList();
            }
            Iterator iterator2 = ((List) value).iterator2();
            while (iterator2.hasNext()) {
                ((List) g3).add(s(iterator2.next()));
            }
            this.f24032a.put(key, g3);
            return;
        }
        if (key.b0() != zzfq.MESSAGE) {
            this.f24032a.put(key, s(value));
            return;
        }
        Object g10 = g(key);
        if (g10 == null) {
            this.f24032a.put(key, s(value));
        } else {
            this.f24032a.put(key, g10 instanceof g2 ? key.d0((g2) g10, (g2) value) : key.e0(((a2) g10).a(), (a2) value).E());
        }
    }

    public final void t() {
        if (this.f24033b) {
            return;
        }
        this.f24032a.q();
        this.f24033b = true;
    }
}
