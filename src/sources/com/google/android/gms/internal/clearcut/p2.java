package com.google.android.gms.internal.clearcut;

import java.lang.reflect.Field;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class p2 {
    public int A;
    public int B;
    public Field C;
    public Object D;
    public Object E;
    public Object F;

    /* renamed from: a, reason: collision with root package name */
    public final q2 f23980a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f23981b;

    /* renamed from: c, reason: collision with root package name */
    public Class<?> f23982c;

    /* renamed from: d, reason: collision with root package name */
    public final int f23983d;

    /* renamed from: e, reason: collision with root package name */
    public final int f23984e;

    /* renamed from: f, reason: collision with root package name */
    public final int f23985f;

    /* renamed from: g, reason: collision with root package name */
    public final int f23986g;

    /* renamed from: h, reason: collision with root package name */
    public final int f23987h;

    /* renamed from: i, reason: collision with root package name */
    public final int f23988i;

    /* renamed from: j, reason: collision with root package name */
    public final int f23989j;

    /* renamed from: k, reason: collision with root package name */
    public final int f23990k;

    /* renamed from: l, reason: collision with root package name */
    public final int f23991l;

    /* renamed from: m, reason: collision with root package name */
    public final int f23992m;

    /* renamed from: n, reason: collision with root package name */
    public final int[] f23993n;

    /* renamed from: o, reason: collision with root package name */
    public int f23994o;

    /* renamed from: p, reason: collision with root package name */
    public int f23995p;

    /* renamed from: q, reason: collision with root package name */
    public int f23996q = Integer.MAX_VALUE;

    /* renamed from: r, reason: collision with root package name */
    public int f23997r = Integer.MIN_VALUE;

    /* renamed from: s, reason: collision with root package name */
    public int f23998s = 0;

    /* renamed from: t, reason: collision with root package name */
    public int f23999t = 0;

    /* renamed from: u, reason: collision with root package name */
    public int f24000u = 0;

    /* renamed from: v, reason: collision with root package name */
    public int f24001v = 0;

    /* renamed from: w, reason: collision with root package name */
    public int f24002w = 0;

    /* renamed from: x, reason: collision with root package name */
    public int f24003x;

    /* renamed from: y, reason: collision with root package name */
    public int f24004y;

    /* renamed from: z, reason: collision with root package name */
    public int f24005z;

    public p2(Class<?> cls, String str, Object[] objArr) {
        this.f23982c = cls;
        q2 q2Var = new q2(str);
        this.f23980a = q2Var;
        this.f23981b = objArr;
        this.f23983d = q2Var.b();
        int b4 = q2Var.b();
        this.f23984e = b4;
        if (b4 == 0) {
            this.f23985f = 0;
            this.f23986g = 0;
            this.f23987h = 0;
            this.f23988i = 0;
            this.f23989j = 0;
            this.f23991l = 0;
            this.f23990k = 0;
            this.f23992m = 0;
            this.f23993n = null;
            return;
        }
        int b10 = q2Var.b();
        this.f23985f = b10;
        int b11 = q2Var.b();
        this.f23986g = b11;
        this.f23987h = q2Var.b();
        this.f23988i = q2Var.b();
        this.f23991l = q2Var.b();
        this.f23990k = q2Var.b();
        this.f23989j = q2Var.b();
        this.f23992m = q2Var.b();
        int b12 = q2Var.b();
        this.f23993n = b12 != 0 ? new int[b12] : null;
        this.f23994o = (b10 << 1) + b11;
    }

    public static /* synthetic */ int A(p2 p2Var) {
        return p2Var.f23990k;
    }

    public static /* synthetic */ int b(p2 p2Var) {
        return p2Var.f23983d;
    }

    public static Field c(Class<?> cls, String str) {
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

    public static /* synthetic */ int d(p2 p2Var) {
        return p2Var.f23987h;
    }

    public static /* synthetic */ int e(p2 p2Var) {
        return p2Var.f23988i;
    }

    public static /* synthetic */ int j(p2 p2Var) {
        return p2Var.f23984e;
    }

    public static /* synthetic */ int w(p2 p2Var) {
        return p2Var.f23989j;
    }

    public static /* synthetic */ int x(p2 p2Var) {
        return p2Var.f23992m;
    }

    public static /* synthetic */ int[] y(p2 p2Var) {
        return p2Var.f23993n;
    }

    public static /* synthetic */ int z(p2 p2Var) {
        return p2Var.f23991l;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c6, code lost:
    
        if (i() != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c8, code lost:
    
        r6.E = f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0152, code lost:
    
        if (((r6.f24004y & 2048) != 0) != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0159, code lost:
    
        if (i() != false) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a() {
        /*
            Method dump skipped, instructions count: 358
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.p2.a():boolean");
    }

    public final Object f() {
        Object[] objArr = this.f23981b;
        int i10 = this.f23994o;
        this.f23994o = i10 + 1;
        return objArr[i10];
    }

    public final int g() {
        return this.f24003x;
    }

    public final int h() {
        return this.f24005z;
    }

    public final boolean i() {
        return (this.f23983d & 1) == 1;
    }

    public final boolean k() {
        return this.f24005z > zzcb.zziw.id();
    }

    public final Field l() {
        int i10 = this.A << 1;
        Object obj = this.f23981b[i10];
        if (obj instanceof Field) {
            return (Field) obj;
        }
        Field c4 = c(this.f23982c, (String) obj);
        this.f23981b[i10] = c4;
        return c4;
    }

    public final Field m() {
        int i10 = (this.A << 1) + 1;
        Object obj = this.f23981b[i10];
        if (obj instanceof Field) {
            return (Field) obj;
        }
        Field c4 = c(this.f23982c, (String) obj);
        this.f23981b[i10] = c4;
        return c4;
    }

    public final Field n() {
        return this.C;
    }

    public final boolean o() {
        return i() && this.f24005z <= zzcb.zzhp.id();
    }

    public final Field p() {
        int i10 = (this.f23985f << 1) + (this.B / 32);
        Object obj = this.f23981b[i10];
        if (obj instanceof Field) {
            return (Field) obj;
        }
        Field c4 = c(this.f23982c, (String) obj);
        this.f23981b[i10] = c4;
        return c4;
    }

    public final int q() {
        return this.B % 32;
    }

    public final boolean r() {
        return (this.f24004y & 256) != 0;
    }

    public final boolean s() {
        return (this.f24004y & 512) != 0;
    }

    public final Object t() {
        return this.D;
    }

    public final Object u() {
        return this.E;
    }

    public final Object v() {
        return this.F;
    }
}
