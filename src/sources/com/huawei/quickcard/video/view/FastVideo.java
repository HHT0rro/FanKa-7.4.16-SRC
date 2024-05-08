package com.huawei.quickcard.video.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.video.ITextureVideoView;
import com.huawei.quickcard.video.view.MediaControllerView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class FastVideo implements MediaControllerView.FastMediaController, ITextureVideoView.VideoSurfaceTextureListener, ITextureVideoView.VideoStateListener, ITextureVideoView.AudioFocusListener {

    /* renamed from: t, reason: collision with root package name */
    private static final String f34371t = "FastVideoView";

    /* renamed from: u, reason: collision with root package name */
    private static final int f34372u = 0;

    /* renamed from: v, reason: collision with root package name */
    private static final int f34373v = 250;

    /* renamed from: w, reason: collision with root package name */
    private static final int f34374w = 1;

    /* renamed from: x, reason: collision with root package name */
    private static final int f34375x = 5;

    /* renamed from: a, reason: collision with root package name */
    private boolean f34376a = false;

    /* renamed from: b, reason: collision with root package name */
    private String f34377b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f34378c;

    /* renamed from: d, reason: collision with root package name */
    private ITextureVideoView f34379d;

    /* renamed from: e, reason: collision with root package name */
    private final Context f34380e;

    /* renamed from: f, reason: collision with root package name */
    private Handler f34381f;

    /* renamed from: g, reason: collision with root package name */
    private int f34382g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f34383h;

    /* renamed from: i, reason: collision with root package name */
    private OnFastVideoTimeUpdateListener f34384i;

    /* renamed from: j, reason: collision with root package name */
    private FastVideoStateListener f34385j;

    /* renamed from: k, reason: collision with root package name */
    private FastVideoSurfaceListener f34386k;

    /* renamed from: l, reason: collision with root package name */
    private FastVideoAutoStartListener f34387l;

    /* renamed from: m, reason: collision with root package name */
    private int f34388m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f34389n;

    /* renamed from: o, reason: collision with root package name */
    private int f34390o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f34391p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f34392q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f34393r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f34394s;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface FastVideoAutoStartListener {
        boolean onAutoStart();

        boolean stopForAutoStopLength();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface FastVideoStateListener {
        void onBufferingEnd();

        void onBufferingStart();

        void onCompletion();

        void onError(int i10, int i11);

        void onIdle();

        void onPause();

        void onPlaying();

        void onPrepared();

        void onPreparing();

        void onStart();

        void onVideoRenderingStart();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface FastVideoSurfaceListener {
        void onSurfaceTextureAvailable();

        void onSurfaceTextureDestroyed();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface OnFastVideoTimeUpdateListener {
        void onTimeUpdate();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (FastVideo.this.f34384i != null) {
                FastVideo.this.f34384i.onTimeUpdate();
            }
            removeMessages(0);
            if (FastVideo.this.f34379d.getCurrentState() == 3) {
                sendMessageDelayed(obtainMessage(0), 250L);
            }
        }
    }

    public FastVideo(Context context) {
        this.f34380e = context;
        f();
    }

    private boolean a(Context context) {
        return false;
    }

    private void f() {
        this.f34382g = 0;
        this.f34388m = -1;
        this.f34390o = -1;
        this.f34378c = false;
        this.f34394s = false;
        com.huawei.quickcard.video.c cVar = new com.huawei.quickcard.video.c(this.f34380e);
        this.f34379d = cVar;
        cVar.setVideoSurfaceTextureListener(this);
        this.f34379d.setVideoStateListener(this);
        this.f34379d.setAudioFocusListener(this);
        this.f34381f = new a();
    }

    private void i() {
        this.f34389n = false;
        this.f34388m = -1;
        this.f34390o = -1;
    }

    private void k() {
        int currentPosition = this.f34379d.getCurrentPosition();
        if (currentPosition > 0) {
            this.f34388m = currentPosition;
        }
    }

    private void l() {
        String str = this.f34377b;
        if (str != null) {
            if (str.equals(this.f34379d.getVideoURI())) {
                if (this.f34379d.getCurrentState() == -1 || this.f34379d.getCurrentState() == 0) {
                    j();
                    return;
                }
                return;
            }
            if (!this.f34391p) {
                this.f34379d.openVideoURI(this.f34377b);
            } else {
                this.f34379d.setVideoURI(this.f34377b);
            }
            if (this.f34379d.getCurrentState() == 0) {
                this.f34389n = true;
            }
        }
    }

    public void c(boolean z10) {
        this.f34379d.setMuted(z10);
        this.f34376a = z10;
    }

    @Override // com.huawei.quickcard.video.view.MediaControllerView.FastMediaController
    public boolean canPause() {
        return this.f34379d.canPause();
    }

    @Override // com.huawei.quickcard.video.view.MediaControllerView.FastMediaController
    public boolean canSeekBackward() {
        return this.f34379d.canSeekBackward();
    }

    @Override // com.huawei.quickcard.video.view.MediaControllerView.FastMediaController
    public boolean canSeekForward() {
        return this.f34379d.canSeekForward();
    }

    public boolean d() {
        return this.f34376a;
    }

    public View e() {
        Object obj = this.f34379d;
        if (obj instanceof View) {
            return (View) obj;
        }
        return new View(this.f34380e);
    }

    public void g() {
        if (this.f34391p) {
            return;
        }
        this.f34391p = true;
        if (this.f34379d.isPlaying() || this.f34379d.getCurrentState() == -1) {
            this.f34392q = true;
            this.f34389n = true;
            this.f34390o = getCurrentPosition();
            this.f34388m = getCurrentPosition();
            if (this.f34379d.getCurrentState() == -1) {
                this.f34379d.suspend();
            }
        }
        pause();
    }

    @Override // com.huawei.quickcard.video.view.MediaControllerView.FastMediaController
    public int getBufferPercentage() {
        return this.f34379d.getBufferPercentage();
    }

    @Override // com.huawei.quickcard.video.view.MediaControllerView.FastMediaController
    public int getCurrentPosition() {
        return this.f34379d.getCurrentPosition();
    }

    @Override // com.huawei.quickcard.video.view.MediaControllerView.FastMediaController
    public int getDuration() {
        return this.f34379d.getDuration();
    }

    public void h() {
        FastVideoAutoStartListener fastVideoAutoStartListener;
        if (this.f34391p) {
            this.f34391p = false;
            if (this.f34389n && this.f34392q && !this.f34393r && (this.f34379d.getCurrentState() != 0 || (fastVideoAutoStartListener = this.f34387l) == null || fastVideoAutoStartListener.onAutoStart())) {
                start();
            }
            this.f34392q = false;
        }
    }

    @Override // com.huawei.quickcard.video.view.MediaControllerView.FastMediaController
    public boolean isPaused() {
        return this.f34379d.getCurrentState() == 4;
    }

    @Override // com.huawei.quickcard.video.view.MediaControllerView.FastMediaController
    public boolean isPlaying() {
        return this.f34379d.isPlaying();
    }

    @Override // com.huawei.quickcard.video.view.MediaControllerView.FastMediaController
    public boolean isPreparing() {
        return this.f34379d.getCurrentState() == 1;
    }

    public void j() {
        if (this.f34383h) {
            return;
        }
        this.f34379d.resume();
    }

    public void m() {
        this.f34379d.stopPlayback();
    }

    public void n() {
        this.f34379d.suspend();
    }

    @Override // com.huawei.quickcard.video.ITextureVideoView.AudioFocusListener
    public void onAudioFocusChange(int i10) {
        if (i10 != -2 && i10 != -1) {
            if (i10 == 1 && this.f34389n && c() == 4 && !this.f34391p) {
                start();
                return;
            }
            return;
        }
        if (this.f34394s) {
            return;
        }
        int c4 = c();
        if (c4 == 2 || c4 == 3) {
            this.f34389n = true;
            pause();
        } else if (c4 == 1) {
            this.f34379d.suspend();
        } else {
            CardLogUtils.i("other state");
        }
    }

    @Override // com.huawei.quickcard.video.ITextureVideoView.VideoStateListener
    public void onCompletion() {
        FastVideoStateListener fastVideoStateListener = this.f34385j;
        if (fastVideoStateListener != null) {
            fastVideoStateListener.onCompletion();
        }
        if (this.f34384i != null) {
            this.f34381f.removeMessages(0);
        }
    }

    @Override // com.huawei.quickcard.video.ITextureVideoView.VideoStateListener
    public boolean onError(int i10, int i11) {
        int i12;
        if (this.f34384i != null) {
            this.f34381f.removeMessages(0);
        }
        if (i11 == -1004 && a(this.f34380e) && (i12 = this.f34382g) < 1) {
            this.f34382g = i12 + 1;
            k();
            start();
        } else {
            FastVideoStateListener fastVideoStateListener = this.f34385j;
            if (fastVideoStateListener != null) {
                fastVideoStateListener.onError(i10, i11);
            }
            k();
        }
        return true;
    }

    @Override // com.huawei.quickcard.video.ITextureVideoView.VideoStateListener
    public void onIdle() {
        FastVideoStateListener fastVideoStateListener = this.f34385j;
        if (fastVideoStateListener != null) {
            fastVideoStateListener.onIdle();
        }
        if (this.f34384i != null) {
            this.f34381f.removeMessages(0);
        }
    }

    @Override // com.huawei.quickcard.video.ITextureVideoView.VideoStateListener
    public void onInfo(int i10) {
        if (i10 == 3) {
            FastVideoStateListener fastVideoStateListener = this.f34385j;
            if (fastVideoStateListener != null) {
                fastVideoStateListener.onVideoRenderingStart();
                return;
            }
            return;
        }
        if (i10 == 701) {
            if (this.f34384i != null) {
                this.f34381f.removeMessages(0);
            }
            FastVideoStateListener fastVideoStateListener2 = this.f34385j;
            if (fastVideoStateListener2 != null) {
                fastVideoStateListener2.onBufferingStart();
                return;
            }
            return;
        }
        if (i10 != 702) {
            return;
        }
        if (this.f34384i != null) {
            this.f34381f.sendEmptyMessage(0);
        }
        FastVideoStateListener fastVideoStateListener3 = this.f34385j;
        if (fastVideoStateListener3 != null) {
            fastVideoStateListener3.onBufferingEnd();
        }
    }

    @Override // com.huawei.quickcard.video.ITextureVideoView.VideoStateListener
    public void onPause() {
        FastVideoStateListener fastVideoStateListener = this.f34385j;
        if (fastVideoStateListener != null) {
            fastVideoStateListener.onPause();
        }
        k();
        if (this.f34384i != null) {
            this.f34381f.removeMessages(0);
        }
    }

    @Override // com.huawei.quickcard.video.ITextureVideoView.VideoStateListener
    public void onPlaying() {
        FastVideoStateListener fastVideoStateListener = this.f34385j;
        if (fastVideoStateListener != null) {
            fastVideoStateListener.onPlaying();
        }
        this.f34389n = false;
        if (this.f34384i != null) {
            this.f34381f.sendEmptyMessage(0);
        }
        this.f34382g = 0;
    }

    @Override // com.huawei.quickcard.video.ITextureVideoView.VideoStateListener
    public void onPrepared() {
        Object obj = this.f34379d;
        if (obj instanceof View) {
            if (ViewCompat.isAttachedToWindow((View) obj)) {
                int i10 = this.f34388m;
                if (i10 > -1) {
                    seekTo(i10);
                    i();
                    start();
                } else if (this.f34378c) {
                    FastVideoAutoStartListener fastVideoAutoStartListener = this.f34387l;
                    if (fastVideoAutoStartListener == null || fastVideoAutoStartListener.onAutoStart()) {
                        int i11 = this.f34390o;
                        if (i11 > 5) {
                            this.f34379d.seekTo(i11);
                        }
                        start();
                    }
                } else {
                    CardLogUtils.i("video prepared and do nothing");
                }
            }
            FastVideoStateListener fastVideoStateListener = this.f34385j;
            if (fastVideoStateListener != null) {
                fastVideoStateListener.onPrepared();
            }
        }
    }

    @Override // com.huawei.quickcard.video.ITextureVideoView.VideoStateListener
    public void onPreparing() {
        c(this.f34376a);
        FastVideoStateListener fastVideoStateListener = this.f34385j;
        if (fastVideoStateListener != null) {
            fastVideoStateListener.onPreparing();
        }
    }

    @Override // com.huawei.quickcard.video.ITextureVideoView.VideoSurfaceTextureListener
    public void onVideoSurfaceTextureAvailable() {
        if (this.f34389n && !this.f34391p) {
            if (!this.f34393r) {
                FastVideoAutoStartListener fastVideoAutoStartListener = this.f34387l;
                if (fastVideoAutoStartListener != null && fastVideoAutoStartListener.stopForAutoStopLength()) {
                    setUserPaused(false);
                }
                start();
            }
            this.f34389n = false;
        }
        FastVideoSurfaceListener fastVideoSurfaceListener = this.f34386k;
        if (fastVideoSurfaceListener != null) {
            fastVideoSurfaceListener.onSurfaceTextureAvailable();
        }
    }

    @Override // com.huawei.quickcard.video.ITextureVideoView.VideoSurfaceTextureListener
    public void onVideoSurfaceTextureDestroyed() {
        FastVideoAutoStartListener fastVideoAutoStartListener;
        if (!this.f34379d.isPlaying() && this.f34379d.getCurrentState() != 1 && ((fastVideoAutoStartListener = this.f34387l) == null || !fastVideoAutoStartListener.stopForAutoStopLength())) {
            this.f34389n = false;
        } else {
            this.f34389n = true;
            k();
            if (this.f34379d.getCurrentState() == 1) {
                n();
            } else if (this.f34379d.isPlaying()) {
                pause();
            }
        }
        FastVideoSurfaceListener fastVideoSurfaceListener = this.f34386k;
        if (fastVideoSurfaceListener != null) {
            fastVideoSurfaceListener.onSurfaceTextureDestroyed();
        }
    }

    @Override // com.huawei.quickcard.video.view.MediaControllerView.FastMediaController
    public void pause() {
        this.f34379d.pause();
    }

    @Override // com.huawei.quickcard.video.view.MediaControllerView.FastMediaController
    public void seekTo(int i10) {
        this.f34379d.seekTo(i10);
    }

    @Override // com.huawei.quickcard.video.view.MediaControllerView.FastMediaController
    public void setUserPaused(boolean z10) {
        this.f34383h = z10;
    }

    @Override // com.huawei.quickcard.video.view.MediaControllerView.FastMediaController
    public void start() {
        FastVideoStateListener fastVideoStateListener;
        FastVideoAutoStartListener fastVideoAutoStartListener;
        if (this.f34383h) {
            return;
        }
        if ((this.f34379d.getTargetState() != 3 || ((fastVideoAutoStartListener = this.f34387l) != null && fastVideoAutoStartListener.stopForAutoStopLength())) && (fastVideoStateListener = this.f34385j) != null) {
            fastVideoStateListener.onStart();
        }
        l();
        this.f34379d.start();
    }

    public boolean a() {
        return this.f34379d.canSeek();
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(this.f34377b)) {
                return;
            }
            i();
            this.f34379d.stopPlayback();
            this.f34379d.setVideoURI(null);
            this.f34377b = null;
            return;
        }
        if (str.equals(this.f34377b)) {
            return;
        }
        this.f34377b = str;
        i();
        if (this.f34378c) {
            FastVideoAutoStartListener fastVideoAutoStartListener = this.f34387l;
            if (fastVideoAutoStartListener == null || fastVideoAutoStartListener.onAutoStart()) {
                l();
                return;
            }
            return;
        }
        if (isPlaying()) {
            this.f34379d.pause();
            i();
            this.f34379d.openVideoURI(str);
            this.f34379d.start();
            return;
        }
        if (isPreparing()) {
            this.f34379d.suspend();
            this.f34379d.openVideoURI(str);
            this.f34379d.start();
        }
    }

    public void d(boolean z10) {
        this.f34378c = z10;
        if (z10) {
            FastVideoAutoStartListener fastVideoAutoStartListener = this.f34387l;
            if (fastVideoAutoStartListener == null || fastVideoAutoStartListener.onAutoStart()) {
                l();
            }
        }
    }

    public void a(OnFastVideoTimeUpdateListener onFastVideoTimeUpdateListener) {
        this.f34384i = onFastVideoTimeUpdateListener;
    }

    public int c() {
        return this.f34379d.getCurrentState();
    }

    public void a(FastVideoStateListener fastVideoStateListener) {
        this.f34385j = fastVideoStateListener;
    }

    public void e(boolean z10) {
        this.f34379d.setShouldReleaseSurface(z10);
    }

    public void a(FastVideoSurfaceListener fastVideoSurfaceListener) {
        this.f34386k = fastVideoSurfaceListener;
    }

    public void a(FastVideoAutoStartListener fastVideoAutoStartListener) {
        this.f34387l = fastVideoAutoStartListener;
    }

    public void a(int i10) {
        this.f34379d.seekTo(i10);
    }

    public void a(String str) {
        this.f34379d.setObjectFitType(str);
    }

    public void a(boolean z10) {
        this.f34393r = z10;
    }

    public void b() {
        this.f34391p = true;
        this.f34379d.destroy();
        i();
    }

    public void b(boolean z10) {
        this.f34394s = z10;
    }
}
