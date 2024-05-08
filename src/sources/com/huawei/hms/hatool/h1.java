package com.huawei.hms.hatool;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class h1 implements o1 {

    /* renamed from: a, reason: collision with root package name */
    private List<b1> f30124a;

    /* renamed from: b, reason: collision with root package name */
    private k0 f30125b;

    /* renamed from: c, reason: collision with root package name */
    private t0 f30126c;

    /* renamed from: d, reason: collision with root package name */
    private o1 f30127d;

    /* renamed from: e, reason: collision with root package name */
    private String f30128e = "";

    /* renamed from: f, reason: collision with root package name */
    private String f30129f;

    public h1(String str) {
        this.f30129f = str;
    }

    @Override // com.huawei.hms.hatool.o1
    public JSONObject a() {
        String str;
        List<b1> list = this.f30124a;
        if (list == null || list.size() == 0) {
            str = "Not have actionEvent to send";
        } else if (this.f30125b == null || this.f30126c == null || this.f30127d == null) {
            str = "model in wrong format";
        } else {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("header", this.f30125b.a());
            JSONObject jSONObject2 = new JSONObject();
            JSONObject a10 = this.f30127d.a();
            a10.put("properties", this.f30126c.a());
            try {
                a10.put("events_global_properties", new JSONObject(this.f30128e));
            } catch (JSONException unused) {
                a10.put("events_global_properties", this.f30128e);
            }
            jSONObject2.put("events_common", a10);
            JSONArray jSONArray = new JSONArray();
            Iterator<b1> iterator2 = this.f30124a.iterator2();
            while (iterator2.hasNext()) {
                JSONObject a11 = iterator2.next().a();
                if (a11 != null) {
                    jSONArray.put(a11);
                } else {
                    v.e("hmsSdk", "custom event is empty,delete this event");
                }
            }
            jSONObject2.put("events", jSONArray);
            try {
                String a12 = n.a(k1.a(jSONObject2.toString().getBytes("UTF-8")), this.f30129f);
                if (TextUtils.isEmpty(a12)) {
                    v.e("hmsSdk", "eventInfo encrypt failed,report over!");
                    return null;
                }
                jSONObject.put("event", a12);
                return jSONObject;
            } catch (UnsupportedEncodingException unused2) {
                str = "getBitZip(): Unsupported coding : utf-8";
            }
        }
        v.e("hmsSdk", str);
        return null;
    }

    public void a(k0 k0Var) {
        this.f30125b = k0Var;
    }

    public void a(l lVar) {
        this.f30127d = lVar;
    }

    public void a(t0 t0Var) {
        this.f30126c = t0Var;
    }

    public void a(String str) {
        if (str != null) {
            this.f30128e = str;
        }
    }

    public void a(List<b1> list) {
        this.f30124a = list;
    }
}
