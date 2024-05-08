package com.huawei.flexiblelayout.services.recyclerview;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;

/* compiled from: LayoutManagerExt.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final /* synthetic */ class a {
    public static int a(LayoutManagerExt layoutManagerExt, @NonNull RecyclerView recyclerView) {
        if (recyclerView.getChildCount() > 0) {
            return recyclerView.getChildAdapterPosition(recyclerView.getChildAt(0));
        }
        return -1;
    }

    public static int[] b(LayoutManagerExt layoutManagerExt, @NonNull RecyclerView recyclerView, int[] iArr) {
        int spanCount = layoutManagerExt.getSpanCount(recyclerView);
        if (iArr == null) {
            iArr = new int[spanCount];
        } else if (iArr.length < spanCount) {
            throw new IllegalArgumentException("LayoutManagerExt, findFirstVisibleItemPositions Provided int[]'s size must be more than or equal to span count. Expected:" + spanCount + ", array size:" + iArr.length);
        }
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter == null) {
            Arrays.fill(iArr, 0, spanCount, -1);
            return iArr;
        }
        int findFirstVisibleItemPosition = layoutManagerExt.findFirstVisibleItemPosition(recyclerView);
        int rowItemSize = layoutManagerExt.getRowItemSize(adapter.getItemCount(), spanCount, findFirstVisibleItemPosition);
        for (int i10 = 0; i10 < spanCount; i10++) {
            if (i10 < rowItemSize) {
                iArr[i10] = findFirstVisibleItemPosition + i10;
            } else {
                iArr[i10] = -1;
            }
        }
        return iArr;
    }

    public static int c(LayoutManagerExt layoutManagerExt, @NonNull RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        if (childCount > 0) {
            return recyclerView.getChildAdapterPosition(recyclerView.getChildAt(childCount - 1));
        }
        return -1;
    }

    public static int[] d(LayoutManagerExt layoutManagerExt, @NonNull RecyclerView recyclerView, int[] iArr) {
        int spanCount = layoutManagerExt.getSpanCount(recyclerView);
        if (iArr == null) {
            iArr = new int[spanCount];
        } else if (iArr.length < spanCount) {
            throw new IllegalArgumentException("LayoutManagerExt, findLastVisibleItemPositions Provided int[]'s size must be more than or equal to span count. Expected:" + spanCount + ", array size:" + iArr.length);
        }
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter == null) {
            Arrays.fill(iArr, 0, spanCount, -1);
            return iArr;
        }
        int findLastVisibleItemPosition = layoutManagerExt.findLastVisibleItemPosition(recyclerView);
        int rowItemSize = layoutManagerExt.getRowItemSize(adapter.getItemCount(), spanCount, findLastVisibleItemPosition);
        for (int i10 = 0; i10 < spanCount; i10++) {
            if (i10 < rowItemSize) {
                iArr[i10] = findLastVisibleItemPosition - ((rowItemSize - 1) - i10);
            } else {
                iArr[i10] = -1;
            }
        }
        return iArr;
    }
}
