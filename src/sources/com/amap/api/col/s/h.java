package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.BusRouteResultV2;
import com.amap.api.services.route.RouteSearchV2;

/* compiled from: BusRouteSearchHandlerV2.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class h extends f<RouteSearchV2.BusRouteQuery, BusRouteResultV2> {
    public h(Context context, RouteSearchV2.BusRouteQuery busRouteQuery) {
        super(context, busRouteQuery);
    }

    private static BusRouteResultV2 c(String str) throws AMapException {
        return v.b(str);
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
        stringBuffer.append(n.a(((RouteSearchV2.BusRouteQuery) ((e) this).f7860b).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(n.a(((RouteSearchV2.BusRouteQuery) ((e) this).f7860b).getFromAndTo().getTo()));
        String city = ((RouteSearchV2.BusRouteQuery) ((e) this).f7860b).getCity();
        if (!v.i(city)) {
            city = f.b(city);
            stringBuffer.append("&city1=");
            stringBuffer.append(city);
        }
        if (!v.i(((RouteSearchV2.BusRouteQuery) ((e) this).f7860b).getCity())) {
            String b4 = f.b(city);
            stringBuffer.append("&city2=");
            stringBuffer.append(b4);
        }
        stringBuffer.append("&strategy=");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((RouteSearchV2.BusRouteQuery) ((e) this).f7860b).getMode());
        stringBuffer.append(sb2.toString());
        stringBuffer.append("&nightflag=");
        stringBuffer.append(((RouteSearchV2.BusRouteQuery) ((e) this).f7860b).getNightFlag());
        stringBuffer.append("&show_fields=");
        stringBuffer.append(n.a(((RouteSearchV2.BusRouteQuery) ((e) this).f7860b).getShowFields()));
        String originPoiId = ((RouteSearchV2.BusRouteQuery) ((e) this).f7860b).getOriginPoiId();
        if (!TextUtils.isEmpty(originPoiId)) {
            stringBuffer.append("&originpoi=");
            stringBuffer.append(originPoiId);
        }
        String destinationPoiId = ((RouteSearchV2.BusRouteQuery) ((e) this).f7860b).getDestinationPoiId();
        if (!TextUtils.isEmpty(destinationPoiId)) {
            stringBuffer.append("&destinationpoi=");
            stringBuffer.append(destinationPoiId);
        }
        String ad1 = ((RouteSearchV2.BusRouteQuery) ((e) this).f7860b).getAd1();
        if (!TextUtils.isEmpty(ad1)) {
            stringBuffer.append("&ad1=");
            stringBuffer.append(ad1);
        }
        String ad2 = ((RouteSearchV2.BusRouteQuery) ((e) this).f7860b).getAd2();
        if (!TextUtils.isEmpty(ad2)) {
            stringBuffer.append("&ad2=");
            stringBuffer.append(ad2);
        }
        String date = ((RouteSearchV2.BusRouteQuery) ((e) this).f7860b).getDate();
        if (!TextUtils.isEmpty(date)) {
            stringBuffer.append("&date=");
            stringBuffer.append(date);
        }
        String time = ((RouteSearchV2.BusRouteQuery) ((e) this).f7860b).getTime();
        if (!TextUtils.isEmpty(time)) {
            stringBuffer.append("&time=");
            stringBuffer.append(time);
        }
        stringBuffer.append("&AlternativeRoute=");
        stringBuffer.append(((RouteSearchV2.BusRouteQuery) ((e) this).f7860b).getAlternativeRoute());
        stringBuffer.append("&multiexport=");
        stringBuffer.append(((RouteSearchV2.BusRouteQuery) ((e) this).f7860b).getMultiExport());
        stringBuffer.append("&max_trans=");
        stringBuffer.append(((RouteSearchV2.BusRouteQuery) ((e) this).f7860b).getMaxTrans());
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String b() {
        return m.c() + "/direction/transit/integrated?";
    }
}
