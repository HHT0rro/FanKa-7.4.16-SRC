package com.kwad.sdk.api.core;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.framework.bean.CardElement;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
class ResUtil {
    public static int getAttrId(Context context, String str) {
        return getIdentifier(context, str, CardElement.Field.ATTRIBUTES);
    }

    public static int getColor(Context context, String str) {
        return getResources(context).getColor(getIdentifier(context, str, "color"));
    }

    public static int getDimenId(Context context, String str) {
        return getIdentifier(context, str, "dimen");
    }

    public static Drawable getDrawable(Context context, String str) {
        return getResources(context).getDrawable(getIdentifier(context, str, "drawable"));
    }

    public static int getDrawableId(Context context, String str) {
        return getIdentifier(context, str, "drawable");
    }

    public static int getId(Context context, String str) {
        return getIdentifier(context, str, "id");
    }

    private static int getIdentifier(Context context, String str, String str2) {
        return getResources(context).getIdentifier(str, str2, getPackageName(context));
    }

    public static int getLayoutId(Context context, String str) {
        return getIdentifier(context, str, "layout");
    }

    private static String getPackageName(Context context) {
        return context.getPackageName();
    }

    public static int getRawId(Context context, String str) {
        return getIdentifier(context, str, "raw");
    }

    private static Resources getResources(Context context) {
        return context.getResources();
    }

    public static String getString(Context context, String str) {
        return getResources(context).getString(getIdentifier(context, str, Attributes.TextOverflow.STRING));
    }

    public static int getStyleId(Context context, String str) {
        return getIdentifier(context, str, "style");
    }
}
