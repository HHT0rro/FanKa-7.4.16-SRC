package com.alipay.sdk.data;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.util.j;
import com.kuaishou.weapon.p0.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int f4564a = 3500;

    /* renamed from: b, reason: collision with root package name */
    public static final String f4565b = "https://h5.m.taobao.com/mlapp/olist.html";

    /* renamed from: c, reason: collision with root package name */
    public static final int f4566c = 10;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f4567d = true;

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f4568e = true;

    /* renamed from: f, reason: collision with root package name */
    public static final int f4569f = 1000;

    /* renamed from: g, reason: collision with root package name */
    public static final int f4570g = 20000;

    /* renamed from: h, reason: collision with root package name */
    public static final String f4571h = "alipay_cashier_dynamic_config";

    /* renamed from: i, reason: collision with root package name */
    public static final String f4572i = "timeout";

    /* renamed from: j, reason: collision with root package name */
    public static final String f4573j = "st_sdk_config";

    /* renamed from: k, reason: collision with root package name */
    public static final String f4574k = "tbreturl";

    /* renamed from: l, reason: collision with root package name */
    public static final String f4575l = "launchAppSwitch";

    /* renamed from: m, reason: collision with root package name */
    public static final String f4576m = "configQueryInterval";

    /* renamed from: n, reason: collision with root package name */
    public static final String f4577n = "scheme_pay";

    /* renamed from: o, reason: collision with root package name */
    public static final String f4578o = "intercept_batch";

    /* renamed from: w, reason: collision with root package name */
    private static a f4579w;

    /* renamed from: q, reason: collision with root package name */
    private int f4581q = f4564a;

    /* renamed from: r, reason: collision with root package name */
    private String f4582r = f4565b;

    /* renamed from: s, reason: collision with root package name */
    private int f4583s = 10;

    /* renamed from: t, reason: collision with root package name */
    private boolean f4584t = true;

    /* renamed from: u, reason: collision with root package name */
    private boolean f4585u = true;

    /* renamed from: p, reason: collision with root package name */
    public boolean f4580p = false;

    /* renamed from: v, reason: collision with root package name */
    private List<C0096a> f4586v = null;

    public static a g() {
        if (f4579w == null) {
            a aVar = new a();
            f4579w = aVar;
            aVar.h();
        }
        return f4579w;
    }

    private void h() {
        a(j.b(com.alipay.sdk.sys.b.a().b(), f4571h, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("timeout", a());
            jSONObject.put(f4574k, d());
            jSONObject.put(f4576m, e());
            jSONObject.put(f4575l, C0096a.a(f()));
            jSONObject.put(f4577n, b());
            jSONObject.put(f4578o, c());
            j.a(com.alipay.sdk.sys.b.a().b(), f4571h, jSONObject.toString());
        } catch (Exception e2) {
            com.alipay.sdk.util.c.a(e2);
        }
    }

    public boolean b() {
        return this.f4584t;
    }

    public boolean c() {
        return this.f4585u;
    }

    public String d() {
        return this.f4582r;
    }

    public int e() {
        return this.f4583s;
    }

    public List<C0096a> f() {
        return this.f4586v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject(f4573j);
            if (optJSONObject != null) {
                this.f4581q = optJSONObject.optInt("timeout", f4564a);
                this.f4582r = optJSONObject.optString(f4574k, f4565b).trim();
                this.f4583s = optJSONObject.optInt(f4576m, 10);
                this.f4586v = C0096a.a(optJSONObject.optJSONArray(f4575l));
                this.f4584t = optJSONObject.optBoolean(f4577n, true);
                this.f4585u = optJSONObject.optBoolean(f4578o, true);
            } else {
                com.alipay.sdk.util.c.d("msp", "config is null");
            }
        } catch (Throwable th) {
            com.alipay.sdk.util.c.a(th);
        }
    }

    /* renamed from: com.alipay.sdk.data.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class C0096a {

        /* renamed from: a, reason: collision with root package name */
        public final String f4587a;

        /* renamed from: b, reason: collision with root package name */
        public final int f4588b;

        /* renamed from: c, reason: collision with root package name */
        public final String f4589c;

        public C0096a(String str, int i10, String str2) {
            this.f4587a = str;
            this.f4588b = i10;
            this.f4589c = str2;
        }

        public static C0096a a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new C0096a(jSONObject.optString("pn"), jSONObject.optInt(t.f36218c, 0), jSONObject.optString("pk"));
        }

        public String toString() {
            return String.valueOf(a(this));
        }

        public static List<C0096a> a(JSONArray jSONArray) {
            if (jSONArray == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                C0096a a10 = a(jSONArray.optJSONObject(i10));
                if (a10 != null) {
                    arrayList.add(a10);
                }
            }
            return arrayList;
        }

        public static JSONObject a(C0096a c0096a) {
            if (c0096a == null) {
                return null;
            }
            try {
                return new JSONObject().put("pn", c0096a.f4587a).put(t.f36218c, c0096a.f4588b).put("pk", c0096a.f4589c);
            } catch (JSONException e2) {
                com.alipay.sdk.util.c.a(e2);
                return null;
            }
        }

        public static JSONArray a(List<C0096a> list) {
            if (list == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<C0096a> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                jSONArray.put(a(iterator2.next()));
            }
            return jSONArray;
        }
    }

    public int a() {
        int i10 = this.f4581q;
        if (i10 >= 1000 && i10 <= 20000) {
            com.alipay.sdk.util.c.b("", "DynamicConfig::getJumpTimeout >" + this.f4581q);
            return this.f4581q;
        }
        com.alipay.sdk.util.c.b("", "DynamicConfig::getJumpTimeout(default) >3500");
        return f4564a;
    }

    public void a(boolean z10) {
        this.f4580p = z10;
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f4581q = jSONObject.optInt("timeout", f4564a);
            this.f4582r = jSONObject.optString(f4574k, f4565b).trim();
            this.f4583s = jSONObject.optInt(f4576m, 10);
            this.f4586v = C0096a.a(jSONObject.optJSONArray(f4575l));
            this.f4584t = jSONObject.optBoolean(f4577n, true);
            this.f4585u = jSONObject.optBoolean(f4578o, true);
        } catch (Throwable th) {
            com.alipay.sdk.util.c.a(th);
        }
    }

    public void a(Context context) {
        new Thread(new b(this, context)).start();
    }
}
