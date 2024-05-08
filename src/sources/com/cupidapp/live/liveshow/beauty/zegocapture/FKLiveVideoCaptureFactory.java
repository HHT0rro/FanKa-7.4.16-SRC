package com.cupidapp.live.liveshow.beauty.zegocapture;

import com.zego.zegoavkit2.ZegoVideoCaptureDevice;
import com.zego.zegoavkit2.ZegoVideoCaptureFactory;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKLiveVideoCaptureFactory.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveVideoCaptureFactory extends ZegoVideoCaptureFactory {
    @Override // com.zego.zegoavkit2.ZegoVideoCaptureFactory
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public VideoCaptureFromImage create(@NotNull String device_id) {
        s.i(device_id, "device_id");
        return new VideoCaptureFromImage();
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureFactory
    public void destroy(@NotNull ZegoVideoCaptureDevice vc2) {
        s.i(vc2, "vc");
    }
}
