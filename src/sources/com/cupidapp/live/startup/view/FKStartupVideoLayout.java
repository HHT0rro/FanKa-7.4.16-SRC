package com.cupidapp.live.startup.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.video.ExoMediaPlayer;
import com.cupidapp.live.startup.model.FKAdType;
import com.cupidapp.live.startup.model.FKClickArea;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FKStartupVideoLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKStartupVideoLayout extends FKBaseStartupLayout {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final FKAdType f18563h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18564i;

    /* compiled from: FKStartupVideoLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18565a;

        static {
            int[] iArr = new int[FKVideoPlayState.values().length];
            try {
                iArr[FKVideoPlayState.RESUME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FKVideoPlayState.PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FKVideoPlayState.STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f18565a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKStartupVideoLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18564i = new LinkedHashMap();
        this.f18563h = FKAdType.Video;
        q();
    }

    private final void setVideoPlayState(FKVideoPlayState fKVideoPlayState) {
        int i10 = a.f18565a[fKVideoPlayState.ordinal()];
        if (i10 == 1) {
            ExoMediaPlayer.f12408a.v();
            return;
        }
        if (i10 == 2) {
            ExoMediaPlayer.f12408a.p();
        } else {
            if (i10 != 3) {
                return;
            }
            ((FrameLayout) o(R$id.start_up_video_container_layout)).removeAllViews();
            ExoMediaPlayer.f12408a.z();
        }
    }

    @Override // com.cupidapp.live.startup.view.FKBaseStartupLayout
    public void f(boolean z10, int i10, @Nullable final String str) {
        int i11 = R$id.start_up_video_jump_button;
        o(i11).setVisibility(z10 ? 0 : 8);
        if (i10 == FKClickArea.FullScreen.getArea()) {
            FrameLayout start_up_video_container_layout = (FrameLayout) o(R$id.start_up_video_container_layout);
            s.h(start_up_video_container_layout, "start_up_video_container_layout");
            y.d(start_up_video_container_layout, new Function1<View, p>() { // from class: com.cupidapp.live.startup.view.FKStartupVideoLayout$configJumpButtonAndClickArea$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    FKAdType fKAdType;
                    b listener = FKStartupVideoLayout.this.getListener();
                    if (listener != null) {
                        fKAdType = FKStartupVideoLayout.this.f18563h;
                        listener.I(fKAdType, str);
                    }
                }
            });
        } else if (i10 == FKClickArea.JumpButton.getArea()) {
            View start_up_video_jump_button = o(i11);
            s.h(start_up_video_jump_button, "start_up_video_jump_button");
            y.d(start_up_video_jump_button, new Function1<View, p>() { // from class: com.cupidapp.live.startup.view.FKStartupVideoLayout$configJumpButtonAndClickArea$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    FKAdType fKAdType;
                    b listener = FKStartupVideoLayout.this.getListener();
                    if (listener != null) {
                        fKAdType = FKStartupVideoLayout.this.f18563h;
                        listener.I(fKAdType, str);
                    }
                }
            });
        }
    }

    @Override // com.cupidapp.live.startup.view.FKBaseStartupLayout
    public void g(@NotNull String path) {
        s.i(path, "path");
        int i10 = R$id.start_up_video_container_layout;
        ((FrameLayout) o(i10)).removeAllViews();
        FrameLayout frameLayout = (FrameLayout) o(i10);
        ExoMediaPlayer exoMediaPlayer = ExoMediaPlayer.f12408a;
        frameLayout.addView(exoMediaPlayer.k(true));
        ExoMediaPlayer.t(exoMediaPlayer, path, true, null, false, 12, null);
    }

    @Override // com.cupidapp.live.startup.view.FKBaseStartupLayout
    public void k(@NotNull String tick) {
        s.i(tick, "tick");
        ((TextView) o(R$id.start_up_video_skip_view)).setText(tick);
    }

    @Nullable
    public View o(int i10) {
        Map<Integer, View> map = this.f18564i;
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

    @Override // com.cupidapp.live.startup.view.FKBaseStartupLayout, androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(@NotNull LifecycleOwner owner) {
        s.i(owner, "owner");
        setVideoPlayState(FKVideoPlayState.STOP);
        setStartupListener(null);
    }

    @Override // com.cupidapp.live.startup.view.FKBaseStartupLayout, androidx.lifecycle.DefaultLifecycleObserver
    public void onPause(@NotNull LifecycleOwner owner) {
        s.i(owner, "owner");
        setVideoPlayState(FKVideoPlayState.PAUSE);
        m();
    }

    @Override // com.cupidapp.live.startup.view.FKBaseStartupLayout, androidx.lifecycle.DefaultLifecycleObserver
    public void onResume(@NotNull LifecycleOwner owner) {
        s.i(owner, "owner");
        setVideoPlayState(FKVideoPlayState.RESUME);
    }

    public final void q() {
        z.a(this, R$layout.layout_start_up_video, true);
        setVisibility(4);
        TextView start_up_video_skip_view = (TextView) o(R$id.start_up_video_skip_view);
        s.h(start_up_video_skip_view, "start_up_video_skip_view");
        y.d(start_up_video_skip_view, new Function1<View, p>() { // from class: com.cupidapp.live.startup.view.FKStartupVideoLayout$initView$1
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
                FKAdType fKAdType;
                b listener = FKStartupVideoLayout.this.getListener();
                if (listener != null) {
                    fKAdType = FKStartupVideoLayout.this.f18563h;
                    listener.J0(fKAdType);
                }
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKStartupVideoLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18564i = new LinkedHashMap();
        this.f18563h = FKAdType.Video;
        q();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKStartupVideoLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18564i = new LinkedHashMap();
        this.f18563h = FKAdType.Video;
        q();
    }
}
