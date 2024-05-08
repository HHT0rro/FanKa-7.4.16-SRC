package com.huawei.flexiblelayout.card;

import android.view.View;
import android.view.ViewGroup;
import com.huawei.flexiblelayout.FLContext;
import com.huawei.flexiblelayout.data.FLCardData;
import com.huawei.flexiblelayout.data.FLNodeData;

/* compiled from: FLBox.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class b extends ContainerNode<FLNodeData> {

    /* renamed from: h, reason: collision with root package name */
    public static final String f27815h = "box";

    @Override // com.huawei.flexiblelayout.card.ContainerNode, com.huawei.flexiblelayout.card.FLNode
    public View buildChildView(FLContext fLContext, FLNodeData fLNodeData, ViewGroup viewGroup) {
        FLCell<FLCardData> createCard;
        View view = null;
        for (int i10 = 0; i10 < fLNodeData.getSize(); i10++) {
            FLCardData child = fLNodeData.getChild(i10);
            if (child instanceof FLNodeData) {
                createCard = createNode(child.getType());
            } else {
                createCard = createCard(child.getType());
            }
            if (createCard != null) {
                addChildCard(createCard);
                View buildCardView = buildCardView(fLContext, createCard, child, viewGroup);
                if (buildCardView != null) {
                    view = buildCardView;
                }
            }
        }
        return view;
    }

    @Override // com.huawei.flexiblelayout.card.FLNode
    public ViewGroup buildView(FLContext fLContext, FLNodeData fLNodeData) {
        return null;
    }

    @Override // com.huawei.flexiblelayout.card.ContainerNode, com.huawei.flexiblelayout.card.FLNode, com.huawei.flexiblelayout.card.FLCell
    public String getType() {
        return f27815h;
    }
}
