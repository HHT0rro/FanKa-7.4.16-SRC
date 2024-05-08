package com.cupidapp.live.mediapicker.newmediapicker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.imageloader.TransformationType;
import com.cupidapp.live.base.imageloader.c;
import com.cupidapp.live.base.video.ExoMediaPlayer;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: VideoPreviewLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VideoPreviewLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Uri f17378b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public a f17379c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f17380d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17381e;

    /* compiled from: VideoPreviewLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        void a(boolean z10);
    }

    /* compiled from: VideoPreviewLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements com.cupidapp.live.base.imageloader.c {
        public b() {
        }

        @Override // com.cupidapp.live.base.imageloader.c
        public void a(@NotNull Drawable drawable) {
            s.i(drawable, "drawable");
            VideoPreviewLayout.this.n();
        }

        @Override // com.cupidapp.live.base.imageloader.c
        public void b() {
            c.a.c(this);
        }

        @Override // com.cupidapp.live.base.imageloader.c
        public void c(@NotNull Bitmap bitmap) {
            c.a.a(this, bitmap);
        }
    }

    /* compiled from: VideoPreviewLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements ExoMediaPlayer.b {

        /* compiled from: VideoPreviewLayout.kt */
        @d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f17384a;

            static {
                int[] iArr = new int[ExoMediaPlayer.PlayState.values().length];
                try {
                    iArr[ExoMediaPlayer.PlayState.READY.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ExoMediaPlayer.PlayState.ENDED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ExoMediaPlayer.PlayState.IDLE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f17384a = iArr;
            }
        }

        public c() {
        }

        @Override // com.cupidapp.live.base.video.ExoMediaPlayer.b
        public void a(@NotNull ExoMediaPlayer.PlayState state) {
            s.i(state, "state");
            int i10 = a.f17384a[state.ordinal()];
            if (i10 == 1) {
                if (VideoPreviewLayout.this.f17380d) {
                    return;
                }
                VideoPreviewLayout.this.f17380d = true;
                VideoPreviewLayout.this.p();
                return;
            }
            if (i10 == 2) {
                VideoPreviewLayout.this.f17380d = false;
                VideoPreviewLayout.this.j();
            } else {
                if (i10 != 3) {
                    return;
                }
                VideoPreviewLayout.this.f17380d = false;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoPreviewLayout(@NotNull Context context) {
        this(context, null, 0);
        s.i(context, "context");
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f17381e;
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

    public final void h(@Nullable Uri uri, @Nullable a aVar) {
        if (uri == null) {
            return;
        }
        this.f17378b = uri;
        this.f17379c = aVar;
        ((ImageLoaderView) a(R$id.ilvVideoCover)).d(new com.cupidapp.live.base.imageloader.b(false, null, null, uri, null, null, null, -16777216, 0, null, TransformationType.FitCenter, null, null, false, 0, 0, false, null, null, 523127, null), new b());
        ImageView ivVideoPlay = (ImageView) a(R$id.ivVideoPlay);
        s.h(ivVideoPlay, "ivVideoPlay");
        y.d(ivVideoPlay, new Function1<View, p>() { // from class: com.cupidapp.live.mediapicker.newmediapicker.view.VideoPreviewLayout$configVideo$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                VideoPreviewLayout.this.k();
            }
        });
        View videoPauseView = a(R$id.videoPauseView);
        s.h(videoPauseView, "videoPauseView");
        y.d(videoPauseView, new Function1<View, p>() { // from class: com.cupidapp.live.mediapicker.newmediapicker.view.VideoPreviewLayout$configVideo$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                VideoPreviewLayout.this.i();
            }
        });
    }

    public final void i() {
        ExoMediaPlayer.f12408a.p();
        n();
        a aVar = this.f17379c;
        if (aVar != null) {
            aVar.a(false);
        }
    }

    public final void j() {
        m();
        n();
        a aVar = this.f17379c;
        if (aVar != null) {
            aVar.a(false);
        }
    }

    public final void k() {
        if (this.f17380d) {
            ExoMediaPlayer.f12408a.v();
        } else {
            FrameLayout frameLayout = (FrameLayout) a(R$id.videoPlayerContainer);
            ExoMediaPlayer exoMediaPlayer = ExoMediaPlayer.f12408a;
            frameLayout.addView(ExoMediaPlayer.l(exoMediaPlayer, false, 1, null));
            exoMediaPlayer.y(new c());
            ExoMediaPlayer.s(exoMediaPlayer, this.f17378b, false, ExoMediaPlayer.PlayMode.SINGLE, false, 10, null);
        }
        o();
        a aVar = this.f17379c;
        if (aVar != null) {
            aVar.a(true);
        }
    }

    public final void l() {
        ExoMediaPlayer.f12408a.z();
        m();
        n();
    }

    public final void m() {
        ((ImageLoaderView) a(R$id.ilvVideoCover)).setVisibility(0);
        ((FrameLayout) a(R$id.videoPlayerContainer)).setVisibility(8);
    }

    public final void n() {
        ((ImageView) a(R$id.ivVideoPlay)).setVisibility(0);
        a(R$id.videoPauseView).setVisibility(8);
    }

    public final void o() {
        ((ImageView) a(R$id.ivVideoPlay)).setVisibility(8);
        a(R$id.videoPauseView).setVisibility(0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        FrameLayout frameLayout = (FrameLayout) a(R$id.videoPlayerContainer);
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
    }

    public final void p() {
        ((ImageLoaderView) a(R$id.ilvVideoCover)).setVisibility(8);
        ((FrameLayout) a(R$id.videoPlayerContainer)).setVisibility(0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoPreviewLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        s.i(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPreviewLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f17381e = new LinkedHashMap();
        z.a(this, R$layout.layout_preview_video, true);
    }
}
