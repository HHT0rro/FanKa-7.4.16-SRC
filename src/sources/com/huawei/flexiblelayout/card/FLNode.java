package com.huawei.flexiblelayout.card;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.FLContext;
import com.huawei.flexiblelayout.FLayout;
import com.huawei.flexiblelayout.adapter.Visitor;
import com.huawei.flexiblelayout.creator.CardResolver;
import com.huawei.flexiblelayout.creator.FLResolverRegistry;
import com.huawei.flexiblelayout.creator.NodeResolver;
import com.huawei.flexiblelayout.css.CSSRule;
import com.huawei.flexiblelayout.css.CSSView;
import com.huawei.flexiblelayout.data.FLCardData;
import com.huawei.flexiblelayout.data.FLDataGroup;
import com.huawei.flexiblelayout.data.FLNodeData;
import com.huawei.flexiblelayout.view.LayoutView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FLNode<T extends FLNodeData> extends FLCell<T> implements FLParent {
    public static final String TYPE = "flnode";

    /* renamed from: e, reason: collision with root package name */
    private FLCell<FLCardData> f27763e;

    /* renamed from: f, reason: collision with root package name */
    private T f27764f;

    private void a(FLCardData fLCardData) {
        CSSRule cssRule = fLCardData.getCssRule();
        if (cssRule == null) {
            return;
        }
        CSSView.wrap(getRootView(), cssRule).renderSelf();
    }

    public View buildChildView(FLContext fLContext, T t2, ViewGroup viewGroup) {
        if (t2.getSize() <= 0) {
            return null;
        }
        FLCardData child = t2.getChild(0);
        if (child instanceof FLNodeData) {
            this.f27763e = createNode(child.getType());
        } else {
            this.f27763e = createCard(child.getType());
        }
        FLCell<FLCardData> fLCell = this.f27763e;
        if (fLCell == null) {
            return null;
        }
        View build = fLCell.build(fLContext, child, viewGroup);
        this.f27763e.setParent(this);
        return build;
    }

    public ViewGroup buildView(FLContext fLContext, T t2) {
        if (t2.getCssRule() == null) {
            return null;
        }
        FrameLayout frameLayout = new FrameLayout(fLContext.getContext());
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(getDefaultWidth(fLContext.getFLayout()), getDefaultHeight(fLContext.getFLayout())));
        return frameLayout;
    }

    public FLCell<FLCardData> createCard(String str) {
        CardResolver cardResolver = FLResolverRegistry.getCardResolver(str);
        if (cardResolver != null) {
            return cardResolver.create();
        }
        return null;
    }

    public FLNode createNode(String str) {
        NodeResolver nodeResolver = FLResolverRegistry.getNodeResolver(str);
        if (nodeResolver != null) {
            return nodeResolver.create();
        }
        return null;
    }

    public FLCell<FLCardData> getChildAt(int i10) {
        return this.f27763e;
    }

    public int getChildCount() {
        return this.f27763e != null ? 1 : 0;
    }

    public int getDefaultHeight(FLayout fLayout) {
        fLayout.getScrollDirection();
        LayoutView.ScrollDirection scrollDirection = LayoutView.ScrollDirection.VERTICAL;
        return -2;
    }

    public int getDefaultWidth(FLayout fLayout) {
        return fLayout.getScrollDirection() == LayoutView.ScrollDirection.VERTICAL ? -1 : -2;
    }

    @Override // com.huawei.flexiblelayout.card.FLCell
    public String getType() {
        return TYPE;
    }

    public void setData(FLContext fLContext, FLDataGroup fLDataGroup, T t2) {
        if (this.f27763e == null || t2.getSize() <= 0) {
            return;
        }
        this.f27763e.bind(fLContext, fLDataGroup, t2.getChild(0));
    }

    @Override // com.huawei.flexiblelayout.card.FLCell
    public void setVisibility(int i10) {
        if (this.f27763e != null && i10 == 0) {
            if (!this.f27764f.isVisible()) {
                i10 = 8;
            }
            this.f27763e.setVisibility(i10);
        }
        if (getRootView() != null) {
            getRootView().setVisibility(i10);
        }
    }

    @Override // com.huawei.flexiblelayout.card.FLCell
    public void unbind(FLContext fLContext) {
        super.unbind(fLContext);
        FLCell<FLCardData> fLCell = this.f27763e;
        if (fLCell != null) {
            fLCell.unbind(fLContext);
        }
    }

    @Override // com.huawei.flexiblelayout.card.FLCell
    public boolean visit(@NonNull Visitor visitor) {
        if (!visitor.onVisitNode(this)) {
            return false;
        }
        FLCell<FLCardData> fLCell = this.f27763e;
        if (fLCell != null) {
            return fLCell.visit(visitor);
        }
        return true;
    }

    @Override // com.huawei.flexiblelayout.card.FLCell
    public final void bind(FLContext fLContext, FLDataGroup fLDataGroup, T t2) {
        this.f27764f = t2;
        setData(fLContext, fLDataGroup, t2);
        setReady(true);
    }

    @Override // com.huawei.flexiblelayout.card.FLCell
    public View build(FLContext fLContext, T t2, ViewGroup viewGroup) {
        View view;
        ViewGroup buildView = buildView(fLContext, t2);
        if (buildView == null) {
            View buildChildView = buildChildView(fLContext, t2, viewGroup);
            setRootView(buildChildView);
            view = buildChildView;
        } else {
            setRootView(buildView);
            View buildChildView2 = buildChildView(fLContext, t2, buildView);
            view = buildView;
            if (buildChildView2 != null) {
                buildView.addView(buildChildView2);
                view = buildView;
            }
        }
        a(t2);
        return view;
    }

    @Override // com.huawei.flexiblelayout.card.FLCell
    public T getData() {
        return this.f27764f;
    }
}
