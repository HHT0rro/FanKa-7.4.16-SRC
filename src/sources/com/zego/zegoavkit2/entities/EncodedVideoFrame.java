package com.zego.zegoavkit2.entities;

import com.zego.zegoavkit2.enums.VideoCodecType;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class EncodedVideoFrame {
    public VideoCodecType codecType;
    public ByteBuffer data;
    public boolean isKeyFrame;
    public double reference_time_ms;
    public int rotation;
}
