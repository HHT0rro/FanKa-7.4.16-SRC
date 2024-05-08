package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.col.s.y;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.interfaces.IPoiSearchV2;
import com.amap.api.services.poisearch.PoiResultV2;
import com.amap.api.services.poisearch.PoiSearchV2;
import java.util.HashMap;
import java.util.List;

/* compiled from: PoiSearchCoreV2.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class bp implements IPoiSearchV2 {

    /* renamed from: i, reason: collision with root package name */
    private static HashMap<Integer, PoiResultV2> f7234i;

    /* renamed from: a, reason: collision with root package name */
    private PoiSearchV2.SearchBound f7235a;

    /* renamed from: b, reason: collision with root package name */
    private PoiSearchV2.Query f7236b;

    /* renamed from: c, reason: collision with root package name */
    private Context f7237c;

    /* renamed from: d, reason: collision with root package name */
    private PoiSearchV2.OnPoiSearchListener f7238d;

    /* renamed from: e, reason: collision with root package name */
    private String f7239e = "zh-CN";

    /* renamed from: f, reason: collision with root package name */
    private PoiSearchV2.Query f7240f;

    /* renamed from: g, reason: collision with root package name */
    private PoiSearchV2.SearchBound f7241g;

    /* renamed from: h, reason: collision with root package name */
    private int f7242h;

    /* renamed from: j, reason: collision with root package name */
    private Handler f7243j;

    public bp(Context context, PoiSearchV2.Query query) throws AMapException {
        this.f7243j = null;
        cg a10 = cf.a(context, m.a(false));
        if (a10.f7502a == cf.c.SuccessCode) {
            this.f7237c = context.getApplicationContext();
            setQuery(query);
            this.f7243j = y.a();
            return;
        }
        String str = a10.f7503b;
        throw new AMapException(str, 1, str, a10.f7502a.a());
    }

    private boolean c() {
        PoiSearchV2.SearchBound bound = getBound();
        if (bound == null) {
            return true;
        }
        if (bound.getShape().equals("Bound")) {
            return bound.getCenter() != null;
        }
        if (bound.getShape().equals("Polygon")) {
            List<LatLonPoint> polyGonList = bound.getPolyGonList();
            if (polyGonList == null || polyGonList.size() == 0) {
                return false;
            }
            for (int i10 = 0; i10 < polyGonList.size(); i10++) {
                if (polyGonList.get(i10) == null) {
                    return false;
                }
            }
            return true;
        }
        if (!bound.getShape().equals("Rectangle")) {
            return true;
        }
        LatLonPoint lowerLeft = bound.getLowerLeft();
        LatLonPoint upperRight = bound.getUpperRight();
        return lowerLeft != null && upperRight != null && lowerLeft.getLatitude() < upperRight.getLatitude() && lowerLeft.getLongitude() < upperRight.getLongitude();
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final PoiSearchV2.SearchBound getBound() {
        return this.f7235a;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final String getLanguage() {
        return this.f7239e;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final PoiSearchV2.Query getQuery() {
        return this.f7236b;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final PoiResultV2 searchPOI() throws AMapException {
        try {
            w.a(this.f7237c);
            if (!b() && !a()) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (c()) {
                PoiSearchV2.Query query = this.f7236b;
                if (query != null) {
                    if ((!query.queryEquals(this.f7240f) && this.f7235a == null) || (!this.f7236b.queryEquals(this.f7240f) && !this.f7235a.equals(this.f7241g))) {
                        this.f7242h = 0;
                        this.f7240f = this.f7236b.m1979clone();
                        PoiSearchV2.SearchBound searchBound = this.f7235a;
                        if (searchBound != null) {
                            this.f7241g = searchBound.m1980clone();
                        }
                        HashMap<Integer, PoiResultV2> hashMap = f7234i;
                        if (hashMap != null) {
                            hashMap.clear();
                        }
                    }
                    PoiSearchV2.SearchBound searchBound2 = this.f7235a;
                    PoiSearchV2.SearchBound m1980clone = searchBound2 != null ? searchBound2.m1980clone() : null;
                    ap.a().a(this.f7236b.getQueryString());
                    this.f7236b.setPageNum(ap.a().k(this.f7236b.getPageNum()));
                    this.f7236b.setPageSize(ap.a().l(this.f7236b.getPageSize()));
                    if (this.f7242h == 0) {
                        PoiResultV2 c4 = new ag(this.f7237c, new ak(this.f7236b.m1979clone(), m1980clone)).c();
                        a(c4);
                        return c4;
                    }
                    PoiResultV2 a10 = a(this.f7236b.getPageNum());
                    if (a10 != null) {
                        return a10;
                    }
                    PoiResultV2 c10 = new ag(this.f7237c, new ak(this.f7236b.m1979clone(), m1980clone)).c();
                    f7234i.put(Integer.valueOf(this.f7236b.getPageNum()), c10);
                    return c10;
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e2) {
            n.a(e2, "PoiSearch", "searchPOI");
            throw new AMapException(e2.getErrorMessage());
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final void searchPOIAsyn() {
        try {
            ax.a().a(new Runnable() { // from class: com.amap.api.col.s.bp.1
                @Override // java.lang.Runnable
                public final void run() {
                    y.k kVar;
                    Message obtainMessage = bp.this.f7243j.obtainMessage();
                    obtainMessage.arg1 = 19;
                    obtainMessage.what = 603;
                    Bundle bundle = new Bundle();
                    PoiResultV2 poiResultV2 = null;
                    try {
                        try {
                            poiResultV2 = bp.this.searchPOI();
                            bundle.putInt("errorCode", 1000);
                            kVar = new y.k();
                        } catch (AMapException e2) {
                            bundle.putInt("errorCode", e2.getErrorCode());
                            kVar = new y.k();
                        }
                        kVar.f8011b = bp.this.f7238d;
                        kVar.f8010a = poiResultV2;
                        obtainMessage.obj = kVar;
                        obtainMessage.setData(bundle);
                        bp.this.f7243j.sendMessage(obtainMessage);
                    } catch (Throwable th) {
                        y.k kVar2 = new y.k();
                        kVar2.f8011b = bp.this.f7238d;
                        kVar2.f8010a = poiResultV2;
                        obtainMessage.obj = kVar2;
                        obtainMessage.setData(bundle);
                        bp.this.f7243j.sendMessage(obtainMessage);
                        throw th;
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final PoiItemV2 searchPOIId(String str) throws AMapException {
        w.a(this.f7237c);
        PoiSearchV2.Query query = this.f7236b;
        return new ae(this.f7237c, str, query != null ? query.m1979clone() : null).c();
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final void searchPOIIdAsyn(final String str) {
        ax.a().a(new Runnable() { // from class: com.amap.api.col.s.bp.2
            @Override // java.lang.Runnable
            public final void run() {
                y.i iVar;
                Message obtainMessage = y.a().obtainMessage();
                obtainMessage.arg1 = 19;
                obtainMessage.what = 604;
                Bundle bundle = new Bundle();
                PoiItemV2 poiItemV2 = null;
                try {
                    try {
                        poiItemV2 = bp.this.searchPOIId(str);
                        bundle.putInt("errorCode", 1000);
                        iVar = new y.i();
                    } catch (AMapException e2) {
                        n.a(e2, "PoiSearch", "searchPOIIdAsyn");
                        bundle.putInt("errorCode", e2.getErrorCode());
                        iVar = new y.i();
                    }
                    iVar.f8007b = bp.this.f7238d;
                    iVar.f8006a = poiItemV2;
                    obtainMessage.obj = iVar;
                    obtainMessage.setData(bundle);
                    bp.this.f7243j.sendMessage(obtainMessage);
                } catch (Throwable th) {
                    y.i iVar2 = new y.i();
                    iVar2.f8007b = bp.this.f7238d;
                    iVar2.f8006a = poiItemV2;
                    obtainMessage.obj = iVar2;
                    obtainMessage.setData(bundle);
                    bp.this.f7243j.sendMessage(obtainMessage);
                    throw th;
                }
            }
        });
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final void setBound(PoiSearchV2.SearchBound searchBound) {
        this.f7235a = searchBound;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final void setLanguage(String str) {
        if ("en".equals(str)) {
            this.f7239e = "en";
        } else {
            this.f7239e = "zh-CN";
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final void setOnPoiSearchListener(PoiSearchV2.OnPoiSearchListener onPoiSearchListener) {
        this.f7238d = onPoiSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public final void setQuery(PoiSearchV2.Query query) {
        this.f7236b = query;
    }

    private boolean a() {
        PoiSearchV2.Query query = this.f7236b;
        if (query == null) {
            return false;
        }
        return (n.a(query.getQueryString()) && n.a(this.f7236b.getCategory())) ? false : true;
    }

    private boolean b() {
        PoiSearchV2.SearchBound bound = getBound();
        return bound != null && bound.getShape().equals("Bound");
    }

    private boolean b(int i10) {
        return i10 <= this.f7242h && i10 >= 0;
    }

    private void a(PoiResultV2 poiResultV2) {
        int i10;
        f7234i = new HashMap<>();
        PoiSearchV2.Query query = this.f7236b;
        if (query == null || poiResultV2 == null || (i10 = this.f7242h) <= 0 || i10 <= query.getPageNum()) {
            return;
        }
        f7234i.put(Integer.valueOf(this.f7236b.getPageNum()), poiResultV2);
    }

    private PoiResultV2 a(int i10) {
        if (b(i10)) {
            return f7234i.get(Integer.valueOf(i10));
        }
        throw new IllegalArgumentException("page out of range");
    }
}
