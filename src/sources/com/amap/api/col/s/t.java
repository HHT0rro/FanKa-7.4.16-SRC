package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.col.s.am;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: GeocodingHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class t extends f<GeocodeQuery, ArrayList<GeocodeAddress>> {
    public t(Context context, GeocodeQuery geocodeQuery) {
        super(context, geocodeQuery);
    }

    private static ArrayList<GeocodeAddress> c(String str) throws AMapException {
        ArrayList<GeocodeAddress> arrayList = new ArrayList<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            return (jSONObject.has("count") && jSONObject.getInt("count") > 0) ? v.i(jSONObject) : arrayList;
        } catch (JSONException e2) {
            n.a(e2, "GeocodingHandler", "paseJSONJSONException");
            return arrayList;
        } catch (Exception e10) {
            n.a(e10, "GeocodingHandler", "paseJSONException");
            return arrayList;
        }
    }

    @Override // com.amap.api.col.s.f, com.amap.api.col.s.e
    public final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.f, com.amap.api.col.s.e
    public final String a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json&address=");
        stringBuffer.append(f.b(((GeocodeQuery) ((e) this).f7860b).getLocationName()));
        String city = ((GeocodeQuery) ((e) this).f7860b).getCity();
        if (!v.i(city)) {
            String b4 = f.b(city);
            stringBuffer.append("&city=");
            stringBuffer.append(b4);
        }
        if (!v.i(((GeocodeQuery) ((e) this).f7860b).getCountry())) {
            stringBuffer.append("&country=");
            stringBuffer.append(f.b(((GeocodeQuery) ((e) this).f7860b).getCountry()));
        }
        stringBuffer.append("&key=" + bw.f(((e) this).f7863e));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String b() {
        return m.a() + "/geocode/geo?";
    }

    @Override // com.amap.api.col.s.e
    public final am.b e() {
        am.b bVar = new am.b();
        bVar.f7098a = b() + a_() + "language=" + ServiceSettings.getInstance().getLanguage();
        return bVar;
    }
}
