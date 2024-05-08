package ac;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f746a = true;

    /* renamed from: b, reason: collision with root package name */
    public static long f747b;

    /* renamed from: c, reason: collision with root package name */
    public static int f748c;

    /* renamed from: d, reason: collision with root package name */
    public static StringBuilder f749d = new StringBuilder();

    /* renamed from: e, reason: collision with root package name */
    public static StringBuilder f750e = new StringBuilder();

    /* renamed from: f, reason: collision with root package name */
    public static StringBuilder f751f = new StringBuilder();

    public static String a(int i10) {
        StringBuilder sb2;
        if (i10 == 0) {
            sb2 = f750e;
        } else if (1 == i10) {
            sb2 = f749d;
        } else {
            if (2 != i10) {
                return "no info";
            }
            sb2 = f751f;
        }
        return sb2.toString();
    }

    public static void b() {
        f748c = 0;
        f750e.setLength(0);
        f750e.append("\n\n********************\n\n\n\n   com debug info   \n\n\n\n********************\n\n");
        f749d.setLength(0);
        f749d.append("\n\n********************\n\n\n\n   all debug info   \n\n\n\n********************\n\n");
        f751f.append("\n\n********************\n\n\n\n   result  info   \n\n\n\n********************\n\n");
    }

    public static void c(int i10, String str) {
        StringBuilder sb2 = new StringBuilder("【");
        int i11 = f748c;
        f748c = i11 + 1;
        sb2.append(i11);
        sb2.append("】\n时间戳:");
        sb2.append(System.currentTimeMillis());
        sb2.append("\n时间差:");
        sb2.append(System.currentTimeMillis() - f747b);
        sb2.append("\n数据:\n");
        sb2.append(str);
        sb2.append("\n\n");
        f(i10, sb2.toString());
        f747b = System.currentTimeMillis();
    }

    public static void d(String str) {
        c(1, "\n" + str + "\n");
    }

    public static void e(boolean z10) {
        f746a = z10;
    }

    public static void f(int i10, String str) {
        if (i10 == 0) {
            f750e.append(str);
        }
        if (2 == i10) {
            f751f.append(str);
        }
        f749d.append(str);
    }

    public static void g(String str) {
        if (f746a) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(b.a());
            sb2.append(" ");
            sb2.append(str);
            c(0, str);
        }
    }

    public static void h(String str) {
        if (f746a) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(b.a());
            sb2.append(" ");
            sb2.append(str);
            c(0, str);
        }
    }

    public static void i(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(b.a());
        sb2.append(" ");
        sb2.append(str);
        c(0, str);
    }
}
