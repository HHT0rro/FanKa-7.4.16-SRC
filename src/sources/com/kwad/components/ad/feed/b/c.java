package com.kwad.components.ad.feed.b;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.j.a;
import com.kwad.components.core.video.a;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.widget.KSRelativeLayout;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class c extends a implements View.OnClickListener, com.kwad.sdk.widget.c {
    private List<Integer> cB;
    private volatile boolean cC;
    private com.kwad.sdk.widget.j cD;
    private ImageView dE;
    private TextView dF;
    private TextView dM;
    private KsAdVideoPlayConfig dU;
    private TextView eB;
    private ImageView eD;
    private TextView eF;
    private TextView eG;
    private View eH;
    private DownloadProgressView eI;
    private KSRelativeLayout eL;
    private ImageView eM;
    private com.kwad.sdk.core.video.videoview.a eN;
    private com.kwad.components.core.video.e eO;
    private d eP;
    private boolean eQ;
    private TextView eR;
    private final a.InterfaceC0479a eS;
    private IAdLiveOfflineView eT;
    private com.kwad.components.core.n.a.a.a eU;
    private IAdLivePlayModule eV;
    private boolean eW;
    private View eX;
    private a.b eY;
    private final AdLivePlayStateListener eZ;

    /* renamed from: fa, reason: collision with root package name */
    private OfflineOnAudioConflictListener f36438fa;

    /* renamed from: fb, reason: collision with root package name */
    private a.b f36439fb;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private boolean mIsAudioEnable;
    private KsLogoView mLogoView;

    public c(@NonNull Context context) {
        super(context);
        this.mIsAudioEnable = false;
        this.cC = false;
        this.cD = new com.kwad.sdk.widget.j() { // from class: com.kwad.components.ad.feed.b.c.1
            @Override // com.kwad.sdk.widget.j
            public final void ao() {
                com.kwad.sdk.utils.l.el(c.this.mAdTemplate);
            }
        };
        this.eS = new a.InterfaceC0479a() { // from class: com.kwad.components.ad.feed.b.c.3
            @Override // com.kwad.components.core.video.a.InterfaceC0479a
            public final void a(int i10, ac.a aVar) {
                int i11;
                int i12 = 2;
                boolean z10 = false;
                if (i10 == 1) {
                    i11 = 15;
                } else if (i10 == 2) {
                    i11 = 16;
                } else if (i10 != 3) {
                    i11 = 35;
                } else {
                    i11 = 39;
                    i12 = 1;
                    z10 = true;
                }
                c.this.ba();
                com.kwad.components.core.e.d.a.a(new a.C0461a(c.this.getContext()).aq(c.this.mAdTemplate).b(c.this.mApkDownloadHelper).an(i12).ao(z10).aq(true).al(5).am(i11).d(aVar).as(true).a(new a.b() { // from class: com.kwad.components.ad.feed.b.c.3.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        c.this.tj();
                    }
                }));
            }
        };
        this.eZ = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.feed.b.c.7
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayEnd() {
                super.onLivePlayEnd();
                c.this.eR.setVisibility(0);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayProgress(long j10) {
                super.onLivePlayProgress(j10);
                c.this.c(j10);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayResume() {
                super.onLivePlayResume();
                com.kwad.components.core.j.a.oG().a(c.this.getCurrentVoiceItem());
                IAdLivePlayModule iAdLivePlayModule = c.this.eV;
                c cVar = c.this;
                iAdLivePlayModule.setAudioEnabled(cVar.g(cVar.mIsAudioEnable), false);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayStart() {
                super.onLivePlayStart();
                com.kwad.components.core.j.a.oG().a(c.this.getCurrentVoiceItem());
                IAdLivePlayModule iAdLivePlayModule = c.this.eV;
                c cVar = c.this;
                iAdLivePlayModule.setAudioEnabled(cVar.g(cVar.mIsAudioEnable), false);
            }
        };
        this.f36438fa = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.feed.b.c.8
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                c.b(c.this, false);
                if (c.this.eN != null) {
                    c.this.eN.setVideoSoundEnable(false);
                }
                if (c.this.eV != null) {
                    c.this.eV.setAudioEnabled(false, false);
                }
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }
        };
        this.f36439fb = new a.b() { // from class: com.kwad.components.ad.feed.b.c.10
            @Override // com.kwad.components.core.video.a.c
            public final void bl() {
                com.kwad.sdk.core.video.videoview.a aVar = c.this.eN;
                c cVar = c.this;
                aVar.setVideoSoundEnable(cVar.g(cVar.mIsAudioEnable));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void bm() {
                if (com.kwad.components.ad.feed.a.b.aW() && c.this.eP == null) {
                    c.this.eP = new d(c.this.getContext());
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    c cVar = c.this;
                    cVar.addView(cVar.eP, layoutParams);
                    c.this.eP.bn();
                }
                com.kwad.sdk.core.adlog.c.bL(c.this.mAdTemplate);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void e(long j10) {
                c.this.c(j10);
            }

            @Override // com.kwad.components.core.video.a.b
            public final void onVideoPlayError(int i10, int i11) {
                com.kwad.components.ad.feed.monitor.b.a(c.this.mAdTemplate, 2, 1, com.kwad.sdk.core.response.b.a.K(c.this.mAdInfo), i10 + " " + i11, SystemClock.elapsedRealtime() - c.this.ey);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                com.kwad.components.core.j.a.oG().a(c.this.getCurrentVoiceItem());
                if (c.this.eP != null && (c.this.eP.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) c.this.eP.getParent()).removeView(c.this.eP);
                    c.this.eP.bo();
                    c.this.eP = null;
                }
                com.kwad.components.ad.feed.monitor.b.a(c.this.mAdTemplate, 1, 1, com.kwad.sdk.core.response.b.a.K(c.this.mAdInfo), null, SystemClock.elapsedRealtime() - c.this.ey);
                com.kwad.sdk.core.adlog.c.bK(c.this.mAdTemplate);
            }
        };
    }

    private void bd() {
        findViewById(R.id.ksad_ad_h5_container).setVisibility(0);
        findViewById(R.id.ksad_ad_download_container).setVisibility(8);
        this.eG = (TextView) findViewById(R.id.ksad_h5_desc);
        this.dM = (TextView) findViewById(R.id.ksad_h5_open_btn);
        this.eH = findViewById(R.id.ksad_h5_open_cover);
        this.eG.setText(com.kwad.components.ad.feed.f.c(this.mAdTemplate));
        this.dM.setText(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo));
        this.eH.setOnClickListener(this);
        this.eG.setOnClickListener(this);
        this.dM.setOnClickListener(this);
        new com.kwad.sdk.widget.f(getContext(), this.eH, this);
        new com.kwad.sdk.widget.f(getContext(), this.eG, this);
        new com.kwad.sdk.widget.f(getContext(), this.dM, this);
    }

    private void be() {
        findViewById(R.id.ksad_ad_download_container).setVisibility(0);
        findViewById(R.id.ksad_ad_h5_container).setVisibility(8);
        this.dE = (ImageView) findViewById(R.id.ksad_app_icon);
        this.dF = (TextView) findViewById(R.id.ksad_app_title);
        TextView textView = (TextView) findViewById(R.id.ksad_app_desc);
        this.eF = textView;
        com.kwad.sdk.d.a.a.a(this, this.dE, this.dF, textView);
        new com.kwad.sdk.widget.f(getContext(), this.dE, this);
        new com.kwad.sdk.widget.f(getContext(), this.dF, this);
        new com.kwad.sdk.widget.f(getContext(), this.eF, this);
        this.dF.setText(com.kwad.sdk.core.response.b.a.av(this.mAdInfo));
        this.dE.setImageResource(R.drawable.ksad_default_app_icon);
        KSImageLoader.loadAppIcon(this.dE, com.kwad.sdk.core.response.b.a.cf(this.mAdInfo), this.mAdTemplate, 8);
        this.eF.setText(com.kwad.components.ad.feed.f.c(this.mAdTemplate));
        bb();
        this.eI.ai(this.mAdTemplate);
        this.eI.setOnClickListener(this);
        new com.kwad.sdk.widget.f(getContext(), this.eI, this);
        com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate, null, this.eI.getAppDownloadListener());
        this.mApkDownloadHelper = cVar;
        cVar.d(this.eI.getAppDownloadListener());
        this.mApkDownloadHelper.setOnShowListener(this);
        this.mApkDownloadHelper.setOnDismissListener(this);
    }

    private void bg() {
        com.kwad.components.core.n.a.a.a aVar = (com.kwad.components.core.n.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.a.a.class);
        this.eU = aVar;
        if (aVar != null && aVar.oK() && com.kwad.sdk.core.response.b.a.cL(this.mAdInfo)) {
            this.eW = true;
        }
    }

    private boolean bh() {
        IAdLiveOfflineView iAdLiveOfflineView = this.eT;
        if (iAdLiveOfflineView == null || iAdLiveOfflineView.getView() == null || !this.eW) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) this.eT.getView().getParent();
        if (viewGroup != this.eL) {
            viewGroup.removeView(this.eT.getView());
            if (this.eL.getTag() != null) {
                KSRelativeLayout kSRelativeLayout = this.eL;
                kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
                this.eL.setTag(null);
            }
            this.eL.addView(this.eT.getView());
            this.eL.setTag(this.eT.getView());
            this.eV.setAudioEnabled(this.mIsAudioEnable, false);
            IAdLivePlayModule adLivePlayModule = this.eU.getAdLivePlayModule(this.eT, ServiceProvider.getAppId(), String.valueOf(com.kwad.sdk.core.response.b.a.cg(this.mAdInfo)), com.kwad.sdk.core.response.b.a.ch(this.mAdInfo), com.kwad.sdk.core.response.b.a.ci(this.mAdInfo));
            this.eV = adLivePlayModule;
            adLivePlayModule.registerAdLivePlayStateListener(this.eZ);
        }
        this.eV.onResume();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IAdLivePlayModule bi() {
        bj();
        IAdLiveOfflineView view = this.eU.getView(((com.kwad.components.core.widget.b) this).mContext, 3);
        this.eT = view;
        IAdLivePlayModule adLivePlayModule = this.eU.getAdLivePlayModule(view, ServiceProvider.KP().appId, String.valueOf(com.kwad.sdk.core.response.b.a.cg(this.mAdInfo)), com.kwad.sdk.core.response.b.a.ch(this.mAdInfo), com.kwad.sdk.core.response.b.a.ci(this.mAdInfo));
        adLivePlayModule.setAudioEnabled(g(this.mIsAudioEnable), false);
        adLivePlayModule.registerAdLivePlayStateListener(this.eZ);
        final View view2 = this.eT.getView();
        if (this.eL.getTag() != null) {
            KSRelativeLayout kSRelativeLayout = this.eL;
            kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
            this.eL.setTag(null);
        }
        this.eL.addView(view2);
        this.eL.setTag(view2);
        bn.postOnUiThread(new ay() { // from class: com.kwad.components.ad.feed.b.c.4
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                c.this.c(view2);
            }
        });
        if (this.mIsAudioEnable) {
            com.kwad.components.core.s.a.ah(((com.kwad.components.core.widget.b) this).mContext).a(this.f36438fa);
        }
        return adLivePlayModule;
    }

    private void bj() {
        String url = com.kwad.sdk.core.response.b.a.br(this.mAdInfo).getUrl();
        this.eM.setVisibility(0);
        this.eX.setVisibility(0);
        if (!TextUtils.isEmpty(url)) {
            this.eM.setImageDrawable(null);
            KSImageLoader.loadImage(this.eM, url, this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.feed.b.c.5
                @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                    decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                    return true;
                }
            });
        } else {
            this.eM.setImageResource(R.drawable.ksad_ad_live_end);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a.b getCurrentVoiceItem() {
        if (this.eY == null) {
            this.eY = new a.b(new a.c() { // from class: com.kwad.components.ad.feed.b.c.2
                @Override // com.kwad.components.core.j.a.c
                public final void bk() {
                    if (c.this.eW) {
                        if (c.this.eV == null) {
                            c cVar = c.this;
                            cVar.eV = cVar.bi();
                        }
                        IAdLivePlayModule iAdLivePlayModule = c.this.eV;
                        c cVar2 = c.this;
                        iAdLivePlayModule.setAudioEnabled(cVar2.g(cVar2.mIsAudioEnable), false);
                        return;
                    }
                    if (c.this.eN != null) {
                        com.kwad.sdk.core.video.videoview.a aVar = c.this.eN;
                        c cVar3 = c.this;
                        aVar.setVideoSoundEnable(cVar3.g(cVar3.mIsAudioEnable));
                    }
                }
            });
        }
        return this.eY;
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.h.c
    public final void aM() {
        super.aM();
        com.kwad.components.core.video.e eVar = this.eO;
        if (eVar != null) {
            eVar.setVideoPlayCallback(this.f36439fb);
        }
        com.kwad.components.core.j.a.oG().a(getCurrentVoiceItem());
        if (this.eW) {
            IAdLivePlayModule iAdLivePlayModule = this.eV;
            if (iAdLivePlayModule == null) {
                this.eV = bi();
            } else {
                iAdLivePlayModule.onResume();
            }
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.h.c
    public final void aN() {
        super.aN();
        IAdLivePlayModule iAdLivePlayModule = this.eV;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onPause();
        }
        com.kwad.components.core.j.a.oG().c(this.eY);
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void ac() {
        super.ac();
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void ad() {
        super.ad();
        com.kwad.sdk.utils.l.ej(this.mAdTemplate);
        IAdLivePlayModule iAdLivePlayModule = this.eV;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onDestroy();
            this.eV = null;
        }
        IAdLiveOfflineView iAdLiveOfflineView = this.eT;
        if (iAdLiveOfflineView != null) {
            iAdLiveOfflineView.onDestroy();
            this.eT = null;
        }
        com.kwad.components.core.j.a.oG().c(this.eY);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bc() {
        this.eB = (TextView) findViewById(R.id.ksad_ad_desc);
        KSRelativeLayout kSRelativeLayout = (KSRelativeLayout) findViewById(R.id.ksad_video_container);
        this.eL = kSRelativeLayout;
        kSRelativeLayout.setRatio(0.56f);
        this.eD = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.eM = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_ad_dislike_logo);
        this.eI = (DownloadProgressView) findViewById(R.id.ksad_app_download_btn);
        this.eR = (TextView) findViewById(R.id.ksad_live_end_text);
        this.eX = findViewById(R.id.ksad_live_end_bg_mantle);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bf() {
        super.bf();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this.eI.getAppDownloadListener());
        }
        if (this.mIsAudioEnable) {
            com.kwad.components.core.s.a.ah(((com.kwad.components.core.widget.b) this).mContext).b(this.f36438fa);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0065, code lost:
    
        if (r5 == r4.eN) goto L19;
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onClick(android.view.View r5) {
        /*
            r4 = this;
            android.widget.ImageView r0 = r4.eD
            if (r5 != r0) goto L8
            r4.tk()
            return
        L8:
            com.kwad.sdk.widget.KSRelativeLayout r0 = r4.eL
            if (r5 != r0) goto L2c
            com.kwad.sdk.core.video.videoview.a r0 = r4.eN
            if (r0 == 0) goto L2c
            boolean r0 = r0.isIdle()
            if (r0 == 0) goto L2c
            R extends com.kwad.sdk.core.response.model.AdTemplate r5 = r4.mAdTemplate
            com.kwad.sdk.utils.l.ek(r5)
            R extends com.kwad.sdk.core.response.model.AdTemplate r5 = r4.mAdTemplate
            com.kwad.sdk.contentalliance.a.a.a r5 = com.kwad.sdk.contentalliance.a.a.a.bD(r5)
            com.kwad.sdk.core.video.videoview.a r0 = r4.eN
            r0.setKsPlayLogParam(r5)
            com.kwad.sdk.core.video.videoview.a r5 = r4.eN
            r5.start()
            return
        L2c:
            r0 = 35
            android.widget.TextView r1 = r4.eB
            r2 = 1
            r3 = 100
            if (r5 != r1) goto L38
            r0 = 25
            goto L6c
        L38:
            com.kwad.sdk.widget.KSRelativeLayout r1 = r4.eL
            if (r5 != r1) goto L3f
        L3c:
            r0 = 100
            goto L6c
        L3f:
            com.kwad.components.ad.widget.DownloadProgressView r1 = r4.eI
            if (r5 == r1) goto L6b
            android.widget.TextView r1 = r4.dM
            if (r5 == r1) goto L6b
            android.view.View r1 = r4.eH
            if (r5 != r1) goto L4c
            goto L6b
        L4c:
            android.widget.ImageView r1 = r4.dE
            if (r5 != r1) goto L53
            r0 = 13
            goto L6c
        L53:
            android.widget.TextView r1 = r4.dF
            if (r5 != r1) goto L5a
            r0 = 14
            goto L6c
        L5a:
            android.widget.TextView r1 = r4.eF
            if (r5 == r1) goto L68
            android.widget.TextView r1 = r4.eG
            if (r5 != r1) goto L63
            goto L68
        L63:
            com.kwad.sdk.core.video.videoview.a r1 = r4.eN
            if (r5 != r1) goto L6c
            goto L3c
        L68:
            r0 = 101(0x65, float:1.42E-43)
            goto L6c
        L6b:
            r0 = 1
        L6c:
            com.kwad.sdk.core.video.videoview.a r1 = r4.eN
            com.kwad.components.ad.widget.DownloadProgressView r3 = r4.eI
            if (r5 != r3) goto L73
            goto L74
        L73:
            r2 = 0
        L74:
            r4.a(r1, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.feed.b.c.onClick(android.view.View):void");
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.View
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (z10) {
            if (bh()) {
                return;
            }
            com.kwad.sdk.core.video.videoview.a aVar = this.eN;
            if (aVar != null && this.eO != null) {
                ViewGroup viewGroup = (ViewGroup) aVar.getParent();
                if (this.eN.getParent() != this.eL) {
                    viewGroup.removeView(this.eN);
                    if (this.eL.getTag() != null) {
                        KSRelativeLayout kSRelativeLayout = this.eL;
                        kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
                        this.eL.setTag(null);
                    }
                    this.eL.addView(this.eN);
                    this.eL.setTag(this.eN);
                    com.kwad.sdk.core.response.b.a.K(this.mAdInfo);
                    this.eN.setVideoSoundEnable(this.mIsAudioEnable);
                    this.mAdTemplate.mIsAudioEnable = this.mIsAudioEnable;
                    this.eO.setAdClickListener(this.eS);
                    this.eO.getAdTemplate().mAdWebVideoPageShowing = false;
                    this.eO.rM();
                    this.eO.setAutoRelease(true);
                }
            }
            AdVideoPlayerViewCache.getInstance().remove(com.kwad.sdk.core.response.b.a.K(this.mAdInfo));
            return;
        }
        IAdLiveOfflineView iAdLiveOfflineView = this.eT;
        if (iAdLiveOfflineView == null || iAdLiveOfflineView.getView() == null) {
            return;
        }
        this.eV.onPause();
    }

    public void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        com.kwad.components.core.video.e eVar;
        IAdLivePlayModule iAdLivePlayModule;
        this.dU = ksAdVideoPlayConfig;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0) {
                this.mIsAudioEnable = kSAdVideoPlayConfigImpl.isVideoSoundEnable();
            } else {
                this.mIsAudioEnable = com.kwad.sdk.core.response.b.a.bT(this.mAdInfo);
            }
            this.mAdTemplate.mIsAudioEnable = this.mIsAudioEnable;
            IAdLiveOfflineView iAdLiveOfflineView = this.eT;
            if (iAdLiveOfflineView != null && iAdLiveOfflineView.getView() != null && (iAdLivePlayModule = this.eV) != null) {
                iAdLivePlayModule.setAudioEnabled(g(this.mIsAudioEnable), false);
            } else {
                com.kwad.sdk.core.video.videoview.a aVar = this.eN;
                if (aVar != null) {
                    aVar.setVideoSoundEnable(g(this.mIsAudioEnable));
                }
            }
            if (this.mIsAudioEnable) {
                com.kwad.components.core.s.a.ah(((com.kwad.components.core.widget.b) this).mContext).a(this.f36438fa);
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() == 0 || (eVar = this.eO) == null) {
                return;
            }
            eVar.setDataAutoStart(kSAdVideoPlayConfigImpl.isDataFlowAutoStart());
        }
    }

    public static /* synthetic */ boolean b(c cVar, boolean z10) {
        cVar.eQ = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final View view) {
        view.post(new ay() { // from class: com.kwad.components.ad.feed.b.c.6
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                int width = c.this.eL.getWidth();
                int height = c.this.eL.getHeight();
                if (width == 0 || height == 0) {
                    return;
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (height * 0.5625f), height);
                layoutParams.addRule(13, -1);
                view.setLayoutParams(layoutParams);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(boolean z10) {
        if (!z10) {
            return false;
        }
        if (!com.kwad.sdk.core.config.d.gs()) {
            if (com.kwad.components.core.s.a.ah(((com.kwad.components.core.widget.b) this).mContext).qX()) {
                return !com.kwad.components.core.s.a.ah(((com.kwad.components.core.widget.b) this).mContext).qW();
            }
            return com.kwad.components.core.s.a.ah(((com.kwad.components.core.widget.b) this).mContext).aN(false);
        }
        if (!this.eQ) {
            this.eQ = com.kwad.components.core.s.a.ah(((com.kwad.components.core.widget.b) this).mContext).aN(true);
        }
        return this.eQ;
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

    @Override // com.kwad.components.core.widget.b
    public final void b(@NonNull AdResultData adResultData) {
        super.b((c) adResultData);
        this.eB.setText(com.kwad.components.ad.feed.f.c(this.mAdTemplate));
        this.mLogoView.aD(this.mAdTemplate);
        bg();
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            be();
        } else {
            bd();
        }
        this.eB.setOnClickListener(this);
        this.eL.setOnClickListener(this);
        this.eD.setOnClickListener(this);
        new com.kwad.sdk.widget.f(getContext(), this.eB, this);
        new com.kwad.sdk.widget.f(getContext(), this.eL, this);
        new com.kwad.sdk.widget.f(getContext(), this.eD, this);
        setOnClickListener(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00f1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(@androidx.annotation.NonNull com.kwad.sdk.api.KsAdVideoPlayConfig r10) {
        /*
            Method dump skipped, instructions count: 419
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.feed.b.c.a(com.kwad.sdk.api.KsAdVideoPlayConfig):void");
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.dF(this.mAdTemplate)) {
            a(this.eN, view == this.eI, 153);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        onClick(view);
    }

    private void a(com.kwad.sdk.core.video.videoview.a aVar, boolean z10, final int i10) {
        if (aVar != null || this.eW) {
            String K = com.kwad.sdk.core.response.b.a.K(this.mAdInfo);
            if (!this.eW) {
                this.eO.setAutoRelease(false);
            }
            int i11 = z10 ? 1 : 2;
            if (!this.eW) {
                AdVideoPlayerViewCache.getInstance().a(K, this.eN);
            }
            ba();
            a.C0461a ao = new a.C0461a(getContext()).aq(this.mAdTemplate).b(this.mApkDownloadHelper).ao(z10);
            IAdLivePlayModule iAdLivePlayModule = this.eV;
            com.kwad.components.core.e.d.a.a(ao.v(iAdLivePlayModule == null ? 0L : iAdLivePlayModule.getPlayDuration()).an(i11).as(true).a(new a.b() { // from class: com.kwad.components.ad.feed.b.c.9
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    c.this.aL(i10);
                }
            }));
        }
    }
}
