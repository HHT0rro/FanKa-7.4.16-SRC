package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.gu;
import com.huawei.hms.ads.gv;
import com.huawei.hms.ads.gx;
import com.huawei.hms.ads.gz;
import com.huawei.hms.ads.ha;
import com.huawei.hms.ads.hb;
import com.huawei.hms.ads.hy;
import com.huawei.hms.ads.lu;
import com.huawei.hms.ads.lz;
import com.huawei.openalliance.ad.inter.data.p;
import com.huawei.openalliance.ad.inter.data.r;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.v;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class PlacementMediaView extends AutoScaleSizeRelativeLayout implements hy, lu, lz {
    public boolean B;
    public boolean C;
    public p Code;
    public String I;
    public boolean S;
    public String V;

    /* renamed from: b, reason: collision with root package name */
    private r f32946b;

    /* renamed from: c, reason: collision with root package name */
    private final Set<hb> f32947c;

    /* renamed from: d, reason: collision with root package name */
    private int f32948d;

    /* renamed from: e, reason: collision with root package name */
    private long f32949e;

    /* renamed from: f, reason: collision with root package name */
    private long f32950f;

    /* renamed from: g, reason: collision with root package name */
    private long f32951g;

    /* renamed from: h, reason: collision with root package name */
    private long f32952h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f32953i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f32954j;

    /* renamed from: k, reason: collision with root package name */
    private Handler f32955k;

    public PlacementMediaView(Context context) {
        super(context);
        this.f32947c = new CopyOnWriteArraySet();
        this.f32948d = 0;
        this.f32949e = 0L;
        this.f32950f = 0L;
        this.f32951g = 0L;
        this.f32953i = false;
        this.f32954j = false;
        this.B = false;
        this.C = false;
        this.S = false;
        this.f32955k = new Handler(Looper.myLooper()) { // from class: com.huawei.openalliance.ad.views.PlacementMediaView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                String str;
                try {
                    if (1 == message.what) {
                        PlacementMediaView.this.f32948d = (int) ((v.Code() - PlacementMediaView.this.f32949e) - PlacementMediaView.this.f32952h);
                        if (PlacementMediaView.this.e()) {
                            PlacementMediaView.this.d();
                        } else {
                            PlacementMediaView.this.b();
                            PlacementMediaView.this.f32955k.removeMessages(1);
                            PlacementMediaView.this.f32955k.sendEmptyMessageDelayed(1, 100L);
                        }
                    }
                } catch (IllegalStateException unused) {
                    str = "handleMessage IllegalStateException";
                    gl.I("PlacementMediaView", str);
                } catch (Throwable th) {
                    str = "handleMessage " + th.getClass().getSimpleName();
                    gl.I("PlacementMediaView", str);
                }
            }
        };
    }

    public PlacementMediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f32947c = new CopyOnWriteArraySet();
        this.f32948d = 0;
        this.f32949e = 0L;
        this.f32950f = 0L;
        this.f32951g = 0L;
        this.f32953i = false;
        this.f32954j = false;
        this.B = false;
        this.C = false;
        this.S = false;
        this.f32955k = new Handler(Looper.myLooper()) { // from class: com.huawei.openalliance.ad.views.PlacementMediaView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                String str;
                try {
                    if (1 == message.what) {
                        PlacementMediaView.this.f32948d = (int) ((v.Code() - PlacementMediaView.this.f32949e) - PlacementMediaView.this.f32952h);
                        if (PlacementMediaView.this.e()) {
                            PlacementMediaView.this.d();
                        } else {
                            PlacementMediaView.this.b();
                            PlacementMediaView.this.f32955k.removeMessages(1);
                            PlacementMediaView.this.f32955k.sendEmptyMessageDelayed(1, 100L);
                        }
                    }
                } catch (IllegalStateException unused) {
                    str = "handleMessage IllegalStateException";
                    gl.I("PlacementMediaView", str);
                } catch (Throwable th) {
                    str = "handleMessage " + th.getClass().getSimpleName();
                    gl.I("PlacementMediaView", str);
                }
            }
        };
    }

    public PlacementMediaView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f32947c = new CopyOnWriteArraySet();
        this.f32948d = 0;
        this.f32949e = 0L;
        this.f32950f = 0L;
        this.f32951g = 0L;
        this.f32953i = false;
        this.f32954j = false;
        this.B = false;
        this.C = false;
        this.S = false;
        this.f32955k = new Handler(Looper.myLooper()) { // from class: com.huawei.openalliance.ad.views.PlacementMediaView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                String str;
                try {
                    if (1 == message.what) {
                        PlacementMediaView.this.f32948d = (int) ((v.Code() - PlacementMediaView.this.f32949e) - PlacementMediaView.this.f32952h);
                        if (PlacementMediaView.this.e()) {
                            PlacementMediaView.this.d();
                        } else {
                            PlacementMediaView.this.b();
                            PlacementMediaView.this.f32955k.removeMessages(1);
                            PlacementMediaView.this.f32955k.sendEmptyMessageDelayed(1, 100L);
                        }
                    }
                } catch (IllegalStateException unused) {
                    str = "handleMessage IllegalStateException";
                    gl.I("PlacementMediaView", str);
                } catch (Throwable th) {
                    str = "handleMessage " + th.getClass().getSimpleName();
                    gl.I("PlacementMediaView", str);
                }
            }
        };
    }

    private void L() {
        this.f32948d = 0;
        this.f32949e = 0L;
        this.f32951g = 0L;
        this.f32950f = 0L;
        this.f32952h = 0L;
        this.f32953i = false;
        this.f32954j = false;
        this.C = false;
        this.B = false;
        this.S = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.f32953i) {
            return;
        }
        this.f32953i = true;
        Iterator<hb> iterator2 = this.f32947c.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().Code(this.I, this.V, this.f32948d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.f32950f <= 0 || this.f32954j) {
            return;
        }
        for (hb hbVar : this.f32947c) {
            String str = this.I;
            String str2 = this.V;
            int i10 = this.f32948d;
            hbVar.Code(str, str2, (int) (i10 / this.f32950f), i10);
        }
    }

    private void c() {
        Iterator<hb> iterator2 = this.f32947c.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().V(this.I, this.V, this.f32948d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.f32953i = false;
        Iterator<hb> iterator2 = this.f32947c.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().Z(this.I, this.V, this.f32948d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        return ((long) this.f32948d) >= this.f32950f;
    }

    public void B() {
    }

    public void C() {
        this.f32955k.removeMessages(1);
        this.f32951g = v.Code();
        c();
    }

    abstract void Code();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void Code(int i10);

    public void Code(long j10) {
    }

    public void Code(gu guVar) {
    }

    public void Code(gv gvVar) {
    }

    public void Code(gz gzVar) {
    }

    public void Code(ha haVar) {
    }

    public void Code(hb hbVar) {
        if (hbVar != null) {
            this.f32947c.add(hbVar);
        }
    }

    public void Code(String str) {
    }

    public void Code(boolean z10, boolean z11) {
        gl.V("PlacementMediaView", "play, mediaCached: %s, mediaAvalible: %s", Boolean.valueOf(this.B), Boolean.valueOf(this.C));
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PlacementMediaView.2
            @Override // java.lang.Runnable
            public void run() {
                PlacementMediaView placementMediaView = PlacementMediaView.this;
                if (!placementMediaView.B) {
                    placementMediaView.S = true;
                    return;
                }
                if (!placementMediaView.C) {
                    placementMediaView.D();
                    return;
                }
                placementMediaView.f32955k.removeMessages(1);
                PlacementMediaView.this.f32955k.sendEmptyMessage(1);
                PlacementMediaView.this.a();
                if (0 == PlacementMediaView.this.f32949e) {
                    PlacementMediaView.this.f32949e = v.Code();
                }
                if (PlacementMediaView.this.f32951g != 0) {
                    PlacementMediaView.this.f32952h += v.Code() - PlacementMediaView.this.f32951g;
                }
            }
        }, 1L);
    }

    public void D() {
        this.f32953i = false;
        this.f32954j = true;
        Iterator<hb> iterator2 = this.f32947c.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().Code(this.I, this.V, 0, -1, -1);
        }
    }

    public boolean F() {
        return false;
    }

    public void I() {
    }

    public void I(hb hbVar) {
    }

    public void S() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void V();

    public void V(gz gzVar) {
    }

    public void destroyView() {
        this.f32955k.removeMessages(1);
        this.f32947c.clear();
        Code();
    }

    public long getDuration() {
        r S;
        p pVar = this.Code;
        if (pVar == null || (S = pVar.S()) == null) {
            return 0L;
        }
        return S.d();
    }

    public abstract ImageView getLastFrame();

    public abstract com.huawei.openalliance.ad.media.c getMediaState();

    @Override // com.huawei.hms.ads.hy
    public View getOpenMeasureView() {
        return this;
    }

    public com.huawei.openalliance.ad.inter.data.h getPlacementAd() {
        return this.Code;
    }

    @Override // com.huawei.hms.ads.lz
    public void pauseView() {
    }

    @Override // com.huawei.hms.ads.lz
    public void resumeView() {
    }

    public void setAudioFocusType(int i10) {
    }

    public abstract void setMediaPlayerReleaseListener(gx gxVar);

    public void setPlacementAd(com.huawei.openalliance.ad.inter.data.h hVar) {
        String str;
        L();
        if (hVar instanceof p) {
            p pVar = (p) hVar;
            this.Code = pVar;
            r S = pVar.S();
            this.f32946b = S;
            this.f32950f = S.d();
            this.V = this.f32946b.Z();
            str = hVar.D();
        } else {
            this.Code = null;
            this.f32946b = null;
            this.f32955k.removeMessages(1);
            str = "";
            this.V = "";
        }
        this.I = str;
    }

    public void setSoundVolume(float f10) {
    }
}
