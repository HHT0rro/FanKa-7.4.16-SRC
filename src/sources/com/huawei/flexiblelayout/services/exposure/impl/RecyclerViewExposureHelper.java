package com.huawei.flexiblelayout.services.exposure.impl;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.flexiblelayout.FLayout;
import com.huawei.flexiblelayout.adapter.LayoutManagerHelper;
import com.huawei.flexiblelayout.adapter.Visit;
import com.huawei.flexiblelayout.adapter.Visitor;
import com.huawei.flexiblelayout.card.FLCell;
import com.huawei.flexiblelayout.card.FLNode;
import com.huawei.flexiblelayout.data.FLCardData;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.services.exposure.ExposureParam;
import com.huawei.flexiblelayout.services.exposure.impl.FLayoutContainer;
import com.huawei.flexiblelayout.services.exposure.impl.RecyclerViewExposureHelper;
import com.huawei.flexiblelayout.services.exposure.reusable.ReusableObjectPool;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class RecyclerViewExposureHelper extends AbsExposureHelper {

    /* renamed from: j, reason: collision with root package name */
    private static final String f28567j = "RecyclerViewExposureHelper";

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final WeakReference<RecyclerView> f28568d;

    /* renamed from: e, reason: collision with root package name */
    private final int f28569e;

    /* renamed from: f, reason: collision with root package name */
    public int f28570f;

    /* renamed from: g, reason: collision with root package name */
    public int[] f28571g;

    /* renamed from: h, reason: collision with root package name */
    public int[] f28572h;

    /* renamed from: i, reason: collision with root package name */
    public int[] f28573i;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class OnScrollListener extends RecyclerView.OnScrollListener {

        /* renamed from: c, reason: collision with root package name */
        private static final long f28576c = 100;

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        private final WeakReference<RecyclerViewExposureHelper> f28577a;

        /* renamed from: b, reason: collision with root package name */
        private long f28578b;

        public /* synthetic */ OnScrollListener(RecyclerViewExposureHelper recyclerViewExposureHelper, AnonymousClass1 anonymousClass1) {
            this(recyclerViewExposureHelper);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i10) {
            super.onScrollStateChanged(recyclerView, i10);
            RecyclerViewExposureHelper recyclerViewExposureHelper = this.f28577a.get();
            if (recyclerViewExposureHelper != null && i10 == 0) {
                recyclerViewExposureHelper.a(recyclerView, recyclerViewExposureHelper.f28569e);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i10, int i11) {
            RecyclerViewExposureHelper recyclerViewExposureHelper;
            super.onScrolled(recyclerView, i10, i11);
            if ((i10 == 0 && i11 == 0) || (recyclerViewExposureHelper = this.f28577a.get()) == null) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f28578b < 100) {
                return;
            }
            this.f28578b = currentTimeMillis;
            recyclerViewExposureHelper.a(recyclerView, recyclerViewExposureHelper.f28569e);
        }

        private OnScrollListener(RecyclerViewExposureHelper recyclerViewExposureHelper) {
            this.f28578b = 0L;
            this.f28577a = new WeakReference<>(recyclerViewExposureHelper);
        }
    }

    public RecyclerViewExposureHelper(@NonNull FLayout fLayout, @NonNull ExposureParam exposureParam, @NonNull RecyclerView recyclerView) {
        super(fLayout, exposureParam);
        this.f28570f = 1;
        this.f28571g = new int[1];
        this.f28572h = new int[1];
        this.f28573i = new int[2];
        recyclerView.addOnScrollListener(new OnScrollListener(this, null));
        this.f28568d = new WeakReference<>(recyclerView);
        this.f28569e = LayoutManagerHelper.getOrientation(recyclerView);
    }

    private void b(@NonNull RecyclerView recyclerView) {
        int spanCount = LayoutManagerHelper.getSpanCount(recyclerView);
        if (this.f28570f != spanCount) {
            this.f28570f = spanCount;
            this.f28571g = new int[spanCount];
            this.f28572h = new int[spanCount];
            this.f28573i = new int[spanCount * 2];
        }
        LayoutManagerHelper.findFirstVisibleItemPositions(recyclerView, this.f28571g);
        LayoutManagerHelper.findLastVisibleItemPositions(recyclerView, this.f28572h);
        System.arraycopy((Object) this.f28571g, 0, (Object) this.f28573i, 0, this.f28570f);
        int[] iArr = this.f28572h;
        int[] iArr2 = this.f28573i;
        int i10 = this.f28570f;
        System.arraycopy((Object) iArr, 0, (Object) iArr2, i10, i10);
        for (int i11 : this.f28573i) {
            if (i11 != -1) {
                Object findViewHolderForLayoutPosition = recyclerView.findViewHolderForLayoutPosition(i11);
                if (findViewHolderForLayoutPosition instanceof Visit) {
                    a((Visit) findViewHolderForLayoutPosition);
                }
            }
        }
    }

    @Override // com.huawei.flexiblelayout.services.exposure.impl.AbsExposureHelper
    public void dispatchLayoutVisibility(boolean z10) {
        RecyclerView recyclerView = this.f28568d.get();
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.getLayoutManager() == null) {
            Log.e(f28567j, "dispatchRecyclerViewVisibility failed, missing layoutManager");
            return;
        }
        int findFirstVisibleItemPosition = LayoutManagerHelper.findFirstVisibleItemPosition(recyclerView);
        int findLastVisibleItemPosition = LayoutManagerHelper.findLastVisibleItemPosition(recyclerView);
        if (findFirstVisibleItemPosition != -1 && findLastVisibleItemPosition != -1 && findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
            while (findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
                Object findViewHolderForLayoutPosition = recyclerView.findViewHolderForLayoutPosition(findFirstVisibleItemPosition);
                if (findViewHolderForLayoutPosition instanceof Visit) {
                    dispatchVisibilityEvent((Visit) findViewHolderForLayoutPosition, z10);
                }
                findFirstVisibleItemPosition++;
            }
            return;
        }
        Log.d(f28567j, "dispatchRecyclerViewVisibility skipped, invalid range: [" + findFirstVisibleItemPosition + ", " + findLastVisibleItemPosition + "]");
    }

    @Override // com.huawei.flexiblelayout.services.exposure.impl.AbsExposureHelper
    public void dispatchScroll(int i10) {
        RecyclerView recyclerView = this.f28568d.get();
        if (recyclerView == null) {
            return;
        }
        a(recyclerView, i10);
    }

    @Override // com.huawei.flexiblelayout.services.exposure.impl.AbsExposureHelper
    public boolean needCalArea(boolean z10, @NonNull FLCardData fLCardData) {
        return !z10 || TextUtils.equals(getExposureMode(fLCardData), "custom");
    }

    /* renamed from: com.huawei.flexiblelayout.services.exposure.impl.RecyclerViewExposureHelper$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class AnonymousClass1 implements Visitor {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f28574a;

        public AnonymousClass1(List list) {
            this.f28574a = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void a(@NonNull FLCell<?> fLCell) {
            if (fLCell instanceof FLayoutContainer) {
                ((FLayoutContainer) fLCell).getBoundFLayout().whenBound(new FLayoutContainer.BoundFLayout.Listener() { // from class: com.huawei.flexiblelayout.services.exposure.impl.h
                    @Override // com.huawei.flexiblelayout.services.exposure.impl.FLayoutContainer.BoundFLayout.Listener
                    public final void onBind(FLayout fLayout) {
                        RecyclerViewExposureHelper.AnonymousClass1.this.a(fLayout);
                    }
                });
            }
        }

        @Override // com.huawei.flexiblelayout.adapter.Visitor
        public boolean onVisitCard(@NonNull FLCell<?> fLCell) {
            if (RecyclerViewExposureHelper.this.needExposure(fLCell)) {
                this.f28574a.add(fLCell);
            }
            a(fLCell);
            return true;
        }

        @Override // com.huawei.flexiblelayout.adapter.Visitor
        public boolean onVisitNode(@NonNull FLNode<?> fLNode) {
            a(fLNode);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(FLayout fLayout) {
            AbsExposureHelper embeddedHelper = RecyclerViewExposureHelper.this.getEmbeddedHelper(fLayout);
            if (embeddedHelper != null) {
                embeddedHelper.dispatchScroll(RecyclerViewExposureHelper.this.f28569e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull RecyclerView recyclerView, int i10) {
        if (this.mLayoutVisible) {
            if (recyclerView.getLayoutManager() == null) {
                Log.e(f28567j, "onScroll failed, missing layoutManager");
            } else if (i10 == this.f28569e) {
                b(recyclerView);
            } else {
                a(recyclerView);
            }
        }
    }

    private void a(@NonNull RecyclerView recyclerView) {
        int findLastVisibleItemPosition = LayoutManagerHelper.findLastVisibleItemPosition(recyclerView);
        for (int findFirstVisibleItemPosition = LayoutManagerHelper.findFirstVisibleItemPosition(recyclerView); findFirstVisibleItemPosition <= findLastVisibleItemPosition; findFirstVisibleItemPosition++) {
            if (findFirstVisibleItemPosition != -1) {
                Object findViewHolderForLayoutPosition = recyclerView.findViewHolderForLayoutPosition(findFirstVisibleItemPosition);
                if (findViewHolderForLayoutPosition instanceof Visit) {
                    a((Visit) findViewHolderForLayoutPosition);
                }
            }
        }
    }

    private void a(Visit visit) {
        ArrayList<FLCell<?>> arrayList = new ArrayList();
        visit.visit(new AnonymousClass1(arrayList));
        boolean z10 = arrayList.size() == 1;
        for (FLCell<?> fLCell : arrayList) {
            FLCardData fLCardData = (FLCardData) fLCell.getData();
            if (fLCardData.isVisible()) {
                boolean needCalArea = needCalArea(z10, fLCardData);
                if (!z10 || needCalArea) {
                    ExposureEvent exposureEvent = (ExposureEvent) ReusableObjectPool.getInstance().acquire(ExposureEvent.class);
                    exposureEvent.assign(this.mLayout, fLCell, 0, getExposureMode(fLCardData));
                    this.mExposureDispatcher.a((FrameEventDispatcher<ExposureEvent>) exposureEvent);
                }
            }
        }
    }
}
