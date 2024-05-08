package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.content.Intent;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.alimm.tanx.core.request.TanxError;
import com.android.internal.os.PowerProfile;
import com.huawei.hms.ads.fr;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.gu;
import com.huawei.hms.ads.gv;
import com.huawei.hms.ads.gx;
import com.huawei.hms.ads.gz;
import com.huawei.hms.ads.ha;
import com.huawei.hms.ads.hb;
import com.huawei.hms.ads.hh;
import com.huawei.hms.ads.hi;
import com.huawei.hms.ads.ic;
import com.huawei.hms.ads.io;
import com.huawei.hms.ads.iy;
import com.huawei.hms.ads.iz;
import com.huawei.hms.ads.jk;
import com.huawei.hms.ads.jm;
import com.huawei.hms.ads.jn;
import com.huawei.hms.ads.jy;
import com.huawei.hms.ads.kl;
import com.huawei.hms.ads.ks;
import com.huawei.hms.ads.lf;
import com.huawei.hms.ads.ln;
import com.huawei.hms.ads.ls;
import com.huawei.hms.ads.lt;
import com.huawei.hms.ads.lz;
import com.huawei.openalliance.ad.activity.ComplianceActivity;
import com.huawei.openalliance.ad.constant.bf;
import com.huawei.openalliance.ad.constant.bj;
import com.huawei.openalliance.ad.constant.bq;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.m;
import com.huawei.openalliance.ad.inter.data.p;
import com.huawei.openalliance.ad.inter.data.r;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.au;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.o;
import com.huawei.openalliance.ad.utils.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PPSPlacementView extends AutoScaleSizeRelativeLayout implements gz, hb, hh, ln, lz {
    private boolean A;
    public io Code;
    private hi D;
    private boolean E;
    private kl F;
    private boolean G;
    private boolean H;
    public io I;
    private m J;
    private List<View> K;
    private List<p> L;
    private boolean M;
    private long N;
    private gx O;
    private int P;
    private boolean Q;
    private AudioManager R;
    private boolean S;
    private Object T;
    private bj U;
    public io V;
    private ha W;

    /* renamed from: a, reason: collision with root package name */
    private p f32838a;

    /* renamed from: aa, reason: collision with root package name */
    private Handler f32839aa;

    /* renamed from: ab, reason: collision with root package name */
    private hb f32840ab;

    /* renamed from: ac, reason: collision with root package name */
    private View.OnClickListener f32841ac;

    /* renamed from: ad, reason: collision with root package name */
    private AudioManager.OnAudioFocusChangeListener f32842ad;

    /* renamed from: b, reason: collision with root package name */
    private p f32843b;

    /* renamed from: c, reason: collision with root package name */
    private int f32844c;

    /* renamed from: d, reason: collision with root package name */
    private a f32845d;

    /* renamed from: e, reason: collision with root package name */
    private List<View> f32846e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f32847f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f32848g;

    /* renamed from: h, reason: collision with root package name */
    private PlacementMediaView f32849h;

    /* renamed from: i, reason: collision with root package name */
    private PlacementMediaView f32850i;

    /* renamed from: j, reason: collision with root package name */
    private PlacementMediaView f32851j;

    /* renamed from: k, reason: collision with root package name */
    private gu f32852k;

    /* renamed from: l, reason: collision with root package name */
    private gz f32853l;

    /* renamed from: m, reason: collision with root package name */
    private gv f32854m;

    /* renamed from: n, reason: collision with root package name */
    private lt f32855n;

    /* renamed from: o, reason: collision with root package name */
    private ls f32856o;

    /* renamed from: p, reason: collision with root package name */
    private int[] f32857p;

    /* renamed from: q, reason: collision with root package name */
    private PlacementMediaView f32858q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f32859r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f32860s;

    /* renamed from: t, reason: collision with root package name */
    private int f32861t;

    /* renamed from: u, reason: collision with root package name */
    private int f32862u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f32863v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f32864w;

    /* renamed from: x, reason: collision with root package name */
    private int f32865x;

    /* renamed from: z, reason: collision with root package name */
    private ImageView f32866z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface a {
        void Code();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b implements AudioManager.OnAudioFocusChangeListener {
        private WeakReference<PPSPlacementView> Code;

        public b(PPSPlacementView pPSPlacementView) {
            this.Code = new WeakReference<>(pPSPlacementView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Code(PPSPlacementView pPSPlacementView) {
            V(pPSPlacementView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void I(PPSPlacementView pPSPlacementView) {
            gl.V("PPSPlacementView", "handleAudioFocusGain.");
            if (!pPSPlacementView.Q || pPSPlacementView.f32858q == null) {
                return;
            }
            pPSPlacementView.f32858q.B();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void V(PPSPlacementView pPSPlacementView) {
            gl.V("PPSPlacementView", "handleAudioFocusLossTransientCanDuck soundMuted: " + pPSPlacementView.f32859r);
            if (pPSPlacementView.f32859r || pPSPlacementView.f32858q == null) {
                return;
            }
            pPSPlacementView.f32858q.I();
            pPSPlacementView.Q = true;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i10) {
            ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.b.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    PPSPlacementView pPSPlacementView = (PPSPlacementView) b.this.Code.get();
                    if (pPSPlacementView == null) {
                        return;
                    }
                    gl.V("PPSPlacementView", "onAudioFocusChange %d previous: %d", Integer.valueOf(i10), Integer.valueOf(pPSPlacementView.P));
                    int i11 = i10;
                    if (i11 == -3) {
                        b.this.V(pPSPlacementView);
                    } else if (i11 == -2 || i11 == -1) {
                        b.this.Code(pPSPlacementView);
                    } else if (i11 == 1 || i11 == 2) {
                        b.this.I(pPSPlacementView);
                    }
                    pPSPlacementView.P = i10;
                }
            });
        }
    }

    public PPSPlacementView(Context context) {
        super(context);
        this.S = true;
        this.Code = new ic();
        this.V = new ic();
        this.I = new ic();
        this.L = new ArrayList(4);
        this.f32844c = 0;
        this.f32847f = false;
        this.f32848g = false;
        this.f32852k = null;
        this.f32853l = null;
        this.f32854m = null;
        this.f32855n = null;
        this.f32856o = null;
        this.f32857p = null;
        this.f32859r = false;
        this.f32860s = false;
        this.f32861t = -1;
        this.f32862u = -1;
        this.f32863v = false;
        this.f32864w = false;
        this.f32865x = -1;
        this.f32866z = null;
        this.A = false;
        this.E = false;
        this.G = false;
        this.H = false;
        this.P = 0;
        this.Q = false;
        this.U = new bj();
        this.W = new ha() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.1
            @Override // com.huawei.hms.ads.ha
            public void Code() {
                gl.V("PPSPlacementView", "videoRenderStart");
                PPSPlacementView.this.k();
                if (!PPSPlacementView.this.E || PPSPlacementView.this.f32855n == null) {
                    return;
                }
                PPSPlacementView.this.E = false;
                PPSPlacementView.this.G = true;
                gl.V("PPSPlacementView", "onMediaStart callback, playTime: %s", Integer.valueOf(PPSPlacementView.this.f32861t));
                PPSPlacementView.this.f32855n.Code(PPSPlacementView.this.f32861t);
                PPSPlacementView.this.l();
            }
        };
        this.f32839aa = new Handler(Looper.myLooper(), new Handler.Callback() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.12
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                int i10;
                p currentAd = PPSPlacementView.this.getCurrentAd();
                r currentMediaFile = PPSPlacementView.this.getCurrentMediaFile();
                String str = "";
                String D = currentAd != null ? currentAd.D() : "";
                if (currentMediaFile != null) {
                    str = currentMediaFile.Z();
                    i10 = (int) currentMediaFile.d();
                } else {
                    i10 = 0;
                }
                gl.V("PPSPlacementView", "callback timeout: %s", D);
                if (PPSPlacementView.this.f32858q != null) {
                    gl.V("PPSPlacementView", "notify Error");
                    PPSPlacementView.this.B(D, str, i10);
                }
                return true;
            }
        });
        this.f32840ab = new hb() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.16
            @Override // com.huawei.hms.ads.hb
            public void Code(String str, String str2, int i10) {
                PPSPlacementView pPSPlacementView;
                io ioVar;
                if (gl.Code()) {
                    gl.Code("PPSPlacementView", "OM onSegmentMediaStart");
                }
                PPSPlacementView.this.M = false;
                if (PPSPlacementView.this.f32858q instanceof PlacementVideoView) {
                    boolean V = PPSPlacementView.this.U.V(bj.a.SINGLE_INST);
                    if (i10 > 0) {
                        (V ? PPSPlacementView.this.I : PPSPlacementView.this.U.V(bj.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).f();
                        return;
                    }
                    if (V) {
                        pPSPlacementView = PPSPlacementView.this;
                        ioVar = pPSPlacementView.I;
                    } else if (PPSPlacementView.this.U.V(bj.a.MAIN_VIEW)) {
                        pPSPlacementView = PPSPlacementView.this;
                        ioVar = pPSPlacementView.Code;
                    } else {
                        pPSPlacementView = PPSPlacementView.this;
                        ioVar = pPSPlacementView.V;
                    }
                    pPSPlacementView.Code(ioVar);
                }
            }

            @Override // com.huawei.hms.ads.hb
            public void Code(String str, String str2, int i10, int i11) {
                if ((str == null || str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) && !PPSPlacementView.this.M && (PPSPlacementView.this.f32858q instanceof PlacementVideoView)) {
                    (PPSPlacementView.this.U.V(bj.a.SINGLE_INST) ? PPSPlacementView.this.I : PPSPlacementView.this.U.V(bj.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).Code(i10);
                }
            }

            @Override // com.huawei.hms.ads.hb
            public void Code(String str, String str2, int i10, int i11, int i12) {
            }

            @Override // com.huawei.hms.ads.hb
            public void I(String str, String str2, int i10) {
                if (gl.Code()) {
                    gl.Code("PPSPlacementView", "OM onSegmentMediaStop");
                }
                if (str != null && !str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) {
                    gl.V("PPSPlacementView", "OM onSegmentMediaStop not equals");
                } else {
                    if (PPSPlacementView.this.M) {
                        return;
                    }
                    PPSPlacementView.this.M = true;
                    if (PPSPlacementView.this.f32858q instanceof PlacementVideoView) {
                        (PPSPlacementView.this.U.V(bj.a.SINGLE_INST) ? PPSPlacementView.this.I : PPSPlacementView.this.U.V(bj.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).a();
                    }
                }
            }

            @Override // com.huawei.hms.ads.hb
            public void V(String str, String str2, int i10) {
                if (gl.Code()) {
                    gl.Code("PPSPlacementView", "OM onSegmentMediaPause");
                }
                if ((str == null || str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) && (PPSPlacementView.this.f32858q instanceof PlacementVideoView)) {
                    (PPSPlacementView.this.U.V(bj.a.SINGLE_INST) ? PPSPlacementView.this.I : PPSPlacementView.this.U.V(bj.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).e();
                }
            }

            @Override // com.huawei.hms.ads.hb
            public void Z(String str, String str2, int i10) {
                if (gl.Code()) {
                    gl.Code("PPSPlacementView", "OM onSegmentMediaCompletion");
                }
                if (str != null && !str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) {
                    gl.V("PPSPlacementView", "OM onSegmentMediaCompletion not equals");
                } else {
                    if (PPSPlacementView.this.M) {
                        return;
                    }
                    PPSPlacementView.this.M = true;
                    if (PPSPlacementView.this.f32858q instanceof PlacementVideoView) {
                        (PPSPlacementView.this.U.V(bj.a.SINGLE_INST) ? PPSPlacementView.this.I : PPSPlacementView.this.U.V(bj.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).a();
                    }
                }
            }
        };
        this.f32841ac = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.21.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PPSPlacementView.this.c();
                    }
                });
            }
        };
        this.f32842ad = new b(this);
        Code(context);
    }

    public PPSPlacementView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.S = true;
        this.Code = new ic();
        this.V = new ic();
        this.I = new ic();
        this.L = new ArrayList(4);
        this.f32844c = 0;
        this.f32847f = false;
        this.f32848g = false;
        this.f32852k = null;
        this.f32853l = null;
        this.f32854m = null;
        this.f32855n = null;
        this.f32856o = null;
        this.f32857p = null;
        this.f32859r = false;
        this.f32860s = false;
        this.f32861t = -1;
        this.f32862u = -1;
        this.f32863v = false;
        this.f32864w = false;
        this.f32865x = -1;
        this.f32866z = null;
        this.A = false;
        this.E = false;
        this.G = false;
        this.H = false;
        this.P = 0;
        this.Q = false;
        this.U = new bj();
        this.W = new ha() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.1
            @Override // com.huawei.hms.ads.ha
            public void Code() {
                gl.V("PPSPlacementView", "videoRenderStart");
                PPSPlacementView.this.k();
                if (!PPSPlacementView.this.E || PPSPlacementView.this.f32855n == null) {
                    return;
                }
                PPSPlacementView.this.E = false;
                PPSPlacementView.this.G = true;
                gl.V("PPSPlacementView", "onMediaStart callback, playTime: %s", Integer.valueOf(PPSPlacementView.this.f32861t));
                PPSPlacementView.this.f32855n.Code(PPSPlacementView.this.f32861t);
                PPSPlacementView.this.l();
            }
        };
        this.f32839aa = new Handler(Looper.myLooper(), new Handler.Callback() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.12
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                int i10;
                p currentAd = PPSPlacementView.this.getCurrentAd();
                r currentMediaFile = PPSPlacementView.this.getCurrentMediaFile();
                String str = "";
                String D = currentAd != null ? currentAd.D() : "";
                if (currentMediaFile != null) {
                    str = currentMediaFile.Z();
                    i10 = (int) currentMediaFile.d();
                } else {
                    i10 = 0;
                }
                gl.V("PPSPlacementView", "callback timeout: %s", D);
                if (PPSPlacementView.this.f32858q != null) {
                    gl.V("PPSPlacementView", "notify Error");
                    PPSPlacementView.this.B(D, str, i10);
                }
                return true;
            }
        });
        this.f32840ab = new hb() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.16
            @Override // com.huawei.hms.ads.hb
            public void Code(String str, String str2, int i10) {
                PPSPlacementView pPSPlacementView;
                io ioVar;
                if (gl.Code()) {
                    gl.Code("PPSPlacementView", "OM onSegmentMediaStart");
                }
                PPSPlacementView.this.M = false;
                if (PPSPlacementView.this.f32858q instanceof PlacementVideoView) {
                    boolean V = PPSPlacementView.this.U.V(bj.a.SINGLE_INST);
                    if (i10 > 0) {
                        (V ? PPSPlacementView.this.I : PPSPlacementView.this.U.V(bj.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).f();
                        return;
                    }
                    if (V) {
                        pPSPlacementView = PPSPlacementView.this;
                        ioVar = pPSPlacementView.I;
                    } else if (PPSPlacementView.this.U.V(bj.a.MAIN_VIEW)) {
                        pPSPlacementView = PPSPlacementView.this;
                        ioVar = pPSPlacementView.Code;
                    } else {
                        pPSPlacementView = PPSPlacementView.this;
                        ioVar = pPSPlacementView.V;
                    }
                    pPSPlacementView.Code(ioVar);
                }
            }

            @Override // com.huawei.hms.ads.hb
            public void Code(String str, String str2, int i10, int i11) {
                if ((str == null || str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) && !PPSPlacementView.this.M && (PPSPlacementView.this.f32858q instanceof PlacementVideoView)) {
                    (PPSPlacementView.this.U.V(bj.a.SINGLE_INST) ? PPSPlacementView.this.I : PPSPlacementView.this.U.V(bj.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).Code(i10);
                }
            }

            @Override // com.huawei.hms.ads.hb
            public void Code(String str, String str2, int i10, int i11, int i12) {
            }

            @Override // com.huawei.hms.ads.hb
            public void I(String str, String str2, int i10) {
                if (gl.Code()) {
                    gl.Code("PPSPlacementView", "OM onSegmentMediaStop");
                }
                if (str != null && !str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) {
                    gl.V("PPSPlacementView", "OM onSegmentMediaStop not equals");
                } else {
                    if (PPSPlacementView.this.M) {
                        return;
                    }
                    PPSPlacementView.this.M = true;
                    if (PPSPlacementView.this.f32858q instanceof PlacementVideoView) {
                        (PPSPlacementView.this.U.V(bj.a.SINGLE_INST) ? PPSPlacementView.this.I : PPSPlacementView.this.U.V(bj.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).a();
                    }
                }
            }

            @Override // com.huawei.hms.ads.hb
            public void V(String str, String str2, int i10) {
                if (gl.Code()) {
                    gl.Code("PPSPlacementView", "OM onSegmentMediaPause");
                }
                if ((str == null || str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) && (PPSPlacementView.this.f32858q instanceof PlacementVideoView)) {
                    (PPSPlacementView.this.U.V(bj.a.SINGLE_INST) ? PPSPlacementView.this.I : PPSPlacementView.this.U.V(bj.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).e();
                }
            }

            @Override // com.huawei.hms.ads.hb
            public void Z(String str, String str2, int i10) {
                if (gl.Code()) {
                    gl.Code("PPSPlacementView", "OM onSegmentMediaCompletion");
                }
                if (str != null && !str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) {
                    gl.V("PPSPlacementView", "OM onSegmentMediaCompletion not equals");
                } else {
                    if (PPSPlacementView.this.M) {
                        return;
                    }
                    PPSPlacementView.this.M = true;
                    if (PPSPlacementView.this.f32858q instanceof PlacementVideoView) {
                        (PPSPlacementView.this.U.V(bj.a.SINGLE_INST) ? PPSPlacementView.this.I : PPSPlacementView.this.U.V(bj.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).a();
                    }
                }
            }
        };
        this.f32841ac = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.21.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PPSPlacementView.this.c();
                    }
                });
            }
        };
        this.f32842ad = new b(this);
        Code(context);
    }

    public PPSPlacementView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.S = true;
        this.Code = new ic();
        this.V = new ic();
        this.I = new ic();
        this.L = new ArrayList(4);
        this.f32844c = 0;
        this.f32847f = false;
        this.f32848g = false;
        this.f32852k = null;
        this.f32853l = null;
        this.f32854m = null;
        this.f32855n = null;
        this.f32856o = null;
        this.f32857p = null;
        this.f32859r = false;
        this.f32860s = false;
        this.f32861t = -1;
        this.f32862u = -1;
        this.f32863v = false;
        this.f32864w = false;
        this.f32865x = -1;
        this.f32866z = null;
        this.A = false;
        this.E = false;
        this.G = false;
        this.H = false;
        this.P = 0;
        this.Q = false;
        this.U = new bj();
        this.W = new ha() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.1
            @Override // com.huawei.hms.ads.ha
            public void Code() {
                gl.V("PPSPlacementView", "videoRenderStart");
                PPSPlacementView.this.k();
                if (!PPSPlacementView.this.E || PPSPlacementView.this.f32855n == null) {
                    return;
                }
                PPSPlacementView.this.E = false;
                PPSPlacementView.this.G = true;
                gl.V("PPSPlacementView", "onMediaStart callback, playTime: %s", Integer.valueOf(PPSPlacementView.this.f32861t));
                PPSPlacementView.this.f32855n.Code(PPSPlacementView.this.f32861t);
                PPSPlacementView.this.l();
            }
        };
        this.f32839aa = new Handler(Looper.myLooper(), new Handler.Callback() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.12
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                int i102;
                p currentAd = PPSPlacementView.this.getCurrentAd();
                r currentMediaFile = PPSPlacementView.this.getCurrentMediaFile();
                String str = "";
                String D = currentAd != null ? currentAd.D() : "";
                if (currentMediaFile != null) {
                    str = currentMediaFile.Z();
                    i102 = (int) currentMediaFile.d();
                } else {
                    i102 = 0;
                }
                gl.V("PPSPlacementView", "callback timeout: %s", D);
                if (PPSPlacementView.this.f32858q != null) {
                    gl.V("PPSPlacementView", "notify Error");
                    PPSPlacementView.this.B(D, str, i102);
                }
                return true;
            }
        });
        this.f32840ab = new hb() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.16
            @Override // com.huawei.hms.ads.hb
            public void Code(String str, String str2, int i102) {
                PPSPlacementView pPSPlacementView;
                io ioVar;
                if (gl.Code()) {
                    gl.Code("PPSPlacementView", "OM onSegmentMediaStart");
                }
                PPSPlacementView.this.M = false;
                if (PPSPlacementView.this.f32858q instanceof PlacementVideoView) {
                    boolean V = PPSPlacementView.this.U.V(bj.a.SINGLE_INST);
                    if (i102 > 0) {
                        (V ? PPSPlacementView.this.I : PPSPlacementView.this.U.V(bj.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).f();
                        return;
                    }
                    if (V) {
                        pPSPlacementView = PPSPlacementView.this;
                        ioVar = pPSPlacementView.I;
                    } else if (PPSPlacementView.this.U.V(bj.a.MAIN_VIEW)) {
                        pPSPlacementView = PPSPlacementView.this;
                        ioVar = pPSPlacementView.Code;
                    } else {
                        pPSPlacementView = PPSPlacementView.this;
                        ioVar = pPSPlacementView.V;
                    }
                    pPSPlacementView.Code(ioVar);
                }
            }

            @Override // com.huawei.hms.ads.hb
            public void Code(String str, String str2, int i102, int i11) {
                if ((str == null || str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) && !PPSPlacementView.this.M && (PPSPlacementView.this.f32858q instanceof PlacementVideoView)) {
                    (PPSPlacementView.this.U.V(bj.a.SINGLE_INST) ? PPSPlacementView.this.I : PPSPlacementView.this.U.V(bj.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).Code(i102);
                }
            }

            @Override // com.huawei.hms.ads.hb
            public void Code(String str, String str2, int i102, int i11, int i12) {
            }

            @Override // com.huawei.hms.ads.hb
            public void I(String str, String str2, int i102) {
                if (gl.Code()) {
                    gl.Code("PPSPlacementView", "OM onSegmentMediaStop");
                }
                if (str != null && !str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) {
                    gl.V("PPSPlacementView", "OM onSegmentMediaStop not equals");
                } else {
                    if (PPSPlacementView.this.M) {
                        return;
                    }
                    PPSPlacementView.this.M = true;
                    if (PPSPlacementView.this.f32858q instanceof PlacementVideoView) {
                        (PPSPlacementView.this.U.V(bj.a.SINGLE_INST) ? PPSPlacementView.this.I : PPSPlacementView.this.U.V(bj.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).a();
                    }
                }
            }

            @Override // com.huawei.hms.ads.hb
            public void V(String str, String str2, int i102) {
                if (gl.Code()) {
                    gl.Code("PPSPlacementView", "OM onSegmentMediaPause");
                }
                if ((str == null || str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) && (PPSPlacementView.this.f32858q instanceof PlacementVideoView)) {
                    (PPSPlacementView.this.U.V(bj.a.SINGLE_INST) ? PPSPlacementView.this.I : PPSPlacementView.this.U.V(bj.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).e();
                }
            }

            @Override // com.huawei.hms.ads.hb
            public void Z(String str, String str2, int i102) {
                if (gl.Code()) {
                    gl.Code("PPSPlacementView", "OM onSegmentMediaCompletion");
                }
                if (str != null && !str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) {
                    gl.V("PPSPlacementView", "OM onSegmentMediaCompletion not equals");
                } else {
                    if (PPSPlacementView.this.M) {
                        return;
                    }
                    PPSPlacementView.this.M = true;
                    if (PPSPlacementView.this.f32858q instanceof PlacementVideoView) {
                        (PPSPlacementView.this.U.V(bj.a.SINGLE_INST) ? PPSPlacementView.this.I : PPSPlacementView.this.U.V(bj.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).a();
                    }
                }
            }
        };
        this.f32841ac = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.21.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PPSPlacementView.this.c();
                    }
                });
            }
        };
        this.f32842ad = new b(this);
        Code(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(final String str, final String str2, final int i10) {
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.15
            @Override // java.lang.Runnable
            public void run() {
                PPSPlacementView.this.Code(str, str2, i10, -1, -1);
            }
        });
    }

    private io Code(bj bjVar) {
        if (bjVar.V(bj.a.SINGLE_INST)) {
            this.I.I();
            ic icVar = new ic();
            this.I = icVar;
            return icVar;
        }
        if (bjVar.V(bj.a.MAIN_VIEW)) {
            this.Code.I();
            ic icVar2 = new ic();
            this.Code = icVar2;
            return icVar2;
        }
        this.V.I();
        ic icVar3 = new ic();
        this.V = icVar3;
        return icVar3;
    }

    private PlacementMediaView Code(p pVar) {
        if (pVar == null) {
            gl.I("PPSPlacementView", "create media view with null ad");
            return null;
        }
        gl.Code("PPSPlacementView", "create media view for content:%s", pVar.D());
        if (pVar.V()) {
            gl.V("PPSPlacementView", "create video view");
            return new PlacementVideoView(getContext());
        }
        if (pVar.I()) {
            gl.V("PPSPlacementView", "create image view");
            return new PlacementImageView(getContext());
        }
        gl.V("PPSPlacementView", "return image view for default");
        return new PlacementImageView(getContext());
    }

    private void Code(int i10) {
        int i11;
        if (this.f32860s && (i11 = this.f32861t) >= 0) {
            this.f32862u = i10 - i11;
            this.f32860s = false;
        }
        this.f32861t = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(long j10) {
        if (this.H) {
            return;
        }
        this.H = true;
        gl.V("PPSPlacementView", "timeout, submit: %s", Long.valueOf(j10));
        this.f32839aa.sendEmptyMessageDelayed(1001, j10);
    }

    private void Code(Context context) {
        bj bjVar;
        bj.a aVar;
        setBackgroundColor(-16777216);
        setUseRatioInMatchParentMode(false);
        this.F = new jy(context, this);
        this.D = new hi(this, this);
        this.R = (AudioManager) context.getSystemService(PowerProfile.POWER_AUDIO);
        if (fr.Code(context).aj()) {
            bjVar = this.U;
            aVar = bj.a.SINGLE_INST;
        } else {
            bjVar = this.U;
            aVar = bj.a.MAIN_VIEW;
        }
        bjVar.Code(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(io ioVar) {
        if (ioVar == null || getCurrentAd() == null || getCurrentAd().S() == null) {
            return;
        }
        gl.V("PPSPlacementView", "om start");
        ioVar.Code((float) getCurrentAd().S().d(), !"y".equals(getCurrentAd().S().S()));
    }

    private void Code(io ioVar, PlacementMediaView placementMediaView) {
        if (placementMediaView instanceof PlacementVideoView) {
            ioVar.Code(jn.Code(0.0f, true, jm.STANDALONE));
            ((PlacementVideoView) placementMediaView).Code(ioVar);
        } else if (placementMediaView instanceof PlacementImageView) {
            ioVar.L();
        }
    }

    private void Code(bj bjVar, com.huawei.openalliance.ad.inter.data.d dVar, PlacementMediaView placementMediaView) {
        if (dVar instanceof p) {
            AdContentData l10 = ((p) dVar).l();
            io Code = Code(bjVar);
            Code.Code(getContext(), l10, placementMediaView, true);
            Z(Code);
            Code.Z();
            Code(Code, placementMediaView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(PlacementMediaView placementMediaView) {
        if (placementMediaView == null) {
            gl.I("PPSPlacementView", "show ad with null media view");
            return;
        }
        this.f32862u = -1;
        gl.Code("PPSPlacementView", "showAd:%s", Integer.valueOf(this.f32844c));
        this.f32858q = placementMediaView;
        placementMediaView.setAlpha(1.0f);
        placementMediaView.Code(true, this.f32859r);
        if (!isShown()) {
            gl.I("PPSPlacementView", "view not visible, pause.");
            pauseView();
        }
        Code(placementMediaView.getDuration() * 2);
    }

    private void Code(final PlacementMediaView placementMediaView, boolean z10) {
        if (placementMediaView != null) {
            com.huawei.openalliance.ad.inter.data.h placementAd = placementMediaView.getPlacementAd();
            gl.V("PPSPlacementView", "unloadMediaView, contentId: %s, remove: %s", placementAd != null ? placementAd.D() : null, Boolean.valueOf(z10));
            placementMediaView.S();
            placementMediaView.setPlacementAd(null);
            final ViewParent parent = placementMediaView.getParent();
            if (parent == null || !(parent instanceof ViewGroup)) {
                return;
            }
            placementMediaView.setAlpha(0.0f);
            if (z10) {
                ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.19
                    @Override // java.lang.Runnable
                    public void run() {
                        ViewParent viewParent = parent;
                        if (viewParent != null) {
                            ((ViewGroup) viewParent).removeView(placementMediaView);
                        }
                    }
                });
            }
        }
    }

    private void Code(Long l10, Integer num, Integer num2) {
        p currentAd = getCurrentAd();
        if (currentAd == null || currentAd.Q()) {
            return;
        }
        currentAd.Z(true);
        this.F.Code(au.Code(Long.valueOf(this.N)));
        this.F.Code(this.N);
        this.F.Code(l10.longValue(), num.intValue(), num2);
        I(this.U.V(bj.a.SINGLE_INST) ? this.I : this.U.V(bj.a.MAIN_VIEW) ? this.Code : this.V);
    }

    private boolean Code(PlacementMediaView placementMediaView, p pVar) {
        return ((placementMediaView instanceof PlacementVideoView) && pVar.V()) || ((placementMediaView instanceof PlacementImageView) && pVar.I());
    }

    private void I(long j10, int i10) {
        p currentAd = getCurrentAd();
        if (currentAd == null || this.f32847f || j10 <= currentAd.r()) {
            return;
        }
        this.f32847f = true;
        Code(Long.valueOf(j10), Integer.valueOf(i10), (Integer) null);
    }

    private void I(io ioVar) {
        if (ioVar != null) {
            ioVar.D();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(List<com.huawei.openalliance.ad.inter.data.h> list) {
        r S;
        r S2;
        if (aa.Code(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        this.L.clear();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            com.huawei.openalliance.ad.inter.data.h hVar = (com.huawei.openalliance.ad.inter.data.h) arrayList.get(i10);
            if ((hVar instanceof p) && (S2 = hVar.S()) != null) {
                String Z = S2.Z();
                if (2 == S2.c() || (Z != null && Z.startsWith(bq.CONTENT.toString()))) {
                    this.L.add((p) hVar);
                } else {
                    gl.V("PPSPlacementView", "has no cache, discard " + hVar.D());
                }
            }
        }
        int size2 = this.L.size();
        this.f32857p = new int[size2];
        if (aa.Code(this.L)) {
            return;
        }
        Collections.sort(this.L);
        for (int i11 = 0; i11 < size2; i11++) {
            p pVar = this.L.get(i11);
            int d10 = (pVar == null || (S = pVar.S()) == null) ? 0 : (int) S.d();
            int[] iArr = this.f32857p;
            if (i11 == 0) {
                iArr[i11] = d10;
            } else {
                iArr[i11] = d10 + iArr[i11 - 1];
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        if (this.f32863v) {
            return;
        }
        this.f32863v = true;
        this.F.V();
    }

    private PlacementMediaView V(PlacementMediaView placementMediaView, p pVar) {
        if (pVar == null) {
            return null;
        }
        boolean z10 = true;
        gl.Code("PPSPlacementView", "init media view for content:%s", pVar.D());
        if (Code(placementMediaView, pVar)) {
            Code(placementMediaView, false);
        } else {
            Code(placementMediaView, true);
            placementMediaView = null;
        }
        if (placementMediaView == null) {
            placementMediaView = Code(pVar);
        } else {
            z10 = false;
        }
        if (placementMediaView != null) {
            gl.V("PPSPlacementView", "meida view created");
            placementMediaView.Code((hb) this);
            gu guVar = this.f32852k;
            if (guVar != null) {
                placementMediaView.Code(guVar);
            }
            ha haVar = this.W;
            if (haVar != null) {
                placementMediaView.Code(haVar);
            }
            gz gzVar = this.f32853l;
            if (gzVar != null) {
                placementMediaView.Code(gzVar);
            }
            placementMediaView.Code((gz) this);
            gv gvVar = this.f32854m;
            if (gvVar != null) {
                placementMediaView.Code(gvVar);
            }
            hb hbVar = this.f32840ab;
            if (hbVar != null) {
                placementMediaView.I(hbVar);
            }
            if (z10) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(13);
                addView(placementMediaView, layoutParams);
            }
            placementMediaView.setAlpha(0.0f);
            placementMediaView.setPlacementAd(pVar);
            placementMediaView.setAudioFocusType(2);
        }
        return placementMediaView;
    }

    private void V(io ioVar) {
        if (ioVar != null) {
            ioVar.Code(jk.CLICK);
        }
    }

    private void V(boolean z10) {
        if (this.f32844c < this.L.size() - 1) {
            h();
            if (z10) {
                return;
            }
            g();
        }
    }

    private void Z(io ioVar) {
        List<View> list;
        iz V = ioVar.V();
        if (V == null || (list = this.K) == null || list.size() <= 0) {
            return;
        }
        Iterator<View> iterator2 = this.K.iterator2();
        while (iterator2.hasNext()) {
            V.Code(iterator2.next(), iy.OTHER, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        bj bjVar;
        p pVar;
        PlacementMediaView placementMediaView;
        bj bjVar2 = this.U;
        bj.a aVar = bj.a.SINGLE_INST;
        gl.Code("PPSPlacementView", "initPlacementView, singlePlayerInst: %s", Boolean.valueOf(bjVar2.V(aVar)));
        this.D.V(this.f32838a.r(), this.f32838a.s());
        this.F.Code(this.f32838a);
        if (this.U.V(aVar)) {
            PlacementMediaView V = V(this.f32851j, this.f32838a);
            this.f32851j = V;
            V.setMediaPlayerReleaseListener(this.O);
            bjVar = new bj(aVar);
            pVar = this.f32838a;
            placementMediaView = this.f32851j;
        } else {
            this.f32849h = V(this.f32849h, this.f32838a);
            Code(new bj(bj.a.MAIN_VIEW), this.f32838a, this.f32849h);
            this.f32850i = V(this.f32850i, this.f32843b);
            bjVar = new bj(bj.a.BACKUP_VIEW);
            pVar = this.f32843b;
            placementMediaView = this.f32850i;
        }
        Code(bjVar, pVar, placementMediaView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        String valueOf = String.valueOf(this.N);
        this.F.Code(valueOf);
        this.F.Code(this.N);
        PlacementMediaView placementMediaView = this.f32851j;
        if (placementMediaView != null) {
            placementMediaView.Code(valueOf);
            this.f32851j.Code(this.N);
        }
        PlacementMediaView placementMediaView2 = this.f32849h;
        if (placementMediaView2 != null) {
            placementMediaView2.Code(valueOf);
            this.f32849h.Code(this.N);
        }
        PlacementMediaView placementMediaView3 = this.f32850i;
        if (placementMediaView3 != null) {
            placementMediaView3.Code(valueOf);
            this.f32850i.Code(this.N);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.S) {
            o.V();
            this.S = false;
            gl.V("PPSPlacementView", "onClick");
            Code((Integer) 1);
            this.F.Code(this.J);
            this.J = null;
            V(this.U.V(bj.a.SINGLE_INST) ? this.I : this.U.V(bj.a.MAIN_VIEW) ? this.Code : this.V);
            a aVar = this.f32845d;
            if (aVar != null) {
                aVar.Code();
            }
            ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.22
                @Override // java.lang.Runnable
                public void run() {
                    PPSPlacementView.this.S = true;
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        this.f32846e = arrayList;
        V(arrayList);
    }

    private boolean f() {
        return this.f32844c == this.L.size() - 1;
    }

    private void g() {
        bj bjVar;
        p pVar;
        PlacementMediaView placementMediaView;
        this.f32844c++;
        gl.V("PPSPlacementView", "load " + this.f32844c + " ad");
        if (getNextAd() == null || this.U.V(bj.a.SINGLE_INST)) {
            return;
        }
        if (Math.abs(this.f32849h.getAlpha() - 1.0f) < 0.01f) {
            p nextAd = getNextAd();
            this.f32843b = nextAd;
            this.f32850i = V(this.f32850i, nextAd);
            bjVar = new bj(bj.a.BACKUP_VIEW);
            pVar = this.f32843b;
            placementMediaView = this.f32850i;
        } else {
            p nextAd2 = getNextAd();
            this.f32838a = nextAd2;
            this.f32849h = V(this.f32849h, nextAd2);
            bjVar = new bj(bj.a.MAIN_VIEW);
            pVar = this.f32838a;
            placementMediaView = this.f32849h;
        }
        Code(bjVar, pVar, placementMediaView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public p getCurrentAd() {
        if (this.f32844c < this.L.size()) {
            return this.L.get(this.f32844c);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getCurrentAdDuration() {
        r S;
        p currentAd = getCurrentAd();
        if (currentAd == null || (S = currentAd.S()) == null) {
            return 0L;
        }
        return S.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getCurrentContentId() {
        p currentAd = getCurrentAd();
        if (currentAd == null) {
            return null;
        }
        return currentAd.D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public r getCurrentMediaFile() {
        if (getCurrentAd() != null) {
            return getCurrentAd().S();
        }
        return null;
    }

    private com.huawei.openalliance.ad.media.c getCurrentMediaState() {
        PlacementMediaView placementMediaView = this.f32858q;
        if (placementMediaView == null) {
            return null;
        }
        return placementMediaView.getMediaState();
    }

    private int getCurrentPlayTime() {
        int i10 = this.f32844c;
        if (i10 < 1) {
            return 0;
        }
        return this.f32857p[i10 - 1];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public p getNextAd() {
        if (this.f32844c < this.L.size() - 1) {
            return this.L.get(this.f32844c + 1);
        }
        return null;
    }

    private void h() {
        PlacementMediaView placementMediaView;
        p nextAd = getNextAd();
        if (nextAd != null) {
            this.D.V(nextAd.r(), nextAd.s());
        }
        this.F.Code(nextAd);
        this.F.Z();
        bj bjVar = this.U;
        bj.a aVar = bj.a.SINGLE_INST;
        if (bjVar.V(aVar)) {
            this.f32851j = V(this.f32851j, nextAd);
            Code(new bj(aVar), nextAd, this.f32851j);
            Code(this.f32851j);
        } else {
            if (Math.abs(this.f32849h.getAlpha() - 1.0f) < 0.01f) {
                this.U.Code(bj.a.BACKUP_VIEW);
                Code(this.f32850i);
                placementMediaView = this.f32849h;
            } else {
                this.U.Code(bj.a.MAIN_VIEW);
                Code(this.f32849h);
                placementMediaView = this.f32850i;
            }
            Code(placementMediaView, false);
        }
        this.D.b();
        gl.V("PPSPlacementView", "show " + this.f32844c + " ad");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.H = false;
        gl.V("PPSPlacementView", "timeout, cancel.");
        this.f32839aa.removeMessages(1001);
    }

    private void j() {
        if (this.f32866z == null) {
            return;
        }
        try {
            gl.V("PPSPlacementView", "showLastFrame");
            this.A = false;
            this.f32866z.setVisibility(0);
            this.f32866z.setScaleType(ImageView.ScaleType.FIT_CENTER);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            addView(this.f32866z, layoutParams);
        } catch (Throwable unused) {
            gl.I("PPSPlacementView", "showLastFrame error.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.14
            @Override // java.lang.Runnable
            public void run() {
                if (PPSPlacementView.this.f32866z == null) {
                    return;
                }
                try {
                    gl.V("PPSPlacementView", "hide last frame.");
                    PPSPlacementView.this.f32866z.setVisibility(8);
                    PPSPlacementView pPSPlacementView = PPSPlacementView.this;
                    pPSPlacementView.removeView(pPSPlacementView.f32866z);
                    PPSPlacementView.this.f32866z = null;
                    PPSPlacementView.this.A = true;
                } catch (Throwable unused) {
                    gl.I("PPSPlacementView", "hideLastFrame error.");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        String str;
        if (!n()) {
            gl.I("PPSPlacementView", "audio focus is not needed");
            return;
        }
        try {
            gl.V("PPSPlacementView", "requestAudioFocus");
            if (Build.VERSION.SDK_INT < 26) {
                this.R.requestAudioFocus(this.f32842ad, 3, 2);
            } else {
                AudioFocusRequest build = new AudioFocusRequest.Builder(2).setOnAudioFocusChangeListener(this.f32842ad).build();
                this.T = build;
                this.R.requestAudioFocus(build);
            }
        } catch (IllegalStateException unused) {
            str = "requestAudioFocus IllegalStateException";
            gl.I("PPSPlacementView", str);
        } catch (Exception e2) {
            str = "requestAudioFocus " + e2.getClass().getSimpleName();
            gl.I("PPSPlacementView", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        String str;
        try {
            try {
                gl.V("PPSPlacementView", "abandonAudioFocus");
                if (Build.VERSION.SDK_INT < 26) {
                    this.R.abandonAudioFocus(this.f32842ad);
                } else {
                    Object obj = this.T;
                    if (obj instanceof AudioFocusRequest) {
                        this.R.abandonAudioFocusRequest((AudioFocusRequest) obj);
                    }
                    this.T = null;
                }
            } catch (IllegalStateException unused) {
                str = "abandonAudioFocus IllegalStateException";
                gl.I("PPSPlacementView", str);
            } catch (Exception e2) {
                str = "abandonAudioFocus " + e2.getClass().getSimpleName();
                gl.I("PPSPlacementView", str);
            }
        } finally {
            this.Q = false;
            this.P = 0;
        }
    }

    private boolean n() {
        gl.V("PPSPlacementView", "isNeedAudioFocus type: %s soundMute: %s", Integer.valueOf(this.f32865x), Boolean.valueOf(this.f32859r));
        int i10 = this.f32865x;
        if (i10 == 0) {
            return true;
        }
        if (i10 == 2) {
            return false;
        }
        return (i10 == 1 && this.f32859r) ? false : true;
    }

    public void C() {
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.6
            @Override // java.lang.Runnable
            public void run() {
                gl.V("PPSPlacementView", "muteSound");
                boolean z10 = true;
                PPSPlacementView.this.f32859r = true;
                if (PPSPlacementView.this.f32865x == 1) {
                    PPSPlacementView.this.m();
                }
                boolean z11 = false;
                if (PPSPlacementView.this.f32849h != null) {
                    PPSPlacementView.this.f32849h.I();
                    z11 = true;
                }
                if (PPSPlacementView.this.f32850i != null) {
                    PPSPlacementView.this.f32850i.I();
                    z11 = true;
                }
                if (PPSPlacementView.this.f32851j != null) {
                    PPSPlacementView.this.f32851j.I();
                } else {
                    z10 = z11;
                }
                if (z10) {
                    PPSPlacementView.this.F.Code(PPSPlacementView.this.f32859r);
                }
            }
        });
    }

    @Override // com.huawei.hms.ads.gz
    public void Code() {
        gl.V("PPSPlacementView", "onMute");
        this.f32859r = true;
    }

    @Override // com.huawei.hms.ads.hh
    public void Code(long j10, int i10) {
        I(this.f32862u, i10);
    }

    public void Code(gz gzVar) {
        if (gzVar == null) {
            return;
        }
        PlacementMediaView placementMediaView = this.f32849h;
        if (placementMediaView != null) {
            placementMediaView.Code(gzVar);
        } else {
            this.f32853l = gzVar;
        }
    }

    public void Code(ls lsVar) {
        if (lsVar == null) {
            return;
        }
        this.f32856o = lsVar;
    }

    public void Code(lt ltVar) {
        if (ltVar == null) {
            return;
        }
        this.f32855n = ltVar;
    }

    public void Code(Integer num) {
        Code(Long.valueOf(System.currentTimeMillis() - this.D.Z()), Integer.valueOf(this.D.I()), num);
    }

    @Override // com.huawei.hms.ads.hb
    public void Code(String str, String str2, int i10) {
        gl.V("PPSPlacementView", "onSegmentMediaStart, contentId: %s, url: %s", str, bc.Code(str2));
        this.f32860s = true;
        this.f32861t = i10;
        PlacementMediaView placementMediaView = this.f32858q;
        if (placementMediaView != null) {
            placementMediaView.setAlpha(1.0f);
        }
        if (this.f32855n != null && this.f32844c == 0) {
            gl.V("PPSPlacementView", "need notify media start.");
            this.E = true;
        }
        if (this.f32856o == null || this.f32858q == null) {
            return;
        }
        gl.V("PPSPlacementView", "mediaChange callback.");
        this.f32856o.Code(this.f32858q.getPlacementAd());
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008e  */
    @Override // com.huawei.hms.ads.hb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void Code(java.lang.String r12, java.lang.String r13, int r14, int r15) {
        /*
            r11 = this;
            com.huawei.openalliance.ad.media.c r14 = r11.getCurrentMediaState()
            java.lang.String r0 = "PPSPlacementView"
            if (r14 == 0) goto L16
            com.huawei.openalliance.ad.media.e r1 = com.huawei.openalliance.ad.media.e.PLAYING
            boolean r14 = r14.V(r1)
            if (r14 == 0) goto L16
            java.lang.String r12 = "progress callback on nonPlaying state."
            com.huawei.hms.ads.gl.I(r0, r12)
            return
        L16:
            java.lang.String r14 = r11.getCurrentContentId()
            if (r12 == 0) goto L23
            boolean r14 = r12.equalsIgnoreCase(r14)
            if (r14 != 0) goto L23
            return
        L23:
            long r7 = r11.getCurrentAdDuration()
            boolean r14 = r11.f32860s
            r9 = 0
            r10 = 1
            if (r14 != 0) goto L36
            int r1 = r11.f32861t
            if (r1 >= 0) goto L36
            r11.f32861t = r15
            r11.f32860s = r10
            goto L66
        L36:
            if (r14 == 0) goto L66
            int r14 = r11.f32861t
            if (r14 < 0) goto L66
            int r14 = r15 - r14
            r11.f32862u = r14
            long r1 = (long) r14
            com.huawei.hms.ads.hi r14 = r11.D
            int r14 = r14.I()
            r11.I(r1, r14)
            int r14 = r11.f32862u
            long r1 = (long) r14
            long r3 = r11.getCurrentAdDuration()
            int r14 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r14 < 0) goto L57
            r14 = 1
            goto L58
        L57:
            r14 = 0
        L58:
            com.huawei.hms.ads.kl r1 = r11.F
            if (r1 == 0) goto L67
            android.content.Context r2 = r11.getContext()
            long r3 = (long) r15
            r5 = r7
            r1.Code(r2, r3, r5)
            goto L67
        L66:
            r14 = 0
        L67:
            com.huawei.hms.ads.lt r1 = r11.f32855n
            if (r1 != 0) goto L71
            boolean r1 = r11.f32860s
            if (r1 != 0) goto L71
            if (r15 <= 0) goto L91
        L71:
            long r1 = (long) r15
            int r3 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r3 <= 0) goto L7d
            r1 = 0
            int r3 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r3 <= 0) goto L7d
            int r15 = (int) r7
        L7d:
            int r1 = r11.getCurrentPlayTime()
            int r1 = r1 + r15
            int[] r2 = r11.f32857p
            int r3 = r2.length
            int r3 = r3 - r10
            r2 = r2[r3]
            int r2 = r1 / r2
            com.huawei.hms.ads.lt r3 = r11.f32855n
            if (r3 == 0) goto L91
            r3.Code(r2, r1)
        L91:
            if (r15 <= 0) goto L9a
            boolean r1 = r11.A
            if (r1 != 0) goto L9a
            r11.k()
        L9a:
            if (r15 <= 0) goto Lb0
            boolean r1 = r11.E
            if (r1 == 0) goto Lb0
            com.huawei.hms.ads.lt r1 = r11.f32855n
            if (r1 == 0) goto Lb0
            r11.E = r9
            r11.G = r10
            int r2 = r11.f32861t
            r1.Code(r2)
            r11.l()
        Lb0:
            if (r14 == 0) goto Lc6
            java.lang.String r14 = "time countdown finish, manual stop."
            com.huawei.hms.ads.gl.V(r0, r14)
            com.huawei.openalliance.ad.views.PlacementMediaView r14 = r11.f32858q
            r14.S()
            com.huawei.hms.ads.hb r14 = r11.f32840ab
            if (r14 == 0) goto Lc3
            r14.Z(r12, r13, r15)
        Lc3:
            r11.Z(r12, r13, r15)
        Lc6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.views.PPSPlacementView.Code(java.lang.String, java.lang.String, int, int):void");
    }

    @Override // com.huawei.hms.ads.hb
    public void Code(String str, String str2, int i10, int i11, int i12) {
        PlacementMediaView placementMediaView;
        r S;
        gl.V("PPSPlacementView", "onSegmentMediaError, contentId: %s, url: %s", str, bc.Code(str2));
        String currentContentId = getCurrentContentId();
        if (str != null && !str.equalsIgnoreCase(currentContentId)) {
            gl.V("PPSPlacementView", "onError, contentId not match, currentConentId: %s", currentContentId);
            return;
        }
        k();
        i();
        gl.I("PPSPlacementView", "onSegmentMediaError:" + bc.Code(str2) + ", playTime:" + i10 + ",errorCode:" + i11 + ",extra:" + i12);
        Code(i10);
        if (this.f32855n != null) {
            int currentPlayTime = getCurrentPlayTime() + i10;
            gl.V("PPSPlacementView", "mediaError callback, playedTime: %s", Integer.valueOf(currentPlayTime));
            this.f32855n.Code(currentPlayTime, i11, i12);
        }
        if (!this.G) {
            gl.V("PPSPlacementView", "error before start callback.");
            this.E = true;
        }
        this.D.c();
        this.f32858q.Code(i10);
        p currentAd = getCurrentAd();
        if (currentAd != null && (S = currentAd.S()) != null) {
            this.F.Code(S.Z(), i11, i12, currentAd);
        }
        boolean f10 = f();
        V(f10);
        if (this.f32855n == null || !f10 || this.f32857p.length <= 0) {
            return;
        }
        gl.V("PPSPlacementView", "last ad play error");
        lt ltVar = this.f32855n;
        int[] iArr = this.f32857p;
        ltVar.Z(iArr[iArr.length - 1]);
        if (!this.U.V(bj.a.SINGLE_INST) || (placementMediaView = this.f32851j) == null) {
            return;
        }
        placementMediaView.V();
    }

    public void Code(final List<com.huawei.openalliance.ad.inter.data.h> list) {
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.17
            @Override // java.lang.Runnable
            public void run() {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("register:");
                List list2 = list;
                sb2.append(list2 == null ? 0 : list2.size());
                gl.V("PPSPlacementView", sb2.toString());
                PPSPlacementView.this.I((List<com.huawei.openalliance.ad.inter.data.h>) list);
                if (aa.Code(list) || aa.Code(PPSPlacementView.this.L)) {
                    return;
                }
                PPSPlacementView.this.f32844c = 0;
                PPSPlacementView pPSPlacementView = PPSPlacementView.this;
                pPSPlacementView.f32838a = pPSPlacementView.getCurrentAd();
                PPSPlacementView pPSPlacementView2 = PPSPlacementView.this;
                pPSPlacementView2.f32843b = pPSPlacementView2.getNextAd();
                PPSPlacementView.this.a();
                PPSPlacementView.this.e();
                PlacementMediaView placementMediaView = PPSPlacementView.this.U.V(bj.a.SINGLE_INST) ? PPSPlacementView.this.f32851j : PPSPlacementView.this.f32849h;
                PPSPlacementView.this.b();
                PPSPlacementView.this.Code(placementMediaView);
                if (PPSPlacementView.this.f32864w) {
                    PPSPlacementView.this.L();
                }
            }
        });
    }

    public void D() {
        this.f32855n = null;
    }

    public void F() {
        this.f32856o = null;
    }

    @Override // com.huawei.hms.ads.hh
    public void I() {
        this.f32864w = true;
        this.f32847f = false;
        this.f32848g = false;
        long Code = v.Code();
        this.N = Code;
        gl.Code("PPSPlacementView", "onViewPhysicalShowStart: %s", Long.valueOf(Code));
        p currentAd = getCurrentAd();
        if (currentAd != null) {
            currentAd.Z(false);
        }
        b();
        if (this.f32838a != null) {
            L();
            (this.U.V(bj.a.SINGLE_INST) ? this.I : this.U.V(bj.a.MAIN_VIEW) ? this.Code : this.V).L();
        }
    }

    @Override // com.huawei.hms.ads.hb
    public void I(String str, String str2, int i10) {
        gl.V("PPSPlacementView", "onSegmentMediaStop, contentId: %s, url: %s", str, bc.Code(str2));
        if (str != null && str.equalsIgnoreCase(getCurrentContentId())) {
            Code(i10);
        }
        if (this.f32855n != null && str.equalsIgnoreCase(getCurrentContentId())) {
            int currentPlayTime = getCurrentPlayTime() + i10;
            gl.V("PPSPlacementView", "mediaStop callback, playedTime: %s", Integer.valueOf(currentPlayTime));
            this.f32855n.I(currentPlayTime);
        } else {
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(this.f32855n == null);
            objArr[1] = getCurrentContentId();
            gl.V("PPSPlacementView", "skip mediaStop callback, listener null ? %s, currentContentId: %s", objArr);
        }
    }

    public void S() {
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.8
            @Override // java.lang.Runnable
            public void run() {
                gl.V("PPSPlacementView", "unmuteSound");
                boolean z10 = false;
                PPSPlacementView.this.f32859r = false;
                boolean z11 = true;
                if (PPSPlacementView.this.f32865x == 1) {
                    PPSPlacementView.this.l();
                }
                if (PPSPlacementView.this.f32849h != null) {
                    PPSPlacementView.this.f32849h.B();
                    z10 = true;
                }
                if (PPSPlacementView.this.f32850i != null) {
                    PPSPlacementView.this.f32850i.B();
                    z10 = true;
                }
                if (PPSPlacementView.this.f32851j != null) {
                    PPSPlacementView.this.f32851j.B();
                } else {
                    z11 = z10;
                }
                if (z11) {
                    PPSPlacementView.this.F.Code(PPSPlacementView.this.f32859r);
                }
            }
        });
    }

    @Override // com.huawei.hms.ads.gz
    public void V() {
        gl.V("PPSPlacementView", "onUnmute");
        this.f32859r = false;
    }

    @Override // com.huawei.hms.ads.hh
    public void V(long j10, int i10) {
        if (!this.f32848g) {
            this.f32848g = true;
            this.F.Code(j10, i10);
        }
        this.f32864w = false;
        this.f32863v = false;
    }

    public void V(gz gzVar) {
        if (gzVar == null) {
            return;
        }
        PlacementMediaView placementMediaView = this.f32849h;
        if (placementMediaView != null) {
            placementMediaView.V(gzVar);
        } else {
            this.f32853l = null;
        }
    }

    @Override // com.huawei.hms.ads.hb
    public void V(String str, String str2, int i10) {
        gl.V("PPSPlacementView", "onSegmentMediaPause:" + bc.Code(str2));
        if (str != null && str.equalsIgnoreCase(getCurrentContentId())) {
            Code(i10);
        }
        if (this.f32855n != null) {
            int currentPlayTime = getCurrentPlayTime() + i10;
            gl.V("PPSPlacementView", "mediaPause callback, playedTime: %s", Integer.valueOf(currentPlayTime));
            this.f32855n.V(currentPlayTime);
        }
    }

    public void V(List<View> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (View view : list) {
            if (view instanceof PlacementVideoView) {
                ((PlacementVideoView) view).setOnClickListener(this.f32841ac);
            } else {
                view.setOnClickListener(this.f32841ac);
            }
        }
    }

    @Override // com.huawei.hms.ads.hb
    public void Z(String str, String str2, int i10) {
        PlacementMediaView placementMediaView;
        String currentContentId = getCurrentContentId();
        if (str != null && !str.equalsIgnoreCase(currentContentId)) {
            gl.V("PPSPlacementView", "onCompletion, %s not match current contentId: %s.", str, currentContentId);
            return;
        }
        boolean f10 = f();
        if (!f10) {
            PlacementMediaView placementMediaView2 = this.f32858q;
            if (placementMediaView2 instanceof PlacementVideoView) {
                this.f32866z = placementMediaView2.getLastFrame();
                j();
            }
        }
        i();
        gl.V("PPSPlacementView", "onSegmentMediaCompletion, contentId: %s, url: %s", str, bc.Code(str2));
        Code(i10);
        this.D.c();
        this.f32858q.Code(i10);
        V(f10);
        if (this.f32855n != null && f10) {
            int currentPlayTime = getCurrentPlayTime() + i10;
            gl.V("PPSPlacementView", "mediaCompletion callback, playedTime: %s", Integer.valueOf(currentPlayTime));
            this.f32855n.Z(currentPlayTime);
            if (this.U.V(bj.a.SINGLE_INST) && (placementMediaView = this.f32851j) != null) {
                placementMediaView.V();
            }
        }
        kl klVar = this.F;
        if (klVar != null) {
            long j10 = i10;
            klVar.Code(getContext(), j10, j10);
        }
    }

    @Override // com.huawei.hms.ads.hh
    public void a_() {
        this.f32861t = -1;
        this.f32860s = false;
    }

    @Override // com.huawei.hms.ads.lz
    public void destroyView() {
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.11
            @Override // java.lang.Runnable
            public void run() {
                gl.V("PPSPlacementView", "destroyView");
                if (PPSPlacementView.this.f32858q != null) {
                    PPSPlacementView.this.f32858q.S();
                    PPSPlacementView.this.f32858q.destroyView();
                }
                PPSPlacementView.this.F();
                PPSPlacementView.this.D();
                PPSPlacementView.this.i();
                PPSPlacementView.this.Code.I();
                PPSPlacementView.this.V.I();
                PPSPlacementView.this.I.I();
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            if (lf.Code(motionEvent) == 0) {
                this.J = lf.Code(this, motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        } catch (Throwable th) {
            gl.I("PPSPlacementView", "dispatchTouchEvent exception : %s", th.getClass().getSimpleName());
            return false;
        }
    }

    public void hideAdvertiserInfoDialog() {
        com.huawei.openalliance.ad.msgnotify.b.Code(getContext(), bf.B, new Intent(com.huawei.openalliance.ad.activity.a.I));
    }

    public boolean isPlaying() {
        PlacementMediaView placementMediaView = this.f32858q;
        if (placementMediaView != null) {
            return placementMediaView.F();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        gl.Code("PPSPlacementView", "onAttachedToWindow");
        this.D.D();
        ks.Code(getContext()).V(getContext());
    }

    public void onClose() {
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.2
            @Override // java.lang.Runnable
            public void run() {
                gl.V("PPSPlacementView", "onClose");
                PPSPlacementView.this.F.Code();
                (PPSPlacementView.this.U.V(bj.a.SINGLE_INST) ? PPSPlacementView.this.I : PPSPlacementView.this.U.V(bj.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).d();
                PPSPlacementView.this.Code.I();
                PPSPlacementView.this.V.I();
                PPSPlacementView.this.I.I();
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        gl.V("PPSPlacementView", "onDetechedFromWindow");
        this.D.L();
        this.Code.I();
        this.V.I();
        this.I.I();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        this.D.a();
    }

    public void pause() {
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.4
            @Override // java.lang.Runnable
            public void run() {
                gl.V("PPSPlacementView", "pause");
                if (PPSPlacementView.this.f32858q != null) {
                    PPSPlacementView.this.f32858q.C();
                }
            }
        });
    }

    @Override // com.huawei.hms.ads.lz
    public void pauseView() {
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.10
            @Override // java.lang.Runnable
            public void run() {
                gl.V("PPSPlacementView", "pauseView");
                if (PPSPlacementView.this.f32858q != null) {
                    PPSPlacementView.this.f32858q.pauseView();
                    PPSPlacementView.this.f32858q.C();
                    PPSPlacementView.this.i();
                }
            }
        });
    }

    @Override // com.huawei.hms.ads.lz
    public void resumeView() {
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.9
            @Override // java.lang.Runnable
            public void run() {
                gl.V("PPSPlacementView", "resumeView");
                if (PPSPlacementView.this.f32858q != null) {
                    PPSPlacementView.this.f32858q.resumeView();
                    PPSPlacementView.this.f32858q.Code(true, PPSPlacementView.this.f32859r);
                    PPSPlacementView pPSPlacementView = PPSPlacementView.this;
                    pPSPlacementView.Code(pPSPlacementView.getCurrentAdDuration() * 2);
                }
            }
        });
    }

    public void setAudioFocusType(int i10) {
        this.f32865x = i10;
    }

    public void setMediaPlayerReleaseListener(gx gxVar) {
        if (gxVar == null) {
            return;
        }
        this.O = gxVar;
    }

    public void setOnPlacementAdClickListener(a aVar) {
        this.f32845d = aVar;
    }

    public void setOverlays(List<View> list) {
        this.K = list;
    }

    public void setSoundVolume(final float f10) {
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.7
            @Override // java.lang.Runnable
            public void run() {
                gl.V("PPSPlacementView", "set sound volume: %s", Float.valueOf(f10));
                if (PPSPlacementView.this.f32858q != null) {
                    PPSPlacementView.this.f32858q.setSoundVolume(f10);
                    (PPSPlacementView.this.U.V(bj.a.SINGLE_INST) ? PPSPlacementView.this.I : PPSPlacementView.this.U.V(bj.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V).V(f10);
                }
            }
        });
    }

    public void showAdvertiserInfoDialog(View view, boolean z10) {
        if (view == null) {
            gl.I("PPSPlacementView", "anchorView is null");
        }
        try {
            p currentAd = getCurrentAd();
            if (currentAd == null) {
                gl.I("PPSPlacementView", TanxError.ERROR_ADINFO_NULL);
                return;
            }
            AdContentData l10 = currentAd.l();
            if (aa.Code(l10.aG())) {
                gl.I("PPSPlacementView", "advertiser Info is null");
            } else {
                ComplianceActivity.Code(getContext(), view, l10, z10);
            }
        } catch (Throwable th) {
            gl.I("PPSPlacementView", "showAdvertiserInfoDialog has exception %s", th.getClass().getSimpleName());
        }
    }

    public void stop() {
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.5
            @Override // java.lang.Runnable
            public void run() {
                gl.V("PPSPlacementView", "stop");
                if (PPSPlacementView.this.f32858q != null) {
                    PPSPlacementView.this.f32858q.S();
                }
            }
        });
    }
}
