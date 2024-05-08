package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.col.p0003l.fk;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: OfflineUpdateCityHandlerAbstract.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class bf extends bw<String, List<OfflineMapProvince>> {

    /* renamed from: d, reason: collision with root package name */
    private Context f5118d;

    public bf(Context context, String str) {
        super(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.p0003l.bw
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public List<OfflineMapProvince> a(JSONObject jSONObject) throws AMapException {
        try {
            if (this.f5118d != null) {
                bv.c(jSONObject.toString(), this.f5118d);
            }
        } catch (Throwable th) {
            gy.b(th, "OfflineUpdateCityHandlerAbstract", "loadData jsonInit");
            th.printStackTrace();
        }
        try {
            Context context = this.f5118d;
            if (context != null) {
                return bv.a(jSONObject, context);
            }
            return null;
        } catch (JSONException e2) {
            gy.b(e2, "OfflineUpdateCityHandlerAbstract", "loadData parseJson");
            e2.printStackTrace();
            return null;
        }
    }

    public final void a(Context context) {
        this.f5118d = context;
    }

    @Override // com.amap.api.col.p0003l.bw
    public final JSONObject a(fk.b bVar) {
        JSONObject jSONObject;
        if (bVar == null || (jSONObject = bVar.f5806f) == null) {
            return null;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("015");
        if (!optJSONObject.has("result")) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("result", new JSONObject().put("offlinemap_with_province_vfour", optJSONObject));
                return jSONObject2;
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return optJSONObject;
    }

    @Override // com.amap.api.col.p0003l.bw
    public final Map<String, String> b() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("mapver", this.f5178a);
        return hashtable;
    }

    @Override // com.amap.api.col.p0003l.bw
    public final String a() {
        return "015";
    }
}
