package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class az {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f35813a;

    public az(Context context, int i10) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.f35933c).intValue(), 2, i10 < 10 ? 10 : i10, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f35813a = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    private String b(String str) {
        JSONObject jSONObject = this.f35813a;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject a(String str) {
        try {
            String b4 = b(str);
            if (TextUtils.isEmpty(b4)) {
                return null;
            }
            return new JSONObject(b4);
        } catch (Exception unused) {
            return null;
        }
    }
}
