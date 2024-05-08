package com.amap.api.fence;

import android.app.PendingIntent;
import android.content.Context;
import com.amap.api.col.p0003l.a;
import com.amap.api.location.DPoint;
import com.autonavi.aps.amapapi.utils.b;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class GeoFenceClient {
    public static final int GEOFENCE_IN = 1;
    public static final int GEOFENCE_OUT = 2;
    public static final int GEOFENCE_STAYED = 4;

    /* renamed from: a, reason: collision with root package name */
    public Context f8044a;

    /* renamed from: b, reason: collision with root package name */
    public a f8045b;

    public GeoFenceClient(Context context) {
        this.f8044a = null;
        this.f8045b = null;
        try {
            if (context != null) {
                Context applicationContext = context.getApplicationContext();
                this.f8044a = applicationContext;
                this.f8045b = a(applicationContext);
                return;
            }
            throw new IllegalArgumentException("Context参数不能为null");
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "<init>");
        }
    }

    private static a a(Context context) {
        return new a(context);
    }

    public void addGeoFence(DPoint dPoint, float f10, String str) {
        try {
            this.f8045b.a(dPoint, f10, str);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "addGeoFence round");
        }
    }

    public PendingIntent createPendingIntent(String str) {
        try {
            return this.f8045b.a(str);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "creatPendingIntent");
            return null;
        }
    }

    public List<GeoFence> getAllGeoFence() {
        ArrayList arrayList = new ArrayList();
        try {
            return this.f8045b.b();
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "getGeoFenceList");
            return arrayList;
        }
    }

    public boolean isPause() {
        try {
            return this.f8045b.i();
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "isPause");
            return true;
        }
    }

    public void pauseGeoFence() {
        try {
            this.f8045b.f();
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "pauseGeoFence");
        }
    }

    public void removeGeoFence() {
        try {
            this.f8045b.a();
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "removeGeoFence");
        }
    }

    public void resumeGeoFence() {
        try {
            this.f8045b.h();
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "resumeGeoFence");
        }
    }

    public void setActivateAction(int i10) {
        try {
            this.f8045b.a(i10);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "setActivatesAction");
        }
    }

    public void setGeoFenceAble(String str, boolean z10) {
        try {
            this.f8045b.a(str, z10);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "setGeoFenceAble");
        }
    }

    public void setGeoFenceListener(GeoFenceListener geoFenceListener) {
        try {
            this.f8045b.a(geoFenceListener);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "setGeoFenceListener");
        }
    }

    public void addGeoFence(List<DPoint> list, String str) {
        try {
            this.f8045b.a(list, str);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "addGeoFence polygon");
        }
    }

    public boolean removeGeoFence(GeoFence geoFence) {
        try {
            return this.f8045b.a(geoFence);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "removeGeoFence1");
            return false;
        }
    }

    public void addGeoFence(String str, String str2, DPoint dPoint, float f10, int i10, String str3) {
        try {
            this.f8045b.a(str, str2, dPoint, f10, i10, str3);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "addGeoFence searche");
        }
    }

    public void addGeoFence(String str, String str2, String str3, int i10, String str4) {
        try {
            this.f8045b.a(str, str2, str3, i10, str4);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "addGeoFence searche");
        }
    }

    public void addGeoFence(String str, String str2) {
        try {
            this.f8045b.a(str, str2);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "addGeoFence district");
        }
    }
}
