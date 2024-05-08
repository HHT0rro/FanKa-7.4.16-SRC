package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Handler;
import com.amap.api.maps.model.LatLng;
import com.amap.api.trace.TraceLocation;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sun.security.x509.CRLDistributionPointsExtension;
import sun.util.locale.LanguageTag;

/* compiled from: TraceHandlerAbstract.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class fe extends fc<List<TraceLocation>, List<LatLng>> implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private List<TraceLocation> f5705f;

    /* renamed from: g, reason: collision with root package name */
    private Handler f5706g;

    /* renamed from: h, reason: collision with root package name */
    private int f5707h;

    /* renamed from: i, reason: collision with root package name */
    private int f5708i;

    /* renamed from: j, reason: collision with root package name */
    private String f5709j;

    public fe(Context context, Handler handler, List<TraceLocation> list, String str, int i10, int i11) {
        super(context, list);
        this.f5705f = list;
        this.f5706g = handler;
        this.f5708i = i10;
        this.f5707h = i11;
        this.f5709j = str;
    }

    private static List<LatLng> b(String str) throws fa {
        JSONObject jSONObject;
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (jSONObject.has("data") && (optJSONArray = jSONObject.optJSONObject("data").optJSONArray(CRLDistributionPointsExtension.POINTS)) != null && optJSONArray.length() != 0) {
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
                arrayList.add(new LatLng(Double.parseDouble(optJSONObject.optString("y")), Double.parseDouble(optJSONObject.optString(LanguageTag.PRIVATEUSE))));
            }
            return arrayList;
        }
        return arrayList;
    }

    @Override // com.amap.api.col.p0003l.fc, com.amap.api.col.p0003l.fb
    public final /* synthetic */ Object a(String str) throws fa {
        return b(str);
    }

    @Override // com.amap.api.col.p0003l.fc, com.amap.api.col.p0003l.fb
    public final String c() {
        JSONArray jSONArray = new JSONArray();
        long j10 = 0;
        for (int i10 = 0; i10 < this.f5705f.size(); i10++) {
            TraceLocation traceLocation = this.f5705f.get(i10);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(LanguageTag.PRIVATEUSE, traceLocation.getLongitude());
                jSONObject.put("y", traceLocation.getLatitude());
                jSONObject.put("ag", (int) traceLocation.getBearing());
                long time = traceLocation.getTime();
                if (i10 == 0) {
                    if (time == 0) {
                        time = (System.currentTimeMillis() - 10000) / 1000;
                    }
                    jSONObject.put("tm", time / 1000);
                } else {
                    if (time != 0) {
                        long j11 = time - j10;
                        if (j11 >= 1000) {
                            jSONObject.put("tm", j11 / 1000);
                        }
                    }
                    jSONObject.put("tm", 1);
                }
                j10 = time;
                jSONObject.put("sp", (int) traceLocation.getSpeed());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            jSONArray.put(jSONObject);
        }
        ((fb) this).f5702d = getURL() + "&" + jSONArray.toString();
        return jSONArray.toString();
    }

    @Override // com.amap.api.col.p0003l.id
    public final String getIPV6URL() {
        return dx.a(getURL());
    }

    @Override // com.amap.api.col.p0003l.id
    public final String getURL() {
        String str = "key=" + fj.f(((fb) this).f5701c);
        String a10 = fl.a();
        return "http://restsdk.amap.com/v4/grasproad/driving?" + str + "&ts=".concat(String.valueOf(a10)) + "&scode=".concat(String.valueOf(fl.a(((fb) this).f5701c, a10, str)));
    }

    @Override // com.amap.api.col.p0003l.id
    public final boolean isSupportIPV6() {
        return true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        new ArrayList();
        try {
            try {
                fg.a().a(this.f5709j, this.f5707h, d());
                fg.a().a(this.f5709j).a(this.f5706g);
            } catch (fa e2) {
                fg.a();
                fg.a(this.f5706g, this.f5708i, e2.a());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
