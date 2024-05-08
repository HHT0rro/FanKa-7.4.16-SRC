package pb;

import android.util.Log;

/* compiled from: L.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f52977a = false;

    /* renamed from: b, reason: collision with root package name */
    public static volatile boolean f52978b = true;

    public static void a(String str, Object... objArr) {
        if (f52977a) {
            e(3, null, str, objArr);
        }
    }

    public static void b(String str, Object... objArr) {
        e(6, null, str, objArr);
    }

    public static void c(Throwable th) {
        e(6, th, null, new Object[0]);
    }

    public static void d(String str, Object... objArr) {
        e(4, null, str, objArr);
    }

    public static void e(int i10, Throwable th, String str, Object... objArr) {
        if (f52978b) {
            if (objArr.length > 0) {
                str = String.format(str, objArr);
            }
            if (th != null) {
                if (str == null) {
                    str = th.getMessage();
                }
                str = String.format("%1$s\n%2$s", str, Log.getStackTraceString(th));
            }
            Log.println(i10, com.nostra13.universalimageloader.core.d.f37798d, str);
        }
    }

    public static void f(String str, Object... objArr) {
        e(5, null, str, objArr);
    }

    public static void g(boolean z10) {
        f52977a = z10;
    }
}
