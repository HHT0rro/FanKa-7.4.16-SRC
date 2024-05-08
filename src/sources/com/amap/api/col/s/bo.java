package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.col.s.y;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IPoiSearch;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import java.util.HashMap;
import java.util.List;

/* compiled from: PoiSearchCore.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class bo implements IPoiSearch {

    /* renamed from: i, reason: collision with root package name */
    private static HashMap<Integer, PoiResult> f7221i;

    /* renamed from: a, reason: collision with root package name */
    private PoiSearch.SearchBound f7222a;

    /* renamed from: b, reason: collision with root package name */
    private PoiSearch.Query f7223b;

    /* renamed from: c, reason: collision with root package name */
    private Context f7224c;

    /* renamed from: d, reason: collision with root package name */
    private PoiSearch.OnPoiSearchListener f7225d;

    /* renamed from: e, reason: collision with root package name */
    private String f7226e = "zh-CN";

    /* renamed from: f, reason: collision with root package name */
    private PoiSearch.Query f7227f;

    /* renamed from: g, reason: collision with root package name */
    private PoiSearch.SearchBound f7228g;

    /* renamed from: h, reason: collision with root package name */
    private int f7229h;

    /* renamed from: j, reason: collision with root package name */
    private Handler f7230j;

    public bo(Context context, PoiSearch.Query query) throws AMapException {
        this.f7230j = null;
        cg a10 = cf.a(context, m.a(false));
        if (a10.f7502a == cf.c.SuccessCode) {
            this.f7224c = context.getApplicationContext();
            setQuery(query);
            this.f7230j = y.a();
            return;
        }
        String str = a10.f7503b;
        throw new AMapException(str, 1, str, a10.f7502a.a());
    }

    private boolean c() {
        PoiSearch.SearchBound bound = getBound();
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

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final PoiSearch.SearchBound getBound() {
        return this.f7222a;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final String getLanguage() {
        return this.f7226e;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final PoiSearch.Query getQuery() {
        return this.f7223b;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final PoiResult searchPOI() throws AMapException {
        try {
            w.a(this.f7224c);
            if (!b() && !a()) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (c()) {
                PoiSearch.Query query = this.f7223b;
                if (query != null) {
                    if ((!query.queryEquals(this.f7227f) && this.f7222a == null) || (!this.f7223b.queryEquals(this.f7227f) && !this.f7222a.equals(this.f7228g))) {
                        this.f7229h = 0;
                        this.f7227f = this.f7223b.m1977clone();
                        PoiSearch.SearchBound searchBound = this.f7222a;
                        if (searchBound != null) {
                            this.f7228g = searchBound.m1978clone();
                        }
                        HashMap<Integer, PoiResult> hashMap = f7221i;
                        if (hashMap != null) {
                            hashMap.clear();
                        }
                    }
                    PoiSearch.SearchBound searchBound2 = this.f7222a;
                    PoiSearch.SearchBound m1978clone = searchBound2 != null ? searchBound2.m1978clone() : null;
                    ap.a().a(this.f7223b.getQueryString());
                    this.f7223b.setPageNum(ap.a().k(this.f7223b.getPageNum()));
                    this.f7223b.setPageSize(ap.a().l(this.f7223b.getPageSize()));
                    if (this.f7229h == 0) {
                        PoiResult c4 = new af(this.f7224c, new aj(this.f7223b.m1977clone(), m1978clone)).c();
                        a(c4);
                        return c4;
                    }
                    PoiResult a10 = a(this.f7223b.getPageNum());
                    if (a10 != null) {
                        return a10;
                    }
                    PoiResult c10 = new af(this.f7224c, new aj(this.f7223b.m1977clone(), m1978clone)).c();
                    f7221i.put(Integer.valueOf(this.f7223b.getPageNum()), c10);
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

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void searchPOIAsyn() {
        try {
            ax.a().a(new Runnable() { // from class: com.amap.api.col.s.bo.1
                @Override // java.lang.Runnable
                public final void run() {
                    y.j jVar;
                    Message obtainMessage = bo.this.f7230j.obtainMessage();
                    obtainMessage.arg1 = 6;
                    obtainMessage.what = 600;
                    Bundle bundle = new Bundle();
                    PoiResult poiResult = null;
                    try {
                        try {
                            poiResult = bo.this.searchPOI();
                            bundle.putInt("errorCode", 1000);
                            jVar = new y.j();
                        } catch (AMapException e2) {
                            bundle.putInt("errorCode", e2.getErrorCode());
                            jVar = new y.j();
                        }
                        jVar.f8009b = bo.this.f7225d;
                        jVar.f8008a = poiResult;
                        obtainMessage.obj = jVar;
                        obtainMessage.setData(bundle);
                        bo.this.f7230j.sendMessage(obtainMessage);
                    } catch (Throwable th) {
                        y.j jVar2 = new y.j();
                        jVar2.f8009b = bo.this.f7225d;
                        jVar2.f8008a = poiResult;
                        obtainMessage.obj = jVar2;
                        obtainMessage.setData(bundle);
                        bo.this.f7230j.sendMessage(obtainMessage);
                        throw th;
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final PoiItem searchPOIId(String str) throws AMapException {
        w.a(this.f7224c);
        PoiSearch.Query query = this.f7223b;
        return new ad(this.f7224c, str, query != null ? query.m1977clone() : null).c();
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void searchPOIIdAsyn(final String str) {
        ax.a().a(new Runnable() { // from class: com.amap.api.col.s.bo.2
            @Override // java.lang.Runnable
            public final void run() {
                y.h hVar;
                Message obtainMessage = y.a().obtainMessage();
                obtainMessage.arg1 = 6;
                obtainMessage.what = 602;
                Bundle bundle = new Bundle();
                PoiItem poiItem = null;
                try {
                    try {
                        poiItem = bo.this.searchPOIId(str);
                        bundle.putInt("errorCode", 1000);
                        hVar = new y.h();
                    } catch (AMapException e2) {
                        n.a(e2, "PoiSearch", "searchPOIIdAsyn");
                        bundle.putInt("errorCode", e2.getErrorCode());
                        hVar = new y.h();
                    }
                    hVar.f8005b = bo.this.f7225d;
                    hVar.f8004a = poiItem;
                    obtainMessage.obj = hVar;
                    obtainMessage.setData(bundle);
                    bo.this.f7230j.sendMessage(obtainMessage);
                } catch (Throwable th) {
                    y.h hVar2 = new y.h();
                    hVar2.f8005b = bo.this.f7225d;
                    hVar2.f8004a = poiItem;
                    obtainMessage.obj = hVar2;
                    obtainMessage.setData(bundle);
                    bo.this.f7230j.sendMessage(obtainMessage);
                    throw th;
                }
            }
        });
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void setBound(PoiSearch.SearchBound searchBound) {
        this.f7222a = searchBound;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void setLanguage(String str) {
        if ("en".equals(str)) {
            this.f7226e = "en";
        } else {
            this.f7226e = "zh-CN";
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void setOnPoiSearchListener(PoiSearch.OnPoiSearchListener onPoiSearchListener) {
        this.f7225d = onPoiSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void setQuery(PoiSearch.Query query) {
        this.f7223b = query;
    }

    private boolean a() {
        PoiSearch.Query query = this.f7223b;
        if (query == null) {
            return false;
        }
        return (n.a(query.getQueryString()) && n.a(this.f7223b.getCategory())) ? false : true;
    }

    private boolean b() {
        PoiSearch.SearchBound bound = getBound();
        return bound != null && bound.getShape().equals("Bound");
    }

    private boolean b(int i10) {
        return i10 <= this.f7229h && i10 >= 0;
    }

    private void a(PoiResult poiResult) {
        int i10;
        f7221i = new HashMap<>();
        PoiSearch.Query query = this.f7223b;
        if (query == null || poiResult == null || (i10 = this.f7229h) <= 0 || i10 <= query.getPageNum()) {
            return;
        }
        f7221i.put(Integer.valueOf(this.f7223b.getPageNum()), poiResult);
    }

    private PoiResult a(int i10) {
        if (b(i10)) {
            return f7221i.get(Integer.valueOf(i10));
        }
        throw new IllegalArgumentException("page out of range");
    }
}
