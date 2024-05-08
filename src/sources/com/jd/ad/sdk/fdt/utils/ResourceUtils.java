package com.jd.ad.sdk.fdt.utils;

import android.content.Context;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.framework.bean.CardElement;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class ResourceUtils {
    public static int getAnimId(Context context, String str) {
        return getResourceId(context, str, "anim");
    }

    public static int getAnimatorId(Context context, String str) {
        return getResourceId(context, str, "animator");
    }

    public static int getAttrId(Context context, String str) {
        return getResourceId(context, str, CardElement.Field.ATTRIBUTES);
    }

    public static int getBoolId(Context context, String str) {
        return getResourceId(context, str, "bool");
    }

    public static int getColorId(Context context, String str) {
        return getResourceId(context, str, "color");
    }

    public static int getComponentId(Context context, String str) {
        return getResourceId(context, str, "id");
    }

    public static int getDimenId(Context context, String str) {
        return getResourceId(context, str, "dimen");
    }

    public static int getDrawableId(Context context, String str) {
        return getResourceId(context, str, "drawable");
    }

    public static int getIntegerId(Context context, String str) {
        return getResourceId(context, str, "integer");
    }

    public static int getInterpolatorId(Context context, String str) {
        return getResourceId(context, str, "interpolator");
    }

    public static int getLayoutId(Context context, String str) {
        return getResourceId(context, str, "layout");
    }

    public static int getMipmapId(Context context, String str) {
        return getResourceId(context, str, "mipmap");
    }

    public static int getPluralsId(Context context, String str) {
        return getResourceId(context, str, "plurals");
    }

    public static int getResourceId(Context context, String str, String str2) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, str2, context.getPackageName());
    }

    public static int getStringId(Context context, String str) {
        return getResourceId(context, str, Attributes.TextOverflow.STRING);
    }

    public static int getStyleId(Context context, String str) {
        return getResourceId(context, str, "style");
    }

    public static int getStyleableId(Context context, String str) {
        return getResourceId(context, str, "styleable");
    }

    public static int getXmlId(Context context, String str) {
        return getResourceId(context, str, "xml");
    }
}
