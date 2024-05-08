package com.cupidapp.live.notify.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.ai.model.AiRcmdModel;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.view.animation.FKLottieAnimationView;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: AiPreviewLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AiPreviewLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17561d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiPreviewLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f17561d = new LinkedHashMap();
        g();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f17561d;
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

    public final void f(@Nullable List<AiRcmdModel> list) {
        if (list != null && (list.isEmpty() ^ true)) {
            int i10 = R$id.ai_preview_rcmd_layout;
            ((AiRcmdLayout) e(i10)).g(list);
            ((AiRcmdLayout) e(i10)).setVisibility(0);
            return;
        }
        ((AiRcmdLayout) e(R$id.ai_preview_rcmd_layout)).setVisibility(4);
    }

    public final void g() {
        z.a(this, R$layout.layout_ai_preview, true);
    }

    @Nullable
    public final AiRcmdModel getSelectedItem() {
        AiRcmdLayout aiRcmdLayout = (AiRcmdLayout) e(R$id.ai_preview_rcmd_layout);
        if (aiRcmdLayout != null) {
            return aiRcmdLayout.getSelectedItem();
        }
        return null;
    }

    public final void h() {
        FKLottieAnimationView fKLottieAnimationView = (FKLottieAnimationView) e(R$id.ai_preview_lottie);
        if (fKLottieAnimationView != null) {
            fKLottieAnimationView.I();
        }
    }

    public final void i() {
        FKLottieAnimationView fKLottieAnimationView = (FKLottieAnimationView) e(R$id.ai_preview_lottie);
        if (fKLottieAnimationView != null) {
            fKLottieAnimationView.K();
        }
    }

    public final void j() {
        ((FKLottieAnimationView) e(R$id.ai_preview_lottie)).M();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiPreviewLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f17561d = new LinkedHashMap();
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiPreviewLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f17561d = new LinkedHashMap();
        g();
    }
}
