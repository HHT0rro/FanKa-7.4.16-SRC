package com.huawei.quickcard.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.log.CardLogUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class I18nUtils {
    public static final String FORMAT_SPLIT_REGEX = "\\{([a-z]|[A-Z]|[0-9]|_)+\\}";
    public static final String KEY_REGEX = "\\{|\\}";

    /* renamed from: a, reason: collision with root package name */
    private static final String f34273a = "I18nUtils";

    /* renamed from: b, reason: collision with root package name */
    private static final String f34274b = "(.*)\\{([a-z]|[A-Z]|[0-9]|_)+\\}(.*)";

    /* renamed from: c, reason: collision with root package name */
    private static final Map<String, String> f34275c;

    static {
        HashMap hashMap = new HashMap(2);
        f34275c = hashMap;
        hashMap.put("my", "my_MM");
        hashMap.put("my_Qaag", "my_ZG");
        hashMap.put("fil", "tl");
    }

    private static String a(String str, String str2, String str3, @NonNull JSONObject jSONObject) {
        return jSONObject.has(str) ? str : b(str2, str3, jSONObject);
    }

    private static String b(String str, String str2, JSONObject jSONObject) {
        CardLogUtils.d(f34273a, "match exactly locale code failed, match vaguely");
        String a10 = a(str, jSONObject);
        return (TextUtils.isEmpty(a10) || !jSONObject.has(a10)) ? str2 : a10;
    }

    public static String mixFinalLocaleCode(Locale locale, String str, @NonNull JSONObject jSONObject) {
        String str2;
        String str3;
        String language = locale.getLanguage();
        String country = locale.getCountry();
        String script = locale.getScript();
        if (TextUtils.isEmpty(country)) {
            str2 = language;
        } else {
            str2 = language + "_" + country.toUpperCase(Locale.ENGLISH);
        }
        if (TextUtils.isEmpty(script)) {
            str3 = "";
        } else {
            str3 = language + "_" + script;
        }
        if (jSONObject.has(str2)) {
            if (!jSONObject.has(str3)) {
                return a(str3, str2, jSONObject);
            }
        } else if (!jSONObject.has(str3)) {
            Map<String, String> map = f34275c;
            if (map.containsKey(str3)) {
                return a(map.get(str3), language, str, jSONObject);
            }
            if (jSONObject.has(language)) {
                return language;
            }
            if (map.containsKey(language)) {
                return a(map.get(language), language, str, jSONObject);
            }
            return b(language, str, jSONObject);
        }
        return str3;
    }

    public static String tFormat(String str, JSONArray jSONArray) {
        if (!a(str)) {
            return str;
        }
        return a(a(str, FORMAT_SPLIT_REGEX), a(str, FORMAT_SPLIT_REGEX, KEY_REGEX), jSONArray);
    }

    private static String a(String str, String str2, JSONObject jSONObject) {
        CardLogUtils.d(f34273a, "match map lang " + str);
        String str3 = f34275c.get(str);
        return jSONObject.has(str3) ? str3 : str2;
    }

    private static String a(String str, JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                if (next.startsWith(str + "_")) {
                    arrayList.add(next);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return "";
        }
        Collections.sort(arrayList);
        return (String) arrayList.get(0);
    }

    public static String tFormat(String str, List<Object> list) {
        if (!a(str)) {
            return str;
        }
        return a(a(str, FORMAT_SPLIT_REGEX), a(str, FORMAT_SPLIT_REGEX, KEY_REGEX), list);
    }

    public static String tFormat(String str, JSONObject jSONObject) {
        if (!a(str)) {
            return str;
        }
        return a(a(str, FORMAT_SPLIT_REGEX), a(str, FORMAT_SPLIT_REGEX, KEY_REGEX), jSONObject);
    }

    private static String a(@NonNull String[] strArr, @NonNull String[] strArr2, @NonNull JSONArray jSONArray) {
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        if (strArr.length == 0) {
            while (i10 < strArr2.length) {
                sb2.append(a(jSONArray, i10));
                i10++;
            }
        } else {
            int min = Math.min(strArr2.length, jSONArray.length());
            while (i10 < strArr.length) {
                sb2.append(strArr[i10]);
                if (i10 < min) {
                    sb2.append(a(jSONArray, i10));
                }
                i10++;
            }
        }
        return sb2.toString();
    }

    public static String tFormat(String str, @NonNull Map<String, Object> map) {
        if (!a(str)) {
            return str;
        }
        return a(a(str, FORMAT_SPLIT_REGEX), a(str, FORMAT_SPLIT_REGEX, KEY_REGEX), map);
    }

    private static String a(@NonNull JSONArray jSONArray, int i10) {
        Object opt;
        return (i10 < jSONArray.length() && (opt = jSONArray.opt(i10)) != null) ? opt.toString() : "";
    }

    private static String a(@NonNull String[] strArr, @NonNull String[] strArr2, @NonNull List<Object> list) {
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        if (strArr.length == 0) {
            while (i10 < strArr2.length) {
                sb2.append(a(list, i10));
                i10++;
            }
        } else {
            int min = Math.min(strArr2.length, list.size());
            while (i10 < strArr.length) {
                sb2.append(strArr[i10]);
                if (i10 < min) {
                    sb2.append(a(list, i10));
                }
                i10++;
            }
        }
        return sb2.toString();
    }

    private static String a(@NonNull List<Object> list, int i10) {
        Object obj;
        return (i10 < list.size() && (obj = list.get(i10)) != null) ? obj.toString() : "";
    }

    private static String a(@NonNull String[] strArr, @NonNull String[] strArr2, JSONObject jSONObject) {
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        if (strArr.length == 0) {
            int length = strArr2.length;
            while (i10 < length) {
                sb2.append(a(jSONObject, strArr2[i10]));
                i10++;
            }
        } else {
            while (i10 < strArr.length) {
                sb2.append(strArr[i10]);
                if (i10 < strArr2.length) {
                    sb2.append(a(jSONObject, strArr2[i10]));
                }
                i10++;
            }
        }
        return sb2.toString();
    }

    private static String a(@NonNull JSONObject jSONObject, String str) {
        Object opt = jSONObject.opt(str);
        return opt == null ? "" : opt.toString();
    }

    private static String a(@NonNull String[] strArr, @NonNull String[] strArr2, @NonNull Map<String, Object> map) {
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        if (strArr.length == 0) {
            int length = strArr2.length;
            while (i10 < length) {
                sb2.append(a(map, strArr2[i10]));
                i10++;
            }
        } else {
            while (i10 < strArr.length) {
                sb2.append(strArr[i10]);
                if (i10 < strArr2.length) {
                    sb2.append(a(map, strArr2[i10]));
                }
                i10++;
            }
        }
        return sb2.toString();
    }

    private static String a(@NonNull Map<String, Object> map, String str) {
        Object obj = map.get(str);
        return obj == null ? "" : obj.toString();
    }

    private static boolean a(@NonNull String str) {
        return str.matches(f34274b);
    }

    private static String[] a(@NonNull String str, String str2, String str3) {
        Matcher matcher = Pattern.compile(str2).matcher(str);
        ArrayList arrayList = new ArrayList();
        while (matcher.find()) {
            String group = matcher.group();
            if (TextUtils.isEmpty(str3)) {
                arrayList.add(group);
            } else {
                arrayList.add(group.replaceAll(str3, ""));
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    private static String[] a(@NonNull String str, String str2) {
        return str.split(str2);
    }
}
