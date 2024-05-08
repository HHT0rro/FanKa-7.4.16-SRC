package com.huawei.openalliance.ad.views;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.Toast;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.gu;
import com.huawei.hms.ads.gv;
import com.huawei.hms.ads.gy;
import com.huawei.hms.ads.nativead.R;
import com.huawei.openalliance.ad.inter.data.v;
import com.huawei.openalliance.ad.utils.ai;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.bd;
import com.huawei.openalliance.ad.views.BaseVideoView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class j implements gu, gv, gy, BaseVideoView.g, e {
    private static final String Z = "j";
    private VideoView B;
    private NativeVideoControlPanel C;
    private View D;
    private ImageView F;
    private ImageView L;
    private ImageView S;

    /* renamed from: a, reason: collision with root package name */
    private View f33040a;

    /* renamed from: b, reason: collision with root package name */
    private View f33041b;

    /* renamed from: c, reason: collision with root package name */
    private View f33042c;

    /* renamed from: f, reason: collision with root package name */
    private boolean f33045f;

    /* renamed from: h, reason: collision with root package name */
    private int f33047h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f33048i;

    /* renamed from: j, reason: collision with root package name */
    private View.OnClickListener f33049j;

    /* renamed from: k, reason: collision with root package name */
    private a f33050k;

    /* renamed from: l, reason: collision with root package name */
    private int f33051l;

    /* renamed from: n, reason: collision with root package name */
    private v f33053n;

    /* renamed from: d, reason: collision with root package name */
    private final String f33043d = "hPlT" + hashCode();

    /* renamed from: e, reason: collision with root package name */
    private final String f33044e = "aPT" + hashCode();

    /* renamed from: g, reason: collision with root package name */
    private boolean f33046g = true;

    /* renamed from: m, reason: collision with root package name */
    private boolean f33052m = false;

    /* renamed from: o, reason: collision with root package name */
    private int f33054o = 0;

    /* renamed from: p, reason: collision with root package name */
    private Runnable f33055p = new Runnable() { // from class: com.huawei.openalliance.ad.views.j.1
        @Override // java.lang.Runnable
        public void run() {
            if (j.this.B == null || !j.this.f33045f) {
                return;
            }
            j.this.V(true);
        }
    };

    /* renamed from: q, reason: collision with root package name */
    private View.OnClickListener f33056q = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.j.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.this.L(!view.isSelected());
        }
    };

    /* renamed from: r, reason: collision with root package name */
    private Runnable f33057r = new Runnable() { // from class: com.huawei.openalliance.ad.views.j.8
        @Override // java.lang.Runnable
        public void run() {
            j.this.Code(false, true);
        }
    };

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface a {
        void Code();

        void Code(boolean z10);

        void Code(boolean z10, int i10);

        void V(boolean z10, int i10);
    }

    public j(VideoView videoView, NativeVideoControlPanel nativeVideoControlPanel) {
        Code(videoView);
        Code(nativeVideoControlPanel);
    }

    private void Code(int i10, boolean z10, boolean z11) {
        NativeVideoControlPanel nativeVideoControlPanel;
        C();
        if (z11) {
            i10 = 0;
        }
        this.f33047h = i10;
        ba.Code(this.f33043d);
        if (this.S != null && (nativeVideoControlPanel = this.C) != null && nativeVideoControlPanel.V() != 0) {
            this.S.setImageResource(this.C.V());
            ay.Code(this.S);
        }
        if (!z10) {
            f();
            a(false);
        }
        View view = this.f33041b;
        if (view == null || view.getVisibility() != 0) {
            Code(true, true);
        }
        ImageView imageView = this.S;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(boolean z10, boolean z11) {
        boolean Code;
        View view = this.f33040a;
        if (z11) {
            Code = bd.Code(view, z10 ? 0 : 8);
        } else {
            Code = bd.Code(view, z10);
        }
        if (Code) {
            if (z10) {
                c(z11);
            } else {
                d(z11);
            }
        }
    }

    private void D(boolean z10) {
        a aVar = this.f33050k;
        if (aVar != null) {
            aVar.Code(z10);
        }
    }

    private void I(NativeVideoControlPanel nativeVideoControlPanel) {
        ImageView B = nativeVideoControlPanel.B();
        this.F = B;
        if (B != null) {
            B.setOnClickListener(this.f33056q);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(boolean z10) {
        gl.V(Z, "switchSound: " + z10);
        VideoView videoView = this.B;
        if (videoView == null) {
            return;
        }
        if (z10) {
            videoView.c();
        } else {
            videoView.b();
        }
        ba.Code(this.f33043d);
        if (this.B.a()) {
            r();
        }
    }

    private void V(NativeVideoControlPanel nativeVideoControlPanel) {
        View D = nativeVideoControlPanel.D();
        this.f33042c = D;
        if (D != null) {
            D.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.j.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.e();
                }
            });
        }
    }

    private void Z(NativeVideoControlPanel nativeVideoControlPanel) {
        ImageView Code = nativeVideoControlPanel.Code();
        this.S = Code;
        if (Code != null) {
            Code.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.j.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.this.f33050k != null) {
                        j.this.f33050k.Code();
                    }
                    if (j.this.f33054o != 10) {
                        j.this.m();
                        return;
                    }
                    gl.Code(j.Z, "linkedVideoMode is " + j.this.f33054o);
                    j.this.p();
                }
            });
            if (nativeVideoControlPanel.V() > 0) {
                this.S.setImageResource(nativeVideoControlPanel.V());
                ay.Code(this.S);
            }
        }
    }

    private void a(boolean z10) {
        this.f33046g = !z10;
        NativeVideoControlPanel nativeVideoControlPanel = this.C;
        if (nativeVideoControlPanel != null) {
            nativeVideoControlPanel.Code(z10);
        }
    }

    private void b(boolean z10) {
        if (this.B == null) {
            return;
        }
        if (z10 || this.f33051l == 1 || this.f33052m) {
            s();
        } else {
            t();
        }
    }

    private void c(boolean z10) {
        VideoView videoView;
        a aVar = this.f33050k;
        if (aVar == null || (videoView = this.B) == null) {
            return;
        }
        aVar.Code(z10, videoView.getCurrentState().V());
    }

    private void d() {
        NativeVideoControlPanel nativeVideoControlPanel = this.C;
        if (nativeVideoControlPanel == null) {
            return;
        }
        this.D = nativeVideoControlPanel.C();
        this.f33040a = this.C.L();
        View F = this.C.F();
        this.f33041b = F;
        if (F != null) {
            F.setClickable(true);
        }
        ImageView S = this.C.S();
        this.L = S;
        if (S != null) {
            S.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.n();
                }
            });
        }
        I(this.C);
        j();
        h();
        a(false);
        F();
    }

    private void d(boolean z10) {
        VideoView videoView;
        a aVar = this.f33050k;
        if (aVar == null || (videoView = this.B) == null) {
            return;
        }
        aVar.V(z10, videoView.getCurrentState().V());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        ba.Code(this.f33044e);
        h();
        if (this.f33054o == 10) {
            p();
        }
        VideoView videoView = this.B;
        if (videoView != null && !videoView.getCurrentState().Code()) {
            f();
        }
        V(false);
    }

    private void f() {
        if (this.L == null) {
            return;
        }
        gl.Code(Z, "showPreviewView");
        Animation animation = this.L.getAnimation();
        if (animation != null) {
            animation.cancel();
        }
        bd.Code((View) this.L, true);
        VideoView videoView = this.B;
        if (videoView != null) {
            videoView.setAlpha(0.0f);
        }
    }

    private void g() {
        VideoView videoView;
        gl.Code(Z, "hidePreviewView");
        bd.Code(this.L, 8, 300, 300);
        if (this.L == null || (videoView = this.B) == null) {
            return;
        }
        videoView.setAlpha(1.0f);
    }

    private void h() {
        View view = this.f33041b;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void i() {
        View view = this.f33041b;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private void j() {
        k();
        Z(this.C);
        V(this.C);
        if (this.f33054o == 10) {
            l();
        }
    }

    private void k() {
        VideoView videoView = this.B;
        if (videoView != null) {
            videoView.Code((gy) this);
            this.B.Code((gu) this);
            this.B.Code((gv) this);
            this.B.Code((e) this);
            this.B.setSurfaceListener(this);
            this.B.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.j.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.o();
                }
            });
        }
    }

    private void l() {
        NativeVideoControlPanel nativeVideoControlPanel = this.C;
        if (nativeVideoControlPanel != null) {
            nativeVideoControlPanel.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.j.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.p();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.B == null) {
            return;
        }
        ba.Code(this.f33044e);
        if (this.B.a()) {
            ba.Code(this.f33043d);
            this.B.L();
            return;
        }
        if (!ai.Z(this.B.getContext())) {
            Toast.makeText(this.B.getContext(), R.string.hiad_network_no_available, 0).show();
            return;
        }
        if (this.f33052m || this.f33051l == 1 || ai.I(this.B.getContext())) {
            V(false);
            r();
        } else {
            gl.V(Z, "non wifi, show alert");
            this.B.L();
            i();
            q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        View.OnClickListener onClickListener = this.f33049j;
        if (onClickListener != null) {
            onClickListener.onClick(this.L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        View.OnClickListener onClickListener;
        VideoView videoView = this.B;
        if (videoView == null || (onClickListener = this.f33049j) == null) {
            return;
        }
        onClickListener.onClick(videoView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        View.OnClickListener onClickListener;
        if (this.B == null || (onClickListener = this.f33049j) == null) {
            return;
        }
        onClickListener.onClick(this.C);
    }

    private void q() {
        Code(false, false);
    }

    private void r() {
        ba.Code(this.f33043d);
        ba.Code(this.f33057r, this.f33043d, com.huawei.openalliance.ad.ipc.c.Code);
    }

    private void s() {
        if (this.B == null) {
            return;
        }
        h();
        if (!this.B.getCurrentState().Code()) {
            f();
        }
        if (this.f33045f && !this.f33048i) {
            V(true);
        } else {
            if (this.B.a()) {
                return;
            }
            F();
        }
    }

    private void t() {
        VideoView videoView = this.B;
        if (videoView != null) {
            if ((!videoView.getCurrentState().Code(com.huawei.openalliance.ad.media.e.PREPARING) && !this.B.a()) || this.f33052m || this.f33051l == 1) {
                return;
            }
            this.B.D();
            if (this.f33041b != null) {
                i();
                q();
            }
        }
    }

    private void u() {
        VideoView videoView = this.B;
        if (videoView != null) {
            if (videoView.getCurrentState().Code(com.huawei.openalliance.ad.media.e.PREPARING) || this.B.a()) {
                this.B.L();
            }
        }
    }

    public void B() {
        gl.Code(Z, "setForImageOnly");
        Code((VideoView) null);
        Code(false, false);
        a(false);
    }

    public void B(int i10) {
        gl.Code(Z, "linkedVideoMode is " + i10);
        this.f33054o = i10;
    }

    public void B(boolean z10) {
        gl.V(Z, "setMuteBtn: " + z10);
        ImageView B = this.C.B();
        if (B != null) {
            B.setSelected(!z10);
        }
    }

    public void C() {
        ba.Code(this.f33044e);
    }

    public void C(boolean z10) {
        if (gl.Code()) {
            gl.Code(Z, "setPlayBtn: %s", Boolean.valueOf(z10));
        }
        ImageView imageView = this.S;
        if (imageView != null) {
            imageView.setEnabled(z10);
        }
    }

    @Override // com.huawei.hms.ads.gu
    public void Code() {
        View view = this.D;
        if (view == null || view.getVisibility() == 0) {
            return;
        }
        this.D.setVisibility(0);
        ImageView imageView = this.S;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
    }

    @Override // com.huawei.hms.ads.gu
    public void Code(int i10) {
    }

    @Override // com.huawei.hms.ads.gy
    public void Code(int i10, int i11) {
        v vVar;
        if (i11 <= 0 || (vVar = this.f33053n) == null) {
            return;
        }
        vVar.Code(i11);
    }

    public void Code(long j10) {
        VideoView videoView;
        String str = Z;
        gl.V(str, "autoPlay - delayMs: %d", Long.valueOf(j10));
        ba.Code(this.f33044e);
        if (!this.f33045f || (videoView = this.B) == null) {
            return;
        }
        if (videoView.a()) {
            gl.Code(str, "autoPlay - video is playing");
            V(true);
        } else {
            gl.Code(str, "autoPlay - start delay runnable");
            this.B.e();
            ba.Code(this.f33055p, this.f33044e, j10);
        }
    }

    public void Code(Bitmap bitmap) {
        ImageView imageView = this.L;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    public void Code(Drawable drawable) {
        ImageView imageView = this.L;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public void Code(View.OnClickListener onClickListener) {
        this.f33049j = onClickListener;
    }

    public void Code(v vVar) {
        this.f33053n = vVar;
    }

    @Override // com.huawei.hms.ads.gy
    public void Code(com.huawei.openalliance.ad.media.b bVar, int i10) {
        NativeVideoControlPanel nativeVideoControlPanel;
        if (this.S != null && (nativeVideoControlPanel = this.C) != null && nativeVideoControlPanel.I() != 0) {
            this.S.setImageResource(this.C.I());
        }
        g();
        if (this.f33046g) {
            Code(false, false);
        } else {
            r();
        }
        a(true);
    }

    @Override // com.huawei.hms.ads.gv
    public void Code(com.huawei.openalliance.ad.media.b bVar, int i10, int i11, int i12) {
        Code(i10, false, false);
    }

    public void Code(NativeVideoControlPanel nativeVideoControlPanel) {
        this.C = nativeVideoControlPanel;
        d();
    }

    public void Code(VideoView videoView) {
        this.B = videoView;
    }

    public void Code(a aVar) {
        this.f33050k = aVar;
    }

    public void Code(String str) {
        VideoView videoView;
        if (this.C == null || (videoView = this.B) == null) {
            return;
        }
        videoView.setVideoFileUrl(str);
    }

    @Override // com.huawei.openalliance.ad.views.e
    public void Code(boolean z10) {
        b(z10);
    }

    public void D() {
        VideoView videoView = this.B;
        if (videoView != null) {
            videoView.L();
        }
    }

    public void F() {
        Code(true, false);
    }

    public void F(boolean z10) {
        this.f33052m = z10;
    }

    @Override // com.huawei.openalliance.ad.views.BaseVideoView.g
    public void I() {
        f();
        a(false);
    }

    public void I(int i10) {
        VideoView videoView = this.B;
        if (videoView != null) {
            videoView.setDefaultDuration(i10);
        }
    }

    @Override // com.huawei.hms.ads.gy
    public void I(com.huawei.openalliance.ad.media.b bVar, int i10) {
        Code(i10, false, false);
    }

    public void I(boolean z10) {
        this.f33045f = z10;
    }

    public void L() {
        this.f33048i = true;
        VideoView videoView = this.B;
        if (videoView != null) {
            videoView.pauseView();
        }
    }

    public void S() {
        VideoView videoView = this.B;
        if (videoView != null) {
            videoView.D();
        }
        h();
        a(false);
        F();
        f();
    }

    public void S(boolean z10) {
        if (z10) {
            Code((String) null);
            V(0);
            I(0);
            Code((Bitmap) null);
        }
        f();
        F();
    }

    @Override // com.huawei.hms.ads.gu
    public void V() {
        View view = this.D;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.D.setVisibility(8);
    }

    public void V(int i10) {
        gl.Code(Z, "setPreferStartPlayTime " + i10);
        this.f33047h = i10;
        VideoView videoView = this.B;
        if (videoView != null) {
            videoView.setPreferStartPlayTime(i10);
        }
    }

    @Override // com.huawei.hms.ads.gy
    public void V(com.huawei.openalliance.ad.media.b bVar, int i10) {
        Code(i10, true, false);
    }

    public void V(boolean z10) {
        if (this.B != null) {
            D(z10);
            this.B.setPreferStartPlayTime(this.f33047h);
            this.B.Code(z10);
        }
    }

    @Override // com.huawei.openalliance.ad.views.e
    public void Z() {
        u();
    }

    public void Z(int i10) {
        this.f33051l = i10;
    }

    @Override // com.huawei.hms.ads.gy
    public void Z(com.huawei.openalliance.ad.media.b bVar, int i10) {
        Code(i10, false, true);
    }

    public void Z(boolean z10) {
        gl.V(Z, "toggleMute: " + z10);
        if (this.B == null || this.C == null) {
            return;
        }
        B(z10);
        if (z10) {
            this.B.b();
        } else {
            this.B.c();
        }
    }

    public void a() {
        this.f33048i = false;
        VideoView videoView = this.B;
        if (videoView != null) {
            videoView.resumeView();
        }
    }
}
