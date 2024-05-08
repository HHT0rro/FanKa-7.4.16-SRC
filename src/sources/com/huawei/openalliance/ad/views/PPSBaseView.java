package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.fr;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.hg;
import com.huawei.hms.ads.hl;
import com.huawei.hms.ads.ic;
import com.huawei.hms.ads.io;
import com.huawei.hms.ads.jk;
import com.huawei.hms.ads.kk;
import com.huawei.hms.ads.kt;
import com.huawei.hms.ads.la;
import com.huawei.hms.ads.lq;
import com.huawei.openalliance.ad.beans.metadata.InteractCfg;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.m;
import com.huawei.openalliance.ad.utils.ba;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class PPSBaseView<P extends kk> extends RelativeLayout implements lq {
    public P B;
    public io C;
    public hg D;
    public int F;
    public AdContentData S;

    /* renamed from: a, reason: collision with root package name */
    private boolean f32749a;

    /* renamed from: b, reason: collision with root package name */
    private Long f32750b;

    /* renamed from: c, reason: collision with root package name */
    private View f32751c;

    /* renamed from: d, reason: collision with root package name */
    private la f32752d;

    /* renamed from: l, reason: collision with root package name */
    private int f32753l;

    /* renamed from: m, reason: collision with root package name */
    private int f32754m;

    /* renamed from: n, reason: collision with root package name */
    private int f32755n;

    /* renamed from: o, reason: collision with root package name */
    private int f32756o;

    /* renamed from: p, reason: collision with root package name */
    private m f32757p;

    /* renamed from: q, reason: collision with root package name */
    private hl f32758q;

    /* renamed from: r, reason: collision with root package name */
    private View.OnTouchListener f32759r;

    /* renamed from: s, reason: collision with root package name */
    private View.OnTouchListener f32760s;

    /* renamed from: t, reason: collision with root package name */
    private View.OnTouchListener f32761t;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a implements la.a {
        private a() {
        }

        @Override // com.huawei.hms.ads.la.a
        public void Code(float f10, float f11, float f12) {
            float sqrt = (float) Math.sqrt((f10 * f10) + (f11 * f11) + (f12 * f12));
            if (gl.Code()) {
                gl.Code("PPSBaseView", "accLimitNew: %s, xAcc: %s yAcc: %s zAcc: %s, sqrtAcc: %s", Integer.valueOf(PPSBaseView.this.f32755n), Float.valueOf(f10), Float.valueOf(f11), Float.valueOf(f12), Float.valueOf(sqrt));
            }
            if (PPSBaseView.this.f32750b == null || sqrt < PPSBaseView.this.f32755n) {
                return;
            }
            gl.V("PPSBaseView", "meet, accLimitNew: %s, sqrtAcc: %s", Integer.valueOf(PPSBaseView.this.f32755n), Float.valueOf(sqrt));
            PPSBaseView.this.f32752d.V();
            PPSBaseView pPSBaseView = PPSBaseView.this;
            pPSBaseView.B.Code(0, 0, pPSBaseView.S, pPSBaseView.f32750b, null, 19);
            PPSBaseView.this.C.Code(jk.CLICK);
        }
    }

    public PPSBaseView(Context context) {
        super(context);
        this.C = new ic();
        this.f32749a = false;
        this.f32750b = null;
        this.f32758q = new hl(this) { // from class: com.huawei.openalliance.ad.views.PPSBaseView.1
            @Override // com.huawei.hms.ads.hl
            public void Code() {
                hg hgVar = PPSBaseView.this.D;
                if (hgVar != null) {
                    hgVar.D();
                }
            }

            @Override // com.huawei.hms.ads.hl
            public void Code(long j10, int i10) {
                PPSBaseView.this.S();
                if (PPSBaseView.this.f32750b == null) {
                    gl.I("PPSBaseView", "onViewShowEnd - no adShowStartTime");
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis() - PPSBaseView.this.f32750b.longValue();
                PPSBaseView pPSBaseView = PPSBaseView.this;
                P p10 = pPSBaseView.B;
                if (p10 != null) {
                    p10.Code(pPSBaseView.S, currentTimeMillis, 100);
                    PPSBaseView.this.B.B();
                }
                PPSBaseView.this.f32750b = null;
                ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSBaseView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PPSBaseView.this.C.I();
                    }
                }, 150L);
            }
        };
        this.f32759r = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSBaseView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return PPSBaseView.this.Code(view, motionEvent);
            }
        };
        this.f32760s = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSBaseView.3
            private float I;
            private float V;

            private boolean Code(float f10, float f11) {
                if (PPSBaseView.this.f32756o != 0 || f11 < PPSBaseView.this.f32753l) {
                    return 1 == PPSBaseView.this.f32756o && Math.sqrt((double) ((f10 * f10) + (f11 * f11))) >= ((double) PPSBaseView.this.f32753l);
                }
                return true;
            }

            private boolean Code(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.V = motionEvent.getX();
                    this.I = motionEvent.getY();
                    if (gl.Code()) {
                        gl.Code("PPSBaseView", "startX = %s, startY = %s", Float.valueOf(this.V), Float.valueOf(this.I));
                    }
                    PPSBaseView pPSBaseView = PPSBaseView.this;
                    pPSBaseView.f32757p = com.huawei.openalliance.ad.utils.i.Code(pPSBaseView, motionEvent);
                }
                if (2 == motionEvent.getAction()) {
                    float x10 = motionEvent.getX();
                    float y10 = motionEvent.getY();
                    if (gl.Code()) {
                        gl.Code("PPSBaseView", " endX= %s, endY = %s, startX - endX= %s, startY - endY= %s", Float.valueOf(x10), Float.valueOf(y10), Float.valueOf(this.V - x10), Float.valueOf(this.I - y10));
                    }
                    if (Code(this.V - x10, this.I - y10)) {
                        PPSBaseView.this.setOnTouchListener(null);
                        PPSBaseView pPSBaseView2 = PPSBaseView.this;
                        pPSBaseView2.B.Code(0, 0, pPSBaseView2.S, pPSBaseView2.f32750b, PPSBaseView.this.f32757p, 18);
                        PPSBaseView.this.f32757p = null;
                        PPSBaseView.this.C.Code(jk.CLICK);
                    }
                }
                return true;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return Code(motionEvent);
            }
        };
        this.f32761t = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSBaseView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        };
        setOnTouchListener(this.f32759r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Code(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            setOnTouchListener(null);
            view.setEnabled(false);
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            if (gl.Code()) {
                gl.Code("PPSBaseView", "touch down image x=%f, y=%f", Float.valueOf(rawX), Float.valueOf(rawY));
            }
            this.B.Code((int) rawX, (int) rawY, this.S, this.f32750b, com.huawei.openalliance.ad.utils.i.Code(view, motionEvent), 2 == kt.C(this.S.r()) ? 17 : 7);
            this.C.Code(jk.CLICK);
        }
        return true;
    }

    private void L() {
        la laVar = new la(getContext());
        this.f32752d = laVar;
        laVar.Code(new a());
        this.f32752d.Code();
    }

    @Override // com.huawei.hms.ads.lq
    public void B() {
        this.D.S();
    }

    @Override // com.huawei.hms.ads.lq
    public boolean C() {
        return false;
    }

    public void Code() {
        this.D.l();
    }

    @Override // com.huawei.hms.ads.lq
    public void Code(int i10) {
        this.D.V(i10);
    }

    @Override // com.huawei.hms.ads.lq
    public void Code(int i10, int i11) {
        gl.V("PPSBaseView", "user click skip button");
        this.B.Code(i10, i11, this.f32750b);
        this.C.d();
        this.C.I();
    }

    @Override // com.huawei.hms.ads.lq
    public void Code(View view, Integer num) {
        this.f32751c = view;
        if (view != null) {
            view.setOnTouchListener(this.f32759r);
        }
        AdContentData adContentData = this.S;
        String r10 = adContentData == null ? null : adContentData.r();
        int C = kt.C(r10);
        if (gl.Code()) {
            gl.Code("PPSBaseView", "ctrlswitch:%s", r10);
            gl.Code("PPSBaseView", "splashpro mode:%s, splashInteractCfg: %s", Integer.valueOf(C), num);
        }
        if (C == 2) {
            setOnTouchListener(null);
            if (num == null) {
                return;
            }
            if (1 == num.intValue() || 4 == num.intValue()) {
                setOnTouchListener(this.f32760s);
                if (this.f32751c == null || 1 != num.intValue()) {
                    return;
                }
                this.f32751c.setOnTouchListener(null);
                return;
            }
            if (2 == num.intValue() || 3 == num.intValue()) {
                setOnTouchListener(this.f32761t);
                L();
                if (this.f32751c == null || 2 != num.intValue()) {
                    return;
                }
                this.f32751c.setOnTouchListener(null);
            }
        }
    }

    @Override // com.huawei.hms.ads.lq
    public void Code(io ioVar) {
        if (ioVar != null) {
            this.C = ioVar;
        }
    }

    @Override // com.huawei.hms.ads.lq
    public void D() {
        P p10 = this.B;
        if (p10 != null) {
            p10.V(this.f32750b);
        }
    }

    @Override // com.huawei.hms.ads.lq
    public void F() {
        P p10 = this.B;
        if (p10 != null) {
            p10.Code(this.f32750b);
        }
    }

    @Override // com.huawei.hms.ads.lq
    public void I(int i10) {
        this.D.C(i10);
    }

    public void S() {
    }

    @Override // com.huawei.hms.ads.lq
    public void V() {
        gl.V("PPSBaseView", "show ad");
        this.B.Code(this.S);
    }

    public void V(int i10) {
        this.D.I(i10);
    }

    @Override // com.huawei.hms.ads.lq
    public void Z() {
        gl.V("PPSBaseView", "notifyAdLoaded");
        this.f32749a = true;
        this.f32750b = Long.valueOf(System.currentTimeMillis());
        this.D.Code(this.S);
    }

    @Override // com.huawei.hms.ads.lz
    public void destroyView() {
        la laVar = this.f32752d;
        if (laVar != null) {
            laVar.V();
        }
    }

    @Override // com.huawei.hms.ads.lq
    public hg getAdMediator() {
        return this.D;
    }

    @Override // com.huawei.hms.ads.hy
    public View getOpenMeasureView() {
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        hl hlVar = this.f32758q;
        if (hlVar != null) {
            hlVar.D();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        gl.V("PPSBaseView", "detached from window");
        hl hlVar = this.f32758q;
        if (hlVar != null) {
            hlVar.L();
        }
        this.C.I();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        hl hlVar = this.f32758q;
        if (hlVar != null) {
            hlVar.a();
        }
    }

    @Override // com.huawei.hms.ads.lz
    public void pauseView() {
    }

    @Override // com.huawei.hms.ads.lz
    public void resumeView() {
    }

    @Override // com.huawei.hms.ads.lq
    public void setAdContent(AdContentData adContentData) {
        this.S = adContentData;
        if (adContentData.av() == null) {
            this.f32753l = fr.Code(getContext()).A();
            this.f32755n = fr.Code(getContext()).H();
            this.f32754m = fr.Code(getContext()).G();
        } else {
            InteractCfg av = adContentData.av();
            this.f32753l = (av.V() == null || av.V().intValue() <= 0) ? fr.Code(getContext()).A() : av.V().intValue();
            this.f32755n = (av.I() == null || av.I().intValue() <= 0) ? fr.Code(getContext()).H() : av.I().intValue();
            this.f32754m = (av.Z() == null || av.Z().intValue() <= 0) ? fr.Code(getContext()).G() : av.Z().intValue();
            this.f32756o = av.C().intValue();
        }
    }

    @Override // com.huawei.hms.ads.lq
    public void setAdMediator(hg hgVar) {
        this.D = hgVar;
    }

    @Override // com.huawei.hms.ads.lq
    public void setAudioFocusType(int i10) {
    }

    @Override // com.huawei.hms.ads.lq
    public void setDisplayDuration(int i10) {
        this.F = i10;
    }
}
