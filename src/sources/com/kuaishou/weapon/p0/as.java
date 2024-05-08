package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class as extends dg {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f35803a;

    public as(Context context, int i10) {
        if (Engine.loadSuccess) {
            try {
                Engine engine = Engine.getInstance(context);
                int intValue = Integer.valueOf(ck.f35933c).intValue();
                String a10 = a(context);
                if (TextUtils.isEmpty(a10)) {
                    return;
                }
                String eopq = engine.eopq(intValue, 0, i10, a10);
                if (TextUtils.isEmpty(eopq)) {
                    return;
                }
                this.f35803a = new JSONObject(eopq);
            } catch (Throwable unused) {
            }
        }
    }

    public JSONObject a() {
        return this.f35803a;
    }

    public String b(String str) {
        JSONObject jSONObject = this.f35803a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            return !TextUtils.isEmpty(string) ? string.replace("\n", "").replace("\t", " ") : string;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONArray c(String str) {
        JSONObject jSONObject = this.f35803a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (TextUtils.isEmpty(string) || string.length() <= 3) {
                return null;
            }
            String replaceAll = string.replaceAll("\\n", "");
            if (!TextUtils.isEmpty(replaceAll)) {
                string = replaceAll;
            }
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray.length() > 1) {
                return jSONArray;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject d(String str) {
        JSONObject jSONObject = this.f35803a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (TextUtils.isEmpty(string) || string.length() <= 2) {
                return null;
            }
            JSONObject jSONObject2 = new JSONObject(string);
            if (jSONObject2.length() > 1) {
                return jSONObject2;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public String e(String str) {
        JSONObject jSONObject = this.f35803a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            if (string.length() > 2) {
                return string;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f35803a;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    private String a(Context context) {
        try {
            StringBuilder sb2 = new StringBuilder();
            h a10 = h.a(context, "re_po_rt");
            sb2.append(a10.b(df.f36052aa, 1));
            sb2.append(a10.b(df.X, 1));
            sb2.append(a10.b(df.V, 1));
            sb2.append(a10.b(df.Z, 1));
            sb2.append(a10.b(df.f36053ab, 1));
            sb2.append(a10.b(df.aj, 1));
            sb2.append(a10.b(df.Y, 1));
            sb2.append(a10.b(df.U, 1));
            sb2.append(a10.b(df.am, 1));
            sb2.append(a10.b(df.ak, 1));
            sb2.append(a10.b(df.al, 1));
            return sb2.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
