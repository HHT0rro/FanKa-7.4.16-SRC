package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IRouteSearch;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DriveRoutePlanResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.TruckRouteRestult;
import com.amap.api.services.route.WalkRouteResult;

/* compiled from: RouteSearchCore.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class br implements IRouteSearch {

    /* renamed from: a, reason: collision with root package name */
    private RouteSearch.OnRouteSearchListener f7252a;

    /* renamed from: b, reason: collision with root package name */
    private RouteSearch.OnTruckRouteSearchListener f7253b;

    /* renamed from: c, reason: collision with root package name */
    private RouteSearch.OnRoutePlanSearchListener f7254c;

    /* renamed from: d, reason: collision with root package name */
    private Context f7255d;

    /* renamed from: e, reason: collision with root package name */
    private Handler f7256e;

    public br(Context context) throws AMapException {
        cg a10 = cf.a(context, m.a(false));
        if (a10.f7502a == cf.c.SuccessCode) {
            this.f7255d = context.getApplicationContext();
            this.f7256e = y.a();
        } else {
            String str = a10.f7503b;
            throw new AMapException(str, 1, str, a10.f7502a.a());
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final BusRouteResult calculateBusRoute(RouteSearch.BusRouteQuery busRouteQuery) throws AMapException {
        try {
            w.a(this.f7255d);
            if (busRouteQuery != null) {
                if (a(busRouteQuery.getFromAndTo())) {
                    RouteSearch.BusRouteQuery m1982clone = busRouteQuery.m1982clone();
                    BusRouteResult c4 = new g(this.f7255d, m1982clone).c();
                    if (c4 != null) {
                        c4.setBusQuery(m1982clone);
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

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateBusRouteAsyn(final RouteSearch.BusRouteQuery busRouteQuery) {
        try {
            ax.a().a(new Runnable() { // from class: com.amap.api.col.s.br.2
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = y.a().obtainMessage();
                    obtainMessage.what = 100;
                    obtainMessage.arg1 = 1;
                    Bundle bundle = new Bundle();
                    BusRouteResult busRouteResult = null;
                    try {
                        try {
                            busRouteResult = br.this.calculateBusRoute(busRouteQuery);
                            bundle.putInt("errorCode", 1000);
                        } catch (AMapException e2) {
                            bundle.putInt("errorCode", e2.getErrorCode());
                        }
                    } finally {
                        obtainMessage.obj = br.this.f7252a;
                        bundle.putParcelable("result", busRouteResult);
                        obtainMessage.setData(bundle);
                        br.this.f7256e.sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            n.a(th, "RouteSearch", "calculateBusRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final DriveRoutePlanResult calculateDrivePlan(RouteSearch.DrivePlanQuery drivePlanQuery) throws AMapException {
        try {
            w.a(this.f7255d);
            if (drivePlanQuery != null) {
                if (a(drivePlanQuery.getFromAndTo())) {
                    DriveRoutePlanResult c4 = new q(this.f7255d, drivePlanQuery.m1983clone()).c();
                    if (c4 != null) {
                        c4.setDrivePlanQuery(drivePlanQuery);
                    }
                    return c4;
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e2) {
            n.a(e2, "RouteSearch", "calculateDrivePlan");
            throw e2;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateDrivePlanAsyn(final RouteSearch.DrivePlanQuery drivePlanQuery) {
        try {
            ax.a().a(new Runnable() { // from class: com.amap.api.col.s.br.6
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = y.a().obtainMessage();
                    obtainMessage.what = 105;
                    obtainMessage.arg1 = 18;
                    Bundle bundle = new Bundle();
                    DriveRoutePlanResult driveRoutePlanResult = null;
                    try {
                        try {
                            driveRoutePlanResult = br.this.calculateDrivePlan(drivePlanQuery);
                            bundle.putInt("errorCode", 1000);
                        } catch (AMapException e2) {
                            bundle.putInt("errorCode", e2.getErrorCode());
                        }
                    } finally {
                        obtainMessage.obj = br.this.f7254c;
                        bundle.putParcelable("result", driveRoutePlanResult);
                        obtainMessage.setData(bundle);
                        br.this.f7256e.sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            n.a(th, "RouteSearch", "calculateTruckRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final DriveRouteResult calculateDriveRoute(RouteSearch.DriveRouteQuery driveRouteQuery) throws AMapException {
        try {
            w.a(this.f7255d);
            if (driveRouteQuery != null) {
                if (a(driveRouteQuery.getFromAndTo())) {
                    ap.a().a(driveRouteQuery.getPassedByPoints());
                    ap.a().c(driveRouteQuery.getAvoidpolygons());
                    RouteSearch.DriveRouteQuery m1984clone = driveRouteQuery.m1984clone();
                    DriveRouteResult c4 = new r(this.f7255d, m1984clone).c();
                    if (c4 != null) {
                        c4.setDriveQuery(m1984clone);
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

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateDriveRouteAsyn(final RouteSearch.DriveRouteQuery driveRouteQuery) {
        try {
            ax.a().a(new Runnable() { // from class: com.amap.api.col.s.br.3
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = y.a().obtainMessage();
                    obtainMessage.what = 101;
                    obtainMessage.arg1 = 1;
                    Bundle bundle = new Bundle();
                    DriveRouteResult driveRouteResult = null;
                    try {
                        try {
                            driveRouteResult = br.this.calculateDriveRoute(driveRouteQuery);
                            bundle.putInt("errorCode", 1000);
                        } catch (AMapException e2) {
                            bundle.putInt("errorCode", e2.getErrorCode());
                        }
                    } finally {
                        obtainMessage.obj = br.this.f7252a;
                        bundle.putParcelable("result", driveRouteResult);
                        obtainMessage.setData(bundle);
                        br.this.f7256e.sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            n.a(th, "RouteSearch", "calculateDriveRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final RideRouteResult calculateRideRoute(RouteSearch.RideRouteQuery rideRouteQuery) throws AMapException {
        try {
            w.a(this.f7255d);
            if (rideRouteQuery != null) {
                if (a(rideRouteQuery.getFromAndTo())) {
                    ap.a().a(rideRouteQuery.getFromAndTo());
                    RouteSearch.RideRouteQuery m1986clone = rideRouteQuery.m1986clone();
                    RideRouteResult c4 = new ar(this.f7255d, m1986clone).c();
                    if (c4 != null) {
                        c4.setRideQuery(m1986clone);
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

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateRideRouteAsyn(final RouteSearch.RideRouteQuery rideRouteQuery) {
        try {
            ax.a().a(new Runnable() { // from class: com.amap.api.col.s.br.4
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = y.a().obtainMessage();
                    obtainMessage.what = 103;
                    obtainMessage.arg1 = 1;
                    Bundle bundle = new Bundle();
                    RideRouteResult rideRouteResult = null;
                    try {
                        try {
                            rideRouteResult = br.this.calculateRideRoute(rideRouteQuery);
                            bundle.putInt("errorCode", 1000);
                        } catch (AMapException e2) {
                            bundle.putInt("errorCode", e2.getErrorCode());
                        }
                    } finally {
                        obtainMessage.obj = br.this.f7252a;
                        bundle.putParcelable("result", rideRouteResult);
                        obtainMessage.setData(bundle);
                        br.this.f7256e.sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            n.a(th, "RouteSearch", "calculateRideRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final TruckRouteRestult calculateTruckRoute(RouteSearch.TruckRouteQuery truckRouteQuery) throws AMapException {
        try {
            w.a(this.f7255d);
            if (truckRouteQuery != null) {
                if (a(truckRouteQuery.getFromAndTo())) {
                    ap.a().a(truckRouteQuery.getFromAndTo(), truckRouteQuery.getPassedByPoints());
                    ap.a();
                    ap.b(truckRouteQuery.getPassedByPoints());
                    RouteSearch.TruckRouteQuery m1987clone = truckRouteQuery.m1987clone();
                    TruckRouteRestult c4 = new ay(this.f7255d, m1987clone).c();
                    if (c4 != null) {
                        c4.setTruckQuery(m1987clone);
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

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateTruckRouteAsyn(final RouteSearch.TruckRouteQuery truckRouteQuery) {
        try {
            ax.a().a(new Runnable() { // from class: com.amap.api.col.s.br.5
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = y.a().obtainMessage();
                    obtainMessage.what = 104;
                    obtainMessage.arg1 = 17;
                    Bundle bundle = new Bundle();
                    TruckRouteRestult truckRouteRestult = null;
                    try {
                        try {
                            truckRouteRestult = br.this.calculateTruckRoute(truckRouteQuery);
                            bundle.putInt("errorCode", 1000);
                        } catch (AMapException e2) {
                            bundle.putInt("errorCode", e2.getErrorCode());
                        }
                    } finally {
                        obtainMessage.obj = br.this.f7253b;
                        bundle.putParcelable("result", truckRouteRestult);
                        obtainMessage.setData(bundle);
                        br.this.f7256e.sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            n.a(th, "RouteSearch", "calculateTruckRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final WalkRouteResult calculateWalkRoute(RouteSearch.WalkRouteQuery walkRouteQuery) throws AMapException {
        try {
            w.a(this.f7255d);
            if (walkRouteQuery != null) {
                if (a(walkRouteQuery.getFromAndTo())) {
                    ap.a().b(walkRouteQuery.getFromAndTo());
                    RouteSearch.WalkRouteQuery m1988clone = walkRouteQuery.m1988clone();
                    WalkRouteResult c4 = new az(this.f7255d, m1988clone).c();
                    if (c4 != null) {
                        c4.setWalkQuery(m1988clone);
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

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateWalkRouteAsyn(final RouteSearch.WalkRouteQuery walkRouteQuery) {
        try {
            ax.a().a(new Runnable() { // from class: com.amap.api.col.s.br.1
                @Override // java.lang.Runnable
                public final void run() {
                    Message obtainMessage = y.a().obtainMessage();
                    obtainMessage.what = 102;
                    obtainMessage.arg1 = 1;
                    Bundle bundle = new Bundle();
                    WalkRouteResult walkRouteResult = null;
                    try {
                        try {
                            walkRouteResult = br.this.calculateWalkRoute(walkRouteQuery);
                            bundle.putInt("errorCode", 1000);
                        } catch (AMapException e2) {
                            bundle.putInt("errorCode", e2.getErrorCode());
                        }
                    } finally {
                        obtainMessage.obj = br.this.f7252a;
                        bundle.putParcelable("result", walkRouteResult);
                        obtainMessage.setData(bundle);
                        br.this.f7256e.sendMessage(obtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            n.a(th, "RouteSearch", "calculateWalkRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void setOnRoutePlanSearchListener(RouteSearch.OnRoutePlanSearchListener onRoutePlanSearchListener) {
        this.f7254c = onRoutePlanSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void setOnTruckRouteSearchListener(RouteSearch.OnTruckRouteSearchListener onTruckRouteSearchListener) {
        this.f7253b = onTruckRouteSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void setRouteSearchListener(RouteSearch.OnRouteSearchListener onRouteSearchListener) {
        this.f7252a = onRouteSearchListener;
    }

    private static boolean a(RouteSearch.FromAndTo fromAndTo) {
        return (fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) ? false : true;
    }
}
