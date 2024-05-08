package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.DriveRouteResultV2;
import com.amap.api.services.route.RouteSearchV2;

/* compiled from: DriveRouteSearchHandlerV2.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class s extends f<RouteSearchV2.DriveRouteQuery, DriveRouteResultV2> {
    public s(Context context, RouteSearchV2.DriveRouteQuery driveRouteQuery) {
        super(context, driveRouteQuery);
    }

    private static DriveRouteResultV2 c(String str) throws AMapException {
        return v.d(str);
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
        if (((RouteSearchV2.DriveRouteQuery) ((e) this).f7860b).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(n.a(((RouteSearchV2.DriveRouteQuery) ((e) this).f7860b).getFromAndTo().getFrom()));
            if (!v.i(((RouteSearchV2.DriveRouteQuery) ((e) this).f7860b).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&origin_id=");
                stringBuffer.append(((RouteSearchV2.DriveRouteQuery) ((e) this).f7860b).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(n.a(((RouteSearchV2.DriveRouteQuery) ((e) this).f7860b).getFromAndTo().getTo()));
            if (!v.i(((RouteSearchV2.DriveRouteQuery) ((e) this).f7860b).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destination_id=");
                stringBuffer.append(((RouteSearchV2.DriveRouteQuery) ((e) this).f7860b).getFromAndTo().getDestinationPoiID());
            }
            if (!v.i(((RouteSearchV2.DriveRouteQuery) ((e) this).f7860b).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origin_type=");
                stringBuffer.append(((RouteSearchV2.DriveRouteQuery) ((e) this).f7860b).getFromAndTo().getOriginType());
            }
            if (!v.i(((RouteSearchV2.DriveRouteQuery) ((e) this).f7860b).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&plate=");
                stringBuffer.append(((RouteSearchV2.DriveRouteQuery) ((e) this).f7860b).getFromAndTo().getPlateNumber());
            }
        }
        stringBuffer.append("&strategy=");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((RouteSearchV2.DriveRouteQuery) ((e) this).f7860b).getMode().getValue());
        stringBuffer.append(sb2.toString());
        int showFields = ((RouteSearchV2.DriveRouteQuery) ((e) this).f7860b).getShowFields();
        stringBuffer.append("&show_fields=");
        stringBuffer.append(n.a(showFields));
        RouteSearchV2.NewEnergy newEnergy = ((RouteSearchV2.DriveRouteQuery) ((e) this).f7860b).getNewEnergy();
        if (newEnergy != null) {
            stringBuffer.append(newEnergy.buildParam());
            stringBuffer.append("&force_new_version=true");
        }
        stringBuffer.append("&ferry=");
        stringBuffer.append(!((RouteSearchV2.DriveRouteQuery) ((e) this).f7860b).isUseFerry() ? 1 : 0);
        stringBuffer.append("&cartype=");
        StringBuilder sb3 = new StringBuilder();
        sb3.append(((RouteSearchV2.DriveRouteQuery) ((e) this).f7860b).getCarType());
        stringBuffer.append(sb3.toString());
        if (((RouteSearchV2.DriveRouteQuery) ((e) this).f7860b).hasPassPoint()) {
            stringBuffer.append("&waypoints=");
            stringBuffer.append(((RouteSearchV2.DriveRouteQuery) ((e) this).f7860b).getPassedPointStr());
        }
        if (((RouteSearchV2.DriveRouteQuery) ((e) this).f7860b).hasAvoidpolygons()) {
            stringBuffer.append("&avoidpolygons=");
            stringBuffer.append(((RouteSearchV2.DriveRouteQuery) ((e) this).f7860b).getAvoidpolygonsStr());
        }
        if (((RouteSearchV2.DriveRouteQuery) ((e) this).f7860b).hasAvoidRoad()) {
            stringBuffer.append("&avoidroad=");
            stringBuffer.append(f.b(((RouteSearchV2.DriveRouteQuery) ((e) this).f7860b).getAvoidRoad()));
        }
        stringBuffer.append("&output=json");
        stringBuffer.append("&geometry=false");
        if (((RouteSearchV2.DriveRouteQuery) ((e) this).f7860b).getExclude() != null) {
            stringBuffer.append("&exclude=");
            stringBuffer.append(((RouteSearchV2.DriveRouteQuery) ((e) this).f7860b).getExclude());
        }
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String b() {
        return m.c() + "/direction/driving?";
    }
}
