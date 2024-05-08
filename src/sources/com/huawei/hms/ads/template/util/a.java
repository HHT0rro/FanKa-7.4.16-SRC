package com.huawei.hms.ads.template.util;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.TypedValue;
import android.view.ViewGroup;
import com.alipay.sdk.util.i;
import com.huawei.flexiblelayout.css.adapter.value.integrate.align.CSSAlignValue;
import com.huawei.hms.ads.gl;
import com.huawei.quickcard.base.Attributes;
import com.kuaishou.weapon.p0.t;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class a {
    private static final String Code = "a";

    public static int Code(int i10) {
        if (i10 == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return i10 > 0 ? i10 : -i10;
    }

    public static int Code(String str) {
        String lowerCase = str.toLowerCase(Locale.US);
        lowerCase.hashCode();
        char c4 = 65535;
        switch (lowerCase.hashCode()) {
            case -1901805651:
                if (lowerCase.equals("invisible")) {
                    c4 = 0;
                    break;
                }
                break;
            case 3178655:
                if (lowerCase.equals("gone")) {
                    c4 = 1;
                    break;
                }
                break;
            case 466743410:
                if (lowerCase.equals(Attributes.Visibility.VISIBLE)) {
                    c4 = 2;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return 4;
            case 1:
                return 8;
            case 2:
            default:
                return 0;
        }
    }

    public static int Code(String str, int i10) {
        if (str.startsWith("#")) {
            try {
                return Color.parseColor(str);
            } catch (IllegalArgumentException e2) {
                gl.I(Code, "parseColorFromString - " + e2.getClass().getSimpleName());
            }
        }
        return i10;
    }

    public static int Code(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.endsWith(t.f36232q)) {
            return V(str, context, 0);
        }
        if (str.endsWith("sp")) {
            return Code(str, context, 0);
        }
        if (str.endsWith("px")) {
            return V(str, 0);
        }
        return 0;
    }

    private static int Code(String str, Context context, int i10) {
        if (str.indexOf("sp") > 0) {
            String substring = str.substring(0, str.length() - 2);
            try {
                return (int) TypedValue.applyDimension(2, substring.contains(".") ? Float.parseFloat(substring) : Integer.parseInt(substring), context.getResources().getDisplayMetrics());
            } catch (NumberFormatException unused) {
                gl.I(Code, "processSpSize - error in parse int");
            }
        }
        return i10;
    }

    public static Pair<Integer, Integer> Code(AttributeSet attributeSet, Context context) {
        String attributeValue = attributeSet.getAttributeValue(null, "layout_width");
        String attributeValue2 = attributeSet.getAttributeValue(null, "layout_height");
        gl.Code(Code, "generateLayoutParams layoutWidth: %s layoutHeight: %s", attributeValue, attributeValue2);
        return new Pair<>(Integer.valueOf(V(attributeValue, context)), Integer.valueOf(V(attributeValue2, context)));
    }

    public static void Code(Context context, ViewGroup.MarginLayoutParams marginLayoutParams, AttributeSet attributeSet) {
        if (attributeSet == null || marginLayoutParams == null) {
            return;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "layout_margin");
        if (!TextUtils.isEmpty(attributeValue)) {
            int Code2 = Code(attributeValue, context);
            marginLayoutParams.setMargins(Code2, Code2, Code2, Code2);
        }
        String attributeValue2 = attributeSet.getAttributeValue(null, "layout_marginStart");
        if (!TextUtils.isEmpty(attributeValue2)) {
            marginLayoutParams.setMarginStart(Code(attributeValue2, context));
        }
        String attributeValue3 = attributeSet.getAttributeValue(null, "layout_marginEnd");
        if (!TextUtils.isEmpty(attributeValue3)) {
            marginLayoutParams.setMarginEnd(Code(attributeValue3, context));
        }
        int i10 = marginLayoutParams.leftMargin;
        int i11 = marginLayoutParams.rightMargin;
        int i12 = marginLayoutParams.topMargin;
        int i13 = marginLayoutParams.bottomMargin;
        String attributeValue4 = attributeSet.getAttributeValue(null, "layout_marginLeft");
        if (!TextUtils.isEmpty(attributeValue4)) {
            i10 = Code(attributeValue4, context);
        }
        String attributeValue5 = attributeSet.getAttributeValue(null, "layout_marginRight");
        if (!TextUtils.isEmpty(attributeValue5)) {
            i11 = Code(attributeValue5, context);
        }
        String attributeValue6 = attributeSet.getAttributeValue(null, "layout_marginTop");
        if (!TextUtils.isEmpty(attributeValue6)) {
            i12 = Code(attributeValue6, context);
        }
        String attributeValue7 = attributeSet.getAttributeValue(null, "layout_marginBottom");
        if (!TextUtils.isEmpty(attributeValue7)) {
            i13 = Code(attributeValue7, context);
        }
        marginLayoutParams.setMargins(i10, i12, i11, i13);
    }

    public static String I(String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 3 || !str.startsWith("#{") || !str.endsWith(i.f4738d)) {
            return null;
        }
        return str.substring(2, str.length() - 1);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int V(String str) {
        char c4;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        str.hashCode();
        switch (str.hashCode()) {
            case -1383228885:
                if (str.equals("bottom")) {
                    c4 = 0;
                    break;
                }
                c4 = 65535;
                break;
            case -1364013995:
                if (str.equals(CSSAlignValue.AlignKey.CENTER)) {
                    c4 = 1;
                    break;
                }
                c4 = 65535;
                break;
            case -348726240:
                if (str.equals("center_vertical")) {
                    c4 = 2;
                    break;
                }
                c4 = 65535;
                break;
            case 100571:
                if (str.equals("end")) {
                    c4 = 3;
                    break;
                }
                c4 = 65535;
                break;
            case 115029:
                if (str.equals("top")) {
                    c4 = 4;
                    break;
                }
                c4 = 65535;
                break;
            case 3317767:
                if (str.equals("left")) {
                    c4 = 5;
                    break;
                }
                c4 = 65535;
                break;
            case 108511772:
                if (str.equals("right")) {
                    c4 = 6;
                    break;
                }
                c4 = 65535;
                break;
            case 109757538:
                if (str.equals("start")) {
                    c4 = 7;
                    break;
                }
                c4 = 65535;
                break;
            case 1063616078:
                if (str.equals("center_horizontal")) {
                    c4 = '\b';
                    break;
                }
                c4 = 65535;
                break;
            default:
                c4 = 65535;
                break;
        }
        switch (c4) {
            case 0:
                return 80;
            case 1:
                return 17;
            case 2:
                return 16;
            case 3:
                return 8388613;
            case 4:
                return 48;
            case 5:
                return 3;
            case 6:
                return 5;
            case 7:
                return 8388611;
            case '\b':
                return 1;
            default:
                return -1;
        }
    }

    private static int V(String str, int i10) {
        if (str.indexOf("px") > 0) {
            String substring = str.substring(0, str.length() - 2);
            try {
                return (int) (substring.contains(".") ? Float.parseFloat(substring) : Integer.parseInt(substring));
            } catch (NumberFormatException unused) {
                gl.I(Code, "processSpSize - error in parse int");
            }
        }
        return i10;
    }

    private static int V(String str, Context context) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "match_parent")) {
            return -1;
        }
        if (TextUtils.equals(str, "wrap_content")) {
            return -2;
        }
        if (str.endsWith(t.f36232q)) {
            return V(str, context, -2);
        }
        if (str.endsWith("sp")) {
            return Code(str, context, -2);
        }
        if (str.endsWith("px")) {
            return V(str, -2);
        }
        return -2;
    }

    private static int V(String str, Context context, int i10) {
        if (str.indexOf(t.f36232q) > 0) {
            String substring = str.substring(0, str.length() - 2);
            try {
                return (int) TypedValue.applyDimension(1, substring.contains(".") ? Float.parseFloat(substring) : Integer.parseInt(substring), context.getResources().getDisplayMetrics());
            } catch (NumberFormatException unused) {
                gl.I(Code, "processDpSize - error in parse int");
            }
        }
        return i10;
    }
}
