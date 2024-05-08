package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.core.AMapException;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CloudSearchIdHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class k extends j<ai, CloudItemDetail> {
    public k(Context context, ai aiVar) {
        super(context, aiVar);
    }

    private static CloudItemDetail c(String str) throws AMapException {
        if (str == null || str.equals("")) {
            return null;
        }
        try {
            return d(new JSONObject(str));
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    private static CloudItemDetail d(JSONObject jSONObject) throws JSONException {
        JSONArray a10 = j.a(jSONObject);
        if (a10 == null || a10.length() <= 0) {
            return null;
        }
        JSONObject jSONObject2 = a10.getJSONObject(0);
        CloudItemDetail c4 = j.c(jSONObject2);
        j.a(c4, jSONObject2);
        return c4;
    }

    @Override // com.amap.api.col.s.f, com.amap.api.col.s.e
    public final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    @Override // com.amap.api.col.s.f, com.amap.api.col.s.e
    public final String a_() {
        return null;
    }

    @Override // com.amap.api.col.s.dz
    public final String b() {
        return m.e() + "/datasearch/id";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.f, com.amap.api.col.s.e, com.amap.api.col.s.dz
    public final Map<String, String> f() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("key", bw.f(((e) this).f7863e));
        hashtable.put("layerId", ((ai) ((e) this).f7860b).f7085a);
        hashtable.put("output", "json");
        hashtable.put("id", ((ai) ((e) this).f7860b).f7086b);
        String a10 = bz.a();
        String a11 = bz.a(((e) this).f7863e, a10, ci.b(hashtable));
        hashtable.put("ts", a10);
        hashtable.put("scode", a11);
        return hashtable;
    }
}
