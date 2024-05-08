package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.RouteSearch;

/* compiled from: BusRouteSearchHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class g extends f<RouteSearch.BusRouteQuery, BusRouteResult> {
    public g(Context context, RouteSearch.BusRouteQuery busRouteQuery) {
        super(context, busRouteQuery);
    }

    private static BusRouteResult c(String str) throws AMapException {
        return v.a(str);
    }

    @Override // com.amap.api.col.s.f, com.amap.api.col.s.e
    public final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.f, com.amap.api.col.s.e
    public final String a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(bw.f(((e) this).f7863e));
        stringBuffer.append("&origin=");
        stringBuffer.append(n.a(((RouteSearch.BusRouteQuery) ((e) this).f7860b).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(n.a(((RouteSearch.BusRouteQuery) ((e) this).f7860b).getFromAndTo().getTo()));
        String city = ((RouteSearch.BusRouteQuery) ((e) this).f7860b).getCity();
        if (!v.i(city)) {
            city = f.b(city);
            stringBuffer.append("&city=");
            stringBuffer.append(city);
        }
        if (!v.i(((RouteSearch.BusRouteQuery) ((e) this).f7860b).getCity())) {
            String b4 = f.b(city);
            stringBuffer.append("&cityd=");
            stringBuffer.append(b4);
        }
        stringBuffer.append("&strategy=");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((RouteSearch.BusRouteQuery) ((e) this).f7860b).getMode());
        stringBuffer.append(sb2.toString());
        stringBuffer.append("&nightflag=");
        stringBuffer.append(((RouteSearch.BusRouteQuery) ((e) this).f7860b).getNightFlag());
        if (!TextUtils.isEmpty(((RouteSearch.BusRouteQuery) ((e) this).f7860b).getExtensions())) {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((RouteSearch.BusRouteQuery) ((e) this).f7860b).getExtensions());
        } else {
            stringBuffer.append("&extensions=base");
        }
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String b() {
        return m.a() + "/direction/transit/integrated?";
    }
}
