package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.TruckRouteRestult;

/* compiled from: TruckRouteSearchHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ay extends f<RouteSearch.TruckRouteQuery, TruckRouteRestult> {

    /* renamed from: g, reason: collision with root package name */
    private final String f7138g;

    /* renamed from: h, reason: collision with root package name */
    private final String f7139h;

    /* renamed from: i, reason: collision with root package name */
    private final String f7140i;

    public ay(Context context, RouteSearch.TruckRouteQuery truckRouteQuery) {
        super(context, truckRouteQuery);
        this.f7138g = "/direction/truck?";
        this.f7139h = "|";
        this.f7140i = ",";
    }

    private static TruckRouteRestult c(String str) throws AMapException {
        return v.m(str);
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
        if (((RouteSearch.TruckRouteQuery) ((e) this).f7860b).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(n.a(((RouteSearch.TruckRouteQuery) ((e) this).f7860b).getFromAndTo().getFrom()));
            if (!v.i(((RouteSearch.TruckRouteQuery) ((e) this).f7860b).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&originid=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) ((e) this).f7860b).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(n.a(((RouteSearch.TruckRouteQuery) ((e) this).f7860b).getFromAndTo().getTo()));
            if (!v.i(((RouteSearch.TruckRouteQuery) ((e) this).f7860b).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destinationid=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) ((e) this).f7860b).getFromAndTo().getDestinationPoiID());
            }
            if (!v.i(((RouteSearch.TruckRouteQuery) ((e) this).f7860b).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origintype=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) ((e) this).f7860b).getFromAndTo().getOriginType());
            }
            if (!v.i(((RouteSearch.TruckRouteQuery) ((e) this).f7860b).getFromAndTo().getDestinationType())) {
                stringBuffer.append("&destinationtype=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) ((e) this).f7860b).getFromAndTo().getDestinationType());
            }
            if (!v.i(((RouteSearch.TruckRouteQuery) ((e) this).f7860b).getFromAndTo().getPlateProvince())) {
                stringBuffer.append("&province=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) ((e) this).f7860b).getFromAndTo().getPlateProvince());
            }
            if (!v.i(((RouteSearch.TruckRouteQuery) ((e) this).f7860b).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&number=");
                stringBuffer.append(((RouteSearch.TruckRouteQuery) ((e) this).f7860b).getFromAndTo().getPlateNumber());
            }
        }
        stringBuffer.append("&strategy=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) ((e) this).f7860b).getMode());
        if (((RouteSearch.TruckRouteQuery) ((e) this).f7860b).hasPassPoint()) {
            stringBuffer.append("&waypoints=");
            stringBuffer.append(((RouteSearch.TruckRouteQuery) ((e) this).f7860b).getPassedPointStr());
        }
        stringBuffer.append("&size=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) ((e) this).f7860b).getTruckSize());
        stringBuffer.append("&height=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) ((e) this).f7860b).getTruckHeight());
        stringBuffer.append("&width=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) ((e) this).f7860b).getTruckWidth());
        stringBuffer.append("&load=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) ((e) this).f7860b).getTruckLoad());
        stringBuffer.append("&weight=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) ((e) this).f7860b).getTruckWeight());
        stringBuffer.append("&axis=");
        stringBuffer.append(((RouteSearch.TruckRouteQuery) ((e) this).f7860b).getTruckAxis());
        if (!TextUtils.isEmpty(((RouteSearch.TruckRouteQuery) ((e) this).f7860b).getExtensions())) {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((RouteSearch.TruckRouteQuery) ((e) this).f7860b).getExtensions());
        } else {
            stringBuffer.append("&extensions=base");
        }
        stringBuffer.append("&output=json");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String b() {
        return m.b() + "/direction/truck?";
    }
}
