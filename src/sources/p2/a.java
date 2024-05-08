package p2;

/* compiled from: LogTimerRecord.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class a extends b {

    /* renamed from: g, reason: collision with root package name */
    public static volatile a f52850g;

    public a() {
    }

    public static void e(String str) {
        g().a(str);
    }

    public static void f(String str) {
        g().d(str);
    }

    public static a g() {
        if (f52850g == null) {
            synchronized (a.class) {
                if (f52850g == null) {
                    f52850g = new a(1000, true, false);
                }
            }
        }
        return f52850g;
    }

    @Override // p2.b
    public void b(String str, double d10, int i10) {
        String.format("%s average time is %f ms in %d round", str, Double.valueOf(d10 * 1.0E-6d), Integer.valueOf(i10));
    }

    @Override // p2.b
    public void c(String str, long j10) {
        String.format("%s %f", str, Double.valueOf(j10 * 1.0E-6d));
    }

    public a(int i10, boolean z10, boolean z11) {
        super(i10, z10, z11);
    }
}
