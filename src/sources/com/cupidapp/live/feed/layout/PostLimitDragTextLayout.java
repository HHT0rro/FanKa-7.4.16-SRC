package com.cupidapp.live.feed.layout;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.view.drag.FKBaseDragLayout;
import com.cupidapp.live.feed.layout.PostLimitCreateTextLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: PostLimitDragTextLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PostLimitDragTextLayout extends FKBaseDragLayout {

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14547m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostLimitDragTextLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14547m = new LinkedHashMap();
        i();
    }

    @Nullable
    public View g(int i10) {
        Map<Integer, View> map = this.f14547m;
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

    @NotNull
    public final String getTextContent() {
        return ((TextView) g(R$id.post_limit_drag_text_view)).getText().toString();
    }

    public final void h(@NotNull CreateTextUiModel model) {
        Typeface typeface;
        kotlin.jvm.internal.s.i(model, "model");
        TextView textView = (TextView) g(R$id.post_limit_drag_text_view);
        textView.setText(model.getText());
        if (model.getFontType() != PostLimitTextFontType.DEFAULT && model.getFontType().getFontResId() > 0) {
            typeface = ResourcesCompat.getFont(getContext(), model.getFontType().getFontResId());
        } else {
            typeface = Typeface.DEFAULT;
        }
        textView.setTypeface(typeface);
        textView.setBackgroundColor(ContextCompat.getColor(getContext(), model.getBgType().getBgColorResId()));
        textView.setTextColor(ContextCompat.getColor(getContext(), model.getBgType().getTextColorResId()));
        textView.setTextSize(model.getSize());
        textView.setGravity(model.getGravity());
        PostLimitCreateTextLayout.a aVar = PostLimitCreateTextLayout.f14532h;
        int b4 = aVar.b();
        int c4 = aVar.c();
        textView.setPadding(b4, c4, b4, c4);
    }

    public final void i() {
        z.a(this, R$layout.layout_post_limit_drag_text, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostLimitDragTextLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14547m = new LinkedHashMap();
        i();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostLimitDragTextLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14547m = new LinkedHashMap();
        i();
    }
}
