package com.bef.effectsdk;

import h0.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@a
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class GeneralParam {
    private static GetNetWorkInfo sGetNetworkInfo;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface GetNetWorkInfo {
        HashMap<String, String> getHeader(String str);

        HashMap<String, String> getParam(String str);
    }

    private static String convertMapToString(HashMap<String, String> hashMap) {
        if (hashMap.isEmpty()) {
            return "";
        }
        Iterator<Map.Entry<String, String>> iterator2 = hashMap.entrySet().iterator2();
        Map.Entry<String, String> next = iterator2.next();
        String str = next.getKey() + "=" + next.getValue();
        while (iterator2.hasNext()) {
            Map.Entry<String, String> next2 = iterator2.next();
            String key = next2.getKey();
            String value = next2.getValue();
            if (!key.isEmpty() && !value.isEmpty()) {
                str = str + "&" + key + "=" + value;
            }
        }
        return str;
    }

    private static String getHeaderStr(String str) {
        GetNetWorkInfo getNetWorkInfo = sGetNetworkInfo;
        return getNetWorkInfo == null ? "" : convertMapToString(getNetWorkInfo.getHeader(str));
    }

    public static String getParamByKey(String str) {
        return nativeGetParamByKey(str);
    }

    @a
    private static String getParamStr(String str) {
        GetNetWorkInfo getNetWorkInfo = sGetNetworkInfo;
        return getNetWorkInfo == null ? "" : convertMapToString(getNetWorkInfo.getParam(str));
    }

    private static native String nativeGetParamByKey(String str);

    private static native void nativeSetParamWithKey(String str, String str2);

    private static native void nativeSetParams(HashMap<String, String> hashMap);

    public static void setNetWorkInfoCallback(GetNetWorkInfo getNetWorkInfo) {
        sGetNetworkInfo = getNetWorkInfo;
    }

    public static void setParamWithKey(String str, String str2) {
        nativeSetParamWithKey(str, str2);
    }

    public static void setParams(HashMap<String, String> hashMap) {
        nativeSetParams(hashMap);
    }
}
