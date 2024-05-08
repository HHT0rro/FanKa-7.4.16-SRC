package com.kwad.components.core.video;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.kwad.components.core.video.f;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bl;
import com.kwad.sdk.widget.KSRelativeLayout;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a extends com.kwad.sdk.core.video.videoview.b implements View.OnClickListener {
    private boolean TA;
    private LinearLayout TB;
    private LinearLayout TC;
    private ImageView TD;
    private ViewGroup TE;
    private TextView TF;
    private c TG;
    private InterfaceC0479a TH;
    public com.kwad.components.core.video.a.a TI;
    private final com.kwad.sdk.core.download.a.a TJ;
    public boolean Ts;
    private boolean Tt;
    public boolean Tu;
    private int Tv;
    private int Tw;
    private KSRelativeLayout Tx;
    private RelativeLayout Ty;
    private boolean Tz;
    public AdInfo mAdInfo;

    @NonNull
    public AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    public Context mContext;
    public ImageView mS;
    public TextView mT;
    private ProgressBar nm;
    private boolean np;
    private ImageView zS;
    private TextView zT;

    /* renamed from: com.kwad.components.core.video.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface InterfaceC0479a {
        void a(int i10, ac.a aVar);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface b extends c {
        void onVideoPlayError(int i10, int i11);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface c {
        void bl();

        void bm();

        void e(long j10);

        void onVideoPlayStart();
    }

    public a(Context context, @NonNull AdTemplate adTemplate, @NonNull com.kwad.sdk.core.video.videoview.c cVar) {
        super(context, cVar);
        this.Tt = true;
        this.Tu = false;
        this.TA = false;
        this.TJ = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.video.a.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                a.this.TF.setText(com.kwad.sdk.core.response.b.a.aE(a.this.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                a.this.TF.setText(com.kwad.sdk.core.response.b.a.bY(a.this.mAdTemplate));
            }

            @Override // com.kwad.sdk.core.download.a.a, com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadStarted() {
                a.this.TF.setText(com.kwad.sdk.core.response.b.a.dm(0));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                a aVar = a.this;
                aVar.aD(com.kwad.sdk.core.response.b.a.aE(aVar.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                a.this.TF.setText(com.kwad.sdk.core.response.b.a.ac(a.this.mAdInfo));
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i10) {
                a.this.TF.setText(com.kwad.sdk.core.response.b.a.Fg());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i10) {
                a.this.TF.setText(com.kwad.sdk.core.response.b.a.dm(i10));
            }
        };
        this.mContext = context;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        init();
    }

    private void aL(int i10) {
        try {
            InterfaceC0479a interfaceC0479a = this.TH;
            if (interfaceC0479a != null) {
                interfaceC0479a.a(i10, this.Tx.getTouchCoords());
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void init() {
        com.kwad.sdk.n.l.inflate(this.mContext, R.layout.ksad_feed_video_palyer_controller, this);
        this.Tx = (KSRelativeLayout) findViewById(R.id.ksad_video_root_container);
        this.Ty = (RelativeLayout) findViewById(R.id.ksad_data_flow_container);
        this.mT = (TextView) findViewById(R.id.ksad_data_flow_play_tip);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_data_flow_play_btn);
        this.mS = imageView;
        imageView.setOnClickListener(this);
        this.TB = (LinearLayout) findViewById(R.id.ksad_video_network_unavailable);
        this.TC = (LinearLayout) findViewById(R.id.ksad_video_error_container);
        this.nm = (ProgressBar) findViewById(R.id.ksad_video_progress);
        this.TD = (ImageView) findViewById(R.id.ksad_video_thumb_image);
        String url = com.kwad.sdk.core.response.b.a.br(this.mAdInfo).getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.TD.setImageDrawable(null);
            KSImageLoader.loadImage(this.TD, url, this.mAdTemplate);
            this.TD.setVisibility(0);
        } else {
            this.TD.setVisibility(8);
        }
        this.mT.setText(bl.ab(com.kwad.sdk.core.response.b.a.L(this.mAdInfo) * 1000));
        this.TI = com.kwad.components.core.video.a.d.ay(this.mAdTemplate);
        rh();
    }

    private void ri() {
        ViewGroup viewGroup = this.TE;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    private void rm() {
        this.Ty.setVisibility(8);
    }

    private void setTopBottomVisible(boolean z10) {
        if (this.TA) {
            return;
        }
        this.nm.setVisibility(z10 ? 0 : 8);
        this.Tz = z10;
    }

    public final void aD(String str) {
        ((TextView) findViewById(R.id.ksad_app_download)).setText(str);
    }

    public final void aO(boolean z10) {
        if (this.TA) {
            return;
        }
        if (z10) {
            if (this.Tz) {
                this.nm.setVisibility(0);
                return;
            }
            return;
        }
        this.nm.setVisibility(8);
    }

    public void ex() {
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ksad_video_complete_app_container);
            this.zS = (ImageView) findViewById(R.id.ksad_video_complete_app_icon);
            this.zT = (TextView) findViewById(R.id.ksad_app_name);
            this.TF = (TextView) findViewById(R.id.ksad_app_download);
            KSImageLoader.loadAppIcon(this.zS, com.kwad.sdk.core.response.b.e.dV(this.mAdTemplate), this.mAdTemplate, 12);
            this.zT.setText(com.kwad.sdk.core.response.b.a.cc(this.mAdInfo));
            this.TF.setText(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo));
            this.TE = linearLayout;
            this.zS.setOnClickListener(this);
            this.zT.setOnClickListener(this);
            this.TF.setOnClickListener(this);
            com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate);
            this.mApkDownloadHelper = cVar;
            cVar.b(this.TJ);
        } else {
            LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.ksad_video_complete_h5_container);
            TextView textView = (TextView) findViewById(R.id.ksad_h5_open);
            this.TF = textView;
            textView.setText(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo));
            this.TF.setOnClickListener(this);
            this.TE = linearLayout2;
        }
        this.TE.setOnClickListener(this);
        this.TE.setVisibility(0);
    }

    public AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void n(int i10, int i11) {
        this.Tw = i11;
        this.Tv = i10;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mS) {
            this.Ts = true;
            this.Tt = true;
            rn();
        } else {
            if (view == this.zS) {
                aL(1);
                return;
            }
            if (view == this.zT) {
                aL(2);
            } else if (view == this.TF) {
                aL(3);
            } else {
                aL(4);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void onPlayStateChanged(int i10) {
        com.kwad.components.core.video.a.a aVar;
        com.kwad.sdk.core.e.c.d("AdVideoPlayerController", "onPlayStateChanged playState=" + i10);
        if (i10 == -1) {
            rx();
            setTopBottomVisible(false);
            this.TB.setVisibility(8);
            this.TC.setVisibility(0);
            c cVar = this.TG;
            if (cVar instanceof f.a) {
                ((f.a) cVar).onVideoPlayError(this.Tv, this.Tw);
            }
            c cVar2 = this.TG;
            if (cVar2 instanceof b) {
                ((b) cVar2).onVideoPlayError(this.Tv, this.Tw);
            }
            com.kwad.components.core.o.a.qi().c(this.mAdTemplate, this.Tv, this.Tw);
            com.kwad.components.core.video.a.a aVar2 = this.TI;
            if (aVar2 != null) {
                aVar2.onMediaPlayError(this.Tv, this.Tw);
                return;
            }
            return;
        }
        if (i10 == 9) {
            c cVar3 = this.TG;
            if (cVar3 != null) {
                cVar3.bm();
            }
            rx();
            this.mAdTemplate.setmCurPlayTime(-1L);
            setTopBottomVisible(false);
            KSImageLoader.loadImage(this.TD, com.kwad.sdk.core.response.b.a.X(this.mAdInfo), this.mAdTemplate);
            this.TD.setVisibility(0);
            ex();
            com.kwad.components.core.video.a.a aVar3 = this.TI;
            if (aVar3 != null) {
                aVar3.onMediaPlayCompleted();
                return;
            }
            return;
        }
        if (i10 == 1) {
            rm();
            this.TB.setVisibility(8);
            this.TC.setVisibility(8);
            this.nm.setVisibility(8);
            ri();
            return;
        }
        if (i10 == 2) {
            c cVar4 = this.TG;
            if (cVar4 != null) {
                cVar4.onVideoPlayStart();
            }
            com.kwad.components.core.video.a.a aVar4 = this.TI;
            if (aVar4 != null) {
                aVar4.onMediaPlayStart();
            }
            setTopBottomVisible(true);
            rw();
            return;
        }
        if (i10 == 4) {
            c cVar5 = this.TG;
            if (cVar5 != null) {
                cVar5.bl();
            }
            this.TD.setVisibility(8);
            com.kwad.components.core.video.a.a aVar5 = this.TI;
            if (aVar5 != null) {
                aVar5.oD();
                this.TI.onMediaPlaying();
                return;
            }
            return;
        }
        if (i10 == 5) {
            com.kwad.components.core.video.a.a aVar6 = this.TI;
            if (aVar6 != null) {
                aVar6.onMediaPlayPaused();
                return;
            }
            return;
        }
        if (i10 != 6) {
            if (i10 == 7 && (aVar = this.TI) != null) {
                aVar.onVideoPlayBufferingPaused();
                return;
            }
            return;
        }
        com.kwad.components.core.video.a.a aVar7 = this.TI;
        if (aVar7 != null) {
            aVar7.onVideoPlayBufferingPlaying();
        }
    }

    public void release() {
        this.aBE.release();
        com.kwad.components.core.video.a.a aVar = this.TI;
        if (aVar != null) {
            aVar.onRelease();
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    @UiThread
    public final void reset() {
        rx();
        this.nm.setProgress(0);
        this.nm.setSecondaryProgress(0);
        rm();
        this.TB.setVisibility(8);
        this.TC.setVisibility(8);
        this.nm.setVisibility(8);
        this.TD.setVisibility(8);
        this.Ty.setVisibility(8);
        this.mAdTemplate.mVideoPlayerStatus.setVideoPlayerBehavior(1);
        ri();
    }

    public void rh() {
    }

    public final void rj() {
        this.TB.setVisibility(0);
    }

    public final void rk() {
        this.TB.setVisibility(8);
    }

    public final void rl() {
        this.Ty.setVisibility(0);
        this.TD.setVisibility(0);
        this.mAdTemplate.mVideoPlayerStatus.setVideoPlayerBehavior(2);
    }

    public void rn() {
        if (this.aBE.isIdle()) {
            com.kwad.components.core.video.a.a aVar = this.TI;
            if (aVar != null) {
                aVar.onStart();
            }
            if (!ag.isNetworkConnected(this.mContext)) {
                rj();
                return;
            }
            rk();
            if (this.Tu) {
                ro();
                this.aBE.start();
                return;
            }
            if (this.Tt && ag.isWifiConnected(this.mContext)) {
                ro();
                this.aBE.start();
                return;
            } else if (this.Tt && (this.np || this.Ts)) {
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

    public final void ro() {
        this.aBE.setKsPlayLogParam(com.kwad.sdk.contentalliance.a.a.a.bD(this.mAdTemplate));
    }

    public void rp() {
        this.aBE.pause();
    }

    @Override // com.kwad.sdk.core.video.videoview.b
    public final void rq() {
        long currentPosition = this.aBE.getCurrentPosition();
        long duration = this.aBE.getDuration();
        this.nm.setSecondaryProgress(this.aBE.getBufferPercentage());
        this.mAdTemplate.setmCurPlayTime(currentPosition);
        this.nm.setProgress((int) ((((float) currentPosition) * 100.0f) / ((float) duration)));
        c cVar = this.TG;
        if (cVar != null) {
            cVar.e(currentPosition);
        }
    }

    public final void rr() {
        this.TA = true;
        this.nm.setVisibility(8);
    }

    public void setAdClickListener(InterfaceC0479a interfaceC0479a) {
        this.TH = interfaceC0479a;
    }

    public void setCanControlPlay(boolean z10) {
        this.Tu = z10;
    }

    public void setDataAutoStart(boolean z10) {
        this.Tt = z10;
    }

    public void setDataFlowAutoStart(boolean z10) {
        this.np = z10;
    }

    public void setVideoPlayCallback(c cVar) {
        this.TG = cVar;
    }
}
