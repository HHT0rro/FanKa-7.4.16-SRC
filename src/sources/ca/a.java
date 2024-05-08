package ca;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.hihonor.android.os.Build;
import com.huawei.hms.android.SystemUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static Map<String, Object> f1587a = new HashMap();

    public static int a(Context context) {
        if (j(context)) {
            return 1;
        }
        if (l(context)) {
            return 2;
        }
        return n(context) ? 7 : 0;
    }

    public static String b() {
        return e.b(SystemUtils.PRODUCT_BRAND);
    }

    public static DisplayMetrics c(Context context) {
        Display defaultDisplay;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static String d() {
        return String.valueOf(Build.DISPLAY);
    }

    public static int e() {
        int a10;
        try {
            a10 = Build.VERSION.MAGIC_SDK_INT;
        } catch (Error | Exception unused) {
            a10 = e.a("ro.build.magic_api_level", 0);
        }
        fa.a.d("DeviceUtil", "magicApiLevel:" + a10);
        return a10;
    }

    public static String f(Context context) {
        String str = (String) f1587a.get("RESOLUTION");
        if (str != null) {
            return str;
        }
        o(context);
        return (String) f1587a.get("RESOLUTION");
    }

    public static String g() {
        String c4;
        try {
            c4 = com.hihonor.android.os.Build.MAGIC_VERSION;
        } catch (Error | Exception unused) {
            c4 = e.c("ro.build.version.magic", "");
        }
        fa.a.d("DeviceUtil", "magicVer:" + c4);
        return c4;
    }

    public static String h(Context context) {
        String str = (String) f1587a.get("DPI");
        if (str != null) {
            return str;
        }
        o(context);
        return (String) f1587a.get("DPI");
    }

    public static String i() {
        String b4 = e.b("ro.product.hw_model");
        if (TextUtils.isEmpty(b4)) {
            b4 = e.b("ro.product.hn_model");
            if (TextUtils.isEmpty(b4)) {
                b4 = android.os.Build.MODEL;
            }
        }
        fa.a.d("DeviceUtil", "phoneType:" + b4);
        return b4;
    }

    public static boolean j(Context context) {
        String str;
        if (context == null) {
            str = "isTelevision: context is null!";
        } else {
            Resources resources = context.getResources();
            if (resources != null) {
                return (resources.getConfiguration().uiMode & 15) == 4;
            }
            str = "isTelevision: resource is null!";
        }
        fa.a.c("DeviceUtil", str);
        return false;
    }

    public static int k() {
        return Build.VERSION.SDK_INT;
    }

    public static boolean l(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }

    public static int m() {
        Integer num = (Integer) f1587a.get("SystemBit");
        if (num != null) {
            return num.intValue();
        }
        Integer valueOf = Integer.valueOf(e.c("ro.product.cpu.abi", "").contains("arm64") ? 2 : 1);
        f1587a.put("SystemBit", valueOf);
        return valueOf.intValue();
    }

    public static boolean n(Context context) {
        return context.getPackageManager().hasSystemFeature("com.huawei.software.features.car");
    }

    public static void o(Context context) {
        DisplayMetrics c4 = c(context);
        if (c4 != null) {
            f1587a.put("DPI", String.valueOf(c4.densityDpi));
            String valueOf = String.valueOf(c4.widthPixels);
            String valueOf2 = String.valueOf(c4.heightPixels);
            f1587a.put("RESOLUTION", valueOf + "_" + valueOf2);
        }
    }

    public static boolean p() {
        String str;
        try {
            return e.d("hw_sc.product.useBrandCust", false);
        } catch (RuntimeException unused) {
            str = "get isUseBrandCust fail: RuntimeException";
            fa.a.d("DeviceUtil", str);
            return false;
        } catch (Exception unused2) {
            str = "get isUseBrandCust fail: Exception";
            fa.a.d("DeviceUtil", str);
            return false;
        }
    }
}
