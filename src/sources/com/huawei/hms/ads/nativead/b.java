package com.huawei.hms.ads.nativead;

import android.view.View;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.hms.ads.VideoOperator;
import com.huawei.hms.ads.bt;
import com.huawei.openalliance.ad.inter.data.g;
import com.huawei.openalliance.ad.inter.data.n;
import com.huawei.openalliance.ad.inter.data.v;
import com.huawei.openalliance.ad.views.NativeVideoView;
import com.huawei.openalliance.ad.views.NativeWindowImageView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b {
    private v B;
    private g C;
    private NativeVideoView Code;
    private NativeAdConfiguration I;
    private NativeAd S;
    private NativeWindowImageView V;
    private VideoConfiguration Z;

    public b(NativeVideoView nativeVideoView, NativeWindowImageView nativeWindowImageView) {
        this.Code = nativeVideoView;
        this.V = nativeWindowImageView;
    }

    private void Code(g gVar) {
        View view;
        if (gVar == null) {
            return;
        }
        this.C = gVar;
        this.B = gVar.B();
        g gVar2 = this.C;
        if (gVar2 instanceof n) {
            NativeAdConfiguration ad2 = ((n) gVar2).ad();
            this.I = ad2;
            if (ad2 != null) {
                this.Z = ad2.getVideoConfiguration();
            }
        }
        if (S()) {
            this.Code.setVisibility(8);
            view = this.V;
        } else {
            this.V.setVisibility(8);
            view = this.Code;
        }
        view.setVisibility(0);
    }

    private boolean S() {
        return this.C.a() == 13 || this.C.a() == 113;
    }

    public View B() {
        if (this.C == null) {
            return null;
        }
        return S() ? this.V : this.Code;
    }

    public void Code(final VideoOperator.VideoLifecycleListener videoLifecycleListener) {
        this.Code.setVideoEventListener(new NativeVideoView.a() { // from class: com.huawei.hms.ads.nativead.b.1
            public boolean Code = true;

            @Override // com.huawei.openalliance.ad.views.NativeVideoView.a
            public void Code() {
                if (this.Code) {
                    videoLifecycleListener.onVideoStart();
                    this.Code = false;
                }
                videoLifecycleListener.onVideoPlay();
            }

            @Override // com.huawei.openalliance.ad.views.NativeVideoView.a
            public void Code(boolean z10) {
                videoLifecycleListener.onVideoMute(z10);
            }

            @Override // com.huawei.openalliance.ad.views.NativeVideoView.a
            public void Code(boolean z10, int i10) {
            }

            @Override // com.huawei.openalliance.ad.views.NativeVideoView.a
            public void I() {
                this.Code = true;
                videoLifecycleListener.onVideoEnd();
            }

            @Override // com.huawei.openalliance.ad.views.NativeVideoView.a
            public void V() {
                videoLifecycleListener.onVideoPause();
            }

            @Override // com.huawei.openalliance.ad.views.NativeVideoView.a
            public void V(boolean z10, int i10) {
            }

            @Override // com.huawei.openalliance.ad.views.NativeVideoView.a
            public void Z() {
            }
        });
    }

    public void Code(NativeAd nativeAd) {
        this.S = nativeAd;
        if (nativeAd instanceof bt) {
            Code(((bt) nativeAd).Code());
        }
    }

    public NativeVideoView I() {
        return this.Code;
    }
}
