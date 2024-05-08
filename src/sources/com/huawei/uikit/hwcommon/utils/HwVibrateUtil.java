package com.huawei.uikit.hwcommon.utils;

import android.provider.Settings;
import android.view.View;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HwVibrateUtil {
    public static Class<?> A = null;
    public static boolean B = false;
    public static Map<Integer, String> C = new HashMap();
    public static Map<Integer, String> D = new HashMap();
    public static List<Integer> E = new ArrayList(10);
    public static final String HAPTIC_TIME_SCROLL_VIBRATOR = "haptic.control.time_scroll";
    public static final int HWVIBRATE_CROWN_STRENGTH1 = 10;
    public static final int HWVIBRATE_CROWN_STRENGTH2 = 11;
    public static final int HWVIBRATE_CROWN_STRENGTH3 = 12;
    public static final int HWVIBRATE_LONG_PRESS = 0;
    public static final int HWVIBRATE_LONG_PRESS1 = 8;
    public static final int HWVIBRATE_LONG_PRESS2 = 9;
    public static final int HWVIBRATE_SLIDE_TYPE1 = 2;
    public static final int HWVIBRATE_SLIDE_TYPE2 = 3;
    public static final int HWVIBRATE_SLIDE_TYPE3 = 4;
    public static final int HWVIBRATE_SLIDE_TYPE4 = 5;
    public static final int HWVIBRATE_SLIDE_TYPE5 = 6;
    public static final int HWVIBRATE_SLIDE_TYPE6 = 7;
    public static final int HWVIBRATE_THRESHOLD = 1;

    /* renamed from: a, reason: collision with root package name */
    public static final String f34961a = "HwVibrateUtil";

    /* renamed from: b, reason: collision with root package name */
    public static final String f34962b = "haptic.common.long_press";

    /* renamed from: c, reason: collision with root package name */
    public static final String f34963c = "haptic.common.long_press1";

    /* renamed from: d, reason: collision with root package name */
    public static final String f34964d = "haptic.common.long_press2";

    /* renamed from: e, reason: collision with root package name */
    public static final String f34965e = "haptic.common.threshold";

    /* renamed from: f, reason: collision with root package name */
    public static final String f34966f = "haptic.slide.type1";

    /* renamed from: g, reason: collision with root package name */
    public static final String f34967g = "haptic.slide.type2";

    /* renamed from: h, reason: collision with root package name */
    public static final String f34968h = "haptic.slide.type3";

    /* renamed from: i, reason: collision with root package name */
    public static final String f34969i = "haptic.slide.type4";

    /* renamed from: j, reason: collision with root package name */
    public static final String f34970j = "haptic.slide.type5";

    /* renamed from: k, reason: collision with root package name */
    public static final String f34971k = "haptic.slide.type6";

    /* renamed from: l, reason: collision with root package name */
    public static final String f34972l = "watchhaptic.crown.strength1";

    /* renamed from: m, reason: collision with root package name */
    public static final String f34973m = "watchhaptic.crown.strength2";

    /* renamed from: n, reason: collision with root package name */
    public static final String f34974n = "watchhaptic.crown.strength3";

    /* renamed from: o, reason: collision with root package name */
    public static final String f34975o = "com.huawei.android.os.VibratorEx";

    /* renamed from: p, reason: collision with root package name */
    public static final String f34976p = "com.huawei.android.view.ViewEx";

    /* renamed from: q, reason: collision with root package name */
    public static final String f34977q = "com.huawei.android.view.HapticFeedbackConstantsEx";

    /* renamed from: r, reason: collision with root package name */
    public static final String f34978r = "class com.huawei.android.os.VibratorEx";

    /* renamed from: s, reason: collision with root package name */
    public static final int f34979s = 0;

    /* renamed from: t, reason: collision with root package name */
    public static Object f34980t;

    /* renamed from: u, reason: collision with root package name */
    public static Method f34981u;

    /* renamed from: v, reason: collision with root package name */
    public static Method f34982v;

    /* renamed from: w, reason: collision with root package name */
    public static Method f34983w;

    /* renamed from: x, reason: collision with root package name */
    public static Method f34984x;

    /* renamed from: y, reason: collision with root package name */
    public static Class<?> f34985y;

    /* renamed from: z, reason: collision with root package name */
    public static Class<?> f34986z;

    static {
        try {
            C.put(0, f34962b);
            C.put(1, f34965e);
            C.put(2, f34966f);
            C.put(3, f34967g);
            C.put(4, f34968h);
            C.put(5, f34969i);
            C.put(6, f34970j);
            C.put(7, f34971k);
            C.put(8, f34963c);
            C.put(9, f34964d);
            C.put(10, f34972l);
            C.put(11, f34973m);
            C.put(12, f34974n);
            D.put(0, f34962b);
            D.put(1, f34965e);
            D.put(2, HAPTIC_TIME_SCROLL_VIBRATOR);
            D.put(3, HAPTIC_TIME_SCROLL_VIBRATOR);
            D.put(4, HAPTIC_TIME_SCROLL_VIBRATOR);
            D.put(5, HAPTIC_TIME_SCROLL_VIBRATOR);
            D.put(6, HAPTIC_TIME_SCROLL_VIBRATOR);
            D.put(7, f34971k);
            D.put(8, f34963c);
            D.put(9, f34964d);
            D.put(10, f34972l);
            D.put(11, f34973m);
            D.put(12, f34974n);
            Class<?> cls = Class.forName(f34975o);
            f34985y = cls;
            if (!f34978r.equals(cls.toString())) {
                B = true;
            } else {
                f34980t = f34985y.newInstance();
                f34981u = f34985y.getMethod("isSupportHwVibrator", String.class);
                f34982v = f34985y.getMethod("setHwVibrator", String.class);
                f34983w = f34985y.getMethod("stopHwVibrator", String.class);
                f34986z = Class.forName(f34976p);
                A = Class.forName(f34977q);
                Class<?> cls2 = f34986z;
                Class<Integer> cls3 = Integer.TYPE;
                f34984x = cls2.getMethod("performHwHapticFeedback", View.class, cls3, cls3);
                E.add(0, Integer.valueOf(a("HW_LONG_PRESS")));
                E.add(1, Integer.valueOf(a("HW_THRESHOLD")));
                E.add(2, Integer.valueOf(a("HW_SLIDE_1")));
                E.add(3, Integer.valueOf(a("HW_SLIDE_2")));
                E.add(4, Integer.valueOf(a("HW_SLIDE_3")));
                E.add(5, Integer.valueOf(a("HW_SLIDE_4")));
                E.add(6, Integer.valueOf(a("HW_SLIDE_5")));
                E.add(7, Integer.valueOf(a("HW_SLIDE_6")));
                E.add(8, Integer.valueOf(a("HW_LONG_PRESS1")));
                E.add(9, Integer.valueOf(a("HW_LONG_PRESS2")));
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | Exception unused) {
        }
    }

    public static int a(String str) {
        if (B || A == null) {
            return 0;
        }
        return b(str);
    }

    public static int b(String str) {
        try {
            Object obj = A.getField(str).get(null);
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            return 0;
        } catch (IllegalAccessException | NoSuchFieldException unused) {
            return 0;
        }
    }

    public static boolean c(String str) {
        Object obj;
        Method method = f34981u;
        if (method == null || (obj = f34980t) == null) {
            return false;
        }
        try {
            Object invoke = method.invoke(obj, str);
            if (invoke instanceof Boolean) {
                return ((Boolean) invoke).booleanValue();
            }
            return false;
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public static boolean stopVibrator(String str) {
        if (B || f34980t == null || f34983w == null || !c(str)) {
            return false;
        }
        try {
            f34983w.invoke(f34980t, str);
            return true;
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public static boolean vibrator(String str) {
        if (B || str == null || f34980t == null || f34982v == null || !c(str)) {
            return false;
        }
        try {
            f34982v.invoke(f34980t, str);
            return true;
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public static boolean vibratorEx(@NonNull View view, int i10, int i11) {
        if (E.size() != 0 && a(view, i10, i11)) {
            return true;
        }
        if (Settings.System.getInt(view.getContext().getContentResolver(), "haptic_feedback_enabled", 0) == 0) {
            return false;
        }
        return vibrator(D.get(Integer.valueOf(i10)));
    }

    public static boolean a(View view, int i10, int i11) {
        if (f34984x == null || i10 >= E.size() || i10 < 0 || !c(C.get(Integer.valueOf(i10)))) {
            return false;
        }
        try {
            f34984x.invoke(null, view, E.get(i10), Integer.valueOf(i11));
            return true;
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public static boolean vibrator(@NonNull View view, int i10, int i11) {
        if (E.size() == 0 || !a(view, i10, i11)) {
            return vibrator(D.get(Integer.valueOf(i10)));
        }
        return true;
    }
}
