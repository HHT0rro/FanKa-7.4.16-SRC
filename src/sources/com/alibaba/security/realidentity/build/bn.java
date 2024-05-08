package com.alibaba.security.realidentity.build;

import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: EasyTrackApi.java */
@aw(a = "rpTrace")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class bn extends aq {
    @Override // com.alibaba.security.realidentity.build.aq
    public final String a() {
        return "rpTrace";
    }

    @Override // com.alibaba.security.realidentity.build.aq
    public final boolean a(String str, ay ayVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString(aq.I);
            String string2 = jSONObject.getString("eventId");
            JSONObject jSONObject2 = jSONObject.getJSONObject("params");
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject2.getString(next));
            }
            d.a().a(string, string2, hashMap);
            ayVar.b();
            a(new bf("success"), true);
            return true;
        } catch (JSONException e2) {
            aq.a(ayVar);
            aq.a("EasyTrackApi parse json error", e2);
            return false;
        }
    }

    @Override // com.alibaba.security.realidentity.build.aq
    public final boolean c() {
        return false;
    }
}
