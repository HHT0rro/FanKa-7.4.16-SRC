package b7;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public static Boolean f1408a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public static Boolean f1409b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public static Boolean f1410c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public static Boolean f1411d;

    @RecentlyNonNull
    public static boolean a(@RecentlyNonNull Context context) {
        return b(context.getPackageManager());
    }

    @RecentlyNonNull
    public static boolean b(@RecentlyNonNull PackageManager packageManager) {
        if (f1411d == null) {
            f1411d = Boolean.valueOf(k.g() && packageManager.hasSystemFeature("android.hardware.type.automotive"));
        }
        return f1411d.booleanValue();
    }

    @RecentlyNonNull
    public static boolean c(@RecentlyNonNull Context context) {
        return d(context.getPackageManager());
    }

    @RecentlyNonNull
    public static boolean d(@RecentlyNonNull PackageManager packageManager) {
        if (f1408a == null) {
            f1408a = Boolean.valueOf(k.d() && packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        return f1408a.booleanValue();
    }

    @RecentlyNonNull
    public static boolean e(@RecentlyNonNull Context context) {
        if (!c(context)) {
            return false;
        }
        if (k.f()) {
            return g(context) && !k.g();
        }
        return true;
    }

    @RecentlyNonNull
    public static boolean f(@RecentlyNonNull Context context) {
        if (f1410c == null) {
            f1410c = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
        }
        return f1410c.booleanValue();
    }

    public static boolean g(Context context) {
        if (f1409b == null) {
            f1409b = Boolean.valueOf(k.e() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return f1409b.booleanValue();
    }
}
