package com.cupidapp.live.base.view.indicator.scroll;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.d;
import org.jetbrains.annotations.Nullable;

/* compiled from: RecyclerViewAttacher.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class RecyclerViewAttacher$attachToPager$3 extends RecyclerView.AdapterDataObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScrollingPagerIndicator f12800a;

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onChanged() {
        ScrollingPagerIndicator scrollingPagerIndicator = this.f12800a;
        RecyclerView.Adapter d10 = b.d(null);
        scrollingPagerIndicator.setDotCount(d10 != null ? d10.getItemCount() : 0);
        b.f(null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeChanged(int i10, int i11) {
        onChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeInserted(int i10, int i11) {
        onChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeMoved(int i10, int i11, int i12) {
        onChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeRemoved(int i10, int i11) {
        onChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeChanged(int i10, int i11, @Nullable Object obj) {
        onChanged();
    }
}
