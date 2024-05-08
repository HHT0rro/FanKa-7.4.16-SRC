package com.xiaomi.push;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class y implements x, InvocationHandler {

    /* renamed from: p, reason: collision with root package name */
    public static final String[][] f48483p = {new String[]{"com.bun.supplier.IIdentifierListener", "com.bun.supplier.IdSupplier"}, new String[]{"com.bun.miitmdid.core.IIdentifierListener", "com.bun.miitmdid.supplier.IdSupplier"}};

    /* renamed from: k, reason: collision with root package name */
    public Context f48493k;

    /* renamed from: b, reason: collision with root package name */
    public Class f48484b = null;

    /* renamed from: c, reason: collision with root package name */
    public Class f48485c = null;

    /* renamed from: d, reason: collision with root package name */
    public Method f48486d = null;

    /* renamed from: e, reason: collision with root package name */
    public Method f48487e = null;

    /* renamed from: f, reason: collision with root package name */
    public Method f48488f = null;

    /* renamed from: g, reason: collision with root package name */
    public Method f48489g = null;

    /* renamed from: h, reason: collision with root package name */
    public Method f48490h = null;

    /* renamed from: i, reason: collision with root package name */
    public Method f48491i = null;

    /* renamed from: j, reason: collision with root package name */
    public Method f48492j = null;

    /* renamed from: l, reason: collision with root package name */
    public final Object f48494l = new Object();

    /* renamed from: m, reason: collision with root package name */
    public volatile int f48495m = 0;

    /* renamed from: n, reason: collision with root package name */
    public volatile long f48496n = 0;

    /* renamed from: o, reason: collision with root package name */
    public volatile a f48497o = null;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public Boolean f48498a;

        /* renamed from: b, reason: collision with root package name */
        public String f48499b;

        /* renamed from: c, reason: collision with root package name */
        public String f48500c;

        /* renamed from: d, reason: collision with root package name */
        public String f48501d;

        /* renamed from: e, reason: collision with root package name */
        public String f48502e;

        public a() {
            this.f48498a = null;
            this.f48499b = null;
            this.f48500c = null;
            this.f48501d = null;
            this.f48502e = null;
        }

        public boolean a() {
            if (!TextUtils.isEmpty(this.f48499b) || !TextUtils.isEmpty(this.f48500c) || !TextUtils.isEmpty(this.f48501d) || !TextUtils.isEmpty(this.f48502e)) {
                this.f48498a = Boolean.TRUE;
            }
            return this.f48498a != null;
        }
    }

    public y(Context context) {
        this.f48493k = context.getApplicationContext();
        f(context);
        i(context);
    }

    public static Class<?> a(Context context, String str) {
        try {
            return n7.c(context, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static <T> T b(Method method, Object obj, Object... objArr) {
        if (method == null) {
            return null;
        }
        try {
            T t2 = (T) method.invoke(obj, objArr);
            if (t2 != null) {
                return t2;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method c(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod(str, clsArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean h(Object obj) {
        return (obj instanceof Boolean) || (obj instanceof Character) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Double);
    }

    public static void j(String str) {
        fc.c.i("mdid:" + str);
    }

    @Override // com.xiaomi.push.x
    public String a() {
        g("getUDID");
        if (this.f48497o == null) {
            return null;
        }
        return this.f48497o.f48499b;
    }

    @Override // com.xiaomi.push.x
    /* renamed from: a */
    public boolean mo2931a() {
        g("isSupported");
        return this.f48497o != null && Boolean.TRUE.equals(this.f48497o.f48498a);
    }

    @Override // com.xiaomi.push.x
    public String b() {
        g("getOAID");
        if (this.f48497o == null) {
            return null;
        }
        return this.f48497o.f48500c;
    }

    @Override // com.xiaomi.push.x
    public String c() {
        g("getVAID");
        if (this.f48497o == null) {
            return null;
        }
        return this.f48497o.f48501d;
    }

    @Override // com.xiaomi.push.x
    public String d() {
        g("getAAID");
        if (this.f48497o == null) {
            return null;
        }
        return this.f48497o.f48502e;
    }

    public final void e() {
        synchronized (this.f48494l) {
            try {
                this.f48494l.notifyAll();
            } catch (Exception unused) {
            }
        }
    }

    public final void f(Context context) {
        Class<?> a10 = a(context, "com.bun.miitmdid.core.MdidSdk");
        Class<?> cls = null;
        Class<?> cls2 = null;
        int i10 = 0;
        while (true) {
            String[][] strArr = f48483p;
            if (i10 >= strArr.length) {
                break;
            }
            String[] strArr2 = strArr[i10];
            Class<?> a11 = a(context, strArr2[0]);
            Class<?> a12 = a(context, strArr2[1]);
            if (a11 != null && a12 != null) {
                j("found class in index " + i10);
                cls2 = a12;
                cls = a11;
                break;
            }
            i10++;
            cls2 = a12;
            cls = a11;
        }
        this.f48484b = a10;
        this.f48486d = c(a10, "InitSdk", Context.class, cls);
        this.f48485c = cls;
        this.f48487e = c(cls2, "getUDID", new Class[0]);
        this.f48488f = c(cls2, "getOAID", new Class[0]);
        this.f48489g = c(cls2, "getVAID", new Class[0]);
        this.f48490h = c(cls2, "getAAID", new Class[0]);
        this.f48491i = c(cls2, "isSupported", new Class[0]);
        this.f48492j = c(cls2, "shutDown", new Class[0]);
    }

    public final void g(String str) {
        if (this.f48497o != null) {
            return;
        }
        long j10 = this.f48496n;
        long elapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j10);
        int i10 = this.f48495m;
        if (elapsedRealtime > com.huawei.openalliance.ad.ipc.c.Code && i10 < 3) {
            synchronized (this.f48494l) {
                if (this.f48496n == j10 && this.f48495m == i10) {
                    j("retry, current count is " + i10);
                    this.f48495m = this.f48495m + 1;
                    i(this.f48493k);
                    j10 = this.f48496n;
                    elapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j10);
                }
            }
        }
        if (this.f48497o != null || j10 < 0 || elapsedRealtime > com.huawei.openalliance.ad.ipc.c.Code || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f48494l) {
            if (this.f48497o == null) {
                try {
                    j(str + " wait...");
                    this.f48494l.wait(com.huawei.openalliance.ad.ipc.c.Code);
                } catch (Exception unused) {
                }
            }
        }
    }

    public final void i(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j10 = -elapsedRealtime;
        Class cls = this.f48485c;
        if (cls != null) {
            try {
                ClassLoader classLoader = cls.getClassLoader();
                if (classLoader == null) {
                    classLoader = context.getClassLoader();
                }
                b(this.f48486d, this.f48484b.newInstance(), context, Proxy.newProxyInstance(classLoader, new Class[]{this.f48485c}, this));
            } catch (Throwable th) {
                j("call init sdk error:" + th);
            }
            this.f48496n = elapsedRealtime;
        }
        elapsedRealtime = j10;
        this.f48496n = elapsedRealtime;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        this.f48496n = SystemClock.elapsedRealtime();
        if (objArr != null) {
            a aVar = new a();
            int length = objArr.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                Object obj2 = objArr[i10];
                if (obj2 != null && !h(obj2)) {
                    aVar.f48499b = (String) b(this.f48487e, obj2, new Object[0]);
                    aVar.f48500c = (String) b(this.f48488f, obj2, new Object[0]);
                    aVar.f48501d = (String) b(this.f48489g, obj2, new Object[0]);
                    aVar.f48502e = (String) b(this.f48490h, obj2, new Object[0]);
                    aVar.f48498a = (Boolean) b(this.f48491i, obj2, new Object[0]);
                    b(this.f48492j, obj2, new Object[0]);
                    if (aVar.a()) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("has get succ, check duplicate:");
                        sb2.append(this.f48497o != null);
                        j(sb2.toString());
                        synchronized (y.class) {
                            if (this.f48497o == null) {
                                this.f48497o = aVar;
                            }
                        }
                    }
                }
                i10++;
            }
        }
        e();
        return null;
    }
}
