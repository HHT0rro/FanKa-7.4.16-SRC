package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class aw {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f35810a;

    public aw(Context context) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.f35941k).intValue(), 0, 1, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f35810a = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    public JSONObject a() {
        return this.f35810a;
    }

    public JSONObject b(Context context) {
        try {
            if (!Engine.loadSuccess) {
                return null;
            }
            String pqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.f35940j).intValue(), 1, 2, "");
            if (TextUtils.isEmpty(pqr) || pqr.length() <= 2) {
                return null;
            }
            return new JSONObject(pqr);
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject c(Context context) {
        try {
            if (!Engine.loadSuccess) {
                return null;
            }
            String pqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.f35940j).intValue(), 2, 1, "");
            if (TextUtils.isEmpty(pqr)) {
                return null;
            }
            return new JSONObject(pqr);
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject d(Context context) {
        JSONObject jSONObject = null;
        try {
            if (Engine.loadSuccess) {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.f35940j).intValue(), 1, 3, "");
                if (!TextUtils.isEmpty(pqr)) {
                    jSONObject = new JSONObject(pqr);
                }
            }
            if (bh.a(context, "com.freeze.kusr")) {
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                jSONObject.put("com.freeze.kusr", 1);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public void a(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = this.f35810a;
            if (jSONObject2 != null) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String string = this.f35810a.getString(next);
                    if (!TextUtils.isEmpty(string)) {
                        jSONObject.put(next, string);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public JSONObject a(Context context) {
        try {
            if (!Engine.loadSuccess) {
                return null;
            }
            String pqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.f35940j).intValue(), 1, 0, "");
            if (TextUtils.isEmpty(pqr)) {
                return null;
            }
            return new JSONObject(pqr);
        } catch (Exception unused) {
            return null;
        }
    }
}
