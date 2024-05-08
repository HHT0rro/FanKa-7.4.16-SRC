package com.huawei.flexiblelayout.view;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.flexiblelayout.FLayout;
import com.huawei.flexiblelayout.adapter.AdapterBuilder;
import com.huawei.flexiblelayout.adapter.CardAdapter;
import com.huawei.flexiblelayout.adapter.FLLinearLayoutManager;
import com.huawei.flexiblelayout.adapter.LayoutManagerHelper;
import com.huawei.flexiblelayout.data.FLDataSource;
import com.huawei.flexiblelayout.data.FLNodeData;
import com.huawei.flexiblelayout.data.changed.FLAddedDataRequest;
import com.huawei.flexiblelayout.data.changed.FLDataChangedRequest;
import com.huawei.flexiblelayout.data.changed.FLModifyDataRequest;
import com.huawei.flexiblelayout.data.changed.FLRefreshDataRequest;
import com.huawei.flexiblelayout.data.changed.FLRemovedDataRequest;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.view.LayoutView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class RecyclerViewLayout implements LayoutView {

    /* renamed from: g, reason: collision with root package name */
    private static final String f28648g = "RecyclerViewLayout";

    /* renamed from: h, reason: collision with root package name */
    private static final Object f28649h = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final RecyclerView f28650a;

    /* renamed from: b, reason: collision with root package name */
    private final AdapterBuilder f28651b;

    /* renamed from: c, reason: collision with root package name */
    private FLayout f28652c;

    /* renamed from: d, reason: collision with root package name */
    private int f28653d = 5;

    /* renamed from: e, reason: collision with root package name */
    private LayoutView.ScrollDirection f28654e;

    /* renamed from: f, reason: collision with root package name */
    private RecyclerView.OnScrollListener f28655f;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a extends RecyclerView.OnScrollListener {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i10, int i11) {
            super.onScrolled(recyclerView, i10, i11);
            RecyclerViewLayout.this.a();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class b implements AdapterBuilder {
        private b() {
        }

        @Override // com.huawei.flexiblelayout.adapter.AdapterBuilder
        public RecyclerView.Adapter newAdapter(@NonNull Context context, @NonNull FLDataSource fLDataSource) {
            return new CardAdapter(fLDataSource);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public RecyclerViewLayout(RecyclerView recyclerView, AdapterBuilder adapterBuilder) {
        if (adapterBuilder != null) {
            this.f28651b = adapterBuilder;
        } else {
            this.f28651b = new b(null);
        }
        this.f28650a = recyclerView;
    }

    private void b() {
        RecyclerView recyclerView = this.f28650a;
        if (recyclerView == null) {
            return;
        }
        recyclerView.setAdapter(null);
        RecyclerView.OnScrollListener onScrollListener = this.f28655f;
        if (onScrollListener != null) {
            this.f28650a.removeOnScrollListener(onScrollListener);
        }
    }

    @Override // com.huawei.flexiblelayout.view.LayoutView
    public LayoutView.ScrollDirection getScrollDirection() {
        LayoutView.ScrollDirection scrollDirection = this.f28654e;
        if (scrollDirection != null) {
            return scrollDirection;
        }
        RecyclerView recyclerView = this.f28650a;
        if (recyclerView != null) {
            LayoutView.ScrollDirection scrollDirection2 = LayoutManagerHelper.getOrientation(recyclerView) == 1 ? LayoutView.ScrollDirection.VERTICAL : LayoutView.ScrollDirection.HORIZONTAL;
            this.f28654e = scrollDirection2;
            return scrollDirection2;
        }
        return LayoutView.ScrollDirection.VERTICAL;
    }

    @Override // com.huawei.flexiblelayout.view.LayoutView
    public View getView() {
        return this.f28650a;
    }

    @Override // com.huawei.flexiblelayout.view.LayoutView
    public void mount(FLayout fLayout) {
        if (fLayout == null) {
            b();
            this.f28652c = null;
            return;
        }
        this.f28652c = fLayout;
        if (this.f28650a == null || fLayout.getDataSource() == null) {
            return;
        }
        if (this.f28650a.getLayoutManager() == null) {
            this.f28650a.setLayoutManager(new FLLinearLayoutManager(this.f28652c.getEngine().getContext()));
        }
        if (this.f28655f == null) {
            this.f28655f = new a();
        }
        this.f28650a.addOnScrollListener(this.f28655f);
        RecyclerView recyclerView = this.f28650a;
        recyclerView.setAdapter(this.f28651b.newAdapter(recyclerView.getContext(), this.f28652c.getDataSource()));
    }

    @Override // com.huawei.flexiblelayout.view.LayoutView
    public void onDataSourceChanged() {
        FLayout fLayout;
        if (this.f28650a == null || (fLayout = this.f28652c) == null) {
            return;
        }
        if (fLayout.getDataSource() == null) {
            this.f28650a.setAdapter(null);
        } else {
            RecyclerView recyclerView = this.f28650a;
            recyclerView.swapAdapter(this.f28651b.newAdapter(recyclerView.getContext(), this.f28652c.getDataSource()), false);
        }
    }

    @Override // com.huawei.flexiblelayout.view.LayoutView
    public void requestDataChanged(FLDataChangedRequest fLDataChangedRequest) {
        FLayout fLayout;
        if (this.f28650a == null || (fLayout = this.f28652c) == null || fLayout.getDataSource() == null || fLDataChangedRequest == null || this.f28650a.getAdapter() == null) {
            return;
        }
        int absolutePosition = this.f28652c.getDataSource().getAbsolutePosition(fLDataChangedRequest.getGroup(), fLDataChangedRequest.getPosition());
        if (absolutePosition == -1) {
            Log.e(f28648g, "Do not found index by request's position, force RefreshDataRequest to updated instead");
            fLDataChangedRequest = new FLRefreshDataRequest();
        }
        RecyclerView.Adapter adapter = this.f28650a.getAdapter();
        if (fLDataChangedRequest instanceof FLRemovedDataRequest) {
            adapter.notifyItemRangeRemoved(absolutePosition, fLDataChangedRequest.getAffectedCount());
            adapter.notifyItemRangeChanged(absolutePosition, this.f28652c.getDataSource().getSize() - absolutePosition);
            return;
        }
        if (fLDataChangedRequest instanceof FLAddedDataRequest) {
            adapter.notifyItemRangeInserted(absolutePosition, fLDataChangedRequest.getAffectedCount());
            int size = this.f28652c.getDataSource().getSize();
            int i10 = absolutePosition != 0 ? absolutePosition - 1 : absolutePosition;
            if (absolutePosition + fLDataChangedRequest.getAffectedCount() < size - 1) {
                adapter.notifyItemRangeChanged(i10, size - i10);
                return;
            } else {
                adapter.notifyItemRangeChanged(i10, 2, f28649h);
                return;
            }
        }
        if (fLDataChangedRequest instanceof FLModifyDataRequest) {
            FLModifyDataRequest fLModifyDataRequest = (FLModifyDataRequest) fLDataChangedRequest;
            adapter.notifyItemRangeChanged(absolutePosition, fLModifyDataRequest.getAffectedCount(), fLModifyDataRequest.getPayload());
        } else if (fLDataChangedRequest instanceof FLRefreshDataRequest) {
            adapter.notifyDataSetChanged();
        }
    }

    public void setPreLoadNumber(int i10) {
        if (i10 >= 0) {
            this.f28653d = i10;
        } else {
            this.f28653d = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        FLayout fLayout;
        int findLastVisibleItemPosition;
        if (this.f28650a == null || (fLayout = this.f28652c) == null || fLayout.getDataSource() == null || (findLastVisibleItemPosition = LayoutManagerHelper.findLastVisibleItemPosition(this.f28650a)) == -1) {
            return;
        }
        int i10 = findLastVisibleItemPosition + this.f28653d;
        int size = this.f28652c.getDataSource().getSize();
        if (i10 >= size) {
            i10 = size - 1;
        }
        FLNodeData data = this.f28652c.getDataSource().getData(i10);
        if (data == null || data.getTaskHandler() == null) {
            return;
        }
        data.getTaskHandler().execute(this.f28652c, i10);
    }
}
