package com.cupidapp.live.liveshow.view.giftplayer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.cupidapp.live.base.network.download.LaunchDownloader;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.base.video.ExoMediaPlayer;
import java.util.LinkedHashMap;
import java.util.Map;
import k4.b;
import kotlin.Lazy;
import kotlin.c;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import l4.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveApngGiftPlayerLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveApngGiftPlayerLayout extends AppCompatImageView {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Lazy f15607b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f15608c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15609d;

    /* compiled from: FKLiveApngGiftPlayerLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a extends e {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<p> f15611b;

        public a(Function0<p> function0) {
            this.f15611b = function0;
        }

        @Override // l4.e
        public void a(@Nullable k4.a aVar) {
            FKLiveApngGiftPlayerLayout.this.setImageDrawable(null);
            this.f15611b.invoke();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveApngGiftPlayerLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15609d = new LinkedHashMap();
        this.f15607b = c.b(FKLiveApngGiftPlayerLayout$apngKeyMap$2.INSTANCE);
    }

    private final Map<String, String> getApngKeyMap() {
        return (Map) this.f15607b.getValue();
    }

    public boolean b() {
        k4.a g3 = k4.a.g(this);
        return g3 != null && g3.isRunning();
    }

    public final void c(String str, String str2, Function0<p> function0) {
        g(str2);
        k4.b.p().l(str, this, new b.C0769b(1, true, false), new a(function0));
    }

    public boolean d(@NotNull String animationKey) {
        s.i(animationKey, "animationKey");
        return getApngKeyMap().containsKey(animationKey) || kotlin.text.p.q(animationKey, "png", false, 2, null);
    }

    public void e() {
        k4.a g3 = k4.a.g(this);
        if (g3 != null) {
            g3.stop();
        }
        setImageDrawable(null);
        if (this.f15608c) {
            ExoMediaPlayer.f12408a.z();
            this.f15608c = false;
        }
    }

    public void f(@NotNull String animationKey, @Nullable final String str, @NotNull final Function0<p> showNextGiftAnimation) {
        s.i(animationKey, "animationKey");
        s.i(showNextGiftAnimation, "showNextGiftAnimation");
        String str2 = getApngKeyMap().get(animationKey);
        if (!(str2 == null || str2.length() == 0)) {
            c(str2, str, showNextGiftAnimation);
            return;
        }
        LaunchDownloader launchDownloader = LaunchDownloader.f11925a;
        String u10 = launchDownloader.u(animationKey);
        j.f12332a.a("DownTest", "apng cachedFileUri:" + u10);
        if (u10 == null || u10.length() == 0) {
            launchDownloader.w(getContext(), animationKey, new Function1<String, p>() { // from class: com.cupidapp.live.liveshow.view.giftplayer.FKLiveApngGiftPlayerLayout$showGiftAnimation$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(String str3) {
                    invoke2(str3);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull String localPath) {
                    s.i(localPath, "localPath");
                    String q10 = LaunchDownloader.f11925a.q(localPath);
                    if (q10 == null || q10.length() == 0) {
                        showNextGiftAnimation.invoke();
                    } else {
                        this.c(q10, str, showNextGiftAnimation);
                    }
                }
            }, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.giftplayer.FKLiveApngGiftPlayerLayout$showGiftAnimation$2
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
                    showNextGiftAnimation.invoke();
                }
            });
        } else {
            c(u10, str, showNextGiftAnimation);
        }
    }

    public final void g(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        String s2 = LaunchDownloader.f11925a.s(str);
        if (s2 == null || s2.length() == 0) {
            return;
        }
        this.f15608c = true;
        ExoMediaPlayer.t(ExoMediaPlayer.f12408a, s2, false, ExoMediaPlayer.PlayMode.SINGLE, false, 10, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveApngGiftPlayerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15609d = new LinkedHashMap();
        this.f15607b = c.b(FKLiveApngGiftPlayerLayout$apngKeyMap$2.INSTANCE);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveApngGiftPlayerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15609d = new LinkedHashMap();
        this.f15607b = c.b(FKLiveApngGiftPlayerLayout$apngKeyMap$2.INSTANCE);
    }
}
