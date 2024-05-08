package com.autonavi.aps.amapapi.restruct;

import android.net.wifi.WifiInfo;

/* compiled from: SystemApiWrapper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class h {
    public static String a(WifiInfo wifiInfo) {
        if (wifiInfo == null) {
            return null;
        }
        return wifiInfo.getBSSID();
    }

    public static String b(WifiInfo wifiInfo) {
        if (wifiInfo == null) {
            return null;
        }
        return wifiInfo.getSSID();
    }

    public static int c(WifiInfo wifiInfo) {
        if (wifiInfo == null) {
            return -1;
        }
        return wifiInfo.getRssi();
    }
}
