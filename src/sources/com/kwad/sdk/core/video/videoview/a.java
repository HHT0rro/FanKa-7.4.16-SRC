package com.kwad.sdk.core.video.videoview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.core.video.a.e;
import com.kwad.sdk.core.video.a.f;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.i;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.utils.y;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a extends AdBasePvFrameLayout implements TextureView.SurfaceTextureListener, c {
    private static AtomicBoolean aBz = new AtomicBoolean(false);
    private int TN;
    private com.kwad.sdk.core.video.a.c TO;
    private int TP;
    private long TQ;
    private com.kwad.sdk.contentalliance.a.a.b TS;
    private c.e Uc;
    private c.i Ud;
    private c.b Ue;
    private c.InterfaceC0530c Uf;
    private c.d Ug;
    private c.a Uh;
    private SurfaceTexture Up;
    private Surface Uq;
    private boolean aBA;
    private boolean aBB;
    private ImageView aBC;
    private AudioManager aBv;
    private com.kwad.sdk.core.video.a aBw;
    private b aBx;
    private boolean aBy;

    /* renamed from: dd, reason: collision with root package name */
    private com.kwad.sdk.contentalliance.a.a.a f36648dd;
    private FrameLayout hR;
    private Context mContext;
    private Map<String, String> mHeaders;
    private String mUrl;

    public a(Context context) {
        this(context, null);
    }

    private ImageView Gh() {
        ImageView imageView = new ImageView(this.mContext);
        addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        return imageView;
    }

    private boolean Gi() {
        return this.TN == 6;
    }

    private void Gk() {
        if (this.TO == null) {
            f fVar = (f) ServiceProvider.get(f.class);
            com.kwad.sdk.core.video.a.c a10 = e.a(this.mContext, false, fVar != null && fVar.yn(), fVar != null && fVar.yo(), 0);
            this.TO = a10;
            a10.setAudioStreamType(3);
            if (this.aBA) {
                return;
            }
            this.TO.setVolume(0.0f, 0.0f);
        }
    }

    private void Gl() {
        this.hR.removeView(this.aBw);
        this.hR.addView(this.aBw, 0, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    private void Gm() {
        com.kwad.sdk.contentalliance.a.a.a aVar;
        this.hR.setKeepScreenOn(true);
        this.TO.b(this.Uc);
        this.TO.a(this.Ud);
        this.TO.a(this.Ue);
        this.TO.a(this.Uf);
        this.TO.c(this.Ug);
        this.TO.a(this.Uh);
        try {
            com.kwad.sdk.contentalliance.a.a.b bVar = this.TS;
            if (bVar != null && (aVar = this.f36648dd) != null) {
                bVar.aoR = aVar;
            }
            this.TO.a(bVar);
            if (this.Uq == null) {
                this.Uq = new Surface(this.Up);
            }
            this.TO.setSurface(this.Uq);
            if (this.TO.prepareAsync()) {
                this.TN = 1;
                this.aBx.onPlayStateChanged(1);
                com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "STATE_PREPARING");
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTrace(e2);
            com.kwad.sdk.core.e.c.e("KSVideoPlayerViewView", "打开播放器发生错误", e2);
        }
    }

    private void Gn() {
        AudioManager audioManager = this.aBv;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(null);
            this.aBv = null;
        }
        com.kwad.sdk.core.video.a.c cVar = this.TO;
        if (cVar != null) {
            cVar.release();
            this.TO = null;
            com.kwad.sdk.core.video.a.a.a.ev("videoFinishPlay");
        }
        bn.runOnUiThread(new ay() { // from class: com.kwad.sdk.core.video.videoview.a.7
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                a.this.hR.removeView(a.this.aBw);
            }
        });
        Surface surface = this.Uq;
        if (surface != null) {
            surface.release();
            this.Uq = null;
        }
        SurfaceTexture surfaceTexture = this.Up;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.Up = null;
        }
        this.TN = 0;
    }

    private void eh(AdTemplate adTemplate) {
        i iVar = (i) ServiceProvider.get(i.class);
        if (iVar != null) {
            iVar.load(this.aBC, com.kwad.sdk.core.response.b.e.dU(adTemplate), adTemplate);
        }
    }

    private void init() {
        this.aBC = Gh();
        this.hR = new FrameLayout(this.mContext);
        addView(this.hR, new FrameLayout.LayoutParams(-1, -1));
    }

    private void rz() {
        if (this.aBw == null) {
            com.kwad.sdk.core.video.a aVar = new com.kwad.sdk.core.video.a(this.mContext);
            this.aBw = aVar;
            aVar.setSurfaceTextureListener(this);
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

    @Override // com.kwad.sdk.core.video.videoview.c
    public final boolean Gj() {
        return this.TN == 7;
    }

    public final void a(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar, Map<String, String> map) {
        this.TS = bVar;
        this.mUrl = bVar.videoUrl;
        this.mHeaders = null;
        eh(bVar.adTemplate);
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final int getBufferPercentage() {
        return this.TP;
    }

    public final b getController() {
        return this.aBx;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final long getCurrentPosition() {
        com.kwad.sdk.core.video.a.c cVar = this.TO;
        if (cVar != null) {
            return cVar.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final long getDuration() {
        com.kwad.sdk.core.video.a.c cVar = this.TO;
        if (cVar != null) {
            return cVar.getDuration();
        }
        return 0L;
    }

    public final int getMaxVolume() {
        AudioManager audioManager = this.aBv;
        if (audioManager != null) {
            return audioManager.getStreamMaxVolume(3);
        }
        return 0;
    }

    public final b getVideoController() {
        return this.aBx;
    }

    public final int getVolume() {
        AudioManager audioManager = this.aBv;
        if (audioManager != null) {
            return audioManager.getStreamVolume(3);
        }
        return 0;
    }

    public final boolean isCompleted() {
        return this.TN == 9;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final boolean isIdle() {
        return this.TN == 0;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final boolean isPaused() {
        return this.TN == 5;
    }

    public final boolean isPlaying() {
        return this.TN == 4;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
        SurfaceTexture surfaceTexture2 = this.Up;
        if (surfaceTexture2 == null) {
            this.Up = surfaceTexture;
            Gm();
        } else {
            this.aBw.setSurfaceTexture(surfaceTexture2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void pause() {
        com.kwad.sdk.core.video.a.c cVar = this.TO;
        if (cVar == null) {
            return;
        }
        int i10 = this.TN;
        if (i10 == 4) {
            cVar.pause();
            com.kwad.sdk.core.video.a.a.a.ev("videoPausePlay");
            this.TN = 5;
            this.aBx.onPlayStateChanged(5);
            com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "STATE_PAUSED");
            return;
        }
        if (i10 == 6) {
            cVar.pause();
            com.kwad.sdk.core.video.a.a.a.ev("videoPausePlay");
            this.TN = 7;
            this.aBx.onPlayStateChanged(7);
            com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "STATE_BUFFERING_PAUSED");
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void release() {
        if (this.aBy) {
            if (!isPlaying() && !Gi() && !Gj() && !isPaused()) {
                if (isCompleted()) {
                    y.e(this.mContext, this.mUrl, 0L);
                }
            } else {
                y.e(this.mContext, this.mUrl, getCurrentPosition());
            }
        }
        Gn();
        b bVar = this.aBx;
        if (bVar != null) {
            bVar.reset();
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void restart() {
        int i10 = this.TN;
        if (i10 == 5) {
            this.TO.start();
            com.kwad.sdk.core.video.a.a.a.ev("videoResumePlay");
            this.TN = 4;
            this.aBx.onPlayStateChanged(4);
            setPlayType(2);
            com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "STATE_PLAYING");
            return;
        }
        if (i10 == 7) {
            this.TO.start();
            com.kwad.sdk.core.video.a.a.a.ev("videoResumePlay");
            this.TN = 6;
            this.aBx.onPlayStateChanged(6);
            com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "STATE_BUFFERING_PLAYING");
            return;
        }
        if (i10 != 9 && i10 != -1) {
            com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "KSVideoPlayer在状态为 " + this.TN + " 时不能调用restart()方法.");
            return;
        }
        this.TO.reset();
        Gm();
        setPlayType(3);
    }

    public final void seekTo(int i10) {
        com.kwad.sdk.core.video.a.c cVar = this.TO;
        if (cVar != null) {
            cVar.seekTo(i10);
        }
    }

    public final void setController(b bVar) {
        this.hR.removeView(this.aBx);
        this.aBx = bVar;
        bVar.reset();
        this.hR.addView(this.aBx, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void setKsPlayLogParam(@NonNull com.kwad.sdk.contentalliance.a.a.a aVar) {
        this.f36648dd = aVar;
    }

    public final void setLooping(boolean z10) {
        com.kwad.sdk.core.video.a.c cVar = this.TO;
        if (cVar != null) {
            cVar.setLooping(z10);
        }
    }

    public final void setPortraitFullscreen(boolean z10) {
        this.aBB = z10;
    }

    public final void setVideoSoundEnable(boolean z10) {
        this.aBA = z10;
        com.kwad.sdk.core.video.a.c cVar = this.TO;
        if (cVar != null) {
            if (z10) {
                cVar.setVolume(1.0f, 1.0f);
            } else {
                cVar.setVolume(0.0f, 0.0f);
            }
        }
    }

    public final void setVolume(int i10) {
        AudioManager audioManager = this.aBv;
        if (audioManager != null) {
            audioManager.setStreamVolume(3, i10, 0);
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void start() {
        VideoPlayerStatus videoPlayerStatus;
        if (this.TN == 0) {
            Gk();
            rz();
            Gl();
            com.kwad.sdk.contentalliance.a.a.b bVar = this.TS;
            if (bVar != null && (videoPlayerStatus = bVar.videoPlayerStatus) != null) {
                if (videoPlayerStatus.mVideoPlayerType == 0) {
                    setPlayType(1);
                } else {
                    setPlayType(3);
                }
            }
            com.kwad.sdk.core.video.a.a.a.ev("videoStartPlay");
            return;
        }
        com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "KSVideoPlayer只有在状态为STATE_IDLE时才能调用start方法.");
    }

    private a(Context context, AttributeSet attributeSet) {
        super(context, null);
        this.TN = 0;
        this.aBy = false;
        this.aBA = false;
        this.aBB = false;
        this.Uc = new c.e() { // from class: com.kwad.sdk.core.video.videoview.a.1
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                try {
                    a.this.TN = 2;
                    a.this.aBx.onPlayStateChanged(a.this.TN);
                    com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "onPrepared ——> STATE_PREPARED");
                    cVar.start();
                    if (a.this.aBy) {
                        cVar.seekTo((int) y.T(a.this.mContext, a.this.mUrl));
                    }
                    if (a.this.TQ != 0) {
                        cVar.seekTo((int) a.this.TQ);
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        };
        this.Ud = new c.i() { // from class: com.kwad.sdk.core.video.videoview.a.2
            @Override // com.kwad.sdk.core.video.a.c.i
            public final void k(int i10, int i11) {
                if (!a.this.aBB || i11 <= i10) {
                    a.this.aBw.adaptVideoSize(i10, i11);
                    com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "onVideoSizeChanged ——> width：" + i10 + "， height：" + i11);
                }
            }
        };
        this.Ue = new c.b() { // from class: com.kwad.sdk.core.video.videoview.a.3
            @Override // com.kwad.sdk.core.video.a.c.b
            public final void oZ() {
                if (a.this.TN != 9) {
                    a.this.TN = 9;
                    a.this.aBx.onPlayStateChanged(a.this.TN);
                    com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "onCompletion ——> STATE_COMPLETED");
                    a.this.hR.setKeepScreenOn(false);
                }
            }
        };
        this.Uf = new c.InterfaceC0530c() { // from class: com.kwad.sdk.core.video.videoview.a.4
            @Override // com.kwad.sdk.core.video.a.c.InterfaceC0530c
            public final boolean l(int i10, int i11) {
                if (i10 == -38) {
                    return true;
                }
                a.this.TN = -1;
                a.this.aBx.n(i10, i11);
                a.this.aBx.onPlayStateChanged(a.this.TN);
                com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "onError ——> STATE_ERROR ———— what：" + i10 + ", extra: " + i11);
                return true;
            }
        };
        this.Ug = new c.d() { // from class: com.kwad.sdk.core.video.videoview.a.5
            @Override // com.kwad.sdk.core.video.a.c.d
            public final boolean m(int i10, int i11) {
                if (i10 == 3) {
                    a.this.TN = 4;
                    a.this.aBx.onPlayStateChanged(a.this.TN);
                    com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_VIDEO_RENDERING_START：STATE_PLAYING");
                    return true;
                }
                if (i10 == 701) {
                    if (a.this.TN != 5 && a.this.TN != 7) {
                        a.this.TN = 6;
                        com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING");
                    } else {
                        a.this.TN = 7;
                        com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED");
                    }
                    a.this.aBx.onPlayStateChanged(a.this.TN);
                    return true;
                }
                if (i10 == 702) {
                    if (a.this.TN == 6) {
                        a.this.TN = 4;
                        a.this.aBx.onPlayStateChanged(a.this.TN);
                        com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                    }
                    if (a.this.TN != 7) {
                        return true;
                    }
                    a.this.TN = 5;
                    a.this.aBx.onPlayStateChanged(a.this.TN);
                    com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED");
                    return true;
                }
                if (i10 == 10001) {
                    if (a.this.aBw == null) {
                        return true;
                    }
                    a.this.aBw.setRotation(i11);
                    com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "视频旋转角度：" + i11);
                    return true;
                }
                if (i10 == 801) {
                    com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "视频不能seekTo，为直播视频");
                    return true;
                }
                com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "onInfo ——> what：" + i10);
                return true;
            }
        };
        this.Uh = new c.a() { // from class: com.kwad.sdk.core.video.videoview.a.6
            @Override // com.kwad.sdk.core.video.a.c.a
            public final void av(int i10) {
                a.this.TP = i10;
            }
        };
        this.mContext = context;
        init();
    }
}
