package io.flutter.plugins.videoplayer;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.f1;
import com.google.android.exoplayer2.g1;
import com.google.android.exoplayer2.h1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.dash.c;
import com.google.android.exoplayer2.source.h0;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource;
import com.google.android.exoplayer2.source.smoothstreaming.a;
import com.google.android.exoplayer2.upstream.DefaultDataSource;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.w0;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import io.flutter.plugin.common.EventChannel;
import io.flutter.view.TextureRegistry;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import q6.y;
import x4.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class VideoPlayer {
    private static final String FORMAT_DASH = "dash";
    private static final String FORMAT_HLS = "hls";
    private static final String FORMAT_OTHER = "other";
    private static final String FORMAT_SS = "ss";
    private static final String USER_AGENT = "User-Agent";
    private final EventChannel eventChannel;
    private QueuingEventSink eventSink;
    private com.google.android.exoplayer2.p exoPlayer;
    private e.b httpDataSourceFactory;

    @VisibleForTesting
    public boolean isInitialized;
    private final VideoPlayerOptions options;
    private Surface surface;
    private final TextureRegistry.SurfaceTextureEntry textureEntry;

    public VideoPlayer(Context context, EventChannel eventChannel, TextureRegistry.SurfaceTextureEntry surfaceTextureEntry, String str, String str2, @NonNull Map<String, String> map, VideoPlayerOptions videoPlayerOptions) {
        this.isInitialized = false;
        this.httpDataSourceFactory = new e.b();
        this.eventChannel = eventChannel;
        this.textureEntry = surfaceTextureEntry;
        this.options = videoPlayerOptions;
        com.google.android.exoplayer2.p a10 = new p.b(context).a();
        Uri parse = Uri.parse(str);
        buildHttpDataSourceFactory(map);
        a10.b(buildMediaSource(parse, new DefaultDataSource.Factory(context, this.httpDataSourceFactory), str2));
        a10.prepare();
        setUpVideoPlayer(a10, new QueuingEventSink());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private s buildMediaSource(Uri uri, a.InterfaceC0208a interfaceC0208a, String str) {
        char c4;
        int i10 = 0;
        if (str != null) {
            switch (str.hashCode()) {
                case 3680:
                    if (str.equals(FORMAT_SS)) {
                        c4 = 0;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 103407:
                    if (str.equals(FORMAT_HLS)) {
                        c4 = 1;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 3075986:
                    if (str.equals(FORMAT_DASH)) {
                        c4 = 2;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 106069776:
                    if (str.equals("other")) {
                        c4 = 3;
                        break;
                    }
                    c4 = 65535;
                    break;
                default:
                    c4 = 65535;
                    break;
            }
            switch (c4) {
                case 0:
                    i10 = 1;
                    break;
                case 1:
                    i10 = 2;
                    break;
                case 2:
                    break;
                case 3:
                    i10 = 4;
                    break;
                default:
                    i10 = -1;
                    break;
            }
        } else {
            i10 = j0.j0(uri);
        }
        if (i10 == 0) {
            return new DashMediaSource.Factory(new c.a(interfaceC0208a), interfaceC0208a).b(w0.b(uri));
        }
        if (i10 == 1) {
            return new SsMediaSource.Factory(new a.C0204a(interfaceC0208a), interfaceC0208a).b(w0.b(uri));
        }
        if (i10 == 2) {
            return new HlsMediaSource.Factory(interfaceC0208a).b(w0.b(uri));
        }
        if (i10 == 4) {
            return new h0.b(interfaceC0208a).b(w0.b(uri));
        }
        throw new IllegalStateException("Unsupported type: " + i10);
    }

    private static void setAudioAttributes(com.google.android.exoplayer2.p pVar, boolean z10) {
        pVar.setAudioAttributes(new d.b().b(3).a(), !z10);
    }

    private void setUpVideoPlayer(final com.google.android.exoplayer2.p pVar, final QueuingEventSink queuingEventSink) {
        this.exoPlayer = pVar;
        this.eventSink = queuingEventSink;
        this.eventChannel.setStreamHandler(new EventChannel.StreamHandler() { // from class: io.flutter.plugins.videoplayer.VideoPlayer.1
            @Override // io.flutter.plugin.common.EventChannel.StreamHandler
            public void onCancel(Object obj) {
                queuingEventSink.setDelegate(null);
            }

            @Override // io.flutter.plugin.common.EventChannel.StreamHandler
            public void onListen(Object obj, EventChannel.EventSink eventSink) {
                queuingEventSink.setDelegate(eventSink);
            }
        });
        Surface surface = new Surface(this.textureEntry.surfaceTexture());
        this.surface = surface;
        pVar.e(surface);
        setAudioAttributes(pVar, this.options.mixWithOthers);
        pVar.N(new Player.e() { // from class: io.flutter.plugins.videoplayer.VideoPlayer.2
            private boolean isBuffering = false;

            public /* bridge */ /* synthetic */ void onAudioAttributesChanged(x4.d dVar) {
                h1.a(this, dVar);
            }

            public /* bridge */ /* synthetic */ void onAudioSessionIdChanged(int i10) {
                h1.b(this, i10);
            }

            @Override // com.google.android.exoplayer2.Player.c
            public /* bridge */ /* synthetic */ void onAvailableCommandsChanged(Player.b bVar) {
                h1.c(this, bVar);
            }

            @Override // com.google.android.exoplayer2.Player.e, e6.j
            public /* bridge */ /* synthetic */ void onCues(List list) {
                h1.d(this, list);
            }

            @Override // com.google.android.exoplayer2.Player.e, a5.c
            public /* bridge */ /* synthetic */ void onDeviceInfoChanged(a5.b bVar) {
                h1.e(this, bVar);
            }

            @Override // com.google.android.exoplayer2.Player.e, a5.c
            public /* bridge */ /* synthetic */ void onDeviceVolumeChanged(int i10, boolean z10) {
                h1.f(this, i10, z10);
            }

            @Override // com.google.android.exoplayer2.Player.c
            public /* bridge */ /* synthetic */ void onEvents(Player player, Player.d dVar) {
                h1.g(this, player, dVar);
            }

            @Override // com.google.android.exoplayer2.Player.c
            public /* bridge */ /* synthetic */ void onIsLoadingChanged(boolean z10) {
                h1.h(this, z10);
            }

            @Override // com.google.android.exoplayer2.Player.c
            public void onIsPlayingChanged(boolean z10) {
                if (queuingEventSink != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("event", "isPlayingStateUpdate");
                    hashMap.put("isPlaying", Boolean.valueOf(z10));
                    queuingEventSink.success(hashMap);
                }
            }

            @Override // com.google.android.exoplayer2.Player.c
            @Deprecated
            public /* bridge */ /* synthetic */ void onLoadingChanged(boolean z10) {
                g1.d(this, z10);
            }

            public /* bridge */ /* synthetic */ void onMaxSeekToPreviousPositionChanged(int i10) {
                g1.e(this, i10);
            }

            @Override // com.google.android.exoplayer2.Player.c
            public /* bridge */ /* synthetic */ void onMediaItemTransition(@Nullable w0 w0Var, int i10) {
                h1.j(this, w0Var, i10);
            }

            @Override // com.google.android.exoplayer2.Player.c
            public /* bridge */ /* synthetic */ void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
                h1.k(this, mediaMetadata);
            }

            @Override // com.google.android.exoplayer2.Player.e, n5.e
            public /* bridge */ /* synthetic */ void onMetadata(Metadata metadata) {
                h1.l(this, metadata);
            }

            @Override // com.google.android.exoplayer2.Player.c
            public /* bridge */ /* synthetic */ void onPlayWhenReadyChanged(boolean z10, int i10) {
                h1.m(this, z10, i10);
            }

            @Override // com.google.android.exoplayer2.Player.c
            public /* bridge */ /* synthetic */ void onPlaybackParametersChanged(f1 f1Var) {
                h1.n(this, f1Var);
            }

            @Override // com.google.android.exoplayer2.Player.c
            public void onPlaybackStateChanged(int i10) {
                if (i10 == 2) {
                    setBuffering(true);
                    VideoPlayer.this.sendBufferingUpdate();
                } else if (i10 == 3) {
                    VideoPlayer videoPlayer = VideoPlayer.this;
                    if (!videoPlayer.isInitialized) {
                        videoPlayer.isInitialized = true;
                        videoPlayer.sendInitialized();
                    }
                } else if (i10 == 4) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("event", "completed");
                    queuingEventSink.success(hashMap);
                }
                if (i10 != 2) {
                    setBuffering(false);
                }
            }

            @Override // com.google.android.exoplayer2.Player.c
            public /* bridge */ /* synthetic */ void onPlaybackSuppressionReasonChanged(int i10) {
                h1.p(this, i10);
            }

            @Override // com.google.android.exoplayer2.Player.c
            public void onPlayerError(@NonNull PlaybackException playbackException) {
                setBuffering(false);
                if (playbackException.errorCode == 1002) {
                    pVar.z();
                    pVar.prepare();
                    return;
                }
                QueuingEventSink queuingEventSink2 = queuingEventSink;
                if (queuingEventSink2 != null) {
                    queuingEventSink2.error("VideoError", "Video player had error " + ((Object) playbackException), null);
                }
            }

            @Override // com.google.android.exoplayer2.Player.c
            public /* bridge */ /* synthetic */ void onPlayerErrorChanged(@Nullable PlaybackException playbackException) {
                h1.r(this, playbackException);
            }

            @Override // com.google.android.exoplayer2.Player.c
            @Deprecated
            public /* bridge */ /* synthetic */ void onPlayerStateChanged(boolean z10, int i10) {
                g1.l(this, z10, i10);
            }

            public /* bridge */ /* synthetic */ void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
                h1.s(this, mediaMetadata);
            }

            @Override // com.google.android.exoplayer2.Player.c
            @Deprecated
            public /* bridge */ /* synthetic */ void onPositionDiscontinuity(int i10) {
                g1.m(this, i10);
            }

            @Override // com.google.android.exoplayer2.Player.c
            public /* bridge */ /* synthetic */ void onPositionDiscontinuity(Player.f fVar, Player.f fVar2, int i10) {
                h1.t(this, fVar, fVar2, i10);
            }

            @Override // com.google.android.exoplayer2.Player.e, q6.l
            public /* bridge */ /* synthetic */ void onRenderedFirstFrame() {
                h1.u(this);
            }

            @Override // com.google.android.exoplayer2.Player.c
            public /* bridge */ /* synthetic */ void onRepeatModeChanged(int i10) {
                h1.v(this, i10);
            }

            public /* bridge */ /* synthetic */ void onSeekBackIncrementChanged(long j10) {
                h1.w(this, j10);
            }

            public /* bridge */ /* synthetic */ void onSeekForwardIncrementChanged(long j10) {
                h1.x(this, j10);
            }

            @Override // com.google.android.exoplayer2.Player.c
            @Deprecated
            public /* bridge */ /* synthetic */ void onSeekProcessed() {
                g1.p(this);
            }

            @Override // com.google.android.exoplayer2.Player.c
            public /* bridge */ /* synthetic */ void onShuffleModeEnabledChanged(boolean z10) {
                h1.y(this, z10);
            }

            @Override // com.google.android.exoplayer2.Player.e, x4.f
            public /* bridge */ /* synthetic */ void onSkipSilenceEnabledChanged(boolean z10) {
                h1.z(this, z10);
            }

            @Override // com.google.android.exoplayer2.Player.c
            @Deprecated
            public /* bridge */ /* synthetic */ void onStaticMetadataChanged(List list) {
                g1.r(this, list);
            }

            @Override // com.google.android.exoplayer2.Player.e, q6.l
            public /* bridge */ /* synthetic */ void onSurfaceSizeChanged(int i10, int i11) {
                h1.A(this, i10, i11);
            }

            @Override // com.google.android.exoplayer2.Player.c
            public /* bridge */ /* synthetic */ void onTimelineChanged(Timeline timeline, int i10) {
                h1.B(this, timeline, i10);
            }

            @Override // com.google.android.exoplayer2.Player.c
            public /* bridge */ /* synthetic */ void onTracksChanged(TrackGroupArray trackGroupArray, n6.h hVar) {
                h1.C(this, trackGroupArray, hVar);
            }

            @Override // q6.l
            @Deprecated
            public /* bridge */ /* synthetic */ void onVideoSizeChanged(int i10, int i11, int i12, float f10) {
                q6.k.a(this, i10, i11, i12, f10);
            }

            @Override // com.google.android.exoplayer2.Player.e, q6.l
            public /* bridge */ /* synthetic */ void onVideoSizeChanged(y yVar) {
                h1.D(this, yVar);
            }

            @Override // com.google.android.exoplayer2.Player.e, x4.f
            public /* bridge */ /* synthetic */ void onVolumeChanged(float f10) {
                h1.E(this, f10);
            }

            public void setBuffering(boolean z10) {
                if (this.isBuffering != z10) {
                    this.isBuffering = z10;
                    HashMap hashMap = new HashMap();
                    hashMap.put("event", this.isBuffering ? "bufferingStart" : "bufferingEnd");
                    queuingEventSink.success(hashMap);
                }
            }
        });
    }

    @VisibleForTesting
    public void buildHttpDataSourceFactory(@NonNull Map<String, String> map) {
        boolean z10 = !map.isEmpty();
        this.httpDataSourceFactory.e((z10 && map.containsKey("User-Agent")) ? map.get("User-Agent") : "ExoPlayer").c(true);
        if (z10) {
            this.httpDataSourceFactory.d(map);
        }
    }

    public void dispose() {
        if (this.isInitialized) {
            this.exoPlayer.stop();
        }
        this.textureEntry.release();
        this.eventChannel.setStreamHandler(null);
        Surface surface = this.surface;
        if (surface != null) {
            surface.release();
        }
        com.google.android.exoplayer2.p pVar = this.exoPlayer;
        if (pVar != null) {
            pVar.release();
        }
    }

    public long getPosition() {
        return this.exoPlayer.getCurrentPosition();
    }

    public void pause() {
        this.exoPlayer.setPlayWhenReady(false);
    }

    public void play() {
        this.exoPlayer.setPlayWhenReady(true);
    }

    public void seekTo(int i10) {
        this.exoPlayer.seekTo(i10);
    }

    public void sendBufferingUpdate() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "bufferingUpdate");
        hashMap.put("values", Collections.singletonList(Arrays.asList(0, Long.valueOf(this.exoPlayer.O()))));
        this.eventSink.success(hashMap);
    }

    @VisibleForTesting
    public void sendInitialized() {
        if (this.isInitialized) {
            HashMap hashMap = new HashMap();
            hashMap.put("event", "initialized");
            hashMap.put("duration", Long.valueOf(this.exoPlayer.getDuration()));
            if (this.exoPlayer.getVideoFormat() != null) {
                Format videoFormat = this.exoPlayer.getVideoFormat();
                int i10 = videoFormat.f19549r;
                int i11 = videoFormat.f19550s;
                int i12 = videoFormat.f19552u;
                if (i12 == 90 || i12 == 270) {
                    i10 = this.exoPlayer.getVideoFormat().f19550s;
                    i11 = this.exoPlayer.getVideoFormat().f19549r;
                }
                hashMap.put("width", Integer.valueOf(i10));
                hashMap.put("height", Integer.valueOf(i11));
                if (i12 == 180) {
                    hashMap.put("rotationCorrection", Integer.valueOf(i12));
                }
            }
            this.eventSink.success(hashMap);
        }
    }

    public void setLooping(boolean z10) {
        this.exoPlayer.setRepeatMode(z10 ? 2 : 0);
    }

    public void setPlaybackSpeed(double d10) {
        this.exoPlayer.c(new f1((float) d10));
    }

    public void setVolume(double d10) {
        this.exoPlayer.setVolume((float) Math.max(ShadowDrawableWrapper.COS_45, Math.min(1.0d, d10)));
    }

    @VisibleForTesting
    public VideoPlayer(com.google.android.exoplayer2.p pVar, EventChannel eventChannel, TextureRegistry.SurfaceTextureEntry surfaceTextureEntry, VideoPlayerOptions videoPlayerOptions, QueuingEventSink queuingEventSink, e.b bVar) {
        this.isInitialized = false;
        new e.b();
        this.eventChannel = eventChannel;
        this.textureEntry = surfaceTextureEntry;
        this.options = videoPlayerOptions;
        this.httpDataSourceFactory = bVar;
        setUpVideoPlayer(pVar, queuingEventSink);
    }
}
