package com.cupidapp.live.liveshow.pk.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FKLivePkStatusAnimationLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLivePkStatusAnimationLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15161b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLivePkStatusAnimationLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15161b = new LinkedHashMap();
        b();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15161b;
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

    public final void b() {
        z.a(this, R$layout.layout_live_pk_status_animation, true);
        setVisibility(8);
    }

    public final void c(boolean z10, @NotNull final Function0<p> finished) {
        s.i(finished, "finished");
        setVisibility(0);
        String str = z10 ? "victory.svga" : "defeat.svga";
        FKSVGAImageView pkStatusSVGAImageView = (FKSVGAImageView) a(R$id.pkStatusSVGAImageView);
        s.h(pkStatusSVGAImageView, "pkStatusSVGAImageView");
        FKSVGAImageView.F(pkStatusSVGAImageView, str, null, new Function0<p>() { // from class: com.cupidapp.live.liveshow.pk.view.FKLivePkStatusAnimationLayout$showPkStatusAnimation$1
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
                FKLivePkStatusAnimationLayout.this.setVisibility(8);
                finished.invoke();
            }
        }, 2, null);
    }

    public final void d() {
        ((FKSVGAImageView) a(R$id.pkStatusSVGAImageView)).K();
        setVisibility(8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLivePkStatusAnimationLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15161b = new LinkedHashMap();
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLivePkStatusAnimationLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15161b = new LinkedHashMap();
        b();
    }
}
