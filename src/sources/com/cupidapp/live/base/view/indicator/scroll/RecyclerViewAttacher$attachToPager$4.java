package com.cupidapp.live.base.view.indicator.scroll;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: RecyclerViewAttacher.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class RecyclerViewAttacher$attachToPager$4 extends RecyclerView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScrollingPagerIndicator f12801a;

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i10) {
        int c4;
        s.i(recyclerView, "recyclerView");
        if (i10 == 0 && b.e(null) && (c4 = b.c(null)) != -1) {
            ScrollingPagerIndicator scrollingPagerIndicator = this.f12801a;
            RecyclerView.Adapter d10 = b.d(null);
            scrollingPagerIndicator.setDotCount(d10 != null ? d10.getItemCount() : 0);
            RecyclerView.Adapter d11 = b.d(null);
            if (c4 < (d11 != null ? d11.getItemCount() : 0)) {
                this.f12801a.setCurrentPosition(c4);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NotNull RecyclerView recyclerView, int i10, int i11) {
        s.i(recyclerView, "recyclerView");
        b.f(null);
    }
}
