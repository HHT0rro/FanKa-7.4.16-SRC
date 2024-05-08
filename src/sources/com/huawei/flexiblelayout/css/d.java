package com.huawei.flexiblelayout.css;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CSSQualifier.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final String f28004a = "@media screen and (";

    /* renamed from: b, reason: collision with root package name */
    private static final Map<String, Integer> f28005b;

    static {
        HashMap hashMap = new HashMap();
        f28005b = hashMap;
        hashMap.put("ldpi", 120);
        hashMap.put("mdpi", 160);
        hashMap.put("tvdpi", 213);
        hashMap.put("hdpi", 240);
        hashMap.put("xhdpi", 320);
        hashMap.put("xxhdpi", 480);
        hashMap.put("xxxhdpi", 640);
    }

    public static String[] a(String str) {
        int indexOf;
        return (TextUtils.isEmpty(str) || (indexOf = str.indexOf(f28004a)) < 0) ? new String[0] : str.substring(indexOf + 19, str.length() - 1).split(";");
    }

    public static Integer b(String str) {
        if (str == null) {
            return null;
        }
        return f28005b.get(str);
    }

    public static Integer c(String str) {
        if (str != null && str.startsWith(IAdInterListener.AdReqParam.WIDTH)) {
            try {
                return Integer.valueOf(Integer.parseInt(str.substring(1)));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }
}
