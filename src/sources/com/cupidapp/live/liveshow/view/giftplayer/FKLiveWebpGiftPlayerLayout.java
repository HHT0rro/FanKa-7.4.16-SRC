package com.cupidapp.live.liveshow.view.giftplayer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.cupidapp.live.base.network.download.LaunchDownloader;
import com.cupidapp.live.base.video.ExoMediaPlayer;
import com.cupidapp.live.base.view.animation.FKWebpAnimationView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveWebpGiftPlayerLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveWebpGiftPlayerLayout extends FKWebpAnimationView {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final String f15628d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f15629e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f15630f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15631g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveWebpGiftPlayerLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15631g = new LinkedHashMap();
        this.f15628d = "TransitionWebpKey";
    }

    public boolean l() {
        return this.f15629e;
    }

    public final void m(Function0<p> function0) {
        o();
        function0.invoke();
    }

    public boolean n(@NotNull String animationKey) {
        s.i(animationKey, "animationKey");
        return kotlin.text.p.q(animationKey, "webp", false, 2, null) || s.d(animationKey, this.f15628d);
    }

    public void o() {
        this.f15629e = false;
        p();
    }

    public final void p() {
        i();
        if (this.f15630f) {
            ExoMediaPlayer.f12408a.z();
            this.f15630f = false;
        }
    }

    public void q(@NotNull String animationKey, @Nullable final String str, @NotNull final Function0<p> showNextGiftAnimation) {
        s.i(animationKey, "animationKey");
        s.i(showNextGiftAnimation, "showNextGiftAnimation");
        this.f15629e = true;
        p();
        if (s.d(animationKey, this.f15628d)) {
            c("webp_live_transition.webp", 1, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.giftplayer.FKLiveWebpGiftPlayerLayout$showGiftAnimation$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ p invoke() {
                    invoke2();
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    FKLiveWebpGiftPlayerLayout.this.m(showNextGiftAnimation);
                }
            });
        } else {
            g(animationKey, 1, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.giftplayer.FKLiveWebpGiftPlayerLayout$showGiftAnimation$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ p invoke() {
                    invoke2();
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    FKLiveWebpGiftPlayerLayout.this.r(str);
                }
            }, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.giftplayer.FKLiveWebpGiftPlayerLayout$showGiftAnimation$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ p invoke() {
                    invoke2();
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    FKLiveWebpGiftPlayerLayout.this.m(showNextGiftAnimation);
                }
            });
        }
    }

    public final void r(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        String s2 = LaunchDownloader.f11925a.s(str);
        if (s2 == null || s2.length() == 0) {
            return;
        }
        this.f15630f = true;
        ExoMediaPlayer.t(ExoMediaPlayer.f12408a, s2, false, ExoMediaPlayer.PlayMode.SINGLE, false, 10, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveWebpGiftPlayerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15631g = new LinkedHashMap();
        this.f15628d = "TransitionWebpKey";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveWebpGiftPlayerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15631g = new LinkedHashMap();
        this.f15628d = "TransitionWebpKey";
    }
}
