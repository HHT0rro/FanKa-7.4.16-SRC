package com.yuyakaido.android.cardstackview.internal;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class CardStackDataObserver extends RecyclerView.AdapterDataObserver {

    /* renamed from: a, reason: collision with root package name */
    public final RecyclerView f48553a;

    public CardStackDataObserver(RecyclerView recyclerView) {
        this.f48553a = recyclerView;
    }

    public final CardStackLayoutManager a() {
        RecyclerView.LayoutManager layoutManager = this.f48553a.getLayoutManager();
        if (layoutManager instanceof CardStackLayoutManager) {
            return (CardStackLayoutManager) layoutManager;
        }
        throw new IllegalStateException("CardStackView must be set CardStackLayoutManager.");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onChanged() {
        a().w(0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeChanged(int i10, int i11) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeChanged(int i10, int i11, @Nullable Object obj) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeInserted(int i10, int i11) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeMoved(int i10, int i11, int i12) {
        a().removeAllViews();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeRemoved(int i10, int i11) {
        CardStackLayoutManager a10 = a();
        int f10 = a10.f();
        if (a10.getItemCount() == 0) {
            a10.w(0);
        } else if (i10 < f10) {
            a10.w(Math.min(f10 - (f10 - i10), a10.getItemCount() - 1));
        }
    }
}
