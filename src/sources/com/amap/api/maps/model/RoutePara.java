package com.amap.api.maps.model;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class RoutePara {
    private String endName;
    private LatLng endPoint;
    private String startName;
    private LatLng startPoint;
    private int drivingRouteStyle = 0;
    private int transitRouteStyle = 0;

    public int getDrivingRouteStyle() {
        return this.drivingRouteStyle;
    }

    public String getEndName() {
        return this.endName;
    }

    public LatLng getEndPoint() {
        return this.endPoint;
    }

    public String getStartName() {
        return this.startName;
    }

    public LatLng getStartPoint() {
        return this.startPoint;
    }

    public int getTransitRouteStyle() {
        return this.transitRouteStyle;
    }

    public void setDrivingRouteStyle(int i10) {
        if (i10 < 0 || i10 >= 9) {
            return;
        }
        this.drivingRouteStyle = i10;
    }

    public void setEndName(String str) {
        this.endName = str;
    }

    public void setEndPoint(LatLng latLng) {
        this.endPoint = latLng;
    }

    public void setStartName(String str) {
        this.startName = str;
    }

    public void setStartPoint(LatLng latLng) {
        this.startPoint = latLng;
    }

    public void setTransitRouteStyle(int i10) {
        if (i10 < 0 || i10 >= 6) {
            return;
        }
        this.transitRouteStyle = i10;
    }
}
