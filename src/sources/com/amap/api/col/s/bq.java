package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.col.s.y;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IRoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearchQuery;
import com.amap.api.services.routepoisearch.RoutePOISearchResult;

/* compiled from: RoutePOISearchCore.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class bq implements IRoutePOISearch {

    /* renamed from: a, reason: collision with root package name */
    private RoutePOISearchQuery f7247a;

    /* renamed from: b, reason: collision with root package name */
    private Context f7248b;

    /* renamed from: c, reason: collision with root package name */
    private RoutePOISearch.OnRoutePOISearchListener f7249c;

    /* renamed from: d, reason: collision with root package name */
    private Handler f7250d;

    public bq(Context context, RoutePOISearchQuery routePOISearchQuery) throws AMapException {
        this.f7250d = null;
        cg a10 = cf.a(context, m.a(false));
        if (a10.f7502a == cf.c.SuccessCode) {
            this.f7248b = context;
            this.f7247a = routePOISearchQuery;
            this.f7250d = y.a();
            return;
        }
        String str = a10.f7503b;
        throw new AMapException(str, 1, str, a10.f7502a.a());
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final RoutePOISearchQuery getQuery() {
        return this.f7247a;
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final RoutePOISearchResult searchRoutePOI() throws AMapException {
        try {
            w.a(this.f7248b);
            if (a()) {
                return new at(this.f7248b, this.f7247a.m1994clone()).c();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e2) {
            n.a(e2, "RoutePOISearchCore", "searchRoutePOI");
            throw e2;
        }
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final void searchRoutePOIAsyn() {
        ax.a().a(new Runnable() { // from class: com.amap.api.col.s.bq.1
            @Override // java.lang.Runnable
            public final void run() {
                y.m mVar;
                Message obtainMessage = bq.this.f7250d.obtainMessage();
                obtainMessage.arg1 = 14;
                Bundle bundle = new Bundle();
                RoutePOISearchResult routePOISearchResult = null;
                try {
                    try {
                        routePOISearchResult = bq.this.searchRoutePOI();
                        bundle.putInt("errorCode", 1000);
                        mVar = new y.m();
                    } catch (AMapException e2) {
                        bundle.putInt("errorCode", e2.getErrorCode());
                        mVar = new y.m();
                    }
                    mVar.f8015b = bq.this.f7249c;
                    mVar.f8014a = routePOISearchResult;
                    obtainMessage.obj = mVar;
                    obtainMessage.setData(bundle);
                    bq.this.f7250d.sendMessage(obtainMessage);
                } catch (Throwable th) {
                    y.m mVar2 = new y.m();
                    mVar2.f8015b = bq.this.f7249c;
                    mVar2.f8014a = routePOISearchResult;
                    obtainMessage.obj = mVar2;
                    obtainMessage.setData(bundle);
                    bq.this.f7250d.sendMessage(obtainMessage);
                    throw th;
                }
            }
        });
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final void setQuery(RoutePOISearchQuery routePOISearchQuery) {
        this.f7247a = routePOISearchQuery;
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final void setRoutePOISearchListener(RoutePOISearch.OnRoutePOISearchListener onRoutePOISearchListener) {
        this.f7249c = onRoutePOISearchListener;
    }

    private boolean a() {
        RoutePOISearchQuery routePOISearchQuery = this.f7247a;
        if (routePOISearchQuery == null || routePOISearchQuery.getSearchType() == null) {
            return false;
        }
        return (this.f7247a.getFrom() == null && this.f7247a.getTo() == null && this.f7247a.getPolylines() == null) ? false : true;
    }
}
