package com.huawei.hms.ads.nativead;

import com.huawei.hms.ads.VideoOperator;
import com.huawei.hms.ads.bu;
import com.huawei.openalliance.ad.views.NativeVideoView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c implements VideoOperator {
    private boolean B;
    private VideoOperator.VideoLifecycleListener Code;
    private bu I;
    private b V;
    private MediaView Z;

    public c(bu buVar) {
        this.B = false;
        this.I = buVar;
        if (buVar != null) {
            this.B = buVar.Z();
        }
    }

    public MediaContent Code() {
        NativeVideoView I;
        b bVar = this.V;
        if (bVar == null || (I = bVar.I()) == null) {
            return null;
        }
        return I.getMediaContent();
    }

    public final void Code(MediaView mediaView) {
        this.Z = mediaView;
        this.V = mediaView.getMediaViewAdapter();
        VideoOperator.VideoLifecycleListener videoLifecycleListener = this.Code;
        if (videoLifecycleListener != null) {
            setVideoLifecycleListener(videoLifecycleListener);
        }
    }

    @Override // com.huawei.hms.ads.VideoOperator
    public float getAspectRatio() {
        bu buVar = this.I;
        if (buVar != null) {
            return buVar.I();
        }
        return 0.0f;
    }

    @Override // com.huawei.hms.ads.VideoOperator
    public VideoOperator.VideoLifecycleListener getVideoLifecycleListener() {
        return this.Code;
    }

    @Override // com.huawei.hms.ads.VideoOperator
    public boolean hasVideo() {
        bu buVar = this.I;
        return buVar != null && buVar.Code();
    }

    @Override // com.huawei.hms.ads.VideoOperator
    public boolean isClickToFullScreenEnabled() {
        return false;
    }

    @Override // com.huawei.hms.ads.VideoOperator
    public boolean isCustomizeOperateEnabled() {
        return this.B;
    }

    @Override // com.huawei.hms.ads.VideoOperator
    public boolean isMuted() {
        bu buVar = this.I;
        return buVar != null && buVar.V();
    }

    @Override // com.huawei.hms.ads.VideoOperator
    public void mute(boolean z10) {
        b bVar = this.V;
        if (bVar == null || !this.B) {
            return;
        }
        if (z10) {
            bVar.I().C();
        } else {
            bVar.I().F();
        }
    }

    @Override // com.huawei.hms.ads.VideoOperator
    public void pause() {
        b bVar;
        if (!this.B || (bVar = this.V) == null) {
            return;
        }
        bVar.I().L();
    }

    @Override // com.huawei.hms.ads.VideoOperator
    public void play() {
        b bVar;
        if (!this.B || (bVar = this.V) == null) {
            return;
        }
        bVar.I().D();
    }

    @Override // com.huawei.hms.ads.VideoOperator
    public final void setVideoLifecycleListener(VideoOperator.VideoLifecycleListener videoLifecycleListener) {
        this.Code = videoLifecycleListener;
        b bVar = this.V;
        if (bVar != null) {
            bVar.Code(videoLifecycleListener);
        }
    }

    @Override // com.huawei.hms.ads.VideoOperator
    public void stop() {
        b bVar;
        if (!this.B || (bVar = this.V) == null) {
            return;
        }
        bVar.I().S();
    }
}
