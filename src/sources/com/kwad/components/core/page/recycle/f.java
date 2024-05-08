package com.kwad.components.core.page.recycle;

import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.utils.ap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class f {
    public final RecyclerView PU;
    public final RecyclerView.LayoutManager PV;

    private f(RecyclerView recyclerView) {
        this.PU = recyclerView;
        this.PV = recyclerView.getLayoutManager();
    }

    private View a(int i10, int i11, boolean z10, boolean z11) {
        OrientationHelper createHorizontalHelper;
        if (this.PV.canScrollVertically()) {
            createHorizontalHelper = OrientationHelper.createVerticalHelper(this.PV);
        } else {
            createHorizontalHelper = OrientationHelper.createHorizontalHelper(this.PV);
        }
        int startAfterPadding = createHorizontalHelper.getStartAfterPadding();
        int endAfterPadding = createHorizontalHelper.getEndAfterPadding();
        int i12 = i11 > i10 ? 1 : -1;
        while (i10 != i11) {
            View childAt = this.PV.getChildAt(i10);
            int decoratedStart = createHorizontalHelper.getDecoratedStart(childAt);
            int decoratedEnd = createHorizontalHelper.getDecoratedEnd(childAt);
            if (decoratedStart < endAfterPadding && decoratedEnd > startAfterPadding) {
                return childAt;
            }
            i10 += i12;
        }
        return null;
    }

    public static f b(RecyclerView recyclerView) {
        ap.checkNotNull(recyclerView);
        return new f(recyclerView);
    }

    public final int findFirstVisibleItemPosition() {
        View a10 = a(0, this.PV.getChildCount(), false, true);
        if (a10 == null) {
            return -1;
        }
        return this.PU.getChildAdapterPosition(a10);
    }

    public final int findLastVisibleItemPosition() {
        View a10 = a(this.PV.getChildCount() - 1, -1, false, true);
        if (a10 == null) {
            return -1;
        }
        return this.PU.getChildAdapterPosition(a10);
    }
}
