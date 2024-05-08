package com.huawei.openalliance.ad.media;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import com.android.internal.os.PowerProfile;
import com.huawei.hms.ads.fg;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.gu;
import com.huawei.hms.ads.gv;
import com.huawei.hms.ads.gw;
import com.huawei.hms.ads.gx;
import com.huawei.hms.ads.gy;
import com.huawei.hms.ads.gz;
import com.huawei.hms.ads.ha;
import com.huawei.openalliance.ad.constant.bq;
import com.huawei.openalliance.ad.utils.at;
import com.huawei.openalliance.ad.utils.aw;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.s;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArraySet;

@com.huawei.openalliance.ad.annotations.b
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b {
    private static final int B = 20;
    private static final int C = 805;
    private static final int F = 2;
    private static final String I = "MediaPlayerAgent";
    private static final int L = 100;
    private static final int S = 300;
    private static final int Z = -10000;

    /* renamed from: a, reason: collision with root package name */
    private static final int f32547a = 0;

    /* renamed from: b, reason: collision with root package name */
    private static final String f32548b = "progress_task";

    /* renamed from: c, reason: collision with root package name */
    private static final int f32549c = 100;

    /* renamed from: d, reason: collision with root package name */
    private static final int f32550d = 200;

    /* renamed from: e, reason: collision with root package name */
    private static final int f32551e = 0;
    private Object A;
    private MediaPlayer D;
    private WeakReference<Surface> E;
    private int G;
    private Context J;

    /* renamed from: h, reason: collision with root package name */
    private volatile String f32559h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f32560i;

    /* renamed from: n, reason: collision with root package name */
    private int f32565n;

    /* renamed from: o, reason: collision with root package name */
    private int f32566o;

    /* renamed from: u, reason: collision with root package name */
    private AudioManager f32572u;
    private static final String Code = "thread_media_player_ctrl";
    private static final s V = new s(Code);

    /* renamed from: f, reason: collision with root package name */
    private int f32557f = 0;

    /* renamed from: j, reason: collision with root package name */
    private boolean f32561j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f32562k = false;

    /* renamed from: l, reason: collision with root package name */
    private boolean f32563l = false;

    /* renamed from: m, reason: collision with root package name */
    private int f32564m = 0;

    /* renamed from: p, reason: collision with root package name */
    private final c f32567p = new c();

    /* renamed from: q, reason: collision with root package name */
    private final byte[] f32568q = new byte[0];

    /* renamed from: r, reason: collision with root package name */
    private final byte[] f32569r = new byte[0];

    /* renamed from: s, reason: collision with root package name */
    private final byte[] f32570s = new byte[0];

    /* renamed from: t, reason: collision with root package name */
    private int f32571t = 0;

    /* renamed from: v, reason: collision with root package name */
    private boolean f32573v = false;

    /* renamed from: w, reason: collision with root package name */
    private boolean f32574w = false;

    /* renamed from: x, reason: collision with root package name */
    private int f32575x = 0;

    /* renamed from: y, reason: collision with root package name */
    private boolean f32576y = false;

    /* renamed from: z, reason: collision with root package name */
    private volatile int f32577z = 0;
    private boolean H = false;
    private final CopyOnWriteArraySet<gy> K = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<gu> M = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<gv> N = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<gz> O = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<gw> P = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<MediaPlayer.OnVideoSizeChangedListener> Q = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<ha> R = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<gx> T = new CopyOnWriteArraySet<>();
    private final MediaPlayer.OnVideoSizeChangedListener U = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.huawei.openalliance.ad.media.b.1
        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i10, int i11) {
            b.this.Code(mediaPlayer, i10, i11);
        }
    };
    private MediaPlayer.OnCompletionListener W = new MediaPlayer.OnCompletionListener() { // from class: com.huawei.openalliance.ad.media.b.12
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (b.this.f32567p.Code(e.ERROR)) {
                return;
            }
            c cVar = b.this.f32567p;
            e eVar = e.PLAYBACK_COMPLETED;
            if (cVar.Code(eVar)) {
                return;
            }
            b.this.f32567p.I(eVar);
            int currentPosition = mediaPlayer.getCurrentPosition();
            int k10 = b.this.k();
            gl.V(b.I, "onCompletion " + currentPosition + " duration: " + k10);
            int max = Math.max(currentPosition, k10);
            b.this.Code(100, max);
            b.this.B(max);
            b.this.t();
            b.F(b.this.f32558g);
            b.this.f32564m = 0;
            b.this.f32571t = 0;
        }
    };
    private MediaPlayer.OnInfoListener X = new MediaPlayer.OnInfoListener() { // from class: com.huawei.openalliance.ad.media.b.23
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0025, code lost:
        
            if (r5 != 702) goto L15;
         */
        @Override // android.media.MediaPlayer.OnInfoListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onInfo(android.media.MediaPlayer r4, int r5, int r6) {
            /*
                r3 = this;
                r4 = 2
                java.lang.Object[] r4 = new java.lang.Object[r4]
                java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
                r1 = 0
                r4[r1] = r0
                java.lang.Integer r0 = java.lang.Integer.valueOf(r6)
                r1 = 1
                r4[r1] = r0
                java.lang.String r0 = "MediaPlayerAgent"
                java.lang.String r2 = "onInfo what: %d extra: %d"
                com.huawei.hms.ads.gl.V(r0, r2, r4)
                r4 = 3
                if (r5 == r4) goto L34
                r4 = 805(0x325, float:1.128E-42)
                if (r5 == r4) goto L2e
                r4 = 701(0x2bd, float:9.82E-43)
                if (r5 == r4) goto L28
                r4 = 702(0x2be, float:9.84E-43)
                if (r5 == r4) goto L39
                goto L3e
            L28:
                com.huawei.openalliance.ad.media.b r4 = com.huawei.openalliance.ad.media.b.this
                com.huawei.openalliance.ad.media.b.B(r4)
                goto L3e
            L2e:
                com.huawei.openalliance.ad.media.b r4 = com.huawei.openalliance.ad.media.b.this
                com.huawei.openalliance.ad.media.b.F(r4, r6)
                goto L3e
            L34:
                com.huawei.openalliance.ad.media.b r4 = com.huawei.openalliance.ad.media.b.this
                com.huawei.openalliance.ad.media.b.C(r4)
            L39:
                com.huawei.openalliance.ad.media.b r4 = com.huawei.openalliance.ad.media.b.this
                com.huawei.openalliance.ad.media.b.I(r4)
            L3e:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.media.b.AnonymousClass23.onInfo(android.media.MediaPlayer, int, int):boolean");
        }
    };
    private MediaPlayer.OnPreparedListener Y = new MediaPlayer.OnPreparedListener() { // from class: com.huawei.openalliance.ad.media.b.34
        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            gl.V(b.I, "onPrepared");
            b.this.f32562k = false;
            mediaPlayer.setOnInfoListener(b.this.X);
            if (b.this.f32563l || b.this.f32567p.V(e.PREPARING)) {
                b.this.f32567p.I(e.PREPARED);
                b bVar = b.this;
                bVar.L(bVar.k());
                return;
            }
            try {
                b.this.f32567p.I(e.PREPARED);
                mediaPlayer.start();
                b.V(mediaPlayer, b.this.f32566o, 3);
                b.this.f32567p.I(e.PLAYING);
                if (gl.Code()) {
                    gl.Code(b.I, "seek to prefer pos: %d", Integer.valueOf(b.this.f32566o));
                }
                b.this.S(mediaPlayer.getCurrentPosition());
                b bVar2 = b.this;
                bVar2.L(bVar2.k());
                b.this.w();
            } catch (IllegalStateException unused) {
                gl.I(b.I, "onPrepared - IllegalStateException");
                b.this.f32567p.I(e.ERROR);
                b.this.Code(0, -1, -1);
            }
        }
    };

    /* renamed from: aa, reason: collision with root package name */
    private MediaPlayer.OnErrorListener f32552aa = new MediaPlayer.OnErrorListener() { // from class: com.huawei.openalliance.ad.media.b.38
        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i10, int i11) {
            gl.I(b.I, "onError - what: %d extra: %d currentState: %s - agent: %s", Integer.valueOf(i10), Integer.valueOf(i11), b.this.f32567p, b.this);
            b.this.t();
            c cVar = b.this.f32567p;
            e eVar = e.ERROR;
            if (cVar.Code(eVar)) {
                return true;
            }
            b.this.f32567p.I(eVar);
            b.this.Code(mediaPlayer.getCurrentPosition(), i10, i11);
            return true;
        }
    };

    /* renamed from: ab, reason: collision with root package name */
    private MediaPlayer.OnBufferingUpdateListener f32553ab = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.huawei.openalliance.ad.media.b.39
        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i10) {
            if (b.this.f32567p.Code()) {
                if (i10 < 0) {
                    i10 = 0;
                }
                if (i10 > 100) {
                    i10 = 100;
                }
                b.this.C(i10);
            }
        }
    };

    /* renamed from: ac, reason: collision with root package name */
    private Callable<Boolean> f32554ac = new Callable<Boolean>() { // from class: com.huawei.openalliance.ad.media.b.7
        @Override // java.util.concurrent.Callable
        /* renamed from: Code, reason: merged with bridge method [inline-methods] */
        public Boolean call() {
            return Boolean.valueOf(b.this.m());
        }
    };

    /* renamed from: ad, reason: collision with root package name */
    private Runnable f32555ad = new Runnable() { // from class: com.huawei.openalliance.ad.media.b.30
        @Override // java.lang.Runnable
        public void run() {
            int k10;
            b.F(b.this.f32558g);
            if (b.this.f32567p.V(e.PREPARING) && b.this.f32567p.V(e.PLAYING) && b.this.f32567p.V(e.PREPARED)) {
                return;
            }
            int B2 = b.this.B();
            if (b.this.K.size() > 0 && (k10 = b.this.k()) > 0) {
                int ceil = (int) Math.ceil((B2 * 100.0f) / k10);
                if (ceil > 100) {
                    ceil = 100;
                }
                b.this.Code(ceil, B2);
                if (B2 == k10) {
                    b.p(b.this);
                    if (b.this.f32571t > 2) {
                        gl.Code(b.I, "reach end count exceeds");
                        b.this.W.onCompletion(b.this.f());
                        return;
                    }
                }
            }
            if (b.this.f32560i && b.this.M.size() > 0 && b.this.f32571t == 0) {
                if (Math.abs(B2 - b.this.f32564m) < 100) {
                    b.this.q();
                } else {
                    b.this.t();
                    b.this.f32564m = B2;
                }
            }
            b.V(b.this.f32555ad, b.this.f32558g, 200L);
        }
    };

    /* renamed from: ae, reason: collision with root package name */
    private AudioManager.OnAudioFocusChangeListener f32556ae = new AudioManager.OnAudioFocusChangeListener() { // from class: com.huawei.openalliance.ad.media.b.36
        /* JADX INFO: Access modifiers changed from: private */
        public void Code() {
            if (b.this.H) {
                gl.V(b.I, "handleAudioFocusLoss muteOnlyOnLostAudioFocus: " + b.this.H);
                V();
                return;
            }
            boolean m10 = b.this.m();
            gl.V(b.I, "handleAudioFocusLoss isPlaying: %s", Boolean.valueOf(m10));
            if (m10) {
                b.this.Z();
                b.this.f32573v = true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void I() {
            gl.V(b.I, "handleAudioFocusGain - muteOnlyOnLostAudioFocus: " + b.this.H);
            if (b.this.H) {
                if (b.this.f32574w) {
                    b.this.p();
                }
            } else {
                if (b.this.f32575x == -2 || b.this.f32575x == -1) {
                    if (b.this.f32573v) {
                        b.this.g();
                        b.this.f32573v = false;
                        return;
                    }
                    return;
                }
                if (b.this.f32575x == -3 && b.this.f32574w) {
                    b.this.p();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void V() {
            gl.V(b.I, "handleAudioFocusLossTransientCanDuck soundMuted: " + b.this.f32576y);
            if (b.this.f32576y) {
                return;
            }
            b.this.o();
            b.this.f32574w = true;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i10) {
            b.V(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.36.1
                @Override // java.lang.Runnable
                public void run() {
                    gl.V(b.I, "onAudioFocusChange %d previous: %d", Integer.valueOf(i10), Integer.valueOf(b.this.f32575x));
                    int i11 = i10;
                    if (i11 == -3) {
                        V();
                    } else if (i11 == -2 || i11 == -1) {
                        Code();
                    } else if (i11 == 1 || i11 == 2) {
                        I();
                    }
                    b.this.f32575x = i10;
                }
            });
        }
    };

    /* renamed from: g, reason: collision with root package name */
    private String f32558g = f32548b + hashCode();

    @com.huawei.openalliance.ad.annotations.b
    public b(Context context) {
        this.J = context.getApplicationContext();
        this.f32572u = (AudioManager) context.getSystemService(PowerProfile.POWER_AUDIO);
        V.Code();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        String str;
        try {
            try {
                gl.V(I, "abandonAudioFocus");
                if (Build.VERSION.SDK_INT < 26) {
                    this.f32572u.abandonAudioFocus(this.f32556ae);
                } else {
                    Object obj = this.A;
                    if (obj instanceof AudioFocusRequest) {
                        this.f32572u.abandonAudioFocusRequest((AudioFocusRequest) obj);
                    }
                    this.A = null;
                }
            } catch (IllegalStateException unused) {
                str = "abandonAudioFocus IllegalStateException";
                gl.I(I, str);
            } catch (Exception e2) {
                str = "abandonAudioFocus " + e2.getClass().getSimpleName();
                gl.I(I, str);
            }
        } finally {
            this.f32574w = false;
            this.f32573v = false;
            this.f32575x = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(final int i10) {
        gl.V(I, "notifyMediaCompletion playTime: %d", Integer.valueOf(i10));
        e();
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.15
            @Override // java.lang.Runnable
            public void run() {
                Iterator iterator2 = b.this.K.iterator2();
                while (iterator2.hasNext()) {
                    gy gyVar = (gy) iterator2.next();
                    if (gyVar != null) {
                        gyVar.Z(b.this, i10);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(final int i10) {
        if (this.f32560i) {
            ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.16
                @Override // java.lang.Runnable
                public void run() {
                    Iterator iterator2 = b.this.M.iterator2();
                    while (iterator2.hasNext()) {
                        gu guVar = (gu) iterator2.next();
                        if (guVar != null) {
                            guVar.Code(i10);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.media.MediaPlayer] */
    /* JADX WARN: Type inference failed for: r1v5, types: [com.huawei.openalliance.ad.media.e] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void C(java.lang.String r7) {
        /*
            r6 = this;
            com.huawei.openalliance.ad.media.c r0 = r6.f32567p
            com.huawei.openalliance.ad.media.e r1 = com.huawei.openalliance.ad.media.e.END
            boolean r0 = r0.Code(r1)
            if (r0 == 0) goto Lb
            return
        Lb:
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r2 = com.huawei.openalliance.ad.utils.bc.Code(r7)
            r3 = 0
            r1[r3] = r2
            java.lang.String r2 = "MediaPlayerAgent"
            java.lang.String r4 = "setMediaFileUrl: %s"
            com.huawei.hms.ads.gl.Code(r2, r4, r1)
            android.media.MediaPlayer r1 = r6.f()
            com.huawei.openalliance.ad.media.c r4 = r6.f32567p     // Catch: java.lang.Throwable -> L36 java.lang.IllegalStateException -> L49
            boolean r4 = r4.Code()     // Catch: java.lang.Throwable -> L36 java.lang.IllegalStateException -> L49
            if (r4 == 0) goto L2b
            r1.stop()     // Catch: java.lang.Throwable -> L36 java.lang.IllegalStateException -> L49
        L2b:
            r1.reset()
            com.huawei.openalliance.ad.media.c r0 = r6.f32567p
            com.huawei.openalliance.ad.media.e r1 = com.huawei.openalliance.ad.media.e.IDLE
            r0.I(r1)
            goto L4f
        L36:
            r4 = move-exception
            java.lang.String r5 = "setMediaFileUrl exception: %s"
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L81
            java.lang.Class r4 = r4.getClass()     // Catch: java.lang.Throwable -> L81
            java.lang.String r4 = r4.getSimpleName()     // Catch: java.lang.Throwable -> L81
            r0[r3] = r4     // Catch: java.lang.Throwable -> L81
            com.huawei.hms.ads.gl.I(r2, r5, r0)     // Catch: java.lang.Throwable -> L81
            goto L2b
        L49:
            java.lang.String r0 = "setMediaFileUrl stop IllegalStateException"
            com.huawei.hms.ads.gl.I(r2, r0)     // Catch: java.lang.Throwable -> L81
            goto L2b
        L4f:
            r6.G = r3
            r6.f32559h = r7
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 != 0) goto L6f
            r6.S(r7)     // Catch: java.lang.Exception -> L5d
            return
        L5d:
            java.lang.String r7 = "setMediaFileUrl Exception"
            com.huawei.hms.ads.gl.I(r2, r7)
            com.huawei.openalliance.ad.media.c r0 = r6.f32567p
            com.huawei.openalliance.ad.media.e r1 = com.huawei.openalliance.ad.media.e.ERROR
            r0.I(r1)
            com.huawei.hms.ads.fg r0 = new com.huawei.hms.ads.fg
            r0.<init>(r7)
            throw r0
        L6f:
            java.lang.String r7 = "media file url is empty"
            com.huawei.hms.ads.gl.I(r2, r7)
            com.huawei.openalliance.ad.media.c r0 = r6.f32567p
            com.huawei.openalliance.ad.media.e r1 = com.huawei.openalliance.ad.media.e.ERROR
            r0.I(r1)
            com.huawei.hms.ads.fg r0 = new com.huawei.hms.ads.fg
            r0.<init>(r7)
            throw r0
        L81:
            r7 = move-exception
            r1.reset()
            com.huawei.openalliance.ad.media.c r0 = r6.f32567p
            com.huawei.openalliance.ad.media.e r1 = com.huawei.openalliance.ad.media.e.IDLE
            r0.I(r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.media.b.C(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(final int i10, final int i11) {
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.14
            @Override // java.lang.Runnable
            public void run() {
                Iterator iterator2 = b.this.K.iterator2();
                while (iterator2.hasNext()) {
                    gy gyVar = (gy) iterator2.next();
                    if (gyVar != null) {
                        gyVar.Code(i10, i11);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(final int i10, final int i11, final int i12) {
        gl.V(I, "notifyError playTime: %d", Integer.valueOf(i10));
        e();
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.25
            @Override // java.lang.Runnable
            public void run() {
                Iterator iterator2 = b.this.N.iterator2();
                while (iterator2.hasNext()) {
                    gv gvVar = (gv) iterator2.next();
                    if (gvVar != null) {
                        gvVar.Code(b.this, i10, i11, i12);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(MediaPlayer mediaPlayer, int i10, int i11) {
        Iterator<MediaPlayer.OnVideoSizeChangedListener> iterator2 = this.Q.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onVideoSizeChanged(mediaPlayer, i10, i11);
        }
    }

    private void D(final int i10) {
        gl.V(I, "notifyMediaPause playTime: %d", Integer.valueOf(i10));
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.24
            @Override // java.lang.Runnable
            public void run() {
                Iterator iterator2 = b.this.K.iterator2();
                while (iterator2.hasNext()) {
                    gy gyVar = (gy) iterator2.next();
                    if (gyVar != null) {
                        gyVar.V(b.this, i10);
                    }
                }
            }
        });
    }

    private boolean E() {
        gl.V(I, "isNeedAudioFocus type: %s soundMute: %s", Integer.valueOf(this.f32577z), Boolean.valueOf(this.f32576y));
        if (this.f32577z == 0) {
            return true;
        }
        if (this.f32577z == 2) {
            return false;
        }
        return (this.f32577z == 1 && this.f32576y) ? false : true;
    }

    private void F(final int i10) {
        gl.V(I, "notifyMediaStop playTime: %d", Integer.valueOf(i10));
        e();
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.22
            @Override // java.lang.Runnable
            public void run() {
                Iterator iterator2 = b.this.K.iterator2();
                while (iterator2.hasNext()) {
                    gy gyVar = (gy) iterator2.next();
                    if (gyVar != null) {
                        gyVar.I(b.this, i10);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void F(String str) {
        V.Code(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean I(float f10) {
        if (this.f32567p.Code(e.END)) {
            return false;
        }
        try {
            f().setVolume(f10, f10);
            return true;
        } catch (IllegalStateException unused) {
            gl.I(I, "mute IllegalStateException");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(final int i10) {
        gl.V(I, "notifyDurationReady: %d", Integer.valueOf(i10));
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.28
            @Override // java.lang.Runnable
            public void run() {
                Iterator iterator2 = b.this.P.iterator2();
                while (iterator2.hasNext()) {
                    gw gwVar = (gw) iterator2.next();
                    if (gwVar != null) {
                        gwVar.Code(i10);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(final int i10) {
        gl.V(I, "notifyMediaStart playTime: %d", Integer.valueOf(i10));
        z();
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.21
            @Override // java.lang.Runnable
            public void run() {
                Iterator iterator2 = b.this.K.iterator2();
                while (iterator2.hasNext()) {
                    gy gyVar = (gy) iterator2.next();
                    if (gyVar != null) {
                        gyVar.Code(b.this, i10);
                    }
                }
            }
        });
    }

    private void S(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        MediaPlayer f10 = f();
        if (Uri.parse(str).getScheme() != null) {
            bq bqVar = bq.FILE;
            if (str.startsWith(bqVar.toString())) {
                str = str.substring(bqVar.toString().length());
            } else {
                if (str.startsWith(bq.CONTENT.toString())) {
                    if (!Code(str, f10)) {
                        gl.I(I, "set remote media fail");
                        throw new fg();
                    }
                    f10.setVideoScalingMode(1);
                    this.f32567p.I(e.INITIALIZED);
                }
                if (str.startsWith(bq.HTTP.toString()) || str.startsWith(bq.HTTPS.toString())) {
                    this.f32560i = true;
                }
            }
        }
        f10.setDataSource(str);
        f10.setVideoScalingMode(1);
        this.f32567p.I(e.INITIALIZED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(long j10, int i10) {
        MediaPlayer mediaPlayer;
        try {
            gl.V(I, "seekToMillis " + j10);
            if (this.f32567p.Code()) {
                synchronized (this.f32568q) {
                    mediaPlayer = this.D;
                }
                V(mediaPlayer, j10, i10);
                long k10 = k();
                if (k10 > 0) {
                    Code((int) ((100 * j10) / k10), (int) j10);
                }
            }
        } catch (IllegalStateException unused) {
            gl.I(I, "seekTo IllegalStateException");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(MediaPlayer mediaPlayer, long j10, int i10) {
        if (mediaPlayer != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                mediaPlayer.seekTo(j10, i10);
            } else {
                mediaPlayer.seekTo((int) j10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(Surface surface) {
        String str;
        if (this.f32567p.Code(e.END)) {
            return;
        }
        if (surface != null && !surface.isValid()) {
            gl.I(I, "setSurfaceInternal - surface is invalid");
            return;
        }
        if (surface == n()) {
            gl.V(I, "setSurfaceInternal - pass-in surface is the same as currentSurface");
            return;
        }
        this.E = new WeakReference<>(surface);
        try {
            gl.V(I, "setSurfaceInternal");
            f().setSurface(surface);
        } catch (IllegalArgumentException unused) {
            str = "setSurface IllegalArgumentException";
            gl.I(I, str);
        } catch (IllegalStateException unused2) {
            str = "setSurface IllegalStateException";
            gl.I(I, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(Runnable runnable) {
        V.Code(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(Runnable runnable, String str, long j10) {
        V.Code(runnable, str, j10);
    }

    private void V(boolean z10) {
        if (this.f32567p.Code(e.END)) {
            return;
        }
        try {
            gl.V(I, "prepareMediaPlayer");
            this.f32567p.I(e.PREPARING);
            this.f32562k = true;
            f().prepareAsync();
            if (z10) {
                q();
            }
        } catch (IllegalStateException unused) {
            gl.I(I, "prepareMediaPlayer IllegalStateException");
            this.f32567p.I(e.ERROR);
            Code(0, -1, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(float f10) {
        this.f32574w = false;
        if (I(f10)) {
            v();
        }
        if (this.f32577z == 1 && m()) {
            z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i10) {
        gl.V(I, "notifyVideoPictureNotPlaying");
        if (i10 < -10000) {
            int i11 = this.G;
            if (i11 < 20) {
                this.G = i11 + 1;
                Code();
                V();
            } else {
                Code();
                this.f32552aa.onError(f(), 805, i10);
            }
        }
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.29
            @Override // java.lang.Runnable
            public void run() {
                Iterator iterator2 = b.this.P.iterator2();
                while (iterator2.hasNext()) {
                    gw gwVar = (gw) iterator2.next();
                    if (gwVar != null) {
                        gwVar.V(i10);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer f() {
        MediaPlayer mediaPlayer;
        synchronized (this.f32568q) {
            if (this.D == null) {
                MediaPlayer mediaPlayer2 = new MediaPlayer();
                mediaPlayer2.setOnCompletionListener(this.W);
                mediaPlayer2.setOnPreparedListener(this.Y);
                mediaPlayer2.setOnErrorListener(this.f32552aa);
                mediaPlayer2.setOnBufferingUpdateListener(this.f32553ab);
                mediaPlayer2.setOnVideoSizeChangedListener(this.U);
                mediaPlayer2.setLooping(false);
                mediaPlayer2.setAudioStreamType(3);
                this.D = mediaPlayer2;
            }
            mediaPlayer = this.D;
        }
        return mediaPlayer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.f32567p.Code(e.END)) {
            gl.V(I, "play - current state: %s - agent: %s", this.f32567p, this);
            return;
        }
        gl.Code(I, "play file: %s", bc.Code(this.f32559h));
        this.f32563l = false;
        if (!this.f32567p.Code(e.ERROR) && !this.f32567p.Code(e.IDLE)) {
            c cVar = this.f32567p;
            e eVar = e.PLAYING;
            if (!cVar.Code(eVar)) {
                MediaPlayer f10 = f();
                gl.V(I, "play - state before play: %s - agent: %s", this.f32567p, this);
                if (this.f32562k || !(this.f32567p.Code(e.PAUSED) || this.f32567p.Code(e.PLAYBACK_COMPLETED) || this.f32567p.Code(e.PREPARED))) {
                    try {
                        C(this.f32559h);
                        if (this.f32567p.Code(e.INITIALIZED)) {
                            V(true);
                        }
                    } catch (fg e2) {
                        gl.Code(I, "set media file error:%s", e2.getMessage());
                        gl.I(I, "set media file error:" + e2.getClass().getSimpleName());
                        this.f32567p.I(e.ERROR);
                        Code(0, -1, -1);
                    }
                } else {
                    try {
                        f10.start();
                        if (this.f32567p.Code(e.PREPARED)) {
                            if (Build.VERSION.SDK_INT >= 26) {
                                f10.seekTo(this.f32566o, 3);
                            } else {
                                f10.seekTo(this.f32566o);
                            }
                        }
                        int currentPosition = this.f32567p.Code(e.PLAYBACK_COMPLETED) ? 0 : f10.getCurrentPosition();
                        this.f32567p.I(eVar);
                        S(currentPosition);
                        w();
                    } catch (IllegalStateException unused) {
                        gl.I(I, "play - start IllegalStateException");
                        this.f32567p.I(e.ERROR);
                        Code(f10.getCurrentPosition(), -100, 0);
                        t();
                    }
                }
                gl.V(I, "play - current state: %s", this.f32567p);
                return;
            }
        }
        gl.V(I, "play - current state: %s - agent: %s", this.f32567p, this);
        if (this.f32567p.Code(e.PLAYING)) {
            S(f().getCurrentPosition());
            w();
            return;
        }
        try {
            C(this.f32559h);
            gl.V(I, "play - current state after set file: %s", this.f32567p);
            if (this.f32567p.Code(e.INITIALIZED)) {
                V(true);
            }
        } catch (fg e10) {
            gl.Code(I, "set media file error:%s", e10.getMessage());
            gl.I(I, "set media file error:" + e10.getClass().getSimpleName());
            this.f32567p.I(e.ERROR);
            Code(0, -1, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        gl.V(I, "prepareInternal - current state: %s - agent: %s", this.f32567p, this);
        if (this.f32567p.Code(e.END)) {
            return;
        }
        gl.V(I, "prepareInternal - current state after set file: %s", this.f32567p);
        if (this.f32567p.Code(e.INITIALIZED)) {
            this.f32563l = true;
            V(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.f32567p.Code(e.END) || this.f32567p.Code(e.ERROR) || this.f32567p.Code(e.IDLE)) {
            return;
        }
        if (this.f32567p.Code() || this.f32567p.Code(e.PREPARING)) {
            try {
                MediaPlayer f10 = f();
                int currentPosition = f10.getCurrentPosition();
                if (this.f32567p.Code() && !this.f32562k) {
                    f10.stop();
                }
                if (this.f32567p.Code(e.PLAYBACK_COMPLETED)) {
                    currentPosition = 0;
                }
                F(currentPosition);
                Code(0, 0);
                this.f32567p.I(e.INITIALIZED);
            } catch (IllegalStateException unused) {
                gl.I(I, "stop IllegalStateException");
                this.f32567p.I(e.ERROR);
            }
        }
        this.f32564m = 0;
        this.f32571t = 0;
        t();
        F(this.f32558g);
        gl.V(I, "stop - agent: %s", this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        gl.V(I, "pauseInternal before State: %s - agent: %s", this.f32567p, this);
        this.f32573v = false;
        if (this.f32567p.Code(e.END) || this.f32567p.Code(e.ERROR)) {
            return;
        }
        c cVar = this.f32567p;
        e eVar = e.PAUSED;
        if (cVar.Code(eVar) || this.f32567p.Code(e.INITIALIZED) || this.f32567p.Code(e.IDLE) || this.f32567p.Code(e.PLAYBACK_COMPLETED)) {
            return;
        }
        try {
            MediaPlayer f10 = f();
            if (f10.isPlaying()) {
                f10.pause();
            }
            this.f32567p.I(eVar);
            D(f10.getCurrentPosition());
        } catch (IllegalStateException unused) {
            gl.I(I, "pause IllegalStateException");
            this.f32567p.I(e.ERROR);
        }
        t();
        F(this.f32558g);
        gl.V(I, "pause");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int k() {
        MediaPlayer mediaPlayer;
        int duration;
        if (this.f32567p.Code(e.END)) {
            return 0;
        }
        int l10 = l();
        if (!this.f32567p.Code() || this.f32562k) {
            return l10;
        }
        try {
            synchronized (this.f32568q) {
                mediaPlayer = this.D;
            }
            return (mediaPlayer == null || (duration = mediaPlayer.getDuration()) <= 0) ? l10 : duration;
        } catch (IllegalStateException unused) {
            gl.I(I, "getDuration IllegalStateException");
            return l10;
        }
    }

    private int l() {
        int i10;
        synchronized (this.f32569r) {
            i10 = this.f32565n;
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m() {
        MediaPlayer mediaPlayer;
        if (!this.f32567p.Code()) {
            return false;
        }
        try {
            synchronized (this.f32568q) {
                mediaPlayer = this.D;
            }
            if (mediaPlayer != null) {
                return mediaPlayer.isPlaying();
            }
            return false;
        } catch (IllegalStateException unused) {
            gl.I(I, "isPlaying IllegalStateException");
            return false;
        }
    }

    private Surface n() {
        WeakReference<Surface> weakReference = this.E;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        this.f32574w = false;
        if (I(0.0f)) {
            u();
        }
        if (this.f32577z == 1 && m()) {
            e();
        }
    }

    public static /* synthetic */ int p(b bVar) {
        int i10 = bVar.f32571t;
        bVar.f32571t = i10 + 1;
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        this.f32574w = false;
        if (I(1.0f)) {
            v();
        }
        if (this.f32577z == 1 && m()) {
            z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (!this.f32561j && this.f32560i && this.M.size() > 0) {
            if (this.f32567p.Code(e.PLAYING) || this.f32567p.Code(e.PREPARING)) {
                gl.V(I, "notifyBufferingStart currentState: %s", this.f32567p);
                this.f32561j = true;
                ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.17
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator iterator2 = b.this.M.iterator2();
                        while (iterator2.hasNext()) {
                            gu guVar = (gu) iterator2.next();
                            if (guVar != null) {
                                guVar.Code();
                            }
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        CopyOnWriteArraySet<ha> copyOnWriteArraySet = this.R;
        if (copyOnWriteArraySet == null || copyOnWriteArraySet.size() == 0) {
            return;
        }
        gl.V(I, "notifyRenderStart");
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.18
            @Override // java.lang.Runnable
            public void run() {
                Iterator iterator2 = b.this.R.iterator2();
                while (iterator2.hasNext()) {
                    ha haVar = (ha) iterator2.next();
                    if (haVar != null) {
                        haVar.Code();
                    }
                }
            }
        });
    }

    private void s() {
        CopyOnWriteArraySet<gx> copyOnWriteArraySet = this.T;
        if (copyOnWriteArraySet == null || copyOnWriteArraySet.size() == 0) {
            return;
        }
        gl.V(I, "notify player release");
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.19
            @Override // java.lang.Runnable
            public void run() {
                Iterator iterator2 = b.this.T.iterator2();
                while (iterator2.hasNext()) {
                    gx gxVar = (gx) iterator2.next();
                    if (gxVar != null) {
                        gxVar.Code();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.f32561j && this.f32560i) {
            this.f32561j = false;
            gl.V(I, "notifyBufferingEnd currentState: %s", this.f32567p);
            ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.20
                @Override // java.lang.Runnable
                public void run() {
                    Iterator iterator2 = b.this.M.iterator2();
                    while (iterator2.hasNext()) {
                        gu guVar = (gu) iterator2.next();
                        if (guVar != null) {
                            guVar.V();
                        }
                    }
                }
            });
        }
    }

    private void u() {
        if (this.f32576y) {
            gl.V(I, "already muted, don't notify");
            return;
        }
        gl.V(I, "notifyMute");
        this.f32576y = true;
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.26
            @Override // java.lang.Runnable
            public void run() {
                Iterator iterator2 = b.this.O.iterator2();
                while (iterator2.hasNext()) {
                    gz gzVar = (gz) iterator2.next();
                    if (gzVar != null) {
                        gzVar.Code();
                    }
                }
            }
        });
    }

    private void v() {
        if (!this.f32576y) {
            gl.V(I, "already unmuted, don't notify");
            return;
        }
        gl.V(I, "notifyUnmute");
        this.f32576y = false;
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.27
            @Override // java.lang.Runnable
            public void run() {
                Iterator iterator2 = b.this.O.iterator2();
                while (iterator2.hasNext()) {
                    gz gzVar = (gz) iterator2.next();
                    if (gzVar != null) {
                        gzVar.V();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        F(this.f32558g);
        if (this.K.size() > 0) {
            V(this.f32555ad);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.media.MediaPlayer, android.media.MediaPlayer$OnVideoSizeChangedListener] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public void x() {
        synchronized (this.f32568q) {
            c cVar = this.f32567p;
            e eVar = e.END;
            if (cVar.Code(eVar)) {
                return;
            }
            this.f32567p.I(eVar);
            gl.V(I, "release - agent: %s", this);
            V.V();
            y();
            MediaPlayer mediaPlayer = this.D;
            if (mediaPlayer != null) {
                ?? r22 = 0;
                try {
                    try {
                        mediaPlayer.setSurface(null);
                        this.D.setOnVideoSizeChangedListener(null);
                        this.D.release();
                        this.D = null;
                        gl.V(I, "release media player");
                        r22 = "release media player";
                    } catch (IllegalStateException unused) {
                        gl.I(I, "media player reset surface IllegalStateException");
                        this.D.setOnVideoSizeChangedListener(null);
                        this.D.release();
                        this.D = null;
                        gl.V(I, "release media player");
                        r22 = "release media player";
                    }
                    s();
                } catch (Throwable th) {
                    this.D.setOnVideoSizeChangedListener(r22);
                    this.D.release();
                    this.D = r22;
                    gl.V(I, "release media player");
                    s();
                    throw th;
                }
            }
            this.K.clear();
            this.M.clear();
            this.N.clear();
            this.O.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        synchronized (this.f32568q) {
            gl.V(I, "resetInternal - agent: %s", this);
            try {
                if (this.D != null) {
                    if (this.f32567p.Code()) {
                        int currentPosition = this.D.getCurrentPosition();
                        this.D.stop();
                        if (this.f32567p.Code(e.PLAYBACK_COMPLETED)) {
                            currentPosition = 0;
                        }
                        F(currentPosition);
                        Code(0, 0);
                        C(0);
                    }
                    this.D.reset();
                }
            } catch (IllegalStateException unused) {
                gl.I(I, "media player reset IllegalStateException");
            } catch (Throwable th) {
                gl.I(I, "media player reset exception: %s", th.getClass().getSimpleName());
            }
            this.f32564m = 0;
            this.f32571t = 0;
            this.f32562k = false;
            this.f32574w = false;
            this.f32573v = false;
            this.f32575x = 0;
            this.G = 0;
            this.f32567p.I(e.IDLE);
            t();
            F(this.f32558g);
        }
    }

    private void z() {
        String str;
        if (!E()) {
            gl.I(I, "audio focus is not needed");
            return;
        }
        try {
            gl.V(I, "requestAudioFocus");
            if (Build.VERSION.SDK_INT < 26) {
                this.f32572u.requestAudioFocus(this.f32556ae, 3, 2);
            } else {
                AudioFocusRequest build = new AudioFocusRequest.Builder(2).setOnAudioFocusChangeListener(this.f32556ae).build();
                this.A = build;
                this.f32572u.requestAudioFocus(build);
            }
        } catch (IllegalStateException unused) {
            str = "requestAudioFocus IllegalStateException";
            gl.I(I, str);
        } catch (Exception e2) {
            str = "requestAudioFocus " + e2.getClass().getSimpleName();
            gl.I(I, str);
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public int B() {
        MediaPlayer mediaPlayer;
        if (!this.f32567p.Code(e.END) && !this.f32567p.Code(e.ERROR) && !this.f32567p.Code(e.IDLE)) {
            try {
                synchronized (this.f32568q) {
                    mediaPlayer = this.D;
                }
                if (mediaPlayer != null) {
                    return mediaPlayer.getCurrentPosition();
                }
            } catch (IllegalStateException unused) {
                gl.I(I, "getCurrentPlayPosition IllegalStateException");
            }
        }
        return 0;
    }

    @com.huawei.openalliance.ad.annotations.b
    public c C() {
        return this.f32567p;
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code() {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.i();
            }
        });
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(final float f10) {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.13
            @Override // java.lang.Runnable
            public void run() {
                gl.Code(b.I, "setSoundVolume %f result: %s", Float.valueOf(f10), Boolean.valueOf(b.this.I(f10)));
            }
        });
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(int i10) {
        V(i10, 0);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(final long j10, final int i10) {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.6
            @Override // java.lang.Runnable
            public void run() {
                b.this.V(j10, i10);
            }
        });
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        V(onVideoSizeChangedListener);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(final Surface surface) {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.9
            @Override // java.lang.Runnable
            public void run() {
                b.this.V(surface);
            }
        });
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(gu guVar) {
        if (guVar == null) {
            return;
        }
        this.M.add(guVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(gv gvVar) {
        if (gvVar == null) {
            return;
        }
        this.N.add(gvVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(gw gwVar) {
        if (gwVar == null) {
            return;
        }
        this.P.add(gwVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(gx gxVar) {
        V(gxVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(gy gyVar) {
        if (gyVar == null) {
            return;
        }
        this.K.add(gyVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(gz gzVar) {
        if (gzVar == null) {
            return;
        }
        this.O.add(gzVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(ha haVar) {
        V(haVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(final String str) {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.41
            @Override // java.lang.Runnable
            public void run() {
                String str2 = str;
                if (str2 == null || !TextUtils.equals(str2, b.this.f32559h)) {
                    gl.V(b.I, "playWhenUrlMatchs - url not match");
                } else {
                    b.this.g();
                }
            }
        });
    }

    public void Code(boolean z10) {
        this.H = z10;
    }

    public boolean Code(String str, MediaPlayer mediaPlayer) {
        AssetFileDescriptor openTypedAssetFileDescriptor = this.J.getContentResolver().openTypedAssetFileDescriptor(Uri.parse(str), "*/*", null);
        if (openTypedAssetFileDescriptor == null) {
            at.Code(openTypedAssetFileDescriptor);
            return false;
        }
        try {
            if (openTypedAssetFileDescriptor.getDeclaredLength() < 0) {
                mediaPlayer.setDataSource(openTypedAssetFileDescriptor.getFileDescriptor());
            } else {
                mediaPlayer.setDataSource(openTypedAssetFileDescriptor.getFileDescriptor(), openTypedAssetFileDescriptor.getStartOffset(), openTypedAssetFileDescriptor.getDeclaredLength());
            }
            return true;
        } finally {
            at.Code(openTypedAssetFileDescriptor);
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public void D() {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.10
            @Override // java.lang.Runnable
            public void run() {
                b.this.o();
            }
        });
    }

    public String F() {
        return this.f32559h;
    }

    @com.huawei.openalliance.ad.annotations.b
    public void I() {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.42
            @Override // java.lang.Runnable
            public void run() {
                b.this.h();
            }
        });
    }

    @com.huawei.openalliance.ad.annotations.b
    public void I(int i10) {
        gl.Code(I, "setPreferStartPlayTime %s", Integer.valueOf(i10));
        this.f32566o = i10;
    }

    @com.huawei.openalliance.ad.annotations.b
    public void I(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        if (onVideoSizeChangedListener == null) {
            return;
        }
        this.Q.remove(onVideoSizeChangedListener);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void I(gx gxVar) {
        if (gxVar == null) {
            return;
        }
        this.T.remove(gxVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void I(ha haVar) {
        if (haVar == null) {
            return;
        }
        this.R.remove(haVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void I(final String str) {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.5
            @Override // java.lang.Runnable
            public void run() {
                String str2 = str;
                if (str2 == null || !TextUtils.equals(str2, b.this.f32559h)) {
                    return;
                }
                b.this.j();
            }
        });
    }

    @com.huawei.openalliance.ad.annotations.b
    public void L() {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.11
            @Override // java.lang.Runnable
            public void run() {
                b.this.p();
            }
        });
    }

    @com.huawei.openalliance.ad.annotations.b
    public boolean S() {
        if (this.f32567p.Code(e.END)) {
            return false;
        }
        return ((Boolean) aw.Code(this.f32554ac, 300L, Boolean.valueOf(this.f32567p.Code(e.PLAYING)))).booleanValue();
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V() {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.40
            @Override // java.lang.Runnable
            public void run() {
                b.this.g();
            }
        });
    }

    public void V(final float f10) {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.37
            @Override // java.lang.Runnable
            public void run() {
                b.this.Z(f10);
            }
        });
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V(int i10) {
        synchronized (this.f32569r) {
            this.f32565n = i10;
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V(int i10, int i11) {
        MediaPlayer mediaPlayer;
        try {
            if (!this.f32567p.Code() || this.f32562k) {
                return;
            }
            synchronized (this.f32568q) {
                mediaPlayer = this.D;
            }
            int k10 = (k() * i10) / 100;
            V(mediaPlayer, k10, i11);
            Code(i10, k10);
        } catch (IllegalStateException unused) {
            gl.I(I, "seekTo IllegalStateException");
        }
    }

    public void V(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        if (onVideoSizeChangedListener == null) {
            return;
        }
        this.Q.add(onVideoSizeChangedListener);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V(gu guVar) {
        if (guVar == null) {
            return;
        }
        this.M.remove(guVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V(gv gvVar) {
        if (gvVar == null) {
            return;
        }
        this.N.remove(gvVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V(gw gwVar) {
        if (gwVar == null) {
            return;
        }
        this.P.remove(gwVar);
    }

    public void V(gx gxVar) {
        if (gxVar == null) {
            return;
        }
        this.T.add(gxVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V(gy gyVar) {
        if (gyVar == null) {
            return;
        }
        this.K.remove(gyVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V(gz gzVar) {
        if (gzVar == null) {
            return;
        }
        this.O.remove(gzVar);
    }

    public void V(ha haVar) {
        if (haVar == null) {
            return;
        }
        this.R.add(haVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V(final String str) {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.3
            @Override // java.lang.Runnable
            public void run() {
                String str2 = str;
                if (str2 == null || !TextUtils.equals(str2, b.this.f32559h)) {
                    return;
                }
                b.this.i();
            }
        });
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Z() {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.j();
            }
        });
    }

    public void Z(int i10) {
        this.f32577z = i10;
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Z(final String str) {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    b.this.C(str);
                } catch (fg e2) {
                    gl.Code(b.I, "set media file error:%s", e2.getMessage());
                    gl.I(b.I, "set media file error:" + e2.getClass().getSimpleName());
                }
            }
        });
    }

    @com.huawei.openalliance.ad.annotations.b
    public void a() {
        synchronized (this.f32570s) {
            int i10 = this.f32557f - 1;
            this.f32557f = i10;
            if (i10 < 0) {
                this.f32557f = 0;
            }
            if (gl.Code()) {
                gl.Code(I, "release - instanceRefCount: %d - agent: %s", Integer.valueOf(this.f32557f), this);
            }
            if (this.f32557f == 0) {
                V(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.31
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.x();
                    }
                });
            }
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public void b() {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.33
            @Override // java.lang.Runnable
            public void run() {
                b.this.y();
            }
        });
    }

    @com.huawei.openalliance.ad.annotations.b
    public void c() {
        synchronized (this.f32570s) {
            this.f32557f++;
            if (gl.Code()) {
                gl.Code(I, "acquire - instanceRefCount: %d - agent: %s", Integer.valueOf(this.f32557f), this);
            }
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public int d() {
        int i10;
        synchronized (this.f32570s) {
            i10 = this.f32557f;
        }
        return i10;
    }

    public void e() {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.35
            @Override // java.lang.Runnable
            public void run() {
                b.this.A();
            }
        });
    }

    public void finalize() {
        super.finalize();
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.b.32
            @Override // java.lang.Runnable
            public void run() {
                b.this.x();
            }
        });
    }

    public String toString() {
        return "MediaPlayerAgent@" + Integer.toHexString(hashCode()) + " [" + bc.Code(this.f32559h) + "]";
    }
}
