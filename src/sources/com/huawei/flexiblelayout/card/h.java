package com.huawei.flexiblelayout.card;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.huawei.flexiblelayout.FLContext;
import com.huawei.flexiblelayout.FLayout;
import com.huawei.flexiblelayout.card.layout.BoxLayout;
import com.huawei.flexiblelayout.data.FLCardData;
import com.huawei.flexiblelayout.data.FLNodeData;

/* compiled from: FLZNode.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class h extends ContainerNode<FLNodeData> {

    /* renamed from: h, reason: collision with root package name */
    public static final String f27848h = "flznode";

    @Override // com.huawei.flexiblelayout.card.ContainerNode
    public View buildCardView(FLContext fLContext, FLCell<FLCardData> fLCell, FLCardData fLCardData, ViewGroup viewGroup) {
        View buildCardView = super.buildCardView(fLContext, fLCell, fLCardData, viewGroup);
        if (buildCardView != null) {
            buildCardView.setLayoutParams(BoxLayout.LayoutParams.wrapLayoutParams(buildCardView.getLayoutParams()));
        }
        return buildCardView;
    }

    @Override // com.huawei.flexiblelayout.card.FLNode
    public ViewGroup buildView(FLContext fLContext, FLNodeData fLNodeData) {
        FrameLayout frameLayout = new FrameLayout(fLContext.getContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(getDefaultWidth(fLContext.getFLayout()), getDefaultHeight(fLContext.getFLayout())));
        return frameLayout;
    }

    @Override // com.huawei.flexiblelayout.card.FLNode
    public int getDefaultWidth(FLayout fLayout) {
        return -2;
    }

    @Override // com.huawei.flexiblelayout.card.ContainerNode, com.huawei.flexiblelayout.card.FLNode, com.huawei.flexiblelayout.card.FLCell
    public String getType() {
        return f27848h;
    }
}
