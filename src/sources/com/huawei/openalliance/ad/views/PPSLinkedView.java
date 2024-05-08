package com.huawei.openalliance.ad.views;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.DisplayCutout;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.ads.ea;
import com.huawei.hms.ads.eo;
import com.huawei.hms.ads.fr;
import com.huawei.hms.ads.fs;
import com.huawei.hms.ads.gf;
import com.huawei.hms.ads.gg;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.gt;
import com.huawei.hms.ads.gu;
import com.huawei.hms.ads.gv;
import com.huawei.hms.ads.gw;
import com.huawei.hms.ads.gy;
import com.huawei.hms.ads.gz;
import com.huawei.hms.ads.ha;
import com.huawei.hms.ads.hg;
import com.huawei.hms.ads.hj;
import com.huawei.hms.ads.ic;
import com.huawei.hms.ads.io;
import com.huawei.hms.ads.jk;
import com.huawei.hms.ads.jw;
import com.huawei.hms.ads.ki;
import com.huawei.hms.ads.kt;
import com.huawei.hms.ads.la;
import com.huawei.hms.ads.lb;
import com.huawei.hms.ads.lf;
import com.huawei.hms.ads.ll;
import com.huawei.hms.ads.splash.R;
import com.huawei.openalliance.ad.beans.inner.AnalysisEventReport;
import com.huawei.openalliance.ad.beans.metadata.InteractCfg;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.l;
import com.huawei.openalliance.ad.inter.data.m;
import com.huawei.openalliance.ad.inter.data.v;
import com.huawei.openalliance.ad.inter.listeners.k;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.au;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PPSLinkedView extends RelativeLayout implements hj.a, ll {
    private static double F = 1.0E-7d;
    private static View.OnTouchListener bo = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.5
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    };
    private List<View> A;
    private PPSSplashView E;
    private WindowManager G;
    private com.huawei.openalliance.ad.media.b H;
    private PPSSkipButton J;
    private ImageView K;
    private boolean M;
    private h N;
    private View O;
    private int P;
    private ViewStub Q;
    private View R;
    private View T;
    private int U;
    private boolean W;
    private boolean aA;
    private boolean aB;
    private boolean aC;
    private ValueAnimator aD;
    private boolean aE;
    private boolean aF;
    private int aG;
    private boolean aH;
    private Integer aI;
    private boolean aJ;
    private boolean aK;
    private boolean aL;
    private boolean aM;
    private int aN;
    private final String aO;
    private PPSSplashProView aP;
    private PPSSplashSwipeView aQ;
    private PPSSplashTwistView aR;
    private lb aS;
    private la aT;
    private double aU;
    private double aV;
    private double aW;
    private float aX;
    private float aY;
    private long aZ;

    /* renamed from: aa, reason: collision with root package name */
    private long f32777aa;

    /* renamed from: ab, reason: collision with root package name */
    private long f32778ab;

    /* renamed from: ac, reason: collision with root package name */
    private long f32779ac;

    /* renamed from: ad, reason: collision with root package name */
    private boolean f32780ad;

    /* renamed from: ae, reason: collision with root package name */
    private boolean f32781ae;
    private final String af;
    private int ag;
    private int ah;
    private float ai;
    private float aj;
    private int ak;
    private int al;
    private int am;
    private int an;
    private float ao;
    private float ap;
    private float aq;

    /* renamed from: ar, reason: collision with root package name */
    private int[] f32782ar;
    private boolean as;
    private boolean at;
    private k au;
    private boolean av;
    private boolean aw;
    private boolean ax;
    private boolean ay;
    private boolean az;

    /* renamed from: ba, reason: collision with root package name */
    private int f32783ba;

    /* renamed from: bb, reason: collision with root package name */
    private int f32784bb;

    /* renamed from: bc, reason: collision with root package name */
    private int f32785bc;

    /* renamed from: bd, reason: collision with root package name */
    private int f32786bd;

    /* renamed from: be, reason: collision with root package name */
    private WeakReference<Context> f32787be;
    private int bf;
    private PPSSplashSwipeClickView bg;
    private PPSSplashTwistClickView bh;
    private boolean bi;
    private ha bj;
    private gy bk;
    private gw bl;
    private View.OnClickListener bm;
    private View.OnTouchListener bn;
    private View.OnTouchListener bp;
    private View.OnTouchListener bq;
    private gv br;
    private gz bs;
    private gu bt;
    private View.OnClickListener bu;

    /* renamed from: c, reason: collision with root package name */
    private io f32788c;

    /* renamed from: d, reason: collision with root package name */
    private m f32789d;

    /* renamed from: e, reason: collision with root package name */
    private PPSAdvertiserInfoDialog f32790e;

    /* renamed from: f, reason: collision with root package name */
    private Context f32791f;

    /* renamed from: g, reason: collision with root package name */
    private fr f32792g;

    /* renamed from: h, reason: collision with root package name */
    private PPSWLSView f32793h;

    /* renamed from: i, reason: collision with root package name */
    private PPSSplashAdSourceView f32794i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f32795j;

    /* renamed from: k, reason: collision with root package name */
    private hj f32796k;

    /* renamed from: l, reason: collision with root package name */
    private l f32797l;

    /* renamed from: m, reason: collision with root package name */
    private hg f32798m;

    /* renamed from: n, reason: collision with root package name */
    private int f32799n;

    /* renamed from: o, reason: collision with root package name */
    private v f32800o;

    /* renamed from: p, reason: collision with root package name */
    private ki f32801p;

    /* renamed from: q, reason: collision with root package name */
    private g f32802q;

    /* renamed from: r, reason: collision with root package name */
    private e f32803r;

    /* renamed from: s, reason: collision with root package name */
    private f f32804s;

    /* renamed from: t, reason: collision with root package name */
    private gt f32805t;

    /* renamed from: u, reason: collision with root package name */
    private gz f32806u;

    /* renamed from: v, reason: collision with root package name */
    private SplashLinkedVideoView f32807v;

    /* renamed from: w, reason: collision with root package name */
    private com.huawei.openalliance.ad.views.d f32808w;

    /* renamed from: x, reason: collision with root package name */
    private LinkedSurfaceView f32809x;

    /* renamed from: y, reason: collision with root package name */
    private TextureGlVideoView f32810y;

    /* renamed from: z, reason: collision with root package name */
    private PPSDestView f32811z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements View.OnClickListener {
        private WeakReference<PPSLinkedView> Code;
        private AdContentData V;

        public a(PPSLinkedView pPSLinkedView, AdContentData adContentData) {
            this.Code = new WeakReference<>(pPSLinkedView);
            this.V = adContentData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            final PPSLinkedView pPSLinkedView = this.Code.get();
            if (pPSLinkedView != null) {
                final int[] choiceViewLoc = pPSLinkedView.f32793h.getChoiceViewLoc();
                final int[] choiceViewSize = pPSLinkedView.f32793h.getChoiceViewSize();
                if (com.huawei.openalliance.ad.utils.v.Code(choiceViewLoc, 2) && com.huawei.openalliance.ad.utils.v.Code(choiceViewSize, 2)) {
                    ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            pPSLinkedView.Code(a.this.V, choiceViewLoc, choiceViewSize);
                        }
                    });
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b extends BroadcastReceiver {
        private WeakReference<PPSLinkedView> Code;

        public b(PPSLinkedView pPSLinkedView) {
            this.Code = new WeakReference<>(pPSLinkedView);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                PPSLinkedView pPSLinkedView = this.Code.get();
                if (pPSLinkedView == null) {
                    gl.I("PPSLinkedView", "view is null");
                    return;
                }
                v vVar = pPSLinkedView.f32800o;
                l lVar = pPSLinkedView.f32797l;
                k kVar = pPSLinkedView.au;
                if (!gg.Code.equals(intent.getAction())) {
                    if (!gg.V.equals(intent.getAction()) || vVar == null) {
                        return;
                    }
                    gl.V("PPSLinkedView", "LinkedSplashAdReceiver, progress resume %s  soundSwitch %s", Integer.valueOf(vVar.L()), vVar.a());
                    if (lVar != null) {
                        lVar.Code(vVar);
                    }
                    if (kVar != null) {
                        kVar.V(lVar);
                    }
                    gf.Code(context).V();
                    return;
                }
                int intExtra = intent.getIntExtra(gg.Z, 0);
                String stringExtra = intent.getStringExtra(gg.B);
                gl.V("PPSLinkedView", "LinkedSplashAdReceiver playProgress " + intExtra);
                if (vVar != null) {
                    vVar.Code(stringExtra);
                    vVar.Code(intExtra);
                }
            } catch (Throwable th) {
                gl.I("PPSLinkedView", "LinkedSplashAdReceiver error: %s", th.getClass().getSimpleName());
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class c implements la.a {
        private c() {
        }

        private void Code(int i10) {
            if (PPSLinkedView.this.aZ == 0) {
                PPSLinkedView.this.aZ = System.currentTimeMillis();
                return;
            }
            if (PPSLinkedView.this.f32783ba <= 2 || System.currentTimeMillis() - PPSLinkedView.this.aZ <= 1000) {
                return;
            }
            double d10 = i10;
            if (PPSLinkedView.this.aU >= d10 || PPSLinkedView.this.aV >= d10 || PPSLinkedView.this.aW >= d10) {
                gl.V("PPSLinkedView", "limitDegree: %s X: %s Y: %s Z: %s", Integer.valueOf(i10), Double.valueOf(PPSLinkedView.this.aU), Double.valueOf(PPSLinkedView.this.aV), Double.valueOf(PPSLinkedView.this.aW));
                PPSLinkedView.this.aZ = System.currentTimeMillis();
                PPSLinkedView.this.f32783ba = 0;
                PPSLinkedView.this.aT.V();
                PPSLinkedView.this.aS.V();
                PPSLinkedView.this.V(19);
            }
        }

        @Override // com.huawei.hms.ads.la.a
        public void Code(float f10, float f11, float f12) {
            if (gl.Code()) {
                gl.Code("PPSLinkedView", "limitAcc: %s, xAcc: %s yAcc: %s zAcc: %s", Integer.valueOf(PPSLinkedView.this.f32786bd), Float.valueOf(f10), Float.valueOf(f11), Float.valueOf(f12));
            }
            if (Math.abs(f10) >= PPSLinkedView.this.f32786bd && PPSLinkedView.this.aX * f10 <= 0.0f) {
                PPSLinkedView.ae(PPSLinkedView.this);
                PPSLinkedView.this.aX = f10;
            } else if (Math.abs(f11) >= PPSLinkedView.this.f32786bd && PPSLinkedView.this.aY * f11 <= 0.0f) {
                PPSLinkedView.ae(PPSLinkedView.this);
                PPSLinkedView.this.aY = f11;
            }
            Code(PPSLinkedView.this.f32785bc);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class d implements lb.a {
        private int B;
        private int C;
        private Integer I;
        private int S;
        private Integer V;
        private Integer Z;

        private d() {
        }

        @Override // com.huawei.hms.ads.lb.a
        public void Code(double d10, double d11, double d12) {
            gl.V("PPSLinkedView", "xDegree=%s, yDegree=%s, zDegree=%s", Double.valueOf(d10), Double.valueOf(d11), Double.valueOf(d12));
            if (this.V == null) {
                this.V = Integer.valueOf((int) d10);
            }
            if (this.I == null) {
                this.I = Integer.valueOf((int) d11);
            }
            if (this.Z == null) {
                this.Z = Integer.valueOf((int) d12);
            }
            PPSLinkedView pPSLinkedView = PPSLinkedView.this;
            double abs = Math.abs(d10 - this.B);
            double abs2 = Math.abs(d10 - this.V.intValue());
            if (abs > 180.0d) {
                abs2 = 360.0d - abs2;
            }
            pPSLinkedView.aU = abs2;
            PPSLinkedView.this.aV = Math.abs(d11 - ((double) this.C)) > 180.0d ? 360.0d - Math.abs(d11 - this.I.intValue()) : Math.abs(d10 - this.V.intValue());
            PPSLinkedView.this.aW = Math.abs(d12 - ((double) this.S)) > 180.0d ? 360.0d - Math.abs(d12 - this.Z.intValue()) : Math.abs(d10 - this.V.intValue());
            if (gl.Code()) {
                gl.Code("PPSLinkedView", "diffX: %s diffY: %s diffZ: %s", Double.valueOf(PPSLinkedView.this.aU), Double.valueOf(PPSLinkedView.this.aV), Double.valueOf(PPSLinkedView.this.aW));
            }
            this.B = (int) d10;
            this.C = (int) d11;
            this.S = (int) d12;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface e {
        void Code(int i10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface f {
        void Code();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface g {
        void Code(int i10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class h extends CountDownTimer {
        public final /* synthetic */ PPSLinkedView Code;

        @Override // android.os.CountDownTimer
        public void onFinish() {
            gl.V("PPSLinkedView", "CountDownTimer onFinish");
            if (this.Code.am == 1) {
                this.Code.Code((Integer) 8, false);
                this.Code.aG = 2;
                ba.Code(this.Code.aO);
                if (this.Code.aB) {
                    return;
                }
                this.Code.t();
                this.Code.aB = true;
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
            gl.Code("PPSLinkedView", "onTick: %s", Long.valueOf(j10));
        }
    }

    public PPSLinkedView(Context context) {
        super(context);
        this.f32788c = new ic();
        this.f32795j = true;
        this.f32799n = 1;
        this.M = true;
        this.U = 0;
        this.W = false;
        this.f32778ab = -1L;
        this.f32780ad = false;
        this.f32781ae = false;
        this.af = u.ah + hashCode();
        this.ag = 0;
        this.ah = 0;
        this.an = com.alipay.sdk.data.a.f4564a;
        this.f32782ar = new int[2];
        this.as = false;
        this.at = false;
        this.av = false;
        this.aw = false;
        this.ax = false;
        this.ay = false;
        this.az = false;
        this.aA = false;
        this.aB = false;
        this.aC = false;
        this.aE = false;
        this.aF = false;
        this.aH = true;
        this.aJ = true;
        this.aK = true;
        this.aL = false;
        this.aM = false;
        this.aN = 0;
        this.aO = "skip_btn_delay_id_" + hashCode();
        this.bi = false;
        this.bj = new ha() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.20
            @Override // com.huawei.hms.ads.ha
            public void Code() {
                gl.Code("PPSLinkedView", "onVideoRenderStart, alreadyNotified: %s", Boolean.valueOf(PPSLinkedView.this.aL));
                if (PPSLinkedView.this.aL) {
                    return;
                }
                PPSLinkedView.this.aL = true;
                PPSLinkedView.this.v();
            }
        };
        this.bk = new gy() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.21
            @Override // com.huawei.hms.ads.gy
            public void Code(int i10, int i11) {
                if (i11 > 0 && !PPSLinkedView.this.aL) {
                    gl.Code("PPSLinkedView", "onProgress onRenderStart, playtime: %s", Integer.valueOf(i11));
                    PPSLinkedView.this.aL = true;
                    PPSLinkedView.this.v();
                }
                if (i11 > 0) {
                    PPSLinkedView.this.f32800o.Code(i11);
                    PPSLinkedView.this.setPlaying(true);
                }
                if (PPSLinkedView.this.f32805t != null) {
                    PPSLinkedView.this.f32805t.Code(i10, i11);
                }
                if (PPSLinkedView.this.W) {
                    PPSLinkedView.this.f32788c.Code(i10);
                }
                if (PPSLinkedView.this.f32801p != null) {
                    PPSLinkedView.this.f32801p.Code(PPSLinkedView.this.f32791f, i11, PPSLinkedView.this.f32800o == null ? 0L : PPSLinkedView.this.f32800o.I());
                }
            }

            @Override // com.huawei.hms.ads.gy
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i10) {
                gl.V("PPSLinkedView", "onMediaStart: %s", Integer.valueOf(i10));
                PPSLinkedView.this.W = true;
                PPSLinkedView.this.setPlaying(true);
                PPSLinkedView.this.f32779ac = i10;
                PPSLinkedView.this.f32777aa = System.currentTimeMillis();
                if (!PPSLinkedView.this.bi) {
                    PPSLinkedView.this.f32801p.Code(au.Code(Long.valueOf(PPSLinkedView.this.f32777aa)));
                    PPSLinkedView.this.f32801p.Code(PPSLinkedView.this.f32777aa);
                }
                if (PPSLinkedView.this.f32798m != null) {
                    PPSLinkedView.this.f32798m.Code(PPSLinkedView.this.f32777aa);
                }
                if (i10 > 0) {
                    PPSLinkedView.this.f32801p.S();
                    PPSLinkedView.this.f32788c.f();
                } else {
                    PPSLinkedView.this.f32801p.C();
                    if (PPSLinkedView.this.f32788c != null && PPSLinkedView.this.f32800o != null) {
                        gl.V("PPSLinkedView", "om start");
                        PPSLinkedView.this.f32788c.Code(PPSLinkedView.this.f32800o.I(), true ^ "y".equals(PPSLinkedView.this.f32800o.a()));
                    }
                }
                if (PPSLinkedView.this.f32797l != null && PPSLinkedView.this.f32797l.I()) {
                    eo.Code(PPSLinkedView.this.f32791f, PPSLinkedView.this.f32797l.m(), PPSLinkedView.this.f32797l.D(), (System.currentTimeMillis() - PPSLinkedView.this.f32792g.Q().longValue()) - PPSLinkedView.this.f32792g.R(), PPSLinkedView.this.f32797l.l(), "84");
                }
                if (PPSLinkedView.this.f32805t != null) {
                    PPSLinkedView.this.f32805t.Code(i10);
                }
            }

            @Override // com.huawei.hms.ads.gy
            public void I(com.huawei.openalliance.ad.media.b bVar, int i10) {
                gl.V("PPSLinkedView", "onMediaStop: %s", Integer.valueOf(i10));
                PPSLinkedView.this.Code(i10, false);
                if (PPSLinkedView.this.f32805t != null) {
                    PPSLinkedView.this.f32805t.I(i10);
                }
            }

            @Override // com.huawei.hms.ads.gy
            public void V(com.huawei.openalliance.ad.media.b bVar, int i10) {
                gl.V("PPSLinkedView", "onMediaPause: %s", Integer.valueOf(i10));
                PPSLinkedView.this.Code(i10, false);
                if (PPSLinkedView.this.f32805t != null) {
                    PPSLinkedView.this.f32805t.V(i10);
                }
            }

            @Override // com.huawei.hms.ads.gy
            public void Z(com.huawei.openalliance.ad.media.b bVar, int i10) {
                gl.V("PPSLinkedView", "onMediaCompletion: %s", Integer.valueOf(i10));
                PPSLinkedView.this.Code(i10, true);
                PPSLinkedView.this.bi = true;
                if (PPSLinkedView.this.am == 2 && PPSLinkedView.this.f32796k != null && PPSLinkedView.this.f32796k.F()) {
                    gl.V("PPSLinkedView", "onMediaCompletion, start play");
                    PPSLinkedView.this.H.V();
                    PPSLinkedView.this.setPlaying(true);
                }
                if (PPSLinkedView.this.f32805t != null) {
                    PPSLinkedView.this.f32805t.Z(i10);
                }
                if (PPSLinkedView.this.f32801p != null) {
                    long j10 = i10;
                    PPSLinkedView.this.f32801p.Code(PPSLinkedView.this.f32791f, j10, j10);
                }
            }
        };
        this.bl = new gw() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.2
            @Override // com.huawei.hms.ads.gw
            public void Code(int i10) {
                gl.V("PPSLinkedView", "onDurationReady:");
                if (!PPSLinkedView.this.aF && PPSLinkedView.this.f32804s != null) {
                    PPSLinkedView.this.aF = true;
                    PPSLinkedView.this.f32804s.Code();
                }
                if (PPSLinkedView.this.aI == null) {
                    PPSLinkedView.this.aI = Integer.valueOf(i10);
                    if (PPSLinkedView.this.f32797l == null || PPSLinkedView.this.f32797l.C() == null) {
                        return;
                    }
                    PPSLinkedView.this.f32797l.C().V(i10);
                }
            }

            @Override // com.huawei.hms.ads.gw
            public void V(int i10) {
            }
        };
        this.bm = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i10;
                if (PPSLinkedView.this.f32795j) {
                    if (PPSLinkedView.this.am == 1) {
                        PPSLinkedView pPSLinkedView = PPSLinkedView.this;
                        if (!pPSLinkedView.Code(pPSLinkedView.f32789d)) {
                            return;
                        }
                    }
                    PPSLinkedView.this.f32795j = false;
                    gl.V("PPSLinkedView", "onClick");
                    if (PPSLinkedView.this.am == 2) {
                        i10 = 10;
                    } else {
                        i10 = 2 == PPSLinkedView.this.aP.getMode() ? 17 : 9;
                        PPSLinkedView.this.l();
                    }
                    PPSLinkedView.this.V(i10);
                    ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PPSLinkedView.this.f32795j = true;
                        }
                    }, 500L);
                }
            }
        };
        this.bn = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.4
            private float I;
            private float V;

            private boolean Code(float f10, float f11) {
                if (PPSLinkedView.this.bf != 0 || f11 < PPSLinkedView.this.f32784bb) {
                    return 1 == PPSLinkedView.this.bf && Math.sqrt((double) ((f10 * f10) + (f11 * f11))) >= ((double) PPSLinkedView.this.f32784bb);
                }
                return true;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.V = motionEvent.getX();
                    this.I = motionEvent.getY();
                    if (gl.Code()) {
                        gl.Code("PPSLinkedView", "startX = %s, startY = %s", Float.valueOf(this.V), Float.valueOf(this.I));
                    }
                    PPSLinkedView.this.f32789d = lf.Code(view, motionEvent);
                }
                if (2 == motionEvent.getAction()) {
                    float x10 = motionEvent.getX();
                    float y10 = motionEvent.getY();
                    if (gl.Code()) {
                        gl.Code("PPSLinkedView", "endX = %s, endY = %s, startX - endX = %s, startY-endY = %s", Float.valueOf(x10), Float.valueOf(y10), Float.valueOf(this.V - x10), Float.valueOf(this.I - y10));
                    }
                    if (Code(this.V - x10, this.I - y10)) {
                        PPSLinkedView.this.f32807v.setOnTouchListener(null);
                        PPSLinkedView.this.V(18);
                    }
                }
                return true;
            }
        };
        this.bp = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.setEnabled(false);
                PPSLinkedView.this.f32807v.setOnTouchListener(null);
                if (motionEvent.getAction() != 0) {
                    return true;
                }
                PPSLinkedView.this.f32789d = com.huawei.openalliance.ad.utils.i.Code(view, motionEvent);
                PPSLinkedView.this.V(17);
                return true;
            }
        };
        this.bq = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                PPSLinkedView.this.f32789d = lf.Code(view, motionEvent);
                return false;
            }
        };
        this.br = new gv() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.8
            @Override // com.huawei.hms.ads.gv
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i10, int i11, int i12) {
                gl.I("PPSLinkedView", "media play error, isMoved: %s", Boolean.valueOf(PPSLinkedView.this.as));
                PPSLinkedView.this.z();
                PPSLinkedView.this.A();
                PPSLinkedView.this.setPlaying(false);
                if (PPSLinkedView.this.f32805t != null) {
                    gl.V("PPSLinkedView", "call onMediaError. ");
                    PPSLinkedView.this.f32805t.Code(i10, i11, i12);
                }
            }
        };
        this.bs = new gz() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.9
            @Override // com.huawei.hms.ads.gz
            public void Code() {
                gl.V("PPSLinkedView", "onMute");
                if (PPSLinkedView.this.f32806u != null) {
                    PPSLinkedView.this.f32806u.Code();
                }
                PPSLinkedView.this.f32788c.V(0.0f);
            }

            @Override // com.huawei.hms.ads.gz
            public void V() {
                gl.V("PPSLinkedView", "onUnmute");
                if (PPSLinkedView.this.f32806u != null) {
                    PPSLinkedView.this.f32806u.V();
                }
                PPSLinkedView.this.f32788c.V(1.0f);
            }
        };
        this.bt = new gu() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.10
            @Override // com.huawei.hms.ads.gu
            public void Code() {
                PPSLinkedView.this.f32788c.b();
            }

            @Override // com.huawei.hms.ads.gu
            public void Code(int i10) {
            }

            @Override // com.huawei.hms.ads.gu
            public void V() {
                PPSLinkedView.this.f32788c.c();
            }
        };
        this.bu = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PPSLinkedView.this.V(!view.isSelected());
            }
        };
        V(context);
    }

    public PPSLinkedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f32788c = new ic();
        this.f32795j = true;
        this.f32799n = 1;
        this.M = true;
        this.U = 0;
        this.W = false;
        this.f32778ab = -1L;
        this.f32780ad = false;
        this.f32781ae = false;
        this.af = u.ah + hashCode();
        this.ag = 0;
        this.ah = 0;
        this.an = com.alipay.sdk.data.a.f4564a;
        this.f32782ar = new int[2];
        this.as = false;
        this.at = false;
        this.av = false;
        this.aw = false;
        this.ax = false;
        this.ay = false;
        this.az = false;
        this.aA = false;
        this.aB = false;
        this.aC = false;
        this.aE = false;
        this.aF = false;
        this.aH = true;
        this.aJ = true;
        this.aK = true;
        this.aL = false;
        this.aM = false;
        this.aN = 0;
        this.aO = "skip_btn_delay_id_" + hashCode();
        this.bi = false;
        this.bj = new ha() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.20
            @Override // com.huawei.hms.ads.ha
            public void Code() {
                gl.Code("PPSLinkedView", "onVideoRenderStart, alreadyNotified: %s", Boolean.valueOf(PPSLinkedView.this.aL));
                if (PPSLinkedView.this.aL) {
                    return;
                }
                PPSLinkedView.this.aL = true;
                PPSLinkedView.this.v();
            }
        };
        this.bk = new gy() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.21
            @Override // com.huawei.hms.ads.gy
            public void Code(int i10, int i11) {
                if (i11 > 0 && !PPSLinkedView.this.aL) {
                    gl.Code("PPSLinkedView", "onProgress onRenderStart, playtime: %s", Integer.valueOf(i11));
                    PPSLinkedView.this.aL = true;
                    PPSLinkedView.this.v();
                }
                if (i11 > 0) {
                    PPSLinkedView.this.f32800o.Code(i11);
                    PPSLinkedView.this.setPlaying(true);
                }
                if (PPSLinkedView.this.f32805t != null) {
                    PPSLinkedView.this.f32805t.Code(i10, i11);
                }
                if (PPSLinkedView.this.W) {
                    PPSLinkedView.this.f32788c.Code(i10);
                }
                if (PPSLinkedView.this.f32801p != null) {
                    PPSLinkedView.this.f32801p.Code(PPSLinkedView.this.f32791f, i11, PPSLinkedView.this.f32800o == null ? 0L : PPSLinkedView.this.f32800o.I());
                }
            }

            @Override // com.huawei.hms.ads.gy
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i10) {
                gl.V("PPSLinkedView", "onMediaStart: %s", Integer.valueOf(i10));
                PPSLinkedView.this.W = true;
                PPSLinkedView.this.setPlaying(true);
                PPSLinkedView.this.f32779ac = i10;
                PPSLinkedView.this.f32777aa = System.currentTimeMillis();
                if (!PPSLinkedView.this.bi) {
                    PPSLinkedView.this.f32801p.Code(au.Code(Long.valueOf(PPSLinkedView.this.f32777aa)));
                    PPSLinkedView.this.f32801p.Code(PPSLinkedView.this.f32777aa);
                }
                if (PPSLinkedView.this.f32798m != null) {
                    PPSLinkedView.this.f32798m.Code(PPSLinkedView.this.f32777aa);
                }
                if (i10 > 0) {
                    PPSLinkedView.this.f32801p.S();
                    PPSLinkedView.this.f32788c.f();
                } else {
                    PPSLinkedView.this.f32801p.C();
                    if (PPSLinkedView.this.f32788c != null && PPSLinkedView.this.f32800o != null) {
                        gl.V("PPSLinkedView", "om start");
                        PPSLinkedView.this.f32788c.Code(PPSLinkedView.this.f32800o.I(), true ^ "y".equals(PPSLinkedView.this.f32800o.a()));
                    }
                }
                if (PPSLinkedView.this.f32797l != null && PPSLinkedView.this.f32797l.I()) {
                    eo.Code(PPSLinkedView.this.f32791f, PPSLinkedView.this.f32797l.m(), PPSLinkedView.this.f32797l.D(), (System.currentTimeMillis() - PPSLinkedView.this.f32792g.Q().longValue()) - PPSLinkedView.this.f32792g.R(), PPSLinkedView.this.f32797l.l(), "84");
                }
                if (PPSLinkedView.this.f32805t != null) {
                    PPSLinkedView.this.f32805t.Code(i10);
                }
            }

            @Override // com.huawei.hms.ads.gy
            public void I(com.huawei.openalliance.ad.media.b bVar, int i10) {
                gl.V("PPSLinkedView", "onMediaStop: %s", Integer.valueOf(i10));
                PPSLinkedView.this.Code(i10, false);
                if (PPSLinkedView.this.f32805t != null) {
                    PPSLinkedView.this.f32805t.I(i10);
                }
            }

            @Override // com.huawei.hms.ads.gy
            public void V(com.huawei.openalliance.ad.media.b bVar, int i10) {
                gl.V("PPSLinkedView", "onMediaPause: %s", Integer.valueOf(i10));
                PPSLinkedView.this.Code(i10, false);
                if (PPSLinkedView.this.f32805t != null) {
                    PPSLinkedView.this.f32805t.V(i10);
                }
            }

            @Override // com.huawei.hms.ads.gy
            public void Z(com.huawei.openalliance.ad.media.b bVar, int i10) {
                gl.V("PPSLinkedView", "onMediaCompletion: %s", Integer.valueOf(i10));
                PPSLinkedView.this.Code(i10, true);
                PPSLinkedView.this.bi = true;
                if (PPSLinkedView.this.am == 2 && PPSLinkedView.this.f32796k != null && PPSLinkedView.this.f32796k.F()) {
                    gl.V("PPSLinkedView", "onMediaCompletion, start play");
                    PPSLinkedView.this.H.V();
                    PPSLinkedView.this.setPlaying(true);
                }
                if (PPSLinkedView.this.f32805t != null) {
                    PPSLinkedView.this.f32805t.Z(i10);
                }
                if (PPSLinkedView.this.f32801p != null) {
                    long j10 = i10;
                    PPSLinkedView.this.f32801p.Code(PPSLinkedView.this.f32791f, j10, j10);
                }
            }
        };
        this.bl = new gw() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.2
            @Override // com.huawei.hms.ads.gw
            public void Code(int i10) {
                gl.V("PPSLinkedView", "onDurationReady:");
                if (!PPSLinkedView.this.aF && PPSLinkedView.this.f32804s != null) {
                    PPSLinkedView.this.aF = true;
                    PPSLinkedView.this.f32804s.Code();
                }
                if (PPSLinkedView.this.aI == null) {
                    PPSLinkedView.this.aI = Integer.valueOf(i10);
                    if (PPSLinkedView.this.f32797l == null || PPSLinkedView.this.f32797l.C() == null) {
                        return;
                    }
                    PPSLinkedView.this.f32797l.C().V(i10);
                }
            }

            @Override // com.huawei.hms.ads.gw
            public void V(int i10) {
            }
        };
        this.bm = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i10;
                if (PPSLinkedView.this.f32795j) {
                    if (PPSLinkedView.this.am == 1) {
                        PPSLinkedView pPSLinkedView = PPSLinkedView.this;
                        if (!pPSLinkedView.Code(pPSLinkedView.f32789d)) {
                            return;
                        }
                    }
                    PPSLinkedView.this.f32795j = false;
                    gl.V("PPSLinkedView", "onClick");
                    if (PPSLinkedView.this.am == 2) {
                        i10 = 10;
                    } else {
                        i10 = 2 == PPSLinkedView.this.aP.getMode() ? 17 : 9;
                        PPSLinkedView.this.l();
                    }
                    PPSLinkedView.this.V(i10);
                    ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PPSLinkedView.this.f32795j = true;
                        }
                    }, 500L);
                }
            }
        };
        this.bn = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.4
            private float I;
            private float V;

            private boolean Code(float f10, float f11) {
                if (PPSLinkedView.this.bf != 0 || f11 < PPSLinkedView.this.f32784bb) {
                    return 1 == PPSLinkedView.this.bf && Math.sqrt((double) ((f10 * f10) + (f11 * f11))) >= ((double) PPSLinkedView.this.f32784bb);
                }
                return true;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.V = motionEvent.getX();
                    this.I = motionEvent.getY();
                    if (gl.Code()) {
                        gl.Code("PPSLinkedView", "startX = %s, startY = %s", Float.valueOf(this.V), Float.valueOf(this.I));
                    }
                    PPSLinkedView.this.f32789d = lf.Code(view, motionEvent);
                }
                if (2 == motionEvent.getAction()) {
                    float x10 = motionEvent.getX();
                    float y10 = motionEvent.getY();
                    if (gl.Code()) {
                        gl.Code("PPSLinkedView", "endX = %s, endY = %s, startX - endX = %s, startY-endY = %s", Float.valueOf(x10), Float.valueOf(y10), Float.valueOf(this.V - x10), Float.valueOf(this.I - y10));
                    }
                    if (Code(this.V - x10, this.I - y10)) {
                        PPSLinkedView.this.f32807v.setOnTouchListener(null);
                        PPSLinkedView.this.V(18);
                    }
                }
                return true;
            }
        };
        this.bp = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.setEnabled(false);
                PPSLinkedView.this.f32807v.setOnTouchListener(null);
                if (motionEvent.getAction() != 0) {
                    return true;
                }
                PPSLinkedView.this.f32789d = com.huawei.openalliance.ad.utils.i.Code(view, motionEvent);
                PPSLinkedView.this.V(17);
                return true;
            }
        };
        this.bq = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                PPSLinkedView.this.f32789d = lf.Code(view, motionEvent);
                return false;
            }
        };
        this.br = new gv() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.8
            @Override // com.huawei.hms.ads.gv
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i10, int i11, int i12) {
                gl.I("PPSLinkedView", "media play error, isMoved: %s", Boolean.valueOf(PPSLinkedView.this.as));
                PPSLinkedView.this.z();
                PPSLinkedView.this.A();
                PPSLinkedView.this.setPlaying(false);
                if (PPSLinkedView.this.f32805t != null) {
                    gl.V("PPSLinkedView", "call onMediaError. ");
                    PPSLinkedView.this.f32805t.Code(i10, i11, i12);
                }
            }
        };
        this.bs = new gz() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.9
            @Override // com.huawei.hms.ads.gz
            public void Code() {
                gl.V("PPSLinkedView", "onMute");
                if (PPSLinkedView.this.f32806u != null) {
                    PPSLinkedView.this.f32806u.Code();
                }
                PPSLinkedView.this.f32788c.V(0.0f);
            }

            @Override // com.huawei.hms.ads.gz
            public void V() {
                gl.V("PPSLinkedView", "onUnmute");
                if (PPSLinkedView.this.f32806u != null) {
                    PPSLinkedView.this.f32806u.V();
                }
                PPSLinkedView.this.f32788c.V(1.0f);
            }
        };
        this.bt = new gu() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.10
            @Override // com.huawei.hms.ads.gu
            public void Code() {
                PPSLinkedView.this.f32788c.b();
            }

            @Override // com.huawei.hms.ads.gu
            public void Code(int i10) {
            }

            @Override // com.huawei.hms.ads.gu
            public void V() {
                PPSLinkedView.this.f32788c.c();
            }
        };
        this.bu = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PPSLinkedView.this.V(!view.isSelected());
            }
        };
        V(context);
    }

    public PPSLinkedView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f32788c = new ic();
        this.f32795j = true;
        this.f32799n = 1;
        this.M = true;
        this.U = 0;
        this.W = false;
        this.f32778ab = -1L;
        this.f32780ad = false;
        this.f32781ae = false;
        this.af = u.ah + hashCode();
        this.ag = 0;
        this.ah = 0;
        this.an = com.alipay.sdk.data.a.f4564a;
        this.f32782ar = new int[2];
        this.as = false;
        this.at = false;
        this.av = false;
        this.aw = false;
        this.ax = false;
        this.ay = false;
        this.az = false;
        this.aA = false;
        this.aB = false;
        this.aC = false;
        this.aE = false;
        this.aF = false;
        this.aH = true;
        this.aJ = true;
        this.aK = true;
        this.aL = false;
        this.aM = false;
        this.aN = 0;
        this.aO = "skip_btn_delay_id_" + hashCode();
        this.bi = false;
        this.bj = new ha() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.20
            @Override // com.huawei.hms.ads.ha
            public void Code() {
                gl.Code("PPSLinkedView", "onVideoRenderStart, alreadyNotified: %s", Boolean.valueOf(PPSLinkedView.this.aL));
                if (PPSLinkedView.this.aL) {
                    return;
                }
                PPSLinkedView.this.aL = true;
                PPSLinkedView.this.v();
            }
        };
        this.bk = new gy() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.21
            @Override // com.huawei.hms.ads.gy
            public void Code(int i102, int i11) {
                if (i11 > 0 && !PPSLinkedView.this.aL) {
                    gl.Code("PPSLinkedView", "onProgress onRenderStart, playtime: %s", Integer.valueOf(i11));
                    PPSLinkedView.this.aL = true;
                    PPSLinkedView.this.v();
                }
                if (i11 > 0) {
                    PPSLinkedView.this.f32800o.Code(i11);
                    PPSLinkedView.this.setPlaying(true);
                }
                if (PPSLinkedView.this.f32805t != null) {
                    PPSLinkedView.this.f32805t.Code(i102, i11);
                }
                if (PPSLinkedView.this.W) {
                    PPSLinkedView.this.f32788c.Code(i102);
                }
                if (PPSLinkedView.this.f32801p != null) {
                    PPSLinkedView.this.f32801p.Code(PPSLinkedView.this.f32791f, i11, PPSLinkedView.this.f32800o == null ? 0L : PPSLinkedView.this.f32800o.I());
                }
            }

            @Override // com.huawei.hms.ads.gy
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i102) {
                gl.V("PPSLinkedView", "onMediaStart: %s", Integer.valueOf(i102));
                PPSLinkedView.this.W = true;
                PPSLinkedView.this.setPlaying(true);
                PPSLinkedView.this.f32779ac = i102;
                PPSLinkedView.this.f32777aa = System.currentTimeMillis();
                if (!PPSLinkedView.this.bi) {
                    PPSLinkedView.this.f32801p.Code(au.Code(Long.valueOf(PPSLinkedView.this.f32777aa)));
                    PPSLinkedView.this.f32801p.Code(PPSLinkedView.this.f32777aa);
                }
                if (PPSLinkedView.this.f32798m != null) {
                    PPSLinkedView.this.f32798m.Code(PPSLinkedView.this.f32777aa);
                }
                if (i102 > 0) {
                    PPSLinkedView.this.f32801p.S();
                    PPSLinkedView.this.f32788c.f();
                } else {
                    PPSLinkedView.this.f32801p.C();
                    if (PPSLinkedView.this.f32788c != null && PPSLinkedView.this.f32800o != null) {
                        gl.V("PPSLinkedView", "om start");
                        PPSLinkedView.this.f32788c.Code(PPSLinkedView.this.f32800o.I(), true ^ "y".equals(PPSLinkedView.this.f32800o.a()));
                    }
                }
                if (PPSLinkedView.this.f32797l != null && PPSLinkedView.this.f32797l.I()) {
                    eo.Code(PPSLinkedView.this.f32791f, PPSLinkedView.this.f32797l.m(), PPSLinkedView.this.f32797l.D(), (System.currentTimeMillis() - PPSLinkedView.this.f32792g.Q().longValue()) - PPSLinkedView.this.f32792g.R(), PPSLinkedView.this.f32797l.l(), "84");
                }
                if (PPSLinkedView.this.f32805t != null) {
                    PPSLinkedView.this.f32805t.Code(i102);
                }
            }

            @Override // com.huawei.hms.ads.gy
            public void I(com.huawei.openalliance.ad.media.b bVar, int i102) {
                gl.V("PPSLinkedView", "onMediaStop: %s", Integer.valueOf(i102));
                PPSLinkedView.this.Code(i102, false);
                if (PPSLinkedView.this.f32805t != null) {
                    PPSLinkedView.this.f32805t.I(i102);
                }
            }

            @Override // com.huawei.hms.ads.gy
            public void V(com.huawei.openalliance.ad.media.b bVar, int i102) {
                gl.V("PPSLinkedView", "onMediaPause: %s", Integer.valueOf(i102));
                PPSLinkedView.this.Code(i102, false);
                if (PPSLinkedView.this.f32805t != null) {
                    PPSLinkedView.this.f32805t.V(i102);
                }
            }

            @Override // com.huawei.hms.ads.gy
            public void Z(com.huawei.openalliance.ad.media.b bVar, int i102) {
                gl.V("PPSLinkedView", "onMediaCompletion: %s", Integer.valueOf(i102));
                PPSLinkedView.this.Code(i102, true);
                PPSLinkedView.this.bi = true;
                if (PPSLinkedView.this.am == 2 && PPSLinkedView.this.f32796k != null && PPSLinkedView.this.f32796k.F()) {
                    gl.V("PPSLinkedView", "onMediaCompletion, start play");
                    PPSLinkedView.this.H.V();
                    PPSLinkedView.this.setPlaying(true);
                }
                if (PPSLinkedView.this.f32805t != null) {
                    PPSLinkedView.this.f32805t.Z(i102);
                }
                if (PPSLinkedView.this.f32801p != null) {
                    long j10 = i102;
                    PPSLinkedView.this.f32801p.Code(PPSLinkedView.this.f32791f, j10, j10);
                }
            }
        };
        this.bl = new gw() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.2
            @Override // com.huawei.hms.ads.gw
            public void Code(int i102) {
                gl.V("PPSLinkedView", "onDurationReady:");
                if (!PPSLinkedView.this.aF && PPSLinkedView.this.f32804s != null) {
                    PPSLinkedView.this.aF = true;
                    PPSLinkedView.this.f32804s.Code();
                }
                if (PPSLinkedView.this.aI == null) {
                    PPSLinkedView.this.aI = Integer.valueOf(i102);
                    if (PPSLinkedView.this.f32797l == null || PPSLinkedView.this.f32797l.C() == null) {
                        return;
                    }
                    PPSLinkedView.this.f32797l.C().V(i102);
                }
            }

            @Override // com.huawei.hms.ads.gw
            public void V(int i102) {
            }
        };
        this.bm = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i102;
                if (PPSLinkedView.this.f32795j) {
                    if (PPSLinkedView.this.am == 1) {
                        PPSLinkedView pPSLinkedView = PPSLinkedView.this;
                        if (!pPSLinkedView.Code(pPSLinkedView.f32789d)) {
                            return;
                        }
                    }
                    PPSLinkedView.this.f32795j = false;
                    gl.V("PPSLinkedView", "onClick");
                    if (PPSLinkedView.this.am == 2) {
                        i102 = 10;
                    } else {
                        i102 = 2 == PPSLinkedView.this.aP.getMode() ? 17 : 9;
                        PPSLinkedView.this.l();
                    }
                    PPSLinkedView.this.V(i102);
                    ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PPSLinkedView.this.f32795j = true;
                        }
                    }, 500L);
                }
            }
        };
        this.bn = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.4
            private float I;
            private float V;

            private boolean Code(float f10, float f11) {
                if (PPSLinkedView.this.bf != 0 || f11 < PPSLinkedView.this.f32784bb) {
                    return 1 == PPSLinkedView.this.bf && Math.sqrt((double) ((f10 * f10) + (f11 * f11))) >= ((double) PPSLinkedView.this.f32784bb);
                }
                return true;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.V = motionEvent.getX();
                    this.I = motionEvent.getY();
                    if (gl.Code()) {
                        gl.Code("PPSLinkedView", "startX = %s, startY = %s", Float.valueOf(this.V), Float.valueOf(this.I));
                    }
                    PPSLinkedView.this.f32789d = lf.Code(view, motionEvent);
                }
                if (2 == motionEvent.getAction()) {
                    float x10 = motionEvent.getX();
                    float y10 = motionEvent.getY();
                    if (gl.Code()) {
                        gl.Code("PPSLinkedView", "endX = %s, endY = %s, startX - endX = %s, startY-endY = %s", Float.valueOf(x10), Float.valueOf(y10), Float.valueOf(this.V - x10), Float.valueOf(this.I - y10));
                    }
                    if (Code(this.V - x10, this.I - y10)) {
                        PPSLinkedView.this.f32807v.setOnTouchListener(null);
                        PPSLinkedView.this.V(18);
                    }
                }
                return true;
            }
        };
        this.bp = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.setEnabled(false);
                PPSLinkedView.this.f32807v.setOnTouchListener(null);
                if (motionEvent.getAction() != 0) {
                    return true;
                }
                PPSLinkedView.this.f32789d = com.huawei.openalliance.ad.utils.i.Code(view, motionEvent);
                PPSLinkedView.this.V(17);
                return true;
            }
        };
        this.bq = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                PPSLinkedView.this.f32789d = lf.Code(view, motionEvent);
                return false;
            }
        };
        this.br = new gv() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.8
            @Override // com.huawei.hms.ads.gv
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i102, int i11, int i12) {
                gl.I("PPSLinkedView", "media play error, isMoved: %s", Boolean.valueOf(PPSLinkedView.this.as));
                PPSLinkedView.this.z();
                PPSLinkedView.this.A();
                PPSLinkedView.this.setPlaying(false);
                if (PPSLinkedView.this.f32805t != null) {
                    gl.V("PPSLinkedView", "call onMediaError. ");
                    PPSLinkedView.this.f32805t.Code(i102, i11, i12);
                }
            }
        };
        this.bs = new gz() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.9
            @Override // com.huawei.hms.ads.gz
            public void Code() {
                gl.V("PPSLinkedView", "onMute");
                if (PPSLinkedView.this.f32806u != null) {
                    PPSLinkedView.this.f32806u.Code();
                }
                PPSLinkedView.this.f32788c.V(0.0f);
            }

            @Override // com.huawei.hms.ads.gz
            public void V() {
                gl.V("PPSLinkedView", "onUnmute");
                if (PPSLinkedView.this.f32806u != null) {
                    PPSLinkedView.this.f32806u.V();
                }
                PPSLinkedView.this.f32788c.V(1.0f);
            }
        };
        this.bt = new gu() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.10
            @Override // com.huawei.hms.ads.gu
            public void Code() {
                PPSLinkedView.this.f32788c.b();
            }

            @Override // com.huawei.hms.ads.gu
            public void Code(int i102) {
            }

            @Override // com.huawei.hms.ads.gu
            public void V() {
                PPSLinkedView.this.f32788c.c();
            }
        };
        this.bu = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PPSLinkedView.this.V(!view.isSelected());
            }
        };
        V(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        gl.V("PPSLinkedView", "reportDisplayError, adMediator: %s, linkedAdListener: %s", au.V(this.f32798m), au.V(this.au));
        boolean z10 = this.aM;
        if (!z10 && this.f32798m != null) {
            gl.V("PPSLinkedView", "report display error. ");
            this.aM = true;
            this.f32798m.I(-3);
            this.f32798m.l();
            return;
        }
        if (z10) {
            return;
        }
        gl.V("PPSLinkedView", "report fail to display. ");
        this.aM = true;
        I(-3);
    }

    private String B(InteractCfg interactCfg) {
        if (interactCfg != null) {
            return interactCfg.D();
        }
        return null;
    }

    private String C(InteractCfg interactCfg) {
        if (interactCfg != null) {
            return interactCfg.L();
        }
        return null;
    }

    private Integer Code(Integer num, int i10) {
        gl.V("PPSLinkedView", "initial mode: %s", num);
        if (i10 == 0) {
            return null;
        }
        int w3 = num == null ? this.f32792g.w() : num.intValue();
        if (w3 == 0) {
            return Integer.valueOf(w3);
        }
        Map<String, String> Code = z.Code(fr.Code(getContext()).ah());
        if (Code != null) {
            if ((2 == w3 || 3 == w3) && Code(au.I(Code.get(u.f32369cn)))) {
                w3 = 4;
            }
            if ((1 == w3 || 4 == w3) && Code(au.I(Code.get("swipe")))) {
                return 0;
            }
        }
        if (1 == getResources().getConfiguration().orientation && 2 == i10) {
            if ((2 != w3 && 3 != w3) || (this.f32792g.f() && (!this.f32792g.f() || com.huawei.openalliance.ad.utils.l.Z(getContext().getApplicationContext())))) {
                return Integer.valueOf(w3);
            }
            gl.V("PPSLinkedView", "can't use twist, enable : %s", Boolean.valueOf(this.f32792g.f()));
        }
        return 0;
    }

    private String Code(InteractCfg interactCfg) {
        return (interactCfg == null || interactCfg.a() == null) ? this.f32792g.z() : interactCfg.a();
    }

    private void Code(int i10) {
        int i11;
        if (i10 == 1) {
            i11 = 8;
        } else if (i10 != 2) {
            return;
        } else {
            i11 = 9;
        }
        Code(Integer.valueOf(i11), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(int i10, boolean z10) {
        v vVar = this.f32800o;
        if (vVar != null) {
            vVar.Code(z10 ? 0 : i10);
        }
        if (this.W) {
            this.W = false;
            ki kiVar = this.f32801p;
            long j10 = this.f32777aa;
            long currentTimeMillis = System.currentTimeMillis();
            long j11 = this.f32779ac;
            long j12 = i10;
            if (z10) {
                kiVar.Code(j10, currentTimeMillis, j11, j12);
                this.f32788c.a();
            } else {
                kiVar.V(j10, currentTimeMillis, j11, j12);
                this.f32788c.e();
            }
        }
        setPlaying(false);
    }

    private void Code(AdContentData adContentData) {
        if (adContentData.av() == null) {
            this.f32784bb = fr.Code(getContext()).A();
            this.f32786bd = fr.Code(getContext()).H();
            this.f32785bc = fr.Code(getContext()).G();
        } else {
            InteractCfg av = adContentData.av();
            this.f32784bb = (av.V() == null || av.V().intValue() <= 0) ? fr.Code(getContext()).A() : av.V().intValue();
            this.f32786bd = (av.I() == null || av.I().intValue() <= 0) ? fr.Code(getContext()).H() : av.I().intValue();
            this.f32785bc = (av.Z() == null || av.Z().intValue() <= 0) ? fr.Code(getContext()).G() : av.Z().intValue();
            this.bf = av.C().intValue();
        }
    }

    private void Code(AdContentData adContentData, int i10) {
        w();
        PPSSplashProView pPSSplashProView = this.aP;
        if (i10 == 0) {
            pPSSplashProView.setVisibility(4);
        } else {
            pPSSplashProView.setVisibility(0);
        }
        this.aP.setDesc(!TextUtils.isEmpty(this.f32792g.x()) ? this.f32792g.x() : adContentData.aq());
        this.aP.Code(false, i10);
        this.f32807v.setOnTouchListener(this.bq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(AdContentData adContentData, int[] iArr, int[] iArr2) {
        if (com.huawei.openalliance.ad.utils.v.Code(iArr, 2) && com.huawei.openalliance.ad.utils.v.Code(iArr2, 2) && adContentData != null) {
            if (gl.Code()) {
                gl.Code("PPSLinkedView", "addComplianceDialog, loc: %s, %s", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
                gl.Code("PPSLinkedView", "addComplianceDialog, size: %s, %s", Integer.valueOf(iArr2[0]), Integer.valueOf(iArr2[1]));
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            PPSAdvertiserInfoDialog pPSAdvertiserInfoDialog = new PPSAdvertiserInfoDialog(getContext(), iArr, iArr2);
            this.f32790e = pPSAdvertiserInfoDialog;
            this.f32807v.addView(pPSAdvertiserInfoDialog, layoutParams);
            this.f32790e.setScreenWidth(this.f32807v.getMeasuredWidth());
            this.f32790e.setScreenHeight(this.f32807v.getMeasuredHeight());
            this.f32790e.setAdContent(adContentData);
        }
    }

    private void Code(l lVar) {
        AdContentData ax;
        Integer I;
        if (this.aP == null || lVar == null || (ax = lVar.ax()) == null) {
            return;
        }
        int C = kt.C(ax.r());
        int S = kt.S(ax.r());
        gl.V("PPSLinkedView", "set splashpro mode:" + C);
        if (C == 0 || (I = I(ax)) == null) {
            this.aP.setVisibility(8);
        } else if (I.intValue() == 0) {
            Code(ax, S);
        } else {
            Code(ax);
            Code(false, I.intValue(), ax.av());
        }
        this.aP.setMode(C);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(Long l10, Integer num, Integer num2, boolean z10) {
        gl.Code("PPSLinkedView", "reportAdShowEvent. ");
        l lVar = this.f32797l;
        if (lVar == null || lVar.ap()) {
            return;
        }
        if (!this.f32792g.k()) {
            this.f32797l.B(true);
            this.f32801p.Code((Long) null, (Integer) null, num2, z10);
        } else if (z10 || l10.longValue() >= this.f32797l.r()) {
            this.f32797l.B(true);
            gl.Code("PPSLinkedView", "report imp. ");
            this.f32801p.Code(l10, num, num2, z10);
        }
        this.f32788c.D();
    }

    private void Code(boolean z10) {
        gl.V("PPSLinkedView", "moveLinkedView");
        if (o() && !this.as) {
            r();
            g gVar = this.f32802q;
            if (gVar != null) {
                gVar.Code(this.aG);
            }
            if (z10) {
                s();
            }
            this.as = true;
        }
    }

    private void Code(boolean z10, int i10, InteractCfg interactCfg) {
        PPSSplashSwipeClickView pPSSplashSwipeClickView;
        this.f32807v.setOnClickListener(null);
        if (1 == i10) {
            PPSSplashSwipeView pPSSplashSwipeView = this.aQ;
            if (pPSSplashSwipeView == null) {
                return;
            }
            pPSSplashSwipeView.setVisibility(0);
            this.aQ.Code(I(interactCfg), Code(interactCfg));
            this.aQ.setShowLogo(z10);
            this.f32807v.setOnTouchListener(this.bn);
            return;
        }
        if (2 == i10) {
            PPSSplashTwistView pPSSplashTwistView = this.aR;
            if (pPSSplashTwistView == null) {
                return;
            }
            pPSSplashTwistView.setVisibility(0);
            this.aR.Code(Z(interactCfg), V(interactCfg));
            this.aR.setShowLogo(z10);
            this.f32807v.setOnTouchListener(bo);
            x();
            return;
        }
        if (3 != i10) {
            if (4 != i10 || (pPSSplashSwipeClickView = this.bg) == null) {
                return;
            }
            pPSSplashSwipeClickView.setVisibility(0);
            this.bg.Code(B(interactCfg), Code(interactCfg));
            this.bg.setShowLogo(z10);
            this.f32807v.setOnTouchListener(this.bn);
            this.bg.getClickAreaView().setOnTouchListener(this.bp);
            return;
        }
        PPSSplashTwistClickView pPSSplashTwistClickView = this.bh;
        if (pPSSplashTwistClickView == null) {
            return;
        }
        pPSSplashTwistClickView.setVisibility(0);
        this.bh.Code(C(interactCfg), V(interactCfg));
        this.bh.setShowLogo(z10);
        this.f32807v.setOnTouchListener(bo);
        this.bh.getClickAreaView().setOnTouchListener(this.bp);
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Code(m mVar) {
        PPSSplashProView pPSSplashProView = this.aP;
        if (pPSSplashProView != null && mVar != null) {
            int mode = pPSSplashProView.getMode();
            if (gl.Code()) {
                gl.Code("PPSLinkedView", "splashpro mode:" + mode);
            }
            if (1 != mode && mode != 0) {
                Rect rect = new Rect();
                this.aP.getHitRect(rect);
                boolean contains = rect.contains(mVar.Code().intValue(), mVar.V().intValue());
                gl.V("PPSLinkedView", "check result:" + contains);
                return contains;
            }
        }
        return true;
    }

    private boolean Code(Long l10) {
        if (l10 == null) {
            return false;
        }
        long ag = fr.Code(getContext()).ag();
        return ag == -1 || System.currentTimeMillis() < (ag * 86400000) + l10.longValue();
    }

    private void E() {
        l lVar = this.f32797l;
        if (lVar != null) {
            lVar.S(false);
        }
        this.f32797l = null;
        this.E = null;
        this.O = null;
        this.T = null;
        LinkedSurfaceView linkedSurfaceView = this.f32809x;
        if (linkedSurfaceView != null) {
            linkedSurfaceView.Z();
        }
        TextureGlVideoView textureGlVideoView = this.f32810y;
        if (textureGlVideoView != null) {
            textureGlVideoView.destroyView();
        }
        com.huawei.openalliance.ad.views.d dVar = this.f32808w;
        if (dVar != null) {
            dVar.D();
        }
        setPlaying(false);
        J();
        ba.Code(this.aO);
        this.f32788c.I();
        com.huawei.openalliance.ad.inter.d.Code(this.f32791f).Code(false);
    }

    private Integer I(AdContentData adContentData) {
        return Code(Integer.valueOf(V(adContentData)), kt.C(adContentData.r()));
    }

    private String I(InteractCfg interactCfg) {
        if (interactCfg != null) {
            return interactCfg.S();
        }
        return null;
    }

    private void I(int i10) {
        k kVar = this.au;
        if (kVar != null) {
            kVar.Code(i10);
        }
        Z(i10);
    }

    private void J() {
        List<View> list = this.A;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (View view : this.A) {
            if (view != null) {
                view.setOnClickListener(null);
            }
        }
        setOnClickListener(null);
    }

    private void K() {
        if (this.M && this.K == null) {
            ImageView imageView = new ImageView(getContext());
            this.K = imageView;
            imageView.setImageResource(R.drawable.hiad_selector_ic_sound_check);
            ay.Code(this.K);
            Resources resources = getContext().getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.hiad_8_dp);
            this.K.setPadding(0, dimensionPixelSize, resources.getDimensionPixelSize(R.dimen.hiad_page_margin_side), dimensionPixelSize);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(21);
            int i10 = R.dimen.haid_splash_sound_margin_right;
            layoutParams.rightMargin = resources.getDimensionPixelSize(i10);
            int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.haid_splash_sound_margin_bottom);
            layoutParams.bottomMargin = dimensionPixelOffset;
            layoutParams.bottomMargin = dimensionPixelOffset + ay.I(getContext());
            layoutParams.setMarginEnd(resources.getDimensionPixelSize(i10));
            this.f32807v.addView(this.K, layoutParams);
            this.K.bringToFront();
            this.K.setSelected(false);
            this.K.setOnClickListener(this.bu);
        }
    }

    private boolean M() {
        return this.aE;
    }

    private void N() {
        if (this.J != null) {
            gl.Code("PPSLinkedView", "%d delay, skip btn show", Integer.valueOf(this.aN));
            if (this.aN > 0) {
                ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.14
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PPSLinkedView.this.J != null) {
                            gl.Code("PPSLinkedView", "skip btn show");
                            PPSLinkedView.this.J.setVisibility(0);
                        }
                    }
                }, this.aO, this.aN);
            } else {
                gl.Code("PPSLinkedView", "skip btn show");
                this.J.setVisibility(0);
            }
        }
    }

    private int V(AdContentData adContentData) {
        return (adContentData.av() == null || adContentData.av().Code() == null) ? this.f32792g.w() : adContentData.av().Code().intValue();
    }

    private String V(InteractCfg interactCfg) {
        return (interactCfg == null || interactCfg.a() == null) ? this.f32792g.E() : interactCfg.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(int i10) {
        e eVar;
        gf.Code(getContext()).Code(new b(this));
        Code(this.am);
        if (this.f32801p.Code(i10, this.f32789d)) {
            u();
            if (18 == i10) {
                Context context = this.f32787be.get();
                if (context instanceof Activity) {
                    ((Activity) context).overridePendingTransition(R.anim.hiad_open, R.anim.hiad_close);
                }
            }
        }
        this.f32789d = null;
        this.f32788c.Code(jk.CLICK);
        int i11 = this.am;
        int i12 = 1;
        if (i11 == 1) {
            this.aG = 3;
            eVar = this.f32803r;
            if (eVar == null) {
                return;
            }
        } else {
            i12 = 2;
            if (i11 != 2) {
                return;
            }
            this.aG = 4;
            eVar = this.f32803r;
            if (eVar == null) {
                return;
            }
        }
        eVar.Code(i12);
    }

    private void V(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f32791f = applicationContext;
        this.f32792g = fr.Code(applicationContext);
        this.f32801p = new jw(this.f32791f, this);
        this.G = (WindowManager) context.getSystemService("window");
        this.aK = ea.Code(this.f32791f).V();
    }

    private void V(l lVar) {
        gl.V("PPSLinkedView", "LinkedSplashAd:%s, isChinaRom:%s", lVar, Boolean.valueOf(this.aK));
        if (lVar != null) {
            Integer I = I(lVar.ax());
            InteractCfg av = lVar.ax().av();
            Integer B = av == null ? null : av.B();
            if (this.aK) {
                this.f32794i.Code(I, B);
                this.f32794i.setVisibility(0);
                this.f32794i.Code(lVar.ax(), false, this.ag, 1, false);
                return;
            }
            this.f32793h.setPpsLinkedView(this);
            this.f32793h.Code(I, B);
            this.f32793h.setVisibility(0);
            this.f32793h.Code(lVar.ax(), false, this.ag, 1, false);
            if (aa.Code(lVar.aA())) {
                return;
            }
            this.f32793h.setChoiceViewOnClickListener(new a(this, lVar.ax()));
        }
    }

    private void V(List<View> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (View view : list) {
            if (view != null) {
                view.setOnClickListener(this.bm);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(boolean z10) {
        com.huawei.openalliance.ad.media.b bVar;
        v vVar;
        String str;
        gl.V("PPSLinkedView", "switchSound enableSound: " + z10);
        if (this.f32809x == null || (bVar = this.H) == null) {
            return;
        }
        if (z10) {
            bVar.L();
            this.K.setSelected(true);
            vVar = this.f32800o;
            if (vVar != null) {
                str = "y";
                vVar.Code(str);
            }
            this.f32801p.Code(!z10);
        }
        bVar.D();
        this.K.setSelected(false);
        vVar = this.f32800o;
        if (vVar != null) {
            str = "n";
            vVar.Code(str);
        }
        this.f32801p.Code(!z10);
    }

    private String Z(InteractCfg interactCfg) {
        if (interactCfg != null) {
            return interactCfg.F();
        }
        return null;
    }

    private void Z(int i10) {
        String str;
        String str2;
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        l lVar = this.f32797l;
        if (lVar != null) {
            str = lVar.h_();
            str2 = this.f32797l.m();
            AdContentData adContentData = new AdContentData();
            adContentData.Z(this.f32797l.D());
            adContentData.F(this.f32797l.h_());
            analysisEventReport.Code(adContentData);
        } else {
            str = null;
            str2 = null;
        }
        analysisEventReport.Code(i10);
        analysisEventReport.I(str);
        analysisEventReport.Z(str2);
        com.huawei.openalliance.ad.ipc.g.V(this.f32791f).Code("rptSplashFailedEvt", z.V(analysisEventReport), null, null);
    }

    public static /* synthetic */ int ae(PPSLinkedView pPSLinkedView) {
        int i10 = pPSLinkedView.f32783ba;
        pPSLinkedView.f32783ba = i10 + 1;
        return i10;
    }

    private void h() {
        gl.V("PPSLinkedView", "reportAdShowStartEvent");
        long j10 = this.f32777aa;
        if (j10 <= 0) {
            j10 = com.huawei.openalliance.ad.utils.v.Code();
        }
        this.f32781ae = false;
        String valueOf = String.valueOf(j10);
        l lVar = this.f32797l;
        if (lVar == null) {
            gl.I("PPSLinkedView", "linkedSplashAd is null! please register first");
            return;
        }
        lVar.m(valueOf);
        this.f32797l.Code(j10);
        this.f32797l.B(false);
        this.f32797l.S(true);
        if (!this.f32797l.ak()) {
            this.f32797l.Z(true);
        }
        this.f32801p.Code(valueOf);
        this.f32801p.Code(j10);
        gl.Code("PPSLinkedView", "report showStart. ");
        this.f32801p.V();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        gl.V("PPSLinkedView", "calculateScaleAndTrans");
        m();
        if (this.ai <= 0.0f || this.aj <= 0.0f) {
            gl.I("PPSLinkedView", "calculateScaleAndTrans, get screen size failed. ");
            A();
            D();
            return;
        }
        boolean F2 = ay.F(this.f32791f);
        gl.V("PPSLinkedView", "calculateScaleAndTrans, MultiWindow:%s, screenHeight:%s,  screenWidth:%s", Boolean.valueOf(F2), Float.valueOf(this.ai), Float.valueOf(this.aj));
        this.f32811z.getLocationOnScreen(this.f32782ar);
        this.ak = this.f32811z.getHeight();
        this.al = this.f32811z.getWidth();
        gl.V("PPSLinkedView", "calculateScaleAndTrans, destViewHeight:%s, destViewWidth:%s, locationX:%s, locationY:%s", Integer.valueOf(this.ak), Integer.valueOf(this.al), Integer.valueOf(this.f32782ar[0]), Integer.valueOf(this.f32782ar[1]));
        Point point = new Point();
        this.G.getDefaultDisplay().getRealSize(point);
        gl.Code("PPSLinkedView", "calculateScaleAndTrans, screenHeight:%s, point.y:%s", Float.valueOf(this.ai), Integer.valueOf(point.y));
        if (this.ag <= 0 && ea.Code(this.f32791f).Code(this.f32791f)) {
            this.ag = Math.max(this.ag, ea.Code(this.f32791f).Code(this));
        }
        if ((point.y - this.ag) - this.ai > ay.C(this.f32791f)) {
            this.ah = ay.S(getContext());
        } else {
            this.ah = 0;
        }
        gl.V("PPSLinkedView", "calculateScaleAndTrans, NotchEnable: %s, scrennHeight:%s, screenWidth:%s, navigationBarHeight:%s, notchHeight:%s", Boolean.valueOf(ea.Code(this.f32791f).Code(this.f32791f)), Float.valueOf(this.ai), Float.valueOf(this.aj), Integer.valueOf(this.ah), Integer.valueOf(this.ag));
        if (ea.Code(this.f32791f).Code(this.f32791f)) {
            int i10 = this.ak;
            if (F2) {
                f13 = this.ai;
                int i11 = this.ag;
                this.ao = (i10 * 1.0f) / (i11 + f13);
                f12 = this.f32782ar[1] + ((i10 * 1.0f) / 2.0f);
                f14 = i11;
            } else {
                float f15 = this.ai;
                int i12 = this.ag;
                int i13 = this.ah;
                this.ao = (i10 * 1.0f) / ((i12 + f15) + i13);
                f12 = this.f32782ar[1] + ((i10 * 1.0f) / 2.0f);
                f13 = f15 + i12;
                f14 = i13;
            }
            f11 = f12 - (((f13 + f14) * 1.0f) / 2.0f);
        } else {
            int i14 = this.ak;
            if (F2) {
                float f16 = this.ai;
                this.ao = (i14 * 1.0f) / f16;
                f10 = (this.f32782ar[1] + ((i14 * 1.0f) / 2.0f)) - ((f16 * 1.0f) / 2.0f);
            } else {
                int i15 = this.ah;
                float f17 = this.ai;
                this.ao = (i14 * 1.0f) / (i15 + f17);
                f10 = (this.f32782ar[1] + ((i14 * 1.0f) / 2.0f)) - (((f17 + i15) * 1.0f) / 2.0f);
            }
            f11 = f10 - this.ag;
        }
        this.ap = f11;
        this.aq = ((this.al * 1.0f) / this.aj) * 1.0f;
    }

    private void m() {
        DisplayMetrics displayMetrics = this.f32791f.getResources().getDisplayMetrics();
        this.ai = displayMetrics.heightPixels;
        this.aj = displayMetrics.widthPixels;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        gl.V("PPSLinkedView", "switchViewOnAnimationEnd. ");
        Code(this.aJ);
        if (gl.Code()) {
            gl.Code("PPSLinkedView", "isMoved: %s, linkedAdListener on switch: %s ", Boolean.valueOf(this.as), this.au);
        }
        if (this.au == null) {
            gl.I("PPSLinkedView", "linkedAdListener is null. ");
        } else {
            gl.Code("PPSLinkedView", "splash show end. ");
            this.au.V();
        }
    }

    private boolean o() {
        boolean p10 = p();
        boolean q10 = q();
        if (!p10 && !q10) {
            return true;
        }
        gl.I("PPSLinkedView", "checkDestView, destView change null, linkedAdListener: %s, isMoved:%s. ", au.V(this.au), Boolean.valueOf(this.as));
        gl.V("PPSLinkedView", "isDestViewNull:%s, isDestViewNotAvalible:%s", Boolean.valueOf(p10), Boolean.valueOf(q10));
        if (!this.aM) {
            this.aM = true;
            I(-5);
            k kVar = this.au;
            if (kVar != null) {
                kVar.V();
            }
        }
        if (!this.as) {
            this.as = true;
            this.am = 0;
            TextureGlVideoView textureGlVideoView = this.f32810y;
            if (textureGlVideoView != null) {
                textureGlVideoView.L();
                this.f32810y.destroyView();
            }
            setPlaying(false);
            r();
            J();
            g gVar = this.f32802q;
            if (gVar != null) {
                gVar.Code(this.aG);
            }
        }
        return false;
    }

    private boolean p() {
        PPSDestView pPSDestView = this.f32811z;
        return pPSDestView == null || pPSDestView.getHeight() == 0 || this.f32811z.getWidth() == 0;
    }

    private boolean q() {
        TextureGlVideoView textureGlVideoView = this.f32810y;
        return textureGlVideoView == null || !textureGlVideoView.h();
    }

    private void r() {
        gl.V("PPSLinkedView", "removeSplashView");
        SplashLinkedVideoView splashLinkedVideoView = this.f32807v;
        if (splashLinkedVideoView != null) {
            splashLinkedVideoView.setVisibility(8);
            this.f32807v.V();
        }
        LinkedSurfaceView linkedSurfaceView = this.f32809x;
        if (linkedSurfaceView != null) {
            linkedSurfaceView.Z();
            com.huawei.openalliance.ad.views.d dVar = this.f32808w;
            if (dVar != null) {
                dVar.V(this.f32809x);
            }
            this.f32809x = null;
        }
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.17
            @Override // java.lang.Runnable
            public void run() {
                if (PPSLinkedView.this.f32807v != null) {
                    if (PPSLinkedView.this.f32807v.isAttachedToWindow()) {
                        PPSLinkedView.this.G.removeView(PPSLinkedView.this.f32807v);
                    }
                    PPSLinkedView.this.f32807v.I();
                    PPSLinkedView.this.f32807v = null;
                }
            }
        }, 20L);
        PPSSplashProView pPSSplashProView = this.aP;
        if (pPSSplashProView != null) {
            pPSSplashProView.Code();
        }
        PPSSplashSwipeView pPSSplashSwipeView = this.aQ;
        if (pPSSplashSwipeView != null) {
            pPSSplashSwipeView.V();
        }
        lb lbVar = this.aS;
        if (lbVar != null) {
            lbVar.V();
        }
        la laVar = this.aT;
        if (laVar != null) {
            laVar.V();
        }
    }

    private void s() {
        gl.V("PPSLinkedView", "addMonitor");
        hj hjVar = new hj(this, this);
        this.f32796k = hjVar;
        hjVar.D();
        l lVar = this.f32797l;
        if (lVar != null) {
            this.f32796k.V(lVar.r(), this.f32797l.s());
        }
        this.f32796k.Code(this.f32797l);
    }

    private void setDestViewClickable(PPSDestView pPSDestView) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(pPSDestView);
        V(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaying(boolean z10) {
        this.aE = z10;
    }

    private void setSkipBtnDelayTime(AdContentData adContentData) {
        if (adContentData == null || adContentData.am() <= 0) {
            return;
        }
        this.aN = adContentData.am();
    }

    private void setSplashViewClickable(SplashLinkedVideoView splashLinkedVideoView) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(splashLinkedVideoView);
        V(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        gl.V("PPSLinkedView", "startScaleDown. ");
        u();
        if (!o()) {
            if (this.at || this.f32778ab == -1) {
                return;
            }
            this.f32801p.Code(System.currentTimeMillis() - this.f32778ab, 100);
            this.f32778ab = -1L;
            return;
        }
        this.aC = true;
        l();
        this.f32807v.setClickable(false);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.aD = ofFloat;
        ofFloat.setInterpolator(new fs(0.4f, 0.0f, 0.2f, 1.0f));
        this.aD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.18
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    float animatedFraction = (valueAnimator.getAnimatedFraction() * (PPSLinkedView.this.ao - 1.0f)) + 1.0f;
                    float animatedFraction2 = (valueAnimator.getAnimatedFraction() * (PPSLinkedView.this.aq - 1.0f)) + 1.0f;
                    PPSLinkedView.this.f32809x.Code(animatedFraction, valueAnimator.getAnimatedFraction() * PPSLinkedView.this.ap, animatedFraction2, (int) (PPSLinkedView.this.aj * animatedFraction2), (int) (PPSLinkedView.this.ai * animatedFraction));
                } catch (Throwable th) {
                    gl.V("PPSLinkedView", "scaleAndTransAnimation err: %s", th.getClass().getSimpleName());
                }
            }
        });
        this.aD.addListener(new Animator.AnimatorListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.19
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LinkedSurfaceView linkedSurfaceView;
                float floatValue;
                float f10;
                int i10;
                int i11;
                gl.V("PPSLinkedView", "onAnimationEnd");
                try {
                    if (PPSLinkedView.this.ak > 0 && PPSLinkedView.this.f32800o != null) {
                        if (PPSLinkedView.this.f32800o.g().floatValue() < 1.0f) {
                            linkedSurfaceView = PPSLinkedView.this.f32809x;
                            floatValue = (PPSLinkedView.this.al * 1.0f) / (PPSLinkedView.this.ak * 1.0f);
                            f10 = (PPSLinkedView.this.al * 1.0f) / (PPSLinkedView.this.ak * 1.0f);
                            i10 = PPSLinkedView.this.al;
                            i11 = PPSLinkedView.this.ak;
                        } else {
                            linkedSurfaceView = PPSLinkedView.this.f32809x;
                            floatValue = PPSLinkedView.this.f32800o.g().floatValue();
                            f10 = (PPSLinkedView.this.al * 1.0f) / (PPSLinkedView.this.ak * 1.0f);
                            i10 = PPSLinkedView.this.al;
                            i11 = PPSLinkedView.this.ak;
                        }
                        linkedSurfaceView.Code(floatValue, f10, i10, i11);
                    }
                    PPSLinkedView.this.n();
                    PPSLinkedView.this.am = 2;
                } catch (Throwable th) {
                    gl.V("PPSLinkedView", "onAnimationEnd err: %s", th.getClass().getSimpleName());
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                gl.V("PPSLinkedView", "onAnimationStart");
                if (PPSLinkedView.this.f32790e != null) {
                    PPSLinkedView.this.f32790e.setVisibility(8);
                }
                if (PPSLinkedView.this.K != null) {
                    PPSLinkedView.this.K.setVisibility(8);
                }
                if (PPSLinkedView.this.J != null) {
                    PPSLinkedView.this.J.setVisibility(8);
                }
                if (PPSLinkedView.this.f32794i != null) {
                    PPSLinkedView.this.f32794i.setVisibility(8);
                }
                if (PPSLinkedView.this.f32793h != null) {
                    PPSLinkedView.this.f32793h.setVisibility(8);
                }
                if (PPSLinkedView.this.R != null) {
                    PPSLinkedView.this.R.setVisibility(8);
                }
                if (PPSLinkedView.this.aP != null) {
                    PPSLinkedView.this.aP.setVisibility(8);
                    PPSLinkedView.this.aP.Code();
                }
                if (PPSLinkedView.this.aQ != null) {
                    PPSLinkedView.this.aQ.setVisibility(8);
                    PPSLinkedView.this.aQ.V();
                }
                if (PPSLinkedView.this.aR != null) {
                    PPSLinkedView.this.aR.setVisibility(8);
                }
                if (PPSLinkedView.this.bh != null) {
                    PPSLinkedView.this.bh.setVisibility(8);
                }
                if (PPSLinkedView.this.bg != null) {
                    PPSLinkedView.this.bg.setVisibility(8);
                }
                if (PPSLinkedView.this.f32807v != null) {
                    PPSLinkedView.this.f32807v.setOnTouchListener(null);
                }
                if (PPSLinkedView.this.aS != null) {
                    PPSLinkedView.this.aS.V();
                }
                if (PPSLinkedView.this.aT != null) {
                    PPSLinkedView.this.aT.V();
                }
            }
        });
        this.aD.setDuration(1000L).start();
    }

    private void u() {
        h hVar = this.N;
        if (hVar != null) {
            hVar.cancel();
            this.N = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (!this.f32780ad) {
            this.f32780ad = true;
            l lVar = this.f32797l;
            if (lVar != null && lVar.I()) {
                com.huawei.openalliance.ad.ipc.d.Code(getContext()).Code("dismissSlogan", null, null, null);
            }
            this.f32778ab = System.currentTimeMillis();
            h();
            if (!this.f32792g.k()) {
                Code((Long) null, (Integer) null, (Integer) 8, false);
                this.at = true;
            }
            if (this.am == 1) {
                N();
                K();
                V(this.f32797l);
                y();
                Code(this.f32797l);
            }
        }
        View view = this.O;
        if (view != null) {
            view.setVisibility(8);
            this.O = null;
        }
        if (this.E != null) {
            gl.Code("PPSLinkedView", "PPSSplashView is not null. ");
            this.E.setVisibility(8);
            this.E = null;
        }
        View view2 = this.T;
        if (view2 != null) {
            view2.setVisibility(8);
            this.T = null;
        }
    }

    private void w() {
        int y10 = this.f32792g.y();
        if (y10 > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aP.getLayoutParams();
            int V = com.huawei.openalliance.ad.utils.v.V(getContext(), y10);
            this.aP.setPadding(V, V, V, V);
            if (layoutParams.isMarginRelative()) {
                layoutParams.setMarginStart(layoutParams.leftMargin - V);
                layoutParams.setMarginEnd(layoutParams.rightMargin - V);
            } else {
                layoutParams.setMargins(layoutParams.leftMargin - V, layoutParams.topMargin, layoutParams.rightMargin - V, layoutParams.bottomMargin);
            }
            this.aP.setLayoutParams(layoutParams);
        }
    }

    private void x() {
        lb lbVar = new lb(getContext());
        this.aS = lbVar;
        lbVar.Code(new d());
        this.aS.Code();
        la laVar = new la(getContext());
        this.aT = laVar;
        laVar.Code(new c());
        this.aT.Code();
    }

    private void y() {
        String str;
        try {
            if (this.R == null) {
                View inflate = this.Q.inflate();
                this.R = inflate;
                inflate.setId(R.id.hiad_full_logo_region);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.R.getLayoutParams();
            if (this.ag > 0) {
                gl.Code("PPSLinkedView", "left:%s, top:%s, right:%s", Integer.valueOf(layoutParams.leftMargin), Integer.valueOf(layoutParams.topMargin), Integer.valueOf(layoutParams.rightMargin));
                layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin + this.ag, layoutParams.rightMargin, layoutParams.bottomMargin);
                this.R.setLayoutParams(layoutParams);
            }
            ImageView imageView = (ImageView) this.R.findViewById(R.id.hiad_full_mode_logo);
            int i10 = this.P;
            if (i10 > 0) {
                imageView.setImageResource(i10);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            TextView textView = (TextView) this.R.findViewById(R.id.hiad_media_name);
            int i11 = this.U;
            if (i11 <= 0) {
                textView.setVisibility(8);
            } else {
                textView.setText(i11);
                textView.setVisibility(0);
            }
        } catch (Resources.NotFoundException unused) {
            str = "showFullModeLogo res not found";
            gl.I("PPSLinkedView", str);
        } catch (Exception e2) {
            str = "showFullModeLogo " + e2.getClass().getSimpleName();
            gl.I("PPSLinkedView", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        if (this.am != 1 || this.as) {
            return;
        }
        this.as = true;
        u();
        this.am = 0;
        TextureGlVideoView textureGlVideoView = this.f32810y;
        if (textureGlVideoView != null) {
            textureGlVideoView.L();
            this.f32810y.destroyView();
        }
        setPlaying(false);
        r();
        com.huawei.openalliance.ad.views.d dVar = this.f32808w;
        if (dVar != null) {
            dVar.D();
        }
        this.E = null;
        this.O = null;
        this.T = null;
        J();
        PPSSplashProView pPSSplashProView = this.aP;
        if (pPSSplashProView != null) {
            pPSSplashProView.Code();
        }
        if (this.at || !this.W) {
            return;
        }
        gl.Code("PPSLinkedView", "report imp and phyImp on splash. ");
        this.f32801p.Code(System.currentTimeMillis() - this.f32777aa, 100);
        Code((Integer) 8, false);
    }

    @Override // com.huawei.hms.ads.hj.a
    public void B() {
        gl.V("PPSLinkedView", "onViewShownBetweenFullAndPartial: ");
        if (this.f32810y == null || this.H == null) {
            return;
        }
        gl.V("PPSLinkedView", "onViewShownBetweenFullAndPartial, start mute");
        this.H.D();
        this.H.e();
        v vVar = this.f32800o;
        if (vVar != null) {
            vVar.Code("n");
        }
    }

    @Override // com.huawei.hms.ads.hj.a
    public void Code() {
        gl.V("PPSLinkedView", "onViewShowStartRecord");
        l lVar = this.f32797l;
        if (lVar == null || !this.as) {
            return;
        }
        gl.Code("PPSLinkedView", "ad.getMinEffectiveShowTime: %s. ", Long.valueOf(lVar.r()));
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.1
            @Override // java.lang.Runnable
            public void run() {
                PPSLinkedView pPSLinkedView;
                Long valueOf;
                Integer valueOf2;
                int i10;
                l lVar2 = PPSLinkedView.this.f32797l;
                if (lVar2 != null) {
                    if (PPSLinkedView.this.am == 2) {
                        pPSLinkedView = PPSLinkedView.this;
                        valueOf = Long.valueOf(lVar2.r());
                        valueOf2 = Integer.valueOf(PPSLinkedView.this.f32796k.B());
                        i10 = 9;
                    } else {
                        pPSLinkedView = PPSLinkedView.this;
                        valueOf = Long.valueOf(lVar2.r());
                        valueOf2 = Integer.valueOf(PPSLinkedView.this.f32796k.B());
                        i10 = 8;
                    }
                    pPSLinkedView.Code(valueOf, valueOf2, Integer.valueOf(i10), false);
                }
            }
        }, this.af, lVar.r());
    }

    @Override // com.huawei.hms.ads.hj.a
    public void Code(long j10, int i10) {
        gl.V("PPSLinkedView", "onViewShowEndRecord");
        ba.Code(this.af);
        if (!this.f32796k.Code(j10) || this.f32781ae) {
            return;
        }
        this.f32781ae = true;
        Code(Long.valueOf(j10), Integer.valueOf(i10), Integer.valueOf(this.am == 2 ? 9 : 8), false);
    }

    public void Code(Integer num, boolean z10) {
        gl.Code("PPSLinkedView", "reportSplashAdShowEvent. ");
        Code(Long.valueOf(System.currentTimeMillis() - this.f32777aa), (Integer) 100, num, z10);
    }

    public void D() {
        gl.V("PPSLinkedView", "unregister. ");
        E();
    }

    @Override // com.huawei.hms.ads.hj.a
    public void I() {
        v vVar;
        com.huawei.openalliance.ad.media.b bVar;
        long j10;
        gl.V("PPSLinkedView", "onViewFullShown: ");
        if (this.f32810y == null || (vVar = this.f32800o) == null || this.H == null) {
            return;
        }
        int L = vVar.L();
        if (M()) {
            return;
        }
        gl.V("PPSLinkedView", "onViewFullShown, start play, duration: %s, playProgress: %s", this.aI, Integer.valueOf(L));
        this.H.I(L);
        this.H.V();
        setPlaying(true);
        Integer num = this.aI;
        if (num == null || Math.abs(num.intValue() - L) >= 1000) {
            bVar = this.H;
            j10 = L;
        } else {
            gl.V("PPSLinkedView", "onViewFullShown, seek to 0");
            bVar = this.H;
            j10 = 0;
        }
        bVar.Code(j10, 3);
    }

    @Override // com.huawei.hms.ads.hj.a
    public void V() {
        l lVar;
        gl.V("PPSLinkedView", "onViewPhysicalShowStart");
        if (!this.as || (lVar = this.f32797l) == null || lVar.av()) {
            return;
        }
        h();
    }

    @Override // com.huawei.hms.ads.hj.a
    public void V(long j10, int i10) {
        gl.V("PPSLinkedView", "onViewPhysicalShowEnd: ");
        ba.Code(this.af);
        l lVar = this.f32797l;
        if (lVar != null) {
            lVar.S(false);
        }
        if (this.f32810y != null) {
            gl.V("PPSLinkedView", "onViewPhysicalShowEnd, start pause. ");
            this.H.Z();
            this.H.e();
            setPlaying(false);
        }
        gl.Code("PPSLinkedView", "onViewPhysicalShowEnd, noPhyImp: %s. ", Boolean.valueOf(this.at));
        if (this.at || i10 <= 0) {
            return;
        }
        gl.Code("PPSLinkedView", "report phyImp. ");
        if (this.f32778ab == -1) {
            this.f32801p.Code(j10, i10);
        } else {
            this.f32801p.Code(System.currentTimeMillis() - this.f32778ab, i10);
            this.f32778ab = -1L;
        }
    }

    @Override // com.huawei.hms.ads.hj.a
    public void Z() {
        gl.V("PPSLinkedView", "onViewPartialHidden: ");
        if (this.f32810y == null || this.H == null) {
            return;
        }
        gl.V("PPSLinkedView", "onViewPartialHidden, start pause");
        this.H.D();
        v vVar = this.f32800o;
        if (vVar != null) {
            vVar.Code("n");
        }
        this.H.Z();
        this.H.e();
        setPlaying(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            if (lf.Code(motionEvent) == 0) {
                this.f32789d = lf.Code(this, motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        } catch (Throwable th) {
            gl.I("PPSLinkedView", "dispatchTouchEvent exception : %s", th.getClass().getSimpleName());
            return false;
        }
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        int i10 = Build.VERSION.SDK_INT;
        gl.V("PPSLinkedView", "onApplyWindowInsets, sdk: %s", Integer.valueOf(i10));
        if (ay.V() && windowInsets != null) {
            DisplayCutout displayCutout = windowInsets.getDisplayCutout();
            if (displayCutout != null) {
                List<Rect> boundingRects = displayCutout.getBoundingRects();
                if (!aa.Code(boundingRects)) {
                    this.ag = boundingRects.get(0).height();
                }
            } else {
                gl.V("PPSLinkedView", "DisplayCutout is null");
            }
        }
        if (this.ag <= 0 && i10 >= 26 && ea.Code(this.f32791f).Code(getContext())) {
            this.ag = Math.max(this.ag, ea.Code(this.f32791f).Code(this));
        }
        gl.V("PPSLinkedView", "notchHeight:" + this.ag);
        return super.onApplyWindowInsets(windowInsets);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        gl.Code("PPSLinkedView", "onAttachedToWindow");
        hj hjVar = this.f32796k;
        if (hjVar != null) {
            hjVar.D();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        gl.Code("PPSLinkedView", "onDetechedFromWindow");
        hj hjVar = this.f32796k;
        if (hjVar != null) {
            hjVar.L();
        }
        ba.Code(this.aO);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        gl.Code("PPSLinkedView", "onVisibilityChanged:");
        hj hjVar = this.f32796k;
        if (hjVar != null) {
            hjVar.a();
        }
    }

    public void setLinkedAdActionListener(com.huawei.openalliance.ad.inter.listeners.a aVar) {
        gl.V("PPSLinkedView", "setLinkedAdActionListener. ");
        ki kiVar = this.f32801p;
        if (kiVar != null) {
            kiVar.Code(aVar);
        }
    }

    public void setMuteOnlyOnLostAudioFocus(boolean z10) {
        this.aH = z10;
    }

    public void setOnLinkedAdClickListener(e eVar) {
        this.f32803r = eVar;
    }

    public void setOnLinkedAdPreparedListener(f fVar) {
        this.f32804s = fVar;
    }

    public void setOnLinkedAdSwitchListener(g gVar) {
        this.f32802q = gVar;
    }
}
