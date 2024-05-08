package com.huawei.quickcard.views.list.layoutmanager;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.yoga.YogaNode;
import com.huawei.quickcard.l1;
import com.huawei.quickcard.utils.YogaUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class QGridLayoutManager extends GridLayoutManager {

    /* renamed from: e, reason: collision with root package name */
    private static final int f34617e = 1;

    /* renamed from: a, reason: collision with root package name */
    private final YogaNode f34618a;

    /* renamed from: b, reason: collision with root package name */
    private RecyclerView f34619b;

    /* renamed from: c, reason: collision with root package name */
    private int f34620c;

    /* renamed from: d, reason: collision with root package name */
    private int f34621d;

    public QGridLayoutManager(@NonNull RecyclerView recyclerView) {
        super(recyclerView.getContext(), 1);
        this.f34620c = -1;
        this.f34621d = 0;
        this.f34618a = YogaUtils.getYogaNode(recyclerView);
        this.f34619b = recyclerView;
    }

    public void a(@IntRange(from = 0) int i10, int i11) {
        this.f34620c = i10;
        this.f34621d = i11;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f34620c >= 0 && state.getItemCount() > 0 && this.f34619b.getScrollState() == 0) {
            scrollToPositionWithOffset(Math.min(this.f34620c, state.getItemCount()), this.f34621d);
        }
        super.onLayoutChildren(recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onMeasure(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, int i10, int i11) {
        super.onMeasure(recycler, state, i10, i11);
        YogaNode yogaNode = this.f34618a;
        if (yogaNode != null) {
            yogaNode.c();
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i10) {
        l1 l1Var = new l1(recyclerView.getContext());
        l1Var.setTargetPosition(i10);
        startSmoothScroll(l1Var);
    }
}
