package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearchQuery;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DistrictServerHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class p extends f<DistrictSearchQuery, DistrictResult> {
    public p(Context context, DistrictSearchQuery districtSearchQuery) {
        super(context, districtSearchQuery);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.f, com.amap.api.col.s.e
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public DistrictResult a(String str) throws AMapException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        DistrictResult districtResult = new DistrictResult((DistrictSearchQuery) ((e) this).f7860b, arrayList);
        try {
            JSONObject jSONObject = new JSONObject(str);
            districtResult.setPageCount(jSONObject.optInt("count"));
            optJSONArray = jSONObject.optJSONArray("districts");
        } catch (JSONException e2) {
            n.a(e2, "DistrictServerHandler", "paseJSONJSONException");
        } catch (Exception e10) {
            n.a(e10, "DistrictServerHandler", "paseJSONException");
        }
        if (optJSONArray == null) {
            return districtResult;
        }
        v.a(optJSONArray, arrayList, null);
        return districtResult;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.f, com.amap.api.col.s.e
    public final String a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        stringBuffer.append("&page=");
        stringBuffer.append(((DistrictSearchQuery) ((e) this).f7860b).getPageNum());
        stringBuffer.append("&offset=");
        stringBuffer.append(((DistrictSearchQuery) ((e) this).f7860b).getPageSize());
        if (((DistrictSearchQuery) ((e) this).f7860b).isShowBoundary()) {
            stringBuffer.append("&extensions=all");
        } else {
            stringBuffer.append("&extensions=base");
        }
        if (((DistrictSearchQuery) ((e) this).f7860b).checkKeyWords()) {
            String b4 = f.b(((DistrictSearchQuery) ((e) this).f7860b).getKeywords());
            stringBuffer.append("&keywords=");
            stringBuffer.append(b4);
        }
        stringBuffer.append("&key=" + bw.f(((e) this).f7863e));
        stringBuffer.append("&subdistrict=" + String.valueOf(((DistrictSearchQuery) ((e) this).f7860b).getSubDistrict()));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String b() {
        return m.a() + "/config/district?";
    }
}
