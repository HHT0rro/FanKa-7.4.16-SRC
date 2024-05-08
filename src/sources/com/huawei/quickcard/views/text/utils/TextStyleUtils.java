package com.huawei.quickcard.views.text.utils;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import com.hailiang.advlib.core.ADEvent;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.base.utils.JsonUtils;
import com.huawei.quickcard.k1;
import com.huawei.quickcard.utils.SystemUtils;
import com.huawei.quickcard.v1;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class TextStyleUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final String f34676a = "TextStyleUtils";

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f34677b = Pattern.compile("\"([^\"]*)\"");

    private static Typeface a(JSONArray jSONArray) {
        String str = null;
        if (jSONArray.length() <= 0) {
            return null;
        }
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                String string = JsonUtils.getString(jSONObject, "fontFamily");
                String string2 = JsonUtils.getString(jSONObject, "src");
                str = !TextUtils.isEmpty(string2) ? a(string2) : string;
                if (!TextUtils.isEmpty(str)) {
                    break;
                }
            } catch (JSONException e2) {
                CardLogUtils.e(f34676a, "parse font family error", e2);
                return Typeface.DEFAULT;
            }
        }
        return Typeface.create(str, 0);
    }

    private static int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 400;
        }
        if (ADEvent.PRICE_FILTER.equals(str)) {
            return 100;
        }
        if ("200".equals(str) || "lighter".equals(str)) {
            return 200;
        }
        if ("300".equals(str)) {
            return 300;
        }
        if ("400".equals(str) || "normal".equals(str) || "regular".equals(str)) {
            return 400;
        }
        if ("500".equals(str) || "medium".equals(str)) {
            return 500;
        }
        if ("600".equals(str)) {
            return 600;
        }
        if ("700".equals(str) || "bold".equals(str)) {
            return 700;
        }
        if ("800".equals(str) || "bolder".equals(str)) {
            return 800;
        }
        return "900".equals(str) ? 900 : 400;
    }

    private static int c(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return isFontWeightBold(str) ? 1 : 0;
    }

    public static Typeface getFontFamily(Object obj) {
        if (obj instanceof JSONArray) {
            return a((JSONArray) obj);
        }
        String str = obj instanceof String ? (String) obj : null;
        if (!TextUtils.isEmpty(str)) {
            if ("sans-serif".equals(str)) {
                return Typeface.SANS_SERIF;
            }
            if ("serif".equals(str)) {
                return Typeface.SERIF;
            }
            if ("monospace".equals(str)) {
                return Typeface.MONOSPACE;
            }
        }
        return Typeface.DEFAULT;
    }

    public static int getFontStyle(String str) {
        return "italic".equals(str) ? 2 : 0;
    }

    public static int getFontWeight(String str) {
        if (SystemUtils.isOverAPI28()) {
            return b(str);
        }
        return c(str);
    }

    public static k1 getLineHeightSpan(int i10) {
        return new k1(i10);
    }

    public static CharacterStyle getTextDecoration(String str) {
        return new v1(str);
    }

    public static boolean isFontWeightBold(String str) {
        return "bold".equals(str) || "bolder".equals(str) || "500".equals(str) || "600".equals(str) || "700".equals(str) || "800".equals(str) || "900".equals(str);
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.trim().split(",");
        if (split.length <= 0) {
            return "";
        }
        Matcher matcher = f34677b.matcher(split[0]);
        return matcher.find() ? matcher.group(1) : "";
    }
}
