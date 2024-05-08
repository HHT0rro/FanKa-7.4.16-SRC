package com.cupidapp.live.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SubRecyclerview.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SubRecyclerview extends RecyclerView {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12561b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubRecyclerview(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12561b = new LinkedHashMap();
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i10) {
        if (getLayoutManager() instanceof LinearLayoutManager) {
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            kotlin.jvm.internal.s.g(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            if (((LinearLayoutManager) layoutManager).getOrientation() == 0) {
                return true;
            }
        }
        return super.canScrollHorizontally(i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubRecyclerview(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12561b = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubRecyclerview(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f12561b = new LinkedHashMap();
    }
}
