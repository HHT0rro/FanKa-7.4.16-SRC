package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.ea;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.gu;
import com.huawei.hms.ads.gv;
import com.huawei.hms.ads.gy;
import com.huawei.hms.ads.gz;
import com.huawei.hms.ads.ha;
import com.huawei.hms.ads.io;
import com.huawei.hms.ads.jx;
import com.huawei.hms.ads.kj;
import com.huawei.hms.ads.lp;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.beans.metadata.VideoInfo;
import com.huawei.openalliance.ad.constant.ad;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.v;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PPSVideoView extends PPSBaseView<kj> implements lp {
    private gv A;
    private final gu E;
    private gz G;

    /* renamed from: b, reason: collision with root package name */
    private VideoView f32919b;

    /* renamed from: c, reason: collision with root package name */
    private ImageView f32920c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f32921d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f32922e;

    /* renamed from: f, reason: collision with root package name */
    private VideoInfo f32923f;

    /* renamed from: g, reason: collision with root package name */
    private int f32924g;

    /* renamed from: h, reason: collision with root package name */
    private int f32925h;

    /* renamed from: i, reason: collision with root package name */
    private long f32926i;

    /* renamed from: j, reason: collision with root package name */
    private long f32927j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f32928k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f32929l;

    /* renamed from: m, reason: collision with root package name */
    private int f32930m;

    /* renamed from: n, reason: collision with root package name */
    private int f32931n;

    /* renamed from: o, reason: collision with root package name */
    private int f32932o;

    /* renamed from: p, reason: collision with root package name */
    private int f32933p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f32934q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f32935r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f32936s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f32937t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f32938u;

    /* renamed from: v, reason: collision with root package name */
    private float f32939v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f32940w;

    /* renamed from: x, reason: collision with root package name */
    private View.OnClickListener f32941x;

    /* renamed from: y, reason: collision with root package name */
    private ha f32942y;

    /* renamed from: z, reason: collision with root package name */
    private gy f32943z;

    public PPSVideoView(Context context, int i10, int i11, int i12, int i13) {
        super(context);
        this.f32921d = true;
        this.f32922e = true;
        this.f32924g = 0;
        this.f32925h = Integer.MAX_VALUE;
        this.f32928k = false;
        this.f32929l = false;
        this.f32930m = 1;
        this.f32934q = false;
        this.f32935r = false;
        this.f32936s = false;
        this.f32937t = true;
        this.f32938u = false;
        this.f32939v = 0.0f;
        this.f32940w = false;
        this.f32941x = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PPSVideoView.this.Code(!view.isSelected());
            }
        };
        this.f32942y = new ha() { // from class: com.huawei.openalliance.ad.views.PPSVideoView.2
            @Override // com.huawei.hms.ads.ha
            public void Code() {
                gl.Code("PPSVideoView", "onVideoRenderStart, alreadyNotified: %s", Boolean.valueOf(PPSVideoView.this.f32934q));
                if (PPSVideoView.this.f32934q) {
                    return;
                }
                PPSVideoView.this.f32934q = true;
                if (PPSVideoView.this.f32919b != null) {
                    PPSVideoView.this.f32919b.setAlpha(1.0f);
                }
                PPSVideoView.this.Z();
                if (PPSVideoView.this.f32936s) {
                    PPSVideoView.this.f32922e = false;
                }
                PPSVideoView.this.c();
            }
        };
        this.f32943z = new gy() { // from class: com.huawei.openalliance.ad.views.PPSVideoView.3
            private void Code(int i14) {
                if (PPSVideoView.this.f32929l) {
                    gl.V("PPSVideoView", "has reported play end event");
                    return;
                }
                PPSVideoView.this.f32929l = true;
                PPSVideoView pPSVideoView = PPSVideoView.this;
                ((kj) pPSVideoView.B).Code(pPSVideoView.f32926i, v.Code(), PPSVideoView.this.f32927j, i14);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void Code(int i14, boolean z10) {
                if (PPSVideoView.this.f32928k) {
                    PPSVideoView.this.f32928k = false;
                    Code(i14);
                    ((kj) PPSVideoView.this.B).V();
                    io ioVar = PPSVideoView.this.C;
                    if (z10) {
                        ioVar.a();
                    } else {
                        ioVar.e();
                    }
                }
            }

            @Override // com.huawei.hms.ads.gy
            public void Code(int i14, int i15) {
                gl.Code("PPSVideoView", "onProgress, playTime: %d, alreadyNotified: %s", Integer.valueOf(i15), Boolean.valueOf(PPSVideoView.this.f32934q));
                if (i15 > 0 && !PPSVideoView.this.f32934q) {
                    PPSVideoView.this.f32934q = true;
                    if (PPSVideoView.this.f32919b != null) {
                        PPSVideoView.this.f32919b.setAlpha(1.0f);
                    }
                    PPSVideoView.this.Z();
                    PPSVideoView.this.c();
                }
                if (PPSVideoView.this.f32919b != null && PPSVideoView.this.f32919b.getCurrentState().Code() && PPSVideoView.this.f32924g > 0) {
                    int i16 = PPSVideoView.this.f32924g - i15;
                    if (i16 < 0) {
                        i16 = 0;
                    }
                    int max = Math.max(1, (int) Math.ceil((i16 * 1.0f) / 1000.0f));
                    gl.Code("PPSVideoView", "left seconds: %d", Integer.valueOf(max));
                    if (max < PPSVideoView.this.f32925h) {
                        PPSVideoView.this.f32925h = max;
                        PPSVideoView.this.I(max);
                    }
                }
                if (PPSVideoView.this.f32928k) {
                    PPSVideoView.this.C.Code(i14);
                    PPSVideoView pPSVideoView = PPSVideoView.this;
                    P p10 = pPSVideoView.B;
                    if (p10 != 0) {
                        ((kj) p10).Code(pPSVideoView.getContext(), i15, PPSVideoView.this.f32924g);
                    }
                }
            }

            @Override // com.huawei.hms.ads.gy
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i14) {
                if (PPSVideoView.this.f32928k) {
                    return;
                }
                PPSVideoView.this.d();
                PPSVideoView.this.f32928k = true;
                PPSVideoView.this.f32927j = i14;
                PPSVideoView.this.f32926i = v.Code();
                PPSVideoView pPSVideoView = PPSVideoView.this;
                if (i14 > 0) {
                    pPSVideoView.C.f();
                } else if (pPSVideoView.f32923f != null) {
                    PPSVideoView.this.C.Code(r3.f32923f.I(), PPSVideoView.this.f32921d);
                }
                PPSVideoView pPSVideoView2 = PPSVideoView.this;
                ((kj) pPSVideoView2.B).Code(pPSVideoView2.f32926i);
                PPSVideoView pPSVideoView3 = PPSVideoView.this;
                pPSVideoView3.D.Code(pPSVideoView3.f32926i);
                ((kj) PPSVideoView.this.B).C();
            }

            @Override // com.huawei.hms.ads.gy
            public void I(com.huawei.openalliance.ad.media.b bVar, int i14) {
                Code(i14, false);
            }

            @Override // com.huawei.hms.ads.gy
            public void V(com.huawei.openalliance.ad.media.b bVar, final int i14) {
                ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSVideoView.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Code(i14, false);
                    }
                }, 1000L);
            }

            @Override // com.huawei.hms.ads.gy
            public void Z(com.huawei.openalliance.ad.media.b bVar, int i14) {
                Code(i14, true);
                PPSVideoView pPSVideoView = PPSVideoView.this;
                P p10 = pPSVideoView.B;
                if (p10 != 0) {
                    long j10 = i14;
                    ((kj) p10).Code(pPSVideoView.getContext(), j10, j10);
                }
            }
        };
        this.A = new gv() { // from class: com.huawei.openalliance.ad.views.PPSVideoView.4
            @Override // com.huawei.hms.ads.gv
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i14, int i15, int i16) {
                PPSVideoView.this.V(ad.Z);
                PPSVideoView.this.Code();
            }
        };
        this.E = new gu() { // from class: com.huawei.openalliance.ad.views.PPSVideoView.5
            @Override // com.huawei.hms.ads.gu
            public void Code() {
                PPSVideoView.this.C.b();
            }

            @Override // com.huawei.hms.ads.gu
            public void Code(int i14) {
            }

            @Override // com.huawei.hms.ads.gu
            public void V() {
                PPSVideoView.this.C.c();
            }
        };
        this.G = new gz() { // from class: com.huawei.openalliance.ad.views.PPSVideoView.6
            @Override // com.huawei.hms.ads.gz
            public void Code() {
                PPSVideoView.this.setMuteButtonState(true);
                PPSVideoView.this.C.V(0.0f);
            }

            @Override // com.huawei.hms.ads.gz
            public void V() {
                PPSVideoView.this.setMuteButtonState(false);
                PPSVideoView.this.C.V(1.0f);
            }
        };
        this.f32932o = i11;
        this.f32931n = i10;
        this.f32933p = i12;
        this.f32935r = ea.Code(context).B();
        this.B = new jx(context, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(boolean z10) {
        gl.V("PPSVideoView", "switchSound enableSound: " + z10);
        VideoView videoView = this.f32919b;
        if (videoView == null) {
            return;
        }
        if (z10) {
            videoView.c();
        } else {
            videoView.b();
        }
        ((kj) this.B).Code(!z10);
    }

    private void b() {
        if (this.f32919b == null) {
            VideoView videoView = new VideoView(getContext());
            this.f32919b = videoView;
            videoView.setScreenOnWhilePlaying(true);
            this.f32919b.setStandalone(true);
            this.f32919b.setAutoScaleResizeLayoutOnVideoSizeChange(false);
            this.f32919b.setVideoScaleMode(2);
            this.f32919b.setMuteOnlyOnLostAudioFocus(true);
            this.f32919b.Code(this.f32942y);
            this.f32919b.Code(this.f32943z);
            this.f32919b.Code(this.A);
            this.f32919b.Code(this.G);
            this.f32919b.Code(this.E);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            addView(this.f32919b, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00bd, code lost:
    
        if (com.huawei.openalliance.ad.utils.l.S(getContext()) != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00e9, code lost:
    
        if (r6.S.D() != 1) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c() {
        /*
            Method dump skipped, instructions count: 271
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.views.PPSVideoView.c():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.f32937t || !this.f32938u) {
            return;
        }
        float f10 = this.f32939v;
        if (f10 > 0.0f) {
            this.f32919b.setSoundVolume(f10);
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseView, com.huawei.hms.ads.lq
    public boolean C() {
        return this.f32924g > 0;
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseView, com.huawei.hms.ads.lq
    public void Code(int i10, int i11) {
        super.Code(i10, i11);
        VideoView videoView = this.f32919b;
        if (videoView != null) {
            videoView.D();
        }
    }

    @Override // com.huawei.hms.ads.lp
    public void Code(String str) {
        VideoInfo p10 = this.S.p();
        this.f32923f = p10;
        if (p10 != null) {
            if (TextUtils.equals("n", p10.e()) || this.f32936s) {
                this.f32922e = false;
            }
            this.f32924g = this.f32923f.I();
            this.f32938u = TextUtils.equals("y", this.f32923f.C());
        }
        MetaData Z = this.S.Z();
        if (Z != null && Z.h() > 0) {
            this.f32924g = (int) Z.h();
        }
        b();
        this.f32919b.setAudioFocusType(this.f32930m);
        this.f32919b.setAlpha(0.0f);
        this.f32919b.setVideoFileUrl(str);
        if (this.f32937t || !this.f32938u) {
            this.f32919b.b();
        } else {
            this.f32919b.c();
        }
        this.f32919b.Code(true);
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseView, com.huawei.hms.ads.lq
    public void D() {
        super.D();
        VideoView videoView = this.f32919b;
        if (videoView != null) {
            videoView.D();
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseView, com.huawei.hms.ads.lq
    public void F() {
        super.F();
        VideoView videoView = this.f32919b;
        if (videoView != null) {
            videoView.D();
        }
    }

    public void L() {
        gl.V("PPSVideoView", "unMuteCustomized");
        this.f32940w = true;
        VideoView videoView = this.f32919b;
        if (videoView != null) {
            float f10 = this.f32939v;
            if (f10 > 0.0f) {
                videoView.Code(f10);
            }
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseView
    public void S() {
        pauseView();
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        VideoView videoView = this.f32919b;
        if (videoView != null) {
            removeView(videoView);
            this.f32919b.destroyView();
            this.f32919b = null;
        }
        this.f32925h = Integer.MAX_VALUE;
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseView, com.huawei.hms.ads.lz
    public void pauseView() {
        VideoView videoView = this.f32919b;
        if (videoView != null) {
            videoView.pauseView();
            this.f32919b.L();
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseView, com.huawei.hms.ads.lq
    public void setAudioFocusType(int i10) {
        this.f32930m = i10;
        VideoView videoView = this.f32919b;
        if (videoView != null) {
            videoView.setAudioFocusType(i10);
        }
    }

    public void setHideSoundIcon(boolean z10) {
        this.f32936s = z10;
    }

    public void setIgnoreSoundCtrl(boolean z10) {
        this.f32937t = z10;
    }

    public void setMuteButtonState(boolean z10) {
        this.f32921d = z10;
        if (this.f32920c != null) {
            this.f32920c.setImageResource(ay.Code(z10));
            this.f32920c.setSelected(!z10);
            ay.Code(this.f32920c);
        }
    }

    public void setStartVol(float f10) {
        this.f32939v = f10;
    }
}
