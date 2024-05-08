package com.huawei.flexiblelayout.view;

import androidx.recyclerview.widget.RecyclerView;
import com.huawei.flexiblelayout.FLayout;
import com.huawei.flexiblelayout.adapter.LayoutManagerHelper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class LayoutScroller {

    /* renamed from: a, reason: collision with root package name */
    private final FLayout f28645a;

    /* renamed from: b, reason: collision with root package name */
    private final RecyclerView f28646b;

    public LayoutScroller(FLayout fLayout) {
        this.f28645a = fLayout;
        LayoutView layoutView = fLayout.getLayoutView();
        if (layoutView != null && (layoutView.getView() instanceof RecyclerView)) {
            this.f28646b = (RecyclerView) layoutView.getView();
        } else {
            this.f28646b = null;
        }
    }

    public void scrollBy(int i10, int i11) {
        RecyclerView recyclerView = this.f28646b;
        if (recyclerView == null) {
            return;
        }
        recyclerView.scrollBy(i10, i11);
    }

    public void scrollToEnd(boolean z10) {
        scrollToPosition(-1, z10);
    }

    public void scrollToOffset(int i10, boolean z10) {
        RecyclerView recyclerView;
        if (i10 == 0 || (recyclerView = this.f28646b) == null) {
            return;
        }
        if (i10 > 0) {
            int findLastVisibleItemPosition = LayoutManagerHelper.findLastVisibleItemPosition(recyclerView);
            int size = this.f28645a.getDataSource().getSize();
            if (findLastVisibleItemPosition >= size) {
                findLastVisibleItemPosition = size - 1;
            }
            scrollToPosition(Math.min(findLastVisibleItemPosition + i10, size - 1), z10);
            return;
        }
        scrollToPosition(Math.max(LayoutManagerHelper.findFirstVisibleItemPosition(recyclerView) + i10, 0), z10);
    }

    public void scrollToPosition(int i10, boolean z10) {
        if (this.f28646b == null) {
            return;
        }
        if (i10 == -1) {
            i10 = this.f28645a.getDataSource().getSize();
        }
        if (z10) {
            this.f28646b.smoothScrollToPosition(i10);
        } else {
            this.f28646b.scrollToPosition(i10);
        }
    }

    public void scrollToStart(boolean z10) {
        scrollToPosition(0, z10);
    }
}
