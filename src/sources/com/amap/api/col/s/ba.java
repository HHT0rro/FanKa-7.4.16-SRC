package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.RouteSearchV2;
import com.amap.api.services.route.WalkRouteResultV2;

/* compiled from: WalkRouteSearchHandlerV2.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ba extends f<RouteSearchV2.WalkRouteQuery, WalkRouteResultV2> {
    public ba(Context context, RouteSearchV2.WalkRouteQuery walkRouteQuery) {
        super(context, walkRouteQuery);
    }

    private static WalkRouteResultV2 c(String str) throws AMapException {
        return v.f(str);
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
        stringBuffer.append(n.a(((RouteSearchV2.WalkRouteQuery) ((e) this).f7860b).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=");
        stringBuffer.append(n.a(((RouteSearchV2.WalkRouteQuery) ((e) this).f7860b).getFromAndTo().getTo()));
        stringBuffer.append("&output=json");
        stringBuffer.append("&isindoor=");
        stringBuffer.append(((RouteSearchV2.WalkRouteQuery) ((e) this).f7860b).isIndoor() ? 1 : 0);
        stringBuffer.append("&alternative_route=");
        stringBuffer.append(((RouteSearchV2.WalkRouteQuery) ((e) this).f7860b).getAlternativeRoute());
        stringBuffer.append("&show_fields=");
        stringBuffer.append(n.a(((RouteSearchV2.WalkRouteQuery) ((e) this).f7860b).getShowFields()));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String b() {
        return m.c() + "/direction/walking?";
    }
}
