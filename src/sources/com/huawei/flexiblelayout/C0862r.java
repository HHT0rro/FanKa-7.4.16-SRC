package com.huawei.flexiblelayout;

import com.huawei.flexiblelayout.css.adapter.type.CSSValue;
import com.huawei.flexiblelayout.log.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CSSEffectValue.java */
/* renamed from: com.huawei.flexiblelayout.r, reason: case insensitive filesystem */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class C0862r extends CSSValue {

    /* renamed from: b, reason: collision with root package name */
    private static final String f28435b = "CSSEffectValue";

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f28436a;

    public C0862r(String str) {
        try {
            this.f28436a = new JSONObject(str);
        } catch (JSONException e2) {
            Log.w(f28435b, "CSSEffectValue, e: " + e2.getMessage());
        }
    }

    public JSONObject a() {
        return this.f28436a;
    }
}
