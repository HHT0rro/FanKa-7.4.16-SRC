package com.huawei.flexiblelayout.json;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.flexiblelayout.data.primitive.ListModel;
import com.huawei.flexiblelayout.data.primitive.MapModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Utils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a {
    public static boolean a(double d10) {
        return Double.isInfinite(d10) || Double.isNaN(d10);
    }

    @Nullable
    public static Double b(Object obj) {
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (!(obj instanceof String)) {
            return null;
        }
        try {
            return Double.valueOf((String) obj);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @Nullable
    public static Integer c(Object obj) {
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (!(obj instanceof String)) {
            return null;
        }
        try {
            return Integer.valueOf((String) obj);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @Nullable
    public static Long d(Object obj) {
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof Number) {
            return Long.valueOf(((Number) obj).longValue());
        }
        if (!(obj instanceof String)) {
            return null;
        }
        try {
            return Long.valueOf((String) obj);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @Nullable
    public static String e(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof MapModel) {
            try {
                return a((MapModel) obj).toString();
            } catch (JSONException unused) {
                return "";
            }
        }
        if (obj instanceof ListModel) {
            try {
                return a((ListModel) obj).toString();
            } catch (JSONException unused2) {
                return "";
            }
        }
        if (obj != null) {
            return String.valueOf(obj);
        }
        return null;
    }

    @Nullable
    public static Boolean a(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (!(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        if ("true".equalsIgnoreCase(str)) {
            return Boolean.TRUE;
        }
        if ("false".equalsIgnoreCase(str)) {
            return Boolean.FALSE;
        }
        return null;
    }

    @Nullable
    public static Object b(Class<?> cls, Object obj) {
        if (Boolean.class != cls && Boolean.TYPE != cls) {
            return a(cls, obj);
        }
        if (obj instanceof Boolean) {
            return obj;
        }
        if (obj instanceof String) {
            return Boolean.valueOf((String) obj);
        }
        return Boolean.FALSE;
    }

    @Nullable
    public static Number a(Class<?> cls, Object obj) {
        Number number;
        if (obj instanceof String) {
            if (Long.class != cls) {
                try {
                    if (Long.TYPE != cls) {
                        number = Double.valueOf((String) obj);
                    }
                } catch (NumberFormatException unused) {
                    return null;
                }
            }
            return Long.valueOf((String) obj);
        }
        if (!(obj instanceof Number)) {
            return null;
        }
        number = (Number) obj;
        if (Double.class != cls && Double.TYPE != cls) {
            if (Float.class != cls && Float.TYPE != cls) {
                if (Long.class != cls && Long.TYPE != cls) {
                    if (Integer.class != cls && Integer.TYPE != cls) {
                        if (Short.class != cls && Short.TYPE != cls) {
                            if (Byte.class == cls || Byte.TYPE == cls) {
                                return Byte.valueOf(number.byteValue());
                            }
                            return null;
                        }
                        return Short.valueOf(number.shortValue());
                    }
                    return Integer.valueOf(number.intValue());
                }
                return Long.valueOf(number.longValue());
            }
            return Float.valueOf(number.floatValue());
        }
        return Double.valueOf(number.doubleValue());
    }

    @NonNull
    public static JSONArray a(ListModel listModel) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        int size = listModel.size();
        for (int i10 = 0; i10 < size; i10++) {
            Object obj = listModel.get(i10);
            if (obj instanceof ListModel) {
                jSONArray.put(a((ListModel) obj));
            } else if (obj instanceof MapModel) {
                jSONArray.put(a((MapModel) obj));
            } else {
                jSONArray.put(obj);
            }
        }
        return jSONArray;
    }

    @NonNull
    public static JSONObject a(MapModel mapModel) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : mapModel.keys()) {
            Object obj = mapModel.get(str);
            if (obj instanceof ListModel) {
                jSONObject.put(str, a((ListModel) obj));
            } else if (obj instanceof MapModel) {
                jSONObject.put(str, a((MapModel) obj));
            } else {
                jSONObject.put(str, obj);
            }
        }
        return jSONObject;
    }
}
