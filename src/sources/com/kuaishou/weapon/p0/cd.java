package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class cd {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f35922a;

    public cd(Context context) {
        if (Engine.loadSuccess) {
            String hij = Engine.getInstance(context).hij();
            if (TextUtils.isEmpty(hij)) {
                return;
            }
            try {
                this.f35922a = new JSONObject(hij);
            } catch (Exception unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f35922a;
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
