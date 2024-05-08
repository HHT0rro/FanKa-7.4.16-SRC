package com.cupidapp.live.match.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: StarLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class StarLayout extends LinearLayout {

    /* renamed from: b, reason: collision with root package name */
    public final int f16996b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16997c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StarLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16997c = new LinkedHashMap();
        this.f16996b = 5;
        a();
    }

    public final void a() {
        setOrientation(0);
        setGravity(16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StarLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16997c = new LinkedHashMap();
        this.f16996b = 5;
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StarLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16997c = new LinkedHashMap();
        this.f16996b = 5;
        a();
    }
}
