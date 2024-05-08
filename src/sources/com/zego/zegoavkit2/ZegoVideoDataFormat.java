package com.zego.zegoavkit2;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ZegoVideoDataFormat {
    public static final int PIXEL_FORMAT_ABGR32 = 7;
    public static final int PIXEL_FORMAT_ARGB32 = 6;
    public static final int PIXEL_FORMAT_BGRA32 = 4;
    public static final int PIXEL_FORMAT_I420 = 1;
    public static final int PIXEL_FORMAT_NV12 = 2;
    public static final int PIXEL_FORMAT_NV21 = 3;
    public static final int PIXEL_FORMAT_RGBA32 = 5;
    public static final int PIXEL_FORMAT_UNKNOWN = 0;
    public int width = 0;
    public int height = 0;
    public int[] strides = {0, 0, 0, 0};
    public int rotation = 0;
    public long pts = 0;
    public int pixel_format = 0;
}
