package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RouteSearch;

/* compiled from: DriveRouteSearchHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class r extends f<RouteSearch.DriveRouteQuery, DriveRouteResult> {
    public r(Context context, RouteSearch.DriveRouteQuery driveRouteQuery) {
        super(context, driveRouteQuery);
    }

    private static DriveRouteResult c(String str) throws AMapException {
        return v.c(str);
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
        if (((RouteSearch.DriveRouteQuery) ((e) this).f7860b).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(n.a(((RouteSearch.DriveRouteQuery) ((e) this).f7860b).getFromAndTo().getFrom()));
            if (!v.i(((RouteSearch.DriveRouteQuery) ((e) this).f7860b).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&originid=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) ((e) this).f7860b).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(n.a(((RouteSearch.DriveRouteQuery) ((e) this).f7860b).getFromAndTo().getTo()));
            if (!v.i(((RouteSearch.DriveRouteQuery) ((e) this).f7860b).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destinationid=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) ((e) this).f7860b).getFromAndTo().getDestinationPoiID());
            }
            if (!v.i(((RouteSearch.DriveRouteQuery) ((e) this).f7860b).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origintype=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) ((e) this).f7860b).getFromAndTo().getOriginType());
            }
            if (!v.i(((RouteSearch.DriveRouteQuery) ((e) this).f7860b).getFromAndTo().getDestinationType())) {
                stringBuffer.append("&destinationtype=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) ((e) this).f7860b).getFromAndTo().getDestinationType());
            }
            if (!v.i(((RouteSearch.DriveRouteQuery) ((e) this).f7860b).getFromAndTo().getPlateProvince())) {
                stringBuffer.append("&province=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) ((e) this).f7860b).getFromAndTo().getPlateProvince());
            }
            if (!v.i(((RouteSearch.DriveRouteQuery) ((e) this).f7860b).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&number=");
                stringBuffer.append(((RouteSearch.DriveRouteQuery) ((e) this).f7860b).getFromAndTo().getPlateNumber());
            }
        }
        stringBuffer.append("&strategy=");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((RouteSearch.DriveRouteQuery) ((e) this).f7860b).getMode());
        stringBuffer.append(sb2.toString());
        if (!TextUtils.isEmpty(((RouteSearch.DriveRouteQuery) ((e) this).f7860b).getExtensions())) {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) ((e) this).f7860b).getExtensions());
        } else {
            stringBuffer.append("&extensions=base");
        }
        stringBuffer.append("&ferry=");
        stringBuffer.append(!((RouteSearch.DriveRouteQuery) ((e) this).f7860b).isUseFerry() ? 1 : 0);
        stringBuffer.append("&cartype=");
        StringBuilder sb3 = new StringBuilder();
        sb3.append(((RouteSearch.DriveRouteQuery) ((e) this).f7860b).getCarType());
        stringBuffer.append(sb3.toString());
        if (((RouteSearch.DriveRouteQuery) ((e) this).f7860b).hasPassPoint()) {
            stringBuffer.append("&waypoints=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) ((e) this).f7860b).getPassedPointStr());
        }
        if (((RouteSearch.DriveRouteQuery) ((e) this).f7860b).hasAvoidpolygons()) {
            stringBuffer.append("&avoidpolygons=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) ((e) this).f7860b).getAvoidpolygonsStr());
        }
        if (((RouteSearch.DriveRouteQuery) ((e) this).f7860b).hasAvoidRoad()) {
            stringBuffer.append("&avoidroad=");
            stringBuffer.append(f.b(((RouteSearch.DriveRouteQuery) ((e) this).f7860b).getAvoidRoad()));
        }
        stringBuffer.append("&output=json");
        stringBuffer.append("&geometry=false");
        if (((RouteSearch.DriveRouteQuery) ((e) this).f7860b).getExclude() != null) {
            stringBuffer.append("&exclude=");
            stringBuffer.append(((RouteSearch.DriveRouteQuery) ((e) this).f7860b).getExclude());
        }
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String b() {
        return m.a() + "/direction/driving?";
    }
}
