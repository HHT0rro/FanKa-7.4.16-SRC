package com.alimm.tanx.core.net.constant;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public enum NetWorkType {
    NETWORK_NO(-1, "NET_NONE"),
    NETWORK_UNKNOWN(0, "NET_UNKNOWN"),
    NETWORK_2G(2, "2G"),
    NETWORK_3G(3, "3G"),
    NETWORK_4G(4, "4G"),
    NETWORK_WIFI(1, "WIFI");

    public final int key;
    public final String msg;

    NetWorkType(int i10, String str) {
        this.key = i10;
        this.msg = str;
    }

    public int getKey() {
        return this.key;
    }

    public String getMsg() {
        return this.msg;
    }
}
