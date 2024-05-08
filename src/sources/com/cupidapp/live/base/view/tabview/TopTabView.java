package com.cupidapp.live.base.view.tabview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import com.cupidapp.live.R$styleable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.r;
import kotlin.collections.s;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.u;
import z0.y;

/* compiled from: TopTabView.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class TopTabView extends LinearLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Function1<? super Integer, p> f12897b;

    /* renamed from: c, reason: collision with root package name */
    public int f12898c;

    /* renamed from: d, reason: collision with root package name */
    public int f12899d;

    /* renamed from: e, reason: collision with root package name */
    public int f12900e;

    /* renamed from: f, reason: collision with root package name */
    public int f12901f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12902g = new LinkedHashMap();

    public TopTabView(@Nullable Context context) {
        super(context);
        this.f12898c = -11584935;
        this.f12899d = -1;
        this.f12900e = -1;
        d(this, null, 1, null);
    }

    public static /* synthetic */ void d(TopTabView topTabView, AttributeSet attributeSet, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            attributeSet = null;
        }
        topTabView.c(attributeSet);
    }

    public final void a(int i10) {
        int i11 = 0;
        for (View view : ViewGroupKt.getChildren(this)) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                s.s();
            }
            View view2 = view;
            if ((view2 instanceof TextView ? (TextView) view2 : null) != null) {
                boolean z10 = i11 == i10;
                TextView textView = (TextView) view2;
                textView.setTextColor(z10 ? this.f12898c : this.f12899d);
                y.i(view2, (r18 & 1) != 0 ? 0.0f : h.c(r4, 6.0f), r.e(Integer.valueOf(z10 ? this.f12900e : this.f12901f)), (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : null, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? null : null, (r18 & 32) != 0 ? 0.0f : 0.0f, (r18 & 64) != 0 ? 0.0f : 0.0f);
                textView.setSelected(z10);
            }
            i11 = i12;
        }
    }

    public final void b(@NotNull List<String> tabList, int i10) {
        kotlin.jvm.internal.s.i(tabList, "tabList");
        final int i11 = 0;
        for (String str : tabList) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                s.s();
            }
            final TextView textView = new TextView(getContext());
            textView.setLayoutParams(new LinearLayout.LayoutParams(h.c(textView, 96.0f), -2));
            textView.setPadding(0, h.c(textView, 12.0f), 0, h.c(textView, 12.0f));
            textView.setTextSize(14.0f);
            textView.setText(str);
            u.a(textView);
            textView.setTextSize(14.0f);
            textView.setPadding(0, h.c(textView, 12.0f), 0, h.c(textView, 12.0f));
            textView.setLayoutParams(new LinearLayout.LayoutParams(h.c(textView, 96.0f), -2));
            textView.setGravity(17);
            y.d(textView, new Function1<View, p>() { // from class: com.cupidapp.live.base.view.tabview.TopTabView$configView$1$tabView$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    Function1<Integer, p> clickListener;
                    if (TextView.this.isSelected() || (clickListener = this.getClickListener()) == null) {
                        return;
                    }
                    clickListener.invoke(Integer.valueOf(i11));
                }
            });
            addView(textView);
            i11 = i12;
        }
        a(i10);
    }

    public final void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.TopTabView);
        kotlin.jvm.internal.s.h(obtainStyledAttributes, "context.obtainStyledAttr…, R.styleable.TopTabView)");
        int color = obtainStyledAttributes.getColor(0, com.cupidapp.live.base.utils.h.a(-526345, 0.1f));
        this.f12898c = obtainStyledAttributes.getColor(2, -11584935);
        this.f12899d = obtainStyledAttributes.getColor(4, -1);
        this.f12900e = obtainStyledAttributes.getColor(1, -1);
        this.f12901f = obtainStyledAttributes.getColor(3, 0);
        obtainStyledAttributes.recycle();
        setOrientation(0);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        int c4 = h.c(this, 2.0f);
        setPadding(c4, c4, c4, c4);
        y.i(this, (r18 & 1) != 0 ? 0.0f : h.c(this, 6.0f), r.e(Integer.valueOf(color)), (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : null, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? null : null, (r18 & 32) != 0 ? 0.0f : 0.0f, (r18 & 64) != 0 ? 0.0f : 0.0f);
    }

    @Nullable
    public final Function1<Integer, p> getClickListener() {
        return this.f12897b;
    }

    public final void setClickListener(@Nullable Function1<? super Integer, p> function1) {
        this.f12897b = function1;
    }

    public TopTabView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12898c = -11584935;
        this.f12899d = -1;
        this.f12900e = -1;
        c(attributeSet);
    }

    public TopTabView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f12898c = -11584935;
        this.f12899d = -1;
        this.f12900e = -1;
        c(attributeSet);
    }
}
