package com.kwad.components.core.widget;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.s.o;
import com.kwad.components.core.video.a;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.view.ScaleAnimSeekBar;
import com.kwad.sdk.n.l;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.bl;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class FeedVideoView extends b<AdResultData, AdTemplate> implements NestedScrollingChild {
    private NestedScrollingChildHelper PQ;
    private com.kwad.components.core.video.e Qi;
    private RatioFrameLayout abB;
    private TextView abC;
    private TextView abD;
    private TextView abE;
    private View abF;
    private KSCornerImageView abG;
    private TextView abH;
    private ScaleAnimSeekBar abI;
    private ImageView abJ;
    private ImageView abK;
    private ImageView abL;
    private ViewGroup abM;
    private ViewGroup abN;
    private TextView abO;
    private ViewGroup abP;
    private ViewGroup abQ;
    private int abR;
    private boolean abS;
    private boolean abT;
    private long abU;
    private boolean abV;
    private KsAdVideoPlayConfig abW;
    private a abX;
    private View abY;
    private boolean abZ;
    private Runnable aca;
    private o acb;
    private View.OnClickListener bU;
    private List<Integer> cB;
    private KsAppDownloadListener cx;
    private TextView eB;
    private ImageView eM;
    private com.kwad.sdk.core.video.videoview.a eN;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void pq();

        void pr();
    }

    public FeedVideoView(@NonNull Context context) {
        super(context);
        this.abR = 100;
        Runnable runnable = new Runnable() { // from class: com.kwad.components.core.widget.FeedVideoView.5
            @Override // java.lang.Runnable
            public final void run() {
                FeedVideoView.this.abM.setVisibility(8);
                FeedVideoView.this.abL.setVisibility(8);
                if (FeedVideoView.this.Qi != null) {
                    FeedVideoView.this.Qi.aO(true);
                }
            }
        };
        this.aca = runnable;
        this.acb = new o(runnable);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.cx == null) {
            this.cx = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.widget.FeedVideoView.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    FeedVideoView.this.abE.setText(com.kwad.sdk.core.response.b.a.aE(FeedVideoView.this.mAdInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    FeedVideoView.this.abE.setText(com.kwad.sdk.core.response.b.a.bY(FeedVideoView.this.mAdTemplate));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    FeedVideoView.this.abE.setText(com.kwad.sdk.core.response.b.a.aE(FeedVideoView.this.mAdInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    FeedVideoView.this.abE.setText(com.kwad.sdk.core.response.b.a.ac(FeedVideoView.this.mAdInfo));
                }

                @Override // com.kwad.sdk.core.download.a.a
                public final void onPaused(int i10) {
                    FeedVideoView.this.abE.setText(com.kwad.sdk.core.response.b.a.dn(i10));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i10) {
                    FeedVideoView.this.abE.setText(com.kwad.sdk.core.response.b.a.dm(i10));
                }
            };
        }
        return this.cx;
    }

    private boolean tn() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j10 = elapsedRealtime - this.abU;
        if (j10 > 888) {
            this.abU = elapsedRealtime;
        }
        return j10 > 888;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void to() {
        a aVar = this.abX;
        if (aVar != null) {
            aVar.pq();
        }
        if ((this.abR == 100) && tn()) {
            this.abN.setVisibility(0);
            this.abO.setText(this.mAdInfo.adBaseInfo.adDescription);
            boolean z10 = com.kwad.sdk.core.response.b.a.R(this.mAdInfo) > com.kwad.sdk.core.response.b.a.Q(this.mAdInfo);
            this.abS = ai.cl(getContext());
            getContext();
            this.abT = ai.LZ();
            if (!z10) {
                ai.cn(getContext());
            } else {
                ai.co(getContext());
            }
            ViewGroup viewGroup = (ViewGroup) this.abP.getParent();
            this.abQ = viewGroup;
            if (viewGroup != null) {
                viewGroup.removeView(this.abP);
                View view = new View(this.abP.getContext());
                this.abY = view;
                view.setLayoutParams(new ViewGroup.LayoutParams(this.abP.getWidth(), this.abP.getHeight()));
                viewGroup.addView(this.abY);
            }
            ai.b(getContext(), false);
            Activity dn = l.dn(getContext());
            if (dn != null) {
                ViewGroup viewGroup2 = (ViewGroup) dn.getWindow().getDecorView();
                this.abP.setLayoutParams(new ViewGroup.LayoutParams(viewGroup2.getWidth(), viewGroup2.getHeight()));
                if (z10 && viewGroup2.getWidth() != 0) {
                    this.abB.setRatio(viewGroup2.getHeight() / viewGroup2.getWidth());
                }
                viewGroup2.addView(this.abP, new FrameLayout.LayoutParams(-1, -1));
                setUIWithStateAndMode(101);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tp() {
        if ((this.abR == 101) & tn()) {
            this.abN.setVisibility(8);
            if (this.abS) {
                ai.cl(getContext());
            } else {
                ai.cm(getContext());
            }
            if (this.abT) {
                ai.co(getContext());
            } else {
                ai.cn(getContext());
            }
            ai.b(getContext(), true);
            ViewGroup viewGroup = (ViewGroup) this.abP.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.abP);
            }
            this.abP.setLayoutParams(new ViewGroup.LayoutParams(this.abQ.getWidth(), this.abQ.getHeight()));
            this.abB.setRatio(0.5600000023841858d);
            View view = this.abY;
            if (view != null) {
                this.abQ.removeView(view);
                this.abY = null;
            }
            this.abQ.addView(this.abP, new FrameLayout.LayoutParams(-1, -2));
            this.abP.requestLayout();
            setUIWithStateAndMode(100);
        }
        a aVar = this.abX;
        if (aVar != null) {
            aVar.pr();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.i
    public final void A(View view) {
        super.A(view);
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.h.c
    public final void aM() {
        super.aM();
        com.kwad.sdk.core.video.videoview.a aVar = this.eN;
        if (aVar == null || aVar.isPlaying()) {
            return;
        }
        qa();
        if (getHandler() != null) {
            getHandler().removeCallbacks(this.acb);
            getHandler().postDelayed(this.acb, 5000L);
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.h.c
    public final void aN() {
        super.aN();
        if (this.eN != null) {
            rp();
            if (getHandler() != null) {
                getHandler().removeCallbacks(this.acb);
                getHandler().postDelayed(this.acb, 5000L);
            }
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void bc() {
        this.PQ = new NestedScrollingChildHelper(this);
        RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(R.id.ksad_video_container);
        this.abB = ratioFrameLayout;
        ratioFrameLayout.setRatio(0.5600000023841858d);
        this.eM = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.eB = (TextView) findViewById(R.id.ksad_video_text_below);
        ScaleAnimSeekBar scaleAnimSeekBar = (ScaleAnimSeekBar) findViewById(R.id.ksad_web_video_seek_bar);
        this.abI = scaleAnimSeekBar;
        scaleAnimSeekBar.setMaxProgress(100);
        this.abI.setMinProgress(0);
        this.abE = (TextView) findViewById(R.id.ksad_video_text_below_action_bar);
        this.abF = findViewById(R.id.ksad_video_text_below_action_icon_layout);
        this.abH = (TextView) findViewById(R.id.ksad_video_text_below_action_title);
        this.abG = (KSCornerImageView) findViewById(R.id.ksad_video_text_below_action_icon);
        this.abC = (TextView) findViewById(R.id.ksad_video_control_play_total);
        this.abD = (TextView) findViewById(R.id.ksad_video_control_play_duration);
        this.abJ = (ImageView) findViewById(R.id.ksad_video_control_play_button);
        this.abL = (ImageView) findViewById(R.id.ksad_video_control_play_status);
        this.abK = (ImageView) findViewById(R.id.ksad_video_control_fullscreen);
        this.abM = (ViewGroup) findViewById(R.id.ksad_video_control_container);
        this.abP = (ViewGroup) findViewById(R.id.ksad_feed_video_container);
        this.abN = (ViewGroup) findViewById(R.id.ksad_video_control_fullscreen_container);
        this.abO = (TextView) findViewById(R.id.ksad_video_control_fullscreen_title);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f10, float f11, boolean z10) {
        return this.PQ.dispatchNestedFling(f10, f11, z10);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f10, float f11) {
        return this.PQ.dispatchNestedPreFling(f10, f11);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2) {
        return this.PQ.dispatchNestedPreScroll(i10, i11, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr) {
        return this.PQ.dispatchNestedScroll(i10, i11, i12, i13, iArr);
    }

    @Override // com.kwad.components.core.widget.b
    public int getLayoutId() {
        return R.layout.ksad_feed_video;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.PQ.hasNestedScrollingParent();
    }

    public final boolean isComplete() {
        com.kwad.sdk.core.video.videoview.a aVar = this.eN;
        if (aVar != null) {
            return aVar.isCompleted();
        }
        return true;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.PQ.isNestedScrollingEnabled();
    }

    public final void pW() {
        this.Qi.rI();
    }

    public final void qa() {
        this.Qi.rL();
        this.Qi.setVisibility(0);
        this.Qi.setAlpha(1.0f);
        this.abJ.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_pause_btn));
        this.abL.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_pause_center));
    }

    public final void release() {
        com.kwad.components.core.video.e eVar = this.Qi;
        if (eVar != null) {
            eVar.release();
        }
    }

    public final void rp() {
        this.Qi.rK();
        this.abL.setVisibility(0);
        this.abL.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_play_176));
        this.abJ.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_play_btn));
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z10) {
        this.PQ.setNestedScrollingEnabled(z10);
    }

    public void setOnEndBtnClickListener(View.OnClickListener onClickListener) {
        this.bU = onClickListener;
    }

    public void setUIWithStateAndMode(int i10) {
        if (i10 == 101) {
            this.abK.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_exit_fullscreen_btn));
        } else {
            this.abK.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_fullscreen_btn));
        }
        this.abR = i10;
    }

    public void setWindowFullScreenListener(a aVar) {
        this.abX = aVar;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i10) {
        return this.PQ.startNestedScroll(i10);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.PQ.stopNestedScroll();
    }

    public final boolean tq() {
        if (this.abR != 101) {
            return false;
        }
        tp();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j10) {
        int ceil = (int) Math.ceil(((float) j10) / 1000.0f);
        List<Integer> list = this.cB;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> iterator2 = this.cB.iterator2();
        while (iterator2.hasNext()) {
            if (ceil >= iterator2.next().intValue()) {
                com.kwad.sdk.core.adlog.c.a((AdTemplate) this.mAdTemplate, ceil, (JSONObject) null);
                iterator2.remove();
                return;
            }
        }
    }

    public static /* synthetic */ boolean a(FeedVideoView feedVideoView, boolean z10) {
        feedVideoView.abZ = true;
        return true;
    }

    @Override // com.kwad.components.core.widget.b
    public final void b(@NonNull AdResultData adResultData) {
        super.b((FeedVideoView) adResultData);
    }

    public final void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, com.kwad.components.core.e.d.c cVar) {
        this.mApkDownloadHelper = cVar;
        this.abZ = false;
        com.kwad.sdk.core.response.model.b br = com.kwad.sdk.core.response.b.a.br(this.mAdInfo);
        this.abW = ksAdVideoPlayConfig;
        String url = br.getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.eM.setImageDrawable(null);
            KSImageLoader.loadImage(this.eM, url, this.mAdTemplate);
            this.eM.setVisibility(0);
        } else {
            this.eM.setVisibility(8);
        }
        this.cB = com.kwad.sdk.core.response.b.a.bm(this.mAdInfo);
        String K = com.kwad.sdk.core.response.b.a.K(this.mAdInfo);
        if (TextUtils.isEmpty(K)) {
            return;
        }
        this.eN = AdVideoPlayerViewCache.getInstance().ew(K);
        if (com.kwad.sdk.core.response.b.a.aq(this.mAdInfo)) {
            this.eB.setVisibility(8);
            View view = this.abF;
            if (view != null) {
                view.setVisibility(0);
                this.abE.setText(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo));
                this.abH.setText(com.kwad.sdk.core.response.b.a.cc(this.mAdInfo));
                KSImageLoader.loadAppIcon(this.abG, com.kwad.sdk.core.response.b.a.cf(this.mAdInfo), this.mAdTemplate, 4);
                com.kwad.components.core.e.d.c cVar2 = this.mApkDownloadHelper;
                if (cVar2 != null) {
                    cVar2.b(getAppDownloadListener());
                }
                this.abE.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        if (FeedVideoView.this.bU != null) {
                            FeedVideoView.this.bU.onClick(view2);
                        }
                    }
                });
            }
        } else {
            View view2 = this.abF;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            this.eB.setVisibility(0);
        }
        com.kwad.sdk.core.video.videoview.a aVar = this.eN;
        if (aVar == null) {
            this.eN = new com.kwad.sdk.core.video.videoview.a(getContext());
            com.kwad.sdk.core.response.b.a.ab(this.mAdInfo);
            this.eN.a(new b.a(this.mAdTemplate).a(this.mAdTemplate.mVideoPlayerStatus).cR(com.kwad.sdk.core.response.b.e.dS(this.mAdTemplate)).cS(com.kwad.sdk.core.response.b.h.b(com.kwad.sdk.core.response.b.e.dR(this.mAdTemplate))).b(new com.kwad.sdk.contentalliance.a.a.a(this.mAdTemplate, System.currentTimeMillis())).Bb(), null);
            com.kwad.components.core.video.e eVar = new com.kwad.components.core.video.e(((b) this).mContext, this.mAdTemplate, this.eN, ksAdVideoPlayConfig);
            this.Qi = eVar;
            eVar.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            this.eN.setController(this.Qi);
            this.Qi.setAutoRelease(false);
            if (com.kwad.sdk.core.config.d.Bv() == 2) {
                AdVideoPlayerViewCache.getInstance().a(K, this.eN);
            }
        } else {
            if (aVar.getTag() != null) {
                try {
                    this.cB = (List) this.eN.getTag();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            com.kwad.components.core.video.e eVar2 = (com.kwad.components.core.video.e) this.eN.getController();
            this.Qi = eVar2;
            eVar2.setAutoRelease(false);
            this.Qi.getAdTemplate().mAdWebVideoPageShowing = true;
        }
        this.eN.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
        if (this.eN.getParent() != null) {
            ((ViewGroup) this.eN.getParent()).removeView(this.eN);
            this.Qi.rI();
        }
        if (this.abB.getTag() != null) {
            RatioFrameLayout ratioFrameLayout = this.abB;
            ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
            this.abB.setTag(null);
        }
        this.abB.addView(this.eN);
        this.abB.setTag(this.eN);
        this.abM.setVisibility(8);
        this.abL.setVisibility(8);
        if (this.mAdInfo.adConversionInfo.h5Type == 1) {
            this.eB.setVisibility(8);
        } else {
            this.eB.setVisibility(0);
            this.eB.setText(this.mAdInfo.adBaseInfo.adDescription);
        }
        a(this.Qi, this.eN);
    }

    public FeedVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.abR = 100;
        Runnable runnable = new Runnable() { // from class: com.kwad.components.core.widget.FeedVideoView.5
            @Override // java.lang.Runnable
            public final void run() {
                FeedVideoView.this.abM.setVisibility(8);
                FeedVideoView.this.abL.setVisibility(8);
                if (FeedVideoView.this.Qi != null) {
                    FeedVideoView.this.Qi.aO(true);
                }
            }
        };
        this.aca = runnable;
        this.acb = new o(runnable);
    }

    public FeedVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.abR = 100;
        Runnable runnable = new Runnable() { // from class: com.kwad.components.core.widget.FeedVideoView.5
            @Override // java.lang.Runnable
            public final void run() {
                FeedVideoView.this.abM.setVisibility(8);
                FeedVideoView.this.abL.setVisibility(8);
                if (FeedVideoView.this.Qi != null) {
                    FeedVideoView.this.Qi.aO(true);
                }
            }
        };
        this.aca = runnable;
        this.acb = new o(runnable);
    }

    private void a(com.kwad.components.core.video.a aVar, final com.kwad.sdk.core.video.videoview.a aVar2) {
        this.abP.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (FeedVideoView.this.abM.getVisibility() == 8) {
                    if (!FeedVideoView.this.eN.isCompleted()) {
                        FeedVideoView.this.abM.setVisibility(0);
                        FeedVideoView.this.abL.setVisibility(0);
                        if (FeedVideoView.this.Qi != null) {
                            FeedVideoView.this.Qi.aO(false);
                        }
                        if (FeedVideoView.this.getHandler() != null) {
                            FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.aca);
                            FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.acb, 5000L);
                            return;
                        }
                        return;
                    }
                    if (FeedVideoView.this.abR == 101) {
                        FeedVideoView.this.abM.setVisibility(0);
                        FeedVideoView.this.abL.setVisibility(8);
                        if (FeedVideoView.this.Qi != null) {
                            FeedVideoView.this.Qi.aO(false);
                        }
                        if (FeedVideoView.this.getHandler() != null) {
                            FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.aca);
                            FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.acb, 5000L);
                            return;
                        }
                        return;
                    }
                    if (FeedVideoView.this.bU != null) {
                        FeedVideoView.this.bU.onClick(view);
                        return;
                    }
                    return;
                }
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.aca);
                    if (FeedVideoView.this.abV) {
                        return;
                    }
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.acb, 1000L);
                }
            }
        });
        aVar.setVideoPlayCallback(new a.c() { // from class: com.kwad.components.core.widget.FeedVideoView.7
            private boolean cC = false;

            @Override // com.kwad.components.core.video.a.c
            public final void bl() {
                if (!FeedVideoView.this.abZ) {
                    FeedVideoView.a(FeedVideoView.this, true);
                    if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.eN.setVideoSoundEnable(!com.kwad.sdk.core.response.b.a.ap(FeedVideoView.this.mAdInfo));
                    }
                    if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.eN.setLooping(com.kwad.sdk.core.response.b.a.ao(FeedVideoView.this.mAdInfo));
                    }
                }
                if (this.cC) {
                    return;
                }
                this.cC = true;
                com.kwad.components.core.o.a.qi().b(FeedVideoView.this.mAdTemplate, System.currentTimeMillis(), 1);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void bm() {
                com.kwad.sdk.core.adlog.c.bL(FeedVideoView.this.mAdTemplate);
                FeedVideoView.this.abM.setVisibility(8);
                FeedVideoView.this.abL.setVisibility(8);
                FeedVideoView.this.abI.setProgress(100);
                FeedVideoView.this.abD.setText(bl.ab(aVar2.getDuration()));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void e(long j10) {
                FeedVideoView.this.c(j10);
                float duration = (((float) j10) * 100.0f) / ((float) aVar2.getDuration());
                if (!FeedVideoView.this.abV) {
                    FeedVideoView.this.abI.setProgress((int) duration);
                    FeedVideoView.this.abD.setText(bl.ab(j10));
                }
                FeedVideoView.this.abC.setText(bl.ab(aVar2.getDuration()));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                if (!FeedVideoView.this.abZ) {
                    FeedVideoView.a(FeedVideoView.this, true);
                    if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.eN.setVideoSoundEnable(true ^ com.kwad.sdk.core.response.b.a.ap(FeedVideoView.this.mAdInfo));
                    }
                    if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.eN.setLooping(com.kwad.sdk.core.response.b.a.ao(FeedVideoView.this.mAdInfo));
                    }
                }
                com.kwad.sdk.core.adlog.c.bK(FeedVideoView.this.mAdTemplate);
                FeedVideoView.this.abC.setText(bl.ab(aVar2.getDuration()));
            }
        });
        this.Qi.setAdClickListener(new a.InterfaceC0479a() { // from class: com.kwad.components.core.widget.FeedVideoView.8
            @Override // com.kwad.components.core.video.a.InterfaceC0479a
            public final void a(int i10, ac.a aVar3) {
                int i11 = 171;
                int i12 = 2;
                boolean z10 = false;
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) == 0) {
                                i11 = 108;
                            }
                        } else {
                            i11 = com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) != 0 ? 50 : 83;
                            i12 = 1;
                            z10 = true;
                        }
                    } else if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) == 0) {
                        i11 = 82;
                    }
                } else if (com.kwad.sdk.core.response.b.a.an(FeedVideoView.this.mAdInfo) == 0) {
                    i11 = 13;
                }
                com.kwad.components.core.e.d.a.a(new a.C0461a(FeedVideoView.this.getContext()).aq(FeedVideoView.this.mAdTemplate).at(true).b(FeedVideoView.this.mApkDownloadHelper).an(i12).ao(z10).aq(true).am(i11).d(aVar3).a(new a.b() { // from class: com.kwad.components.core.widget.FeedVideoView.8.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        FeedVideoView.this.tj();
                    }
                }));
            }
        });
        this.abI.setOnSeekBarChangeListener(new ScaleAnimSeekBar.a() { // from class: com.kwad.components.core.widget.FeedVideoView.9
            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public final void a(ScaleAnimSeekBar scaleAnimSeekBar, boolean z10) {
                if (z10) {
                    FeedVideoView.this.abI.bo(true);
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.acb);
                    FeedVideoView.this.abV = true;
                    FeedVideoView.this.abD.setText(bl.ab((int) ((aVar2.getDuration() * scaleAnimSeekBar.getProgress()) / scaleAnimSeekBar.getMaxProgress())));
                }
            }

            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public final void tr() {
                FeedVideoView.this.abI.bo(true);
                FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.acb);
                FeedVideoView.this.abV = true;
            }

            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public final void a(ScaleAnimSeekBar scaleAnimSeekBar) {
                FeedVideoView.this.abI.bo(false);
                aVar2.seekTo((int) ((aVar2.getDuration() * scaleAnimSeekBar.getProgress()) / scaleAnimSeekBar.getMaxProgress()));
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.acb);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.acb, 5000L);
                }
                FeedVideoView.this.abV = false;
            }
        });
        this.abJ.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (!aVar2.isPaused() && !aVar2.isIdle()) {
                    if (aVar2.isPlaying()) {
                        FeedVideoView.this.Qi.rK();
                        FeedVideoView.this.abL.setVisibility(0);
                        FeedVideoView.this.abL.setImageDrawable(FeedVideoView.this.getContext().getResources().getDrawable(R.drawable.ksad_video_play_176));
                        FeedVideoView.this.abJ.setImageDrawable(FeedVideoView.this.getContext().getResources().getDrawable(R.drawable.ksad_video_player_play_btn));
                    }
                } else {
                    FeedVideoView.this.Qi.rL();
                    FeedVideoView.this.abJ.setImageDrawable(FeedVideoView.this.getResources().getDrawable(R.drawable.ksad_video_player_pause_btn));
                    FeedVideoView.this.abL.setImageDrawable(FeedVideoView.this.getResources().getDrawable(R.drawable.ksad_video_player_pause_center));
                }
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.acb);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.acb, 5000L);
                }
            }
        });
        this.abL.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (!FeedVideoView.this.eN.isPaused() && !FeedVideoView.this.eN.isIdle()) {
                    if (FeedVideoView.this.eN.isPlaying()) {
                        FeedVideoView.this.rp();
                    }
                } else {
                    FeedVideoView.this.qa();
                }
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.acb);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.acb, 5000L);
                }
            }
        });
        this.abN.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedVideoView.this.tp();
            }
        });
        this.abK.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (FeedVideoView.this.abR == 100) {
                    FeedVideoView.this.to();
                } else if (FeedVideoView.this.abR == 101) {
                    FeedVideoView.this.tp();
                }
            }
        });
    }
}
