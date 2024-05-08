package com.cupidapp.live.match.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.view.BaseLayout;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: IntelligentRcmdWordItemLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class IntelligentRcmdWordItemLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public Function1<? super String, kotlin.p> f16940d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16941e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntelligentRcmdWordItemLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16941e = new LinkedHashMap();
        i();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f16941e;
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

    public final void g(@NotNull String key, @NotNull List<String> contents, @NotNull Function1<? super String, kotlin.p> clickListener) {
        kotlin.jvm.internal.s.i(key, "key");
        kotlin.jvm.internal.s.i(contents, "contents");
        kotlin.jvm.internal.s.i(clickListener, "clickListener");
        this.f16940d = clickListener;
        ((TextView) e(R$id.rcmd_key)).setText(key);
        ((LinearLayout) e(R$id.rcmd_word_linear)).removeAllViews();
        int l10 = ((((z0.h.l(this) - z0.h.c(this, 60.0f)) - z0.h.c(this, 16.0f)) - z0.h.c(this, 10.0f)) / 4) - z0.h.c(this, 8.0f);
        Iterator<String> iterator2 = contents.iterator2();
        while (iterator2.hasNext()) {
            View h10 = h(iterator2.next());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(l10, z0.h.c(this, 32.0f));
            layoutParams.setMarginEnd(z0.h.c(layoutParams, 8.0f));
            h10.setLayoutParams(layoutParams);
            ((LinearLayout) e(R$id.rcmd_word_linear)).addView(h10);
        }
    }

    public final View h(final String str) {
        View itemView = LayoutInflater.from(getContext()).inflate(R$layout.item_intelligent_rcmd_word, (ViewGroup) e(R$id.rcmd_word_root), false);
        TextView textView = (TextView) itemView.findViewById(R$id.item_con_txt);
        kotlin.jvm.internal.s.h(textView, "textView");
        z0.u.a(textView);
        textView.setTextSize(12.0f);
        textView.setText(str);
        kotlin.jvm.internal.s.h(itemView, "itemView");
        z0.y.d(itemView, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.IntelligentRcmdWordItemLayout$getItemView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                Function1 function1;
                function1 = IntelligentRcmdWordItemLayout.this.f16940d;
                if (function1 != null) {
                    function1.invoke(str);
                }
            }
        });
        return itemView;
    }

    public final void i() {
        z0.z.a(this, R$layout.item_rcmd_word, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntelligentRcmdWordItemLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16941e = new LinkedHashMap();
        i();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntelligentRcmdWordItemLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16941e = new LinkedHashMap();
        i();
    }
}
