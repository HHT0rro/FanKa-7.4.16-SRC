package com.huawei.flexiblelayout.view.recyclerview.layoutmanager;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* compiled from: StaggeredGridLayoutManagerImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
class f extends a {
    @Override // com.huawei.flexiblelayout.view.recyclerview.layoutmanager.a
    public int a(@NonNull RecyclerView.LayoutManager layoutManager) {
        int i10 = -1;
        for (int i11 : ((StaggeredGridLayoutManager) layoutManager).findFirstVisibleItemPositions(null)) {
            if (i11 != -1 && (i10 == -1 || i11 < i10)) {
                i10 = i11;
            }
        }
        return i10;
    }

    @Override // com.huawei.flexiblelayout.view.recyclerview.layoutmanager.a
    public int b(@NonNull RecyclerView.LayoutManager layoutManager) {
        int i10 = -1;
        for (int i11 : ((StaggeredGridLayoutManager) layoutManager).findLastVisibleItemPositions(null)) {
            if (i11 > i10) {
                i10 = i11;
            }
        }
        return i10;
    }

    @Override // com.huawei.flexiblelayout.view.recyclerview.layoutmanager.a
    public int c(@NonNull RecyclerView.LayoutManager layoutManager) {
        return ((StaggeredGridLayoutManager) layoutManager).getOrientation();
    }

    @Override // com.huawei.flexiblelayout.view.recyclerview.layoutmanager.a
    public int d(@NonNull RecyclerView.LayoutManager layoutManager) {
        return ((StaggeredGridLayoutManager) layoutManager).getSpanCount();
    }

    @Override // com.huawei.flexiblelayout.view.recyclerview.layoutmanager.a
    public int[] a(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull int[] iArr) {
        ((StaggeredGridLayoutManager) layoutManager).findFirstVisibleItemPositions(iArr);
        return iArr;
    }

    @Override // com.huawei.flexiblelayout.view.recyclerview.layoutmanager.a
    public int[] b(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull int[] iArr) {
        ((StaggeredGridLayoutManager) layoutManager).findLastVisibleItemPositions(iArr);
        return iArr;
    }
}
