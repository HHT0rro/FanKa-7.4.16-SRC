package com.huawei.openalliance.ad.views;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.internal.os.PowerProfile;
import com.huawei.hms.ads.ff;
import com.huawei.hms.ads.fr;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.hc;
import com.huawei.hms.ads.hd;
import com.huawei.hms.ads.hg;
import com.huawei.hms.ads.jr;
import com.huawei.hms.ads.kd;
import com.huawei.hms.ads.kp;
import com.huawei.hms.ads.lo;
import com.huawei.hms.ads.lq;
import com.huawei.hms.ads.lz;
import com.huawei.hms.ads.mb;
import com.huawei.hms.ads.splash.R;
import com.huawei.openalliance.ad.beans.metadata.AdSource;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.ag;
import com.huawei.openalliance.ad.utils.au;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.v;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class SmartScreenSplashView extends RelativeLayout implements lo, lz {
    private AdSlotParam B;
    private com.huawei.openalliance.ad.inter.listeners.b C;
    public fr Code;
    private kp D;
    private com.huawei.openalliance.ad.inter.listeners.a F;
    private int I;
    private SloganView L;
    private hg S;

    /* renamed from: a, reason: collision with root package name */
    private View f32996a;

    /* renamed from: b, reason: collision with root package name */
    private View f32997b;

    /* renamed from: c, reason: collision with root package name */
    private lq f32998c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f32999d;

    /* renamed from: e, reason: collision with root package name */
    private PPSCircleProgressBar f33000e;

    /* renamed from: f, reason: collision with root package name */
    private PPSLabelView f33001f;

    /* renamed from: g, reason: collision with root package name */
    private TextView f33002g;

    /* renamed from: h, reason: collision with root package name */
    private int f33003h;

    /* renamed from: i, reason: collision with root package name */
    private RelativeLayout f33004i;

    /* renamed from: j, reason: collision with root package name */
    private RelativeLayout f33005j;

    /* renamed from: k, reason: collision with root package name */
    private long f33006k;

    /* renamed from: l, reason: collision with root package name */
    private int f33007l;

    /* renamed from: m, reason: collision with root package name */
    private final String f33008m;

    /* renamed from: n, reason: collision with root package name */
    private long f33009n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f33010o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f33011p;

    /* renamed from: q, reason: collision with root package name */
    private int f33012q;

    /* renamed from: r, reason: collision with root package name */
    private a f33013r;

    /* renamed from: s, reason: collision with root package name */
    private float f33014s;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a extends BroadcastReceiver {
        private WeakReference<lq> Code;

        public a(lq lqVar) {
            this.Code = new WeakReference<>(lqVar);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            lq lqVar;
            if (intent == null || !u.f32364ca.equals(intent.getAction()) || (lqVar = this.Code.get()) == null || !(lqVar instanceof PPSVideoView)) {
                return;
            }
            ((PPSVideoView) lqVar).L();
        }
    }

    public SmartScreenSplashView(Context context) {
        super(context);
        this.I = 0;
        this.f33003h = 0;
        this.f33007l = 0;
        this.f33008m = "skip_btn_delay_id_" + hashCode();
        this.f33010o = false;
        this.f33011p = false;
        this.f33012q = 1;
        this.f33014s = 0.18f;
        Code(context);
    }

    public SmartScreenSplashView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.I = 0;
        this.f33003h = 0;
        this.f33007l = 0;
        this.f33008m = "skip_btn_delay_id_" + hashCode();
        this.f33010o = false;
        this.f33011p = false;
        this.f33012q = 1;
        this.f33014s = 0.18f;
        Code(context);
    }

    public SmartScreenSplashView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.I = 0;
        this.f33003h = 0;
        this.f33007l = 0;
        this.f33008m = "skip_btn_delay_id_" + hashCode();
        this.f33010o = false;
        this.f33011p = false;
        this.f33012q = 1;
        this.f33014s = 0.18f;
        Code(context);
    }

    private void Code(Context context) {
        V(context);
        this.Code = fr.Code(context.getApplicationContext());
        this.D = new kd(context.getApplicationContext(), this);
        this.f33007l = this.Code.ab();
    }

    private void Code(lq lqVar) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(u.f32364ca);
        if (this.f33013r == null) {
            this.f33013r = new a(lqVar);
        }
        getContext().registerReceiver(this.f33013r, intentFilter);
    }

    private void S() {
        if (this.f32999d == null || this.f33000e == null) {
            return;
        }
        int i10 = this.f33007l;
        if (i10 > 0) {
            gl.V("SmartScreenSplashView", "%d delay, skip btn show", Integer.valueOf(i10));
            ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.SmartScreenSplashView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (SmartScreenSplashView.this.f32999d != null) {
                        gl.Code("SmartScreenSplashView", "skip hint show");
                        SmartScreenSplashView.this.f32999d.setVisibility(0);
                    }
                    if (SmartScreenSplashView.this.f33000e != null) {
                        gl.Code("SmartScreenSplashView", "coutDownView show");
                        SmartScreenSplashView.this.f33000e.setVisibility(0);
                    }
                    SmartScreenSplashView.this.f33011p = true;
                }
            }, this.f33008m, this.f33007l);
        } else {
            gl.V("SmartScreenSplashView", "direct show skip hint");
            this.f33011p = true;
            this.f32999d.setVisibility(0);
            this.f33000e.setVisibility(0);
        }
    }

    private void V(Context context) {
        RelativeLayout.inflate(context, v.e(context) ? R.layout.hiad_view_tv_splash_ad_elderly : R.layout.hiad_view_tv_splash_ad, this);
        this.f33004i = (RelativeLayout) findViewById(R.id.rl_splash_container);
        this.f33005j = (RelativeLayout) findViewById(R.id.hiad_logo_container);
        this.f32999d = (TextView) findViewById(R.id.hiad_skip_text);
        this.f33000e = (PPSCircleProgressBar) findViewById(R.id.hiad_count_progress);
        this.f33001f = (PPSLabelView) findViewById(R.id.hiad_ad_label);
        this.f33002g = (TextView) findViewById(R.id.hiad_ad_source);
        setFocusable(true);
    }

    private void V(AdContentData adContentData) {
        MetaData Z;
        if (adContentData == null) {
            return;
        }
        if (this.f33001f != null) {
            String n10 = adContentData.n();
            if (TextUtils.isEmpty(n10)) {
                this.f33001f.setVisibility(8);
            } else {
                MetaData Z2 = adContentData.Z();
                if (Z2 == null || AdSource.Code(Z2.i()) == null) {
                    this.f33001f.setText(n10);
                } else {
                    this.f33001f.V(AdSource.Code(Z2.i()), n10);
                }
                this.f33001f.setVisibility(0);
            }
        }
        if (this.f33002g == null || (Z = adContentData.Z()) == null) {
            return;
        }
        String V = au.V(Z.F());
        if (TextUtils.isEmpty(V)) {
            this.f33002g.setVisibility(8);
        } else {
            this.f33002g.setText(V);
            this.f33002g.setVisibility(0);
        }
    }

    private void setVisibleAndBringToFont(View view) {
        if (view != null) {
            view.setVisibility(0);
            view.bringToFront();
        }
    }

    @Override // com.huawei.hms.ads.lo
    public Integer Code(AdContentData adContentData) {
        return null;
    }

    @Override // com.huawei.hms.ads.lo
    public void Code(int i10) {
        hc Code = hd.Code(i10, this);
        this.S = Code;
        Code.Code(this.C);
        this.S.Code(this.F);
        this.S.Code(this.I);
        this.S.V(this.f33006k);
        this.S.k();
    }

    @Override // com.huawei.hms.ads.lo
    public void Code(int i10, int i11, String str, boolean z10, Integer num) {
    }

    @Override // com.huawei.hms.ads.lo
    public void Code(int i10, boolean z10) {
    }

    @Override // com.huawei.hms.ads.lo
    public void Code(View view) {
    }

    public void Code(View view, int i10) {
        this.f32997b = view;
        view.setVisibility(i10);
        this.f33003h = i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huawei.hms.ads.lo
    public void Code(lq lqVar, Integer num) {
        if (ay.D(getContext())) {
            gl.I("SmartScreenSplashView", "showAdView - activity finished, not add view");
            return;
        }
        if (lqVar == 0 || !(lqVar instanceof View)) {
            return;
        }
        View view = (View) lqVar;
        this.f32998c = lqVar;
        lqVar.setAudioFocusType(this.f33012q);
        Code(this.f32998c);
        ViewParent parent = view.getParent();
        if (parent == this.f33004i) {
            view.setVisibility(0);
            return;
        }
        if (parent != null && (parent instanceof ViewGroup)) {
            gl.V("SmartScreenSplashView", "showAdView, remove adView.");
            ((ViewGroup) parent).removeView(view);
        } else if (parent != null) {
            return;
        }
        setVisibleAndBringToFont(this.f33005j);
        setVisibleAndBringToFont(this.f32997b);
        this.f33004i.addView(view, new RelativeLayout.LayoutParams(-1, -1));
        view.setVisibility(0);
    }

    @Override // com.huawei.hms.ads.lo
    public void Code(mb mbVar) {
        View view = this.f32996a;
        if (view != null) {
            view.setVisibility(0);
            new jr(this.Code, mbVar).V();
            return;
        }
        SloganView sloganView = this.L;
        if (sloganView == null) {
            gl.V("SmartScreenSplashView", "create default slogan");
            setSloganResId(R.drawable.hiad_default_slogan);
            sloganView = this.L;
            if (sloganView == null) {
                return;
            }
        }
        sloganView.setSloganShowListener(mbVar);
        this.L.Code();
    }

    @Override // com.huawei.hms.ads.lo
    public void Code(AdContentData adContentData, int i10) {
        gl.Code("SmartScreenSplashView", "showLabelView and logo.");
        if (this.f32999d != null && this.f33000e != null) {
            if (adContentData != null && adContentData.Z() != null && adContentData.h() == 9) {
                long h10 = adContentData.Z().h();
                this.f33009n = h10;
                this.f33000e.Code(0, au.Code(Integer.valueOf((int) ((((float) h10) * 1.0f) / 1000.0f))));
            }
            S();
        }
        if (this.f33005j != null && this.f32997b != null) {
            gl.V("SmartScreenSplashView", "show logo, visibility: %s", Integer.valueOf(this.f33003h));
            this.f33005j.addView(this.f32997b);
            this.f32997b.setVisibility(this.f33003h);
        }
        V(adContentData);
    }

    @Override // com.huawei.hms.ads.lo
    public void I(int i10) {
        gl.Code("SmartScreenSplashView", "update left time, total: %s, left: %s", Long.valueOf(this.f33009n), Integer.valueOf(i10));
        long j10 = this.f33009n;
        int doubleValue = j10 > 0 ? (int) ((1.0d - ag.Code(Double.valueOf(((i10 - 1) * 1000) / j10), 2, 4).doubleValue()) * 100.0d) : 0;
        if (doubleValue >= 100) {
            doubleValue = 100;
        }
        PPSCircleProgressBar pPSCircleProgressBar = this.f33000e;
        if (pPSCircleProgressBar != null) {
            pPSCircleProgressBar.Code(doubleValue, au.Code(Integer.valueOf(i10)));
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
        PPSVideoView pPSVideoView = new PPSVideoView(getContext(), this.B.V(), 0, this.B.I(), 18);
        pPSVideoView.setHideSoundIcon(true);
        pPSVideoView.setIgnoreSoundCtrl(false);
        pPSVideoView.setStartVol(this.f33014s);
        return pPSVideoView;
    }

    @Override // com.huawei.hms.ads.lo
    public void V() {
        SloganView sloganView = this.L;
        if (sloganView != null) {
            sloganView.V();
        }
        View view = this.f32996a;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.huawei.hms.ads.lz
    public void destroyView() {
        gl.V("SmartScreenSplashView", "destroyView ");
        lq lqVar = this.f32998c;
        if (lqVar != null) {
            lqVar.destroyView();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        hg hgVar;
        gl.V("SmartScreenSplashView", "dispatchKeyEvent:" + keyEvent.getKeyCode() + ", " + keyEvent.getAction());
        if (this.f33011p && 4 == keyEvent.getKeyCode() && keyEvent.getAction() == 1 && (hgVar = this.S) != null) {
            hgVar.Code(0, 0);
        }
        return true;
    }

    public com.huawei.openalliance.ad.inter.listeners.b getAdListener() {
        return this.C;
    }

    @Override // com.huawei.hms.ads.lo
    public AdSlotParam getAdSlotParam() {
        AdSlotParam adSlotParam = this.B;
        if (adSlotParam != null) {
            adSlotParam.Code(18);
        }
        return this.B;
    }

    @Override // com.huawei.hms.ads.lo
    public int getAdType() {
        return 18;
    }

    @Override // com.huawei.hms.ads.lo
    public int getAudioFocusType() {
        return 0;
    }

    @Override // com.huawei.hms.ads.hy
    public View getOpenMeasureView() {
        return this;
    }

    public float getStartMaxVol() {
        return this.f33014s;
    }

    public String getUniqueId() {
        return null;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        hg hgVar;
        gl.V("SmartScreenSplashView", "onKeyDown, keyCode: %s", Integer.valueOf(keyEvent.getKeyCode()));
        if (this.f33011p && 4 == keyEvent.getKeyCode() && keyEvent.getAction() == 1 && (hgVar = this.S) != null) {
            hgVar.Code(0, 0);
        }
        return false;
    }

    @Override // com.huawei.hms.ads.lz
    public void pauseView() {
        gl.V("SmartScreenSplashView", "pauseView ");
        lq lqVar = this.f32998c;
        if (lqVar != null) {
            lqVar.pauseView();
        }
        if (getContext() != null) {
            try {
                if (this.f33013r != null) {
                    getContext().unregisterReceiver(this.f33013r);
                    this.f33013r = null;
                }
            } catch (Throwable th) {
                gl.I("SmartScreenSplashView", "unregister err: %s", th.getClass().getSimpleName());
            }
        }
    }

    @Override // com.huawei.hms.ads.lz
    public void resumeView() {
        gl.V("SmartScreenSplashView", "resumeView ");
        lq lqVar = this.f32998c;
        if (lqVar != null) {
            lqVar.resumeView();
        }
    }

    public void setAdActionListener(com.huawei.openalliance.ad.inter.listeners.a aVar) {
        this.F = aVar;
        hg hgVar = this.S;
        if (hgVar != null) {
            hgVar.Code(aVar);
        }
    }

    public void setAdListener(com.huawei.openalliance.ad.inter.listeners.b bVar) {
        this.C = bVar;
        this.D.Code(bVar);
        hg hgVar = this.S;
        if (hgVar != null) {
            hgVar.Code(bVar);
        }
    }

    public void setAdSlotParam(AdSlotParam adSlotParam) {
        if (v.Code(getContext())) {
            int B = com.huawei.openalliance.ad.utils.c.B(getContext(), adSlotParam.V());
            int C = com.huawei.openalliance.ad.utils.c.C(getContext(), adSlotParam.V());
            adSlotParam.Z(B);
            adSlotParam.B(C);
            adSlotParam.I(8);
            adSlotParam.L(Integer.valueOf(this.I));
            adSlotParam.Z((Integer) 0);
            adSlotParam.B(Integer.valueOf((HiAd.Code(getContext()).isNewProcess() && com.huawei.openalliance.ad.utils.c.L(getContext())) ? 0 : 1));
            this.B = adSlotParam;
            com.huawei.openalliance.ad.inter.h Code = com.huawei.openalliance.ad.inter.g.Code(getContext());
            if (Code instanceof com.huawei.openalliance.ad.inter.g) {
                ((com.huawei.openalliance.ad.inter.g) Code).I(adSlotParam);
            }
        }
    }

    public void setAudioFocusType(int i10) {
        this.f33012q = i10;
        lq lqVar = this.f32998c;
        if (lqVar != null) {
            lqVar.setAudioFocusType(i10);
        }
    }

    public void setLinkedSupportMode(int i10) {
        this.I = i10;
    }

    public void setLogo(View view) {
        Code(view, 0);
    }

    public void setSloganResId(int i10) {
        if (v.Code(getContext())) {
            if (ay.D(getContext())) {
                gl.I("SmartScreenSplashView", "setSloganResId - activity finished, not add view");
                return;
            }
            if (this.B == null) {
                throw new ff("Must invoke SplashAdView's setAdSlotParam method before invoke setSloganResId method");
            }
            if (this.L == null) {
                SloganView sloganView = new SloganView(getContext(), this.B.V(), i10, 18);
                this.L = sloganView;
                this.f33004i.addView(sloganView, new RelativeLayout.LayoutParams(-1, -1));
                this.L.V();
            }
        }
    }

    public void setSloganView(View view) {
        if (view != null) {
            this.f32996a = view;
            view.setVisibility(8);
        }
    }

    public void setStartMaxVol(float f10) {
        if (f10 >= 0.0f) {
            if (f10 <= 1.0f) {
                AudioManager audioManager = (AudioManager) getContext().getSystemService(PowerProfile.POWER_AUDIO);
                int streamMaxVolume = audioManager.getStreamMaxVolume(3);
                int streamVolume = audioManager.getStreamVolume(3);
                gl.V("SmartScreenSplashView", "music max %s, current %s， maxVol： %s", Integer.valueOf(streamMaxVolume), Integer.valueOf(streamVolume), Float.valueOf(f10));
                float f11 = streamVolume;
                float f12 = streamMaxVolume * 1.0f * f10;
                float floatValue = f11 * 1.0f >= f12 ? Float.valueOf(f12 / f11).floatValue() : 1.0f;
                if (gl.Code()) {
                    gl.Code("SmartScreenSplashView", "maxVol end: %s", Float.valueOf(floatValue));
                }
                this.f33014s = floatValue;
                return;
            }
        }
        gl.I("SmartScreenSplashView", "valid max vol is from 0.0 to 1.0");
    }
}
