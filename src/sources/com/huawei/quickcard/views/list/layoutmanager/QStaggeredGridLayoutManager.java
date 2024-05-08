package com.huawei.quickcard.views.list.layoutmanager;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.facebook.yoga.YogaNode;
import com.huawei.quickcard.l1;
import com.huawei.quickcard.utils.YogaUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class QStaggeredGridLayoutManager extends StaggeredGridLayoutManager {

    /* renamed from: e, reason: collision with root package name */
    private static final int f34622e = 1;

    /* renamed from: f, reason: collision with root package name */
    private static final int f34623f = 1;

    /* renamed from: a, reason: collision with root package name */
    private final YogaNode f34624a;

    /* renamed from: b, reason: collision with root package name */
    private RecyclerView f34625b;

    /* renamed from: c, reason: collision with root package name */
    private int f34626c;

    /* renamed from: d, reason: collision with root package name */
    private int f34627d;

    public QStaggeredGridLayoutManager(RecyclerView recyclerView) {
        super(1, 1);
        this.f34626c = -1;
        this.f34627d = 0;
        this.f34624a = YogaUtils.getYogaNode(recyclerView);
        this.f34625b = recyclerView;
    }

    public void a(@IntRange(from = 0) int i10, int i11) {
        this.f34626c = i10;
        this.f34627d = i11;
    }

    @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f34626c >= 0 && state.getItemCount() > 0 && this.f34625b.getScrollState() == 0) {
            scrollToPositionWithOffset(Math.min(this.f34626c, state.getItemCount()), this.f34627d);
        }
        super.onLayoutChildren(recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onMeasure(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, int i10, int i11) {
        super.onMeasure(recycler, state, i10, i11);
        YogaNode yogaNode = this.f34624a;
        if (yogaNode != null) {
            yogaNode.c();
        }
    }

    @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i10) {
        l1 l1Var = new l1(recyclerView.getContext());
        l1Var.setTargetPosition(i10);
        startSmoothScroll(l1Var);
    }
}
