package com.huawei.openalliance.ad.views;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.Surface;
import android.view.TextureView;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.gu;
import com.huawei.hms.ads.gv;
import com.huawei.hms.ads.gw;
import com.huawei.hms.ads.gx;
import com.huawei.hms.ads.gy;
import com.huawei.hms.ads.gz;
import com.huawei.hms.ads.ha;
import com.huawei.hms.ads.hb;
import com.huawei.hms.ads.lz;
import com.huawei.openalliance.ad.constant.cj;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.media.IMultiMediaPlayingManager;
import com.huawei.openalliance.ad.utils.ai;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.bc;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@com.huawei.openalliance.ad.annotations.b
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class BaseVideoView extends AutoScaleSizeRelativeLayout implements TextureView.SurfaceTextureListener, lz {
    private static final String V = BaseVideoView.class.getSimpleName();
    private boolean A;
    private IMultiMediaPlayingManager B;
    private final Set<com.huawei.openalliance.ad.views.e> C;
    private ha Code;
    private final Set<gz> D;
    private boolean E;
    private final Set<gu> F;
    private boolean G;
    private boolean H;
    private int I;
    private f J;
    private String K;
    private final Set<gv> L;
    private gy M;
    private gu N;
    private gv O;
    private gz P;
    private gw Q;
    private d R;
    private final Set<gy> S;
    private a T;
    private b U;
    private e W;

    /* renamed from: a, reason: collision with root package name */
    private final Set<gw> f32635a;

    /* renamed from: aa, reason: collision with root package name */
    private c f32636aa;

    /* renamed from: ab, reason: collision with root package name */
    private BroadcastReceiver f32637ab;

    /* renamed from: b, reason: collision with root package name */
    public TextureView f32638b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f32639c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f32640d;

    /* renamed from: e, reason: collision with root package name */
    public com.huawei.openalliance.ad.media.b f32641e;

    /* renamed from: f, reason: collision with root package name */
    public com.huawei.openalliance.ad.media.b f32642f;

    /* renamed from: g, reason: collision with root package name */
    public Surface f32643g;

    /* renamed from: h, reason: collision with root package name */
    public SurfaceTexture f32644h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f32645i;

    /* renamed from: j, reason: collision with root package name */
    public int f32646j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f32647k;

    /* renamed from: l, reason: collision with root package name */
    public MediaPlayer.OnVideoSizeChangedListener f32648l;

    /* renamed from: m, reason: collision with root package name */
    public int f32649m;

    /* renamed from: n, reason: collision with root package name */
    public int f32650n;

    /* renamed from: o, reason: collision with root package name */
    public i f32651o;

    /* renamed from: p, reason: collision with root package name */
    private final Set<hb> f32652p;

    /* renamed from: q, reason: collision with root package name */
    private final Set<hb> f32653q;

    /* renamed from: r, reason: collision with root package name */
    private final Set<ha> f32654r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f32655s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f32656t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f32657u;

    /* renamed from: v, reason: collision with root package name */
    private String f32658v;

    /* renamed from: w, reason: collision with root package name */
    private String[] f32659w;

    /* renamed from: x, reason: collision with root package name */
    private int f32660x;

    /* renamed from: y, reason: collision with root package name */
    private SparseBooleanArray f32661y;

    /* renamed from: z, reason: collision with root package name */
    private g f32662z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements gu {
        private WeakReference<gu> Code;

        public a(gu guVar) {
            this.Code = new WeakReference<>(guVar);
        }

        @Override // com.huawei.hms.ads.gu
        public void Code() {
            gu guVar = this.Code.get();
            if (guVar != null) {
                guVar.Code();
            }
        }

        @Override // com.huawei.hms.ads.gu
        public void Code(int i10) {
            gu guVar = this.Code.get();
            if (guVar != null) {
                guVar.Code(i10);
            }
        }

        @Override // com.huawei.hms.ads.gu
        public void V() {
            gu guVar = this.Code.get();
            if (guVar != null) {
                guVar.V();
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b implements gv {
        private WeakReference<gv> Code;

        public b(gv gvVar) {
            this.Code = new WeakReference<>(gvVar);
        }

        @Override // com.huawei.hms.ads.gv
        public void Code(com.huawei.openalliance.ad.media.b bVar, int i10, int i11, int i12) {
            gv gvVar = this.Code.get();
            if (gvVar != null) {
                gvVar.Code(bVar, i10, i11, i12);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class c implements gw {
        private WeakReference<gw> Code;

        public c(gw gwVar) {
            this.Code = new WeakReference<>(gwVar);
        }

        @Override // com.huawei.hms.ads.gw
        public void Code(int i10) {
            gw gwVar = this.Code.get();
            if (gwVar != null) {
                gwVar.Code(i10);
            }
        }

        @Override // com.huawei.hms.ads.gw
        public void V(int i10) {
            gw gwVar = this.Code.get();
            if (gwVar != null) {
                gwVar.V(i10);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class d implements gy {
        private WeakReference<gy> Code;

        public d(gy gyVar) {
            this.Code = new WeakReference<>(gyVar);
        }

        @Override // com.huawei.hms.ads.gy
        public void Code(int i10, int i11) {
            gy gyVar = this.Code.get();
            if (gyVar != null) {
                gyVar.Code(i10, i11);
            }
        }

        @Override // com.huawei.hms.ads.gy
        public void Code(com.huawei.openalliance.ad.media.b bVar, int i10) {
            gl.Code(BaseVideoView.V, "onMediaStart %s", Integer.valueOf(i10));
            gy gyVar = this.Code.get();
            if (gyVar != null) {
                gyVar.Code(bVar, i10);
            }
        }

        @Override // com.huawei.hms.ads.gy
        public void I(com.huawei.openalliance.ad.media.b bVar, int i10) {
            gl.Code(BaseVideoView.V, "onMediaStop %s", Integer.valueOf(i10));
            gy gyVar = this.Code.get();
            if (gyVar != null) {
                gyVar.I(bVar, i10);
            }
        }

        @Override // com.huawei.hms.ads.gy
        public void V(com.huawei.openalliance.ad.media.b bVar, int i10) {
            gl.Code(BaseVideoView.V, "onMediaPause %s", Integer.valueOf(i10));
            gy gyVar = this.Code.get();
            if (gyVar != null) {
                gyVar.V(bVar, i10);
            }
        }

        @Override // com.huawei.hms.ads.gy
        public void Z(com.huawei.openalliance.ad.media.b bVar, int i10) {
            gl.Code(BaseVideoView.V, "onMediaCompletion %s", Integer.valueOf(i10));
            gy gyVar = this.Code.get();
            if (gyVar != null) {
                gyVar.Z(bVar, i10);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class e implements gz {
        private WeakReference<gz> Code;

        public e(gz gzVar) {
            this.Code = new WeakReference<>(gzVar);
        }

        @Override // com.huawei.hms.ads.gz
        public void Code() {
            gz gzVar = this.Code.get();
            if (gzVar != null) {
                gzVar.Code();
            }
        }

        @Override // com.huawei.hms.ads.gz
        public void V() {
            gz gzVar = this.Code.get();
            if (gzVar != null) {
                gzVar.V();
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class f implements ha {
        public WeakReference<ha> Code;

        public f(ha haVar) {
            this.Code = new WeakReference<>(haVar);
        }

        @Override // com.huawei.hms.ads.ha
        public void Code() {
            ha haVar = this.Code.get();
            if (haVar != null) {
                haVar.Code();
            }
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface g {
        void I();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class h implements MediaPlayer.OnVideoSizeChangedListener {
        private WeakReference<MediaPlayer.OnVideoSizeChangedListener> Code;

        public h(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
            this.Code = new WeakReference<>(onVideoSizeChangedListener);
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i10, int i11) {
            MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener = this.Code.get();
            if (onVideoSizeChangedListener != null) {
                onVideoSizeChangedListener.onVideoSizeChanged(mediaPlayer, i10, i11);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class i implements MediaPlayer.OnVideoSizeChangedListener {
        public float Code = 0.0f;
        public float V = 0.0f;

        public i() {
        }

        public void Code(int i10, int i11) {
            gl.V(BaseVideoView.V, "video size changed - w: %d h: %d", Integer.valueOf(i10), Integer.valueOf(i11));
            if (i10 == 0 || i11 == 0) {
                return;
            }
            BaseVideoView baseVideoView = BaseVideoView.this;
            baseVideoView.f32649m = i10;
            baseVideoView.f32650n = i11;
            float f10 = (i10 * 1.0f) / i11;
            float abs = Math.abs(f10 - this.Code);
            if (gl.Code()) {
                gl.Code(BaseVideoView.V, "video ratio: %f oldRatio: %f diff: %f", Float.valueOf(f10), Float.valueOf(this.Code), Float.valueOf(abs));
            }
            this.Code = f10;
            if (BaseVideoView.this.E) {
                if (abs > 0.01f) {
                    BaseVideoView.this.setRatio(Float.valueOf(f10));
                    BaseVideoView.this.requestLayout();
                    return;
                }
                return;
            }
            int width = BaseVideoView.this.getWidth();
            int height = BaseVideoView.this.getHeight();
            gl.V(BaseVideoView.V, "resizeVideo view width: %d height: %d", Integer.valueOf(width), Integer.valueOf(height));
            if (height == 0 || width == 0) {
                return;
            }
            float f11 = (width * 1.0f) / height;
            float abs2 = Math.abs(f11 - this.V);
            if (gl.Code()) {
                gl.Code(BaseVideoView.V, "view ratio: %f oldRatio: %f diff: %f", Float.valueOf(f11), Float.valueOf(this.V), Float.valueOf(abs2));
            }
            this.V = f11;
            if (abs2 > 0.01f) {
                BaseVideoView.this.Code(f10, f11, width, height);
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, final int i10, final int i11) {
            ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.i.1
                @Override // java.lang.Runnable
                public void run() {
                    i.this.Code(i10, i11);
                }
            });
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public BaseVideoView(Context context) {
        super(context);
        this.Code = new ha() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.1
            @Override // com.huawei.hms.ads.ha
            public void Code() {
                BaseVideoView.this.j();
            }
        };
        this.I = 0;
        this.C = new CopyOnWriteArraySet();
        this.S = new CopyOnWriteArraySet();
        this.F = new CopyOnWriteArraySet();
        this.D = new CopyOnWriteArraySet();
        this.L = new CopyOnWriteArraySet();
        this.f32635a = new CopyOnWriteArraySet();
        this.f32652p = new CopyOnWriteArraySet();
        this.f32653q = new CopyOnWriteArraySet();
        this.f32654r = new CopyOnWriteArraySet();
        this.f32655s = true;
        this.f32656t = false;
        this.f32657u = false;
        this.f32661y = new SparseBooleanArray(3);
        this.A = false;
        this.f32646j = 1;
        this.E = true;
        this.f32647k = true;
        this.G = false;
        this.J = new f(this.Code);
        this.f32651o = new i();
        this.M = new gy() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.2
            @Override // com.huawei.hms.ads.gy
            public void Code(int i10, int i11) {
                BaseVideoView.this.V(i10, i11);
                BaseVideoView.this.Code(i10, i11);
            }

            @Override // com.huawei.hms.ads.gy
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i10) {
                if (BaseVideoView.this.f32657u) {
                    BaseVideoView.this.setKeepScreenOn(true);
                }
                BaseVideoView.this.Code();
                BaseVideoView.this.I(i10);
                BaseVideoView.this.Code(bVar, i10);
            }

            @Override // com.huawei.hms.ads.gy
            public void I(com.huawei.openalliance.ad.media.b bVar, int i10) {
                BaseVideoView.this.n();
                BaseVideoView.this.B(i10);
                BaseVideoView.this.I(bVar, i10);
            }

            @Override // com.huawei.hms.ads.gy
            public void V(com.huawei.openalliance.ad.media.b bVar, int i10) {
                BaseVideoView.this.n();
                BaseVideoView.this.Z(i10);
                BaseVideoView.this.V(bVar, i10);
            }

            @Override // com.huawei.hms.ads.gy
            public void Z(com.huawei.openalliance.ad.media.b bVar, int i10) {
                BaseVideoView.this.C(i10);
                if (BaseVideoView.this.C()) {
                    return;
                }
                BaseVideoView.this.n();
                BaseVideoView.this.Z(bVar, i10);
            }
        };
        this.N = new gu() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.3
            @Override // com.huawei.hms.ads.gu
            public void Code() {
                BaseVideoView.this.h();
            }

            @Override // com.huawei.hms.ads.gu
            public void Code(int i10) {
                BaseVideoView.this.V(i10);
            }

            @Override // com.huawei.hms.ads.gu
            public void V() {
                BaseVideoView.this.i();
            }
        };
        this.O = new gv() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.4
            @Override // com.huawei.hms.ads.gv
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i10, int i11, int i12) {
                BaseVideoView.this.n();
                BaseVideoView.this.Code(i10, i11, i12);
                BaseVideoView.this.Code(bVar, i10, i11, i12);
            }
        };
        this.P = new gz() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.5
            @Override // com.huawei.hms.ads.gz
            public void Code() {
                BaseVideoView.this.G = true;
                BaseVideoView.this.l();
            }

            @Override // com.huawei.hms.ads.gz
            public void V() {
                BaseVideoView.this.G = false;
                BaseVideoView.this.m();
            }
        };
        this.Q = new gw() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.6
            @Override // com.huawei.hms.ads.gw
            public void Code(int i10) {
                BaseVideoView.this.S(i10);
            }

            @Override // com.huawei.hms.ads.gw
            public void V(int i10) {
                BaseVideoView.this.F(i10);
            }
        };
        this.R = new d(this.M);
        this.T = new a(this.N);
        this.U = new b(this.O);
        this.W = new e(this.P);
        this.f32636aa = new c(this.Q);
        this.f32637ab = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.8
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                ConnectivityManager connectivityManager;
                if (!TextUtils.equals("android.net.conn.CONNECTIVITY_CHANGE", intent.getAction()) || (connectivityManager = (ConnectivityManager) context2.getSystemService("connectivity")) == null) {
                    return;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    BaseVideoView.this.k();
                } else {
                    BaseVideoView.this.V(ai.I(context2));
                }
            }
        };
        V(context);
    }

    @com.huawei.openalliance.ad.annotations.b
    public BaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Code = new ha() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.1
            @Override // com.huawei.hms.ads.ha
            public void Code() {
                BaseVideoView.this.j();
            }
        };
        this.I = 0;
        this.C = new CopyOnWriteArraySet();
        this.S = new CopyOnWriteArraySet();
        this.F = new CopyOnWriteArraySet();
        this.D = new CopyOnWriteArraySet();
        this.L = new CopyOnWriteArraySet();
        this.f32635a = new CopyOnWriteArraySet();
        this.f32652p = new CopyOnWriteArraySet();
        this.f32653q = new CopyOnWriteArraySet();
        this.f32654r = new CopyOnWriteArraySet();
        this.f32655s = true;
        this.f32656t = false;
        this.f32657u = false;
        this.f32661y = new SparseBooleanArray(3);
        this.A = false;
        this.f32646j = 1;
        this.E = true;
        this.f32647k = true;
        this.G = false;
        this.J = new f(this.Code);
        this.f32651o = new i();
        this.M = new gy() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.2
            @Override // com.huawei.hms.ads.gy
            public void Code(int i10, int i11) {
                BaseVideoView.this.V(i10, i11);
                BaseVideoView.this.Code(i10, i11);
            }

            @Override // com.huawei.hms.ads.gy
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i10) {
                if (BaseVideoView.this.f32657u) {
                    BaseVideoView.this.setKeepScreenOn(true);
                }
                BaseVideoView.this.Code();
                BaseVideoView.this.I(i10);
                BaseVideoView.this.Code(bVar, i10);
            }

            @Override // com.huawei.hms.ads.gy
            public void I(com.huawei.openalliance.ad.media.b bVar, int i10) {
                BaseVideoView.this.n();
                BaseVideoView.this.B(i10);
                BaseVideoView.this.I(bVar, i10);
            }

            @Override // com.huawei.hms.ads.gy
            public void V(com.huawei.openalliance.ad.media.b bVar, int i10) {
                BaseVideoView.this.n();
                BaseVideoView.this.Z(i10);
                BaseVideoView.this.V(bVar, i10);
            }

            @Override // com.huawei.hms.ads.gy
            public void Z(com.huawei.openalliance.ad.media.b bVar, int i10) {
                BaseVideoView.this.C(i10);
                if (BaseVideoView.this.C()) {
                    return;
                }
                BaseVideoView.this.n();
                BaseVideoView.this.Z(bVar, i10);
            }
        };
        this.N = new gu() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.3
            @Override // com.huawei.hms.ads.gu
            public void Code() {
                BaseVideoView.this.h();
            }

            @Override // com.huawei.hms.ads.gu
            public void Code(int i10) {
                BaseVideoView.this.V(i10);
            }

            @Override // com.huawei.hms.ads.gu
            public void V() {
                BaseVideoView.this.i();
            }
        };
        this.O = new gv() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.4
            @Override // com.huawei.hms.ads.gv
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i10, int i11, int i12) {
                BaseVideoView.this.n();
                BaseVideoView.this.Code(i10, i11, i12);
                BaseVideoView.this.Code(bVar, i10, i11, i12);
            }
        };
        this.P = new gz() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.5
            @Override // com.huawei.hms.ads.gz
            public void Code() {
                BaseVideoView.this.G = true;
                BaseVideoView.this.l();
            }

            @Override // com.huawei.hms.ads.gz
            public void V() {
                BaseVideoView.this.G = false;
                BaseVideoView.this.m();
            }
        };
        this.Q = new gw() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.6
            @Override // com.huawei.hms.ads.gw
            public void Code(int i10) {
                BaseVideoView.this.S(i10);
            }

            @Override // com.huawei.hms.ads.gw
            public void V(int i10) {
                BaseVideoView.this.F(i10);
            }
        };
        this.R = new d(this.M);
        this.T = new a(this.N);
        this.U = new b(this.O);
        this.W = new e(this.P);
        this.f32636aa = new c(this.Q);
        this.f32637ab = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.8
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                ConnectivityManager connectivityManager;
                if (!TextUtils.equals("android.net.conn.CONNECTIVITY_CHANGE", intent.getAction()) || (connectivityManager = (ConnectivityManager) context2.getSystemService("connectivity")) == null) {
                    return;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    BaseVideoView.this.k();
                } else {
                    BaseVideoView.this.V(ai.I(context2));
                }
            }
        };
        V(context);
    }

    public BaseVideoView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.Code = new ha() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.1
            @Override // com.huawei.hms.ads.ha
            public void Code() {
                BaseVideoView.this.j();
            }
        };
        this.I = 0;
        this.C = new CopyOnWriteArraySet();
        this.S = new CopyOnWriteArraySet();
        this.F = new CopyOnWriteArraySet();
        this.D = new CopyOnWriteArraySet();
        this.L = new CopyOnWriteArraySet();
        this.f32635a = new CopyOnWriteArraySet();
        this.f32652p = new CopyOnWriteArraySet();
        this.f32653q = new CopyOnWriteArraySet();
        this.f32654r = new CopyOnWriteArraySet();
        this.f32655s = true;
        this.f32656t = false;
        this.f32657u = false;
        this.f32661y = new SparseBooleanArray(3);
        this.A = false;
        this.f32646j = 1;
        this.E = true;
        this.f32647k = true;
        this.G = false;
        this.J = new f(this.Code);
        this.f32651o = new i();
        this.M = new gy() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.2
            @Override // com.huawei.hms.ads.gy
            public void Code(int i102, int i11) {
                BaseVideoView.this.V(i102, i11);
                BaseVideoView.this.Code(i102, i11);
            }

            @Override // com.huawei.hms.ads.gy
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i102) {
                if (BaseVideoView.this.f32657u) {
                    BaseVideoView.this.setKeepScreenOn(true);
                }
                BaseVideoView.this.Code();
                BaseVideoView.this.I(i102);
                BaseVideoView.this.Code(bVar, i102);
            }

            @Override // com.huawei.hms.ads.gy
            public void I(com.huawei.openalliance.ad.media.b bVar, int i102) {
                BaseVideoView.this.n();
                BaseVideoView.this.B(i102);
                BaseVideoView.this.I(bVar, i102);
            }

            @Override // com.huawei.hms.ads.gy
            public void V(com.huawei.openalliance.ad.media.b bVar, int i102) {
                BaseVideoView.this.n();
                BaseVideoView.this.Z(i102);
                BaseVideoView.this.V(bVar, i102);
            }

            @Override // com.huawei.hms.ads.gy
            public void Z(com.huawei.openalliance.ad.media.b bVar, int i102) {
                BaseVideoView.this.C(i102);
                if (BaseVideoView.this.C()) {
                    return;
                }
                BaseVideoView.this.n();
                BaseVideoView.this.Z(bVar, i102);
            }
        };
        this.N = new gu() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.3
            @Override // com.huawei.hms.ads.gu
            public void Code() {
                BaseVideoView.this.h();
            }

            @Override // com.huawei.hms.ads.gu
            public void Code(int i102) {
                BaseVideoView.this.V(i102);
            }

            @Override // com.huawei.hms.ads.gu
            public void V() {
                BaseVideoView.this.i();
            }
        };
        this.O = new gv() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.4
            @Override // com.huawei.hms.ads.gv
            public void Code(com.huawei.openalliance.ad.media.b bVar, int i102, int i11, int i12) {
                BaseVideoView.this.n();
                BaseVideoView.this.Code(i102, i11, i12);
                BaseVideoView.this.Code(bVar, i102, i11, i12);
            }
        };
        this.P = new gz() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.5
            @Override // com.huawei.hms.ads.gz
            public void Code() {
                BaseVideoView.this.G = true;
                BaseVideoView.this.l();
            }

            @Override // com.huawei.hms.ads.gz
            public void V() {
                BaseVideoView.this.G = false;
                BaseVideoView.this.m();
            }
        };
        this.Q = new gw() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.6
            @Override // com.huawei.hms.ads.gw
            public void Code(int i102) {
                BaseVideoView.this.S(i102);
            }

            @Override // com.huawei.hms.ads.gw
            public void V(int i102) {
                BaseVideoView.this.F(i102);
            }
        };
        this.R = new d(this.M);
        this.T = new a(this.N);
        this.U = new b(this.O);
        this.W = new e(this.P);
        this.f32636aa = new c(this.Q);
        this.f32637ab = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.8
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                ConnectivityManager connectivityManager;
                if (!TextUtils.equals("android.net.conn.CONNECTIVITY_CHANGE", intent.getAction()) || (connectivityManager = (ConnectivityManager) context2.getSystemService("connectivity")) == null) {
                    return;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    BaseVideoView.this.k();
                } else {
                    BaseVideoView.this.V(ai.I(context2));
                }
            }
        };
        V(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(int i10) {
        Iterator<hb> iterator2 = this.f32653q.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().I(getContentId(), getCurrentVideoUrl(), i10);
        }
        Iterator<hb> iterator22 = this.f32652p.iterator2();
        while (iterator22.hasNext()) {
            iterator22.next().I(getContentId(), getCurrentVideoUrl(), i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(int i10) {
        Iterator<hb> iterator2 = this.f32653q.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().Z(getContentId(), getCurrentVideoUrl(), i10);
        }
        Iterator<hb> iterator22 = this.f32652p.iterator2();
        while (iterator22.hasNext()) {
            iterator22.next().Z(getContentId(), getCurrentVideoUrl(), i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean C() {
        String nextVideoUrl;
        int i10 = this.f32660x + 1;
        if (!this.f32661y.get(i10) || (nextVideoUrl = getNextVideoUrl()) == null) {
            gl.V(V, "no next player to switch, current: %d", Integer.valueOf(this.f32660x));
            return false;
        }
        this.f32658v = nextVideoUrl;
        this.f32642f = Code(getNextPlayerAgent());
        if (!TextUtils.equals(nextVideoUrl, this.f32641e.F())) {
            this.f32641e.Z(nextVideoUrl);
        }
        if (this.G) {
            this.f32641e.D();
        } else {
            this.f32641e.L();
        }
        this.f32641e.V();
        this.f32660x = i10;
        gl.V(V, "switch to next player [%d] and play", Integer.valueOf(i10));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code() {
        String nextVideoUrl = getNextVideoUrl();
        if (nextVideoUrl == null) {
            gl.V(V, "no next video url need to prepare, current: %d", Integer.valueOf(this.f32660x));
            return;
        }
        int i10 = this.f32660x + 1;
        if (this.f32661y.get(i10)) {
            gl.V(V, "player for url %d is already set", Integer.valueOf(i10));
            return;
        }
        gl.V(V, "prepare to set next player[%d]", Integer.valueOf(i10));
        com.huawei.openalliance.ad.media.b nextPlayerAgent = getNextPlayerAgent();
        nextPlayerAgent.Z(nextVideoUrl);
        nextPlayerAgent.I();
        this.f32661y.put(i10, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(int i10, int i11) {
        Iterator<gy> iterator2 = this.S.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().Code(i10, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(int i10, int i11, int i12) {
        Iterator<hb> iterator2 = this.f32652p.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().Code(getContentId(), getCurrentVideoUrl(), i10, i11, i12);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(com.huawei.openalliance.ad.media.b bVar, int i10) {
        Iterator<gy> iterator2 = this.S.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().Code(bVar, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(com.huawei.openalliance.ad.media.b bVar, int i10, int i11, int i12) {
        Iterator<gv> iterator2 = this.L.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().Code(bVar, i10, i11, i12);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(int i10) {
        Iterator<gw> iterator2 = this.f32635a.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().V(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(int i10) {
        Iterator<hb> iterator2 = this.f32653q.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().Code(getContentId(), getCurrentVideoUrl(), i10);
        }
        Iterator<hb> iterator22 = this.f32652p.iterator2();
        while (iterator22.hasNext()) {
            iterator22.next().Code(getContentId(), getCurrentVideoUrl(), i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(com.huawei.openalliance.ad.media.b bVar, int i10) {
        Iterator<gy> iterator2 = this.S.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().I(bVar, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(int i10) {
        Iterator<gw> iterator2 = this.f32635a.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().Code(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(int i10) {
        Iterator<gu> iterator2 = this.F.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().Code(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(int i10, int i11) {
        Iterator<hb> iterator2 = this.f32653q.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().Code(getContentId(), getCurrentVideoUrl(), i10, i11);
        }
        Iterator<hb> iterator22 = this.f32652p.iterator2();
        while (iterator22.hasNext()) {
            iterator22.next().Code(getContentId(), getCurrentVideoUrl(), i10, i11);
        }
    }

    private void V(Context context) {
        setBackgroundColor(-16777216);
        Code(context);
        this.B = HiAd.Code(context).V();
        setMediaPlayerAgent(new com.huawei.openalliance.ad.media.b(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(com.huawei.openalliance.ad.media.b bVar, int i10) {
        Iterator<gy> iterator2 = this.S.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().V(bVar, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(boolean z10) {
        if (gl.Code()) {
            gl.Code(V, "notifyNetworkConnectedOrChanged wifi: %s", Boolean.valueOf(z10));
        }
        Iterator<com.huawei.openalliance.ad.views.e> iterator2 = this.C.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().Code(z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(int i10) {
        Iterator<hb> iterator2 = this.f32653q.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().V(getContentId(), getCurrentVideoUrl(), i10);
        }
        Iterator<hb> iterator22 = this.f32652p.iterator2();
        while (iterator22.hasNext()) {
            iterator22.next().V(getContentId(), getCurrentVideoUrl(), i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(com.huawei.openalliance.ad.media.b bVar, int i10) {
        Iterator<gy> iterator2 = this.S.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().Z(bVar, i10);
        }
    }

    private String getCurrentVideoUrl() {
        if (this.f32660x < getVideoFileUrlArrayLength()) {
            return this.f32659w[this.f32660x];
        }
        return null;
    }

    private com.huawei.openalliance.ad.media.b getNextPlayerAgent() {
        if (this.f32642f == null) {
            com.huawei.openalliance.ad.media.b bVar = new com.huawei.openalliance.ad.media.b(getContext());
            this.f32642f = bVar;
            bVar.c();
        }
        return this.f32642f;
    }

    private String getNextVideoUrl() {
        int i10 = this.f32660x + 1;
        if (i10 < getVideoFileUrlArrayLength()) {
            return this.f32659w[i10];
        }
        return null;
    }

    private int getVideoFileUrlArrayLength() {
        String[] strArr = this.f32659w;
        if (strArr != null) {
            return strArr.length;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Iterator<gu> iterator2 = this.F.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().Code();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Iterator<gu> iterator2 = this.F.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().V();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        Iterator<ha> iterator2 = this.f32654r.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().Code();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (gl.Code()) {
            gl.Code(V, "notifyNetworkDisconnected");
        }
        Iterator<com.huawei.openalliance.ad.views.e> iterator2 = this.C.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().Z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        Iterator<gz> iterator2 = this.D.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().Code();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        Iterator<gz> iterator2 = this.D.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().V();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.f32657u) {
            setKeepScreenOn(false);
        }
    }

    public void B() {
        TextureView textureView = this.f32638b;
        if (textureView != null) {
            textureView.setSurfaceTextureListener(null);
            ViewParent parent = this.f32638b.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f32638b);
            }
            TextureView textureView2 = new TextureView(getContext());
            this.f32638b = textureView2;
            textureView2.setSurfaceTextureListener(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            addView(this.f32638b, layoutParams);
        }
    }

    public com.huawei.openalliance.ad.media.b Code(com.huawei.openalliance.ad.media.b bVar) {
        if (bVar == null) {
            gl.I(V, "no agent to switch");
            return null;
        }
        com.huawei.openalliance.ad.media.b bVar2 = this.f32641e;
        if (bVar2 != null) {
            bVar2.V(this.R);
            bVar2.V(this.T);
            bVar2.V(this.U);
            bVar2.V(this.W);
            bVar2.I(this.J);
            bVar2.V(this.f32636aa);
            bVar2.Code((Surface) null);
        }
        bVar.Code(this.R);
        bVar.Code(this.T);
        bVar.Code(this.U);
        bVar.Code(this.W);
        bVar.V(this.J);
        bVar.Code(this.f32636aa);
        bVar.Code(this.H);
        bVar.Z(this.I);
        Surface surface = this.f32643g;
        if (surface != null) {
            bVar.Code(surface);
        }
        this.f32641e = bVar;
        return bVar2;
    }

    public void Code(float f10) {
        gl.V(V, "unmute, volume: %s", Float.valueOf(f10));
        this.f32641e.V(f10);
    }

    public void Code(float f10, float f11, int i10, int i11) {
        Matrix matrix;
        float f12;
        float f13 = 1.0f;
        float f14 = (i10 * 1.0f) / 2.0f;
        float f15 = (i11 * 1.0f) / 2.0f;
        int i12 = this.f32646j;
        if (i12 == 1) {
            gl.V(V, "set video scale mode as fit");
            matrix = new Matrix();
            matrix.setScale(1.0f, 1.0f, f14, f15);
        } else {
            if (i12 != 2) {
                return;
            }
            String str = V;
            gl.V(str, "set video scale mode as fit with cropping");
            if (f11 < f10) {
                f13 = f10 / f11;
                f12 = 1.0f;
            } else {
                f12 = f11 / f10;
            }
            gl.Code(str, "calculateScaleMatrix scaleX: %s scaleY: %s pivotPointX: %s pivotPointY: %s", Float.valueOf(f13), Float.valueOf(f12), Float.valueOf(f14), Float.valueOf(f15));
            matrix = new Matrix();
            matrix.setScale(f13, f12, f14, f15);
        }
        this.f32638b.setTransform(matrix);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(int i10) {
        this.f32641e.Code(i10);
    }

    public void Code(Context context) {
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(gu guVar) {
        if (guVar == null) {
            return;
        }
        this.F.add(guVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(gv gvVar) {
        if (gvVar == null) {
            return;
        }
        this.L.add(gvVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(gw gwVar) {
        if (gwVar == null) {
            return;
        }
        this.f32635a.add(gwVar);
    }

    public void Code(gx gxVar) {
        com.huawei.openalliance.ad.media.b bVar = this.f32641e;
        if (bVar != null) {
            bVar.I(gxVar);
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(gy gyVar) {
        if (gyVar == null) {
            return;
        }
        this.S.add(gyVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(gz gzVar) {
        if (gzVar == null) {
            return;
        }
        this.D.add(gzVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(ha haVar) {
        if (haVar == null) {
            return;
        }
        this.f32654r.add(haVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(hb hbVar) {
        if (hbVar != null) {
            this.f32652p.add(hbVar);
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(com.huawei.openalliance.ad.views.e eVar) {
        if (eVar == null) {
            return;
        }
        this.C.add(eVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(boolean z10) {
        if (this.f32656t) {
            gl.I(V, "play action is not performed - view paused");
            return;
        }
        gl.V(V, "play auto: %s surfaceAvailable: %s standalone: %s url: %s", Boolean.valueOf(z10), Boolean.valueOf(this.f32640d), Boolean.valueOf(this.f32655s), bc.Code(this.f32658v));
        if (!this.f32640d) {
            this.f32639c = true;
            this.f32645i = z10;
            return;
        }
        Surface surface = this.f32643g;
        if (surface != null) {
            this.f32641e.Code(surface);
        }
        if (this.f32655s) {
            this.f32641e.V();
        } else if (z10) {
            this.B.Code(this.f32658v, this.f32641e);
        } else {
            this.B.V(this.f32658v, this.f32641e);
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public void D() {
        gl.V(V, "stop standalone " + this.f32655s);
        this.f32639c = false;
        if (this.f32655s) {
            this.f32641e.Code();
        } else {
            this.B.I(this.f32658v, this.f32641e);
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public void F() {
        Code(false);
    }

    public void I(int i10, int i11) {
        this.f32641e.V(i10, i11);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void I(hb hbVar) {
        if (hbVar != null) {
            this.f32653q.add(hbVar);
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public void L() {
        gl.V(V, "pause standalone " + this.f32655s);
        this.f32639c = false;
        if (this.f32655s) {
            this.f32641e.Z();
        } else {
            this.B.Z(this.f32658v, this.f32641e);
        }
    }

    public void S() {
        gl.V(V, "resetVideoView");
        if (this.f32641e.d() <= 1) {
            this.f32641e.Code((Surface) null);
            this.f32641e.b();
        }
        com.huawei.openalliance.ad.media.b bVar = this.f32642f;
        if (bVar != null) {
            bVar.Code((Surface) null);
            this.f32642f.b();
        }
        Surface surface = this.f32643g;
        if (surface != null) {
            surface.release();
            this.f32643g = null;
        }
        SurfaceTexture surfaceTexture = this.f32644h;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        this.f32644h = null;
        this.f32639c = false;
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V(gu guVar) {
        if (guVar == null) {
            return;
        }
        this.F.remove(guVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V(gv gvVar) {
        if (gvVar == null) {
            return;
        }
        this.L.remove(gvVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V(gw gwVar) {
        if (gwVar == null) {
            return;
        }
        this.f32635a.remove(gwVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V(gy gyVar) {
        if (gyVar == null) {
            return;
        }
        this.S.remove(gyVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V(gz gzVar) {
        if (gzVar == null) {
            return;
        }
        this.D.remove(gzVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V(ha haVar) {
        if (haVar == null) {
            return;
        }
        this.f32654r.remove(haVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V(hb hbVar) {
        if (hbVar != null) {
            this.f32652p.remove(hbVar);
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V(com.huawei.openalliance.ad.views.e eVar) {
        if (eVar == null) {
            return;
        }
        this.C.remove(eVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Z(hb hbVar) {
        if (hbVar != null) {
            this.f32653q.remove(hbVar);
        }
    }

    @Override // com.huawei.openalliance.ad.views.AutoScaleSizeRelativeLayout
    public boolean Z() {
        return this.A;
    }

    @com.huawei.openalliance.ad.annotations.b
    public boolean a() {
        return this.f32641e.S();
    }

    @com.huawei.openalliance.ad.annotations.b
    public void b() {
        gl.V(V, cj.C);
        this.f32641e.D();
    }

    @com.huawei.openalliance.ad.annotations.b
    public void c() {
        gl.V(V, cj.S);
        this.f32641e.L();
    }

    public void d() {
        g gVar = this.f32662z;
        if (gVar != null) {
            gVar.I();
        }
    }

    public void destroyView() {
        this.f32641e.I(this.f32648l);
        if (!this.f32655s) {
            this.B.Code(this.f32641e);
        }
        this.f32641e.a();
        com.huawei.openalliance.ad.media.b bVar = this.f32642f;
        if (bVar != null) {
            bVar.a();
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public void e() {
        this.f32641e.I();
    }

    public void f() {
        com.huawei.openalliance.ad.media.b bVar = this.f32641e;
        if (bVar != null) {
            bVar.a();
        }
    }

    public String getContentId() {
        return this.K;
    }

    @com.huawei.openalliance.ad.annotations.b
    public int getCurrentPosition() {
        return this.f32641e.B();
    }

    @com.huawei.openalliance.ad.annotations.b
    public com.huawei.openalliance.ad.media.c getCurrentState() {
        return this.f32641e.C();
    }

    public com.huawei.openalliance.ad.media.b getMediaPlayerAgent() {
        return this.f32641e;
    }

    public com.huawei.openalliance.ad.media.c getMediaState() {
        com.huawei.openalliance.ad.media.b bVar = this.f32641e;
        if (bVar == null) {
            return null;
        }
        return bVar.C();
    }

    public int getVideoHeight() {
        return this.f32650n;
    }

    public int getVideoWidth() {
        return this.f32649m;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isHardwareAccelerated()) {
            gl.Z(V, "hardware acceleration is off");
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        HiAd.Code(getContext()).Code(this.f32637ab, intentFilter);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        String str;
        String str2;
        super.onDetachedFromWindow();
        try {
            HiAd.Code(getContext()).Code(this.f32637ab);
        } catch (IllegalStateException unused) {
            str = V;
            str2 = "unregisterReceiver IllegalArgumentException";
            gl.I(str, str2);
        } catch (Exception unused2) {
            str = V;
            str2 = "unregisterReceiver Exception";
            gl.I(str, str2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
        if (gl.Code()) {
            gl.Code(V, "onSurfaceTextureSizeChanged width: %d height: %d", Integer.valueOf(i10), Integer.valueOf(i11));
        }
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                BaseVideoView baseVideoView = BaseVideoView.this;
                baseVideoView.f32651o.Code(baseVideoView.f32649m, baseVideoView.f32650n);
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // com.huawei.hms.ads.lz
    public void pauseView() {
        this.f32656t = true;
        this.f32641e.e();
    }

    @Override // com.huawei.hms.ads.lz
    public void resumeView() {
        this.f32656t = false;
    }

    public void setAudioFocusType(int i10) {
        this.I = i10;
        this.f32641e.Z(i10);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void setAutoScaleResizeLayoutOnVideoSizeChange(boolean z10) {
        this.E = z10;
    }

    public void setContentId(String str) {
        this.K = str;
    }

    @com.huawei.openalliance.ad.annotations.b
    public void setDefaultDuration(int i10) {
        this.f32641e.V(i10);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void setMediaPlayerAgent(com.huawei.openalliance.ad.media.b bVar) {
        if (bVar == null) {
            return;
        }
        bVar.c();
        com.huawei.openalliance.ad.media.b Code = Code(bVar);
        if (Code != null) {
            Code.a();
        }
    }

    public void setMediaPlayerReleaseListener(gx gxVar) {
        com.huawei.openalliance.ad.media.b bVar = this.f32641e;
        if (bVar != null) {
            bVar.Code(gxVar);
        }
    }

    public void setMuteOnlyOnLostAudioFocus(boolean z10) {
        this.H = z10;
        this.f32641e.Code(z10);
    }

    public void setNeedPauseOnSurfaceDestory(boolean z10) {
        this.f32647k = z10;
    }

    @com.huawei.openalliance.ad.annotations.b
    public void setPreferStartPlayTime(int i10) {
        this.f32641e.I(i10);
    }

    public void setRemediate(boolean z10) {
        this.A = z10;
    }

    @com.huawei.openalliance.ad.annotations.b
    public void setScreenOnWhilePlaying(boolean z10) {
        this.f32657u = z10;
        setKeepScreenOn(z10 && getCurrentState().Code(com.huawei.openalliance.ad.media.e.PLAYING));
    }

    public void setSoundVolume(float f10) {
        this.f32641e.Code(f10);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void setStandalone(boolean z10) {
        this.f32655s = z10;
    }

    @com.huawei.openalliance.ad.annotations.b
    public void setSurfaceListener(g gVar) {
        this.f32662z = gVar;
    }

    @com.huawei.openalliance.ad.annotations.b
    public void setVideoFileUrl(String str) {
        setVideoFileUrls(new String[]{str});
    }

    @com.huawei.openalliance.ad.annotations.b
    public void setVideoFileUrls(String[] strArr) {
        String[] strArr2 = strArr != null ? (String[]) Arrays.copyOf(strArr, strArr.length) : null;
        this.f32659w = strArr2;
        this.f32660x = 0;
        this.f32661y.clear();
        if (strArr2 == null || strArr2.length <= 0) {
            this.f32658v = null;
            gl.I(V, "setVideoFileUrls - url array is empty");
        } else {
            gl.V(V, "setVideoFileUrls - size: %d", Integer.valueOf(strArr2.length));
            String str = strArr2[this.f32660x];
            this.f32658v = str;
            this.f32641e.Z(str);
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public void setVideoScaleMode(int i10) {
        if (i10 == 1 || i10 == 2) {
            this.f32646j = i10;
            return;
        }
        throw new IllegalArgumentException("Not supported video scale mode: " + i10);
    }
}
