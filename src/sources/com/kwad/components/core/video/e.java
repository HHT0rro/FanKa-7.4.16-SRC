package com.kwad.components.core.video;

import android.content.Context;
import android.os.Message;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.utils.br;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e extends a implements br.a {
    private View UI;
    private final AtomicBoolean UJ;
    private boolean UK;
    private boolean UL;
    private final KsAdVideoPlayConfig dU;
    private final br hh;

    public e(Context context, AdTemplate adTemplate, @NonNull com.kwad.sdk.core.video.videoview.c cVar, KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        super(context, adTemplate, cVar);
        this.hh = new br(this);
        this.UJ = new AtomicBoolean(true);
        this.UL = true;
        this.UI = this;
        this.dU = ksAdVideoPlayConfig;
    }

    private void ac() {
        if (this.UJ.getAndSet(false)) {
            com.kwad.sdk.core.e.c.i("FeedVideoPlayerController", "onViewAttached");
            this.hh.sendEmptyMessage(1);
        }
    }

    private boolean rJ() {
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.dU;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 1) {
                return ag.isNetworkConnected(((a) this).mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 2) {
                return ag.isWifiConnected(((a) this).mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 3) {
                return false;
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                if (kSAdVideoPlayConfigImpl.isDataFlowAutoStart()) {
                    return ag.isNetworkConnected(((a) this).mContext);
                }
                return ag.isWifiConnected(((a) this).mContext);
            }
        }
        if (com.kwad.sdk.core.response.b.a.bU(this.mAdInfo)) {
            return ag.isNetworkConnected(((a) this).mContext);
        }
        if (com.kwad.sdk.core.response.b.a.bV(this.mAdInfo)) {
            return ag.isWifiConnected(((a) this).mContext);
        }
        return false;
    }

    @Override // com.kwad.sdk.utils.br.a
    public final void a(Message message) {
        if (!this.Tu && message.what == 1) {
            if (bq.o(this.UI, 30)) {
                if (!this.UK) {
                    rn();
                }
            } else {
                rp();
            }
            this.hh.sendEmptyMessageDelayed(1, 500L);
        }
    }

    public final void ad() {
        if (this.UJ.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.e.c.i("FeedVideoPlayerController", "onViewDetached");
        this.hh.removeCallbacksAndMessages(null);
        if (this.UL) {
            release();
        } else {
            this.aBE.pause();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.e.c.i("FeedVideoPlayerController", "onAttachedToWindow");
        ac();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.e.c.i("FeedVideoPlayerController", "onDetachedFromWindow");
        ad();
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.e.c.i("FeedVideoPlayerController", "onFinishTemporaryDetach");
        ac();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.e.c.i("FeedVideoPlayerController", "onStartTemporaryDetach");
        ad();
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
    }

    public final void rI() {
        this.hh.removeCallbacksAndMessages(null);
        if (this.UL) {
            release();
        } else {
            this.aBE.pause();
        }
    }

    public final void rK() {
        this.aBE.pause();
        this.UK = true;
    }

    public final void rL() {
        rn();
        this.UK = false;
    }

    public final void rM() {
        this.UK = false;
    }

    @Override // com.kwad.components.core.video.a
    public final void rn() {
        if (this.aBE.isIdle()) {
            com.kwad.components.core.video.a.a aVar = this.TI;
            if (aVar != null) {
                aVar.onStart();
            }
            if (!ag.isNetworkConnected(((a) this).mContext)) {
                rj();
                return;
            }
            rk();
            if (this.Tu) {
                ro();
                this.aBE.start();
                return;
            } else if (rJ()) {
                ro();
                this.aBE.start();
                return;
            } else if (this.Ts) {
                ro();
                this.aBE.start();
                return;
            } else {
                rl();
                return;
            }
        }
        if (this.aBE.isPaused() || this.aBE.Gj()) {
            ro();
            this.aBE.restart();
        }
    }

    public final void setAutoRelease(boolean z10) {
        this.UL = z10;
    }
}
