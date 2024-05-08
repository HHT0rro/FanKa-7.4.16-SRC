package com.amap.api.col.s;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.col.s.y;
import com.amap.api.services.busline.BusStationQuery;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.busline.BusStationSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusStationSearch;
import java.util.ArrayList;

/* compiled from: BusStationSearchCore.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class bh implements IBusStationSearch {

    /* renamed from: a, reason: collision with root package name */
    private Context f7158a;

    /* renamed from: b, reason: collision with root package name */
    private BusStationSearch.OnBusStationSearchListener f7159b;

    /* renamed from: c, reason: collision with root package name */
    private BusStationQuery f7160c;

    /* renamed from: d, reason: collision with root package name */
    private BusStationQuery f7161d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<BusStationResult> f7162e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    private int f7163f;

    /* renamed from: g, reason: collision with root package name */
    private Handler f7164g;

    public bh(Context context, BusStationQuery busStationQuery) throws AMapException {
        cg a10 = cf.a(context, m.a(false));
        if (a10.f7502a == cf.c.SuccessCode) {
            this.f7158a = context.getApplicationContext();
            this.f7160c = busStationQuery;
            this.f7164g = y.a();
            return;
        }
        String str = a10.f7503b;
        throw new AMapException(str, 1, str, a10.f7502a.a());
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final BusStationQuery getQuery() {
        return this.f7160c;
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final BusStationResult searchBusStation() throws AMapException {
        try {
            w.a(this.f7158a);
            if (a()) {
                if (!this.f7160c.weakEquals(this.f7161d)) {
                    this.f7161d = this.f7160c.m1973clone();
                    this.f7163f = 0;
                    ArrayList<BusStationResult> arrayList = this.f7162e;
                    if (arrayList != null) {
                        arrayList.clear();
                    }
                }
                if (this.f7163f == 0) {
                    BusStationResult busStationResult = (BusStationResult) new i(this.f7158a, this.f7160c).c();
                    this.f7163f = busStationResult.getPageCount();
                    a(busStationResult);
                    return busStationResult;
                }
                BusStationResult b4 = b(this.f7160c.getPageNumber());
                if (b4 != null) {
                    return b4;
                }
                BusStationResult busStationResult2 = (BusStationResult) new i(this.f7158a, this.f7160c).c();
                this.f7162e.set(this.f7160c.getPageNumber(), busStationResult2);
                return busStationResult2;
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e2) {
            n.a(e2, "BusStationSearch", "searchBusStation");
            throw new AMapException(e2.getErrorMessage());
        } catch (Throwable th) {
            n.a(th, "BusStationSearch", "searchBusStation");
            return null;
        }
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final void searchBusStationAsyn() {
        try {
            ax.a().a(new Runnable() { // from class: com.amap.api.col.s.bh.1
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = y.a().obtainMessage();
                    try {
                        try {
                            obtainMessage.arg1 = 7;
                            y.c cVar = new y.c();
                            cVar.f7995b = bh.this.f7159b;
                            obtainMessage.obj = cVar;
                            BusStationResult searchBusStation = bh.this.searchBusStation();
                            obtainMessage.what = 1000;
                            cVar.f7994a = searchBusStation;
                        } catch (AMapException e2) {
                            obtainMessage.what = e2.getErrorCode();
                        }
                    } finally {
                        bh.this.f7164g.sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final void setOnBusStationSearchListener(BusStationSearch.OnBusStationSearchListener onBusStationSearchListener) {
        this.f7159b = onBusStationSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final void setQuery(BusStationQuery busStationQuery) {
        if (busStationQuery.weakEquals(this.f7160c)) {
            return;
        }
        this.f7160c = busStationQuery;
    }

    private void a(BusStationResult busStationResult) {
        int i10;
        this.f7162e = new ArrayList<>();
        int i11 = 0;
        while (true) {
            i10 = this.f7163f;
            if (i11 > i10) {
                break;
            }
            this.f7162e.add(null);
            i11++;
        }
        if (i10 > 0) {
            this.f7162e.set(this.f7160c.getPageNumber(), busStationResult);
        }
    }

    private BusStationResult b(int i10) {
        if (a(i10)) {
            return this.f7162e.get(i10);
        }
        throw new IllegalArgumentException("page out of range");
    }

    private boolean a(int i10) {
        return i10 <= this.f7163f && i10 >= 0;
    }

    private boolean a() {
        BusStationQuery busStationQuery = this.f7160c;
        return (busStationQuery == null || n.a(busStationQuery.getQueryString())) ? false : true;
    }
}
