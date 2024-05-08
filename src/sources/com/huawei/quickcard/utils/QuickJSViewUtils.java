package com.huawei.quickcard.utils;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.android.internal.logging.nano.MetricsProto;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class QuickJSViewUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final int f34302a = 1063;

    /* renamed from: b, reason: collision with root package name */
    private static int f34303b;

    private static boolean a(String str) {
        return "device-width".equals(str) || "-1".equals(str);
    }

    public static int dipSize2IntPx(View view, float f10) {
        if (view == null) {
            return ViewUtils.dip2IntPx(f10);
        }
        Object tag = view.getTag();
        if (a(tag instanceof String ? String.valueOf(tag) : "750")) {
            return ViewUtils.dip2IntPx(view, f10);
        }
        int standardWidth = getStandardWidth(view.getContext());
        if (standardWidth <= 0) {
            return ViewUtils.dip2IntPx(view, f10);
        }
        return (int) ((standardWidth * f10) / a(r0, MetricsProto.MetricsEvent.SETTINGS_LANGUAGE_CATEGORY));
    }

    public static int getStandardWidth(Context context) {
        int i10 = f34303b;
        if (i10 > 0) {
            return i10;
        }
        if (context == null) {
            return -1;
        }
        Resources resources = context.getResources();
        int i11 = resources.getDisplayMetrics().widthPixels;
        return QuickJSCardAppCommon.getMinPlatformVersion() < 1063 ? Math.min(i11, resources.getDisplayMetrics().heightPixels) : i11;
    }

    public static void setStandardWidth(int i10) {
        f34303b = i10;
    }

    private static int a(String str, int i10) {
        if (str == null) {
            return i10;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return i10;
        }
    }
}
