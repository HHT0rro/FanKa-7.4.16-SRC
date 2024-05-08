package com.kwad.components.core.video;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b {
    private static boolean TL;
    private static final AtomicInteger TM = new AtomicInteger(0);
    private final String TAG;
    private volatile int TN;
    private com.kwad.sdk.core.video.a.c TO;
    private int TP;
    private long TQ;
    private Runnable TR;
    private com.kwad.sdk.contentalliance.a.a.b TS;
    private int TT;
    private List<c.d> TU;
    private final AtomicBoolean TV;
    private boolean TW;
    private final int TX;
    private volatile List<k> TY;
    private volatile List<com.kwad.components.core.video.a.c> TZ;
    private int Tv;
    private int Tw;
    private volatile List<c.e> Ua;
    private final c.f Ub;
    private c.e Uc;
    private c.i Ud;
    private c.b Ue;
    private c.InterfaceC0530c Uf;
    private c.d Ug;
    private c.a Uh;
    private Handler fS;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private DetailVideoView mDetailVideoView;
    private long mStartTime;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        @WorkerThread
        void onReleaseSuccess();
    }

    public b(@Nullable DetailVideoView detailVideoView) {
        this(detailVideoView, 0);
    }

    private void aM(int i10) {
        for (com.kwad.components.core.video.a.c cVar : this.TZ) {
            if (i10 == 0) {
                cVar.onStart();
            } else if (i10 == 1) {
                cVar.onReset();
            } else if (i10 == 2) {
                try {
                    cVar.onRelease();
                } catch (Exception e2) {
                    com.kwad.sdk.core.e.c.printStackTrace(e2);
                }
            }
        }
    }

    private void aP(final boolean z10) {
        if (this.TO == null) {
            return;
        }
        com.kwad.sdk.core.e.c.i(this.TAG, "start prepareAsync");
        if (this.TW) {
            if (this.TV.compareAndSet(false, true)) {
                com.kwad.sdk.utils.g.execute(new ay() { // from class: com.kwad.components.core.video.b.10
                    @Override // com.kwad.sdk.utils.ay
                    public final void doTask() {
                        com.kwad.sdk.core.e.c.i(b.this.TAG, "prepareAsync now:" + b.getStateString(b.this.TN));
                        if (b.this.TO == null) {
                            return;
                        }
                        try {
                            synchronized (b.this.TO) {
                                b.this.aQ(z10);
                            }
                        } finally {
                            try {
                            } finally {
                            }
                        }
                        try {
                            synchronized (b.this.TV) {
                                b.this.TV.notifyAll();
                            }
                        } catch (Exception e2) {
                            com.kwad.sdk.core.e.c.printStackTrace(e2);
                        }
                    }
                });
                return;
            }
            return;
        }
        try {
            aQ(z10);
        } catch (Throwable th) {
            if (getMediaPlayerType() != 2) {
                int i10 = this.TT;
                this.TT = i10 + 1;
                if (i10 <= 4) {
                    rv();
                }
            }
            com.kwad.sdk.core.e.c.i(this.TAG, "prepareAsync Exception:" + getStateString(this.TN));
            com.kwad.sdk.core.e.c.printStackTrace(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQ(boolean z10) {
        boolean prepareAsync;
        a(this.TS);
        if (z10) {
            prepareAsync = this.TO.FZ();
        } else {
            prepareAsync = this.TO.prepareAsync();
        }
        com.kwad.sdk.core.e.c.i(this.TAG, "prepareAsync forcePrepare: " + z10 + ", result: " + prepareAsync);
    }

    public static String getStateString(int i10) {
        switch (i10) {
            case -1:
                return "STATE_ERROR";
            case 0:
                return "STATE_IDLE";
            case 1:
                return "STATE_PREPARING";
            case 2:
                return "STATE_PREPARED";
            case 3:
                return "STATE_STARTED";
            case 4:
                return "STATE_PLAYING";
            case 5:
                return "STATE_PAUSED";
            case 6:
                return "STATE_BUFFERING_PLAYING";
            case 7:
                return "STATE_BUFFERING_PAUSED";
            case 8:
                return "PLAYER_STATE_STOPPED";
            case 9:
                return "STATE_COMPLETED";
            default:
                return "STATE_UNKNOWN";
        }
    }

    private void reset() {
        com.kwad.sdk.core.e.c.i(this.TAG, "reset:" + getStateString(this.TN) + "->STATE_IDLE");
        aM(1);
        this.TO.reset();
        this.TN = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rq() {
        long currentPosition = getCurrentPosition();
        long duration = getDuration();
        if (this.TY != null) {
            Iterator<k> iterator2 = this.TY.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().onMediaPlayProgress(duration, currentPosition);
            }
        }
    }

    private void rt() {
        this.TO.a(this.Ub);
        this.TO.b(this.Uc);
        this.TO.a(this.Ud);
        this.TO.a(this.Ue);
        this.TO.a(this.Uf);
        this.TO.c(this.Ug);
        this.TO.a(this.Uh);
    }

    private void ru() {
        com.kwad.sdk.core.video.a.c cVar = this.TO;
        if (cVar == null) {
            return;
        }
        cVar.a((c.InterfaceC0530c) null);
        this.TO.a((c.b) null);
        this.TO.b(null);
        this.TO.a((c.i) null);
        this.TO.c(null);
        this.TO.a((c.g) null);
        this.TO.a((c.a) null);
    }

    private void rw() {
        rx();
        if (this.TR == null) {
            this.TR = new ay() { // from class: com.kwad.components.core.video.b.3
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    b.this.rq();
                    if (b.this.TR != null) {
                        b.this.fS.postDelayed(b.this.TR, 500L);
                    }
                }
            };
        }
        this.fS.post(this.TR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rx() {
        Runnable runnable = this.TR;
        if (runnable != null) {
            this.fS.removeCallbacks(runnable);
            this.TR = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeepScreenOn(boolean z10) {
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            detailVideoView.setKeepScreenOn(z10);
        }
    }

    private void setPlayType(int i10) {
        VideoPlayerStatus videoPlayerStatus;
        com.kwad.sdk.contentalliance.a.a.b bVar = this.TS;
        if (bVar == null || (videoPlayerStatus = bVar.videoPlayerStatus) == null) {
            return;
        }
        videoPlayerStatus.mVideoPlayerType = i10;
    }

    public final void clear() {
        this.TY.clear();
        this.TZ.clear();
    }

    public final int getBufferPercentage() {
        return this.TP;
    }

    public final String getCurrentPlayingUrl() {
        com.kwad.sdk.core.video.a.c cVar = this.TO;
        return cVar == null ? "" : cVar.getCurrentPlayingUrl();
    }

    public final long getCurrentPosition() {
        com.kwad.sdk.core.video.a.c cVar = this.TO;
        if (cVar != null) {
            return cVar.getCurrentPosition();
        }
        return 0L;
    }

    public final long getDuration() {
        com.kwad.sdk.core.video.a.c cVar = this.TO;
        if (cVar != null) {
            return cVar.getDuration();
        }
        return 0L;
    }

    public final int getMediaPlayerType() {
        com.kwad.sdk.core.video.a.c cVar = this.TO;
        if (cVar != null) {
            return cVar.getMediaPlayerType();
        }
        return 0;
    }

    public final long getPlayDuration() {
        com.kwad.sdk.core.video.a.c cVar = this.TO;
        if (cVar != null) {
            return cVar.getCurrentPosition();
        }
        return 0L;
    }

    public final int getVideoHeight() {
        com.kwad.sdk.core.video.a.c cVar = this.TO;
        if (cVar != null) {
            return cVar.getVideoHeight();
        }
        return 0;
    }

    public final int getVideoWidth() {
        com.kwad.sdk.core.video.a.c cVar = this.TO;
        if (cVar != null) {
            return cVar.getVideoWidth();
        }
        return 0;
    }

    public final boolean isPlaying() {
        com.kwad.sdk.core.video.a.c cVar = this.TO;
        if (cVar != null) {
            return cVar.isPlaying();
        }
        return false;
    }

    @Deprecated
    public final boolean isPrepared() {
        return this.TN == 2 || this.TN == 3 || this.TN == 5 || this.TN == 8 || this.TN == 9;
    }

    @Deprecated
    public final boolean isPreparing() {
        return this.TN == 1;
    }

    public final void onPlayStateChanged(final int i10) {
        if (this.TY == null) {
            return;
        }
        bn.runOnUiThread(new ay() { // from class: com.kwad.components.core.video.b.2
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                for (k kVar : b.this.TY) {
                    switch (i10) {
                        case -1:
                            b.this.setKeepScreenOn(false);
                            b.this.rx();
                            kVar.onMediaPlayError(b.this.Tv, b.this.Tw);
                            break;
                        case 1:
                            kVar.onMediaPreparing();
                            break;
                        case 2:
                            kVar.onMediaPrepared();
                            break;
                        case 3:
                            b.this.setKeepScreenOn(true);
                            kVar.onMediaPlayStart();
                            break;
                        case 4:
                            b.this.setKeepScreenOn(true);
                            kVar.onMediaPlaying();
                            break;
                        case 5:
                            b.this.setKeepScreenOn(false);
                            kVar.onMediaPlayPaused();
                            break;
                        case 6:
                            kVar.onVideoPlayBufferingPlaying();
                            break;
                        case 7:
                            kVar.onVideoPlayBufferingPaused();
                            break;
                        case 9:
                            if (b.this.TO != null && !b.this.TO.isLooping()) {
                                b.this.setKeepScreenOn(false);
                                b.this.rx();
                            }
                            kVar.onMediaPlayCompleted();
                            break;
                    }
                }
            }
        });
    }

    public final boolean pause() {
        boolean z10;
        com.kwad.sdk.core.e.c.i(this.TAG, "pause mCurrentState: " + getStateString(this.TN));
        if (this.TN == 4) {
            this.TO.pause();
            com.kwad.sdk.core.e.c.i(this.TAG, "pause STATE_PLAYING->STATE_PAUSED");
            this.TN = 5;
            onPlayStateChanged(this.TN);
            com.kwad.sdk.core.video.a.a.a.ev("videoPausePlay");
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.TN == 6) {
            this.TO.pause();
            com.kwad.sdk.core.e.c.i(this.TAG, "pause STATE_BUFFERING_PLAYING->STATE_PAUSED");
            this.TN = 7;
            onPlayStateChanged(this.TN);
            z10 = true;
        }
        if (this.TN == 3) {
            this.TO.pause();
            com.kwad.sdk.core.e.c.i(this.TAG, "pause STATE_STARTED->STATE_PAUSED");
            this.TN = 5;
            onPlayStateChanged(this.TN);
            com.kwad.sdk.core.video.a.a.a.ev("videoPausePlay");
            z10 = true;
        }
        if (this.TN != 9 || !this.TO.isLooping()) {
            return z10;
        }
        this.TO.pause();
        com.kwad.sdk.core.e.c.i(this.TAG, "pause " + getStateString(this.TN) + "->STATE_PAUSED");
        this.TN = 5;
        onPlayStateChanged(this.TN);
        return true;
    }

    public final void prepareAsync() {
        aP(false);
    }

    public final void release() {
        a((a) null);
    }

    public final void releaseSync() {
        a((a) null, false);
    }

    public final void restart() {
        if (this.TO != null && this.TN == 9) {
            start();
        }
        setPlayType(3);
    }

    public final void resume() {
        try {
            if (this.TO == null) {
                com.kwad.sdk.core.e.c.e(this.TAG, "resume but mMediaPlayer is null");
                return;
            }
            com.kwad.sdk.core.e.c.i(this.TAG, "resume state: " + getStateString(this.TN));
            if (this.TN != 2 && this.TN != 3 && this.TN != 0) {
                if (this.TN == 5) {
                    this.TO.start();
                    com.kwad.sdk.core.e.c.i(this.TAG, "resume:" + getStateString(this.TN) + "->STATE_PLAYING");
                    this.TN = 4;
                    onPlayStateChanged(this.TN);
                    setPlayType(2);
                    com.kwad.sdk.core.video.a.a.a.ev("videoResumePlay");
                    return;
                }
                if (this.TN == 7) {
                    this.TO.start();
                    com.kwad.sdk.core.e.c.i(this.TAG, "resume:" + getStateString(this.TN) + "->STATE_BUFFERING_PLAYING");
                    this.TN = 6;
                    onPlayStateChanged(this.TN);
                    return;
                }
                if (this.TN != 1) {
                    com.kwad.sdk.core.e.c.w(this.TAG, "resume: " + getStateString(this.TN) + " 此时不能调用resume()方法.");
                    return;
                }
                return;
            }
            com.kwad.sdk.core.e.c.i(this.TAG, "resume:" + getStateString(this.TN) + "->start()");
            start();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final com.kwad.sdk.core.video.a.c rs() {
        return this.TO;
    }

    public final void rv() {
        if (this.TO == null) {
            com.kwad.sdk.core.e.c.w("resetAndPlay", "mMediaPlayer is null");
            return;
        }
        if (this.TN != 2 && this.TN != 3 && this.TN != 4 && this.TN != 5) {
            reset();
            ru();
            rt();
            prepareAsync();
            return;
        }
        com.kwad.sdk.core.e.c.w("resetAndPlay", "can not resetAndPlay in state:");
    }

    public final void seekTo(long j10) {
        com.kwad.sdk.core.video.a.c cVar = this.TO;
        if (cVar != null) {
            cVar.seekTo(j10);
        }
    }

    public final void setAudioEnabled(boolean z10) {
        if (z10) {
            setVolume(1.0f, 1.0f);
        } else {
            setVolume(0.0f, 0.0f);
        }
    }

    public final void setRadius(float f10, float f11, float f12, float f13) {
        this.mDetailVideoView.setRadius(f10, f11, f12, f13);
    }

    public final void setSpeed(float f10) {
        com.kwad.sdk.core.video.a.c cVar = this.TO;
        if (cVar == null) {
            return;
        }
        cVar.setSpeed(f10);
    }

    public final void setSurface(Surface surface) {
        com.kwad.sdk.core.video.a.c cVar = this.TO;
        if (cVar != null) {
            cVar.setSurface(surface);
        }
    }

    public final void setVolume(float f10, float f11) {
        com.kwad.sdk.core.video.a.c cVar = this.TO;
        if (cVar == null) {
            return;
        }
        try {
            cVar.setVolume(f10, f11);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
    }

    public final void start() {
        try {
            if (this.TO == null) {
                return;
            }
            com.kwad.sdk.core.e.c.i(this.TAG, "start state: " + getStateString(this.TN));
            aM(0);
            if (this.TN == 0) {
                com.kwad.sdk.core.e.c.i(this.TAG, "start still not prepared well forcePrepare");
                aP(true);
                return;
            }
            if (this.TN != 2 && this.TN != 9) {
                if (this.TN == 3) {
                    this.TO.start();
                    return;
                }
                return;
            }
            this.mStartTime = System.currentTimeMillis();
            this.TO.start();
            com.kwad.sdk.core.video.a.a.a.ev("videoStartPlay");
            if (this.TQ != 0) {
                this.TO.seekTo((int) r5);
            }
            com.kwad.sdk.core.e.c.i(this.TAG, "start:" + getStateString(this.TN) + "->STATE_STARTED");
            com.kwad.sdk.contentalliance.a.a.b bVar = this.TS;
            if (bVar != null && bVar.videoPlayerStatus != null) {
                if (this.TN == 2) {
                    if (this.TS.videoPlayerStatus.mVideoPlayerType == 0) {
                        setPlayType(1);
                    } else {
                        setPlayType(3);
                    }
                } else if (this.TN == 9) {
                    setPlayType(3);
                }
            }
            this.TN = 3;
            onPlayStateChanged(this.TN);
            rw();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void stopAndPrepareAsync() {
        com.kwad.sdk.core.e.c.i(this.TAG, "stopAndPrepareAsync state: " + getStateString(this.TN));
        if (this.TN == 1 || this.TN == 2) {
            return;
        }
        if (this.TN == 3 || this.TN == 4 || this.TN == 5 || this.TN == 6 || this.TN == 7 || this.TN == 8 || this.TN == 9) {
            try {
                this.TO.stop();
                this.TN = 8;
                onPlayStateChanged(this.TN);
                prepareAsync();
                return;
            } catch (Exception unused) {
            }
        }
        release();
    }

    private b(@Nullable DetailVideoView detailVideoView, int i10) {
        this.TN = 0;
        this.fS = new Handler(Looper.getMainLooper());
        this.mStartTime = 0L;
        this.TT = 0;
        this.TU = new CopyOnWriteArrayList();
        this.TV = new AtomicBoolean(false);
        this.TW = false;
        this.TY = new CopyOnWriteArrayList();
        this.TZ = new CopyOnWriteArrayList();
        this.Ua = new CopyOnWriteArrayList();
        this.Ub = new c.f() { // from class: com.kwad.components.core.video.b.1
            @Override // com.kwad.sdk.core.video.a.c.f
            public final void ry() {
                b.this.TN = 1;
                b bVar = b.this;
                bVar.onPlayStateChanged(bVar.TN);
            }
        };
        this.Uc = new c.e() { // from class: com.kwad.components.core.video.b.4
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                try {
                    com.kwad.sdk.core.e.c.i(b.this.TAG, "onPrepared:" + b.getStateString(b.this.TN) + "->STATE_PREPARED");
                    b.this.TN = 2;
                    b bVar = b.this;
                    bVar.onPlayStateChanged(bVar.TN);
                    Iterator iterator2 = b.this.Ua.iterator2();
                    while (iterator2.hasNext()) {
                        ((c.e) iterator2.next()).a(b.this.TO);
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        };
        this.Ud = new c.i() { // from class: com.kwad.components.core.video.b.5
            @Override // com.kwad.sdk.core.video.a.c.i
            public final void k(int i11, int i12) {
                if (b.this.mDetailVideoView != null) {
                    b.this.mDetailVideoView.adaptVideoSize(i11, i12);
                }
                com.kwad.sdk.core.e.c.i(b.this.TAG, "onVideoSizeChanged ——> width：" + i11 + "， height：" + i12);
            }
        };
        this.Ue = new c.b() { // from class: com.kwad.components.core.video.b.6
            @Override // com.kwad.sdk.core.video.a.c.b
            public final void oZ() {
                b.this.TN = 9;
                b bVar = b.this;
                bVar.onPlayStateChanged(bVar.TN);
                com.kwad.sdk.core.video.a.a.a.ev("videoFinishPlay");
            }
        };
        this.Uf = new c.InterfaceC0530c() { // from class: com.kwad.components.core.video.b.7
            @Override // com.kwad.sdk.core.video.a.c.InterfaceC0530c
            public final boolean l(int i11, int i12) {
                if (i11 == -38) {
                    return true;
                }
                b.this.TN = -1;
                b.this.Tv = i11;
                b.this.Tw = i12;
                b bVar = b.this;
                bVar.onPlayStateChanged(bVar.TN);
                com.kwad.sdk.core.e.c.i(b.this.TAG, "onError ——> STATE_ERROR ———— what：" + i11 + ", extra: " + i12);
                return true;
            }
        };
        this.Ug = new c.d() { // from class: com.kwad.components.core.video.b.8
            @Override // com.kwad.sdk.core.video.a.c.d
            public final boolean m(int i11, int i12) {
                if (i11 == 3) {
                    b.this.TN = 4;
                    b bVar = b.this;
                    bVar.onPlayStateChanged(bVar.TN);
                    com.kwad.sdk.core.e.c.i(b.this.TAG, "onInfo:" + b.getStateString(b.this.TN) + "->STATE_PLAYING, time: " + (System.currentTimeMillis() - b.this.mStartTime));
                } else if (i11 == 701) {
                    if (b.this.TN == 5 || b.this.TN == 7) {
                        b.this.TN = 7;
                        com.kwad.sdk.core.e.c.i(b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED");
                    } else {
                        b.this.TN = 6;
                        com.kwad.sdk.core.e.c.i(b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING");
                    }
                    b bVar2 = b.this;
                    bVar2.onPlayStateChanged(bVar2.TN);
                } else if (i11 == 702) {
                    if (b.this.TN == 6) {
                        b.this.TN = 4;
                        b bVar3 = b.this;
                        bVar3.onPlayStateChanged(bVar3.TN);
                        com.kwad.sdk.core.e.c.i(b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                    }
                    if (b.this.TN == 7) {
                        b.this.TN = 5;
                        b bVar4 = b.this;
                        bVar4.onPlayStateChanged(bVar4.TN);
                        com.kwad.sdk.core.e.c.i(b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED");
                    }
                } else if (i11 != 10001) {
                    if (i11 == 801) {
                        com.kwad.sdk.core.e.c.i(b.this.TAG, "视频不能seekTo，为直播视频");
                    } else {
                        com.kwad.sdk.core.e.c.i(b.this.TAG, "onInfo ——> what：" + i11);
                    }
                }
                b bVar5 = b.this;
                bVar5.a(bVar5.TO, i11, i12);
                return true;
            }
        };
        this.Uh = new c.a() { // from class: com.kwad.components.core.video.b.9
            @Override // com.kwad.sdk.core.video.a.c.a
            public final void av(int i11) {
                b.this.TP = i11;
            }
        };
        this.mDetailVideoView = detailVideoView;
        if (detailVideoView != null) {
            this.mContext = detailVideoView.getContext().getApplicationContext();
        }
        this.TX = 0;
        String str = "DetailMediaPlayerImpl[0]";
        this.TAG = str;
        com.kwad.sdk.core.e.c.i(str, "create DetailMediaPlayerImpl");
    }

    public final void c(k kVar) {
        this.TY.add(kVar);
    }

    public final void d(k kVar) {
        this.TY.remove(kVar);
    }

    public final void a(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar, @NonNull DetailVideoView detailVideoView) {
        a(bVar, true, false, detailVideoView);
    }

    public final void b(c.d dVar) {
        if (dVar == null) {
            return;
        }
        this.TU.remove(dVar);
    }

    public final void a(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar, boolean z10, boolean z11, @NonNull DetailVideoView detailVideoView) {
        com.kwad.sdk.core.e.c.i(this.TAG, "initMediaPlayer enablePreLoad:" + z10);
        if (bVar == null || detailVideoView == null) {
            return;
        }
        com.kwad.sdk.core.video.a.c a10 = com.kwad.sdk.core.video.a.e.a(this.mContext, z10, com.kwad.sdk.core.config.d.yn(), com.kwad.sdk.core.config.d.yo(), this.TX);
        a10.setLooping(false);
        a(bVar, z11, detailVideoView, a10);
    }

    private void a(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar, boolean z10, @NonNull DetailVideoView detailVideoView, @NonNull com.kwad.sdk.core.video.a.c cVar) {
        com.kwad.sdk.core.e.c.i(this.TAG, "initMediaPlayer " + ((Object) this.TO));
        if (bVar == null || detailVideoView == null || cVar == null) {
            return;
        }
        if (this.mContext == null) {
            this.mContext = detailVideoView.getContext().getApplicationContext();
        }
        this.TW = z10;
        this.TS = bVar;
        com.kwad.components.core.video.a.a a10 = com.kwad.components.core.video.a.d.a(bVar.adTemplate, this.mAdTemplate, bVar.videoUrl);
        c(a10);
        a(a10);
        DetailVideoView detailVideoView2 = this.mDetailVideoView;
        if (detailVideoView2 != detailVideoView) {
            com.kwad.sdk.core.e.c.i(this.TAG, "initMediaPlayer videoView changed");
            if (detailVideoView2 != null) {
                detailVideoView2.setMediaPlayer(null);
                detailVideoView.setKeepScreenOn(detailVideoView2.getKeepScreenOn());
                detailVideoView2.setKeepScreenOn(false);
            }
            this.mDetailVideoView = detailVideoView;
        }
        detailVideoView.setMediaPlayer(this);
        if (this.TO != cVar) {
            com.kwad.sdk.core.e.c.i(this.TAG, "initMediaPlayer mediaPlayer changed");
            com.kwad.sdk.core.video.a.c cVar2 = this.TO;
            if (cVar2 != null) {
                cVar.setLooping(cVar2.isLooping());
                ru();
                this.TO.release();
            }
            this.TO = cVar;
            reset();
            rt();
            cVar.setAudioStreamType(3);
        } else {
            com.kwad.sdk.core.e.c.i(this.TAG, "initMediaPlayer mediaPlayer not changed");
            reset();
            ru();
            rt();
        }
        this.TO.setSurface(detailVideoView.Uq);
    }

    public b(@Nullable DetailVideoView detailVideoView, @NonNull AdTemplate adTemplate) {
        this(detailVideoView);
        this.mAdTemplate = adTemplate;
    }

    public final void start(long j10) {
        this.TQ = j10;
        start();
    }

    public final void a(c.e eVar) {
        this.Ua.add(eVar);
    }

    public final void a(c.d dVar) {
        if (dVar == null) {
            return;
        }
        this.TU.add(dVar);
    }

    public final void a(com.kwad.sdk.core.video.a.c cVar, int i10, int i11) {
        Iterator<c.d> iterator2 = this.TU.iterator2();
        while (iterator2.hasNext()) {
            c.d next = iterator2.next();
            if (next == null) {
                iterator2.remove();
            } else {
                next.m(i10, i11);
            }
        }
    }

    public final void a(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar) {
        try {
            if (!TextUtils.isEmpty(bVar.videoUrl)) {
                com.kwad.sdk.core.e.c.d(this.TAG, "videoUrl=" + bVar.videoUrl);
                this.TO.a(bVar);
                return;
            }
            com.kwad.sdk.core.e.c.e(this.TAG, "videoUrl is null");
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTrace(e2);
        }
    }

    public final void a(final a aVar, boolean z10) {
        if (this.TO == null) {
            return;
        }
        com.kwad.sdk.core.e.c.i(this.TAG, "release:" + getStateString(this.TN) + "->STATE_IDLE");
        setKeepScreenOn(false);
        this.fS.removeCallbacksAndMessages(null);
        rx();
        ru();
        this.mDetailVideoView = null;
        final com.kwad.sdk.core.video.a.c cVar = this.TO;
        if (cVar != null) {
            if (z10) {
                com.kwad.sdk.utils.g.execute(new ay() { // from class: com.kwad.components.core.video.b.11
                    @Override // com.kwad.sdk.utils.ay
                    public final void doTask() {
                        b.this.a(cVar, aVar);
                    }
                });
            } else {
                a(cVar, aVar);
            }
            this.TO = null;
        }
        this.TN = 0;
        this.TT = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.core.video.a.c cVar, a aVar) {
        if (cVar == null) {
            return;
        }
        com.kwad.sdk.core.e.c.i(this.TAG, "releaseMediaPlayer:" + getStateString(this.TN) + "->STATE_IDLE");
        try {
            aM(2);
            cVar.release();
            if (aVar != null) {
                aVar.onReleaseSuccess();
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
        }
    }

    public final void a(a aVar) {
        a(aVar, true);
    }

    private void a(com.kwad.components.core.video.a.c cVar) {
        this.TZ.add(cVar);
    }

    public final void a(com.kwad.sdk.contentalliance.a.a.a aVar) {
        com.kwad.sdk.core.video.a.c cVar = this.TO;
        if (cVar instanceof com.kwad.sdk.core.video.a.d) {
            ((com.kwad.sdk.core.video.a.d) cVar).a(aVar);
        }
    }
}
