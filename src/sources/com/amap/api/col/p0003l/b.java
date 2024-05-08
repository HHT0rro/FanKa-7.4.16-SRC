package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.district.DistrictSearchQuery;
import com.huawei.quickcard.base.Attributes;
import com.wangmai.okhttp.model.HttpHeaders;
import java.util.HashMap;
import java.util.Map;

/* compiled from: GeoFenceNetManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public hw f5105a;

    public b(Context context) {
        this.f5105a = null;
        try {
            fo.a().a(context);
        } catch (Throwable unused) {
        }
        this.f5105a = hw.a();
    }

    private static Map<String, String> b(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        HashMap hashMap = new HashMap(16);
        hashMap.put("key", fj.f(context));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("keywords", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("types", str2);
        }
        if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
            hashMap.put("location", str6 + "," + str5);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put(DistrictSearchQuery.KEYWORDS_CITY, str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put(Attributes.Style.OFFSET, str4);
        }
        if (!TextUtils.isEmpty(str7)) {
            hashMap.put("radius", str7);
        }
        return hashMap;
    }

    public final String a(Context context, String str, String str2, String str3, String str4, String str5) {
        Map<String, String> b4 = b(context, str2, str3, str4, str5, null, null, null);
        b4.put("children", "1");
        b4.put("page", "1");
        b4.put("extensions", "base");
        return a(context, str, b4);
    }

    public final String a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Map<String, String> b4 = b(context, str2, str3, null, str4, str5, str6, str7);
        b4.put("children", "1");
        b4.put("page", "1");
        b4.put("extensions", "base");
        return a(context, str, b4);
    }

    public final String a(Context context, String str, String str2) {
        Map<String, String> b4 = b(context, str2, null, null, null, null, null, null);
        b4.put("extensions", "all");
        b4.put("subdistrict", "0");
        return a(context, str, b4);
    }

    private String a(Context context, String str, Map<String, String> map) {
        try {
            HashMap hashMap = new HashMap(16);
            com.autonavi.aps.amapapi.trans.b bVar = new com.autonavi.aps.amapapi.trans.b();
            hashMap.clear();
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put(HttpHeaders.HEAD_KEY_CONNECTION, "Keep-Alive");
            hashMap.put("User-Agent", "AMAP_Location_SDK_Android 6.4.1");
            String a10 = fl.a();
            String a11 = fl.a(context, a10, fv.b(map));
            map.put("ts", a10);
            map.put("scode", a11);
            bVar.b(map);
            bVar.a(hashMap);
            bVar.a(str);
            bVar.setProxy(ft.a(context));
            bVar.setConnectionTimeout(com.autonavi.aps.amapapi.utils.b.f9640i);
            bVar.setSoTimeout(com.autonavi.aps.amapapi.utils.b.f9640i);
            try {
                return new String(hw.a(bVar).f6444a, "utf-8");
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceNetManager", "post");
                return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }
}
