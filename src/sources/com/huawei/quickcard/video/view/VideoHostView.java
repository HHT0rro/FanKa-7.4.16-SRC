package com.huawei.quickcard.video.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.Cleanable;
import com.huawei.quickcard.FullScreenExtendedParams;
import com.huawei.quickcard.IFullScreenHelper;
import com.huawei.quickcard.LifeListener;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.base.utils.CardThreadUtils;
import com.huawei.quickcard.exposure.ExposureManager;
import com.huawei.quickcard.framework.IComponentSupport;
import com.huawei.quickcard.framework.bean.ConfigBean;
import com.huawei.quickcard.framework.border.Border;
import com.huawei.quickcard.framework.border.BorderRadius;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.utils.FullScreenImpl;
import com.huawei.quickcard.utils.NetworkConnectivityMonitor;
import com.huawei.quickcard.utils.NetworkInfoImpl;
import com.huawei.quickcard.utils.NetworkUtils;
import com.huawei.quickcard.utils.QuickCardValueUtil;
import com.huawei.quickcard.utils.ViewUtils;
import com.huawei.quickcard.video.R;
import com.huawei.quickcard.video.processor.IVideoEvent;
import com.huawei.quickcard.video.utils.EventFilter;
import com.huawei.quickcard.video.utils.FullScreenUtils;
import com.huawei.quickcard.video.utils.VideoFullScreenHelper;
import com.huawei.quickcard.video.utils.VideoGlobalConfig;
import com.huawei.quickcard.video.view.BaseMediaGestureHelper;
import com.huawei.quickcard.video.view.FastVideo;
import com.huawei.quickcard.video.view.MediaControllerView;
import com.huawei.quickcard.views.image.extension.FitMode;
import com.huawei.quickcard.views.image.view.BorderDrawer;
import com.huawei.quickcard.views.image.view.FlexImageView;
import com.huawei.quickcard.views.image.view.IBorderDrawer;
import com.huawei.quickcard.views.image.view.IImageHost;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.HashMap;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class VideoHostView extends FrameLayout implements IComponentSupport, BaseMediaGestureHelper.MediaGestureHelperHoster, BaseMediaGestureHelper.MediaGestureChangeListener, IVideoHost, IVideoHostView {

    /* renamed from: u0, reason: collision with root package name */
    private static final String f34429u0 = "VideoLayout";

    /* renamed from: v0, reason: collision with root package name */
    private static final int f34430v0 = 30;

    /* renamed from: w0, reason: collision with root package name */
    private static final int f34431w0 = 200;

    /* renamed from: x0, reason: collision with root package name */
    private static final String f34432x0 = "portrait";

    /* renamed from: y0, reason: collision with root package name */
    private static final int f34433y0 = -1;
    private IVideoEvent A;
    private IVideoEvent B;
    private IVideoEvent C;
    private IVideoEvent D;
    private IVideoEvent E;
    private IVideoEvent F;
    private IVideoEvent G;
    private IVideoEvent H;
    private IVideoEvent I;
    private IVideoEvent J;
    private IVideoEvent K;
    private Cleanable L;
    private LifeListener M;
    private BorderRadius N;
    private Object O;
    private String P;
    private View Q;
    private EventFilter.IEventCallback R;
    private String S;
    private FullScreenImpl T;
    private NetworkConnectivityMonitor.ConnectivityListener U;
    private String V;
    private String W;

    /* renamed from: a, reason: collision with root package name */
    private final Runnable f34434a;

    /* renamed from: a0, reason: collision with root package name */
    private int f34435a0;

    /* renamed from: b, reason: collision with root package name */
    private final Runnable f34436b;

    /* renamed from: b0, reason: collision with root package name */
    private int f34437b0;

    /* renamed from: c, reason: collision with root package name */
    private final Runnable f34438c;

    /* renamed from: c0, reason: collision with root package name */
    private m f34439c0;

    /* renamed from: d, reason: collision with root package name */
    private final Runnable f34440d;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f34441d0;

    /* renamed from: e, reason: collision with root package name */
    private final IFullScreenHelper.IFullScreenListener f34442e;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f34443e0;

    /* renamed from: f, reason: collision with root package name */
    private final Runnable f34444f;

    /* renamed from: f0, reason: collision with root package name */
    private String f34445f0;

    /* renamed from: g, reason: collision with root package name */
    private final ViewTreeObserver.OnGlobalLayoutListener f34446g;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f34447g0;

    /* renamed from: h, reason: collision with root package name */
    private final ViewTreeObserver.OnScrollChangedListener f34448h;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f34449h0;

    /* renamed from: i, reason: collision with root package name */
    private final IBorderDrawer f34450i;

    /* renamed from: i0, reason: collision with root package name */
    private View f34451i0;

    /* renamed from: j, reason: collision with root package name */
    private final Rect f34452j;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f34453j0;

    /* renamed from: k, reason: collision with root package name */
    private boolean f34454k;

    /* renamed from: k0, reason: collision with root package name */
    private ExposureManager f34455k0;

    /* renamed from: l, reason: collision with root package name */
    private String f34456l;

    /* renamed from: l0, reason: collision with root package name */
    private Border f34457l0;

    /* renamed from: m, reason: collision with root package name */
    private ProgressBar f34458m;

    /* renamed from: m0, reason: collision with root package name */
    private BaseMediaGestureHelper f34459m0;

    /* renamed from: n, reason: collision with root package name */
    private boolean f34460n;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f34461n0;

    /* renamed from: o, reason: collision with root package name */
    private boolean f34462o;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f34463o0;

    /* renamed from: p, reason: collision with root package name */
    private String f34464p;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f34465p0;

    /* renamed from: q, reason: collision with root package name */
    private FastVideo f34466q;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f34467q0;

    /* renamed from: r, reason: collision with root package name */
    private MediaControllerView f34468r;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f34469r0;

    /* renamed from: s, reason: collision with root package name */
    private ImageView f34470s;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f34471s0;

    /* renamed from: t, reason: collision with root package name */
    private LinearLayout f34472t;

    /* renamed from: t0, reason: collision with root package name */
    private View.OnLongClickListener f34473t0;

    /* renamed from: u, reason: collision with root package name */
    private ImageView f34474u;

    /* renamed from: v, reason: collision with root package name */
    private LinearLayout f34475v;

    /* renamed from: w, reason: collision with root package name */
    private Button f34476w;

    /* renamed from: x, reason: collision with root package name */
    private TextView f34477x;

    /* renamed from: y, reason: collision with root package name */
    private LinearLayout f34478y;

    /* renamed from: z, reason: collision with root package name */
    private IVideoEvent f34479z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a implements Cleanable {
        public a() {
        }

        @Override // com.huawei.quickcard.Cleanable
        public void release() {
            VideoHostView.this.B();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class b implements LifeListener {
        public b() {
        }

        @Override // com.huawei.quickcard.LifeListener
        public void onPause() {
            VideoHostView.this.z();
        }

        @Override // com.huawei.quickcard.LifeListener
        public void onResume() {
            VideoHostView.this.A();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VideoHostView.this.f34466q != null) {
                if (VideoHostView.this.f34466q.isPlaying()) {
                    VideoHostView.this.f34466q.setUserPaused(true);
                    VideoHostView.this.f34466q.pause();
                } else if (VideoHostView.this.f34466q.isPreparing()) {
                    VideoHostView.this.f34466q.n();
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoHostView videoHostView = VideoHostView.this;
            videoHostView.b(videoHostView.W);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class e implements IFullScreenHelper.IFullScreenListener {
        public e() {
        }

        @Override // com.huawei.quickcard.IFullScreenHelper.IFullScreenListener
        public void beforeExitFullScreen() {
            if (!VideoHostView.this.f34460n || VideoHostView.this.f34466q == null) {
                return;
            }
            VideoHostView.this.f34466q.e(false);
        }

        @Override // com.huawei.quickcard.IFullScreenHelper.IFullScreenListener
        public void onExitFullScreen() {
            if (VideoHostView.this.f34460n && VideoHostView.this.f34466q != null) {
                if (VideoHostView.this.f34468r != null) {
                    VideoHostView.this.f34468r.n();
                }
                VideoHostView.this.f34460n = false;
                if (VideoHostView.this.I != null) {
                    HashMap hashMap = new HashMap(1);
                    hashMap.put("fullscreen", Boolean.FALSE);
                    VideoHostView.this.I.onCallback(VideoHostView.this, hashMap);
                }
            }
            VideoHostView.this.a((String) null, false);
            VideoHostView videoHostView = VideoHostView.this;
            videoHostView.a(videoHostView.f34461n0);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class f implements View.OnLongClickListener {
        public f() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return VideoHostView.this.f34473t0 != null && VideoHostView.this.f34473t0.onLongClick(VideoHostView.this);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class g implements MediaControllerView.SeekBarChangeListener {
        public g() {
        }

        @Override // com.huawei.quickcard.video.view.MediaControllerView.SeekBarChangeListener
        public void onSeeked(int i10) {
            if (VideoHostView.this.E != null) {
                HashMap hashMap = new HashMap(1);
                hashMap.put("currenttime", Float.valueOf(i10 / 1000.0f));
                VideoHostView.this.E.onCallback(VideoHostView.this, hashMap);
            }
        }

        @Override // com.huawei.quickcard.video.view.MediaControllerView.SeekBarChangeListener
        public void onSeeking(int i10) {
            if (VideoHostView.this.F != null) {
                HashMap hashMap = new HashMap(1);
                hashMap.put("currenttime", Float.valueOf(i10 / 1000.0f));
                VideoHostView.this.F.onCallback(VideoHostView.this, hashMap);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class h implements FastVideo.FastVideoStateListener {
        public h() {
        }

        @Override // com.huawei.quickcard.video.view.FastVideo.FastVideoStateListener
        public void onBufferingEnd() {
            VideoHostView.this.f34458m.setVisibility(8);
            VideoHostView.this.f34472t.setVisibility(8);
            VideoHostView.this.setPosterVisible(false);
            VideoHostView.this.f34469r0 = false;
        }

        @Override // com.huawei.quickcard.video.view.FastVideo.FastVideoStateListener
        public void onBufferingStart() {
            if (VideoHostView.this.f34466q != null && !VideoHostView.this.f34466q.isPaused()) {
                VideoHostView.this.f34472t.setVisibility(8);
                VideoHostView.this.f34458m.setVisibility(0);
            }
            VideoHostView.this.f34469r0 = true;
        }

        @Override // com.huawei.quickcard.video.view.FastVideo.FastVideoStateListener
        public void onCompletion() {
            VideoHostView.this.a(5);
            VideoHostView.this.f34472t.setVisibility(8);
            VideoHostView.this.f34458m.setVisibility(8);
            if (VideoHostView.this.f34468r != null) {
                VideoHostView.this.f34468r.b(0);
                VideoHostView.this.f34468r.s();
            }
            VideoHostView.this.setPosterVisible(true);
            if (VideoHostView.this.D != null) {
                VideoHostView.this.D.onCallback(VideoHostView.this, new HashMap(1));
            }
        }

        @Override // com.huawei.quickcard.video.view.FastVideo.FastVideoStateListener
        public void onError(int i10, int i11) {
            if (VideoHostView.this.f34460n) {
                VideoHostView.this.h();
            }
            VideoHostView.this.a(-1);
            VideoHostView.this.f34458m.setVisibility(8);
            if (VideoHostView.this.f34454k) {
                VideoHostView.this.f34472t.setVisibility(0);
                VideoHostView.this.f34475v.setVisibility(8);
                VideoHostView.this.f34477x.setText(R.string.quick_card_video_play_fail);
                VideoHostView.this.f34476w.setText(R.string.quick_card_fa_vp_tv_error_retry);
                VideoHostView.this.f34478y.setVisibility(0);
            }
            if (VideoHostView.this.f34468r != null) {
                VideoHostView.this.f34468r.g();
            }
            VideoHostView.this.setPosterVisible(true);
            VideoHostView.this.a(i10, i11);
        }

        @Override // com.huawei.quickcard.video.view.FastVideo.FastVideoStateListener
        public void onIdle() {
            VideoHostView.this.N();
            VideoHostView.this.a(0);
            if (VideoHostView.this.f34468r != null) {
                VideoHostView.this.f34468r.g();
            }
            if (VideoHostView.this.K != null) {
                VideoHostView.this.K.onCallback(VideoHostView.this, new HashMap(1));
            }
        }

        @Override // com.huawei.quickcard.video.view.FastVideo.FastVideoStateListener
        public void onPause() {
            VideoHostView.this.f34458m.setVisibility(8);
            if (VideoHostView.this.f34468r != null) {
                VideoHostView.this.f34468r.b(0);
            }
            VideoHostView.this.a(4);
            if (VideoHostView.this.C != null) {
                VideoHostView.this.C.onCallback(VideoHostView.this, new HashMap(1));
            }
        }

        @Override // com.huawei.quickcard.video.view.FastVideo.FastVideoStateListener
        public void onPlaying() {
            if (VideoHostView.this.f34465p0 && !VideoHostView.this.f34469r0) {
                VideoHostView.this.f34458m.setVisibility(8);
                VideoHostView.this.f34472t.setVisibility(8);
                VideoHostView.this.setPosterVisible(false);
                if (VideoHostView.this.f34468r != null) {
                    VideoHostView.this.f34468r.p();
                }
            }
            VideoHostView.this.a(3);
            if (VideoHostView.this.B != null) {
                VideoHostView.this.B.onCallback(VideoHostView.this, new HashMap(1));
            }
            VideoHostView.this.i();
        }

        @Override // com.huawei.quickcard.video.view.FastVideo.FastVideoStateListener
        public void onPrepared() {
            VideoHostView.this.a(2);
            if (VideoHostView.this.f34465p0) {
                VideoHostView.this.f34472t.setVisibility(8);
                VideoHostView.this.f34458m.setVisibility(8);
            }
            if (VideoHostView.this.f34479z != null) {
                int duration = VideoHostView.this.f34466q != null ? VideoHostView.this.f34466q.getDuration() : 0;
                HashMap hashMap = new HashMap(1);
                hashMap.put("duration", Float.valueOf(duration / 1000.0f));
                VideoHostView.this.f34479z.onCallback(VideoHostView.this, hashMap);
            }
        }

        @Override // com.huawei.quickcard.video.view.FastVideo.FastVideoStateListener
        public void onPreparing() {
            VideoHostView.this.a(1);
            VideoHostView.this.f34472t.setVisibility(8);
            VideoHostView.this.f34458m.setVisibility(0);
        }

        @Override // com.huawei.quickcard.video.view.FastVideo.FastVideoStateListener
        public void onStart() {
            if (VideoHostView.this.A != null && !VideoHostView.this.f34462o) {
                VideoHostView.this.A.onCallback(VideoHostView.this, new HashMap(1));
                VideoHostView.this.f34462o = true;
            }
            VideoHostView.this.f34439c0 = m.NONE;
            VideoHostView.this.o();
        }

        @Override // com.huawei.quickcard.video.view.FastVideo.FastVideoStateListener
        public void onVideoRenderingStart() {
            VideoHostView.this.f34458m.setVisibility(8);
            VideoHostView.this.f34472t.setVisibility(8);
            VideoHostView.this.setPosterVisible(false);
            if (VideoHostView.this.f34468r != null) {
                VideoHostView.this.f34468r.p();
            }
            VideoHostView.this.f34465p0 = true;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class i implements FastVideo.FastVideoSurfaceListener {
        public i() {
        }

        @Override // com.huawei.quickcard.video.view.FastVideo.FastVideoSurfaceListener
        public void onSurfaceTextureAvailable() {
        }

        @Override // com.huawei.quickcard.video.view.FastVideo.FastVideoSurfaceListener
        public void onSurfaceTextureDestroyed() {
            VideoHostView.this.setPosterVisible(true);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class j implements FastVideo.OnFastVideoTimeUpdateListener {
        public j() {
        }

        @Override // com.huawei.quickcard.video.view.FastVideo.OnFastVideoTimeUpdateListener
        public void onTimeUpdate() {
            if (VideoHostView.this.H != null) {
                int currentPosition = VideoHostView.this.f34466q != null ? VideoHostView.this.f34466q.getCurrentPosition() : 0;
                HashMap hashMap = new HashMap(1);
                hashMap.put("currenttime", Float.valueOf(currentPosition / 1000.0f));
                VideoHostView.this.H.onCallback(VideoHostView.this, hashMap);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class k implements FastVideo.FastVideoAutoStartListener {
        public k() {
        }

        @Override // com.huawei.quickcard.video.view.FastVideo.FastVideoAutoStartListener
        public boolean onAutoStart() {
            return VideoHostView.this.c();
        }

        @Override // com.huawei.quickcard.video.view.FastVideo.FastVideoAutoStartListener
        public boolean stopForAutoStopLength() {
            return VideoHostView.this.f34439c0 != m.NONE;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class l implements NetworkConnectivityMonitor.ConnectivityListener {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<VideoHostView> f34491a;

        public l(@NonNull VideoHostView videoHostView) {
            this.f34491a = new WeakReference<>(videoHostView);
        }

        @Override // com.huawei.quickcard.utils.NetworkConnectivityMonitor.ConnectivityListener
        public void onConnectivityChanged(boolean z10) {
        }

        @Override // com.huawei.quickcard.utils.NetworkConnectivityMonitor.ConnectivityListener
        public void onNetworkTypeChanged(NetworkInfo networkInfo) {
            VideoHostView videoHostView = this.f34491a.get();
            if (videoHostView != null) {
                videoHostView.c(NetworkUtils.getNetworkType(networkInfo));
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum m {
        VERTICAL,
        HORIZONTAL,
        ALL,
        NONE
    }

    public VideoHostView(@NonNull Context context) {
        super(context);
        this.f34434a = new Runnable() { // from class: com.huawei.quickcard.video.view.c
            @Override // java.lang.Runnable
            public final void run() {
                VideoHostView.this.O();
            }
        };
        this.f34436b = new c();
        this.f34438c = new Runnable() { // from class: com.huawei.quickcard.video.view.e
            @Override // java.lang.Runnable
            public final void run() {
                VideoHostView.this.I();
            }
        };
        this.f34440d = new d();
        this.f34442e = new e();
        this.f34444f = new Runnable() { // from class: com.huawei.quickcard.video.view.d
            @Override // java.lang.Runnable
            public final void run() {
                VideoHostView.this.J();
            }
        };
        this.f34446g = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.huawei.quickcard.video.view.i
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                VideoHostView.this.w();
            }
        };
        this.f34448h = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.huawei.quickcard.video.view.j
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                VideoHostView.this.w();
            }
        };
        p();
        setBackgroundColor(-301989888);
        k();
        setOnKeyListener(new View.OnKeyListener() { // from class: com.huawei.quickcard.video.view.h
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
                boolean a10;
                a10 = VideoHostView.this.a(view, i10, keyEvent);
                return a10;
            }
        });
        K();
        this.f34450i = new BorderDrawer(this);
        this.f34452j = new Rect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        Object obj = this.O;
        if (obj == null || this.f34466q == null) {
            return;
        }
        QuickCardValue wrap = QuickCardValueUtil.wrap(obj);
        if (wrap.isWrapper()) {
            Object obj2 = wrap.getDataWrapper().get("currenttime");
            if (obj2 instanceof Number) {
                this.f34466q.seekTo(((Number) obj2).intValue() * 1000);
            }
        }
    }

    private void K() {
        if (getResources().getConfiguration().getLayoutDirection() == 1) {
            M();
        } else {
            L();
        }
    }

    private void L() {
        this.f34474u.setRotation(0.0f);
        setLayoutDirection(0);
        setTextDirection(3);
    }

    private void M() {
        this.f34474u.setRotation(180.0f);
        setLayoutDirection(1);
        setTextDirection(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        if (this.f34454k) {
            this.f34472t.setVisibility(0);
            this.f34475v.setVisibility(0);
            this.f34478y.setVisibility(8);
        }
        this.f34458m.setVisibility(8);
        setPosterVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        this.f34439c0 = m.NONE;
        if (TextUtils.isEmpty(this.S)) {
            return;
        }
        this.f34458m.setVisibility(0);
        if (this.f34466q == null) {
            f();
        }
        if (c()) {
            this.f34466q.setUserPaused(false);
            this.f34466q.start();
        }
    }

    private void P() {
        if (this.f34468r.k()) {
            this.f34468r.g();
        } else {
            this.f34468r.p();
        }
    }

    private EventFilter.IEventCallback getEventCallback() {
        if (this.R == null) {
            this.R = new EventFilter.IEventCallback() { // from class: com.huawei.quickcard.video.view.k
                @Override // com.huawei.quickcard.video.utils.EventFilter.IEventCallback
                public final void onDo() {
                    VideoHostView.this.y();
                }
            };
        }
        return this.R;
    }

    private void setMediaControllerVisible(boolean z10) {
        MediaControllerView mediaControllerView = this.f34468r;
        if (mediaControllerView != null) {
            if (z10) {
                mediaControllerView.setCanShow(true);
                FastVideo fastVideo = this.f34466q;
                if (fastVideo != null) {
                    if (fastVideo.isPlaying()) {
                        this.f34468r.p();
                        return;
                    } else {
                        if (this.f34466q.isPaused()) {
                            this.f34468r.b(0);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            mediaControllerView.setCanShow(false);
            this.f34468r.g();
        }
    }

    private void setPosterObjectFit(@NonNull IImageHost iImageHost) {
        if (TextUtils.isEmpty(this.f34464p)) {
            return;
        }
        iImageHost.setFitMode(a(this.f34456l));
    }

    private void setStartContainerVisible(boolean z10) {
        LinearLayout linearLayout = this.f34472t;
        if (linearLayout != null) {
            if (z10) {
                FastVideo fastVideo = this.f34466q;
                if (fastVideo == null || !fastVideo.isPlaying()) {
                    this.f34472t.setVisibility(0);
                    return;
                }
                return;
            }
            linearLayout.setVisibility(8);
        }
    }

    @Override // com.huawei.quickcard.video.view.BaseMediaGestureHelper.MediaGestureHelperHoster
    public boolean canChangePosition() {
        FastVideo fastVideo = this.f34466q;
        return (fastVideo == null || fastVideo.c() == -1 || this.f34466q.c() == 1) ? false : true;
    }

    @Override // com.huawei.quickcard.video.view.BaseMediaGestureHelper.MediaGestureHelperHoster
    public boolean canSeek() {
        FastVideo fastVideo = this.f34466q;
        return fastVideo != null && fastVideo.a();
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j10) {
        boolean drawChild = super.drawChild(canvas, view, j10);
        if (this.N != null) {
            this.f34450i.drawMaskLayer(canvas, this.f34452j);
        }
        return drawChild;
    }

    @Override // com.huawei.quickcard.framework.IComponentFunction
    public /* synthetic */ void focus(Object obj) {
        com.huawei.quickcard.framework.b.a(this, obj);
    }

    @Override // com.huawei.quickcard.video.view.BaseMediaGestureHelper.MediaGestureHelperHoster
    public int getCurrentPosition() {
        FastVideo fastVideo = this.f34466q;
        if (fastVideo == null) {
            return 0;
        }
        return fastVideo.getCurrentPosition();
    }

    @Override // com.huawei.quickcard.video.view.BaseMediaGestureHelper.MediaGestureHelperHoster
    public int getDuration() {
        FastVideo fastVideo = this.f34466q;
        if (fastVideo == null) {
            return 0;
        }
        return fastVideo.getDuration();
    }

    @Override // com.huawei.quickcard.video.view.BaseMediaGestureHelper.MediaGestureHelperHoster
    public int getHosterMeasuredHeight() {
        return getMeasuredHeight();
    }

    @Override // com.huawei.quickcard.video.view.BaseMediaGestureHelper.MediaGestureHelperHoster
    public int getHosterMeasuredWidth() {
        return getMeasuredWidth();
    }

    @Override // com.huawei.quickcard.framework.IComponentSupport
    public /* synthetic */ ViewParent getViewParent(View view) {
        return com.huawei.quickcard.framework.c.a(this, view);
    }

    @Override // com.huawei.quickcard.video.view.BaseMediaGestureHelper.MediaGestureHelperHoster
    public boolean isGestureEffective() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        j();
        if (b()) {
            r();
        }
        ExposureManager exposureManager = this.f34455k0;
        if (exposureManager != null) {
            exposureManager.onAttachedToWindow(this);
        }
    }

    @Override // com.huawei.quickcard.video.view.BaseMediaGestureHelper.MediaGestureChangeListener
    public void onBrightnessChange(float f10, float f11) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        D();
        ExposureManager exposureManager = this.f34455k0;
        if (exposureManager != null) {
            exposureManager.onDetachedFromWindow(this);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.N != null) {
            this.f34450i.drawMaskLayer(canvas, this.f34452j);
        }
    }

    @Override // android.view.View
    public void onScreenStateChanged(int i10) {
        ExposureManager exposureManager = this.f34455k0;
        if (exposureManager != null) {
            exposureManager.onScreenSateChange(this, i10);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f34452j.set(0, 0, i10, i11);
        Border border = new Border();
        border.setBorderRadius(this.N);
        this.f34450i.prepare(border, this.f34452j);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int c4;
        BaseMediaGestureHelper baseMediaGestureHelper;
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        FastVideo fastVideo = this.f34466q;
        if (fastVideo != null && (c4 = fastVideo.c()) != -1 && c4 != 1) {
            if (this.f34460n && (baseMediaGestureHelper = this.f34459m0) != null) {
                onTouchEvent = baseMediaGestureHelper.onTouch(motionEvent);
            }
            if (motionEvent.getAction() == 0 && c4 != 4 && c4 != 0 && c4 != 5) {
                P();
            }
        }
        return onTouchEvent;
    }

    @Override // com.huawei.quickcard.framework.IComponentSupport
    public /* synthetic */ void onViewCreated(CardContext cardContext) {
        com.huawei.quickcard.framework.c.b(this, cardContext);
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i10) {
        ExposureManager exposureManager = this.f34455k0;
        if (exposureManager != null) {
            exposureManager.onVisibilityChanged(this, view, i10);
        }
        if (i10 == 0) {
            A();
        } else {
            z();
        }
    }

    @Override // com.huawei.quickcard.video.view.IVideoHostView
    public void pause() {
        CardThreadUtils.cancelOnMainThread(this.f34436b);
        CardThreadUtils.runOnMainThreadDelay(this.f34436b, 30);
    }

    @Override // com.huawei.quickcard.video.view.BaseMediaGestureHelper.MediaGestureHelperHoster
    public void requestHosterDisallowInterceptTouchEvent(boolean z10) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z10);
        }
    }

    @Override // com.huawei.quickcard.video.view.IVideoHost
    public void setAutoGoOnLength(int i10) {
        this.f34437b0 = i10;
    }

    @Override // com.huawei.quickcard.video.view.IVideoHost
    public void setAutoPlay(boolean z10) {
        this.f34449h0 = z10;
        FastVideo fastVideo = this.f34466q;
        if (fastVideo != null) {
            fastVideo.d(z10);
        } else {
            if (!z10 || TextUtils.isEmpty(this.S)) {
                return;
            }
            f();
        }
    }

    @Override // com.huawei.quickcard.video.view.IVideoHost
    public void setAutoStopLength(int i10) {
        if (i10 >= 0 && this.f34435a0 < 0) {
            r();
        } else if (i10 < 0 && this.f34435a0 >= 0) {
            D();
        }
        this.f34435a0 = i10;
    }

    @Override // com.huawei.quickcard.video.view.IVideoHost
    public void setBlockAutoContinuePlay(boolean z10) {
        this.f34467q0 = z10;
        FastVideo fastVideo = this.f34466q;
        if (fastVideo != null) {
            fastVideo.a(z10);
        }
    }

    @Override // com.huawei.quickcard.video.view.IVideoHost
    public void setBorderRadius(BorderRadius borderRadius) {
        this.N = borderRadius;
        E();
        KeyEvent.Callback callback = this.f34470s;
        if (callback instanceof IImageHost) {
            a((IImageHost) callback);
        }
    }

    @Override // com.huawei.quickcard.video.view.IVideoHost
    public void setControls(boolean z10) {
        if (this.f34454k == z10) {
            return;
        }
        this.f34454k = z10;
        setStartContainerVisible(z10);
        setMediaControllerVisible(z10);
    }

    @Override // com.huawei.quickcard.video.view.IVideoHostView
    public void setCurrentTime(Object obj) {
        this.O = obj;
        CardThreadUtils.cancelOnMainThread(this.f34444f);
        CardThreadUtils.runOnMainThreadDelay(this.f34444f, 30);
    }

    @Override // com.huawei.quickcard.video.view.IVideoHost
    public void setErrorListener(IVideoEvent iVideoEvent) {
        this.G = iVideoEvent;
    }

    @Override // com.huawei.quickcard.exposure.IExposureSupport
    public void setExposureManager(ExposureManager exposureManager) {
        this.f34455k0 = exposureManager;
    }

    @Override // com.huawei.quickcard.video.view.IVideoHost
    public void setFinishListener(IVideoEvent iVideoEvent) {
        this.D = iVideoEvent;
    }

    @Override // com.huawei.quickcard.video.view.IVideoHost
    public void setFullScreenChangeListener(IVideoEvent iVideoEvent) {
        this.I = iVideoEvent;
    }

    @Override // com.huawei.quickcard.video.view.IVideoHost
    public void setFullScreenEnable(boolean z10) {
        this.f34447g0 = z10;
        MediaControllerView mediaControllerView = this.f34468r;
        if (mediaControllerView != null) {
            mediaControllerView.setFullScreenEnable(z10);
        }
    }

    @Override // com.huawei.quickcard.video.view.IVideoHost
    public void setIdleListener(IVideoEvent iVideoEvent) {
        this.K = iVideoEvent;
    }

    @Override // com.huawei.quickcard.video.view.IVideoHost
    public void setMultiPlayEnable(boolean z10) {
        this.f34471s0 = z10;
        FastVideo fastVideo = this.f34466q;
        if (fastVideo != null) {
            fastVideo.b(z10);
        }
    }

    @Override // com.huawei.quickcard.video.view.IVideoHost
    public void setMuted(boolean z10) {
        this.f34441d0 = z10;
        FastVideo fastVideo = this.f34466q;
        if (fastVideo != null) {
            fastVideo.c(z10);
        }
        MediaControllerView mediaControllerView = this.f34468r;
        if (mediaControllerView != null) {
            if (z10) {
                mediaControllerView.e();
            } else {
                mediaControllerView.f();
            }
        }
    }

    @Override // com.huawei.quickcard.video.view.IVideoHost
    public void setNetworkChangeListener(IVideoEvent iVideoEvent) {
        this.J = iVideoEvent;
    }

    @Override // com.huawei.quickcard.video.view.IVideoHost
    public void setObjectFit(String str) {
        this.f34456l = str;
        FastVideo fastVideo = this.f34466q;
        if (fastVideo != null) {
            fastVideo.a(str);
        }
        KeyEvent.Callback callback = this.f34470s;
        if (callback instanceof IImageHost) {
            setPosterObjectFit((IImageHost) callback);
        }
    }

    @Override // android.view.View
    public void setOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        super.setOnLongClickListener(onLongClickListener);
        this.f34473t0 = onLongClickListener;
    }

    @Override // com.huawei.quickcard.video.view.IVideoHost
    public void setOrientation(String str) {
        this.P = str;
    }

    @Override // com.huawei.quickcard.video.view.IVideoHost
    public void setPauseListener(IVideoEvent iVideoEvent) {
        this.C = iVideoEvent;
    }

    @Override // com.huawei.quickcard.video.view.IVideoHost
    public void setPlayingListener(IVideoEvent iVideoEvent) {
        this.B = iVideoEvent;
    }

    @Override // com.huawei.quickcard.video.view.IVideoHost
    public void setPoster(String str) {
        if (str == null && this.f34464p == null) {
            return;
        }
        e();
        if (str == null || !str.equals(this.f34464p)) {
            this.f34464p = str;
            if (TextUtils.isEmpty(str)) {
                setPosterVisible(false);
                return;
            }
            KeyEvent.Callback callback = this.f34470s;
            if (callback instanceof IImageHost) {
                IImageHost iImageHost = (IImageHost) callback;
                if (this.f34456l != null) {
                    setPosterObjectFit(iImageHost);
                }
                iImageHost.setSrc(this.f34464p);
                iImageHost.setPlaceHolder("blank", null);
                a(iImageHost);
                iImageHost.loadImage();
            }
            FastVideo fastVideo = this.f34466q;
            if (fastVideo == null || !fastVideo.isPlaying()) {
                setPosterVisible(true);
            }
        }
    }

    @Override // com.huawei.quickcard.video.view.IVideoHostView
    public void setPosterVisible(boolean z10) {
        this.f34463o0 = z10;
        CardThreadUtils.cancelOnMainThread(this.f34438c);
        CardThreadUtils.runOnMainThreadDelay(this.f34438c, 30);
    }

    @Override // com.huawei.quickcard.video.view.IVideoHost
    public void setPreparedListener(IVideoEvent iVideoEvent) {
        this.f34479z = iVideoEvent;
    }

    @Override // com.huawei.quickcard.video.view.BaseMediaGestureHelper.MediaGestureHelperHoster
    public void setSeekValue(int i10) {
        if (!canSeek() || this.f34458m == null) {
            return;
        }
        this.f34466q.seekTo(i10);
        int duration = this.f34466q.getDuration();
        int i11 = i10 * 100;
        if (duration == 0) {
            duration = 1;
        }
        this.f34458m.setProgress(i11 / duration);
        if (this.f34466q.isPlaying()) {
            return;
        }
        this.f34466q.start();
    }

    @Override // com.huawei.quickcard.video.view.IVideoHost
    public void setSeekedListener(IVideoEvent iVideoEvent) {
        this.E = iVideoEvent;
    }

    @Override // com.huawei.quickcard.video.view.IVideoHost
    public void setSeekingListener(IVideoEvent iVideoEvent) {
        this.F = iVideoEvent;
    }

    @Override // com.huawei.quickcard.video.view.IVideoHost
    public void setStartListener(IVideoEvent iVideoEvent) {
        this.A = iVideoEvent;
    }

    @Override // com.huawei.quickcard.video.view.IVideoHost
    public void setTimeupdateListener(IVideoEvent iVideoEvent) {
        this.H = iVideoEvent;
    }

    @Override // com.huawei.quickcard.video.view.IVideoHost
    public void setTitle(String str) {
        this.f34445f0 = str;
        MediaControllerView mediaControllerView = this.f34468r;
        if (mediaControllerView != null) {
            mediaControllerView.setTitleBatText(str);
        }
    }

    @Override // com.huawei.quickcard.video.view.IVideoHost
    public void setTitleBar(boolean z10) {
        this.f34443e0 = z10;
        MediaControllerView mediaControllerView = this.f34468r;
        if (mediaControllerView != null) {
            mediaControllerView.setTitleBarVisibility(z10);
        }
    }

    @Override // com.huawei.quickcard.video.view.IVideoHost
    public void setVideoDir(int i10) {
        if (i10 == 0) {
            L();
            G();
        } else if (i10 != 1) {
            K();
            F();
        } else {
            M();
            H();
        }
    }

    public void setVideoFocusable(boolean z10) {
        this.f34461n0 = z10;
    }

    @Override // com.huawei.quickcard.video.view.IVideoHost
    public void setVideoURI(String str) {
        if (this.f34466q == null) {
            if (this.f34449h0) {
                f();
            } else {
                this.S = str;
                return;
            }
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(this.S)) {
            return;
        }
        if (TextUtils.isEmpty(str) || !str.equals(this.S)) {
            this.S = str;
            this.f34466q.b(str);
            if (TextUtils.isEmpty(this.S) || this.f34466q.isPlaying() || this.f34466q.isPreparing()) {
                return;
            }
            N();
            a(0);
            this.f34468r.g();
        }
    }

    @Override // com.huawei.quickcard.framework.IComponentSupport
    public /* synthetic */ void setViewParent(ViewParent viewParent) {
        com.huawei.quickcard.framework.c.c(this, viewParent);
    }

    @Override // com.huawei.quickcard.video.view.IVideoHostView
    public void start() {
        CardThreadUtils.cancelOnMainThread(this.f34434a);
        CardThreadUtils.runOnMainThreadDelay(this.f34434a, 30);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        FastVideo fastVideo = this.f34466q;
        if (fastVideo != null) {
            fastVideo.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        FastVideo fastVideo = this.f34466q;
        if (fastVideo != null) {
            fastVideo.b();
            this.f34466q = null;
        }
        C();
    }

    private void C() {
        NetworkConnectivityMonitor.ConnectivityListener connectivityListener = this.U;
        if (connectivityListener != null) {
            NetworkInfoImpl.removeConnectivityListener(connectivityListener);
            this.U = null;
            this.J = null;
        }
    }

    private void D() {
        View view = this.Q;
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f34446g);
        this.Q.getViewTreeObserver().removeOnScrollChangedListener(this.f34448h);
        this.Q = null;
    }

    private void E() {
        if (this.N != null) {
            Border border = new Border();
            this.f34457l0 = border;
            border.setBorderRadius(this.N);
            this.f34450i.prepare(this.f34457l0, this.f34452j);
        }
    }

    private void F() {
        if (getResources().getConfiguration().getLayoutDirection() == 1) {
            H();
        } else {
            G();
        }
    }

    private void G() {
        MediaControllerView mediaControllerView = this.f34468r;
        if (mediaControllerView != null) {
            mediaControllerView.setControllerDirection(Attributes.LayoutDirection.LTR);
        }
    }

    private void H() {
        MediaControllerView mediaControllerView = this.f34468r;
        if (mediaControllerView != null) {
            mediaControllerView.setControllerDirection(Attributes.LayoutDirection.RTL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        ImageView imageView = this.f34470s;
        if (imageView != null) {
            imageView.setVisibility((!this.f34463o0 || TextUtils.isEmpty(this.f34464p)) ? 8 : 0);
        }
    }

    private void f() {
        if (this.f34466q == null) {
            e();
            FastVideo fastVideo = new FastVideo(getContext());
            d();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            fastVideo.e().setLayoutParams(layoutParams);
            addView(fastVideo.e(), 0);
            l();
            this.f34468r.setMediaPlayer(fastVideo);
            fastVideo.a(new h());
            fastVideo.a(new i());
            fastVideo.a(new j());
            fastVideo.a(new k());
            this.f34466q = fastVideo;
            q();
        }
    }

    private void g() {
        FastVideo fastVideo;
        if (this.f34460n || (fastVideo = this.f34466q) == null) {
            return;
        }
        fastVideo.e(false);
        boolean equals = f34432x0.equals(this.P);
        m();
        FullScreenImpl fullScreenImpl = this.T;
        if (fullScreenImpl != null && fullScreenImpl.enterFullScreen("video", getContext(), this, equals ? 1 : 0)) {
            a(this.P, true);
            this.T.getFullScreenHelper("video").setFullScreenListener(this.f34442e);
            MediaControllerView mediaControllerView = this.f34468r;
            if (mediaControllerView != null) {
                mediaControllerView.d();
            }
            a(true);
            requestFocus();
            this.f34460n = true;
            if (this.I != null) {
                HashMap hashMap = new HashMap(1);
                hashMap.put("fullscreen", Boolean.TRUE);
                this.I.onCallback(this, hashMap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        FullScreenImpl fullScreenImpl;
        if (!this.f34460n || this.f34466q == null || (fullScreenImpl = this.T) == null) {
            return;
        }
        fullScreenImpl.exitFullScreen("video");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (a(this.W, this.V)) {
            return;
        }
        this.W = this.V;
        x();
    }

    private void j() {
        if (this.L == null) {
            this.L = new a();
            CardContext cardContext = ViewUtils.getCardContext(this);
            if (cardContext != null) {
                cardContext.addCleanQueue(this.L);
            }
        }
        if (this.M == null) {
            this.M = new b();
            CardContext cardContext2 = ViewUtils.getCardContext(this);
            if (cardContext2 != null) {
                cardContext2.addLifeListenerQueue(this.M);
            }
        }
    }

    private void k() {
        Context context = getContext();
        ProgressBar progressBar = new ProgressBar(context);
        progressBar.setVisibility(8);
        progressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.quick_card_video_loading_bg));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addView(progressBar, layoutParams);
        this.f34458m = progressBar;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setGravity(17);
        linearLayout.setBackgroundResource(R.color.quick_card_video_start_layout_bg);
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewUtils.dip2IntPx(this, 40.0f), ViewUtils.dip2IntPx(this, 40.0f)));
        imageView.setImageResource(R.drawable.quick_card_video_player_start_play);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        linearLayout.addView(imageView);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.quickcard.video.view.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoHostView.this.c(view);
            }
        });
        linearLayout.setOnLongClickListener(new f());
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setGravity(17);
        linearLayout2.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        addView(linearLayout2, layoutParams2);
        this.f34474u = imageView;
        this.f34475v = linearLayout;
        this.f34472t = linearLayout2;
        setStartContainerVisible(this.f34454k);
    }

    private void l() {
        int indexOfChild;
        if (this.f34468r != null) {
            return;
        }
        MediaControllerView mediaControllerView = new MediaControllerView(getContext());
        mediaControllerView.setVisibility(8);
        mediaControllerView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 80));
        int i10 = 0;
        View view = this.f34451i0;
        if (view != null && (indexOfChild = indexOfChild(view)) >= 0) {
            removeView(this.f34451i0);
            i10 = indexOfChild;
        }
        addView(mediaControllerView, i10);
        mediaControllerView.setMutedChangeListener(new MediaControllerView.MutedChangeListener() { // from class: com.huawei.quickcard.video.view.n
            @Override // com.huawei.quickcard.video.view.MediaControllerView.MutedChangeListener
            public final void onChange() {
                VideoHostView.this.u();
            }
        });
        mediaControllerView.setFullScreenChangeListener(new MediaControllerView.FullScreenChangeListener() { // from class: com.huawei.quickcard.video.view.m
            @Override // com.huawei.quickcard.video.view.MediaControllerView.FullScreenChangeListener
            public final void onChange() {
                VideoHostView.this.v();
            }
        });
        mediaControllerView.setSeekBarChangeListener(new g());
        mediaControllerView.setExitFullChangeListener(new MediaControllerView.ExitFullChangeListener() { // from class: com.huawei.quickcard.video.view.l
            @Override // com.huawei.quickcard.video.view.MediaControllerView.ExitFullChangeListener
            public final void onChange() {
                VideoHostView.this.h();
            }
        });
        this.f34468r = mediaControllerView;
        setMediaControllerVisible(this.f34454k);
        n();
    }

    private void m() {
        if (this.T == null) {
            this.T = FullScreenImpl.getFullScreenImpl(this);
        }
        FullScreenImpl fullScreenImpl = this.T;
        if (fullScreenImpl != null) {
            fullScreenImpl.registerFullScreenHelper("video", new VideoFullScreenHelper());
        }
        FullScreenExtendedParams extendedParams = this.T.getFullScreenHelper("video").getExtendedParams();
        if (extendedParams == null) {
            return;
        }
        Object param = extendedParams.getParam("mediaGestureHelper");
        if (param instanceof Class) {
            try {
                Constructor constructor = ((Class) param).getConstructor(Context.class, BaseMediaGestureHelper.MediaGestureHelperHoster.class);
                if (constructor != null) {
                    Object newInstance = constructor.newInstance(getContext(), this);
                    if (newInstance instanceof BaseMediaGestureHelper) {
                        BaseMediaGestureHelper baseMediaGestureHelper = (BaseMediaGestureHelper) newInstance;
                        this.f34459m0 = baseMediaGestureHelper;
                        baseMediaGestureHelper.setGestureChangeListener(this);
                    }
                }
            } catch (Exception unused) {
                CardLogUtils.e(f34429u0, "get MediaGestureHelper fail");
            }
        }
    }

    private void n() {
        F();
        this.f34468r.setTitleBarVisibility(this.f34443e0);
        this.f34468r.setTitleBatText(this.f34445f0);
        this.f34468r.setFullScreenEnable(this.f34447g0);
        if (this.f34441d0) {
            this.f34468r.e();
        } else {
            this.f34468r.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.U != null || this.J == null) {
            return;
        }
        l lVar = new l(this);
        this.U = lVar;
        NetworkInfoImpl.addNetworkListener(lVar);
        this.f34453j0 = NetworkInfoImpl.registerNetworkListener(getContext());
        this.V = NetworkUtils.getNetworkType(getContext());
    }

    private void p() {
        this.f34460n = false;
        this.f34454k = true;
        this.f34456l = null;
        this.f34462o = false;
        this.S = null;
        this.T = null;
        this.f34441d0 = false;
        this.f34443e0 = true;
        this.f34447g0 = true;
        this.f34449h0 = false;
        this.f34451i0 = null;
        this.f34453j0 = false;
        this.f34435a0 = -1;
        this.f34437b0 = -1;
        this.f34439c0 = m.NONE;
        this.f34461n0 = isFocusable();
        this.f34463o0 = false;
        this.f34465p0 = false;
        this.f34467q0 = VideoGlobalConfig.getBlockAutoContinuePlay();
        this.f34469r0 = false;
        this.f34471s0 = VideoGlobalConfig.getMultiPlayEnable();
    }

    private void q() {
        this.f34466q.b(this.S);
        this.f34466q.c(this.f34441d0);
        this.f34466q.d(this.f34449h0);
        this.f34466q.a(this.f34467q0);
        if (!TextUtils.isEmpty(this.f34456l)) {
            this.f34466q.a(this.f34456l);
        }
        this.f34466q.b(this.f34471s0);
    }

    private void r() {
        View rootView;
        if (this.Q == null && (rootView = getRootView()) != null) {
            rootView.getViewTreeObserver().addOnGlobalLayoutListener(this.f34446g);
            rootView.getViewTreeObserver().addOnScrollChangedListener(this.f34448h);
            this.Q = rootView;
        }
    }

    private boolean s() {
        FastVideo fastVideo = this.f34466q;
        return fastVideo != null && fastVideo.isPaused();
    }

    private boolean t() {
        FastVideo fastVideo = this.f34466q;
        return fastVideo != null && fastVideo.isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u() {
        if (this.f34466q != null) {
            setMuted(!r0.d());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v() {
        if (this.f34460n) {
            h();
        } else {
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        EventFilter.a(this, 200L, getEventCallback());
    }

    private void x() {
        CardThreadUtils.cancelOnMainThread(this.f34440d);
        CardThreadUtils.runOnMainThreadDelay(this.f34440d, 30);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        if (!this.f34460n && b()) {
            if (t() || (a() && s() && this.f34439c0 != m.NONE)) {
                Rect rect = new Rect();
                getLocalVisibleRect(rect);
                if (t()) {
                    a(rect.left, rect.right, getWidth(), m.HORIZONTAL);
                    a(rect.top, rect.bottom, getHeight(), m.VERTICAL);
                } else {
                    b(rect.left, rect.right, getWidth(), m.HORIZONTAL);
                    b(rect.top, rect.bottom, getHeight(), m.VERTICAL);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        FastVideo fastVideo = this.f34466q;
        if (fastVideo != null) {
            fastVideo.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        O();
    }

    private void d() {
        if (this.f34478y != null) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        TextView textView = new TextView(getContext());
        textView.setTextSize(2, 14.0f);
        textView.setTextColor(-1);
        textView.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(ViewUtils.dip2IntPx(this, 16.0f), 0, ViewUtils.dip2IntPx(this, 16.0f), ViewUtils.dip2IntPx(this, 12.0f));
        linearLayout.addView(textView, layoutParams);
        Button button = new Button(getContext());
        button.setLayoutParams(new ViewGroup.LayoutParams(ViewUtils.dip2IntPx(this, 96.0f), ViewUtils.dip2IntPx(this, 28.0f)));
        button.setBackgroundResource(R.drawable.quick_card_video_player_retry_bg);
        button.setTextSize(2, 14.0f);
        button.setTextColor(-1);
        button.setGravity(17);
        button.setPadding(ViewUtils.dip2IntPx(this, 8.0f), 0, ViewUtils.dip2IntPx(this, 8.0f), 0);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.quickcard.video.view.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoHostView.this.a(view);
            }
        });
        linearLayout.addView(button);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.quickcard.video.view.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoHostView.this.b(view);
            }
        });
        linearLayout.setVisibility(8);
        this.f34472t.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        this.f34476w = button;
        this.f34477x = textView;
        this.f34478y = linearLayout;
    }

    private void e() {
        if (this.f34470s == null) {
            Context context = getContext();
            if (this.f34468r == null) {
                View view = new View(context);
                this.f34451i0 = view;
                addView(view, new FrameLayout.LayoutParams(-1, -1, 80));
            }
            FlexImageView create = FlexImageView.FACTORY.create(context);
            create.setVisibility(8);
            create.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(create, 0);
            this.f34470s = create;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        if (!"none".equals(NetworkUtils.getNetworkType(getContext()))) {
            return true;
        }
        if (this.f34466q.c() != 0 && this.f34466q.c() != -1) {
            return true;
        }
        if (this.f34454k) {
            this.f34472t.setVisibility(0);
            this.f34475v.setVisibility(8);
            this.f34477x.setText(R.string.quick_card_net_error);
            this.f34476w.setText(R.string.quick_card_fa_vp_tv_error_retry);
            this.f34478y.setVisibility(0);
        }
        this.f34468r.g();
        this.f34458m.setVisibility(8);
        a(2, 2);
        return false;
    }

    private void b(int i10, int i11, int i12, m mVar) {
        int i13;
        if (t()) {
            return;
        }
        m mVar2 = this.f34439c0;
        if ((mVar2 == mVar || mVar2 == m.ALL) && i12 > (i13 = this.f34437b0)) {
            if (i10 == 0) {
                if (i11 >= i13) {
                    start();
                }
            } else {
                if (i10 <= 0 || i11 - i10 < i13 || i10 >= i12) {
                    return;
                }
                start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(View view, int i10, KeyEvent keyEvent) {
        if (!this.f34460n || i10 != 4 || keyEvent.getAction() != 0) {
            return false;
        }
        h();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        O();
    }

    private boolean b() {
        return this.f34435a0 >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i10) {
        if (getContext() instanceof Activity) {
            Activity activity = (Activity) getContext();
            switch (i10) {
                case -1:
                case 0:
                case 1:
                case 4:
                case 5:
                    activity.getWindow().clearFlags(128);
                    return;
                case 2:
                case 3:
                    activity.getWindow().addFlags(128);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (this.J == null) {
            return;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put(ConfigBean.Field.NETWORK_TYPE, str);
        FastVideo fastVideo = this.f34466q;
        if (fastVideo == null) {
            hashMap.put("videoState", 0);
        } else {
            hashMap.put("videoState", Integer.valueOf(fastVideo.c()));
        }
        this.J.onCallback(this, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i10, int i11) {
        if (this.G != null) {
            HashMap hashMap = new HashMap(2);
            hashMap.put("what", Integer.valueOf(i10));
            hashMap.put("extra", Integer.valueOf(i11));
            this.G.onCallback(this, hashMap);
        }
    }

    public VideoHostView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f34434a = new Runnable() { // from class: com.huawei.quickcard.video.view.c
            @Override // java.lang.Runnable
            public final void run() {
                VideoHostView.this.O();
            }
        };
        this.f34436b = new c();
        this.f34438c = new Runnable() { // from class: com.huawei.quickcard.video.view.e
            @Override // java.lang.Runnable
            public final void run() {
                VideoHostView.this.I();
            }
        };
        this.f34440d = new d();
        this.f34442e = new e();
        this.f34444f = new Runnable() { // from class: com.huawei.quickcard.video.view.d
            @Override // java.lang.Runnable
            public final void run() {
                VideoHostView.this.J();
            }
        };
        this.f34446g = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.huawei.quickcard.video.view.i
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                VideoHostView.this.w();
            }
        };
        this.f34448h = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.huawei.quickcard.video.view.j
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                VideoHostView.this.w();
            }
        };
        this.f34450i = new BorderDrawer(this);
        this.f34452j = new Rect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (this.f34453j0) {
            this.f34453j0 = false;
            return;
        }
        this.V = str;
        if (a(this.W, str)) {
            return;
        }
        this.W = this.V;
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z10) {
        BaseMediaGestureHelper baseMediaGestureHelper;
        BaseMediaGestureHelper baseMediaGestureHelper2;
        if (z10) {
            Activity scanForActivity = FullScreenUtils.scanForActivity(getContext());
            if (scanForActivity == null) {
                return;
            }
            int screenDegree = FullScreenUtils.getScreenDegree(scanForActivity);
            boolean isScreenOrientationPortrait = FullScreenUtils.isScreenOrientationPortrait(getContext());
            if (f34432x0.equalsIgnoreCase(str)) {
                if (isScreenOrientationPortrait || (baseMediaGestureHelper2 = this.f34459m0) == null) {
                    return;
                }
                baseMediaGestureHelper2.setOtherParams(Integer.valueOf(screenDegree));
                return;
            }
            if (!isScreenOrientationPortrait || (baseMediaGestureHelper = this.f34459m0) == null) {
                return;
            }
            baseMediaGestureHelper.setOtherParams(90);
            return;
        }
        BaseMediaGestureHelper baseMediaGestureHelper3 = this.f34459m0;
        if (baseMediaGestureHelper3 != null) {
            baseMediaGestureHelper3.setOtherParams(null);
        }
    }

    public VideoHostView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f34434a = new Runnable() { // from class: com.huawei.quickcard.video.view.c
            @Override // java.lang.Runnable
            public final void run() {
                VideoHostView.this.O();
            }
        };
        this.f34436b = new c();
        this.f34438c = new Runnable() { // from class: com.huawei.quickcard.video.view.e
            @Override // java.lang.Runnable
            public final void run() {
                VideoHostView.this.I();
            }
        };
        this.f34440d = new d();
        this.f34442e = new e();
        this.f34444f = new Runnable() { // from class: com.huawei.quickcard.video.view.d
            @Override // java.lang.Runnable
            public final void run() {
                VideoHostView.this.J();
            }
        };
        this.f34446g = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.huawei.quickcard.video.view.i
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                VideoHostView.this.w();
            }
        };
        this.f34448h = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.huawei.quickcard.video.view.j
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                VideoHostView.this.w();
            }
        };
        this.f34450i = new BorderDrawer(this);
        this.f34452j = new Rect();
    }

    private void a(@NonNull IImageHost iImageHost) {
        Border border = this.f34457l0;
        if (border != null) {
            iImageHost.setBorder(border);
        }
    }

    private FitMode a(String str) {
        if (Attributes.ImageMode.FILL.equals(str)) {
            return FitMode.FILL;
        }
        if (Attributes.ImageMode.COVER.equals(str)) {
            return FitMode.COVER;
        }
        if ("none".equals(str)) {
            return FitMode.NONE;
        }
        if ("scale-down".equals(str)) {
            return FitMode.SCALE_DOWN;
        }
        if ("contain".equals(str)) {
            return FitMode.CONTAIN;
        }
        return FitMode.COVER;
    }

    public VideoHostView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f34434a = new Runnable() { // from class: com.huawei.quickcard.video.view.c
            @Override // java.lang.Runnable
            public final void run() {
                VideoHostView.this.O();
            }
        };
        this.f34436b = new c();
        this.f34438c = new Runnable() { // from class: com.huawei.quickcard.video.view.e
            @Override // java.lang.Runnable
            public final void run() {
                VideoHostView.this.I();
            }
        };
        this.f34440d = new d();
        this.f34442e = new e();
        this.f34444f = new Runnable() { // from class: com.huawei.quickcard.video.view.d
            @Override // java.lang.Runnable
            public final void run() {
                VideoHostView.this.J();
            }
        };
        this.f34446g = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.huawei.quickcard.video.view.i
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                VideoHostView.this.w();
            }
        };
        this.f34448h = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.huawei.quickcard.video.view.j
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                VideoHostView.this.w();
            }
        };
        this.f34450i = new BorderDrawer(this);
        this.f34452j = new Rect();
    }

    private void a(int i10, int i11, int i12, m mVar) {
        int i13 = this.f34435a0;
        if (i12 <= i13) {
            return;
        }
        if (i10 == 0) {
            if (i11 <= i13) {
                a(mVar);
            }
        } else if (i10 <= 0) {
            a(mVar);
        } else if (i11 - i10 <= i13 || i10 >= i12) {
            a(mVar);
        }
    }

    private void a(m mVar) {
        if (t()) {
            pause();
            this.f34439c0 = mVar;
        } else {
            this.f34439c0 = m.ALL;
        }
    }

    private boolean a() {
        int i10 = this.f34437b0;
        return i10 >= 0 && i10 > this.f34435a0;
    }

    private boolean a(String str, String str2) {
        if (str == null) {
            return TextUtils.isEmpty(str2);
        }
        return str.equals(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z10) {
        setFocusable(z10);
        setFocusableInTouchMode(z10);
    }
}
