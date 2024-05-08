package com.huawei.flexiblelayout.services.recyclerview;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.flexiblelayout.view.recyclerview.layoutmanager.FLLayoutManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface LayoutManagerExt extends FLLayoutManager {
    @Override // com.huawei.flexiblelayout.view.recyclerview.layoutmanager.FLLayoutManager
    int findFirstVisibleItemPosition(@NonNull RecyclerView recyclerView);

    @Override // com.huawei.flexiblelayout.view.recyclerview.layoutmanager.FLLayoutManager
    int[] findFirstVisibleItemPositions(@NonNull RecyclerView recyclerView, int[] iArr);

    @Override // com.huawei.flexiblelayout.view.recyclerview.layoutmanager.FLLayoutManager
    int findLastVisibleItemPosition(@NonNull RecyclerView recyclerView);

    @Override // com.huawei.flexiblelayout.view.recyclerview.layoutmanager.FLLayoutManager
    int[] findLastVisibleItemPositions(@NonNull RecyclerView recyclerView, int[] iArr);
}
