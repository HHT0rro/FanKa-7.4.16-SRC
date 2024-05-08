package com.wangmai.appsdkdex;

import com.wangmai.common.utils.WMLocation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class WMCustomPrivateController {
    public String getDevImei() {
        return null;
    }

    public String getDevMacAddress() {
        return null;
    }

    public String getDevOaid() {
        return null;
    }

    public WMLocation getLocation() {
        return null;
    }

    public boolean isCanUseAppList() {
        return true;
    }

    public boolean isCanUseLocation() {
        return true;
    }

    public boolean isCanUseNetworkState() {
        return true;
    }

    public boolean isCanUseOaid() {
        return true;
    }

    public boolean isCanUsePermissionRecordAudio() {
        return true;
    }

    public boolean isCanUsePhoneState() {
        return true;
    }

    public boolean isCanUseWifiState() {
        return true;
    }

    public boolean isCanUseWriteExternal() {
        return true;
    }
}
