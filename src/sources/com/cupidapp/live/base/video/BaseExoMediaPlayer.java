package com.cupidapp.live.base.video;

import android.content.Context;
import android.net.Uri;
import android.os.CountDownTimer;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.URLUtil;
import c5.a;
import com.cupidapp.live.AppApplication;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.f1;
import com.google.android.exoplayer2.g1;
import com.google.android.exoplayer2.h1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.q1;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.h0;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.cache.a;
import com.google.android.exoplayer2.w0;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipUtils;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import n6.h;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p6.n;
import q6.k;
import q6.y;

/* compiled from: BaseExoMediaPlayer.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class BaseExoMediaPlayer {

    /* renamed from: l */
    @NotNull
    public static final a f12394l = new a(null);

    /* renamed from: a */
    @Nullable
    public q1 f12395a;

    /* renamed from: b */
    @Nullable
    public q1 f12396b;

    /* renamed from: c */
    @Nullable
    public com.google.android.exoplayer2.upstream.cache.c f12397c;

    /* renamed from: d */
    @Nullable
    public a.InterfaceC0208a f12398d;

    /* renamed from: e */
    @Nullable
    public q1 f12399e;

    /* renamed from: f */
    @Nullable
    public PlayerView f12400f;

    /* renamed from: g */
    @Nullable
    public c f12401g;

    /* renamed from: h */
    @Nullable
    public LinkedList<c> f12402h;

    /* renamed from: i */
    @Nullable
    public PlaybackException f12403i;

    /* renamed from: j */
    @Nullable
    public CountDownTimer f12404j;

    /* renamed from: k */
    @Nullable
    public b f12405k;

    /* compiled from: BaseExoMediaPlayer.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum PlayMode {
        REPEAT,
        SINGLE
    }

    /* compiled from: BaseExoMediaPlayer.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum PlayState {
        ERROR,
        IDLE,
        BUFFERING,
        READY,
        PERIOD,
        ENDED
    }

    /* compiled from: BaseExoMediaPlayer.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: BaseExoMediaPlayer.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface b {
        void a(long j10);
    }

    /* compiled from: BaseExoMediaPlayer.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface c {
        void a(@NotNull PlayState playState);
    }

    /* compiled from: BaseExoMediaPlayer.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class d implements Player.e {
        public d() {
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onAvailableCommandsChanged(Player.b bVar) {
            h1.c(this, bVar);
        }

        @Override // com.google.android.exoplayer2.Player.e, e6.j
        public /* synthetic */ void onCues(List list) {
            h1.d(this, list);
        }

        @Override // com.google.android.exoplayer2.Player.e, a5.c
        public /* synthetic */ void onDeviceInfoChanged(a5.b bVar) {
            h1.e(this, bVar);
        }

        @Override // com.google.android.exoplayer2.Player.e, a5.c
        public /* synthetic */ void onDeviceVolumeChanged(int i10, boolean z10) {
            h1.f(this, i10, z10);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onEvents(Player player, Player.d dVar) {
            h1.g(this, player, dVar);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onIsLoadingChanged(boolean z10) {
            h1.h(this, z10);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onIsPlayingChanged(boolean z10) {
            h1.i(this, z10);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onLoadingChanged(boolean z10) {
            g1.d(this, z10);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onMediaItemTransition(w0 w0Var, int i10) {
            h1.j(this, w0Var, i10);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
            h1.k(this, mediaMetadata);
        }

        @Override // com.google.android.exoplayer2.Player.e, n5.e
        public /* synthetic */ void onMetadata(Metadata metadata) {
            h1.l(this, metadata);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onPlayWhenReadyChanged(boolean z10, int i10) {
            h1.m(this, z10, i10);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onPlaybackParametersChanged(f1 f1Var) {
            h1.n(this, f1Var);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public void onPlaybackStateChanged(int i10) {
            PlayState playState;
            BaseExoMediaPlayer baseExoMediaPlayer = BaseExoMediaPlayer.this;
            if (i10 == 1) {
                playState = PlayState.IDLE;
            } else if (i10 == 2) {
                playState = PlayState.BUFFERING;
            } else if (i10 == 3) {
                playState = PlayState.READY;
            } else if (i10 != 4) {
                playState = PlayState.ERROR;
            } else {
                playState = PlayState.ENDED;
            }
            baseExoMediaPlayer.m(playState);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i10) {
            h1.p(this, i10);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public void onPlayerError(@NotNull PlaybackException error) {
            s.i(error, "error");
            BaseExoMediaPlayer.this.f12403i = error;
            BaseExoMediaPlayer.this.m(PlayState.ERROR);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onPlayerErrorChanged(PlaybackException playbackException) {
            h1.r(this, playbackException);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onPlayerStateChanged(boolean z10, int i10) {
            g1.l(this, z10, i10);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onPositionDiscontinuity(int i10) {
            g1.m(this, i10);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public void onPositionDiscontinuity(@NotNull Player.f oldPosition, @NotNull Player.f newPosition, int i10) {
            s.i(oldPosition, "oldPosition");
            s.i(newPosition, "newPosition");
            if (i10 == 0) {
                BaseExoMediaPlayer.this.m(PlayState.PERIOD);
            }
        }

        @Override // com.google.android.exoplayer2.Player.e, q6.l
        public /* synthetic */ void onRenderedFirstFrame() {
            h1.u(this);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onRepeatModeChanged(int i10) {
            h1.v(this, i10);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onSeekProcessed() {
            g1.p(this);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onShuffleModeEnabledChanged(boolean z10) {
            h1.y(this, z10);
        }

        @Override // com.google.android.exoplayer2.Player.e, x4.f
        public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z10) {
            h1.z(this, z10);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onStaticMetadataChanged(List list) {
            g1.r(this, list);
        }

        @Override // com.google.android.exoplayer2.Player.e, q6.l
        public /* synthetic */ void onSurfaceSizeChanged(int i10, int i11) {
            h1.A(this, i10, i11);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onTimelineChanged(Timeline timeline, int i10) {
            h1.B(this, timeline, i10);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onTracksChanged(TrackGroupArray trackGroupArray, h hVar) {
            h1.C(this, trackGroupArray, hVar);
        }

        @Override // q6.l
        public /* synthetic */ void onVideoSizeChanged(int i10, int i11, int i12, float f10) {
            k.a(this, i10, i11, i12, f10);
        }

        @Override // com.google.android.exoplayer2.Player.e, q6.l
        public /* synthetic */ void onVideoSizeChanged(y yVar) {
            h1.D(this, yVar);
        }

        @Override // com.google.android.exoplayer2.Player.e, x4.f
        public /* synthetic */ void onVolumeChanged(float f10) {
            h1.E(this, f10);
        }
    }

    /* compiled from: BaseExoMediaPlayer.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class e extends CountDownTimer {
        public e() {
            super(ZipUtils.UPPER_UNIXTIME_BOUND, 50L);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
            b bVar;
            q1 q1Var = BaseExoMediaPlayer.this.f12399e;
            if (q1Var == null || (bVar = BaseExoMediaPlayer.this.f12405k) == null) {
                return;
            }
            bVar.a(q1Var.getCurrentPosition());
        }
    }

    public BaseExoMediaPlayer() {
        Context c4 = AppApplication.f11612d.c();
        if (c4 != null) {
            j(c4);
        }
    }

    public static /* synthetic */ void q(BaseExoMediaPlayer baseExoMediaPlayer, String str, boolean z10, PlayMode playMode, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        if ((i10 & 4) != 0) {
            playMode = PlayMode.REPEAT;
        }
        if ((i10 & 8) != 0) {
            z11 = true;
        }
        baseExoMediaPlayer.p(str, z10, playMode, z11);
    }

    public final void A(@NotNull c listener) {
        s.i(listener, "listener");
        this.f12402h = null;
        this.f12401g = listener;
    }

    public final void B() {
        q1 q1Var = this.f12399e;
        if (q1Var != null) {
            q1Var.stop();
        }
    }

    public final void e(@NotNull c listener) {
        s.i(listener, "listener");
        this.f12401g = null;
        if (this.f12402h == null) {
            this.f12402h = new LinkedList<>();
        }
        LinkedList<c> linkedList = this.f12402h;
        if (linkedList != null) {
            linkedList.add(listener);
        }
    }

    public final void f(Context context) {
        if (this.f12395a == null) {
            q1 z10 = new q1.b(context).A(new h0.b(new com.google.android.exoplayer2.upstream.d(context))).z();
            z10.N(i("localMediaPlayer"));
            this.f12395a = z10;
        }
    }

    public final void g(Context context) {
        File B;
        if (this.f12396b != null || (B = z0.k.f54819a.B(context)) == null) {
            return;
        }
        if (!B.exists()) {
            B.mkdirs();
        }
        if (this.f12397c == null) {
            this.f12397c = new com.google.android.exoplayer2.upstream.cache.c(B, new n(209715200L), new y4.b(context));
        }
        com.google.android.exoplayer2.upstream.cache.c cVar = this.f12397c;
        if (cVar != null && this.f12398d == null) {
            this.f12398d = new a.c().d(cVar).e(2).f(new a.b(new OkHttpClient()));
        }
        a.InterfaceC0208a interfaceC0208a = this.f12398d;
        if (interfaceC0208a == null || this.f12396b != null) {
            return;
        }
        q1 z10 = new q1.b(context).A(new h0.b(interfaceC0208a)).z();
        z10.N(i("networkMediaPlayer"));
        this.f12396b = z10;
    }

    public final void h(Context context, String str) {
        q1 q1Var;
        if (context != null) {
            if (URLUtil.isNetworkUrl(str)) {
                g(context);
                q1Var = this.f12396b;
            } else {
                f(context);
                q1Var = this.f12395a;
            }
            this.f12399e = q1Var;
            j(context);
        }
    }

    public final Player.e i(String str) {
        return new d();
    }

    public final void j(Context context) {
        if (this.f12400f == null) {
            PlayerView playerView = new PlayerView(context);
            playerView.setUseController(false);
            playerView.setKeepContentOnPlayerReset(true);
            this.f12400f = playerView;
        }
    }

    @Nullable
    public final PlayerView k(boolean z10) {
        PlayerView playerView = this.f12400f;
        ViewParent parent = playerView != null ? playerView.getParent() : null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        PlayerView playerView2 = this.f12400f;
        if (playerView2 != null) {
            playerView2.setResizeMode(z10 ? 4 : 0);
        }
        return this.f12400f;
    }

    public final void l() {
        if (this.f12404j != null) {
            return;
        }
        w();
        this.f12404j = new e().start();
    }

    public final void m(PlayState playState) {
        c removeFirst;
        Iterator<c> it;
        c cVar = this.f12401g;
        if (cVar != null) {
            cVar.a(playState);
        }
        LinkedList<c> linkedList = this.f12402h;
        if (linkedList == null || linkedList.isEmpty()) {
            return;
        }
        if (playState != PlayState.IDLE && playState != PlayState.ENDED) {
            LinkedList<c> linkedList2 = this.f12402h;
            if (linkedList2 == null || (it = linkedList2.iterator2()) == null) {
                return;
            }
            while (it.hasNext()) {
                it.next().a(playState);
            }
            return;
        }
        LinkedList<c> linkedList3 = this.f12402h;
        if (linkedList3 == null || (removeFirst = linkedList3.removeFirst()) == null) {
            return;
        }
        removeFirst.a(playState);
    }

    public final void n() {
        q1 q1Var;
        q1 q1Var2 = this.f12399e;
        if (((q1Var2 == null || q1Var2.o()) ? false : true) || (q1Var = this.f12399e) == null) {
            return;
        }
        q1Var.setPlayWhenReady(false);
    }

    public final void o(@Nullable Uri uri, boolean z10, @NotNull PlayMode mode, boolean z11) {
        s.i(mode, "mode");
        if (uri != null) {
            String uri2 = uri.toString();
            s.h(uri2, "it.toString()");
            if (uri2.length() > 0) {
                B();
                h(AppApplication.f11612d.c(), uri2);
                q1 q1Var = this.f12399e;
                if (q1Var != null) {
                    q1Var.setVolume(z10 ? 0.0f : 1.0f);
                    q1Var.setRepeatMode(mode != PlayMode.REPEAT ? 0 : 1);
                    q1Var.h0(w0.b(uri));
                    q1Var.prepare();
                    q1Var.setPlayWhenReady(z11);
                }
                PlayerView playerView = this.f12400f;
                if (playerView == null) {
                    return;
                }
                playerView.setPlayer(this.f12399e);
            }
        }
    }

    public final void p(@Nullable String str, boolean z10, @NotNull PlayMode mode, boolean z11) {
        s.i(mode, "mode");
        if (str == null || str.length() == 0) {
            return;
        }
        o(Uri.parse(str), z10, mode, z11);
    }

    public final void r() {
        w();
        this.f12399e = null;
        v();
        s();
        t();
    }

    public final void s() {
        u(this.f12395a);
        this.f12395a = null;
    }

    public final void t() {
        u(this.f12396b);
        this.f12396b = null;
        com.google.android.exoplayer2.upstream.cache.c cVar = this.f12397c;
        if (cVar != null) {
            cVar.y();
        }
        this.f12397c = null;
        this.f12398d = null;
    }

    public final void u(q1 q1Var) {
        if (q1Var != null) {
            q1Var.stop();
            q1Var.release();
        }
    }

    public final void v() {
        this.f12400f = null;
    }

    public final void w() {
        CountDownTimer countDownTimer = this.f12404j;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.f12404j = null;
    }

    public final void x() {
        q1 q1Var;
        q1 q1Var2 = this.f12399e;
        boolean z10 = false;
        if (q1Var2 != null && q1Var2.o()) {
            z10 = true;
        }
        if (z10 || (q1Var = this.f12399e) == null) {
            return;
        }
        q1Var.setPlayWhenReady(true);
    }

    public final void y(long j10) {
        q1 q1Var = this.f12399e;
        if (q1Var != null) {
            q1Var.seekTo(q1Var.getDuration() != -9223372036854775807L ? Math.min(Math.max(0L, j10), q1Var.getDuration()) : 0L);
        }
    }

    public final void z(@Nullable b bVar) {
        this.f12405k = bVar;
    }
}
