package com.amap.api.services.interfaces;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.route.BusRouteResultV2;
import com.amap.api.services.route.DriveRouteResultV2;
import com.amap.api.services.route.RideRouteResultV2;
import com.amap.api.services.route.RouteSearchV2;
import com.amap.api.services.route.WalkRouteResultV2;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface IRouteSearchV2 {
    BusRouteResultV2 calculateBusRoute(RouteSearchV2.BusRouteQuery busRouteQuery) throws AMapException;

    void calculateBusRouteAsyn(RouteSearchV2.BusRouteQuery busRouteQuery);

    DriveRouteResultV2 calculateDriveRoute(RouteSearchV2.DriveRouteQuery driveRouteQuery) throws AMapException;

    void calculateDriveRouteAsyn(RouteSearchV2.DriveRouteQuery driveRouteQuery);

    RideRouteResultV2 calculateRideRoute(RouteSearchV2.RideRouteQuery rideRouteQuery) throws AMapException;

    void calculateRideRouteAsyn(RouteSearchV2.RideRouteQuery rideRouteQuery);

    WalkRouteResultV2 calculateWalkRoute(RouteSearchV2.WalkRouteQuery walkRouteQuery) throws AMapException;

    void calculateWalkRouteAsyn(RouteSearchV2.WalkRouteQuery walkRouteQuery);

    void setRouteSearchListener(RouteSearchV2.OnRouteSearchListener onRouteSearchListener);
}
