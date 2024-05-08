package com.cupidapp.live.feed.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.cupidapp.live.R$layout;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FeedDetailManagerLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedDetailManagerLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14459b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedDetailManagerLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14459b = new LinkedHashMap();
        a();
    }

    public final void a() {
        z.a(this, R$layout.layout_feeddetail_manager, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedDetailManagerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14459b = new LinkedHashMap();
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedDetailManagerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14459b = new LinkedHashMap();
        a();
    }
}
