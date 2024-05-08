package com.huawei.flexiblelayout.view;

import android.view.View;
import android.view.ViewGroup;
import com.huawei.flexiblelayout.FLContext;
import com.huawei.flexiblelayout.FLayout;
import com.huawei.flexiblelayout.adapter.CardAdapter;
import com.huawei.flexiblelayout.adapter.ViewHolder;
import com.huawei.flexiblelayout.data.changed.FLDataChangedRequest;
import com.huawei.flexiblelayout.data.changed.FLRefreshDataRequest;
import com.huawei.flexiblelayout.view.LayoutView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ViewGroupLayout implements LayoutView {

    /* renamed from: a, reason: collision with root package name */
    private final ViewGroup f28657a;

    /* renamed from: b, reason: collision with root package name */
    private FLContext f28658b;

    /* renamed from: c, reason: collision with root package name */
    private FLayout f28659c;
    public CardAdapter mCardAdapter;
    public ViewHolder mViewHolder;

    public ViewGroupLayout(ViewGroup viewGroup) {
        this.f28657a = viewGroup;
    }

    private ViewHolder a() {
        CardAdapter cardAdapter = this.mCardAdapter;
        if (cardAdapter == null) {
            return null;
        }
        ViewHolder createViewHolder = this.mCardAdapter.createViewHolder(this.f28657a, cardAdapter.getItemViewType(0));
        this.mCardAdapter.bindViewHolder(createViewHolder, 0);
        this.f28657a.addView(createViewHolder.itemView);
        this.mCardAdapter.onViewAttachedToWindow(createViewHolder);
        return createViewHolder;
    }

    private void b(ViewHolder viewHolder) {
        CardAdapter cardAdapter = this.mCardAdapter;
        if (cardAdapter != null) {
            cardAdapter.onViewDetachedFromWindow(viewHolder);
            this.mCardAdapter.onUnbindViewHolder(viewHolder);
            this.f28657a.removeView(viewHolder.itemView);
        }
    }

    @Override // com.huawei.flexiblelayout.view.LayoutView
    public LayoutView.ScrollDirection getScrollDirection() {
        return LayoutView.ScrollDirection.VERTICAL;
    }

    @Override // com.huawei.flexiblelayout.view.LayoutView
    public View getView() {
        return this.f28657a;
    }

    @Override // com.huawei.flexiblelayout.view.LayoutView
    public void mount(FLayout fLayout) {
        ViewHolder viewHolder = this.mViewHolder;
        if (viewHolder != null) {
            b(viewHolder);
            this.mViewHolder = null;
        }
        if (fLayout == null) {
            this.f28659c = null;
            return;
        }
        this.f28659c = fLayout;
        this.f28658b = new FLContext(fLayout, this.f28657a.getContext());
        if (fLayout.getDataSource() != null) {
            CardAdapter cardAdapter = new CardAdapter(fLayout.getDataSource());
            this.mCardAdapter = cardAdapter;
            if (cardAdapter.getItemCount() > 0) {
                this.mViewHolder = a();
            }
        }
    }

    @Override // com.huawei.flexiblelayout.view.LayoutView
    public void onDataSourceChanged() {
        FLayout fLayout;
        if (this.mCardAdapter == null && (fLayout = this.f28659c) != null && fLayout.getDataSource() != null) {
            this.mCardAdapter = new CardAdapter(this.f28659c.getDataSource());
        }
        requestDataChanged(new FLRefreshDataRequest());
    }

    @Override // com.huawei.flexiblelayout.view.LayoutView
    public void requestDataChanged(FLDataChangedRequest fLDataChangedRequest) {
        if (this.f28658b == null) {
            return;
        }
        CardAdapter cardAdapter = this.mCardAdapter;
        if (cardAdapter != null && cardAdapter.getItemCount() != 0) {
            ViewHolder viewHolder = this.mViewHolder;
            if (viewHolder != null) {
                a(viewHolder);
                return;
            } else {
                this.mViewHolder = a();
                return;
            }
        }
        ViewHolder viewHolder2 = this.mViewHolder;
        if (viewHolder2 != null) {
            b(viewHolder2);
            this.mViewHolder = null;
        }
    }

    private void a(ViewHolder viewHolder) {
        CardAdapter cardAdapter = this.mCardAdapter;
        if (cardAdapter != null) {
            cardAdapter.onViewDetachedFromWindow(viewHolder);
            this.mCardAdapter.onUnbindViewHolder(viewHolder);
            this.mCardAdapter.bindViewHolder(viewHolder, 0);
            this.mCardAdapter.onViewAttachedToWindow(viewHolder);
        }
    }
}
