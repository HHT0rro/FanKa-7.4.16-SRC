package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.DistanceSearch;
import java.util.List;

/* compiled from: DistanceSearchHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class o extends f<DistanceSearch.DistanceQuery, DistanceResult> {

    /* renamed from: g, reason: collision with root package name */
    private final String f7974g;

    /* renamed from: h, reason: collision with root package name */
    private final String f7975h;

    /* renamed from: i, reason: collision with root package name */
    private final String f7976i;

    public o(Context context, DistanceSearch.DistanceQuery distanceQuery) {
        super(context, distanceQuery);
        this.f7974g = "/distance?";
        this.f7975h = "|";
        this.f7976i = ",";
    }

    private static DistanceResult c(String str) throws AMapException {
        return v.l(str);
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
        List<LatLonPoint> origins = ((DistanceSearch.DistanceQuery) ((e) this).f7860b).getOrigins();
        if (origins != null && origins.size() > 0) {
            stringBuffer.append("&origins=");
            int size = origins.size();
            for (int i10 = 0; i10 < size; i10++) {
                LatLonPoint latLonPoint = origins.get(i10);
                if (latLonPoint != null) {
                    double a10 = n.a(latLonPoint.getLatitude());
                    stringBuffer.append(n.a(latLonPoint.getLongitude()));
                    stringBuffer.append(",");
                    stringBuffer.append(a10);
                    if (i10 < size) {
                        stringBuffer.append("|");
                    }
                }
            }
        }
        LatLonPoint destination = ((DistanceSearch.DistanceQuery) ((e) this).f7860b).getDestination();
        if (destination != null) {
            double a11 = n.a(destination.getLatitude());
            double a12 = n.a(destination.getLongitude());
            stringBuffer.append("&destination=");
            stringBuffer.append(a12);
            stringBuffer.append(",");
            stringBuffer.append(a11);
        }
        stringBuffer.append("&type=");
        stringBuffer.append(((DistanceSearch.DistanceQuery) ((e) this).f7860b).getType());
        if (!TextUtils.isEmpty(((DistanceSearch.DistanceQuery) ((e) this).f7860b).getExtensions())) {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((DistanceSearch.DistanceQuery) ((e) this).f7860b).getExtensions());
        } else {
            stringBuffer.append("&extensions=base");
        }
        stringBuffer.append("&output=json");
        if (((DistanceSearch.DistanceQuery) ((e) this).f7860b).getType() == 1) {
            stringBuffer.append("&strategy=");
            stringBuffer.append(((DistanceSearch.DistanceQuery) ((e) this).f7860b).getMode());
        }
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String b() {
        return m.a() + "/distance?";
    }
}
