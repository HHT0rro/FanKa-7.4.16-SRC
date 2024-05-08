package com.huawei.hms.ads.template.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.BannerAdSize;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.hms.ads.VideoOperator;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.dg;
import com.huawei.hms.ads.dq;
import com.huawei.hms.ads.dx;
import com.huawei.hms.ads.dy;
import com.huawei.hms.ads.ea;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.lg;
import com.huawei.hms.ads.nativead.NativeAdConfiguration;
import com.huawei.hms.ads.template.DTManager;
import com.huawei.hms.ads.template.R;
import com.huawei.hms.ads.template.util.ImageLoader;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.inter.data.d;
import com.huawei.openalliance.ad.inter.data.g;
import com.huawei.openalliance.ad.inter.data.n;
import com.huawei.openalliance.ad.inter.m;
import com.huawei.openalliance.ad.utils.aj;
import com.huawei.openalliance.ad.utils.at;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.f;
import com.huawei.openalliance.ad.utils.l;
import com.huawei.openalliance.ad.views.NativeVideoView;
import com.huawei.openalliance.ad.views.PPSNativeView;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@GlobalApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class NativeTemplateView extends PPSNativeView {
    private DynamicTemplateView B;
    private DTAppDownloadButton C;
    private boolean D;
    private int F;
    private n I;
    private boolean L;
    private OnEventListener S;

    /* renamed from: a, reason: collision with root package name */
    private String f29387a;

    /* renamed from: b, reason: collision with root package name */
    private BannerAdSize f29388b;

    /* renamed from: c, reason: collision with root package name */
    private AdListener f29389c;

    /* renamed from: d, reason: collision with root package name */
    private NativeAdConfiguration f29390d;

    /* renamed from: e, reason: collision with root package name */
    private VideoOperator f29391e;

    /* renamed from: f, reason: collision with root package name */
    private VideoOperator.VideoLifecycleListener f29392f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f29393g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f29394h;

    /* renamed from: i, reason: collision with root package name */
    private int f29395i;

    @GlobalApi
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface OnEventListener {
        void onHandleClickEvent(View view, String str);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a implements View.OnClickListener {
        private a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag(R.id.hiad_pps_view_store_click_event);
            if (tag instanceof String) {
                gl.Code("NativeTemplateView", "handle click event: %s", tag);
                if ("dislike_ad".equals(tag)) {
                    if (ea.Code(NativeTemplateView.this.getContext()).V()) {
                        NativeTemplateView.this.F();
                        NativeTemplateView.this.destroy();
                        NativeTemplateView.this.removeAllViews();
                    } else {
                        NativeTemplateView.this.Code();
                    }
                }
                if (NativeTemplateView.this.S != null) {
                    NativeTemplateView.this.S.onHandleClickEvent(view, (String) tag);
                }
            }
        }
    }

    @GlobalApi
    public NativeTemplateView(Context context) {
        super(context);
        this.L = true;
        this.f29393g = true;
        this.f29394h = false;
        L();
        setImageLoader(context);
        this.f29395i = l.I(context);
    }

    @GlobalApi
    public NativeTemplateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.L = true;
        this.f29393g = true;
        this.f29394h = false;
        L();
        setImageLoader(context);
    }

    @GlobalApi
    public NativeTemplateView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.L = true;
        this.f29393g = true;
        this.f29394h = false;
        L();
        setImageLoader(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Code(Context context, Integer num) {
        if (num != null && context != null) {
            Map<Integer, String> map = dg.V;
            if (map.containsKey(num)) {
                return Code(context.getApplicationContext(), map.get(num));
            }
        }
        gl.I("NativeTemplateView", "load default template error" + ((Object) num));
        return null;
    }

    private String Code(Context context, String str) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            inputStream = context.getResources().getAssets().open(str);
        } catch (IOException unused) {
            inputStream = null;
        } catch (Throwable th) {
            th = th;
            at.Code((Closeable) inputStream2);
            throw th;
        }
        try {
            try {
                String Code = at.Code(inputStream);
                at.Code((Closeable) inputStream);
                return Code;
            } catch (Throwable th2) {
                th = th2;
                inputStream2 = inputStream;
                at.Code((Closeable) inputStream2);
                throw th;
            }
        } catch (IOException unused2) {
            gl.Z("NativeTemplateView", "loadTemplateFromAssets fail");
            at.Code((Closeable) inputStream);
            return null;
        }
    }

    private void Code(Context context, String str, BannerAdSize bannerAdSize) {
        removeAllViews();
        long currentTimeMillis = System.currentTimeMillis();
        this.B = dq.Code(context).Code(str);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (bannerAdSize != null) {
            int width = bannerAdSize.getWidth();
            int height = bannerAdSize.getHeight();
            if (width != 0) {
                layoutParams.width = width;
            }
            if (height != 0) {
                layoutParams.height = height;
            }
        }
        Z();
        addView(this.B, layoutParams);
        if (gl.Code()) {
            gl.Code("NativeTemplateView", "inflateTemplateView end duration: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        render();
    }

    private void Code(DTNativeVideoView dTNativeVideoView) {
        int i10;
        DTRelativeLayout relativeLayout = this.B.getRelativeLayout();
        if (relativeLayout == null) {
            return;
        }
        if (relativeLayout.getHeight() == 0) {
            relativeLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            i10 = relativeLayout.getMeasuredHeight();
        } else {
            i10 = relativeLayout.getLayoutParams().height;
        }
        dTNativeVideoView.getLayoutParams().height = this.f29388b.getHeight() - i10;
        dTNativeVideoView.getLayoutParams().width = (int) (dTNativeVideoView.getLayoutParams().height * (this.I.Z().get(0).C() / this.I.Z().get(0).B()));
    }

    private void Code(m mVar, AdParam adParam) {
        if (adParam == null) {
            return;
        }
        if (adParam.Code() != null) {
            mVar.Code(adParam.Code());
        }
        mVar.Code(adParam.getGender());
        mVar.V(adParam.getTargetingContentUrl());
        mVar.I(adParam.I());
        mVar.Code(adParam.getKeywords());
        mVar.Code(dy.Code(adParam.V()));
        mVar.Z(adParam.C());
        HiAd.getInstance(getContext()).setCountryCode(adParam.Z());
    }

    private void Code(NativeVideoView nativeVideoView) {
        int i10;
        if (nativeVideoView == null) {
            return;
        }
        NativeAdConfiguration nativeAdConfiguration = this.f29390d;
        if (nativeAdConfiguration == null || nativeAdConfiguration.getVideoConfiguration() == null) {
            i10 = 1;
        } else {
            nativeVideoView.Code(this.f29390d.getVideoConfiguration().isStartMuted());
            i10 = this.f29390d.getVideoConfiguration().getAudioFocusType();
        }
        nativeVideoView.setAudioFocusType(i10);
        nativeVideoView.setVideoEventListener(new NativeVideoView.a() { // from class: com.huawei.hms.ads.template.view.NativeTemplateView.8
            @Override // com.huawei.openalliance.ad.views.NativeVideoView.a
            public void Code() {
                if (NativeTemplateView.this.f29392f != null) {
                    if (NativeTemplateView.this.f29393g) {
                        NativeTemplateView.this.f29392f.onVideoStart();
                    } else {
                        NativeTemplateView.this.f29392f.onVideoPlay();
                    }
                }
                NativeTemplateView.this.f29393g = false;
            }

            @Override // com.huawei.openalliance.ad.views.NativeVideoView.a
            public void Code(boolean z10) {
                if (NativeTemplateView.this.f29392f != null) {
                    NativeTemplateView.this.f29392f.onVideoMute(z10);
                }
            }

            @Override // com.huawei.openalliance.ad.views.NativeVideoView.a
            public void Code(boolean z10, int i11) {
            }

            @Override // com.huawei.openalliance.ad.views.NativeVideoView.a
            public void I() {
                if (NativeTemplateView.this.f29392f != null) {
                    NativeTemplateView.this.f29392f.onVideoEnd();
                }
                NativeTemplateView.this.f29393g = true;
            }

            @Override // com.huawei.openalliance.ad.views.NativeVideoView.a
            public void V() {
                if (NativeTemplateView.this.f29392f != null) {
                    NativeTemplateView.this.f29392f.onVideoPause();
                }
            }

            @Override // com.huawei.openalliance.ad.views.NativeVideoView.a
            public void V(boolean z10, int i11) {
            }

            @Override // com.huawei.openalliance.ad.views.NativeVideoView.a
            public void Z() {
                if (NativeTemplateView.this.f29392f != null) {
                    NativeTemplateView.this.f29392f.onVideoPause();
                }
                NativeTemplateView.this.f29393g = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(final Map<String, List<g>> map) {
        f.I(new Runnable() { // from class: com.huawei.hms.ads.template.view.NativeTemplateView.3
            @Override // java.lang.Runnable
            public void run() {
                if (NativeTemplateView.this.getContext() == null) {
                    gl.I("NativeTemplateView", "onTemplateAdsLoaded - activity doesn't exit anymore");
                    return;
                }
                boolean z10 = false;
                Iterator iterator2 = map.entrySet().iterator2();
                loop0: while (true) {
                    if (!iterator2.hasNext()) {
                        break;
                    }
                    int i10 = 10000;
                    for (g gVar : (List) ((Map.Entry) iterator2.next()).getValue()) {
                        if (gVar instanceof n) {
                            n nVar = (n) gVar;
                            if (TextUtils.isEmpty(nVar.ah())) {
                                NativeTemplateView nativeTemplateView = NativeTemplateView.this;
                                String Code = nativeTemplateView.Code(nativeTemplateView.getContext(), Integer.valueOf(gVar.a()));
                                if (!TextUtils.isEmpty(Code)) {
                                    n nVar2 = (n) gVar;
                                    nVar2.Z(Code);
                                    nVar2.Code(i10);
                                    i10++;
                                }
                            }
                            if (!TextUtils.isEmpty(nVar.ah())) {
                                NativeTemplateView.this.V(gVar);
                                z10 = true;
                                break loop0;
                            }
                        }
                    }
                }
                if (z10) {
                    NativeTemplateView.this.a();
                } else {
                    NativeTemplateView.this.V(3);
                }
            }
        });
    }

    private void L() {
        setIsCustomDislikeThisAdEnabled(true);
        setChoiceViewPosition(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(final int i10) {
        ba.Code(new Runnable() { // from class: com.huawei.hms.ads.template.view.NativeTemplateView.6
            @Override // java.lang.Runnable
            public void run() {
                if (NativeTemplateView.this.f29389c != null) {
                    NativeTemplateView.this.f29389c.onAdFailed(dx.Code(i10));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(d dVar) {
        if (!(dVar instanceof n)) {
            gl.I("NativeTemplateView", "ad is not native ad");
            return;
        }
        destroy();
        this.I = (n) dVar;
        Code(getContext(), this.I.ah(), this.f29388b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(final g gVar) {
        ba.Code(new Runnable() { // from class: com.huawei.hms.ads.template.view.NativeTemplateView.4
            @Override // java.lang.Runnable
            public void run() {
                NativeTemplateView.this.V((d) gVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        ba.Code(new Runnable() { // from class: com.huawei.hms.ads.template.view.NativeTemplateView.5
            @Override // java.lang.Runnable
            public void run() {
                if (NativeTemplateView.this.f29389c != null) {
                    NativeTemplateView.this.f29389c.onAdLoaded();
                }
            }
        });
    }

    private void b() {
        DTAppDownloadButton dTAppDownloadButton;
        int i10;
        DTAppDownloadButton nativeButton = this.B.getNativeButton();
        this.C = nativeButton;
        if (nativeButton != null) {
            if (Code((lg) nativeButton)) {
                this.C.Code();
                dTAppDownloadButton = this.C;
                i10 = 0;
            } else {
                dTAppDownloadButton = this.C;
                i10 = 8;
            }
            dTAppDownloadButton.setVisibility(i10);
        }
    }

    private void c() {
        int i10;
        DTTextView adSignTextView = this.B.getAdSignTextView();
        if (adSignTextView == null || this.I.L() == null) {
            return;
        }
        if ("2".equals(this.I.L())) {
            i10 = 0;
        } else if (!"1".equals(this.I.L())) {
            return;
        } else {
            i10 = 8;
        }
        adSignTextView.setVisibility(i10);
    }

    private void d() {
        B();
        V((lg) this.C);
        this.I = null;
        this.f29394h = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        n nVar = this.I;
        boolean z10 = nVar != null && nVar.c_();
        DynamicTemplateView dynamicTemplateView = this.B;
        return z10 && (dynamicTemplateView != null && dynamicTemplateView.getNativeVideoView() != null);
    }

    private void f() {
        if (this.f29391e != null) {
            return;
        }
        this.f29391e = new VideoOperator() { // from class: com.huawei.hms.ads.template.view.NativeTemplateView.9
            @Override // com.huawei.hms.ads.VideoOperator
            public float getAspectRatio() {
                if (NativeTemplateView.this.B == null || NativeTemplateView.this.B.getNativeVideoView() == null) {
                    return 0.0f;
                }
                return NativeTemplateView.this.B.getNativeVideoView().getAspectRatio();
            }

            @Override // com.huawei.hms.ads.VideoOperator
            public VideoOperator.VideoLifecycleListener getVideoLifecycleListener() {
                return NativeTemplateView.this.f29392f;
            }

            @Override // com.huawei.hms.ads.VideoOperator
            public boolean hasVideo() {
                return NativeTemplateView.this.e();
            }

            @Override // com.huawei.hms.ads.VideoOperator
            public boolean isClickToFullScreenEnabled() {
                if (NativeTemplateView.this.f29390d == null || NativeTemplateView.this.f29390d.getVideoConfiguration() == null) {
                    return false;
                }
                return NativeTemplateView.this.f29390d.getVideoConfiguration().isClickToFullScreenRequested();
            }

            @Override // com.huawei.hms.ads.VideoOperator
            public boolean isCustomizeOperateEnabled() {
                if (NativeTemplateView.this.f29390d == null || NativeTemplateView.this.f29390d.getVideoConfiguration() == null) {
                    return false;
                }
                return NativeTemplateView.this.f29390d.getVideoConfiguration().isCustomizeOperateRequested();
            }

            @Override // com.huawei.hms.ads.VideoOperator
            public boolean isMuted() {
                return NativeTemplateView.this.L;
            }

            @Override // com.huawei.hms.ads.VideoOperator
            public void mute(boolean z10) {
                if (!isCustomizeOperateEnabled() || NativeTemplateView.this.B == null || NativeTemplateView.this.B.getNativeVideoView() == null) {
                    return;
                }
                DTNativeVideoView nativeVideoView = NativeTemplateView.this.B.getNativeVideoView();
                if (z10) {
                    nativeVideoView.C();
                } else {
                    nativeVideoView.F();
                }
                NativeTemplateView.this.L = z10;
            }

            @Override // com.huawei.hms.ads.VideoOperator
            public void pause() {
                if (!isCustomizeOperateEnabled() || NativeTemplateView.this.B == null || NativeTemplateView.this.B.getNativeVideoView() == null) {
                    return;
                }
                NativeTemplateView.this.B.getNativeVideoView().L();
            }

            @Override // com.huawei.hms.ads.VideoOperator
            public void play() {
                if (!isCustomizeOperateEnabled() || NativeTemplateView.this.B == null || NativeTemplateView.this.B.getNativeVideoView() == null) {
                    return;
                }
                NativeTemplateView.this.B.getNativeVideoView().D();
            }

            @Override // com.huawei.hms.ads.VideoOperator
            public void setVideoLifecycleListener(VideoOperator.VideoLifecycleListener videoLifecycleListener) {
                NativeTemplateView.this.f29392f = videoLifecycleListener;
            }

            @Override // com.huawei.hms.ads.VideoOperator
            public void stop() {
                if (isCustomizeOperateEnabled()) {
                    NativeTemplateView.this.g();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        DynamicTemplateView dynamicTemplateView = this.B;
        if (dynamicTemplateView == null || dynamicTemplateView.getNativeVideoView() == null) {
            return;
        }
        this.B.getNativeVideoView().S();
    }

    private void h() {
        setOnNativeAdClickListener(new PPSNativeView.b() { // from class: com.huawei.hms.ads.template.view.NativeTemplateView.10
            @Override // com.huawei.openalliance.ad.views.PPSNativeView.b
            public void Code(View view) {
                if (NativeTemplateView.this.f29389c != null) {
                    NativeTemplateView.this.f29389c.onAdClicked();
                }
            }
        });
        setOnNativeAdStatusTrackingListener(new PPSNativeView.e() { // from class: com.huawei.hms.ads.template.view.NativeTemplateView.2
            @Override // com.huawei.openalliance.ad.views.PPSNativeView.e
            public void B() {
                if (NativeTemplateView.this.f29389c != null) {
                    NativeTemplateView.this.f29389c.onAdImpression();
                }
            }

            @Override // com.huawei.openalliance.ad.views.PPSNativeView.e
            public void I() {
                if (NativeTemplateView.this.f29389c != null) {
                    NativeTemplateView.this.f29389c.onAdLeave();
                }
            }

            @Override // com.huawei.openalliance.ad.views.PPSNativeView.e
            public void V() {
                if (NativeTemplateView.this.f29389c != null) {
                    NativeTemplateView.this.f29389c.onAdOpened();
                }
            }

            @Override // com.huawei.openalliance.ad.views.PPSNativeView.e
            public void Z() {
                if (NativeTemplateView.this.f29389c != null) {
                    NativeTemplateView.this.f29389c.onAdClosed();
                }
            }
        });
    }

    private void setClickListenerForClickableViews(List<View> list) {
        a aVar = new a();
        Iterator<View> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().setOnClickListener(aVar);
        }
    }

    private void setImageLoader(Context context) {
        DTManager.getInstance().setImageLoader(new ImageLoader(context.getApplicationContext(), new aj() { // from class: com.huawei.hms.ads.template.view.NativeTemplateView.7
            @Override // com.huawei.openalliance.ad.utils.aj
            public void Code() {
                NativeTemplateView.this.V(0);
            }

            @Override // com.huawei.openalliance.ad.utils.aj
            public void Code(String str, Drawable drawable) {
            }
        }));
    }

    @GlobalApi
    public void destroy() {
        d();
    }

    @GlobalApi
    public String getAdId() {
        return this.f29387a;
    }

    @GlobalApi
    public AdListener getAdListener() {
        return this.f29389c;
    }

    @GlobalApi
    public BannerAdSize getAdSize() {
        return this.f29388b;
    }

    @GlobalApi
    public int getTemplateId() {
        return this.F;
    }

    @GlobalApi
    public VideoConfiguration getVideoConfiguration() {
        NativeAdConfiguration nativeAdConfiguration = this.f29390d;
        if (nativeAdConfiguration != null) {
            return nativeAdConfiguration.getVideoConfiguration();
        }
        return null;
    }

    @GlobalApi
    public VideoOperator getVideoOperator() {
        f();
        return this.f29391e;
    }

    @GlobalApi
    public boolean isLoading() {
        return this.D;
    }

    @GlobalApi
    public void loadAd(AdParam adParam) {
        m mVar = new m(getContext(), new String[]{this.f29387a});
        mVar.V(1);
        mVar.Code(true);
        setIsCustomDislikeThisAdEnabled(false);
        mVar.Code(new com.huawei.openalliance.ad.inter.listeners.l() { // from class: com.huawei.hms.ads.template.view.NativeTemplateView.1
            @Override // com.huawei.openalliance.ad.inter.listeners.l
            public void Code(int i10) {
                gl.Z("NativeTemplateView", "Load ads failed, error : " + i10);
                NativeTemplateView.this.D = false;
                NativeTemplateView.this.V(i10);
            }

            @Override // com.huawei.openalliance.ad.inter.listeners.l
            public void Code(Map<String, List<g>> map) {
                NativeTemplateView.this.D = false;
                NativeTemplateView.this.Code(map);
            }
        });
        NativeAdConfiguration nativeAdConfiguration = this.f29390d;
        if (nativeAdConfiguration != null) {
            mVar.Code(nativeAdConfiguration);
        }
        Code(mVar, adParam);
        this.D = true;
        mVar.Code(this.f29395i, false);
    }

    @Override // com.huawei.openalliance.ad.views.PPSNativeView
    @GlobalApi
    public void pause() {
        VideoOperator videoOperator = this.f29391e;
        if (videoOperator != null) {
            videoOperator.pause();
        }
    }

    @GlobalApi
    public void render() {
        String str;
        if (this.I == null) {
            gl.Z("NativeTemplateView", "Ad info not set yet.");
            return;
        }
        if (this.f29394h) {
            gl.I("NativeTemplateView", "View has been rendered.");
            return;
        }
        try {
            this.B.Code(new JSONObject(this.I.ag()));
            List<View> clickableViews = this.B.getClickableViews();
            List<View> arrayList = new ArrayList<>();
            List<View> arrayList2 = new ArrayList<>();
            for (View view : clickableViews) {
                if ("show_detail".equals(view.getTag(R.id.hiad_pps_view_store_click_event))) {
                    arrayList.add(view);
                } else {
                    arrayList2.add(view);
                }
            }
            DTNativeVideoView nativeVideoView = this.B.getNativeVideoView();
            if (this.f29388b.getHeight() > 0) {
                Code(nativeVideoView);
            }
            Code((NativeVideoView) nativeVideoView);
            Code(this.I, arrayList, nativeVideoView);
            c();
            b();
            setClickListenerForClickableViews(arrayList2);
            this.f29394h = true;
        } catch (JSONException unused) {
            str = "Render JSONException";
            gl.Z("NativeTemplateView", str);
        } catch (Exception e2) {
            str = "Render failed for " + e2.getClass().getSimpleName();
            gl.Z("NativeTemplateView", str);
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSNativeView
    @GlobalApi
    public void resume() {
    }

    @GlobalApi
    public void setAdId(String str) {
        this.f29387a = str;
    }

    @GlobalApi
    public void setAdListener(AdListener adListener) {
        this.f29389c = adListener;
        if (adListener != null) {
            h();
        }
    }

    @GlobalApi
    public void setAdSize(BannerAdSize bannerAdSize) {
        this.f29388b = bannerAdSize;
    }

    @GlobalApi
    public void setEventListener(OnEventListener onEventListener) {
        this.S = onEventListener;
    }

    @GlobalApi
    public void setVideoConfiguration(VideoConfiguration videoConfiguration) {
        this.f29390d = new NativeAdConfiguration.Builder().setVideoConfiguration(videoConfiguration).build();
        if (videoConfiguration != null) {
            this.L = videoConfiguration.isStartMuted();
        }
    }
}
