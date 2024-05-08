package com.danlan.android.videogift;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.danlan.android.videogift.AlphaMovieView;
import com.danlan.android.videogift.FitViewHelper;
import com.danlan.android.videogift.GLTextureView;
import java.io.File;
import java.io.FileDescriptor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class AlphaVideoGiftView extends AlphaMovieView implements LifecycleObserver {
    public static final String B = AlphaVideoGiftView.class.getSimpleName();
    public static Handler C = new Handler(Looper.getMainLooper());
    public String A;

    /* renamed from: x, reason: collision with root package name */
    public Lifecycle f19064x;

    /* renamed from: y, reason: collision with root package name */
    public d f19065y;

    /* renamed from: z, reason: collision with root package name */
    public Status f19066z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum Status {
        EMPTY,
        LOADING,
        PLAYING
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements AlphaMovieView.g {

        /* renamed from: com.danlan.android.videogift.AlphaVideoGiftView$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public class RunnableC0177a implements Runnable {
            public RunnableC0177a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AlphaVideoGiftView.this.M();
                AlphaVideoGiftView.this.f19066z = Status.EMPTY;
                if (AlphaVideoGiftView.this.f19065y != null) {
                    AlphaVideoGiftView.this.f19065y.b();
                }
            }
        }

        public a() {
        }

        @Override // com.danlan.android.videogift.AlphaMovieView.g
        public void a() {
            AlphaVideoGiftView.this.setVisibility(8);
            AlphaVideoGiftView.this.N(0);
            AlphaVideoGiftView.C.postDelayed(new RunnableC0177a(), 100L);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class b implements AlphaMovieView.h {
        public b() {
        }

        @Override // com.danlan.android.videogift.AlphaMovieView.h
        public void onVideoError() {
            AlphaVideoGiftView.this.f19066z = Status.EMPTY;
            if (AlphaVideoGiftView.this.f19065y != null) {
                AlphaVideoGiftView.this.f19065y.onError();
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class c implements AlphaMovieView.i {
        public c() {
        }

        @Override // com.danlan.android.videogift.AlphaMovieView.i
        public void a() {
            AlphaVideoGiftView.this.f19066z = Status.PLAYING;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface d {
        void a();

        void b();

        void onError();
    }

    public AlphaVideoGiftView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19064x = null;
        this.f19065y = null;
        this.f19066z = Status.EMPTY;
        this.A = "";
        k();
    }

    @Override // com.danlan.android.videogift.AlphaMovieView
    public /* bridge */ /* synthetic */ boolean D() {
        return super.D();
    }

    @Override // com.danlan.android.videogift.AlphaMovieView
    public /* bridge */ /* synthetic */ void H() {
        super.H();
    }

    @Override // com.danlan.android.videogift.AlphaMovieView
    public /* bridge */ /* synthetic */ void L() {
        super.L();
    }

    @Override // com.danlan.android.videogift.AlphaMovieView
    public /* bridge */ /* synthetic */ void M() {
        super.M();
    }

    @Override // com.danlan.android.videogift.AlphaMovieView
    public /* bridge */ /* synthetic */ void N(int i10) {
        super.N(i10);
    }

    @Override // com.danlan.android.videogift.AlphaMovieView
    public /* bridge */ /* synthetic */ void O() {
        super.O();
    }

    public void S(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str) || Status.EMPTY != this.f19066z) {
            return;
        }
        this.f19066z = Status.LOADING;
        this.A = str;
        setVideoFromUri(context, Uri.fromFile(new File(str)));
        T();
    }

    public final void T() {
        d dVar = this.f19065y;
        if (dVar != null) {
            dVar.a();
        }
        setVisibility(0);
        try {
            O();
        } catch (Exception e2) {
            this.f19066z = Status.EMPTY;
            e2.printStackTrace();
        }
    }

    @Override // com.danlan.android.videogift.AlphaMovieView
    public /* bridge */ /* synthetic */ int getCurrentPosition() {
        return super.getCurrentPosition();
    }

    @Override // com.danlan.android.videogift.GLTextureView
    public /* bridge */ /* synthetic */ int getDebugFlags() {
        return super.getDebugFlags();
    }

    @Override // com.danlan.android.videogift.AlphaMovieView
    public /* bridge */ /* synthetic */ MediaPlayer getMediaPlayer() {
        return super.getMediaPlayer();
    }

    @Override // com.danlan.android.videogift.GLTextureView
    public /* bridge */ /* synthetic */ boolean getPreserveEGLContextOnPause() {
        return super.getPreserveEGLContextOnPause();
    }

    @Override // com.danlan.android.videogift.GLTextureView
    public /* bridge */ /* synthetic */ int getRenderMode() {
        return super.getRenderMode();
    }

    @Override // com.danlan.android.videogift.AlphaMovieView
    public /* bridge */ /* synthetic */ AlphaMovieView.PlayerState getState() {
        return super.getState();
    }

    public final void k() {
        setLooping(false);
        setOnVideoEndedListener(new a());
        setOnVideoErrorListener(new b());
        setOnVideoStartedListener(new c());
    }

    @Override // com.danlan.android.videogift.AlphaMovieView, com.danlan.android.videogift.GLTextureView
    public /* bridge */ /* synthetic */ void l() {
        super.l();
    }

    @Override // com.danlan.android.videogift.AlphaMovieView, com.danlan.android.videogift.GLTextureView
    public /* bridge */ /* synthetic */ void m() {
        super.m();
    }

    @Override // com.danlan.android.videogift.GLTextureView
    public /* bridge */ /* synthetic */ void o() {
        super.o();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onEventDestroy() {
        L();
        this.f19066z = Status.EMPTY;
        Lifecycle lifecycle = this.f19064x;
        if (lifecycle != null) {
            lifecycle.removeObserver(this);
            this.f19064x = null;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onEventPause() {
        l();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onEventResume() {
        m();
        if (D()) {
            O();
        }
    }

    @Override // com.danlan.android.videogift.GLTextureView, android.view.View.OnLayoutChangeListener
    public /* bridge */ /* synthetic */ void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        super.onLayoutChange(view, i10, i11, i12, i13, i14, i15, i16, i17);
    }

    @Override // com.danlan.android.videogift.GLTextureView, android.view.TextureView.SurfaceTextureListener
    public /* bridge */ /* synthetic */ void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
        super.onSurfaceTextureAvailable(surfaceTexture, i10, i11);
    }

    @Override // com.danlan.android.videogift.GLTextureView, android.view.TextureView.SurfaceTextureListener
    public /* bridge */ /* synthetic */ boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return super.onSurfaceTextureDestroyed(surfaceTexture);
    }

    @Override // com.danlan.android.videogift.GLTextureView, android.view.TextureView.SurfaceTextureListener
    public /* bridge */ /* synthetic */ void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
        super.onSurfaceTextureSizeChanged(surfaceTexture, i10, i11);
    }

    @Override // com.danlan.android.videogift.GLTextureView, android.view.TextureView.SurfaceTextureListener
    public /* bridge */ /* synthetic */ void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        super.onSurfaceTextureUpdated(surfaceTexture);
    }

    @Override // com.danlan.android.videogift.GLTextureView
    public /* bridge */ /* synthetic */ void p(SurfaceTexture surfaceTexture, int i10, int i11, int i12) {
        super.p(surfaceTexture, i10, i11, i12);
    }

    @Override // com.danlan.android.videogift.GLTextureView
    public /* bridge */ /* synthetic */ void q(SurfaceTexture surfaceTexture) {
        super.q(surfaceTexture);
    }

    @Override // com.danlan.android.videogift.GLTextureView
    public /* bridge */ /* synthetic */ void r(SurfaceTexture surfaceTexture) {
        super.r(surfaceTexture);
    }

    @Override // com.danlan.android.videogift.GLTextureView
    public /* bridge */ /* synthetic */ void setDebugFlags(int i10) {
        super.setDebugFlags(i10);
    }

    @Override // com.danlan.android.videogift.GLTextureView
    public /* bridge */ /* synthetic */ void setEGLConfigChooser(int i10, int i11, int i12, int i13, int i14, int i15) {
        super.setEGLConfigChooser(i10, i11, i12, i13, i14, i15);
    }

    @Override // com.danlan.android.videogift.GLTextureView
    public /* bridge */ /* synthetic */ void setEGLContextClientVersion(int i10) {
        super.setEGLContextClientVersion(i10);
    }

    @Override // com.danlan.android.videogift.GLTextureView
    public /* bridge */ /* synthetic */ void setEGLContextFactory(GLTextureView.g gVar) {
        super.setEGLContextFactory(gVar);
    }

    @Override // com.danlan.android.videogift.GLTextureView
    public /* bridge */ /* synthetic */ void setEGLWindowSurfaceFactory(GLTextureView.h hVar) {
        super.setEGLWindowSurfaceFactory(hVar);
    }

    @Override // com.danlan.android.videogift.GLTextureView
    public /* bridge */ /* synthetic */ void setGLWrapper(GLTextureView.l lVar) {
        super.setGLWrapper(lVar);
    }

    public void setLifecycle(Lifecycle lifecycle) {
        if (lifecycle != null) {
            this.f19064x = lifecycle;
            lifecycle.addObserver(this);
        }
    }

    @Override // com.danlan.android.videogift.AlphaMovieView
    public /* bridge */ /* synthetic */ void setLooping(boolean z10) {
        super.setLooping(z10);
    }

    @Override // com.danlan.android.videogift.AlphaMovieView
    public /* bridge */ /* synthetic */ void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        super.setOnErrorListener(onErrorListener);
    }

    @Override // com.danlan.android.videogift.AlphaMovieView
    public /* bridge */ /* synthetic */ void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        super.setOnSeekCompleteListener(onSeekCompleteListener);
    }

    @Override // com.danlan.android.videogift.AlphaMovieView
    public /* bridge */ /* synthetic */ void setOnVideoEndedListener(AlphaMovieView.g gVar) {
        super.setOnVideoEndedListener(gVar);
    }

    @Override // com.danlan.android.videogift.AlphaMovieView
    public /* bridge */ /* synthetic */ void setOnVideoErrorListener(AlphaMovieView.h hVar) {
        super.setOnVideoErrorListener(hVar);
    }

    @Override // com.danlan.android.videogift.AlphaMovieView
    public /* bridge */ /* synthetic */ void setOnVideoStartedListener(AlphaMovieView.i iVar) {
        super.setOnVideoStartedListener(iVar);
    }

    public void setOnVideoStateChangedListener(d dVar) {
        this.f19065y = dVar;
    }

    @Override // com.danlan.android.videogift.GLTextureView
    public /* bridge */ /* synthetic */ void setPreserveEGLContextOnPause(boolean z10) {
        super.setPreserveEGLContextOnPause(z10);
    }

    @Override // com.danlan.android.videogift.GLTextureView
    public /* bridge */ /* synthetic */ void setRenderMode(int i10) {
        super.setRenderMode(i10);
    }

    @Override // com.danlan.android.videogift.GLTextureView
    public /* bridge */ /* synthetic */ void setRenderer(GLTextureView.n nVar) {
        super.setRenderer(nVar);
    }

    @Override // com.danlan.android.videogift.AlphaMovieView
    public /* bridge */ /* synthetic */ void setScaleType(FitViewHelper.ScaleType scaleType) {
        super.setScaleType(scaleType);
    }

    @Override // com.danlan.android.videogift.AlphaMovieView
    public /* bridge */ /* synthetic */ void setScreenOnWhilePlaying(boolean z10) {
        super.setScreenOnWhilePlaying(z10);
    }

    @Override // com.danlan.android.videogift.AlphaMovieView
    public /* bridge */ /* synthetic */ void setVideoByUrl(String str) {
        super.setVideoByUrl(str);
    }

    @Override // com.danlan.android.videogift.AlphaMovieView
    public /* bridge */ /* synthetic */ void setVideoFromAssets(String str) {
        super.setVideoFromAssets(str);
    }

    @Override // com.danlan.android.videogift.AlphaMovieView
    public /* bridge */ /* synthetic */ void setVideoFromFile(FileDescriptor fileDescriptor) {
        super.setVideoFromFile(fileDescriptor);
    }

    @Override // com.danlan.android.videogift.AlphaMovieView
    public /* bridge */ /* synthetic */ void setVideoFromMediaDataSource(MediaDataSource mediaDataSource) {
        super.setVideoFromMediaDataSource(mediaDataSource);
    }

    @Override // com.danlan.android.videogift.AlphaMovieView
    public /* bridge */ /* synthetic */ void setVideoFromUri(Context context, Uri uri) {
        super.setVideoFromUri(context, uri);
    }

    @Override // com.danlan.android.videogift.GLTextureView
    public /* bridge */ /* synthetic */ void setEGLConfigChooser(GLTextureView.f fVar) {
        super.setEGLConfigChooser(fVar);
    }

    @Override // com.danlan.android.videogift.AlphaMovieView
    public /* bridge */ /* synthetic */ void setVideoFromFile(FileDescriptor fileDescriptor, int i10, int i11) {
        super.setVideoFromFile(fileDescriptor, i10, i11);
    }

    @Override // com.danlan.android.videogift.GLTextureView
    public /* bridge */ /* synthetic */ void setEGLConfigChooser(boolean z10) {
        super.setEGLConfigChooser(z10);
    }
}
