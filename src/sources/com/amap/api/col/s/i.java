package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.busline.BusLineQuery;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusStationQuery;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.SuggestionCity;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: BusSearchServerHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class i<T> extends f<T, Object> {

    /* renamed from: g, reason: collision with root package name */
    private int f7969g;

    /* renamed from: h, reason: collision with root package name */
    private List<String> f7970h;

    /* renamed from: i, reason: collision with root package name */
    private List<SuggestionCity> f7971i;

    public i(Context context, T t2) {
        super(context, t2);
        this.f7969g = 0;
        this.f7970h = new ArrayList();
        this.f7971i = new ArrayList();
    }

    @Override // com.amap.api.col.s.f, com.amap.api.col.s.e
    public final Object a(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("suggestion");
            if (optJSONObject != null) {
                this.f7971i = v.a(optJSONObject);
                this.f7970h = v.b(optJSONObject);
            }
            this.f7969g = jSONObject.optInt("count");
            if (((e) this).f7860b instanceof BusLineQuery) {
                return BusLineResult.createPagedResult((BusLineQuery) ((e) this).f7860b, this.f7969g, this.f7971i, this.f7970h, v.h(jSONObject));
            }
            return BusStationResult.createPagedResult((BusStationQuery) ((e) this).f7860b, this.f7969g, this.f7971i, this.f7970h, v.g(jSONObject));
        } catch (Exception e2) {
            n.a(e2, "BusSearchServerHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.col.s.f, com.amap.api.col.s.e
    public final String a_() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("output=json");
        T t2 = ((e) this).f7860b;
        if (t2 instanceof BusLineQuery) {
            BusLineQuery busLineQuery = (BusLineQuery) t2;
            if (!TextUtils.isEmpty(busLineQuery.getExtensions())) {
                sb2.append("&extensions=");
                sb2.append(busLineQuery.getExtensions());
            } else {
                sb2.append("&extensions=base");
            }
            if (busLineQuery.getCategory() == BusLineQuery.SearchType.BY_LINE_ID) {
                sb2.append("&id=");
                sb2.append(f.b(((BusLineQuery) ((e) this).f7860b).getQueryString()));
            } else {
                String city = busLineQuery.getCity();
                if (!v.i(city)) {
                    String b4 = f.b(city);
                    sb2.append("&city=");
                    sb2.append(b4);
                }
                sb2.append("&keywords=" + f.b(busLineQuery.getQueryString()));
                sb2.append("&offset=" + busLineQuery.getPageSize());
                sb2.append("&page=" + busLineQuery.getPageNumber());
            }
        } else {
            BusStationQuery busStationQuery = (BusStationQuery) t2;
            String city2 = busStationQuery.getCity();
            if (!v.i(city2)) {
                String b10 = f.b(city2);
                sb2.append("&city=");
                sb2.append(b10);
            }
            sb2.append("&keywords=" + f.b(busStationQuery.getQueryString()));
            sb2.append("&offset=" + busStationQuery.getPageSize());
            sb2.append("&page=" + busStationQuery.getPageNumber());
        }
        sb2.append("&key=" + bw.f(((e) this).f7863e));
        return sb2.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String b() {
        String str;
        T t2 = ((e) this).f7860b;
        if (!(t2 instanceof BusLineQuery)) {
            str = "stopname";
        } else if (((BusLineQuery) t2).getCategory() == BusLineQuery.SearchType.BY_LINE_ID) {
            str = "lineid";
        } else {
            str = ((BusLineQuery) ((e) this).f7860b).getCategory() == BusLineQuery.SearchType.BY_LINE_NAME ? "linename" : "";
        }
        return m.a() + "/bus/" + str + SymbolValues.QUESTION_EN_SYMBOL;
    }
}
