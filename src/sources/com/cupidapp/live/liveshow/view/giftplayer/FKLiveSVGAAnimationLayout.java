package com.cupidapp.live.liveshow.view.giftplayer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.cupidapp.live.base.network.download.LaunchDownloader;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.base.video.ExoMediaPlayer;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import java.io.FileInputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveSVGAAnimationLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveSVGAAnimationLayout extends SVGAImageView {

    /* renamed from: q, reason: collision with root package name */
    public boolean f15620q;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public Function0<p> f15621r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f15622s;

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15623t;

    /* compiled from: FKLiveSVGAAnimationLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements com.opensource.svgaplayer.b {
        public a() {
        }

        @Override // com.opensource.svgaplayer.b
        public void a() {
            FKLiveSVGAAnimationLayout.this.f15620q = false;
            FKLiveSVGAAnimationLayout.this.J();
            Function0 function0 = FKLiveSVGAAnimationLayout.this.f15621r;
            if (function0 != null) {
                function0.invoke();
            }
        }

        @Override // com.opensource.svgaplayer.b
        public void b(int i10, double d10) {
        }

        @Override // com.opensource.svgaplayer.b
        public void c() {
        }

        @Override // com.opensource.svgaplayer.b
        public void onPause() {
        }
    }

    /* compiled from: FKLiveSVGAAnimationLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements SVGAParser.c {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<p> f15626b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f15627c;

        public b(Function0<p> function0, String str) {
            this.f15626b = function0;
            this.f15627c = str;
        }

        @Override // com.opensource.svgaplayer.SVGAParser.c
        public void a(@NotNull SVGAVideoEntity videoItem) {
            s.i(videoItem, "videoItem");
            FKLiveSVGAAnimationLayout.this.f15621r = this.f15626b;
            FKLiveSVGAAnimationLayout.this.setVideoItem(videoItem);
            FKLiveSVGAAnimationLayout.this.s();
            FKLiveSVGAAnimationLayout.this.L(this.f15627c);
        }

        @Override // com.opensource.svgaplayer.SVGAParser.c
        public void onError() {
            FKLiveSVGAAnimationLayout.this.E(this.f15626b);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveSVGAAnimationLayout(@NotNull Context context) {
        super(context, null, 0, 6, null);
        s.i(context, "context");
        this.f15623t = new LinkedHashMap();
        G();
    }

    public final void E(Function0<p> function0) {
        this.f15620q = false;
        J();
        function0.invoke();
    }

    public boolean F() {
        return this.f15620q || k();
    }

    public final void G() {
        setLoops(1);
        setCallback(new a());
    }

    public boolean H(@NotNull String animationKey) {
        s.i(animationKey, "animationKey");
        return kotlin.text.p.q(animationKey, "svga", false, 2, null);
    }

    public final void I(String str, String str2, String str3, Function0<p> function0) {
        SVGAParser.f37905h.b().q(new FileInputStream(str), str2, new b(function0, str3), (r14 & 8) != 0 ? false : false, (r14 & 16) != 0 ? null : null, (r14 & 32) != 0 ? null : null);
    }

    public void J() {
        h();
        if (this.f15622s) {
            ExoMediaPlayer.f12408a.z();
            this.f15622s = false;
        }
    }

    public void K(@NotNull final String animationKey, @Nullable final String str, @NotNull final Function0<p> showNextGiftAnimation) {
        s.i(animationKey, "animationKey");
        s.i(showNextGiftAnimation, "showNextGiftAnimation");
        boolean z10 = true;
        this.f15620q = true;
        LaunchDownloader launchDownloader = LaunchDownloader.f11925a;
        String s2 = launchDownloader.s(animationKey);
        j.f12332a.a("DownTest", "svga cachedFilePath:" + s2);
        if (s2 != null && s2.length() != 0) {
            z10 = false;
        }
        if (z10) {
            launchDownloader.w(getContext(), animationKey, new Function1<String, p>() { // from class: com.cupidapp.live.liveshow.view.giftplayer.FKLiveSVGAAnimationLayout$showGiftAnimation$1
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
                    FKLiveSVGAAnimationLayout.this.I(localPath, animationKey, str, showNextGiftAnimation);
                }
            }, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.giftplayer.FKLiveSVGAAnimationLayout$showGiftAnimation$2
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
                    FKLiveSVGAAnimationLayout.this.E(showNextGiftAnimation);
                }
            });
        } else {
            I(s2, animationKey, str, showNextGiftAnimation);
        }
    }

    public final void L(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        String s2 = LaunchDownloader.f11925a.s(str);
        if (s2 == null || s2.length() == 0) {
            return;
        }
        this.f15622s = true;
        ExoMediaPlayer.t(ExoMediaPlayer.f12408a, s2, false, ExoMediaPlayer.PlayMode.SINGLE, false, 10, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveSVGAAnimationLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
        s.i(context, "context");
        this.f15623t = new LinkedHashMap();
        G();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveSVGAAnimationLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15623t = new LinkedHashMap();
        G();
    }
}
