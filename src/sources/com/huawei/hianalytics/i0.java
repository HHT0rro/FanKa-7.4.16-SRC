package com.huawei.hianalytics;

import android.text.TextUtils;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.log.LogTag;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class i0 {
    public static final String lmn = LogTag.get(i0.class, new Class[0]);

    public static boolean klm(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            if (map.size() == 1 && (map.get("constants") != null || map.get("_constants") != null)) {
                HiLog.w(lmn, "checkMap() the key can't be constants or _constants");
                return false;
            }
            if (map.size() <= 2048 && map.toString().length() <= 204800) {
                return true;
            }
            HiLog.w(lmn, "checkMap Map data is too big! size: %d , length: %d", Integer.valueOf(map.size()), Integer.valueOf(map.toString().length()));
            return false;
        }
        HiLog.w(lmn, "onEvent() mapValue has not data.so,The data will be empty");
        return false;
    }

    public static boolean lmn(String str) {
        return !lmn("eventId", str, 256);
    }

    public static boolean lmn(String str, String str2, int i10) {
        if (TextUtils.isEmpty(str2)) {
            HiLog.w(lmn, "checkString() Parameter is empty : " + str);
            return false;
        }
        if (str2.length() <= i10) {
            return true;
        }
        HiLog.w(lmn, "checkString() Failure of parameter length check! Parameter:" + str);
        return false;
    }

    public static boolean lmn(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            HiLog.w(lmn, "checkString() Parameter is null! Parameter:" + str);
            return false;
        }
        if (Pattern.compile(str3).matcher(str2).matches()) {
            return true;
        }
        HiLog.w(lmn, "checkString() Parameter verification failure! Parameter:" + str);
        return false;
    }

    public static int lmn(int i10, int i11, int i12) {
        if (i10 > i11) {
            HiLog.w(lmn, "checkIntRange(): parameter overlarge.");
            return i11;
        }
        if (i10 >= i12) {
            return i10;
        }
        HiLog.w(lmn, "checkIntRange(): parameter under size.");
        return i12;
    }

    public static String lmn(String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str2)) {
            return lmn(str, str2, str3) ? str2 : str4;
        }
        HiLog.w(lmn, "checkStrParameter() Parameter verification failure! Parameter:" + str);
        return str4;
    }

    public static LinkedHashMap<String, String> lmn(Map<String, String> map) {
        return lmn(map, 10, 128L, 512L, "x_");
    }

    public static LinkedHashMap<String, String> lmn(Map<String, String> map, int i10, long j10, long j11, String str) {
        if (map != null && map.size() != 0) {
            if (map.size() > i10) {
                HiLog.w(lmn, "checkMap(): map size is too big");
                return null;
            }
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key) && key.length() <= j10) {
                    if (!TextUtils.isEmpty(str) && !key.startsWith(str)) {
                        HiLog.w(lmn, "checkMap() key is not starts with x_");
                    } else {
                        if (!TextUtils.isEmpty(entry.getValue()) && r2.length() <= j11) {
                            linkedHashMap.put(key, entry.getValue());
                        } else {
                            HiLog.w(lmn, "checkMap():value check failure");
                        }
                    }
                } else {
                    HiLog.w(lmn, "checkMap():key check failure");
                }
            }
            return linkedHashMap;
        }
        HiLog.w(lmn, "checkMap():headers is empty");
        return null;
    }
}
