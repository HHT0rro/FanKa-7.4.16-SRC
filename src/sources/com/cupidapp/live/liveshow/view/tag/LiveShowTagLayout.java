package com.cupidapp.live.liveshow.view.tag;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.utils.h;
import com.cupidapp.live.base.view.RoundedFrameLayout;
import com.cupidapp.live.liveshow.view.tag.LiveShowTagView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.t;
import kotlin.d;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: LiveShowTagLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class LiveShowTagLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    public int f15974b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public LiveShowTagModel f15975c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15976d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveShowTagLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15976d = new LinkedHashMap();
        f();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15976d;
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

    public final void b(LiveShowTagModel liveShowTagModel) {
        LiveShowTagModel liveShowTagModel2 = this.f15975c;
        if (s.d(liveShowTagModel2 != null ? liveShowTagModel2.getBgColor() : null, liveShowTagModel.getBgColor())) {
            LiveShowTagModel liveShowTagModel3 = this.f15975c;
            if (s.b(liveShowTagModel3 != null ? Float.valueOf(liveShowTagModel3.getBgColorAlpha()) : null, liveShowTagModel.getBgColorAlpha())) {
                LiveShowTagModel liveShowTagModel4 = this.f15975c;
                if (s.d(liveShowTagModel4 != null ? liveShowTagModel4.getBorderColor() : null, liveShowTagModel.getBorderColor())) {
                    return;
                }
            }
        }
        List z02 = StringsKt__StringsKt.z0(liveShowTagModel.getBgColor(), new String[]{","}, false, 0, 6, null);
        ArrayList arrayList = new ArrayList(t.t(z02, 10));
        Iterator<E> iterator2 = z02.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(Integer.valueOf(h.a(h.b((String) iterator2.next()), liveShowTagModel.getBgColorAlpha())));
        }
        String borderColor = liveShowTagModel.getBorderColor();
        Integer valueOf = borderColor != null ? Integer.valueOf(h.b(borderColor)) : null;
        int style = liveShowTagModel.getStyle();
        if (style == TagShape.Parallelogram.getShape()) {
            int i10 = R$id.parallelogram_layout;
            ParallelogramLayout parallelogram_layout = (ParallelogramLayout) a(i10);
            s.h(parallelogram_layout, "parallelogram_layout");
            parallelogram_layout.setVisibility(0);
            View parallelogram_bg_view = a(R$id.parallelogram_bg_view);
            s.h(parallelogram_bg_view, "parallelogram_bg_view");
            y.i(parallelogram_bg_view, (r18 & 1) != 0 ? 0.0f : 0.0f, arrayList, (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : null, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? null : null, (r18 & 32) != 0 ? 0.0f : 0.0f, (r18 & 64) != 0 ? 0.0f : 0.0f);
            if (valueOf != null) {
                ParallelogramLayout configBgColor$lambda$1 = (ParallelogramLayout) a(i10);
                s.h(configBgColor$lambda$1, "configBgColor$lambda$1");
                configBgColor$lambda$1.setStroke(z0.h.c(configBgColor$lambda$1, 1.5f));
                configBgColor$lambda$1.setStrokeColor(valueOf.intValue());
            }
            ((ConstraintLayout) a(R$id.live_show_container_layout)).setBackground(null);
            return;
        }
        if (style == TagShape.RoundRectangle.getShape()) {
            ParallelogramLayout parallelogram_layout2 = (ParallelogramLayout) a(R$id.parallelogram_layout);
            s.h(parallelogram_layout2, "parallelogram_layout");
            parallelogram_layout2.setVisibility(8);
            ConstraintLayout live_show_container_layout = (ConstraintLayout) a(R$id.live_show_container_layout);
            s.h(live_show_container_layout, "live_show_container_layout");
            y.i(live_show_container_layout, (r18 & 1) != 0 ? 0.0f : z0.h.c(this, 10.0f), arrayList, (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : null, (r18 & 8) != 0 ? null : Integer.valueOf(z0.h.c(this, 1.5f)), (r18 & 16) != 0 ? null : valueOf, (r18 & 32) != 0 ? 0.0f : 0.0f, (r18 & 64) != 0 ? 0.0f : 0.0f);
        }
    }

    public final void c(@NotNull LiveShowTagModel tagModel) {
        s.i(tagModel, "tagModel");
        b(tagModel);
        ((LiveShowTagView) a(R$id.live_show_tag_view)).c(tagModel, TagScrollingType.OverallScrolling.getType());
        int i10 = R$id.live_show_container_layout;
        ((ConstraintLayout) a(i10)).measure(View.MeasureSpec.makeMeasureSpec(z0.h.l(this), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(z0.h.k(this), Integer.MIN_VALUE));
        int measuredWidth = ((ConstraintLayout) a(i10)).getMeasuredWidth();
        this.f15974b = measuredWidth;
        LiveShowTagView.a aVar = LiveShowTagView.f15978d;
        if (measuredWidth > aVar.a()) {
            this.f15974b = aVar.a();
        }
        y.o(this, Integer.valueOf(this.f15974b), null, 2, null);
        d(tagModel);
        e(tagModel);
        this.f15975c = tagModel;
    }

    public final void d(LiveShowTagModel liveShowTagModel) {
        LiveShowTagModel liveShowTagModel2 = this.f15975c;
        Integer num = null;
        if (s.d(liveShowTagModel2 != null ? liveShowTagModel2.getPercentColor() : null, liveShowTagModel.getPercentColor())) {
            LiveShowTagModel liveShowTagModel3 = this.f15975c;
            if (s.c(liveShowTagModel3 != null ? liveShowTagModel3.getPercentColorAlpha() : null, liveShowTagModel.getPercentColorAlpha())) {
                return;
            }
        }
        String percentColor = liveShowTagModel.getPercentColor();
        if (percentColor != null) {
            int b4 = h.b(percentColor);
            Float percentColorAlpha = liveShowTagModel.getPercentColorAlpha();
            num = Integer.valueOf(h.a(b4, percentColorAlpha != null ? percentColorAlpha.floatValue() : 1.0f));
        }
        if (num == null) {
            View parallelogram_progress_view = a(R$id.parallelogram_progress_view);
            s.h(parallelogram_progress_view, "parallelogram_progress_view");
            parallelogram_progress_view.setVisibility(8);
            RoundedFrameLayout round_progress_layout = (RoundedFrameLayout) a(R$id.round_progress_layout);
            s.h(round_progress_layout, "round_progress_layout");
            round_progress_layout.setVisibility(8);
            return;
        }
        int style = liveShowTagModel.getStyle();
        if (style == TagShape.Parallelogram.getShape()) {
            int i10 = R$id.parallelogram_progress_view;
            View parallelogram_progress_view2 = a(i10);
            s.h(parallelogram_progress_view2, "parallelogram_progress_view");
            parallelogram_progress_view2.setVisibility(0);
            a(i10).setBackgroundColor(num.intValue());
            return;
        }
        if (style == TagShape.RoundRectangle.getShape()) {
            RoundedFrameLayout round_progress_layout2 = (RoundedFrameLayout) a(R$id.round_progress_layout);
            s.h(round_progress_layout2, "round_progress_layout");
            round_progress_layout2.setVisibility(0);
            a(R$id.round_progress_view).setBackgroundColor(num.intValue());
        }
    }

    public final void e(LiveShowTagModel liveShowTagModel) {
        Float percent = liveShowTagModel.getPercent();
        if (percent == null) {
            View parallelogram_progress_view = a(R$id.parallelogram_progress_view);
            s.h(parallelogram_progress_view, "parallelogram_progress_view");
            parallelogram_progress_view.setVisibility(8);
            RoundedFrameLayout round_progress_layout = (RoundedFrameLayout) a(R$id.round_progress_layout);
            s.h(round_progress_layout, "round_progress_layout");
            round_progress_layout.setVisibility(8);
            return;
        }
        float floatValue = this.f15974b * percent.floatValue();
        int style = liveShowTagModel.getStyle();
        if (style == TagShape.Parallelogram.getShape()) {
            View parallelogram_progress_view2 = a(R$id.parallelogram_progress_view);
            s.h(parallelogram_progress_view2, "parallelogram_progress_view");
            y.o(parallelogram_progress_view2, Integer.valueOf((int) floatValue), null, 2, null);
        } else if (style == TagShape.RoundRectangle.getShape()) {
            View round_progress_view = a(R$id.round_progress_view);
            s.h(round_progress_view, "round_progress_view");
            y.o(round_progress_view, Integer.valueOf((int) floatValue), null, 2, null);
            String borderColor = liveShowTagModel.getBorderColor();
            int c4 = borderColor == null || borderColor.length() == 0 ? 0 : z0.h.c(this, 1.5f);
            RoundedFrameLayout round_progress_layout2 = (RoundedFrameLayout) a(R$id.round_progress_layout);
            s.h(round_progress_layout2, "round_progress_layout");
            y.l(round_progress_layout2, Integer.valueOf(c4), Integer.valueOf(c4), Integer.valueOf(c4), Integer.valueOf(c4));
        }
    }

    public final void f() {
        z.a(this, R$layout.layout_live_show_tag, true);
        ((RoundedFrameLayout) a(R$id.round_progress_layout)).setCornerRadius(z0.h.c(this, 10.0f));
    }

    public final void g() {
        ((LiveShowTagView) a(R$id.live_show_tag_view)).e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveShowTagLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15976d = new LinkedHashMap();
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveShowTagLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15976d = new LinkedHashMap();
        f();
    }
}
