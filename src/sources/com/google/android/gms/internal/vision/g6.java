package com.google.android.gms.internal.vision;

import com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class g6<T> implements t6<T> {

    /* renamed from: r, reason: collision with root package name */
    public static final int[] f25482r = new int[0];

    /* renamed from: s, reason: collision with root package name */
    public static final Unsafe f25483s = p7.t();

    /* renamed from: a, reason: collision with root package name */
    public final int[] f25484a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f25485b;

    /* renamed from: c, reason: collision with root package name */
    public final int f25486c;

    /* renamed from: d, reason: collision with root package name */
    public final int f25487d;

    /* renamed from: e, reason: collision with root package name */
    public final c6 f25488e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f25489f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f25490g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f25491h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f25492i;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f25493j;

    /* renamed from: k, reason: collision with root package name */
    public final int f25494k;

    /* renamed from: l, reason: collision with root package name */
    public final int f25495l;

    /* renamed from: m, reason: collision with root package name */
    public final j6 f25496m;

    /* renamed from: n, reason: collision with root package name */
    public final n5 f25497n;

    /* renamed from: o, reason: collision with root package name */
    public final k7<?, ?> f25498o;

    /* renamed from: p, reason: collision with root package name */
    public final n4<?> f25499p;

    /* renamed from: q, reason: collision with root package name */
    public final z5 f25500q;

    public g6(int[] iArr, Object[] objArr, int i10, int i11, c6 c6Var, boolean z10, boolean z11, int[] iArr2, int i12, int i13, j6 j6Var, n5 n5Var, k7<?, ?> k7Var, n4<?> n4Var, z5 z5Var) {
        this.f25484a = iArr;
        this.f25485b = objArr;
        this.f25486c = i10;
        this.f25487d = i11;
        this.f25490g = c6Var instanceof x4;
        this.f25491h = z10;
        this.f25489f = n4Var != null && n4Var.e(c6Var);
        this.f25492i = false;
        this.f25493j = iArr2;
        this.f25494k = i12;
        this.f25495l = i13;
        this.f25496m = j6Var;
        this.f25497n = n5Var;
        this.f25498o = k7Var;
        this.f25499p = n4Var;
        this.f25488e = c6Var;
        this.f25500q = z5Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean A(Object obj, int i10, t6 t6Var) {
        return t6Var.c(p7.F(obj, i10 & 1048575));
    }

    public static <T> double B(T t2, long j10) {
        return ((Double) p7.F(t2, j10)).doubleValue();
    }

    public static <T> float I(T t2, long j10) {
        return ((Float) p7.F(t2, j10)).floatValue();
    }

    public static <T> int M(T t2, long j10) {
        return ((Integer) p7.F(t2, j10)).intValue();
    }

    public static <T> long O(T t2, long j10) {
        return ((Long) p7.F(t2, j10)).longValue();
    }

    public static m7 P(Object obj) {
        x4 x4Var = (x4) obj;
        m7 m7Var = x4Var.zzb;
        if (m7Var != m7.a()) {
            return m7Var;
        }
        m7 g3 = m7.g();
        x4Var.zzb = g3;
        return g3;
    }

    public static <T> boolean Q(T t2, long j10) {
        return ((Boolean) p7.F(t2, j10)).booleanValue();
    }

    public static <UT, UB> int i(k7<UT, UB> k7Var, T t2) {
        return k7Var.l(k7Var.f(t2));
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x039c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> com.google.android.gms.internal.vision.g6<T> n(java.lang.Class<T> r33, com.google.android.gms.internal.vision.a6 r34, com.google.android.gms.internal.vision.j6 r35, com.google.android.gms.internal.vision.n5 r36, com.google.android.gms.internal.vision.k7<?, ?> r37, com.google.android.gms.internal.vision.n4<?> r38, com.google.android.gms.internal.vision.z5 r39) {
        /*
            Method dump skipped, instructions count: 1052
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.g6.n(java.lang.Class, com.google.android.gms.internal.vision.a6, com.google.android.gms.internal.vision.j6, com.google.android.gms.internal.vision.n5, com.google.android.gms.internal.vision.k7, com.google.android.gms.internal.vision.n4, com.google.android.gms.internal.vision.z5):com.google.android.gms.internal.vision.g6");
    }

    public static Field r(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 40 + name.length() + String.valueOf(arrays).length());
            sb2.append("Field ");
            sb2.append(str);
            sb2.append(" for ");
            sb2.append(name);
            sb2.append(" not found. Known fields are ");
            sb2.append(arrays);
            throw new RuntimeException(sb2.toString());
        }
    }

    public static List<?> s(Object obj, long j10) {
        return (List) p7.F(obj, j10);
    }

    public static void t(int i10, Object obj, z7 z7Var) throws IOException {
        if (obj instanceof String) {
            z7Var.s(i10, (String) obj);
        } else {
            z7Var.H(i10, (zzht) obj);
        }
    }

    public static <UT, UB> void u(k7<UT, UB> k7Var, T t2, z7 z7Var) throws IOException {
        k7Var.d(k7Var.f(t2), z7Var);
    }

    public final int C(int i10, int i11) {
        int length = (this.f25484a.length / 3) - 1;
        while (i11 <= length) {
            int i12 = (length + i11) >>> 1;
            int i13 = i12 * 3;
            int i14 = this.f25484a[i13];
            if (i10 == i14) {
                return i13;
            }
            if (i10 < i14) {
                length = i12 - 1;
            } else {
                i11 = i12 + 1;
            }
        }
        return -1;
    }

    public final Object D(int i10) {
        return this.f25485b[(i10 / 3) << 1];
    }

    public final void E(T t2, int i10) {
        int N = N(i10);
        long j10 = 1048575 & N;
        if (j10 == 1048575) {
            return;
        }
        p7.h(t2, j10, (1 << (N >>> 20)) | p7.b(t2, j10));
    }

    public final void F(T t2, int i10, int i11) {
        p7.h(t2, N(i11) & 1048575, i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:214:0x0491  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void G(T r18, com.google.android.gms.internal.vision.z7 r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1338
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.g6.G(java.lang.Object, com.google.android.gms.internal.vision.z7):void");
    }

    public final void H(T t2, T t10, int i10) {
        int L = L(i10);
        int i11 = this.f25484a[i10];
        long j10 = L & 1048575;
        if (y(t10, i11, i10)) {
            Object F = y(t2, i11, i10) ? p7.F(t2, j10) : null;
            Object F2 = p7.F(t10, j10);
            if (F != null && F2 != null) {
                p7.j(t2, j10, b5.e(F, F2));
                F(t2, i11, i10);
            } else if (F2 != null) {
                p7.j(t2, j10, F2);
                F(t2, i11, i10);
            }
        }
    }

    public final c5 J(int i10) {
        return (c5) this.f25485b[((i10 / 3) << 1) + 1];
    }

    public final boolean K(T t2, T t10, int i10) {
        return x(t2, i10) == x(t10, i10);
    }

    public final int L(int i10) {
        return this.f25484a[i10 + 1];
    }

    public final int N(int i10) {
        return this.f25484a[i10 + 2];
    }

    public final int R(int i10) {
        if (i10 < this.f25486c || i10 > this.f25487d) {
            return -1;
        }
        return C(i10, 0);
    }

    @Override // com.google.android.gms.internal.vision.t6
    public final void a(T t2) {
        int i10;
        int i11 = this.f25494k;
        while (true) {
            i10 = this.f25495l;
            if (i11 >= i10) {
                break;
            }
            long L = L(this.f25493j[i11]) & 1048575;
            Object F = p7.F(t2, L);
            if (F != null) {
                p7.j(t2, L, this.f25500q.f(F));
            }
            i11++;
        }
        int length = this.f25493j.length;
        while (i10 < length) {
            this.f25497n.d(t2, this.f25493j[i10]);
            i10++;
        }
        this.f25498o.j(t2);
        if (this.f25489f) {
            this.f25499p.g(t2);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x001b. Please report as an issue. */
    @Override // com.google.android.gms.internal.vision.t6
    public final int b(T t2) {
        int i10;
        int b4;
        int length = this.f25484a.length;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12 += 3) {
            int L = L(i12);
            int i13 = this.f25484a[i12];
            long j10 = 1048575 & L;
            int i14 = 37;
            switch ((L & 267386880) >>> 20) {
                case 0:
                    i10 = i11 * 53;
                    b4 = b5.b(Double.doubleToLongBits(p7.C(t2, j10)));
                    i11 = i10 + b4;
                    break;
                case 1:
                    i10 = i11 * 53;
                    b4 = Float.floatToIntBits(p7.x(t2, j10));
                    i11 = i10 + b4;
                    break;
                case 2:
                    i10 = i11 * 53;
                    b4 = b5.b(p7.o(t2, j10));
                    i11 = i10 + b4;
                    break;
                case 3:
                    i10 = i11 * 53;
                    b4 = b5.b(p7.o(t2, j10));
                    i11 = i10 + b4;
                    break;
                case 4:
                    i10 = i11 * 53;
                    b4 = p7.b(t2, j10);
                    i11 = i10 + b4;
                    break;
                case 5:
                    i10 = i11 * 53;
                    b4 = b5.b(p7.o(t2, j10));
                    i11 = i10 + b4;
                    break;
                case 6:
                    i10 = i11 * 53;
                    b4 = p7.b(t2, j10);
                    i11 = i10 + b4;
                    break;
                case 7:
                    i10 = i11 * 53;
                    b4 = b5.c(p7.w(t2, j10));
                    i11 = i10 + b4;
                    break;
                case 8:
                    i10 = i11 * 53;
                    b4 = ((String) p7.F(t2, j10)).hashCode();
                    i11 = i10 + b4;
                    break;
                case 9:
                    Object F = p7.F(t2, j10);
                    if (F != null) {
                        i14 = F.hashCode();
                    }
                    i11 = (i11 * 53) + i14;
                    break;
                case 10:
                    i10 = i11 * 53;
                    b4 = p7.F(t2, j10).hashCode();
                    i11 = i10 + b4;
                    break;
                case 11:
                    i10 = i11 * 53;
                    b4 = p7.b(t2, j10);
                    i11 = i10 + b4;
                    break;
                case 12:
                    i10 = i11 * 53;
                    b4 = p7.b(t2, j10);
                    i11 = i10 + b4;
                    break;
                case 13:
                    i10 = i11 * 53;
                    b4 = p7.b(t2, j10);
                    i11 = i10 + b4;
                    break;
                case 14:
                    i10 = i11 * 53;
                    b4 = b5.b(p7.o(t2, j10));
                    i11 = i10 + b4;
                    break;
                case 15:
                    i10 = i11 * 53;
                    b4 = p7.b(t2, j10);
                    i11 = i10 + b4;
                    break;
                case 16:
                    i10 = i11 * 53;
                    b4 = b5.b(p7.o(t2, j10));
                    i11 = i10 + b4;
                    break;
                case 17:
                    Object F2 = p7.F(t2, j10);
                    if (F2 != null) {
                        i14 = F2.hashCode();
                    }
                    i11 = (i11 * 53) + i14;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i10 = i11 * 53;
                    b4 = p7.F(t2, j10).hashCode();
                    i11 = i10 + b4;
                    break;
                case 50:
                    i10 = i11 * 53;
                    b4 = p7.F(t2, j10).hashCode();
                    i11 = i10 + b4;
                    break;
                case 51:
                    if (y(t2, i13, i12)) {
                        i10 = i11 * 53;
                        b4 = b5.b(Double.doubleToLongBits(B(t2, j10)));
                        i11 = i10 + b4;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (y(t2, i13, i12)) {
                        i10 = i11 * 53;
                        b4 = Float.floatToIntBits(I(t2, j10));
                        i11 = i10 + b4;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (y(t2, i13, i12)) {
                        i10 = i11 * 53;
                        b4 = b5.b(O(t2, j10));
                        i11 = i10 + b4;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (y(t2, i13, i12)) {
                        i10 = i11 * 53;
                        b4 = b5.b(O(t2, j10));
                        i11 = i10 + b4;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (y(t2, i13, i12)) {
                        i10 = i11 * 53;
                        b4 = M(t2, j10);
                        i11 = i10 + b4;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (y(t2, i13, i12)) {
                        i10 = i11 * 53;
                        b4 = b5.b(O(t2, j10));
                        i11 = i10 + b4;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (y(t2, i13, i12)) {
                        i10 = i11 * 53;
                        b4 = M(t2, j10);
                        i11 = i10 + b4;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (y(t2, i13, i12)) {
                        i10 = i11 * 53;
                        b4 = b5.c(Q(t2, j10));
                        i11 = i10 + b4;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (y(t2, i13, i12)) {
                        i10 = i11 * 53;
                        b4 = ((String) p7.F(t2, j10)).hashCode();
                        i11 = i10 + b4;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (y(t2, i13, i12)) {
                        i10 = i11 * 53;
                        b4 = p7.F(t2, j10).hashCode();
                        i11 = i10 + b4;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (y(t2, i13, i12)) {
                        i10 = i11 * 53;
                        b4 = p7.F(t2, j10).hashCode();
                        i11 = i10 + b4;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (y(t2, i13, i12)) {
                        i10 = i11 * 53;
                        b4 = M(t2, j10);
                        i11 = i10 + b4;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (y(t2, i13, i12)) {
                        i10 = i11 * 53;
                        b4 = M(t2, j10);
                        i11 = i10 + b4;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (y(t2, i13, i12)) {
                        i10 = i11 * 53;
                        b4 = M(t2, j10);
                        i11 = i10 + b4;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (y(t2, i13, i12)) {
                        i10 = i11 * 53;
                        b4 = b5.b(O(t2, j10));
                        i11 = i10 + b4;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (y(t2, i13, i12)) {
                        i10 = i11 * 53;
                        b4 = M(t2, j10);
                        i11 = i10 + b4;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (y(t2, i13, i12)) {
                        i10 = i11 * 53;
                        b4 = b5.b(O(t2, j10));
                        i11 = i10 + b4;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (y(t2, i13, i12)) {
                        i10 = i11 * 53;
                        b4 = p7.F(t2, j10).hashCode();
                        i11 = i10 + b4;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i11 * 53) + this.f25498o.f(t2).hashCode();
        return this.f25489f ? (hashCode * 53) + this.f25499p.b(t2).hashCode() : hashCode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.vision.t6
    public final boolean c(T t2) {
        int i10;
        int i11;
        int i12 = 1048575;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            boolean z10 = true;
            if (i14 >= this.f25494k) {
                return !this.f25489f || this.f25499p.b(t2).r();
            }
            int i15 = this.f25493j[i14];
            int i16 = this.f25484a[i15];
            int L = L(i15);
            int i17 = this.f25484a[i15 + 2];
            int i18 = i17 & 1048575;
            int i19 = 1 << (i17 >>> 20);
            if (i18 != i12) {
                if (i18 != 1048575) {
                    i13 = f25483s.getInt(t2, i18);
                }
                i11 = i13;
                i10 = i18;
            } else {
                i10 = i12;
                i11 = i13;
            }
            if (((268435456 & L) != 0) && !z(t2, i15, i10, i11, i19)) {
                return false;
            }
            int i20 = (267386880 & L) >>> 20;
            if (i20 != 9 && i20 != 17) {
                if (i20 != 27) {
                    if (i20 == 60 || i20 == 68) {
                        if (y(t2, i16, i15) && !A(t2, L, o(i15))) {
                            return false;
                        }
                    } else if (i20 != 49) {
                        if (i20 == 50 && !this.f25500q.a(p7.F(t2, L & 1048575)).isEmpty()) {
                            this.f25500q.zzb(D(i15));
                            throw null;
                        }
                    }
                }
                List list = (List) p7.F(t2, L & 1048575);
                if (!list.isEmpty()) {
                    t6 o10 = o(i15);
                    int i21 = 0;
                    while (true) {
                        if (i21 >= list.size()) {
                            break;
                        }
                        if (!o10.c(list.get(i21))) {
                            z10 = false;
                            break;
                        }
                        i21++;
                    }
                }
                if (!z10) {
                    return false;
                }
            } else if (z(t2, i15, i10, i11, i19) && !A(t2, L, o(i15))) {
                return false;
            }
            i14++;
            i12 = i10;
            i13 = i11;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x006a, code lost:
    
        if (com.google.android.gms.internal.vision.u6.q(com.google.android.gms.internal.vision.p7.F(r10, r6), com.google.android.gms.internal.vision.p7.F(r11, r6)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007e, code lost:
    
        if (com.google.android.gms.internal.vision.p7.o(r10, r6) == com.google.android.gms.internal.vision.p7.o(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0090, code lost:
    
        if (com.google.android.gms.internal.vision.p7.b(r10, r6) == com.google.android.gms.internal.vision.p7.b(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a4, code lost:
    
        if (com.google.android.gms.internal.vision.p7.o(r10, r6) == com.google.android.gms.internal.vision.p7.o(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b6, code lost:
    
        if (com.google.android.gms.internal.vision.p7.b(r10, r6) == com.google.android.gms.internal.vision.p7.b(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c8, code lost:
    
        if (com.google.android.gms.internal.vision.p7.b(r10, r6) == com.google.android.gms.internal.vision.p7.b(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00da, code lost:
    
        if (com.google.android.gms.internal.vision.p7.b(r10, r6) == com.google.android.gms.internal.vision.p7.b(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00f0, code lost:
    
        if (com.google.android.gms.internal.vision.u6.q(com.google.android.gms.internal.vision.p7.F(r10, r6), com.google.android.gms.internal.vision.p7.F(r11, r6)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0106, code lost:
    
        if (com.google.android.gms.internal.vision.u6.q(com.google.android.gms.internal.vision.p7.F(r10, r6), com.google.android.gms.internal.vision.p7.F(r11, r6)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x011c, code lost:
    
        if (com.google.android.gms.internal.vision.u6.q(com.google.android.gms.internal.vision.p7.F(r10, r6), com.google.android.gms.internal.vision.p7.F(r11, r6)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x012e, code lost:
    
        if (com.google.android.gms.internal.vision.p7.w(r10, r6) == com.google.android.gms.internal.vision.p7.w(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0140, code lost:
    
        if (com.google.android.gms.internal.vision.p7.b(r10, r6) == com.google.android.gms.internal.vision.p7.b(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0154, code lost:
    
        if (com.google.android.gms.internal.vision.p7.o(r10, r6) == com.google.android.gms.internal.vision.p7.o(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0165, code lost:
    
        if (com.google.android.gms.internal.vision.p7.b(r10, r6) == com.google.android.gms.internal.vision.p7.b(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0178, code lost:
    
        if (com.google.android.gms.internal.vision.p7.o(r10, r6) == com.google.android.gms.internal.vision.p7.o(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x018b, code lost:
    
        if (com.google.android.gms.internal.vision.p7.o(r10, r6) == com.google.android.gms.internal.vision.p7.o(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01a4, code lost:
    
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.vision.p7.x(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.vision.p7.x(r11, r6))) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01bf, code lost:
    
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.vision.p7.C(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.vision.p7.C(r11, r6))) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0038, code lost:
    
        if (com.google.android.gms.internal.vision.u6.q(com.google.android.gms.internal.vision.p7.F(r10, r6), com.google.android.gms.internal.vision.p7.F(r11, r6)) != false) goto L105;
     */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01c5 A[LOOP:0: B:2:0x0005->B:86:0x01c5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01c4 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.vision.t6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean d(T r10, T r11) {
        /*
            Method dump skipped, instructions count: 640
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.g6.d(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.vision.t6
    public final void e(T t2, T t10) {
        Objects.requireNonNull(t10);
        for (int i10 = 0; i10 < this.f25484a.length; i10 += 3) {
            int L = L(i10);
            long j10 = 1048575 & L;
            int i11 = this.f25484a[i10];
            switch ((L & 267386880) >>> 20) {
                case 0:
                    if (x(t10, i10)) {
                        p7.f(t2, j10, p7.C(t10, j10));
                        E(t2, i10);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (x(t10, i10)) {
                        p7.g(t2, j10, p7.x(t10, j10));
                        E(t2, i10);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (x(t10, i10)) {
                        p7.i(t2, j10, p7.o(t10, j10));
                        E(t2, i10);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (x(t10, i10)) {
                        p7.i(t2, j10, p7.o(t10, j10));
                        E(t2, i10);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (x(t10, i10)) {
                        p7.h(t2, j10, p7.b(t10, j10));
                        E(t2, i10);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (x(t10, i10)) {
                        p7.i(t2, j10, p7.o(t10, j10));
                        E(t2, i10);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (x(t10, i10)) {
                        p7.h(t2, j10, p7.b(t10, j10));
                        E(t2, i10);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (x(t10, i10)) {
                        p7.k(t2, j10, p7.w(t10, j10));
                        E(t2, i10);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (x(t10, i10)) {
                        p7.j(t2, j10, p7.F(t10, j10));
                        E(t2, i10);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    w(t2, t10, i10);
                    break;
                case 10:
                    if (x(t10, i10)) {
                        p7.j(t2, j10, p7.F(t10, j10));
                        E(t2, i10);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (x(t10, i10)) {
                        p7.h(t2, j10, p7.b(t10, j10));
                        E(t2, i10);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (x(t10, i10)) {
                        p7.h(t2, j10, p7.b(t10, j10));
                        E(t2, i10);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (x(t10, i10)) {
                        p7.h(t2, j10, p7.b(t10, j10));
                        E(t2, i10);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (x(t10, i10)) {
                        p7.i(t2, j10, p7.o(t10, j10));
                        E(t2, i10);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (x(t10, i10)) {
                        p7.h(t2, j10, p7.b(t10, j10));
                        E(t2, i10);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (x(t10, i10)) {
                        p7.i(t2, j10, p7.o(t10, j10));
                        E(t2, i10);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    w(t2, t10, i10);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.f25497n.b(t2, t10, j10);
                    break;
                case 50:
                    u6.n(this.f25500q, t2, t10, j10);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (y(t10, i11, i10)) {
                        p7.j(t2, j10, p7.F(t10, j10));
                        F(t2, i11, i10);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    H(t2, t10, i10);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (y(t10, i11, i10)) {
                        p7.j(t2, j10, p7.F(t10, j10));
                        F(t2, i11, i10);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    H(t2, t10, i10);
                    break;
            }
        }
        u6.o(this.f25498o, t2, t10);
        if (this.f25489f) {
            u6.m(this.f25499p, t2, t10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0552  */
    /* JADX WARN: Removed duplicated region for block: B:566:0x0a2a  */
    @Override // com.google.android.gms.internal.vision.t6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void f(T r14, com.google.android.gms.internal.vision.z7 r15) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2916
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.g6.f(java.lang.Object, com.google.android.gms.internal.vision.z7):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x02dc, code lost:
    
        if (r0 == r5) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x02e0, code lost:
    
        r15 = r30;
        r14 = r31;
        r12 = r32;
        r13 = r34;
        r11 = r35;
        r2 = r18;
        r1 = r25;
        r6 = r27;
        r7 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0348, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0323, code lost:
    
        if (r0 == r15) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0346, code lost:
    
        if (r0 == r15) goto L116;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:29:0x0095. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11, types: [int] */
    @Override // com.google.android.gms.internal.vision.t6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void g(T r31, byte[] r32, int r33, int r34, com.google.android.gms.internal.vision.s3 r35) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 966
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.g6.g(java.lang.Object, byte[], int, int, com.google.android.gms.internal.vision.s3):void");
    }

    public final int h(int i10, int i11) {
        if (i10 < this.f25486c || i10 > this.f25487d) {
            return -1;
        }
        return C(i10, i11);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0023. Please report as an issue. */
    public final int j(T t2, byte[] bArr, int i10, int i11, int i12, int i13, int i14, int i15, int i16, long j10, int i17, s3 s3Var) throws IOException {
        int k10;
        Unsafe unsafe = f25483s;
        long j11 = this.f25484a[i17 + 2] & 1048575;
        switch (i16) {
            case 51:
                if (i14 == 1) {
                    unsafe.putObject(t2, j10, Double.valueOf(r3.m(bArr, i10)));
                    k10 = i10 + 8;
                    unsafe.putInt(t2, j11, i13);
                    return k10;
                }
                return i10;
            case 52:
                if (i14 == 5) {
                    unsafe.putObject(t2, j10, Float.valueOf(r3.o(bArr, i10)));
                    k10 = i10 + 4;
                    unsafe.putInt(t2, j11, i13);
                    return k10;
                }
                return i10;
            case 53:
            case 54:
                if (i14 == 0) {
                    k10 = r3.k(bArr, i10, s3Var);
                    unsafe.putObject(t2, j10, Long.valueOf(s3Var.f25632b));
                    unsafe.putInt(t2, j11, i13);
                    return k10;
                }
                return i10;
            case 55:
            case 62:
                if (i14 == 0) {
                    k10 = r3.i(bArr, i10, s3Var);
                    unsafe.putObject(t2, j10, Integer.valueOf(s3Var.f25631a));
                    unsafe.putInt(t2, j11, i13);
                    return k10;
                }
                return i10;
            case 56:
            case 65:
                if (i14 == 1) {
                    unsafe.putObject(t2, j10, Long.valueOf(r3.l(bArr, i10)));
                    k10 = i10 + 8;
                    unsafe.putInt(t2, j11, i13);
                    return k10;
                }
                return i10;
            case 57:
            case 64:
                if (i14 == 5) {
                    unsafe.putObject(t2, j10, Integer.valueOf(r3.h(bArr, i10)));
                    k10 = i10 + 4;
                    unsafe.putInt(t2, j11, i13);
                    return k10;
                }
                return i10;
            case 58:
                if (i14 == 0) {
                    k10 = r3.k(bArr, i10, s3Var);
                    unsafe.putObject(t2, j10, Boolean.valueOf(s3Var.f25632b != 0));
                    unsafe.putInt(t2, j11, i13);
                    return k10;
                }
                return i10;
            case 59:
                if (i14 == 2) {
                    int i18 = r3.i(bArr, i10, s3Var);
                    int i19 = s3Var.f25631a;
                    if (i19 == 0) {
                        unsafe.putObject(t2, j10, "");
                    } else {
                        if ((i15 & 536870912) != 0 && !s7.g(bArr, i18, i18 + i19)) {
                            throw zzjk.zzh();
                        }
                        unsafe.putObject(t2, j10, new String(bArr, i18, i19, b5.f25436a));
                        i18 += i19;
                    }
                    unsafe.putInt(t2, j11, i13);
                    return i18;
                }
                return i10;
            case 60:
                if (i14 == 2) {
                    int g3 = r3.g(o(i17), bArr, i10, i11, s3Var);
                    Object object = unsafe.getInt(t2, j11) == i13 ? unsafe.getObject(t2, j10) : null;
                    if (object == null) {
                        unsafe.putObject(t2, j10, s3Var.f25633c);
                    } else {
                        unsafe.putObject(t2, j10, b5.e(object, s3Var.f25633c));
                    }
                    unsafe.putInt(t2, j11, i13);
                    return g3;
                }
                return i10;
            case 61:
                if (i14 == 2) {
                    k10 = r3.q(bArr, i10, s3Var);
                    unsafe.putObject(t2, j10, s3Var.f25633c);
                    unsafe.putInt(t2, j11, i13);
                    return k10;
                }
                return i10;
            case 63:
                if (i14 == 0) {
                    int i20 = r3.i(bArr, i10, s3Var);
                    int i21 = s3Var.f25631a;
                    c5 J = J(i17);
                    if (J != null && !J.zza(i21)) {
                        P(t2).c(i12, Long.valueOf(i21));
                        return i20;
                    }
                    unsafe.putObject(t2, j10, Integer.valueOf(i21));
                    k10 = i20;
                    unsafe.putInt(t2, j11, i13);
                    return k10;
                }
                return i10;
            case 66:
                if (i14 == 0) {
                    k10 = r3.i(bArr, i10, s3Var);
                    unsafe.putObject(t2, j10, Integer.valueOf(f4.d(s3Var.f25631a)));
                    unsafe.putInt(t2, j11, i13);
                    return k10;
                }
                return i10;
            case 67:
                if (i14 == 0) {
                    k10 = r3.k(bArr, i10, s3Var);
                    unsafe.putObject(t2, j10, Long.valueOf(f4.a(s3Var.f25632b)));
                    unsafe.putInt(t2, j11, i13);
                    return k10;
                }
                return i10;
            case 68:
                if (i14 == 3) {
                    k10 = r3.f(o(i17), bArr, i10, i11, (i12 & (-8)) | 4, s3Var);
                    Object object2 = unsafe.getInt(t2, j11) == i13 ? unsafe.getObject(t2, j10) : null;
                    if (object2 == null) {
                        unsafe.putObject(t2, j10, s3Var.f25633c);
                    } else {
                        unsafe.putObject(t2, j10, b5.e(object2, s3Var.f25633c));
                    }
                    unsafe.putInt(t2, j11, i13);
                    return k10;
                }
                return i10;
            default:
                return i10;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0037. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    public final int k(T t2, byte[] bArr, int i10, int i11, int i12, int i13, int i14, int i15, long j10, int i16, long j11, s3 s3Var) throws IOException {
        int i17;
        int i18 = i10;
        Unsafe unsafe = f25483s;
        g5 g5Var = (g5) unsafe.getObject(t2, j11);
        if (!g5Var.zza()) {
            int size = g5Var.size();
            g5Var = g5Var.zza(size == 0 ? 10 : size << 1);
            unsafe.putObject(t2, j11, g5Var);
        }
        switch (i16) {
            case 18:
            case 35:
                if (i14 == 2) {
                    k4 k4Var = (k4) g5Var;
                    int i19 = r3.i(bArr, i18, s3Var);
                    int i20 = s3Var.f25631a + i19;
                    while (i19 < i20) {
                        k4Var.c(r3.m(bArr, i19));
                        i19 += 8;
                    }
                    if (i19 == i20) {
                        return i19;
                    }
                    throw zzjk.zza();
                }
                if (i14 == 1) {
                    k4 k4Var2 = (k4) g5Var;
                    k4Var2.c(r3.m(bArr, i10));
                    while (true) {
                        int i21 = i18 + 8;
                        if (i21 >= i11) {
                            return i21;
                        }
                        i18 = r3.i(bArr, i21, s3Var);
                        if (i12 != s3Var.f25631a) {
                            return i21;
                        }
                        k4Var2.c(r3.m(bArr, i18));
                    }
                }
                return i18;
            case 19:
            case 36:
                if (i14 == 2) {
                    w4 w4Var = (w4) g5Var;
                    int i22 = r3.i(bArr, i18, s3Var);
                    int i23 = s3Var.f25631a + i22;
                    while (i22 < i23) {
                        w4Var.c(r3.o(bArr, i22));
                        i22 += 4;
                    }
                    if (i22 == i23) {
                        return i22;
                    }
                    throw zzjk.zza();
                }
                if (i14 == 5) {
                    w4 w4Var2 = (w4) g5Var;
                    w4Var2.c(r3.o(bArr, i10));
                    while (true) {
                        int i24 = i18 + 4;
                        if (i24 >= i11) {
                            return i24;
                        }
                        i18 = r3.i(bArr, i24, s3Var);
                        if (i12 != s3Var.f25631a) {
                            return i24;
                        }
                        w4Var2.c(r3.o(bArr, i18));
                    }
                }
                return i18;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i14 == 2) {
                    r5 r5Var = (r5) g5Var;
                    int i25 = r3.i(bArr, i18, s3Var);
                    int i26 = s3Var.f25631a + i25;
                    while (i25 < i26) {
                        i25 = r3.k(bArr, i25, s3Var);
                        r5Var.c(s3Var.f25632b);
                    }
                    if (i25 == i26) {
                        return i25;
                    }
                    throw zzjk.zza();
                }
                if (i14 == 0) {
                    r5 r5Var2 = (r5) g5Var;
                    int k10 = r3.k(bArr, i18, s3Var);
                    r5Var2.c(s3Var.f25632b);
                    while (k10 < i11) {
                        int i27 = r3.i(bArr, k10, s3Var);
                        if (i12 != s3Var.f25631a) {
                            return k10;
                        }
                        k10 = r3.k(bArr, i27, s3Var);
                        r5Var2.c(s3Var.f25632b);
                    }
                    return k10;
                }
                return i18;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i14 == 2) {
                    return r3.j(bArr, i18, g5Var, s3Var);
                }
                if (i14 == 0) {
                    return r3.b(i12, bArr, i10, i11, g5Var, s3Var);
                }
                return i18;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i14 == 2) {
                    r5 r5Var3 = (r5) g5Var;
                    int i28 = r3.i(bArr, i18, s3Var);
                    int i29 = s3Var.f25631a + i28;
                    while (i28 < i29) {
                        r5Var3.c(r3.l(bArr, i28));
                        i28 += 8;
                    }
                    if (i28 == i29) {
                        return i28;
                    }
                    throw zzjk.zza();
                }
                if (i14 == 1) {
                    r5 r5Var4 = (r5) g5Var;
                    r5Var4.c(r3.l(bArr, i10));
                    while (true) {
                        int i30 = i18 + 8;
                        if (i30 >= i11) {
                            return i30;
                        }
                        i18 = r3.i(bArr, i30, s3Var);
                        if (i12 != s3Var.f25631a) {
                            return i30;
                        }
                        r5Var4.c(r3.l(bArr, i18));
                    }
                }
                return i18;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i14 == 2) {
                    z4 z4Var = (z4) g5Var;
                    int i31 = r3.i(bArr, i18, s3Var);
                    int i32 = s3Var.f25631a + i31;
                    while (i31 < i32) {
                        z4Var.f(r3.h(bArr, i31));
                        i31 += 4;
                    }
                    if (i31 == i32) {
                        return i31;
                    }
                    throw zzjk.zza();
                }
                if (i14 == 5) {
                    z4 z4Var2 = (z4) g5Var;
                    z4Var2.f(r3.h(bArr, i10));
                    while (true) {
                        int i33 = i18 + 4;
                        if (i33 >= i11) {
                            return i33;
                        }
                        i18 = r3.i(bArr, i33, s3Var);
                        if (i12 != s3Var.f25631a) {
                            return i33;
                        }
                        z4Var2.f(r3.h(bArr, i18));
                    }
                }
                return i18;
            case 25:
            case 42:
                if (i14 == 2) {
                    u3 u3Var = (u3) g5Var;
                    i17 = r3.i(bArr, i18, s3Var);
                    int i34 = s3Var.f25631a + i17;
                    while (i17 < i34) {
                        i17 = r3.k(bArr, i17, s3Var);
                        u3Var.c(s3Var.f25632b != 0);
                    }
                    if (i17 != i34) {
                        throw zzjk.zza();
                    }
                    return i17;
                }
                if (i14 == 0) {
                    u3 u3Var2 = (u3) g5Var;
                    i18 = r3.k(bArr, i18, s3Var);
                    u3Var2.c(s3Var.f25632b != 0);
                    while (i18 < i11) {
                        int i35 = r3.i(bArr, i18, s3Var);
                        if (i12 == s3Var.f25631a) {
                            i18 = r3.k(bArr, i35, s3Var);
                            u3Var2.c(s3Var.f25632b != 0);
                        }
                    }
                }
                return i18;
            case 26:
                if (i14 == 2) {
                    if ((j10 & HttpProxyCacheServer.Builder.DEFAULT_MAX_SIZE) == 0) {
                        i18 = r3.i(bArr, i18, s3Var);
                        int i36 = s3Var.f25631a;
                        if (i36 < 0) {
                            throw zzjk.zzb();
                        }
                        if (i36 == 0) {
                            g5Var.add("");
                        } else {
                            g5Var.add(new String(bArr, i18, i36, b5.f25436a));
                            i18 += i36;
                        }
                        while (i18 < i11) {
                            int i37 = r3.i(bArr, i18, s3Var);
                            if (i12 == s3Var.f25631a) {
                                i18 = r3.i(bArr, i37, s3Var);
                                int i38 = s3Var.f25631a;
                                if (i38 < 0) {
                                    throw zzjk.zzb();
                                }
                                if (i38 == 0) {
                                    g5Var.add("");
                                } else {
                                    g5Var.add(new String(bArr, i18, i38, b5.f25436a));
                                    i18 += i38;
                                }
                            }
                        }
                    } else {
                        i18 = r3.i(bArr, i18, s3Var);
                        int i39 = s3Var.f25631a;
                        if (i39 < 0) {
                            throw zzjk.zzb();
                        }
                        if (i39 == 0) {
                            g5Var.add("");
                        } else {
                            int i40 = i18 + i39;
                            if (s7.g(bArr, i18, i40)) {
                                g5Var.add(new String(bArr, i18, i39, b5.f25436a));
                                i18 = i40;
                            } else {
                                throw zzjk.zzh();
                            }
                        }
                        while (i18 < i11) {
                            int i41 = r3.i(bArr, i18, s3Var);
                            if (i12 == s3Var.f25631a) {
                                i18 = r3.i(bArr, i41, s3Var);
                                int i42 = s3Var.f25631a;
                                if (i42 < 0) {
                                    throw zzjk.zzb();
                                }
                                if (i42 == 0) {
                                    g5Var.add("");
                                } else {
                                    int i43 = i18 + i42;
                                    if (s7.g(bArr, i18, i43)) {
                                        g5Var.add(new String(bArr, i18, i42, b5.f25436a));
                                        i18 = i43;
                                    } else {
                                        throw zzjk.zzh();
                                    }
                                }
                            }
                        }
                    }
                }
                return i18;
            case 27:
                if (i14 == 2) {
                    return r3.e(o(i15), i12, bArr, i10, i11, g5Var, s3Var);
                }
                return i18;
            case 28:
                if (i14 == 2) {
                    int i44 = r3.i(bArr, i18, s3Var);
                    int i45 = s3Var.f25631a;
                    if (i45 >= 0) {
                        if (i45 > bArr.length - i44) {
                            throw zzjk.zza();
                        }
                        if (i45 == 0) {
                            g5Var.add(zzht.zza);
                        } else {
                            g5Var.add(zzht.zza(bArr, i44, i45));
                            i44 += i45;
                        }
                        while (i44 < i11) {
                            int i46 = r3.i(bArr, i44, s3Var);
                            if (i12 != s3Var.f25631a) {
                                return i44;
                            }
                            i44 = r3.i(bArr, i46, s3Var);
                            int i47 = s3Var.f25631a;
                            if (i47 >= 0) {
                                if (i47 > bArr.length - i44) {
                                    throw zzjk.zza();
                                }
                                if (i47 == 0) {
                                    g5Var.add(zzht.zza);
                                } else {
                                    g5Var.add(zzht.zza(bArr, i44, i47));
                                    i44 += i47;
                                }
                            } else {
                                throw zzjk.zzb();
                            }
                        }
                        return i44;
                    }
                    throw zzjk.zzb();
                }
                return i18;
            case 30:
            case 44:
                if (i14 != 2) {
                    if (i14 == 0) {
                        i17 = r3.b(i12, bArr, i10, i11, g5Var, s3Var);
                    }
                    return i18;
                }
                i17 = r3.j(bArr, i18, g5Var, s3Var);
                x4 x4Var = (x4) t2;
                m7 m7Var = x4Var.zzb;
                if (m7Var == m7.a()) {
                    m7Var = null;
                }
                m7 m7Var2 = (m7) u6.i(i13, g5Var, J(i15), m7Var, this.f25498o);
                if (m7Var2 != null) {
                    x4Var.zzb = m7Var2;
                }
                return i17;
            case 33:
            case 47:
                if (i14 == 2) {
                    z4 z4Var3 = (z4) g5Var;
                    int i48 = r3.i(bArr, i18, s3Var);
                    int i49 = s3Var.f25631a + i48;
                    while (i48 < i49) {
                        i48 = r3.i(bArr, i48, s3Var);
                        z4Var3.f(f4.d(s3Var.f25631a));
                    }
                    if (i48 == i49) {
                        return i48;
                    }
                    throw zzjk.zza();
                }
                if (i14 == 0) {
                    z4 z4Var4 = (z4) g5Var;
                    int i50 = r3.i(bArr, i18, s3Var);
                    z4Var4.f(f4.d(s3Var.f25631a));
                    while (i50 < i11) {
                        int i51 = r3.i(bArr, i50, s3Var);
                        if (i12 != s3Var.f25631a) {
                            return i50;
                        }
                        i50 = r3.i(bArr, i51, s3Var);
                        z4Var4.f(f4.d(s3Var.f25631a));
                    }
                    return i50;
                }
                return i18;
            case 34:
            case 48:
                if (i14 == 2) {
                    r5 r5Var5 = (r5) g5Var;
                    int i52 = r3.i(bArr, i18, s3Var);
                    int i53 = s3Var.f25631a + i52;
                    while (i52 < i53) {
                        i52 = r3.k(bArr, i52, s3Var);
                        r5Var5.c(f4.a(s3Var.f25632b));
                    }
                    if (i52 == i53) {
                        return i52;
                    }
                    throw zzjk.zza();
                }
                if (i14 == 0) {
                    r5 r5Var6 = (r5) g5Var;
                    int k11 = r3.k(bArr, i18, s3Var);
                    r5Var6.c(f4.a(s3Var.f25632b));
                    while (k11 < i11) {
                        int i54 = r3.i(bArr, k11, s3Var);
                        if (i12 != s3Var.f25631a) {
                            return k11;
                        }
                        k11 = r3.k(bArr, i54, s3Var);
                        r5Var6.c(f4.a(s3Var.f25632b));
                    }
                    return k11;
                }
                return i18;
            case 49:
                if (i14 == 3) {
                    t6 o10 = o(i15);
                    int i55 = (i12 & (-8)) | 4;
                    i18 = r3.f(o10, bArr, i10, i11, i55, s3Var);
                    g5Var.add(s3Var.f25633c);
                    while (i18 < i11) {
                        int i56 = r3.i(bArr, i18, s3Var);
                        if (i12 == s3Var.f25631a) {
                            i18 = r3.f(o10, bArr, i56, i11, i55, s3Var);
                            g5Var.add(s3Var.f25633c);
                        }
                    }
                }
                return i18;
            default:
                return i18;
        }
    }

    public final <K, V> int l(T t2, byte[] bArr, int i10, int i11, int i12, long j10, s3 s3Var) throws IOException {
        Unsafe unsafe = f25483s;
        Object D = D(i12);
        Object object = unsafe.getObject(t2, j10);
        if (this.f25500q.c(object)) {
            Object e2 = this.f25500q.e(D);
            this.f25500q.d(e2, object);
            unsafe.putObject(t2, j10, e2);
            object = e2;
        }
        this.f25500q.zzb(D);
        this.f25500q.b(object);
        int i13 = r3.i(bArr, i10, s3Var);
        int i14 = s3Var.f25631a;
        if (i14 >= 0 && i14 <= i11 - i13) {
            throw null;
        }
        throw zzjk.zza();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:144:0x009c. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:65:0x0444. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:70:0x058a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x058e  */
    /* JADX WARN: Type inference failed for: r13v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m(T r33, byte[] r34, int r35, int r36, int r37, com.google.android.gms.internal.vision.s3 r38) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1680
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.g6.m(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.vision.s3):int");
    }

    public final t6 o(int i10) {
        int i11 = (i10 / 3) << 1;
        t6 t6Var = (t6) this.f25485b[i11];
        if (t6Var != null) {
            return t6Var;
        }
        t6<T> b4 = p6.a().b((Class) this.f25485b[i11 + 1]);
        this.f25485b[i11] = b4;
        return b4;
    }

    public final <K, V, UT, UB> UB p(int i10, int i11, Map<K, V> map, c5 c5Var, UB ub2, k7<UT, UB> k7Var) {
        this.f25500q.zzb(D(i10));
        Iterator<Map.Entry<K, V>> iterator2 = map.entrySet().iterator2();
        while (iterator2.hasNext()) {
            Map.Entry<K, V> next = iterator2.next();
            if (!c5Var.zza(((Integer) next.getValue()).intValue())) {
                if (ub2 == null) {
                    ub2 = k7Var.a();
                }
                c4 zzc = zzht.zzc(v5.a(null, next.getKey(), next.getValue()));
                try {
                    v5.b(zzc.b(), null, next.getKey(), next.getValue());
                    k7Var.c(ub2, i11, zzc.a());
                    iterator2.remove();
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
        return ub2;
    }

    public final <UT, UB> UB q(Object obj, int i10, UB ub2, k7<UT, UB> k7Var) {
        c5 J;
        int i11 = this.f25484a[i10];
        Object F = p7.F(obj, L(i10) & 1048575);
        return (F == null || (J = J(i10)) == null) ? ub2 : (UB) p(i10, i11, this.f25500q.b(F), J, ub2, k7Var);
    }

    public final <K, V> void v(z7 z7Var, int i10, Object obj, int i11) throws IOException {
        if (obj != null) {
            this.f25500q.zzb(D(i11));
            z7Var.I(i10, null, this.f25500q.a(obj));
        }
    }

    public final void w(T t2, T t10, int i10) {
        long L = L(i10) & 1048575;
        if (x(t10, i10)) {
            Object F = p7.F(t2, L);
            Object F2 = p7.F(t10, L);
            if (F != null && F2 != null) {
                p7.j(t2, L, b5.e(F, F2));
                E(t2, i10);
            } else if (F2 != null) {
                p7.j(t2, L, F2);
                E(t2, i10);
            }
        }
    }

    public final boolean x(T t2, int i10) {
        int N = N(i10);
        long j10 = N & 1048575;
        if (j10 != 1048575) {
            return (p7.b(t2, j10) & (1 << (N >>> 20))) != 0;
        }
        int L = L(i10);
        long j11 = L & 1048575;
        switch ((L & 267386880) >>> 20) {
            case 0:
                return p7.C(t2, j11) != ShadowDrawableWrapper.COS_45;
            case 1:
                return p7.x(t2, j11) != 0.0f;
            case 2:
                return p7.o(t2, j11) != 0;
            case 3:
                return p7.o(t2, j11) != 0;
            case 4:
                return p7.b(t2, j11) != 0;
            case 5:
                return p7.o(t2, j11) != 0;
            case 6:
                return p7.b(t2, j11) != 0;
            case 7:
                return p7.w(t2, j11);
            case 8:
                Object F = p7.F(t2, j11);
                if (F instanceof String) {
                    return !((String) F).isEmpty();
                }
                if (F instanceof zzht) {
                    return !zzht.zza.equals(F);
                }
                throw new IllegalArgumentException();
            case 9:
                return p7.F(t2, j11) != null;
            case 10:
                return !zzht.zza.equals(p7.F(t2, j11));
            case 11:
                return p7.b(t2, j11) != 0;
            case 12:
                return p7.b(t2, j11) != 0;
            case 13:
                return p7.b(t2, j11) != 0;
            case 14:
                return p7.o(t2, j11) != 0;
            case 15:
                return p7.b(t2, j11) != 0;
            case 16:
                return p7.o(t2, j11) != 0;
            case 17:
                return p7.F(t2, j11) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final boolean y(T t2, int i10, int i11) {
        return p7.b(t2, (long) (N(i11) & 1048575)) == i10;
    }

    public final boolean z(T t2, int i10, int i11, int i12, int i13) {
        return i11 == 1048575 ? x(t2, i10) : (i12 & i13) != 0;
    }

    @Override // com.google.android.gms.internal.vision.t6
    public final T zza() {
        return (T) this.f25496m.b(this.f25488e);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x003f. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:255:0x04b4. Please report as an issue. */
    @Override // com.google.android.gms.internal.vision.t6
    public final int zzb(T t2) {
        int i10;
        long j10;
        int b02;
        int G;
        int A0;
        int R;
        int V;
        int g02;
        int o02;
        int B;
        int V2;
        int g03;
        int o03;
        int i11 = 267386880;
        int i12 = 1048575;
        int i13 = 1;
        if (this.f25491h) {
            Unsafe unsafe = f25483s;
            int i14 = 0;
            int i15 = 0;
            while (i14 < this.f25484a.length) {
                int L = L(i14);
                int i16 = (L & i11) >>> 20;
                int i17 = this.f25484a[i14];
                long j11 = L & 1048575;
                if (i16 >= zziv.zza.zza() && i16 <= zziv.zzb.zza()) {
                    int i18 = this.f25484a[i14 + 2];
                }
                switch (i16) {
                    case 0:
                        if (x(t2, i14)) {
                            B = zzii.B(i17, ShadowDrawableWrapper.COS_45);
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (x(t2, i14)) {
                            B = zzii.C(i17, 0.0f);
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (x(t2, i14)) {
                            B = zzii.b0(i17, p7.o(t2, j11));
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (x(t2, i14)) {
                            B = zzii.h0(i17, p7.o(t2, j11));
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (x(t2, i14)) {
                            B = zzii.l0(i17, p7.b(t2, j11));
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (x(t2, i14)) {
                            B = zzii.q0(i17, 0L);
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (x(t2, i14)) {
                            B = zzii.x0(i17, 0);
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (x(t2, i14)) {
                            B = zzii.H(i17, true);
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (x(t2, i14)) {
                            Object F = p7.F(t2, j11);
                            if (F instanceof zzht) {
                                B = zzii.T(i17, (zzht) F);
                            } else {
                                B = zzii.G(i17, (String) F);
                            }
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (x(t2, i14)) {
                            B = u6.a(i17, p7.F(t2, j11), o(i14));
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (x(t2, i14)) {
                            B = zzii.T(i17, (zzht) p7.F(t2, j11));
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (x(t2, i14)) {
                            B = zzii.p0(i17, p7.b(t2, j11));
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (x(t2, i14)) {
                            B = zzii.C0(i17, p7.b(t2, j11));
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (x(t2, i14)) {
                            B = zzii.A0(i17, 0);
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (x(t2, i14)) {
                            B = zzii.u0(i17, 0L);
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (x(t2, i14)) {
                            B = zzii.t0(i17, p7.b(t2, j11));
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (x(t2, i14)) {
                            B = zzii.m0(i17, p7.o(t2, j11));
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (x(t2, i14)) {
                            B = zzii.U(i17, (c6) p7.F(t2, j11), o(i14));
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        B = u6.U(i17, s(t2, j11), false);
                        i15 += B;
                        break;
                    case 19:
                        B = u6.R(i17, s(t2, j11), false);
                        i15 += B;
                        break;
                    case 20:
                        B = u6.d(i17, s(t2, j11), false);
                        i15 += B;
                        break;
                    case 21:
                        B = u6.t(i17, s(t2, j11), false);
                        i15 += B;
                        break;
                    case 22:
                        B = u6.H(i17, s(t2, j11), false);
                        i15 += B;
                        break;
                    case 23:
                        B = u6.U(i17, s(t2, j11), false);
                        i15 += B;
                        break;
                    case 24:
                        B = u6.R(i17, s(t2, j11), false);
                        i15 += B;
                        break;
                    case 25:
                        B = u6.X(i17, s(t2, j11), false);
                        i15 += B;
                        break;
                    case 26:
                        B = u6.b(i17, s(t2, j11));
                        i15 += B;
                        break;
                    case 27:
                        B = u6.c(i17, s(t2, j11), o(i14));
                        i15 += B;
                        break;
                    case 28:
                        B = u6.r(i17, s(t2, j11));
                        i15 += B;
                        break;
                    case 29:
                        B = u6.L(i17, s(t2, j11), false);
                        i15 += B;
                        break;
                    case 30:
                        B = u6.D(i17, s(t2, j11), false);
                        i15 += B;
                        break;
                    case 31:
                        B = u6.R(i17, s(t2, j11), false);
                        i15 += B;
                        break;
                    case 32:
                        B = u6.U(i17, s(t2, j11), false);
                        i15 += B;
                        break;
                    case 33:
                        B = u6.O(i17, s(t2, j11), false);
                        i15 += B;
                        break;
                    case 34:
                        B = u6.z(i17, s(t2, j11), false);
                        i15 += B;
                        break;
                    case 35:
                        V2 = u6.V((List) unsafe.getObject(t2, j11));
                        if (V2 > 0) {
                            g03 = zzii.g0(i17);
                            o03 = zzii.o0(V2);
                            B = g03 + o03 + V2;
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 36:
                        V2 = u6.S((List) unsafe.getObject(t2, j11));
                        if (V2 > 0) {
                            g03 = zzii.g0(i17);
                            o03 = zzii.o0(V2);
                            B = g03 + o03 + V2;
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 37:
                        V2 = u6.e((List) unsafe.getObject(t2, j11));
                        if (V2 > 0) {
                            g03 = zzii.g0(i17);
                            o03 = zzii.o0(V2);
                            B = g03 + o03 + V2;
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 38:
                        V2 = u6.u((List) unsafe.getObject(t2, j11));
                        if (V2 > 0) {
                            g03 = zzii.g0(i17);
                            o03 = zzii.o0(V2);
                            B = g03 + o03 + V2;
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 39:
                        V2 = u6.I((List) unsafe.getObject(t2, j11));
                        if (V2 > 0) {
                            g03 = zzii.g0(i17);
                            o03 = zzii.o0(V2);
                            B = g03 + o03 + V2;
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 40:
                        V2 = u6.V((List) unsafe.getObject(t2, j11));
                        if (V2 > 0) {
                            g03 = zzii.g0(i17);
                            o03 = zzii.o0(V2);
                            B = g03 + o03 + V2;
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 41:
                        V2 = u6.S((List) unsafe.getObject(t2, j11));
                        if (V2 > 0) {
                            g03 = zzii.g0(i17);
                            o03 = zzii.o0(V2);
                            B = g03 + o03 + V2;
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 42:
                        V2 = u6.Y((List) unsafe.getObject(t2, j11));
                        if (V2 > 0) {
                            g03 = zzii.g0(i17);
                            o03 = zzii.o0(V2);
                            B = g03 + o03 + V2;
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 43:
                        V2 = u6.M((List) unsafe.getObject(t2, j11));
                        if (V2 > 0) {
                            g03 = zzii.g0(i17);
                            o03 = zzii.o0(V2);
                            B = g03 + o03 + V2;
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 44:
                        V2 = u6.E((List) unsafe.getObject(t2, j11));
                        if (V2 > 0) {
                            g03 = zzii.g0(i17);
                            o03 = zzii.o0(V2);
                            B = g03 + o03 + V2;
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 45:
                        V2 = u6.S((List) unsafe.getObject(t2, j11));
                        if (V2 > 0) {
                            g03 = zzii.g0(i17);
                            o03 = zzii.o0(V2);
                            B = g03 + o03 + V2;
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 46:
                        V2 = u6.V((List) unsafe.getObject(t2, j11));
                        if (V2 > 0) {
                            g03 = zzii.g0(i17);
                            o03 = zzii.o0(V2);
                            B = g03 + o03 + V2;
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 47:
                        V2 = u6.P((List) unsafe.getObject(t2, j11));
                        if (V2 > 0) {
                            g03 = zzii.g0(i17);
                            o03 = zzii.o0(V2);
                            B = g03 + o03 + V2;
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 48:
                        V2 = u6.A((List) unsafe.getObject(t2, j11));
                        if (V2 > 0) {
                            g03 = zzii.g0(i17);
                            o03 = zzii.o0(V2);
                            B = g03 + o03 + V2;
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 49:
                        B = u6.s(i17, s(t2, j11), o(i14));
                        i15 += B;
                        break;
                    case 50:
                        B = this.f25500q.g(i17, p7.F(t2, j11), D(i14));
                        i15 += B;
                        break;
                    case 51:
                        if (y(t2, i17, i14)) {
                            B = zzii.B(i17, ShadowDrawableWrapper.COS_45);
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (y(t2, i17, i14)) {
                            B = zzii.C(i17, 0.0f);
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (y(t2, i17, i14)) {
                            B = zzii.b0(i17, O(t2, j11));
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (y(t2, i17, i14)) {
                            B = zzii.h0(i17, O(t2, j11));
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (y(t2, i17, i14)) {
                            B = zzii.l0(i17, M(t2, j11));
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (y(t2, i17, i14)) {
                            B = zzii.q0(i17, 0L);
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (y(t2, i17, i14)) {
                            B = zzii.x0(i17, 0);
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (y(t2, i17, i14)) {
                            B = zzii.H(i17, true);
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (y(t2, i17, i14)) {
                            Object F2 = p7.F(t2, j11);
                            if (F2 instanceof zzht) {
                                B = zzii.T(i17, (zzht) F2);
                            } else {
                                B = zzii.G(i17, (String) F2);
                            }
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (y(t2, i17, i14)) {
                            B = u6.a(i17, p7.F(t2, j11), o(i14));
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (y(t2, i17, i14)) {
                            B = zzii.T(i17, (zzht) p7.F(t2, j11));
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (y(t2, i17, i14)) {
                            B = zzii.p0(i17, M(t2, j11));
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (y(t2, i17, i14)) {
                            B = zzii.C0(i17, M(t2, j11));
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (y(t2, i17, i14)) {
                            B = zzii.A0(i17, 0);
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (y(t2, i17, i14)) {
                            B = zzii.u0(i17, 0L);
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (y(t2, i17, i14)) {
                            B = zzii.t0(i17, M(t2, j11));
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (y(t2, i17, i14)) {
                            B = zzii.m0(i17, O(t2, j11));
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (y(t2, i17, i14)) {
                            B = zzii.U(i17, (c6) p7.F(t2, j11), o(i14));
                            i15 += B;
                            break;
                        } else {
                            break;
                        }
                }
                i14 += 3;
                i11 = 267386880;
            }
            return i15 + i(this.f25498o, t2);
        }
        Unsafe unsafe2 = f25483s;
        int i19 = 0;
        int i20 = 0;
        int i21 = 1048575;
        int i22 = 0;
        while (i19 < this.f25484a.length) {
            int L2 = L(i19);
            int[] iArr = this.f25484a;
            int i23 = iArr[i19];
            int i24 = (L2 & 267386880) >>> 20;
            if (i24 <= 17) {
                int i25 = iArr[i19 + 2];
                int i26 = i25 & i12;
                i10 = i13 << (i25 >>> 20);
                if (i26 != i21) {
                    i22 = unsafe2.getInt(t2, i26);
                    i21 = i26;
                }
            } else {
                i10 = 0;
            }
            long j12 = L2 & i12;
            switch (i24) {
                case 0:
                    j10 = 0;
                    if ((i22 & i10) != 0) {
                        i20 += zzii.B(i23, ShadowDrawableWrapper.COS_45);
                        break;
                    }
                    break;
                case 1:
                    j10 = 0;
                    if ((i22 & i10) != 0) {
                        i20 += zzii.C(i23, 0.0f);
                    }
                    break;
                case 2:
                    j10 = 0;
                    if ((i10 & i22) != 0) {
                        b02 = zzii.b0(i23, unsafe2.getLong(t2, j12));
                        i20 += b02;
                    }
                    break;
                case 3:
                    j10 = 0;
                    if ((i10 & i22) != 0) {
                        b02 = zzii.h0(i23, unsafe2.getLong(t2, j12));
                        i20 += b02;
                    }
                    break;
                case 4:
                    j10 = 0;
                    if ((i10 & i22) != 0) {
                        b02 = zzii.l0(i23, unsafe2.getInt(t2, j12));
                        i20 += b02;
                    }
                    break;
                case 5:
                    j10 = 0;
                    if ((i22 & i10) != 0) {
                        b02 = zzii.q0(i23, 0L);
                        i20 += b02;
                    }
                    break;
                case 6:
                    if ((i22 & i10) != 0) {
                        i20 += zzii.x0(i23, 0);
                    }
                    j10 = 0;
                    break;
                case 7:
                    if ((i22 & i10) != 0) {
                        i20 += zzii.H(i23, true);
                        j10 = 0;
                        break;
                    }
                    j10 = 0;
                case 8:
                    if ((i22 & i10) != 0) {
                        Object object = unsafe2.getObject(t2, j12);
                        if (object instanceof zzht) {
                            G = zzii.T(i23, (zzht) object);
                        } else {
                            G = zzii.G(i23, (String) object);
                        }
                        i20 += G;
                    }
                    j10 = 0;
                    break;
                case 9:
                    if ((i22 & i10) != 0) {
                        G = u6.a(i23, unsafe2.getObject(t2, j12), o(i19));
                        i20 += G;
                    }
                    j10 = 0;
                    break;
                case 10:
                    if ((i22 & i10) != 0) {
                        G = zzii.T(i23, (zzht) unsafe2.getObject(t2, j12));
                        i20 += G;
                    }
                    j10 = 0;
                    break;
                case 11:
                    if ((i22 & i10) != 0) {
                        G = zzii.p0(i23, unsafe2.getInt(t2, j12));
                        i20 += G;
                    }
                    j10 = 0;
                    break;
                case 12:
                    if ((i22 & i10) != 0) {
                        G = zzii.C0(i23, unsafe2.getInt(t2, j12));
                        i20 += G;
                    }
                    j10 = 0;
                    break;
                case 13:
                    if ((i22 & i10) != 0) {
                        A0 = zzii.A0(i23, 0);
                        i20 += A0;
                    }
                    j10 = 0;
                    break;
                case 14:
                    if ((i22 & i10) != 0) {
                        G = zzii.u0(i23, 0L);
                        i20 += G;
                    }
                    j10 = 0;
                    break;
                case 15:
                    if ((i22 & i10) != 0) {
                        G = zzii.t0(i23, unsafe2.getInt(t2, j12));
                        i20 += G;
                    }
                    j10 = 0;
                    break;
                case 16:
                    if ((i22 & i10) != 0) {
                        G = zzii.m0(i23, unsafe2.getLong(t2, j12));
                        i20 += G;
                    }
                    j10 = 0;
                    break;
                case 17:
                    if ((i22 & i10) != 0) {
                        G = zzii.U(i23, (c6) unsafe2.getObject(t2, j12), o(i19));
                        i20 += G;
                    }
                    j10 = 0;
                    break;
                case 18:
                    G = u6.U(i23, (List) unsafe2.getObject(t2, j12), false);
                    i20 += G;
                    j10 = 0;
                    break;
                case 19:
                    R = u6.R(i23, (List) unsafe2.getObject(t2, j12), false);
                    i20 += R;
                    j10 = 0;
                    break;
                case 20:
                    R = u6.d(i23, (List) unsafe2.getObject(t2, j12), false);
                    i20 += R;
                    j10 = 0;
                    break;
                case 21:
                    R = u6.t(i23, (List) unsafe2.getObject(t2, j12), false);
                    i20 += R;
                    j10 = 0;
                    break;
                case 22:
                    R = u6.H(i23, (List) unsafe2.getObject(t2, j12), false);
                    i20 += R;
                    j10 = 0;
                    break;
                case 23:
                    R = u6.U(i23, (List) unsafe2.getObject(t2, j12), false);
                    i20 += R;
                    j10 = 0;
                    break;
                case 24:
                    R = u6.R(i23, (List) unsafe2.getObject(t2, j12), false);
                    i20 += R;
                    j10 = 0;
                    break;
                case 25:
                    R = u6.X(i23, (List) unsafe2.getObject(t2, j12), false);
                    i20 += R;
                    j10 = 0;
                    break;
                case 26:
                    G = u6.b(i23, (List) unsafe2.getObject(t2, j12));
                    i20 += G;
                    j10 = 0;
                    break;
                case 27:
                    G = u6.c(i23, (List) unsafe2.getObject(t2, j12), o(i19));
                    i20 += G;
                    j10 = 0;
                    break;
                case 28:
                    G = u6.r(i23, (List) unsafe2.getObject(t2, j12));
                    i20 += G;
                    j10 = 0;
                    break;
                case 29:
                    G = u6.L(i23, (List) unsafe2.getObject(t2, j12), false);
                    i20 += G;
                    j10 = 0;
                    break;
                case 30:
                    R = u6.D(i23, (List) unsafe2.getObject(t2, j12), false);
                    i20 += R;
                    j10 = 0;
                    break;
                case 31:
                    R = u6.R(i23, (List) unsafe2.getObject(t2, j12), false);
                    i20 += R;
                    j10 = 0;
                    break;
                case 32:
                    R = u6.U(i23, (List) unsafe2.getObject(t2, j12), false);
                    i20 += R;
                    j10 = 0;
                    break;
                case 33:
                    R = u6.O(i23, (List) unsafe2.getObject(t2, j12), false);
                    i20 += R;
                    j10 = 0;
                    break;
                case 34:
                    R = u6.z(i23, (List) unsafe2.getObject(t2, j12), false);
                    i20 += R;
                    j10 = 0;
                    break;
                case 35:
                    V = u6.V((List) unsafe2.getObject(t2, j12));
                    if (V > 0) {
                        g02 = zzii.g0(i23);
                        o02 = zzii.o0(V);
                        A0 = g02 + o02 + V;
                        i20 += A0;
                    }
                    j10 = 0;
                    break;
                case 36:
                    V = u6.S((List) unsafe2.getObject(t2, j12));
                    if (V > 0) {
                        g02 = zzii.g0(i23);
                        o02 = zzii.o0(V);
                        A0 = g02 + o02 + V;
                        i20 += A0;
                    }
                    j10 = 0;
                    break;
                case 37:
                    V = u6.e((List) unsafe2.getObject(t2, j12));
                    if (V > 0) {
                        g02 = zzii.g0(i23);
                        o02 = zzii.o0(V);
                        A0 = g02 + o02 + V;
                        i20 += A0;
                    }
                    j10 = 0;
                    break;
                case 38:
                    V = u6.u((List) unsafe2.getObject(t2, j12));
                    if (V > 0) {
                        g02 = zzii.g0(i23);
                        o02 = zzii.o0(V);
                        A0 = g02 + o02 + V;
                        i20 += A0;
                    }
                    j10 = 0;
                    break;
                case 39:
                    V = u6.I((List) unsafe2.getObject(t2, j12));
                    if (V > 0) {
                        g02 = zzii.g0(i23);
                        o02 = zzii.o0(V);
                        A0 = g02 + o02 + V;
                        i20 += A0;
                    }
                    j10 = 0;
                    break;
                case 40:
                    V = u6.V((List) unsafe2.getObject(t2, j12));
                    if (V > 0) {
                        g02 = zzii.g0(i23);
                        o02 = zzii.o0(V);
                        A0 = g02 + o02 + V;
                        i20 += A0;
                    }
                    j10 = 0;
                    break;
                case 41:
                    V = u6.S((List) unsafe2.getObject(t2, j12));
                    if (V > 0) {
                        g02 = zzii.g0(i23);
                        o02 = zzii.o0(V);
                        A0 = g02 + o02 + V;
                        i20 += A0;
                    }
                    j10 = 0;
                    break;
                case 42:
                    V = u6.Y((List) unsafe2.getObject(t2, j12));
                    if (V > 0) {
                        g02 = zzii.g0(i23);
                        o02 = zzii.o0(V);
                        A0 = g02 + o02 + V;
                        i20 += A0;
                    }
                    j10 = 0;
                    break;
                case 43:
                    V = u6.M((List) unsafe2.getObject(t2, j12));
                    if (V > 0) {
                        g02 = zzii.g0(i23);
                        o02 = zzii.o0(V);
                        A0 = g02 + o02 + V;
                        i20 += A0;
                    }
                    j10 = 0;
                    break;
                case 44:
                    V = u6.E((List) unsafe2.getObject(t2, j12));
                    if (V > 0) {
                        g02 = zzii.g0(i23);
                        o02 = zzii.o0(V);
                        A0 = g02 + o02 + V;
                        i20 += A0;
                    }
                    j10 = 0;
                    break;
                case 45:
                    V = u6.S((List) unsafe2.getObject(t2, j12));
                    if (V > 0) {
                        g02 = zzii.g0(i23);
                        o02 = zzii.o0(V);
                        A0 = g02 + o02 + V;
                        i20 += A0;
                    }
                    j10 = 0;
                    break;
                case 46:
                    V = u6.V((List) unsafe2.getObject(t2, j12));
                    if (V > 0) {
                        g02 = zzii.g0(i23);
                        o02 = zzii.o0(V);
                        A0 = g02 + o02 + V;
                        i20 += A0;
                    }
                    j10 = 0;
                    break;
                case 47:
                    V = u6.P((List) unsafe2.getObject(t2, j12));
                    if (V > 0) {
                        g02 = zzii.g0(i23);
                        o02 = zzii.o0(V);
                        A0 = g02 + o02 + V;
                        i20 += A0;
                    }
                    j10 = 0;
                    break;
                case 48:
                    V = u6.A((List) unsafe2.getObject(t2, j12));
                    if (V > 0) {
                        g02 = zzii.g0(i23);
                        o02 = zzii.o0(V);
                        A0 = g02 + o02 + V;
                        i20 += A0;
                    }
                    j10 = 0;
                    break;
                case 49:
                    G = u6.s(i23, (List) unsafe2.getObject(t2, j12), o(i19));
                    i20 += G;
                    j10 = 0;
                    break;
                case 50:
                    G = this.f25500q.g(i23, unsafe2.getObject(t2, j12), D(i19));
                    i20 += G;
                    j10 = 0;
                    break;
                case 51:
                    if (y(t2, i23, i19)) {
                        G = zzii.B(i23, ShadowDrawableWrapper.COS_45);
                        i20 += G;
                    }
                    j10 = 0;
                    break;
                case 52:
                    if (y(t2, i23, i19)) {
                        A0 = zzii.C(i23, 0.0f);
                        i20 += A0;
                    }
                    j10 = 0;
                    break;
                case 53:
                    if (y(t2, i23, i19)) {
                        G = zzii.b0(i23, O(t2, j12));
                        i20 += G;
                    }
                    j10 = 0;
                    break;
                case 54:
                    if (y(t2, i23, i19)) {
                        G = zzii.h0(i23, O(t2, j12));
                        i20 += G;
                    }
                    j10 = 0;
                    break;
                case 55:
                    if (y(t2, i23, i19)) {
                        G = zzii.l0(i23, M(t2, j12));
                        i20 += G;
                    }
                    j10 = 0;
                    break;
                case 56:
                    if (y(t2, i23, i19)) {
                        G = zzii.q0(i23, 0L);
                        i20 += G;
                    }
                    j10 = 0;
                    break;
                case 57:
                    if (y(t2, i23, i19)) {
                        A0 = zzii.x0(i23, 0);
                        i20 += A0;
                    }
                    j10 = 0;
                    break;
                case 58:
                    if (y(t2, i23, i19)) {
                        A0 = zzii.H(i23, true);
                        i20 += A0;
                    }
                    j10 = 0;
                    break;
                case 59:
                    if (y(t2, i23, i19)) {
                        Object object2 = unsafe2.getObject(t2, j12);
                        if (object2 instanceof zzht) {
                            G = zzii.T(i23, (zzht) object2);
                        } else {
                            G = zzii.G(i23, (String) object2);
                        }
                        i20 += G;
                    }
                    j10 = 0;
                    break;
                case 60:
                    if (y(t2, i23, i19)) {
                        G = u6.a(i23, unsafe2.getObject(t2, j12), o(i19));
                        i20 += G;
                    }
                    j10 = 0;
                    break;
                case 61:
                    if (y(t2, i23, i19)) {
                        G = zzii.T(i23, (zzht) unsafe2.getObject(t2, j12));
                        i20 += G;
                    }
                    j10 = 0;
                    break;
                case 62:
                    if (y(t2, i23, i19)) {
                        G = zzii.p0(i23, M(t2, j12));
                        i20 += G;
                    }
                    j10 = 0;
                    break;
                case 63:
                    if (y(t2, i23, i19)) {
                        G = zzii.C0(i23, M(t2, j12));
                        i20 += G;
                    }
                    j10 = 0;
                    break;
                case 64:
                    if (y(t2, i23, i19)) {
                        A0 = zzii.A0(i23, 0);
                        i20 += A0;
                    }
                    j10 = 0;
                    break;
                case 65:
                    if (y(t2, i23, i19)) {
                        G = zzii.u0(i23, 0L);
                        i20 += G;
                    }
                    j10 = 0;
                    break;
                case 66:
                    if (y(t2, i23, i19)) {
                        G = zzii.t0(i23, M(t2, j12));
                        i20 += G;
                    }
                    j10 = 0;
                    break;
                case 67:
                    if (y(t2, i23, i19)) {
                        G = zzii.m0(i23, O(t2, j12));
                        i20 += G;
                    }
                    j10 = 0;
                    break;
                case 68:
                    if (y(t2, i23, i19)) {
                        G = zzii.U(i23, (c6) unsafe2.getObject(t2, j12), o(i19));
                        i20 += G;
                    }
                    j10 = 0;
                    break;
                default:
                    j10 = 0;
                    break;
            }
            i19 += 3;
            i12 = 1048575;
            i13 = 1;
        }
        int i27 = 0;
        int i28 = i20 + i(this.f25498o, t2);
        if (!this.f25489f) {
            return i28;
        }
        r4<?> b4 = this.f25499p.b(t2);
        for (int i29 = 0; i29 < b4.f25620a.j(); i29++) {
            Map.Entry<?, Object> h10 = b4.f25620a.h(i29);
            i27 += r4.l((s4) h10.getKey(), h10.getValue());
        }
        for (Map.Entry<?, Object> entry : b4.f25620a.m()) {
            i27 += r4.l((s4) entry.getKey(), entry.getValue());
        }
        return i28 + i27;
    }
}
