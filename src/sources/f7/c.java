package f7;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    public static c f49225c;

    /* renamed from: a, reason: collision with root package name */
    public final b f49226a = new b();

    /* renamed from: b, reason: collision with root package name */
    public final e f49227b = new e();

    static {
        c cVar = new c();
        synchronized (c.class) {
            f49225c = cVar;
        }
    }

    public static b a() {
        return b().f49226a;
    }

    public static c b() {
        c cVar;
        synchronized (c.class) {
            cVar = f49225c;
        }
        return cVar;
    }
}
