package com.baidu.mobads.sdk.internal.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class RLRecyclerView extends SwipeRefreshLayout {

    /* renamed from: a, reason: collision with root package name */
    private RecyclerView f10334a;

    /* renamed from: b, reason: collision with root package name */
    private int[] f10335b;

    /* renamed from: c, reason: collision with root package name */
    private int[] f10336c;

    /* renamed from: d, reason: collision with root package name */
    private int[] f10337d;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class NormalItemDecoration extends RecyclerView.ItemDecoration {

        /* renamed from: a, reason: collision with root package name */
        private final int f10338a;

        /* renamed from: b, reason: collision with root package name */
        private final int f10339b;

        /* renamed from: c, reason: collision with root package name */
        private final int f10340c;

        /* renamed from: d, reason: collision with root package name */
        private final int f10341d;

        public NormalItemDecoration(int i10, int i11, int i12, int i13) {
            this.f10338a = i10;
            this.f10339b = i11;
            this.f10340c = i12;
            this.f10341d = i13;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            rect.left = this.f10338a;
            rect.top = this.f10339b;
            rect.right = this.f10340c;
            rect.bottom = this.f10341d;
        }
    }

    public RLRecyclerView(Context context) {
        super(context);
        this.f10336c = new int[2];
        this.f10337d = new int[2];
        a(context);
    }

    private void a(Context context) {
        this.f10334a = new RecyclerView(context);
        addView(this.f10334a, new ViewGroup.LayoutParams(-1, -1));
    }

    private int b(int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            return -1;
        }
        int i10 = iArr[0];
        for (int i11 : iArr) {
            if (i11 > i10) {
                i10 = i11;
            }
        }
        return i10;
    }

    public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        RecyclerView recyclerView = this.f10334a;
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(onScrollListener);
        }
    }

    public int[] findVisibleItemPositions() {
        RecyclerView recyclerView = this.f10334a;
        if (recyclerView == null) {
            return null;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            this.f10337d[0] = gridLayoutManager.findFirstVisibleItemPosition();
            this.f10337d[1] = gridLayoutManager.findLastVisibleItemPosition();
            return this.f10337d;
        }
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            this.f10337d[0] = linearLayoutManager.findFirstVisibleItemPosition();
            this.f10337d[1] = linearLayoutManager.findLastVisibleItemPosition();
            return this.f10337d;
        }
        if (!(layoutManager instanceof StaggeredGridLayoutManager)) {
            return null;
        }
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
        if (this.f10335b == null) {
            this.f10335b = new int[staggeredGridLayoutManager.getSpanCount()];
        }
        staggeredGridLayoutManager.findFirstVisibleItemPositions(this.f10335b);
        this.f10337d[0] = a(this.f10335b);
        staggeredGridLayoutManager.findLastVisibleItemPositions(this.f10335b);
        this.f10337d[1] = b(this.f10335b);
        return this.f10337d;
    }

    public int getChildAdapterPosition(View view) {
        RecyclerView recyclerView = this.f10334a;
        if (recyclerView != null) {
            return recyclerView.getChildAdapterPosition(view);
        }
        return -1;
    }

    public int[] getLayoutManagerCounts() {
        RecyclerView.LayoutManager layoutManager;
        RecyclerView recyclerView = this.f10334a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
            return null;
        }
        this.f10336c[0] = layoutManager.getItemCount();
        this.f10336c[1] = layoutManager.getChildCount();
        return this.f10336c;
    }

    public View getRvChildAt(int i10) {
        RecyclerView recyclerView = this.f10334a;
        if (recyclerView != null) {
            return recyclerView.getChildAt(i10);
        }
        return null;
    }

    public int getRvChildCount() {
        RecyclerView recyclerView = this.f10334a;
        if (recyclerView != null) {
            return recyclerView.getChildCount();
        }
        return 0;
    }

    public int indexOfRvChild(View view) {
        RecyclerView recyclerView = this.f10334a;
        if (recyclerView != null) {
            return recyclerView.indexOfChild(view);
        }
        return -1;
    }

    public void scrollToPosition(int i10) {
        RecyclerView recyclerView = this.f10334a;
        if (recyclerView != null) {
            recyclerView.scrollToPosition(i10);
        }
    }

    public void setAdapter(@Nullable RecyclerView.Adapter adapter) {
        RecyclerView recyclerView = this.f10334a;
        if (recyclerView != null) {
            recyclerView.setAdapter(adapter);
        }
    }

    public void setItemDecoration(int i10, int i11, int i12, int i13) {
        RecyclerView recyclerView = this.f10334a;
        if (recyclerView != null) {
            recyclerView.addItemDecoration(new NormalItemDecoration(i10, i11, i12, i13));
        }
    }

    public void setLayoutManager(int i10, int i11, int i12) {
        RecyclerView recyclerView = this.f10334a;
        if (recyclerView != null) {
            if (1 == i10) {
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            } else if (2 == i10) {
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(), i11));
            } else if (3 == i10) {
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(i11, i12));
            }
        }
    }

    public void setRecyclerViewPadding(int i10, int i11, int i12, int i13) {
        RecyclerView recyclerView = this.f10334a;
        if (recyclerView != null) {
            recyclerView.setPadding(i10, i11, i12, i13);
        }
    }

    private int a(int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            return -1;
        }
        int i10 = iArr[0];
        for (int i11 : iArr) {
            if (i11 < i10) {
                i10 = i11;
            }
        }
        return i10;
    }

    public RLRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10336c = new int[2];
        this.f10337d = new int[2];
        a(context);
    }
}
