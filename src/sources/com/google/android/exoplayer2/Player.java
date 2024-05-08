package com.google.android.exoplayer2;

import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.util.FlagSet;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface Player {

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public @interface Event {
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {

        /* renamed from: b, reason: collision with root package name */
        public static final b f19636b = new a().e();

        /* renamed from: c, reason: collision with root package name */
        public static final g<b> f19637c = a5.a.f700a;

        /* renamed from: a, reason: collision with root package name */
        public final FlagSet f19638a;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public static final class a {

            /* renamed from: b, reason: collision with root package name */
            public static final int[] f19639b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27};

            /* renamed from: a, reason: collision with root package name */
            public final FlagSet.b f19640a = new FlagSet.b();

            public a a(int i10) {
                this.f19640a.a(i10);
                return this;
            }

            public a b(b bVar) {
                this.f19640a.b(bVar.f19638a);
                return this;
            }

            public a c(int... iArr) {
                this.f19640a.c(iArr);
                return this;
            }

            public a d(int i10, boolean z10) {
                this.f19640a.d(i10, z10);
                return this;
            }

            public b e() {
                return new b(this.f19640a.e());
            }
        }

        public boolean b(int i10) {
            return this.f19638a.a(i10);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                return this.f19638a.equals(((b) obj).f19638a);
            }
            return false;
        }

        public int hashCode() {
            return this.f19638a.hashCode();
        }

        public b(FlagSet flagSet) {
            this.f19638a = flagSet;
        }
    }

    @Deprecated
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface c {
        void onAvailableCommandsChanged(b bVar);

        void onEvents(Player player, d dVar);

        void onIsLoadingChanged(boolean z10);

        void onIsPlayingChanged(boolean z10);

        @Deprecated
        void onLoadingChanged(boolean z10);

        void onMediaItemTransition(@Nullable w0 w0Var, int i10);

        void onMediaMetadataChanged(MediaMetadata mediaMetadata);

        void onPlayWhenReadyChanged(boolean z10, int i10);

        void onPlaybackParametersChanged(f1 f1Var);

        void onPlaybackStateChanged(int i10);

        void onPlaybackSuppressionReasonChanged(int i10);

        void onPlayerError(PlaybackException playbackException);

        void onPlayerErrorChanged(@Nullable PlaybackException playbackException);

        @Deprecated
        void onPlayerStateChanged(boolean z10, int i10);

        @Deprecated
        void onPositionDiscontinuity(int i10);

        void onPositionDiscontinuity(f fVar, f fVar2, int i10);

        void onRepeatModeChanged(int i10);

        @Deprecated
        void onSeekProcessed();

        void onShuffleModeEnabledChanged(boolean z10);

        @Deprecated
        void onStaticMetadataChanged(List<Metadata> list);

        void onTimelineChanged(Timeline timeline, int i10);

        void onTracksChanged(TrackGroupArray trackGroupArray, n6.h hVar);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final FlagSet f19641a;

        public d(FlagSet flagSet) {
            this.f19641a = flagSet;
        }

        public boolean a(int i10) {
            return this.f19641a.a(i10);
        }

        public boolean b(int... iArr) {
            return this.f19641a.b(iArr);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof d) {
                return this.f19641a.equals(((d) obj).f19641a);
            }
            return false;
        }

        public int hashCode() {
            return this.f19641a.hashCode();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface e extends q6.l, x4.f, e6.j, n5.e, a5.c, c {
        void onCues(List<e6.a> list);

        void onDeviceInfoChanged(a5.b bVar);

        void onDeviceVolumeChanged(int i10, boolean z10);

        void onMetadata(Metadata metadata);

        @Override // q6.l
        void onRenderedFirstFrame();

        void onSkipSilenceEnabledChanged(boolean z10);

        @Override // q6.l
        void onSurfaceSizeChanged(int i10, int i11);

        @Override // q6.l
        void onVideoSizeChanged(q6.y yVar);

        void onVolumeChanged(float f10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class f {

        /* renamed from: i, reason: collision with root package name */
        public static final g<f> f19642i = a5.a.f700a;

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        public final Object f19643a;

        /* renamed from: b, reason: collision with root package name */
        public final int f19644b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        public final Object f19645c;

        /* renamed from: d, reason: collision with root package name */
        public final int f19646d;

        /* renamed from: e, reason: collision with root package name */
        public final long f19647e;

        /* renamed from: f, reason: collision with root package name */
        public final long f19648f;

        /* renamed from: g, reason: collision with root package name */
        public final int f19649g;

        /* renamed from: h, reason: collision with root package name */
        public final int f19650h;

        public f(@Nullable Object obj, int i10, @Nullable Object obj2, int i11, long j10, long j11, int i12, int i13) {
            this.f19643a = obj;
            this.f19644b = i10;
            this.f19645c = obj2;
            this.f19646d = i11;
            this.f19647e = j10;
            this.f19648f = j11;
            this.f19649g = i12;
            this.f19650h = i13;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || f.class != obj.getClass()) {
                return false;
            }
            f fVar = (f) obj;
            return this.f19644b == fVar.f19644b && this.f19646d == fVar.f19646d && this.f19647e == fVar.f19647e && this.f19648f == fVar.f19648f && this.f19649g == fVar.f19649g && this.f19650h == fVar.f19650h && com.google.common.base.l.a(this.f19643a, fVar.f19643a) && com.google.common.base.l.a(this.f19645c, fVar.f19645c);
        }

        public int hashCode() {
            return com.google.common.base.l.b(this.f19643a, Integer.valueOf(this.f19644b), this.f19645c, Integer.valueOf(this.f19646d), Integer.valueOf(this.f19644b), Long.valueOf(this.f19647e), Long.valueOf(this.f19648f), Integer.valueOf(this.f19649g), Integer.valueOf(this.f19650h));
        }
    }

    int A();

    void B();

    List<e6.a> C();

    int D();

    Timeline E();

    Looper F();

    void G();

    void H(@Nullable TextureView textureView);

    n6.h I();

    void J(int i10, long j10);

    b K();

    q6.y L();

    long M();

    void N(e eVar);

    long O();

    void P(@Nullable SurfaceView surfaceView);

    boolean Q();

    void R();

    MediaMetadata S();

    long T();

    void c(f1 f1Var);

    f1 d();

    void e(@Nullable Surface surface);

    boolean f();

    long g();

    long getCurrentPosition();

    long getDuration();

    int getPlaybackState();

    int getRepeatMode();

    void h(e eVar);

    void i(List<w0> list, boolean z10);

    boolean isPlaying();

    void j(@Nullable SurfaceView surfaceView);

    @Nullable
    PlaybackException k();

    int l();

    boolean m(int i10);

    TrackGroupArray n();

    boolean o();

    void p(boolean z10);

    void prepare();

    @Deprecated
    void q(boolean z10);

    int r();

    void release();

    int s();

    void seekTo(long j10);

    void setPlayWhenReady(boolean z10);

    void setRepeatMode(int i10);

    void setVolume(float f10);

    void stop();

    void t(@Nullable TextureView textureView);

    int u();

    long v();

    long w();

    void x();

    boolean y();

    void z();
}
