package com.huawei.appgallery.serviceverifykit.api;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ServiceVerifyKit {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public String f27650a;

        /* renamed from: j, reason: collision with root package name */
        public Context f27659j;

        /* renamed from: k, reason: collision with root package name */
        public int f27660k;

        /* renamed from: n, reason: collision with root package name */
        public Intent f27663n;

        /* renamed from: o, reason: collision with root package name */
        public ComponentType f27664o;

        /* renamed from: q, reason: collision with root package name */
        public String f27666q;

        /* renamed from: b, reason: collision with root package name */
        public String f27651b = "AppGallery Verification";

        /* renamed from: c, reason: collision with root package name */
        public String f27652c = "Huawei CBG Cloud Security Signer";

        /* renamed from: d, reason: collision with root package name */
        public String f27653d = "com.huawei.appgallery.fingerprint_signature";

        /* renamed from: e, reason: collision with root package name */
        public String f27654e = "com.huawei.appgallery.sign_certchain";

        /* renamed from: f, reason: collision with root package name */
        public Map<String, String[]> f27655f = new HashMap();

        /* renamed from: g, reason: collision with root package name */
        public Map<String, Integer> f27656g = new HashMap();

        /* renamed from: h, reason: collision with root package name */
        public List<String> f27657h = new ArrayList();

        /* renamed from: i, reason: collision with root package name */
        public List<b> f27658i = new ArrayList();

        /* renamed from: l, reason: collision with root package name */
        public int f27661l = 0;

        /* renamed from: m, reason: collision with root package name */
        public int f27662m = 0;

        /* renamed from: p, reason: collision with root package name */
        public String f27665p = "verify_match_property";

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public enum ComponentType {
            ACTIVITY,
            SERVICE,
            BROADCAST
        }

        public Builder a(String str, String str2) {
            this.f27655f.put(str, ServiceVerifyKit.d(this.f27655f.get(str), str2));
            this.f27656g.put(str, Integer.valueOf(this.f27661l));
            return this;
        }

        public String b() {
            ServiceVerifyKit serviceVerifyKit = new ServiceVerifyKit();
            na.a aVar = new na.a(this.f27659j);
            aVar.k(this.f27650a, this.f27651b, this.f27652c, this.f27653d, this.f27654e, this.f27655f, this.f27656g, this.f27660k, this.f27657h, this.f27658i, this.f27662m, this.f27665p, this.f27666q, this.f27663n, this.f27664o);
            return serviceVerifyKit.b(aVar);
        }

        public Builder c(String str) {
            if (TextUtils.isEmpty(str)) {
                pa.b.f52973b.a("ServiceVerifyKit", "error input chain key");
            } else {
                this.f27654e = str;
            }
            return this;
        }

        public Builder d(String str) {
            if (TextUtils.isEmpty(str)) {
                pa.b.f52973b.a("ServiceVerifyKit", "error input signer key");
            } else {
                this.f27653d = str;
            }
            return this;
        }

        public Builder e(Context context) {
            this.f27659j = context.getApplicationContext();
            return this;
        }

        public Builder f(Intent intent, ComponentType componentType) {
            if (intent == null) {
                pa.b.f52973b.a("ServiceVerifyKit", "error input intent");
            } else {
                this.f27663n = intent;
            }
            if (componentType == null) {
                pa.b.f52973b.a("ServiceVerifyKit", "error input type");
            } else {
                this.f27664o = componentType;
            }
            return this;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f27667a;

        /* renamed from: b, reason: collision with root package name */
        public String f27668b;

        public String a() {
            return this.f27667a;
        }

        public String b() {
            return this.f27668b;
        }
    }

    public ServiceVerifyKit() {
    }

    public static String[] d(String[] strArr, String str) {
        if (strArr == null) {
            return new String[]{str};
        }
        int length = strArr.length;
        for (String str2 : strArr) {
            if (TextUtils.equals(str2, str)) {
                return strArr;
            }
        }
        String[] strArr2 = new String[length + 1];
        System.arraycopy(strArr, 0, strArr2, 0, length);
        strArr2[length] = str;
        return strArr2;
    }

    public final String b(na.a aVar) {
        List<la.a> g3 = aVar.g();
        if (g3 == null || g3.isEmpty()) {
            return null;
        }
        return new ma.a().a(g3);
    }
}
