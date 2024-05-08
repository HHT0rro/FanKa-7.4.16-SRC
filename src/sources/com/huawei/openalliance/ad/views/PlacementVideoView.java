package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.gu;
import com.huawei.hms.ads.gv;
import com.huawei.hms.ads.gx;
import com.huawei.hms.ads.gy;
import com.huawei.hms.ads.gz;
import com.huawei.hms.ads.ha;
import com.huawei.hms.ads.hb;
import com.huawei.hms.ads.hk;
import com.huawei.hms.ads.ic;
import com.huawei.hms.ads.io;
import com.huawei.hms.ads.ka;
import com.huawei.hms.ads.kn;
import com.huawei.hms.ads.lv;
import com.huawei.hms.ads.placement.R;
import com.huawei.openalliance.ad.inter.data.p;
import com.huawei.openalliance.ad.inter.data.r;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PlacementVideoView extends PlacementMediaView implements lv {
    private kn D;
    private VideoView L;

    /* renamed from: a, reason: collision with root package name */
    private boolean f32956a;

    /* renamed from: b, reason: collision with root package name */
    private r f32957b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f32958c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f32959d;

    /* renamed from: e, reason: collision with root package name */
    private long f32960e;

    /* renamed from: f, reason: collision with root package name */
    private long f32961f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f32962g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f32963h;

    /* renamed from: i, reason: collision with root package name */
    private int f32964i;

    /* renamed from: j, reason: collision with root package name */
    private hk f32965j;

    /* renamed from: k, reason: collision with root package name */
    private io f32966k;

    /* renamed from: l, reason: collision with root package name */
    private gu f32967l;

    /* renamed from: m, reason: collision with root package name */
    private gy f32968m;

    /* renamed from: n, reason: collision with root package name */
    private gz f32969n;

    /* renamed from: o, reason: collision with root package name */
    private gv f32970o;

    public PlacementVideoView(Context context) {
        super(context);
        this.f32959d = true;
        this.f32966k = new ic();
        this.f32967l = new gu() { // from class: com.huawei.openalliance.ad.views.PlacementVideoView.1
            @Override // com.huawei.hms.ads.gu
            public void Code() {
                if (gl.Code()) {
                    gl.Code(PlacementVideoView.this.getTAG(), "contentId: %s onBufferingStart", ((PlacementMediaView) PlacementVideoView.this).I);
                }
                PlacementVideoView.this.f32965j.V();
                PlacementVideoView.this.f32966k.b();
            }

            @Override // com.huawei.hms.ads.gu
            public void Code(int i10) {
            }

            @Override // com.huawei.hms.ads.gu
            public void V() {
                PlacementVideoView.this.f32966k.c();
            }
        };
        this.f32968m = new gy() { // from class: com.huawei.openalliance.ad.views.PlacementVideoView.2
            @Override // com.huawei.hms.ads.gy
            public void Code(int i10, int i11) {
            }

            @Override // com.huawei.hms.ads.gy
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i10) {
                if (gl.Code()) {
                    gl.Code(PlacementVideoView.this.getTAG(), "contentId: %s onMediaStart:  %s", ((PlacementMediaView) PlacementVideoView.this).I, Integer.valueOf(i10));
                }
                PlacementVideoView.this.f32962g = true;
                PlacementVideoView.this.f32961f = i10;
                PlacementVideoView.this.f32960e = System.currentTimeMillis();
                kn knVar = PlacementVideoView.this.D;
                if (i10 > 0) {
                    knVar.V();
                } else {
                    knVar.Code();
                    PlacementVideoView.this.D.Code(PlacementVideoView.this.f32965j.B(), PlacementVideoView.this.f32965j.Z(), PlacementVideoView.this.f32960e);
                }
            }

            @Override // com.huawei.hms.ads.gy
            public void I(com.huawei.openalliance.ad.media.b bVar, int i10) {
                gl.V("PlacementVideoView", "onMediaStop");
                PlacementVideoView.this.Code(i10, false);
            }

            @Override // com.huawei.hms.ads.gy
            public void V(com.huawei.openalliance.ad.media.b bVar, int i10) {
                gl.V("PlacementVideoView", "onMediaPause");
                PlacementVideoView.this.Code(i10, false);
            }

            @Override // com.huawei.hms.ads.gy
            public void Z(com.huawei.openalliance.ad.media.b bVar, int i10) {
                gl.V("PlacementVideoView", "onMediaCompletion");
                PlacementVideoView.this.Code(i10, true);
            }
        };
        this.f32969n = new gz() { // from class: com.huawei.openalliance.ad.views.PlacementVideoView.3
            @Override // com.huawei.hms.ads.gz
            public void Code() {
                if (PlacementVideoView.this.f32957b != null) {
                    PlacementVideoView.this.f32957b.Code("n");
                    PlacementVideoView.this.f32966k.V(0.0f);
                }
            }

            @Override // com.huawei.hms.ads.gz
            public void V() {
                if (PlacementVideoView.this.f32957b != null) {
                    PlacementVideoView.this.f32957b.Code("y");
                    PlacementVideoView.this.f32966k.V(1.0f);
                }
            }
        };
        this.f32970o = new gv() { // from class: com.huawei.openalliance.ad.views.PlacementVideoView.4
            @Override // com.huawei.hms.ads.gv
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i10, int i11, int i12) {
                PlacementVideoView.this.Code(i10, false);
            }
        };
        Code(context);
    }

    public PlacementVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f32959d = true;
        this.f32966k = new ic();
        this.f32967l = new gu() { // from class: com.huawei.openalliance.ad.views.PlacementVideoView.1
            @Override // com.huawei.hms.ads.gu
            public void Code() {
                if (gl.Code()) {
                    gl.Code(PlacementVideoView.this.getTAG(), "contentId: %s onBufferingStart", ((PlacementMediaView) PlacementVideoView.this).I);
                }
                PlacementVideoView.this.f32965j.V();
                PlacementVideoView.this.f32966k.b();
            }

            @Override // com.huawei.hms.ads.gu
            public void Code(int i10) {
            }

            @Override // com.huawei.hms.ads.gu
            public void V() {
                PlacementVideoView.this.f32966k.c();
            }
        };
        this.f32968m = new gy() { // from class: com.huawei.openalliance.ad.views.PlacementVideoView.2
            @Override // com.huawei.hms.ads.gy
            public void Code(int i10, int i11) {
            }

            @Override // com.huawei.hms.ads.gy
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i10) {
                if (gl.Code()) {
                    gl.Code(PlacementVideoView.this.getTAG(), "contentId: %s onMediaStart:  %s", ((PlacementMediaView) PlacementVideoView.this).I, Integer.valueOf(i10));
                }
                PlacementVideoView.this.f32962g = true;
                PlacementVideoView.this.f32961f = i10;
                PlacementVideoView.this.f32960e = System.currentTimeMillis();
                kn knVar = PlacementVideoView.this.D;
                if (i10 > 0) {
                    knVar.V();
                } else {
                    knVar.Code();
                    PlacementVideoView.this.D.Code(PlacementVideoView.this.f32965j.B(), PlacementVideoView.this.f32965j.Z(), PlacementVideoView.this.f32960e);
                }
            }

            @Override // com.huawei.hms.ads.gy
            public void I(com.huawei.openalliance.ad.media.b bVar, int i10) {
                gl.V("PlacementVideoView", "onMediaStop");
                PlacementVideoView.this.Code(i10, false);
            }

            @Override // com.huawei.hms.ads.gy
            public void V(com.huawei.openalliance.ad.media.b bVar, int i10) {
                gl.V("PlacementVideoView", "onMediaPause");
                PlacementVideoView.this.Code(i10, false);
            }

            @Override // com.huawei.hms.ads.gy
            public void Z(com.huawei.openalliance.ad.media.b bVar, int i10) {
                gl.V("PlacementVideoView", "onMediaCompletion");
                PlacementVideoView.this.Code(i10, true);
            }
        };
        this.f32969n = new gz() { // from class: com.huawei.openalliance.ad.views.PlacementVideoView.3
            @Override // com.huawei.hms.ads.gz
            public void Code() {
                if (PlacementVideoView.this.f32957b != null) {
                    PlacementVideoView.this.f32957b.Code("n");
                    PlacementVideoView.this.f32966k.V(0.0f);
                }
            }

            @Override // com.huawei.hms.ads.gz
            public void V() {
                if (PlacementVideoView.this.f32957b != null) {
                    PlacementVideoView.this.f32957b.Code("y");
                    PlacementVideoView.this.f32966k.V(1.0f);
                }
            }
        };
        this.f32970o = new gv() { // from class: com.huawei.openalliance.ad.views.PlacementVideoView.4
            @Override // com.huawei.hms.ads.gv
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i10, int i11, int i12) {
                PlacementVideoView.this.Code(i10, false);
            }
        };
        Code(context);
    }

    public PlacementVideoView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f32959d = true;
        this.f32966k = new ic();
        this.f32967l = new gu() { // from class: com.huawei.openalliance.ad.views.PlacementVideoView.1
            @Override // com.huawei.hms.ads.gu
            public void Code() {
                if (gl.Code()) {
                    gl.Code(PlacementVideoView.this.getTAG(), "contentId: %s onBufferingStart", ((PlacementMediaView) PlacementVideoView.this).I);
                }
                PlacementVideoView.this.f32965j.V();
                PlacementVideoView.this.f32966k.b();
            }

            @Override // com.huawei.hms.ads.gu
            public void Code(int i102) {
            }

            @Override // com.huawei.hms.ads.gu
            public void V() {
                PlacementVideoView.this.f32966k.c();
            }
        };
        this.f32968m = new gy() { // from class: com.huawei.openalliance.ad.views.PlacementVideoView.2
            @Override // com.huawei.hms.ads.gy
            public void Code(int i102, int i11) {
            }

            @Override // com.huawei.hms.ads.gy
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i102) {
                if (gl.Code()) {
                    gl.Code(PlacementVideoView.this.getTAG(), "contentId: %s onMediaStart:  %s", ((PlacementMediaView) PlacementVideoView.this).I, Integer.valueOf(i102));
                }
                PlacementVideoView.this.f32962g = true;
                PlacementVideoView.this.f32961f = i102;
                PlacementVideoView.this.f32960e = System.currentTimeMillis();
                kn knVar = PlacementVideoView.this.D;
                if (i102 > 0) {
                    knVar.V();
                } else {
                    knVar.Code();
                    PlacementVideoView.this.D.Code(PlacementVideoView.this.f32965j.B(), PlacementVideoView.this.f32965j.Z(), PlacementVideoView.this.f32960e);
                }
            }

            @Override // com.huawei.hms.ads.gy
            public void I(com.huawei.openalliance.ad.media.b bVar, int i102) {
                gl.V("PlacementVideoView", "onMediaStop");
                PlacementVideoView.this.Code(i102, false);
            }

            @Override // com.huawei.hms.ads.gy
            public void V(com.huawei.openalliance.ad.media.b bVar, int i102) {
                gl.V("PlacementVideoView", "onMediaPause");
                PlacementVideoView.this.Code(i102, false);
            }

            @Override // com.huawei.hms.ads.gy
            public void Z(com.huawei.openalliance.ad.media.b bVar, int i102) {
                gl.V("PlacementVideoView", "onMediaCompletion");
                PlacementVideoView.this.Code(i102, true);
            }
        };
        this.f32969n = new gz() { // from class: com.huawei.openalliance.ad.views.PlacementVideoView.3
            @Override // com.huawei.hms.ads.gz
            public void Code() {
                if (PlacementVideoView.this.f32957b != null) {
                    PlacementVideoView.this.f32957b.Code("n");
                    PlacementVideoView.this.f32966k.V(0.0f);
                }
            }

            @Override // com.huawei.hms.ads.gz
            public void V() {
                if (PlacementVideoView.this.f32957b != null) {
                    PlacementVideoView.this.f32957b.Code("y");
                    PlacementVideoView.this.f32966k.V(1.0f);
                }
            }
        };
        this.f32970o = new gv() { // from class: com.huawei.openalliance.ad.views.PlacementVideoView.4
            @Override // com.huawei.hms.ads.gv
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i102, int i11, int i12) {
                PlacementVideoView.this.Code(i102, false);
            }
        };
        Code(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(int i10, boolean z10) {
        gl.V("PlacementVideoView", "onVideoEnd, videoComplete: %s", Boolean.valueOf(z10));
        this.f32965j.I();
        if (this.f32962g) {
            this.f32962g = false;
            setPreferStartPlayTime(i10);
            if (z10) {
                this.D.Code(this.f32960e, System.currentTimeMillis(), this.f32961f, i10);
            } else {
                this.D.V(this.f32960e, System.currentTimeMillis(), this.f32961f, i10);
            }
        }
    }

    private void Code(Context context) {
        LayoutInflater.from(context).inflate(R.layout.hiad_placement_pure_video_view, this);
        this.D = new ka(context, this);
        this.f32965j = new hk(getTAG());
        VideoView videoView = (VideoView) findViewById(R.id.hiad_id_video_view);
        this.L = videoView;
        videoView.setScreenOnWhilePlaying(true);
        this.L.setAutoScaleResizeLayoutOnVideoSizeChange(false);
        this.L.Code(this.f32968m);
        this.L.Code(this.f32967l);
        this.L.Code(this.f32970o);
        this.L.Code(this.f32969n);
        this.L.setMuteOnlyOnLostAudioFocus(true);
        this.L.setRemediate(true);
    }

    private void L() {
        if (((PlacementMediaView) this).Code == null) {
            return;
        }
        gl.V(getTAG(), "loadVideoInfo");
        r S = ((PlacementMediaView) this).Code.S();
        if (S == null || !S.V()) {
            return;
        }
        this.f32957b = S;
        Float f10 = S.f();
        if (f10 != null) {
            setRatio(f10);
            this.L.setRatio(f10);
        }
        this.L.setDefaultDuration((int) this.f32957b.d());
        this.D.Code(this.f32957b);
        this.f32958c = false;
        this.f32959d = true;
    }

    private void V(boolean z10, boolean z11) {
        gl.V(getTAG(), "doRealPlay, auto:" + z10 + ", isMute:" + z11);
        this.f32965j.Code();
        if (z11) {
            this.L.b();
        } else {
            this.L.c();
        }
        if (!this.L.getCurrentState().Code(com.huawei.openalliance.ad.media.e.PLAYBACK_COMPLETED)) {
            this.L.setPreferStartPlayTime(this.f32964i);
        } else if (Build.VERSION.SDK_INT >= 26) {
            this.L.I(this.f32964i, 1);
        } else {
            this.L.Code(this.f32964i);
        }
        this.L.Code(z10);
    }

    private void a() {
        gl.V(getTAG(), "resetVideoView");
        setPreferStartPlayTime(0);
        this.f32956a = false;
        this.f32958c = false;
        this.f32959d = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getTAG() {
        return "PlacementVideoView_" + hashCode();
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void B() {
        this.f32963h = false;
        this.L.c();
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void C() {
        this.L.L();
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void Code() {
        this.L.B();
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void Code(int i10) {
        Code(i10, true);
        this.L.B();
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void Code(long j10) {
        this.D.Code(j10);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void Code(gu guVar) {
        this.L.Code(guVar);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void Code(gv gvVar) {
        this.L.Code(gvVar);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void Code(gz gzVar) {
        this.L.Code(gzVar);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void Code(ha haVar) {
        this.L.Code(haVar);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void Code(hb hbVar) {
        this.L.Code(hbVar);
    }

    public void Code(io ioVar) {
        this.f32966k = ioVar;
    }

    @Override // com.huawei.hms.ads.lv
    public void Code(r rVar, boolean z10) {
        gl.V(getTAG(), "onCheckVideoHashResult sucess: %s", Boolean.valueOf(z10));
        if (!z10 || this.f32957b == null || rVar == null) {
            return;
        }
        this.f32957b = rVar;
        this.f32956a = true;
        String e2 = rVar.e();
        if (TextUtils.isEmpty(e2)) {
            e2 = rVar.Z();
        }
        ((PlacementMediaView) this).V = e2;
        this.L.setVideoFileUrl(e2);
        VideoView videoView = this.L;
        p pVar = ((PlacementMediaView) this).Code;
        videoView.setContentId(pVar == null ? null : pVar.D());
        if (this.f32958c) {
            gl.V(getTAG(), "play when hash check success");
            V(true, this.f32963h);
        }
        if (this.f32959d) {
            gl.V(getTAG(), "prefect when hash check success");
            this.L.e();
        }
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void Code(String str) {
        this.D.Code(str);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void Code(boolean z10, boolean z11) {
        gl.V(getTAG(), "play, auto:" + z10 + ", isMute:" + z11);
        if (this.f32956a) {
            V(z10, z11);
        } else {
            this.f32958c = true;
            this.f32963h = z11;
        }
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public boolean F() {
        return this.L.a();
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void I() {
        this.f32963h = true;
        this.L.b();
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void I(hb hbVar) {
        this.L.I(hbVar);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void S() {
        this.L.D();
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void V() {
        if (this.L != null) {
            gl.V("PlacementVideoView", "release player");
            this.L.f();
        }
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void V(gz gzVar) {
        this.L.V(gzVar);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView, com.huawei.hms.ads.lz
    public void destroyView() {
        gl.V(getTAG(), "destroyView");
        this.L.destroyView();
        this.f32966k.I();
    }

    public com.huawei.openalliance.ad.media.c getCurrentState() {
        return this.L.getCurrentState();
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public ImageView getLastFrame() {
        if (this.L == null) {
            return null;
        }
        ImageView imageView = new ImageView(getContext());
        imageView.setImageBitmap(this.L.getSurfaceBitmap());
        return imageView;
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public com.huawei.openalliance.ad.media.c getMediaState() {
        VideoView videoView = this.L;
        if (videoView != null) {
            return videoView.getMediaState();
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView, com.huawei.hms.ads.hy
    public View getOpenMeasureView() {
        return this;
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView, com.huawei.hms.ads.lz
    public void pauseView() {
        gl.V(getTAG(), "pauseView");
        this.L.pauseView();
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView, com.huawei.hms.ads.lz
    public void resumeView() {
        gl.V(getTAG(), "resumeView");
        this.L.resumeView();
        this.L.setNeedPauseOnSurfaceDestory(true);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void setAudioFocusType(int i10) {
        this.L.setAudioFocusType(i10);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void setMediaPlayerReleaseListener(gx gxVar) {
        VideoView videoView = this.L;
        if (videoView != null) {
            videoView.setMediaPlayerReleaseListener(gxVar);
        }
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void setPlacementAd(com.huawei.openalliance.ad.inter.data.h hVar) {
        com.huawei.openalliance.ad.media.c currentState = this.L.getCurrentState();
        if (((PlacementMediaView) this).Code == hVar && currentState.V(com.huawei.openalliance.ad.media.e.IDLE) && currentState.V(com.huawei.openalliance.ad.media.e.ERROR)) {
            gl.V(getTAG(), "setPlacementVideoAd - has the same ad");
            return;
        }
        super.setPlacementAd(hVar);
        String tag = getTAG();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("set placement ad:");
        sb2.append(hVar == null ? "null" : hVar.D());
        gl.V(tag, sb2.toString());
        a();
        this.D.Code(((PlacementMediaView) this).Code);
        if (((PlacementMediaView) this).Code != null) {
            L();
        } else {
            this.f32957b = null;
        }
    }

    public void setPreferStartPlayTime(int i10) {
        this.f32964i = i10;
        this.L.setPreferStartPlayTime(i10);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void setSoundVolume(float f10) {
        this.L.setSoundVolume(f10);
    }
}
