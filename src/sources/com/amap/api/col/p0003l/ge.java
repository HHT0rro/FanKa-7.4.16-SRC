package com.amap.api.col.p0003l;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AMapLogEntity.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ge {

    /* renamed from: a, reason: collision with root package name */
    public static int f6047a = 1;

    /* renamed from: b, reason: collision with root package name */
    public static int f6048b = 2;

    /* renamed from: c, reason: collision with root package name */
    private String f6049c;

    /* renamed from: d, reason: collision with root package name */
    private int f6050d;

    /* renamed from: e, reason: collision with root package name */
    private long f6051e = System.currentTimeMillis();

    /* renamed from: f, reason: collision with root package name */
    private String f6052f;

    private ge(int i10, String str, String str2) {
        this.f6049c = str2;
        this.f6050d = i10;
        this.f6052f = str;
    }

    public static ge a(String str, String str2) {
        return new ge(f6047a, str, str2);
    }

    public static ge b(String str, String str2) {
        return new ge(f6048b, str, str2);
    }

    private String d() {
        return this.f6052f;
    }

    public final String c() {
        return a(this.f6050d);
    }

    public final int a() {
        return this.f6050d;
    }

    public final String b() {
        new JSONObject();
        return this.f6049c;
    }

    public static String a(int i10) {
        return i10 == f6048b ? "error" : "info";
    }

    public static boolean a(ge geVar) {
        return (geVar == null || TextUtils.isEmpty(geVar.b())) ? false : true;
    }

    private static String b(ge geVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("info", geVar.b());
            jSONObject.put("session", geVar.d());
            jSONObject.put("timestamp", geVar.f6051e);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a(List<ge> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<ge> iterator2 = list.iterator2();
                    while (iterator2.hasNext()) {
                        String b4 = b(iterator2.next());
                        if (!TextUtils.isEmpty(b4)) {
                            jSONArray.put(b4);
                        }
                    }
                    return jSONArray.toString();
                }
            } catch (Throwable unused) {
            }
        }
        return "";
    }
}
