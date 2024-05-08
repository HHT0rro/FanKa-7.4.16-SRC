package com.zego.zegoliveroom.entity;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ZegoStreamInfo {
    public String extraInfo;
    public int streamDeleteReason = -1;
    public String streamID;
    public int streamNID;
    public String userID;
    public String userName;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class StreamDeleteReason {
        public static final int deleteHeartBeatTimeOut = 1;
        public static final int deleteKickout = 3;
        public static final int deleteNormal = 0;
        public static final int deleteOffline = 4;
        public static final int deleteRepeatLogin = 2;
        public static final int deleteSever = 100;
        public static final int deleteUnkown = 1000;
        public static final int notSupport = -1;
    }
}
