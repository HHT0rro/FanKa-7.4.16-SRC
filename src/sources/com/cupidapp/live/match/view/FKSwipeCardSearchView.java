package com.cupidapp.live.match.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.view.animation.FKWebpAnimationView;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKSwipeCardSearchView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKSwipeCardSearchView extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16898d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSwipeCardSearchView(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16898d = new LinkedHashMap();
        f();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f16898d;
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
        z0.z.a(this, R$layout.swipe_card_search_view, true);
        ((TextView) e(R$id.searching_title_textView)).getPaint().setFakeBoldText(true);
        setVisibility(8);
    }

    public final void g() {
        setVisibility(0);
        FKWebpAnimationView searching_imageview = (FKWebpAnimationView) e(R$id.searching_imageview);
        kotlin.jvm.internal.s.h(searching_imageview, "searching_imageview");
        FKWebpAnimationView.d(searching_imageview, "match_animator.webp", 0, null, 4, null);
    }

    public final void h() {
        setVisibility(8);
        ((FKWebpAnimationView) e(R$id.searching_imageview)).i();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSwipeCardSearchView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16898d = new LinkedHashMap();
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSwipeCardSearchView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16898d = new LinkedHashMap();
        f();
    }
}
