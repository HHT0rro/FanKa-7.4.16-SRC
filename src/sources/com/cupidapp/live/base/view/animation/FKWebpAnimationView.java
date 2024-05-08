package com.cupidapp.live.base.view.animation;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.cupidapp.live.base.network.download.LaunchDownloader;
import com.github.penfeizhou.animation.webp.WebPDrawable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKWebpAnimationView.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class FKWebpAnimationView extends AppCompatImageView {

    /* renamed from: b */
    @Nullable
    public WebPDrawable f12627b;

    /* renamed from: c */
    @NotNull
    public Map<Integer, View> f12628c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKWebpAnimationView(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f12628c = new LinkedHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void b(FKWebpAnimationView fKWebpAnimationView, String str, int i10, Function0 function0, Function0 function02, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: displayAnimation");
        }
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            function0 = null;
        }
        if ((i11 & 8) != 0) {
            function02 = null;
        }
        fKWebpAnimationView.a(str, i10, function0, function02);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d(FKWebpAnimationView fKWebpAnimationView, String str, int i10, Function0 function0, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: displayAnimationFromAsset");
        }
        if ((i11 & 2) != 0) {
            i10 = 1;
        }
        if ((i11 & 4) != 0) {
            function0 = null;
        }
        fKWebpAnimationView.c(str, i10, function0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void h(FKWebpAnimationView fKWebpAnimationView, String str, int i10, Function0 function0, Function0 function02, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showWebpAnimation");
        }
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            function0 = null;
        }
        if ((i11 & 8) != 0) {
            function02 = null;
        }
        fKWebpAnimationView.g(str, i10, function0, function02);
    }

    public final void a(@NotNull String animationPath, int i10, @Nullable final Function0<p> function0, @Nullable final Function0<p> function02) {
        s.i(animationPath, "animationPath");
        WebPDrawable l10 = WebPDrawable.l(animationPath);
        l10.i(i10);
        l10.registerAnimationCallback(new Animatable2Compat.AnimationCallback() { // from class: com.cupidapp.live.base.view.animation.FKWebpAnimationView$displayAnimation$1$1
            @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
            public void onAnimationEnd(@Nullable Drawable drawable) {
                Function0<p> function03 = function02;
                if (function03 != null) {
                    function03.invoke();
                }
            }

            @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
            public void onAnimationStart(@Nullable Drawable drawable) {
                Function0<p> function03 = function0;
                if (function03 != null) {
                    function03.invoke();
                }
            }
        });
        this.f12627b = l10;
        setImageDrawable(l10);
    }

    public final void c(@NotNull String assetName, int i10, @Nullable final Function0<p> function0) {
        s.i(assetName, "assetName");
        WebPDrawable k10 = WebPDrawable.k(getContext(), "webp/" + assetName);
        k10.i(i10);
        k10.registerAnimationCallback(new Animatable2Compat.AnimationCallback() { // from class: com.cupidapp.live.base.view.animation.FKWebpAnimationView$displayAnimationFromAsset$1$1
            @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
            public void onAnimationEnd(@Nullable Drawable drawable) {
                Function0<p> function02 = function0;
                if (function02 != null) {
                    function02.invoke();
                }
            }
        });
        this.f12627b = k10;
        setImageDrawable(k10);
    }

    public final void e() {
        WebPDrawable webPDrawable = this.f12627b;
        if (webPDrawable != null) {
            webPDrawable.g();
        }
    }

    public final void f() {
        WebPDrawable webPDrawable = this.f12627b;
        if (webPDrawable != null) {
            webPDrawable.h();
        }
    }

    public final void g(@NotNull String animationKey, final int i10, @Nullable final Function0<p> function0, @Nullable final Function0<p> function02) {
        s.i(animationKey, "animationKey");
        LaunchDownloader launchDownloader = LaunchDownloader.f11925a;
        String t2 = launchDownloader.t(animationKey);
        if (t2 == null || t2.length() == 0) {
            launchDownloader.w(getContext(), animationKey, new Function1<String, p>() { // from class: com.cupidapp.live.base.view.animation.FKWebpAnimationView$showWebpAnimation$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(String str) {
                    invoke2(str);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull String localPath) {
                    s.i(localPath, "localPath");
                    if (localPath.length() > 0) {
                        FKWebpAnimationView.this.a(localPath, i10, function0, function02);
                    }
                }
            }, new Function0<p>() { // from class: com.cupidapp.live.base.view.animation.FKWebpAnimationView$showWebpAnimation$2
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
                    Function0<p> function03 = function02;
                    if (function03 != null) {
                        function03.invoke();
                    }
                }
            });
        } else {
            a(t2, i10, function0, function02);
        }
    }

    public final void i() {
        WebPDrawable webPDrawable = this.f12627b;
        if (webPDrawable != null) {
            webPDrawable.g();
        }
        WebPDrawable webPDrawable2 = this.f12627b;
        if (webPDrawable2 != null) {
            webPDrawable2.stop();
        }
        this.f12627b = null;
        setImageDrawable(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKWebpAnimationView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f12628c = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKWebpAnimationView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f12628c = new LinkedHashMap();
    }
}
