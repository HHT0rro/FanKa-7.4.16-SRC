package fc;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static int f49290a = 2;

    /* renamed from: b, reason: collision with root package name */
    public static a f49291b = new b();

    /* renamed from: c, reason: collision with root package name */
    public static final HashMap<Integer, Long> f49292c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    public static final HashMap<Integer, String> f49293d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    public static final Integer f49294e = -1;

    /* renamed from: f, reason: collision with root package name */
    public static AtomicInteger f49295f = new AtomicInteger(1);

    public static int a() {
        return f49290a;
    }

    public static Integer b(String str) {
        if (f49290a > 1) {
            return f49294e;
        }
        Integer valueOf = Integer.valueOf(f49295f.incrementAndGet());
        f49292c.put(valueOf, Long.valueOf(System.currentTimeMillis()));
        f49293d.put(valueOf, str);
        f49291b.log(str + " starts");
        return valueOf;
    }

    public static void c(int i10) {
        if (i10 < 0 || i10 > 5) {
            d(2, "set log level as " + i10);
        }
        f49290a = i10;
    }

    public static void d(int i10, String str) {
        if (i10 >= f49290a) {
            f49291b.log(str);
        }
    }

    public static void e(int i10, String str, Throwable th) {
        if (i10 >= f49290a) {
            f49291b.log(str, th);
        }
    }

    public static void f(int i10, Throwable th) {
        if (i10 >= f49290a) {
            f49291b.log("", th);
        }
    }

    public static void g(a aVar) {
        f49291b = aVar;
    }

    public static void h(Integer num) {
        if (f49290a <= 1) {
            HashMap<Integer, Long> hashMap = f49292c;
            if (hashMap.containsKey(num)) {
                long longValue = hashMap.remove(num).longValue();
                String remove = f49293d.remove(num);
                long currentTimeMillis = System.currentTimeMillis() - longValue;
                f49291b.log(remove + " ends in " + currentTimeMillis + " ms");
            }
        }
    }

    public static void i(String str) {
        d(2, "[Thread:" + Thread.currentThread().getId() + "] " + str);
    }

    public static void j(String str, Throwable th) {
        e(4, str, th);
    }

    public static void k(Throwable th) {
        f(4, th);
    }

    public static void l(String str) {
        d(0, str);
    }

    public static void m(String str) {
        d(1, "[Thread:" + Thread.currentThread().getId() + "] " + str);
    }

    public static void n(String str) {
        d(4, str);
    }
}
