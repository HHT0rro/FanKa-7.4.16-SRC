package com.huawei.flexiblelayout.view.recyclerview.layoutmanager;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: GridLayoutManagerImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
class c extends e {
    @Override // com.huawei.flexiblelayout.view.recyclerview.layoutmanager.e, com.huawei.flexiblelayout.view.recyclerview.layoutmanager.a
    public int[] a(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull int[] iArr) {
        int d10 = d(layoutManager);
        int a10 = a(layoutManager);
        int rowItemSize = getRowItemSize(layoutManager.getItemCount(), d10, a10);
        for (int i10 = 0; i10 < d10; i10++) {
            if (i10 < rowItemSize) {
                iArr[i10] = a10 + i10;
            } else {
                iArr[i10] = -1;
            }
        }
        return iArr;
    }

    @Override // com.huawei.flexiblelayout.view.recyclerview.layoutmanager.e, com.huawei.flexiblelayout.view.recyclerview.layoutmanager.a
    public int[] b(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull int[] iArr) {
        int d10 = d(layoutManager);
        int b4 = b(layoutManager);
        int rowItemSize = getRowItemSize(layoutManager.getItemCount(), d10, b4);
        for (int i10 = 0; i10 < d10; i10++) {
            if (i10 < rowItemSize) {
                iArr[i10] = b4 - ((rowItemSize - 1) - i10);
            } else {
                iArr[i10] = -1;
            }
        }
        return iArr;
    }

    @Override // com.huawei.flexiblelayout.view.recyclerview.layoutmanager.e, com.huawei.flexiblelayout.view.recyclerview.layoutmanager.a
    public int d(@NonNull RecyclerView.LayoutManager layoutManager) {
        return ((GridLayoutManager) layoutManager).getSpanCount();
    }
}
