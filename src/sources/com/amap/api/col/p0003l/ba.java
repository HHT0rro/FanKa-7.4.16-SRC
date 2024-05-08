package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.col.p0003l.fk;
import com.amap.api.maps.AMapException;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: OfflineInitHandlerAbstract.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ba extends bw<String, az> {
    public ba(Context context, String str) {
        super(context, str);
    }

    @Override // com.amap.api.col.p0003l.bw
    public final /* synthetic */ az a(JSONObject jSONObject) throws AMapException {
        return b(jSONObject);
    }

    @Override // com.amap.api.col.p0003l.bw
    public final Map<String, String> b() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("mapver", this.f5178a);
        return hashtable;
    }

    @Override // com.amap.api.col.p0003l.bw
    public final JSONObject a(fk.b bVar) {
        JSONObject jSONObject;
        if (bVar == null || (jSONObject = bVar.f5806f) == null) {
            return null;
        }
        return jSONObject.optJSONObject("016");
    }

    private static az b(JSONObject jSONObject) throws AMapException {
        az azVar = new az();
        try {
            String optString = jSONObject.optString("update", "");
            if (optString.equals("0")) {
                azVar.a(false);
            } else if (optString.equals("1")) {
                azVar.a(true);
            }
            azVar.a(jSONObject.optString("version", ""));
        } catch (Throwable th) {
            gy.b(th, "OfflineInitHandlerAbstract", "loadData parseJson");
        }
        return azVar;
    }

    @Override // com.amap.api.col.p0003l.bw
    public final String a() {
        return "016";
    }
}
