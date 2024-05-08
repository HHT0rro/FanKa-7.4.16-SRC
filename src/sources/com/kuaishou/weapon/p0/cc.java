package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class cc {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f35921a;

    public cc(Context context) {
        if (Engine.loadSuccess) {
            Engine.getInstance(context);
            String bcd = Engine.bcd();
            if (TextUtils.isEmpty(bcd) || bcd.length() <= 2) {
                return;
            }
            try {
                this.f35921a = new JSONObject(bcd);
            } catch (Exception unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f35921a;
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
