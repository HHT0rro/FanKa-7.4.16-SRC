package com.huawei.quickcard.base.utils;

import com.huawei.quickcard.base.wrapper.IQuickDataCallback;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class Utils {

    /* renamed from: a, reason: collision with root package name */
    private static final List<IQuickDataCallback> f33451a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private static final List<Collection<String>> f33452b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private static final List<Collection<String>> f33453c = new ArrayList();

    private static Map a(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object opt = jSONObject.isNull(next) ? null : jSONObject.opt(next);
                if (opt instanceof JSONArray) {
                    hashMap.put(next, a((JSONArray) opt));
                } else if (opt instanceof JSONObject) {
                    hashMap.put(next, a((JSONObject) opt));
                } else {
                    hashMap.put(next, opt);
                }
            }
        }
        return hashMap;
    }

    public static void collectGetterVarPath(Collection collection) {
        if (collection != null) {
            f33452b.add(collection);
        }
    }

    public static void collectSetterVarPath(Collection collection) {
        if (collection != null) {
            f33453c.add(collection);
        }
    }

    public static boolean isDpValue(String str) {
        int length;
        if (str != null && (length = str.length()) >= 3) {
            int i10 = length - 2;
            if (str.charAt(i10) == 'd' && str.charAt(length - 1) == 'p') {
                for (int i11 = 0; i11 < i10; i11++) {
                    char charAt = str.charAt(i11);
                    if ((charAt < '0' || charAt > '9') && charAt != '.') {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static boolean isIntNum(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            if (charAt < '0' || charAt > '9') {
                return false;
            }
        }
        return true;
    }

    public static boolean isNum(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            if ((charAt < '0' || charAt > '9') && charAt != '.') {
                return false;
            }
        }
        return true;
    }

    public static boolean isPercentValue(String str) {
        int length;
        if (str == null || (length = str.length()) < 2 || str.charAt(length - 1) != '%') {
            return false;
        }
        int i10 = length - 1;
        for (int i11 = 0; i11 < i10; i11++) {
            char charAt = str.charAt(i11);
            if ((charAt < '0' || charAt > '9') && charAt != '.') {
                return false;
            }
        }
        return true;
    }

    public static void notifyDataGet(int i10, String str) {
        int i11 = 0;
        while (true) {
            List<Collection<String>> list = f33452b;
            if (i11 >= list.size()) {
                return;
            }
            list.get(i11).add(str);
            i11++;
        }
    }

    public static void notifyDataSet(int i10, String str, Object obj, Object obj2) {
        int i11 = 0;
        while (true) {
            List<Collection<String>> list = f33453c;
            if (i11 >= list.size()) {
                break;
            }
            list.get(i11).add(str);
            i11++;
        }
        for (IQuickDataCallback iQuickDataCallback : f33451a) {
            if (iQuickDataCallback != null) {
                iQuickDataCallback.onDataChanged(i10, str, obj, obj2);
            }
        }
    }

    public static void registerDataChangedCallback(IQuickDataCallback iQuickDataCallback) {
        if (iQuickDataCallback != null) {
            f33451a.add(iQuickDataCallback);
        }
    }

    public static void stopCollectGetterVarPath(Collection collection) {
        if (collection != null) {
            f33452b.remove(collection);
        }
    }

    public static void stopCollectSetterVarPath(Collection collection) {
        if (collection != null) {
            f33453c.remove(collection);
        }
    }

    public static List toList(String str) {
        try {
            return a(new JSONArray(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static Map toMap(String str) {
        try {
            return a(new JSONObject(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static void unRegisterDataChangedCallback(IQuickDataCallback iQuickDataCallback) {
        if (iQuickDataCallback != null) {
            f33451a.remove(iQuickDataCallback);
        }
    }

    public static String unWrapStr(String str) {
        return str.replaceAll("\\\\\\\"", "\"").replaceAll("\\\\\\\\", "\\\\");
    }

    public static String wrapStr(String str) {
        return str.replaceAll("\\\\", "\\\\\\\\").replaceAll("\\\"", "\\\\\"");
    }

    public static List toList(JSONArray jSONArray) {
        try {
            return a(jSONArray);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static Map toMap(JSONObject jSONObject) {
        try {
            return a(jSONObject);
        } catch (JSONException unused) {
            return null;
        }
    }

    private static List a(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            Object opt = jSONArray.isNull(i10) ? null : jSONArray.opt(i10);
            if (opt instanceof JSONArray) {
                arrayList.add(a((JSONArray) opt));
            } else if (opt instanceof JSONObject) {
                arrayList.add(a((JSONObject) opt));
            } else {
                arrayList.add(opt);
            }
        }
        return arrayList;
    }
}
