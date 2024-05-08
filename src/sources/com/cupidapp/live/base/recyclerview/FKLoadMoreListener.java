package com.cupidapp.live.base.recyclerview;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import kotlin.collections.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLoadMoreListener.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLoadMoreListener extends RecyclerView.OnScrollListener {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f12038d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final Function0<p> f12039a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f12040b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public RecyclerView.OnScrollListener f12041c;

    /* compiled from: FKLoadMoreListener.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(@NotNull RecyclerView recyclerView) {
            s.i(recyclerView, "recyclerView");
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (!(layoutManager instanceof LinearLayoutManager)) {
                return false;
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            int itemCount = linearLayoutManager.getItemCount();
            return itemCount - findLastVisibleItemPosition <= 5 && itemCount - 1 != findLastVisibleItemPosition;
        }
    }

    public FKLoadMoreListener(@NotNull Function0<p> loadMoreCallBack) {
        s.i(loadMoreCallBack, "loadMoreCallBack");
        this.f12039a = loadMoreCallBack;
    }

    public final void c(boolean z10) {
        this.f12040b = z10;
    }

    public final void d(@Nullable RecyclerView.OnScrollListener onScrollListener) {
        this.f12041c = onScrollListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i10) {
        s.i(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, i10);
        RecyclerView.OnScrollListener onScrollListener = this.f12041c;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(recyclerView, i10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NotNull RecyclerView recyclerView, int i10, int i11) {
        s.i(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i10, i11);
        RecyclerView.OnScrollListener onScrollListener = this.f12041c;
        if (onScrollListener != null) {
            onScrollListener.onScrolled(recyclerView, i10, i11);
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            int itemCount = staggeredGridLayoutManager.getItemCount();
            int[] lastPositionRange = staggeredGridLayoutManager.findLastVisibleItemPositions(new int[staggeredGridLayoutManager.getSpanCount()]);
            s.h(lastPositionRange, "lastPositionRange");
            int max = Math.max(m.w(lastPositionRange), m.F(lastPositionRange));
            if (this.f12040b || itemCount != max + 1) {
                return;
            }
            this.f12040b = true;
            this.f12039a.invoke();
            return;
        }
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            int itemCount2 = linearLayoutManager.getItemCount();
            if (this.f12040b || itemCount2 - findLastVisibleItemPosition > 5 || itemCount2 - 1 == findLastVisibleItemPosition) {
                return;
            }
            this.f12040b = true;
            this.f12039a.invoke();
        }
    }
}
