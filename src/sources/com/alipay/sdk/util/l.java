package com.alipay.sdk.util;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4746a = "resultStatus";

    /* renamed from: b, reason: collision with root package name */
    public static final String f4747b = "memo";

    /* renamed from: c, reason: collision with root package name */
    public static final String f4748c = "result";

    public static Map<String, String> a(String str) {
        Map<String, String> a10 = a();
        try {
            return b(str);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f4432b, com.alipay.sdk.app.statistic.c.f4437g, th);
            return a10;
        }
    }

    public static Map<String, String> b(String str) {
        String[] split = str.split(";");
        HashMap hashMap = new HashMap();
        for (String str2 : split) {
            String substring = str2.substring(0, str2.indexOf("={"));
            hashMap.put(substring, a(str2, substring));
        }
        return hashMap;
    }

    private static Map<String, String> a() {
        com.alipay.sdk.app.k b4 = com.alipay.sdk.app.k.b(com.alipay.sdk.app.k.CANCELED.a());
        HashMap hashMap = new HashMap();
        hashMap.put(f4746a, Integer.toString(b4.a()));
        hashMap.put(f4747b, b4.b());
        hashMap.put("result", "");
        return hashMap;
    }

    private static String a(String str, String str2) {
        String str3 = str2 + "={";
        return str.substring(str.indexOf(str3) + str3.length(), str.lastIndexOf(i.f4738d));
    }
}
