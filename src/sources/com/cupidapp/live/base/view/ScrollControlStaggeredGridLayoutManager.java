package com.cupidapp.live.base.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import org.jetbrains.annotations.Nullable;

/* compiled from: ScrollControlStaggeredGridLayoutManager.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ScrollControlStaggeredGridLayoutManager extends StaggeredGridLayoutManager {

    /* renamed from: a, reason: collision with root package name */
    public boolean f12558a;

    public ScrollControlStaggeredGridLayoutManager(@Nullable Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f12558a = true;
    }

    public final void a(boolean z10) {
        this.f12558a = z10;
    }

    @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.f12558a && super.canScrollVertically();
    }

    public ScrollControlStaggeredGridLayoutManager(int i10, int i11) {
        super(i10, i11);
        this.f12558a = true;
    }
}
