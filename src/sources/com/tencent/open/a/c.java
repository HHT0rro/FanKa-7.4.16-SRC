package com.tencent.open.a;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import java.util.Locale;
import sun.util.locale.LanguageTag;

/* compiled from: ProGuard */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static String f45161a;

    /* renamed from: b, reason: collision with root package name */
    private static String f45162b;

    public static String a() {
        return "";
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f45161a)) {
            return f45161a;
        }
        if (context == null) {
            return "";
        }
        f45161a = "";
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            f45161a = windowManager.getDefaultDisplay().getWidth() + LanguageTag.PRIVATEUSE + windowManager.getDefaultDisplay().getHeight();
        }
        return f45161a;
    }

    public static String b() {
        return Locale.getDefault().getLanguage();
    }

    public static String b(Context context) {
        return "";
    }

    public static String c(Context context) {
        return "";
    }

    public static String d(Context context) {
        return "";
    }

    public static String e(Context context) {
        try {
            if (f45162b == null) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("imei=");
                sb2.append(b(context));
                sb2.append(SymbolValues.CHAR_AND_SYMBOL);
                sb2.append("model=");
                sb2.append(Build.MODEL);
                sb2.append(SymbolValues.CHAR_AND_SYMBOL);
                sb2.append("os=");
                sb2.append(Build.VERSION.RELEASE);
                sb2.append(SymbolValues.CHAR_AND_SYMBOL);
                sb2.append("apilevel=");
                sb2.append(Build.VERSION.SDK_INT);
                sb2.append(SymbolValues.CHAR_AND_SYMBOL);
                String b4 = a.b(context);
                if (b4 == null) {
                    b4 = "";
                }
                sb2.append("network=");
                sb2.append(b4);
                sb2.append(SymbolValues.CHAR_AND_SYMBOL);
                sb2.append("sdcard=");
                sb2.append(Environment.getExternalStorageState().equals("mounted") ? 1 : 0);
                sb2.append(SymbolValues.CHAR_AND_SYMBOL);
                sb2.append("display=");
                sb2.append(displayMetrics.widthPixels);
                sb2.append('*');
                sb2.append(displayMetrics.heightPixels);
                sb2.append(SymbolValues.CHAR_AND_SYMBOL);
                sb2.append("manu=");
                sb2.append(Build.MANUFACTURER);
                sb2.append("&");
                sb2.append("wifi=");
                sb2.append(a.e(context));
                f45162b = sb2.toString();
            }
            return f45162b;
        } catch (Exception unused) {
            return null;
        }
    }
}
