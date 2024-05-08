package com.cupidapp.live.base.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.VideoModel;
import com.cupidapp.live.base.video.ExoMediaPlayer;
import com.cupidapp.live.base.view.RoundedFrameLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: AppVideoLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AppVideoLayout extends RoundedFrameLayout implements ExoMediaPlayer.b {

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public VideoModel f12390h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f12391i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12392j;

    /* compiled from: AppVideoLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12393a;

        static {
            int[] iArr = new int[ExoMediaPlayer.PlayState.values().length];
            try {
                iArr[ExoMediaPlayer.PlayState.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ExoMediaPlayer.PlayState.BUFFERING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ExoMediaPlayer.PlayState.READY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f12393a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppVideoLayout(@NotNull Context context) {
        this(context, null, 0);
        s.i(context, "context");
    }

    @Override // com.cupidapp.live.base.video.ExoMediaPlayer.b
    public void a(@NotNull ExoMediaPlayer.PlayState state) {
        s.i(state, "state");
        int i10 = a.f12393a[state.ordinal()];
        if (i10 == 1 || i10 == 2) {
            ((ImageLoaderView) c(R$id.cover_image)).setVisibility(0);
        } else {
            if (i10 != 3) {
                return;
            }
            ((FrameLayout) c(R$id.video_player_container)).setVisibility(0);
            ((ImageLoaderView) c(R$id.cover_image)).setVisibility(4);
        }
    }

    @Nullable
    public View c(int i10) {
        Map<Integer, View> map = this.f12392j;
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

    public final void d(@Nullable VideoModel videoModel, @Nullable ImageModel imageModel) {
        if (imageModel == null || videoModel == null) {
            return;
        }
        this.f12390h = videoModel;
        ImageLoaderView cover_image = (ImageLoaderView) c(R$id.cover_image);
        s.h(cover_image, "cover_image");
        ImageLoaderView.g(cover_image, imageModel, null, null, 6, null);
    }

    public final void e() {
        VideoModel videoModel = this.f12390h;
        if (videoModel != null) {
            this.f12391i = true;
            ((ImageLoaderView) c(R$id.cover_image)).setVisibility(0);
            FrameLayout frameLayout = (FrameLayout) c(R$id.video_player_container);
            ExoMediaPlayer exoMediaPlayer = ExoMediaPlayer.f12408a;
            frameLayout.addView(exoMediaPlayer.k(true));
            exoMediaPlayer.y(this);
            ExoMediaPlayer.t(exoMediaPlayer, videoModel.getUrl(), true, null, false, 12, null);
        }
    }

    public final void f() {
        this.f12391i = false;
        ((ImageLoaderView) c(R$id.cover_image)).setVisibility(0);
        ((FrameLayout) c(R$id.video_player_container)).setVisibility(4);
        ExoMediaPlayer.f12408a.z();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        FrameLayout frameLayout = (FrameLayout) c(R$id.video_player_container);
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        if (this.f12391i) {
            ExoMediaPlayer.f12408a.z();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppVideoLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        s.i(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppVideoLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f12392j = new LinkedHashMap();
        z.a(this, R$layout.layout_app_video_layout, true);
    }
}
