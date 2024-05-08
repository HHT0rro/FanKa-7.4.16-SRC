package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.col.s.y;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IWeatherSearch;
import com.amap.api.services.weather.LocalWeatherForecastResult;
import com.amap.api.services.weather.LocalWeatherLiveResult;
import com.amap.api.services.weather.WeatherSearch;
import com.amap.api.services.weather.WeatherSearchQuery;
import com.android.internal.logging.nano.MetricsProto;

/* compiled from: WeatherSearchCore.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class bu implements IWeatherSearch {

    /* renamed from: a, reason: collision with root package name */
    private Context f7299a;

    /* renamed from: b, reason: collision with root package name */
    private WeatherSearchQuery f7300b;

    /* renamed from: c, reason: collision with root package name */
    private WeatherSearch.OnWeatherSearchListener f7301c;

    /* renamed from: d, reason: collision with root package name */
    private LocalWeatherLiveResult f7302d;

    /* renamed from: e, reason: collision with root package name */
    private LocalWeatherForecastResult f7303e;

    /* renamed from: f, reason: collision with root package name */
    private Handler f7304f;

    public bu(Context context) throws AMapException {
        this.f7304f = null;
        cg a10 = cf.a(context, m.a(false));
        if (a10.f7502a == cf.c.SuccessCode) {
            this.f7299a = context.getApplicationContext();
            this.f7304f = y.a();
        } else {
            String str = a10.f7503b;
            throw new AMapException(str, 1, str, a10.f7502a.a());
        }
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public final WeatherSearchQuery getQuery() {
        return this.f7300b;
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public final void searchWeatherAsyn() {
        try {
            ax.a().a(new Runnable() { // from class: com.amap.api.col.s.bu.1
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = y.a().obtainMessage();
                    obtainMessage.arg1 = 13;
                    Bundle bundle = new Bundle();
                    if (bu.this.f7300b != null) {
                        if (bu.this.f7300b.getType() != 1) {
                            if (bu.this.f7300b.getType() == 2) {
                                try {
                                    try {
                                        bu buVar = bu.this;
                                        buVar.f7303e = buVar.b();
                                        bundle.putInt("errorCode", 1000);
                                        return;
                                    } catch (AMapException e2) {
                                        bundle.putInt("errorCode", e2.getErrorCode());
                                        n.a(e2, "WeatherSearch", "searchWeatherAsyn");
                                        return;
                                    } catch (Throwable th) {
                                        n.a(th, "WeatherSearch", "searchWeatherAnsyThrowable");
                                        return;
                                    }
                                } finally {
                                    y.n nVar = new y.n();
                                    obtainMessage.what = MetricsProto.MetricsEvent.BATTERY_SAVER;
                                    nVar.f8017b = bu.this.f7301c;
                                    nVar.f8016a = bu.this.f7303e;
                                    obtainMessage.obj = nVar;
                                    obtainMessage.setData(bundle);
                                    bu.this.f7304f.sendMessage(obtainMessage);
                                }
                            }
                            return;
                        }
                        try {
                            try {
                                bu buVar2 = bu.this;
                                buVar2.f7302d = buVar2.a();
                                bundle.putInt("errorCode", 1000);
                                return;
                            } catch (AMapException e10) {
                                bundle.putInt("errorCode", e10.getErrorCode());
                                n.a(e10, "WeatherSearch", "searchWeatherAsyn");
                                return;
                            } catch (Throwable th2) {
                                n.a(th2, "WeatherSearch", "searchWeatherAnsyThrowable");
                                return;
                            }
                        } finally {
                            y.o oVar = new y.o();
                            obtainMessage.what = MetricsProto.MetricsEvent.DIALOG_TV_NETWORK_PROXY;
                            oVar.f8019b = bu.this.f7301c;
                            oVar.f8018a = bu.this.f7302d;
                            obtainMessage.obj = oVar;
                            obtainMessage.setData(bundle);
                            bu.this.f7304f.sendMessage(obtainMessage);
                        }
                    }
                    try {
                        throw new AMapException("无效的参数 - IllegalArgumentException");
                    } catch (AMapException e11) {
                        n.a(e11, "WeatherSearch", "searchWeatherAsyn");
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public final void setOnWeatherSearchListener(WeatherSearch.OnWeatherSearchListener onWeatherSearchListener) {
        this.f7301c = onWeatherSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public final void setQuery(WeatherSearchQuery weatherSearchQuery) {
        this.f7300b = weatherSearchQuery;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LocalWeatherForecastResult b() throws AMapException {
        w.a(this.f7299a);
        WeatherSearchQuery weatherSearchQuery = this.f7300b;
        if (weatherSearchQuery != null) {
            bb bbVar = new bb(this.f7299a, weatherSearchQuery);
            return LocalWeatherForecastResult.createPagedResult((WeatherSearchQuery) bbVar.c_(), bbVar.c());
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LocalWeatherLiveResult a() throws AMapException {
        w.a(this.f7299a);
        WeatherSearchQuery weatherSearchQuery = this.f7300b;
        if (weatherSearchQuery != null) {
            bc bcVar = new bc(this.f7299a, weatherSearchQuery);
            return LocalWeatherLiveResult.createPagedResult((WeatherSearchQuery) bcVar.c_(), bcVar.c());
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }
}
