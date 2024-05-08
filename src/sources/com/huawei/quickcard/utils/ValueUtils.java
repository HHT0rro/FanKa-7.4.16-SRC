package com.huawei.quickcard.utils;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.QuickCardRoot;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.core.R;
import com.huawei.quickcard.framework.condition.ConditionalData;
import com.huawei.quickcard.framework.processor.PropertyCacheBean;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ValueUtils {
    public static ConditionalData getConditionalData(View view) {
        if (view == null) {
            return null;
        }
        return obtainPropertyCacheBeanFromView(view).getConditionalData();
    }

    public static float getFloatFromMap(Map map, float f10, String... strArr) {
        Float floatFromMap = getFloatFromMap(map, strArr);
        return floatFromMap != null ? floatFromMap.floatValue() : f10;
    }

    public static Object getFromMap(Map map, String... strArr) {
        if (map == null || strArr == null || strArr.length == 0) {
            return null;
        }
        for (int i10 = 0; i10 < strArr.length - 1; i10++) {
            Object obj = map.get(strArr[i10]);
            if (!(obj instanceof Map)) {
                return null;
            }
            map = (Map) obj;
        }
        return map.get(strArr[strArr.length - 1]);
    }

    public static int getIntegerFromMap(Map map, int i10, String... strArr) {
        Integer integerFromMap = getIntegerFromMap(map, strArr);
        return integerFromMap != null ? integerFromMap.intValue() : i10;
    }

    @NonNull
    public static PropertyCacheBean obtainPropertyCacheBeanFromView(@NonNull View view) {
        int i10 = R.id.quick_card_properties;
        Object tag = view.getTag(i10);
        if (!(tag instanceof PropertyCacheBean)) {
            tag = new PropertyCacheBean();
            view.setTag(i10, tag);
        }
        return (PropertyCacheBean) tag;
    }

    public static PropertyCacheBean obtainRootPropertyCacheBeanFromView(@NonNull View view) {
        QuickCardRoot root;
        ViewGroup rootViewGroup;
        CardContext cardContext = ViewUtils.getCardContext(view);
        if (cardContext == null || (root = cardContext.getRoot()) == null || (rootViewGroup = root.getRootViewGroup()) == null) {
            return null;
        }
        return obtainPropertyCacheBeanFromView(rootViewGroup);
    }

    public static Float parseFloat(String str) {
        return parseFloat(str, null);
    }

    public static Integer parseInteger(String str) {
        try {
            return Integer.valueOf(Integer.parseInt(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static float parseToFloat(Object obj, float f10) {
        if (obj instanceof Number) {
            f10 = ((Number) obj).floatValue();
        }
        if (!(obj instanceof String)) {
            return f10;
        }
        try {
            return Float.parseFloat((String) obj);
        } catch (NumberFormatException unused) {
            CardLogUtils.w("parse float fail");
            return f10;
        }
    }

    public static void putToMap(Map map, Object obj, String... strArr) {
        Map hashMap;
        if (map == null || strArr == null || strArr.length == 0) {
            return;
        }
        for (int i10 = 0; i10 < strArr.length - 1; i10++) {
            Object obj2 = map.get(strArr[i10]);
            if (obj2 instanceof Map) {
                hashMap = (Map) obj2;
            } else {
                hashMap = new HashMap();
                map.put(strArr[i10], hashMap);
            }
            map = hashMap;
        }
        map.put(strArr[strArr.length - 1], obj);
    }

    public static void removeFromMap(Map map, String... strArr) {
        if (map == null || strArr == null || strArr.length == 0) {
            return;
        }
        for (int i10 = 0; i10 < strArr.length - 1; i10++) {
            Object obj = map.get(strArr[i10]);
            if (!(obj instanceof Map)) {
                return;
            }
            map = (Map) obj;
        }
        map.remove(strArr[strArr.length - 1]);
    }

    public static Float parseFloat(String str, Float f10) {
        if (TextUtils.isEmpty(str)) {
            return f10;
        }
        try {
            return Float.valueOf(Float.parseFloat(str));
        } catch (NumberFormatException unused) {
            return f10;
        }
    }

    public static Float getFloatFromMap(Map map, String... strArr) {
        Object fromMap = getFromMap(map, strArr);
        if (fromMap instanceof Number) {
            return Float.valueOf(((Number) fromMap).floatValue());
        }
        if (fromMap instanceof String) {
            return parseFloat((String) fromMap);
        }
        return null;
    }

    public static Integer getIntegerFromMap(Map map, String... strArr) {
        Object fromMap = getFromMap(map, strArr);
        if (fromMap instanceof Number) {
            return Integer.valueOf(((Number) fromMap).intValue());
        }
        if (fromMap instanceof String) {
            return parseInteger((String) fromMap);
        }
        return null;
    }
}
