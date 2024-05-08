package com.kwad.components.ad.k;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.a.c;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class a {
    public AdBaseFrameLayout HA;
    private InterfaceC0422a HB;
    private c.a HF;
    private b HG;
    private KsAdWebView Hx;
    private boolean Hy;
    private boolean Hz;

    @Nullable
    private com.kwad.sdk.core.webview.d.a.a cR;
    private AdBaseFrameLayout dB;

    /* renamed from: da, reason: collision with root package name */
    private FrameLayout f36537da;
    private Activity mActivity;
    private AdTemplate mAdTemplate;
    private ImageView mBackIcon;
    private long mLastDown;
    private boolean Hw = true;
    private Handler fS = new Handler(Looper.getMainLooper());
    private boolean HC = false;
    private boolean HD = false;
    private boolean HE = false;

    /* renamed from: com.kwad.components.ad.k.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface InterfaceC0422a {
        void R(boolean z10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface b {
        void iv();
    }

    private static String B(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.a.aS(e.dQ(adTemplate));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bx() {
        return this.HE ? !this.Hw : (this.Hw || this.HC || this.HD) ? false : true;
    }

    private void fj() {
        this.f36537da.removeAllViews();
        this.f36537da.setVisibility(4);
        this.HA = (AdBaseFrameLayout) ((ViewGroup) com.kwad.sdk.d.a.a.a((ViewGroup) this.f36537da, R.layout.ksad_ad_landingpage_layout, true)).findViewById(R.id.ksad_web_card_frame);
        KsAdWebView ksAdWebView = (KsAdWebView) this.f36537da.findViewById(R.id.ksad_web_card_webView);
        this.Hx = ksAdWebView;
        ksAdWebView.setBackgroundColor(-1);
        c.a b4 = this.Hx.getClientConfig().bu(false).bw(true).bv(false).bt(true).ei(this.mAdTemplate).a(mh()).b(ij());
        this.HF = b4;
        this.Hx.setClientConfig(b4);
        this.Hx.setDownloadListener(new DownloadListener() { // from class: com.kwad.components.ad.k.a.1
            @Override // android.webkit.DownloadListener
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j10) {
                a.a(a.this, true);
                if (a.this.HB != null) {
                    a.this.HB.R(a.this.bx());
                }
            }
        });
        ImageView imageView = (ImageView) this.HA.findViewById(R.id.ksad_end_close_btn);
        this.mBackIcon = imageView;
        imageView.setVisibility(8);
        this.mBackIcon.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.k.a.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (a.this.HG != null) {
                    a.this.HG.iv();
                }
            }
        });
    }

    private KsAdWebView.d ij() {
        return new KsAdWebView.d() { // from class: com.kwad.components.ad.k.a.3
            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
                if (a.this.HB != null) {
                    a.this.HB.R(a.this.bx());
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i10, String str, String str2) {
                a.b(a.this, true);
                if (a.this.HB != null) {
                    a.this.HB.R(a.this.bx());
                }
            }
        };
    }

    private KsAdWebView.b mh() {
        return new KsAdWebView.b() { // from class: com.kwad.components.ad.k.a.4
            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onFailed() {
                a.c(a.this, true);
                if (a.this.HB != null) {
                    a.this.HB.R(a.this.bx());
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onSuccess() {
                a.c(a.this, true);
                if (a.this.HB != null) {
                    a.this.HB.R(a.this.bx());
                }
            }
        };
    }

    private boolean mi() {
        if (bx()) {
            FrameLayout frameLayout = this.f36537da;
            if (frameLayout == null) {
                return true;
            }
            frameLayout.setVisibility(0);
            return true;
        }
        FrameLayout frameLayout2 = this.f36537da;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(8);
        }
        return false;
    }

    public final a af(boolean z10) {
        this.Hz = true;
        return this;
    }

    public final boolean ar() {
        boolean mi = mi();
        this.HE = true;
        if (mi && this.mActivity != null) {
            if (this.Hx.getClientConfig() != null) {
                this.Hx.getClientConfig().bu(true);
                this.Hx.getClientConfig().bv(true);
            }
            this.HA.a(new View.OnTouchListener() { // from class: com.kwad.components.ad.k.a.5
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getX() > a.this.mBackIcon.getX() && motionEvent.getX() - a.this.mBackIcon.getX() < a.this.mBackIcon.getWidth() && motionEvent.getY() > a.this.mBackIcon.getY() && motionEvent.getY() - a.this.mBackIcon.getY() < a.this.mBackIcon.getHeight()) {
                        com.kwad.sdk.core.e.c.d("LandingPageWebCard", "onClick backIcon");
                        return false;
                    }
                    if (motionEvent.getAction() == 0) {
                        a.this.mLastDown = SystemClock.elapsedRealtime();
                    } else if (motionEvent.getAction() == 1) {
                        long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.mLastDown;
                        if (a.this.mLastDown > 0 && elapsedRealtime > 30 && elapsedRealtime < 500) {
                            com.kwad.sdk.core.adlog.c.a(a.this.mAdTemplate, 155, a.this.dB.getTouchCoords());
                            if (!a.this.Hy) {
                                a.d(a.this, true);
                                if (a.this.cR != null) {
                                    com.kwad.sdk.core.webview.d.b.a aVar = new com.kwad.sdk.core.webview.d.b.a();
                                    aVar.XC = 3;
                                    a.this.cR.a(aVar);
                                }
                            }
                        }
                        a.this.mLastDown = 0L;
                    }
                    return false;
                }
            });
            long am = com.kwad.sdk.core.response.b.a.am(e.dQ(this.mAdTemplate));
            if (am != 0 && this.Hz) {
                this.fS.postDelayed(new Runnable() { // from class: com.kwad.components.ad.k.a.6
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (a.this.mActivity == null || a.this.mActivity.isFinishing()) {
                            return;
                        }
                        a.this.mBackIcon.setVisibility(0);
                        a.this.mBackIcon.setAlpha(0.0f);
                        a.this.mBackIcon.animate().alpha(1.0f).setDuration(500L).start();
                    }
                }, am);
            } else {
                this.mBackIcon.setVisibility(0);
            }
            KsAdWebView ksAdWebView = this.Hx;
            if (ksAdWebView != null) {
                ksAdWebView.onActivityCreate();
            }
        }
        return mi;
    }

    public final void ay() {
        this.f36537da.setVisibility(4);
        String B = B(this.mAdTemplate);
        if (TextUtils.isEmpty(B)) {
            return;
        }
        this.Hx.loadUrl(B);
    }

    public final void setActivity(Activity activity) {
        this.mActivity = activity;
    }

    public static /* synthetic */ boolean b(a aVar, boolean z10) {
        aVar.Hw = true;
        return true;
    }

    public static /* synthetic */ boolean c(a aVar, boolean z10) {
        aVar.HC = true;
        return true;
    }

    public static /* synthetic */ boolean d(a aVar, boolean z10) {
        aVar.Hy = true;
        return true;
    }

    public static /* synthetic */ boolean a(a aVar, boolean z10) {
        aVar.HD = true;
        return true;
    }

    public final void a(InterfaceC0422a interfaceC0422a) {
        this.HB = interfaceC0422a;
    }

    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate) {
        this.f36537da = frameLayout;
        this.dB = adBaseFrameLayout;
        this.mAdTemplate = adTemplate;
        fj();
        this.Hw = false;
    }

    public final void a(b bVar) {
        this.HG = bVar;
    }

    public final void a(com.kwad.sdk.core.webview.d.a.a aVar) {
        this.cR = aVar;
    }
}
