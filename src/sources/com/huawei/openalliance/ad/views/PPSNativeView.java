package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.alimm.tanx.core.request.TanxError;
import com.huawei.hms.ads.AdFeedbackListener;
import com.huawei.hms.ads.ChoicesView;
import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.hms.ads.du;
import com.huawei.hms.ads.dynamic.ObjectWrapper;
import com.huawei.hms.ads.ea;
import com.huawei.hms.ads.ew;
import com.huawei.hms.ads.gf;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.hh;
import com.huawei.hms.ads.hi;
import com.huawei.hms.ads.hy;
import com.huawei.hms.ads.ic;
import com.huawei.hms.ads.io;
import com.huawei.hms.ads.iy;
import com.huawei.hms.ads.iz;
import com.huawei.hms.ads.jk;
import com.huawei.hms.ads.js;
import com.huawei.hms.ads.kf;
import com.huawei.hms.ads.ks;
import com.huawei.hms.ads.kt;
import com.huawei.hms.ads.lf;
import com.huawei.hms.ads.lg;
import com.huawei.hms.ads.lh;
import com.huawei.hms.ads.li;
import com.huawei.hms.ads.lm;
import com.huawei.hms.ads.ma;
import com.huawei.hms.ads.nativead.DislikeAdListener;
import com.huawei.hms.ads.nativead.R;
import com.huawei.hms.ads.uiengine.IRemoteCreator;
import com.huawei.hms.ads.uiengineloader.ai;
import com.huawei.hms.ads.whythisad.CusWhyThisAdView;
import com.huawei.openalliance.ad.activity.ComplianceActivity;
import com.huawei.openalliance.ad.activity.FeedbackActivity;
import com.huawei.openalliance.ad.constant.bf;
import com.huawei.openalliance.ad.constant.bg;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.openalliance.ad.download.app.k;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.m;
import com.huawei.openalliance.ad.inter.data.n;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.o;
import com.huawei.openalliance.ad.utils.v;
import com.huawei.openalliance.ad.utils.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PPSNativeView extends RelativeLayout implements hh, hy, lm {
    private kf B;
    private hi C;
    public io Code;
    private ChoicesView D;
    private View F;
    private boolean I;
    private int L;
    private n S;

    /* renamed from: a, reason: collision with root package name */
    private CusWhyThisAdView f32812a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f32813b;

    /* renamed from: c, reason: collision with root package name */
    private b f32814c;

    /* renamed from: d, reason: collision with root package name */
    private d f32815d;

    /* renamed from: e, reason: collision with root package name */
    private e f32816e;

    /* renamed from: f, reason: collision with root package name */
    private c f32817f;

    /* renamed from: g, reason: collision with root package name */
    private lh f32818g;

    /* renamed from: h, reason: collision with root package name */
    private li f32819h;

    /* renamed from: i, reason: collision with root package name */
    private lg f32820i;

    /* renamed from: j, reason: collision with root package name */
    private List<View> f32821j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f32822k;

    /* renamed from: l, reason: collision with root package name */
    private final String f32823l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f32824m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f32825n;

    /* renamed from: o, reason: collision with root package name */
    private DislikeAdListener f32826o;

    /* renamed from: p, reason: collision with root package name */
    private String f32827p;

    /* renamed from: q, reason: collision with root package name */
    private String f32828q;

    /* renamed from: r, reason: collision with root package name */
    private m f32829r;

    /* renamed from: s, reason: collision with root package name */
    private CusWhyThisAdView.a f32830s;

    /* renamed from: t, reason: collision with root package name */
    private iz f32831t;

    /* renamed from: u, reason: collision with root package name */
    private AdFeedbackListener f32832u;

    /* renamed from: v, reason: collision with root package name */
    private IRemoteCreator f32833v;

    /* renamed from: w, reason: collision with root package name */
    private du f32834w;

    /* renamed from: x, reason: collision with root package name */
    private View f32835x;

    /* renamed from: y, reason: collision with root package name */
    private ImageView f32836y;

    /* renamed from: z, reason: collision with root package name */
    private View.OnClickListener f32837z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements AdFeedbackListener {
        private final WeakReference<PPSNativeView> Code;

        public a(PPSNativeView pPSNativeView) {
            this.Code = new WeakReference<>(pPSNativeView);
        }

        @Override // com.huawei.hms.ads.AdFeedbackListener
        public void onAdDisliked() {
            PPSNativeView pPSNativeView = this.Code.get();
            if (pPSNativeView != null) {
                pPSNativeView.o();
            }
        }

        @Override // com.huawei.hms.ads.AdFeedbackListener
        public void onAdFeedbackShowFailed() {
        }

        @Override // com.huawei.hms.ads.AdFeedbackListener
        public void onAdLiked() {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface b {
        void Code(View view);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface c {
        void Code();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface d {
        void Code();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface e {
        void B();

        void I();

        void V();

        void Z();
    }

    public PPSNativeView(Context context) {
        super(context);
        this.I = true;
        this.Code = new ic();
        this.f32822k = false;
        this.f32823l = u.ah + hashCode();
        this.f32824m = false;
        this.f32830s = CusWhyThisAdView.a.NONE;
        this.f32837z = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PPSNativeView.this.Code(view, 7);
            }
        };
        Code(context);
    }

    public PPSNativeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.I = true;
        this.Code = new ic();
        this.f32822k = false;
        this.f32823l = u.ah + hashCode();
        this.f32824m = false;
        this.f32830s = CusWhyThisAdView.a.NONE;
        this.f32837z = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PPSNativeView.this.Code(view, 7);
            }
        };
        Code(context);
    }

    public PPSNativeView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.I = true;
        this.Code = new ic();
        this.f32822k = false;
        this.f32823l = u.ah + hashCode();
        this.f32824m = false;
        this.f32830s = CusWhyThisAdView.a.NONE;
        this.f32837z = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PPSNativeView.this.Code(view, 7);
            }
        };
        Code(context);
    }

    public PPSNativeView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.I = true;
        this.Code = new ic();
        this.f32822k = false;
        this.f32823l = u.ah + hashCode();
        this.f32824m = false;
        this.f32830s = CusWhyThisAdView.a.NONE;
        this.f32837z = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PPSNativeView.this.Code(view, 7);
            }
        };
    }

    private void Code(Context context) {
        this.B = new js(context, this);
        this.C = new hi(this, this);
        boolean V = ea.Code(context).V();
        this.f32813b = V;
        if (V) {
            return;
        }
        L();
    }

    private void Code(View view) {
        ViewGroup viewGroup;
        if (view == null || (viewGroup = (ViewGroup) view.getParent()) == null) {
            return;
        }
        viewGroup.removeView(view);
    }

    private void Code(io ioVar, n nVar) {
        lh lhVar = this.f32818g;
        if (lhVar instanceof NativeVideoView) {
            ((NativeVideoView) lhVar).Code(ioVar, nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(Long l10, Integer num, Integer num2, boolean z10) {
        n nVar = this.S;
        if (nVar == null || nVar.R()) {
            return;
        }
        e eVar = this.f32816e;
        if (eVar != null) {
            eVar.B();
        }
        io ioVar = this.Code;
        if (ioVar != null) {
            ioVar.D();
        }
        c cVar = this.f32817f;
        if (cVar != null) {
            cVar.Code();
        }
        this.S.Z(true);
        this.B.Code(l10, num, num2, z10);
    }

    private void L() {
        gl.Code("PPSNativeView", "initChoicesView start");
        if (this.D == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.hiad_choices_wrapper, (ViewGroup) null);
            this.F = inflate;
            this.D = (ChoicesView) inflate.findViewById(R.id.hiad_choices_icon);
            this.f32836y = (ImageView) this.F.findViewById(R.id.compliance_icon);
            addView(this.F);
            View view = this.F;
            if (view != null) {
                view.setVisibility(8);
            }
        }
        setChoiceViewPosition(1);
        this.D.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (PPSNativeView.this.Code() || PPSNativeView.this.S == null) {
                    return;
                }
                if (PPSNativeView.this.S.l() == null) {
                    gl.V("PPSNativeView", TanxError.ERROR_ADINFO_NULL);
                } else if (aa.Code(PPSNativeView.this.S.l().aG())) {
                    com.huawei.openalliance.ad.utils.c.Code(PPSNativeView.this.getContext(), PPSNativeView.this.S);
                } else {
                    ComplianceActivity.Code(PPSNativeView.this.getContext(), view2, PPSNativeView.this.S.l(), true);
                }
            }
        });
        this.f32836y.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (PPSNativeView.this.f32825n || PPSNativeView.this.S == null) {
                    return;
                }
                ComplianceActivity.Code(PPSNativeView.this.getContext(), view2, PPSNativeView.this.S.l(), false);
            }
        });
    }

    private void V(Context context) {
        gl.V("PPSNativeView", "showV3Ad");
        IRemoteCreator Code = com.huawei.hms.ads.f.Code(getContext().getApplicationContext());
        this.f32833v = Code;
        if (Code == null) {
            gl.V("PPSNativeView", "Creator is null");
            return;
        }
        this.f32834w = new du(context, this, this.S);
        String V = z.V(this.S.l());
        Bundle bundle = new Bundle();
        bundle.putBinder("context", (IBinder) ObjectWrapper.wrap(getContext()));
        bundle.putString("content", V);
        bundle.putInt(bg.e.Code, ai.f29435f);
        try {
            View view = (View) ObjectWrapper.unwrap(this.f32833v.newNativeTemplateView(bundle, this.f32834w));
            this.f32835x = view;
            if (view == null) {
                gl.I("PPSNativeView", "templateView is null");
                return;
            }
            this.Code = null;
            removeAllViews();
            addView(this.f32835x);
            this.f32833v.bindData(ObjectWrapper.wrap(this.f32835x), V);
        } catch (Throwable th) {
            gl.I("PPSNativeView", "create newNativeTemplateView err: %s", th.getClass().getSimpleName());
        }
    }

    private void V(View view) {
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        view.bringToFront();
    }

    private void V(View view, int i10) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                viewGroup.getChildAt(i11).setVisibility(i10);
            }
        }
    }

    private void V(List<View> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (View view : list) {
            if (view instanceof NativeVideoView) {
                ((NativeVideoView) view).setCoverClickListener(this.f32837z);
            } else if (view != null) {
                view.setOnClickListener(this.f32837z);
            }
        }
    }

    private void a() {
        gl.Code("PPSNativeView", "update choiceView start.");
        if (this.D == null) {
            gl.Code("PPSNativeView", "do not need update choiceView");
            return;
        }
        if (this.f32812a == null) {
            Z();
        }
        if (!this.f32825n && this.f32812a != null) {
            gl.Code("PPSNativeView", "cusWhyView is not null, set choiceView as close.");
            this.D.V();
        } else {
            if (TextUtils.isEmpty(this.f32827p)) {
                return;
            }
            gl.Code("PPSNativeView", "update choiceView.");
            if (TextUtils.isEmpty(this.f32828q)) {
                this.D.I();
            } else {
                this.D.setAdChoiceIcon(this.f32828q);
            }
        }
    }

    private boolean b() {
        if (this.S.ai() == null || 3 != this.S.ai().intValue()) {
            return false;
        }
        V(getContext().getApplicationContext());
        return true;
    }

    private boolean c() {
        n nVar;
        return (this.f32836y == null || this.f32825n || (nVar = this.S) == null || nVar.l() == null || aa.Code(this.S.l().aG())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        CusWhyThisAdView cusWhyThisAdView = this.f32812a;
        if (cusWhyThisAdView != null) {
            ViewGroup viewGroup = (ViewGroup) cusWhyThisAdView.getParent();
            if (viewGroup != null) {
                V(viewGroup, 4);
            }
            this.f32812a.setVisibility(0);
            setBackgroundColor(getResources().getColor(R.color.hiad_whythisad_root_bg));
        }
    }

    private void e() {
        Code(this.L);
        V(this.D);
        if (this.f32813b || !f()) {
            return;
        }
        setWhyAdViewStatus(CusWhyThisAdView.a.NONE);
        this.I = true;
        V(this, 0);
    }

    private boolean f() {
        return getWhyAdViewStatus() != CusWhyThisAdView.a.NONE && getWhyAdViewStatus() == CusWhyThisAdView.a.INIT;
    }

    private void g() {
        View view;
        IRemoteCreator iRemoteCreator = this.f32833v;
        if (iRemoteCreator != null && (view = this.f32835x) != null) {
            try {
                iRemoteCreator.destroyView(ObjectWrapper.wrap(view));
            } catch (Throwable th) {
                gl.V("PPSNativeView", "destory remote view err: %s", th.getClass().getSimpleName());
            }
        }
        this.f32833v = null;
        this.f32835x = null;
        this.f32834w = null;
    }

    private CusWhyThisAdView.a getWhyAdViewStatus() {
        return this.f32830s;
    }

    private void h() {
        gf.Code(getContext()).V();
        this.C.V();
        lh lhVar = this.f32818g;
        if (lhVar != null) {
            lhVar.S();
            this.f32818g.setPpsNativeView(null);
        }
        this.f32818g = null;
        this.f32826o = null;
        this.f32832u = null;
        k();
    }

    @AllApi
    public static void hideFeedback(Context context) {
        if (context != null) {
            com.huawei.openalliance.ad.msgnotify.b.Code(context, bf.B, new Intent(com.huawei.openalliance.ad.activity.a.I));
        }
    }

    private void i() {
        lg lgVar = this.f32820i;
        if (lgVar != null) {
            lgVar.setClickActionListener(new ma() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.5
                @Override // com.huawei.hms.ads.ma
                public void Code(AppDownloadButton appDownloadButton) {
                    PPSNativeView.this.B.Code((m) null, (Integer) null);
                }

                @Override // com.huawei.hms.ads.ma
                public void I(AppDownloadButton appDownloadButton) {
                    if (PPSNativeView.this.f32816e != null) {
                        PPSNativeView.this.f32816e.V();
                        PPSNativeView.this.f32816e.I();
                    }
                }

                @Override // com.huawei.hms.ads.ma
                public void V(AppDownloadButton appDownloadButton) {
                }
            });
        }
    }

    private void j() {
        n nVar;
        if (!C() || (nVar = this.S) == null || nVar.T()) {
            return;
        }
        gl.V("PPSNativeView", " maybe report show start.");
        I();
    }

    private void k() {
        List<View> list = this.f32821j;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (View view : this.f32821j) {
            if (view != null) {
                view.setOnClickListener(null);
            }
        }
        setOnClickListener(null);
    }

    private void l() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        this.f32821j = arrayList;
        V(arrayList);
    }

    private void m() {
        n();
        Code((Integer) 3, false);
        io ioVar = this.Code;
        if (ioVar != null) {
            ioVar.d();
            this.Code.I();
        }
        lh lhVar = this.f32818g;
        if (lhVar != null) {
            lhVar.S();
        }
        DislikeAdListener dislikeAdListener = this.f32826o;
        if (dislikeAdListener != null) {
            dislikeAdListener.onAdDisliked();
        }
        h();
    }

    private void n() {
        if (this.f32820i != null) {
            ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.9
                @Override // java.lang.Runnable
                public void run() {
                    PPSNativeView.this.f32820i.cancel();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        n();
        io ioVar = this.Code;
        if (ioVar != null) {
            ioVar.d();
            this.Code.I();
        }
        lh lhVar = this.f32818g;
        if (lhVar != null) {
            lhVar.S();
        }
        DislikeAdListener dislikeAdListener = this.f32826o;
        if (dislikeAdListener != null) {
            dislikeAdListener.onAdDisliked();
        }
        h();
    }

    private void setNativeVideoViewClickable(lh lhVar) {
        if (lhVar instanceof NativeVideoView) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((NativeVideoView) lhVar);
            V(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWhyAdViewStatus(CusWhyThisAdView.a aVar) {
        this.f32830s = aVar;
    }

    private void setWindowImageViewClickable(li liVar) {
        if (liVar instanceof NativeWindowImageView) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((NativeWindowImageView) liVar);
            V(arrayList);
        }
    }

    public void B() {
        h();
        gf.Code(getContext()).V();
        if (!this.f32813b) {
            Code(this.F);
            this.F = null;
            this.D = null;
            Code(this.f32812a);
            this.f32812a = null;
        }
        io ioVar = this.Code;
        if (ioVar != null) {
            ioVar.I();
        }
        g();
    }

    public boolean C() {
        hi hiVar = this.C;
        if (hiVar != null) {
            return hiVar.d();
        }
        return false;
    }

    public void Code(int i10) {
        gl.Code("PPSNativeView", "changeChoiceViewPosition option = " + i10);
        if (this.f32813b) {
            gl.I("PPSNativeView", "china rom should not call this method");
            return;
        }
        if (this.F == null) {
            gl.Code("PPSNativeView", "choicesView is null, error");
            return;
        }
        if (c()) {
            this.f32836y.setVisibility(0);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.F.getLayoutParams());
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.hiad_10_dp);
        if (i10 != 0) {
            if (i10 == 2) {
                layoutParams.addRule(12);
            } else if (i10 == 3) {
                layoutParams.addRule(12);
            } else {
                if (i10 == 4) {
                    if (this.f32825n) {
                        gl.Code("PPSNativeView", "ADCHOICES_INVISIBLE is called and not default feedback!");
                        V(this.F, 8);
                        return;
                    }
                    this.F.setVisibility(0);
                    this.F.setLayoutParams(layoutParams);
                    this.F.bringToFront();
                }
                layoutParams.addRule(10);
            }
            layoutParams.addRule(21);
            layoutParams.setMargins(0, 0, dimensionPixelOffset, 0);
            layoutParams.setMarginEnd(dimensionPixelOffset);
            this.F.setVisibility(0);
            this.F.setLayoutParams(layoutParams);
            this.F.bringToFront();
        }
        layoutParams.addRule(10);
        layoutParams.addRule(20);
        layoutParams.setMargins(dimensionPixelOffset, 0, 0, 0);
        layoutParams.setMarginStart(dimensionPixelOffset);
        this.F.setScaleX(-1.0f);
        this.D.setScaleX(-1.0f);
        this.F.setVisibility(0);
        this.F.setLayoutParams(layoutParams);
        this.F.bringToFront();
    }

    @Override // com.huawei.hms.ads.hh
    public void Code(long j10, int i10) {
        ba.Code(this.f32823l);
        if (!this.C.Code(j10) || this.f32822k) {
            return;
        }
        this.f32822k = true;
        Code(Long.valueOf(j10), Integer.valueOf(i10), null, false);
    }

    public void Code(View view, int i10) {
        n nVar;
        if (this.I) {
            this.I = false;
            gl.V("PPSNativeView", "onClick");
            this.f32824m = true;
            b bVar = this.f32814c;
            if (bVar != null) {
                bVar.Code(view);
            }
            gf.Code(getContext()).Code();
            Code((Integer) 1, true);
            o.V();
            if (this.B.Code(this.f32829r, Integer.valueOf(i10))) {
                io ioVar = this.Code;
                if (ioVar != null) {
                    ioVar.Code(jk.CLICK);
                }
            } else {
                lg lgVar = this.f32820i;
                if (lgVar instanceof AppDownloadButton) {
                    if (k.DOWNLOAD == ((AppDownloadButton) lgVar).getStatus() && (nVar = this.S) != null && nVar.l_() && kt.I(this.S.z())) {
                        gl.V("PPSNativeView", "download app directly");
                        ((AppDownloadButton) this.f32820i).performClick();
                    }
                }
            }
            this.f32829r = null;
            ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.8
                @Override // java.lang.Runnable
                public void run() {
                    PPSNativeView.this.I = true;
                }
            }, 500L);
        }
    }

    public void Code(com.huawei.openalliance.ad.inter.data.d dVar) {
        io ioVar;
        if (dVar instanceof n) {
            n nVar = (n) dVar;
            AdContentData l10 = nVar.l();
            if (l10.aA() == 3 || (ioVar = this.Code) == null) {
                return;
            }
            ioVar.Code(getContext(), l10, this, true);
            this.Code.Code(false);
            this.Code.Z();
            iz V = this.Code.V();
            this.f32831t = V;
            if (V != null) {
                ChoicesView choicesView = this.D;
                iy iyVar = iy.OTHER;
                V.Code(choicesView, iyVar, null);
                this.f32831t.Code(this.f32812a, iyVar, null);
                this.f32831t.Code(this.F, iyVar, null);
            }
            Code(this.Code, nVar);
        }
    }

    public void Code(com.huawei.openalliance.ad.inter.data.g gVar) {
        this.I = true;
        if (gVar == null) {
            return;
        }
        gl.Code("PPSNativeView", "register nativeAd");
        this.S = (n) gVar;
        e();
        if (!b()) {
            this.f32827p = gVar.h();
            this.f32828q = gVar.i();
            a();
        }
        this.C.V(this.S.r(), this.S.s());
        this.B.Code(this.S);
        this.B.V();
        Code((com.huawei.openalliance.ad.inter.data.d) gVar);
        j();
        l();
    }

    public void Code(com.huawei.openalliance.ad.inter.data.g gVar, List<View> list) {
        this.I = true;
        if (gVar == null) {
            return;
        }
        gl.Code("PPSNativeView", "register nativeAd");
        this.S = (n) gVar;
        e();
        if (!b()) {
            this.f32827p = gVar.h();
            this.f32828q = gVar.i();
            a();
        }
        this.C.V(this.S.r(), this.S.s());
        this.B.Code(this.S);
        this.B.V();
        j();
        this.f32821j = list;
        V(list);
        Code((com.huawei.openalliance.ad.inter.data.d) gVar);
    }

    public void Code(com.huawei.openalliance.ad.inter.data.g gVar, List<View> list, lh lhVar) {
        this.f32818g = lhVar;
        Code(gVar);
        if (lhVar != null) {
            lhVar.setPpsNativeView(this);
            lhVar.setNativeAd(gVar);
            setNativeVideoViewClickable(lhVar);
        }
        this.f32821j = list;
        V(list);
    }

    public void Code(com.huawei.openalliance.ad.inter.data.g gVar, List<View> list, li liVar) {
        Code(gVar);
        this.f32819h = liVar;
        if (liVar != null) {
            liVar.setNativeAd(gVar);
            setWindowImageViewClickable(this.f32819h);
        }
        this.f32821j = list;
        V(list);
    }

    @Override // com.huawei.hms.ads.lm
    public void Code(Integer num, boolean z10) {
        Code(Long.valueOf(System.currentTimeMillis() - this.C.Z()), Integer.valueOf(this.C.I()), num, z10);
    }

    public void Code(List<String> list) {
        gl.V("PPSNativeView", "onClose keyWords");
        this.B.Code(list);
        m();
    }

    public boolean Code() {
        if (this.f32825n || this.f32812a == null) {
            return false;
        }
        setWhyAdViewStatus(CusWhyThisAdView.a.SHOWN);
        d();
        this.f32812a.V();
        k();
        this.I = false;
        return true;
    }

    public boolean Code(lg lgVar) {
        if (this.S == null) {
            throw new IllegalStateException("Register INativeAd first");
        }
        boolean z10 = false;
        this.f32820i = lgVar;
        if (lgVar != null) {
            lgVar.setPpsNativeView(this);
            z10 = lgVar.Code(this.S);
            i();
        }
        if (gl.Code()) {
            gl.Code("PPSNativeView", "register downloadbutton, succ:" + z10);
        }
        return z10;
    }

    @Override // com.huawei.hms.ads.lm
    public void D() {
        io ioVar = this.Code;
        if (ioVar != null) {
            ioVar.Code(jk.CLICK);
        }
    }

    public void F() {
        gl.V("PPSNativeView", "onClose");
        Code((List<String>) null);
    }

    @Override // com.huawei.hms.ads.hh
    public void I() {
        e eVar;
        this.f32822k = false;
        long Code = v.Code();
        String valueOf = String.valueOf(Code);
        n nVar = this.S;
        if (nVar == null) {
            gl.V("PPSNativeView", "nativeAd is null, please register first");
            return;
        }
        nVar.Z(false);
        this.S.B(true);
        this.S.B(valueOf);
        this.S.V(Code);
        if (this.f32824m && (eVar = this.f32816e) != null) {
            this.f32824m = false;
            eVar.Z();
        }
        if (!this.S.Q()) {
            this.S.V(true);
            if (this.f32815d != null) {
                ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PPSNativeView.this.f32815d != null) {
                            PPSNativeView.this.f32815d.Code();
                        }
                    }
                });
            }
        }
        this.B.Code(valueOf);
        this.B.Code(Code);
        lh lhVar = this.f32818g;
        if (lhVar != null) {
            lhVar.Code(valueOf);
            this.f32818g.Code(Code);
        }
        lg lgVar = this.f32820i;
        if (lgVar != null) {
            lgVar.Z(valueOf);
            this.f32820i.Code(Code);
        }
        du duVar = this.f32834w;
        if (duVar != null) {
            duVar.Code(valueOf);
            this.f32834w.Code(Code);
        }
        io ioVar = this.Code;
        if (ioVar != null) {
            ioVar.L();
        }
        this.B.Code();
    }

    public void S() {
        io ioVar = this.Code;
        if (ioVar != null) {
            ioVar.I();
        }
    }

    @Override // com.huawei.hms.ads.hh
    public void V(long j10, int i10) {
        ba.Code(this.f32823l);
        n nVar = this.S;
        if (nVar != null) {
            nVar.B(false);
        }
        this.B.Code(j10, i10);
    }

    public void V(lg lgVar) {
        lg lgVar2;
        if (lgVar == null || lgVar != (lgVar2 = this.f32820i)) {
            return;
        }
        lgVar2.setPpsNativeView(null);
        this.f32820i.Code((com.huawei.openalliance.ad.inter.data.g) null);
        this.f32820i = null;
    }

    public void Z() {
        if (this.f32812a == null || getWhyAdViewStatus() != CusWhyThisAdView.a.INIT) {
            View view = this.f32812a;
            if (view != null) {
                Code(view);
                this.f32812a = null;
            }
            setWhyAdViewStatus(CusWhyThisAdView.a.INIT);
            CusWhyThisAdView cusWhyThisAdView = new CusWhyThisAdView(getContext(), this);
            this.f32812a = cusWhyThisAdView;
            addView(cusWhyThisAdView);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f32812a.getLayoutParams());
            layoutParams.addRule(13);
            this.f32812a.setLayoutParams(layoutParams);
        }
        this.f32812a.setOnCloseCallBack(new com.huawei.hms.ads.whythisad.b() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.3
            @Override // com.huawei.hms.ads.whythisad.b
            public void Code() {
                PPSNativeView.this.d();
            }

            @Override // com.huawei.hms.ads.whythisad.b
            public void Code(String str) {
                PPSNativeView.this.d();
                ArrayList arrayList = new ArrayList();
                if (str == null || str.isEmpty()) {
                    arrayList = null;
                } else {
                    arrayList.add(str);
                }
                PPSNativeView.this.setWhyAdViewStatus(CusWhyThisAdView.a.DISLIKED);
                PPSNativeView.this.Code(arrayList);
            }

            @Override // com.huawei.hms.ads.whythisad.b
            public List<String> I() {
                if (PPSNativeView.this.S != null) {
                    return PPSNativeView.this.S.n();
                }
                gl.I("PPSNativeView", "getKeyWords nativaAd is null");
                return null;
            }

            @Override // com.huawei.hms.ads.whythisad.b
            public void V() {
                if (PPSNativeView.this.S != null) {
                    com.huawei.openalliance.ad.utils.c.Code(PPSNativeView.this.getContext(), PPSNativeView.this.S);
                } else {
                    gl.I("PPSNativeView", "processWhyThisAdEvent nativaAd is null");
                }
            }
        });
    }

    @Override // com.huawei.hms.ads.hh
    public void a_() {
        n nVar = this.S;
        if (nVar != null) {
            ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSNativeView.4
                @Override // java.lang.Runnable
                public void run() {
                    n nVar2 = PPSNativeView.this.S;
                    if (nVar2 != null) {
                        PPSNativeView.this.Code(Long.valueOf(nVar2.r()), Integer.valueOf(PPSNativeView.this.C.I()), null, false);
                    }
                }
            }, this.f32823l, nVar.r());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            if (lf.Code(motionEvent) == 0) {
                m Code = lf.Code(this, motionEvent);
                this.f32829r = Code;
                lg lgVar = this.f32820i;
                if (lgVar != null) {
                    ((AppDownloadButton) lgVar).setClickInfo(Code);
                }
            }
            return super.dispatchTouchEvent(motionEvent);
        } catch (Throwable th) {
            gl.I("PPSNativeView", "dispatchTouchEvent exception : %s", th.getClass().getSimpleName());
            return false;
        }
    }

    public iz getAdSessionAgent() {
        return this.f32831t;
    }

    @AllApi
    public View getFeedBackView() {
        try {
            com.huawei.hms.ads.uiengine.d V = com.huawei.hms.ads.f.V();
            View view = this.f32835x;
            if (view == null || V == null) {
                return null;
            }
            return (View) ObjectWrapper.unwrap(V.Code(ObjectWrapper.wrap(view)));
        } catch (Throwable th) {
            gl.I("PPSNativeView", "get anchor view err: %s", th.getClass().getSimpleName());
            return null;
        }
    }

    public n getNativeAd() {
        return this.S;
    }

    @Override // com.huawei.hms.ads.hy
    public View getOpenMeasureView() {
        return this;
    }

    @AllApi
    public void gotoWhyThisAdPage() {
        if (this.f32813b) {
            gl.I("PPSNativeView", "china rom should not call gotoWhyThisAdPage method");
        } else if (this.S != null) {
            com.huawei.openalliance.ad.utils.c.Code(getContext(), this.S);
        } else {
            gl.I("PPSNativeView", "skipWhyThisAdPage nativaAd is null");
        }
    }

    @AllApi
    public void hideAdvertiserInfoDialog() {
        hideFeedback(getContext());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        hi hiVar = this.C;
        if (hiVar != null) {
            hiVar.D();
        }
        n nVar = this.S;
        if (nVar != null) {
            Code((com.huawei.openalliance.ad.inter.data.d) nVar);
        }
        ks.Code(getContext()).V(getContext());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        gl.V("PPSNativeView", "onDetechedFromWindow");
        hi hiVar = this.C;
        if (hiVar != null) {
            hiVar.L();
        }
        io ioVar = this.Code;
        if (ioVar != null) {
            ioVar.I();
        }
    }

    public void onViewUpdate() {
        if (gl.Code()) {
            gl.Code("PPSNativeView", "manual updateView");
        }
        this.C.onGlobalLayout();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        hi hiVar = this.C;
        if (hiVar != null) {
            hiVar.a();
        }
    }

    @AllApi
    public void pause() {
        try {
            com.huawei.hms.ads.uiengine.d V = com.huawei.hms.ads.f.V();
            View view = this.f32835x;
            if (view == null || V == null) {
                return;
            }
            V.Code(ObjectWrapper.wrap(view), (Bundle) null);
        } catch (Throwable th) {
            gl.I("PPSNativeView", "pauseVideo err: %s", th.getClass().getSimpleName());
        }
    }

    @AllApi
    public void resume() {
        try {
            com.huawei.hms.ads.uiengine.d V = com.huawei.hms.ads.f.V();
            View view = this.f32835x;
            if (view == null || V == null) {
                return;
            }
            V.V(ObjectWrapper.wrap(view), null);
        } catch (Throwable th) {
            gl.I("PPSNativeView", "resumeVideo err: %s", th.getClass().getSimpleName());
        }
    }

    public void setAdContainerSizeMatched(String str) {
        this.B.V(str);
    }

    @AllApi
    public void setAdFeedbackListener(AdFeedbackListener adFeedbackListener) {
        this.f32832u = adFeedbackListener;
    }

    public void setChoiceViewPosition(int i10) {
        gl.Code("PPSNativeView", "setChoiceViewPosition option = " + i10);
        if (this.S == null) {
            this.L = i10;
        } else {
            Code(i10);
        }
    }

    public void setDislikeAdListener(DislikeAdListener dislikeAdListener) {
        if (this.f32813b) {
            gl.I("PPSNativeView", "china rom should not call setChoiceViewPosition method");
        } else {
            this.f32826o = dislikeAdListener;
        }
    }

    public void setIsCustomDislikeThisAdEnabled(boolean z10) {
        if (this.f32813b) {
            gl.I("PPSNativeView", "china rom should not call this method and isCustomDislikeThisAdEnabled = " + z10);
            return;
        }
        this.f32825n = z10;
        if (z10) {
            gl.Code("PPSNativeView", "dont like default feedback!");
            return;
        }
        gl.Code("PPSNativeView", "like default feedback!");
        ChoicesView choicesView = this.D;
        if (choicesView != null) {
            choicesView.V();
            gl.Code("PPSNativeView", "setCustomLikeBackgroundResource");
        }
        Z();
    }

    public void setOnNativeAdClickListener(b bVar) {
        this.f32814c = bVar;
    }

    public void setOnNativeAdImpressionListener(c cVar) {
        this.f32817f = cVar;
    }

    public void setOnNativeAdStatusChangedListener(d dVar) {
        this.f32815d = dVar;
    }

    public void setOnNativeAdStatusTrackingListener(e eVar) {
        this.f32816e = eVar;
        this.B.Code(eVar);
    }

    @AllApi
    public void showAdvertiserInfoDialog(View view, boolean z10) {
        if (view == null) {
            gl.I("PPSNativeView", "anchorView is null");
        }
        try {
            n nVar = this.S;
            if (nVar == null) {
                gl.I("PPSNativeView", TanxError.ERROR_ADINFO_NULL);
                return;
            }
            AdContentData l10 = nVar.l();
            if (aa.Code(l10.aG())) {
                gl.I("PPSNativeView", "advertiser Info is null");
            } else {
                ComplianceActivity.Code(getContext(), view, l10, z10);
            }
        } catch (Throwable th) {
            gl.I("PPSNativeView", "showAdvertiserInfoDialog has exception %s", th.getClass().getSimpleName());
        }
    }

    @AllApi
    public void showFeedback(View view) {
        com.huawei.openalliance.ad.feedback.a aVar = new com.huawei.openalliance.ad.feedback.a();
        aVar.Code(view);
        aVar.V(this.f32832u);
        aVar.Code(new a(this));
        ew.Code(this.S);
        FeedbackActivity.Code(getContext(), aVar);
    }
}
