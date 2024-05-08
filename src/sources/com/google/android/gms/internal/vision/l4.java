package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.x4;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class l4 {

    /* renamed from: b, reason: collision with root package name */
    public static volatile l4 f25530b;

    /* renamed from: c, reason: collision with root package name */
    public static volatile l4 f25531c;

    /* renamed from: d, reason: collision with root package name */
    public static final l4 f25532d = new l4(true);

    /* renamed from: a, reason: collision with root package name */
    public final Map<a, x4.e<?, ?>> f25533a;

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Object f25534a;

        /* renamed from: b, reason: collision with root package name */
        public final int f25535b;

        public a(Object obj, int i10) {
            this.f25534a = obj;
            this.f25535b = i10;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f25534a == aVar.f25534a && this.f25535b == aVar.f25535b;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.f25534a) * 65535) + this.f25535b;
        }
    }

    public l4() {
        this.f25533a = new HashMap();
    }

    public static l4 a() {
        return new l4();
    }

    public static l4 d() {
        l4 l4Var = f25530b;
        if (l4Var == null) {
            synchronized (l4.class) {
                l4Var = f25530b;
                if (l4Var == null) {
                    l4Var = f25532d;
                    f25530b = l4Var;
                }
            }
        }
        return l4Var;
    }

    public static l4 e() {
        l4 l4Var = f25531c;
        if (l4Var != null) {
            return l4Var;
        }
        synchronized (l4.class) {
            l4 l4Var2 = f25531c;
            if (l4Var2 != null) {
                return l4Var2;
            }
            l4 b4 = u4.b(l4.class);
            f25531c = b4;
            return b4;
        }
    }

    public final <ContainingType extends c6> x4.e<ContainingType, ?> b(ContainingType containingtype, int i10) {
        return (x4.e) this.f25533a.get(new a(containingtype, i10));
    }

    public final void c(x4.e<?, ?> eVar) {
        this.f25533a.put(new a(eVar.f25679a, eVar.f25682d.f25684c), eVar);
    }

    public l4(boolean z10) {
        this.f25533a = Collections.emptyMap();
    }
}
