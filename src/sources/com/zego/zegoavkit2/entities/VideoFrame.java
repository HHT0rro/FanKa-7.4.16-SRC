package com.zego.zegoavkit2.entities;

import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class VideoFrame {
    public int height;
    public int width;
    public ByteBuffer[] byteBuffers = new ByteBuffer[4];
    public int[] strides = new int[4];
}
