package b7;

import android.os.Build;
import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static Boolean f1414a;

    @RecentlyNonNull
    public static boolean a() {
        return true;
    }

    @RecentlyNonNull
    public static boolean b() {
        return true;
    }

    @RecentlyNonNull
    public static boolean c() {
        return true;
    }

    @RecentlyNonNull
    public static boolean d() {
        return true;
    }

    @RecentlyNonNull
    public static boolean e() {
        return true;
    }

    @RecentlyNonNull
    public static boolean f() {
        return Build.VERSION.SDK_INT >= 24;
    }

    @RecentlyNonNull
    public static boolean g() {
        return Build.VERSION.SDK_INT >= 26;
    }

    @RecentlyNonNull
    public static boolean h() {
        return Build.VERSION.SDK_INT >= 29;
    }

    @RecentlyNonNull
    public static boolean i() {
        boolean z10 = false;
        if (!h()) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 30 && Build.VERSION.CODENAME.equals("REL")) {
            return true;
        }
        String str = Build.VERSION.CODENAME;
        if (!(str.length() == 1 && str.charAt(0) >= 'R' && str.charAt(0) <= 'Z')) {
            return false;
        }
        Boolean bool = f1414a;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            if ("google".equals(Build.BRAND) && !Build.ID.startsWith("RPP1") && !Build.ID.startsWith("RPP2") && Integer.parseInt(Build.VERSION.INCREMENTAL) >= 6301457) {
                z10 = true;
            }
            f1414a = Boolean.valueOf(z10);
        } catch (NumberFormatException unused) {
            f1414a = Boolean.TRUE;
        }
        f1414a.booleanValue();
        return f1414a.booleanValue();
    }
}
