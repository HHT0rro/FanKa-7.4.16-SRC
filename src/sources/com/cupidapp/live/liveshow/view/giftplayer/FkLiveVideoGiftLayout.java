package com.cupidapp.live.liveshow.view.giftplayer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.cupidapp.live.base.network.download.LaunchDownloader;
import com.cupidapp.live.base.utils.j;
import com.danlan.android.videogift.AlphaVideoGiftView;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FkLiveVideoGiftLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FkLiveVideoGiftLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15632b;

    /* compiled from: FkLiveVideoGiftLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements AlphaVideoGiftView.d {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<p> f15634b;

        public a(Function0<p> function0) {
            this.f15634b = function0;
        }

        @Override // com.danlan.android.videogift.AlphaVideoGiftView.d
        public void a() {
            j.f12332a.a("DownTest", "video gift play onStarted");
        }

        @Override // com.danlan.android.videogift.AlphaVideoGiftView.d
        public void b() {
            j.f12332a.a("DownTest", "video gift play onEnded");
            FkLiveVideoGiftLayout.this.e();
            this.f15634b.invoke();
        }

        @Override // com.danlan.android.videogift.AlphaVideoGiftView.d
        public void onError() {
            j.f12332a.a("DownTest", "video gift play onError");
            FkLiveVideoGiftLayout.this.e();
            this.f15634b.invoke();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FkLiveVideoGiftLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15632b = new LinkedHashMap();
    }

    public boolean c() {
        return getChildCount() > 0;
    }

    public boolean d(@NotNull String animationKey) {
        s.i(animationKey, "animationKey");
        Locale locale = Locale.getDefault();
        s.h(locale, "getDefault()");
        String lowerCase = animationKey.toLowerCase(locale);
        s.h(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return kotlin.text.p.q(lowerCase, ".mp4", false, 2, null);
    }

    public final void e() {
        removeAllViews();
    }

    public final void f(String str, Function0<p> function0) {
        try {
            AlphaVideoGiftView alphaVideoGiftView = new AlphaVideoGiftView(getContext(), null);
            addView(alphaVideoGiftView, new FrameLayout.LayoutParams(-1, -1));
            alphaVideoGiftView.S(getContext(), str);
            alphaVideoGiftView.setOnVideoStateChangedListener(new a(function0));
        } catch (Exception e2) {
            j.f12332a.a("DownTest", "video gift play fail e:" + ((Object) e2));
            e2.printStackTrace();
            function0.invoke();
        }
    }

    public void g() {
        e();
    }

    public void h(@NotNull String animationKey, @Nullable String str, @NotNull final Function0<p> showNextGiftAnimation) {
        s.i(animationKey, "animationKey");
        s.i(showNextGiftAnimation, "showNextGiftAnimation");
        LaunchDownloader launchDownloader = LaunchDownloader.f11925a;
        String s2 = launchDownloader.s(animationKey);
        j.f12332a.a("DownTest", "video cachedFilePath:" + s2);
        if (s2 == null || s2.length() == 0) {
            launchDownloader.w(getContext(), animationKey, new Function1<String, p>() { // from class: com.cupidapp.live.liveshow.view.giftplayer.FkLiveVideoGiftLayout$showGiftAnimation$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(String str2) {
                    invoke2(str2);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull String localPath) {
                    s.i(localPath, "localPath");
                    j.f12332a.a("DownTest", "video gift download success localPath:" + localPath);
                    FkLiveVideoGiftLayout.this.f(localPath, showNextGiftAnimation);
                }
            }, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.giftplayer.FkLiveVideoGiftLayout$showGiftAnimation$2
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
                    j.f12332a.a("DownTest", "video gift download failure");
                    showNextGiftAnimation.invoke();
                }
            });
        } else {
            f(s2, showNextGiftAnimation);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FkLiveVideoGiftLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15632b = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FkLiveVideoGiftLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15632b = new LinkedHashMap();
    }
}
