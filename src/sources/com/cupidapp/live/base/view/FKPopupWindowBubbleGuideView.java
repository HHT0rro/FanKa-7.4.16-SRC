package com.cupidapp.live.base.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FKPopupWindowBubbleGuideView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKPopupWindowBubbleGuideView extends FrameLayout {

    /* renamed from: b */
    @NotNull
    public final com.cupidapp.live.base.utils.l f12515b;

    /* renamed from: c */
    @NotNull
    public final com.cupidapp.live.base.utils.i f12516c;

    /* renamed from: d */
    @NotNull
    public Map<Integer, View> f12517d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKPopupWindowBubbleGuideView(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12517d = new LinkedHashMap();
        this.f12515b = new com.cupidapp.live.base.utils.l();
        this.f12516c = new com.cupidapp.live.base.utils.i();
        d();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f12517d;
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

    public final void c(@NotNull BubbleGuideModel bubble) {
        kotlin.jvm.internal.s.i(bubble, "bubble");
        String guideText = bubble.getGuideText();
        if (!(guideText == null || guideText.length() == 0)) {
            ((ImageView) a(R$id.bubble_guide_bg_image_View)).setVisibility(8);
            ((LinearLayout) a(R$id.bubble_guide_text_layout)).setVisibility(0);
            int i10 = R$id.bubble_guide_text_view;
            ((TextView) a(i10)).getPaint().setFakeBoldText(true);
            ((TextView) a(i10)).setTextColor(bubble.getTextColor());
            ((TextView) a(i10)).setText(bubble.getGuideText());
            if (bubble.getGuideBg() != null) {
                ((TextView) a(i10)).setBackgroundResource(bubble.getGuideBg().intValue());
                ((ImageView) a(R$id.bottom_angle_view)).setVisibility(8);
                return;
            }
            TextView bubble_guide_text_view = (TextView) a(i10);
            kotlin.jvm.internal.s.h(bubble_guide_text_view, "bubble_guide_text_view");
            y.i(bubble_guide_text_view, (r18 & 1) != 0 ? 0.0f : z0.h.c(this, 10.0f), kotlin.collections.r.e(Integer.valueOf(bubble.getGuideBgColor())), (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : null, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? null : null, (r18 & 32) != 0 ? 0.0f : 0.0f, (r18 & 64) != 0 ? 0.0f : 0.0f);
            int i11 = R$id.bottom_angle_view;
            ((ImageView) a(i11)).setVisibility(0);
            ((ImageView) a(i11)).setColorFilter(bubble.getGuideBgColor());
            return;
        }
        if (bubble.getGuideBg() != null) {
            ((LinearLayout) a(R$id.bubble_guide_text_layout)).setVisibility(8);
            int i12 = R$id.bubble_guide_bg_image_View;
            ((ImageView) a(i12)).setVisibility(0);
            ((ImageView) a(i12)).setImageResource(bubble.getGuideBg().intValue());
        }
    }

    public final void d() {
        z.a(this, R$layout.layout_popup_window_bubble_guide_view, true);
    }

    public final void e(@NotNull View parent, int i10, int i11, int i12, @Nullable Integer num, boolean z10, boolean z11) {
        kotlin.jvm.internal.s.i(parent, "parent");
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null && activity.isFinishing()) {
            return;
        }
        com.cupidapp.live.base.utils.l.f(this.f12515b.b(z10).c(z11), this, 0, 0, 6, null).j(parent, i10, i11, i12);
        com.cupidapp.live.base.utils.i.d(this.f12516c, num, 1, new Function0<kotlin.p>() { // from class: com.cupidapp.live.base.view.FKPopupWindowBubbleGuideView$showGuide$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ kotlin.p invoke() {
                invoke2();
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                com.cupidapp.live.base.utils.l lVar;
                lVar = FKPopupWindowBubbleGuideView.this.f12515b;
                lVar.d();
            }
        }, null, 8, null);
    }

    public final void g() {
        this.f12515b.d();
        this.f12516c.g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKPopupWindowBubbleGuideView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12517d = new LinkedHashMap();
        this.f12515b = new com.cupidapp.live.base.utils.l();
        this.f12516c = new com.cupidapp.live.base.utils.i();
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKPopupWindowBubbleGuideView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12517d = new LinkedHashMap();
        this.f12515b = new com.cupidapp.live.base.utils.l();
        this.f12516c = new com.cupidapp.live.base.utils.i();
        d();
    }
}
