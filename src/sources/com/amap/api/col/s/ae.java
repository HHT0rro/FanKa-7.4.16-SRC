package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.s.am;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.poisearch.PoiSearchV2;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PoiSearchIdHandlerV2.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ae extends ac<String, PoiItemV2> {

    /* renamed from: g, reason: collision with root package name */
    private PoiSearchV2.Query f7075g;

    public ae(Context context, String str, PoiSearchV2.Query query) {
        super(context, str);
        this.f7075g = query;
    }

    private static PoiItemV2 e(String str) throws AMapException {
        try {
            return a(new JSONObject(str));
        } catch (JSONException e2) {
            n.a(e2, "PoiSearchIdHandlerV2", "paseJSONJSONException");
            return null;
        } catch (Exception e10) {
            n.a(e10, "PoiSearchIdHandlerV2", "paseJSONException");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String j() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("id=");
        sb2.append((String) ((e) this).f7860b);
        sb2.append("&output=json");
        PoiSearchV2.Query query = this.f7075g;
        String a10 = (query == null || query.getShowFields() == null) ? null : ac.a(this.f7075g.getShowFields());
        if (a10 != null) {
            sb2.append("&show_fields=");
            sb2.append(a10);
        }
        sb2.append("&key=" + bw.f(((e) this).f7863e));
        String channel = this.f7075g.getChannel();
        if (!TextUtils.isEmpty(channel)) {
            sb2.append("&channel=");
            sb2.append(channel);
        }
        String premium = this.f7075g.getPremium();
        if (!TextUtils.isEmpty(premium)) {
            sb2.append("&permium=");
            sb2.append(premium);
        }
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
        return m.c() + "/place/detail?";
    }

    private static PoiItemV2 a(JSONObject jSONObject) throws JSONException {
        JSONObject optJSONObject;
        JSONArray optJSONArray = jSONObject.optJSONArray("pois");
        if (optJSONArray == null || optJSONArray.length() <= 0 || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
            return null;
        }
        return v.f(optJSONObject);
    }

    @Override // com.amap.api.col.s.e
    public final am.b e() {
        am.b bVar = new am.b();
        bVar.f7098a = b() + a_() + "language=" + ServiceSettings.getInstance().getLanguage();
        return bVar;
    }
}
