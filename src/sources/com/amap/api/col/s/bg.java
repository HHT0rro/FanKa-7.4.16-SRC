package com.amap.api.col.s;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.col.s.y;
import com.amap.api.services.busline.BusLineQuery;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusLineSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusLineSearch;
import java.util.ArrayList;

/* compiled from: BusLineSearchCore.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class bg implements IBusLineSearch {

    /* renamed from: a, reason: collision with root package name */
    private Context f7150a;

    /* renamed from: b, reason: collision with root package name */
    private BusLineSearch.OnBusLineSearchListener f7151b;

    /* renamed from: c, reason: collision with root package name */
    private BusLineQuery f7152c;

    /* renamed from: d, reason: collision with root package name */
    private BusLineQuery f7153d;

    /* renamed from: e, reason: collision with root package name */
    private int f7154e;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<BusLineResult> f7155f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    private Handler f7156g;

    public bg(Context context, BusLineQuery busLineQuery) throws AMapException {
        this.f7156g = null;
        cg a10 = cf.a(context, m.a(false));
        if (a10.f7502a == cf.c.SuccessCode) {
            this.f7150a = context.getApplicationContext();
            this.f7152c = busLineQuery;
            if (busLineQuery != null) {
                this.f7153d = busLineQuery.m1972clone();
            }
            this.f7156g = y.a();
            return;
        }
        String str = a10.f7503b;
        throw new AMapException(str, 1, str, a10.f7502a.a());
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final BusLineQuery getQuery() {
        return this.f7152c;
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final BusLineResult searchBusLine() throws AMapException {
        try {
            w.a(this.f7150a);
            if (this.f7153d != null && a()) {
                if (!this.f7152c.weakEquals(this.f7153d)) {
                    this.f7153d = this.f7152c.m1972clone();
                    this.f7154e = 0;
                    ArrayList<BusLineResult> arrayList = this.f7155f;
                    if (arrayList != null) {
                        arrayList.clear();
                    }
                }
                if (this.f7154e == 0) {
                    BusLineResult busLineResult = (BusLineResult) new i(this.f7150a, this.f7152c.m1972clone()).c();
                    a(busLineResult);
                    return busLineResult;
                }
                BusLineResult b4 = b(this.f7152c.getPageNumber());
                if (b4 != null) {
                    return b4;
                }
                BusLineResult busLineResult2 = (BusLineResult) new i(this.f7150a, this.f7152c).c();
                this.f7155f.set(this.f7152c.getPageNumber(), busLineResult2);
                return busLineResult2;
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e2) {
            n.a(e2, "BusLineSearch", "searchBusLine");
            throw new AMapException(e2.getErrorMessage());
        }
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final void searchBusLineAsyn() {
        try {
            ax.a().a(new Runnable() { // from class: com.amap.api.col.s.bg.1
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = y.a().obtainMessage();
                    try {
                        try {
                            obtainMessage.arg1 = 3;
                            obtainMessage.what = 1000;
                            y.b bVar = new y.b();
                            obtainMessage.obj = bVar;
                            bVar.f7993b = bg.this.f7151b;
                            bVar.f7992a = bg.this.searchBusLine();
                        } catch (AMapException e2) {
                            obtainMessage.what = e2.getErrorCode();
                        }
                    } finally {
                        bg.this.f7156g.sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final void setOnBusLineSearchListener(BusLineSearch.OnBusLineSearchListener onBusLineSearchListener) {
        this.f7151b = onBusLineSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final void setQuery(BusLineQuery busLineQuery) {
        if (this.f7152c.weakEquals(busLineQuery)) {
            return;
        }
        this.f7152c = busLineQuery;
        this.f7153d = busLineQuery.m1972clone();
    }

    private void a(BusLineResult busLineResult) {
        int i10;
        this.f7155f = new ArrayList<>();
        int i11 = 0;
        while (true) {
            i10 = this.f7154e;
            if (i11 >= i10) {
                break;
            }
            this.f7155f.add(null);
            i11++;
        }
        if (i10 < 0 || !a(this.f7152c.getPageNumber())) {
            return;
        }
        this.f7155f.set(this.f7152c.getPageNumber(), busLineResult);
    }

    private BusLineResult b(int i10) {
        if (a(i10)) {
            return this.f7155f.get(i10);
        }
        throw new IllegalArgumentException("page out of range");
    }

    private boolean a(int i10) {
        return i10 < this.f7154e && i10 >= 0;
    }

    private boolean a() {
        BusLineQuery busLineQuery = this.f7152c;
        return (busLineQuery == null || n.a(busLineQuery.getQueryString())) ? false : true;
    }
}
