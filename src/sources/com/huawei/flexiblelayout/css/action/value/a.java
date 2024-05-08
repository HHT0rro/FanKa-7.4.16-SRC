package com.huawei.flexiblelayout.css.action.value;

import com.huawei.flexiblelayout.css.CSSRule;
import com.huawei.flexiblelayout.css.adapter.type.CSSValue;
import com.huawei.flexiblelayout.css.c;
import com.huawei.flexiblelayout.log.Log;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CSSActionValue.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a extends CSSValue {

    /* renamed from: c, reason: collision with root package name */
    private static final String f27991c = "CSSActionValue";

    /* renamed from: a, reason: collision with root package name */
    private CSSRule f27992a;

    /* renamed from: b, reason: collision with root package name */
    private CSSRule f27993b;

    public a(String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf("|")) <= 0) {
            return;
        }
        String substring = str.substring(0, indexOf);
        try {
            JSONObject jSONObject = new JSONObject(str.substring(indexOf + 1));
            this.f27992a = c.b(jSONObject.optJSONObject(substring));
            this.f27993b = a(jSONObject);
        } catch (JSONException e2) {
            Log.w(f27991c, "CSSActionValue, e: " + e2.getMessage());
        }
    }

    public void a(CSSRule cSSRule) {
        this.f27992a = cSSRule;
    }

    public void b(CSSRule cSSRule) {
        this.f27993b = cSSRule;
    }

    public CSSRule a() {
        return this.f27992a;
    }

    public CSSRule b() {
        return this.f27993b;
    }

    private CSSRule a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!a(next)) {
                try {
                    jSONObject2.put(next, jSONObject.get(next));
                } catch (JSONException e2) {
                    Log.w(f27991c, "getDefaultParams, e: " + e2.getMessage());
                }
            }
        }
        return c.b(jSONObject2);
    }

    private boolean a(String str) {
        return com.huawei.flexiblelayout.css.action.a.b().b(str);
    }
}
