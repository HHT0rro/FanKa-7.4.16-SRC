package com.cupidapp.live.base.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MarqueeTextView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MarqueeTextView extends AppCompatTextView {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12545b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarqueeTextView(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12545b = new LinkedHashMap();
        a();
    }

    public final void a() {
        setEllipsize(TextUtils.TruncateAt.MARQUEE);
        setSingleLine(true);
        setFocusableInTouchMode(true);
        setFocusable(true);
        setMarqueeRepeatLimit(-1);
        setHorizontallyScrolling(true);
    }

    @Override // android.view.View
    public boolean isFocused() {
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarqueeTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12545b = new LinkedHashMap();
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarqueeTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12545b = new LinkedHashMap();
        a();
    }
}
