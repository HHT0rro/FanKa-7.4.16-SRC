package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, String> f4302a;

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f4303b = {"AD1", "AD2", "AD3", "AD8", "AD9", "AD10", "AD11", "AD12", "AD14", "AD15", "AD16", "AD18", "AD20", "AD21", "AD23", "AD24", "AD26", "AD27", "AD28", "AD29", "AD30", "AD31", "AD34", "AA1", "AA2", "AA3", "AA4", "AC4", "AC10", "AE1", "AE2", "AE3", "AE4", "AE5", "AE6", "AE7", "AE8", "AE9", "AE10", "AE11", "AE12", "AE13", "AE14", "AE15"};

    /* JADX WARN: Multi-variable type inference failed */
    private static String a(Map<String, String> map) {
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList arrayList = new ArrayList(map.h());
        Collections.sort(arrayList);
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            String str = (String) arrayList.get(i10);
            String str2 = map.get(str);
            String str3 = "";
            if (str2 == null) {
                str2 = "";
            }
            StringBuilder sb2 = new StringBuilder();
            if (i10 != 0) {
                str3 = "&";
            }
            sb2.append(str3);
            sb2.append(str);
            sb2.append("=");
            sb2.append(str2);
            stringBuffer.append(sb2.toString());
        }
        return stringBuffer.toString();
    }

    public static synchronized Map<String, String> a(Context context, Map<String, String> map) {
        Map<String, String> map2;
        synchronized (e.class) {
            if (f4302a == null) {
                c(context, map);
            }
            f4302a.putAll(d.a());
            map2 = f4302a;
        }
        return map2;
    }

    public static synchronized void a() {
        synchronized (e.class) {
            f4302a = null;
        }
    }

    public static synchronized String b(Context context, Map<String, String> map) {
        String a10;
        synchronized (e.class) {
            a(context, map);
            TreeMap treeMap = new TreeMap();
            for (String str : f4303b) {
                if (f4302a.containsKey(str)) {
                    treeMap.put(str, f4302a.get(str));
                }
            }
            a10 = a0.b.a(a(treeMap));
        }
        return a10;
    }

    private static synchronized void c(Context context, Map<String, String> map) {
        synchronized (e.class) {
            TreeMap treeMap = new TreeMap();
            f4302a = treeMap;
            treeMap.putAll(b.a(context, map));
            f4302a.putAll(d.a(context));
            f4302a.putAll(c.a(context));
            f4302a.putAll(a.a(context, map));
        }
    }
}
