package com.danlan.android.videogift;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import com.danlan.android.videogift.FitViewHelper;
import com.danlan.android.videogift.a;
import java.io.FileDescriptor;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
class AlphaMovieView extends GLTextureView {

    /* renamed from: n, reason: collision with root package name */
    public com.danlan.android.videogift.a f19047n;

    /* renamed from: o, reason: collision with root package name */
    public Surface f19048o;

    /* renamed from: p, reason: collision with root package name */
    public MediaPlayer f19049p;

    /* renamed from: q, reason: collision with root package name */
    public i f19050q;

    /* renamed from: r, reason: collision with root package name */
    public g f19051r;

    /* renamed from: s, reason: collision with root package name */
    public h f19052s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f19053t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f19054u;

    /* renamed from: v, reason: collision with root package name */
    public FitViewHelper f19055v;

    /* renamed from: w, reason: collision with root package name */
    public PlayerState f19056w;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum PlayerState {
        NOT_PREPARED,
        PREPARED,
        STARTED,
        PAUSED,
        STOPPED,
        RELEASE
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements MediaPlayer.OnCompletionListener {
        public a() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            AlphaMovieView.this.f19056w = PlayerState.PAUSED;
            if (AlphaMovieView.this.f19051r != null) {
                AlphaMovieView.this.f19051r.a();
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class b implements a.InterfaceC0178a {
        public b() {
        }

        @Override // com.danlan.android.videogift.a.InterfaceC0178a
        public void a(Surface surface) {
            AlphaMovieView.this.f19048o = surface;
            AlphaMovieView.this.f19053t = true;
            AlphaMovieView.this.f19049p.setSurface(surface);
            if (AlphaMovieView.this.f19054u) {
                AlphaMovieView.this.I();
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class c implements MediaPlayer.OnPreparedListener {
        public c() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            AlphaMovieView.this.O();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class d implements MediaPlayer.OnPreparedListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MediaPlayer.OnPreparedListener f19060b;

        public d(MediaPlayer.OnPreparedListener onPreparedListener) {
            this.f19060b = onPreparedListener;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            AlphaMovieView.this.f19056w = PlayerState.PREPARED;
            this.f19060b.onPrepared(mediaPlayer);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class e implements MediaPlayer.OnPreparedListener {
        public e() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            AlphaMovieView.this.f19049p.start();
            AlphaMovieView.this.f19056w = PlayerState.STARTED;
            if (AlphaMovieView.this.f19050q != null) {
                AlphaMovieView.this.f19050q.a();
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static /* synthetic */ class f {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19063a;

        static {
            int[] iArr = new int[PlayerState.values().length];
            f19063a = iArr;
            try {
                iArr[PlayerState.PREPARED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19063a[PlayerState.PAUSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19063a[PlayerState.STOPPED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface g {
        void a();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface h {
        void onVideoError();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface i {
        void a();
    }

    public AlphaMovieView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19056w = PlayerState.NOT_PREPARED;
        if (isInEditMode()) {
            return;
        }
        B(context, attributeSet);
    }

    private void B(Context context, AttributeSet attributeSet) {
        setEGLContextClientVersion(2);
        setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        this.f19055v = new FitViewHelper();
        C();
        this.f19047n = new com.danlan.android.videogift.a();
        E(context, attributeSet);
        A();
        setRenderer(this.f19047n);
        bringToFront();
        setPreserveEGLContextOnPause(true);
        setOpaque(false);
    }

    public final void A() {
        com.danlan.android.videogift.a aVar = this.f19047n;
        if (aVar != null) {
            aVar.g(new b());
        }
    }

    public final void C() {
        this.f19049p = new MediaPlayer();
        setScreenOnWhilePlaying(true);
        setLooping(false);
        this.f19049p.setOnCompletionListener(new a());
    }

    public boolean D() {
        return this.f19056w == PlayerState.PAUSED;
    }

    public final void E(Context context, AttributeSet attributeSet) {
        this.f19047n.f(context.getString(R$string.video_gift_shader));
    }

    public final void F(MediaMetadataRetriever mediaMetadataRetriever) {
        int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18)) / 2;
        int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
        FitViewHelper fitViewHelper = this.f19055v;
        if (fitViewHelper != null) {
            fitViewHelper.h((parseInt * 1.0f) / parseInt2, 0, 0);
        }
        this.f19054u = true;
        K();
        if (this.f19053t) {
            I();
        }
    }

    public final void G() {
        C();
        Surface surface = this.f19048o;
        if (surface != null) {
            this.f19049p.setSurface(surface);
        }
        h hVar = this.f19052s;
        if (hVar != null) {
            hVar.onVideoError();
        }
    }

    public void H() {
        MediaPlayer mediaPlayer = this.f19049p;
        if (mediaPlayer == null || this.f19056w != PlayerState.STARTED) {
            return;
        }
        mediaPlayer.pause();
        this.f19056w = PlayerState.PAUSED;
    }

    public final void I() {
        J(new c());
    }

    public final void J(MediaPlayer.OnPreparedListener onPreparedListener) {
        MediaPlayer mediaPlayer = this.f19049p;
        if (mediaPlayer != null) {
            PlayerState playerState = this.f19056w;
            if (playerState == PlayerState.NOT_PREPARED || playerState == PlayerState.STOPPED) {
                mediaPlayer.setOnPreparedListener(new d(onPreparedListener));
                try {
                    this.f19049p.prepareAsync();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void K() {
        requestLayout();
        invalidate();
    }

    public void L() {
        if (this.f19049p != null) {
            this.f19048o.release();
            this.f19049p.release();
            this.f19056w = PlayerState.RELEASE;
        }
    }

    public void M() {
        MediaPlayer mediaPlayer = this.f19049p;
        if (mediaPlayer != null) {
            PlayerState playerState = this.f19056w;
            if (playerState == PlayerState.STARTED || playerState == PlayerState.PAUSED || playerState == PlayerState.STOPPED) {
                mediaPlayer.reset();
                this.f19056w = PlayerState.NOT_PREPARED;
            }
        }
    }

    public void N(int i10) {
        this.f19049p.seekTo(i10);
    }

    public void O() {
        if (this.f19049p != null) {
            int i10 = f.f19063a[this.f19056w.ordinal()];
            if (i10 == 1) {
                this.f19049p.start();
                this.f19056w = PlayerState.STARTED;
                i iVar = this.f19050q;
                if (iVar != null) {
                    iVar.a();
                    return;
                }
                return;
            }
            if (i10 == 2) {
                this.f19049p.start();
                this.f19056w = PlayerState.STARTED;
            } else {
                if (i10 != 3) {
                    return;
                }
                J(new e());
            }
        }
    }

    public int getCurrentPosition() {
        return this.f19049p.getCurrentPosition();
    }

    public MediaPlayer getMediaPlayer() {
        return this.f19049p;
    }

    public PlayerState getState() {
        return this.f19056w;
    }

    @Override // com.danlan.android.videogift.GLTextureView
    public void l() {
        super.l();
        H();
    }

    @Override // com.danlan.android.videogift.GLTextureView
    public void m() {
        super.m();
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.f19055v != null) {
            int mode = View.MeasureSpec.getMode(i10);
            int mode2 = View.MeasureSpec.getMode(i11);
            this.f19055v.a(View.MeasureSpec.getSize(i10), View.MeasureSpec.getSize(i11));
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.f19055v.g(), mode), View.MeasureSpec.makeMeasureSpec(this.f19055v.f(), mode2));
            return;
        }
        super.onMeasure(i10, i11);
    }

    public void setLooping(boolean z10) {
        this.f19049p.setLooping(z10);
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.f19049p.setOnErrorListener(onErrorListener);
    }

    public void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.f19049p.setOnSeekCompleteListener(onSeekCompleteListener);
    }

    public void setOnVideoEndedListener(g gVar) {
        this.f19051r = gVar;
    }

    public void setOnVideoErrorListener(h hVar) {
        this.f19052s = hVar;
    }

    public void setOnVideoStartedListener(i iVar) {
        this.f19050q = iVar;
    }

    public void setScaleType(FitViewHelper.ScaleType scaleType) {
        FitViewHelper fitViewHelper = this.f19055v;
        if (fitViewHelper != null) {
            fitViewHelper.i(scaleType);
            K();
        }
    }

    public void setScreenOnWhilePlaying(boolean z10) {
        this.f19049p.setScreenOnWhilePlaying(z10);
    }

    public void setVideoByUrl(String str) {
        M();
        try {
            this.f19049p.setDataSource(str);
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str, new HashMap());
            F(mediaMetadataRetriever);
        } catch (Exception e2) {
            e2.getMessage();
            G();
        }
    }

    public void setVideoFromAssets(String str) {
        M();
        try {
            AssetFileDescriptor openFd = getContext().getAssets().openFd(str);
            this.f19049p.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
            F(mediaMetadataRetriever);
        } catch (Exception e2) {
            e2.getMessage();
            G();
        }
    }

    public void setVideoFromFile(FileDescriptor fileDescriptor) {
        M();
        try {
            this.f19049p.setDataSource(fileDescriptor);
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(fileDescriptor);
            F(mediaMetadataRetriever);
        } catch (Exception e2) {
            e2.getMessage();
            G();
        }
    }

    public void setVideoFromMediaDataSource(MediaDataSource mediaDataSource) {
        M();
        this.f19049p.setDataSource(mediaDataSource);
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(mediaDataSource);
        F(mediaMetadataRetriever);
    }

    public void setVideoFromUri(Context context, Uri uri) {
        M();
        try {
            this.f19049p.setDataSource(context, uri);
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(context, uri);
            F(mediaMetadataRetriever);
        } catch (Exception e2) {
            e2.getMessage();
            G();
        }
    }

    public void setVideoFromFile(FileDescriptor fileDescriptor, int i10, int i11) {
        M();
        try {
            long j10 = i10;
            long j11 = i11;
            this.f19049p.setDataSource(fileDescriptor, j10, j11);
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(fileDescriptor, j10, j11);
            F(mediaMetadataRetriever);
        } catch (Exception e2) {
            e2.getMessage();
            G();
        }
    }
}
