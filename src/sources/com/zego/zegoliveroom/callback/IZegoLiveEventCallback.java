package com.zego.zegoliveroom.callback;

import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface IZegoLiveEventCallback {
    public static final int Play_AudioBreak = 9;
    public static final int Play_AudioBreakCancel = 14;
    public static final int Play_AudioBreakEnd = 10;
    public static final int Play_BeginRetry = 1;
    public static final int Play_RetrySuccess = 2;
    public static final int Play_TempDisconnected = 5;
    public static final int Play_VideoBreak = 7;
    public static final int Play_VideoBreakCancel = 13;
    public static final int Play_VideoBreakEnd = 8;
    public static final int PublishInfo_RegisterFailed = 11;
    public static final int PublishInfo_RegisterSuccess = 12;
    public static final int Publish_BeginRetry = 3;
    public static final int Publish_RetrySuccess = 4;
    public static final int Publish_TempDisconnected = 6;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class StreamEvent {
        public static final int PlayEnd = 206;
        public static final int PlayFail = 202;
        public static final int PlayStart = 200;
        public static final int PlaySuccess = 201;
        public static final int PublishEnd = 106;
        public static final int PublishFail = 102;
        public static final int PublishStart = 100;
        public static final int PublishSuccess = 101;
        public static final int RetryPlayFail = 205;
        public static final int RetryPlayStart = 203;
        public static final int RetryPlaySuccess = 204;
        public static final int RetryPublishFail = 105;
        public static final int RetryPublishStart = 103;
        public static final int RetryPublishSuccess = 104;
    }

    void onLiveEvent(int i10, HashMap<String, String> hashMap);

    void onStreamEvent(int i10, String str, HashMap<String, String> hashMap);
}
