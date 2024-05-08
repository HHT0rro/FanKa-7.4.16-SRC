package com.huawei.quickcard.framework.bean;

import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class I18nBean {

    /* renamed from: a, reason: collision with root package name */
    private final JSONObject f33800a;

    /* renamed from: b, reason: collision with root package name */
    private final String f33801b;

    /* renamed from: c, reason: collision with root package name */
    private String f33802c;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface Field {
        public static final String FALLBACK = "fallbackLocale";
        public static final String FIXED_LOCALE = "locale";
        public static final String I18N_OBJECT = "messages";
    }

    public I18nBean(JSONObject jSONObject, String str) {
        this.f33800a = jSONObject;
        this.f33801b = str;
    }

    public void a(String str) {
        this.f33802c = str;
    }

    public String b() {
        return this.f33801b;
    }

    public String c() {
        return this.f33802c;
    }

    public JSONObject a() {
        return this.f33800a;
    }
}
