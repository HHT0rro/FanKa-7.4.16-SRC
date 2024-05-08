package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.col.s.am;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.poisearch.PoiSearch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PoiSearchIdHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ad extends ac<String, PoiItem> {

    /* renamed from: g, reason: collision with root package name */
    private PoiSearch.Query f7074g;

    public ad(Context context, String str, PoiSearch.Query query) {
        super(context, str);
        this.f7074g = query;
    }

    private static PoiItem e(String str) throws AMapException {
        try {
            return a(new JSONObject(str));
        } catch (JSONException e2) {
            n.a(e2, "PoiSearchIdHandler", "paseJSONJSONException");
            return null;
        } catch (Exception e10) {
            n.a(e10, "PoiSearchIdHandler", "paseJSONException");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String j() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("id=");
        sb2.append((String) ((e) this).f7860b);
        sb2.append("&output=json");
        PoiSearch.Query query = this.f7074g;
        if (query != null && !ac.c(query.getExtensions())) {
            sb2.append("&extensions=");
            sb2.append(this.f7074g.getExtensions());
        } else {
            sb2.append("&extensions=base");
        }
        sb2.append("&children=1");
        sb2.append("&key=" + bw.f(((e) this).f7863e));
        return sb2.toString();
    }

    @Override // com.amap.api.col.s.f, com.amap.api.col.s.e
    public final /* synthetic */ Object a(String str) throws AMapException {
        return e(str);
    }

    @Override // com.amap.api.col.s.f, com.amap.api.col.s.e
    public final String a_() {
        return j();
    }

    @Override // com.amap.api.col.s.dz
    public final String b() {
        return m.a() + "/place/detail?";
    }

    private static PoiItem a(JSONObject jSONObject) throws JSONException {
        JSONObject optJSONObject;
        JSONArray optJSONArray = jSONObject.optJSONArray("pois");
        if (optJSONArray == null || optJSONArray.length() <= 0 || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
            return null;
        }
        return v.e(optJSONObject);
    }

    @Override // com.amap.api.col.s.e
    public final am.b e() {
        am.b bVar = new am.b();
        bVar.f7098a = b() + a_() + "language=" + ServiceSettings.getInstance().getLanguage();
        return bVar;
    }
}
