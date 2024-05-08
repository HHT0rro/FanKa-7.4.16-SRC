package com.amap.api.col.s;

import com.amap.api.col.s.am;
import com.amap.api.services.core.LatLonPoint;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* compiled from: RequestCacheWorkerCheckDistance.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
final class ao extends an {

    /* renamed from: a, reason: collision with root package name */
    private double f7111a;

    /* compiled from: RequestCacheWorkerCheckDistance.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public LatLonPoint f7112a;

        /* renamed from: b, reason: collision with root package name */
        public double f7113b;

        public a(double d10, double d11, double d12) {
            this.f7112a = null;
            this.f7113b = ShadowDrawableWrapper.COS_45;
            this.f7112a = new LatLonPoint(d10, d11);
            this.f7113b = d12;
        }

        public final boolean a(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && a.class == obj.getClass()) {
                LatLonPoint latLonPoint = this.f7112a;
                a aVar = (a) obj;
                if (latLonPoint == aVar.f7112a) {
                    return true;
                }
                if (latLonPoint != null && n.a(latLonPoint, r3) <= aVar.f7113b) {
                    return true;
                }
            }
            return false;
        }
    }

    public ao(String... strArr) {
        super(strArr);
        this.f7111a = ShadowDrawableWrapper.COS_45;
    }

    @Override // com.amap.api.col.s.an
    public final boolean a(LinkedHashMap<am.b, Object> linkedHashMap, am.b bVar) {
        String str;
        if (linkedHashMap != null && bVar != null) {
            if (bVar.f7099b == null) {
                return super.a(linkedHashMap, bVar);
            }
            for (am.b bVar2 : linkedHashMap.h()) {
                if (bVar2 != null && (str = bVar2.f7098a) != null && str.equals(bVar.f7098a)) {
                    Object obj = bVar2.f7099b;
                    if ((obj instanceof a) && ((a) obj).a(bVar.f7099b)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.amap.api.col.s.an
    public final Object b(LinkedHashMap<am.b, Object> linkedHashMap, am.b bVar) {
        String str;
        if (linkedHashMap != null && bVar != null) {
            if (bVar.f7099b == null) {
                return super.b(linkedHashMap, bVar);
            }
            for (am.b bVar2 : linkedHashMap.h()) {
                if (bVar2 != null && (str = bVar2.f7098a) != null && str.equals(bVar.f7098a)) {
                    Object obj = bVar2.f7099b;
                    if ((obj instanceof a) && ((a) obj).a(bVar.f7099b)) {
                        return linkedHashMap.get(bVar2);
                    }
                }
            }
        }
        return null;
    }

    @Override // com.amap.api.col.s.an
    public final Object c(LinkedHashMap<am.b, Object> linkedHashMap, am.b bVar) {
        am.b bVar2;
        String str;
        if (linkedHashMap != null && bVar != null) {
            if (bVar.f7099b == null) {
                return super.c(linkedHashMap, bVar);
            }
            Iterator<am.b> iterator2 = linkedHashMap.h().iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    bVar2 = null;
                    break;
                }
                bVar2 = iterator2.next();
                if (bVar2 != null && (str = bVar2.f7098a) != null && str.equals(bVar.f7098a)) {
                    Object obj = bVar2.f7099b;
                    if ((obj instanceof a) && ((a) obj).a(bVar.f7099b)) {
                        break;
                    }
                }
            }
            if (bVar2 != null) {
                return linkedHashMap.remove(bVar2);
            }
        }
        return null;
    }

    public final double a() {
        return this.f7111a;
    }

    @Override // com.amap.api.col.s.an
    public final void a(am.a aVar) {
        super.a(aVar);
        if (aVar != null) {
            this.f7111a = aVar.d();
        }
    }
}
