package com.amap.api.col.s;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.RouteSearchV2;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.Iterator;
import java.util.List;

/* compiled from: RequestConfig.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ap {

    /* renamed from: r, reason: collision with root package name */
    private static volatile ap f7114r;

    /* renamed from: a, reason: collision with root package name */
    public boolean f7115a = true;

    /* renamed from: b, reason: collision with root package name */
    public boolean f7116b = true;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7117c = true;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7118d = true;

    /* renamed from: e, reason: collision with root package name */
    public boolean f7119e = true;

    /* renamed from: f, reason: collision with root package name */
    public boolean f7120f = true;

    /* renamed from: g, reason: collision with root package name */
    public boolean f7121g = true;

    /* renamed from: h, reason: collision with root package name */
    public int f7122h = 25;

    /* renamed from: i, reason: collision with root package name */
    public int f7123i = 100;

    /* renamed from: j, reason: collision with root package name */
    public int f7124j = 100;

    /* renamed from: k, reason: collision with root package name */
    public int f7125k = 100;

    /* renamed from: l, reason: collision with root package name */
    public int f7126l = 6;

    /* renamed from: m, reason: collision with root package name */
    public int f7127m = 100;

    /* renamed from: n, reason: collision with root package name */
    public int f7128n = 5000;

    /* renamed from: o, reason: collision with root package name */
    public int f7129o = 1200;

    /* renamed from: p, reason: collision with root package name */
    public int f7130p = 100000000;

    /* renamed from: q, reason: collision with root package name */
    public int f7131q = 16;

    public static ap a() {
        if (f7114r == null) {
            synchronized (ap.class) {
                if (f7114r == null) {
                    f7114r = new ap();
                }
            }
        }
        return f7114r;
    }

    public final void b(boolean z10) {
        this.f7117c = z10;
    }

    public final void c(boolean z10) {
        this.f7118d = z10;
    }

    public final void d(boolean z10) {
        this.f7119e = z10;
    }

    public final void e(boolean z10) {
        this.f7120f = z10;
    }

    public final void f(boolean z10) {
        this.f7121g = z10;
    }

    public final void g(boolean z10) {
        this.f7116b = z10;
    }

    public final void h(int i10) {
        this.f7129o = i10;
    }

    public final void i(int i10) {
        this.f7130p = i10;
    }

    public final void j(int i10) {
        this.f7131q = i10;
    }

    public final int k(int i10) {
        int i11;
        return (this.f7118d && (i11 = this.f7127m) < i10) ? i11 : i10;
    }

    public final int l(int i10) {
        int i11;
        return (this.f7118d && (i11 = this.f7122h) < i10) ? i11 : i10;
    }

    public final void b(int i10) {
        this.f7123i = i10;
    }

    public final void c(int i10) {
        this.f7124j = i10;
    }

    public final void d(int i10) {
        this.f7125k = i10;
    }

    public final void e(int i10) {
        this.f7126l = i10;
    }

    public final void f(int i10) {
        this.f7127m = i10;
    }

    public final void g(int i10) {
        this.f7128n = i10;
    }

    public final void b(RouteSearch.FromAndTo fromAndTo) throws AMapException {
        if (!this.f7120f || fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) {
            return;
        }
        if (this.f7125k < n.a(fromAndTo.getFrom(), fromAndTo.getTo()) / 1000.0d) {
            throw new AMapException(AMapException.AMAP_OVER_DIRECTION_RANGE);
        }
    }

    public final void c(List<List<LatLonPoint>> list) throws AMapException {
        if (this.f7115a && list != null) {
            if (this.f7124j >= list.size()) {
                for (List<LatLonPoint> list2 : list) {
                    double b4 = n.b(list2);
                    if (this.f7131q < list2.size()) {
                        throw new AMapException(AMapException.AMAP_CLIENT_OVER_PASSAREA_ITEM_POINT_COUNT_EXCEPTION);
                    }
                    if (this.f7130p < b4) {
                        throw new AMapException(AMapException.AMAP_CLIENT_OVER_PASSAREA_MAX_AREA_EXCEPTION);
                    }
                }
                return;
            }
            throw new AMapException(AMapException.AMAP_CLIENT_OVER_PASSAREA_MAX_COUNT_EXCEPTION);
        }
    }

    public final void a(boolean z10) {
        this.f7115a = z10;
    }

    public final void a(int i10) {
        this.f7122h = i10;
    }

    public final void b(RouteSearchV2.FromAndTo fromAndTo) throws AMapException {
        if (!this.f7120f || fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) {
            return;
        }
        if (this.f7125k < n.a(fromAndTo.getFrom(), fromAndTo.getTo()) / 1000.0d) {
            throw new AMapException(AMapException.AMAP_OVER_DIRECTION_RANGE);
        }
    }

    public final void a(RouteSearch.FromAndTo fromAndTo, List<LatLonPoint> list) throws AMapException {
        double a10;
        if (!this.f7117c || fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) {
            return;
        }
        double d10 = ShadowDrawableWrapper.COS_45;
        if (list != null && list.size() != 0) {
            LatLonPoint from = fromAndTo.getFrom();
            LatLonPoint to = fromAndTo.getTo();
            Iterator<LatLonPoint> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                d10 += n.a(from, r3);
                from = iterator2.next();
            }
            a10 = d10 + n.a(from, to);
        } else {
            a10 = n.a(fromAndTo.getFrom(), fromAndTo.getTo());
        }
        if (this.f7128n < a10 / 1000.0d) {
            throw new AMapException(AMapException.AMAP_OVER_DIRECTION_RANGE);
        }
    }

    public static void b(List<LatLonPoint> list) throws AMapException {
        if (list != null && 16 < list.size()) {
            throw new AMapException(AMapException.AMAP_CLIENT_OVER_PASSBY_MAX_COUNT_EXCEPTION);
        }
    }

    public final void a(RouteSearch.FromAndTo fromAndTo) throws AMapException {
        if (!this.f7119e || fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) {
            return;
        }
        if (this.f7129o < n.a(fromAndTo.getFrom(), fromAndTo.getTo()) / 1000.0d) {
            throw new AMapException(AMapException.AMAP_OVER_DIRECTION_RANGE);
        }
    }

    public final void a(RouteSearchV2.FromAndTo fromAndTo) throws AMapException {
        if (!this.f7119e || fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) {
            return;
        }
        if (this.f7129o < n.a(fromAndTo.getFrom(), fromAndTo.getTo()) / 1000.0d) {
            throw new AMapException(AMapException.AMAP_OVER_DIRECTION_RANGE);
        }
    }

    public final void a(List<LatLonPoint> list) throws AMapException {
        if (this.f7121g && list != null) {
            if (this.f7126l < list.size()) {
                throw new AMapException(AMapException.AMAP_CLIENT_OVER_PASSBY_MAX_COUNT_EXCEPTION);
            }
        }
    }

    public final void a(String str) throws AMapException {
        if (str != null && this.f7116b && str.length() > this.f7123i) {
            throw new AMapException(AMapException.AMAP_CLIENT_OVER_KEYWORD_LEN_MAX_COUNT_EXCEPTION);
        }
    }
}
