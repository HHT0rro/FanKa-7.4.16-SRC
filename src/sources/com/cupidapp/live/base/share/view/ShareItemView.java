package com.cupidapp.live.base.share.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.cupidapp.live.R$color;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;

/* compiled from: ShareItemView.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ShareItemView extends AppCompatTextView {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12265b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareItemView(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f12265b = new LinkedHashMap();
    }

    public final void setContent(@NotNull String content, int i10) {
        s.i(content, "content");
        setGravity(17);
        setText(content);
        setTextSize(12.0f);
        setTextColor(ContextCompat.getColor(getContext(), R$color.gray_7C7C7C));
        setCompoundDrawablesWithIntrinsicBounds(0, i10, 0, 0);
        setCompoundDrawablePadding(h.c(this, 5.0f));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f12265b = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f12265b = new LinkedHashMap();
    }
}
