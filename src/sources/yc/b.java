package yc;

import android.content.Context;
import android.os.Build;

/* compiled from: AppOpsManagerCompat.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final C0843b f54808a;

    /* compiled from: AppOpsManagerCompat.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class a extends C0843b {
        @Override // yc.b.C0843b
        public int a(Context context, String str, String str2) {
            return c.a(context, str, str2);
        }

        @Override // yc.b.C0843b
        public String b(String str) {
            return c.b(str);
        }
    }

    /* compiled from: AppOpsManagerCompat.java */
    /* renamed from: yc.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class C0843b {
        public int a(Context context, String str, String str2) {
            return 1;
        }

        public String b(String str) {
            return null;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 23) {
            f54808a = new a();
        } else {
            f54808a = new C0843b();
        }
    }

    public static int a(Context context, String str, String str2) {
        return f54808a.a(context, str, str2);
    }

    public static String b(String str) {
        return f54808a.b(str);
    }
}
