package com.alipay.sdk.protocol;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private a f4657a;

    /* renamed from: b, reason: collision with root package name */
    private String f4658b;

    /* renamed from: c, reason: collision with root package name */
    private String[] f4659c;

    public b(String str) {
        this.f4658b = str;
    }

    public static void a(b bVar) {
        String[] c4 = bVar.c();
        if (c4.length == 3 && TextUtils.equals("tid", c4[0])) {
            com.alipay.sdk.tid.b a10 = com.alipay.sdk.tid.b.a(com.alipay.sdk.sys.b.a().b());
            if (TextUtils.isEmpty(c4[1]) || TextUtils.isEmpty(c4[2])) {
                return;
            }
            a10.a(c4[1], c4[2]);
        }
    }

    private static String[] b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split(";");
    }

    public String[] c() {
        return this.f4659c;
    }

    public b(String str, a aVar) {
        this.f4658b = str;
        this.f4657a = aVar;
    }

    public a b() {
        return this.f4657a;
    }

    public static List<b> a(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null) {
            return arrayList;
        }
        String[] b4 = b(jSONObject.optString("name", ""));
        for (int i10 = 0; i10 < b4.length; i10++) {
            a a10 = a.a(b4[i10]);
            if (a10 != a.None) {
                b bVar = new b(b4[i10], a10);
                bVar.f4659c = a(b4[i10]);
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    private static String[] a(String str) {
        ArrayList arrayList = new ArrayList();
        int indexOf = str.indexOf(40);
        int lastIndexOf = str.lastIndexOf(41);
        if (indexOf == -1 || lastIndexOf == -1 || lastIndexOf <= indexOf) {
            return null;
        }
        for (String str2 : str.substring(indexOf + 1, lastIndexOf).split("' *, *'", -1)) {
            arrayList.add(str2.trim().replaceAll("'", "").replaceAll("\"", ""));
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public String a() {
        return this.f4658b;
    }
}
