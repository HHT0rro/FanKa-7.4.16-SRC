package com.amap.api.maps.model;

import com.amap.api.col.p0003l.dg;
import com.autonavi.amap.mapcore.DPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* compiled from: PointQuadTree.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    private final dg f8227a;

    /* renamed from: b, reason: collision with root package name */
    private final int f8228b;

    /* renamed from: c, reason: collision with root package name */
    private List<WeightedLatLng> f8229c;

    /* renamed from: d, reason: collision with root package name */
    private List<a> f8230d;

    public a(dg dgVar) {
        this(dgVar, 0);
    }

    public final void a(WeightedLatLng weightedLatLng) {
        DPoint point = weightedLatLng.getPoint();
        if (this.f8227a.a(point.f9303x, point.f9304y)) {
            a(point.f9303x, point.f9304y, weightedLatLng);
        }
    }

    private a(double d10, double d11, double d12, double d13, int i10) {
        this(new dg(d10, d11, d12, d13), i10);
    }

    private a(dg dgVar, int i10) {
        this.f8230d = null;
        this.f8227a = dgVar;
        this.f8228b = i10;
    }

    private void a(double d10, double d11, WeightedLatLng weightedLatLng) {
        List<a> list = this.f8230d;
        if (list != null) {
            dg dgVar = this.f8227a;
            if (d11 < dgVar.f5343f) {
                if (d10 < dgVar.f5342e) {
                    list.get(0).a(d10, d11, weightedLatLng);
                    return;
                } else {
                    list.get(1).a(d10, d11, weightedLatLng);
                    return;
                }
            }
            if (d10 < dgVar.f5342e) {
                list.get(2).a(d10, d11, weightedLatLng);
                return;
            } else {
                list.get(3).a(d10, d11, weightedLatLng);
                return;
            }
        }
        if (this.f8229c == null) {
            this.f8229c = new ArrayList();
        }
        this.f8229c.add(weightedLatLng);
        if (this.f8229c.size() <= 50 || this.f8228b >= 40) {
            return;
        }
        a();
    }

    private void a() {
        ArrayList arrayList = new ArrayList(4);
        this.f8230d = arrayList;
        dg dgVar = this.f8227a;
        arrayList.add(new a(dgVar.f5338a, dgVar.f5342e, dgVar.f5339b, dgVar.f5343f, this.f8228b + 1));
        List<a> list = this.f8230d;
        dg dgVar2 = this.f8227a;
        list.add(new a(dgVar2.f5342e, dgVar2.f5340c, dgVar2.f5339b, dgVar2.f5343f, this.f8228b + 1));
        List<a> list2 = this.f8230d;
        dg dgVar3 = this.f8227a;
        list2.add(new a(dgVar3.f5338a, dgVar3.f5342e, dgVar3.f5343f, dgVar3.f5341d, this.f8228b + 1));
        List<a> list3 = this.f8230d;
        dg dgVar4 = this.f8227a;
        list3.add(new a(dgVar4.f5342e, dgVar4.f5340c, dgVar4.f5343f, dgVar4.f5341d, this.f8228b + 1));
        List<WeightedLatLng> list4 = this.f8229c;
        this.f8229c = null;
        for (WeightedLatLng weightedLatLng : list4) {
            a(weightedLatLng.getPoint().f9303x, weightedLatLng.getPoint().f9304y, weightedLatLng);
        }
    }

    public final Collection<WeightedLatLng> a(dg dgVar) {
        ArrayList arrayList = new ArrayList();
        a(dgVar, arrayList);
        return arrayList;
    }

    private void a(dg dgVar, Collection<WeightedLatLng> collection) {
        if (this.f8227a.a(dgVar)) {
            List<a> list = this.f8230d;
            if (list != null) {
                Iterator<a> iterator2 = list.iterator2();
                while (iterator2.hasNext()) {
                    iterator2.next().a(dgVar, collection);
                }
            } else if (this.f8229c != null) {
                if (dgVar.b(this.f8227a)) {
                    collection.addAll(this.f8229c);
                    return;
                }
                for (WeightedLatLng weightedLatLng : this.f8229c) {
                    if (dgVar.a(weightedLatLng.getPoint())) {
                        collection.add(weightedLatLng);
                    }
                }
            }
        }
    }
}
