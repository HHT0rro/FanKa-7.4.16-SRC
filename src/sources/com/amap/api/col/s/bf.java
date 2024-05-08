package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.col.s.y;
import com.amap.api.services.auto.AutoTChargeStationResult;
import com.amap.api.services.auto.AutoTSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IAutoTSearch;

/* compiled from: AutoTSearchCore.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class bf implements IAutoTSearch {

    /* renamed from: a, reason: collision with root package name */
    private Context f7145a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f7146b;

    /* renamed from: c, reason: collision with root package name */
    private AutoTSearch.Query f7147c;

    /* renamed from: d, reason: collision with root package name */
    private AutoTSearch.OnChargeStationListener f7148d;

    public bf(Context context) throws AMapException {
        this.f7146b = null;
        cg a10 = cf.a(context, m.a(false));
        if (a10.f7502a == cf.c.SuccessCode) {
            this.f7145a = context.getApplicationContext();
            this.f7146b = y.a();
        } else {
            String str = a10.f7503b;
            throw new AMapException(str, 1, str, a10.f7502a.a());
        }
    }

    @Override // com.amap.api.services.interfaces.IAutoTSearch
    public final AutoTChargeStationResult searchChargeStation() throws AMapException {
        try {
            w.a(this.f7145a);
            AutoTSearch.Query query = this.f7147c;
            if (query != null) {
                return new b(this.f7145a, query.m1971clone()).c();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e2) {
            throw new AMapException(e2.getMessage());
        }
    }

    @Override // com.amap.api.services.interfaces.IAutoTSearch
    public final void searchChargeStationAsync() {
        try {
            ax.a().a(new Runnable() { // from class: com.amap.api.col.s.bf.1
                @Override // java.lang.Runnable
                public final void run() {
                    y.a aVar;
                    Message obtainMessage = bf.this.f7146b.obtainMessage();
                    obtainMessage.arg1 = 20;
                    obtainMessage.what = 600;
                    Bundle bundle = new Bundle();
                    AutoTChargeStationResult autoTChargeStationResult = null;
                    try {
                        try {
                            autoTChargeStationResult = bf.this.searchChargeStation();
                            bundle.putInt("errorCode", 1000);
                            aVar = new y.a();
                        } catch (AMapException e2) {
                            bundle.putInt("errorCode", e2.getErrorCode());
                            aVar = new y.a();
                        }
                        aVar.f7991b = bf.this.f7148d;
                        aVar.f7990a = autoTChargeStationResult;
                        obtainMessage.obj = aVar;
                        obtainMessage.setData(bundle);
                        bf.this.f7146b.sendMessage(obtainMessage);
                    } catch (Throwable th) {
                        y.a aVar2 = new y.a();
                        aVar2.f7991b = bf.this.f7148d;
                        aVar2.f7990a = autoTChargeStationResult;
                        obtainMessage.obj = aVar2;
                        obtainMessage.setData(bundle);
                        bf.this.f7146b.sendMessage(obtainMessage);
                        throw th;
                    }
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IAutoTSearch
    public final void setChargeStationListener(AutoTSearch.OnChargeStationListener onChargeStationListener) {
        this.f7148d = onChargeStationListener;
    }

    @Override // com.amap.api.services.interfaces.IAutoTSearch
    public final void setQuery(AutoTSearch.Query query) {
        this.f7147c = query;
    }
}
