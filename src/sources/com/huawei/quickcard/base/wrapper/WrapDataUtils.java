package com.huawei.quickcard.base.wrapper;

import androidx.annotation.NonNull;
import com.huawei.quickcard.base.interfaces.CardDataObject;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class WrapDataUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<Class, DataWrapper> f33460a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private static IQuickCardDataWrapper f33461b;

    public static <T> DataWrapper<T> getDataWrapper(T t2) {
        if (t2 == null) {
            return null;
        }
        Class<?> cls = t2.getClass();
        if (!cls.isPrimitive() && String.class != cls) {
            Map<Class, DataWrapper> map = f33460a;
            DataWrapper<T> dataWrapper = map.get(cls);
            if (dataWrapper != null) {
                return dataWrapper;
            }
            for (Map.Entry<Class, DataWrapper> entry : map.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    public static Object getItemIgnoreCase(CardDataObject cardDataObject, @NonNull String str) {
        if (cardDataObject == null) {
            return null;
        }
        Object obj = cardDataObject.get(str);
        if (obj != null) {
            return obj;
        }
        Locale locale = Locale.ENGLISH;
        Object obj2 = cardDataObject.get(str.toLowerCase(locale));
        return obj2 == null ? cardDataObject.get(str.toUpperCase(locale)) : obj2;
    }

    public static <T> void registerDataWrapper(Class<T> cls, DataWrapper<T> dataWrapper) {
        f33460a.put(cls, dataWrapper);
    }

    public static void setWrapperMethod(IQuickCardDataWrapper iQuickCardDataWrapper) {
        f33461b = iQuickCardDataWrapper;
    }

    public static String stringify(Object obj, String str) {
        if (obj == null) {
            return str;
        }
        if (obj instanceof CardDataObject) {
            return ((CardDataObject) obj).toJSON().toString();
        }
        return obj.toString();
    }

    public static Object wrap(Object obj) {
        IQuickCardDataWrapper iQuickCardDataWrapper = f33461b;
        if (iQuickCardDataWrapper != null) {
            return iQuickCardDataWrapper.wrap(obj);
        }
        return null;
    }
}
