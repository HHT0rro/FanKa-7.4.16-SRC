package com.cupidapp.live.base.recyclerview.decoration;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKRecyclerViewDecoration.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class FKRecyclerViewDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    public final int f12084a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final List<Rect> f12085b;

    public FKRecyclerViewDecoration() {
        this(0, 1, null);
    }

    public /* synthetic */ FKRecyclerViewDecoration(int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 20 : i10);
    }

    public final List<Rect> a(int i10, int i11, int i12, int i13, int i14) {
        int i15 = i11 - i12;
        int i16 = i15 - this.f12084a;
        ArrayList arrayList = new ArrayList();
        for (int i17 = 0; i17 < i10; i17++) {
            if (i17 == 0) {
                arrayList.add(new Rect(this.f12084a, i13, i16, 0));
            } else {
                int i18 = i14 - ((Rect) CollectionsKt___CollectionsKt.e0(arrayList)).right;
                arrayList.add(new Rect(i18, i13, i15 - i18, 0));
            }
        }
        return arrayList;
    }

    public final void b(int i10, RecyclerView recyclerView) {
        if (!this.f12085b.isEmpty()) {
            return;
        }
        int i11 = this.f12084a;
        int measuredWidth = recyclerView.getMeasuredWidth() / i10;
        int measuredWidth2 = recyclerView.getMeasuredWidth();
        int i12 = this.f12084a;
        this.f12085b.addAll(a(i10, measuredWidth, (measuredWidth2 - ((i10 + 1) * i12)) / i10, i11, i12));
    }

    public int c(int i10, int i11) {
        return i10 % i11;
    }

    public final int d(RecyclerView recyclerView) {
        if (recyclerView == null) {
            return 0;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).getSpanCount();
        }
        if (layoutManager != null) {
            return layoutManager.getItemCount();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        s.i(outRect, "outRect");
        s.i(view, "view");
        s.i(parent, "parent");
        s.i(state, "state");
        int d10 = d(parent);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        s.g(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        int viewLayoutPosition = ((RecyclerView.LayoutParams) layoutParams).getViewLayoutPosition();
        b(d10, parent);
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        if ((layoutManager instanceof GridLayoutManager) && ((GridLayoutManager) layoutManager).getSpanSizeLookup().getSpanSize(viewLayoutPosition) == d10) {
            int i10 = this.f12084a;
            outRect.set(i10, i10, i10, 0);
        } else {
            Rect rect = this.f12085b.get(c(viewLayoutPosition, d10));
            outRect.set(rect.left, rect.top, rect.right, 0);
        }
    }

    public FKRecyclerViewDecoration(int i10) {
        this.f12084a = i10;
        this.f12085b = new ArrayList();
    }
}
