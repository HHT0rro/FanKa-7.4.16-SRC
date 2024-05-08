package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IRouteSearchV2;
import com.amap.api.services.route.BusRouteResultV2;
import com.amap.api.services.route.DriveRouteResultV2;
import com.amap.api.services.route.RideRouteResultV2;
import com.amap.api.services.route.RouteSearchV2;
import com.amap.api.services.route.WalkRouteResultV2;

/* compiled from: RouteSearchCoreV2.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class bs implements IRouteSearchV2 {

    /* renamed from: a, reason: collision with root package name */
    private RouteSearchV2.OnRouteSearchListener f7269a;

    /* renamed from: b, reason: collision with root package name */
    private Context f7270b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f7271c;

    public bs(Context context) throws AMapException {
        cg a10 = cf.a(context, m.a(false));
        if (a10.f7502a == cf.c.SuccessCode) {
            this.f7270b = context.getApplicationContext();
            this.f7271c = y.a();
        } else {
            String str = a10.f7503b;
            throw new AMapException(str, 1, str, a10.f7502a.a());
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final BusRouteResultV2 calculateBusRoute(RouteSearchV2.BusRouteQuery busRouteQuery) throws AMapException {
        try {
            w.a(this.f7270b);
            if (busRouteQuery != null) {
                if (a(busRouteQuery.getFromAndTo())) {
                    RouteSearchV2.BusRouteQuery m1989clone = busRouteQuery.m1989clone();
                    BusRouteResultV2 c4 = new h(this.f7270b, m1989clone).c();
                    if (c4 != null) {
                        c4.setBusQuery(m1989clone);
                    }
                    return c4;
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e2) {
            n.a(e2, "RouteSearch", "calculateBusRoute");
            throw e2;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final void calculateBusRouteAsyn(final RouteSearchV2.BusRouteQuery busRouteQuery) {
        try {
            ax.a().a(new Runnable() { // from class: com.amap.api.col.s.bs.4
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = y.a().obtainMessage();
                    obtainMessage.what = 100;
                    obtainMessage.arg1 = 101;
                    Bundle bundle = new Bundle();
                    BusRouteResultV2 busRouteResultV2 = null;
                    try {
                        try {
                            busRouteResultV2 = bs.this.calculateBusRoute(busRouteQuery);
                            bundle.putInt("errorCode", 1000);
                        } catch (AMapException e2) {
                            bundle.putInt("errorCode", e2.getErrorCode());
                        }
                    } finally {
                        obtainMessage.obj = bs.this.f7269a;
                        bundle.putParcelable("result", busRouteResultV2);
                        obtainMessage.setData(bundle);
                        bs.this.f7271c.sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            n.a(th, "RouteSearch", "calculateBusRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final DriveRouteResultV2 calculateDriveRoute(RouteSearchV2.DriveRouteQuery driveRouteQuery) throws AMapException {
        try {
            w.a(this.f7270b);
            if (driveRouteQuery != null) {
                if (a(driveRouteQuery.getFromAndTo())) {
                    ap.a();
                    ap.b(driveRouteQuery.getPassedByPoints());
                    ap.a().c(driveRouteQuery.getAvoidpolygons());
                    RouteSearchV2.DriveRouteQuery m1990clone = driveRouteQuery.m1990clone();
                    DriveRouteResultV2 c4 = new s(this.f7270b, m1990clone).c();
                    if (c4 != null) {
                        c4.setDriveQuery(m1990clone);
                    }
                    return c4;
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e2) {
            n.a(e2, "RouteSearch", "calculateDriveRoute");
            throw e2;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final void calculateDriveRouteAsyn(final RouteSearchV2.DriveRouteQuery driveRouteQuery) {
        try {
            ax.a().a(new Runnable() { // from class: com.amap.api.col.s.bs.1
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = y.a().obtainMessage();
                    obtainMessage.what = 101;
                    obtainMessage.arg1 = 101;
                    Bundle bundle = new Bundle();
                    DriveRouteResultV2 driveRouteResultV2 = null;
                    try {
                        try {
                            driveRouteResultV2 = bs.this.calculateDriveRoute(driveRouteQuery);
                            bundle.putInt("errorCode", 1000);
                        } catch (AMapException e2) {
                            bundle.putInt("errorCode", e2.getErrorCode());
                        }
                    } finally {
                        obtainMessage.obj = bs.this.f7269a;
                        bundle.putParcelable("result", driveRouteResultV2);
                        obtainMessage.setData(bundle);
                        bs.this.f7271c.sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            n.a(th, "RouteSearch", "calculateDriveRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final RideRouteResultV2 calculateRideRoute(RouteSearchV2.RideRouteQuery rideRouteQuery) throws AMapException {
        try {
            w.a(this.f7270b);
            if (rideRouteQuery != null) {
                if (a(rideRouteQuery.getFromAndTo())) {
                    ap.a().a(rideRouteQuery.getFromAndTo());
                    RouteSearchV2.RideRouteQuery m1992clone = rideRouteQuery.m1992clone();
                    RideRouteResultV2 c4 = new as(this.f7270b, m1992clone).c();
                    if (c4 != null) {
                        c4.setRideQuery(m1992clone);
                    }
                    return c4;
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e2) {
            n.a(e2, "RouteSearch", "calculaterideRoute");
            throw e2;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final void calculateRideRouteAsyn(final RouteSearchV2.RideRouteQuery rideRouteQuery) {
        try {
            ax.a().a(new Runnable() { // from class: com.amap.api.col.s.bs.3
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = y.a().obtainMessage();
                    obtainMessage.what = 103;
                    obtainMessage.arg1 = 101;
                    Bundle bundle = new Bundle();
                    RideRouteResultV2 rideRouteResultV2 = null;
                    try {
                        try {
                            rideRouteResultV2 = bs.this.calculateRideRoute(rideRouteQuery);
                            bundle.putInt("errorCode", 1000);
                        } catch (AMapException e2) {
                            bundle.putInt("errorCode", e2.getErrorCode());
                        }
                    } finally {
                        obtainMessage.obj = bs.this.f7269a;
                        bundle.putParcelable("result", rideRouteResultV2);
                        obtainMessage.setData(bundle);
                        bs.this.f7271c.sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            n.a(th, "RouteSearch", "calculateRideRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final WalkRouteResultV2 calculateWalkRoute(RouteSearchV2.WalkRouteQuery walkRouteQuery) throws AMapException {
        try {
            w.a(this.f7270b);
            if (walkRouteQuery != null) {
                if (a(walkRouteQuery.getFromAndTo())) {
                    ap.a().b(walkRouteQuery.getFromAndTo());
                    RouteSearchV2.WalkRouteQuery m1993clone = walkRouteQuery.m1993clone();
                    WalkRouteResultV2 c4 = new ba(this.f7270b, m1993clone).c();
                    if (c4 != null) {
                        c4.setWalkQuery(m1993clone);
                    }
                    return c4;
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e2) {
            n.a(e2, "RouteSearch", "calculateWalkRoute");
            throw e2;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final void calculateWalkRouteAsyn(final RouteSearchV2.WalkRouteQuery walkRouteQuery) {
        try {
            ax.a().a(new Runnable() { // from class: com.amap.api.col.s.bs.2
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = y.a().obtainMessage();
                    obtainMessage.what = 102;
                    obtainMessage.arg1 = 101;
                    Bundle bundle = new Bundle();
                    WalkRouteResultV2 walkRouteResultV2 = null;
                    try {
                        try {
                            walkRouteResultV2 = bs.this.calculateWalkRoute(walkRouteQuery);
                            bundle.putInt("errorCode", 1000);
                        } catch (AMapException e2) {
                            bundle.putInt("errorCode", e2.getErrorCode());
                        }
                    } finally {
                        obtainMessage.obj = bs.this.f7269a;
                        bundle.putParcelable("result", walkRouteResultV2);
                        obtainMessage.setData(bundle);
                        bs.this.f7271c.sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            n.a(th, "RouteSearch", "calculateWalkRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final void setRouteSearchListener(RouteSearchV2.OnRouteSearchListener onRouteSearchListener) {
        this.f7269a = onRouteSearchListener;
    }

    private static boolean a(RouteSearchV2.FromAndTo fromAndTo) {
        return (fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) ? false : true;
    }
}
