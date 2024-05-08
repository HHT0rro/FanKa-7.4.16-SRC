package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.f1;
import com.google.android.exoplayer2.g1;
import com.google.android.exoplayer2.h1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.r0;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.t0;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.b;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;
import com.google.android.exoplayer2.ui.m0;
import com.google.android.exoplayer2.w0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class StyledPlayerControlView extends FrameLayout {
    public final String A;
    public final Drawable B;
    public final Drawable C;
    public final float D;
    public final float E;
    public final String F;

    @Nullable
    public View F0;
    public final String G;

    @Nullable
    public View G0;
    public final Drawable H;
    public final Drawable I;
    public final String J;
    public final String K;
    public final Drawable L;
    public final Drawable M;
    public final String N;
    public final String O;

    @Nullable
    public Player P;
    public com.google.android.exoplayer2.i Q;

    @Nullable
    public f R;

    @Nullable
    public d S;
    public boolean T;
    public boolean U;
    public boolean V;
    public boolean W;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f22453a0;

    /* renamed from: b, reason: collision with root package name */
    public final c f22454b;

    /* renamed from: b0, reason: collision with root package name */
    public int f22455b0;

    /* renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList<m> f22456c;

    /* renamed from: c0, reason: collision with root package name */
    public int f22457c0;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final View f22458d;

    /* renamed from: d0, reason: collision with root package name */
    public int f22459d0;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public final View f22460e;

    /* renamed from: e0, reason: collision with root package name */
    public long[] f22461e0;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public final View f22462f;

    /* renamed from: f0, reason: collision with root package name */
    public boolean[] f22463f0;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public final View f22464g;

    /* renamed from: g0, reason: collision with root package name */
    public long[] f22465g0;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public final View f22466h;

    /* renamed from: h0, reason: collision with root package name */
    public boolean[] f22467h0;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public final TextView f22468i;

    /* renamed from: i0, reason: collision with root package name */
    public long f22469i0;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public final TextView f22470j;

    /* renamed from: j0, reason: collision with root package name */
    public h0 f22471j0;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public final ImageView f22472k;

    /* renamed from: k0, reason: collision with root package name */
    public Resources f22473k0;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public final ImageView f22474l;

    /* renamed from: l0, reason: collision with root package name */
    public RecyclerView f22475l0;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public final View f22476m;

    /* renamed from: m0, reason: collision with root package name */
    public h f22477m0;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    public final TextView f22478n;

    /* renamed from: n0, reason: collision with root package name */
    public e f22479n0;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    public final TextView f22480o;

    /* renamed from: o0, reason: collision with root package name */
    public PopupWindow f22481o0;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    public final m0 f22482p;

    /* renamed from: p0, reason: collision with root package name */
    public boolean f22483p0;

    /* renamed from: q, reason: collision with root package name */
    public final StringBuilder f22484q;

    /* renamed from: q0, reason: collision with root package name */
    public int f22485q0;

    /* renamed from: r, reason: collision with root package name */
    public final Formatter f22486r;

    /* renamed from: r0, reason: collision with root package name */
    @Nullable
    public DefaultTrackSelector f22487r0;

    /* renamed from: s, reason: collision with root package name */
    public final Timeline.b f22488s;

    /* renamed from: s0, reason: collision with root package name */
    public l f22489s0;

    /* renamed from: t, reason: collision with root package name */
    public final Timeline.c f22490t;

    /* renamed from: t0, reason: collision with root package name */
    public l f22491t0;

    /* renamed from: u, reason: collision with root package name */
    public final Runnable f22492u;

    /* renamed from: u0, reason: collision with root package name */
    public n0 f22493u0;

    /* renamed from: v, reason: collision with root package name */
    public final Drawable f22494v;

    /* renamed from: v0, reason: collision with root package name */
    @Nullable
    public ImageView f22495v0;

    /* renamed from: w, reason: collision with root package name */
    public final Drawable f22496w;

    /* renamed from: w0, reason: collision with root package name */
    @Nullable
    public ImageView f22497w0;

    /* renamed from: x, reason: collision with root package name */
    public final Drawable f22498x;

    /* renamed from: x0, reason: collision with root package name */
    @Nullable
    public ImageView f22499x0;

    /* renamed from: y, reason: collision with root package name */
    public final String f22500y;

    /* renamed from: y0, reason: collision with root package name */
    @Nullable
    public View f22501y0;

    /* renamed from: z, reason: collision with root package name */
    public final String f22502z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class b extends l {
        public b() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l(View view) {
            if (StyledPlayerControlView.this.f22487r0 != null) {
                DefaultTrackSelector.d f10 = StyledPlayerControlView.this.f22487r0.u().f();
                for (int i10 = 0; i10 < this.f22525a.size(); i10++) {
                    f10 = f10.P(this.f22525a.get(i10).intValue());
                }
                ((DefaultTrackSelector) com.google.android.exoplayer2.util.a.e(StyledPlayerControlView.this.f22487r0)).M(f10);
            }
            StyledPlayerControlView.this.f22477m0.e(1, StyledPlayerControlView.this.getResources().getString(R$string.exo_track_selection_auto));
            StyledPlayerControlView.this.f22481o0.dismiss();
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.l
        public void e(List<Integer> list, List<k> list2, b.a aVar) {
            boolean z10;
            int i10 = 0;
            int i11 = 0;
            while (true) {
                if (i11 >= list.size()) {
                    z10 = false;
                    break;
                }
                int intValue = list.get(i11).intValue();
                TrackGroupArray e2 = aVar.e(intValue);
                if (StyledPlayerControlView.this.f22487r0 != null && StyledPlayerControlView.this.f22487r0.u().j(intValue, e2)) {
                    z10 = true;
                    break;
                }
                i11++;
            }
            if (!list2.isEmpty()) {
                if (z10) {
                    while (true) {
                        if (i10 >= list2.size()) {
                            break;
                        }
                        k kVar = list2.get(i10);
                        if (kVar.f22524e) {
                            StyledPlayerControlView.this.f22477m0.e(1, kVar.f22523d);
                            break;
                        }
                        i10++;
                    }
                } else {
                    StyledPlayerControlView.this.f22477m0.e(1, StyledPlayerControlView.this.getResources().getString(R$string.exo_track_selection_auto));
                }
            } else {
                StyledPlayerControlView.this.f22477m0.e(1, StyledPlayerControlView.this.getResources().getString(R$string.exo_track_selection_none));
            }
            this.f22525a = list;
            this.f22526b = list2;
            this.f22527c = aVar;
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.l
        public void h(i iVar) {
            boolean z10;
            iVar.f22517a.setText(R$string.exo_track_selection_auto);
            DefaultTrackSelector.Parameters u10 = ((DefaultTrackSelector) com.google.android.exoplayer2.util.a.e(StyledPlayerControlView.this.f22487r0)).u();
            int i10 = 0;
            while (true) {
                if (i10 >= this.f22525a.size()) {
                    z10 = false;
                    break;
                }
                int intValue = this.f22525a.get(i10).intValue();
                if (u10.j(intValue, ((b.a) com.google.android.exoplayer2.util.a.e(this.f22527c)).e(intValue))) {
                    z10 = true;
                    break;
                }
                i10++;
            }
            iVar.f22518b.setVisibility(z10 ? 4 : 0);
            iVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StyledPlayerControlView.b.this.l(view);
                }
            });
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.l
        public void j(String str) {
            StyledPlayerControlView.this.f22477m0.e(1, str);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class c implements Player.e, m0.a, View.OnClickListener, PopupWindow.OnDismissListener {
        public c() {
        }

        @Override // com.google.android.exoplayer2.ui.m0.a
        public void a(m0 m0Var, long j10, boolean z10) {
            StyledPlayerControlView.this.f22453a0 = false;
            if (!z10 && StyledPlayerControlView.this.P != null) {
                StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
                styledPlayerControlView.r0(styledPlayerControlView.P, j10);
            }
            StyledPlayerControlView.this.f22471j0.W();
        }

        @Override // com.google.android.exoplayer2.ui.m0.a
        public void b(m0 m0Var, long j10) {
            if (StyledPlayerControlView.this.f22480o != null) {
                StyledPlayerControlView.this.f22480o.setText(com.google.android.exoplayer2.util.j0.d0(StyledPlayerControlView.this.f22484q, StyledPlayerControlView.this.f22486r, j10));
            }
        }

        @Override // com.google.android.exoplayer2.ui.m0.a
        public void c(m0 m0Var, long j10) {
            StyledPlayerControlView.this.f22453a0 = true;
            if (StyledPlayerControlView.this.f22480o != null) {
                StyledPlayerControlView.this.f22480o.setText(com.google.android.exoplayer2.util.j0.d0(StyledPlayerControlView.this.f22484q, StyledPlayerControlView.this.f22486r, j10));
            }
            StyledPlayerControlView.this.f22471j0.V();
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onAvailableCommandsChanged(Player.b bVar) {
            h1.c(this, bVar);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Player player = StyledPlayerControlView.this.P;
            if (player == null) {
                return;
            }
            StyledPlayerControlView.this.f22471j0.W();
            if (StyledPlayerControlView.this.f22460e == view) {
                StyledPlayerControlView.this.Q.i(player);
                return;
            }
            if (StyledPlayerControlView.this.f22458d == view) {
                StyledPlayerControlView.this.Q.h(player);
                return;
            }
            if (StyledPlayerControlView.this.f22464g == view) {
                if (player.getPlaybackState() != 4) {
                    StyledPlayerControlView.this.Q.e(player);
                    return;
                }
                return;
            }
            if (StyledPlayerControlView.this.f22466h == view) {
                StyledPlayerControlView.this.Q.k(player);
                return;
            }
            if (StyledPlayerControlView.this.f22462f == view) {
                StyledPlayerControlView.this.Z(player);
                return;
            }
            if (StyledPlayerControlView.this.f22472k == view) {
                StyledPlayerControlView.this.Q.d(player, com.google.android.exoplayer2.util.w.a(player.getRepeatMode(), StyledPlayerControlView.this.f22459d0));
                return;
            }
            if (StyledPlayerControlView.this.f22474l == view) {
                StyledPlayerControlView.this.Q.c(player, !player.Q());
                return;
            }
            if (StyledPlayerControlView.this.f22501y0 == view) {
                StyledPlayerControlView.this.f22471j0.V();
                StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
                styledPlayerControlView.a0(styledPlayerControlView.f22477m0);
                return;
            }
            if (StyledPlayerControlView.this.F0 == view) {
                StyledPlayerControlView.this.f22471j0.V();
                StyledPlayerControlView styledPlayerControlView2 = StyledPlayerControlView.this;
                styledPlayerControlView2.a0(styledPlayerControlView2.f22479n0);
            } else if (StyledPlayerControlView.this.G0 == view) {
                StyledPlayerControlView.this.f22471j0.V();
                StyledPlayerControlView styledPlayerControlView3 = StyledPlayerControlView.this;
                styledPlayerControlView3.a0(styledPlayerControlView3.f22491t0);
            } else if (StyledPlayerControlView.this.f22495v0 == view) {
                StyledPlayerControlView.this.f22471j0.V();
                StyledPlayerControlView styledPlayerControlView4 = StyledPlayerControlView.this;
                styledPlayerControlView4.a0(styledPlayerControlView4.f22489s0);
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

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (StyledPlayerControlView.this.f22483p0) {
                StyledPlayerControlView.this.f22471j0.W();
            }
        }

        @Override // com.google.android.exoplayer2.Player.c
        public void onEvents(Player player, Player.d dVar) {
            if (dVar.b(5, 6)) {
                StyledPlayerControlView.this.A0();
            }
            if (dVar.b(5, 6, 8)) {
                StyledPlayerControlView.this.C0();
            }
            if (dVar.a(9)) {
                StyledPlayerControlView.this.D0();
            }
            if (dVar.a(10)) {
                StyledPlayerControlView.this.G0();
            }
            if (dVar.b(9, 10, 12, 0, 17, 18, 14)) {
                StyledPlayerControlView.this.z0();
            }
            if (dVar.b(12, 0)) {
                StyledPlayerControlView.this.H0();
            }
            if (dVar.a(13)) {
                StyledPlayerControlView.this.B0();
            }
            if (dVar.a(2)) {
                StyledPlayerControlView.this.I0();
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
        void a(boolean z10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class e extends RecyclerView.Adapter<i> {

        /* renamed from: a, reason: collision with root package name */
        public final String[] f22505a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f22506b;

        /* renamed from: c, reason: collision with root package name */
        public int f22507c;

        public e(String[] strArr, int[] iArr) {
            this.f22505a = strArr;
            this.f22506b = iArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(int i10, View view) {
            if (i10 != this.f22507c) {
                StyledPlayerControlView.this.setPlaybackSpeed(this.f22506b[i10] / 100.0f);
            }
            StyledPlayerControlView.this.f22481o0.dismiss();
        }

        public String d() {
            return this.f22505a[this.f22507c];
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(i iVar, final int i10) {
            String[] strArr = this.f22505a;
            if (i10 < strArr.length) {
                iVar.f22517a.setText(strArr[i10]);
            }
            iVar.f22518b.setVisibility(i10 == this.f22507c ? 0 : 4);
            iVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StyledPlayerControlView.e.this.e(i10, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public i onCreateViewHolder(ViewGroup viewGroup, int i10) {
            return new i(LayoutInflater.from(StyledPlayerControlView.this.getContext()).inflate(R$layout.exo_styled_sub_settings_list_item, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f22505a.length;
        }

        public void h(float f10) {
            int round = Math.round(f10 * 100.0f);
            int i10 = 0;
            int i11 = 0;
            int i12 = Integer.MAX_VALUE;
            while (true) {
                int[] iArr = this.f22506b;
                if (i10 < iArr.length) {
                    int abs = Math.abs(round - iArr[i10]);
                    if (abs < i12) {
                        i11 = i10;
                        i12 = abs;
                    }
                    i10++;
                } else {
                    this.f22507c = i11;
                    return;
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface f {
        void onProgressUpdate(long j10, long j11);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class g extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f22509a;

        /* renamed from: b, reason: collision with root package name */
        public final TextView f22510b;

        /* renamed from: c, reason: collision with root package name */
        public final ImageView f22511c;

        public g(View view) {
            super(view);
            if (com.google.android.exoplayer2.util.j0.f22990a < 26) {
                view.setFocusable(true);
            }
            this.f22509a = (TextView) view.findViewById(R$id.exo_main_text);
            this.f22510b = (TextView) view.findViewById(R$id.exo_sub_text);
            this.f22511c = (ImageView) view.findViewById(R$id.exo_icon);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    StyledPlayerControlView.g.this.m(view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(View view) {
            StyledPlayerControlView.this.n0(getAdapterPosition());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class h extends RecyclerView.Adapter<g> {

        /* renamed from: a, reason: collision with root package name */
        public final String[] f22513a;

        /* renamed from: b, reason: collision with root package name */
        public final String[] f22514b;

        /* renamed from: c, reason: collision with root package name */
        public final Drawable[] f22515c;

        public h(String[] strArr, Drawable[] drawableArr) {
            this.f22513a = strArr;
            this.f22514b = new String[strArr.length];
            this.f22515c = drawableArr;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(g gVar, int i10) {
            gVar.f22509a.setText(this.f22513a[i10]);
            if (this.f22514b[i10] == null) {
                gVar.f22510b.setVisibility(8);
            } else {
                gVar.f22510b.setText(this.f22514b[i10]);
            }
            if (this.f22515c[i10] == null) {
                gVar.f22511c.setVisibility(8);
            } else {
                gVar.f22511c.setImageDrawable(this.f22515c[i10]);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public g onCreateViewHolder(ViewGroup viewGroup, int i10) {
            return new g(LayoutInflater.from(StyledPlayerControlView.this.getContext()).inflate(R$layout.exo_styled_settings_list_item, viewGroup, false));
        }

        public void e(int i10, String str) {
            this.f22514b[i10] = str;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f22513a.length;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i10) {
            return i10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class i extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f22517a;

        /* renamed from: b, reason: collision with root package name */
        public final View f22518b;

        public i(View view) {
            super(view);
            if (com.google.android.exoplayer2.util.j0.f22990a < 26) {
                view.setFocusable(true);
            }
            this.f22517a = (TextView) view.findViewById(R$id.exo_text);
            this.f22518b = view.findViewById(R$id.exo_check);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class j extends l {
        public j() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l(View view) {
            if (StyledPlayerControlView.this.f22487r0 != null) {
                DefaultTrackSelector.d f10 = StyledPlayerControlView.this.f22487r0.u().f();
                for (int i10 = 0; i10 < this.f22525a.size(); i10++) {
                    int intValue = this.f22525a.get(i10).intValue();
                    f10 = f10.P(intValue).T(intValue, true);
                }
                ((DefaultTrackSelector) com.google.android.exoplayer2.util.a.e(StyledPlayerControlView.this.f22487r0)).M(f10);
                StyledPlayerControlView.this.f22481o0.dismiss();
            }
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.l
        public void e(List<Integer> list, List<k> list2, b.a aVar) {
            boolean z10 = false;
            int i10 = 0;
            while (true) {
                if (i10 >= list2.size()) {
                    break;
                }
                if (list2.get(i10).f22524e) {
                    z10 = true;
                    break;
                }
                i10++;
            }
            if (StyledPlayerControlView.this.f22495v0 != null) {
                ImageView imageView = StyledPlayerControlView.this.f22495v0;
                StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
                imageView.setImageDrawable(z10 ? styledPlayerControlView.H : styledPlayerControlView.I);
                StyledPlayerControlView.this.f22495v0.setContentDescription(z10 ? StyledPlayerControlView.this.J : StyledPlayerControlView.this.K);
            }
            this.f22525a = list;
            this.f22526b = list2;
            this.f22527c = aVar;
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.l, androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(i iVar, int i10) {
            super.onBindViewHolder(iVar, i10);
            if (i10 > 0) {
                iVar.f22518b.setVisibility(this.f22526b.get(i10 + (-1)).f22524e ? 0 : 4);
            }
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.l
        public void h(i iVar) {
            boolean z10;
            iVar.f22517a.setText(R$string.exo_track_selection_none);
            int i10 = 0;
            while (true) {
                if (i10 >= this.f22526b.size()) {
                    z10 = true;
                    break;
                } else {
                    if (this.f22526b.get(i10).f22524e) {
                        z10 = false;
                        break;
                    }
                    i10++;
                }
            }
            iVar.f22518b.setVisibility(z10 ? 0 : 4);
            iVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StyledPlayerControlView.j.this.l(view);
                }
            });
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.l
        public void j(String str) {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class k {

        /* renamed from: a, reason: collision with root package name */
        public final int f22520a;

        /* renamed from: b, reason: collision with root package name */
        public final int f22521b;

        /* renamed from: c, reason: collision with root package name */
        public final int f22522c;

        /* renamed from: d, reason: collision with root package name */
        public final String f22523d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f22524e;

        public k(int i10, int i11, int i12, String str, boolean z10) {
            this.f22520a = i10;
            this.f22521b = i11;
            this.f22522c = i12;
            this.f22523d = str;
            this.f22524e = z10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public abstract class l extends RecyclerView.Adapter<i> {

        /* renamed from: a, reason: collision with root package name */
        public List<Integer> f22525a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public List<k> f22526b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        public b.a f22527c = null;

        public l() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(k kVar, View view) {
            if (this.f22527c == null || StyledPlayerControlView.this.f22487r0 == null) {
                return;
            }
            DefaultTrackSelector.d f10 = StyledPlayerControlView.this.f22487r0.u().f();
            for (int i10 = 0; i10 < this.f22525a.size(); i10++) {
                int intValue = this.f22525a.get(i10).intValue();
                if (intValue == kVar.f22520a) {
                    f10 = f10.U(intValue, ((b.a) com.google.android.exoplayer2.util.a.e(this.f22527c)).e(intValue), new DefaultTrackSelector.SelectionOverride(kVar.f22521b, kVar.f22522c)).T(intValue, false);
                } else {
                    f10 = f10.P(intValue).T(intValue, true);
                }
            }
            ((DefaultTrackSelector) com.google.android.exoplayer2.util.a.e(StyledPlayerControlView.this.f22487r0)).M(f10);
            j(kVar.f22523d);
            StyledPlayerControlView.this.f22481o0.dismiss();
        }

        public void d() {
            this.f22526b = Collections.emptyList();
            this.f22527c = null;
        }

        public abstract void e(List<Integer> list, List<k> list2, b.a aVar);

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: g */
        public void onBindViewHolder(i iVar, int i10) {
            if (StyledPlayerControlView.this.f22487r0 == null || this.f22527c == null) {
                return;
            }
            if (i10 == 0) {
                h(iVar);
                return;
            }
            final k kVar = this.f22526b.get(i10 - 1);
            boolean z10 = ((DefaultTrackSelector) com.google.android.exoplayer2.util.a.e(StyledPlayerControlView.this.f22487r0)).u().j(kVar.f22520a, this.f22527c.e(kVar.f22520a)) && kVar.f22524e;
            iVar.f22517a.setText(kVar.f22523d);
            iVar.f22518b.setVisibility(z10 ? 0 : 4);
            iVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StyledPlayerControlView.l.this.f(kVar, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.f22526b.isEmpty()) {
                return 0;
            }
            return this.f22526b.size() + 1;
        }

        public abstract void h(i iVar);

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public i onCreateViewHolder(ViewGroup viewGroup, int i10) {
            return new i(LayoutInflater.from(StyledPlayerControlView.this.getContext()).inflate(R$layout.exo_styled_sub_settings_list_item, viewGroup, false));
        }

        public abstract void j(String str);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface m {
        void a(int i10);
    }

    static {
        r0.a("goog.exo.ui");
    }

    public StyledPlayerControlView(Context context) {
        this(context, null);
    }

    public static boolean V(Timeline timeline, Timeline.c cVar) {
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

    public static int c0(TypedArray typedArray, int i10) {
        return typedArray.getInt(R$styleable.StyledPlayerControlView_repeat_toggle_modes, i10);
    }

    public static void g0(View view, View.OnClickListener onClickListener) {
        if (view == null) {
            return;
        }
        view.setVisibility(8);
        view.setOnClickListener(onClickListener);
    }

    public static boolean i0(int i10) {
        return i10 == 90 || i10 == 89 || i10 == 85 || i10 == 79 || i10 == 126 || i10 == 127 || i10 == 87 || i10 == 88;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaybackSpeed(float f10) {
        Player player = this.P;
        if (player == null) {
            return;
        }
        this.Q.a(player, player.d().b(f10));
    }

    public static void y0(@Nullable View view, boolean z10) {
        if (view == null) {
            return;
        }
        if (z10) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public final void A0() {
        if (j0() && this.U && this.f22462f != null) {
            if (s0()) {
                ((ImageView) this.f22462f).setImageDrawable(this.f22473k0.getDrawable(R$drawable.exo_styled_controls_pause));
                this.f22462f.setContentDescription(this.f22473k0.getString(R$string.exo_controls_pause_description));
            } else {
                ((ImageView) this.f22462f).setImageDrawable(this.f22473k0.getDrawable(R$drawable.exo_styled_controls_play));
                this.f22462f.setContentDescription(this.f22473k0.getString(R$string.exo_controls_play_description));
            }
        }
    }

    public final void B0() {
        Player player = this.P;
        if (player == null) {
            return;
        }
        this.f22479n0.h(player.d().f20698a);
        this.f22477m0.e(0, this.f22479n0.d());
    }

    public final void C0() {
        long j10;
        if (j0() && this.U) {
            Player player = this.P;
            long j11 = 0;
            if (player != null) {
                j11 = this.f22469i0 + player.M();
                j10 = this.f22469i0 + player.w();
            } else {
                j10 = 0;
            }
            TextView textView = this.f22480o;
            if (textView != null && !this.f22453a0) {
                textView.setText(com.google.android.exoplayer2.util.j0.d0(this.f22484q, this.f22486r, j11));
            }
            m0 m0Var = this.f22482p;
            if (m0Var != null) {
                m0Var.setPosition(j11);
                this.f22482p.setBufferedPosition(j10);
            }
            f fVar = this.R;
            if (fVar != null) {
                fVar.onProgressUpdate(j11, j10);
            }
            removeCallbacks(this.f22492u);
            int playbackState = player == null ? 1 : player.getPlaybackState();
            if (player == null || !player.isPlaying()) {
                if (playbackState == 4 || playbackState == 1) {
                    return;
                }
                postDelayed(this.f22492u, 1000L);
                return;
            }
            m0 m0Var2 = this.f22482p;
            long min = Math.min(m0Var2 != null ? m0Var2.getPreferredUpdateDelay() : 1000L, 1000 - (j11 % 1000));
            postDelayed(this.f22492u, com.google.android.exoplayer2.util.j0.s(player.d().f20698a > 0.0f ? ((float) min) / r0 : 1000L, this.f22457c0, 1000L));
        }
    }

    public final void D0() {
        ImageView imageView;
        if (j0() && this.U && (imageView = this.f22472k) != null) {
            if (this.f22459d0 == 0) {
                v0(false, imageView);
                return;
            }
            Player player = this.P;
            if (player == null) {
                v0(false, imageView);
                this.f22472k.setImageDrawable(this.f22494v);
                this.f22472k.setContentDescription(this.f22500y);
                return;
            }
            v0(true, imageView);
            int repeatMode = player.getRepeatMode();
            if (repeatMode == 0) {
                this.f22472k.setImageDrawable(this.f22494v);
                this.f22472k.setContentDescription(this.f22500y);
            } else if (repeatMode == 1) {
                this.f22472k.setImageDrawable(this.f22496w);
                this.f22472k.setContentDescription(this.f22502z);
            } else {
                if (repeatMode != 2) {
                    return;
                }
                this.f22472k.setImageDrawable(this.f22498x);
                this.f22472k.setContentDescription(this.A);
            }
        }
    }

    public final void E0() {
        Player player;
        com.google.android.exoplayer2.i iVar = this.Q;
        int n10 = (int) (((!(iVar instanceof com.google.android.exoplayer2.j) || (player = this.P) == null) ? 5000L : ((com.google.android.exoplayer2.j) iVar).n(player)) / 1000);
        TextView textView = this.f22470j;
        if (textView != null) {
            textView.setText(String.valueOf(n10));
        }
        View view = this.f22466h;
        if (view != null) {
            view.setContentDescription(this.f22473k0.getQuantityString(R$plurals.exo_controls_rewind_by_amount_description, n10, Integer.valueOf(n10)));
        }
    }

    public final void F0() {
        this.f22475l0.measure(0, 0);
        this.f22481o0.setWidth(Math.min(this.f22475l0.getMeasuredWidth(), getWidth() - (this.f22485q0 * 2)));
        this.f22481o0.setHeight(Math.min(getHeight() - (this.f22485q0 * 2), this.f22475l0.getMeasuredHeight()));
    }

    public final void G0() {
        ImageView imageView;
        String str;
        if (j0() && this.U && (imageView = this.f22474l) != null) {
            Player player = this.P;
            if (!this.f22471j0.A(imageView)) {
                v0(false, this.f22474l);
                return;
            }
            if (player == null) {
                v0(false, this.f22474l);
                this.f22474l.setImageDrawable(this.C);
                this.f22474l.setContentDescription(this.G);
                return;
            }
            v0(true, this.f22474l);
            this.f22474l.setImageDrawable(player.Q() ? this.B : this.C);
            ImageView imageView2 = this.f22474l;
            if (player.Q()) {
                str = this.F;
            } else {
                str = this.G;
            }
            imageView2.setContentDescription(str);
        }
    }

    public final void H0() {
        int i10;
        Timeline.c cVar;
        Player player = this.P;
        if (player == null) {
            return;
        }
        boolean z10 = true;
        this.W = this.V && V(player.E(), this.f22490t);
        long j10 = 0;
        this.f22469i0 = 0L;
        Timeline E = player.E();
        if (E.q()) {
            i10 = 0;
        } else {
            int A = player.A();
            boolean z11 = this.W;
            int i11 = z11 ? 0 : A;
            int p10 = z11 ? E.p() - 1 : A;
            long j11 = 0;
            i10 = 0;
            while (true) {
                if (i11 > p10) {
                    break;
                }
                if (i11 == A) {
                    this.f22469i0 = com.google.android.exoplayer2.h.e(j11);
                }
                E.n(i11, this.f22490t);
                Timeline.c cVar2 = this.f22490t;
                if (cVar2.f19680n == -9223372036854775807L) {
                    com.google.android.exoplayer2.util.a.g(this.W ^ z10);
                    break;
                }
                int i12 = cVar2.f19681o;
                while (true) {
                    cVar = this.f22490t;
                    if (i12 <= cVar.f19682p) {
                        E.f(i12, this.f22488s);
                        int c4 = this.f22488s.c();
                        for (int n10 = this.f22488s.n(); n10 < c4; n10++) {
                            long f10 = this.f22488s.f(n10);
                            if (f10 == Long.MIN_VALUE) {
                                long j12 = this.f22488s.f19659d;
                                if (j12 != -9223372036854775807L) {
                                    f10 = j12;
                                }
                            }
                            long m10 = f10 + this.f22488s.m();
                            if (m10 >= 0) {
                                long[] jArr = this.f22461e0;
                                if (i10 == jArr.length) {
                                    int length = jArr.length == 0 ? 1 : jArr.length * 2;
                                    this.f22461e0 = Arrays.copyOf(jArr, length);
                                    this.f22463f0 = Arrays.copyOf(this.f22463f0, length);
                                }
                                this.f22461e0[i10] = com.google.android.exoplayer2.h.e(j11 + m10);
                                this.f22463f0[i10] = this.f22488s.o(n10);
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
        TextView textView = this.f22478n;
        if (textView != null) {
            textView.setText(com.google.android.exoplayer2.util.j0.d0(this.f22484q, this.f22486r, e2));
        }
        m0 m0Var = this.f22482p;
        if (m0Var != null) {
            m0Var.setDuration(e2);
            int length2 = this.f22465g0.length;
            int i13 = i10 + length2;
            long[] jArr2 = this.f22461e0;
            if (i13 > jArr2.length) {
                this.f22461e0 = Arrays.copyOf(jArr2, i13);
                this.f22463f0 = Arrays.copyOf(this.f22463f0, i13);
            }
            System.arraycopy((Object) this.f22465g0, 0, (Object) this.f22461e0, i10, length2);
            System.arraycopy((Object) this.f22467h0, 0, (Object) this.f22463f0, i10, length2);
            this.f22482p.setAdGroupTimesMs(this.f22461e0, this.f22463f0, i13);
        }
        C0();
    }

    public final void I0() {
        f0();
        v0(this.f22489s0.getItemCount() > 0, this.f22495v0);
    }

    public void U(m mVar) {
        com.google.android.exoplayer2.util.a.e(mVar);
        this.f22456c.add(mVar);
    }

    public boolean W(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        Player player = this.P;
        if (player == null || !i0(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() != 0) {
            return true;
        }
        if (keyCode == 90) {
            if (player.getPlaybackState() == 4) {
                return true;
            }
            this.Q.e(player);
            return true;
        }
        if (keyCode == 89) {
            this.Q.k(player);
            return true;
        }
        if (keyEvent.getRepeatCount() != 0) {
            return true;
        }
        if (keyCode == 79 || keyCode == 85) {
            Z(player);
            return true;
        }
        if (keyCode == 87) {
            this.Q.i(player);
            return true;
        }
        if (keyCode == 88) {
            this.Q.h(player);
            return true;
        }
        if (keyCode == 126) {
            Y(player);
            return true;
        }
        if (keyCode != 127) {
            return true;
        }
        X(player);
        return true;
    }

    public final void X(Player player) {
        this.Q.j(player, false);
    }

    public final void Y(Player player) {
        int playbackState = player.getPlaybackState();
        if (playbackState == 1) {
            this.Q.g(player);
        } else if (playbackState == 4) {
            q0(player, player.A(), -9223372036854775807L);
        }
        this.Q.j(player, true);
    }

    public final void Z(Player player) {
        int playbackState = player.getPlaybackState();
        if (playbackState != 1 && playbackState != 4 && player.o()) {
            X(player);
        } else {
            Y(player);
        }
    }

    public final void a0(RecyclerView.Adapter<?> adapter) {
        this.f22475l0.setAdapter(adapter);
        F0();
        this.f22483p0 = false;
        this.f22481o0.dismiss();
        this.f22483p0 = true;
        this.f22481o0.showAsDropDown(this, (getWidth() - this.f22481o0.getWidth()) - this.f22485q0, (-this.f22481o0.getHeight()) - this.f22485q0);
    }

    public final void b0(b.a aVar, int i10, List<k> list) {
        TrackGroupArray e2 = aVar.e(i10);
        n6.g a10 = ((Player) com.google.android.exoplayer2.util.a.e(this.P)).I().a(i10);
        for (int i11 = 0; i11 < e2.f21172b; i11++) {
            TrackGroup a11 = e2.a(i11);
            for (int i12 = 0; i12 < a11.f21168b; i12++) {
                Format a12 = a11.a(i12);
                if (aVar.f(i10, i11, i12) == 4) {
                    list.add(new k(i10, i11, i12, this.f22493u0.a(a12), (a10 == null || a10.t(a12) == -1) ? false : true));
                }
            }
        }
    }

    public void d0() {
        this.f22471j0.C();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return W(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public void e0() {
        this.f22471j0.F();
    }

    public final void f0() {
        DefaultTrackSelector defaultTrackSelector;
        b.a g3;
        this.f22489s0.d();
        this.f22491t0.d();
        if (this.P == null || (defaultTrackSelector = this.f22487r0) == null || (g3 = defaultTrackSelector.g()) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (int i10 = 0; i10 < g3.c(); i10++) {
            if (g3.d(i10) == 3 && this.f22471j0.A(this.f22495v0)) {
                b0(g3, i10, arrayList);
                arrayList3.add(Integer.valueOf(i10));
            } else if (g3.d(i10) == 1) {
                b0(g3, i10, arrayList2);
                arrayList4.add(Integer.valueOf(i10));
            }
        }
        this.f22489s0.e(arrayList3, arrayList, g3);
        this.f22491t0.e(arrayList4, arrayList2, g3);
    }

    @Nullable
    public Player getPlayer() {
        return this.P;
    }

    public int getRepeatToggleModes() {
        return this.f22459d0;
    }

    public boolean getShowShuffleButton() {
        return this.f22471j0.A(this.f22474l);
    }

    public boolean getShowSubtitleButton() {
        return this.f22471j0.A(this.f22495v0);
    }

    public int getShowTimeoutMs() {
        return this.f22455b0;
    }

    public boolean getShowVrButton() {
        return this.f22471j0.A(this.f22476m);
    }

    public boolean h0() {
        return this.f22471j0.I();
    }

    public boolean j0() {
        return getVisibility() == 0;
    }

    public void k0() {
        Iterator<m> iterator2 = this.f22456c.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().a(getVisibility());
        }
    }

    public final void l0(View view) {
        if (this.S == null) {
            return;
        }
        boolean z10 = !this.T;
        this.T = z10;
        x0(this.f22497w0, z10);
        x0(this.f22499x0, this.T);
        d dVar = this.S;
        if (dVar != null) {
            dVar.a(this.T);
        }
    }

    public final void m0(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        int i18 = i13 - i11;
        int i19 = i17 - i15;
        if (!(i12 - i10 == i16 - i14 && i18 == i19) && this.f22481o0.isShowing()) {
            F0();
            this.f22481o0.update(view, (getWidth() - this.f22481o0.getWidth()) - this.f22485q0, (-this.f22481o0.getHeight()) - this.f22485q0, -1, -1);
        }
    }

    public final void n0(int i10) {
        if (i10 == 0) {
            a0(this.f22479n0);
        } else if (i10 == 1) {
            a0(this.f22491t0);
        } else {
            this.f22481o0.dismiss();
        }
    }

    public void o0(m mVar) {
        this.f22456c.remove(mVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f22471j0.O();
        this.U = true;
        if (h0()) {
            this.f22471j0.W();
        }
        u0();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f22471j0.P();
        this.U = false;
        removeCallbacks(this.f22492u);
        this.f22471j0.V();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        this.f22471j0.Q(z10, i10, i11, i12, i13);
    }

    public void p0() {
        View view = this.f22462f;
        if (view != null) {
            view.requestFocus();
        }
    }

    public final boolean q0(Player player, int i10, long j10) {
        return this.Q.b(player, i10, j10);
    }

    public final void r0(Player player, long j10) {
        int A;
        Timeline E = player.E();
        if (this.W && !E.q()) {
            int p10 = E.p();
            A = 0;
            while (true) {
                long d10 = E.n(A, this.f22490t).d();
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
        q0(player, A, j10);
        C0();
    }

    public final boolean s0() {
        Player player = this.P;
        return (player == null || player.getPlaybackState() == 4 || this.P.getPlaybackState() == 1 || !this.P.o()) ? false : true;
    }

    public void setAnimationEnabled(boolean z10) {
        this.f22471j0.X(z10);
    }

    @Deprecated
    public void setControlDispatcher(com.google.android.exoplayer2.i iVar) {
        if (this.Q != iVar) {
            this.Q = iVar;
            z0();
        }
    }

    public void setExtraAdGroupMarkers(@Nullable long[] jArr, @Nullable boolean[] zArr) {
        if (jArr == null) {
            this.f22465g0 = new long[0];
            this.f22467h0 = new boolean[0];
        } else {
            boolean[] zArr2 = (boolean[]) com.google.android.exoplayer2.util.a.e(zArr);
            com.google.android.exoplayer2.util.a.a(jArr.length == zArr2.length);
            this.f22465g0 = jArr;
            this.f22467h0 = zArr2;
        }
        H0();
    }

    public void setOnFullScreenModeChangedListener(@Nullable d dVar) {
        this.S = dVar;
        y0(this.f22497w0, dVar != null);
        y0(this.f22499x0, dVar != null);
    }

    public void setPlayer(@Nullable Player player) {
        boolean z10 = true;
        com.google.android.exoplayer2.util.a.g(Looper.myLooper() == Looper.getMainLooper());
        if (player != null && player.F() != Looper.getMainLooper()) {
            z10 = false;
        }
        com.google.android.exoplayer2.util.a.a(z10);
        Player player2 = this.P;
        if (player2 == player) {
            return;
        }
        if (player2 != null) {
            player2.h(this.f22454b);
        }
        this.P = player;
        if (player != null) {
            player.N(this.f22454b);
        }
        if (player instanceof t0) {
            player = ((t0) player).U();
        }
        if (player instanceof com.google.android.exoplayer2.p) {
            n6.i a10 = ((com.google.android.exoplayer2.p) player).a();
            if (a10 instanceof DefaultTrackSelector) {
                this.f22487r0 = (DefaultTrackSelector) a10;
            }
        } else {
            this.f22487r0 = null;
        }
        u0();
    }

    public void setProgressUpdateListener(@Nullable f fVar) {
        this.R = fVar;
    }

    public void setRepeatToggleModes(int i10) {
        this.f22459d0 = i10;
        Player player = this.P;
        if (player != null) {
            int repeatMode = player.getRepeatMode();
            if (i10 == 0 && repeatMode != 0) {
                this.Q.d(this.P, 0);
            } else if (i10 == 1 && repeatMode == 2) {
                this.Q.d(this.P, 1);
            } else if (i10 == 2 && repeatMode == 1) {
                this.Q.d(this.P, 2);
            }
        }
        this.f22471j0.Y(this.f22472k, i10 != 0);
        D0();
    }

    public void setShowFastForwardButton(boolean z10) {
        this.f22471j0.Y(this.f22464g, z10);
        z0();
    }

    public void setShowMultiWindowTimeBar(boolean z10) {
        this.V = z10;
        H0();
    }

    public void setShowNextButton(boolean z10) {
        this.f22471j0.Y(this.f22460e, z10);
        z0();
    }

    public void setShowPreviousButton(boolean z10) {
        this.f22471j0.Y(this.f22458d, z10);
        z0();
    }

    public void setShowRewindButton(boolean z10) {
        this.f22471j0.Y(this.f22466h, z10);
        z0();
    }

    public void setShowShuffleButton(boolean z10) {
        this.f22471j0.Y(this.f22474l, z10);
        G0();
    }

    public void setShowSubtitleButton(boolean z10) {
        this.f22471j0.Y(this.f22495v0, z10);
    }

    public void setShowTimeoutMs(int i10) {
        this.f22455b0 = i10;
        if (h0()) {
            this.f22471j0.W();
        }
    }

    public void setShowVrButton(boolean z10) {
        this.f22471j0.Y(this.f22476m, z10);
    }

    public void setTimeBarMinUpdateInterval(int i10) {
        this.f22457c0 = com.google.android.exoplayer2.util.j0.r(i10, 16, 1000);
    }

    public void setVrButtonListener(@Nullable View.OnClickListener onClickListener) {
        View view = this.f22476m;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            v0(onClickListener != null, this.f22476m);
        }
    }

    public void t0() {
        this.f22471j0.b0();
    }

    public void u0() {
        A0();
        z0();
        D0();
        G0();
        I0();
        B0();
        H0();
    }

    public final void v0(boolean z10, @Nullable View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(z10);
        view.setAlpha(z10 ? this.D : this.E);
    }

    public final void w0() {
        Player player;
        com.google.android.exoplayer2.i iVar = this.Q;
        int m10 = (int) (((!(iVar instanceof com.google.android.exoplayer2.j) || (player = this.P) == null) ? 15000L : ((com.google.android.exoplayer2.j) iVar).m(player)) / 1000);
        TextView textView = this.f22468i;
        if (textView != null) {
            textView.setText(String.valueOf(m10));
        }
        View view = this.f22464g;
        if (view != null) {
            view.setContentDescription(this.f22473k0.getQuantityString(R$plurals.exo_controls_fastforward_by_amount_description, m10, Integer.valueOf(m10)));
        }
    }

    public final void x0(@Nullable ImageView imageView, boolean z10) {
        if (imageView == null) {
            return;
        }
        if (z10) {
            imageView.setImageDrawable(this.L);
            imageView.setContentDescription(this.N);
        } else {
            imageView.setImageDrawable(this.M);
            imageView.setContentDescription(this.O);
        }
    }

    public final void z0() {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (j0() && this.U) {
            Player player = this.P;
            boolean z14 = false;
            if (player != null) {
                boolean m10 = player.m(4);
                z12 = player.m(6);
                boolean z15 = player.m(10) && this.Q.f();
                if (player.m(11) && this.Q.l()) {
                    z14 = true;
                }
                z11 = player.m(8);
                z10 = z14;
                z14 = z15;
                z13 = m10;
            } else {
                z10 = false;
                z11 = false;
                z12 = false;
                z13 = false;
            }
            if (z14) {
                E0();
            }
            if (z10) {
                w0();
            }
            v0(z12, this.f22458d);
            v0(z14, this.f22466h);
            v0(z10, this.f22464g);
            v0(z11, this.f22460e);
            m0 m0Var = this.f22482p;
            if (m0Var != null) {
                m0Var.setEnabled(z13);
            }
        }
    }

    public StyledPlayerControlView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StyledPlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, attributeSet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [com.google.android.exoplayer2.ui.StyledPlayerControlView$a, android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r9v4 */
    public StyledPlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i10, @Nullable AttributeSet attributeSet2) {
        super(context, attributeSet, i10);
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        c cVar;
        boolean z18;
        boolean z19;
        ?? r92;
        int i11 = R$layout.exo_styled_player_control_view;
        this.f22455b0 = 5000;
        this.f22459d0 = 0;
        this.f22457c0 = 200;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R$styleable.StyledPlayerControlView, i10, 0);
            try {
                i11 = obtainStyledAttributes.getResourceId(R$styleable.StyledPlayerControlView_controller_layout_id, i11);
                this.f22455b0 = obtainStyledAttributes.getInt(R$styleable.StyledPlayerControlView_show_timeout, this.f22455b0);
                this.f22459d0 = c0(obtainStyledAttributes, this.f22459d0);
                boolean z20 = obtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_rewind_button, true);
                boolean z21 = obtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_fastforward_button, true);
                boolean z22 = obtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_previous_button, true);
                boolean z23 = obtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_next_button, true);
                boolean z24 = obtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_shuffle_button, false);
                boolean z25 = obtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_subtitle_button, false);
                boolean z26 = obtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_show_vr_button, false);
                setTimeBarMinUpdateInterval(obtainStyledAttributes.getInt(R$styleable.StyledPlayerControlView_time_bar_min_update_interval, this.f22457c0));
                boolean z27 = obtainStyledAttributes.getBoolean(R$styleable.StyledPlayerControlView_animation_enabled, true);
                obtainStyledAttributes.recycle();
                z16 = z24;
                z17 = z25;
                z12 = z20;
                z13 = z21;
                z14 = z22;
                z10 = z27;
                z15 = z23;
                z11 = z26;
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            z10 = true;
            z11 = false;
            z12 = true;
            z13 = true;
            z14 = true;
            z15 = true;
            z16 = false;
            z17 = false;
        }
        LayoutInflater.from(context).inflate(i11, this);
        setDescendantFocusability(262144);
        c cVar2 = new c();
        this.f22454b = cVar2;
        this.f22456c = new CopyOnWriteArrayList<>();
        this.f22488s = new Timeline.b();
        this.f22490t = new Timeline.c();
        StringBuilder sb2 = new StringBuilder();
        this.f22484q = sb2;
        this.f22486r = new Formatter(sb2, Locale.getDefault());
        this.f22461e0 = new long[0];
        this.f22463f0 = new boolean[0];
        this.f22465g0 = new long[0];
        this.f22467h0 = new boolean[0];
        this.Q = new com.google.android.exoplayer2.j();
        this.f22492u = new Runnable() { // from class: com.google.android.exoplayer2.ui.o
            @Override // java.lang.Runnable
            public final void run() {
                StyledPlayerControlView.this.C0();
            }
        };
        this.f22478n = (TextView) findViewById(R$id.exo_duration);
        this.f22480o = (TextView) findViewById(R$id.exo_position);
        ImageView imageView = (ImageView) findViewById(R$id.exo_subtitle);
        this.f22495v0 = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(cVar2);
        }
        ImageView imageView2 = (ImageView) findViewById(R$id.exo_fullscreen);
        this.f22497w0 = imageView2;
        g0(imageView2, new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StyledPlayerControlView.this.l0(view);
            }
        });
        ImageView imageView3 = (ImageView) findViewById(R$id.exo_minimal_fullscreen);
        this.f22499x0 = imageView3;
        g0(imageView3, new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StyledPlayerControlView.this.l0(view);
            }
        });
        View findViewById = findViewById(R$id.exo_settings);
        this.f22501y0 = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(cVar2);
        }
        View findViewById2 = findViewById(R$id.exo_playback_speed);
        this.F0 = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(cVar2);
        }
        View findViewById3 = findViewById(R$id.exo_audio_track);
        this.G0 = findViewById3;
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(cVar2);
        }
        int i12 = R$id.exo_progress;
        m0 m0Var = (m0) findViewById(i12);
        View findViewById4 = findViewById(R$id.exo_progress_placeholder);
        if (m0Var != null) {
            this.f22482p = m0Var;
            cVar = cVar2;
            z18 = z10;
            z19 = z11;
            r92 = 0;
        } else if (findViewById4 != null) {
            r92 = 0;
            cVar = cVar2;
            z18 = z10;
            z19 = z11;
            DefaultTimeBar defaultTimeBar = new DefaultTimeBar(context, null, 0, attributeSet2, R$style.ExoStyledControls_TimeBar);
            defaultTimeBar.setId(i12);
            defaultTimeBar.setLayoutParams(findViewById4.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById4.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById4);
            viewGroup.removeView(findViewById4);
            viewGroup.addView(defaultTimeBar, indexOfChild);
            this.f22482p = defaultTimeBar;
        } else {
            cVar = cVar2;
            z18 = z10;
            z19 = z11;
            r92 = 0;
            this.f22482p = null;
        }
        m0 m0Var2 = this.f22482p;
        c cVar3 = cVar;
        if (m0Var2 != null) {
            m0Var2.a(cVar3);
        }
        View findViewById5 = findViewById(R$id.exo_play_pause);
        this.f22462f = findViewById5;
        if (findViewById5 != null) {
            findViewById5.setOnClickListener(cVar3);
        }
        View findViewById6 = findViewById(R$id.exo_prev);
        this.f22458d = findViewById6;
        if (findViewById6 != null) {
            findViewById6.setOnClickListener(cVar3);
        }
        View findViewById7 = findViewById(R$id.exo_next);
        this.f22460e = findViewById7;
        if (findViewById7 != null) {
            findViewById7.setOnClickListener(cVar3);
        }
        Typeface font = ResourcesCompat.getFont(context, R$font.roboto_medium_numbers);
        View findViewById8 = findViewById(R$id.exo_rew);
        TextView textView = findViewById8 == null ? (TextView) findViewById(R$id.exo_rew_with_amount) : r92;
        this.f22470j = textView;
        if (textView != null) {
            textView.setTypeface(font);
        }
        findViewById8 = findViewById8 == null ? textView : findViewById8;
        this.f22466h = findViewById8;
        if (findViewById8 != null) {
            findViewById8.setOnClickListener(cVar3);
        }
        View findViewById9 = findViewById(R$id.exo_ffwd);
        TextView textView2 = findViewById9 == null ? (TextView) findViewById(R$id.exo_ffwd_with_amount) : r92;
        this.f22468i = textView2;
        if (textView2 != null) {
            textView2.setTypeface(font);
        }
        findViewById9 = findViewById9 == null ? textView2 : findViewById9;
        this.f22464g = findViewById9;
        if (findViewById9 != null) {
            findViewById9.setOnClickListener(cVar3);
        }
        ImageView imageView4 = (ImageView) findViewById(R$id.exo_repeat_toggle);
        this.f22472k = imageView4;
        if (imageView4 != null) {
            imageView4.setOnClickListener(cVar3);
        }
        ImageView imageView5 = (ImageView) findViewById(R$id.exo_shuffle);
        this.f22474l = imageView5;
        if (imageView5 != null) {
            imageView5.setOnClickListener(cVar3);
        }
        this.f22473k0 = context.getResources();
        this.D = r2.getInteger(R$integer.exo_media_button_opacity_percentage_enabled) / 100.0f;
        this.E = this.f22473k0.getInteger(R$integer.exo_media_button_opacity_percentage_disabled) / 100.0f;
        View findViewById10 = findViewById(R$id.exo_vr);
        this.f22476m = findViewById10;
        if (findViewById10 != null) {
            v0(false, findViewById10);
        }
        h0 h0Var = new h0(this);
        this.f22471j0 = h0Var;
        h0Var.X(z18);
        this.f22477m0 = new h(new String[]{this.f22473k0.getString(R$string.exo_controls_playback_speed), this.f22473k0.getString(R$string.exo_track_selection_title_audio)}, new Drawable[]{this.f22473k0.getDrawable(R$drawable.exo_styled_controls_speed), this.f22473k0.getDrawable(R$drawable.exo_styled_controls_audiotrack)});
        this.f22485q0 = this.f22473k0.getDimensionPixelSize(R$dimen.exo_settings_offset);
        RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(context).inflate(R$layout.exo_styled_settings_list, (ViewGroup) r92);
        this.f22475l0 = recyclerView;
        recyclerView.setAdapter(this.f22477m0);
        this.f22475l0.setLayoutManager(new LinearLayoutManager(getContext()));
        PopupWindow popupWindow = new PopupWindow((View) this.f22475l0, -2, -2, true);
        this.f22481o0 = popupWindow;
        if (com.google.android.exoplayer2.util.j0.f22990a < 23) {
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        }
        this.f22481o0.setOnDismissListener(cVar3);
        this.f22483p0 = true;
        this.f22493u0 = new com.google.android.exoplayer2.ui.f(getResources());
        this.H = this.f22473k0.getDrawable(R$drawable.exo_styled_controls_subtitle_on);
        this.I = this.f22473k0.getDrawable(R$drawable.exo_styled_controls_subtitle_off);
        this.J = this.f22473k0.getString(R$string.exo_controls_cc_enabled_description);
        this.K = this.f22473k0.getString(R$string.exo_controls_cc_disabled_description);
        this.f22489s0 = new j();
        this.f22491t0 = new b();
        this.f22479n0 = new e(this.f22473k0.getStringArray(R$array.exo_playback_speeds), this.f22473k0.getIntArray(R$array.exo_speed_multiplied_by_100));
        this.L = this.f22473k0.getDrawable(R$drawable.exo_styled_controls_fullscreen_exit);
        this.M = this.f22473k0.getDrawable(R$drawable.exo_styled_controls_fullscreen_enter);
        this.f22494v = this.f22473k0.getDrawable(R$drawable.exo_styled_controls_repeat_off);
        this.f22496w = this.f22473k0.getDrawable(R$drawable.exo_styled_controls_repeat_one);
        this.f22498x = this.f22473k0.getDrawable(R$drawable.exo_styled_controls_repeat_all);
        this.B = this.f22473k0.getDrawable(R$drawable.exo_styled_controls_shuffle_on);
        this.C = this.f22473k0.getDrawable(R$drawable.exo_styled_controls_shuffle_off);
        this.N = this.f22473k0.getString(R$string.exo_controls_fullscreen_exit_description);
        this.O = this.f22473k0.getString(R$string.exo_controls_fullscreen_enter_description);
        this.f22500y = this.f22473k0.getString(R$string.exo_controls_repeat_off_description);
        this.f22502z = this.f22473k0.getString(R$string.exo_controls_repeat_one_description);
        this.A = this.f22473k0.getString(R$string.exo_controls_repeat_all_description);
        this.F = this.f22473k0.getString(R$string.exo_controls_shuffle_on_description);
        this.G = this.f22473k0.getString(R$string.exo_controls_shuffle_off_description);
        this.f22471j0.Y((ViewGroup) findViewById(R$id.exo_bottom_bar), true);
        this.f22471j0.Y(this.f22464g, z13);
        this.f22471j0.Y(this.f22466h, z12);
        this.f22471j0.Y(this.f22458d, z14);
        this.f22471j0.Y(this.f22460e, z15);
        this.f22471j0.Y(this.f22474l, z16);
        this.f22471j0.Y(this.f22495v0, z17);
        this.f22471j0.Y(this.f22476m, z19);
        this.f22471j0.Y(this.f22472k, this.f22459d0 != 0);
        addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.google.android.exoplayer2.ui.n
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20) {
                StyledPlayerControlView.this.m0(view, i13, i14, i15, i16, i17, i18, i19, i20);
            }
        });
    }
}
