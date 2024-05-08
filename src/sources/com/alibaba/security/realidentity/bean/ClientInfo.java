package com.alibaba.security.realidentity.bean;

import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ClientInfo implements Serializable {
    private AppInfo appInfo;
    private String clientType;
    private DeviceInfo deviceInfo;
    private NetWorkInfo netWorkInfo;

    public AppInfo getAppInfo() {
        return this.appInfo;
    }

    public String getClientType() {
        return this.clientType;
    }

    public DeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    public NetWorkInfo getNetWorkInfo() {
        return this.netWorkInfo;
    }

    public void setAppInfo(AppInfo appInfo) {
        this.appInfo = appInfo;
    }

    public void setClientType(String str) {
        this.clientType = str;
    }

    public void setDeviceInfo(DeviceInfo deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public void setNetWorkInfo(NetWorkInfo netWorkInfo) {
        this.netWorkInfo = netWorkInfo;
    }
}
