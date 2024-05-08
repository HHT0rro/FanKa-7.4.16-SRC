package com.huawei.flexiblelayout.card;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.huawei.flexiblelayout.FLContext;
import com.huawei.flexiblelayout.data.FLCardData;
import com.huawei.flexiblelayout.data.FLNodeData;

/* compiled from: FLHNode.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class e extends ContainerNode<FLNodeData> {

    /* renamed from: h, reason: collision with root package name */
    public static final String f27831h = "flhnode";

    @Override // com.huawei.flexiblelayout.card.ContainerNode
    public View buildCardView(FLContext fLContext, FLCell<FLCardData> fLCell, FLCardData fLCardData, ViewGroup viewGroup) {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        View buildCardView = super.buildCardView(fLContext, fLCell, fLCardData, viewGroup);
        if (buildCardView != null) {
            ViewGroup.LayoutParams layoutParams3 = buildCardView.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams2 = new LinearLayout.LayoutParams(-1, -2, 1.0f);
            } else {
                if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                    layoutParams = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams3);
                } else {
                    layoutParams = new LinearLayout.LayoutParams(layoutParams3);
                }
                layoutParams2 = layoutParams;
                layoutParams2.weight = 1.0f;
            }
            buildCardView.setLayoutParams(layoutParams2);
        }
        return buildCardView;
    }

    @Override // com.huawei.flexiblelayout.card.FLNode
    public ViewGroup buildView(FLContext fLContext, FLNodeData fLNodeData) {
        LinearLayout linearLayout = new LinearLayout(fLContext.getContext());
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(getDefaultWidth(fLContext.getFLayout()), getDefaultHeight(fLContext.getFLayout())));
        linearLayout.setOrientation(0);
        return linearLayout;
    }

    @Override // com.huawei.flexiblelayout.card.ContainerNode, com.huawei.flexiblelayout.card.FLNode, com.huawei.flexiblelayout.card.FLCell
    public String getType() {
        return f27831h;
    }
}
