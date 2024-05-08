package com.huawei.flexiblelayout.view.recyclerview.layoutmanager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.flexiblelayout.services.recyclerview.LayoutManagerExt;

/* compiled from: LayoutManagerExtImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
class d implements FLLayoutManager {
    private int[] a(@Nullable int[] iArr, int i10, String str) {
        if (iArr == null) {
            return new int[i10];
        }
        if (iArr.length >= i10) {
            return iArr;
        }
        throw new IllegalArgumentException(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huawei.flexiblelayout.view.recyclerview.layoutmanager.FLLayoutManager
    public int findFirstVisibleItemPosition(@NonNull RecyclerView recyclerView) {
        return ((LayoutManagerExt) recyclerView).findFirstVisibleItemPosition(recyclerView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huawei.flexiblelayout.view.recyclerview.layoutmanager.FLLayoutManager
    public int[] findFirstVisibleItemPositions(@NonNull RecyclerView recyclerView, @Nullable int[] iArr) {
        int spanCount = getSpanCount(recyclerView);
        int[] a10 = a(iArr, spanCount, "LayoutManagerExtImpl findFirstVisibleItemPositions failed, Provided int[]'s size must be more than or equal " + spanCount);
        ((LayoutManagerExt) recyclerView).findFirstVisibleItemPositions(recyclerView, a10);
        return a10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huawei.flexiblelayout.view.recyclerview.layoutmanager.FLLayoutManager
    public int findLastVisibleItemPosition(@NonNull RecyclerView recyclerView) {
        return ((LayoutManagerExt) recyclerView).findLastVisibleItemPosition(recyclerView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huawei.flexiblelayout.view.recyclerview.layoutmanager.FLLayoutManager
    public int[] findLastVisibleItemPositions(@NonNull RecyclerView recyclerView, @Nullable int[] iArr) {
        int spanCount = getSpanCount(recyclerView);
        int[] a10 = a(iArr, spanCount, "LayoutManagerExtImpl findLastVisibleItemPositions failed, Provided int[]'s size must be more than or equal " + spanCount);
        ((LayoutManagerExt) recyclerView).findLastVisibleItemPositions(recyclerView, a10);
        return a10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huawei.flexiblelayout.view.recyclerview.layoutmanager.FLLayoutManager
    public int getOrientation(@NonNull RecyclerView recyclerView) {
        return ((LayoutManagerExt) recyclerView).getOrientation(recyclerView);
    }

    @Override // com.huawei.flexiblelayout.view.recyclerview.layoutmanager.FLLayoutManager
    public /* synthetic */ int getRowItemSize(int i10, int i11, int i12) {
        return g.a(this, i10, i11, i12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huawei.flexiblelayout.view.recyclerview.layoutmanager.FLLayoutManager
    public int getSpanCount(@NonNull RecyclerView recyclerView) {
        return ((LayoutManagerExt) recyclerView).getSpanCount(recyclerView);
    }
}
