package z0;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Base64;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import androidx.core.content.ContextCompat;
import com.baidu.mobads.sdk.internal.bk;
import com.cupidapp.live.base.extension.NetworkStateConstants;
import com.cupidapp.live.base.network.gson.GsonUtil;
import com.hailiang.advlib.core.ADEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ContextExtension.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class h {
    public static final boolean a(@NotNull Context context, @NotNull String appPackageName) {
        kotlin.jvm.internal.s.i(context, "<this>");
        kotlin.jvm.internal.s.i(appPackageName, "appPackageName");
        return false;
    }

    public static final boolean b(@Nullable Context context, @NotNull String permission) {
        kotlin.jvm.internal.s.i(permission, "permission");
        return context != null && ContextCompat.checkSelfPermission(context, permission) == 0;
    }

    public static final int c(@NotNull Object obj, float f10) {
        kotlin.jvm.internal.s.i(obj, "<this>");
        return (int) ((f10 * com.cupidapp.live.base.utils.f.f12314a.c().density) + 0.5f);
    }

    @NotNull
    public static final String d(@NotNull String oaid) {
        kotlin.jvm.internal.s.i(oaid, "oaid");
        String encodeToString = Base64.encodeToString(l1.a.c(oaid, "4503fb7f0f6ebe50"), 2);
        kotlin.jvm.internal.s.h(encodeToString, "encodeToString(oaid.aesE…6ebe50\"), Base64.NO_WRAP)");
        return encodeToString;
    }

    @NotNull
    public static final String e() {
        HashMap hashMap = new HashMap();
        String MANUFACTURER = Build.MANUFACTURER;
        kotlin.jvm.internal.s.h(MANUFACTURER, "MANUFACTURER");
        hashMap.put("manufacturer", MANUFACTURER);
        String MODEL = Build.MODEL;
        kotlin.jvm.internal.s.h(MODEL, "MODEL");
        hashMap.put(bk.f9900i, MODEL);
        String BRAND = Build.BRAND;
        kotlin.jvm.internal.s.h(BRAND, "BRAND");
        hashMap.put("brand", BRAND);
        String json = GsonUtil.f12000a.b().toJson(hashMap);
        kotlin.jvm.internal.s.h(json, "GsonUtil.pureGson.toJson(map)");
        String encodeToString = Base64.encodeToString(l1.a.c(json, "4503fb7f0f6ebe50"), 2);
        kotlin.jvm.internal.s.h(encodeToString, "encodeToString(\n        …     Base64.NO_WRAP\n    )");
        return encodeToString;
    }

    public static final int f(@Nullable Context context) {
        Display defaultDisplay;
        Display defaultDisplay2;
        int dimensionPixelSize = context != null ? Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android")) : 0;
        Object systemService = context != null ? context.getSystemService("window") : null;
        WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
        Point point = new Point();
        Point point2 = new Point();
        if (windowManager != null && (defaultDisplay2 = windowManager.getDefaultDisplay()) != null) {
            defaultDisplay2.getRealSize(point);
        }
        if (windowManager != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
            defaultDisplay.getSize(point2);
        }
        int i10 = point.y;
        int i11 = point2.y;
        if (i10 == i11 || i10 - i11 < dimensionPixelSize) {
            return 0;
        }
        return dimensionPixelSize;
    }

    @NotNull
    public static final NetworkStateConstants g(@Nullable Context context) {
        if (context != null) {
            Object systemService = context.getSystemService("connectivity");
            kotlin.jvm.internal.s.g(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                int type = activeNetworkInfo.getType();
                if (type == 0) {
                    return NetworkStateConstants.MOBILE;
                }
                if (type == 1) {
                    return NetworkStateConstants.WIFI;
                }
            }
            return NetworkStateConstants.DISCONNECT;
        }
        return NetworkStateConstants.NONE;
    }

    @NotNull
    public static final String h() {
        String c4 = p1.g.f52734a.f().c();
        return c4 == null || c4.length() == 0 ? "" : d(c4);
    }

    @NotNull
    public static final String i(@NotNull Context context) {
        kotlin.jvm.internal.s.i(context, "<this>");
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        kotlin.jvm.internal.s.h(string, "getString(this.contentRe…ttings.Secure.ANDROID_ID)");
        return string;
    }

    @NotNull
    public static final String j(@NotNull Context context) {
        String str;
        kotlin.jvm.internal.s.i(context, "<this>");
        try {
            Object systemService = context.getSystemService("wifi");
            kotlin.jvm.internal.s.g(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
            str = ((WifiManager) systemService).getConnectionInfo().getSSID();
        } catch (Exception e2) {
            e2.printStackTrace();
            str = null;
        }
        if (str == null || str.length() == 0) {
            return "";
        }
        String encodeToString = Base64.encodeToString(l1.a.c(str, "4503fb7f0f6ebe50"), 2);
        kotlin.jvm.internal.s.h(encodeToString, "encodeToString(ssid.aesE…6ebe50\"), Base64.NO_WRAP)");
        return encodeToString;
    }

    public static final int k(@NotNull Object obj) {
        kotlin.jvm.internal.s.i(obj, "<this>");
        return com.cupidapp.live.base.utils.f.f12314a.c().heightPixels;
    }

    public static final int l(@NotNull Object obj) {
        kotlin.jvm.internal.s.i(obj, "<this>");
        return com.cupidapp.live.base.utils.f.f12314a.c().widthPixels;
    }

    public static final int m(@Nullable Context context) {
        int identifier;
        if (context == null || (identifier = Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android")) <= 0) {
            return 0;
        }
        return Resources.getSystem().getDimensionPixelSize(identifier);
    }

    @NotNull
    public static final String n(@NotNull Context context) {
        kotlin.jvm.internal.s.i(context, "<this>");
        String string = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("ANDROID_STORE", "");
        kotlin.jvm.internal.s.h(string, "this.packageManager.getA…ring(\"ANDROID_STORE\", \"\")");
        return string;
    }

    public static final void o(@NotNull Context context) {
        kotlin.jvm.internal.s.i(context, "<this>");
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        context.startActivity(intent);
    }

    public static final void p(@NotNull Context context, @Nullable View view) {
        IBinder windowToken;
        kotlin.jvm.internal.s.i(context, "<this>");
        if (view != null) {
            windowToken = view.getWindowToken();
        } else {
            windowToken = context instanceof Activity ? ((Activity) context).findViewById(16908290).getWindowToken() : null;
        }
        if (windowToken != null) {
            Object systemService = context.getSystemService("input_method");
            kotlin.jvm.internal.s.g(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(windowToken, 2);
        }
    }

    public static /* synthetic */ void q(Context context, View view, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            view = null;
        }
        p(context, view);
    }

    public static final boolean r(@NotNull Context context) {
        kotlin.jvm.internal.s.i(context, "<this>");
        try {
            Object systemService = context.getSystemService("activity");
            ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
            if (activityManager != null) {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (kotlin.jvm.internal.s.d(runningAppProcessInfo.processName, context.getPackageName()) && runningAppProcessInfo.importance == 100) {
                            return true;
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static final boolean s() {
        String BRAND = Build.BRAND;
        kotlin.jvm.internal.s.h(BRAND, "BRAND");
        Locale locale = Locale.getDefault();
        kotlin.jvm.internal.s.h(locale, "getDefault()");
        String lowerCase = BRAND.toLowerCase(locale);
        kotlin.jvm.internal.s.h(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        String MANUFACTURER = Build.MANUFACTURER;
        kotlin.jvm.internal.s.h(MANUFACTURER, "MANUFACTURER");
        Locale locale2 = Locale.getDefault();
        kotlin.jvm.internal.s.h(locale2, "getDefault()");
        String lowerCase2 = MANUFACTURER.toLowerCase(locale2);
        kotlin.jvm.internal.s.h(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
        return kotlin.jvm.internal.s.d(lowerCase, ADEvent.XIAOMI) || kotlin.jvm.internal.s.d(lowerCase2, ADEvent.XIAOMI);
    }

    public static final int t(@NotNull Object obj, int i10) {
        kotlin.jvm.internal.s.i(obj, "<this>");
        try {
            return (int) ((i10 / com.cupidapp.live.base.utils.f.f12314a.c().density) + 0.5f);
        } catch (Exception unused) {
            return i10;
        }
    }

    public static final void u(@NotNull Context context, @NotNull View view) {
        kotlin.jvm.internal.s.i(context, "<this>");
        kotlin.jvm.internal.s.i(view, "view");
        if (Build.VERSION.SDK_INT >= 23) {
            int m10 = m(context);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height += m10;
            view.setLayoutParams(layoutParams);
            view.setPadding(0, m10, 0, 0);
        }
    }

    public static final void v(@NotNull Context context, @NotNull View view) {
        kotlin.jvm.internal.s.i(context, "<this>");
        kotlin.jvm.internal.s.i(view, "view");
        if (view.requestFocus()) {
            Object systemService = context.getSystemService("input_method");
            kotlin.jvm.internal.s.g(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).showSoftInput(view, 1);
        }
    }

    public static final int w(@NotNull Context context, int i10) {
        kotlin.jvm.internal.s.i(context, "<this>");
        return (int) ((i10 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
