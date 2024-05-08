package com.tencent.trtc;

import java.util.ArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class TRTCStatistics {
    public int appCpu;
    public int downLoss;
    public int gatewayRtt;
    public ArrayList<TRTCLocalStatistics> localArray;
    public long receiveBytes;
    public ArrayList<TRTCRemoteStatistics> remoteArray;
    public int rtt;
    public long sendBytes;
    public int systemCpu;
    public int upLoss;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TRTCLocalStatistics {
        public int audioBitrate;
        public int audioCaptureState;
        public int audioSampleRate;
        public int frameRate;
        public int height;
        public int streamType;
        public int videoBitrate;
        public int width;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class TRTCRemoteStatistics {
        public int audioBitrate;
        public int audioBlockRate;
        public int audioPacketLoss;
        public int audioSampleRate;
        public int audioTotalBlockTime;
        public int finalLoss;
        public int frameRate;
        public int height;
        public int jitterBufferDelay;
        public int point2PointDelay;
        public int remoteNetworkRTT;
        public int remoteNetworkUplinkLoss;
        public int streamType;
        public String userId;
        public int videoBitrate;
        public int videoBlockRate;
        public int videoPacketLoss;
        public int videoTotalBlockTime;
        public int width;
    }
}
