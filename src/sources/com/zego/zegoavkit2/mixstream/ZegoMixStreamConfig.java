package com.zego.zegoavkit2.mixstream;

import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ZegoMixStreamConfig {
    public String advancedConfig;
    public ZegoMixStreamInfo[] inputStreamList;
    public int outputAudioBitrate;
    public String outputBackgroundImage;
    public int outputFps;
    public int outputHeight;
    public ZegoMixStreamOutput[] outputList;
    public int outputWidth;
    public ByteBuffer userData;
    public ZegoMixStreamWatermark watermark;
    public ZegoMixStreamWhiteboard whiteboard;
    public int outputRateControlMode = 0;

    @Deprecated
    public int outputBitrate = 0;
    public int outputQuality = 23;
    public int outputAudioConfig = 0;
    public int lenOfUserData = 0;
    public int channels = 1;
    public int outputBackgroundColor = 0;
    public boolean withSoundLevel = false;
    public int audioMixMode = 0;
    public int extra = 0;
    public boolean singleStreamPassThrough = false;
    public boolean streamAlignment = false;
    public int streamAlignmentType = 0;
    public int minPlayStreamBufferLength = -1;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class RateControlMode {
        public static final int CBR = 0;
        public static final int CRF = 1;

        public RateControlMode() {
        }
    }
}
