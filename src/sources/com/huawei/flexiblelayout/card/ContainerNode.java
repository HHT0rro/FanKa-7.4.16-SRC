package com.huawei.flexiblelayout.card;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.FLContext;
import com.huawei.flexiblelayout.adapter.Visitor;
import com.huawei.flexiblelayout.data.FLCardData;
import com.huawei.flexiblelayout.data.FLDataGroup;
import com.huawei.flexiblelayout.data.FLNodeData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class ContainerNode<T extends FLNodeData> extends FLNode<T> {

    /* renamed from: g, reason: collision with root package name */
    private final List<FLCell<FLCardData>> f27756g = new ArrayList();

    public void addChildCard(FLCell<FLCardData> fLCell) {
        fLCell.setParent(this);
        this.f27756g.add(fLCell);
    }

    public View buildCardView(FLContext fLContext, FLCell<FLCardData> fLCell, FLCardData fLCardData, ViewGroup viewGroup) {
        return fLCell.build(fLContext, fLCardData, viewGroup);
    }

    @Override // com.huawei.flexiblelayout.card.FLNode
    public View buildChildView(FLContext fLContext, T t2, ViewGroup viewGroup) {
        FLCell<FLCardData> createCard;
        ViewGroup viewGroup2 = (ViewGroup) getRootView();
        for (int i10 = 0; i10 < t2.getSize(); i10++) {
            FLCardData child = t2.getChild(i10);
            if (child instanceof FLNodeData) {
                createCard = createNode(child.getType());
            } else {
                createCard = createCard(child.getType());
            }
            if (createCard == null) {
                return null;
            }
            addChildCard(createCard);
            View buildCardView = buildCardView(fLContext, createCard, child, viewGroup);
            if (buildCardView != null) {
                viewGroup2.addView(buildCardView);
            }
        }
        return null;
    }

    @Override // com.huawei.flexiblelayout.card.FLNode
    public FLCell<FLCardData> getChildAt(int i10) {
        if (i10 < 0 || i10 >= getChildCount()) {
            return null;
        }
        return this.f27756g.get(i10);
    }

    @Override // com.huawei.flexiblelayout.card.FLNode
    public int getChildCount() {
        return this.f27756g.size();
    }

    @Override // com.huawei.flexiblelayout.card.FLNode, com.huawei.flexiblelayout.card.FLCell
    public abstract String getType();

    @Override // com.huawei.flexiblelayout.card.FLNode
    public void setData(FLContext fLContext, FLDataGroup fLDataGroup, T t2) {
        for (int i10 = 0; i10 < t2.getSize(); i10++) {
            this.f27756g.get(i10).bind(fLContext, fLDataGroup, t2.getChild(i10));
        }
    }

    @Override // com.huawei.flexiblelayout.card.FLNode, com.huawei.flexiblelayout.card.FLCell
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        if (i10 == 4) {
            return;
        }
        Iterator<FLCell<FLCardData>> iterator2 = this.f27756g.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().setVisibility(i10);
        }
    }

    @Override // com.huawei.flexiblelayout.card.FLNode, com.huawei.flexiblelayout.card.FLCell
    public void unbind(FLContext fLContext) {
        super.unbind(fLContext);
        for (int i10 = 0; i10 < this.f27756g.size(); i10++) {
            this.f27756g.get(i10).unbind(fLContext);
        }
    }

    @Override // com.huawei.flexiblelayout.card.FLNode, com.huawei.flexiblelayout.card.FLCell
    public boolean visit(@NonNull Visitor visitor) {
        if (!visitor.onVisitNode(this)) {
            return false;
        }
        Iterator<FLCell<FLCardData>> iterator2 = this.f27756g.iterator2();
        while (iterator2.hasNext()) {
            if (!iterator2.next().visit(visitor)) {
                return false;
            }
        }
        return true;
    }
}
