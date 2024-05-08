package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ce {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f35923a;

    public ce(Context context) {
        if (Engine.loadSuccess) {
            Engine.getInstance(context);
            String abc = Engine.abc();
            if (TextUtils.isEmpty(abc)) {
                return;
            }
            try {
                this.f35923a = new JSONObject(abc);
            } catch (Exception unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f35923a;
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
