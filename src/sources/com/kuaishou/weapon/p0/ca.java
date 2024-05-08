package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ca {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f35919a;

    public ca(Context context) {
        if (Engine.loadSuccess) {
            String efg = Engine.getInstance(context).efg();
            if (TextUtils.isEmpty(efg)) {
                return;
            }
            try {
                this.f35919a = new JSONObject(efg);
            } catch (Exception unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f35919a;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }
}
