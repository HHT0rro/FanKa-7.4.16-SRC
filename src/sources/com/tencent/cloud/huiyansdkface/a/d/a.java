package com.tencent.cloud.huiyansdkface.a.d;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static c f40411a = null;

    /* renamed from: b, reason: collision with root package name */
    private static int f40412b = 6;

    /* renamed from: c, reason: collision with root package name */
    private static b f40413c = new b() { // from class: com.tencent.cloud.huiyansdkface.a.d.a.1
        @Override // com.tencent.cloud.huiyansdkface.a.d.a.b
        public void a(boolean z10, Throwable th) {
            if (th == null || z10) {
                return;
            }
            th.printStackTrace();
        }
    };

    /* renamed from: d, reason: collision with root package name */
    private static C0614a f40414d = new C0614a();

    /* renamed from: com.tencent.cloud.huiyansdkface.a.d.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class C0614a {
        private C0614a() {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface b {
        void a(boolean z10, Throwable th);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static abstract class c {
        public void a(int i10, String str, Throwable th, String str2, Object... objArr) {
            switch (i10) {
                case 2:
                    a(str, th, str2, objArr);
                    return;
                case 3:
                    b(str, th, str2, objArr);
                    return;
                case 4:
                    c(str, th, str2, objArr);
                    return;
                case 5:
                    d(str, th, str2, objArr);
                    return;
                case 6:
                    e(str, th, str2, objArr);
                    return;
                case 7:
                    f(str, th, str2, objArr);
                    return;
                default:
                    return;
            }
        }

        public abstract void a(String str, Throwable th, String str2, Object... objArr);

        public abstract void b(String str, Throwable th, String str2, Object... objArr);

        public abstract void c(String str, Throwable th, String str2, Object... objArr);

        public abstract void d(String str, Throwable th, String str2, Object... objArr);

        public abstract void e(String str, Throwable th, String str2, Object... objArr);

        public void f(String str, Throwable th, String str2, Object... objArr) {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static abstract class d extends c {
    }

    static {
        a();
    }

    private static String a(String str) {
        if (str == null) {
            return "WeCamera";
        }
        return "WeCamera-" + str;
    }

    public static void a() {
        f40412b = 10;
    }

    public static void a(c cVar) {
        f40411a = cVar;
    }

    public static void a(d dVar) {
        f40411a = dVar;
    }

    public static void a(String str, String str2, Object... objArr) {
        a(str, null, str2, objArr);
    }

    public static void a(String str, Throwable th, String str2, Object... objArr) {
        String a10 = a(str);
        c cVar = f40411a;
        if (cVar != null) {
            cVar.a(3, a10, th, str2, objArr);
        } else if (f40412b <= 3) {
            if (objArr.length > 0) {
                String.format(str2, objArr);
            }
            a(true, th);
        }
    }

    private static void a(boolean z10, Throwable th) {
        b bVar = f40413c;
        if (bVar == null || th == null) {
            return;
        }
        bVar.a(z10, th);
    }

    public static void b(String str, String str2, Object... objArr) {
        b(str, null, str2, objArr);
    }

    public static void b(String str, Throwable th, String str2, Object... objArr) {
        String a10 = a(str);
        c cVar = f40411a;
        if (cVar != null) {
            cVar.a(4, a10, th, str2, objArr);
        } else if (f40412b <= 4) {
            if (objArr.length > 0) {
                String.format(str2, objArr);
            }
            a(true, th);
        }
    }

    public static void c(String str, String str2, Object... objArr) {
        c(str, null, str2, objArr);
    }

    public static void c(String str, Throwable th, String str2, Object... objArr) {
        String a10 = a(str);
        c cVar = f40411a;
        if (cVar != null) {
            cVar.a(5, a10, th, str2, objArr);
        } else if (f40412b <= 5) {
            if (objArr.length > 0) {
                String.format(str2, objArr);
            }
            a(true, th);
        }
    }

    public static void d(String str, Throwable th, String str2, Object... objArr) {
        String a10 = a(str);
        c cVar = f40411a;
        if (cVar != null) {
            cVar.a(6, a10, th, str2, objArr);
        } else if (f40412b <= 6) {
            if (objArr.length > 0) {
                String.format(str2, objArr);
            }
            a(true, th);
        }
    }
}
