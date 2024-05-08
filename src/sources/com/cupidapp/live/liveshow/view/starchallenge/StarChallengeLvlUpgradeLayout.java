package com.cupidapp.live.liveshow.view.starchallenge;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.view.animation.FKLottieAnimationView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: StarChallengeLvlUpgradeLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class StarChallengeLvlUpgradeLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15910b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StarChallengeLvlUpgradeLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15910b = new LinkedHashMap();
        c();
    }

    public static final void e(StarChallengeLvlUpgradeLayout this$0) {
        s.i(this$0, "this$0");
        this$0.g();
        this$0.setVisibility(8);
    }

    @Nullable
    public View b(int i10) {
        Map<Integer, View> map = this.f15910b;
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

    public final void c() {
        z.a(this, R$layout.layout_star_challenge_lvl_upgrade, true);
    }

    public final void d(@Nullable String str) {
        setVisibility(0);
        f();
        ((TextView) b(R$id.star_challenge_lvl_upgrade_text)).setText(str);
        postDelayed(new Runnable() { // from class: com.cupidapp.live.liveshow.view.starchallenge.c
            @Override // java.lang.Runnable
            public final void run() {
                StarChallengeLvlUpgradeLayout.e(StarChallengeLvlUpgradeLayout.this);
            }
        }, com.huawei.openalliance.ad.ipc.c.Code);
    }

    public final void f() {
        ((FKLottieAnimationView) b(R$id.star_challenge_lvl_upgrade_lottie)).L();
    }

    public final void g() {
        ((FKLottieAnimationView) b(R$id.star_challenge_lvl_upgrade_lottie)).M();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StarChallengeLvlUpgradeLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15910b = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StarChallengeLvlUpgradeLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15910b = new LinkedHashMap();
        c();
    }
}
