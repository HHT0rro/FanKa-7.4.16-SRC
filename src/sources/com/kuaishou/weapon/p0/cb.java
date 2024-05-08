package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class cb {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f35920a;

    public cb(Context context) {
        if (Engine.loadSuccess) {
            String ghi = Engine.getInstance(context).ghi();
            if (TextUtils.isEmpty(ghi)) {
                return;
            }
            try {
                this.f35920a = new JSONObject(ghi);
            } catch (Exception unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f35920a;
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
