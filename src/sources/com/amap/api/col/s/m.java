package com.amap.api.col.s;

import com.amap.api.col.s.ch;
import com.amap.api.services.core.ServiceSettings;

/* compiled from: ConfigableConst.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f7973a = {"com.amap.api.services", "com.amap.api.search.admic"};

    public static String a() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://restsdk.amap.com/v3" : "https://restsdk.amap.com/v3";
    }

    public static String b() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://restsdk.amap.com/v4" : "https://restsdk.amap.com/v4";
    }

    public static String c() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://restsdk.amap.com/v5" : "https://restsdk.amap.com/v5";
    }

    public static String d() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://yuntuapi.amap.com" : "https://yuntuapi.amap.com";
    }

    public static String e() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://restsdk.amap.com/rest/me/cpoint" : "https://restsdk.amap.com/rest/me/cpoint";
    }

    public static String f() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://apistore.amap.com" : "https://apistore.amap.com";
    }

    public static String g() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://m5.amap.com/ws/mapapi/shortaddress/transform" : "https://m5.amap.com/ws/mapapi/shortaddress/transform";
    }

    public static ch a(boolean z10) {
        try {
            return new ch.a("sea", "9.7.0", "AMAP SDK Android Search 9.7.0").a(f7973a).a(z10).a("9.7.0").a();
        } catch (bv e2) {
            n.a(e2, "ConfigableConst", "getSDKInfo");
            return null;
        }
    }
}
