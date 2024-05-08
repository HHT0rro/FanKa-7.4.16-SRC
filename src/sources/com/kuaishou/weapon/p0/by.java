package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class by {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f35889a;

    public by(Context context) {
        if (Engine.loadSuccess) {
            String cde = Engine.getInstance(context).cde();
            if (TextUtils.isEmpty(cde)) {
                return;
            }
            try {
                this.f35889a = new JSONObject(cde);
            } catch (Exception unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f35889a;
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
        JSONObject jSONObject = this.f35889a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            return new JSONArray(string);
        } catch (Exception unused) {
            return null;
        }
    }
}
