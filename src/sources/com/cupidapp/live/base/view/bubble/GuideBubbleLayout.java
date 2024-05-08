package com.cupidapp.live.base.view.bubble;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.cupidapp.live.R$layout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: GuideBubbleLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class GuideBubbleLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12652b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuideBubbleLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f12652b = new LinkedHashMap();
        a();
    }

    public final void a() {
        z.a(this, R$layout.layout_guide_bubble, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuideBubbleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f12652b = new LinkedHashMap();
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuideBubbleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f12652b = new LinkedHashMap();
        a();
    }
}
