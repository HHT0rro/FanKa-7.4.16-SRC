package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.nearby.UploadInfo;

/* compiled from: NearbyUpdateHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ab extends f<UploadInfo, Integer> {

    /* renamed from: g, reason: collision with root package name */
    private Context f7072g;

    /* renamed from: h, reason: collision with root package name */
    private UploadInfo f7073h;

    public ab(Context context, UploadInfo uploadInfo) {
        super(context, uploadInfo);
        this.f7072g = context;
        this.f7073h = uploadInfo;
    }

    private static Integer j() throws AMapException {
        return 0;
    }

    @Override // com.amap.api.col.s.f, com.amap.api.col.s.e
    public final /* synthetic */ Object a(String str) throws AMapException {
        return j();
    }

    @Override // com.amap.api.col.s.f, com.amap.api.col.s.e
    public final String a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(bw.f(this.f7072g));
        stringBuffer.append("&userid=");
        stringBuffer.append(this.f7073h.getUserID());
        LatLonPoint point = this.f7073h.getPoint();
        int longitude = (int) (point.getLongitude() * 1000000.0d);
        int latitude = (int) (point.getLatitude() * 1000000.0d);
        stringBuffer.append("&location=");
        stringBuffer.append(longitude / 1000000.0f);
        stringBuffer.append(",");
        stringBuffer.append(latitude / 1000000.0f);
        stringBuffer.append("&coordtype=");
        stringBuffer.append(this.f7073h.getCoordType());
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String b() {
        return m.d() + "/nearby/data/create";
    }
}
