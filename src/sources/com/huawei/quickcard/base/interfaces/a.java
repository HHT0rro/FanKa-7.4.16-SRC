package com.huawei.quickcard.base.interfaces;

import com.huawei.quickcard.base.wrapper.WrapDataUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final /* synthetic */ class a {
    public static boolean a(CardDataObject cardDataObject, String str, boolean z10) {
        Object obj = cardDataObject.get(str);
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z10;
    }

    public static CardDataObject b(CardDataObject cardDataObject, String str) {
        Object wrap = WrapDataUtils.wrap(cardDataObject.get(str));
        if (wrap instanceof CardDataObject) {
            return (CardDataObject) wrap;
        }
        return null;
    }

    public static Double c(CardDataObject cardDataObject, String str) {
        Object obj = cardDataObject.get(str);
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        return null;
    }

    public static double d(CardDataObject cardDataObject, String str, double d10) {
        Object obj = cardDataObject.get(str);
        return obj instanceof Number ? ((Number) obj).doubleValue() : d10;
    }

    public static int e(CardDataObject cardDataObject, String str, int i10) {
        Object obj = cardDataObject.get(str);
        return obj instanceof Number ? ((Number) obj).intValue() : i10;
    }

    public static Integer f(CardDataObject cardDataObject, String str) {
        Object obj = cardDataObject.get(str);
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        return null;
    }

    public static String g(CardDataObject cardDataObject, int i10) {
        return cardDataObject.getString(i10, (String) null);
    }

    public static String h(CardDataObject cardDataObject, int i10, String str) {
        Object obj = cardDataObject.get(i10);
        return obj != null ? obj.toString() : str;
    }

    public static String i(CardDataObject cardDataObject, String str) {
        return cardDataObject.getString(str, (String) null);
    }

    public static String j(CardDataObject cardDataObject, String str, String str2) {
        Object obj = cardDataObject.get(str);
        return obj != null ? obj.toString() : str2;
    }
}
