package com.zego.zegoavkit2.networktime;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ZegoNetworkTime {
    public static ZegoNetworkTimeInfo getNetworkTimeInfo() {
        ZegoNetworkTimeInfo zegoNetworkTimeInfo = new ZegoNetworkTimeInfo();
        ZegoNetworkTimeJNI.getNetworkTimeInfo(zegoNetworkTimeInfo);
        return zegoNetworkTimeInfo;
    }

    public static void setNetworkTimeCallback(IZegoNetworkTimeCallback iZegoNetworkTimeCallback) {
        ZegoNetworkTimeJNI.setNetworkTimeCallback(iZegoNetworkTimeCallback);
    }
}
