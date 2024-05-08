package com.huawei.hms.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.quickcard.base.Attributes;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class ResourceLoaderUtil {

    /* renamed from: a, reason: collision with root package name */
    private static Context f31974a;

    /* renamed from: b, reason: collision with root package name */
    private static String f31975b;

    public static int getAnimId(String str) {
        Context context = f31974a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "anim", f31975b);
    }

    public static int getColorId(String str) {
        Context context = f31974a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "color", f31975b);
    }

    public static int getDimenId(String str) {
        Context context = f31974a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "dimen", f31975b);
    }

    public static Drawable getDrawable(String str) {
        Context context = f31974a;
        if (context == null) {
            return null;
        }
        return context.getResources().getDrawable(getDrawableId(str));
    }

    public static int getDrawableId(String str) {
        Context context = f31974a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "drawable", f31975b);
    }

    public static int getIdId(String str) {
        Context context = f31974a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "id", f31975b);
    }

    public static int getLayoutId(String str) {
        Context context = f31974a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "layout", f31975b);
    }

    public static String getString(String str) {
        Context context = f31974a;
        return context == null ? "" : context.getResources().getString(getStringId(str));
    }

    public static int getStringId(String str) {
        Context context = f31974a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, Attributes.TextOverflow.STRING, f31975b);
    }

    public static int getStyleId(String str) {
        Context context = f31974a;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, "style", f31975b);
    }

    public static Context getmContext() {
        return f31974a;
    }

    public static void setmContext(Context context) {
        f31974a = context;
        if (context != null) {
            f31975b = context.getPackageName();
        } else {
            f31975b = null;
            HMSLog.e("ResourceLoaderUtil", "context is null");
        }
    }

    public static String getString(String str, Object... objArr) {
        Context context = f31974a;
        return context == null ? "" : context.getResources().getString(getStringId(str), objArr);
    }
}
