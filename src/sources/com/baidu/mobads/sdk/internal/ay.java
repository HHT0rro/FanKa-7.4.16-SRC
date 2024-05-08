package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ay {

    /* renamed from: a, reason: collision with root package name */
    private static DisplayMetrics f9851a;

    /* renamed from: b, reason: collision with root package name */
    private static float f9852b;

    public static Rect a(Context context) {
        DisplayMetrics f10 = f(context);
        try {
            if (f10.widthPixels > f10.heightPixels) {
                return new Rect(0, 0, f10.heightPixels, f10.widthPixels);
            }
            return new Rect(0, 0, f10.widthPixels, f10.heightPixels);
        } catch (Exception unused) {
            return null;
        }
    }

    public static int b(Context context) {
        return a(context).width();
    }

    public static int c(Context context) {
        return a(context).height();
    }

    public static Rect d(Context context) {
        DisplayMetrics f10 = f(context);
        return new Rect(0, 0, f10.widthPixels, f10.heightPixels);
    }

    public static float e(Context context) {
        if (f9852b < 0.01d) {
            f9852b = f(context).density;
        }
        return f9852b;
    }

    public static DisplayMetrics f(Context context) {
        try {
            DisplayMetrics displayMetrics = f9851a;
            if (displayMetrics != null && displayMetrics.widthPixels > 0) {
                return displayMetrics;
            }
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            if (bk.a(context).a() >= 17) {
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics2);
            } else {
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics2);
            }
            f9851a = displayMetrics2;
        } catch (Throwable th) {
            f9851a = new DisplayMetrics();
            bs.a().a(th);
        }
        return f9851a;
    }

    public static int g(Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
    }

    public static int b(Context context, int i10) {
        try {
            return (int) (i10 * e(context));
        } catch (Exception unused) {
            return i10;
        }
    }

    public static int b(Context context, float f10) {
        return (int) ((f10 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int a(Context context, int i10) {
        try {
            return (int) (i10 / e(context));
        } catch (Exception unused) {
            return i10;
        }
    }

    public static int a(Context context, float f10) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
