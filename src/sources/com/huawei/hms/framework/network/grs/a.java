package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.g.g;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    private static final String f29917e = "a";

    /* renamed from: a, reason: collision with root package name */
    private final GrsBaseInfo f29918a;

    /* renamed from: b, reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.e.a f29919b;

    /* renamed from: c, reason: collision with root package name */
    private g f29920c;

    /* renamed from: d, reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.e.c f29921d;

    /* renamed from: com.huawei.hms.framework.network.grs.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class C0321a implements com.huawei.hms.framework.network.grs.b {

        /* renamed from: a, reason: collision with root package name */
        public String f29922a;

        /* renamed from: b, reason: collision with root package name */
        public Map<String, String> f29923b;

        /* renamed from: c, reason: collision with root package name */
        public IQueryUrlsCallBack f29924c;

        /* renamed from: d, reason: collision with root package name */
        public Context f29925d;

        /* renamed from: e, reason: collision with root package name */
        public GrsBaseInfo f29926e;

        /* renamed from: f, reason: collision with root package name */
        public com.huawei.hms.framework.network.grs.e.a f29927f;

        public C0321a(String str, Map<String, String> map, IQueryUrlsCallBack iQueryUrlsCallBack, Context context, GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.a aVar) {
            this.f29922a = str;
            this.f29923b = map;
            this.f29924c = iQueryUrlsCallBack;
            this.f29925d = context;
            this.f29926e = grsBaseInfo;
            this.f29927f = aVar;
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a() {
            Map<String, String> map = this.f29923b;
            if (map != null && !map.isEmpty()) {
                Logger.i(a.f29917e, "GrsClientManager.ayncGetGrsUrls: Return [%s] Urls: %s", this.f29922a, StringUtils.anonymizeMessage(new JSONObject(this.f29923b).toString()));
                this.f29924c.onCallBackSuccess(this.f29923b);
                return;
            }
            if (this.f29923b != null) {
                Logger.i(a.f29917e, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls is Empty", this.f29922a);
                this.f29924c.onCallBackFail(-3);
                return;
            }
            Logger.i(a.f29917e, "GrsClientManager.ayncGetGrsUrls: Get URL from Local JSON File");
            Map<String, String> a10 = com.huawei.hms.framework.network.grs.f.b.a(this.f29925d.getPackageName()).a(this.f29925d, this.f29927f, this.f29926e, this.f29922a, true);
            if (a10 == null || a10.isEmpty()) {
                Logger.e(a.f29917e, "The serviceName[%s] is not configured in the JSON configuration files to reveal all the details", this.f29922a);
            }
            if (a10 == null) {
                a10 = new ConcurrentHashMap<>();
            }
            Logger.i(a.f29917e, "GrsClientManager.ayncGetGrsUrls: Return [%s] Urls: %s", this.f29922a, StringUtils.anonymizeMessage(new JSONObject(a10).toString()));
            this.f29924c.onCallBackSuccess(a10);
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a(com.huawei.hms.framework.network.grs.g.d dVar) {
            IQueryUrlsCallBack iQueryUrlsCallBack;
            String j10 = dVar.j();
            Map<String, String> a10 = a.a(j10, this.f29922a);
            if (a10.isEmpty()) {
                Map<String, String> map = this.f29923b;
                if (map == null || map.isEmpty()) {
                    if (this.f29923b != null) {
                        Logger.i(a.f29917e, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls is Empty", this.f29922a);
                        this.f29924c.onCallBackFail(-5);
                        return;
                    }
                    if (!TextUtils.isEmpty(j10)) {
                        Logger.e(a.f29917e, "The serviceName[%s] is not configured on the GRS server.", this.f29922a);
                    }
                    Logger.i(a.f29917e, "GrsClientManager.ayncGetGrsUrls: Get URL from Local JSON File");
                    Map<String, String> a11 = com.huawei.hms.framework.network.grs.f.b.a(this.f29925d.getPackageName()).a(this.f29925d, this.f29927f, this.f29926e, this.f29922a, true);
                    if (a11 == null || a11.isEmpty()) {
                        Logger.e(a.f29917e, "The serviceName[%s] is not configured in the JSON configuration files to reveal all the details", this.f29922a);
                    }
                    if (a11 == null) {
                        a11 = new ConcurrentHashMap<>();
                    }
                    Logger.i(a.f29917e, "GrsClientManager.ayncGetGrsUrls: Return [%s] Urls: %s", this.f29922a, StringUtils.anonymizeMessage(new JSONObject(a11).toString()));
                    this.f29924c.onCallBackSuccess(a11);
                    return;
                }
                Logger.i(a.f29917e, "GrsClientManager.ayncGetGrsUrls: Return [%s][%s] Url: %s", this.f29922a, StringUtils.anonymizeMessage(new JSONObject(this.f29923b).toString()));
                iQueryUrlsCallBack = this.f29924c;
                a10 = this.f29923b;
            } else {
                Logger.i(a.f29917e, "GrsClientManager.ayncGetGrsUrls: Get URL from Current Called GRS Server Return [%s] Urls: %s", this.f29922a, StringUtils.anonymizeMessage(new JSONObject(a10).toString()));
                iQueryUrlsCallBack = this.f29924c;
            }
            iQueryUrlsCallBack.onCallBackSuccess(a10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b implements com.huawei.hms.framework.network.grs.b {

        /* renamed from: a, reason: collision with root package name */
        public String f29928a;

        /* renamed from: b, reason: collision with root package name */
        public String f29929b;

        /* renamed from: c, reason: collision with root package name */
        public IQueryUrlCallBack f29930c;

        /* renamed from: d, reason: collision with root package name */
        public String f29931d;

        /* renamed from: e, reason: collision with root package name */
        public Context f29932e;

        /* renamed from: f, reason: collision with root package name */
        public GrsBaseInfo f29933f;

        /* renamed from: g, reason: collision with root package name */
        public com.huawei.hms.framework.network.grs.e.a f29934g;

        public b(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, String str3, Context context, GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.a aVar) {
            this.f29928a = str;
            this.f29929b = str2;
            this.f29930c = iQueryUrlCallBack;
            this.f29931d = str3;
            this.f29932e = context;
            this.f29933f = grsBaseInfo;
            this.f29934g = aVar;
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a() {
            if (!TextUtils.isEmpty(this.f29931d)) {
                Logger.i(a.f29917e, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.f29928a, this.f29929b, StringUtils.anonymizeMessage(this.f29931d));
                this.f29930c.onCallBackSuccess(this.f29931d);
                return;
            }
            if (!TextUtils.isEmpty(this.f29931d)) {
                Logger.i(a.f29917e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url is Empty", this.f29928a, this.f29929b);
                this.f29930c.onCallBackFail(-3);
                return;
            }
            Logger.i(a.f29917e, "GrsClientManager.ayncGetGrsUrl: Get URL from Local JSON File");
            String a10 = com.huawei.hms.framework.network.grs.f.b.a(this.f29932e.getPackageName()).a(this.f29932e, this.f29934g, this.f29933f, this.f29928a, this.f29929b, true);
            if (a10 == null || a10.isEmpty()) {
                Logger.e(a.f29917e, "The serviceName[%s][%s] is not configured in the JSON configuration files to reveal all the details", this.f29928a, this.f29929b);
            }
            Logger.i(a.f29917e, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.f29928a, this.f29929b, StringUtils.anonymizeMessage(a10));
            this.f29930c.onCallBackSuccess(a10);
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a(com.huawei.hms.framework.network.grs.g.d dVar) {
            IQueryUrlCallBack iQueryUrlCallBack;
            String str;
            String j10 = dVar.j();
            Map<String, String> a10 = a.a(j10, this.f29928a);
            if (a10.containsKey(this.f29929b)) {
                String str2 = a.f29917e;
                String str3 = this.f29929b;
                Logger.i(str2, "GrsClientManager.ayncGetGrsUrl: Get URL from Current Called GRS Server, Return [%s][%s] Url: %s", this.f29928a, str3, StringUtils.anonymizeMessage(a10.get(str3)));
                iQueryUrlCallBack = this.f29930c;
                str = a10.get(this.f29929b);
            } else {
                if (TextUtils.isEmpty(this.f29931d)) {
                    if (!TextUtils.isEmpty(this.f29931d)) {
                        Logger.i(a.f29917e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url is Empty", this.f29928a, this.f29929b);
                        this.f29930c.onCallBackFail(-5);
                        return;
                    }
                    if (!TextUtils.isEmpty(j10)) {
                        Logger.e(a.f29917e, "The serviceName[%s][%s] is not configured on the GRS server.", this.f29928a, this.f29929b);
                    }
                    Logger.i(a.f29917e, "GrsClientManager.ayncGetGrsUrl: Get URL from Local JSON File");
                    String a11 = com.huawei.hms.framework.network.grs.f.b.a(this.f29932e.getPackageName()).a(this.f29932e, this.f29934g, this.f29933f, this.f29928a, this.f29929b, true);
                    if (a11 == null || a11.isEmpty()) {
                        Logger.e(a.f29917e, "The serviceName[%s][%s] is not configured in the JSON configuration files to reveal all the details", this.f29928a, this.f29929b);
                    }
                    Logger.i(a.f29917e, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.f29928a, this.f29929b, StringUtils.anonymizeMessage(a11));
                    this.f29930c.onCallBackSuccess(a11);
                    return;
                }
                String str4 = a.f29917e;
                String str5 = this.f29929b;
                Logger.i(str4, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.f29928a, str5, StringUtils.anonymizeMessage(a10.get(str5)));
                iQueryUrlCallBack = this.f29930c;
                str = this.f29931d;
            }
            iQueryUrlCallBack.onCallBackSuccess(str);
        }
    }

    public a(GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.a aVar, g gVar, com.huawei.hms.framework.network.grs.e.c cVar) {
        this.f29918a = grsBaseInfo;
        this.f29919b = aVar;
        this.f29920c = gVar;
        this.f29921d = cVar;
    }

    public static CountryCodeBean a(Context context, boolean z10) {
        return new CountryCodeBean(context, z10);
    }

    public static Map<String, Map<String, String>> a(String str) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        if (TextUtils.isEmpty(str)) {
            Logger.v(f29917e, "isSpExpire jsonValue is null.");
            return concurrentHashMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                if (!TextUtils.isEmpty(next)) {
                    concurrentHashMap.put(next, a(jSONObject2));
                }
            }
            return concurrentHashMap;
        } catch (JSONException e2) {
            Logger.w(f29917e, "getServicesUrlsMap occur a JSONException: %s", StringUtils.anonymizeMessage(e2.getMessage()));
            return concurrentHashMap;
        }
    }

    private Map<String, String> a(String str, com.huawei.hms.framework.network.grs.e.b bVar, Context context) {
        Map<String, String> a10 = this.f29919b.a(this.f29918a, str, bVar, context);
        if (a10 != null && !a10.isEmpty()) {
            Logger.i(f29917e, "GrsClientManager.getUrlsLocal: Get URL from GRS Server Cache");
            return a10;
        }
        Map<String, String> a11 = com.huawei.hms.framework.network.grs.f.b.a(context.getPackageName()).a(context, this.f29919b, this.f29918a, str, false);
        Logger.i(f29917e, "GrsClientManager.getUrlsLocal: Get URL from Local JSON File");
        return a11 != null ? a11 : new HashMap();
    }

    public static Map<String, String> a(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            Logger.w(f29917e, "isSpExpire jsonValue from server is null.");
            return hashMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.has(str2) ? jSONObject.getJSONObject(str2) : null;
            if (jSONObject2 == null) {
                Logger.w(f29917e, "getServiceNameUrls: paser null from server json data by {%s}.", str2);
                return hashMap;
            }
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject2.get(next).toString());
            }
            return hashMap;
        } catch (JSONException e2) {
            Logger.w(f29917e, "Method{getServiceNameUrls} query url from SP occur an JSONException: %s", StringUtils.anonymizeMessage(e2.getMessage()));
            return hashMap;
        }
    }

    public static Map<String, String> a(JSONObject jSONObject) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String obj = jSONObject.get(next).toString();
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(obj)) {
                    concurrentHashMap.put(next, obj);
                }
            }
            return concurrentHashMap;
        } catch (JSONException e2) {
            Logger.w(f29917e, "getServiceUrls occur a JSONException: %s", StringUtils.anonymizeMessage(e2.getMessage()));
            return concurrentHashMap;
        }
    }

    public String a(Context context, String str, int i10) {
        com.huawei.hms.framework.network.grs.g.d a10 = this.f29920c.a(new com.huawei.hms.framework.network.grs.g.j.c(this.f29918a, context), str, this.f29921d, i10);
        return a10 == null ? "" : a10.m() ? this.f29919b.a().a(this.f29918a.getGrsParasKey(true, true, context), "") : a10.j();
    }

    public String a(String str, String str2, Context context, int i10) {
        com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
        String str3 = a(str, bVar, context).get(str2);
        if (bVar.a() && !TextUtils.isEmpty(str3)) {
            Logger.i(f29917e, "GrsClientManager.synGetGrsUrl: Return [%s][%s] Url: %s", str, str2, StringUtils.anonymizeMessage(str3));
            return str3;
        }
        String a10 = a(context, str, i10);
        String str4 = a(a10, str).get(str2);
        if (!TextUtils.isEmpty(str4)) {
            Logger.i(f29917e, "GrsClientManager.synGetGrsUrl: Get URL from Current Called GRS Server, Return [%s][%s] Url: %s", str, str2, StringUtils.anonymizeMessage(str4));
            return str4;
        }
        if (TextUtils.isEmpty(str3)) {
            if (!TextUtils.isEmpty(a10)) {
                Logger.e(f29917e, "The serviceName[%s][%s] is not configured on the GRS server.", str, str2);
            }
            String str5 = f29917e;
            Logger.i(str5, "GrsClientManager.synGetGrsUrl: Get URL from Local JSON File.");
            str3 = com.huawei.hms.framework.network.grs.f.b.a(context.getPackageName()).a(context, this.f29919b, this.f29918a, str, str2, true);
            if (str3 == null || str3.isEmpty()) {
                Logger.e(str5, "The serviceName[%s][%s] is not configured in the JSON configuration files to reveal all the details", str, str2);
            }
        }
        Logger.i(f29917e, "GrsClientManager.synGetGrsUrl: Return [%s][%s] Url: %s", str, str2, StringUtils.anonymizeMessage(str3));
        return str3;
    }

    public Map<String, String> a(String str, Context context, int i10) {
        com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
        Map<String, String> a10 = a(str, bVar, context);
        if (bVar.a() && !a10.isEmpty()) {
            Logger.i(f29917e, "Return [%s] Urls: %s", str, StringUtils.anonymizeMessage(new JSONObject(a10).toString()));
            return a10;
        }
        String a11 = a(context, str, i10);
        Map<String, String> a12 = a(a11, str);
        if (!a12.isEmpty()) {
            Logger.i(f29917e, "GrsClientManager.synGetGrsUrls: Get URL from Current Called GRS Server Return [%s] Urls: %s", str, StringUtils.anonymizeMessage(new JSONObject(a12).toString()));
            return a12;
        }
        if (a10.isEmpty()) {
            if (!TextUtils.isEmpty(a11)) {
                Logger.e(f29917e, "The serviceName[%s] is not configured on the GRS server.", str);
            }
            String str2 = f29917e;
            Logger.i(str2, "GrsClientManager.synGetGrsUrls: Get URL from Local JSON File.");
            a10 = com.huawei.hms.framework.network.grs.f.b.a(context.getPackageName()).a(context, this.f29919b, this.f29918a, str, true);
            if (a10 == null || a10.isEmpty()) {
                Logger.e(str2, "The serviceName[%s] is not configured in the JSON configuration files to reveal all the details", str);
            }
        }
        String str3 = f29917e;
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = StringUtils.anonymizeMessage(a10 != null ? new JSONObject(a10).toString() : "");
        Logger.i(str3, "GrsClientManager.synGetGrsUrls: Return [%s] Urls: %s", objArr);
        return a10;
    }

    public void a(String str, IQueryUrlsCallBack iQueryUrlsCallBack, Context context, int i10) {
        com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
        Map<String, String> a10 = a(str, bVar, context);
        if (!bVar.a()) {
            this.f29920c.a(new com.huawei.hms.framework.network.grs.g.j.c(this.f29918a, context), new C0321a(str, a10, iQueryUrlsCallBack, context, this.f29918a, this.f29919b), str, this.f29921d, i10);
            return;
        }
        if (a10.isEmpty()) {
            Logger.i(f29917e, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls is Empty", str);
            iQueryUrlsCallBack.onCallBackFail(-5);
        } else {
            String str2 = f29917e;
            Logger.i(str2, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls: %s", str, StringUtils.anonymizeMessage(new JSONObject(a10).toString()));
            Logger.i(str2, "ayncGetGrsUrls: %s", StringUtils.anonymizeMessage(new JSONObject(a10).toString()));
            iQueryUrlsCallBack.onCallBackSuccess(a10);
        }
    }

    public void a(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, Context context, int i10) {
        com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
        String str3 = a(str, bVar, context).get(str2);
        if (!bVar.a()) {
            this.f29920c.a(new com.huawei.hms.framework.network.grs.g.j.c(this.f29918a, context), new b(str, str2, iQueryUrlCallBack, str3, context, this.f29918a, this.f29919b), str, this.f29921d, i10);
        } else if (TextUtils.isEmpty(str3)) {
            Logger.i(f29917e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url is Empty", str, str2);
            iQueryUrlCallBack.onCallBackFail(-5);
        } else {
            Logger.i(f29917e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url: %s", str, str2, StringUtils.anonymizeMessage(str3));
            iQueryUrlCallBack.onCallBackSuccess(str3);
        }
    }
}
