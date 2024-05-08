package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class aw {

    /* renamed from: a, reason: collision with root package name */
    public static final String f9845a = "bqt_ad_tag";

    /* renamed from: b, reason: collision with root package name */
    public static volatile a[] f9846b;

    /* renamed from: c, reason: collision with root package name */
    private static final a[] f9847c;

    /* renamed from: d, reason: collision with root package name */
    private static final Map<String, a> f9848d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private static final a f9849e = new ax();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        private final ThreadLocal<String> f9850a = new ThreadLocal<>();

        private String g(Object[] objArr) {
            StringBuilder sb2 = new StringBuilder();
            for (Object obj : objArr) {
                sb2.append(obj);
                sb2.append(' ');
            }
            return sb2.toString();
        }

        @NonNull
        public abstract String a();

        public abstract void a(int i10, String str, String str2, Throwable th);

        public boolean a(int i10) {
            return true;
        }

        public String b() {
            String str = this.f9850a.get();
            if (str != null) {
                this.f9850a.remove();
            }
            return str;
        }

        public void c(String str) {
            b(3, null, str);
        }

        public void d(String str) {
            b(4, null, str);
        }

        public void e(String str) {
            b(5, null, str);
        }

        public void f(String str) {
            b(6, null, str);
        }

        public void a(String str) {
            if (TextUtils.isEmpty(str)) {
                c("Empty/Null json content");
                return;
            }
            try {
                String trim = str.trim();
                if (trim.startsWith("{")) {
                    b(3, null, new JSONObject(trim).toString(2));
                } else if (trim.startsWith("[")) {
                    b(3, null, new JSONArray(trim).toString(2));
                } else {
                    f("Invalid Json");
                }
            } catch (Exception unused) {
                f("Invalid Json");
            }
        }

        public void c(Object... objArr) {
            b(4, null, g(objArr));
        }

        public void d(Throwable th, String str) {
            b(5, th, str);
        }

        public void e(Object... objArr) {
            b(6, null, g(objArr));
        }

        public void f(Object... objArr) {
            b(7, null, g(objArr));
        }

        public String b(Object obj) {
            if (obj == null) {
                return "null";
            }
            if (!obj.getClass().isArray()) {
                return obj.toString();
            }
            if (obj instanceof boolean[]) {
                return Arrays.toString((boolean[]) obj);
            }
            if (obj instanceof byte[]) {
                return Arrays.toString((byte[]) obj);
            }
            if (obj instanceof char[]) {
                return Arrays.toString((char[]) obj);
            }
            if (obj instanceof short[]) {
                return Arrays.toString((short[]) obj);
            }
            if (obj instanceof int[]) {
                return Arrays.toString((int[]) obj);
            }
            if (obj instanceof long[]) {
                return Arrays.toString((long[]) obj);
            }
            if (obj instanceof float[]) {
                return Arrays.toString((float[]) obj);
            }
            if (obj instanceof double[]) {
                return Arrays.toString((double[]) obj);
            }
            return obj instanceof Object[] ? Arrays.deepToString((Object[]) obj) : "Couldn't find a correct type for the object";
        }

        public void c(Throwable th, String str) {
            b(4, th, str);
        }

        public void d(Throwable th) {
            b(5, th, null);
        }

        public void e(Throwable th, String str) {
            b(6, th, str);
        }

        public void f(Throwable th, String str) {
            b(7, th, str);
        }

        public void c(Throwable th) {
            b(4, th, null);
        }

        public void d(Object... objArr) {
            b(5, null, g(objArr));
        }

        public void e(Throwable th) {
            b(6, th, null);
        }

        public void f(Throwable th) {
            b(7, th, null);
        }

        public void g(String str) {
            b(7, null, str);
        }

        private String g(Throwable th) {
            StringWriter stringWriter = new StringWriter(256);
            PrintWriter printWriter = new PrintWriter((Writer) stringWriter, false);
            th.printStackTrace(printWriter);
            printWriter.flush();
            return stringWriter.toString();
        }

        public void a(Object... objArr) {
            b(2, null, g(objArr));
        }

        public void a(Throwable th, String str) {
            b(2, th, str);
        }

        public void a(Throwable th) {
            b(2, th, null);
        }

        public void a(Object obj) {
            b(3, null, b(obj));
        }

        public void a(int i10, String str) {
            b(i10, null, str);
        }

        public void a(int i10, Object... objArr) {
            b(i10, null, g(objArr));
        }

        public void a(int i10, Throwable th, String str) {
            b(i10, th, str);
        }

        public void a(int i10, Throwable th) {
            b(i10, th, null);
        }

        public boolean a(String str, int i10) {
            return a(i10);
        }

        public void b(String str) {
            b(2, null, str);
        }

        public String a(String str, Object[] objArr) {
            return String.format(str, objArr);
        }

        public void b(Throwable th, String str) {
            b(3, th, str);
        }

        public void b(Object... objArr) {
            b(3, null, g(objArr));
        }

        public void b(Throwable th) {
            b(3, th, null);
        }

        private void b(int i10, Throwable th, String str) {
            String b4 = b();
            if (a(b4, i10)) {
                if (str != null && str.length() == 0) {
                    str = null;
                }
                if (str == null) {
                    if (th == null) {
                        return;
                    } else {
                        str = g(th);
                    }
                } else if (th != null) {
                    str = str + "\n" + g(th);
                }
                a(i10, b4, str, th);
            }
        }
    }

    static {
        a[] aVarArr = new a[0];
        f9847c = aVarArr;
        f9846b = aVarArr;
    }

    public static void a(boolean z10) {
        try {
            a();
            if (ck.f10043a) {
                a((a) new au());
            } else if (z10) {
                a((a) new at());
            }
        } catch (Throwable unused) {
        }
    }

    public static void b(String str) {
        f9849e.b(str);
    }

    public static void c(String str) {
        f9849e.c(str);
    }

    public static void d(String str) {
        f9849e.d(str);
    }

    public static void e(String str) {
        f9849e.e(str);
    }

    public static void f(String str) {
        f9849e.f(str);
    }

    public static void g(String str) {
        f9849e.g(str);
    }

    public static a h(String str) {
        for (a aVar : f9846b) {
            aVar.f9850a.set(str);
        }
        return f9849e;
    }

    public static void i(String str) {
        Map<String, a> map = f9848d;
        synchronized (map) {
            if (map.remove(str) == null) {
                return;
            }
            f9846b = (a[]) map.values().toArray(new a[0]);
        }
    }

    public static void b(Object... objArr) {
        f9849e.b(objArr);
    }

    public static void c(Throwable th, String str) {
        f9849e.c(th, str);
    }

    public static void d(Throwable th, String str) {
        f9849e.d(th, str);
    }

    public static void e(Object... objArr) {
        f9849e.e(objArr);
    }

    public static void f(Object... objArr) {
        f9849e.f(objArr);
    }

    public static void b(Throwable th, String str) {
        f9849e.b(th, str);
    }

    public static void c(Object... objArr) {
        f9849e.c(objArr);
    }

    public static void d(Object... objArr) {
        f9849e.d(objArr);
    }

    public static void e(Throwable th, String str) {
        f9849e.e(th, str);
    }

    public static void f(Throwable th, String str) {
        f9849e.f(th, str);
    }

    public static void b(Throwable th) {
        f9849e.b(th);
    }

    public static void c(Throwable th) {
        f9849e.c(th);
    }

    public static void d(Throwable th) {
        f9849e.d(th);
    }

    public static void e(Throwable th) {
        f9849e.e(th);
    }

    public static void f(Throwable th) {
        f9849e.f(th);
    }

    public static void a() {
        try {
            i("local");
            i("debug");
        } catch (Throwable unused) {
        }
    }

    public static a b() {
        return f9849e;
    }

    public static a c() {
        for (a aVar : f9846b) {
            aVar.f9850a.set(f9845a);
        }
        return f9849e;
    }

    public static void d() {
        Map<String, a> map = f9848d;
        synchronized (map) {
            map.clear();
            f9846b = f9847c;
        }
    }

    public static List<a> e() {
        List<a> unmodifiableList;
        Map<String, a> map = f9848d;
        synchronized (map) {
            unmodifiableList = Collections.unmodifiableList(new ArrayList(map.values()));
        }
        return unmodifiableList;
    }

    public static int f() {
        int size;
        Map<String, a> map = f9848d;
        synchronized (map) {
            size = map.size();
        }
        return size;
    }

    public static void b(a aVar) {
        i(aVar.a());
    }

    public static void a(String str) {
        f9849e.a(str);
    }

    public static void a(Object... objArr) {
        f9849e.a(objArr);
    }

    public static void a(Throwable th, String str) {
        f9849e.a(th, str);
    }

    public static void a(Throwable th) {
        f9849e.a(th);
    }

    public static void a(Object obj) {
        f9849e.a(obj);
    }

    public static void a(int i10, String str) {
        f9849e.a(i10, str);
    }

    public static void a(int i10, Throwable th, String str) {
        f9849e.a(i10, th, str);
    }

    public static void a(int i10, Object... objArr) {
        f9849e.a(i10, objArr);
    }

    public static void a(int i10, Throwable th) {
        f9849e.a(i10, th);
    }

    public static void a(a aVar) {
        if (aVar == null || aVar == f9849e) {
            return;
        }
        Map<String, a> map = f9848d;
        synchronized (map) {
            map.put(aVar.a(), aVar);
            f9846b = (a[]) map.values().toArray(new a[0]);
        }
    }
}
