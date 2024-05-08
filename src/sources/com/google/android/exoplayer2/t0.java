package com.google.android.exoplayer2;

import android.os.Looper;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.TrackGroupArray;
import java.util.List;

/* compiled from: ForwardingPlayer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class t0 implements Player {

    /* renamed from: a, reason: collision with root package name */
    public final Player f22160a;

    /* compiled from: ForwardingPlayer.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class b implements Player.c {

        /* renamed from: b, reason: collision with root package name */
        public final t0 f22161b;

        /* renamed from: c, reason: collision with root package name */
        public final Player.c f22162c;

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f22161b.equals(bVar.f22161b)) {
                return this.f22162c.equals(bVar.f22162c);
            }
            return false;
        }

        public int hashCode() {
            return (this.f22161b.hashCode() * 31) + this.f22162c.hashCode();
        }

        @Override // com.google.android.exoplayer2.Player.c
        public void onAvailableCommandsChanged(Player.b bVar) {
            this.f22162c.onAvailableCommandsChanged(bVar);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public void onEvents(Player player, Player.d dVar) {
            this.f22162c.onEvents(this.f22161b, dVar);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public void onIsLoadingChanged(boolean z10) {
            this.f22162c.onIsLoadingChanged(z10);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public void onIsPlayingChanged(boolean z10) {
            this.f22162c.onIsPlayingChanged(z10);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public void onLoadingChanged(boolean z10) {
            this.f22162c.onIsLoadingChanged(z10);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public void onMediaItemTransition(@Nullable w0 w0Var, int i10) {
            this.f22162c.onMediaItemTransition(w0Var, i10);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
            this.f22162c.onMediaMetadataChanged(mediaMetadata);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public void onPlayWhenReadyChanged(boolean z10, int i10) {
            this.f22162c.onPlayWhenReadyChanged(z10, i10);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public void onPlaybackParametersChanged(f1 f1Var) {
            this.f22162c.onPlaybackParametersChanged(f1Var);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public void onPlaybackStateChanged(int i10) {
            this.f22162c.onPlaybackStateChanged(i10);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public void onPlaybackSuppressionReasonChanged(int i10) {
            this.f22162c.onPlaybackSuppressionReasonChanged(i10);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public void onPlayerError(PlaybackException playbackException) {
            this.f22162c.onPlayerError(playbackException);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public void onPlayerErrorChanged(@Nullable PlaybackException playbackException) {
            this.f22162c.onPlayerErrorChanged(playbackException);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public void onPlayerStateChanged(boolean z10, int i10) {
            this.f22162c.onPlayerStateChanged(z10, i10);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public void onPositionDiscontinuity(int i10) {
            this.f22162c.onPositionDiscontinuity(i10);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public void onRepeatModeChanged(int i10) {
            this.f22162c.onRepeatModeChanged(i10);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public void onSeekProcessed() {
            this.f22162c.onSeekProcessed();
        }

        @Override // com.google.android.exoplayer2.Player.c
        public void onShuffleModeEnabledChanged(boolean z10) {
            this.f22162c.onShuffleModeEnabledChanged(z10);
        }

        @Override // com.google.android.exoplayer2.Player.c
        @Deprecated
        public void onStaticMetadataChanged(List<Metadata> list) {
            this.f22162c.onStaticMetadataChanged(list);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public void onTimelineChanged(Timeline timeline, int i10) {
            this.f22162c.onTimelineChanged(timeline, i10);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public void onTracksChanged(TrackGroupArray trackGroupArray, n6.h hVar) {
            this.f22162c.onTracksChanged(trackGroupArray, hVar);
        }

        public b(t0 t0Var, Player.c cVar) {
            this.f22161b = t0Var;
            this.f22162c = cVar;
        }

        @Override // com.google.android.exoplayer2.Player.c
        public void onPositionDiscontinuity(Player.f fVar, Player.f fVar2, int i10) {
            this.f22162c.onPositionDiscontinuity(fVar, fVar2, i10);
        }
    }

    /* compiled from: ForwardingPlayer.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c extends b implements Player.e {

        /* renamed from: d, reason: collision with root package name */
        public final Player.e f22163d;

        public c(t0 t0Var, Player.e eVar) {
            super(eVar);
            this.f22163d = eVar;
        }

        @Override // com.google.android.exoplayer2.Player.e, e6.j
        public void onCues(List<e6.a> list) {
            this.f22163d.onCues(list);
        }

        @Override // com.google.android.exoplayer2.Player.e, a5.c
        public void onDeviceInfoChanged(a5.b bVar) {
            this.f22163d.onDeviceInfoChanged(bVar);
        }

        @Override // com.google.android.exoplayer2.Player.e, a5.c
        public void onDeviceVolumeChanged(int i10, boolean z10) {
            this.f22163d.onDeviceVolumeChanged(i10, z10);
        }

        @Override // com.google.android.exoplayer2.Player.e, n5.e
        public void onMetadata(Metadata metadata) {
            this.f22163d.onMetadata(metadata);
        }

        @Override // com.google.android.exoplayer2.Player.e, q6.l
        public void onRenderedFirstFrame() {
            this.f22163d.onRenderedFirstFrame();
        }

        @Override // com.google.android.exoplayer2.Player.e, x4.f
        public void onSkipSilenceEnabledChanged(boolean z10) {
            this.f22163d.onSkipSilenceEnabledChanged(z10);
        }

        @Override // com.google.android.exoplayer2.Player.e, q6.l
        public void onSurfaceSizeChanged(int i10, int i11) {
            this.f22163d.onSurfaceSizeChanged(i10, i11);
        }

        @Override // com.google.android.exoplayer2.Player.e, q6.l
        public void onVideoSizeChanged(q6.y yVar) {
            this.f22163d.onVideoSizeChanged(yVar);
        }

        @Override // com.google.android.exoplayer2.Player.e, x4.f
        public void onVolumeChanged(float f10) {
            this.f22163d.onVolumeChanged(f10);
        }

        @Override // q6.l
        public void onVideoSizeChanged(int i10, int i11, int i12, float f10) {
            this.f22163d.onVideoSizeChanged(i10, i11, i12, f10);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public int A() {
        return this.f22160a.A();
    }

    @Override // com.google.android.exoplayer2.Player
    public void B() {
        this.f22160a.B();
    }

    @Override // com.google.android.exoplayer2.Player
    public List<e6.a> C() {
        return this.f22160a.C();
    }

    @Override // com.google.android.exoplayer2.Player
    public Timeline E() {
        return this.f22160a.E();
    }

    @Override // com.google.android.exoplayer2.Player
    public Looper F() {
        return this.f22160a.F();
    }

    @Override // com.google.android.exoplayer2.Player
    public void G() {
        this.f22160a.G();
    }

    @Override // com.google.android.exoplayer2.Player
    public void H(@Nullable TextureView textureView) {
        this.f22160a.H(textureView);
    }

    @Override // com.google.android.exoplayer2.Player
    public n6.h I() {
        return this.f22160a.I();
    }

    @Override // com.google.android.exoplayer2.Player
    public void J(int i10, long j10) {
        this.f22160a.J(i10, j10);
    }

    @Override // com.google.android.exoplayer2.Player
    public q6.y L() {
        return this.f22160a.L();
    }

    @Override // com.google.android.exoplayer2.Player
    public long M() {
        return this.f22160a.M();
    }

    @Override // com.google.android.exoplayer2.Player
    public void N(Player.e eVar) {
        this.f22160a.N(new c(this, eVar));
    }

    @Override // com.google.android.exoplayer2.Player
    public void P(@Nullable SurfaceView surfaceView) {
        this.f22160a.P(surfaceView);
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean Q() {
        return this.f22160a.Q();
    }

    @Override // com.google.android.exoplayer2.Player
    public void R() {
        this.f22160a.R();
    }

    @Override // com.google.android.exoplayer2.Player
    public MediaMetadata S() {
        return this.f22160a.S();
    }

    @Override // com.google.android.exoplayer2.Player
    public long T() {
        return this.f22160a.T();
    }

    public Player U() {
        return this.f22160a;
    }

    @Override // com.google.android.exoplayer2.Player
    public void c(f1 f1Var) {
        this.f22160a.c(f1Var);
    }

    @Override // com.google.android.exoplayer2.Player
    public f1 d() {
        return this.f22160a.d();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean f() {
        return this.f22160a.f();
    }

    @Override // com.google.android.exoplayer2.Player
    public long g() {
        return this.f22160a.g();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getCurrentPosition() {
        return this.f22160a.getCurrentPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getDuration() {
        return this.f22160a.getDuration();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPlaybackState() {
        return this.f22160a.getPlaybackState();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRepeatMode() {
        return this.f22160a.getRepeatMode();
    }

    @Override // com.google.android.exoplayer2.Player
    public void h(Player.e eVar) {
        this.f22160a.h(new c(this, eVar));
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isPlaying() {
        return this.f22160a.isPlaying();
    }

    @Override // com.google.android.exoplayer2.Player
    public void j(@Nullable SurfaceView surfaceView) {
        this.f22160a.j(surfaceView);
    }

    @Override // com.google.android.exoplayer2.Player
    @Nullable
    public PlaybackException k() {
        return this.f22160a.k();
    }

    @Override // com.google.android.exoplayer2.Player
    public int l() {
        return this.f22160a.l();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean m(int i10) {
        return this.f22160a.m(i10);
    }

    @Override // com.google.android.exoplayer2.Player
    public TrackGroupArray n() {
        return this.f22160a.n();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean o() {
        return this.f22160a.o();
    }

    @Override // com.google.android.exoplayer2.Player
    public void p(boolean z10) {
        this.f22160a.p(z10);
    }

    @Override // com.google.android.exoplayer2.Player
    public void prepare() {
        this.f22160a.prepare();
    }

    @Override // com.google.android.exoplayer2.Player
    public int s() {
        return this.f22160a.s();
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekTo(long j10) {
        this.f22160a.seekTo(j10);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlayWhenReady(boolean z10) {
        this.f22160a.setPlayWhenReady(z10);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setRepeatMode(int i10) {
        this.f22160a.setRepeatMode(i10);
    }

    @Override // com.google.android.exoplayer2.Player
    public void t(@Nullable TextureView textureView) {
        this.f22160a.t(textureView);
    }

    @Override // com.google.android.exoplayer2.Player
    public int u() {
        return this.f22160a.u();
    }

    @Override // com.google.android.exoplayer2.Player
    public long v() {
        return this.f22160a.v();
    }

    @Override // com.google.android.exoplayer2.Player
    public long w() {
        return this.f22160a.w();
    }

    @Override // com.google.android.exoplayer2.Player
    public void x() {
        this.f22160a.x();
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean y() {
        return this.f22160a.y();
    }
}
