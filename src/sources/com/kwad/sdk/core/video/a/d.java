package com.kwad.sdk.core.video.a;

import android.content.Context;
import android.media.MediaDataSource;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import com.kwad.sdk.n.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.video.ksvodplayerkit.IKSVodPlayer;
import com.kwai.video.ksvodplayerkit.KSVodConstants;
import com.kwai.video.ksvodplayerkit.KSVodPlayerWrapper;
import com.kwai.video.ksvodplayerkit.KSVodVideoContext;
import com.kwai.video.player.IKwaiMediaPlayer;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d extends com.kwad.sdk.core.video.a.a {
    private static volatile boolean aBm;
    private static final Queue<d> aBn = new ConcurrentLinkedQueue();
    private final String TAG;
    private com.kwad.sdk.contentalliance.a.a.b TS;
    private String aBd;
    private MediaDataSource aBe;
    private final Object aBf;
    private boolean aBg;
    private final KSVodPlayerWrapper aBi;
    private final a aBj;
    private boolean aBk;
    private boolean aBl;
    private boolean aBo;
    private int mSarDen;
    private int mSarNum;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a implements IKSVodPlayer.OnBufferingUpdateListener, IKSVodPlayer.OnErrorListener, IKSVodPlayer.OnEventListener, IKSVodPlayer.OnPreparedListener, IKSVodPlayer.OnVideoSizeChangedListener, IKSVodPlayer.OnVodPlayerReleaseListener {
        public final String TAG;
        public final WeakReference<d> mWeakMediaPlayer;

        public a(d dVar, String str) {
            this.mWeakMediaPlayer = new WeakReference<>(dVar);
            this.TAG = str;
        }

        private d Ge() {
            return this.mWeakMediaPlayer.get();
        }

        public final void onBufferingUpdate(int i10) {
            d Ge = Ge();
            if (Ge != null) {
                Ge.notifyOnBufferingUpdate(i10);
            }
        }

        public final void onError(int i10, int i11) {
            d Ge = Ge();
            if (Ge != null) {
                d.a(Ge, false);
                Ge.notifyOnError(i10, i11);
            }
        }

        public final void onEvent(@KSVodConstants.KSVodPlayerEventType int i10, int i11) {
            com.kwad.sdk.core.e.c.i(this.TAG, "onEvent, what: " + i10);
            try {
                d Ge = Ge();
                if (Ge != null) {
                    if (i10 == 10100) {
                        Ge.notifyOnSeekComplete();
                    } else {
                        if (i10 == 10101) {
                            Ge.notifyOnCompletion();
                            return;
                        }
                        if (i10 == 10209) {
                            Ge.Gd();
                        }
                        Ge.notifyOnInfo(i10, i11);
                    }
                }
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }

        public final void onPlayerRelease() {
            com.kwad.sdk.core.e.c.i(this.TAG, "onPlayerRelease");
        }

        public final void onPrepared() {
            com.kwad.sdk.core.e.c.i(this.TAG, "onPrepared");
            d Ge = Ge();
            if (Ge != null) {
                Ge.notifyOnPrepared();
            }
        }

        public final void onVideoSizeChanged(int i10, int i11, int i12, int i13) {
            com.kwad.sdk.core.e.c.i(this.TAG, "onVideoSizeChanged width: " + i10 + ", height: " + i11 + ", sarNum:" + i12 + ", sarDen:" + i13);
            d Ge = Ge();
            if (Ge != null) {
                Ge.w(i10, i11);
                Ge.mSarNum = i12;
                Ge.mSarDen = i13;
            }
        }
    }

    public d(int i10) {
        Object obj = new Object();
        this.aBf = obj;
        this.aBl = false;
        this.aBo = true;
        synchronized (obj) {
            this.aBi = new KSVodPlayerWrapper(l.Ob());
        }
        String str = "KSMediaPlayer[" + i10 + "]";
        this.TAG = str;
        this.aBj = new a(this, str);
        Ga();
        setLooping(false);
        com.kwad.sdk.core.e.c.i(str, "create KwaiMediaPlayer");
    }

    private void FY() {
        MediaDataSource mediaDataSource = this.aBe;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.aBe = null;
        }
    }

    private void Ga() {
        this.aBi.setOnPreparedListener(this.aBj);
        this.aBi.setBufferingUpdateListener(this.aBj);
        this.aBi.setOnEventListener(this.aBj);
        this.aBi.setVideoSizeChangedListener(this.aBj);
        this.aBi.setOnErrorListener(this.aBj);
    }

    private void Gb() {
        this.aBi.setOnPreparedListener((IKSVodPlayer.OnPreparedListener) null);
        this.aBi.setBufferingUpdateListener((IKSVodPlayer.OnBufferingUpdateListener) null);
        this.aBi.setOnEventListener((IKSVodPlayer.OnEventListener) null);
        this.aBi.setVideoSizeChangedListener((IKSVodPlayer.OnVideoSizeChangedListener) null);
        this.aBi.setOnErrorListener((IKSVodPlayer.OnErrorListener) null);
    }

    private void Gc() {
        com.kwad.sdk.core.e.c.i(this.TAG, "realPrepare hasCallPrepare: " + this.aBl);
        if (this.aBl) {
            return;
        }
        try {
            this.aBl = true;
            int prepareAsync = this.aBi.prepareAsync();
            FX();
            com.kwad.sdk.core.e.c.i(this.TAG, "realPrepare result: " + prepareAsync);
        } catch (IllegalStateException e2) {
            com.kwad.sdk.core.e.c.e(this.TAG, "realPrepare failed ", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gd() {
        Iterator<d> it = aBn.iterator2();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = 0;
                break;
            } else if (it.next() == this) {
                break;
            } else {
                i10++;
            }
        }
        com.kwad.sdk.core.e.c.i(this.TAG, "preloadNextPlayer next player index: " + i10);
        int i11 = i10 + 1;
        if (i11 < aBn.size()) {
            com.kwad.sdk.core.e.c.i(this.TAG, "----------------preloadNextPlayer prepare next player----------------");
            for (int i12 = 0; i12 < i11; i12++) {
                aBn.poll();
            }
            Queue<d> queue = aBn;
            d poll = queue.poll();
            queue.clear();
            if (poll != null) {
                poll.prepareAsync();
            } else {
                com.kwad.sdk.core.e.c.i(this.TAG, "----------------preloadNextPlayer prepareAsync next player is null----------------");
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean FZ() {
        com.kwad.sdk.core.e.c.i(this.TAG, "forcePrepareAsync");
        Gc();
        return true;
    }

    public final void bn(boolean z10) {
        this.aBo = z10;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getAudioSessionId() {
        return this.aBi.getKwaiMediaPlayer().getAudioSessionId();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final String getCurrentPlayingUrl() {
        KSVodPlayerWrapper kSVodPlayerWrapper = this.aBi;
        return kSVodPlayerWrapper == null ? "" : kSVodPlayerWrapper.getCurrentPlayUrl();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getCurrentPosition() {
        try {
            return this.aBi.getCurrentPosition();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final String getDataSource() {
        return this.aBd;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getDuration() {
        try {
            return this.aBi.getDuration();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getMediaPlayerType() {
        return 2;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoHeight() {
        return this.aBi.getKwaiMediaPlayer().getVideoHeight();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoWidth() {
        return this.aBi.getKwaiMediaPlayer().getVideoWidth();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isLooping() {
        return this.aBk;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isPlaying() {
        try {
            return this.aBi.isPlaying();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void pause() {
        this.aBi.pause();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean prepareAsync() {
        if (this.aBo) {
            Queue<d> queue = aBn;
            if (!queue.contains(this)) {
                queue.offer(this);
            }
            int size = queue.size();
            if (size == 1) {
                com.kwad.sdk.core.e.c.i(this.TAG, "prepareAsync first");
                Gc();
                return true;
            }
            com.kwad.sdk.core.e.c.i(this.TAG, "prepareAsync pending size: " + size);
            return false;
        }
        Gc();
        return true;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void release() {
        Queue<d> queue = aBn;
        boolean remove = queue.remove(this);
        com.kwad.sdk.core.e.c.i(this.TAG, "release remote player ret: " + remove + ", player list size: " + queue.size());
        this.aBg = true;
        this.aBi.releaseAsync(new IKSVodPlayer.OnVodPlayerReleaseListener() { // from class: com.kwad.sdk.core.video.a.d.1
            public final void onPlayerRelease() {
                com.kwad.sdk.core.e.c.i(d.this.TAG, "onPlayerRelease");
            }
        });
        try {
            FY();
            resetListeners();
            Gb();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void reset() {
        this.aBl = false;
        try {
            IKwaiMediaPlayer kwaiMediaPlayer = this.aBi.getKwaiMediaPlayer();
            if (kwaiMediaPlayer != null) {
                kwaiMediaPlayer.reset();
            }
        } catch (IllegalStateException unused) {
        }
        FY();
        resetListeners();
        Ga();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void seekTo(long j10) {
        this.aBi.seekTo((int) j10);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setAudioStreamType(int i10) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(Context context, Uri uri) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(Context context, Uri uri, Map<String, String> map) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(FileDescriptor fileDescriptor) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(String str) {
        setDataSource(str, (Map<String, String>) null);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDisplay(SurfaceHolder surfaceHolder) {
        synchronized (this.aBf) {
            if (!this.aBg) {
                this.aBi.setDisplay(surfaceHolder);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setLooping(boolean z10) {
        this.aBk = z10;
        this.aBi.setLooping(z10);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setScreenOnWhilePlaying(boolean z10) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setSpeed(float f10) {
        this.aBi.setSpeed(f10);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setSurface(Surface surface) {
        this.aBi.setSurface(surface);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setVolume(float f10, float f11) {
        this.aBi.setVolume(f10, f11);
        com.kwad.sdk.core.video.a.a.f(f10);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void start() {
        com.kwad.sdk.core.e.c.i(this.TAG, "start");
        this.aBi.start();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void stop() {
        this.aBi.stop();
    }

    private void setDataSource(String str, Map<String, String> map) {
        this.aBd = str;
        this.aBi.setDataSource(str, (Map) null);
    }

    public static /* synthetic */ boolean a(d dVar, boolean z10) {
        dVar.aBl = false;
        return false;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar) {
        this.TS = bVar;
        a(bVar.aoR);
        f fVar = (f) ServiceProvider.get(f.class);
        if (!TextUtils.isEmpty(bVar.manifest) && fVar != null && fVar.tB()) {
            setDataSource(bVar.manifest, (Map<String, String>) null);
        } else {
            setDataSource(bVar.videoUrl, (Map<String, String>) null);
        }
    }

    public final void a(com.kwad.sdk.contentalliance.a.a.a aVar) {
        if (this.aBi == null || aVar == null) {
            return;
        }
        KSVodVideoContext kSVodVideoContext = new KSVodVideoContext();
        kSVodVideoContext.mVideoId = String.valueOf(aVar.photoId);
        kSVodVideoContext.mClickTime = aVar.clickTime;
        kSVodVideoContext.mExtra = aVar.Ba();
        this.aBi.updateVideoContext(kSVodVideoContext);
    }
}
