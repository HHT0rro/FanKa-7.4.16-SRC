package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.s.am;
import com.amap.api.col.s.ao;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ReverseGeocodingHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class aq extends f<RegeocodeQuery, RegeocodeAddress> {
    public aq(Context context, RegeocodeQuery regeocodeQuery) {
        super(context, regeocodeQuery);
    }

    private static RegeocodeAddress c(String str) throws AMapException {
        JSONObject optJSONObject;
        RegeocodeAddress regeocodeAddress = new RegeocodeAddress();
        try {
            optJSONObject = new JSONObject(str).optJSONObject("regeocode");
        } catch (JSONException e2) {
            n.a(e2, "ReverseGeocodingHandler", "paseJSON");
        }
        if (optJSONObject == null) {
            return regeocodeAddress;
        }
        regeocodeAddress.setFormatAddress(v.a(optJSONObject, "formatted_address"));
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("addressComponent");
        if (optJSONObject2 != null) {
            v.a(optJSONObject2, regeocodeAddress);
        }
        regeocodeAddress.setPois(v.c(optJSONObject));
        JSONArray optJSONArray = optJSONObject.optJSONArray("roads");
        if (optJSONArray != null) {
            v.b(optJSONArray, regeocodeAddress);
        }
        JSONArray optJSONArray2 = optJSONObject.optJSONArray("roadinters");
        if (optJSONArray2 != null) {
            v.a(optJSONArray2, regeocodeAddress);
        }
        JSONArray optJSONArray3 = optJSONObject.optJSONArray("aois");
        if (optJSONArray3 != null) {
            v.c(optJSONArray3, regeocodeAddress);
        }
        return regeocodeAddress;
    }

    private static ao j() {
        an a10 = am.a().a("regeo");
        if (a10 == null) {
            return null;
        }
        return (ao) a10;
    }

    @Override // com.amap.api.col.s.f, com.amap.api.col.s.e
    public final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    @Override // com.amap.api.col.s.f, com.amap.api.col.s.e
    public final String a_() {
        return a(true);
    }

    @Override // com.amap.api.col.s.dz
    public final String b() {
        return m.a() + "/geocode/regeo?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.e
    public final am.b e() {
        ao j10 = j();
        double a10 = j10 != null ? j10.a() : ShadowDrawableWrapper.COS_45;
        am.b bVar = new am.b();
        bVar.f7098a = b() + a(false) + "language=" + ServiceSettings.getInstance().getLanguage();
        T t2 = ((e) this).f7860b;
        if (t2 != 0 && ((RegeocodeQuery) t2).getPoint() != null) {
            bVar.f7099b = new ao.a(((RegeocodeQuery) ((e) this).f7860b).getPoint().getLatitude(), ((RegeocodeQuery) ((e) this).f7860b).getPoint().getLongitude(), a10);
        }
        return bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String a(boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("output=json&location=");
        if (z10) {
            sb2.append(n.a(((RegeocodeQuery) ((e) this).f7860b).getPoint().getLongitude()));
            sb2.append(",");
            sb2.append(n.a(((RegeocodeQuery) ((e) this).f7860b).getPoint().getLatitude()));
        }
        if (!TextUtils.isEmpty(((RegeocodeQuery) ((e) this).f7860b).getPoiType())) {
            sb2.append("&poitype=");
            sb2.append(((RegeocodeQuery) ((e) this).f7860b).getPoiType());
        }
        if (!TextUtils.isEmpty(((RegeocodeQuery) ((e) this).f7860b).getMode())) {
            sb2.append("&mode=");
            sb2.append(((RegeocodeQuery) ((e) this).f7860b).getMode());
        }
        if (!TextUtils.isEmpty(((RegeocodeQuery) ((e) this).f7860b).getExtensions())) {
            sb2.append("&extensions=");
            sb2.append(((RegeocodeQuery) ((e) this).f7860b).getExtensions());
        } else {
            sb2.append("&extensions=base");
        }
        sb2.append("&radius=");
        sb2.append((int) ((RegeocodeQuery) ((e) this).f7860b).getRadius());
        sb2.append("&coordsys=");
        sb2.append(((RegeocodeQuery) ((e) this).f7860b).getLatLonType());
        sb2.append("&key=");
        sb2.append(bw.f(((e) this).f7863e));
        return sb2.toString();
    }
}
