package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.WindowManager;
import com.hihonor.android.os.Build;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class c {
    private static final int B = 81;
    private static final int C = 90;
    private static final int Code = 32;
    private static final int D = 655;
    private static final int F = 720;
    private static final int I = 68;
    private static final int L = 632;
    private static final int S = 400;
    private static final int V = 50;
    private static final int Z = 60;

    /* renamed from: a, reason: collision with root package name */
    private static final int f32584a = 526;

    /* renamed from: b, reason: collision with root package name */
    private static final int f32585b = 432;

    /* renamed from: c, reason: collision with root package name */
    private static final int f32586c = 320;

    /* renamed from: d, reason: collision with root package name */
    private static final int f32587d = 468;

    /* renamed from: e, reason: collision with root package name */
    private static final int f32588e = 728;

    /* renamed from: f, reason: collision with root package name */
    private static final float f32589f = 0.15f;

    /* renamed from: g, reason: collision with root package name */
    private static final float f32590g = 0.12362637f;

    /* renamed from: h, reason: collision with root package name */
    private static final float f32591h = 0.12820514f;

    /* renamed from: i, reason: collision with root package name */
    private static final float f32592i = 0.15625f;

    /* renamed from: j, reason: collision with root package name */
    private static final String f32593j = "ex_splash_func_status";

    /* renamed from: k, reason: collision with root package name */
    private static final String f32594k = "ex_splash_list";

    /* renamed from: l, reason: collision with root package name */
    private static final String f32595l = "ex_splash_block_list";

    /* renamed from: m, reason: collision with root package name */
    private static final String f32596m = "c";

    public static int B(Context context) {
        if (context == null) {
            return 0;
        }
        int Code2 = Code(context);
        int V2 = V(context);
        return Code2 > V2 ? Code2 : V2;
    }

    public static int B(Context context, int i10) {
        return i10 == 0 ? B(context) : Z(context);
    }

    public static int C(Context context, int i10) {
        return i10 == 0 ? Z(context) : B(context);
    }

    public static DisplayMetrics C(Context context) {
        WindowManager windowManager;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (context == null || (windowManager = (WindowManager) context.getSystemService("window")) == null) {
            return displayMetrics;
        }
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics;
    }

    public static int Code(int i10, int i11) {
        float f10;
        float f11;
        int i12;
        int min = Math.min(90, Math.round(i11 * f32589f));
        if (i10 > 432) {
            if (i10 <= 526) {
                i12 = 68;
            } else if (i10 <= 632) {
                f10 = i10;
                f11 = f32591h;
            } else if (i10 <= 655) {
                i12 = 81;
            } else {
                f10 = i10;
                f11 = f32590g;
            }
            return Math.max(Math.min(i12, min), 50);
        }
        f10 = i10;
        f11 = f32592i;
        i12 = Math.round(f10 * f11);
        return Math.max(Math.min(i12, min), 50);
    }

    public static int Code(Context context) {
        if (context == null) {
            return 0;
        }
        return C(context).heightPixels;
    }

    public static int Code(Context context, int i10) {
        int I2 = v.I(context, i10);
        if (I2 == 0) {
            return 0;
        }
        return v.V(context, I2 <= 432 ? 50 : I2 <= 632 ? 60 : 90);
    }

    private static int Code(DisplayMetrics displayMetrics, Configuration configuration, int i10, int i11) {
        if (i10 == 0) {
            i10 = configuration.orientation;
        }
        int i12 = displayMetrics.heightPixels;
        int i13 = displayMetrics.widthPixels;
        int i14 = i12 > i13 ? i12 : i13;
        if (i12 >= i13) {
            i12 = i13;
        }
        return i10 == 1 ? i14 - i11 : i12;
    }

    public static String Code() {
        return Locale.getDefault().getLanguage();
    }

    private static void Code(final am amVar, final Context context) {
        f.I(new Runnable() { // from class: com.huawei.openalliance.ad.utils.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.huawei.openalliance.ad.ipc.g.V(context).Code(com.huawei.openalliance.ad.constant.q.f32333p, "", new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.utils.c.1.1
                    @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                    public void onRemoteCallResult(String str, CallResult<String> callResult) {
                        if (callResult.getCode() != 200) {
                            gl.V(c.f32596m, "requestUuid failed");
                        } else {
                            gl.V(c.f32596m, "requestUuid success");
                            amVar.Code(callResult.getData());
                        }
                    }
                }, String.class);
            }
        });
    }

    public static boolean Code(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        if (dVar == null) {
            return false;
        }
        String h10 = dVar.h();
        if (TextUtils.isEmpty(h10)) {
            h10 = dVar.g();
        }
        return v.Code(context, h10);
    }

    public static int D(Context context) {
        if (context == null) {
            return 0;
        }
        if (C(context).density == 0.0f) {
            return 0;
        }
        int I2 = v.I(context, r1.widthPixels);
        int Z2 = Z(context, 0);
        if (I2 == 0 || Z2 == 0) {
            return 0;
        }
        return Code(I2, Z2);
    }

    public static int F(Context context) {
        if (context == null) {
            return 0;
        }
        return v.V(context, D(context));
    }

    public static int I(Context context) {
        if (context == null) {
            return 0;
        }
        return v.I(context, Z(context));
    }

    public static int I(Context context, int i10) {
        return (int) TypedValue.applyDimension(1, i10, C(context));
    }

    public static boolean I() {
        try {
            if (!Build.MANUFACTURER.equalsIgnoreCase("HONOR") || Build.VERSION.SDK_INT < 31) {
                return false;
            }
            return Build.VERSION.MAGIC_SDK_INT >= 33;
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("isHonor6UpPhone Error:");
            sb2.append(th.getClass().getSimpleName());
            return false;
        }
    }

    public static boolean L(Context context) {
        if (context != null) {
            String packageName = context.getPackageName();
            if (!TextUtils.isEmpty(packageName)) {
                try {
                    String string = Settings.Global.getString(context.getContentResolver(), f32595l);
                    if ((!TextUtils.isEmpty(string) && Arrays.asList(string.split(";")).contains(packageName)) || Settings.Global.getInt(context.getContentResolver(), f32593j, 0) == 0) {
                        return false;
                    }
                    String string2 = Settings.Global.getString(context.getContentResolver(), f32594k);
                    if (TextUtils.isEmpty(string2)) {
                        return false;
                    }
                    return Arrays.asList(string2.split(";")).contains(packageName);
                } catch (Throwable th) {
                    gl.I(f32596m, "exception happen: " + th.getClass().getSimpleName());
                }
            }
        }
        return false;
    }

    public static int S(Context context) {
        if (context == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float f10 = displayMetrics.heightPixels;
        float f11 = displayMetrics.density;
        int i10 = (int) (f10 / f11);
        return (int) ((i10 > 720 ? 90 : i10 > 400 ? 50 : 32) * f11);
    }

    public static int V(Context context) {
        if (context == null) {
            return 0;
        }
        return C(context).widthPixels;
    }

    public static int V(Context context, int i10) {
        int I2 = v.I(context, i10);
        if (I2 == 0) {
            return 0;
        }
        return v.V(context, I2 <= 432 ? 320 : I2 <= 632 ? 468 : 728);
    }

    public static String V() {
        return Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry();
    }

    public static int Z(Context context) {
        if (context == null) {
            return 0;
        }
        int Code2 = Code(context);
        int V2 = V(context);
        return Code2 > V2 ? V2 : Code2;
    }

    public static int Z(Context context, int i10) {
        Configuration configuration;
        if (context == null) {
            return 0;
        }
        DisplayMetrics C2 = C(context);
        Resources resources = context.getResources();
        if (resources == null || (configuration = resources.getConfiguration()) == null) {
            return 0;
        }
        return Math.round(Code(C2, configuration, i10, ay.I(context)) / C2.density);
    }

    public static float a(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (displayMetrics != null) {
                return displayMetrics.density;
            }
            return 0.0f;
        } catch (RuntimeException | Exception unused) {
            gl.I(f32596m, "getDensity fail");
            return 0.0f;
        }
    }

    public static int b(Context context) {
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "secure_gesture_navigation", 0);
        } catch (Throwable th) {
            gl.I(f32596m, "exception happen: " + th.getClass().getSimpleName());
            return 0;
        }
    }

    public static String c(Context context) {
        am Code2 = am.Code(context);
        Code(Code2, context.getApplicationContext());
        return Code2.I();
    }

    public static Integer d(final Context context) {
        Integer b4 = am.Code(context).b();
        if (b4 != null) {
            return b4;
        }
        final Integer b10 = v.b(context);
        f.I(new Runnable() { // from class: com.huawei.openalliance.ad.utils.c.2
            @Override // java.lang.Runnable
            public void run() {
                am.Code(context).Code(b10);
            }
        });
        return b10;
    }
}
