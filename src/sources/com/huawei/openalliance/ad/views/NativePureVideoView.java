package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.gu;
import com.huawei.hms.ads.gv;
import com.huawei.hms.ads.gy;
import com.huawei.hms.ads.gz;
import com.huawei.hms.ads.hk;
import com.huawei.hms.ads.jt;
import com.huawei.hms.ads.kg;
import com.huawei.hms.ads.lh;
import com.huawei.hms.ads.lm;
import com.huawei.hms.ads.lz;
import com.huawei.hms.ads.nativead.R;
import com.huawei.openalliance.ad.inter.data.k;
import com.huawei.openalliance.ad.inter.data.n;
import com.huawei.openalliance.ad.inter.data.v;
import com.huawei.openalliance.ad.utils.au;
import com.huawei.openalliance.ad.utils.bd;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class NativePureVideoView extends NativeMediaView implements lh, lz {
    private static final String S = NativePureVideoView.class.getSimpleName();
    private VideoView D;
    private kg F;
    private ImageView L;

    /* renamed from: a, reason: collision with root package name */
    private boolean f32663a;

    /* renamed from: b, reason: collision with root package name */
    private v f32664b;

    /* renamed from: c, reason: collision with root package name */
    private k f32665c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f32666d;

    /* renamed from: e, reason: collision with root package name */
    private long f32667e;

    /* renamed from: f, reason: collision with root package name */
    private long f32668f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f32669g;

    /* renamed from: h, reason: collision with root package name */
    private lm f32670h;

    /* renamed from: i, reason: collision with root package name */
    private hk f32671i;

    /* renamed from: j, reason: collision with root package name */
    private gu f32672j;

    /* renamed from: k, reason: collision with root package name */
    private gy f32673k;

    /* renamed from: l, reason: collision with root package name */
    private gv f32674l;

    /* renamed from: m, reason: collision with root package name */
    private gz f32675m;

    public NativePureVideoView(Context context) {
        super(context);
        this.f32669g = false;
        this.f32672j = new gu() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.1
            @Override // com.huawei.hms.ads.gu
            public void Code() {
                if (gl.Code()) {
                    gl.Code(NativePureVideoView.S, "onBufferingStart");
                }
                NativePureVideoView.this.f32671i.V();
            }

            @Override // com.huawei.hms.ads.gu
            public void Code(int i10) {
            }

            @Override // com.huawei.hms.ads.gu
            public void V() {
            }
        };
        this.f32673k = new gy() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.2
            @Override // com.huawei.hms.ads.gy
            public void Code(int i10, int i11) {
            }

            @Override // com.huawei.hms.ads.gy
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i10) {
                if (gl.Code()) {
                    gl.Code(NativePureVideoView.S, "onMediaStart: %s", Integer.valueOf(i10));
                }
                NativePureVideoView.this.f();
                if (NativePureVideoView.this.f32669g) {
                    return;
                }
                NativePureVideoView.this.f32669g = true;
                NativePureVideoView.this.f32668f = i10;
                NativePureVideoView.this.f32667e = System.currentTimeMillis();
                kg kgVar = NativePureVideoView.this.F;
                if (i10 > 0) {
                    kgVar.V();
                } else {
                    kgVar.Code();
                    NativePureVideoView.this.F.Code(NativePureVideoView.this.f32671i.B(), NativePureVideoView.this.f32671i.Z(), NativePureVideoView.this.f32667e);
                }
            }

            @Override // com.huawei.hms.ads.gy
            public void I(com.huawei.openalliance.ad.media.b bVar, int i10) {
                NativePureVideoView.this.e();
                NativePureVideoView.this.Code(i10, false);
            }

            @Override // com.huawei.hms.ads.gy
            public void V(com.huawei.openalliance.ad.media.b bVar, int i10) {
                NativePureVideoView.this.Code(i10, false);
            }

            @Override // com.huawei.hms.ads.gy
            public void Z(com.huawei.openalliance.ad.media.b bVar, int i10) {
                NativePureVideoView.this.e();
                NativePureVideoView.this.Code(i10, true);
            }
        };
        this.f32674l = new gv() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.3
            @Override // com.huawei.hms.ads.gv
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i10, int i11, int i12) {
                NativePureVideoView.this.e();
                NativePureVideoView.this.Code(i10, false);
            }
        };
        this.f32675m = new gz() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.4
            @Override // com.huawei.hms.ads.gz
            public void Code() {
                if (NativePureVideoView.this.f32664b != null) {
                    NativePureVideoView.this.f32664b.Code("n");
                }
            }

            @Override // com.huawei.hms.ads.gz
            public void V() {
                if (NativePureVideoView.this.f32664b != null) {
                    NativePureVideoView.this.f32664b.Code("y");
                }
            }
        };
        Code(context);
    }

    public NativePureVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f32669g = false;
        this.f32672j = new gu() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.1
            @Override // com.huawei.hms.ads.gu
            public void Code() {
                if (gl.Code()) {
                    gl.Code(NativePureVideoView.S, "onBufferingStart");
                }
                NativePureVideoView.this.f32671i.V();
            }

            @Override // com.huawei.hms.ads.gu
            public void Code(int i10) {
            }

            @Override // com.huawei.hms.ads.gu
            public void V() {
            }
        };
        this.f32673k = new gy() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.2
            @Override // com.huawei.hms.ads.gy
            public void Code(int i10, int i11) {
            }

            @Override // com.huawei.hms.ads.gy
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i10) {
                if (gl.Code()) {
                    gl.Code(NativePureVideoView.S, "onMediaStart: %s", Integer.valueOf(i10));
                }
                NativePureVideoView.this.f();
                if (NativePureVideoView.this.f32669g) {
                    return;
                }
                NativePureVideoView.this.f32669g = true;
                NativePureVideoView.this.f32668f = i10;
                NativePureVideoView.this.f32667e = System.currentTimeMillis();
                kg kgVar = NativePureVideoView.this.F;
                if (i10 > 0) {
                    kgVar.V();
                } else {
                    kgVar.Code();
                    NativePureVideoView.this.F.Code(NativePureVideoView.this.f32671i.B(), NativePureVideoView.this.f32671i.Z(), NativePureVideoView.this.f32667e);
                }
            }

            @Override // com.huawei.hms.ads.gy
            public void I(com.huawei.openalliance.ad.media.b bVar, int i10) {
                NativePureVideoView.this.e();
                NativePureVideoView.this.Code(i10, false);
            }

            @Override // com.huawei.hms.ads.gy
            public void V(com.huawei.openalliance.ad.media.b bVar, int i10) {
                NativePureVideoView.this.Code(i10, false);
            }

            @Override // com.huawei.hms.ads.gy
            public void Z(com.huawei.openalliance.ad.media.b bVar, int i10) {
                NativePureVideoView.this.e();
                NativePureVideoView.this.Code(i10, true);
            }
        };
        this.f32674l = new gv() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.3
            @Override // com.huawei.hms.ads.gv
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i10, int i11, int i12) {
                NativePureVideoView.this.e();
                NativePureVideoView.this.Code(i10, false);
            }
        };
        this.f32675m = new gz() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.4
            @Override // com.huawei.hms.ads.gz
            public void Code() {
                if (NativePureVideoView.this.f32664b != null) {
                    NativePureVideoView.this.f32664b.Code("n");
                }
            }

            @Override // com.huawei.hms.ads.gz
            public void V() {
                if (NativePureVideoView.this.f32664b != null) {
                    NativePureVideoView.this.f32664b.Code("y");
                }
            }
        };
        Code(context);
    }

    public NativePureVideoView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f32669g = false;
        this.f32672j = new gu() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.1
            @Override // com.huawei.hms.ads.gu
            public void Code() {
                if (gl.Code()) {
                    gl.Code(NativePureVideoView.S, "onBufferingStart");
                }
                NativePureVideoView.this.f32671i.V();
            }

            @Override // com.huawei.hms.ads.gu
            public void Code(int i102) {
            }

            @Override // com.huawei.hms.ads.gu
            public void V() {
            }
        };
        this.f32673k = new gy() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.2
            @Override // com.huawei.hms.ads.gy
            public void Code(int i102, int i11) {
            }

            @Override // com.huawei.hms.ads.gy
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i102) {
                if (gl.Code()) {
                    gl.Code(NativePureVideoView.S, "onMediaStart: %s", Integer.valueOf(i102));
                }
                NativePureVideoView.this.f();
                if (NativePureVideoView.this.f32669g) {
                    return;
                }
                NativePureVideoView.this.f32669g = true;
                NativePureVideoView.this.f32668f = i102;
                NativePureVideoView.this.f32667e = System.currentTimeMillis();
                kg kgVar = NativePureVideoView.this.F;
                if (i102 > 0) {
                    kgVar.V();
                } else {
                    kgVar.Code();
                    NativePureVideoView.this.F.Code(NativePureVideoView.this.f32671i.B(), NativePureVideoView.this.f32671i.Z(), NativePureVideoView.this.f32667e);
                }
            }

            @Override // com.huawei.hms.ads.gy
            public void I(com.huawei.openalliance.ad.media.b bVar, int i102) {
                NativePureVideoView.this.e();
                NativePureVideoView.this.Code(i102, false);
            }

            @Override // com.huawei.hms.ads.gy
            public void V(com.huawei.openalliance.ad.media.b bVar, int i102) {
                NativePureVideoView.this.Code(i102, false);
            }

            @Override // com.huawei.hms.ads.gy
            public void Z(com.huawei.openalliance.ad.media.b bVar, int i102) {
                NativePureVideoView.this.e();
                NativePureVideoView.this.Code(i102, true);
            }
        };
        this.f32674l = new gv() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.3
            @Override // com.huawei.hms.ads.gv
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i102, int i11, int i12) {
                NativePureVideoView.this.e();
                NativePureVideoView.this.Code(i102, false);
            }
        };
        this.f32675m = new gz() { // from class: com.huawei.openalliance.ad.views.NativePureVideoView.4
            @Override // com.huawei.hms.ads.gz
            public void Code() {
                if (NativePureVideoView.this.f32664b != null) {
                    NativePureVideoView.this.f32664b.Code("n");
                }
            }

            @Override // com.huawei.hms.ads.gz
            public void V() {
                if (NativePureVideoView.this.f32664b != null) {
                    NativePureVideoView.this.f32664b.Code("y");
                }
            }
        };
        Code(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(int i10, boolean z10) {
        this.f32671i.I();
        if (this.f32669g) {
            this.f32669g = false;
            if (z10) {
                this.F.Code(this.f32667e, System.currentTimeMillis(), this.f32668f, i10);
            } else {
                this.F.V(this.f32667e, System.currentTimeMillis(), this.f32668f, i10);
            }
        }
    }

    private void Code(Context context) {
        LayoutInflater.from(context).inflate(R.layout.hiad_native_pure_video_view, this);
        this.F = new jt(context, this);
        this.f32671i = new hk(getTAG());
        this.D = (VideoView) findViewById(R.id.hiad_id_video_view);
        this.L = (ImageView) findViewById(R.id.hiad_iv_preview_video);
        this.D.setScreenOnWhilePlaying(true);
        this.D.setAutoScaleResizeLayoutOnVideoSizeChange(false);
        this.D.Code(this.f32673k);
        this.D.Code(this.f32672j);
        this.D.Code(this.f32674l);
        this.D.Code(this.f32675m);
    }

    private void V(boolean z10) {
        gl.V(S, "doRealPlay, auto:" + z10);
        this.f32671i.Code();
        this.D.Code(z10);
    }

    private void b() {
        List<k> Z;
        n nVar = ((NativeMediaView) this).B;
        if (nVar == null || (Z = nVar.Z()) == null || Z.size() <= 0) {
            return;
        }
        k kVar = Z.get(0);
        this.f32665c = kVar;
        if (kVar != null) {
            if (au.B(kVar.Z())) {
                gl.V(S, "don't load preview image with http url");
                return;
            }
            if (this.f32665c.B() > 0) {
                setRatio(Float.valueOf((this.f32665c.C() * 1.0f) / this.f32665c.B()));
            }
            this.F.Code(this.f32665c);
        }
    }

    private void c() {
        n nVar = ((NativeMediaView) this).B;
        if (nVar == null) {
            return;
        }
        v B = nVar.B();
        this.f32664b = B;
        if (B != null) {
            Float g3 = B.g();
            if (g3 == null) {
                g3 = Float.valueOf(1.7777778f);
            }
            setRatio(g3);
            this.D.setDefaultDuration(this.f32664b.I());
            this.F.Code(this.f32664b);
        }
    }

    private void d() {
        e();
        this.f32663a = false;
        this.f32666d = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (gl.Code()) {
            gl.Code(S, "showPreviewView");
        }
        Animation animation = this.L.getAnimation();
        if (animation != null) {
            animation.cancel();
        }
        bd.Code((View) this.L, true);
        this.D.setAlpha(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (gl.Code()) {
            gl.Code(S, "hidePreviewView");
        }
        bd.Code(this.L, 8, 300, 300);
        this.D.setAlpha(1.0f);
    }

    private String getTAG() {
        return S + "_" + hashCode();
    }

    @Override // com.huawei.hms.ads.lh
    public void Code(long j10) {
        this.F.Code(j10);
    }

    @Override // com.huawei.hms.ads.lh
    public void Code(k kVar, Drawable drawable) {
        k kVar2 = this.f32665c;
        if (kVar2 == null || kVar == null || !TextUtils.equals(kVar2.Z(), kVar.Z())) {
            return;
        }
        this.L.setImageDrawable(drawable);
    }

    @Override // com.huawei.hms.ads.lh
    public void Code(v vVar, boolean z10) {
        v vVar2;
        gl.V(S, "onCheckVideoHashResult sucess: %s", Boolean.valueOf(z10));
        if (!z10 || (vVar2 = this.f32664b) == null || vVar == null || !TextUtils.equals(vVar2.V(), vVar.V())) {
            return;
        }
        this.f32663a = true;
        this.D.setVideoFileUrl(vVar.V());
        if (this.f32666d) {
            V(false);
        }
    }

    @Override // com.huawei.hms.ads.lh
    public void Code(String str) {
        this.F.Code(str);
    }

    @Override // com.huawei.hms.ads.lh
    public void S() {
        this.D.D();
    }

    @Override // com.huawei.hms.ads.lz
    public void destroyView() {
        this.D.destroyView();
    }

    public com.huawei.openalliance.ad.media.c getCurrentState() {
        return this.D.getCurrentState();
    }

    public ImageView getPreviewImageView() {
        return this.L;
    }

    @Override // com.huawei.hms.ads.lz
    public void pauseView() {
        this.D.pauseView();
    }

    @Override // com.huawei.hms.ads.lz
    public void resumeView() {
        ((NativeMediaView) this).V = false;
        this.D.resumeView();
        this.D.setNeedPauseOnSurfaceDestory(true);
        ((NativeMediaView) this).C.onGlobalLayout();
    }

    public void setAudioFocusType(int i10) {
        this.D.setAudioFocusType(i10);
    }

    @Override // com.huawei.openalliance.ad.views.NativeMediaView, com.huawei.hms.ads.lh
    public void setNativeAd(com.huawei.openalliance.ad.inter.data.g gVar) {
        com.huawei.openalliance.ad.media.c currentState = this.D.getCurrentState();
        if (((NativeMediaView) this).B == gVar && currentState.V(com.huawei.openalliance.ad.media.e.IDLE) && currentState.V(com.huawei.openalliance.ad.media.e.ERROR)) {
            gl.V(S, "setNativeAd - has the same ad");
            return;
        }
        super.setNativeAd(gVar);
        d();
        this.F.Code(((NativeMediaView) this).B);
        if (((NativeMediaView) this).B == null) {
            this.f32664b = null;
        } else {
            b();
            c();
        }
    }

    @Override // com.huawei.hms.ads.lh
    public void setPpsNativeView(lm lmVar) {
        this.f32670h = lmVar;
    }

    public void setPreferStartPlayTime(int i10) {
        this.D.setPreferStartPlayTime(i10);
    }

    public void setStandalone(boolean z10) {
        this.D.setStandalone(z10);
    }
}
