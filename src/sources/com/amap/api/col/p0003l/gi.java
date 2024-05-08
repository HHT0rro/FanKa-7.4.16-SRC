package com.amap.api.col.p0003l;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.bg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: SPConfigUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class gi {

    /* renamed from: a, reason: collision with root package name */
    private fu f6084a;

    /* compiled from: SPConfigUtil.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static Map<String, gi> f6085a = new HashMap();
    }

    /* compiled from: SPConfigUtil.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private String f6086a;

        /* renamed from: b, reason: collision with root package name */
        private String f6087b;

        /* renamed from: c, reason: collision with root package name */
        private String f6088c;

        public b(String str, String str2, String str3) {
            this.f6086a = str;
            this.f6087b = str2;
            this.f6088c = str3;
        }

        public final boolean a(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                str = this.f6086a;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = this.f6087b;
            }
            return this.f6086a.equals(str) && this.f6087b.equals(str2);
        }

        private JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(bg.e.Code, this.f6086a);
                jSONObject.put("cpuType", this.f6087b);
                jSONObject.put("content", this.f6088c);
                return jSONObject;
            } catch (Throwable unused) {
                return new JSONObject();
            }
        }

        public static JSONArray a(List<b> list) {
            if (list == null) {
                return new JSONArray();
            }
            JSONArray jSONArray = new JSONArray();
            for (b bVar : list) {
                if (bVar != null) {
                    if (!TextUtils.isEmpty(bVar.f6088c)) {
                        jSONArray.put(bVar.a());
                    }
                }
            }
            return jSONArray;
        }

        private static b a(JSONObject jSONObject) {
            try {
                return new b(jSONObject.optString(bg.e.Code), jSONObject.optString("cpuType"), jSONObject.optString("content"));
            } catch (Throwable unused) {
                return null;
            }
        }

        public static List<b> a(String str) {
            if (TextUtils.isEmpty(str)) {
                return new ArrayList();
            }
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    arrayList.add(a(jSONArray.getJSONObject(i10)));
                }
                return arrayList;
            } catch (Throwable unused) {
                return new ArrayList();
            }
        }
    }

    private gi(fu fuVar) {
        this.f6084a = fuVar;
    }

    public static gi a(fu fuVar) {
        if (fuVar == null || TextUtils.isEmpty(fuVar.a())) {
            return null;
        }
        if (a.f6085a.get(fuVar.a()) == null) {
            a.f6085a.put(fuVar.a(), new gi(fuVar));
        }
        return a.f6085a.get(fuVar.a());
    }

    private static void b(Context context, String str, String str2, String str3) {
        if (str3 == null || TextUtils.isEmpty(str)) {
            return;
        }
        c(context, "C7ADB20F22F238708BA5EE26D0401DB9" + fq.b(str), "ik".concat(String.valueOf(str2)), str3);
    }

    private static void c(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return;
        }
        String g3 = fv.g(fh.a(fv.a(str3)));
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str2, g3);
        edit.commit();
    }

    private static String b(Context context, String str, String str2) {
        return (context == null || TextUtils.isEmpty(str2)) ? "" : fv.a(fh.b(fv.d(context.getSharedPreferences(str, 0).getString(str2, ""))));
    }

    public final String a(Context context, String str, String str2, String str3) {
        fu fuVar;
        if (context != null && (fuVar = this.f6084a) != null && !TextUtils.isEmpty(fuVar.a())) {
            List<b> a10 = b.a(a(context, this.f6084a.a(), str3));
            if (a10.size() == 0) {
                return "";
            }
            for (int i10 = 0; i10 < a10.size(); i10++) {
                b bVar = a10.get(i10);
                if (bVar.a(str, str2)) {
                    return bVar.f6088c;
                }
            }
        }
        return null;
    }

    public final void a(Context context, String str, String str2, String str3, String str4) {
        fu fuVar;
        if (context == null || (fuVar = this.f6084a) == null || TextUtils.isEmpty(fuVar.a())) {
            return;
        }
        List<b> a10 = b.a(a(context, this.f6084a.a(), str3));
        for (int i10 = 0; i10 < a10.size(); i10++) {
            b bVar = a10.get(i10);
            if (bVar.a(str, str2)) {
                bVar.f6088c = str4;
                b(context, this.f6084a.a(), str3, b.a(a10).toString());
                return;
            }
        }
        a10.add(new b(str, str2, str4));
        b(context, this.f6084a.a(), str3, b.a(a10).toString());
    }

    private static String a(Context context, String str, String str2) {
        return b(context, "C7ADB20F22F238708BA5EE26D0401DB9" + fq.b(str), "ik".concat(String.valueOf(str2)));
    }
}
