package com.huawei.quickcard.framework.parser;

import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.base.utils.ResourceUtils;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.utils.ExpressionUtils;
import com.huawei.quickcard.utils.FloatUtils;
import com.huawei.quickcard.utils.ViewUtils;
import com.kuaishou.weapon.p0.t;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ParserHelper {
    public static <T extends Enum<T>> T object2Enum(Class<T> cls, Object obj, T t2) {
        if (obj != null) {
            String obj2 = obj.toString();
            try {
                return (T) Enum.valueOf(cls, obj2.toUpperCase(Locale.ENGLISH));
            } catch (IllegalArgumentException unused) {
                CardLogUtils.w("ParserHelper", "enum " + obj2 + " is not support, use default value");
            }
        }
        return t2;
    }

    public static QuickCardValue parseToBool(Object obj) {
        return parseToBool(obj, false);
    }

    public static QuickCardValue parseToColor(Object obj, int i10) {
        String str = obj instanceof String ? (String) obj : null;
        if (str != null) {
            i10 = ResourceUtils.getColor(str, i10);
        }
        return new QuickCardValue.NumberValue(Integer.valueOf(i10));
    }

    public static QuickCardValue parseToDP(Object obj, float f10) {
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            return new QuickCardValue.DpValue(f10);
        }
        if (str.endsWith(t.f36232q)) {
            return new QuickCardValue.DpValue(ViewUtils.parseFloat(str.substring(0, str.length() - 2), 0.0f));
        }
        if (str.endsWith("px")) {
            return new QuickCardValue.PxValue(ViewUtils.parseFloat(str.substring(0, str.length() - 2), 0.0f));
        }
        return new QuickCardValue.DpValue(f10);
    }

    public static QuickCardValue parseToJsonArray(Object obj) {
        JSONArray jSONArray;
        if (obj instanceof JSONArray) {
            jSONArray = (JSONArray) obj;
        } else {
            if (obj instanceof String) {
                try {
                    jSONArray = new JSONArray((String) obj);
                } catch (JSONException e2) {
                    CardLogUtils.w("ParserHelper", "parse str to json array failed.", e2);
                }
            }
            jSONArray = null;
        }
        return new QuickCardValue.JSONArrayValue(jSONArray);
    }

    public static QuickCardValue parseToJsonObject(Object obj) {
        JSONObject jSONObject;
        if (obj instanceof JSONObject) {
            jSONObject = (JSONObject) obj;
        } else {
            if (obj instanceof String) {
                try {
                    jSONObject = new JSONObject((String) obj);
                } catch (JSONException e2) {
                    CardLogUtils.w("ParserHelper", "parse str to json object failed.", e2);
                }
            }
            jSONObject = null;
        }
        return new QuickCardValue.JSONValue(jSONObject);
    }

    public static QuickCardValue parseToNumber(Object obj, Number number) {
        if (obj instanceof Number) {
            number = (Number) obj;
        }
        if (obj instanceof String) {
            try {
                number = Double.valueOf((String) obj);
            } catch (NumberFormatException e2) {
                CardLogUtils.w("ParserHelper", "parse str to Number failed.", e2);
            }
        }
        return new QuickCardValue.NumberValue(number);
    }

    public static QuickCardValue parseToRatio(Object obj, float f10) {
        if (obj instanceof Number) {
            return new QuickCardValue.NumberValue(Float.valueOf(((Number) obj).floatValue()));
        }
        String obj2 = obj instanceof String ? obj.toString() : null;
        if (obj2 == null) {
            return new QuickCardValue.NumberValue(Float.valueOf(f10));
        }
        String[] split = obj2.split("[/:]", 2);
        if (split.length == 2) {
            float parse = FloatUtils.parse(split[0], Float.NaN);
            float parse2 = FloatUtils.parse(split[1], Float.NaN);
            if (!Float.isNaN(parse) && !Float.isNaN(parse2)) {
                f10 = parse / parse2;
            }
            return new QuickCardValue.NumberValue(Float.valueOf(f10));
        }
        return new QuickCardValue.NumberValue(Float.valueOf(FloatUtils.parse(split[0], f10)));
    }

    public static QuickCardValue parseToSP(Object obj, float f10) {
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.endsWith("sp")) {
                return new QuickCardValue.SpValue(ViewUtils.parseFloat(str.substring(0, str.length() - 2), 0.0f));
            }
            if (str.endsWith(t.f36232q)) {
                return new QuickCardValue.DpValue(ViewUtils.parseFloat(str.substring(0, str.length() - 2), 0.0f));
            }
            if (str.endsWith("px")) {
                return new QuickCardValue.PxValue(ViewUtils.parseFloat(str.substring(0, str.length() - 2), 0.0f));
            }
            return new QuickCardValue.SpValue(f10);
        }
        return new QuickCardValue.SpValue(f10);
    }

    public static QuickCardValue parseToSize(Object obj) {
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            return new QuickCardValue.ObjectValue(obj);
        }
        if (str.endsWith("%")) {
            return new QuickCardValue.Percent(ViewUtils.parseFloat(str.substring(0, str.indexOf("%")), 0.0f) / 100.0f);
        }
        if (str.endsWith(t.f36232q)) {
            return new QuickCardValue.DpValue(ViewUtils.parseFloat(str.substring(0, str.length() - 2), 0.0f));
        }
        if (str.endsWith("px")) {
            return new QuickCardValue.PxValue(ViewUtils.parseFloat(str.substring(0, str.length() - 2), 0.0f));
        }
        return new QuickCardValue.ObjectValue(obj);
    }

    public static QuickCardValue parseToString(Object obj, String str) {
        if (obj != null) {
            str = obj.toString();
        }
        return new QuickCardValue.StringValue(str);
    }

    public static QuickCardValue parseToBool(Object obj, boolean z10) {
        return new QuickCardValue.BooleanValue("false".equals(String.valueOf(obj)) ? false : ExpressionUtils.isTrue(obj, z10));
    }
}
