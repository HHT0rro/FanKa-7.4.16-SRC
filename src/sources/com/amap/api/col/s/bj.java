package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IDistanceSearch;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.DistanceSearch;

/* compiled from: DistanceSearchCore.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class bj implements IDistanceSearch {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7177a = "bj";

    /* renamed from: b, reason: collision with root package name */
    private Context f7178b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f7179c;

    /* renamed from: d, reason: collision with root package name */
    private DistanceSearch.OnDistanceSearchListener f7180d;

    public bj(Context context) throws AMapException {
        cg a10 = cf.a(context, m.a(false));
        if (a10.f7502a == cf.c.SuccessCode) {
            this.f7178b = context.getApplicationContext();
            this.f7179c = y.a();
        } else {
            String str = a10.f7503b;
            throw new AMapException(str, 1, str, a10.f7502a.a());
        }
    }

    @Override // com.amap.api.services.interfaces.IDistanceSearch
    public DistanceResult calculateRouteDistance(DistanceSearch.DistanceQuery distanceQuery) throws AMapException {
        try {
            w.a(this.f7178b);
            if (distanceQuery != null) {
                if (!a(distanceQuery)) {
                    DistanceSearch.DistanceQuery m1981clone = distanceQuery.m1981clone();
                    DistanceResult c4 = new o(this.f7178b, m1981clone).c();
                    if (c4 != null) {
                        c4.setDistanceQuery(m1981clone);
                    }
                    return c4;
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e2) {
            n.a(e2, f7177a, "calculateWalkRoute");
            throw e2;
        }
    }

    @Override // com.amap.api.services.interfaces.IDistanceSearch
    public void calculateRouteDistanceAsyn(final DistanceSearch.DistanceQuery distanceQuery) {
        ax.a().a(new Runnable() { // from class: com.amap.api.col.s.bj.1
            @Override // java.lang.Runnable
            public final void run() {
                Message obtainMessage = y.a().obtainMessage();
                obtainMessage.what = 400;
                obtainMessage.arg1 = 16;
                Bundle bundle = new Bundle();
                DistanceResult distanceResult = null;
                try {
                    try {
                        distanceResult = bj.this.calculateRouteDistance(distanceQuery);
                        bundle.putInt("errorCode", 1000);
                    } catch (AMapException e2) {
                        bundle.putInt("errorCode", e2.getErrorCode());
                    }
                } finally {
                    obtainMessage.obj = bj.this.f7180d;
                    bundle.putParcelable("result", distanceResult);
                    obtainMessage.setData(bundle);
                    bj.this.f7179c.sendMessage(obtainMessage);
                }
            }
        });
    }

    @Override // com.amap.api.services.interfaces.IDistanceSearch
    public void setDistanceSearchListener(DistanceSearch.OnDistanceSearchListener onDistanceSearchListener) {
        this.f7180d = onDistanceSearchListener;
    }

    private static boolean a(DistanceSearch.DistanceQuery distanceQuery) {
        return distanceQuery.getDestination() == null || distanceQuery.getOrigins() == null || distanceQuery.getOrigins().size() <= 0;
    }
}
