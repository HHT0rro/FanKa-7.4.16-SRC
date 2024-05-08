package com.alibaba.security.realidentity.bean;

import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class NetWorkInfo implements Serializable {
    private boolean connected;
    private String networkState;
    private String operator;
    private boolean wifiProxy;

    public String getNetworkState() {
        return this.networkState;
    }

    public String getOperator() {
        return this.operator;
    }

    public boolean isConnected() {
        return this.connected;
    }

    public boolean isWifiProxy() {
        return this.wifiProxy;
    }

    public void setConnected(boolean z10) {
        this.connected = z10;
    }

    public void setNetworkState(String str) {
        this.networkState = str;
    }

    public void setOperator(String str) {
        this.operator = str;
    }

    public void setWifiProxy(boolean z10) {
        this.wifiProxy = z10;
    }
}
