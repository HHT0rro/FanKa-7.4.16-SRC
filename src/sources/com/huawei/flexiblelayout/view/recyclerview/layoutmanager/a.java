package com.huawei.flexiblelayout.view.recyclerview.layoutmanager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;

/* compiled from: BaseLayoutManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
abstract class a implements FLLayoutManager {
    private int[] a(@Nullable int[] iArr, int i10, String str) {
        if (iArr == null) {
            return new int[i10];
        }
        if (iArr.length >= i10) {
            return iArr;
        }
        throw new IllegalArgumentException(str);
    }

    public abstract int a(@NonNull RecyclerView.LayoutManager layoutManager);

    public abstract int[] a(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull int[] iArr);

    public abstract int b(@NonNull RecyclerView.LayoutManager layoutManager);

    public abstract int[] b(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull int[] iArr);

    public abstract int c(@NonNull RecyclerView.LayoutManager layoutManager);

    public abstract int d(@NonNull RecyclerView.LayoutManager layoutManager);

    @Override // com.huawei.flexiblelayout.view.recyclerview.layoutmanager.FLLayoutManager
    public final int findFirstVisibleItemPosition(@NonNull RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
            return -1;
        }
        return a(layoutManager);
    }

    @Override // com.huawei.flexiblelayout.view.recyclerview.layoutmanager.FLLayoutManager
    public final int[] findFirstVisibleItemPositions(@NonNull RecyclerView recyclerView, @Nullable int[] iArr) {
        int spanCount = getSpanCount(recyclerView);
        int[] a10 = a(iArr, spanCount, "BaseLayoutManager findFirstVisibleItemPositions failed, Provided int[]'s size must be more than or equal " + spanCount);
        Arrays.fill(a10, 0, spanCount, -1);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            a(layoutManager, a10);
        }
        return a10;
    }

    @Override // com.huawei.flexiblelayout.view.recyclerview.layoutmanager.FLLayoutManager
    public final int findLastVisibleItemPosition(@NonNull RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
            return -1;
        }
        return b(layoutManager);
    }

    @Override // com.huawei.flexiblelayout.view.recyclerview.layoutmanager.FLLayoutManager
    public final int[] findLastVisibleItemPositions(@NonNull RecyclerView recyclerView, @Nullable int[] iArr) {
        int spanCount = getSpanCount(recyclerView);
        int[] a10 = a(iArr, spanCount, "BaseLayoutManager findLastVisibleItemPositions failed, Provided int[]'s size must be more than or equal " + spanCount);
        Arrays.fill(a10, 0, spanCount, -1);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            b(layoutManager, a10);
        }
        return a10;
    }

    @Override // com.huawei.flexiblelayout.view.recyclerview.layoutmanager.FLLayoutManager
    public final int getOrientation(@NonNull RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
            return 1;
        }
        return c(layoutManager);
    }

    @Override // com.huawei.flexiblelayout.view.recyclerview.layoutmanager.FLLayoutManager
    public /* synthetic */ int getRowItemSize(int i10, int i11, int i12) {
        return g.a(this, i10, i11, i12);
    }

    @Override // com.huawei.flexiblelayout.view.recyclerview.layoutmanager.FLLayoutManager
    public final int getSpanCount(@NonNull RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
            return 1;
        }
        return d(layoutManager);
    }
}
