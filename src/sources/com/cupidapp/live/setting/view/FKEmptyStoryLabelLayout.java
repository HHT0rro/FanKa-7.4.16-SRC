package com.cupidapp.live.setting.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.setting.activity.FKStoryLabelListActivity;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.r;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: FKEmptyStoryLabelLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKEmptyStoryLabelLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18203b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKEmptyStoryLabelLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18203b = new LinkedHashMap();
        b();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f18203b;
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
        z.a(this, R$layout.layout_empty_story_label, true);
        ConstraintLayout add_story_label_layout = (ConstraintLayout) a(R$id.add_story_label_layout);
        s.h(add_story_label_layout, "add_story_label_layout");
        y.i(add_story_label_layout, (r18 & 1) != 0 ? 0.0f : h.c(this, 12.0f), r.e(0), (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : null, (r18 & 8) != 0 ? null : Integer.valueOf(h.c(this, 0.5f)), (r18 & 16) != 0 ? null : -5658199, (r18 & 32) != 0 ? 0.0f : h.c(this, 3.0f), (r18 & 64) != 0 ? 0.0f : h.c(this, 3.0f));
        y.d(this, new Function1<View, p>() { // from class: com.cupidapp.live.setting.view.FKEmptyStoryLabelLayout$initView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                FKStoryLabelListActivity.f17962r.a(FKEmptyStoryLabelLayout.this.getContext(), SensorPosition.EditProfile);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKEmptyStoryLabelLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18203b = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKEmptyStoryLabelLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18203b = new LinkedHashMap();
    }
}
