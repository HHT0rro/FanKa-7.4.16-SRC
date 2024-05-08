package com.danlan.android.cognition.collector.util;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import com.danlan.android.cognition.StringFog;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class LocationUtil {
    private static boolean error_flag;
    private static Location location;
    private static PermissionUtil permissionUtils;

    private static Location getGpsLocation(LocationManager locationManager) {
        try {
            if (!permissionUtils.isPermissionGranted(StringFog.decrypt("QE1AUU5KQA9RRlZOSFBXSE5NCmJiYGFycnxiam9me21uYGV3aGxq"))) {
                return null;
            }
            Location lastKnownLocation = locationManager.getLastKnownLocation(StringFog.decrypt("RlNX"));
            if (lastKnownLocation == null) {
                error_flag = true;
            }
            return lastKnownLocation;
        } catch (Exception e2) {
            e2.printStackTrace();
            error_flag = true;
            return null;
        }
    }

    public static Location getLocation(Context context) {
        if (permissionUtils == null) {
            permissionUtils = new PermissionUtil(context);
        }
        if (error_flag || location != null || context == null) {
            return location;
        }
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService(StringFog.decrypt("TUxHQlVKS08="));
            if (locationManager.isProviderEnabled(StringFog.decrypt("RlNX"))) {
                location = getGpsLocation(locationManager);
            }
            if (location == null && locationManager.isProviderEnabled(StringFog.decrypt("T0ZQVE5RTw=="))) {
                location = getNetworkLocation(locationManager);
            }
            if (location == null && locationManager.isProviderEnabled(StringFog.decrypt("UUJXUEhVQQ=="))) {
                location = getPassiveLocation(locationManager);
            }
            return location;
        } catch (Exception unused) {
            error_flag = true;
            return null;
        }
    }

    private static Location getNetworkLocation(LocationManager locationManager) {
        try {
            if (!permissionUtils.isPermissionGranted(StringFog.decrypt("QE1AUU5KQA9RRlZOSFBXSE5NCmJiYGFycnxiam9me21uYGV3aGxq")) && !permissionUtils.isPermissionGranted(StringFog.decrypt("QE1AUU5KQA9RRlZOSFBXSE5NCmJiYGFycnxnbGBxd2R+b2tgYHdtbm8="))) {
                return null;
            }
            Location lastKnownLocation = locationManager.getLastKnownLocation(StringFog.decrypt("T0ZQVE5RTw=="));
            if (lastKnownLocation == null) {
                error_flag = true;
            }
            return lastKnownLocation;
        } catch (Exception e2) {
            e2.printStackTrace();
            error_flag = true;
            return null;
        }
    }

    private static Location getPassiveLocation(LocationManager locationManager) {
        try {
            if (!permissionUtils.isPermissionGranted(StringFog.decrypt("QE1AUU5KQA9RRlZOSFBXSE5NCmJiYGFycnxnbGBxd2R+b2tgYHdtbm8="))) {
                return null;
            }
            Location lastKnownLocation = locationManager.getLastKnownLocation(StringFog.decrypt("UUJXUEhVQQ=="));
            if (lastKnownLocation == null) {
                error_flag = true;
            }
            return lastKnownLocation;
        } catch (Exception e2) {
            e2.printStackTrace();
            error_flag = true;
            return null;
        }
    }
}
