package com.amap.api.maps.model;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class NaviPara {

    @Deprecated
    public static final int DRIVING_AVOID_CONGESTION = 4;

    @Deprecated
    public static final int DRIVING_DEFAULT = 0;

    @Deprecated
    public static final int DRIVING_NO_HIGHWAY = 3;

    @Deprecated
    public static final int DRIVING_NO_HIGHWAY_AVOID_CONGESTION = 6;

    @Deprecated
    public static final int DRIVING_NO_HIGHWAY_AVOID_SHORT_MONEY = 5;

    @Deprecated
    public static final int DRIVING_NO_HIGHWAY_SAVE_MONEY_AVOID_CONGESTION = 8;

    @Deprecated
    public static final int DRIVING_SAVE_MONEY = 1;

    @Deprecated
    public static final int DRIVING_SAVE_MONEY_AVOID_CONGESTION = 7;

    @Deprecated
    public static final int DRIVING_SHORT_DISTANCE = 2;
    private LatLng latLng;
    private int naviStyle = 0;

    public int getNaviStyle() {
        return this.naviStyle;
    }

    public LatLng getTargetPoint() {
        return this.latLng;
    }

    public void setNaviStyle(int i10) {
        if (i10 < 0 || i10 >= 9) {
            return;
        }
        this.naviStyle = i10;
    }

    public void setTargetPoint(LatLng latLng) {
        this.latLng = latLng;
    }
}
