package com.yxcorp.kuaishou.addfp.android.b;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public boolean f48582a;

    /* renamed from: b, reason: collision with root package name */
    public int f48583b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f48584c;

    /* renamed from: d, reason: collision with root package name */
    public String f48585d;

    public c(String str) {
        this.f48582a = true;
        if (TextUtils.isEmpty(str)) {
            this.f48582a = false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f48583b = jSONObject.optInt("errorCode", 2);
            this.f48584c = jSONObject.optBoolean("userSet", true);
            this.f48585d = jSONObject.optString("value", "KWE_OTHER");
        } catch (JSONException e2) {
            this.f48582a = false;
            e2.printStackTrace();
        }
    }

    public String a(boolean z10) {
        if (!this.f48582a) {
            return "KWE_OTHER";
        }
        if (z10 != this.f48584c) {
            return "KWE_NPN";
        }
        int i10 = this.f48583b;
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? "KWE_OTHER" : "KWE_NS" : "KWE_N" : "KWE_PE" : "KWE_PN" : !TextUtils.isEmpty(this.f48585d) ? this.f48585d : "KWE_N";
    }
}
