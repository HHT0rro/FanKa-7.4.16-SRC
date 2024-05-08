package com.cupidapp.live.match.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.view.animation.FKLottieAnimationView;
import java.util.LinkedHashMap;
import java.util.Map;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NearByBoostEntranceLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NearByBoostEntranceLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    public final int f16973d;

    /* renamed from: e, reason: collision with root package name */
    public final int f16974e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16975f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearByBoostEntranceLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16975f = new LinkedHashMap();
        this.f16973d = (z0.h.l(this) - z0.h.c(this, 5.0f)) / 4;
        this.f16974e = (int) ((r2 * 122) / 102.0f);
        f();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f16975f;
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

    public final void f() {
        z0.z.a(this, R$layout.layout_nearby_super_boost_entrance, true);
        ((TextView) e(R$id.open_exposure_textview)).getPaint().setFakeBoldText(true);
        ConstraintLayout super_boost_entrance_layout = (ConstraintLayout) e(R$id.super_boost_entrance_layout);
        kotlin.jvm.internal.s.h(super_boost_entrance_layout, "super_boost_entrance_layout");
        z0.y.n(super_boost_entrance_layout, Integer.valueOf(this.f16973d), Integer.valueOf(this.f16974e));
        FKLottieAnimationView nearby_super_boost_animation_view = (FKLottieAnimationView) e(R$id.nearby_super_boost_animation_view);
        kotlin.jvm.internal.s.h(nearby_super_boost_animation_view, "nearby_super_boost_animation_view");
        z0.y.n(nearby_super_boost_animation_view, Integer.valueOf(this.f16973d), Integer.valueOf(this.f16973d));
    }

    public final void g() {
        ((FKLottieAnimationView) e(R$id.nearby_super_boost_animation_view)).L();
    }

    public final int getItemHeight() {
        return this.f16974e;
    }

    public final int getItemWidth() {
        return this.f16973d;
    }

    public final void h() {
        ((FKLottieAnimationView) e(R$id.nearby_super_boost_animation_view)).M();
    }

    @Override // com.cupidapp.live.base.view.BaseLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        g();
    }

    @Override // com.cupidapp.live.base.view.BaseLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h();
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull PlayOrStopSuperBoostAnimationEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        if (event.getPlay()) {
            g();
        } else {
            h();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearByBoostEntranceLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16975f = new LinkedHashMap();
        this.f16973d = (z0.h.l(this) - z0.h.c(this, 5.0f)) / 4;
        this.f16974e = (int) ((r2 * 122) / 102.0f);
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearByBoostEntranceLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16975f = new LinkedHashMap();
        this.f16973d = (z0.h.l(this) - z0.h.c(this, 5.0f)) / 4;
        this.f16974e = (int) ((r2 * 122) / 102.0f);
        f();
    }
}
