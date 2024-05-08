package com.cupidapp.live.feed.layout;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.VideoModel;
import com.cupidapp.live.base.utils.k0;
import com.cupidapp.live.base.video.ExoMediaPlayer;
import com.cupidapp.live.feed.FeedType;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.liveshow.miniwindow.FKLiveMiniWindow;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FeedVideoContentLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedVideoContentLayout extends FrameLayout implements ExoMediaPlayer.b {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public d2.a f14508b;

    /* renamed from: c, reason: collision with root package name */
    public float f14509c;

    /* renamed from: d, reason: collision with root package name */
    public float f14510d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f14511e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f14512f;

    /* renamed from: g, reason: collision with root package name */
    public final int f14513g;

    /* renamed from: h, reason: collision with root package name */
    public final int f14514h;

    /* renamed from: i, reason: collision with root package name */
    public final int f14515i;

    /* renamed from: j, reason: collision with root package name */
    public int f14516j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public String f14517k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public FeedModel f14518l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14519m;

    /* compiled from: FeedVideoContentLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14520a;

        static {
            int[] iArr = new int[ExoMediaPlayer.PlayState.values().length];
            try {
                iArr[ExoMediaPlayer.PlayState.READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ExoMediaPlayer.PlayState.IDLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ExoMediaPlayer.PlayState.ENDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ExoMediaPlayer.PlayState.PERIOD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f14520a = iArr;
        }
    }

    /* compiled from: FeedVideoContentLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b extends k0 {
        public b() {
            super(300L);
        }

        @Override // com.cupidapp.live.base.utils.k0
        public void c(@Nullable View view) {
            d2.a feedVideoClickListener = FeedVideoContentLayout.this.getFeedVideoClickListener();
            if (feedVideoClickListener != null) {
                feedVideoClickListener.d();
            }
            FeedVideoContentLayout.this.e();
        }

        @Override // com.cupidapp.live.base.utils.k0
        public void d(@Nullable View view) {
            d2.a feedVideoClickListener = FeedVideoContentLayout.this.getFeedVideoClickListener();
            if (feedVideoClickListener != null) {
                feedVideoClickListener.e(FeedVideoContentLayout.this.f14509c, FeedVideoContentLayout.this.f14510d);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FeedVideoContentLayout(@NotNull Context context) {
        this(context, null, 0);
        kotlin.jvm.internal.s.i(context, "context");
    }

    private final String getVideoUrl() {
        VideoModel video;
        if (this.f14516j == this.f14514h) {
            return this.f14517k;
        }
        FeedModel feedModel = this.f14518l;
        if (feedModel == null || (video = feedModel.getVideo()) == null) {
            return null;
        }
        return video.getUrl();
    }

    @Override // com.cupidapp.live.base.video.ExoMediaPlayer.b
    public void a(@NotNull ExoMediaPlayer.PlayState state) {
        kotlin.jvm.internal.s.i(state, "state");
        int i10 = a.f14520a[state.ordinal()];
        if (i10 != 1) {
            if (i10 == 2 || i10 == 3) {
                this.f14511e = false;
                this.f14512f = false;
                h();
                return;
            }
            return;
        }
        if (this.f14511e) {
            return;
        }
        this.f14511e = true;
        ((ImageLoaderView) b(R$id.feedVideoCover)).setVisibility(8);
        ((ProgressBar) b(R$id.feedVideoProgressbar)).setVisibility(8);
        int i11 = this.f14516j;
        if (i11 == this.f14513g || i11 == this.f14515i) {
            g();
        }
    }

    @Nullable
    public View b(int i10) {
        Map<Integer, View> map = this.f14519m;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void e() {
        try {
            p1.g gVar = p1.g.f52734a;
            boolean z10 = true;
            gVar.R2(!gVar.q0());
            FKLiveMiniWindow a10 = FKLiveMiniWindow.f15074m.a();
            if (gVar.q0()) {
                z10 = false;
            }
            a10.p0(z10);
            ExoMediaPlayer.f12408a.n(gVar.q0());
            g();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void f(boolean z10) {
        p1.g gVar = p1.g.f52734a;
        gVar.R2(!z10);
        ExoMediaPlayer.f12408a.n(gVar.q0());
        g();
    }

    public final void g() {
        Context context;
        int i10;
        int i11 = R$id.feedVideoSoundSwitch;
        ((TextView) b(i11)).setVisibility(0);
        ((TextView) b(i11)).getPaint().setFakeBoldText(true);
        if (p1.g.f52734a.q0()) {
            ((TextView) b(i11)).setCompoundDrawablesWithIntrinsicBounds(R$mipmap.icon_sound_off, 0, 0, 0);
            TextView textView = (TextView) b(i11);
            if (this.f14516j == this.f14513g) {
                context = getContext();
                i10 = R$string.tap_screen_to_play_the_sound;
            } else {
                context = getContext();
                i10 = R$string.tap_button_to_play_the_sound;
            }
            textView.setText(context.getString(i10));
            return;
        }
        ((TextView) b(i11)).setCompoundDrawablesRelativeWithIntrinsicBounds(R$mipmap.icon_sound_on, 0, 0, 0);
        ((TextView) b(i11)).setText("");
    }

    @Nullable
    public final FeedModel getFeedModel() {
        return this.f14518l;
    }

    @Nullable
    public final d2.a getFeedVideoClickListener() {
        return this.f14508b;
    }

    public final void h() {
        FrameLayout frameLayout = (FrameLayout) b(R$id.feedVideoContainer);
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        RelativeLayout relativeLayout = (RelativeLayout) b(R$id.feedVideoPlayButton);
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        ImageLoaderView imageLoaderView = (ImageLoaderView) b(R$id.feedVideoCover);
        if (imageLoaderView != null) {
            imageLoaderView.setVisibility(0);
        }
        TextView textView = (TextView) b(R$id.feedVideoSoundSwitch);
        if (textView != null) {
            textView.setVisibility(8);
        }
        FKLiveMiniWindow.f15074m.a().p0(!p1.g.f52734a.q0());
    }

    public final void i() {
        int i10 = this.f14516j;
        if (i10 == this.f14513g) {
            setOnClickListener(new b());
        } else if (i10 == this.f14515i) {
            g();
            TextView feedVideoSoundSwitch = (TextView) b(R$id.feedVideoSoundSwitch);
            kotlin.jvm.internal.s.h(feedVideoSoundSwitch, "feedVideoSoundSwitch");
            y.d(feedVideoSoundSwitch, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.FeedVideoContentLayout$initClickEvent$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                    invoke2(view);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable View view) {
                    FeedVideoContentLayout.this.e();
                }
            });
        }
    }

    public final void j(FeedModel feedModel) {
        int i10;
        ImageModel imageListFirst = feedModel.getImageListFirst();
        if (imageListFirst == null) {
            return;
        }
        if (kotlin.jvm.internal.s.d(feedModel.getType(), FeedType.ShowCase.getValue()) && feedModel.getUrl() != null) {
            i10 = this.f14515i;
        } else {
            i10 = this.f14513g;
        }
        this.f14516j = i10;
        int min = Math.min(imageListFirst.getScaleHeightByWidth(z0.h.l(this)), (z0.h.l(this) * 4) / 3);
        int scaleWidthByHeight = imageListFirst.getScaleWidthByHeight(min);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(scaleWidthByHeight, min);
        layoutParams.addRule(3, R$id.feedVideoTopLineView);
        layoutParams.setMargins((z0.h.l(this) - scaleWidthByHeight) / 2, 0, 0, 0);
        int i11 = R$id.feedVideoCover;
        ((ImageLoaderView) b(i11)).setLayoutParams(layoutParams);
        ((FrameLayout) b(R$id.feedVideoContainer)).setLayoutParams(layoutParams);
        b(R$id.feedVideoBottomLineView).setVisibility(feedModel.haveSponsor() ? 8 : 0);
        ViewGroup.LayoutParams layoutParams2 = ((RelativeLayout) b(R$id.feedVideoContentRootLayout)).getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = z0.h.c(this, feedModel.haveSponsor() ? 0.5f : 1.0f) + min;
        }
        ((RelativeLayout) b(R$id.feedVideoPlayButton)).setLayoutParams(new RelativeLayout.LayoutParams(z0.h.l(this), min));
        ImageLoaderView feedVideoCover = (ImageLoaderView) b(i11);
        kotlin.jvm.internal.s.h(feedVideoCover, "feedVideoCover");
        ImageLoaderView.g(feedVideoCover, imageListFirst, null, null, 6, null);
        ((TextView) b(R$id.feedVideoSoundSwitch)).getLayoutParams().width = z0.h.l(this) / 2;
    }

    public final void k() {
        if (this.f14512f) {
            ExoMediaPlayer.f12408a.p();
        }
    }

    public final void l() {
        String videoUrl = getVideoUrl();
        if (videoUrl != null) {
            if (TextUtils.isEmpty(videoUrl)) {
                ((RelativeLayout) b(R$id.feedVideoPlayButton)).setVisibility(8);
                return;
            }
            ((RelativeLayout) b(R$id.feedVideoPlayButton)).setVisibility(8);
            if (this.f14512f) {
                return;
            }
            this.f14512f = true;
            ((ProgressBar) b(R$id.feedVideoProgressbar)).setVisibility(0);
            FrameLayout frameLayout = (FrameLayout) b(R$id.feedVideoContainer);
            ExoMediaPlayer exoMediaPlayer = ExoMediaPlayer.f12408a;
            frameLayout.addView(ExoMediaPlayer.l(exoMediaPlayer, false, 1, null));
            exoMediaPlayer.e(this);
            ExoMediaPlayer.t(exoMediaPlayer, videoUrl, p1.g.f52734a.q0(), null, false, 12, null);
        }
    }

    public final void m() {
        if (this.f14512f && this.f14511e) {
            ExoMediaPlayer.f12408a.v();
        }
    }

    public final void n() {
        if (this.f14512f) {
            ExoMediaPlayer.f12408a.z();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        FrameLayout frameLayout = (FrameLayout) b(R$id.feedVideoContainer);
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        n();
    }

    @Override // android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent motionEvent) {
        boolean z10 = false;
        if (motionEvent != null && motionEvent.getAction() == 0) {
            z10 = true;
        }
        if (z10) {
            this.f14509c = motionEvent.getX();
            this.f14510d = motionEvent.getY();
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void setFeedModel(@Nullable FeedModel feedModel) {
        this.f14518l = feedModel;
        if (feedModel == null) {
            return;
        }
        j(feedModel);
        i();
    }

    public final void setFeedVideoClickListener(@Nullable d2.a aVar) {
        this.f14508b = aVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FeedVideoContentLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        kotlin.jvm.internal.s.i(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedVideoContentLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14519m = new LinkedHashMap();
        this.f14513g = 1;
        this.f14514h = 2;
        this.f14515i = 3;
        this.f14516j = 1;
        z.a(this, R$layout.layout_feed_video_content, true);
    }
}
