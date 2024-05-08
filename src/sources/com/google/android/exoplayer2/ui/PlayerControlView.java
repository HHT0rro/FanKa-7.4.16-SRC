package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.f1;
import com.google.android.exoplayer2.g1;
import com.google.android.exoplayer2.h1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.r0;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.ui.m0;
import com.google.android.exoplayer2.w0;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class PlayerControlView extends FrameLayout {
    public final String A;
    public final Drawable B;
    public final Drawable C;
    public final float D;
    public final float E;
    public final String F;
    public final String G;

    @Nullable
    public Player H;
    public com.google.android.exoplayer2.i I;

    @Nullable
    public d J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public int O;
    public int P;
    public int Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public boolean U;
    public boolean V;
    public long W;

    /* renamed from: a0, reason: collision with root package name */
    public long[] f22392a0;

    /* renamed from: b, reason: collision with root package name */
    public final c f22393b;

    /* renamed from: b0, reason: collision with root package name */
    public boolean[] f22394b0;

    /* renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList<e> f22395c;

    /* renamed from: c0, reason: collision with root package name */
    public long[] f22396c0;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final View f22397d;

    /* renamed from: d0, reason: collision with root package name */
    public boolean[] f22398d0;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public final View f22399e;

    /* renamed from: e0, reason: collision with root package name */
    public long f22400e0;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public final View f22401f;

    /* renamed from: f0, reason: collision with root package name */
    public long f22402f0;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public final View f22403g;

    /* renamed from: g0, reason: collision with root package name */
    public long f22404g0;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public final View f22405h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public final View f22406i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public final ImageView f22407j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public final ImageView f22408k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public final View f22409l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public final TextView f22410m;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    public final TextView f22411n;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    public final m0 f22412o;

    /* renamed from: p, reason: collision with root package name */
    public final StringBuilder f22413p;

    /* renamed from: q, reason: collision with root package name */
    public final Formatter f22414q;

    /* renamed from: r, reason: collision with root package name */
    public final Timeline.b f22415r;

    /* renamed from: s, reason: collision with root package name */
    public final Timeline.c f22416s;

    /* renamed from: t, reason: collision with root package name */
    public final Runnable f22417t;

    /* renamed from: u, reason: collision with root package name */
    public final Runnable f22418u;

    /* renamed from: v, reason: collision with root package name */
    public final Drawable f22419v;

    /* renamed from: w, reason: collision with root package name */
    public final Drawable f22420w;

    /* renamed from: x, reason: collision with root package name */
    public final Drawable f22421x;

    /* renamed from: y, reason: collision with root package name */
    public final String f22422y;

    /* renamed from: z, reason: collision with root package name */
    public final String f22423z;

    @RequiresApi(21)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {
        @DoNotInline
        public static boolean a(View view) {
            return view.isAccessibilityFocused();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class c implements Player.e, m0.a, View.OnClickListener {
        public c() {
        }

        @Override // com.google.android.exoplayer2.ui.m0.a
        public void a(m0 m0Var, long j10, boolean z10) {
            PlayerControlView.this.N = false;
            if (z10 || PlayerControlView.this.H == null) {
                return;
            }
            PlayerControlView playerControlView = PlayerControlView.this;
            playerControlView.O(playerControlView.H, j10);
        }

        @Override // com.google.android.exoplayer2.ui.m0.a
        public void b(m0 m0Var, long j10) {
            if (PlayerControlView.this.f22411n != null) {
                PlayerControlView.this.f22411n.setText(com.google.android.exoplayer2.util.j0.d0(PlayerControlView.this.f22413p, PlayerControlView.this.f22414q, j10));
            }
        }

        @Override // com.google.android.exoplayer2.ui.m0.a
        public void c(m0 m0Var, long j10) {
            PlayerControlView.this.N = true;
            if (PlayerControlView.this.f22411n != null) {
                PlayerControlView.this.f22411n.setText(com.google.android.exoplayer2.util.j0.d0(PlayerControlView.this.f22413p, PlayerControlView.this.f22414q, j10));
            }
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onAvailableCommandsChanged(Player.b bVar) {
            h1.c(this, bVar);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Player player = PlayerControlView.this.H;
            if (player == null) {
                return;
            }
            if (PlayerControlView.this.f22399e == view) {
                PlayerControlView.this.I.i(player);
                return;
            }
            if (PlayerControlView.this.f22397d == view) {
                PlayerControlView.this.I.h(player);
                return;
            }
            if (PlayerControlView.this.f22405h == view) {
                if (player.getPlaybackState() != 4) {
                    PlayerControlView.this.I.e(player);
                    return;
                }
                return;
            }
            if (PlayerControlView.this.f22406i == view) {
                PlayerControlView.this.I.k(player);
                return;
            }
            if (PlayerControlView.this.f22401f == view) {
                PlayerControlView.this.D(player);
                return;
            }
            if (PlayerControlView.this.f22403g == view) {
                PlayerControlView.this.C(player);
            } else if (PlayerControlView.this.f22407j == view) {
                PlayerControlView.this.I.d(player, com.google.android.exoplayer2.util.w.a(player.getRepeatMode(), PlayerControlView.this.Q));
            } else if (PlayerControlView.this.f22408k == view) {
                PlayerControlView.this.I.c(player, !player.Q());
            }
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
        public void onEvents(Player player, Player.d dVar) {
            if (dVar.b(5, 6)) {
                PlayerControlView.this.U();
            }
            if (dVar.b(5, 6, 8)) {
                PlayerControlView.this.V();
            }
            if (dVar.a(9)) {
                PlayerControlView.this.W();
            }
            if (dVar.a(10)) {
                PlayerControlView.this.X();
            }
            if (dVar.b(9, 10, 12, 0, 14)) {
                PlayerControlView.this.T();
            }
            if (dVar.b(12, 0)) {
                PlayerControlView.this.Y();
            }
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
        public /* synthetic */ void onPlaybackStateChanged(int i10) {
            h1.o(this, i10);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i10) {
            h1.p(this, i10);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onPlayerError(PlaybackException playbackException) {
            h1.q(this, playbackException);
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
        public /* synthetic */ void onPositionDiscontinuity(Player.f fVar, Player.f fVar2, int i10) {
            h1.t(this, fVar, fVar2, i10);
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
        public /* synthetic */ void onTracksChanged(TrackGroupArray trackGroupArray, n6.h hVar) {
            h1.C(this, trackGroupArray, hVar);
        }

        @Override // q6.l
        public /* synthetic */ void onVideoSizeChanged(int i10, int i11, int i12, float f10) {
            q6.k.a(this, i10, i11, i12, f10);
        }

        @Override // com.google.android.exoplayer2.Player.e, q6.l
        public /* synthetic */ void onVideoSizeChanged(q6.y yVar) {
            h1.D(this, yVar);
        }

        @Override // com.google.android.exoplayer2.Player.e, x4.f
        public /* synthetic */ void onVolumeChanged(float f10) {
            h1.E(this, f10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface d {
        void onProgressUpdate(long j10, long j11);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface e {
        void a(int i10);
    }

    static {
        r0.a("goog.exo.ui");
    }

    public PlayerControlView(Context context) {
        this(context, null);
    }

    public static boolean A(Timeline timeline, Timeline.c cVar) {
        if (timeline.p() > 100) {
            return false;
        }
        int p10 = timeline.p();
        for (int i10 = 0; i10 < p10; i10++) {
            if (timeline.n(i10, cVar).f19680n == -9223372036854775807L) {
                return false;
            }
        }
        return true;
    }

    public static int F(TypedArray typedArray, int i10) {
        return typedArray.getInt(R$styleable.PlayerControlView_repeat_toggle_modes, i10);
    }

    public static boolean I(int i10) {
        return i10 == 90 || i10 == 89 || i10 == 85 || i10 == 79 || i10 == 126 || i10 == 127 || i10 == 87 || i10 == 88;
    }

    public boolean B(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        Player player = this.H;
        if (player == null || !I(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() != 0) {
            return true;
        }
        if (keyCode == 90) {
            if (player.getPlaybackState() == 4) {
                return true;
            }
            this.I.e(player);
            return true;
        }
        if (keyCode == 89) {
            this.I.k(player);
            return true;
        }
        if (keyEvent.getRepeatCount() != 0) {
            return true;
        }
        if (keyCode == 79 || keyCode == 85) {
            E(player);
            return true;
        }
        if (keyCode == 87) {
            this.I.i(player);
            return true;
        }
        if (keyCode == 88) {
            this.I.h(player);
            return true;
        }
        if (keyCode == 126) {
            D(player);
            return true;
        }
        if (keyCode != 127) {
            return true;
        }
        C(player);
        return true;
    }

    public final void C(Player player) {
        this.I.j(player, false);
    }

    public final void D(Player player) {
        int playbackState = player.getPlaybackState();
        if (playbackState == 1) {
            this.I.g(player);
        } else if (playbackState == 4) {
            N(player, player.A(), -9223372036854775807L);
        }
        this.I.j(player, true);
    }

    public final void E(Player player) {
        int playbackState = player.getPlaybackState();
        if (playbackState != 1 && playbackState != 4 && player.o()) {
            C(player);
        } else {
            D(player);
        }
    }

    public void G() {
        if (J()) {
            setVisibility(8);
            Iterator<e> iterator2 = this.f22395c.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().a(getVisibility());
            }
            removeCallbacks(this.f22417t);
            removeCallbacks(this.f22418u);
            this.W = -9223372036854775807L;
        }
    }

    public final void H() {
        removeCallbacks(this.f22418u);
        if (this.O > 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            int i10 = this.O;
            this.W = uptimeMillis + i10;
            if (this.K) {
                postDelayed(this.f22418u, i10);
                return;
            }
            return;
        }
        this.W = -9223372036854775807L;
    }

    public boolean J() {
        return getVisibility() == 0;
    }

    public void K(e eVar) {
        this.f22395c.remove(eVar);
    }

    public final void L() {
        View view;
        View view2;
        boolean P = P();
        if (!P && (view2 = this.f22401f) != null) {
            view2.sendAccessibilityEvent(8);
        } else {
            if (!P || (view = this.f22403g) == null) {
                return;
            }
            view.sendAccessibilityEvent(8);
        }
    }

    public final void M() {
        View view;
        View view2;
        boolean P = P();
        if (!P && (view2 = this.f22401f) != null) {
            view2.requestFocus();
        } else {
            if (!P || (view = this.f22403g) == null) {
                return;
            }
            view.requestFocus();
        }
    }

    public final boolean N(Player player, int i10, long j10) {
        return this.I.b(player, i10, j10);
    }

    public final void O(Player player, long j10) {
        int A;
        Timeline E = player.E();
        if (this.M && !E.q()) {
            int p10 = E.p();
            A = 0;
            while (true) {
                long d10 = E.n(A, this.f22416s).d();
                if (j10 < d10) {
                    break;
                }
                if (A == p10 - 1) {
                    j10 = d10;
                    break;
                } else {
                    j10 -= d10;
                    A++;
                }
            }
        } else {
            A = player.A();
        }
        N(player, A, j10);
        V();
    }

    public final boolean P() {
        Player player = this.H;
        return (player == null || player.getPlaybackState() == 4 || this.H.getPlaybackState() == 1 || !this.H.o()) ? false : true;
    }

    public void Q() {
        if (!J()) {
            setVisibility(0);
            Iterator<e> iterator2 = this.f22395c.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().a(getVisibility());
            }
            R();
            M();
            L();
        }
        H();
    }

    public final void R() {
        U();
        T();
        W();
        X();
        Y();
    }

    public final void S(boolean z10, boolean z11, @Nullable View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(z11);
        view.setAlpha(z11 ? this.D : this.E);
        view.setVisibility(z10 ? 0 : 8);
    }

    public final void T() {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (J() && this.K) {
            Player player = this.H;
            boolean z14 = false;
            if (player != null) {
                boolean m10 = player.m(4);
                boolean m11 = player.m(6);
                z13 = player.m(10) && this.I.f();
                if (player.m(11) && this.I.l()) {
                    z14 = true;
                }
                z11 = player.m(8);
                z10 = z14;
                z14 = m11;
                z12 = m10;
            } else {
                z10 = false;
                z11 = false;
                z12 = false;
                z13 = false;
            }
            S(this.T, z14, this.f22397d);
            S(this.R, z13, this.f22406i);
            S(this.S, z10, this.f22405h);
            S(this.U, z11, this.f22399e);
            m0 m0Var = this.f22412o;
            if (m0Var != null) {
                m0Var.setEnabled(z12);
            }
        }
    }

    public final void U() {
        boolean z10;
        boolean z11;
        boolean z12;
        if (J() && this.K) {
            boolean P = P();
            View view = this.f22401f;
            boolean z13 = true;
            if (view != null) {
                z10 = (P && view.isFocused()) | false;
                if (com.google.android.exoplayer2.util.j0.f22990a < 21) {
                    z12 = z10;
                } else {
                    z12 = P && b.a(this.f22401f);
                }
                z11 = z12 | false;
                this.f22401f.setVisibility(P ? 8 : 0);
            } else {
                z10 = false;
                z11 = false;
            }
            View view2 = this.f22403g;
            if (view2 != null) {
                z10 |= !P && view2.isFocused();
                if (com.google.android.exoplayer2.util.j0.f22990a < 21) {
                    z13 = z10;
                } else if (P || !b.a(this.f22403g)) {
                    z13 = false;
                }
                z11 |= z13;
                this.f22403g.setVisibility(P ? 0 : 8);
            }
            if (z10) {
                M();
            }
            if (z11) {
                L();
            }
        }
    }

    public final void V() {
        long j10;
        if (J() && this.K) {
            Player player = this.H;
            long j11 = 0;
            if (player != null) {
                j11 = this.f22400e0 + player.M();
                j10 = this.f22400e0 + player.w();
            } else {
                j10 = 0;
            }
            boolean z10 = j11 != this.f22402f0;
            boolean z11 = j10 != this.f22404g0;
            this.f22402f0 = j11;
            this.f22404g0 = j10;
            TextView textView = this.f22411n;
            if (textView != null && !this.N && z10) {
                textView.setText(com.google.android.exoplayer2.util.j0.d0(this.f22413p, this.f22414q, j11));
            }
            m0 m0Var = this.f22412o;
            if (m0Var != null) {
                m0Var.setPosition(j11);
                this.f22412o.setBufferedPosition(j10);
            }
            d dVar = this.J;
            if (dVar != null && (z10 || z11)) {
                dVar.onProgressUpdate(j11, j10);
            }
            removeCallbacks(this.f22417t);
            int playbackState = player == null ? 1 : player.getPlaybackState();
            if (player == null || !player.isPlaying()) {
                if (playbackState == 4 || playbackState == 1) {
                    return;
                }
                postDelayed(this.f22417t, 1000L);
                return;
            }
            m0 m0Var2 = this.f22412o;
            long min = Math.min(m0Var2 != null ? m0Var2.getPreferredUpdateDelay() : 1000L, 1000 - (j11 % 1000));
            postDelayed(this.f22417t, com.google.android.exoplayer2.util.j0.s(player.d().f20698a > 0.0f ? ((float) min) / r0 : 1000L, this.P, 1000L));
        }
    }

    public final void W() {
        ImageView imageView;
        if (J() && this.K && (imageView = this.f22407j) != null) {
            if (this.Q == 0) {
                S(false, false, imageView);
                return;
            }
            Player player = this.H;
            if (player == null) {
                S(true, false, imageView);
                this.f22407j.setImageDrawable(this.f22419v);
                this.f22407j.setContentDescription(this.f22422y);
                return;
            }
            S(true, true, imageView);
            int repeatMode = player.getRepeatMode();
            if (repeatMode == 0) {
                this.f22407j.setImageDrawable(this.f22419v);
                this.f22407j.setContentDescription(this.f22422y);
            } else if (repeatMode == 1) {
                this.f22407j.setImageDrawable(this.f22420w);
                this.f22407j.setContentDescription(this.f22423z);
            } else if (repeatMode == 2) {
                this.f22407j.setImageDrawable(this.f22421x);
                this.f22407j.setContentDescription(this.A);
            }
            this.f22407j.setVisibility(0);
        }
    }

    public final void X() {
        ImageView imageView;
        String str;
        if (J() && this.K && (imageView = this.f22408k) != null) {
            Player player = this.H;
            if (!this.V) {
                S(false, false, imageView);
                return;
            }
            if (player == null) {
                S(true, false, imageView);
                this.f22408k.setImageDrawable(this.C);
                this.f22408k.setContentDescription(this.G);
                return;
            }
            S(true, true, imageView);
            this.f22408k.setImageDrawable(player.Q() ? this.B : this.C);
            ImageView imageView2 = this.f22408k;
            if (player.Q()) {
                str = this.F;
            } else {
                str = this.G;
            }
            imageView2.setContentDescription(str);
        }
    }

    public final void Y() {
        int i10;
        Timeline.c cVar;
        Player player = this.H;
        if (player == null) {
            return;
        }
        boolean z10 = true;
        this.M = this.L && A(player.E(), this.f22416s);
        long j10 = 0;
        this.f22400e0 = 0L;
        Timeline E = player.E();
        if (E.q()) {
            i10 = 0;
        } else {
            int A = player.A();
            boolean z11 = this.M;
            int i11 = z11 ? 0 : A;
            int p10 = z11 ? E.p() - 1 : A;
            long j11 = 0;
            i10 = 0;
            while (true) {
                if (i11 > p10) {
                    break;
                }
                if (i11 == A) {
                    this.f22400e0 = com.google.android.exoplayer2.h.e(j11);
                }
                E.n(i11, this.f22416s);
                Timeline.c cVar2 = this.f22416s;
                if (cVar2.f19680n == -9223372036854775807L) {
                    com.google.android.exoplayer2.util.a.g(this.M ^ z10);
                    break;
                }
                int i12 = cVar2.f19681o;
                while (true) {
                    cVar = this.f22416s;
                    if (i12 <= cVar.f19682p) {
                        E.f(i12, this.f22415r);
                        int c4 = this.f22415r.c();
                        for (int n10 = this.f22415r.n(); n10 < c4; n10++) {
                            long f10 = this.f22415r.f(n10);
                            if (f10 == Long.MIN_VALUE) {
                                long j12 = this.f22415r.f19659d;
                                if (j12 != -9223372036854775807L) {
                                    f10 = j12;
                                }
                            }
                            long m10 = f10 + this.f22415r.m();
                            if (m10 >= 0) {
                                long[] jArr = this.f22392a0;
                                if (i10 == jArr.length) {
                                    int length = jArr.length == 0 ? 1 : jArr.length * 2;
                                    this.f22392a0 = Arrays.copyOf(jArr, length);
                                    this.f22394b0 = Arrays.copyOf(this.f22394b0, length);
                                }
                                this.f22392a0[i10] = com.google.android.exoplayer2.h.e(j11 + m10);
                                this.f22394b0[i10] = this.f22415r.o(n10);
                                i10++;
                            }
                        }
                        i12++;
                    }
                }
                j11 += cVar.f19680n;
                i11++;
                z10 = true;
            }
            j10 = j11;
        }
        long e2 = com.google.android.exoplayer2.h.e(j10);
        TextView textView = this.f22410m;
        if (textView != null) {
            textView.setText(com.google.android.exoplayer2.util.j0.d0(this.f22413p, this.f22414q, e2));
        }
        m0 m0Var = this.f22412o;
        if (m0Var != null) {
            m0Var.setDuration(e2);
            int length2 = this.f22396c0.length;
            int i13 = i10 + length2;
            long[] jArr2 = this.f22392a0;
            if (i13 > jArr2.length) {
                this.f22392a0 = Arrays.copyOf(jArr2, i13);
                this.f22394b0 = Arrays.copyOf(this.f22394b0, i13);
            }
            System.arraycopy((Object) this.f22396c0, 0, (Object) this.f22392a0, i10, length2);
            System.arraycopy((Object) this.f22398d0, 0, (Object) this.f22394b0, i10, length2);
            this.f22412o.setAdGroupTimesMs(this.f22392a0, this.f22394b0, i13);
        }
        V();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return B(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            removeCallbacks(this.f22418u);
        } else if (motionEvent.getAction() == 1) {
            H();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Nullable
    public Player getPlayer() {
        return this.H;
    }

    public int getRepeatToggleModes() {
        return this.Q;
    }

    public boolean getShowShuffleButton() {
        return this.V;
    }

    public int getShowTimeoutMs() {
        return this.O;
    }

    public boolean getShowVrButton() {
        View view = this.f22409l;
        return view != null && view.getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.K = true;
        long j10 = this.W;
        if (j10 != -9223372036854775807L) {
            long uptimeMillis = j10 - SystemClock.uptimeMillis();
            if (uptimeMillis <= 0) {
                G();
            } else {
                postDelayed(this.f22418u, uptimeMillis);
            }
        } else if (J()) {
            H();
        }
        R();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.K = false;
        removeCallbacks(this.f22417t);
        removeCallbacks(this.f22418u);
    }

    @Deprecated
    public void setControlDispatcher(com.google.android.exoplayer2.i iVar) {
        if (this.I != iVar) {
            this.I = iVar;
            T();
        }
    }

    public void setExtraAdGroupMarkers(@Nullable long[] jArr, @Nullable boolean[] zArr) {
        if (jArr == null) {
            this.f22396c0 = new long[0];
            this.f22398d0 = new boolean[0];
        } else {
            boolean[] zArr2 = (boolean[]) com.google.android.exoplayer2.util.a.e(zArr);
            com.google.android.exoplayer2.util.a.a(jArr.length == zArr2.length);
            this.f22396c0 = jArr;
            this.f22398d0 = zArr2;
        }
        Y();
    }

    public void setPlayer(@Nullable Player player) {
        boolean z10 = true;
        com.google.android.exoplayer2.util.a.g(Looper.myLooper() == Looper.getMainLooper());
        if (player != null && player.F() != Looper.getMainLooper()) {
            z10 = false;
        }
        com.google.android.exoplayer2.util.a.a(z10);
        Player player2 = this.H;
        if (player2 == player) {
            return;
        }
        if (player2 != null) {
            player2.h(this.f22393b);
        }
        this.H = player;
        if (player != null) {
            player.N(this.f22393b);
        }
        R();
    }

    public void setProgressUpdateListener(@Nullable d dVar) {
        this.J = dVar;
    }

    public void setRepeatToggleModes(int i10) {
        this.Q = i10;
        Player player = this.H;
        if (player != null) {
            int repeatMode = player.getRepeatMode();
            if (i10 == 0 && repeatMode != 0) {
                this.I.d(this.H, 0);
            } else if (i10 == 1 && repeatMode == 2) {
                this.I.d(this.H, 1);
            } else if (i10 == 2 && repeatMode == 1) {
                this.I.d(this.H, 2);
            }
        }
        W();
    }

    public void setShowFastForwardButton(boolean z10) {
        this.S = z10;
        T();
    }

    public void setShowMultiWindowTimeBar(boolean z10) {
        this.L = z10;
        Y();
    }

    public void setShowNextButton(boolean z10) {
        this.U = z10;
        T();
    }

    public void setShowPreviousButton(boolean z10) {
        this.T = z10;
        T();
    }

    public void setShowRewindButton(boolean z10) {
        this.R = z10;
        T();
    }

    public void setShowShuffleButton(boolean z10) {
        this.V = z10;
        X();
    }

    public void setShowTimeoutMs(int i10) {
        this.O = i10;
        if (J()) {
            H();
        }
    }

    public void setShowVrButton(boolean z10) {
        View view = this.f22409l;
        if (view != null) {
            view.setVisibility(z10 ? 0 : 8);
        }
    }

    public void setTimeBarMinUpdateInterval(int i10) {
        this.P = com.google.android.exoplayer2.util.j0.r(i10, 16, 1000);
    }

    public void setVrButtonListener(@Nullable View.OnClickListener onClickListener) {
        View view = this.f22409l;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            S(getShowVrButton(), onClickListener != null, this.f22409l);
        }
    }

    public void z(e eVar) {
        com.google.android.exoplayer2.util.a.e(eVar);
        this.f22395c.add(eVar);
    }

    public PlayerControlView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, attributeSet);
    }

    public PlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i10, @Nullable AttributeSet attributeSet2) {
        super(context, attributeSet, i10);
        int i11 = R$layout.exo_player_control_view;
        this.O = 5000;
        this.Q = 0;
        this.P = 200;
        this.W = -9223372036854775807L;
        this.R = true;
        this.S = true;
        this.T = true;
        this.U = true;
        this.V = false;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R$styleable.PlayerControlView, i10, 0);
            try {
                this.O = obtainStyledAttributes.getInt(R$styleable.PlayerControlView_show_timeout, this.O);
                i11 = obtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_controller_layout_id, i11);
                this.Q = F(obtainStyledAttributes, this.Q);
                this.R = obtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_rewind_button, this.R);
                this.S = obtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_fastforward_button, this.S);
                this.T = obtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_previous_button, this.T);
                this.U = obtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_next_button, this.U);
                this.V = obtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_shuffle_button, this.V);
                setTimeBarMinUpdateInterval(obtainStyledAttributes.getInt(R$styleable.PlayerControlView_time_bar_min_update_interval, this.P));
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.f22395c = new CopyOnWriteArrayList<>();
        this.f22415r = new Timeline.b();
        this.f22416s = new Timeline.c();
        StringBuilder sb2 = new StringBuilder();
        this.f22413p = sb2;
        this.f22414q = new Formatter(sb2, Locale.getDefault());
        this.f22392a0 = new long[0];
        this.f22394b0 = new boolean[0];
        this.f22396c0 = new long[0];
        this.f22398d0 = new boolean[0];
        c cVar = new c();
        this.f22393b = cVar;
        this.I = new com.google.android.exoplayer2.j();
        this.f22417t = new Runnable() { // from class: com.google.android.exoplayer2.ui.i
            @Override // java.lang.Runnable
            public final void run() {
                PlayerControlView.this.V();
            }
        };
        this.f22418u = new Runnable() { // from class: com.google.android.exoplayer2.ui.h
            @Override // java.lang.Runnable
            public final void run() {
                PlayerControlView.this.G();
            }
        };
        LayoutInflater.from(context).inflate(i11, this);
        setDescendantFocusability(262144);
        int i12 = R$id.exo_progress;
        m0 m0Var = (m0) findViewById(i12);
        View findViewById = findViewById(R$id.exo_progress_placeholder);
        if (m0Var != null) {
            this.f22412o = m0Var;
        } else if (findViewById != null) {
            DefaultTimeBar defaultTimeBar = new DefaultTimeBar(context, null, 0, attributeSet2);
            defaultTimeBar.setId(i12);
            defaultTimeBar.setLayoutParams(findViewById.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById);
            viewGroup.removeView(findViewById);
            viewGroup.addView(defaultTimeBar, indexOfChild);
            this.f22412o = defaultTimeBar;
        } else {
            this.f22412o = null;
        }
        this.f22410m = (TextView) findViewById(R$id.exo_duration);
        this.f22411n = (TextView) findViewById(R$id.exo_position);
        m0 m0Var2 = this.f22412o;
        if (m0Var2 != null) {
            m0Var2.a(cVar);
        }
        View findViewById2 = findViewById(R$id.exo_play);
        this.f22401f = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(cVar);
        }
        View findViewById3 = findViewById(R$id.exo_pause);
        this.f22403g = findViewById3;
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(cVar);
        }
        View findViewById4 = findViewById(R$id.exo_prev);
        this.f22397d = findViewById4;
        if (findViewById4 != null) {
            findViewById4.setOnClickListener(cVar);
        }
        View findViewById5 = findViewById(R$id.exo_next);
        this.f22399e = findViewById5;
        if (findViewById5 != null) {
            findViewById5.setOnClickListener(cVar);
        }
        View findViewById6 = findViewById(R$id.exo_rew);
        this.f22406i = findViewById6;
        if (findViewById6 != null) {
            findViewById6.setOnClickListener(cVar);
        }
        View findViewById7 = findViewById(R$id.exo_ffwd);
        this.f22405h = findViewById7;
        if (findViewById7 != null) {
            findViewById7.setOnClickListener(cVar);
        }
        ImageView imageView = (ImageView) findViewById(R$id.exo_repeat_toggle);
        this.f22407j = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(cVar);
        }
        ImageView imageView2 = (ImageView) findViewById(R$id.exo_shuffle);
        this.f22408k = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(cVar);
        }
        View findViewById8 = findViewById(R$id.exo_vr);
        this.f22409l = findViewById8;
        setShowVrButton(false);
        S(false, false, findViewById8);
        Resources resources = context.getResources();
        this.D = resources.getInteger(R$integer.exo_media_button_opacity_percentage_enabled) / 100.0f;
        this.E = resources.getInteger(R$integer.exo_media_button_opacity_percentage_disabled) / 100.0f;
        this.f22419v = resources.getDrawable(R$drawable.exo_controls_repeat_off);
        this.f22420w = resources.getDrawable(R$drawable.exo_controls_repeat_one);
        this.f22421x = resources.getDrawable(R$drawable.exo_controls_repeat_all);
        this.B = resources.getDrawable(R$drawable.exo_controls_shuffle_on);
        this.C = resources.getDrawable(R$drawable.exo_controls_shuffle_off);
        this.f22422y = resources.getString(R$string.exo_controls_repeat_off_description);
        this.f22423z = resources.getString(R$string.exo_controls_repeat_one_description);
        this.A = resources.getString(R$string.exo_controls_repeat_all_description);
        this.F = resources.getString(R$string.exo_controls_shuffle_on_description);
        this.G = resources.getString(R$string.exo_controls_shuffle_off_description);
    }
}
