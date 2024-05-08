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
import kotlin.jvm.internal.s;
import n6.h;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p6.n;
import q6.k;
import q6.y;

/* compiled from: ExoMediaPlayer.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ExoMediaPlayer {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ExoMediaPlayer f12408a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public static q1 f12409b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public static q1 f12410c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public static com.google.android.exoplayer2.upstream.cache.c f12411d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public static a.InterfaceC0208a f12412e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public static q1 f12413f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public static PlayerView f12414g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public static b f12415h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public static LinkedList<b> f12416i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public static PlaybackException f12417j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public static CountDownTimer f12418k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public static a f12419l;

    /* compiled from: ExoMediaPlayer.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum PlayMode {
        REPEAT,
        SINGLE
    }

    /* compiled from: ExoMediaPlayer.kt */
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

    /* compiled from: ExoMediaPlayer.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface a {
        void a(long j10);
    }

    /* compiled from: ExoMediaPlayer.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface b {
        void a(@NotNull PlayState playState);
    }

    /* compiled from: ExoMediaPlayer.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c implements Player.e {
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
            ExoMediaPlayer exoMediaPlayer = ExoMediaPlayer.f12408a;
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
            exoMediaPlayer.o(playState);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i10) {
            h1.p(this, i10);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public void onPlayerError(@NotNull PlaybackException error) {
            s.i(error, "error");
            ExoMediaPlayer exoMediaPlayer = ExoMediaPlayer.f12408a;
            ExoMediaPlayer.f12417j = error;
            exoMediaPlayer.o(PlayState.ERROR);
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
                ExoMediaPlayer.f12408a.o(PlayState.PERIOD);
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

    /* compiled from: ExoMediaPlayer.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class d extends CountDownTimer {
        public d() {
            super(ZipUtils.UPPER_UNIXTIME_BOUND, 50L);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
            a aVar;
            q1 q1Var = ExoMediaPlayer.f12413f;
            if (q1Var == null || (aVar = ExoMediaPlayer.f12419l) == null) {
                return;
            }
            aVar.a(q1Var.getCurrentPosition());
        }
    }

    static {
        ExoMediaPlayer exoMediaPlayer = new ExoMediaPlayer();
        f12408a = exoMediaPlayer;
        Context c4 = AppApplication.f11612d.c();
        if (c4 != null) {
            exoMediaPlayer.j(c4);
        }
    }

    public static /* synthetic */ PlayerView l(ExoMediaPlayer exoMediaPlayer, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return exoMediaPlayer.k(z10);
    }

    public static /* synthetic */ void s(ExoMediaPlayer exoMediaPlayer, Uri uri, boolean z10, PlayMode playMode, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        if ((i10 & 4) != 0) {
            playMode = PlayMode.REPEAT;
        }
        if ((i10 & 8) != 0) {
            z11 = true;
        }
        exoMediaPlayer.q(uri, z10, playMode, z11);
    }

    public static /* synthetic */ void t(ExoMediaPlayer exoMediaPlayer, String str, boolean z10, PlayMode playMode, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        if ((i10 & 4) != 0) {
            playMode = PlayMode.REPEAT;
        }
        if ((i10 & 8) != 0) {
            z11 = true;
        }
        exoMediaPlayer.r(str, z10, playMode, z11);
    }

    public final void e(@NotNull b listener) {
        s.i(listener, "listener");
        f12415h = null;
        if (f12416i == null) {
            f12416i = new LinkedList<>();
        }
        LinkedList<b> linkedList = f12416i;
        if (linkedList != null) {
            linkedList.add(listener);
        }
    }

    public final void f(Context context) {
        if (f12409b == null) {
            q1 z10 = new q1.b(context).A(new h0.b(new com.google.android.exoplayer2.upstream.d(context))).z();
            z10.N(f12408a.i("localMediaPlayer"));
            f12409b = z10;
        }
    }

    public final void g(Context context) {
        File B;
        if (f12410c != null || (B = z0.k.f54819a.B(context)) == null) {
            return;
        }
        if (!B.exists()) {
            B.mkdirs();
        }
        if (f12411d == null) {
            f12411d = new com.google.android.exoplayer2.upstream.cache.c(B, new n(209715200L), new y4.b(context));
        }
        com.google.android.exoplayer2.upstream.cache.c cVar = f12411d;
        if (cVar != null && f12412e == null) {
            f12412e = new a.c().d(cVar).e(2).f(new a.b(new OkHttpClient()));
        }
        a.InterfaceC0208a interfaceC0208a = f12412e;
        if (interfaceC0208a == null || f12410c != null) {
            return;
        }
        ExoMediaPlayer exoMediaPlayer = f12408a;
        q1 z10 = new q1.b(context).A(new h0.b(interfaceC0208a)).z();
        z10.N(exoMediaPlayer.i("networkMediaPlayer"));
        f12410c = z10;
    }

    public final void h(Context context, String str) {
        q1 q1Var;
        if (context != null) {
            ExoMediaPlayer exoMediaPlayer = f12408a;
            if (URLUtil.isNetworkUrl(str)) {
                exoMediaPlayer.g(context);
                q1Var = f12410c;
            } else {
                exoMediaPlayer.f(context);
                q1Var = f12409b;
            }
            f12413f = q1Var;
            exoMediaPlayer.j(context);
        }
    }

    public final Player.e i(String str) {
        return new c();
    }

    public final void j(Context context) {
        if (f12414g == null) {
            PlayerView playerView = new PlayerView(context);
            playerView.setUseController(false);
            playerView.setKeepContentOnPlayerReset(true);
            f12414g = playerView;
        }
    }

    @Nullable
    public final PlayerView k(boolean z10) {
        PlayerView playerView = f12414g;
        ViewParent parent = playerView != null ? playerView.getParent() : null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        PlayerView playerView2 = f12414g;
        if (playerView2 != null) {
            playerView2.setResizeMode(z10 ? 4 : 0);
        }
        return f12414g;
    }

    public final void m() {
        if (f12418k != null) {
            return;
        }
        u();
        f12418k = new d().start();
    }

    public final void n(boolean z10) {
        q1 q1Var = f12413f;
        if (q1Var != null) {
            q1Var.setVolume(z10 ? 0.0f : 1.0f);
        }
    }

    public final void o(PlayState playState) {
        b removeFirst;
        Iterator<b> it;
        b bVar = f12415h;
        if (bVar != null) {
            bVar.a(playState);
        }
        LinkedList<b> linkedList = f12416i;
        if (linkedList == null || linkedList.isEmpty()) {
            return;
        }
        if (playState != PlayState.IDLE && playState != PlayState.ENDED) {
            LinkedList<b> linkedList2 = f12416i;
            if (linkedList2 == null || (it = linkedList2.iterator2()) == null) {
                return;
            }
            while (it.hasNext()) {
                it.next().a(playState);
            }
            return;
        }
        LinkedList<b> linkedList3 = f12416i;
        if (linkedList3 == null || (removeFirst = linkedList3.removeFirst()) == null) {
            return;
        }
        removeFirst.a(playState);
    }

    public final void p() {
        q1 q1Var;
        q1 q1Var2 = f12413f;
        if (((q1Var2 == null || q1Var2.o()) ? false : true) || (q1Var = f12413f) == null) {
            return;
        }
        q1Var.setPlayWhenReady(false);
    }

    public final void q(@Nullable Uri uri, boolean z10, @NotNull PlayMode mode, boolean z11) {
        s.i(mode, "mode");
        if (uri != null) {
            String uri2 = uri.toString();
            s.h(uri2, "it.toString()");
            if (uri2.length() > 0) {
                ExoMediaPlayer exoMediaPlayer = f12408a;
                exoMediaPlayer.z();
                exoMediaPlayer.h(AppApplication.f11612d.c(), uri2);
                q1 q1Var = f12413f;
                if (q1Var != null) {
                    q1Var.setVolume(z10 ? 0.0f : 1.0f);
                    q1Var.setRepeatMode(mode != PlayMode.REPEAT ? 0 : 1);
                    q1Var.h0(w0.b(uri));
                    q1Var.prepare();
                    q1Var.setPlayWhenReady(z11);
                }
                PlayerView playerView = f12414g;
                if (playerView == null) {
                    return;
                }
                playerView.setPlayer(f12413f);
            }
        }
    }

    public final void r(@Nullable String str, boolean z10, @NotNull PlayMode mode, boolean z11) {
        s.i(mode, "mode");
        if (str == null || str.length() == 0) {
            return;
        }
        q(Uri.parse(str), z10, mode, z11);
    }

    public final void u() {
        CountDownTimer countDownTimer = f12418k;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        f12418k = null;
    }

    public final void v() {
        q1 q1Var;
        q1 q1Var2 = f12413f;
        boolean z10 = false;
        if (q1Var2 != null && q1Var2.o()) {
            z10 = true;
        }
        if (z10 || (q1Var = f12413f) == null) {
            return;
        }
        q1Var.setPlayWhenReady(true);
    }

    public final void w(long j10) {
        q1 q1Var = f12413f;
        if (q1Var != null) {
            q1Var.seekTo(q1Var.getDuration() != -9223372036854775807L ? Math.min(Math.max(0L, j10), q1Var.getDuration()) : 0L);
        }
    }

    public final void x(@Nullable a aVar) {
        f12419l = aVar;
    }

    public final void y(@NotNull b listener) {
        s.i(listener, "listener");
        f12416i = null;
        f12415h = listener;
    }

    public final void z() {
        q1 q1Var = f12413f;
        if (q1Var != null) {
            q1Var.stop();
        }
    }
}
