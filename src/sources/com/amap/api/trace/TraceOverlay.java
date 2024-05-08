package com.amap.api.trace;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class TraceOverlay {
    public static final int TRACE_STATUS_FAILURE = 3;
    public static final int TRACE_STATUS_FINISH = 2;
    public static final int TRACE_STATUS_PREPARE = 4;
    public static final int TRACE_STATUS_PROCESSING = 1;

    /* renamed from: a, reason: collision with root package name */
    private Polyline f9136a;

    /* renamed from: b, reason: collision with root package name */
    private PolylineOptions f9137b;

    /* renamed from: c, reason: collision with root package name */
    private AMap f9138c;

    /* renamed from: d, reason: collision with root package name */
    private List<LatLng> f9139d;

    /* renamed from: e, reason: collision with root package name */
    private int f9140e;

    /* renamed from: f, reason: collision with root package name */
    private int f9141f;

    /* renamed from: g, reason: collision with root package name */
    private int f9142g;

    public TraceOverlay(AMap aMap, List<LatLng> list) {
        this.f9139d = new ArrayList();
        this.f9140e = 4;
        this.f9138c = aMap;
        a();
        this.f9139d = list;
        this.f9137b.addAll(list);
        this.f9136a = aMap.addPolyline(this.f9137b);
    }

    private PolylineOptions a() {
        if (this.f9137b == null) {
            PolylineOptions polylineOptions = new PolylineOptions();
            this.f9137b = polylineOptions;
            polylineOptions.setCustomTexture(BitmapDescriptorFactory.fromAsset("tracelinetexture.png"));
            this.f9137b.width(40.0f);
        }
        return this.f9137b;
    }

    public void add(List<LatLng> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.f9139d.addAll(list);
        a();
        if (this.f9136a == null) {
            this.f9136a = this.f9138c.addPolyline(this.f9137b);
        }
        Polyline polyline = this.f9136a;
        if (polyline != null) {
            polyline.setPoints(this.f9139d);
        }
    }

    public int getDistance() {
        return this.f9141f;
    }

    public int getTraceStatus() {
        return this.f9140e;
    }

    public int getWaitTime() {
        return this.f9142g;
    }

    public void remove() {
        Polyline polyline = this.f9136a;
        if (polyline != null) {
            polyline.remove();
        }
    }

    public void setDistance(int i10) {
        this.f9141f = i10;
    }

    public void setProperCamera(List<LatLng> list) {
        LatLngBounds.Builder builder = LatLngBounds.builder();
        if (list == null || list.size() == 0) {
            return;
        }
        Iterator<LatLng> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            builder.include(iterator2.next());
        }
        try {
            this.f9138c.moveCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), 20));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setTraceStatus(int i10) {
        this.f9140e = i10;
    }

    public void setWaitTime(int i10) {
        this.f9142g = i10;
    }

    public void zoopToSpan() {
        setProperCamera(this.f9137b.getPoints());
    }

    public TraceOverlay(AMap aMap) {
        this.f9139d = new ArrayList();
        this.f9140e = 4;
        this.f9138c = aMap;
        a();
    }
}
