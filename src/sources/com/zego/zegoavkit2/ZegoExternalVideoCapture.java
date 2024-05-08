package com.zego.zegoavkit2;

import com.zego.zegoavkit2.videocapture.ZegoTrafficControlCallback;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ZegoExternalVideoCapture {
    public static native boolean setTrafficControlCallback(ZegoTrafficControlCallback zegoTrafficControlCallback, int i10);

    public static native boolean setVideoCaptureFactory(ZegoVideoCaptureFactory zegoVideoCaptureFactory, int i10);
}
