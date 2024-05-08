package com.amap.api.col.s;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.col.s.y;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.interfaces.IGeocodeSearch;
import java.util.List;

/* compiled from: GeocodeSearchCore.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class bl implements IGeocodeSearch {

    /* renamed from: a, reason: collision with root package name */
    private Context f7191a;

    /* renamed from: b, reason: collision with root package name */
    private GeocodeSearch.OnGeocodeSearchListener f7192b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f7193c;

    public bl(Context context) throws AMapException {
        cg a10 = cf.a(context, m.a(false));
        if (a10.f7502a == cf.c.SuccessCode) {
            this.f7191a = context.getApplicationContext();
            this.f7193c = y.a();
        } else {
            String str = a10.f7503b;
            throw new AMapException(str, 1, str, a10.f7502a.a());
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final RegeocodeAddress getFromLocation(RegeocodeQuery regeocodeQuery) throws AMapException {
        try {
            w.a(this.f7191a);
            if (a(regeocodeQuery)) {
                return new aq(this.f7191a, regeocodeQuery).c();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e2) {
            n.a(e2, "GeocodeSearch", "getFromLocationAsyn");
            throw e2;
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final void getFromLocationAsyn(final RegeocodeQuery regeocodeQuery) {
        try {
            ax.a().a(new Runnable() { // from class: com.amap.api.col.s.bl.1
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = y.a().obtainMessage();
                    try {
                        try {
                            obtainMessage.arg1 = 2;
                            obtainMessage.what = 201;
                            y.l lVar = new y.l();
                            lVar.f8013b = bl.this.f7192b;
                            obtainMessage.obj = lVar;
                            lVar.f8012a = new RegeocodeResult(regeocodeQuery, bl.this.getFromLocation(regeocodeQuery));
                            obtainMessage.arg2 = 1000;
                        } catch (AMapException e2) {
                            obtainMessage.arg2 = e2.getErrorCode();
                        }
                    } finally {
                        bl.this.f7193c.sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            n.a(th, "GeocodeSearch", "getFromLocationAsyn_threadcreate");
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final List<GeocodeAddress> getFromLocationName(GeocodeQuery geocodeQuery) throws AMapException {
        try {
            w.a(this.f7191a);
            if (geocodeQuery != null) {
                return new t(this.f7191a, geocodeQuery).c();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e2) {
            n.a(e2, "GeocodeSearch", "getFromLocationName");
            throw e2;
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final void getFromLocationNameAsyn(final GeocodeQuery geocodeQuery) {
        try {
            ax.a().a(new Runnable() { // from class: com.amap.api.col.s.bl.2
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = y.a().obtainMessage();
                    try {
                        try {
                            obtainMessage.what = 200;
                            obtainMessage.arg1 = 2;
                            obtainMessage.arg2 = 1000;
                            y.f fVar = new y.f();
                            fVar.f8001b = bl.this.f7192b;
                            obtainMessage.obj = fVar;
                            fVar.f8000a = new GeocodeResult(geocodeQuery, bl.this.getFromLocationName(geocodeQuery));
                        } catch (AMapException e2) {
                            obtainMessage.arg2 = e2.getErrorCode();
                        }
                    } finally {
                        bl.this.f7193c.sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            n.a(th, "GeocodeSearch", "getFromLocationNameAsynThrowable");
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final void setOnGeocodeSearchListener(GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener) {
        this.f7192b = onGeocodeSearchListener;
    }

    private static boolean a(RegeocodeQuery regeocodeQuery) {
        return (regeocodeQuery == null || regeocodeQuery.getPoint() == null || regeocodeQuery.getLatLonType() == null) ? false : true;
    }
}
