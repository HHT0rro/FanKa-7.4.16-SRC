package com.huawei.openalliance.ad.utils;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.ImageView;
import com.huawei.android.app.ActivityManagerEx;
import com.huawei.appgallery.agd.common.constant.SystemPropertyValues;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.ea;
import com.huawei.hms.ads.eb;
import com.huawei.hms.ads.em;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.hp;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Locale;

@com.huawei.openalliance.ad.annotations.b
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class ay {
    private static final int B = 33;
    public static final String Code = "zh-CN";
    private static final String I = "display_notch_status";
    private static final String V = "ay";
    private static final int Z = 0;

    public static boolean B() {
        String Code2 = Code(SystemPropertyValues.PROP_REGION_KEY);
        if (!TextUtils.isEmpty(Code2)) {
            return "cn".equalsIgnoreCase(Code2);
        }
        String Code3 = Code(SystemPropertyValues.PROP_LOCALE_KEY);
        if (!TextUtils.isEmpty(Code3)) {
            return Code3.toLowerCase(Locale.ENGLISH).contains("cn");
        }
        String Z2 = Z();
        if (TextUtils.isEmpty(Z2)) {
            return false;
        }
        return "cn".equalsIgnoreCase(Z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0039 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean B(android.content.Context r4) {
        /*
            r0 = 0
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch: java.lang.Throwable -> Lc android.provider.Settings.SettingNotFoundException -> L17
            java.lang.String r1 = "display_notch_status"
            int r4 = android.provider.Settings.Secure.getInt(r4, r1)     // Catch: java.lang.Throwable -> Lc android.provider.Settings.SettingNotFoundException -> L17
            goto L37
        Lc:
            r4 = move-exception
            java.lang.String r1 = com.huawei.openalliance.ad.utils.ay.V
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "isNotchEnable Throwable:"
            goto L21
        L17:
            r4 = move-exception
            java.lang.String r1 = com.huawei.openalliance.ad.utils.ay.V
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "isNotchEnable error:"
        L21:
            r2.append(r3)
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = r4.getSimpleName()
            r2.append(r4)
            java.lang.String r4 = r2.toString()
            com.huawei.hms.ads.gl.V(r1, r4)
            r4 = 0
        L37:
            if (r4 != 0) goto L3a
            r0 = 1
        L3a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.utils.ay.B(android.content.Context):boolean");
    }

    public static int C(Context context) {
        int S = S(context);
        if (S > 0) {
            return S / 2;
        }
        return 36;
    }

    public static boolean C() {
        return I() && !com.huawei.openalliance.ad.constant.u.cF.equalsIgnoreCase(Locale.getDefault().getLanguage());
    }

    public static int Code(boolean z10) {
        return z10 ? R.drawable.hiad_video_mute : R.drawable.hiad_video_unmute;
    }

    public static String Code(Context context, String str) {
        PackageManager packageManager;
        String str2;
        StringBuilder sb2;
        if (context == null || (packageManager = context.getPackageManager()) == null) {
            return "";
        }
        try {
            Bundle bundle = packageManager.getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null) {
                return bundle.getString(str);
            }
        } catch (PackageManager.NameNotFoundException e2) {
            e = e2;
            str2 = V;
            sb2 = new StringBuilder();
            sb2.append("getMetaDataInfo ");
            sb2.append(e.getClass().getSimpleName());
            gl.I(str2, sb2.toString());
            return "";
        } catch (Throwable th) {
            e = th;
            str2 = V;
            sb2 = new StringBuilder();
            sb2.append("getMetaDataInfo ");
            sb2.append(e.getClass().getSimpleName());
            gl.I(str2, sb2.toString());
            return "";
        }
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Class] */
    public static String Code(String str) {
        String str2;
        StringBuilder sb2;
        String str3;
        Class<?> cls;
        String str4 = "android.os.SystemProperties";
        try {
            if (Build.VERSION.SDK_INT >= 27) {
                try {
                    str4 = Class.forName(c.I() ? "com.hihonor.android.os.SystemPropertiesEx" : "com.huawei.android.os.SystemPropertiesEx");
                    cls = str4;
                } catch (ClassNotFoundException unused) {
                }
                return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, str);
            }
            cls = Class.forName(str4);
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, str);
        } catch (RuntimeException e2) {
            e = e2;
            str2 = V;
            sb2 = new StringBuilder();
            str3 = "getSystemProperties RuntimeException:";
            sb2.append(str3);
            sb2.append(e.getClass().getSimpleName());
            gl.I(str2, sb2.toString());
            return null;
        } catch (Throwable th) {
            e = th;
            str2 = V;
            sb2 = new StringBuilder();
            str3 = "getSystemProperties Exception:";
            sb2.append(str3);
            sb2.append(e.getClass().getSimpleName());
            gl.I(str2, sb2.toString());
            return null;
        }
    }

    public static void Code(Activity activity, Context context) {
        if (context == null || activity == null || !(context instanceof Activity)) {
            gl.I(V, "activity is null");
            return;
        }
        Window window = ((Activity) context).getWindow();
        Window window2 = activity.getWindow();
        if (window == null || window2 == null) {
            gl.I(V, "window is null");
            return;
        }
        WindowManager.LayoutParams attributes = window2.getAttributes();
        attributes.flags = window.getAttributes().flags;
        window2.setAttributes(attributes);
        window2.setNavigationBarColor(window.getNavigationBarColor());
        View decorView = window.getDecorView();
        View decorView2 = window2.getDecorView();
        if (decorView == null || decorView2 == null) {
            gl.I(V, "decorView is null");
        } else {
            decorView2.setSystemUiVisibility(decorView.getSystemUiVisibility());
        }
    }

    public static void Code(Activity activity, final com.huawei.openalliance.ad.views.i iVar) {
        if (activity == null || !ea.B(activity)) {
            return;
        }
        Window window = activity.getWindow();
        if (window == null) {
            gl.I(V, "get safe padding, window is null");
            return;
        }
        try {
            final em Code2 = eb.Code(activity);
            Code2.Code(window.getAttributes());
            window.getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.huawei.openalliance.ad.utils.ay.2
                @Override // android.view.View.OnApplyWindowInsetsListener
                public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    com.huawei.openalliance.ad.views.i iVar2;
                    try {
                        Rect Code3 = em.this.Code(windowInsets);
                        if (gl.Code()) {
                            String str = ay.V;
                            Object[] objArr = new Object[1];
                            objArr[0] = Integer.valueOf(Code3 == null ? 0 : Code3.right);
                            gl.Code(str, "got safe padding: %s", objArr);
                        }
                        if (Code3 != null && (iVar2 = iVar) != null) {
                            iVar2.Code(Code3.right);
                        }
                    } catch (NoSuchMethodError unused) {
                        gl.I(ay.V, "getRingScreenSafePadding NoSuchMethodError getDisplaySideRegion");
                    } catch (Throwable th) {
                        gl.I(ay.V, "getRingScreenSafePadding error:" + th.getClass().getSimpleName());
                    }
                    return windowInsets;
                }
            });
        } catch (Throwable th) {
            gl.I(V, "getSafePadding ex: %s", th.getClass().getSimpleName());
        }
    }

    public static void Code(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        try {
            intent.setClipData(com.huawei.openalliance.ad.constant.u.cG);
            context.startActivity(intent);
        } catch (Throwable unused) {
            gl.I(V, "start activity error");
        }
    }

    public static void Code(final View view, Activity activity) {
        String str;
        String str2;
        if (activity == null) {
            str = V;
            str2 = "has no activity";
        } else if (!ea.B(activity)) {
            str = V;
            str2 = "not huawei phone";
        } else if (view == null) {
            str = V;
            str2 = "has no rootview";
        } else {
            Window window = activity.getWindow();
            if (window != null) {
                try {
                    final em Code2 = eb.Code(activity);
                    Code2.Code(window.getAttributes());
                    window.getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.huawei.openalliance.ad.utils.ay.1
                        @Override // android.view.View.OnApplyWindowInsetsListener
                        public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                            View view3;
                            try {
                                Rect Code3 = em.this.Code(windowInsets);
                                if (Code3 != null && (view3 = view) != null) {
                                    view3.setPadding(Code3.left, 0, Code3.right, 0);
                                }
                            } catch (NoSuchMethodError unused) {
                                gl.I(ay.V, "initOnApplyWindowInsets NoSuchMethodError getDisplaySideRegion");
                            } catch (Throwable th) {
                                gl.I(ay.V, "initOnApplyWindowInsets error:" + th.getClass().getSimpleName());
                            }
                            return windowInsets;
                        }
                    });
                    return;
                } catch (NoSuchMethodError unused) {
                    gl.I(V, "adaptRingScreen NoSuchMethodError setDisplaySideMode");
                    return;
                } catch (Throwable th) {
                    gl.I(V, "adaptRingScreen error:" + th.getClass().getSimpleName());
                    return;
                }
            }
            str = V;
            str2 = "has no window";
        }
        gl.I(str, str2);
    }

    public static void Code(ImageView imageView) {
        if (imageView == null) {
            return;
        }
        imageView.setScaleX(I() ? -1.0f : 1.0f);
    }

    public static boolean Code() {
        return true;
    }

    public static boolean Code(Activity activity) {
        if (activity == null) {
            return false;
        }
        try {
            return ActivityManagerEx.getActivityWindowMode(activity) == 102;
        } catch (Throwable unused) {
            gl.I(V, "isFreedomWindowMode error");
            return false;
        }
    }

    public static boolean Code(Context context) {
        PowerManager powerManager;
        if (context == null || (powerManager = (PowerManager) context.getSystemService("power")) == null) {
            return true;
        }
        try {
            return powerManager.isInteractive();
        } catch (Exception unused) {
            gl.I(V, "isScreenInteractive has exception");
            return true;
        }
    }

    public static int[] Code(View view) {
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
        }
        return iArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int[] Code(hp hpVar) {
        return Code(hpVar instanceof View ? (View) hpVar : null);
    }

    public static boolean D(Context context) {
        if (!(context instanceof Activity)) {
            return true;
        }
        Activity activity = (Activity) context;
        return activity.isFinishing() || activity.isDestroyed();
    }

    public static boolean F(Context context) {
        try {
            return eb.Code(context).Code();
        } catch (Throwable th) {
            gl.I(V, "isInMultiWindowMode " + th.getClass().getSimpleName());
            return false;
        }
    }

    public static int I(Context context) {
        Resources resources;
        int identifier;
        if (context != null && (identifier = (resources = context.getResources()).getIdentifier("navigation_bar_height", "dimen", "android")) > 0 && f(context) && g(context)) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    @com.huawei.openalliance.ad.annotations.b
    public static boolean I() {
        return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }

    public static int[] I(View view) {
        if (!V(view)) {
            return new int[0];
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr;
    }

    public static int L(Context context) {
        Resources resources;
        Configuration configuration;
        if (context == null || (resources = context.getResources()) == null || (configuration = resources.getConfiguration()) == null) {
            return 1;
        }
        return configuration.orientation;
    }

    public static int S(Context context) {
        Resources resources;
        int identifier;
        if (context != null && (identifier = (resources = context.getResources()).getIdentifier("navigation_bar_height", "dimen", "android")) > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static boolean V() {
        return Build.VERSION.SDK_INT >= 28;
    }

    public static boolean V(Context context) {
        KeyguardManager keyguardManager;
        if (context == null || (keyguardManager = (KeyguardManager) context.getSystemService("keyguard")) == null) {
            return false;
        }
        return keyguardManager.inKeyguardRestrictedInputMode();
    }

    public static boolean V(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public static int Z(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static String Z() {
        Locale locale = Locale.getDefault();
        return locale != null ? locale.getCountry() : "";
    }

    public static int[] Z(View view) {
        return !V(view) ? new int[0] : new int[]{view.getMeasuredWidth(), view.getMeasuredHeight()};
    }

    public static boolean a(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                return context.getPackageManager().canRequestPackageInstalls();
            }
        } catch (Throwable th) {
            gl.I(V, "canInstallPackage exception %s", th.getClass().getSimpleName());
        }
        return true;
    }

    public static int b(Context context) {
        String str;
        String str2;
        if (!ea.Code(context).S()) {
            return 0;
        }
        try {
            return 1 - Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state");
        } catch (Settings.SettingNotFoundException unused) {
            str = V;
            str2 = "get pureModeState error, setting not found.";
            gl.Z(str, str2);
            return 0;
        } catch (Throwable unused2) {
            str = V;
            str2 = "get pureModeState error.";
            gl.Z(str, str2);
            return 0;
        }
    }

    public static int c(Context context) {
        Display defaultDisplay;
        if (context == null) {
            return 1;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
            gl.Z(V, "Failed to get display orientation info.");
            return context.getResources().getConfiguration().orientation == 2 ? 0 : 1;
        }
        int rotation = defaultDisplay.getRotation();
        if (rotation == 1) {
            return 0;
        }
        if (rotation == 2) {
            return 9;
        }
        return rotation == 3 ? 8 : 1;
    }

    public static boolean d(Context context) {
        if (Build.VERSION.SDK_INT >= 33) {
            return al.Code(context, com.huawei.openalliance.ad.constant.u.cw);
        }
        return true;
    }

    public static int e(Context context) {
        try {
            int identifier = context.getResources().getIdentifier("hw_multiwindow_height_of_drag_bar", "dimen", "androidhwext");
            if (identifier > 0) {
                return context.getResources().getDimensionPixelSize(identifier);
            }
            return 0;
        } catch (Throwable th) {
            gl.I(V, "getMultiWindowDragBarHeight " + th.getClass().getSimpleName());
            return 0;
        }
    }

    private static boolean f(Context context) {
        if (context == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            int b4 = c.b(context);
            gl.Code(V, "isGesture: %s", Integer.valueOf(b4));
            if (b4 != 0) {
                return false;
            }
        } else {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
            boolean z10 = identifier > 0 ? resources.getBoolean(identifier) : false;
            String Code2 = Code("qemu.hw.mainkeys");
            if ("1".equals(Code2)) {
                return false;
            }
            if (!"0".equals(Code2)) {
                return z10;
            }
        }
        return true;
    }

    private static boolean g(Context context) {
        WindowManager windowManager;
        if (context == null || (windowManager = (WindowManager) context.getSystemService("window")) == null) {
            return false;
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        int i10 = displayMetrics.heightPixels;
        int i11 = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics2);
        return i11 - displayMetrics2.widthPixels > 0 || i10 - displayMetrics2.heightPixels > 0;
    }
}
