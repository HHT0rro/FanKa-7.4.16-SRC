package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public com.huawei.hms.framework.network.grs.local.model.a f29961a;

    /* renamed from: b, reason: collision with root package name */
    public List<com.huawei.hms.framework.network.grs.local.model.b> f29962b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f29963c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f29964d = false;

    /* renamed from: e, reason: collision with root package name */
    public Set<String> f29965e = new HashSet(16);

    private Map<String, String> a(List<com.huawei.hms.framework.network.grs.local.model.b> list, GrsBaseInfo grsBaseInfo, String str) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        concurrentHashMap.put("no_route_country", "no-country");
        for (com.huawei.hms.framework.network.grs.local.model.b bVar : list) {
            if (bVar.a().contains(grsBaseInfo.getIssueCountry())) {
                concurrentHashMap.put(grsBaseInfo.getIssueCountry(), bVar.b());
            }
            if (bVar.a().contains(grsBaseInfo.getRegCountry())) {
                concurrentHashMap.put(grsBaseInfo.getRegCountry(), bVar.b());
            }
            if (bVar.a().contains(grsBaseInfo.getSerCountry())) {
                concurrentHashMap.put(grsBaseInfo.getSerCountry(), bVar.b());
            }
            if (bVar.a().contains(str)) {
                Logger.v("AbstractLocalManager", "get countryGroupID from geoIp");
                concurrentHashMap.put(str, bVar.b());
            }
        }
        return concurrentHashMap;
    }

    private int b(String str, Context context) {
        if (g(com.huawei.hms.framework.network.grs.h.c.a(str, context)) != 0) {
            return -1;
        }
        Logger.i("AbstractLocalManager", "load APP_CONFIG_FILE success{%s}.", str);
        return 0;
    }

    private int g(String str) {
        int c4;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (this.f29964d && (c4 = c(str)) != 0) {
            return c4;
        }
        int b4 = b(str);
        return b4 != 0 ? b4 : f(str);
    }

    private int h(String str) {
        List<com.huawei.hms.framework.network.grs.local.model.b> list;
        int d10;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (!this.f29964d || !((list = this.f29962b) == null || list.isEmpty()) || (d10 = d(str)) == 0) ? e(str) : d10;
    }

    public int a(String str, Context context) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(GrsApp.getInstance().getBrand("/"));
        sb2.append(str);
        return b(sb2.toString(), context) != 0 ? -1 : 0;
    }

    public com.huawei.hms.framework.network.grs.local.model.a a() {
        return this.f29961a;
    }

    public String a(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo, String str, String str2, boolean z10) {
        Map<String, String> a10 = a(context, aVar, grsBaseInfo, str, z10);
        if (a10 != null) {
            return a10.get(str2);
        }
        Logger.w("AbstractLocalManager", "addresses not found by routeby in local config{%s}", str);
        return null;
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if ("no_route_country".equals(str)) {
            return "no-country";
        }
        List<com.huawei.hms.framework.network.grs.local.model.b> list = this.f29962b;
        if (list != null && !list.isEmpty()) {
            for (com.huawei.hms.framework.network.grs.local.model.b bVar : this.f29962b) {
                if (bVar.a().contains(str)) {
                    return bVar.b();
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0075 A[Catch: JSONException -> 0x0091, LOOP:1: B:19:0x006f->B:21:0x0075, LOOP_END, TryCatch #0 {JSONException -> 0x0091, blocks: (B:7:0x0011, B:8:0x0019, B:10:0x001f, B:12:0x004a, B:14:0x0060, B:16:0x0067, B:19:0x006f, B:21:0x0075, B:23:0x0081, B:26:0x008a, B:31:0x0050, B:33:0x0056, B:34:0x005b), top: B:6:0x0011 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.huawei.hms.framework.network.grs.local.model.b> a(org.json.JSONArray r13) {
        /*
            r12 = this;
            java.lang.String r0 = "countries"
            java.lang.String r1 = "countriesOrAreas"
            java.lang.String r2 = "AbstractLocalManager"
            if (r13 == 0) goto Laa
            int r3 = r13.length()
            if (r3 != 0) goto L10
            goto Laa
        L10:
            r3 = 0
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: org.json.JSONException -> L91
            r5 = 16
            r4.<init>(r5)     // Catch: org.json.JSONException -> L91
            r6 = 0
        L19:
            int r7 = r13.length()     // Catch: org.json.JSONException -> L91
            if (r6 >= r7) goto L90
            org.json.JSONObject r7 = r13.getJSONObject(r6)     // Catch: org.json.JSONException -> L91
            com.huawei.hms.framework.network.grs.local.model.b r8 = new com.huawei.hms.framework.network.grs.local.model.b     // Catch: org.json.JSONException -> L91
            r8.<init>()     // Catch: org.json.JSONException -> L91
            java.lang.String r9 = "id"
            java.lang.String r9 = r7.getString(r9)     // Catch: org.json.JSONException -> L91
            r8.b(r9)     // Catch: org.json.JSONException -> L91
            java.lang.String r9 = "name"
            java.lang.String r9 = r7.getString(r9)     // Catch: org.json.JSONException -> L91
            r8.c(r9)     // Catch: org.json.JSONException -> L91
            java.lang.String r9 = "description"
            java.lang.String r9 = r7.getString(r9)     // Catch: org.json.JSONException -> L91
            r8.a(r9)     // Catch: org.json.JSONException -> L91
            r9 = 0
            boolean r10 = r7.has(r1)     // Catch: org.json.JSONException -> L91
            if (r10 == 0) goto L50
            org.json.JSONArray r7 = r7.getJSONArray(r1)     // Catch: org.json.JSONException -> L91
        L4e:
            r9 = r7
            goto L60
        L50:
            boolean r10 = r7.has(r0)     // Catch: org.json.JSONException -> L91
            if (r10 == 0) goto L5b
            org.json.JSONArray r7 = r7.getJSONArray(r0)     // Catch: org.json.JSONException -> L91
            goto L4e
        L5b:
            java.lang.String r7 = "current country or area group has not config countries or areas."
            com.huawei.hms.framework.common.Logger.w(r2, r7)     // Catch: org.json.JSONException -> L91
        L60:
            java.util.HashSet r7 = new java.util.HashSet     // Catch: org.json.JSONException -> L91
            r7.<init>(r5)     // Catch: org.json.JSONException -> L91
            if (r9 == 0) goto L8a
            int r10 = r9.length()     // Catch: org.json.JSONException -> L91
            if (r10 != 0) goto L6e
            goto L8a
        L6e:
            r10 = 0
        L6f:
            int r11 = r9.length()     // Catch: org.json.JSONException -> L91
            if (r10 >= r11) goto L81
            java.lang.Object r11 = r9.get(r10)     // Catch: org.json.JSONException -> L91
            java.lang.String r11 = (java.lang.String) r11     // Catch: org.json.JSONException -> L91
            r7.add(r11)     // Catch: org.json.JSONException -> L91
            int r10 = r10 + 1
            goto L6f
        L81:
            r8.a(r7)     // Catch: org.json.JSONException -> L91
            r4.add(r8)     // Catch: org.json.JSONException -> L91
            int r6 = r6 + 1
            goto L19
        L8a:
            java.util.ArrayList r13 = new java.util.ArrayList     // Catch: org.json.JSONException -> L91
            r13.<init>()     // Catch: org.json.JSONException -> L91
            return r13
        L90:
            return r4
        L91:
            r13 = move-exception
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r13 = r13.getMessage()
            java.lang.String r13 = com.huawei.hms.framework.common.StringUtils.anonymizeMessage(r13)
            r0[r3] = r13
            java.lang.String r13 = "parse countrygroup failed maybe json style is wrong. %s"
            com.huawei.hms.framework.common.Logger.w(r2, r13, r0)
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            return r13
        Laa:
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.f.a.a(org.json.JSONArray):java.util.List");
    }

    public Map<String, String> a(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo, String str, boolean z10) {
        com.huawei.hms.framework.network.grs.local.model.a aVar2 = this.f29961a;
        if (aVar2 == null) {
            Logger.w("AbstractLocalManager", "application data is null.");
            return null;
        }
        com.huawei.hms.framework.network.grs.local.model.c a10 = aVar2.a(str);
        if (a10 == null) {
            Logger.w("AbstractLocalManager", "service not found in local config{%s}", str);
            return null;
        }
        String b4 = e.b(context, aVar, a10.b(), grsBaseInfo, z10);
        if (b4 == null) {
            Logger.w("AbstractLocalManager", "country not found by routeby in local config{%s}", a10.b());
            return null;
        }
        List<com.huawei.hms.framework.network.grs.local.model.b> a11 = a10.a();
        com.huawei.hms.framework.network.grs.local.model.d a12 = a10.a((a11 == null || a11.size() == 0) ? a(b4) : a(a11, grsBaseInfo, b4).get(b4));
        if (a12 == null) {
            return null;
        }
        return a12.a();
    }

    public void a(Context context, List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (String str : list) {
            Logger.d("AbstractLocalManager", "getBatchLoadSdkSuccessFlag file:" + str);
            if (TextUtils.isEmpty(str) || !Pattern.matches("^grs_sdk_global_route_config_[a-zA-Z]+\\.json$", str)) {
                Logger.d("AbstractLocalManager", "load SDK_CONFIG_FILE: %s, skipped.", str);
            } else {
                if (h(com.huawei.hms.framework.network.grs.h.c.a(GrsApp.getInstance().getBrand("/") + str, context)) == 0) {
                    Logger.d("AbstractLocalManager", "load SDK_CONFIG_FILE: %s, sucess.", str);
                } else {
                    Logger.w("AbstractLocalManager", "load SDK_CONFIG_FILE: %s, failure.", str);
                }
            }
        }
    }

    public abstract int b(String str);

    public Set<String> b() {
        return this.f29965e;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(org.json.JSONArray r15) {
        /*
            r14 = this;
            if (r15 == 0) goto Lf6
            int r0 = r15.length()
            if (r0 != 0) goto La
            goto Lf6
        La:
            r0 = 0
            r1 = 0
        Lc:
            int r2 = r15.length()
            if (r1 >= r2) goto Lf6
            org.json.JSONObject r2 = r15.getJSONObject(r1)
            com.huawei.hms.framework.network.grs.local.model.c r3 = new com.huawei.hms.framework.network.grs.local.model.c
            r3.<init>()
            java.lang.String r4 = "name"
            java.lang.String r4 = r2.getString(r4)
            r3.b(r4)
            java.util.Set<java.lang.String> r5 = r14.f29965e
            boolean r5 = r5.contains(r4)
            if (r5 != 0) goto Lf2
            java.util.Set<java.lang.String> r5 = r14.f29965e
            r5.add(r4)
            boolean r5 = r14.f29964d
            if (r5 == 0) goto Lf2
            java.lang.String r5 = "routeBy"
            java.lang.String r5 = r2.getString(r5)
            r3.c(r5)
            java.lang.String r5 = "servings"
            org.json.JSONArray r5 = r2.getJSONArray(r5)
            r6 = 0
        L45:
            int r7 = r5.length()
            java.lang.String r8 = "AbstractLocalManager"
            if (r6 >= r7) goto Lbf
            java.lang.Object r7 = r5.get(r6)
            org.json.JSONObject r7 = (org.json.JSONObject) r7
            com.huawei.hms.framework.network.grs.local.model.d r9 = new com.huawei.hms.framework.network.grs.local.model.d
            r9.<init>()
            java.lang.String r10 = "countryOrAreaGroup"
            boolean r11 = r7.has(r10)
            if (r11 == 0) goto L65
        L60:
            java.lang.String r8 = r7.getString(r10)
            goto L7a
        L65:
            java.lang.String r10 = "countryGroup"
            boolean r11 = r7.has(r10)
            if (r11 == 0) goto L6e
            goto L60
        L6e:
            r10 = 1
            java.lang.Object[] r10 = new java.lang.Object[r10]
            r10[r0] = r4
            java.lang.String r11 = "maybe this service{%s} routeBy is unconditional."
            com.huawei.hms.framework.common.Logger.v(r8, r11, r10)
            java.lang.String r8 = "no-country"
        L7a:
            r9.a(r8)
            java.lang.String r8 = "addresses"
            org.json.JSONObject r7 = r7.getJSONObject(r8)
            java.util.concurrent.ConcurrentHashMap r8 = new java.util.concurrent.ConcurrentHashMap
            r10 = 16
            r8.<init>(r10)
            java.util.Iterator r10 = r7.keys()
        L8e:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto Lb2
            java.lang.Object r11 = r10.next()
            java.lang.String r11 = (java.lang.String) r11
            java.lang.String r12 = r7.getString(r11)
            boolean r13 = android.text.TextUtils.isEmpty(r11)
            if (r13 != 0) goto L8e
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L8e
            java.lang.String r12 = r7.getString(r11)
            r8.put(r11, r12)
            goto L8e
        Lb2:
            r9.a(r8)
            java.lang.String r7 = r9.b()
            r3.a(r7, r9)
            int r6 = r6 + 1
            goto L45
        Lbf:
            r5 = 0
            java.lang.String r6 = "countryOrAreaGroups"
            boolean r7 = r2.has(r6)
            if (r7 == 0) goto Ld1
        Lc8:
            org.json.JSONArray r2 = r2.getJSONArray(r6)
            java.util.List r5 = r14.a(r2)
            goto Ldf
        Ld1:
            java.lang.String r6 = "countryGroups"
            boolean r7 = r2.has(r6)
            if (r7 == 0) goto Lda
            goto Lc8
        Lda:
            java.lang.String r2 = "service use default countryOrAreaGroup"
            com.huawei.hms.framework.common.Logger.i(r8, r2)
        Ldf:
            r3.a(r5)
            com.huawei.hms.framework.network.grs.local.model.a r2 = r14.f29961a
            if (r2 != 0) goto Led
            com.huawei.hms.framework.network.grs.local.model.a r2 = new com.huawei.hms.framework.network.grs.local.model.a
            r2.<init>()
            r14.f29961a = r2
        Led:
            com.huawei.hms.framework.network.grs.local.model.a r2 = r14.f29961a
            r2.a(r4, r3)
        Lf2:
            int r1 = r1 + 1
            goto Lc
        Lf6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.f.a.b(org.json.JSONArray):void");
    }

    public abstract int c(String str);

    public boolean c() {
        return this.f29963c;
    }

    public int d(String str) {
        this.f29962b = new ArrayList(16);
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = null;
            if (jSONObject.has("countryOrAreaGroups")) {
                jSONArray = jSONObject.getJSONArray("countryOrAreaGroups");
            } else if (jSONObject.has("countryGroups")) {
                jSONArray = jSONObject.getJSONArray("countryGroups");
            } else {
                Logger.e("AbstractLocalManager", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
            }
            if (jSONArray == null) {
                return -1;
            }
            this.f29962b.addAll(a(jSONArray));
            return 0;
        } catch (JSONException e2) {
            Logger.w("AbstractLocalManager", "parse countrygroup failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e2.getMessage()));
            return -1;
        }
    }

    public int e(String str) {
        try {
            b(new JSONObject(str).getJSONArray("services"));
            return 0;
        } catch (JSONException e2) {
            Logger.w("AbstractLocalManager", "parse 2.0 services failed maybe because of json style.please check! %s", StringUtils.anonymizeMessage(e2.getMessage()));
            return -1;
        }
    }

    public abstract int f(String str);
}
