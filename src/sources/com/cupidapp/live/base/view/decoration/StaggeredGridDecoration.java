package com.cupidapp.live.base.view.decoration;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: StaggeredGridDecoration.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class StaggeredGridDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    public final int f12683a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12684b;

    /* renamed from: c, reason: collision with root package name */
    public final int f12685c;

    /* renamed from: d, reason: collision with root package name */
    public final int f12686d;

    /* renamed from: e, reason: collision with root package name */
    public final int f12687e;

    public StaggeredGridDecoration() {
        this(0, 0, 0, 0, 0, 31, null);
    }

    public /* synthetic */ StaggeredGridDecoration(int i10, int i11, int i12, int i13, int i14, int i15, DefaultConstructorMarker defaultConstructorMarker) {
        this((i15 & 1) != 0 ? 0 : i10, (i15 & 2) != 0 ? 0 : i11, (i15 & 4) != 0 ? 0 : i12, (i15 & 8) != 0 ? 0 : i13, (i15 & 16) != 0 ? 0 : i14);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        s.i(outRect, "outRect");
        s.i(view, "view");
        s.i(parent, "parent");
        s.i(state, "state");
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        RecyclerView.Adapter adapter = parent.getAdapter();
        if ((layoutManager instanceof StaggeredGridLayoutManager) && (adapter instanceof MutableColumnRecyclerAdapter)) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            s.g(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
            StaggeredGridLayoutManager.LayoutParams layoutParams2 = (StaggeredGridLayoutManager.LayoutParams) layoutParams;
            int spanIndex = layoutParams2.getSpanIndex();
            int viewLayoutPosition = layoutParams2.getViewLayoutPosition();
            MutableColumnRecyclerAdapter mutableColumnRecyclerAdapter = (MutableColumnRecyclerAdapter) adapter;
            int v2 = mutableColumnRecyclerAdapter.v();
            if (mutableColumnRecyclerAdapter.u(viewLayoutPosition) == v2) {
                outRect.set(0, 0, 0, 0);
                return;
            }
            if (spanIndex % v2 == 0) {
                outRect.set(this.f12683a + this.f12687e, this.f12684b, this.f12685c, this.f12686d);
            } else if ((spanIndex + 1) % v2 == 0) {
                outRect.set(this.f12683a, this.f12684b, this.f12685c + this.f12687e, this.f12686d);
            } else {
                outRect.set(this.f12683a, this.f12684b, this.f12685c, this.f12686d);
            }
        }
    }

    public StaggeredGridDecoration(int i10, int i11, int i12, int i13, int i14) {
        this.f12683a = i10;
        this.f12684b = i11;
        this.f12685c = i12;
        this.f12686d = i13;
        this.f12687e = i14;
    }
}
