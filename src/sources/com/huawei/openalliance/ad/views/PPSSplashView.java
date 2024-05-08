package com.huawei.openalliance.ad.views;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.WindowInsets;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.ads.dy;
import com.huawei.hms.ads.ea;
import com.huawei.hms.ads.ff;
import com.huawei.hms.ads.fr;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.hc;
import com.huawei.hms.ads.hd;
import com.huawei.hms.ads.hg;
import com.huawei.hms.ads.jr;
import com.huawei.hms.ads.kd;
import com.huawei.hms.ads.kp;
import com.huawei.hms.ads.kt;
import com.huawei.hms.ads.lo;
import com.huawei.hms.ads.lq;
import com.huawei.hms.ads.lz;
import com.huawei.hms.ads.mb;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.hms.ads.splash.R;
import com.huawei.hms.ads.splash.SplashView;
import com.huawei.openalliance.ad.beans.metadata.InteractCfg;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.inter.d;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.au;
import com.huawei.openalliance.ad.utils.ax;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.l;
import com.huawei.openalliance.ad.utils.v;
import com.huawei.openalliance.ad.utils.z;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PPSSplashView extends RelativeLayout implements lo, lz {
    private PPSSplashSwipeView A;
    public fr B;
    public long C;
    public SloganView Code;
    private View D;
    private PPSSplashTwistView E;
    private AdSlotParam F;
    private PPSSplashSwipeClickView G;
    private PPSSplashTwistClickView H;
    public PPSSkipButton I;
    private b J;
    private InteractCfg K;
    private int L;
    public RelativeLayout V;

    /* renamed from: a, reason: collision with root package name */
    private PPSWLSView f32893a;

    /* renamed from: b, reason: collision with root package name */
    private PPSSplashAdSourceView f32894b;

    /* renamed from: c, reason: collision with root package name */
    private hg f32895c;

    /* renamed from: d, reason: collision with root package name */
    private kp f32896d;

    /* renamed from: e, reason: collision with root package name */
    private com.huawei.openalliance.ad.inter.listeners.b f32897e;

    /* renamed from: f, reason: collision with root package name */
    private com.huawei.openalliance.ad.inter.listeners.a f32898f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f32899g;

    /* renamed from: h, reason: collision with root package name */
    private int f32900h;

    /* renamed from: i, reason: collision with root package name */
    private Bitmap f32901i;

    /* renamed from: j, reason: collision with root package name */
    private View f32902j;

    /* renamed from: k, reason: collision with root package name */
    private lq f32903k;

    /* renamed from: l, reason: collision with root package name */
    private int f32904l;

    /* renamed from: m, reason: collision with root package name */
    private String f32905m;

    /* renamed from: n, reason: collision with root package name */
    private int f32906n;

    /* renamed from: o, reason: collision with root package name */
    private int f32907o;

    /* renamed from: p, reason: collision with root package name */
    private int f32908p;

    /* renamed from: q, reason: collision with root package name */
    private int f32909q;

    /* renamed from: r, reason: collision with root package name */
    private int f32910r;

    /* renamed from: s, reason: collision with root package name */
    private int f32911s;

    /* renamed from: t, reason: collision with root package name */
    private View f32912t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f32913u;

    /* renamed from: v, reason: collision with root package name */
    private int f32914v;

    /* renamed from: w, reason: collision with root package name */
    private final String f32915w;

    /* renamed from: x, reason: collision with root package name */
    private int f32916x;

    /* renamed from: y, reason: collision with root package name */
    private RewardVerifyConfig f32917y;

    /* renamed from: z, reason: collision with root package name */
    private PPSSplashProView f32918z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements View.OnClickListener {
        private WeakReference<PPSSplashView> Code;
        private AdContentData V;

        public a(PPSSplashView pPSSplashView, AdContentData adContentData) {
            this.Code = new WeakReference<>(pPSSplashView);
            this.V = adContentData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            final PPSSplashView pPSSplashView = this.Code.get();
            if (pPSSplashView != null) {
                final int[] choiceViewLoc = pPSSplashView.f32893a.getChoiceViewLoc();
                final int[] choiceViewSize = pPSSplashView.f32893a.getChoiceViewSize();
                if (v.Code(choiceViewLoc, 2) && v.Code(choiceViewSize, 2)) {
                    ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSSplashView.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            pPSSplashView.Code(a.this.V, choiceViewLoc, choiceViewSize);
                        }
                    });
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class b implements d.b {
        private b() {
        }

        @Override // com.huawei.openalliance.ad.inter.d.b
        public void Code() {
            gl.V("PPSSplashView", "onStart");
            PPSSplashView.this.d();
        }
    }

    public PPSSplashView(Context context) {
        super(context);
        this.L = 8;
        this.f32899g = false;
        this.f32904l = 0;
        this.f32906n = 0;
        this.f32907o = 1;
        this.f32908p = 0;
        this.f32909q = 0;
        this.f32910r = 0;
        this.f32911s = 0;
        this.f32913u = true;
        this.f32914v = 0;
        this.f32915w = "skip_btn_delay_id_" + hashCode();
        Code(context);
    }

    public PPSSplashView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.L = 8;
        this.f32899g = false;
        this.f32904l = 0;
        this.f32906n = 0;
        this.f32907o = 1;
        this.f32908p = 0;
        this.f32909q = 0;
        this.f32910r = 0;
        this.f32911s = 0;
        this.f32913u = true;
        this.f32914v = 0;
        this.f32915w = "skip_btn_delay_id_" + hashCode();
        Code(context);
    }

    public PPSSplashView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.L = 8;
        this.f32899g = false;
        this.f32904l = 0;
        this.f32906n = 0;
        this.f32907o = 1;
        this.f32908p = 0;
        this.f32909q = 0;
        this.f32910r = 0;
        this.f32911s = 0;
        this.f32913u = true;
        this.f32914v = 0;
        this.f32915w = "skip_btn_delay_id_" + hashCode();
        Code(context);
    }

    private void B() {
        String str;
        int I;
        int i10;
        int i11;
        int i12;
        View view;
        try {
            if (this.f32902j == null) {
                View inflate = ((ViewStub) findViewById(R.id.hiad_logo_stub)).inflate();
                this.f32902j = inflate;
                inflate.setId(R.id.hiad_full_logo_region);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f32902j.getLayoutParams();
            if (1 == this.F.V()) {
                L();
                if (this.f32908p > 0) {
                    gl.Code("PPSSplashView", "left: %s, top: %s, right: %s", Integer.valueOf(layoutParams.leftMargin), Integer.valueOf(layoutParams.topMargin), Integer.valueOf(layoutParams.rightMargin));
                    layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin + this.f32908p, layoutParams.rightMargin, layoutParams.bottomMargin);
                    view = this.f32902j;
                }
                D();
                S();
            }
            gl.V("PPSSplashView", "showFullModeLogo, orientation: %s, leftNotchHeight: %s", Integer.valueOf(this.F.V()), Integer.valueOf(this.f32909q));
            gl.Code("PPSSplashView", "left:%s, top:%s, right:%s, leftNotchHeight:%s", Integer.valueOf(layoutParams.leftMargin), Integer.valueOf(layoutParams.topMargin), Integer.valueOf(layoutParams.rightMargin), Integer.valueOf(this.f32909q));
            if (!ea.V(getContext()) || this.f32909q <= 0) {
                if (!ea.V(getContext()) || (ea.V(getContext()) && TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 && !l.B(getContext()))) {
                    if (layoutParams.isMarginRelative()) {
                        layoutParams.setMarginStart(ay.I(getContext()));
                    } else {
                        I = ay.I(getContext());
                        i10 = layoutParams.topMargin;
                        i11 = layoutParams.rightMargin;
                        i12 = layoutParams.bottomMargin;
                        layoutParams.setMargins(I, i10, i11, i12);
                    }
                }
                layoutParams.topMargin += v.V(getContext(), 12.0f);
                view = this.f32902j;
            } else if (layoutParams.isMarginRelative()) {
                layoutParams.setMarginStart(layoutParams.leftMargin + this.f32909q);
                layoutParams.topMargin += v.V(getContext(), 12.0f);
                view = this.f32902j;
            } else {
                I = layoutParams.leftMargin + this.f32909q;
                i10 = layoutParams.topMargin;
                i11 = layoutParams.rightMargin;
                i12 = layoutParams.bottomMargin;
                layoutParams.setMargins(I, i10, i11, i12);
                layoutParams.topMargin += v.V(getContext(), 12.0f);
                view = this.f32902j;
            }
            view.setLayoutParams(layoutParams);
            D();
            S();
        } catch (Resources.NotFoundException unused) {
            str = "showFullModeLogo res not found";
            gl.I("PPSSplashView", str);
        } catch (Exception e2) {
            str = "showFullModeLogo " + e2.getClass().getSimpleName();
            gl.I("PPSSplashView", str);
        }
    }

    private void C() {
        if (this.f32902j == null) {
            return;
        }
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSSplashView.1
            @Override // java.lang.Runnable
            public void run() {
                PPSSplashView.this.S();
            }
        });
    }

    private PPSSkipButton Code(String str, int i10, String str2, boolean z10, float f10, int i11) {
        int i12;
        boolean z11;
        PPSSkipButton pPSSkipButton;
        int V = this.F.V();
        int I = this.F.I();
        L();
        if (1 == V) {
            pPSSkipButton = new PPSSkipButton(getContext(), str, V, I, i10, str2, z10, this.f32908p, f10, i11, false);
        } else {
            gl.V("PPSSplashView", "createSkipAdButton, orientation: %s, leftNotchHeight: %s, rightNotchHeight: %s", Integer.valueOf(V), Integer.valueOf(this.f32909q), Integer.valueOf(this.f32910r));
            int i13 = this.f32909q;
            if (i13 > 0) {
                i12 = i13;
                z11 = true;
            } else {
                i12 = this.f32910r;
                z11 = false;
            }
            pPSSkipButton = new PPSSkipButton(getContext(), str, V, I, i10, str2, z10, i12, f10, i11, z11);
        }
        pPSSkipButton.setAdMediator(this.f32895c);
        return pPSSkipButton;
    }

    private void Code(int i10, String str, boolean z10) {
        gl.V("PPSSplashView", "showClickButton");
        c();
        this.f32918z.setVisibility(i10 == 0 ? 4 : 0);
        PPSSplashProView pPSSplashProView = this.f32918z;
        if (!TextUtils.isEmpty(this.B.x())) {
            str = this.B.x();
        }
        pPSSplashProView.setDesc(str);
        this.f32918z.setOrientation(this.F.V());
        this.f32918z.Code(z10, i10);
    }

    private void Code(Context context) {
        V(context);
        this.f32896d = new kd(context, this);
        this.B = fr.Code(context);
        this.f32916x = l.I(context.getApplicationContext());
        this.J = new b();
        com.huawei.openalliance.ad.inter.d.Code(context.getApplicationContext()).Code(this.J);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(AdContentData adContentData, int[] iArr, int[] iArr2) {
        if (v.Code(iArr, 2) && v.Code(iArr2, 2) && adContentData != null) {
            if (gl.Code()) {
                gl.Code("PPSSplashView", "addComplianceDialog, loc: %s, %s", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
                gl.Code("PPSSplashView", "addComplianceDialog, size: %s, %s", Integer.valueOf(iArr2[0]), Integer.valueOf(iArr2[1]));
            }
            ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            PPSAdvertiserInfoDialog pPSAdvertiserInfoDialog = new PPSAdvertiserInfoDialog(getContext(), iArr, iArr2);
            addView(pPSAdvertiserInfoDialog, layoutParams);
            pPSAdvertiserInfoDialog.setScreenWidth(getMeasuredWidth());
            pPSAdvertiserInfoDialog.setScreenHeight(getMeasuredHeight());
            pPSAdvertiserInfoDialog.setAdContent(adContentData);
        }
    }

    private void Code(boolean z10, int i10) {
        PPSSplashSwipeClickView pPSSplashSwipeClickView;
        PPSBaseStyleView pPSBaseStyleView;
        gl.V("PPSSplashView", "showNewStyle, cfg= %s", Integer.valueOf(i10));
        if (1 == i10) {
            PPSSplashSwipeView pPSSplashSwipeView = this.A;
            if (pPSSplashSwipeView == null) {
                return;
            }
            pPSSplashSwipeView.setVisibility(0);
            this.A.Code(getSwipeInteractDesc(), getSwipeJumpDesc());
            this.A.setOrientation(this.F.V());
            pPSBaseStyleView = this.A;
        } else if (2 == i10) {
            PPSSplashTwistView pPSSplashTwistView = this.E;
            if (pPSSplashTwistView == null) {
                return;
            }
            pPSSplashTwistView.setVisibility(0);
            this.E.Code(getTwistInteractDesc(), getTwistJumpDesc());
            this.E.setOrientation(this.F.V());
            pPSBaseStyleView = this.E;
        } else if (3 == i10) {
            PPSSplashTwistClickView pPSSplashTwistClickView = this.H;
            if (pPSSplashTwistClickView == null) {
                return;
            }
            pPSSplashTwistClickView.setVisibility(0);
            this.H.Code(getTwistClkInteractDesc(), getTwistJumpDesc());
            this.H.setOrientation(this.F.V());
            pPSBaseStyleView = this.H;
        } else {
            if (4 != i10 || (pPSSplashSwipeClickView = this.G) == null) {
                return;
            }
            pPSSplashSwipeClickView.setVisibility(0);
            this.G.Code(getSwipeClkInteractDesc(), getSwipeJumpDesc());
            this.G.setOrientation(this.F.V());
            pPSBaseStyleView = this.G;
        }
        pPSBaseStyleView.setShowLogo(z10);
    }

    private boolean Code(Long l10) {
        if (l10 == null) {
            return false;
        }
        long ag = fr.Code(getContext()).ag();
        return ag == -1 || System.currentTimeMillis() < (ag * 86400000) + l10.longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        View view = this.f32902j;
        if (view == null) {
            return;
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.hiad_full_mode_logo);
        int i10 = this.f32900h;
        if (i10 > 0) {
            imageView.setImageResource(i10);
        } else {
            Bitmap bitmap = this.f32901i;
            if (bitmap == null) {
                imageView.setVisibility(8);
                return;
            }
            imageView.setImageBitmap(bitmap);
        }
        imageView.setVisibility(0);
    }

    private void F() {
        if (this.f32902j == null) {
            return;
        }
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSSplashView.2
            @Override // java.lang.Runnable
            public void run() {
                PPSSplashView.this.D();
            }
        });
    }

    private int I(AdContentData adContentData) {
        return (adContentData.av() == null || adContentData.av().Code() == null) ? this.B.w() : adContentData.av().Code().intValue();
    }

    private static boolean I(Context context) {
        if (!(context instanceof Activity)) {
            return true;
        }
        Activity activity = (Activity) context;
        return activity.isFinishing() || activity.isDestroyed();
    }

    private void L() {
        if (this.f32908p > 0 || ea.Code(getContext().getApplicationContext()).Code(getContext().getApplicationContext())) {
            return;
        }
        this.f32908p = v.f(getContext().getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        View view = this.f32902j;
        if (view == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(R.id.hiad_media_name);
        int i10 = this.f32904l;
        if (i10 > 0) {
            textView.setText(i10);
        } else {
            String str = this.f32905m;
            if (str == null) {
                textView.setVisibility(8);
                return;
            }
            textView.setText(str);
        }
        textView.setVisibility(0);
    }

    private void V(Context context) {
        RelativeLayout.inflate(context, R.layout.hiad_view_splash_ad, this);
        this.V = (RelativeLayout) findViewById(R.id.rl_splash_container);
        this.f32893a = (PPSWLSView) findViewById(R.id.splash_wls_view);
        this.f32894b = (PPSSplashAdSourceView) findViewById(R.id.splash_ad_source_view);
        this.f32913u = ea.Code(context).V();
        this.f32918z = (PPSSplashProView) findViewById(R.id.hiad_splash_pro_view);
        this.A = (PPSSplashSwipeView) findViewById(R.id.hiad_splash_swipe_view);
        this.E = (PPSSplashTwistView) findViewById(R.id.hiad_splash_twist_view);
        this.H = (PPSSplashTwistClickView) findViewById(R.id.hiad_splash_twist_click_view);
        this.G = (PPSSplashSwipeClickView) findViewById(R.id.hiad_splash_swipe_click_view);
    }

    private void V(AdContentData adContentData) {
        int i10;
        boolean z10;
        PPSSplashAdSourceView pPSSplashAdSourceView;
        boolean z11;
        int i11;
        boolean z12;
        PPSWLSView pPSWLSView;
        boolean z13;
        if (adContentData != null) {
            int V = this.F.V();
            Integer Code = Code(adContentData);
            InteractCfg av = adContentData.av();
            Integer B = av == null ? null : av.B();
            L();
            if (this.f32913u) {
                this.f32894b.setAdMediator(this.f32895c);
                this.f32894b.Code(Code, B);
                this.f32894b.setVisibility(0);
                if (1 == V) {
                    pPSSplashAdSourceView = this.f32894b;
                    z11 = adContentData.D() == 1;
                    i10 = this.f32908p;
                    z10 = false;
                } else {
                    gl.V("PPSSplashView", "showAdLabel, orientation: %s, leftNotchHeight: %s, rightNotchHeight: %s", Integer.valueOf(V), Integer.valueOf(this.f32909q), Integer.valueOf(this.f32910r));
                    int i12 = this.f32909q;
                    if (i12 > 0) {
                        i10 = i12;
                        z10 = true;
                    } else {
                        i10 = this.f32910r;
                        z10 = false;
                    }
                    pPSSplashAdSourceView = this.f32894b;
                    z11 = adContentData.D() == 1;
                }
                pPSSplashAdSourceView.Code(adContentData, z11, i10, V, z10);
                return;
            }
            this.f32893a.setAdMediator(this.f32895c);
            this.f32893a.Code(Code, B);
            this.f32893a.setVisibility(0);
            if (1 == V) {
                pPSWLSView = this.f32893a;
                z13 = adContentData.D() == 1;
                i11 = this.f32908p;
                z12 = false;
            } else {
                gl.V("PPSSplashView", "showAdLabel, orientation: %s, leftNotchHeight: %s, rightNotchHeight: %s", Integer.valueOf(V), Integer.valueOf(this.f32909q), Integer.valueOf(this.f32910r));
                int i13 = this.f32909q;
                if (i13 > 0) {
                    i11 = i13;
                    z12 = true;
                } else {
                    i11 = this.f32910r;
                    z12 = false;
                }
                pPSWLSView = this.f32893a;
                z13 = adContentData.D() == 1;
            }
            pPSWLSView.Code(adContentData, z13, i11, V, z12);
            if (aa.Code(adContentData.aG())) {
                return;
            }
            this.f32893a.setChoiceViewOnClickListener(new a(this, adContentData));
        }
    }

    private void V(AdContentData adContentData, int i10) {
        String str;
        String str2;
        boolean z10;
        float f10;
        int i11;
        if (I(getContext())) {
            gl.I("PPSSplashView", "addSkipAdButton - activity finished, not add view");
            return;
        }
        if (adContentData != null) {
            boolean z11 = adContentData.D() == 1;
            String V = adContentData.V();
            String l10 = adContentData.l();
            float ab2 = adContentData.ab();
            i11 = adContentData.ac();
            str2 = l10;
            str = V;
            z10 = z11;
            f10 = ab2;
        } else {
            str = null;
            str2 = null;
            z10 = false;
            f10 = 0.0f;
            i11 = 0;
        }
        PPSSkipButton Code = Code(str, i10, str2, z10, f10, i11);
        this.I = Code;
        Code.setId(R.id.hiad_btn_skip);
        addView(this.I);
        this.I.setVisibility(4);
    }

    private void Z() {
        List<String> Code = this.F.Code();
        this.f32896d.Code(!aa.Code(Code) ? Code.get(0) : null, 1);
        this.f32896d.C();
        com.huawei.openalliance.ad.inter.d.Code(getContext().getApplicationContext()).Code(false);
    }

    private boolean Z(int i10) {
        return 2 == i10 || 3 == i10;
    }

    private void a() {
        if (this.I != null) {
            gl.Code("PPSSplashView", "%d delay, skip btn show", Integer.valueOf(this.f32914v));
            if (this.f32914v > 0) {
                ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSSplashView.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PPSSplashView.this.I != null) {
                            gl.Code("PPSSplashView", "skip btn show");
                            PPSSplashView.this.I.setVisibility(0);
                        }
                    }
                }, this.f32915w, this.f32914v);
            } else {
                gl.Code("PPSSplashView", "skip btn show");
                this.I.setVisibility(0);
            }
        }
    }

    private boolean b() {
        if (this.B.f()) {
            return !l.Z(getContext().getApplicationContext());
        }
        return true;
    }

    private void c() {
        int y10 = this.B.y();
        if (y10 > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f32918z.getLayoutParams();
            int V = v.V(getContext(), y10);
            this.f32918z.setPadding(V, V, V, V);
            if (layoutParams.isMarginRelative()) {
                layoutParams.setMarginStart(layoutParams.leftMargin - V);
                layoutParams.setMarginEnd(layoutParams.rightMargin - V);
            } else {
                layoutParams.setMargins(layoutParams.leftMargin - V, layoutParams.topMargin, layoutParams.rightMargin - V, layoutParams.bottomMargin);
            }
            this.f32918z.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (!this.f32899g || this.F == null) {
            return;
        }
        gl.V("PPSSplashView", " exsplash start, dismiss");
        Z();
    }

    private String getSwipeClkInteractDesc() {
        InteractCfg interactCfg = this.K;
        if (interactCfg != null) {
            return interactCfg.D();
        }
        return null;
    }

    private String getSwipeInteractDesc() {
        InteractCfg interactCfg = this.K;
        if (interactCfg != null) {
            return interactCfg.S();
        }
        return null;
    }

    private String getSwipeJumpDesc() {
        InteractCfg interactCfg = this.K;
        return (interactCfg == null || interactCfg.a() == null) ? this.B.z() : this.K.a();
    }

    private String getTwistClkInteractDesc() {
        InteractCfg interactCfg = this.K;
        if (interactCfg != null) {
            return interactCfg.L();
        }
        return null;
    }

    private String getTwistInteractDesc() {
        InteractCfg interactCfg = this.K;
        if (interactCfg != null) {
            return interactCfg.F();
        }
        return null;
    }

    private String getTwistJumpDesc() {
        InteractCfg interactCfg = this.K;
        return (interactCfg == null || interactCfg.a() == null) ? this.B.E() : this.K.a();
    }

    private void setSkipBtnDelayTime(AdContentData adContentData) {
        if (adContentData == null || adContentData.am() <= 0) {
            return;
        }
        this.f32914v = adContentData.am();
    }

    @Override // com.huawei.hms.ads.lo
    public Integer Code(AdContentData adContentData) {
        int C = kt.C(adContentData.r());
        if (C == 0) {
            return null;
        }
        int I = I(adContentData);
        gl.V("PPSSplashView", "initial mode: %s", Integer.valueOf(I));
        if (I == 0) {
            return Integer.valueOf(I);
        }
        Map<String, String> Code = z.Code(fr.Code(getContext()).ah());
        if (Code != null) {
            if ((2 == I || 3 == I) && Code(au.I(Code.get(u.f32369cn)))) {
                I = 4;
            }
            if ((1 == I || 4 == I) && Code(au.I(Code.get("swipe")))) {
                return 0;
            }
        }
        if (1 != this.F.V() || 2 != C) {
            return 0;
        }
        if (!Z(I) || !b()) {
            return Integer.valueOf(I);
        }
        gl.V("PPSSplashView", "can't use twist, enable : %s", Boolean.valueOf(this.B.f()));
        return 0;
    }

    public void Code(int i10) {
        hc Code = hd.Code(i10, this);
        this.f32895c = Code;
        Code.Code(this.f32897e);
        this.f32895c.Code(this.f32898f);
        this.f32895c.Code(this.f32911s);
        this.f32895c.V(this.C);
        this.f32895c.Code(this.f32917y);
        this.f32895c.k();
    }

    @Override // com.huawei.hms.ads.lo
    public void Code(int i10, int i11, String str, boolean z10, Integer num) {
        if (this.f32918z == null) {
            return;
        }
        gl.V("PPSSplashView", "set splashpro mode: %d", Integer.valueOf(i10));
        gl.V("PPSSplashView", "interactCfg = %s", num);
        if (num == null) {
            this.f32918z.setVisibility(8);
        } else if (num.intValue() == 0) {
            Code(i11, str, z10);
        } else {
            Code(z10, num.intValue());
        }
        this.f32918z.setMode(i10);
    }

    @Override // com.huawei.hms.ads.lo
    public void Code(int i10, boolean z10) {
        View view = this.D;
        if (view == null) {
            return;
        }
        if (1 == i10) {
            view.setVisibility(0);
            return;
        }
        view.setVisibility(8);
        if (z10) {
            B();
        }
    }

    @Override // com.huawei.hms.ads.lo
    public void Code(View view) {
        gl.V("PPSSplashView", "showTemplateView");
        if (I(getContext())) {
            gl.I("PPSSplashView", "showAdView - activity finished, not add view");
        } else {
            this.V.addView(view, new RelativeLayout.LayoutParams(-1, -1));
            view.setVisibility(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huawei.hms.ads.lo
    public void Code(lq lqVar, Integer num) {
        if (I(getContext())) {
            gl.I("PPSSplashView", "showAdView - activity finished, not add view");
            return;
        }
        if (lqVar == 0 || !(lqVar instanceof View)) {
            return;
        }
        View view = (View) lqVar;
        this.f32903k = lqVar;
        ViewParent parent = view.getParent();
        if (parent == this.V) {
            view.setVisibility(0);
            return;
        }
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(view);
        } else if (parent != null) {
            return;
        }
        this.V.addView(view, new RelativeLayout.LayoutParams(-1, -1));
        view.setVisibility(0);
        lqVar.setAudioFocusType(this.f32907o);
        gl.V("PPSSplashView", "set splashpro view to adview");
        if (num != null && num.intValue() == 4) {
            lqVar.Code(this.G.getClickAreaView(), num);
        } else if (num == null || num.intValue() != 3) {
            lqVar.Code(this.f32918z, num);
        } else {
            lqVar.Code(this.H.getClickAreaView(), num);
        }
    }

    @Override // com.huawei.hms.ads.lo
    public void Code(mb mbVar) {
        View view = this.D;
        if (view != null) {
            view.setVisibility(this.L);
        }
        View view2 = this.f32912t;
        if (view2 != null) {
            view2.setVisibility(0);
            new jr(this.B, mbVar).V();
            return;
        }
        SloganView sloganView = this.Code;
        if (sloganView == null) {
            gl.V("PPSSplashView", "create default slogan");
            setSloganResId(R.drawable.hiad_default_slogan);
            sloganView = this.Code;
            if (sloganView == null) {
                return;
            }
        }
        sloganView.setSloganShowListener(mbVar);
        this.Code.Code();
    }

    @Override // com.huawei.hms.ads.lo
    public void Code(AdContentData adContentData, int i10) {
        if (adContentData != null) {
            this.K = adContentData.av();
        }
        setSkipBtnDelayTime(adContentData);
        if (this.I == null) {
            V(adContentData, i10);
        }
        PPSSkipButton pPSSkipButton = this.I;
        if (pPSSkipButton != null) {
            lq lqVar = this.f32903k;
            if (lqVar != null) {
                pPSSkipButton.setShowLeftTime(lqVar.C());
            }
            if (adContentData != null && adContentData.Z() != null && adContentData.h() == 9) {
                this.I.Code((int) ((((float) adContentData.Z().h()) * 1.0f) / 1000.0f));
            }
            a();
        }
        V(adContentData);
    }

    @Override // com.huawei.hms.ads.lo
    public void I(int i10) {
        PPSSkipButton pPSSkipButton = this.I;
        if (pPSSkipButton != null) {
            pPSSkipButton.Code(i10);
        }
    }

    @Override // com.huawei.hms.ads.lo
    public lq V(int i10) {
        if (i10 == 2) {
            return new PPSImageView(getContext());
        }
        if (i10 != 9) {
            return null;
        }
        Context context = getContext();
        int V = this.F.V();
        int i11 = this.f32910r;
        return new PPSVideoView(context, V, i11 > 0 ? i11 : 0, this.F.I(), 1);
    }

    @Override // com.huawei.hms.ads.lo
    public void V() {
        SloganView sloganView = this.Code;
        if (sloganView != null) {
            sloganView.V();
        }
        View view = this.f32912t;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void destroyView() {
        lq lqVar = this.f32903k;
        if (lqVar != null) {
            lqVar.destroyView();
        }
        try {
            PPSSplashProView pPSSplashProView = this.f32918z;
            if (pPSSplashProView != null) {
                pPSSplashProView.Code();
            }
            PPSSplashSwipeView pPSSplashSwipeView = this.A;
            if (pPSSplashSwipeView != null) {
                pPSSplashSwipeView.V();
            }
            PPSSplashSwipeClickView pPSSplashSwipeClickView = this.G;
            if (pPSSplashSwipeClickView != null) {
                pPSSplashSwipeClickView.V();
            }
            com.huawei.openalliance.ad.inter.d.Code(getContext().getApplicationContext()).V(this.J);
            com.huawei.openalliance.ad.inter.d.Code(getContext().getApplicationContext()).Code(false);
            RelativeLayout relativeLayout = this.V;
            if (relativeLayout != null) {
                relativeLayout.removeAllViews();
            }
        } catch (Throwable th) {
            gl.V("PPSSplashView", "destroy err: %s", th.getClass().getSimpleName());
        }
        this.f32899g = false;
    }

    public com.huawei.openalliance.ad.inter.listeners.b getAdListener() {
        return this.f32897e;
    }

    public hg getAdMediator() {
        return this.f32895c;
    }

    @Override // com.huawei.hms.ads.lo
    public AdSlotParam getAdSlotParam() {
        return this.F;
    }

    @Override // com.huawei.hms.ads.lo
    public int getAdType() {
        return 1;
    }

    @Override // com.huawei.hms.ads.lo
    public int getAudioFocusType() {
        return this.f32907o;
    }

    public View getLogo() {
        return this.D;
    }

    public Bitmap getLogoBitmap() {
        return this.f32901i;
    }

    public int getLogoResId() {
        return this.f32900h;
    }

    public int getMediaNameResId() {
        return this.f32904l;
    }

    public String getMediaNameString() {
        return this.f32905m;
    }

    @Override // com.huawei.hms.ads.hy
    public View getOpenMeasureView() {
        return this;
    }

    public View getSloganView() {
        return this.f32912t;
    }

    public kp getSplashPresenter() {
        return this.f32896d;
    }

    public String getUniqueId() {
        hg hgVar = this.f32895c;
        if (hgVar != null) {
            return hgVar.j();
        }
        return null;
    }

    public boolean isLoaded() {
        hg hgVar = this.f32895c;
        return hgVar != null && hgVar.Code() == com.huawei.openalliance.ad.constant.b.LOADED;
    }

    public boolean isLoading() {
        hg hgVar = this.f32895c;
        return hgVar == null ? this.f32899g : hgVar.Code() == com.huawei.openalliance.ad.constant.b.LOADING;
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        DisplayCutout displayCutout;
        gl.V("PPSSplashView", "onApplyWindowInsets");
        if (ay.V() && windowInsets != null && (displayCutout = windowInsets.getDisplayCutout()) != null) {
            List<Rect> boundingRects = displayCutout.getBoundingRects();
            if (!aa.Code(boundingRects)) {
                this.f32908p = boundingRects.get(0).height();
            }
            this.f32909q = displayCutout.getSafeInsetLeft();
            gl.V("PPSSplashView", "notchHeight left:" + this.f32909q);
            this.f32910r = displayCutout.getSafeInsetRight();
            gl.V("PPSSplashView", "notchHeight right:" + this.f32910r);
        }
        if (this.f32908p <= 0 && Build.VERSION.SDK_INT >= 26 && ea.Code(getContext()).Code(getContext())) {
            this.f32908p = Math.max(this.f32908p, ea.Code(getContext()).Code(this));
        }
        gl.V("PPSSplashView", "notchHeight:" + this.f32908p);
        return super.onApplyWindowInsets(windowInsets);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        gl.V("PPSSplashView", "onAttachedToWindow");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ba.Code(this.f32915w);
        PPSSplashProView pPSSplashProView = this.f32918z;
        if (pPSSplashProView != null) {
            pPSSplashProView.Code();
        }
        PPSSplashSwipeView pPSSplashSwipeView = this.A;
        if (pPSSplashSwipeView != null) {
            pPSSplashSwipeView.V();
        }
        PPSSplashSwipeClickView pPSSplashSwipeClickView = this.G;
        if (pPSSplashSwipeClickView != null) {
            pPSSplashSwipeClickView.V();
        }
    }

    public void pauseView() {
        lq lqVar = this.f32903k;
        if (lqVar != null) {
            lqVar.pauseView();
        }
        PPSSplashProView pPSSplashProView = this.f32918z;
        if (pPSSplashProView != null) {
            pPSSplashProView.Code();
        }
        PPSSplashSwipeView pPSSplashSwipeView = this.A;
        if (pPSSplashSwipeView != null) {
            pPSSplashSwipeView.V();
        }
        PPSSplashSwipeClickView pPSSplashSwipeClickView = this.G;
        if (pPSSplashSwipeClickView != null) {
            pPSSplashSwipeClickView.V();
        }
    }

    public void resumeView() {
        lq lqVar = this.f32903k;
        if (lqVar != null) {
            lqVar.resumeView();
        }
    }

    public void setAdActionListener(com.huawei.openalliance.ad.inter.listeners.a aVar) {
        this.f32898f = aVar;
        hg hgVar = this.f32895c;
        if (hgVar != null) {
            hgVar.Code(aVar);
        }
    }

    public void setAdListener(com.huawei.openalliance.ad.inter.listeners.b bVar) {
        this.f32897e = bVar;
        this.f32896d.Code(bVar);
        hg hgVar = this.f32895c;
        if (hgVar != null) {
            hgVar.Code(bVar);
        }
    }

    public void setAdSlotParam(AdSlotParam adSlotParam) {
        if (v.Code(getContext())) {
            int Code = ax.Code(getContext(), adSlotParam.V());
            int V = ax.V(getContext(), adSlotParam.V());
            adSlotParam.Z(Code);
            adSlotParam.B(V);
            adSlotParam.I(this.f32916x);
            adSlotParam.L(Integer.valueOf(this.f32911s));
            adSlotParam.Code(dy.Code(adSlotParam.B()));
            adSlotParam.Z((Integer) 0);
            adSlotParam.B(Integer.valueOf((HiAd.Code(getContext()).isNewProcess() && com.huawei.openalliance.ad.utils.c.L(getContext())) ? 0 : 1));
            this.F = adSlotParam;
            com.huawei.openalliance.ad.inter.h Code2 = com.huawei.openalliance.ad.inter.g.Code(getContext());
            if (Code2 instanceof com.huawei.openalliance.ad.inter.g) {
                ((com.huawei.openalliance.ad.inter.g) Code2).I(adSlotParam);
            }
        }
    }

    public void setAudioFocusType(int i10) {
        this.f32907o = i10;
        lq lqVar = this.f32903k;
        if (lqVar != null) {
            lqVar.setAudioFocusType(i10);
        }
    }

    public void setLinkedSupportMode(int i10) {
        this.f32911s = i10;
    }

    public void setLogo(View view) {
        setLogo(view, 8);
    }

    public void setLogo(View view, int i10) {
        this.D = view;
        view.setVisibility(i10);
        this.L = i10;
    }

    public void setLogoBitmap(Bitmap bitmap) {
        this.f32901i = bitmap;
        this.f32900h = 0;
        F();
    }

    public void setLogoResId(int i10) {
        this.f32900h = i10;
        this.f32901i = null;
        F();
    }

    public void setMediaNameResId(int i10) {
        this.f32904l = i10;
        this.f32905m = null;
        C();
    }

    public void setMediaNameString(String str) {
        this.f32905m = str;
        this.f32904l = 0;
        C();
    }

    public void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig) {
        this.f32917y = rewardVerifyConfig;
    }

    public void setSloganResId(int i10) {
        if (v.Code(getContext())) {
            if (I(getContext())) {
                gl.I("PPSSplashView", "setSloganResId - activity finished, not add view");
                return;
            }
            if (this.F == null && !(this instanceof SplashView)) {
                throw new ff("Must invoke SplashAdView's setAdSlotParam method before invoke setSloganResId method");
            }
            if (this.Code == null) {
                SloganView sloganView = new SloganView(getContext(), i10, 1);
                this.Code = sloganView;
                int i11 = this.f32906n;
                if (i11 > 0) {
                    sloganView.setWideSloganResId(i11);
                }
                this.V.addView(this.Code, new RelativeLayout.LayoutParams(-1, -1));
                this.Code.V();
            }
        }
    }

    public void setSloganView(View view) {
        if (view != null) {
            this.f32912t = view;
            view.setVisibility(8);
        }
    }

    public void setWideSloganResId(int i10) {
        SloganView sloganView = this.Code;
        if (sloganView != null) {
            sloganView.setWideSloganResId(i10);
        } else {
            this.f32906n = i10;
        }
    }
}
