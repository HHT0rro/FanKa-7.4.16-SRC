package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.x0;
import com.google.android.gms.internal.clearcut.x0.a;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class x0<MessageType extends x0<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends q<MessageType, BuilderType> {
    private static Map<Object, x0<?, ?>> zzjr = new ConcurrentHashMap();
    public j3 zzjp = j3.h();
    private int zzjq = -1;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static abstract class a<MessageType extends x0<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends r<MessageType, BuilderType> {

        /* renamed from: b, reason: collision with root package name */
        public final MessageType f24075b;

        /* renamed from: c, reason: collision with root package name */
        public MessageType f24076c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f24077d = false;

        public a(MessageType messagetype) {
            this.f24075b = messagetype;
            this.f24076c = (MessageType) messagetype.i(e.f24084d, null, null);
        }

        public static void j(MessageType messagetype, MessageType messagetype2) {
            m2.a().d(messagetype).e(messagetype, messagetype2);
        }

        @Override // com.google.android.gms.internal.clearcut.b2
        public final /* synthetic */ a2 E() {
            x0 x0Var = (x0) G();
            byte byteValue = ((Byte) x0Var.i(e.f24081a, null, null)).byteValue();
            boolean z10 = true;
            if (byteValue != 1) {
                if (byteValue == 0) {
                    z10 = false;
                } else {
                    z10 = m2.a().d(x0Var).d(x0Var);
                    x0Var.i(e.f24082b, z10 ? x0Var : null, null);
                }
            }
            if (z10) {
                return x0Var;
            }
            throw new zzew(x0Var);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            a aVar = (a) this.f24075b.i(e.f24085e, null, null);
            aVar.h((x0) G());
            return aVar;
        }

        @Override // com.google.android.gms.internal.clearcut.c2
        public final /* synthetic */ a2 d() {
            return this.f24075b;
        }

        @Override // com.google.android.gms.internal.clearcut.r
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public final BuilderType h(MessageType messagetype) {
            k();
            j(this.f24076c, messagetype);
            return this;
        }

        public void k() {
            if (this.f24077d) {
                MessageType messagetype = (MessageType) this.f24076c.i(e.f24084d, null, null);
                j(messagetype, this.f24076c);
                this.f24076c = messagetype;
                this.f24077d = false;
            }
        }

        @Override // com.google.android.gms.internal.clearcut.b2
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public MessageType G() {
            if (this.f24077d) {
                return this.f24076c;
            }
            MessageType messagetype = this.f24076c;
            m2.a().d(messagetype).a(messagetype);
            this.f24077d = true;
            return this.f24076c;
        }

        public final MessageType m() {
            MessageType messagetype = (MessageType) G();
            byte byteValue = ((Byte) messagetype.i(e.f24081a, null, null)).byteValue();
            boolean z10 = true;
            if (byteValue != 1) {
                if (byteValue == 0) {
                    z10 = false;
                } else {
                    z10 = m2.a().d(messagetype).d(messagetype);
                    messagetype.i(e.f24082b, z10 ? messagetype : null, null);
                }
            }
            if (z10) {
                return messagetype;
            }
            throw new zzew(messagetype);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class b<T extends x0<T, ?>> extends s<T> {

        /* renamed from: b, reason: collision with root package name */
        public T f24078b;

        public b(T t2) {
            this.f24078b = t2;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static abstract class c<MessageType extends c<MessageType, BuilderType>, BuilderType> extends x0<MessageType, BuilderType> implements c2 {
        public q0<d> zzjv = q0.k();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d implements t0<d> {

        /* renamed from: b, reason: collision with root package name */
        public final int f24079b;

        /* renamed from: c, reason: collision with root package name */
        public final zzfl f24080c;

        @Override // com.google.android.gms.internal.clearcut.t0
        public final boolean a0() {
            return false;
        }

        @Override // com.google.android.gms.internal.clearcut.t0
        public final zzfq b0() {
            return this.f24080c.zzek();
        }

        @Override // com.google.android.gms.internal.clearcut.t0
        public final boolean c0() {
            return false;
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            return this.f24079b - ((d) obj).f24079b;
        }

        @Override // com.google.android.gms.internal.clearcut.t0
        public final g2 d0(g2 g2Var, g2 g2Var2) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.clearcut.t0
        public final b2 e0(b2 b2Var, a2 a2Var) {
            return ((a) b2Var).h((x0) a2Var);
        }

        @Override // com.google.android.gms.internal.clearcut.t0
        public final zzfl f0() {
            return this.f24080c;
        }

        @Override // com.google.android.gms.internal.clearcut.t0
        public final int zzc() {
            return this.f24079b;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum e {

        /* renamed from: a, reason: collision with root package name */
        public static final int f24081a = 1;

        /* renamed from: b, reason: collision with root package name */
        public static final int f24082b = 2;

        /* renamed from: c, reason: collision with root package name */
        public static final int f24083c = 3;

        /* renamed from: d, reason: collision with root package name */
        public static final int f24084d = 4;

        /* renamed from: e, reason: collision with root package name */
        public static final int f24085e = 5;

        /* renamed from: f, reason: collision with root package name */
        public static final int f24086f = 6;

        /* renamed from: g, reason: collision with root package name */
        public static final int f24087g = 7;

        /* renamed from: i, reason: collision with root package name */
        public static final int f24089i = 1;

        /* renamed from: j, reason: collision with root package name */
        public static final int f24090j = 2;

        /* renamed from: l, reason: collision with root package name */
        public static final int f24092l = 1;

        /* renamed from: m, reason: collision with root package name */
        public static final int f24093m = 2;

        /* renamed from: h, reason: collision with root package name */
        public static final /* synthetic */ int[] f24088h = {1, 2, 3, 4, 5, 6, 7};

        /* renamed from: k, reason: collision with root package name */
        public static final /* synthetic */ int[] f24091k = {1, 2};

        /* renamed from: n, reason: collision with root package name */
        public static final /* synthetic */ int[] f24094n = {1, 2};

        public static int[] a() {
            return (int[]) f24088h.clone();
        }
    }

    public static <T extends x0<T, ?>> T h(T t2, byte[] bArr) throws zzco {
        T t10 = (T) t2.i(e.f24084d, null, null);
        try {
            m2.a().d(t10).c(t10, bArr, 0, bArr.length, new w());
            m2.a().d(t10).a(t10);
            if (t10.zzex == 0) {
                return t10;
            }
            throw new RuntimeException();
        } catch (IOException e2) {
            if (e2.getCause() instanceof zzco) {
                throw ((zzco) e2.getCause());
            }
            throw new zzco(e2.getMessage()).zzg(t10);
        } catch (IndexOutOfBoundsException unused) {
            throw zzco.zzbl().zzg(t10);
        }
    }

    public static Object j(a2 a2Var, String str, Object[] objArr) {
        return new o2(a2Var, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object k(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e10) {
            Throwable cause = e10.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static <T extends x0<?, ?>> void l(Class<T> cls, T t2) {
        zzjr.put(cls, t2);
    }

    public static <T extends x0<T, ?>> T m(T t2, byte[] bArr) throws zzco {
        T t10 = (T) h(t2, bArr);
        if (t10 != null) {
            byte byteValue = ((Byte) t10.i(e.f24081a, null, null)).byteValue();
            boolean z10 = true;
            if (byteValue != 1) {
                if (byteValue == 0) {
                    z10 = false;
                } else {
                    z10 = m2.a().d(t10).d(t10);
                    t10.i(e.f24082b, z10 ? t10 : null, null);
                }
            }
            if (!z10) {
                throw new zzco(new zzew(t10).getMessage()).zzg(t10);
            }
        }
        return t10;
    }

    public static <E> c1<E> n() {
        return n2.c();
    }

    public static <T extends x0<?, ?>> T o(Class<T> cls) {
        T t2 = (T) zzjr.get(cls);
        if (t2 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t2 = (T) zzjr.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (t2 != null) {
            return t2;
        }
        String name = cls.getName();
        throw new IllegalStateException(name.length() != 0 ? "Unable to get default instance for: ".concat(name) : new String("Unable to get default instance for: "));
    }

    @Override // com.google.android.gms.internal.clearcut.a2
    public final /* synthetic */ b2 a() {
        a aVar = (a) i(e.f24085e, null, null);
        aVar.h(this);
        return aVar;
    }

    @Override // com.google.android.gms.internal.clearcut.q
    public final void b(int i10) {
        this.zzjq = i10;
    }

    @Override // com.google.android.gms.internal.clearcut.a2
    public final /* synthetic */ b2 c() {
        return (a) i(e.f24085e, null, null);
    }

    @Override // com.google.android.gms.internal.clearcut.c2
    public final /* synthetic */ a2 d() {
        return (x0) i(e.f24086f, null, null);
    }

    @Override // com.google.android.gms.internal.clearcut.a2
    public final void e(zzbn zzbnVar) throws IOException {
        m2.a().b(getClass()).b(this, i0.a(zzbnVar));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (((x0) i(e.f24086f, null, null)).getClass().isInstance(obj)) {
            return m2.a().d(this).equals(this, (x0) obj);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.clearcut.q
    public final int f() {
        return this.zzjq;
    }

    @Override // com.google.android.gms.internal.clearcut.a2
    public final int g() {
        if (this.zzjq == -1) {
            this.zzjq = m2.a().d(this).f(this);
        }
        return this.zzjq;
    }

    public int hashCode() {
        int i10 = this.zzex;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = m2.a().d(this).hashCode(this);
        this.zzex = hashCode;
        return hashCode;
    }

    public abstract Object i(int i10, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.clearcut.c2
    public final boolean isInitialized() {
        byte byteValue = ((Byte) i(e.f24081a, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean d10 = m2.a().d(this).d(this);
        i(e.f24082b, d10 ? this : null, null);
        return d10;
    }

    public String toString() {
        return d2.a(this, super.toString());
    }
}
