package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.s4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class r4<T extends s4<T>> {

    /* renamed from: d, reason: collision with root package name */
    public static final r4 f25619d = new r4(true);

    /* renamed from: a, reason: collision with root package name */
    public final x6<T, Object> f25620a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f25621b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f25622c;

    public r4() {
        this.f25620a = x6.b(16);
    }

    public static int a(zzml zzmlVar, int i10, Object obj) {
        int g02 = zzii.g0(i10);
        if (zzmlVar == zzml.zzj) {
            b5.g((c6) obj);
            g02 <<= 1;
        }
        return g02 + b(zzmlVar, obj);
    }

    public static int b(zzml zzmlVar, Object obj) {
        switch (q4.f25612b[zzmlVar.ordinal()]) {
            case 1:
                return zzii.z(((Double) obj).doubleValue());
            case 2:
                return zzii.A(((Float) obj).floatValue());
            case 3:
                return zzii.d0(((Long) obj).longValue());
            case 4:
                return zzii.i0(((Long) obj).longValue());
            case 5:
                return zzii.k0(((Integer) obj).intValue());
            case 6:
                return zzii.r0(((Long) obj).longValue());
            case 7:
                return zzii.w0(((Integer) obj).intValue());
            case 8:
                return zzii.L(((Boolean) obj).booleanValue());
            case 9:
                return zzii.V((c6) obj);
            case 10:
                if (obj instanceof i5) {
                    return zzii.d((i5) obj);
                }
                return zzii.J((c6) obj);
            case 11:
                if (obj instanceof zzht) {
                    return zzii.I((zzht) obj);
                }
                return zzii.K((String) obj);
            case 12:
                if (obj instanceof zzht) {
                    return zzii.I((zzht) obj);
                }
                return zzii.M((byte[]) obj);
            case 13:
                return zzii.o0(((Integer) obj).intValue());
            case 14:
                return zzii.z0(((Integer) obj).intValue());
            case 15:
                return zzii.v0(((Long) obj).longValue());
            case 16:
                return zzii.s0(((Integer) obj).intValue());
            case 17:
                return zzii.n0(((Long) obj).longValue());
            case 18:
                if (obj instanceof a5) {
                    return zzii.B0(((a5) obj).zza());
                }
                return zzii.B0(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static <T extends s4<T>> r4<T> c() {
        return f25619d;
    }

    public static Object e(Object obj) {
        if (obj instanceof k6) {
            return ((k6) obj).clone();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy((Object) bArr, 0, (Object) bArr2, 0, bArr.length);
        return bArr2;
    }

    public static <T extends s4<T>> boolean h(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.zzc() == zzmo.MESSAGE) {
            if (key.zzd()) {
                Iterator iterator2 = ((List) entry.getValue()).iterator2();
                while (iterator2.hasNext()) {
                    if (!((c6) iterator2.next()).zzk()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof c6) {
                    if (!((c6) value).zzk()) {
                        return false;
                    }
                } else {
                    if (value instanceof i5) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public static int l(s4<?> s4Var, Object obj) {
        zzml zzb = s4Var.zzb();
        int zza = s4Var.zza();
        if (s4Var.zzd()) {
            int i10 = 0;
            if (s4Var.zze()) {
                Iterator iterator2 = ((List) obj).iterator2();
                while (iterator2.hasNext()) {
                    i10 += b(zzb, iterator2.next());
                }
                return zzii.g0(zza) + i10 + zzii.D0(i10);
            }
            Iterator iterator22 = ((List) obj).iterator2();
            while (iterator22.hasNext()) {
                i10 += a(zzb, zza, iterator22.next());
            }
            return i10;
        }
        return a(zzb, zza, obj);
    }

    public static int m(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzc() == zzmo.MESSAGE && !key.zzd() && !key.zze()) {
            if (value instanceof i5) {
                return zzii.D(entry.getKey().zza(), (i5) value);
            }
            return zzii.E(entry.getKey().zza(), (c6) value);
        }
        return l(key, value);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
    
        if ((r6 instanceof com.google.android.gms.internal.vision.i5) == false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0029, code lost:
    
        if ((r6 instanceof com.google.android.gms.internal.vision.a5) == false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0032, code lost:
    
        if ((r6 instanceof byte[]) == false) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void p(T r5, java.lang.Object r6) {
        /*
            com.google.android.gms.internal.vision.zzml r0 = r5.zzb()
            com.google.android.gms.internal.vision.b5.d(r6)
            int[] r1 = com.google.android.gms.internal.vision.q4.f25611a
            com.google.android.gms.internal.vision.zzmo r0 = r0.zza()
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            r2 = 0
            switch(r0) {
                case 1: goto L45;
                case 2: goto L42;
                case 3: goto L3f;
                case 4: goto L3c;
                case 5: goto L39;
                case 6: goto L36;
                case 7: goto L2c;
                case 8: goto L23;
                case 9: goto L1a;
                default: goto L18;
            }
        L18:
            r0 = 0
            goto L47
        L1a:
            boolean r0 = r6 instanceof com.google.android.gms.internal.vision.c6
            if (r0 != 0) goto L34
            boolean r0 = r6 instanceof com.google.android.gms.internal.vision.i5
            if (r0 == 0) goto L18
            goto L34
        L23:
            boolean r0 = r6 instanceof java.lang.Integer
            if (r0 != 0) goto L34
            boolean r0 = r6 instanceof com.google.android.gms.internal.vision.a5
            if (r0 == 0) goto L18
            goto L34
        L2c:
            boolean r0 = r6 instanceof com.google.android.gms.internal.vision.zzht
            if (r0 != 0) goto L34
            boolean r0 = r6 instanceof byte[]
            if (r0 == 0) goto L18
        L34:
            r0 = 1
            goto L47
        L36:
            boolean r0 = r6 instanceof java.lang.String
            goto L47
        L39:
            boolean r0 = r6 instanceof java.lang.Boolean
            goto L47
        L3c:
            boolean r0 = r6 instanceof java.lang.Double
            goto L47
        L3f:
            boolean r0 = r6 instanceof java.lang.Float
            goto L47
        L42:
            boolean r0 = r6 instanceof java.lang.Long
            goto L47
        L45:
            boolean r0 = r6 instanceof java.lang.Integer
        L47:
            if (r0 == 0) goto L4a
            return
        L4a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            int r4 = r5.zza()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3[r2] = r4
            com.google.android.gms.internal.vision.zzml r5 = r5.zzb()
            com.google.android.gms.internal.vision.zzmo r5 = r5.zza()
            r3[r1] = r5
            r5 = 2
            java.lang.Class r6 = r6.getClass()
            java.lang.String r6 = r6.getName()
            r3[r5] = r6
            java.lang.String r5 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r5 = java.lang.String.format(r5, r3)
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.r4.p(com.google.android.gms.internal.vision.s4, java.lang.Object):void");
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        r4 r4Var = new r4();
        for (int i10 = 0; i10 < this.f25620a.j(); i10++) {
            Map.Entry<T, Object> h10 = this.f25620a.h(i10);
            r4Var.g(h10.getKey(), h10.getValue());
        }
        for (Map.Entry<T, Object> entry : this.f25620a.m()) {
            r4Var.g(entry.getKey(), entry.getValue());
        }
        r4Var.f25622c = this.f25622c;
        return r4Var;
    }

    public final Object d(T t2) {
        Object obj = this.f25620a.get(t2);
        if (!(obj instanceof i5)) {
            return obj;
        }
        return i5.e();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r4) {
            return this.f25620a.equals(((r4) obj).f25620a);
        }
        return false;
    }

    public final void f(r4<T> r4Var) {
        for (int i10 = 0; i10 < r4Var.f25620a.j(); i10++) {
            k(r4Var.f25620a.h(i10));
        }
        Iterator<Map.Entry<T, Object>> iterator2 = r4Var.f25620a.m().iterator2();
        while (iterator2.hasNext()) {
            k(iterator2.next());
        }
    }

    public final void g(T t2, Object obj) {
        if (t2.zzd()) {
            if (obj instanceof List) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj2 = arrayList.get(i10);
                    i10++;
                    p(t2, obj2);
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            p(t2, obj);
        }
        if (obj instanceof i5) {
            this.f25622c = true;
        }
        this.f25620a.put(t2, obj);
    }

    public final int hashCode() {
        return this.f25620a.hashCode();
    }

    public final void i() {
        if (this.f25621b) {
            return;
        }
        this.f25620a.e();
        this.f25621b = true;
    }

    public final void j(T t2, Object obj) {
        List list;
        if (t2.zzd()) {
            p(t2, obj);
            Object d10 = d(t2);
            if (d10 == null) {
                list = new ArrayList();
                this.f25620a.put(t2, list);
            } else {
                list = (List) d10;
            }
            list.add(obj);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    public final void k(Map.Entry<T, Object> entry) {
        c6 zzf;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof i5) {
            value = i5.e();
        }
        if (key.zzd()) {
            Object d10 = d(key);
            if (d10 == null) {
                d10 = new ArrayList();
            }
            Iterator iterator2 = ((List) value).iterator2();
            while (iterator2.hasNext()) {
                ((List) d10).add(e(iterator2.next()));
            }
            this.f25620a.put(key, d10);
            return;
        }
        if (key.zzc() == zzmo.MESSAGE) {
            Object d11 = d(key);
            if (d11 == null) {
                this.f25620a.put(key, e(value));
                return;
            }
            if (d11 instanceof k6) {
                zzf = key.d((k6) d11, (k6) value);
            } else {
                zzf = key.e(((c6) d11).zzp(), (c6) value).zzf();
            }
            this.f25620a.put(key, zzf);
            return;
        }
        this.f25620a.put(key, e(value));
    }

    public final boolean n() {
        return this.f25621b;
    }

    public final Iterator<Map.Entry<T, Object>> o() {
        if (this.f25622c) {
            return new j5(this.f25620a.entrySet().iterator2());
        }
        return this.f25620a.entrySet().iterator2();
    }

    public final Iterator<Map.Entry<T, Object>> q() {
        if (this.f25622c) {
            return new j5(this.f25620a.o().iterator2());
        }
        return this.f25620a.o().iterator2();
    }

    public final boolean r() {
        for (int i10 = 0; i10 < this.f25620a.j(); i10++) {
            if (!h(this.f25620a.h(i10))) {
                return false;
            }
        }
        Iterator<Map.Entry<T, Object>> iterator2 = this.f25620a.m().iterator2();
        while (iterator2.hasNext()) {
            if (!h(iterator2.next())) {
                return false;
            }
        }
        return true;
    }

    public final int s() {
        int i10 = 0;
        for (int i11 = 0; i11 < this.f25620a.j(); i11++) {
            i10 += m(this.f25620a.h(i11));
        }
        Iterator<Map.Entry<T, Object>> iterator2 = this.f25620a.m().iterator2();
        while (iterator2.hasNext()) {
            i10 += m(iterator2.next());
        }
        return i10;
    }

    public r4(boolean z10) {
        this(x6.b(0));
        i();
    }

    public r4(x6<T, Object> x6Var) {
        this.f25620a = x6Var;
        i();
    }
}
