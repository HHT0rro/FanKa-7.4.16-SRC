package com.huawei.flexiblelayout.view.recyclerview.layoutmanager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface FLLayoutManager {
    int findFirstVisibleItemPosition(@NonNull RecyclerView recyclerView);

    int[] findFirstVisibleItemPositions(@NonNull RecyclerView recyclerView, @Nullable int[] iArr);

    int findLastVisibleItemPosition(@NonNull RecyclerView recyclerView);

    int[] findLastVisibleItemPositions(@NonNull RecyclerView recyclerView, @Nullable int[] iArr);

    int getOrientation(@NonNull RecyclerView recyclerView);

    int getRowItemSize(int i10, int i11, int i12);

    int getSpanCount(@NonNull RecyclerView recyclerView);
}
