package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearch;
import com.amap.api.services.district.DistrictSearchQuery;
import com.amap.api.services.interfaces.IDistrictSearch;
import java.util.HashMap;

/* compiled from: DistrictSearchCore.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class bk implements IDistrictSearch {

    /* renamed from: f, reason: collision with root package name */
    private static HashMap<Integer, DistrictResult> f7183f;

    /* renamed from: a, reason: collision with root package name */
    private Context f7184a;

    /* renamed from: b, reason: collision with root package name */
    private DistrictSearchQuery f7185b;

    /* renamed from: c, reason: collision with root package name */
    private DistrictSearch.OnDistrictSearchListener f7186c;

    /* renamed from: d, reason: collision with root package name */
    private DistrictSearchQuery f7187d;

    /* renamed from: e, reason: collision with root package name */
    private int f7188e;

    /* renamed from: g, reason: collision with root package name */
    private Handler f7189g;

    public bk(Context context) throws AMapException {
        cg a10 = cf.a(context, m.a(false));
        if (a10.f7502a == cf.c.SuccessCode) {
            this.f7184a = context.getApplicationContext();
            this.f7189g = y.a();
        } else {
            String str = a10.f7503b;
            throw new AMapException(str, 1, str, a10.f7502a.a());
        }
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final DistrictSearchQuery getQuery() {
        return this.f7185b;
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final DistrictResult searchDistrict() throws AMapException {
        DistrictResult a10;
        int i10;
        try {
            DistrictResult districtResult = new DistrictResult();
            w.a(this.f7184a);
            if (!a()) {
                this.f7185b = new DistrictSearchQuery();
            }
            districtResult.setQuery(this.f7185b.m1976clone());
            if (!this.f7185b.weakEquals(this.f7187d)) {
                this.f7188e = 0;
                this.f7187d = this.f7185b.m1976clone();
                HashMap<Integer, DistrictResult> hashMap = f7183f;
                if (hashMap != null) {
                    hashMap.clear();
                }
            }
            if (this.f7188e == 0) {
                a10 = new p(this.f7184a, this.f7185b.m1976clone()).c();
                if (a10 == null) {
                    return a10;
                }
                this.f7188e = a10.getPageCount();
                a(a10);
            } else {
                a10 = a(this.f7185b.getPageNum());
                if (a10 == null) {
                    a10 = new p(this.f7184a, this.f7185b.m1976clone()).c();
                    DistrictSearchQuery districtSearchQuery = this.f7185b;
                    if (districtSearchQuery != null && a10 != null && (i10 = this.f7188e) > 0 && i10 > districtSearchQuery.getPageNum()) {
                        f7183f.put(Integer.valueOf(this.f7185b.getPageNum()), a10);
                    }
                }
            }
            return a10;
        } catch (AMapException e2) {
            n.a(e2, "DistrictSearch", "searchDistrict");
            throw e2;
        }
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final void searchDistrictAnsy() {
        searchDistrictAsyn();
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final void searchDistrictAsyn() {
        try {
            ax.a().a(new Runnable() { // from class: com.amap.api.col.s.bk.1
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = y.a().obtainMessage();
                    DistrictResult districtResult = new DistrictResult();
                    districtResult.setQuery(bk.this.f7185b);
                    try {
                        try {
                            districtResult = bk.this.searchDistrict();
                            if (districtResult != null) {
                                districtResult.setAMapException(new AMapException());
                            }
                        } catch (AMapException e2) {
                            districtResult.setAMapException(e2);
                            obtainMessage.arg1 = 4;
                            obtainMessage.obj = bk.this.f7186c;
                            Bundle bundle = new Bundle();
                            bundle.putParcelable("result", districtResult);
                            obtainMessage.setData(bundle);
                            if (bk.this.f7189g != null) {
                                bk.this.f7189g.sendMessage(obtainMessage);
                            }
                        } catch (Throwable th) {
                            n.a(th, "DistrictSearch", "searchDistrictAnsyThrowable");
                            obtainMessage.arg1 = 4;
                            obtainMessage.obj = bk.this.f7186c;
                            Bundle bundle2 = new Bundle();
                            bundle2.putParcelable("result", districtResult);
                            obtainMessage.setData(bundle2);
                            if (bk.this.f7189g != null) {
                                bk.this.f7189g.sendMessage(obtainMessage);
                            }
                        }
                    } finally {
                        obtainMessage.arg1 = 4;
                        obtainMessage.obj = bk.this.f7186c;
                        Bundle bundle3 = new Bundle();
                        bundle3.putParcelable("result", districtResult);
                        obtainMessage.setData(bundle3);
                        if (bk.this.f7189g != null) {
                            bk.this.f7189g.sendMessage(obtainMessage);
                        }
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final void setOnDistrictSearchListener(DistrictSearch.OnDistrictSearchListener onDistrictSearchListener) {
        this.f7186c = onDistrictSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final void setQuery(DistrictSearchQuery districtSearchQuery) {
        this.f7185b = districtSearchQuery;
    }

    private void a(DistrictResult districtResult) {
        int i10;
        f7183f = new HashMap<>();
        DistrictSearchQuery districtSearchQuery = this.f7185b;
        if (districtSearchQuery == null || districtResult == null || (i10 = this.f7188e) <= 0 || i10 <= districtSearchQuery.getPageNum()) {
            return;
        }
        f7183f.put(Integer.valueOf(this.f7185b.getPageNum()), districtResult);
    }

    private boolean b(int i10) {
        return i10 < this.f7188e && i10 >= 0;
    }

    private boolean a() {
        return this.f7185b != null;
    }

    private DistrictResult a(int i10) throws AMapException {
        if (b(i10)) {
            return f7183f.get(Integer.valueOf(i10));
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }
}
