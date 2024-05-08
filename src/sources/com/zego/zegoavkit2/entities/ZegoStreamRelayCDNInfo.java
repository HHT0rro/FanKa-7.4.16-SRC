package com.zego.zegoavkit2.entities;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ZegoStreamRelayCDNInfo {
    public int detail;
    public String rtmpURL;
    public int state;
    public int stateTime;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Detail {
        public static final int ACCESS_POINT_ERROR = 10;
        public static final int BAD_NAME = 12;
        public static final int CDN_SERVER_DISCONNECTED = 13;
        public static final int CREATE_STREAM_FAILED = 11;
        public static final int DISCONNECTED = 14;
        public static final int HAND_SHAKE_FAILED = 9;
        public static final int MIXSTREAM_ALL_INPUT_STREAM_CLOSED = 1214;
        public static final int MIXSTREAM_ALL_INPUT_STREAM_NODATA = 1215;
        public static final int MIXSTREAM_SERVER_INTERNAL_ERROR = 1230;
        public static final int NONE = 0;
        public static final int SERVER_ERROR = 8;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class State {
        public static final int RETRY = 2;
        public static final int START = 1;
        public static final int STOP = 0;
    }
}
