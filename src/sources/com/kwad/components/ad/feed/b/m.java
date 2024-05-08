package com.kwad.components.ad.feed.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.kwad.components.ad.feed.d;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.j.a;
import com.kwad.components.core.liveEnd.AdLiveEndCommonResultData;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.video.a;
import com.kwad.components.core.webview.b;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveMessageListener;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveShopListener;
import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import com.kwad.components.core.webview.jshandler.ab;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.aj;
import com.kwad.components.core.webview.jshandler.ao;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.ar;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.ax;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.widget.b;
import com.kwad.components.model.FeedType;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveMessageListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveShopListener;
import com.kwad.components.offline.api.core.adlive.model.AdLiveMessageInfo;
import com.kwad.components.offline.api.core.adlive.model.AdLiveShopInfo;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.widget.KSRelativeLayout;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class m extends com.kwad.components.core.widget.b<AdResultData, AdTemplate> implements View.OnClickListener, com.kwad.sdk.widget.c {
    private static final HashMap<Long, Double> fG = new HashMap<>(8);
    private List<Integer> cB;
    private int cP;
    private KsAdVideoPlayConfig dU;
    private KSRelativeLayout eL;
    private ImageView eM;
    private com.kwad.sdk.core.video.videoview.a eN;
    private com.kwad.components.core.video.e eO;
    private d eP;
    private boolean eQ;
    private final a.InterfaceC0479a eS;
    private IAdLiveOfflineView eT;
    private com.kwad.components.core.n.a.a.a eU;
    private IAdLivePlayModule eV;
    private boolean eW;
    private View eX;
    private a.b eY;
    private final AdLivePlayStateListener eZ;
    private d.b ek;
    private long ey;
    private LinearLayout fA;
    private TextView fB;
    private ba fC;
    private aw fD;
    private WebCardRegisterLiveMessageListener fE;
    private WebCardRegisterLiveShopListener fF;
    private boolean fH;
    private String fI;
    private ax.b fJ;
    private ax.a fK;
    private boolean fL;
    private com.kwad.components.core.widget.b fM;
    private float fN;
    private float fO;
    private boolean fP;
    private a fQ;
    private ViewGroup.MarginLayoutParams fR;
    private Handler fS;
    private e fT;
    private ar fU;
    private boolean fV;
    private boolean fW;
    private com.kwad.components.core.webview.b fX;
    private com.kwad.components.core.webview.c fY;
    private b.a fZ;

    /* renamed from: fa, reason: collision with root package name */
    private OfflineOnAudioConflictListener f36451fa;
    private RatioFrameLayout fy;
    private double fz;

    /* renamed from: ga, reason: collision with root package name */
    private IAdLiveEndRequest f36452ga;
    private KsAdWebView mAdWebView;

    @Nullable
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private boolean mIsAudioEnable;
    private final com.kwad.sdk.core.network.l<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData> mNetworking;
    private int mWidth;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface a {
        void c(int i10, String str);
    }

    public m(@NonNull Context context) {
        super(context);
        this.cP = -1;
        this.mIsAudioEnable = false;
        this.fL = false;
        this.fS = new Handler(Looper.getMainLooper());
        this.fV = false;
        this.fW = false;
        this.f36451fa = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.feed.b.m.1
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                m.a(m.this, false);
                if (m.this.eN != null) {
                    m.this.eN.setVideoSoundEnable(false);
                }
                if (m.this.eV != null) {
                    m.this.eV.setAudioEnabled(false, false);
                }
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }
        };
        this.fY = new AnonymousClass11();
        this.fZ = new b.a() { // from class: com.kwad.components.ad.feed.b.m.13
            @Override // com.kwad.components.core.widget.b.a
            public final void onAdClicked() {
                if (m.this.abm != null) {
                    m.this.abm.onAdClicked();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onAdShow() {
                if (m.this.abm != null && m.this.fL) {
                    m.this.abm.onAdShow();
                }
                if (m.this.fL) {
                    com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                    a.C0516a c0516a = new a.C0516a();
                    FeedType fromInt = FeedType.fromInt(m.this.mAdTemplate.type);
                    if (fromInt == FeedType.FEED_TYPE_TEXT_NEW) {
                        fromInt = FeedType.FEED_TYPE_TEXT_BELOW;
                    }
                    c0516a.templateId = String.valueOf(fromInt.getType());
                    bVar.b(c0516a);
                    bVar.v((int) Math.ceil(m.this.fz), m.this.mWidth);
                    com.kwad.components.core.s.b.qY().a(m.this.mAdTemplate, null, bVar);
                    com.kwad.components.ad.feed.monitor.b.a(m.this.mAdTemplate, 1, 2);
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDislikeClicked() {
                if (m.this.abm != null) {
                    m.this.abm.onDislikeClicked();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogDismiss() {
                if (m.this.abm != null) {
                    m.this.abm.onDownloadTipsDialogDismiss();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogShow() {
                if (m.this.abm != null) {
                    m.this.abm.onDownloadTipsDialogShow();
                }
            }
        };
        this.mNetworking = new com.kwad.sdk.core.network.l<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.feed.b.m.15
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: bC, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.core.liveEnd.a createRequest() {
                return new com.kwad.components.core.liveEnd.a(m.this.f36452ga);
            }

            @NonNull
            private static AdLiveEndCommonResultData p(String str) {
                AdLiveEndCommonResultData adLiveEndCommonResultData = new AdLiveEndCommonResultData();
                adLiveEndCommonResultData.parseJson(new JSONObject(str));
                return adLiveEndCommonResultData;
            }

            @Override // com.kwad.sdk.core.network.l
            public final boolean isPostByJson() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ AdLiveEndCommonResultData parseData(String str) {
                return p(str);
            }
        };
        this.eZ = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.feed.b.m.16
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayEnd() {
                super.onLivePlayEnd();
                String bg = com.kwad.sdk.core.response.b.a.bg(m.this.mAdInfo);
                if (TextUtils.isEmpty(bg)) {
                    return;
                }
                com.kwad.components.core.n.a.a.a aVar = (com.kwad.components.core.n.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.a.a.class);
                if (aVar != null) {
                    m.this.f36452ga = aVar.getAdLiveEndRequest(bg);
                }
                m.this.mNetworking.request(new o<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.feed.b.m.16.1
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onStartRequest(@NonNull com.kwad.components.core.liveEnd.a aVar2) {
                        super.onStartRequest(aVar2);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onSuccess(@NonNull com.kwad.components.core.liveEnd.a aVar2, @NonNull AdLiveEndCommonResultData adLiveEndCommonResultData) {
                        super.onSuccess(aVar2, adLiveEndCommonResultData);
                        ax.a aVar3 = new ax.a();
                        aVar3.status = 9;
                        aVar3.totalWatchingDuration = adLiveEndCommonResultData.totalWatchingDuration;
                        aVar3.watchingUserCount = adLiveEndCommonResultData.watchingUserCount;
                        aVar3.displayWatchingUserCount = adLiveEndCommonResultData.displayWatchingUserCount;
                        aVar3.likeUserCount = adLiveEndCommonResultData.likeUserCount;
                        aVar3.displayLikeUserCount = adLiveEndCommonResultData.displayLikeUserCount;
                        aVar3.liveDuration = adLiveEndCommonResultData.liveDuration;
                        if (m.this.fJ == null) {
                            m.this.fK = aVar3;
                        } else {
                            m.this.fJ.a(aVar3);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onError(@NonNull com.kwad.components.core.liveEnd.a aVar2, int i10, String str) {
                        super.onError(aVar2, i10, str);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayProgress(long j10) {
                super.onLivePlayProgress(j10);
                m.this.c(j10);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayResume() {
                com.kwad.components.core.j.a.oG().a(m.this.getCurrentVoiceItem());
                super.onLivePlayResume();
                IAdLivePlayModule iAdLivePlayModule = m.this.eV;
                m mVar = m.this;
                iAdLivePlayModule.setAudioEnabled(mVar.g(mVar.mIsAudioEnable), false);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayStart() {
                com.kwad.components.core.j.a.oG().a(m.this.getCurrentVoiceItem());
                super.onLivePlayStart();
                IAdLivePlayModule iAdLivePlayModule = m.this.eV;
                m mVar = m.this;
                iAdLivePlayModule.setAudioEnabled(mVar.g(mVar.mIsAudioEnable), false);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePrepared() {
                super.onLivePrepared();
                m.this.eV.setAudioEnabled(false, false);
            }
        };
        this.eS = new a.InterfaceC0479a() { // from class: com.kwad.components.ad.feed.b.m.10
            @Override // com.kwad.components.core.video.a.InterfaceC0479a
            public final void a(int i10, ac.a aVar) {
                int i11;
                int i12 = 2;
                boolean z10 = false;
                if (i10 == 1) {
                    i11 = 13;
                } else if (i10 == 2) {
                    i11 = 82;
                } else if (i10 != 3) {
                    i11 = 108;
                } else {
                    i11 = 83;
                    i12 = 1;
                    z10 = true;
                }
                m.this.bw();
                com.kwad.components.core.e.d.a.a(new a.C0461a(m.this.getContext()).aq(m.this.mAdTemplate).b(m.this.mApkDownloadHelper).an(i12).ao(z10).aq(true).am(i11).d(aVar).as(true).a(new a.b() { // from class: com.kwad.components.ad.feed.b.m.10.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        m.this.tj();
                    }
                }));
            }
        };
    }

    private boolean bh() {
        IAdLiveOfflineView iAdLiveOfflineView = this.eT;
        if (iAdLiveOfflineView == null || iAdLiveOfflineView.getView() == null || this.eV == null) {
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
            this.eV.setAudioEnabled(g(this.mIsAudioEnable), false);
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
        bn.postOnUiThread(new ay() { // from class: com.kwad.components.ad.feed.b.m.3
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                m.this.c(view2);
            }
        });
        by();
        if (this.mIsAudioEnable) {
            com.kwad.components.core.s.a.ah(((com.kwad.components.core.widget.b) this).mContext).a(this.f36451fa);
        }
        return adLivePlayModule;
    }

    private void bj() {
        String url = com.kwad.sdk.core.response.b.a.br(this.mAdInfo).getUrl();
        this.eM.setVisibility(0);
        this.eX.setVisibility(0);
        if (!TextUtils.isEmpty(url)) {
            this.eM.setImageDrawable(null);
            KSImageLoader.loadImage(this.eM, url, this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.feed.b.m.6
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

    private void bt() {
        this.fS.postDelayed(new ay() { // from class: com.kwad.components.ad.feed.b.m.12
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                m.this.mAdWebView.stopLoading();
                m.this.mAdWebView.setVisibility(8);
                m.this.f("0", 1);
            }
        }, 2500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bu() {
        float cL = com.kwad.sdk.core.response.b.b.cL(this.mAdTemplate);
        d.b bVar = new d.b() { // from class: com.kwad.components.ad.feed.b.m.17
            @Override // com.kwad.components.ad.feed.d.b
            public final boolean b(final double d10) {
                if (!bq.o(m.this.fy, (int) (com.kwad.sdk.core.config.d.Cl() * 100.0f))) {
                    return false;
                }
                com.kwad.components.core.e.d.a.a(new a.C0461a(m.this.getContext()).aq(m.this.mAdTemplate).b(m.this.mApkDownloadHelper).an(2).ao(false).aq(false).am(157).al(5).as(true).a(new a.b() { // from class: com.kwad.components.ad.feed.b.m.17.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        com.kwad.sdk.core.e.c.d("FeedWebView", "convertEnable End" + com.kwad.sdk.core.response.b.e.ea(m.this.mAdTemplate));
                        com.kwad.sdk.core.adlog.c.b bVar2 = new com.kwad.sdk.core.adlog.c.b();
                        bVar2.l(d10);
                        bVar2.cK(157);
                        m.this.c(bVar2);
                    }
                }));
                return true;
            }
        };
        this.ek = bVar;
        com.kwad.components.ad.feed.d.a(cL, ((com.kwad.components.core.widget.b) this).mContext, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bw() {
        if (this.fP) {
            return;
        }
        this.fP = true;
        com.kwad.components.ad.feed.monitor.b.a(this.mAdTemplate, 2, getStayTime());
    }

    private boolean bx() {
        return this.cP == 1;
    }

    private void by() {
        this.eT.registerLiveMessageListener(new AdLiveMessageListener() { // from class: com.kwad.components.ad.feed.b.m.4
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveMessageListener
            public final void handleAdLiveMessage(List<AdLiveMessageInfo> list) {
                if (m.this.fE != null) {
                    m.this.fE.n(list);
                }
            }
        });
        this.eT.registerLiveShopListener(new AdLiveShopListener() { // from class: com.kwad.components.ad.feed.b.m.5
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveShopListener
            public final void handleAdLiveShop(AdLiveShopInfo adLiveShopInfo) {
                if (m.this.fF != null) {
                    m.this.fF.a(adLiveShopInfo);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a.b getCurrentVoiceItem() {
        if (this.eY == null) {
            this.eY = new a.b(new a.c() { // from class: com.kwad.components.ad.feed.b.m.2
                @Override // com.kwad.components.core.j.a.c
                public final void bk() {
                    if (m.this.eW) {
                        if (m.this.eV == null) {
                            m mVar = m.this;
                            mVar.eV = mVar.bi();
                        }
                        IAdLivePlayModule iAdLivePlayModule = m.this.eV;
                        m mVar2 = m.this;
                        iAdLivePlayModule.setAudioEnabled(mVar2.g(mVar2.mIsAudioEnable), false);
                        return;
                    }
                    if (m.this.eN != null) {
                        com.kwad.sdk.core.video.videoview.a aVar = m.this.eN;
                        m mVar3 = m.this;
                        aVar.setVideoSoundEnable(mVar3.g(mVar3.mIsAudioEnable));
                    }
                }
            });
        }
        return this.eY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ao.a getOpenNewPageListener() {
        return new ao.a() { // from class: com.kwad.components.ad.feed.b.m.18
            @Override // com.kwad.components.core.webview.jshandler.ao.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                AdWebViewActivityProxy.launch(((com.kwad.components.core.widget.b) m.this).mContext, new AdWebViewActivityProxy.a.C0472a().as(bVar.title).at(bVar.url).aC(true).as(m.this.mAdTemplate).pl());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ax.c getRegisterLiveListener() {
        return new ax.c() { // from class: com.kwad.components.ad.feed.b.m.14
            @Override // com.kwad.components.core.webview.jshandler.ax.c
            public final void a(ax.b bVar) {
                m.this.fJ = bVar;
                if (m.this.fK != null) {
                    m.this.fJ.a(m.this.fK);
                    m.this.fK = null;
                }
            }
        };
    }

    private a.b getVideoPlayCallback() {
        return new a.b() { // from class: com.kwad.components.ad.feed.b.m.7
            private boolean cC = false;

            @Override // com.kwad.components.core.video.a.c
            public final void bl() {
                if (!this.cC) {
                    this.cC = true;
                    com.kwad.components.core.o.a.qi().b(m.this.mAdTemplate, System.currentTimeMillis(), 1);
                }
                com.kwad.sdk.core.video.videoview.a aVar = m.this.eN;
                m mVar = m.this;
                aVar.setVideoSoundEnable(mVar.g(mVar.mIsAudioEnable));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void bm() {
                com.kwad.sdk.core.adlog.c.bL(m.this.mAdTemplate);
                m.this.fC.aQ(9);
                m.this.eL.setVisibility(8);
                if (com.kwad.components.ad.feed.a.b.aW() && m.this.eP == null && !m.this.fV) {
                    m.this.eP = new d(((com.kwad.components.core.widget.b) m.this).mContext);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    m mVar = m.this;
                    mVar.addView(mVar.eP, layoutParams);
                    m.this.eP.bn();
                }
            }

            @Override // com.kwad.components.core.video.a.c
            public final void e(long j10) {
                m.this.c(j10);
            }

            @Override // com.kwad.components.core.video.a.b
            public final void onVideoPlayError(int i10, int i11) {
                com.kwad.components.ad.feed.monitor.b.a(m.this.mAdTemplate, 2, 1, com.kwad.sdk.core.response.b.a.K(m.this.mAdInfo), i10 + " " + i11, SystemClock.elapsedRealtime() - m.this.ey);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                com.kwad.components.core.j.a.oG().a(m.this.getCurrentVoiceItem());
                com.kwad.components.ad.feed.monitor.b.a(m.this.mAdTemplate, 1, 1, com.kwad.sdk.core.response.b.a.K(m.this.mAdInfo), null, SystemClock.elapsedRealtime() - m.this.ey);
                com.kwad.sdk.core.adlog.c.bK(m.this.mAdTemplate);
                m.this.fC.aQ(3);
                if (m.this.eP != null && (m.this.eP.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) m.this.eP.getParent()).removeView(m.this.eP);
                    m.this.eP.bo();
                    m.this.eP = null;
                }
                if (m.this.fT == null && com.kwad.sdk.core.response.b.b.cJ(m.this.mAdTemplate) && m.this.fV) {
                    m.this.fT = new e(((com.kwad.components.core.widget.b) m.this).mContext);
                    m.this.eL.addView(m.this.fT, new FrameLayout.LayoutParams(-1, -1));
                    m.this.fT.setOnViewEventListener(new com.kwad.sdk.widget.c() { // from class: com.kwad.components.ad.feed.b.m.7.1
                        @Override // com.kwad.sdk.widget.c
                        public final void a(View view) {
                            if (com.kwad.sdk.core.response.b.b.cK(m.this.mAdTemplate)) {
                                return;
                            }
                            m.this.v(158);
                        }

                        @Override // com.kwad.sdk.widget.c
                        public final void b(View view) {
                            if (com.kwad.sdk.core.response.b.b.cK(m.this.mAdTemplate) || !com.kwad.sdk.core.response.b.d.dF(m.this.mAdTemplate)) {
                                return;
                            }
                            m.this.v(153);
                        }
                    });
                    m.this.fT.a(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.b.m.7.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            m.this.fU.aP(1);
                            m.this.eL.removeView(m.this.fT);
                        }
                    });
                }
            }
        };
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.h.c
    public final void aM() {
        super.aM();
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

    @Override // com.kwad.components.core.widget.b
    public final void bc() {
        com.kwad.components.ad.feed.monitor.b.aZ();
        this.fy = (RatioFrameLayout) findViewById(R.id.ksad_container);
        this.eL = (KSRelativeLayout) findViewById(R.id.ksad_video_container);
        this.fA = (LinearLayout) findViewById(R.id.ksad_video_immerse_text_container);
        this.fB = (TextView) findViewById(R.id.ksad_video_immerse_text);
        this.eM = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.eX = findViewById(R.id.ksad_live_end_bg_mantle);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bf() {
        super.bf();
        if (this.cP == 1 || this.fH) {
            return;
        }
        this.mAdWebView.stopLoading();
        this.mAdWebView.setVisibility(8);
        f("0", 1);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bv() {
        aw awVar;
        b.a aVar;
        if (!this.mAdTemplate.mPvReported && (aVar = this.abm) != null && this.fL) {
            aVar.onAdShow();
            com.kwad.components.ad.feed.monitor.b.a((AdTemplate) this.mAdTemplate, 1, 2);
        }
        if (this.fL || (awVar = this.fD) == null) {
            return;
        }
        awVar.ss();
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_webview;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (com.kwad.sdk.core.config.d.Co() && com.kwad.sdk.core.response.b.d.dF(this.mAdTemplate)) {
            if (com.kwad.sdk.core.response.b.b.cf(this.mAdTemplate) == null) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            a(motionEvent);
            if ((action == 2 || action == 3) && this.mAdWebView != null && !this.fL && Math.abs(motionEvent.getX() - this.fN) > 0.0f) {
                this.mAdWebView.requestDisallowInterceptTouchEvent(true);
                double abs = Math.abs(motionEvent.getX() - this.fN);
                double abs2 = Math.abs(motionEvent.getY() - this.fO);
                if (Math.tan(r1.maxRange) * abs < abs2 || Math.tan(r1.minRange) * abs < abs2) {
                    this.mAdWebView.requestDisallowInterceptTouchEvent(false);
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.View
    public final void onWindowFocusChanged(boolean z10) {
        IAdLivePlayModule iAdLivePlayModule;
        ViewGroup viewGroup;
        super.onWindowFocusChanged(z10);
        if (z10) {
            if (bh()) {
                return;
            }
            com.kwad.sdk.core.video.videoview.a aVar = this.eN;
            if (aVar != null && (viewGroup = (ViewGroup) aVar.getParent()) != this.eL) {
                viewGroup.removeView(this.eN);
                if (this.eL.getTag() != null) {
                    KSRelativeLayout kSRelativeLayout = this.eL;
                    kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
                    this.eL.setTag(null);
                }
                this.eL.addView(this.eN);
                this.eL.setTag(this.eN);
                this.eN.setVideoSoundEnable(this.mIsAudioEnable);
                this.eO.setVideoPlayCallback(getVideoPlayCallback());
                this.eO.setAdClickListener(this.eS);
                this.eO.getAdTemplate().mAdWebVideoPageShowing = false;
                this.eO.rM();
                this.eO.setAutoRelease(true);
            }
            AdVideoPlayerViewCache.getInstance().remove(com.kwad.sdk.core.response.b.a.K(this.mAdInfo));
            return;
        }
        IAdLiveOfflineView iAdLiveOfflineView = this.eT;
        if (iAdLiveOfflineView == null || iAdLiveOfflineView.getView() == null || (iAdLivePlayModule = this.eV) == null) {
            return;
        }
        iAdLivePlayModule.onPause();
    }

    @Override // com.kwad.components.core.widget.b
    public final void setMargin(int i10) {
    }

    public final void setPreloadListener(a aVar) {
        a aVar2 = this.fQ;
        if (aVar2 != null) {
            aVar2.c(this.cP == 1 ? 2 : 1, "");
        }
        this.fQ = aVar;
    }

    public final void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        com.kwad.components.core.video.e eVar;
        IAdLivePlayModule iAdLivePlayModule;
        this.dU = ksAdVideoPlayConfig;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0) {
                boolean isVideoSoundEnable = kSAdVideoPlayConfigImpl.isVideoSoundEnable();
                this.mIsAudioEnable = isVideoSoundEnable;
                R r10 = this.mAdTemplate;
                if (r10 != 0) {
                    r10.mIsAudioEnable = isVideoSoundEnable;
                }
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
                    com.kwad.components.core.s.a.ah(((com.kwad.components.core.widget.b) this).mContext).a(this.f36451fa);
                }
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() == 0 || (eVar = this.eO) == null) {
                return;
            }
            eVar.setDataAutoStart(kSAdVideoPlayConfigImpl.isDataFlowAutoStart());
        }
    }

    public final void setWidth(int i10) {
        if (i10 <= 0) {
            i10 = getContext().getResources().getDisplayMetrics().widthPixels;
        }
        this.mWidth = i10;
    }

    private void ay() {
        com.kwad.components.core.webview.b bVar = this.fX;
        if (bVar != null) {
            bVar.jp();
        }
        this.mAdWebView.setVisibility(4);
        this.mAdWebView.setBackgroundColor(0);
        this.fX = new com.kwad.components.core.webview.b();
        this.fX.a(new b.a().az(this.mAdTemplate).aF(com.kwad.sdk.core.response.b.b.cG(this.mAdTemplate)).d(this.mAdWebView).k(this.fy).f(this.mApkDownloadHelper).a(this.fY));
        this.mAdWebView.loadUrl(com.kwad.sdk.core.response.b.b.cG(this.mAdTemplate));
        R r10 = this.mAdTemplate;
        com.kwad.components.ad.feed.monitor.b.a(r10, com.kwad.sdk.core.response.b.b.cG(r10));
        bt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, int i10) {
        int i11;
        com.kwad.sdk.core.e.c.d("FeedWebView", "handleWebViewError " + str);
        this.fS.removeCallbacksAndMessages(null);
        if (this.fH) {
            return;
        }
        this.fH = true;
        if (this.mAdWebView != null) {
            R r10 = this.mAdTemplate;
            com.kwad.components.ad.feed.monitor.b.a(r10, com.kwad.sdk.core.response.b.b.cG(r10), System.currentTimeMillis() - this.mAdWebView.getLoadTime(), i10);
        }
        com.kwad.components.core.o.a qi = com.kwad.components.core.o.a.qi();
        AdTemplate adTemplate = this.mAdTemplate;
        qi.b(adTemplate, com.kwad.sdk.core.response.b.b.cG(adTemplate), str);
        try {
            i11 = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            com.kwad.sdk.core.e.c.d("FeedWebView", "handleWebViewError errorCode exception" + str);
            i11 = 0;
        }
        com.kwad.components.ad.feed.monitor.b.b(i11, com.kwad.sdk.core.response.b.a.be(this.mAdInfo), this.mAdTemplate);
        a aVar = this.fQ;
        if (aVar != null) {
            aVar.c(1, str);
        }
        this.fQ = null;
        if (this.fM == null) {
            this.fL = true;
            com.kwad.components.core.widget.b.c(this);
            int be2 = com.kwad.sdk.core.response.b.a.be(this.mAdInfo);
            IAdLivePlayModule iAdLivePlayModule = this.eV;
            if (iAdLivePlayModule != null) {
                iAdLivePlayModule.setAudioEnabled(false, false);
                this.eV.onDestroy();
                this.eV = null;
            }
            IAdLiveOfflineView iAdLiveOfflineView = this.eT;
            if (iAdLiveOfflineView != null) {
                iAdLiveOfflineView.onDestroy();
                this.eT = null;
            }
            com.kwad.components.core.widget.b a10 = com.kwad.components.ad.feed.b.a(((com.kwad.components.core.widget.b) this).mContext, FeedType.fromInt(this.mAdTemplate.type), be2);
            this.fM = a10;
            if (a10 != null) {
                this.fM.setMargin(com.kwad.sdk.d.a.a.a(((com.kwad.components.core.widget.b) this).mContext, 16.0f));
                this.fy.removeAllViews();
                this.fy.setRatio(ShadowDrawableWrapper.COS_45);
                KsAdWebView ksAdWebView = this.mAdWebView;
                if (ksAdWebView != null) {
                    ksAdWebView.setVisibility(8);
                }
                this.eL.setVisibility(8);
                this.fM.setInnerAdInteractionListener(this.fZ);
                this.fy.addView(this.fM);
                this.fM.b((com.kwad.components.core.widget.b) this.mAdResultData);
                com.kwad.components.core.widget.b bVar = this.fM;
                if (bVar instanceof c) {
                    ((c) bVar).a(this.dU);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(boolean z10) {
        if (!z10) {
            return false;
        }
        if (this.eY != null) {
            com.kwad.components.core.j.a.oG();
            if (!com.kwad.components.core.j.a.b(this.eY)) {
                return false;
            }
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

    private static float h(AdTemplate adTemplate) {
        int i10 = adTemplate.type;
        if (i10 == 1) {
            return 0.6013f;
        }
        return (i10 == 2 || i10 == 3) ? 0.283f : 0.968f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void i(AdTemplate adTemplate) {
        com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        this.mApkDownloadHelper = cVar;
        cVar.setOnShowListener(this);
        this.mApkDownloadHelper.setOnDismissListener(this);
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        if (fG.get(Long.valueOf(this.mAdTemplate.posId)) != null) {
            this.fy.setRatio(r5.floatValue());
        } else if (com.kwad.sdk.core.response.b.b.cM(this.mAdTemplate) > ShadowDrawableWrapper.COS_45) {
            this.fy.setRatio(com.kwad.sdk.core.response.b.b.cM(this.mAdTemplate));
        } else if (this.fy.getRatio() == ShadowDrawableWrapper.COS_45) {
            this.fy.setRatio(h(this.mAdTemplate));
        }
        com.kwad.components.core.n.a.a.a aVar = (com.kwad.components.core.n.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.a.a.class);
        this.eU = aVar;
        if (aVar != null && aVar.oK() && com.kwad.sdk.core.response.b.a.cL(this.mAdInfo)) {
            this.eW = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(final int i10) {
        bw();
        com.kwad.components.core.e.d.a.a(new a.C0461a(getContext()).aq(this.mAdTemplate).b(this.mApkDownloadHelper).an(1).ao(true).am(i10).al(5).aq(false).as(true).a(new a.b() { // from class: com.kwad.components.ad.feed.b.m.8
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                m.this.aL(i10);
            }
        }));
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void ac() {
        super.ac();
        if (this.ek != null) {
            com.kwad.components.ad.feed.d.a(com.kwad.sdk.core.response.b.b.cL(this.mAdTemplate), ((com.kwad.components.core.widget.b) this).mContext, this.ek);
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void ad() {
        super.ad();
        this.fS.removeCallbacksAndMessages(null);
        com.kwad.sdk.utils.l.ej(this.mAdTemplate);
        d.b bVar = this.ek;
        if (bVar != null) {
            com.kwad.components.ad.feed.d.a(bVar);
        }
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
        this.fJ = null;
        this.fK = null;
    }

    public static /* synthetic */ boolean d(m mVar, boolean z10) {
        mVar.fV = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view) {
        int width = this.eL.getWidth();
        int height = this.eL.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (height * 0.5625f), height);
        layoutParams.addRule(13, -1);
        view.setLayoutParams(layoutParams);
    }

    @Override // com.kwad.components.core.widget.b
    public final void b(@NonNull AdResultData adResultData) {
        AdTemplate n10 = com.kwad.sdk.core.response.b.c.n(adResultData);
        g(n10);
        n10.realShowType = 2;
        super.b((m) adResultData);
        if (this.fH) {
            com.kwad.components.core.widget.b bVar = this.fM;
            if (bVar != null) {
                bVar.b((com.kwad.components.core.widget.b) adResultData);
                com.kwad.components.core.widget.b bVar2 = this.fM;
                if (bVar2 instanceof c) {
                    ((c) bVar2).a(this.dU);
                    return;
                }
                return;
            }
            return;
        }
        if (!com.kwad.sdk.core.response.b.b.cN(this.mAdTemplate)) {
            f("0", 0);
            return;
        }
        if (!bx()) {
            i(this.mAdTemplate);
        }
        try {
            String str = this.fI;
            if (str == null || !str.equals(n10.mOriginJString)) {
                if (bx()) {
                    this.mAdWebView.reload();
                } else {
                    this.cP = -2;
                    ay();
                }
            }
        } catch (Throwable unused) {
            f("0", 0);
        }
        this.fI = n10.mOriginJString;
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

    private void g(AdTemplate adTemplate) {
        if (this.fW) {
            return;
        }
        if (com.kwad.sdk.core.response.b.a.cL(com.kwad.sdk.core.response.b.e.dQ(adTemplate))) {
            this.mAdWebView = (KsAdWebView) findViewById(R.id.ksad_web_bottom_card_webView);
        } else {
            this.mAdWebView = (KsAdWebView) findViewById(R.id.ksad_web_default_bottom_card_webView);
        }
        this.fW = true;
    }

    /* renamed from: com.kwad.components.ad.feed.b.m$11, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class AnonymousClass11 extends com.kwad.components.core.webview.c {
        public AnonymousClass11() {
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.components.core.webview.a aVar, com.kwad.sdk.core.webview.b bVar) {
            bVar.aDL = false;
            aVar.a(new com.kwad.components.core.webview.jshandler.f(m.this.mAdTemplate.loadType));
            m.this.fC = new ba();
            aVar.a(m.this.fC);
            aVar.a(new ao(m.this.getOpenNewPageListener()));
            aVar.a(new WebCardVideoPositionHandler(new WebCardVideoPositionHandler.a() { // from class: com.kwad.components.ad.feed.b.m.11.1
                @Override // com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler.a
                public final void a(WebCardVideoPositionHandler.VideoPosition videoPosition) {
                    if (m.this.mAdInfo != null) {
                        if (com.kwad.sdk.core.response.b.a.bc(m.this.mAdInfo) || m.this.eW) {
                            m mVar = m.this;
                            mVar.fR = (ViewGroup.MarginLayoutParams) mVar.eL.getLayoutParams();
                            int ceil = (int) Math.ceil(m.this.fz);
                            int i10 = m.this.mWidth;
                            if (videoPosition.widthRation == ShadowDrawableWrapper.COS_45) {
                                videoPosition.widthRation = 0.9200000166893005d;
                                videoPosition.leftMarginRation = 0.03999999910593033d;
                            }
                            m.this.fR.topMargin = (int) (videoPosition.topMarginRation * ceil);
                            double d10 = i10;
                            m.this.fR.leftMargin = (int) (videoPosition.leftMarginRation * d10);
                            m.this.fR.width = (int) (d10 * videoPosition.widthRation);
                            m.this.fR.height = (int) (m.this.fR.width * videoPosition.heightWidthRation);
                            m.this.eL.setRadius(videoPosition.borderRadius);
                            m.this.eL.setLayoutParams(m.this.fR);
                            m.this.eL.setVisibility(0);
                            if ((m.this.dU instanceof KSAdVideoPlayConfigImpl) && ((KSAdVideoPlayConfigImpl) m.this.dU).getVideoSoundValue() != 0) {
                                m mVar2 = m.this;
                                mVar2.mIsAudioEnable = mVar2.dU.isVideoSoundEnable();
                            } else {
                                m mVar3 = m.this;
                                mVar3.mIsAudioEnable = com.kwad.sdk.core.response.b.a.bT(mVar3.mAdInfo);
                            }
                            m.this.mAdTemplate.mIsAudioEnable = m.this.mIsAudioEnable;
                            m mVar4 = m.this;
                            mVar4.cB = com.kwad.sdk.core.response.b.a.bm(mVar4.mAdInfo);
                            if (m.this.eW) {
                                if (m.this.eV != null) {
                                    IAdLivePlayModule iAdLivePlayModule = m.this.eV;
                                    m mVar5 = m.this;
                                    iAdLivePlayModule.setAudioEnabled(mVar5.g(mVar5.mIsAudioEnable), false);
                                    return;
                                }
                                return;
                            }
                            m mVar6 = m.this;
                            mVar6.a(mVar6.dU);
                        }
                    }
                }
            }));
            aVar.a(new ab(bVar, new ab.a() { // from class: com.kwad.components.ad.feed.b.m.11.2
                @Override // com.kwad.components.core.webview.jshandler.ab.a
                public final void bA() {
                    m.this.fS.post(new ay() { // from class: com.kwad.components.ad.feed.b.m.11.2.1
                        @Override // com.kwad.sdk.utils.ay
                        public final void doTask() {
                            m.this.tk();
                        }
                    });
                }
            }));
            aVar.a(new com.kwad.components.core.webview.jshandler.ay(new ay.a() { // from class: com.kwad.components.ad.feed.b.m.11.3
                @Override // com.kwad.components.core.webview.jshandler.ay.a
                public final void bB() {
                    m.d(m.this, true);
                    m.this.bu();
                }
            }));
            m.this.fU = new ar();
            aVar.a(m.this.fU);
            if (m.this.eW) {
                aVar.a(new com.kwad.components.core.webview.jshandler.e(1, 1));
                m.this.fF = new WebCardRegisterLiveShopListener();
                m.this.fE = new WebCardRegisterLiveMessageListener();
                aVar.a(m.this.fF);
                aVar.a(m.this.fE);
                aVar.a(new ax(m.this.getRegisterLiveListener()));
            }
        }

        @Override // com.kwad.components.core.webview.c
        public final void g(int i10, String str) {
            m.this.f("1", 2);
        }

        @Override // com.kwad.components.core.webview.c
        public final void onAdShow() {
            super.onAdShow();
            bn.runOnUiThread(new com.kwad.sdk.utils.ay() { // from class: com.kwad.components.ad.feed.b.m.11.4
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    if (m.this.abm == null || m.this.fL) {
                        return;
                    }
                    m.this.abm.onAdShow();
                    com.kwad.components.ad.feed.monitor.b.a(m.this.mAdTemplate, 2, 2);
                }
            });
        }

        @Override // com.kwad.components.core.webview.c
        public final void onPageFinished() {
            com.kwad.components.ad.feed.monitor.b.a(m.this.mAdTemplate, com.kwad.sdk.core.response.b.b.cG(m.this.mAdTemplate), System.currentTimeMillis() - m.this.mAdWebView.getLoadTime());
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(aw awVar) {
            m.this.fD = awVar;
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(aj.a aVar) {
            if (m.this.fL) {
                return;
            }
            m.this.mAdWebView.setVisibility(0);
            if (m.this.fz == ShadowDrawableWrapper.COS_45) {
                m.this.fz = aVar.height;
                m.this.fy.setRatio((float) r0);
                m.fG.put(Long.valueOf(m.this.mAdTemplate.posId), Double.valueOf(aVar.height / m.this.mWidth));
            }
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(ac.a aVar) {
            aVar.height = 0;
            aVar.width = m.this.mWidth;
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            m.this.bw();
            int i10 = aVar.XC;
            if (aVar.Kr) {
                i10 = aVar.XA ? 1 : 2;
            }
            boolean bc2 = com.kwad.sdk.core.response.b.a.bc(m.this.mAdInfo);
            com.kwad.sdk.core.webview.d.b.c cVar = aVar.XD;
            com.kwad.components.core.e.d.a.a(new a.C0461a(m.this.getContext()).aq(m.this.mAdTemplate).b(m.this.mApkDownloadHelper).ao(m.a(m.this, aVar)).an(i10).am(aVar.kl).ag((cVar == null || TextUtils.isEmpty(cVar.KG)) ? "" : aVar.XD.KG).al(5).au(aVar.Kr).as(bc2).v(m.this.eV == null ? 0L : m.this.eV.getPlayDuration()).aq(true).a(new a.b() { // from class: com.kwad.components.ad.feed.b.m.11.5
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    if (m.this.abm != null) {
                        m.this.abm.onAdClicked();
                    }
                }
            }));
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(aq.a aVar) {
            if (m.this.fH) {
                return;
            }
            m.this.cP = aVar.status;
            if (m.this.cP != 1) {
                m.this.f("3", 3);
                return;
            }
            m.this.fS.removeCallbacksAndMessages(null);
            if (m.this.fM != null) {
                m.this.fM.setVisibility(8);
            }
            m.this.mAdWebView.setVisibility(0);
            com.kwad.components.core.o.a.qi().au(m.this.mAdTemplate);
            if (m.this.fQ != null) {
                m.this.fQ.c(2, "");
            }
        }
    }

    public static /* synthetic */ boolean a(m mVar, com.kwad.sdk.core.webview.d.b.a aVar) {
        return b(aVar);
    }

    public static /* synthetic */ boolean a(m mVar, boolean z10) {
        mVar.eQ = false;
        return false;
    }

    private void a(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return;
        }
        this.fN = motionEvent.getX();
        this.fO = motionEvent.getY();
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.dF(this.mAdTemplate)) {
            if (view == this.eL || view == this.fB) {
                a(this.eN, 153);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00a2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(@androidx.annotation.NonNull com.kwad.sdk.api.KsAdVideoPlayConfig r11) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.feed.b.m.a(com.kwad.sdk.api.KsAdVideoPlayConfig):void");
    }

    private static boolean b(com.kwad.sdk.core.webview.d.b.a aVar) {
        if (aVar.Kr) {
            return aVar.XA;
        }
        return aVar.XC == 1;
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        if (view == this.eL) {
            if (this.eN.isIdle()) {
                com.kwad.sdk.utils.l.ek(this.mAdTemplate);
                this.eN.setKsPlayLogParam(com.kwad.sdk.contentalliance.a.a.a.bD(this.mAdTemplate));
                this.eN.start();
                return;
            }
            a(this.eN, 100);
            return;
        }
        if (view == this.fB) {
            a(this.eN, 25);
        }
    }

    private void a(com.kwad.sdk.core.video.videoview.a aVar, final int i10) {
        if (aVar != null) {
            String K = com.kwad.sdk.core.response.b.a.K(this.mAdInfo);
            this.eO.setAutoRelease(false);
            AdVideoPlayerViewCache.getInstance().a(K, this.eN);
            FeedType.fromInt(this.mAdTemplate.type);
            bw();
            com.kwad.components.core.e.d.a.a(new a.C0461a(getContext()).aq(this.mAdTemplate).b(this.mApkDownloadHelper).an(2).as(com.kwad.sdk.core.response.b.a.bc(this.mAdInfo)).a(new a.b() { // from class: com.kwad.components.ad.feed.b.m.9
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    m.this.aL(i10);
                }
            }));
        }
    }
}
