package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.DriveRoutePlanResult;
import com.amap.api.services.route.RouteSearch;

/* compiled from: DrivePlanSearchHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class q extends f<RouteSearch.DrivePlanQuery, DriveRoutePlanResult> {
    public q(Context context, RouteSearch.DrivePlanQuery drivePlanQuery) {
        super(context, drivePlanQuery);
    }

    private static DriveRoutePlanResult c(String str) throws AMapException {
        return v.n(str);
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
        if (((RouteSearch.DrivePlanQuery) ((e) this).f7860b).getFromAndTo() != null) {
            stringBuffer.append("&origin=");
            stringBuffer.append(n.a(((RouteSearch.DrivePlanQuery) ((e) this).f7860b).getFromAndTo().getFrom()));
            if (!v.i(((RouteSearch.DrivePlanQuery) ((e) this).f7860b).getFromAndTo().getStartPoiID())) {
                stringBuffer.append("&originid=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) ((e) this).f7860b).getFromAndTo().getStartPoiID());
            }
            stringBuffer.append("&destination=");
            stringBuffer.append(n.a(((RouteSearch.DrivePlanQuery) ((e) this).f7860b).getFromAndTo().getTo()));
            if (!v.i(((RouteSearch.DrivePlanQuery) ((e) this).f7860b).getFromAndTo().getDestinationPoiID())) {
                stringBuffer.append("&destinationid=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) ((e) this).f7860b).getFromAndTo().getDestinationPoiID());
            }
            if (!v.i(((RouteSearch.DrivePlanQuery) ((e) this).f7860b).getFromAndTo().getOriginType())) {
                stringBuffer.append("&origintype=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) ((e) this).f7860b).getFromAndTo().getOriginType());
            }
            if (!v.i(((RouteSearch.DrivePlanQuery) ((e) this).f7860b).getFromAndTo().getDestinationType())) {
                stringBuffer.append("&destinationtype=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) ((e) this).f7860b).getFromAndTo().getDestinationType());
            }
            if (!v.i(((RouteSearch.DrivePlanQuery) ((e) this).f7860b).getFromAndTo().getPlateProvince())) {
                stringBuffer.append("&province=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) ((e) this).f7860b).getFromAndTo().getPlateProvince());
            }
            if (!v.i(((RouteSearch.DrivePlanQuery) ((e) this).f7860b).getFromAndTo().getPlateNumber())) {
                stringBuffer.append("&number=");
                stringBuffer.append(((RouteSearch.DrivePlanQuery) ((e) this).f7860b).getFromAndTo().getPlateNumber());
            }
        }
        if (((RouteSearch.DrivePlanQuery) ((e) this).f7860b).getDestParentPoiID() != null) {
            stringBuffer.append("&parentid=");
            stringBuffer.append(((RouteSearch.DrivePlanQuery) ((e) this).f7860b).getDestParentPoiID());
        }
        stringBuffer.append("&strategy=");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((RouteSearch.DrivePlanQuery) ((e) this).f7860b).getMode());
        stringBuffer.append(sb2.toString());
        stringBuffer.append("&cartype=");
        StringBuilder sb3 = new StringBuilder();
        sb3.append(((RouteSearch.DrivePlanQuery) ((e) this).f7860b).getCarType());
        stringBuffer.append(sb3.toString());
        stringBuffer.append("&firsttime=");
        StringBuilder sb4 = new StringBuilder();
        sb4.append(((RouteSearch.DrivePlanQuery) ((e) this).f7860b).getFirstTime());
        stringBuffer.append(sb4.toString());
        stringBuffer.append("&interval=");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(((RouteSearch.DrivePlanQuery) ((e) this).f7860b).getInterval());
        stringBuffer.append(sb5.toString());
        stringBuffer.append("&count=");
        StringBuilder sb6 = new StringBuilder();
        sb6.append(((RouteSearch.DrivePlanQuery) ((e) this).f7860b).getCount());
        stringBuffer.append(sb6.toString());
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String b() {
        return m.b() + "/etd/driving?";
    }
}
