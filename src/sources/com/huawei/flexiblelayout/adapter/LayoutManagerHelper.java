package com.huawei.flexiblelayout.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.flexiblelayout.view.recyclerview.layoutmanager.FLLayoutManager;
import com.huawei.flexiblelayout.view.recyclerview.layoutmanager.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class LayoutManagerHelper {
    public static int findFirstVisibleItemPosition(@NonNull RecyclerView recyclerView) {
        FLLayoutManager a10 = b.a(recyclerView);
        if (a10 != null) {
            return a10.findFirstVisibleItemPosition(recyclerView);
        }
        return -1;
    }

    public static int[] findFirstVisibleItemPositions(@NonNull RecyclerView recyclerView, @Nullable int[] iArr) {
        int spanCount = getSpanCount(recyclerView);
        if (iArr == null) {
            iArr = new int[spanCount];
        } else if (iArr.length < spanCount) {
            throw new IllegalArgumentException("LayoutManagerHelper findFirstVisibleItemPositions failed, Provided int[]'s size must be more than or equal to span count. Expected:" + spanCount + ", array size:" + iArr.length);
        }
        FLLayoutManager a10 = b.a(recyclerView);
        if (a10 != null) {
            return a10.findFirstVisibleItemPositions(recyclerView, iArr);
        }
        for (int i10 = 0; i10 < spanCount; i10++) {
            iArr[i10] = -1;
        }
        return iArr;
    }

    public static int findLastVisibleItemPosition(@NonNull RecyclerView recyclerView) {
        FLLayoutManager a10 = b.a(recyclerView);
        if (a10 != null) {
            return a10.findLastVisibleItemPosition(recyclerView);
        }
        return -1;
    }

    public static int[] findLastVisibleItemPositions(@NonNull RecyclerView recyclerView, @Nullable int[] iArr) {
        int spanCount = getSpanCount(recyclerView);
        if (iArr == null) {
            iArr = new int[spanCount];
        } else if (iArr.length < spanCount) {
            throw new IllegalArgumentException("LayoutManagerHelper findLastVisibleItemPositions failed, Provided int[]'s size must be more than or equal to span count. Expected:" + spanCount + ", array size:" + iArr.length);
        }
        FLLayoutManager a10 = b.a(recyclerView);
        if (a10 != null) {
            return a10.findLastVisibleItemPositions(recyclerView, iArr);
        }
        for (int i10 = 0; i10 < spanCount; i10++) {
            iArr[i10] = -1;
        }
        return iArr;
    }

    public static int getOrientation(@NonNull RecyclerView recyclerView) {
        FLLayoutManager a10 = b.a(recyclerView);
        if (a10 != null) {
            return a10.getOrientation(recyclerView);
        }
        return 1;
    }

    public static int getSpanCount(@NonNull RecyclerView recyclerView) {
        FLLayoutManager a10 = b.a(recyclerView);
        if (a10 != null) {
            return a10.getSpanCount(recyclerView);
        }
        return 1;
    }
}
