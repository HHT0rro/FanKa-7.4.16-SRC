package com.cupidapp.live.match.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.view.BaseLayout;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: IntelligentFilterRcmdWordLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class IntelligentFilterRcmdWordLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16939d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntelligentFilterRcmdWordLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16939d = new LinkedHashMap();
        g();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f16939d;
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

    public final void f(@NotNull Map<String, ? extends List<String>> word, @NotNull Function1<? super String, kotlin.p> clickListener) {
        kotlin.jvm.internal.s.i(word, "word");
        kotlin.jvm.internal.s.i(clickListener, "clickListener");
        ((LinearLayout) e(R$id.rcmd_word_root)).removeAllViews();
        for (Map.Entry<String, ? extends List<String>> entry : word.entrySet()) {
            Context context = getContext();
            kotlin.jvm.internal.s.h(context, "context");
            IntelligentRcmdWordItemLayout intelligentRcmdWordItemLayout = new IntelligentRcmdWordItemLayout(context);
            intelligentRcmdWordItemLayout.g(entry.getKey(), entry.getValue(), clickListener);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, z0.h.c(this, 32.0f));
            layoutParams.bottomMargin = z0.h.c(layoutParams, 12.0f);
            intelligentRcmdWordItemLayout.setLayoutParams(layoutParams);
            ((LinearLayout) e(R$id.rcmd_word_root)).addView(intelligentRcmdWordItemLayout);
        }
    }

    public final void g() {
        z0.z.a(this, R$layout.layout_intelligent_rcmd_keyword, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntelligentFilterRcmdWordLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16939d = new LinkedHashMap();
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntelligentFilterRcmdWordLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16939d = new LinkedHashMap();
        g();
    }
}
