package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alimm.tanx.core.utils.LandingPageUtHelper;
import com.huawei.hms.ads.ChoicesView;
import com.huawei.hms.ads.RequestOptions;
import com.huawei.hms.ads.banner.R;
import com.huawei.hms.ads.ea;
import com.huawei.hms.ads.eo;
import com.huawei.hms.ads.fr;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.hl;
import com.huawei.hms.ads.hy;
import com.huawei.hms.ads.iy;
import com.huawei.hms.ads.iz;
import com.huawei.hms.ads.jo;
import com.huawei.hms.ads.ke;
import com.huawei.hms.ads.ks;
import com.huawei.hms.ads.lj;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.hms.ads.whythisad.CusWhyThisAdView;
import com.huawei.openalliance.ad.activity.ComplianceActivity;
import com.huawei.openalliance.ad.constant.bf;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.openalliance.ad.inter.data.n;
import com.huawei.openalliance.ad.inter.data.t;
import com.huawei.openalliance.ad.inter.listeners.m;
import com.huawei.openalliance.ad.utils.v;
import com.huawei.openalliance.ad.views.PPSNativeView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PPSBannerView extends RelativeLayout implements hy, lj {
    private String A;
    private ImageView E;
    private final byte[] G;
    private boolean H;
    private String J;
    private b K;
    private a M;
    private int N;
    private List<String> O;
    private String P;
    private String Q;
    private RequestOptions R;
    private Location T;
    private t U;
    public Handler V;
    private Integer W;

    /* renamed from: aa, reason: collision with root package name */
    private float f32713aa;

    /* renamed from: ab, reason: collision with root package name */
    private RewardVerifyConfig f32714ab;

    /* renamed from: ac, reason: collision with root package name */
    private hl f32715ac;

    /* renamed from: d, reason: collision with root package name */
    private ke f32716d;

    /* renamed from: e, reason: collision with root package name */
    private long f32717e;

    /* renamed from: f, reason: collision with root package name */
    private long f32718f;

    /* renamed from: g, reason: collision with root package name */
    private String f32719g;

    /* renamed from: h, reason: collision with root package name */
    private com.huawei.openalliance.ad.inter.listeners.c f32720h;

    /* renamed from: i, reason: collision with root package name */
    private m f32721i;

    /* renamed from: j, reason: collision with root package name */
    private com.huawei.openalliance.ad.inter.data.b f32722j;

    /* renamed from: k, reason: collision with root package name */
    private PPSNativeView f32723k;

    /* renamed from: l, reason: collision with root package name */
    private PPSNativeView f32724l;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f32725m;

    /* renamed from: n, reason: collision with root package name */
    private ImageView f32726n;

    /* renamed from: o, reason: collision with root package name */
    private ChoicesView f32727o;

    /* renamed from: p, reason: collision with root package name */
    private CusWhyThisAdView f32728p;

    /* renamed from: q, reason: collision with root package name */
    private ImageView f32729q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f32730r;

    /* renamed from: s, reason: collision with root package name */
    private LinearLayout f32731s;

    /* renamed from: t, reason: collision with root package name */
    private PPSLabelView f32732t;

    /* renamed from: u, reason: collision with root package name */
    private TextView f32733u;

    /* renamed from: v, reason: collision with root package name */
    private AutoScaleSizeRelativeLayout f32734v;

    /* renamed from: w, reason: collision with root package name */
    private com.huawei.openalliance.ad.inter.data.g f32735w;

    /* renamed from: x, reason: collision with root package name */
    private com.huawei.openalliance.ad.inter.data.g f32736x;

    /* renamed from: y, reason: collision with root package name */
    private int f32737y;

    /* renamed from: z, reason: collision with root package name */
    private fr f32738z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum a {
        STARTED,
        PAUSED,
        RESUMED,
        DESTROYED
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum b {
        IDLE,
        LOADING
    }

    public PPSBannerView(Context context) {
        super(context);
        this.f32722j = com.huawei.openalliance.ad.inter.data.b.Code;
        this.f32730r = true;
        this.f32737y = 0;
        this.G = new byte[0];
        this.H = true;
        this.K = b.IDLE;
        this.M = a.STARTED;
        this.N = 0;
        this.f32713aa = 0.05f;
        this.f32715ac = new hl(this) { // from class: com.huawei.openalliance.ad.views.PPSBannerView.1
            @Override // com.huawei.hms.ads.hl
            public void Code() {
                gl.Code("PPSBannerView", "onViewShowStart");
                PPSBannerView.this.setBannerVisibility(0);
                PPSBannerView.this.b();
                PPSBannerView.this.f();
            }

            @Override // com.huawei.hms.ads.hl
            public void Code(long j10, int i10) {
                gl.Code("PPSBannerView", "onViewShowEnd");
                PPSBannerView.this.setBannerVisibility(4);
                PPSBannerView.this.c();
                PPSBannerView.this.g();
            }
        };
        this.V = new Handler(Looper.myLooper()) { // from class: com.huawei.openalliance.ad.views.PPSBannerView.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i10 = message.what;
                if (i10 == 1000) {
                    PPSBannerView.this.Code();
                } else {
                    if (i10 != 1001) {
                        return;
                    }
                    PPSBannerView pPSBannerView = PPSBannerView.this;
                    pPSBannerView.Code(1, pPSBannerView.f32735w, (List<String>) null);
                }
            }
        };
        Code(context);
    }

    public PPSBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f32722j = com.huawei.openalliance.ad.inter.data.b.Code;
        this.f32730r = true;
        this.f32737y = 0;
        this.G = new byte[0];
        this.H = true;
        this.K = b.IDLE;
        this.M = a.STARTED;
        this.N = 0;
        this.f32713aa = 0.05f;
        this.f32715ac = new hl(this) { // from class: com.huawei.openalliance.ad.views.PPSBannerView.1
            @Override // com.huawei.hms.ads.hl
            public void Code() {
                gl.Code("PPSBannerView", "onViewShowStart");
                PPSBannerView.this.setBannerVisibility(0);
                PPSBannerView.this.b();
                PPSBannerView.this.f();
            }

            @Override // com.huawei.hms.ads.hl
            public void Code(long j10, int i10) {
                gl.Code("PPSBannerView", "onViewShowEnd");
                PPSBannerView.this.setBannerVisibility(4);
                PPSBannerView.this.c();
                PPSBannerView.this.g();
            }
        };
        this.V = new Handler(Looper.myLooper()) { // from class: com.huawei.openalliance.ad.views.PPSBannerView.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i10 = message.what;
                if (i10 == 1000) {
                    PPSBannerView.this.Code();
                } else {
                    if (i10 != 1001) {
                        return;
                    }
                    PPSBannerView pPSBannerView = PPSBannerView.this;
                    pPSBannerView.Code(1, pPSBannerView.f32735w, (List<String>) null);
                }
            }
        };
        Code(attributeSet);
        Code(context);
    }

    public PPSBannerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f32722j = com.huawei.openalliance.ad.inter.data.b.Code;
        this.f32730r = true;
        this.f32737y = 0;
        this.G = new byte[0];
        this.H = true;
        this.K = b.IDLE;
        this.M = a.STARTED;
        this.N = 0;
        this.f32713aa = 0.05f;
        this.f32715ac = new hl(this) { // from class: com.huawei.openalliance.ad.views.PPSBannerView.1
            @Override // com.huawei.hms.ads.hl
            public void Code() {
                gl.Code("PPSBannerView", "onViewShowStart");
                PPSBannerView.this.setBannerVisibility(0);
                PPSBannerView.this.b();
                PPSBannerView.this.f();
            }

            @Override // com.huawei.hms.ads.hl
            public void Code(long j10, int i102) {
                gl.Code("PPSBannerView", "onViewShowEnd");
                PPSBannerView.this.setBannerVisibility(4);
                PPSBannerView.this.c();
                PPSBannerView.this.g();
            }
        };
        this.V = new Handler(Looper.myLooper()) { // from class: com.huawei.openalliance.ad.views.PPSBannerView.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i102 = message.what;
                if (i102 == 1000) {
                    PPSBannerView.this.Code();
                } else {
                    if (i102 != 1001) {
                        return;
                    }
                    PPSBannerView pPSBannerView = PPSBannerView.this;
                    pPSBannerView.Code(1, pPSBannerView.f32735w, (List<String>) null);
                }
            }
        };
        Code(attributeSet);
        Code(context);
    }

    private long Code(com.huawei.openalliance.ad.inter.data.g gVar) {
        if (gVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            long e2 = gVar.e();
            r0 = currentTimeMillis < e2 ? e2 - currentTimeMillis : 0L;
            gl.Code("PPSBannerView", "calcAdLeftTime,currentTime:" + currentTimeMillis + ",expireTime:" + e2 + ",leftTime:" + r0);
        }
        return r0;
    }

    private void Code(int i10, int i11) {
        com.huawei.openalliance.ad.inter.listeners.c cVar = this.f32720h;
        if (cVar == null) {
            return;
        }
        if (i10 == 0) {
            cVar.F();
        } else if (i10 == 1) {
            cVar.Code(i11);
        } else {
            if (i10 != 2) {
                return;
            }
            cVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x002a, code lost:
    
        r4.Code(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void Code(int r4, com.huawei.openalliance.ad.inter.data.g r5, java.util.List<java.lang.String> r6) {
        /*
            r3 = this;
            com.huawei.openalliance.ad.views.AutoScaleSizeRelativeLayout r0 = r3.f32734v
            if (r0 == 0) goto L4c
            r1 = 2
            r2 = 1
            if (r4 == 0) goto L1b
            if (r4 == r2) goto L11
            if (r4 == r1) goto Ld
            goto L2d
        Ld:
            r3.I(r5)
            goto L2d
        L11:
            int r4 = r0.getVisibility()
            if (r4 != 0) goto L2d
            r3.V(r5)
            goto L2d
        L1b:
            int r4 = r3.f32737y
            int r4 = r4 - r2
            int r4 = r4 % r1
            if (r4 != 0) goto L26
            com.huawei.openalliance.ad.views.PPSNativeView r4 = r3.f32723k
            if (r4 == 0) goto L2d
            goto L2a
        L26:
            com.huawei.openalliance.ad.views.PPSNativeView r4 = r3.f32724l
            if (r4 == 0) goto L2d
        L2a:
            r4.Code(r6)
        L2d:
            com.huawei.openalliance.ad.views.PPSNativeView r4 = r3.f32723k
            r5 = 8
            if (r4 == 0) goto L36
            r4.setVisibility(r5)
        L36:
            com.huawei.openalliance.ad.views.PPSNativeView r4 = r3.f32724l
            if (r4 == 0) goto L3d
            r4.setVisibility(r5)
        L3d:
            com.huawei.openalliance.ad.views.AutoScaleSizeRelativeLayout r4 = r3.f32734v
            r4.setVisibility(r5)
            com.huawei.hms.ads.hl r4 = r3.f32715ac
            if (r4 == 0) goto L49
            r4.onGlobalLayout()
        L49:
            r3.S()
        L4c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.views.PPSBannerView.Code(int, com.huawei.openalliance.ad.inter.data.g, java.util.List):void");
    }

    private void Code(Context context) {
        this.f32716d = new jo(context, this);
        fr Code = fr.Code(context);
        this.f32738z = Code;
        this.f32713aa = Code.s();
        V(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void Code(android.graphics.drawable.Drawable r7) {
        /*
            Method dump skipped, instructions count: 309
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.views.PPSBannerView.Code(android.graphics.drawable.Drawable):void");
    }

    private void Code(AttributeSet attributeSet) {
        String str;
        com.huawei.openalliance.ad.inter.data.b bVar;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.PPSBannerView);
        try {
            if (obtainStyledAttributes != null) {
                try {
                    String string = obtainStyledAttributes.getString(R.styleable.PPSBannerView_hiad_adId);
                    if (string != null && !string.isEmpty()) {
                        this.f32719g = string;
                    }
                    String string2 = obtainStyledAttributes.getString(R.styleable.PPSBannerView_hiad_bannerSize);
                    if (string2 != null && !string2.isEmpty()) {
                        if (string2.equals("BANNER")) {
                            bVar = com.huawei.openalliance.ad.inter.data.b.Code;
                        } else if (string2.equals("LARGE_BANNER")) {
                            bVar = com.huawei.openalliance.ad.inter.data.b.V;
                        }
                        this.f32722j = bVar;
                    }
                } catch (RuntimeException e2) {
                    str = "initDefAttr " + e2.getClass().getSimpleName();
                    gl.I("PPSBannerView", str);
                    obtainStyledAttributes.recycle();
                } catch (Throwable th) {
                    str = "initDefAttr " + th.getClass().getSimpleName();
                    gl.I("PPSBannerView", str);
                    obtainStyledAttributes.recycle();
                }
                obtainStyledAttributes.recycle();
            }
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }

    private void Code(final PPSNativeView pPSNativeView) {
        pPSNativeView.setOnNativeAdImpressionListener(new PPSNativeView.c() { // from class: com.huawei.openalliance.ad.views.PPSBannerView.4
            @Override // com.huawei.openalliance.ad.views.PPSNativeView.c
            public void Code() {
                pPSNativeView.setAdContainerSizeMatched(PPSBannerView.this.W == u.aJ ? PPSBannerView.this.H : PPSBannerView.this.f32716d.Code(PPSBannerView.this.f32722j, PPSBannerView.this.f32713aa) ? "1" : "0");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(boolean z10, int i10, int i11) {
        gl.Code("PPSBannerView", "notifyResult isRefreshAd:%s,resultType:%s", Boolean.valueOf(z10), Integer.valueOf(i10));
        Code(i10, i11);
        if (z10) {
            return;
        }
        c();
    }

    private boolean Code(String str, List<String> list) {
        gl.Code("PPSBannerView", "invalidcontentIds is %s", list);
        gl.Code("PPSBannerView", "currentContentId is %s", str);
        return (TextUtils.isEmpty(str) || list == null || list.isEmpty() || !list.contains(str)) ? false : true;
    }

    private void D() {
        gl.Code("PPSBannerView", "initChoicesView start");
        if (this.f32727o == null) {
            ChoicesView choicesView = new ChoicesView(getContext());
            this.f32727o = choicesView;
            choicesView.setId(R.id.hiad_choice_view);
            this.f32734v.addView(this.f32727o);
        }
        this.f32727o.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSBannerView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PPSBannerView.this.f32728p != null) {
                    PPSBannerView.this.L();
                    PPSBannerView.this.f32728p.V();
                } else if ((PPSBannerView.this.f32735w instanceof n) && (PPSBannerView.this.f32735w instanceof n)) {
                    n nVar = (n) PPSBannerView.this.f32735w;
                    String h10 = nVar.h();
                    if (TextUtils.isEmpty(h10)) {
                        h10 = nVar.g();
                    }
                    v.Code(PPSBannerView.this.getContext(), h10);
                }
                PPSBannerView.this.f32727o.setVisibility(8);
            }
        });
        if (com.huawei.openalliance.ad.inter.data.b.Code == getBannerSize()) {
            this.f32727o.V();
            this.f32727o.Code(R.dimen.hiad_banner_choice_view_size);
        }
    }

    private void F() {
        if (this.E == null) {
            return;
        }
        gl.V("PPSBannerView", "init compliance activity");
        this.E.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSBannerView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PPSBannerView.this.f32735w == null || !(PPSBannerView.this.f32735w instanceof n)) {
                    return;
                }
                ComplianceActivity.Code(PPSBannerView.this.getContext(), view, ((n) PPSBannerView.this.f32735w).l(), false);
            }
        });
    }

    private void I(long j10) {
        Handler handler = this.V;
        if (handler == null) {
            return;
        }
        if (handler.hasMessages(1000)) {
            this.V.removeMessages(1000);
        }
        if (getBannerVisibility() == 4 || getBannerState() == a.PAUSED || getBannerState() == a.DESTROYED) {
            gl.V("PPSBannerView", "stopRefreshAd");
        } else if (0 != j10) {
            gl.V("PPSBannerView", "start refreshAd ad will be refreshed in %s", Long.valueOf(j10));
            this.V.sendEmptyMessageDelayed(1000, j10 * 1000);
        }
    }

    private void I(com.huawei.openalliance.ad.inter.data.g gVar) {
        if (this.f32716d == null || gVar == null) {
            return;
        }
        gl.Code("PPSBannerView", "reportAdCancelled");
        this.f32716d.Code(com.huawei.openalliance.ad.beans.inner.a.V, gVar, 0L);
    }

    private void I(PPSNativeView pPSNativeView) {
        if (this.f32721i == null) {
            return;
        }
        pPSNativeView.setOnNativeAdClickListener(new PPSNativeView.b() { // from class: com.huawei.openalliance.ad.views.PPSBannerView.8
            @Override // com.huawei.openalliance.ad.views.PPSNativeView.b
            public void Code(View view) {
                PPSBannerView.this.f32721i.D();
            }
        });
        pPSNativeView.setOnNativeAdStatusTrackingListener(new PPSNativeView.e() { // from class: com.huawei.openalliance.ad.views.PPSBannerView.9
            @Override // com.huawei.openalliance.ad.views.PPSNativeView.e
            public void B() {
                PPSBannerView.this.f32721i.c();
            }

            @Override // com.huawei.openalliance.ad.views.PPSNativeView.e
            public void I() {
                PPSBannerView.this.f32721i.a();
            }

            @Override // com.huawei.openalliance.ad.views.PPSNativeView.e
            public void V() {
                PPSBannerView.this.f32721i.L();
            }

            @Override // com.huawei.openalliance.ad.views.PPSNativeView.e
            public void Z() {
                PPSBannerView.this.f32721i.b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        CusWhyThisAdView cusWhyThisAdView = this.f32728p;
        if (cusWhyThisAdView != null) {
            ViewGroup viewGroup = (ViewGroup) cusWhyThisAdView.getParent();
            if (viewGroup != null) {
                setChildrenViewsInVisible(viewGroup);
            }
            this.f32728p.setVisibility(0);
        }
        AutoScaleSizeRelativeLayout autoScaleSizeRelativeLayout = this.f32734v;
        if (autoScaleSizeRelativeLayout != null) {
            autoScaleSizeRelativeLayout.setBackgroundColor(getResources().getColor(R.color.hiad_whythisad_root_bg));
        }
    }

    private long V(long j10) {
        fr frVar;
        if (0 == j10 || (frVar = this.f32738z) == null) {
            return 0L;
        }
        long n10 = frVar.n();
        long p10 = this.f32738z.p();
        if (gl.Code()) {
            gl.Code("PPSBannerView", "setBannerRefresh,minInterval:%s,maxInterval:%s", Long.valueOf(n10), Long.valueOf(p10));
        }
        if (n10 > p10) {
            return 0L;
        }
        return j10 < n10 ? n10 : Math.min(j10, p10);
    }

    private void V(Context context) {
        RelativeLayout.inflate(context, R.layout.hiad_view_banner_ad, this);
        this.f32723k = (PPSNativeView) findViewById(R.id.hiad_banner_layout_1);
        this.f32724l = (PPSNativeView) findViewById(R.id.hiad_banner_layout_2);
        this.f32725m = (ImageView) findViewById(R.id.hiad_banner_image_1);
        this.f32726n = (ImageView) findViewById(R.id.hiad_banner_image_2);
        this.f32731s = (LinearLayout) findViewById(R.id.custom_ad_bg_layout);
        this.f32732t = (PPSLabelView) findViewById(R.id.hiad_ad_label);
        this.f32733u = (TextView) findViewById(R.id.hiad_ad_source);
        this.E = (ImageView) findViewById(R.id.compliance_icon_banner);
        this.f32734v = (AutoScaleSizeRelativeLayout) findViewById(R.id.hiad_banner_ad);
        setAdViewParam(context);
        this.f32734v.setVisibility(8);
        boolean V = ea.Code(context).V();
        this.f32730r = V;
        gl.Code("PPSBannerView", "isChinaRom = %s", Boolean.valueOf(V));
        if (this.f32730r) {
            ImageView imageView = (ImageView) findViewById(R.id.hiad_banner_close_button);
            this.f32729q = imageView;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSBannerView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PPSBannerView pPSBannerView = PPSBannerView.this;
                    pPSBannerView.Code(0, pPSBannerView.f32735w, (List<String>) null);
                    PPSBannerView pPSBannerView2 = PPSBannerView.this;
                    pPSBannerView2.Code(pPSBannerView2.d(), 2, 0);
                }
            });
        } else {
            a();
            D();
            F();
        }
        Code(this.f32723k);
        Code(this.f32724l);
    }

    private void V(com.huawei.openalliance.ad.inter.data.g gVar) {
        if (this.f32716d == null || gVar == null) {
            return;
        }
        gl.Code("PPSBannerView", "reportAdExpire");
        this.f32716d.Code(com.huawei.openalliance.ad.beans.inner.a.Code, gVar, gVar.e());
    }

    private void V(PPSNativeView pPSNativeView) {
        iz adSessionAgent = pPSNativeView.getAdSessionAgent();
        if (adSessionAgent != null) {
            adSessionAgent.Code(this.f32729q, iy.CLOSE_AD, null);
            PPSLabelView pPSLabelView = this.f32732t;
            iy iyVar = iy.OTHER;
            adSessionAgent.Code(pPSLabelView, iyVar, null);
            adSessionAgent.Code(this.f32733u, iyVar, null);
            adSessionAgent.Code(this.f32727o, iyVar, null);
            adSessionAgent.Code(this.f32728p, iyVar, null);
        }
    }

    private void a() {
        if (this.f32728p != null) {
            gl.Code("PPSBannerView", "SDK-banner cusWhyView is not null");
            return;
        }
        CusWhyThisAdView cusWhyThisAdView = new CusWhyThisAdView(getContext(), this.f32734v);
        this.f32728p = cusWhyThisAdView;
        cusWhyThisAdView.setOnCloseCallBack(new com.huawei.hms.ads.whythisad.b() { // from class: com.huawei.openalliance.ad.views.PPSBannerView.7
            @Override // com.huawei.hms.ads.whythisad.b
            public void Code() {
                if (PPSBannerView.this.f32723k != null) {
                    PPSBannerView.this.f32723k.setVisibility(8);
                }
                if (PPSBannerView.this.f32724l != null) {
                    PPSBannerView.this.f32724l.setVisibility(8);
                }
            }

            @Override // com.huawei.hms.ads.whythisad.b
            public void Code(String str) {
                if (PPSBannerView.this.f32723k != null) {
                    PPSBannerView.this.f32723k.setVisibility(8);
                }
                if (PPSBannerView.this.f32724l != null) {
                    PPSBannerView.this.f32724l.setVisibility(8);
                }
                ArrayList arrayList = new ArrayList();
                if (str == null || str.isEmpty()) {
                    arrayList = null;
                } else {
                    arrayList.add(str);
                }
                PPSBannerView pPSBannerView = PPSBannerView.this;
                pPSBannerView.Code(0, pPSBannerView.f32735w, arrayList);
                PPSBannerView pPSBannerView2 = PPSBannerView.this;
                pPSBannerView2.Code(pPSBannerView2.d(), 2, 0);
            }

            @Override // com.huawei.hms.ads.whythisad.b
            public List<String> I() {
                if (PPSBannerView.this.f32735w == null) {
                    return null;
                }
                return PPSBannerView.this.f32735w.n();
            }

            @Override // com.huawei.hms.ads.whythisad.b
            public void V() {
                if (PPSBannerView.this.f32735w instanceof n) {
                    n nVar = (n) PPSBannerView.this.f32735w;
                    String h10 = nVar.h();
                    if (TextUtils.isEmpty(h10)) {
                        h10 = nVar.g();
                    }
                    v.Code(PPSBannerView.this.getContext(), h10);
                }
            }
        });
        this.f32734v.addView(this.f32728p);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f32728p.getLayoutParams());
        layoutParams.addRule(13);
        this.f32728p.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        long j10 = this.f32717e;
        if (j10 == 0) {
            j10 = this.f32718f;
        }
        I(j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Handler handler = this.V;
        if (handler == null || !handler.hasMessages(1000)) {
            return;
        }
        gl.V("PPSBannerView", "stopRefreshAd");
        this.V.removeMessages(1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        return this.f32717e > 0 || this.f32718f > 0;
    }

    private void e() {
        gl.V("PPSBannerView", "hide activity");
        com.huawei.openalliance.ad.msgnotify.b.Code(getContext(), bf.B, new Intent(com.huawei.openalliance.ad.activity.a.I));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.V == null || this.f32735w == null || d()) {
            return;
        }
        if (this.V.hasMessages(1001)) {
            this.V.removeMessages(1001);
        }
        gl.Code("PPSBannerView", "start closeAdWhenExpire");
        this.V.sendEmptyMessageDelayed(1001, Code(this.f32735w));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Handler handler = this.V;
        if (handler == null || !handler.hasMessages(1001)) {
            return;
        }
        gl.Code("PPSBannerView", "stopCloseAdWhenExpire");
        this.V.removeMessages(1001);
    }

    private b getAdLoadState() {
        b bVar;
        synchronized (this.G) {
            bVar = this.K;
        }
        return bVar;
    }

    private int getBannerVisibility() {
        int i10;
        synchronized (this.G) {
            i10 = this.N;
        }
        return i10;
    }

    private void setAdLoadState(b bVar) {
        synchronized (this.G) {
            this.K = bVar;
        }
    }

    private void setAdViewParam(Context context) {
        AutoScaleSizeRelativeLayout autoScaleSizeRelativeLayout = this.f32734v;
        if (autoScaleSizeRelativeLayout == null || this.f32722j == null || context == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) autoScaleSizeRelativeLayout.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f32734v.setLayoutParams(layoutParams);
        this.f32734v.setRatio(Float.valueOf((this.f32722j.Code() * 1.0f) / this.f32722j.V()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBannerVisibility(int i10) {
        synchronized (this.G) {
            this.N = i10;
        }
    }

    private void setChildrenViewsInVisible(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                viewGroup.getChildAt(i10).setVisibility(4);
            }
        }
    }

    private void setChoiceViewPosition(int i10) {
        gl.Code("PPSBannerView", "bannerView option = %s", Integer.valueOf(i10));
        if (this.f32727o == null) {
            gl.Code("PPSBannerView", "choicesView is null, error");
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f32727o.getLayoutParams());
        Resources resources = getResources();
        int i11 = R.dimen.hiad_banner_choice_custom_margin;
        int dimensionPixelOffset = resources.getDimensionPixelOffset(i11);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(i11);
        if (i10 != 0) {
            if (i10 == 2) {
                layoutParams.addRule(12);
                layoutParams.addRule(21);
                layoutParams.setMargins(0, 0, dimensionPixelOffset, dimensionPixelOffset2);
            } else if (i10 == 3) {
                layoutParams.addRule(12);
                layoutParams.addRule(20);
                layoutParams.setMargins(dimensionPixelOffset, 0, 0, dimensionPixelOffset2);
            } else if (i10 == 4) {
                this.f32727o.setVisibility(8);
                this.f32727o.setLayoutParams(layoutParams);
                this.f32727o.bringToFront();
            } else {
                layoutParams.addRule(10);
                layoutParams.addRule(21);
                layoutParams.setMargins(0, dimensionPixelOffset2, dimensionPixelOffset, 0);
            }
            layoutParams.setMarginEnd(dimensionPixelOffset);
            this.f32727o.setLayoutParams(layoutParams);
            this.f32727o.bringToFront();
        }
        layoutParams.addRule(10);
        layoutParams.addRule(20);
        layoutParams.setMargins(dimensionPixelOffset, dimensionPixelOffset2, 0, 0);
        layoutParams.setMarginStart(dimensionPixelOffset);
        this.f32727o.setLayoutParams(layoutParams);
        this.f32727o.bringToFront();
    }

    @Override // com.huawei.hms.ads.lj
    public void B() {
        com.huawei.openalliance.ad.inter.data.g gVar = this.f32735w;
        eo.Code(getContext(), gVar instanceof n ? ((n) gVar).h_() : "", this.f32719g, 8, 499, "Fail to display ad because of missing presentation material");
    }

    public boolean C() {
        return getAdLoadState() == b.LOADING;
    }

    public void Code() {
        if (!this.f32716d.B()) {
            Code(d(), 1, 1001);
            return;
        }
        if (getAdLoadState() != b.IDLE) {
            gl.I("PPSBannerView", "ad is loading now!");
            Code(d(), 1, 701);
            return;
        }
        setAdLoadState(b.LOADING);
        ArrayList arrayList = new ArrayList();
        String str = this.P;
        if (str == null || str.isEmpty()) {
            arrayList = null;
        } else {
            arrayList.add(this.P);
        }
        this.f32716d.Code(this.T);
        this.f32716d.Code(this.R);
        this.f32716d.Code(this.U);
        this.f32716d.Code(this.W);
        this.f32716d.V(Integer.valueOf(this.f32722j.Code()));
        this.f32716d.I(Integer.valueOf(this.f32722j.V()));
        this.f32716d.V(this.J);
        this.f32716d.Code(this.f32719g, 8, arrayList, this.f32717e == 0 ? 0 : 1);
        b();
    }

    @Override // com.huawei.hms.ads.lj
    public void Code(int i10) {
        gl.Code("PPSBannerView", "onReqAdFail ");
        if (Code(this.P, this.O)) {
            Code(2, this.f32735w, (List<String>) null);
            Code(false, 1, 705);
        } else {
            Code(d(), 1, i10);
        }
        setAdLoadState(b.IDLE);
    }

    @Override // com.huawei.hms.ads.lj
    public void Code(long j10) {
        this.f32718f = V(j10);
        b();
    }

    @Override // com.huawei.hms.ads.lj
    public void Code(Drawable drawable, com.huawei.openalliance.ad.inter.data.g gVar) {
        if (drawable == null || gVar == null) {
            Code(d(), 1, 499);
            gl.I("PPSBannerView", "onAdContentLoaded,content is null");
        } else {
            this.f32735w = gVar;
            this.A = gVar.c();
            this.P = gVar.D();
            if (0 == Code(gVar)) {
                V(gVar);
                gl.Code("PPSBannerView", "do not show ad due to ad expired");
                Code(false, 1, 704);
                if (Code(this.Q, this.O)) {
                    Code(2, this.f32736x, (List<String>) null);
                }
            } else if (Code(this.P, this.O)) {
                gl.Code("PPSBannerView", "do not show ad due to ad cancelled");
                I(gVar);
                Code(false, 1, 705);
            } else {
                e();
                Code(drawable);
                Code(d(), 0, 0);
                f();
            }
            this.Q = this.P;
            this.f32736x = gVar;
        }
        setAdLoadState(b.IDLE);
    }

    @Override // com.huawei.hms.ads.lj
    public void Code(List<String> list) {
        this.O = list;
    }

    public void I() {
        if (getBannerState() == a.DESTROYED) {
            gl.V("PPSBannerView", "hasDestroyed");
            return;
        }
        gl.V("PPSBannerView", "pause");
        setBannerState(a.PAUSED);
        c();
    }

    public void S() {
        PPSNativeView pPSNativeView = this.f32723k;
        if (pPSNativeView != null) {
            pPSNativeView.S();
        }
        PPSNativeView pPSNativeView2 = this.f32724l;
        if (pPSNativeView2 != null) {
            pPSNativeView2.S();
        }
    }

    public void V() {
        gl.V("PPSBannerView", LandingPageUtHelper.XAD_UT_LP_DESTROY);
        setBannerState(a.DESTROYED);
        c();
        g();
        this.V = null;
    }

    public void Z() {
        if (getBannerState() == a.DESTROYED) {
            gl.V("PPSBannerView", "hasDestroyed");
            return;
        }
        gl.V("PPSBannerView", "resume");
        setBannerState(a.RESUMED);
        b();
    }

    public String getAdId() {
        return this.f32719g;
    }

    public long getBannerRefresh() {
        return this.f32717e;
    }

    public com.huawei.openalliance.ad.inter.data.b getBannerSize() {
        return this.f32722j;
    }

    public a getBannerState() {
        a aVar;
        synchronized (this.G) {
            aVar = this.M;
        }
        return aVar;
    }

    public Integer getIsSmart() {
        return this.W;
    }

    public Location getLocation() {
        return this.T;
    }

    @Override // com.huawei.hms.ads.hy
    public View getOpenMeasureView() {
        return this;
    }

    public RequestOptions getRequestOptions() {
        return this.R;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        hl hlVar = this.f32715ac;
        if (hlVar != null) {
            hlVar.D();
        }
        ks.Code(getContext()).V(getContext());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        hl hlVar = this.f32715ac;
        if (hlVar != null) {
            hlVar.L();
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        hl hlVar = this.f32715ac;
        if (hlVar != null) {
            hlVar.a();
        }
    }

    public void setAdContainerSizeMatched(boolean z10) {
        this.H = z10;
    }

    public void setAdId(String str) {
        this.f32719g = str;
    }

    public void setAdListener(com.huawei.openalliance.ad.inter.listeners.c cVar) {
        this.f32720h = cVar;
    }

    public void setBannerRefresh(long j10) {
        long V = V(j10);
        this.f32717e = V;
        gl.V("PPSBannerView", "setBannerRefresh:%s", Long.valueOf(V));
    }

    public void setBannerSize(com.huawei.openalliance.ad.inter.data.b bVar) {
        this.f32722j = bVar;
        setAdViewParam(getContext());
    }

    public void setBannerState(a aVar) {
        synchronized (this.G) {
            this.M = aVar;
        }
    }

    public void setContentBundle(String str) {
        this.J = str;
    }

    public void setIsSmart(Integer num) {
        this.W = num;
    }

    public void setLocation(Location location) {
        this.T = location;
    }

    public void setOnBannerAdStatusTrackingListener(m mVar) {
        this.f32721i = mVar;
    }

    public void setRequestOptions(RequestOptions requestOptions) {
        this.R = requestOptions;
    }

    public void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig) {
        this.f32714ab = rewardVerifyConfig;
    }

    public void setTargetingInfo(t tVar) {
        this.U = tVar;
    }
}
