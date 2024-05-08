package com.huawei.flexiblelayout.view.recyclerview.layoutmanager;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: LinearLayoutManagerImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
class e extends a {
    @Override // com.huawei.flexiblelayout.view.recyclerview.layoutmanager.a
    public int a(@NonNull RecyclerView.LayoutManager layoutManager) {
        return ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
    }

    @Override // com.huawei.flexiblelayout.view.recyclerview.layoutmanager.a
    public int b(@NonNull RecyclerView.LayoutManager layoutManager) {
        return ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
    }

    @Override // com.huawei.flexiblelayout.view.recyclerview.layoutmanager.a
    public int c(@NonNull RecyclerView.LayoutManager layoutManager) {
        return ((LinearLayoutManager) layoutManager).getOrientation();
    }

    @Override // com.huawei.flexiblelayout.view.recyclerview.layoutmanager.a
    public int d(@NonNull RecyclerView.LayoutManager layoutManager) {
        return 1;
    }

    @Override // com.huawei.flexiblelayout.view.recyclerview.layoutmanager.a
    public int[] a(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull int[] iArr) {
        iArr[0] = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        return iArr;
    }

    @Override // com.huawei.flexiblelayout.view.recyclerview.layoutmanager.a
    public int[] b(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull int[] iArr) {
        iArr[0] = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
        return iArr;
    }
}
