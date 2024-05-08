package com.wangmai.common.utils;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.kuaishou.weapon.p0.g;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class LocationUtils {
    public static final String TAG = "LocationUtils";
    public static float accuracy = -1.0f;
    public static double longitude = -1.0d;

    private float getAccuracyWithNetwork(Context context) {
        try {
            if (PermissionUtils.checkPermission(context, g.f36121g) && PermissionUtils.checkPermission(context, g.f36122h)) {
                Location lastKnownLocation = ((LocationManager) context.getSystemService("location")).getLastKnownLocation("network");
                if (lastKnownLocation != null) {
                    return lastKnownLocation.getAccuracy();
                }
            } else {
                DebugLog.W(TAG, "定位失败，权限缺失!");
            }
        } catch (Throwable th) {
            DebugLog.W(TAG, "getAccuracyWithNetwork error:" + th.toString());
        }
        return 0.0f;
    }

    private double getLatWithNetwork(Context context) {
        Location lastKnownLocation;
        try {
            if (PermissionUtils.checkPermission(context, g.f36121g) && PermissionUtils.checkPermission(context, g.f36122h) && (lastKnownLocation = ((LocationManager) context.getSystemService("location")).getLastKnownLocation("network")) != null) {
                return lastKnownLocation.getLatitude();
            }
        } catch (Throwable th) {
            DebugLog.W(TAG, "getLatWithNetwork error:" + th.toString());
        }
        return ShadowDrawableWrapper.COS_45;
    }

    private double getLngWithNetwork(Context context) {
        Location lastKnownLocation;
        double d10 = ShadowDrawableWrapper.COS_45;
        try {
            if (!PermissionUtils.checkPermission(context, g.f36121g) || !PermissionUtils.checkPermission(context, g.f36122h) || (lastKnownLocation = ((LocationManager) context.getSystemService("location")).getLastKnownLocation("network")) == null) {
                return ShadowDrawableWrapper.COS_45;
            }
            d10 = lastKnownLocation.getLatitude();
            longitude = lastKnownLocation.getLongitude();
            accuracy = lastKnownLocation.getAccuracy();
            return d10;
        } catch (Throwable th) {
            DebugLog.W(TAG, "getLngWithNetwork error:" + th.toString());
            return d10;
        }
    }

    public float getAccuracy(Context context) {
        float f10 = accuracy;
        if (f10 > 0.0f) {
            return f10;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (PermissionUtils.checkPermission(context, g.f36121g) && PermissionUtils.checkPermission(context, g.f36122h)) {
                LocationManager locationManager = (LocationManager) context.getSystemService("location");
                if (locationManager.isProviderEnabled(GeocodeSearch.GPS)) {
                    Location lastKnownLocation = locationManager.getLastKnownLocation(GeocodeSearch.GPS);
                    if (lastKnownLocation != null) {
                        accuracy = lastKnownLocation.getAccuracy();
                    } else {
                        return getAccuracyWithNetwork(context);
                    }
                } else {
                    return getAccuracyWithNetwork(context);
                }
            } else {
                DebugLog.W(TAG, "定位失败，权限缺失!");
            }
        } catch (Exception e2) {
            DebugLog.W(TAG, "getAccuracy error:" + e2.toString());
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 10) {
            DebugLog.W(TAG, "采集定位精度耗时：" + currentTimeMillis2 + " ms");
        }
        return accuracy;
    }

    public double getLatitude(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        double d10 = ShadowDrawableWrapper.COS_45;
        try {
            if (PermissionUtils.checkPermission(context, g.f36121g) && PermissionUtils.checkPermission(context, g.f36122h)) {
                LocationManager locationManager = (LocationManager) context.getSystemService("location");
                if (locationManager.isProviderEnabled(GeocodeSearch.GPS)) {
                    Location lastKnownLocation = locationManager.getLastKnownLocation(GeocodeSearch.GPS);
                    if (lastKnownLocation != null) {
                        d10 = lastKnownLocation.getLatitude();
                        longitude = lastKnownLocation.getLongitude();
                        accuracy = lastKnownLocation.getAccuracy();
                    } else {
                        return getLngWithNetwork(context);
                    }
                } else {
                    return getLngWithNetwork(context);
                }
            }
        } catch (Exception e2) {
            DebugLog.W(TAG, "getLatitude error:" + e2.toString());
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 10) {
            DebugLog.W(TAG, "采集定位纬度耗时：" + currentTimeMillis2 + " ms");
        }
        return d10;
    }

    public double getLongitude(Context context) {
        double d10 = longitude;
        if (d10 > ShadowDrawableWrapper.COS_45) {
            return d10;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (PermissionUtils.checkPermission(context, g.f36121g) && PermissionUtils.checkPermission(context, g.f36122h)) {
                LocationManager locationManager = (LocationManager) context.getSystemService("location");
                if (locationManager.isProviderEnabled(GeocodeSearch.GPS)) {
                    Location lastKnownLocation = locationManager.getLastKnownLocation(GeocodeSearch.GPS);
                    if (lastKnownLocation != null) {
                        longitude = lastKnownLocation.getLongitude();
                    } else {
                        return getLatWithNetwork(context);
                    }
                } else {
                    return getLatWithNetwork(context);
                }
            }
        } catch (Exception e2) {
            DebugLog.W(TAG, "getLongitude error:" + e2.toString());
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 10) {
            DebugLog.W(TAG, "采集定位经度耗时：" + currentTimeMillis2 + " ms");
        }
        return longitude;
    }
}
