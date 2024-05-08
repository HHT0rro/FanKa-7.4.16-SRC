package com.huawei.flexiblelayout.card;

import android.view.View;
import android.view.ViewGroup;
import com.huawei.flexiblelayout.FLContext;
import com.huawei.flexiblelayout.card.action.BaseAction;
import com.huawei.flexiblelayout.css.CSSLink;
import com.huawei.flexiblelayout.css.CSSRule;
import com.huawei.flexiblelayout.css.CSSView;
import com.huawei.flexiblelayout.data.FLCardData;
import com.huawei.flexiblelayout.data.FLDataGroup;
import com.huawei.flexiblelayout.parser.csslink.CSSLinkManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class FLCard<T extends FLCardData> extends FLCell<T> {

    /* renamed from: e, reason: collision with root package name */
    private T f27757e;

    /* renamed from: f, reason: collision with root package name */
    private String f27758f;

    private void a(View view, FLCardData fLCardData) {
        CSSRule cssRule = fLCardData.getCssRule();
        CSSLink parent = cssRule != null ? cssRule.getParent() : null;
        if (parent == null) {
            parent = CSSLinkManager.getInstance().findCssLink(fLCardData);
        }
        if (cssRule == null && parent == null) {
            return;
        }
        CSSView.wrap(view, cssRule).cssLink(parent).render();
    }

    public abstract View build(FLContext fLContext, ViewGroup viewGroup);

    @Override // com.huawei.flexiblelayout.card.FLCell
    public String getType() {
        String str = this.f27758f;
        return str != null ? str : "";
    }

    public void setClickAction(FLContext fLContext) {
        BaseAction.bindTo(fLContext, getRootView(), this);
    }

    public abstract void setData(FLContext fLContext, FLDataGroup fLDataGroup, T t2);

    @Override // com.huawei.flexiblelayout.card.FLCell
    public void setVisibility(int i10) {
        if (getRootView() != null) {
            T t2 = this.f27757e;
            if (t2 == null || !t2.isVisible()) {
                i10 = 8;
            }
            getRootView().setVisibility(i10);
        }
    }

    @Override // com.huawei.flexiblelayout.card.FLCell
    public final void bind(FLContext fLContext, FLDataGroup fLDataGroup, T t2) {
        this.f27757e = t2;
        if (fLContext.getFLayout().getLayoutDelegate() != null) {
            fLContext.getFLayout().getLayoutDelegate().onCardBind(fLContext, this, t2);
        }
        setClickAction(fLContext);
        setData(fLContext, fLDataGroup, t2);
        setReady(true);
    }

    @Override // com.huawei.flexiblelayout.card.FLCell
    public final View build(FLContext fLContext, T t2, ViewGroup viewGroup) {
        this.f27758f = t2.getType();
        View build = build(fLContext, viewGroup);
        setRootView(build);
        a(build, t2);
        return build;
    }

    @Override // com.huawei.flexiblelayout.card.FLCell
    public T getData() {
        return this.f27757e;
    }
}
