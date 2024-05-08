package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.x4;
import com.google.android.gms.internal.vision.x4.b;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class x4<MessageType extends x4<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> extends l3<MessageType, BuilderType> {
    private static Map<Object, x4<?, ?>> zzd = new ConcurrentHashMap();
    public m7 zzb = m7.a();
    private int zzc = -1;

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class a<T extends x4<T, ?>> extends m3<T> {

        /* renamed from: b, reason: collision with root package name */
        public final T f25675b;

        public a(T t2) {
            this.f25675b = t2;
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static abstract class b<MessageType extends x4<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> extends k3<MessageType, BuilderType> {

        /* renamed from: b, reason: collision with root package name */
        public final MessageType f25676b;

        /* renamed from: c, reason: collision with root package name */
        public MessageType f25677c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f25678d = false;

        public b(MessageType messagetype) {
            this.f25676b = messagetype;
            this.f25677c = (MessageType) messagetype.n(g.f25691d, null, null);
        }

        public static void g(MessageType messagetype, MessageType messagetype2) {
            p6.a().c(messagetype).e(messagetype, messagetype2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            b bVar = (b) this.f25676b.n(g.f25692e, null, null);
            bVar.c((x4) zze());
            return bVar;
        }

        @Override // com.google.android.gms.internal.vision.k3
        public final /* synthetic */ k3 d(byte[] bArr, int i10, int i11, l4 l4Var) throws zzjk {
            return h(bArr, 0, i11, l4Var);
        }

        @Override // com.google.android.gms.internal.vision.k3
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public final BuilderType c(MessageType messagetype) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            g(this.f25677c, messagetype);
            return this;
        }

        public final BuilderType h(byte[] bArr, int i10, int i11, l4 l4Var) throws zzjk {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            try {
                p6.a().c(this.f25677c).g(this.f25677c, bArr, 0, i11, new s3(l4Var));
                return this;
            } catch (zzjk e2) {
                throw e2;
            } catch (IOException e10) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e10);
            } catch (IndexOutOfBoundsException unused) {
                throw zzjk.zza();
            }
        }

        public void i() {
            MessageType messagetype = (MessageType) this.f25677c.n(g.f25691d, null, null);
            g(messagetype, this.f25677c);
            this.f25677c = messagetype;
        }

        @Override // com.google.android.gms.internal.vision.f6
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public MessageType zze() {
            if (this.f25678d) {
                return this.f25677c;
            }
            MessageType messagetype = this.f25677c;
            p6.a().c(messagetype).a(messagetype);
            this.f25678d = true;
            return this.f25677c;
        }

        @Override // com.google.android.gms.internal.vision.f6
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public final MessageType zzf() {
            MessageType messagetype = (MessageType) zze();
            if (messagetype.zzk()) {
                return messagetype;
            }
            throw new zzlv(messagetype);
        }

        @Override // com.google.android.gms.internal.vision.e6
        public final /* synthetic */ c6 zzr() {
            return this.f25676b;
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static abstract class c<MessageType extends c<MessageType, BuilderType>, BuilderType extends d<MessageType, BuilderType>> extends x4<MessageType, BuilderType> implements e6 {
        public r4<f> zzc = r4.c();

        public final r4<f> x() {
            if (this.zzc.n()) {
                this.zzc = (r4) this.zzc.clone();
            }
            return this.zzc;
        }

        /* JADX WARN: Type inference failed for: r1v6, types: [Type, java.util.List, java.util.ArrayList] */
        public final <Type> Type y(j4<MessageType, Type> j4Var) {
            e s2 = x4.s(j4Var);
            if (s2.f25679a == ((x4) zzr())) {
                Type type = (Type) this.zzc.d(s2.f25682d);
                if (type == null) {
                    return s2.f25680b;
                }
                f fVar = s2.f25682d;
                if (fVar.f25686e) {
                    if (fVar.f25685d.zza() != zzmo.ENUM) {
                        return type;
                    }
                    ?? r12 = (Type) new ArrayList();
                    Iterator iterator2 = ((List) type).iterator2();
                    while (iterator2.hasNext()) {
                        r12.add(s2.a(iterator2.next()));
                    }
                    return r12;
                }
                return (Type) s2.a(type);
            }
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static abstract class d<MessageType extends c<MessageType, BuilderType>, BuilderType extends d<MessageType, BuilderType>> extends b<MessageType, BuilderType> implements e6 {
        public d(MessageType messagetype) {
            super(messagetype);
        }

        @Override // com.google.android.gms.internal.vision.x4.b
        public void i() {
            super.i();
            MessageType messagetype = this.f25677c;
            ((c) messagetype).zzc = (r4) ((c) messagetype).zzc.clone();
        }

        @Override // com.google.android.gms.internal.vision.x4.b
        /* renamed from: j */
        public /* synthetic */ x4 zze() {
            return (c) zze();
        }

        @Override // com.google.android.gms.internal.vision.x4.b, com.google.android.gms.internal.vision.f6
        public /* synthetic */ c6 zze() {
            if (this.f25678d) {
                return (c) this.f25677c;
            }
            ((c) this.f25677c).zzc.i();
            return (c) super.zze();
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class e<ContainingType extends c6, Type> extends j4<ContainingType, Type> {

        /* renamed from: a, reason: collision with root package name */
        public final ContainingType f25679a;

        /* renamed from: b, reason: collision with root package name */
        public final Type f25680b;

        /* renamed from: c, reason: collision with root package name */
        public final c6 f25681c;

        /* renamed from: d, reason: collision with root package name */
        public final f f25682d;

        public e(ContainingType containingtype, Type type, c6 c6Var, f fVar, Class cls) {
            if (containingtype != null) {
                if (fVar.f25685d == zzml.zzk && c6Var == null) {
                    throw new IllegalArgumentException("Null messageDefaultInstance");
                }
                this.f25679a = containingtype;
                this.f25680b = type;
                this.f25681c = c6Var;
                this.f25682d = fVar;
                return;
            }
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }

        public final Object a(Object obj) {
            if (this.f25682d.f25685d.zza() != zzmo.ENUM) {
                return obj;
            }
            ((Integer) obj).intValue();
            throw null;
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class f implements s4<f> {

        /* renamed from: d, reason: collision with root package name */
        public final zzml f25685d;

        /* renamed from: b, reason: collision with root package name */
        public final d5<?> f25683b = null;

        /* renamed from: c, reason: collision with root package name */
        public final int f25684c = 202056002;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f25686e = true;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f25687f = false;

        public f(d5<?> d5Var, int i10, zzml zzmlVar, boolean z10, boolean z11) {
            this.f25685d = zzmlVar;
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            return this.f25684c - ((f) obj).f25684c;
        }

        @Override // com.google.android.gms.internal.vision.s4
        public final k6 d(k6 k6Var, k6 k6Var2) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.vision.s4
        public final f6 e(f6 f6Var, c6 c6Var) {
            return ((b) f6Var).c((x4) c6Var);
        }

        @Override // com.google.android.gms.internal.vision.s4
        public final int zza() {
            return this.f25684c;
        }

        @Override // com.google.android.gms.internal.vision.s4
        public final zzml zzb() {
            return this.f25685d;
        }

        @Override // com.google.android.gms.internal.vision.s4
        public final zzmo zzc() {
            return this.f25685d.zza();
        }

        @Override // com.google.android.gms.internal.vision.s4
        public final boolean zzd() {
            return this.f25686e;
        }

        @Override // com.google.android.gms.internal.vision.s4
        public final boolean zze() {
            return false;
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum g {

        /* renamed from: a, reason: collision with root package name */
        public static final int f25688a = 1;

        /* renamed from: b, reason: collision with root package name */
        public static final int f25689b = 2;

        /* renamed from: c, reason: collision with root package name */
        public static final int f25690c = 3;

        /* renamed from: d, reason: collision with root package name */
        public static final int f25691d = 4;

        /* renamed from: e, reason: collision with root package name */
        public static final int f25692e = 5;

        /* renamed from: f, reason: collision with root package name */
        public static final int f25693f = 6;

        /* renamed from: g, reason: collision with root package name */
        public static final int f25694g = 7;

        /* renamed from: h, reason: collision with root package name */
        public static final /* synthetic */ int[] f25695h = {1, 2, 3, 4, 5, 6, 7};

        public static int[] a() {
            return (int[]) f25695h.clone();
        }
    }

    public static <ContainingType extends c6, Type> e<ContainingType, Type> h(ContainingType containingtype, c6 c6Var, d5<?> d5Var, int i10, zzml zzmlVar, boolean z10, Class cls) {
        return new e<>(containingtype, Collections.emptyList(), c6Var, new f(null, 202056002, zzmlVar, true, false), cls);
    }

    public static <T extends x4<T, ?>> T i(T t2) throws zzjk {
        if (t2 == null || t2.zzk()) {
            return t2;
        }
        throw new zzjk(new zzlv(t2).getMessage()).zza(t2);
    }

    public static <T extends x4<T, ?>> T j(T t2, byte[] bArr, int i10, int i11, l4 l4Var) throws zzjk {
        T t10 = (T) t2.n(g.f25691d, null, null);
        try {
            t6 c4 = p6.a().c(t10);
            c4.g(t10, bArr, 0, i11, new s3(l4Var));
            c4.a(t10);
            if (t10.zza == 0) {
                return t10;
            }
            throw new RuntimeException();
        } catch (IOException e2) {
            if (e2.getCause() instanceof zzjk) {
                throw ((zzjk) e2.getCause());
            }
            throw new zzjk(e2.getMessage()).zza(t10);
        } catch (IndexOutOfBoundsException unused) {
            throw zzjk.zza().zza(t10);
        }
    }

    public static <T extends x4<T, ?>> T k(T t2, byte[] bArr, l4 l4Var) throws zzjk {
        return (T) i(j(t2, bArr, 0, bArr.length, l4Var));
    }

    public static <T extends x4<?, ?>> T l(Class<T> cls) {
        x4<?, ?> x4Var = zzd.get(cls);
        if (x4Var == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                x4Var = zzd.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (x4Var == null) {
            x4Var = (T) ((x4) p7.c(cls)).n(g.f25693f, null, null);
            if (x4Var != null) {
                zzd.put(cls, x4Var);
            } else {
                throw new IllegalStateException();
            }
        }
        return (T) x4Var;
    }

    public static <E> g5<E> m(g5<E> g5Var) {
        int size = g5Var.size();
        return g5Var.zza(size == 0 ? 10 : size << 1);
    }

    public static Object o(c6 c6Var, String str, Object[] objArr) {
        return new r6(c6Var, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object p(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e10) {
            Throwable cause = e10.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    public static <T extends x4<?, ?>> void q(Class<T> cls, T t2) {
        zzd.put(cls, t2);
    }

    public static final <T extends x4<T, ?>> boolean r(T t2, boolean z10) {
        byte byteValue = ((Byte) t2.n(g.f25688a, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean c4 = p6.a().c(t2).c(t2);
        if (z10) {
            t2.n(g.f25689b, c4 ? t2 : null, null);
        }
        return c4;
    }

    public static <MessageType extends c<MessageType, BuilderType>, BuilderType extends d<MessageType, BuilderType>, T> e<MessageType, T> s(j4<MessageType, T> j4Var) {
        return (e) j4Var;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.vision.f5, com.google.android.gms.internal.vision.z4] */
    public static f5 v() {
        return z4.g();
    }

    public static <E> g5<E> w() {
        return s6.g();
    }

    @Override // com.google.android.gms.internal.vision.c6
    public final void a(zzii zziiVar) throws IOException {
        p6.a().c(this).f(this, i4.N(zziiVar));
    }

    @Override // com.google.android.gms.internal.vision.l3
    public final void c(int i10) {
        this.zzc = i10;
    }

    @Override // com.google.android.gms.internal.vision.l3
    public final int e() {
        return this.zzc;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return p6.a().c(this).d(this, (x4) obj);
        }
        return false;
    }

    public int hashCode() {
        int i10 = this.zza;
        if (i10 != 0) {
            return i10;
        }
        int b4 = p6.a().c(this).b(this);
        this.zza = b4;
        return b4;
    }

    public abstract Object n(int i10, Object obj, Object obj2);

    public final <MessageType extends x4<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> BuilderType t() {
        return (BuilderType) n(g.f25692e, null, null);
    }

    public String toString() {
        return h6.a(this, super.toString());
    }

    public final BuilderType u() {
        BuilderType buildertype = (BuilderType) n(g.f25692e, null, null);
        buildertype.c(this);
        return buildertype;
    }

    @Override // com.google.android.gms.internal.vision.e6
    public final boolean zzk() {
        return r(this, true);
    }

    @Override // com.google.android.gms.internal.vision.c6
    public final int zzm() {
        if (this.zzc == -1) {
            this.zzc = p6.a().c(this).zzb(this);
        }
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.vision.c6
    public final /* synthetic */ f6 zzp() {
        b bVar = (b) n(g.f25692e, null, null);
        bVar.c(this);
        return bVar;
    }

    @Override // com.google.android.gms.internal.vision.c6
    public final /* synthetic */ f6 zzq() {
        return (b) n(g.f25692e, null, null);
    }

    @Override // com.google.android.gms.internal.vision.e6
    public final /* synthetic */ c6 zzr() {
        return (x4) n(g.f25693f, null, null);
    }
}
