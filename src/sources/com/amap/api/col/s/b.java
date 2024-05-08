package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.auto.AutoTChargeStationResult;
import com.amap.api.services.auto.AutoTSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: AutoTPoiSearchHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class b extends f<AutoTSearch.Query, AutoTChargeStationResult> {

    /* renamed from: g, reason: collision with root package name */
    private a f7141g;

    public b(Context context, AutoTSearch.Query query) {
        super(context, query);
        this.f7141g = null;
        this.f7141g = new a(context);
    }

    private static AutoTChargeStationResult c(String str) throws AMapException {
        try {
            return c.a(new JSONObject(str));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.col.s.f, com.amap.api.col.s.e
    public final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.f, com.amap.api.col.s.e
    public final String a_() {
        StringBuilder sb2 = new StringBuilder(this.f7141g.a());
        sb2.append("&adcode=");
        sb2.append(((AutoTSearch.Query) ((e) this).f7860b).getAdCode());
        sb2.append("&city=");
        sb2.append(((AutoTSearch.Query) ((e) this).f7860b).getCity());
        sb2.append("&data_type=");
        sb2.append(((AutoTSearch.Query) ((e) this).f7860b).getDataType());
        sb2.append("&geoobj=");
        sb2.append(((AutoTSearch.Query) ((e) this).f7860b).getGeoObj());
        sb2.append("&keywords=");
        sb2.append(((AutoTSearch.Query) ((e) this).f7860b).getKeywords());
        sb2.append("&pagenum=");
        sb2.append(((AutoTSearch.Query) ((e) this).f7860b).getPageNum());
        sb2.append("&pagesize=");
        sb2.append(((AutoTSearch.Query) ((e) this).f7860b).getPageSize());
        sb2.append("&qii=");
        sb2.append(((AutoTSearch.Query) ((e) this).f7860b).isQii());
        sb2.append("&query_type=");
        sb2.append(((AutoTSearch.Query) ((e) this).f7860b).getQueryType());
        sb2.append("&range=");
        sb2.append(((AutoTSearch.Query) ((e) this).f7860b).getRange());
        LatLonPoint latLonPoint = ((AutoTSearch.Query) ((e) this).f7860b).getLatLonPoint();
        if (latLonPoint != null) {
            sb2.append("&longitude=");
            sb2.append(latLonPoint.getLongitude());
            sb2.append("&latitude=");
            sb2.append(latLonPoint.getLatitude());
        }
        sb2.append("&user_loc=");
        sb2.append(((AutoTSearch.Query) ((e) this).f7860b).getUserLoc());
        sb2.append("&user_city=");
        sb2.append(((AutoTSearch.Query) ((e) this).f7860b).getUserCity());
        AutoTSearch.FilterBox filterBox = ((AutoTSearch.Query) ((e) this).f7860b).getFilterBox();
        if (filterBox != null) {
            sb2.append("&retain_state=");
            sb2.append(filterBox.getRetainState());
            sb2.append("&checked_level=");
            sb2.append(filterBox.getCheckedLevel());
            sb2.append("&classify_v2_data=");
            sb2.append(filterBox.getClassifyV2Data());
            sb2.append("&classify_v2_level2_data=");
            sb2.append(filterBox.getClassifyV2Level2Data());
            sb2.append("&classify_v2_level3_data=");
            sb2.append(filterBox.getClassifyV2Level3Data());
        }
        return sb2.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.dz
    public final String b() {
        try {
            String a10 = d.a(new HashMap(), ((AutoTSearch.Query) ((e) this).f7860b).getAccessKey());
            return m.f() + "/ws/mapapi/poi/infolite/auto?" + a10 + "&Signature=" + d.a("POST", a10, ((AutoTSearch.Query) ((e) this).f7860b).getSecretKey());
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
