package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class cf {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f35924a;

    public cf(Context context) {
        if (Engine.loadSuccess) {
            String nop = Engine.getInstance(context).nop();
            if (TextUtils.isEmpty(nop)) {
                return;
            }
            try {
                this.f35924a = new JSONObject(nop);
            } catch (Exception unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f35924a;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONArray b(String str) {
        JSONObject jSONObject = this.f35924a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(string);
            try {
                if (jSONArray.length() > 0) {
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                        String a10 = f.a(jSONObject2.optString("1"));
                        String a11 = f.a(jSONObject2.optString("2"));
                        if (!TextUtils.isEmpty(a10)) {
                            jSONObject2.put("1", a10);
                        }
                        if (!TextUtils.isEmpty(a11)) {
                            jSONObject2.put("2", a11);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
            return jSONArray;
        } catch (Exception unused2) {
            return null;
        }
    }
}
