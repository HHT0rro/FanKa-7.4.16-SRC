package com.google.common.base;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/* compiled from: MoreObjects.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class j {

    /* compiled from: MoreObjects.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f25968a;

        /* renamed from: b, reason: collision with root package name */
        public final C0224b f25969b;

        /* renamed from: c, reason: collision with root package name */
        public C0224b f25970c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f25971d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f25972e;

        /* compiled from: MoreObjects.java */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static final class a extends C0224b {
            public a() {
                super();
            }
        }

        /* compiled from: MoreObjects.java */
        /* renamed from: com.google.common.base.j$b$b, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static class C0224b {

            /* renamed from: a, reason: collision with root package name */
            public String f25973a;

            /* renamed from: b, reason: collision with root package name */
            public Object f25974b;

            /* renamed from: c, reason: collision with root package name */
            public C0224b f25975c;

            public C0224b() {
            }
        }

        public static boolean l(Object obj) {
            if (obj instanceof CharSequence) {
                return ((CharSequence) obj).length() == 0;
            }
            if (obj instanceof Collection) {
                return ((Collection) obj).isEmpty();
            }
            if (obj instanceof Map) {
                return ((Map) obj).isEmpty();
            }
            if (obj instanceof Optional) {
                return !((Optional) obj).isPresent();
            }
            return obj.getClass().isArray() && Array.getLength(obj) == 0;
        }

        public b a(String str, double d10) {
            return j(str, String.valueOf(d10));
        }

        public b b(String str, int i10) {
            return j(str, String.valueOf(i10));
        }

        public b c(String str, long j10) {
            return j(str, String.valueOf(j10));
        }

        public b d(String str, Object obj) {
            return h(str, obj);
        }

        public b e(String str, boolean z10) {
            return j(str, String.valueOf(z10));
        }

        public final C0224b f() {
            C0224b c0224b = new C0224b();
            this.f25970c.f25975c = c0224b;
            this.f25970c = c0224b;
            return c0224b;
        }

        public final b g(Object obj) {
            f().f25974b = obj;
            return this;
        }

        public final b h(String str, Object obj) {
            C0224b f10 = f();
            f10.f25974b = obj;
            f10.f25973a = (String) o.r(str);
            return this;
        }

        public final a i() {
            a aVar = new a();
            this.f25970c.f25975c = aVar;
            this.f25970c = aVar;
            return aVar;
        }

        public final b j(String str, Object obj) {
            a i10 = i();
            i10.f25974b = obj;
            i10.f25973a = (String) o.r(str);
            return this;
        }

        public b k(Object obj) {
            return g(obj);
        }

        public b m() {
            this.f25971d = true;
            return this;
        }

        public String toString() {
            boolean z10 = this.f25971d;
            boolean z11 = this.f25972e;
            StringBuilder sb2 = new StringBuilder(32);
            sb2.append(this.f25968a);
            sb2.append('{');
            String str = "";
            for (C0224b c0224b = this.f25969b.f25975c; c0224b != null; c0224b = c0224b.f25975c) {
                Object obj = c0224b.f25974b;
                if (!(c0224b instanceof a)) {
                    if (obj == null) {
                        if (z10) {
                        }
                    } else if (z11 && l(obj)) {
                    }
                }
                sb2.append(str);
                String str2 = c0224b.f25973a;
                if (str2 != null) {
                    sb2.append(str2);
                    sb2.append('=');
                }
                if (obj != null && obj.getClass().isArray()) {
                    String deepToString = Arrays.deepToString(new Object[]{obj});
                    sb2.append((CharSequence) deepToString, 1, deepToString.length() - 1);
                } else {
                    sb2.append(obj);
                }
                str = ", ";
            }
            sb2.append('}');
            return sb2.toString();
        }

        public b(String str) {
            C0224b c0224b = new C0224b();
            this.f25969b = c0224b;
            this.f25970c = c0224b;
            this.f25971d = false;
            this.f25972e = false;
            this.f25968a = (String) o.r(str);
        }
    }

    public static <T> T a(T t2, T t10) {
        if (t2 != null) {
            return t2;
        }
        Objects.requireNonNull(t10, "Both parameters are null");
        return t10;
    }

    public static b b(Class<?> cls) {
        return new b(cls.getSimpleName());
    }

    public static b c(Object obj) {
        return new b(obj.getClass().getSimpleName());
    }
}
