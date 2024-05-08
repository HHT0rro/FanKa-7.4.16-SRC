package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.nearby.NearbyInfo;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchResult;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: NearbySearchHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class aa extends f<NearbySearch.NearbyQuery, NearbySearchResult> {

    /* renamed from: g, reason: collision with root package name */
    private Context f7070g;

    /* renamed from: h, reason: collision with root package name */
    private NearbySearch.NearbyQuery f7071h;

    public aa(Context context, NearbySearch.NearbyQuery nearbyQuery) {
        super(context, nearbyQuery);
        this.f7070g = context;
        this.f7071h = nearbyQuery;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.s.f, com.amap.api.col.s.e
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public NearbySearchResult a(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            boolean z10 = true;
            if (this.f7071h.getType() != 1) {
                z10 = false;
            }
            ArrayList<NearbyInfo> a10 = v.a(jSONObject, z10);
            NearbySearchResult nearbySearchResult = new NearbySearchResult();
            nearbySearchResult.setNearbyInfoList(a10);
            return nearbySearchResult;
        } catch (JSONException e2) {
            n.a(e2, "NearbySearchHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.col.s.f, com.amap.api.col.s.e
    public final String a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(bw.f(this.f7070g));
        LatLonPoint centerPoint = this.f7071h.getCenterPoint();
        if (centerPoint != null) {
            stringBuffer.append("&center=");
            stringBuffer.append(centerPoint.getLongitude());
            stringBuffer.append(",");
            stringBuffer.append(centerPoint.getLatitude());
        }
        stringBuffer.append("&radius=");
        stringBuffer.append(this.f7071h.getRadius());
        stringBuffer.append("&limit=30");
        stringBuffer.append("&searchtype=");
        stringBuffer.append(this.f7071h.getType());
        stringBuffer.append("&timerange=");
        stringBuffer.append(this.f7071h.getTimeRange());
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String b() {
        return m.d() + "/nearby/around";
    }
}
