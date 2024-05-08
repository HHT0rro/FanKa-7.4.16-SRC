package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.f1;
import com.google.android.exoplayer2.g1;
import com.google.android.exoplayer2.h1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.w0;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class PlayerView extends FrameLayout implements b {
    public int A;
    public boolean B;

    /* renamed from: b, reason: collision with root package name */
    public final a f22425b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final AspectRatioFrameLayout f22426c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final View f22427d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public final View f22428e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f22429f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public final ImageView f22430g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public final SubtitleView f22431h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public final View f22432i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public final TextView f22433j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public final PlayerControlView f22434k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public final FrameLayout f22435l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public final FrameLayout f22436m;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    public Player f22437n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f22438o;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    public PlayerControlView.e f22439p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f22440q;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public Drawable f22441r;

    /* renamed from: s, reason: collision with root package name */
    public int f22442s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f22443t;

    /* renamed from: u, reason: collision with root package name */
    @Nullable
    public com.google.android.exoplayer2.util.g<? super PlaybackException> f22444u;

    /* renamed from: v, reason: collision with root package name */
    @Nullable
    public CharSequence f22445v;

    /* renamed from: w, reason: collision with root package name */
    public int f22446w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f22447x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f22448y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f22449z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class a implements Player.e, View.OnLayoutChangeListener, View.OnClickListener, PlayerControlView.e {

        /* renamed from: b, reason: collision with root package name */
        public final Timeline.b f22450b = new Timeline.b();

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        public Object f22451c;

        public a() {
        }

        @Override // com.google.android.exoplayer2.ui.PlayerControlView.e
        public void a(int i10) {
            PlayerView.this.I();
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onAvailableCommandsChanged(Player.b bVar) {
            h1.c(this, bVar);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PlayerView.this.F();
        }

        @Override // com.google.android.exoplayer2.Player.e, e6.j
        public void onCues(List<e6.a> list) {
            if (PlayerView.this.f22431h != null) {
                PlayerView.this.f22431h.onCues(list);
            }
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

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            PlayerView.o((TextureView) view, PlayerView.this.A);
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
        public void onPlayWhenReadyChanged(boolean z10, int i10) {
            PlayerView.this.H();
            PlayerView.this.J();
        }

        @Override // com.google.android.exoplayer2.Player.c
        public /* synthetic */ void onPlaybackParametersChanged(f1 f1Var) {
            h1.n(this, f1Var);
        }

        @Override // com.google.android.exoplayer2.Player.c
        public void onPlaybackStateChanged(int i10) {
            PlayerView.this.H();
            PlayerView.this.K();
            PlayerView.this.J();
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
        public void onPositionDiscontinuity(Player.f fVar, Player.f fVar2, int i10) {
            if (PlayerView.this.w() && PlayerView.this.f22448y) {
                PlayerView.this.u();
            }
        }

        @Override // com.google.android.exoplayer2.Player.e, q6.l
        public void onRenderedFirstFrame() {
            if (PlayerView.this.f22427d != null) {
                PlayerView.this.f22427d.setVisibility(4);
            }
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
        public void onTracksChanged(TrackGroupArray trackGroupArray, n6.h hVar) {
            Player player = (Player) com.google.android.exoplayer2.util.a.e(PlayerView.this.f22437n);
            Timeline E = player.E();
            if (E.q()) {
                this.f22451c = null;
            } else if (!player.n().c()) {
                this.f22451c = E.g(player.s(), this.f22450b, true).f19657b;
            } else {
                Object obj = this.f22451c;
                if (obj != null) {
                    int b4 = E.b(obj);
                    if (b4 != -1) {
                        if (player.A() == E.f(b4, this.f22450b).f19658c) {
                            return;
                        }
                    }
                    this.f22451c = null;
                }
            }
            PlayerView.this.L(false);
        }

        @Override // q6.l
        public /* synthetic */ void onVideoSizeChanged(int i10, int i11, int i12, float f10) {
            q6.k.a(this, i10, i11, i12, f10);
        }

        @Override // com.google.android.exoplayer2.Player.e, q6.l
        public void onVideoSizeChanged(q6.y yVar) {
            PlayerView.this.G();
        }

        @Override // com.google.android.exoplayer2.Player.e, x4.f
        public /* synthetic */ void onVolumeChanged(float f10) {
            h1.E(this, f10);
        }
    }

    public PlayerView(Context context) {
        this(context, null);
    }

    public static void B(AspectRatioFrameLayout aspectRatioFrameLayout, int i10) {
        aspectRatioFrameLayout.setResizeMode(i10);
    }

    public static void o(TextureView textureView, int i10) {
        Matrix matrix = new Matrix();
        float width = textureView.getWidth();
        float height = textureView.getHeight();
        if (width != 0.0f && height != 0.0f && i10 != 0) {
            float f10 = width / 2.0f;
            float f11 = height / 2.0f;
            matrix.postRotate(i10, f10, f11);
            RectF rectF = new RectF(0.0f, 0.0f, width, height);
            RectF rectF2 = new RectF();
            matrix.mapRect(rectF2, rectF);
            matrix.postScale(width / rectF2.width(), height / rectF2.height(), f10, f11);
        }
        textureView.setTransform(matrix);
    }

    public static void q(Resources resources, ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(R$drawable.exo_edit_mode_logo));
        imageView.setBackgroundColor(resources.getColor(R$color.exo_edit_mode_background_color));
    }

    @RequiresApi(23)
    public static void r(Resources resources, ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(R$drawable.exo_edit_mode_logo, null));
        imageView.setBackgroundColor(resources.getColor(R$color.exo_edit_mode_background_color, null));
    }

    public final boolean A(@Nullable Drawable drawable) {
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                y(this.f22426c, intrinsicWidth / intrinsicHeight);
                this.f22430g.setImageDrawable(drawable);
                this.f22430g.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    public final boolean C() {
        Player player = this.f22437n;
        if (player == null) {
            return true;
        }
        int playbackState = player.getPlaybackState();
        return this.f22447x && (playbackState == 1 || playbackState == 4 || !this.f22437n.o());
    }

    public void D() {
        E(C());
    }

    public final void E(boolean z10) {
        if (N()) {
            this.f22434k.setShowTimeoutMs(z10 ? 0 : this.f22446w);
            this.f22434k.Q();
        }
    }

    public final boolean F() {
        if (!N() || this.f22437n == null) {
            return false;
        }
        if (!this.f22434k.J()) {
            x(true);
        } else if (this.f22449z) {
            this.f22434k.G();
        }
        return true;
    }

    public final void G() {
        Player player = this.f22437n;
        q6.y L = player != null ? player.L() : q6.y.f53146e;
        int i10 = L.f53148a;
        int i11 = L.f53149b;
        int i12 = L.f53150c;
        float f10 = (i11 == 0 || i10 == 0) ? 0.0f : (i10 * L.f53151d) / i11;
        View view = this.f22428e;
        if (view instanceof TextureView) {
            if (f10 > 0.0f && (i12 == 90 || i12 == 270)) {
                f10 = 1.0f / f10;
            }
            if (this.A != 0) {
                view.removeOnLayoutChangeListener(this.f22425b);
            }
            this.A = i12;
            if (i12 != 0) {
                this.f22428e.addOnLayoutChangeListener(this.f22425b);
            }
            o((TextureView) this.f22428e, this.A);
        }
        y(this.f22426c, this.f22429f ? 0.0f : f10);
    }

    public final void H() {
        int i10;
        if (this.f22432i != null) {
            Player player = this.f22437n;
            boolean z10 = true;
            if (player == null || player.getPlaybackState() != 2 || ((i10 = this.f22442s) != 2 && (i10 != 1 || !this.f22437n.o()))) {
                z10 = false;
            }
            this.f22432i.setVisibility(z10 ? 0 : 8);
        }
    }

    public final void I() {
        PlayerControlView playerControlView = this.f22434k;
        if (playerControlView != null && this.f22438o) {
            if (playerControlView.getVisibility() == 0) {
                setContentDescription(this.f22449z ? getResources().getString(R$string.exo_controls_hide) : null);
                return;
            } else {
                setContentDescription(getResources().getString(R$string.exo_controls_show));
                return;
            }
        }
        setContentDescription(null);
    }

    public final void J() {
        if (w() && this.f22448y) {
            u();
        } else {
            x(false);
        }
    }

    public final void K() {
        com.google.android.exoplayer2.util.g<? super PlaybackException> gVar;
        TextView textView = this.f22433j;
        if (textView != null) {
            CharSequence charSequence = this.f22445v;
            if (charSequence != null) {
                textView.setText(charSequence);
                this.f22433j.setVisibility(0);
                return;
            }
            Player player = this.f22437n;
            PlaybackException k10 = player != null ? player.k() : null;
            if (k10 != null && (gVar = this.f22444u) != null) {
                this.f22433j.setText((CharSequence) gVar.a(k10).second);
                this.f22433j.setVisibility(0);
            } else {
                this.f22433j.setVisibility(8);
            }
        }
    }

    public final void L(boolean z10) {
        Player player = this.f22437n;
        if (player != null && !player.n().c()) {
            if (z10 && !this.f22443t) {
                p();
            }
            n6.h I = player.I();
            for (int i10 = 0; i10 < I.f52141a; i10++) {
                n6.g a10 = I.a(i10);
                if (a10 != null) {
                    for (int i11 = 0; i11 < a10.length(); i11++) {
                        if (com.google.android.exoplayer2.util.q.l(a10.p(i11).f19544m) == 2) {
                            t();
                            return;
                        }
                    }
                }
            }
            p();
            if (M() && (z(player.S()) || A(this.f22441r))) {
                return;
            }
            t();
            return;
        }
        if (this.f22443t) {
            return;
        }
        t();
        p();
    }

    public final boolean M() {
        if (!this.f22440q) {
            return false;
        }
        com.google.android.exoplayer2.util.a.i(this.f22430g);
        return true;
    }

    public final boolean N() {
        if (!this.f22438o) {
            return false;
        }
        com.google.android.exoplayer2.util.a.i(this.f22434k);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Player player = this.f22437n;
        if (player != null && player.f()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        boolean v2 = v(keyEvent.getKeyCode());
        if (v2 && N() && !this.f22434k.J()) {
            x(true);
        } else {
            if (!s(keyEvent) && !super.dispatchKeyEvent(keyEvent)) {
                if (!v2 || !N()) {
                    return false;
                }
                x(true);
                return false;
            }
            x(true);
        }
        return true;
    }

    public List<com.google.android.exoplayer2.ui.a> getAdOverlayInfos() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.f22436m;
        if (frameLayout != null) {
            arrayList.add(new com.google.android.exoplayer2.ui.a(frameLayout, 3, "Transparent overlay does not impact viewability"));
        }
        PlayerControlView playerControlView = this.f22434k;
        if (playerControlView != null) {
            arrayList.add(new com.google.android.exoplayer2.ui.a(playerControlView, 0));
        }
        return ImmutableList.copyOf((Collection) arrayList);
    }

    public ViewGroup getAdViewGroup() {
        return (ViewGroup) com.google.android.exoplayer2.util.a.j(this.f22435l, "exo_ad_overlay must be present for ad playback");
    }

    public boolean getControllerAutoShow() {
        return this.f22447x;
    }

    public boolean getControllerHideOnTouch() {
        return this.f22449z;
    }

    public int getControllerShowTimeoutMs() {
        return this.f22446w;
    }

    @Nullable
    public Drawable getDefaultArtwork() {
        return this.f22441r;
    }

    @Nullable
    public FrameLayout getOverlayFrameLayout() {
        return this.f22436m;
    }

    @Nullable
    public Player getPlayer() {
        return this.f22437n;
    }

    public int getResizeMode() {
        com.google.android.exoplayer2.util.a.i(this.f22426c);
        return this.f22426c.getResizeMode();
    }

    @Nullable
    public SubtitleView getSubtitleView() {
        return this.f22431h;
    }

    public boolean getUseArtwork() {
        return this.f22440q;
    }

    public boolean getUseController() {
        return this.f22438o;
    }

    @Nullable
    public View getVideoSurfaceView() {
        return this.f22428e;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!N() || this.f22437n == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1 || !this.B) {
                return false;
            }
            this.B = false;
            performClick();
            return true;
        }
        this.B = true;
        return true;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!N() || this.f22437n == null) {
            return false;
        }
        x(true);
        return true;
    }

    public final void p() {
        View view = this.f22427d;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        super.performClick();
        return F();
    }

    public boolean s(KeyEvent keyEvent) {
        return N() && this.f22434k.B(keyEvent);
    }

    public void setAspectRatioListener(@Nullable AspectRatioFrameLayout.b bVar) {
        com.google.android.exoplayer2.util.a.i(this.f22426c);
        this.f22426c.setAspectRatioListener(bVar);
    }

    @Deprecated
    public void setControlDispatcher(com.google.android.exoplayer2.i iVar) {
        com.google.android.exoplayer2.util.a.i(this.f22434k);
        this.f22434k.setControlDispatcher(iVar);
    }

    public void setControllerAutoShow(boolean z10) {
        this.f22447x = z10;
    }

    public void setControllerHideDuringAds(boolean z10) {
        this.f22448y = z10;
    }

    public void setControllerHideOnTouch(boolean z10) {
        com.google.android.exoplayer2.util.a.i(this.f22434k);
        this.f22449z = z10;
        I();
    }

    public void setControllerShowTimeoutMs(int i10) {
        com.google.android.exoplayer2.util.a.i(this.f22434k);
        this.f22446w = i10;
        if (this.f22434k.J()) {
            D();
        }
    }

    public void setControllerVisibilityListener(@Nullable PlayerControlView.e eVar) {
        com.google.android.exoplayer2.util.a.i(this.f22434k);
        PlayerControlView.e eVar2 = this.f22439p;
        if (eVar2 == eVar) {
            return;
        }
        if (eVar2 != null) {
            this.f22434k.K(eVar2);
        }
        this.f22439p = eVar;
        if (eVar != null) {
            this.f22434k.z(eVar);
        }
    }

    public void setCustomErrorMessage(@Nullable CharSequence charSequence) {
        com.google.android.exoplayer2.util.a.g(this.f22433j != null);
        this.f22445v = charSequence;
        K();
    }

    public void setDefaultArtwork(@Nullable Drawable drawable) {
        if (this.f22441r != drawable) {
            this.f22441r = drawable;
            L(false);
        }
    }

    public void setErrorMessageProvider(@Nullable com.google.android.exoplayer2.util.g<? super PlaybackException> gVar) {
        if (this.f22444u != gVar) {
            this.f22444u = gVar;
            K();
        }
    }

    public void setExtraAdGroupMarkers(@Nullable long[] jArr, @Nullable boolean[] zArr) {
        com.google.android.exoplayer2.util.a.i(this.f22434k);
        this.f22434k.setExtraAdGroupMarkers(jArr, zArr);
    }

    public void setKeepContentOnPlayerReset(boolean z10) {
        if (this.f22443t != z10) {
            this.f22443t = z10;
            L(false);
        }
    }

    public void setPlayer(@Nullable Player player) {
        com.google.android.exoplayer2.util.a.g(Looper.myLooper() == Looper.getMainLooper());
        com.google.android.exoplayer2.util.a.a(player == null || player.F() == Looper.getMainLooper());
        Player player2 = this.f22437n;
        if (player2 == player) {
            return;
        }
        if (player2 != null) {
            player2.h(this.f22425b);
            if (player2.m(26)) {
                View view = this.f22428e;
                if (view instanceof TextureView) {
                    player2.t((TextureView) view);
                } else if (view instanceof SurfaceView) {
                    player2.P((SurfaceView) view);
                }
            }
        }
        SubtitleView subtitleView = this.f22431h;
        if (subtitleView != null) {
            subtitleView.setCues(null);
        }
        this.f22437n = player;
        if (N()) {
            this.f22434k.setPlayer(player);
        }
        H();
        K();
        L(true);
        if (player != null) {
            if (player.m(26)) {
                View view2 = this.f22428e;
                if (view2 instanceof TextureView) {
                    player.H((TextureView) view2);
                } else if (view2 instanceof SurfaceView) {
                    player.j((SurfaceView) view2);
                }
                G();
            }
            if (this.f22431h != null && player.m(27)) {
                this.f22431h.setCues(player.C());
            }
            player.N(this.f22425b);
            x(false);
            return;
        }
        u();
    }

    public void setRepeatToggleModes(int i10) {
        com.google.android.exoplayer2.util.a.i(this.f22434k);
        this.f22434k.setRepeatToggleModes(i10);
    }

    public void setResizeMode(int i10) {
        com.google.android.exoplayer2.util.a.i(this.f22426c);
        this.f22426c.setResizeMode(i10);
    }

    public void setShowBuffering(int i10) {
        if (this.f22442s != i10) {
            this.f22442s = i10;
            H();
        }
    }

    public void setShowFastForwardButton(boolean z10) {
        com.google.android.exoplayer2.util.a.i(this.f22434k);
        this.f22434k.setShowFastForwardButton(z10);
    }

    public void setShowMultiWindowTimeBar(boolean z10) {
        com.google.android.exoplayer2.util.a.i(this.f22434k);
        this.f22434k.setShowMultiWindowTimeBar(z10);
    }

    public void setShowNextButton(boolean z10) {
        com.google.android.exoplayer2.util.a.i(this.f22434k);
        this.f22434k.setShowNextButton(z10);
    }

    public void setShowPreviousButton(boolean z10) {
        com.google.android.exoplayer2.util.a.i(this.f22434k);
        this.f22434k.setShowPreviousButton(z10);
    }

    public void setShowRewindButton(boolean z10) {
        com.google.android.exoplayer2.util.a.i(this.f22434k);
        this.f22434k.setShowRewindButton(z10);
    }

    public void setShowShuffleButton(boolean z10) {
        com.google.android.exoplayer2.util.a.i(this.f22434k);
        this.f22434k.setShowShuffleButton(z10);
    }

    public void setShutterBackgroundColor(int i10) {
        View view = this.f22427d;
        if (view != null) {
            view.setBackgroundColor(i10);
        }
    }

    public void setUseArtwork(boolean z10) {
        com.google.android.exoplayer2.util.a.g((z10 && this.f22430g == null) ? false : true);
        if (this.f22440q != z10) {
            this.f22440q = z10;
            L(false);
        }
    }

    public void setUseController(boolean z10) {
        com.google.android.exoplayer2.util.a.g((z10 && this.f22434k == null) ? false : true);
        if (this.f22438o == z10) {
            return;
        }
        this.f22438o = z10;
        if (N()) {
            this.f22434k.setPlayer(this.f22437n);
        } else {
            PlayerControlView playerControlView = this.f22434k;
            if (playerControlView != null) {
                playerControlView.G();
                this.f22434k.setPlayer(null);
            }
        }
        I();
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        View view = this.f22428e;
        if (view instanceof SurfaceView) {
            view.setVisibility(i10);
        }
    }

    public final void t() {
        ImageView imageView = this.f22430g;
        if (imageView != null) {
            imageView.setImageResource(17170445);
            this.f22430g.setVisibility(4);
        }
    }

    public void u() {
        PlayerControlView playerControlView = this.f22434k;
        if (playerControlView != null) {
            playerControlView.G();
        }
    }

    public final boolean v(int i10) {
        return i10 == 19 || i10 == 270 || i10 == 22 || i10 == 271 || i10 == 20 || i10 == 269 || i10 == 21 || i10 == 268 || i10 == 23;
    }

    public final boolean w() {
        Player player = this.f22437n;
        return player != null && player.f() && this.f22437n.o();
    }

    public final void x(boolean z10) {
        if (!(w() && this.f22448y) && N()) {
            boolean z11 = this.f22434k.J() && this.f22434k.getShowTimeoutMs() <= 0;
            boolean C = C();
            if (z10 || z11 || C) {
                E(C);
            }
        }
    }

    public void y(@Nullable AspectRatioFrameLayout aspectRatioFrameLayout, float f10) {
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setAspectRatio(f10);
        }
    }

    public final boolean z(MediaMetadata mediaMetadata) {
        byte[] bArr = mediaMetadata.f19592i;
        if (bArr == null) {
            return false;
        }
        return A(new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length)));
    }

    public PlayerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PlayerView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        int i11;
        boolean z10;
        int i12;
        boolean z11;
        int i13;
        boolean z12;
        int i14;
        int i15;
        boolean z13;
        boolean z14;
        int i16;
        boolean z15;
        boolean z16;
        boolean z17;
        a aVar = new a();
        this.f22425b = aVar;
        if (isInEditMode()) {
            this.f22426c = null;
            this.f22427d = null;
            this.f22428e = null;
            this.f22429f = false;
            this.f22430g = null;
            this.f22431h = null;
            this.f22432i = null;
            this.f22433j = null;
            this.f22434k = null;
            this.f22435l = null;
            this.f22436m = null;
            ImageView imageView = new ImageView(context);
            if (com.google.android.exoplayer2.util.j0.f22990a >= 23) {
                r(getResources(), imageView);
            } else {
                q(getResources(), imageView);
            }
            addView(imageView);
            return;
        }
        int i17 = R$layout.exo_player_view;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.PlayerView, i10, 0);
            try {
                int i18 = R$styleable.PlayerView_shutter_background_color;
                boolean hasValue = obtainStyledAttributes.hasValue(i18);
                int color = obtainStyledAttributes.getColor(i18, 0);
                int resourceId = obtainStyledAttributes.getResourceId(R$styleable.PlayerView_player_layout_id, i17);
                boolean z18 = obtainStyledAttributes.getBoolean(R$styleable.PlayerView_use_artwork, true);
                int resourceId2 = obtainStyledAttributes.getResourceId(R$styleable.PlayerView_default_artwork, 0);
                boolean z19 = obtainStyledAttributes.getBoolean(R$styleable.PlayerView_use_controller, true);
                int i19 = obtainStyledAttributes.getInt(R$styleable.PlayerView_surface_type, 1);
                int i20 = obtainStyledAttributes.getInt(R$styleable.PlayerView_resize_mode, 0);
                int i21 = obtainStyledAttributes.getInt(R$styleable.PlayerView_show_timeout, 5000);
                boolean z20 = obtainStyledAttributes.getBoolean(R$styleable.PlayerView_hide_on_touch, true);
                boolean z21 = obtainStyledAttributes.getBoolean(R$styleable.PlayerView_auto_show, true);
                i13 = obtainStyledAttributes.getInteger(R$styleable.PlayerView_show_buffering, 0);
                this.f22443t = obtainStyledAttributes.getBoolean(R$styleable.PlayerView_keep_content_on_player_reset, this.f22443t);
                boolean z22 = obtainStyledAttributes.getBoolean(R$styleable.PlayerView_hide_during_ads, true);
                obtainStyledAttributes.recycle();
                z12 = z20;
                z10 = z21;
                i12 = i20;
                z15 = z19;
                i16 = resourceId2;
                z14 = z18;
                z13 = hasValue;
                i15 = color;
                i14 = i19;
                i17 = resourceId;
                i11 = i21;
                z11 = z22;
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            i11 = 5000;
            z10 = true;
            i12 = 0;
            z11 = true;
            i13 = 0;
            z12 = true;
            i14 = 1;
            i15 = 0;
            z13 = false;
            z14 = true;
            i16 = 0;
            z15 = true;
        }
        LayoutInflater.from(context).inflate(i17, this);
        setDescendantFocusability(262144);
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) findViewById(R$id.exo_content_frame);
        this.f22426c = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            B(aspectRatioFrameLayout, i12);
        }
        View findViewById = findViewById(R$id.exo_shutter);
        this.f22427d = findViewById;
        if (findViewById != null && z13) {
            findViewById.setBackgroundColor(i15);
        }
        if (aspectRatioFrameLayout != null && i14 != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (i14 == 2) {
                this.f22428e = new TextureView(context);
            } else if (i14 == 3) {
                try {
                    this.f22428e = (View) Class.forName("com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView").getConstructor(Context.class).newInstance(context);
                    z17 = true;
                    this.f22428e.setLayoutParams(layoutParams);
                    this.f22428e.setOnClickListener(aVar);
                    this.f22428e.setClickable(false);
                    aspectRatioFrameLayout.addView(this.f22428e, 0);
                    z16 = z17;
                } catch (Exception e2) {
                    throw new IllegalStateException("spherical_gl_surface_view requires an ExoPlayer dependency", e2);
                }
            } else if (i14 != 4) {
                this.f22428e = new SurfaceView(context);
            } else {
                try {
                    this.f22428e = (View) Class.forName("com.google.android.exoplayer2.video.VideoDecoderGLSurfaceView").getConstructor(Context.class).newInstance(context);
                } catch (Exception e10) {
                    throw new IllegalStateException("video_decoder_gl_surface_view requires an ExoPlayer dependency", e10);
                }
            }
            z17 = false;
            this.f22428e.setLayoutParams(layoutParams);
            this.f22428e.setOnClickListener(aVar);
            this.f22428e.setClickable(false);
            aspectRatioFrameLayout.addView(this.f22428e, 0);
            z16 = z17;
        } else {
            this.f22428e = null;
            z16 = false;
        }
        this.f22429f = z16;
        this.f22435l = (FrameLayout) findViewById(R$id.exo_ad_overlay);
        this.f22436m = (FrameLayout) findViewById(R$id.exo_overlay);
        ImageView imageView2 = (ImageView) findViewById(R$id.exo_artwork);
        this.f22430g = imageView2;
        this.f22440q = z14 && imageView2 != null;
        if (i16 != 0) {
            this.f22441r = ContextCompat.getDrawable(getContext(), i16);
        }
        SubtitleView subtitleView = (SubtitleView) findViewById(R$id.exo_subtitles);
        this.f22431h = subtitleView;
        if (subtitleView != null) {
            subtitleView.setUserDefaultStyle();
            subtitleView.setUserDefaultTextSize();
        }
        View findViewById2 = findViewById(R$id.exo_buffering);
        this.f22432i = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setVisibility(8);
        }
        this.f22442s = i13;
        TextView textView = (TextView) findViewById(R$id.exo_error_message);
        this.f22433j = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        int i22 = R$id.exo_controller;
        PlayerControlView playerControlView = (PlayerControlView) findViewById(i22);
        View findViewById3 = findViewById(R$id.exo_controller_placeholder);
        if (playerControlView != null) {
            this.f22434k = playerControlView;
        } else if (findViewById3 != null) {
            PlayerControlView playerControlView2 = new PlayerControlView(context, null, 0, attributeSet);
            this.f22434k = playerControlView2;
            playerControlView2.setId(i22);
            playerControlView2.setLayoutParams(findViewById3.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById3.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById3);
            viewGroup.removeView(findViewById3);
            viewGroup.addView(playerControlView2, indexOfChild);
        } else {
            this.f22434k = null;
        }
        PlayerControlView playerControlView3 = this.f22434k;
        this.f22446w = playerControlView3 != null ? i11 : 0;
        this.f22449z = z12;
        this.f22447x = z10;
        this.f22448y = z11;
        this.f22438o = z15 && playerControlView3 != null;
        u();
        I();
        PlayerControlView playerControlView4 = this.f22434k;
        if (playerControlView4 != null) {
            playerControlView4.z(aVar);
        }
    }
}
