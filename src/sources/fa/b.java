package fa;

import android.util.Log;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f49235a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f49236b;

    static {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13 = false;
        try {
            z10 = Log.class.getField("HWLog").getBoolean(Log.class);
        } catch (IllegalAccessException | NoSuchFieldException unused) {
            z10 = false;
        }
        try {
            z11 = Log.class.getField("HWModuleLog").getBoolean(Log.class);
        } catch (IllegalAccessException | NoSuchFieldException unused2) {
            z11 = false;
        }
        f49235a = z10 || (z11 && Log.isLoggable("MarketInstallService", 3));
        try {
            z12 = Log.class.getField("HWINFO").getBoolean(Log.class);
        } catch (IllegalAccessException | NoSuchFieldException unused3) {
            z12 = false;
        }
        if (z12 || (z11 && Log.isLoggable("MarketInstallService", 4))) {
            z13 = true;
        }
        f49236b = z13;
    }

    public static boolean a() {
        return f49235a;
    }

    public static boolean b() {
        return f49236b;
    }

    public static boolean c() {
        return true;
    }
}
