package com.cupidapp.live.base.view.decoration;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: StaggeredGridDecoration.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ProfileGridDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final MutableColumnRecyclerAdapter f12677a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12678b;

    public ProfileGridDecoration(@NotNull MutableColumnRecyclerAdapter adapter, int i10) {
        s.i(adapter, "adapter");
        this.f12677a = adapter;
        this.f12678b = i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        s.i(outRect, "outRect");
        s.i(view, "view");
        s.i(parent, "parent");
        s.i(state, "state");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        StaggeredGridLayoutManager.LayoutParams layoutParams2 = layoutParams instanceof StaggeredGridLayoutManager.LayoutParams ? (StaggeredGridLayoutManager.LayoutParams) layoutParams : null;
        int viewLayoutPosition = layoutParams2 != null ? layoutParams2.getViewLayoutPosition() : 0;
        int u10 = this.f12677a.u(viewLayoutPosition);
        int v2 = this.f12677a.v();
        this.f12677a.a(viewLayoutPosition);
        if (u10 > 1) {
            outRect.set(0, 0, 0, 0);
            return;
        }
        int spanIndex = layoutParams2 != null ? layoutParams2.getSpanIndex() : 0;
        if (spanIndex % v2 == 0) {
            int i10 = this.f12678b;
            outRect.set(0, i10, i10 / 2, 0);
        } else if ((spanIndex + 1) % v2 == 0) {
            int i11 = this.f12678b;
            outRect.set(0, i11, (-i11) / 2, 0);
        } else {
            int i12 = this.f12678b;
            outRect.set(i12 / 2, i12, i12 / 2, 0);
        }
    }
}
