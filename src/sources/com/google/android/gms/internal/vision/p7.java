package com.google.android.gms.internal.vision;

import android.view.textclassifier.TextClassifier;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class p7 {

    /* renamed from: a, reason: collision with root package name */
    public static final Unsafe f25586a;

    /* renamed from: b, reason: collision with root package name */
    public static final Class<?> f25587b;

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f25588c;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f25589d;

    /* renamed from: e, reason: collision with root package name */
    public static final d f25590e;

    /* renamed from: f, reason: collision with root package name */
    public static final boolean f25591f;

    /* renamed from: g, reason: collision with root package name */
    public static final boolean f25592g;

    /* renamed from: h, reason: collision with root package name */
    public static final long f25593h;

    /* renamed from: i, reason: collision with root package name */
    public static final long f25594i;

    /* renamed from: j, reason: collision with root package name */
    public static final long f25595j;

    /* renamed from: k, reason: collision with root package name */
    public static final long f25596k;

    /* renamed from: l, reason: collision with root package name */
    public static final long f25597l;

    /* renamed from: m, reason: collision with root package name */
    public static final long f25598m;

    /* renamed from: n, reason: collision with root package name */
    public static final long f25599n;

    /* renamed from: o, reason: collision with root package name */
    public static final long f25600o;

    /* renamed from: p, reason: collision with root package name */
    public static final long f25601p;

    /* renamed from: q, reason: collision with root package name */
    public static final long f25602q;

    /* renamed from: r, reason: collision with root package name */
    public static final long f25603r;

    /* renamed from: s, reason: collision with root package name */
    public static final long f25604s;

    /* renamed from: t, reason: collision with root package name */
    public static final long f25605t;

    /* renamed from: u, reason: collision with root package name */
    public static final long f25606u;

    /* renamed from: v, reason: collision with root package name */
    public static final int f25607v;

    /* renamed from: w, reason: collision with root package name */
    public static final boolean f25608w;

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends d {
        public a(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.vision.p7.d
        public final byte a(Object obj, long j10) {
            if (p7.f25608w) {
                return p7.L(obj, j10);
            }
            return p7.M(obj, j10);
        }

        @Override // com.google.android.gms.internal.vision.p7.d
        public final void b(Object obj, long j10, byte b4) {
            if (p7.f25608w) {
                p7.u(obj, j10, b4);
            } else {
                p7.y(obj, j10, b4);
            }
        }

        @Override // com.google.android.gms.internal.vision.p7.d
        public final void c(Object obj, long j10, double d10) {
            f(obj, j10, Double.doubleToLongBits(d10));
        }

        @Override // com.google.android.gms.internal.vision.p7.d
        public final void d(Object obj, long j10, float f10) {
            e(obj, j10, Float.floatToIntBits(f10));
        }

        @Override // com.google.android.gms.internal.vision.p7.d
        public final void g(Object obj, long j10, boolean z10) {
            if (p7.f25608w) {
                p7.z(obj, j10, z10);
            } else {
                p7.D(obj, j10, z10);
            }
        }

        @Override // com.google.android.gms.internal.vision.p7.d
        public final boolean h(Object obj, long j10) {
            if (p7.f25608w) {
                return p7.N(obj, j10);
            }
            return p7.O(obj, j10);
        }

        @Override // com.google.android.gms.internal.vision.p7.d
        public final float i(Object obj, long j10) {
            return Float.intBitsToFloat(k(obj, j10));
        }

        @Override // com.google.android.gms.internal.vision.p7.d
        public final double j(Object obj, long j10) {
            return Double.longBitsToDouble(l(obj, j10));
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b extends d {
        public b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.vision.p7.d
        public final byte a(Object obj, long j10) {
            return this.f25609a.getByte(obj, j10);
        }

        @Override // com.google.android.gms.internal.vision.p7.d
        public final void b(Object obj, long j10, byte b4) {
            this.f25609a.putByte(obj, j10, b4);
        }

        @Override // com.google.android.gms.internal.vision.p7.d
        public final void c(Object obj, long j10, double d10) {
            this.f25609a.putDouble(obj, j10, d10);
        }

        @Override // com.google.android.gms.internal.vision.p7.d
        public final void d(Object obj, long j10, float f10) {
            this.f25609a.putFloat(obj, j10, f10);
        }

        @Override // com.google.android.gms.internal.vision.p7.d
        public final void g(Object obj, long j10, boolean z10) {
            this.f25609a.putBoolean(obj, j10, z10);
        }

        @Override // com.google.android.gms.internal.vision.p7.d
        public final boolean h(Object obj, long j10) {
            return this.f25609a.getBoolean(obj, j10);
        }

        @Override // com.google.android.gms.internal.vision.p7.d
        public final float i(Object obj, long j10) {
            return this.f25609a.getFloat(obj, j10);
        }

        @Override // com.google.android.gms.internal.vision.p7.d
        public final double j(Object obj, long j10) {
            return this.f25609a.getDouble(obj, j10);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c extends d {
        public c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.vision.p7.d
        public final byte a(Object obj, long j10) {
            if (p7.f25608w) {
                return p7.L(obj, j10);
            }
            return p7.M(obj, j10);
        }

        @Override // com.google.android.gms.internal.vision.p7.d
        public final void b(Object obj, long j10, byte b4) {
            if (p7.f25608w) {
                p7.u(obj, j10, b4);
            } else {
                p7.y(obj, j10, b4);
            }
        }

        @Override // com.google.android.gms.internal.vision.p7.d
        public final void c(Object obj, long j10, double d10) {
            f(obj, j10, Double.doubleToLongBits(d10));
        }

        @Override // com.google.android.gms.internal.vision.p7.d
        public final void d(Object obj, long j10, float f10) {
            e(obj, j10, Float.floatToIntBits(f10));
        }

        @Override // com.google.android.gms.internal.vision.p7.d
        public final void g(Object obj, long j10, boolean z10) {
            if (p7.f25608w) {
                p7.z(obj, j10, z10);
            } else {
                p7.D(obj, j10, z10);
            }
        }

        @Override // com.google.android.gms.internal.vision.p7.d
        public final boolean h(Object obj, long j10) {
            if (p7.f25608w) {
                return p7.N(obj, j10);
            }
            return p7.O(obj, j10);
        }

        @Override // com.google.android.gms.internal.vision.p7.d
        public final float i(Object obj, long j10) {
            return Float.intBitsToFloat(k(obj, j10));
        }

        @Override // com.google.android.gms.internal.vision.p7.d
        public final double j(Object obj, long j10) {
            return Double.longBitsToDouble(l(obj, j10));
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static abstract class d {

        /* renamed from: a, reason: collision with root package name */
        public Unsafe f25609a;

        public d(Unsafe unsafe) {
            this.f25609a = unsafe;
        }

        public abstract byte a(Object obj, long j10);

        public abstract void b(Object obj, long j10, byte b4);

        public abstract void c(Object obj, long j10, double d10);

        public abstract void d(Object obj, long j10, float f10);

        public final void e(Object obj, long j10, int i10) {
            this.f25609a.putInt(obj, j10, i10);
        }

        public final void f(Object obj, long j10, long j11) {
            this.f25609a.putLong(obj, j10, j11);
        }

        public abstract void g(Object obj, long j10, boolean z10);

        public abstract boolean h(Object obj, long j10);

        public abstract float i(Object obj, long j10);

        public abstract double j(Object obj, long j10);

        public final int k(Object obj, long j10) {
            return this.f25609a.getInt(obj, j10);
        }

        public final long l(Object obj, long j10) {
            return this.f25609a.getLong(obj, j10);
        }
    }

    static {
        Unsafe t2 = t();
        f25586a = t2;
        f25587b = o3.c();
        boolean B = B(Long.TYPE);
        f25588c = B;
        boolean B2 = B(Integer.TYPE);
        f25589d = B2;
        d dVar = null;
        if (t2 != null) {
            if (!o3.b()) {
                dVar = new b(t2);
            } else if (B) {
                dVar = new c(t2);
            } else if (B2) {
                dVar = new a(t2);
            }
        }
        f25590e = dVar;
        f25591f = E();
        f25592g = A();
        long n10 = n(byte[].class);
        f25593h = n10;
        f25594i = n(boolean[].class);
        f25595j = s(boolean[].class);
        f25596k = n(int[].class);
        f25597l = s(int[].class);
        f25598m = n(long[].class);
        f25599n = s(long[].class);
        f25600o = n(float[].class);
        f25601p = s(float[].class);
        f25602q = n(double[].class);
        f25603r = s(double[].class);
        f25604s = n(Object[].class);
        f25605t = s(Object[].class);
        Field G = G();
        f25606u = (G == null || dVar == null) ? -1L : dVar.f25609a.objectFieldOffset(G);
        f25607v = (int) (7 & n10);
        f25608w = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static boolean A() {
        Unsafe unsafe = f25586a;
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
            if (o3.b()) {
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
            Logger logger = Logger.getLogger(p7.class.getName());
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 71);
            sb2.append("platform method missing - proto runtime falling back to safer methods: ");
            sb2.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb2.toString());
            return false;
        }
    }

    public static boolean B(Class<?> cls) {
        if (!o3.b()) {
            return false;
        }
        try {
            Class<?> cls2 = f25587b;
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

    public static double C(Object obj, long j10) {
        return f25590e.j(obj, j10);
    }

    public static void D(Object obj, long j10, boolean z10) {
        y(obj, j10, z10 ? (byte) 1 : (byte) 0);
    }

    public static boolean E() {
        Unsafe unsafe = f25586a;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            Class<Long> cls2 = Long.TYPE;
            cls.getMethod("getLong", Object.class, cls2);
            if (G() == null) {
                return false;
            }
            if (o3.b()) {
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
            Logger logger = Logger.getLogger(p7.class.getName());
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 71);
            sb2.append("platform method missing - proto runtime falling back to safer methods: ");
            sb2.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb2.toString());
            return false;
        }
    }

    public static Object F(Object obj, long j10) {
        return f25590e.f25609a.getObject(obj, j10);
    }

    public static Field G() {
        Field d10;
        if (o3.b() && (d10 = d(Buffer.class, "effectiveDirectAddress")) != null) {
            return d10;
        }
        Field d11 = d(Buffer.class, TextClassifier.TYPE_ADDRESS);
        if (d11 == null || d11.getType() != Long.TYPE) {
            return null;
        }
        return d11;
    }

    public static byte L(Object obj, long j10) {
        return (byte) (b(obj, (-4) & j10) >>> ((int) (((~j10) & 3) << 3)));
    }

    public static byte M(Object obj, long j10) {
        return (byte) (b(obj, (-4) & j10) >>> ((int) ((j10 & 3) << 3)));
    }

    public static boolean N(Object obj, long j10) {
        return L(obj, j10) != 0;
    }

    public static boolean O(Object obj, long j10) {
        return M(obj, j10) != 0;
    }

    public static byte a(byte[] bArr, long j10) {
        return f25590e.a(bArr, f25593h + j10);
    }

    public static int b(Object obj, long j10) {
        return f25590e.k(obj, j10);
    }

    public static <T> T c(Class<T> cls) {
        try {
            return (T) f25586a.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static Field d(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void f(Object obj, long j10, double d10) {
        f25590e.c(obj, j10, d10);
    }

    public static void g(Object obj, long j10, float f10) {
        f25590e.d(obj, j10, f10);
    }

    public static void h(Object obj, long j10, int i10) {
        f25590e.e(obj, j10, i10);
    }

    public static void i(Object obj, long j10, long j11) {
        f25590e.f(obj, j10, j11);
    }

    public static void j(Object obj, long j10, Object obj2) {
        f25590e.f25609a.putObject(obj, j10, obj2);
    }

    public static void k(Object obj, long j10, boolean z10) {
        f25590e.g(obj, j10, z10);
    }

    public static void l(byte[] bArr, long j10, byte b4) {
        f25590e.b(bArr, f25593h + j10, b4);
    }

    public static boolean m() {
        return f25592g;
    }

    public static int n(Class<?> cls) {
        if (f25592g) {
            return f25590e.f25609a.arrayBaseOffset(cls);
        }
        return -1;
    }

    public static long o(Object obj, long j10) {
        return f25590e.l(obj, j10);
    }

    public static boolean r() {
        return f25591f;
    }

    public static int s(Class<?> cls) {
        if (f25592g) {
            return f25590e.f25609a.arrayIndexScale(cls);
        }
        return -1;
    }

    public static Unsafe t() {
        try {
            return (Unsafe) AccessController.doPrivileged(new r7());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void u(Object obj, long j10, byte b4) {
        long j11 = (-4) & j10;
        int b10 = b(obj, j11);
        int i10 = ((~((int) j10)) & 3) << 3;
        h(obj, j11, ((255 & b4) << i10) | (b10 & (~(255 << i10))));
    }

    public static boolean w(Object obj, long j10) {
        return f25590e.h(obj, j10);
    }

    public static float x(Object obj, long j10) {
        return f25590e.i(obj, j10);
    }

    public static void y(Object obj, long j10, byte b4) {
        long j11 = (-4) & j10;
        int i10 = (((int) j10) & 3) << 3;
        h(obj, j11, ((255 & b4) << i10) | (b(obj, j11) & (~(255 << i10))));
    }

    public static void z(Object obj, long j10, boolean z10) {
        u(obj, j10, z10 ? (byte) 1 : (byte) 0);
    }
}
