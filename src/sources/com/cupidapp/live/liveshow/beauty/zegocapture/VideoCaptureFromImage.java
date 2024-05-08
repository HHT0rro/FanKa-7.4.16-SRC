package com.cupidapp.live.liveshow.beauty.zegocapture;

import android.graphics.SurfaceTexture;
import android.view.Choreographer;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.zego.zegoavkit2.ZegoVideoCaptureDevice;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveVideoCaptureFromImage.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class VideoCaptureFromImage extends ZegoVideoCaptureDevice implements Choreographer.FrameCallback, TextureView.SurfaceTextureListener, SurfaceHolder.Callback {

    /* renamed from: b, reason: collision with root package name */
    public boolean f14905b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public SurfaceTexture f14906c;

    public final void a(int i10, int i11, int i12) {
        j.f12332a.a("VideoCaptureTextureData", "displayTex:" + i10 + "   texHeight:" + i12);
        ZegoVideoCaptureDevice.Client fkLiveVideoCaptureClient = FKLiveConstantsData.INSTANCE.getFkLiveVideoCaptureClient();
        if (fkLiveVideoCaptureClient != null) {
            fkLiveVideoCaptureClient.onTextureCaptured(i10, i11, i12, System.currentTimeMillis());
        }
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public void allocateAndStart(@NotNull ZegoVideoCaptureDevice.Client client) {
        s.i(client, "client");
        FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
        fKLiveConstantsData.setFkLiveVideoCaptureClient(client);
        ZegoVideoCaptureDevice.Client fkLiveVideoCaptureClient = fKLiveConstantsData.getFkLiveVideoCaptureClient();
        if (fkLiveVideoCaptureClient != null) {
            fkLiveVideoCaptureClient.setFlipMode(0);
        }
        Choreographer.getInstance().postFrameCallback(this);
    }

    public final void b(int i10) {
        ZegoVideoCaptureDevice.Client fkLiveVideoCaptureClient = FKLiveConstantsData.INSTANCE.getFkLiveVideoCaptureClient();
        if (fkLiveVideoCaptureClient != null) {
            fkLiveVideoCaptureClient.setRotation(i10);
        }
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j10) {
        Choreographer.getInstance().postFrameCallback(this);
        j.f12332a.a("VideoCaptureFromImage", "doFrame frameTimeNanos " + j10);
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public int enableTorch(boolean z10) {
        return 0;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(@NotNull SurfaceTexture surface, int i10, int i11) {
        s.i(surface, "surface");
        j.f12332a.a("VideoCaptureFromImage", "onSurfaceTextureAvailable ");
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(@NotNull SurfaceTexture surface) {
        s.i(surface, "surface");
        j.f12332a.a("VideoCaptureFromImage", "onSurfaceTextureDestroyed ");
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(@NotNull SurfaceTexture surface, int i10, int i11) {
        s.i(surface, "surface");
        j.f12332a.a("VideoCaptureFromImage", "onSurfaceTextureSizeChanged ");
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(@NotNull SurfaceTexture surface) {
        s.i(surface, "surface");
        j.f12332a.a("VideoCaptureFromImage", "onSurfaceTextureUpdated ");
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public int setCaptureRotation(int i10) {
        return 0;
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public int setFrameRate(int i10) {
        return 0;
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public int setFrontCam(int i10) {
        return 0;
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public int setPowerlineFreq(int i10) {
        return 0;
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public int setResolution(int i10, int i11) {
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public int setView(@Nullable View view) {
        if (!(view instanceof SurfaceTexture)) {
            return 0;
        }
        this.f14906c = (SurfaceTexture) view;
        return 0;
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public int setViewMode(int i10) {
        return 0;
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public int setViewRotation(int i10) {
        return 0;
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public int startCapture() {
        return 0;
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public int startPreview() {
        return 0;
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public void stopAndDeAllocate() {
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public int stopCapture() {
        j.f12332a.a("VideoCaptureFromImage", "stopCapture ");
        this.f14905b = false;
        return 0;
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public int stopPreview() {
        j.f12332a.a("VideoCaptureFromImage", "stopPreview ");
        return 0;
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public int supportBufferType() {
        return 8;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(@NotNull SurfaceHolder holder, int i10, int i11, int i12) {
        s.i(holder, "holder");
        j.f12332a.a("VideoCaptureFromImage", "surfaceChanged ");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(@NotNull SurfaceHolder holder) {
        s.i(holder, "holder");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(@NotNull SurfaceHolder holder) {
        s.i(holder, "holder");
        j.f12332a.a("VideoCaptureFromImage", "surfaceDestroyed ");
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public int takeSnapshot() {
        return 0;
    }
}
