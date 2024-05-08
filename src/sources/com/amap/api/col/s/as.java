package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RideRouteResultV2;
import com.amap.api.services.route.RouteSearchV2;

/* compiled from: RideRouteSearchHandlerV2.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class as extends f<RouteSearchV2.RideRouteQuery, RideRouteResultV2> {
    public as(Context context, RouteSearchV2.RideRouteQuery rideRouteQuery) {
        super(context, rideRouteQuery);
    }

    private static RideRouteResultV2 c(String str) throws AMapException {
        return v.k(str);
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
        stringBuffer.append(n.a(((RouteSearchV2.RideRouteQuery) ((e) this).f7860b).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(n.a(((RouteSearchV2.RideRouteQuery) ((e) this).f7860b).getFromAndTo().getTo()));
        stringBuffer.append("&alternative_route=");
        stringBuffer.append(((RouteSearchV2.RideRouteQuery) ((e) this).f7860b).getAlternativeRoute());
        stringBuffer.append("&output=json");
        stringBuffer.append("&show_fields=");
        stringBuffer.append(n.a(((RouteSearchV2.RideRouteQuery) ((e) this).f7860b).getShowFields()));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String b() {
        return m.c() + "/direction/bicycling?";
    }
}
