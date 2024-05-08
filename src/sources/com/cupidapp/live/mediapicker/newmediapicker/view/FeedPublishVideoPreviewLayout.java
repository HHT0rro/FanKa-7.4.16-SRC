package com.cupidapp.live.mediapicker.newmediapicker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.imageloader.TransformationType;
import com.cupidapp.live.base.imageloader.b;
import com.cupidapp.live.base.video.ExoMediaPlayer;
import com.cupidapp.live.base.view.RoundedFrameLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FeedPublishVideoPreviewLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FeedPublishVideoPreviewLayout extends RoundedFrameLayout {

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public String f17364h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f17365i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17366j;

    /* compiled from: FeedPublishVideoPreviewLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements ExoMediaPlayer.b {

        /* compiled from: FeedPublishVideoPreviewLayout.kt */
        @d
        /* renamed from: com.cupidapp.live.mediapicker.newmediapicker.view.FeedPublishVideoPreviewLayout$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public /* synthetic */ class C0166a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f17368a;

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
                f17368a = iArr;
            }
        }

        public a() {
        }

        @Override // com.cupidapp.live.base.video.ExoMediaPlayer.b
        public void a(@NotNull ExoMediaPlayer.PlayState state) {
            s.i(state, "state");
            int i10 = C0166a.f17368a[state.ordinal()];
            if (i10 != 1) {
                if (i10 == 2 || i10 == 3) {
                    FeedPublishVideoPreviewLayout.this.f17365i = false;
                    return;
                }
                return;
            }
            if (FeedPublishVideoPreviewLayout.this.f17365i) {
                return;
            }
            FeedPublishVideoPreviewLayout.this.f17365i = true;
            ((ImageLoaderView) FeedPublishVideoPreviewLayout.this.c(R$id.videoCover)).setVisibility(8);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FeedPublishVideoPreviewLayout(@NotNull Context context) {
        this(context, null, 0);
        s.i(context, "context");
    }

    @Nullable
    public View c(int i10) {
        Map<Integer, View> map = this.f17366j;
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

    public final void f(@Nullable String str, @Nullable String str2) {
        if (str == null || str.length() == 0) {
            return;
        }
        if (str2 == null || str2.length() == 0) {
            return;
        }
        ImageLoaderView videoCover = (ImageLoaderView) c(R$id.videoCover);
        s.h(videoCover, "videoCover");
        ImageLoaderView.f(videoCover, new b(false, str2, null, null, null, null, null, -1, 0, null, TransformationType.FitCenter, null, null, false, 0, 0, false, null, null, 523133, null), null, 2, null);
        this.f17364h = str;
    }

    public final void g() {
        ExoMediaPlayer.f12408a.p();
    }

    public final void h() {
        if (this.f17365i) {
            ExoMediaPlayer.f12408a.v();
            return;
        }
        FrameLayout frameLayout = (FrameLayout) c(R$id.videoPlayerContainer);
        ExoMediaPlayer exoMediaPlayer = ExoMediaPlayer.f12408a;
        frameLayout.addView(ExoMediaPlayer.l(exoMediaPlayer, false, 1, null));
        exoMediaPlayer.y(new a());
        ExoMediaPlayer.t(exoMediaPlayer, this.f17364h, false, null, false, 14, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        FrameLayout frameLayout = (FrameLayout) c(R$id.videoPlayerContainer);
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        ExoMediaPlayer.f12408a.z();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FeedPublishVideoPreviewLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        s.i(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedPublishVideoPreviewLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f17366j = new LinkedHashMap();
        z.a(this, R$layout.layout_feed_publish_preview_video, true);
    }
}
