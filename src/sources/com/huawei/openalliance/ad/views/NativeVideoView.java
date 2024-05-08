package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.hms.ads.bs;
import com.huawei.hms.ads.gd;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.gf;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.gu;
import com.huawei.hms.ads.gv;
import com.huawei.hms.ads.gw;
import com.huawei.hms.ads.gy;
import com.huawei.hms.ads.gz;
import com.huawei.hms.ads.hk;
import com.huawei.hms.ads.hy;
import com.huawei.hms.ads.ic;
import com.huawei.hms.ads.io;
import com.huawei.hms.ads.jm;
import com.huawei.hms.ads.jn;
import com.huawei.hms.ads.jt;
import com.huawei.hms.ads.kg;
import com.huawei.hms.ads.lh;
import com.huawei.hms.ads.lm;
import com.huawei.hms.ads.lz;
import com.huawei.hms.ads.nativead.MediaContent;
import com.huawei.hms.ads.nativead.NativeAdConfiguration;
import com.huawei.hms.ads.nativead.R;
import com.huawei.hms.ads.t;
import com.huawei.openalliance.ad.inter.data.k;
import com.huawei.openalliance.ad.inter.data.n;
import com.huawei.openalliance.ad.inter.data.v;
import com.huawei.openalliance.ad.utils.ai;
import com.huawei.openalliance.ad.utils.au;
import com.huawei.openalliance.ad.views.j;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class NativeVideoView extends NativeMediaView implements hy, lh, lz {
    private static final String S = NativeVideoView.class.getSimpleName();
    private a D;
    private io F;
    private boolean L;

    /* renamed from: a, reason: collision with root package name */
    private j f32676a;

    /* renamed from: b, reason: collision with root package name */
    private kg f32677b;

    /* renamed from: c, reason: collision with root package name */
    private v f32678c;

    /* renamed from: d, reason: collision with root package name */
    private k f32679d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f32680e;

    /* renamed from: f, reason: collision with root package name */
    private int f32681f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f32682g;

    /* renamed from: h, reason: collision with root package name */
    private long f32683h;

    /* renamed from: i, reason: collision with root package name */
    private NativeVideoControlPanel f32684i;

    /* renamed from: j, reason: collision with root package name */
    private VideoView f32685j;

    /* renamed from: k, reason: collision with root package name */
    private lm f32686k;

    /* renamed from: l, reason: collision with root package name */
    private MediaContent f32687l;

    /* renamed from: m, reason: collision with root package name */
    private long f32688m;

    /* renamed from: n, reason: collision with root package name */
    private long f32689n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f32690o;

    /* renamed from: p, reason: collision with root package name */
    private hk f32691p;

    /* renamed from: q, reason: collision with root package name */
    private final gu f32692q;

    /* renamed from: r, reason: collision with root package name */
    private final gy f32693r;

    /* renamed from: s, reason: collision with root package name */
    private final gv f32694s;

    /* renamed from: t, reason: collision with root package name */
    private gw f32695t;

    /* renamed from: u, reason: collision with root package name */
    private gz f32696u;

    /* renamed from: v, reason: collision with root package name */
    private j.a f32697v;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface a {
        void Code();

        void Code(boolean z10);

        void Code(boolean z10, int i10);

        void I();

        void V();

        void V(boolean z10, int i10);

        void Z();
    }

    public NativeVideoView(Context context) {
        super(context);
        this.F = new ic();
        this.L = false;
        this.f32680e = false;
        this.f32681f = 0;
        this.f32682g = false;
        this.f32692q = new gu() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.1
            @Override // com.huawei.hms.ads.gu
            public void Code() {
                if (gl.Code()) {
                    gl.Code(NativeVideoView.S, "onBufferingStart");
                }
                NativeVideoView.this.f32691p.V();
                NativeVideoView.this.F.b();
            }

            @Override // com.huawei.hms.ads.gu
            public void Code(int i10) {
            }

            @Override // com.huawei.hms.ads.gu
            public void V() {
                NativeVideoView.this.F.c();
            }
        };
        this.f32693r = new gy() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.2
            @Override // com.huawei.hms.ads.gy
            public void Code(int i10, int i11) {
                if (NativeVideoView.this.L) {
                    NativeVideoView.this.F.Code(i10);
                    if (NativeVideoView.this.f32677b != null) {
                        NativeVideoView.this.f32677b.Code(NativeVideoView.this.getContext(), i11, NativeVideoView.this.f32678c == null ? 0L : NativeVideoView.this.f32678c.I());
                    }
                }
            }

            @Override // com.huawei.hms.ads.gy
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i10) {
                if (gl.Code()) {
                    gl.Code(NativeVideoView.S, "onMediaStart: %s", Integer.valueOf(i10));
                }
                if (NativeVideoView.this.L) {
                    return;
                }
                NativeVideoView.this.L = true;
                NativeVideoView.this.f32689n = i10;
                NativeVideoView.this.f32688m = System.currentTimeMillis();
                NativeVideoView.this.i();
                io ioVar = NativeVideoView.this.F;
                if (i10 > 0) {
                    ioVar.f();
                    NativeVideoView.this.f32677b.V();
                    return;
                }
                if (ioVar != null && NativeVideoView.this.f32678c != null) {
                    NativeVideoView.this.F.Code(NativeVideoView.this.f32678c.I(), !"y".equals(NativeVideoView.this.f32678c.a()));
                }
                NativeVideoView.this.f32677b.Code();
                NativeVideoView.this.f32677b.Code(NativeVideoView.this.f32691p.B(), NativeVideoView.this.f32691p.Z(), NativeVideoView.this.f32688m);
            }

            @Override // com.huawei.hms.ads.gy
            public void I(com.huawei.openalliance.ad.media.b bVar, int i10) {
                NativeVideoView.this.Code(i10, false);
                NativeVideoView.this.j();
            }

            @Override // com.huawei.hms.ads.gy
            public void V(com.huawei.openalliance.ad.media.b bVar, int i10) {
                NativeVideoView.this.Code(i10, false);
                NativeVideoView.this.k();
            }

            @Override // com.huawei.hms.ads.gy
            public void Z(com.huawei.openalliance.ad.media.b bVar, int i10) {
                NativeVideoView.this.Code(i10, true);
                NativeVideoView.this.l();
                if (NativeVideoView.this.f32677b != null) {
                    long j10 = i10;
                    NativeVideoView.this.f32677b.Code(NativeVideoView.this.getContext(), j10, j10);
                }
            }
        };
        this.f32694s = new gv() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.3
            @Override // com.huawei.hms.ads.gv
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i10, int i11, int i12) {
                NativeVideoView.this.Code(i10, false);
                NativeVideoView nativeVideoView = NativeVideoView.this;
                if (((NativeMediaView) nativeVideoView).I || ai.Z(nativeVideoView.getContext())) {
                    return;
                }
                Toast makeText = Toast.makeText(NativeVideoView.this.getContext(), R.string.hiad_network_error, 0);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            }
        };
        this.f32695t = new gw() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.4
            @Override // com.huawei.hms.ads.gw
            public void Code(int i10) {
                NativeVideoView.this.f32676a.I(i10);
            }

            @Override // com.huawei.hms.ads.gw
            public void V(int i10) {
            }
        };
        this.f32696u = new gz() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.5
            @Override // com.huawei.hms.ads.gz
            public void Code() {
                gl.V(NativeVideoView.S, "onMute");
                if (NativeVideoView.this.f32678c != null) {
                    NativeVideoView.this.f32678c.Code("n");
                    if (NativeVideoView.this.f32690o || !NativeVideoView.this.L) {
                        NativeVideoView.this.f32690o = false;
                    } else {
                        NativeVideoView.this.f32677b.Code(true);
                    }
                    NativeVideoView.this.F.V(0.0f);
                }
                NativeVideoView.this.f32676a.B(true);
                if (NativeVideoView.this.D != null) {
                    NativeVideoView.this.D.Code(true);
                }
            }

            @Override // com.huawei.hms.ads.gz
            public void V() {
                gl.V(NativeVideoView.S, "onUnmute");
                if (NativeVideoView.this.f32678c != null) {
                    NativeVideoView.this.f32690o = false;
                    NativeVideoView.this.f32678c.Code("y");
                    NativeVideoView.this.f32677b.Code(false);
                    NativeVideoView.this.F.V(1.0f);
                }
                NativeVideoView.this.f32676a.B(false);
                if (NativeVideoView.this.D != null) {
                    NativeVideoView.this.D.Code(false);
                }
            }
        };
        this.f32697v = new j.a() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.6
            @Override // com.huawei.openalliance.ad.views.j.a
            public void Code() {
                if (NativeVideoView.this.f32686k != null) {
                    NativeVideoView.this.f32686k.Code(5, false);
                }
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public void Code(boolean z10) {
                gl.V(NativeVideoView.S, "doRealPlay, auto:" + z10);
                NativeVideoView.this.f32691p.Code();
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public void Code(boolean z10, int i10) {
                NativeVideoView.this.Code(z10, i10);
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public void V(boolean z10, int i10) {
                NativeVideoView.this.V(z10, i10);
            }
        };
        Code(context);
    }

    public NativeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.F = new ic();
        this.L = false;
        this.f32680e = false;
        this.f32681f = 0;
        this.f32682g = false;
        this.f32692q = new gu() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.1
            @Override // com.huawei.hms.ads.gu
            public void Code() {
                if (gl.Code()) {
                    gl.Code(NativeVideoView.S, "onBufferingStart");
                }
                NativeVideoView.this.f32691p.V();
                NativeVideoView.this.F.b();
            }

            @Override // com.huawei.hms.ads.gu
            public void Code(int i10) {
            }

            @Override // com.huawei.hms.ads.gu
            public void V() {
                NativeVideoView.this.F.c();
            }
        };
        this.f32693r = new gy() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.2
            @Override // com.huawei.hms.ads.gy
            public void Code(int i10, int i11) {
                if (NativeVideoView.this.L) {
                    NativeVideoView.this.F.Code(i10);
                    if (NativeVideoView.this.f32677b != null) {
                        NativeVideoView.this.f32677b.Code(NativeVideoView.this.getContext(), i11, NativeVideoView.this.f32678c == null ? 0L : NativeVideoView.this.f32678c.I());
                    }
                }
            }

            @Override // com.huawei.hms.ads.gy
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i10) {
                if (gl.Code()) {
                    gl.Code(NativeVideoView.S, "onMediaStart: %s", Integer.valueOf(i10));
                }
                if (NativeVideoView.this.L) {
                    return;
                }
                NativeVideoView.this.L = true;
                NativeVideoView.this.f32689n = i10;
                NativeVideoView.this.f32688m = System.currentTimeMillis();
                NativeVideoView.this.i();
                io ioVar = NativeVideoView.this.F;
                if (i10 > 0) {
                    ioVar.f();
                    NativeVideoView.this.f32677b.V();
                    return;
                }
                if (ioVar != null && NativeVideoView.this.f32678c != null) {
                    NativeVideoView.this.F.Code(NativeVideoView.this.f32678c.I(), !"y".equals(NativeVideoView.this.f32678c.a()));
                }
                NativeVideoView.this.f32677b.Code();
                NativeVideoView.this.f32677b.Code(NativeVideoView.this.f32691p.B(), NativeVideoView.this.f32691p.Z(), NativeVideoView.this.f32688m);
            }

            @Override // com.huawei.hms.ads.gy
            public void I(com.huawei.openalliance.ad.media.b bVar, int i10) {
                NativeVideoView.this.Code(i10, false);
                NativeVideoView.this.j();
            }

            @Override // com.huawei.hms.ads.gy
            public void V(com.huawei.openalliance.ad.media.b bVar, int i10) {
                NativeVideoView.this.Code(i10, false);
                NativeVideoView.this.k();
            }

            @Override // com.huawei.hms.ads.gy
            public void Z(com.huawei.openalliance.ad.media.b bVar, int i10) {
                NativeVideoView.this.Code(i10, true);
                NativeVideoView.this.l();
                if (NativeVideoView.this.f32677b != null) {
                    long j10 = i10;
                    NativeVideoView.this.f32677b.Code(NativeVideoView.this.getContext(), j10, j10);
                }
            }
        };
        this.f32694s = new gv() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.3
            @Override // com.huawei.hms.ads.gv
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i10, int i11, int i12) {
                NativeVideoView.this.Code(i10, false);
                NativeVideoView nativeVideoView = NativeVideoView.this;
                if (((NativeMediaView) nativeVideoView).I || ai.Z(nativeVideoView.getContext())) {
                    return;
                }
                Toast makeText = Toast.makeText(NativeVideoView.this.getContext(), R.string.hiad_network_error, 0);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            }
        };
        this.f32695t = new gw() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.4
            @Override // com.huawei.hms.ads.gw
            public void Code(int i10) {
                NativeVideoView.this.f32676a.I(i10);
            }

            @Override // com.huawei.hms.ads.gw
            public void V(int i10) {
            }
        };
        this.f32696u = new gz() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.5
            @Override // com.huawei.hms.ads.gz
            public void Code() {
                gl.V(NativeVideoView.S, "onMute");
                if (NativeVideoView.this.f32678c != null) {
                    NativeVideoView.this.f32678c.Code("n");
                    if (NativeVideoView.this.f32690o || !NativeVideoView.this.L) {
                        NativeVideoView.this.f32690o = false;
                    } else {
                        NativeVideoView.this.f32677b.Code(true);
                    }
                    NativeVideoView.this.F.V(0.0f);
                }
                NativeVideoView.this.f32676a.B(true);
                if (NativeVideoView.this.D != null) {
                    NativeVideoView.this.D.Code(true);
                }
            }

            @Override // com.huawei.hms.ads.gz
            public void V() {
                gl.V(NativeVideoView.S, "onUnmute");
                if (NativeVideoView.this.f32678c != null) {
                    NativeVideoView.this.f32690o = false;
                    NativeVideoView.this.f32678c.Code("y");
                    NativeVideoView.this.f32677b.Code(false);
                    NativeVideoView.this.F.V(1.0f);
                }
                NativeVideoView.this.f32676a.B(false);
                if (NativeVideoView.this.D != null) {
                    NativeVideoView.this.D.Code(false);
                }
            }
        };
        this.f32697v = new j.a() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.6
            @Override // com.huawei.openalliance.ad.views.j.a
            public void Code() {
                if (NativeVideoView.this.f32686k != null) {
                    NativeVideoView.this.f32686k.Code(5, false);
                }
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public void Code(boolean z10) {
                gl.V(NativeVideoView.S, "doRealPlay, auto:" + z10);
                NativeVideoView.this.f32691p.Code();
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public void Code(boolean z10, int i10) {
                NativeVideoView.this.Code(z10, i10);
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public void V(boolean z10, int i10) {
                NativeVideoView.this.V(z10, i10);
            }
        };
        Code(context);
    }

    public NativeVideoView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.F = new ic();
        this.L = false;
        this.f32680e = false;
        this.f32681f = 0;
        this.f32682g = false;
        this.f32692q = new gu() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.1
            @Override // com.huawei.hms.ads.gu
            public void Code() {
                if (gl.Code()) {
                    gl.Code(NativeVideoView.S, "onBufferingStart");
                }
                NativeVideoView.this.f32691p.V();
                NativeVideoView.this.F.b();
            }

            @Override // com.huawei.hms.ads.gu
            public void Code(int i102) {
            }

            @Override // com.huawei.hms.ads.gu
            public void V() {
                NativeVideoView.this.F.c();
            }
        };
        this.f32693r = new gy() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.2
            @Override // com.huawei.hms.ads.gy
            public void Code(int i102, int i11) {
                if (NativeVideoView.this.L) {
                    NativeVideoView.this.F.Code(i102);
                    if (NativeVideoView.this.f32677b != null) {
                        NativeVideoView.this.f32677b.Code(NativeVideoView.this.getContext(), i11, NativeVideoView.this.f32678c == null ? 0L : NativeVideoView.this.f32678c.I());
                    }
                }
            }

            @Override // com.huawei.hms.ads.gy
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i102) {
                if (gl.Code()) {
                    gl.Code(NativeVideoView.S, "onMediaStart: %s", Integer.valueOf(i102));
                }
                if (NativeVideoView.this.L) {
                    return;
                }
                NativeVideoView.this.L = true;
                NativeVideoView.this.f32689n = i102;
                NativeVideoView.this.f32688m = System.currentTimeMillis();
                NativeVideoView.this.i();
                io ioVar = NativeVideoView.this.F;
                if (i102 > 0) {
                    ioVar.f();
                    NativeVideoView.this.f32677b.V();
                    return;
                }
                if (ioVar != null && NativeVideoView.this.f32678c != null) {
                    NativeVideoView.this.F.Code(NativeVideoView.this.f32678c.I(), !"y".equals(NativeVideoView.this.f32678c.a()));
                }
                NativeVideoView.this.f32677b.Code();
                NativeVideoView.this.f32677b.Code(NativeVideoView.this.f32691p.B(), NativeVideoView.this.f32691p.Z(), NativeVideoView.this.f32688m);
            }

            @Override // com.huawei.hms.ads.gy
            public void I(com.huawei.openalliance.ad.media.b bVar, int i102) {
                NativeVideoView.this.Code(i102, false);
                NativeVideoView.this.j();
            }

            @Override // com.huawei.hms.ads.gy
            public void V(com.huawei.openalliance.ad.media.b bVar, int i102) {
                NativeVideoView.this.Code(i102, false);
                NativeVideoView.this.k();
            }

            @Override // com.huawei.hms.ads.gy
            public void Z(com.huawei.openalliance.ad.media.b bVar, int i102) {
                NativeVideoView.this.Code(i102, true);
                NativeVideoView.this.l();
                if (NativeVideoView.this.f32677b != null) {
                    long j10 = i102;
                    NativeVideoView.this.f32677b.Code(NativeVideoView.this.getContext(), j10, j10);
                }
            }
        };
        this.f32694s = new gv() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.3
            @Override // com.huawei.hms.ads.gv
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i102, int i11, int i12) {
                NativeVideoView.this.Code(i102, false);
                NativeVideoView nativeVideoView = NativeVideoView.this;
                if (((NativeMediaView) nativeVideoView).I || ai.Z(nativeVideoView.getContext())) {
                    return;
                }
                Toast makeText = Toast.makeText(NativeVideoView.this.getContext(), R.string.hiad_network_error, 0);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            }
        };
        this.f32695t = new gw() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.4
            @Override // com.huawei.hms.ads.gw
            public void Code(int i102) {
                NativeVideoView.this.f32676a.I(i102);
            }

            @Override // com.huawei.hms.ads.gw
            public void V(int i102) {
            }
        };
        this.f32696u = new gz() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.5
            @Override // com.huawei.hms.ads.gz
            public void Code() {
                gl.V(NativeVideoView.S, "onMute");
                if (NativeVideoView.this.f32678c != null) {
                    NativeVideoView.this.f32678c.Code("n");
                    if (NativeVideoView.this.f32690o || !NativeVideoView.this.L) {
                        NativeVideoView.this.f32690o = false;
                    } else {
                        NativeVideoView.this.f32677b.Code(true);
                    }
                    NativeVideoView.this.F.V(0.0f);
                }
                NativeVideoView.this.f32676a.B(true);
                if (NativeVideoView.this.D != null) {
                    NativeVideoView.this.D.Code(true);
                }
            }

            @Override // com.huawei.hms.ads.gz
            public void V() {
                gl.V(NativeVideoView.S, "onUnmute");
                if (NativeVideoView.this.f32678c != null) {
                    NativeVideoView.this.f32690o = false;
                    NativeVideoView.this.f32678c.Code("y");
                    NativeVideoView.this.f32677b.Code(false);
                    NativeVideoView.this.F.V(1.0f);
                }
                NativeVideoView.this.f32676a.B(false);
                if (NativeVideoView.this.D != null) {
                    NativeVideoView.this.D.Code(false);
                }
            }
        };
        this.f32697v = new j.a() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.6
            @Override // com.huawei.openalliance.ad.views.j.a
            public void Code() {
                if (NativeVideoView.this.f32686k != null) {
                    NativeVideoView.this.f32686k.Code(5, false);
                }
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public void Code(boolean z10) {
                gl.V(NativeVideoView.S, "doRealPlay, auto:" + z10);
                NativeVideoView.this.f32691p.Code();
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public void Code(boolean z10, int i102) {
                NativeVideoView.this.Code(z10, i102);
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public void V(boolean z10, int i102) {
                NativeVideoView.this.V(z10, i102);
            }
        };
        Code(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(int i10, boolean z10) {
        v vVar = this.f32678c;
        if (vVar != null) {
            vVar.Code(z10 ? 0 : i10);
        }
        this.f32691p.I();
        if (this.L) {
            this.L = false;
            if (z10) {
                this.f32677b.Code(this.f32688m, System.currentTimeMillis(), this.f32689n, i10);
                this.F.a();
            } else {
                this.f32677b.V(this.f32688m, System.currentTimeMillis(), this.f32689n, i10);
                this.F.e();
            }
        }
    }

    private void Code(Context context) {
        this.f32677b = new jt(context, this);
        LayoutInflater.from(context).inflate(R.layout.hiad_native_video_view, this);
        this.f32685j = (VideoView) findViewById(R.id.hiad_id_video_view);
        this.f32684i = (NativeVideoControlPanel) findViewById(R.id.hiad_native_video_ctrl_panel);
        this.f32685j.setStandalone(false);
        this.f32685j.setScreenOnWhilePlaying(true);
        this.f32685j.setAutoScaleResizeLayoutOnVideoSizeChange(false);
        j jVar = new j(this.f32685j, this.f32684i);
        this.f32676a = jVar;
        jVar.Code(this.f32697v);
        this.f32685j.Code(this.f32693r);
        this.f32685j.Code(this.f32692q);
        this.f32685j.Code(this.f32694s);
        this.f32685j.Code(this.f32696u);
        this.f32685j.Code(this.f32695t);
        this.f32691p = new hk(getTAG());
    }

    private void Code(MediaContent mediaContent) {
        this.f32676a.Code(mediaContent.getImage());
        if (mediaContent.getAspectRatio() > 0.0f) {
            setRatio(Float.valueOf(mediaContent.getAspectRatio()));
        }
    }

    private void Code(k kVar) {
        if (kVar.B() > 0) {
            setRatio(Float.valueOf((kVar.C() * 1.0f) / kVar.B()));
        }
        if (c()) {
            return;
        }
        this.f32677b.Code(kVar);
    }

    private void Code(n nVar) {
        if (nVar.B() != null) {
            this.F.Code(jn.Code(0.0f, m(), jm.STANDALONE));
        }
    }

    private void Code(v vVar) {
        gd Code = ge.Code();
        if (Code == null || vVar == null) {
            return;
        }
        int Code2 = Code.Code();
        vVar.Code(Code2);
        gl.V(S, "obtain progress from linked view " + Code2);
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(boolean z10, int i10) {
        a aVar = this.D;
        if (aVar != null) {
            aVar.Code(z10, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(boolean z10, int i10) {
        a aVar = this.D;
        if (aVar != null) {
            aVar.V(z10, i10);
        }
    }

    private void b() {
        gl.V(S, "setInnerListener");
        this.f32685j.Code(this.f32694s);
        this.f32685j.Code(this.f32696u);
        this.f32676a.Z(!g());
    }

    private boolean c() {
        NativeAdConfiguration ad2;
        n nVar = ((NativeMediaView) this).B;
        if (nVar == null || (ad2 = nVar.ad()) == null) {
            return false;
        }
        return ad2.isReturnUrlsForImages();
    }

    private void d() {
        n nVar = ((NativeMediaView) this).B;
        if (nVar == null) {
            return;
        }
        this.f32678c = nVar.B();
        if (((NativeMediaView) this).B.ad() != null) {
            VideoConfiguration videoConfiguration = ((NativeMediaView) this).B.ad().getVideoConfiguration();
            if (videoConfiguration != null) {
                Code(videoConfiguration.isStartMuted());
                setAudioFocusType(videoConfiguration.getAudioFocusType());
            } else {
                Code(true);
            }
        }
        if (this.f32678c == null) {
            this.f32676a.B();
            return;
        }
        this.f32676a.Code(this.f32685j);
        this.f32681f = ((NativeMediaView) this).B.aj();
        this.f32676a.Code(this.f32678c);
        Float g3 = this.f32678c.g();
        if (g3 == null) {
            g3 = Float.valueOf(1.7777778f);
        }
        setRatio(g3);
        this.f32676a.B(this.f32681f);
        this.f32676a.Z(!g());
        this.f32676a.V(getContinuePlayTime());
        this.f32676a.I(this.f32678c.I());
        this.f32676a.Z(this.f32678c.f());
        this.f32677b.Code(this.f32678c);
        this.f32684i.setNonWifiAlertMsg(this.f32678c.Z() > 0 ? getResources().getString(R.string.hiad_consume_data_to_play_video, au.Code(getContext(), this.f32678c.Z())) : getResources().getString(R.string.hiad_consume_data_to_play_video_no_data_size));
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0013, code lost:
    
        if ((r0 instanceof com.huawei.hms.ads.bs) == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e() {
        /*
            r2 = this;
            com.huawei.openalliance.ad.inter.data.n r0 = r2.B
            if (r0 != 0) goto L5
            return
        L5:
            com.huawei.hms.ads.nativead.MediaContent r0 = r2.f32687l
            if (r0 == 0) goto L19
            android.graphics.drawable.Drawable r0 = r0.getImage()
            if (r0 == 0) goto L19
            com.huawei.hms.ads.nativead.MediaContent r0 = r2.f32687l
            boolean r1 = r0 instanceof com.huawei.hms.ads.bs
            if (r1 != 0) goto L19
        L15:
            r2.Code(r0)
            goto L58
        L19:
            com.huawei.openalliance.ad.inter.data.n r0 = r2.B
            java.util.List r0 = r0.Z()
            if (r0 == 0) goto L58
            int r1 = r0.size()
            if (r1 <= 0) goto L58
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.huawei.openalliance.ad.inter.data.k r0 = (com.huawei.openalliance.ad.inter.data.k) r0
            r2.f32679d = r0
            if (r0 == 0) goto L58
            com.huawei.hms.ads.nativead.MediaContent r0 = r2.f32687l
            if (r0 == 0) goto L53
            android.graphics.drawable.Drawable r0 = r0.getImage()
            if (r0 == 0) goto L53
            com.huawei.hms.ads.nativead.MediaContent r0 = r2.f32687l
            boolean r1 = r0 instanceof com.huawei.hms.ads.bs
            if (r1 == 0) goto L15
            com.huawei.hms.ads.bs r0 = (com.huawei.hms.ads.bs) r0
            com.huawei.openalliance.ad.inter.data.k r1 = r2.f32679d
            java.lang.String r1 = r1.Z()
            boolean r0 = r0.Code(r1)
            if (r0 == 0) goto L53
            com.huawei.hms.ads.nativead.MediaContent r0 = r2.f32687l
            goto L15
        L53:
            com.huawei.openalliance.ad.inter.data.k r0 = r2.f32679d
            r2.Code(r0)
        L58:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.views.NativeVideoView.e():void");
    }

    private void f() {
        this.f32680e = false;
        this.f32676a.S(true);
    }

    private boolean g() {
        v vVar = this.f32678c;
        return vVar != null && TextUtils.equals(vVar.a(), "y");
    }

    private int getContinuePlayTime() {
        v vVar = this.f32678c;
        if (vVar == null) {
            gl.Code(S, "getContinuePlayTime other");
            return 0;
        }
        int L = vVar.L();
        if (L >= 5000) {
            return L;
        }
        return 0;
    }

    private String getTAG() {
        return S + "_" + hashCode();
    }

    private boolean h() {
        v vVar = this.f32678c;
        if (vVar == null) {
            return false;
        }
        if (vVar.L() < this.f32678c.I()) {
            v vVar2 = this.f32678c;
            return vVar2 != null && TextUtils.equals(vVar2.B(), "y");
        }
        this.f32678c.Code(0);
        gl.V(S, "play progress bigger than video duration, skip autoPlay.");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        a aVar = this.D;
        if (aVar != null) {
            aVar.Code();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        a aVar = this.D;
        if (aVar != null) {
            aVar.Z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        a aVar = this.D;
        if (aVar != null) {
            aVar.V();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        a aVar = this.D;
        if (aVar != null) {
            aVar.I();
        }
    }

    private boolean m() {
        if (this.f32678c == null || !ai.Z(getContext()) || !h()) {
            return false;
        }
        if (this.f32678c.f() == 1) {
            return true;
        }
        return this.f32678c.f() == 0 && ai.I(getContext());
    }

    private void n() {
        ge.Code(null);
        gf.Code(getContext()).V();
    }

    @Override // com.huawei.openalliance.ad.views.NativeMediaView
    public void B() {
        gl.V(S, "onViewShownBetweenFullAndPartial");
        this.f32676a.C(true);
        b();
    }

    public void C() {
        this.f32685j.b();
    }

    @Override // com.huawei.openalliance.ad.views.NativeMediaView
    public void Code() {
        super.Code();
        this.f32685j.setNeedPauseOnSurfaceDestory(true);
    }

    @Override // com.huawei.hms.ads.lh
    public void Code(long j10) {
        this.f32677b.Code(j10);
    }

    public void Code(io ioVar, n nVar) {
        this.F = ioVar;
        Code(nVar);
    }

    @Override // com.huawei.hms.ads.lh
    public void Code(k kVar, Drawable drawable) {
        k kVar2 = this.f32679d;
        if (kVar2 == null || kVar == null || !TextUtils.equals(kVar2.Z(), kVar.Z())) {
            return;
        }
        t tVar = new t(this.f32679d, false);
        tVar.Code(drawable);
        this.f32687l = new bs(tVar);
        this.f32676a.Code(drawable);
    }

    @Override // com.huawei.hms.ads.lh
    public void Code(v vVar, boolean z10) {
        v vVar2;
        String str = S;
        gl.V(str, "onCheckVideoResult: %s", Boolean.valueOf(z10));
        if (!z10 || (vVar2 = this.f32678c) == null || vVar == null || !TextUtils.equals(vVar2.V(), vVar.V())) {
            return;
        }
        this.f32680e = true;
        this.f32676a.Code(vVar.V());
        if (((NativeMediaView) this).V) {
            this.f32676a.V(getContinuePlayTime());
            boolean h10 = h();
            gl.V(str, "onCheckVideoResult - full shown, autoPlay: %s", Boolean.valueOf(h10));
            this.f32676a.I(h10);
            if (m()) {
                long S2 = vVar.S() - (System.currentTimeMillis() - this.f32683h);
                if (S2 < 0) {
                    S2 = 0;
                }
                this.f32676a.Code(S2);
            }
        }
    }

    @Override // com.huawei.hms.ads.lh
    public void Code(String str) {
        this.f32677b.Code(str);
    }

    public void Code(boolean z10) {
        gl.V(S, "customToggleVideoMute, customMuteState is " + z10);
        v vVar = this.f32678c;
        if (vVar != null) {
            vVar.Code(z10 ? "n" : "y");
        }
    }

    public void D() {
        this.f32676a.V(false);
    }

    public void F() {
        this.f32685j.c();
    }

    @Override // com.huawei.openalliance.ad.views.NativeMediaView
    public void I() {
        gl.V(S, "onViewPartialHidden");
        this.f32682g = false;
        this.f32685j.V(this.f32694s);
        this.f32685j.V(this.f32696u);
        if (this.f32678c != null) {
            this.f32676a.C(false);
            this.f32676a.I(false);
            this.f32676a.C();
            this.f32676a.S();
        }
    }

    public void L() {
        this.f32676a.D();
    }

    @Override // com.huawei.hms.ads.lh
    public void S() {
        this.f32676a.S();
    }

    @Override // com.huawei.openalliance.ad.views.NativeMediaView
    public void V() {
        this.f32683h = System.currentTimeMillis();
        this.f32676a.C(true);
        Code(this.f32678c);
        b();
        String str = S;
        gl.V(str, "onViewFullShown hashCheckSuccess: %s", Boolean.valueOf(this.f32680e));
        if (this.f32680e) {
            boolean h10 = h();
            gl.V(str, "onViewFullShown autoplay: %s", Boolean.valueOf(h10));
            this.f32676a.I(h10);
            this.f32676a.V(getContinuePlayTime());
            if (m()) {
                this.f32676a.Code(this.f32678c.S());
            }
        }
    }

    @Override // com.huawei.hms.ads.lz
    public void destroyView() {
        this.f32685j.destroyView();
        this.f32687l = null;
        this.F.I();
    }

    public float getAspectRatio() {
        Float g3;
        v vVar = this.f32678c;
        if (vVar == null || (g3 = vVar.g()) == null) {
            return 0.0f;
        }
        return g3.floatValue();
    }

    @Override // com.huawei.openalliance.ad.views.NativeMediaView
    public int getAutoPlayAreaPercentageThresshold() {
        v vVar = this.f32678c;
        return vVar != null ? vVar.c() : super.getAutoPlayAreaPercentageThresshold();
    }

    @Override // com.huawei.openalliance.ad.views.NativeMediaView
    public int getHiddenAreaPercentageThreshhold() {
        v vVar = this.f32678c;
        return vVar != null ? Math.max(100 - vVar.d(), 0) : super.getHiddenAreaPercentageThreshhold();
    }

    public MediaContent getMediaContent() {
        return this.f32687l;
    }

    @Override // com.huawei.hms.ads.hy
    public View getOpenMeasureView() {
        return this;
    }

    public ImageView getPreviewImageView() {
        return this.f32684i.S();
    }

    public VideoView getVideoView() {
        return this.f32685j;
    }

    @Override // com.huawei.openalliance.ad.views.NativeMediaView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // com.huawei.openalliance.ad.views.NativeMediaView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.F.I();
    }

    @Override // com.huawei.hms.ads.lz
    public void pauseView() {
        this.f32676a.L();
    }

    @Override // com.huawei.hms.ads.lz
    public void resumeView() {
        this.f32676a.a();
        gl.V(S, "resumeView");
        b();
        ((NativeMediaView) this).V = false;
        ((NativeMediaView) this).C.onGlobalLayout();
        this.f32685j.setNeedPauseOnSurfaceDestory(true);
    }

    public void setAudioFocusType(int i10) {
        this.f32685j.setAudioFocusType(i10);
    }

    public void setCoverClickListener(View.OnClickListener onClickListener) {
        this.f32676a.Code(onClickListener);
    }

    public void setMediaContent(MediaContent mediaContent) {
        this.f32687l = mediaContent;
    }

    @Override // com.huawei.openalliance.ad.views.NativeMediaView, com.huawei.hms.ads.lh
    public void setNativeAd(com.huawei.openalliance.ad.inter.data.g gVar) {
        String str = S;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("setNativeAd ");
        sb2.append(gVar != null ? gVar.D() : "null");
        gl.V(str, sb2.toString());
        if (gVar == null) {
            this.f32687l = null;
        }
        com.huawei.openalliance.ad.media.c currentState = this.f32685j.getCurrentState();
        if (((NativeMediaView) this).B == gVar && currentState.V(com.huawei.openalliance.ad.media.e.IDLE) && currentState.V(com.huawei.openalliance.ad.media.e.ERROR)) {
            gl.V(str, "setNativeAd - has the same ad");
            return;
        }
        super.setNativeAd(gVar);
        f();
        this.f32677b.Code(((NativeMediaView) this).B);
        if (((NativeMediaView) this).B != null) {
            e();
            d();
            this.f32676a.C(false);
        } else {
            this.f32676a.Z(true);
            this.f32678c = null;
            this.f32687l = null;
        }
        if (!h() || g()) {
            return;
        }
        this.f32690o = true;
    }

    public void setNotShowDataUsageAlert(boolean z10) {
        this.f32676a.F(z10);
    }

    @Override // com.huawei.hms.ads.lh
    public void setPpsNativeView(lm lmVar) {
        this.f32686k = lmVar;
    }

    public void setVideoEventListener(a aVar) {
        this.D = aVar;
    }
}
