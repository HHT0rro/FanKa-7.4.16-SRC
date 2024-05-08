package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class bc {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f35822a;

    public bc(Context context, String str, int i10) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(i10, 0, cu.a() ? 1 : 0, str);
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f35822a = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f35822a;
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
