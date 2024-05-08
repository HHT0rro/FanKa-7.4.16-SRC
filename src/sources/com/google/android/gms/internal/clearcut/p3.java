package com.google.android.gms.internal.clearcut;

import android.view.textclassifier.TextClassifier;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class p3 {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f24006a = Logger.getLogger(p3.class.getName());

    /* renamed from: b, reason: collision with root package name */
    public static final Unsafe f24007b;

    /* renamed from: c, reason: collision with root package name */
    public static final Class<?> f24008c;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f24009d;

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f24010e;

    /* renamed from: f, reason: collision with root package name */
    public static final d f24011f;

    /* renamed from: g, reason: collision with root package name */
    public static final boolean f24012g;

    /* renamed from: h, reason: collision with root package name */
    public static final boolean f24013h;

    /* renamed from: i, reason: collision with root package name */
    public static final long f24014i;

    /* renamed from: j, reason: collision with root package name */
    public static final long f24015j;

    /* renamed from: k, reason: collision with root package name */
    public static final long f24016k;

    /* renamed from: l, reason: collision with root package name */
    public static final long f24017l;

    /* renamed from: m, reason: collision with root package name */
    public static final long f24018m;

    /* renamed from: n, reason: collision with root package name */
    public static final long f24019n;

    /* renamed from: o, reason: collision with root package name */
    public static final long f24020o;

    /* renamed from: p, reason: collision with root package name */
    public static final long f24021p;

    /* renamed from: q, reason: collision with root package name */
    public static final long f24022q;

    /* renamed from: r, reason: collision with root package name */
    public static final long f24023r;

    /* renamed from: s, reason: collision with root package name */
    public static final long f24024s;

    /* renamed from: t, reason: collision with root package name */
    public static final long f24025t;

    /* renamed from: u, reason: collision with root package name */
    public static final long f24026u;

    /* renamed from: v, reason: collision with root package name */
    public static final long f24027v;

    /* renamed from: w, reason: collision with root package name */
    public static final long f24028w;

    /* renamed from: x, reason: collision with root package name */
    public static final boolean f24029x;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends d {
        public a(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.clearcut.p3.d
        public final void b(long j10, byte b4) {
            Memory.pokeByte((int) (j10 & (-1)), b4);
        }

        @Override // com.google.android.gms.internal.clearcut.p3.d
        public final void c(Object obj, long j10, double d10) {
            f(obj, j10, Double.doubleToLongBits(d10));
        }

        @Override // com.google.android.gms.internal.clearcut.p3.d
        public final void d(Object obj, long j10, float f10) {
            e(obj, j10, Float.floatToIntBits(f10));
        }

        @Override // com.google.android.gms.internal.clearcut.p3.d
        public final void g(Object obj, long j10, boolean z10) {
            if (p3.f24029x) {
                p3.r(obj, j10, z10);
            } else {
                p3.t(obj, j10, z10);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.p3.d
        public final void h(byte[] bArr, long j10, long j11, long j12) {
            Memory.pokeByteArray((int) (j11 & (-1)), bArr, (int) j10, (int) j12);
        }

        @Override // com.google.android.gms.internal.clearcut.p3.d
        public final void i(Object obj, long j10, byte b4) {
            if (p3.f24029x) {
                p3.d(obj, j10, b4);
            } else {
                p3.q(obj, j10, b4);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.p3.d
        public final boolean l(Object obj, long j10) {
            return p3.f24029x ? p3.P(obj, j10) : p3.Q(obj, j10);
        }

        @Override // com.google.android.gms.internal.clearcut.p3.d
        public final float m(Object obj, long j10) {
            return Float.intBitsToFloat(j(obj, j10));
        }

        @Override // com.google.android.gms.internal.clearcut.p3.d
        public final double n(Object obj, long j10) {
            return Double.longBitsToDouble(k(obj, j10));
        }

        @Override // com.google.android.gms.internal.clearcut.p3.d
        public final byte o(Object obj, long j10) {
            return p3.f24029x ? p3.N(obj, j10) : p3.O(obj, j10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b extends d {
        public b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.clearcut.p3.d
        public final void b(long j10, byte b4) {
            Memory.pokeByte(j10, b4);
        }

        @Override // com.google.android.gms.internal.clearcut.p3.d
        public final void c(Object obj, long j10, double d10) {
            f(obj, j10, Double.doubleToLongBits(d10));
        }

        @Override // com.google.android.gms.internal.clearcut.p3.d
        public final void d(Object obj, long j10, float f10) {
            e(obj, j10, Float.floatToIntBits(f10));
        }

        @Override // com.google.android.gms.internal.clearcut.p3.d
        public final void g(Object obj, long j10, boolean z10) {
            if (p3.f24029x) {
                p3.r(obj, j10, z10);
            } else {
                p3.t(obj, j10, z10);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.p3.d
        public final void h(byte[] bArr, long j10, long j11, long j12) {
            Memory.pokeByteArray(j11, bArr, (int) j10, (int) j12);
        }

        @Override // com.google.android.gms.internal.clearcut.p3.d
        public final void i(Object obj, long j10, byte b4) {
            if (p3.f24029x) {
                p3.d(obj, j10, b4);
            } else {
                p3.q(obj, j10, b4);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.p3.d
        public final boolean l(Object obj, long j10) {
            return p3.f24029x ? p3.P(obj, j10) : p3.Q(obj, j10);
        }

        @Override // com.google.android.gms.internal.clearcut.p3.d
        public final float m(Object obj, long j10) {
            return Float.intBitsToFloat(j(obj, j10));
        }

        @Override // com.google.android.gms.internal.clearcut.p3.d
        public final double n(Object obj, long j10) {
            return Double.longBitsToDouble(k(obj, j10));
        }

        @Override // com.google.android.gms.internal.clearcut.p3.d
        public final byte o(Object obj, long j10) {
            return p3.f24029x ? p3.N(obj, j10) : p3.O(obj, j10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c extends d {
        public c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.clearcut.p3.d
        public final void b(long j10, byte b4) {
            this.f24030a.putByte(j10, b4);
        }

        @Override // com.google.android.gms.internal.clearcut.p3.d
        public final void c(Object obj, long j10, double d10) {
            this.f24030a.putDouble(obj, j10, d10);
        }

        @Override // com.google.android.gms.internal.clearcut.p3.d
        public final void d(Object obj, long j10, float f10) {
            this.f24030a.putFloat(obj, j10, f10);
        }

        @Override // com.google.android.gms.internal.clearcut.p3.d
        public final void g(Object obj, long j10, boolean z10) {
            this.f24030a.putBoolean(obj, j10, z10);
        }

        @Override // com.google.android.gms.internal.clearcut.p3.d
        public final void h(byte[] bArr, long j10, long j11, long j12) {
            this.f24030a.copyMemory(bArr, p3.f24014i + j10, null, j11, j12);
        }

        @Override // com.google.android.gms.internal.clearcut.p3.d
        public final void i(Object obj, long j10, byte b4) {
            this.f24030a.putByte(obj, j10, b4);
        }

        @Override // com.google.android.gms.internal.clearcut.p3.d
        public final boolean l(Object obj, long j10) {
            return this.f24030a.getBoolean(obj, j10);
        }

        @Override // com.google.android.gms.internal.clearcut.p3.d
        public final float m(Object obj, long j10) {
            return this.f24030a.getFloat(obj, j10);
        }

        @Override // com.google.android.gms.internal.clearcut.p3.d
        public final double n(Object obj, long j10) {
            return this.f24030a.getDouble(obj, j10);
        }

        @Override // com.google.android.gms.internal.clearcut.p3.d
        public final byte o(Object obj, long j10) {
            return this.f24030a.getByte(obj, j10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static abstract class d {

        /* renamed from: a, reason: collision with root package name */
        public Unsafe f24030a;

        public d(Unsafe unsafe) {
            this.f24030a = unsafe;
        }

        public final long a(Field field) {
            return this.f24030a.objectFieldOffset(field);
        }

        public abstract void b(long j10, byte b4);

        public abstract void c(Object obj, long j10, double d10);

        public abstract void d(Object obj, long j10, float f10);

        public final void e(Object obj, long j10, int i10) {
            this.f24030a.putInt(obj, j10, i10);
        }

        public final void f(Object obj, long j10, long j11) {
            this.f24030a.putLong(obj, j10, j11);
        }

        public abstract void g(Object obj, long j10, boolean z10);

        public abstract void h(byte[] bArr, long j10, long j11, long j12);

        public abstract void i(Object obj, long j10, byte b4);

        public final int j(Object obj, long j10) {
            return this.f24030a.getInt(obj, j10);
        }

        public final long k(Object obj, long j10) {
            return this.f24030a.getLong(obj, j10);
        }

        public abstract boolean l(Object obj, long j10);

        public abstract float m(Object obj, long j10);

        public abstract double n(Object obj, long j10);

        public abstract byte o(Object obj, long j10);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00ec  */
    static {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.p3.<clinit>():void");
    }

    public static boolean A() {
        Unsafe unsafe = f24007b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            Class<Long> cls2 = Long.TYPE;
            cls.getMethod("getInt", Object.class, cls2);
            cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
            cls.getMethod("getLong", Object.class, cls2);
            cls.getMethod("putLong", Object.class, cls2, cls2);
            cls.getMethod("getObject", Object.class, cls2);
            cls.getMethod("putObject", Object.class, cls2, Object.class);
            if (u.b()) {
                return true;
            }
            cls.getMethod("getByte", Object.class, cls2);
            cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, cls2);
            cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, cls2);
            cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
            cls.getMethod("getDouble", Object.class, cls2);
            cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger = f24006a;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 71);
            sb2.append("platform method missing - proto runtime falling back to safer methods: ");
            sb2.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb2.toString());
            return false;
        }
    }

    public static boolean B() {
        Unsafe unsafe = f24007b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            Class<Long> cls2 = Long.TYPE;
            cls.getMethod("getLong", Object.class, cls2);
            if (C() == null) {
                return false;
            }
            if (u.b()) {
                return true;
            }
            cls.getMethod("getByte", cls2);
            cls.getMethod("putByte", cls2, Byte.TYPE);
            cls.getMethod("getInt", cls2);
            cls.getMethod("putInt", cls2, Integer.TYPE);
            cls.getMethod("getLong", cls2);
            cls.getMethod("putLong", cls2, cls2);
            cls.getMethod("copyMemory", cls2, cls2, cls2);
            cls.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
            return true;
        } catch (Throwable th) {
            Logger logger = f24006a;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 71);
            sb2.append("platform method missing - proto runtime falling back to safer methods: ");
            sb2.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb2.toString());
            return false;
        }
    }

    public static Field C() {
        Field p10;
        if (u.b() && (p10 = p(Buffer.class, "effectiveDirectAddress")) != null) {
            return p10;
        }
        Field p11 = p(Buffer.class, TextClassifier.TYPE_ADDRESS);
        if (p11 == null || p11.getType() != Long.TYPE) {
            return null;
        }
        return p11;
    }

    public static int E(Class<?> cls) {
        if (f24013h) {
            return f24011f.f24030a.arrayBaseOffset(cls);
        }
        return -1;
    }

    public static int F(Class<?> cls) {
        if (f24013h) {
            return f24011f.f24030a.arrayIndexScale(cls);
        }
        return -1;
    }

    public static boolean G(Class<?> cls) {
        if (!u.b()) {
            return false;
        }
        try {
            Class<?> cls2 = f24008c;
            Class<Boolean> cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class<Integer> cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int H(Object obj, long j10) {
        return f24011f.j(obj, j10);
    }

    public static long I(Object obj, long j10) {
        return f24011f.k(obj, j10);
    }

    public static boolean J(Object obj, long j10) {
        return f24011f.l(obj, j10);
    }

    public static float K(Object obj, long j10) {
        return f24011f.m(obj, j10);
    }

    public static double L(Object obj, long j10) {
        return f24011f.n(obj, j10);
    }

    public static Object M(Object obj, long j10) {
        return f24011f.f24030a.getObject(obj, j10);
    }

    public static byte N(Object obj, long j10) {
        return (byte) (H(obj, (-4) & j10) >>> ((int) (((~j10) & 3) << 3)));
    }

    public static byte O(Object obj, long j10) {
        return (byte) (H(obj, (-4) & j10) >>> ((int) ((j10 & 3) << 3)));
    }

    public static boolean P(Object obj, long j10) {
        return N(obj, j10) != 0;
    }

    public static boolean Q(Object obj, long j10) {
        return O(obj, j10) != 0;
    }

    public static byte a(byte[] bArr, long j10) {
        return f24011f.o(bArr, f24014i + j10);
    }

    public static long b(Field field) {
        return f24011f.a(field);
    }

    public static void c(long j10, byte b4) {
        f24011f.b(j10, b4);
    }

    public static void d(Object obj, long j10, byte b4) {
        long j11 = (-4) & j10;
        int H = H(obj, j11);
        int i10 = ((~((int) j10)) & 3) << 3;
        g(obj, j11, ((255 & b4) << i10) | (H & (~(255 << i10))));
    }

    public static void e(Object obj, long j10, double d10) {
        f24011f.c(obj, j10, d10);
    }

    public static void f(Object obj, long j10, float f10) {
        f24011f.d(obj, j10, f10);
    }

    public static void g(Object obj, long j10, int i10) {
        f24011f.e(obj, j10, i10);
    }

    public static void h(Object obj, long j10, long j11) {
        f24011f.f(obj, j10, j11);
    }

    public static void i(Object obj, long j10, Object obj2) {
        f24011f.f24030a.putObject(obj, j10, obj2);
    }

    public static void j(Object obj, long j10, boolean z10) {
        f24011f.g(obj, j10, z10);
    }

    public static void k(byte[] bArr, long j10, byte b4) {
        f24011f.i(bArr, f24014i + j10, b4);
    }

    public static void l(byte[] bArr, long j10, long j11, long j12) {
        f24011f.h(bArr, j10, j11, j12);
    }

    public static long n(Field field) {
        d dVar;
        if (field == null || (dVar = f24011f) == null) {
            return -1L;
        }
        return dVar.a(field);
    }

    public static long o(ByteBuffer byteBuffer) {
        return f24011f.k(byteBuffer, f24027v);
    }

    public static Field p(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void q(Object obj, long j10, byte b4) {
        long j11 = (-4) & j10;
        int i10 = (((int) j10) & 3) << 3;
        g(obj, j11, ((255 & b4) << i10) | (H(obj, j11) & (~(255 << i10))));
    }

    public static void r(Object obj, long j10, boolean z10) {
        d(obj, j10, z10 ? (byte) 1 : (byte) 0);
    }

    public static void t(Object obj, long j10, boolean z10) {
        q(obj, j10, z10 ? (byte) 1 : (byte) 0);
    }

    public static boolean x() {
        return f24013h;
    }

    public static boolean y() {
        return f24012g;
    }

    public static Unsafe z() {
        try {
            return (Unsafe) AccessController.doPrivileged(new q3());
        } catch (Throwable unused) {
            return null;
        }
    }
}
