package com.huawei.flexiblelayout.card;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.huawei.flexiblelayout.FLContext;
import com.huawei.flexiblelayout.data.FLNodeData;

/* compiled from: FLVNode.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class g extends ContainerNode {

    /* renamed from: h, reason: collision with root package name */
    public static final String f27847h = "flvnode";

    @Override // com.huawei.flexiblelayout.card.FLNode
    public ViewGroup buildView(FLContext fLContext, FLNodeData fLNodeData) {
        LinearLayout linearLayout = new LinearLayout(fLContext.getContext());
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(getDefaultWidth(fLContext.getFLayout()), getDefaultHeight(fLContext.getFLayout())));
        linearLayout.setOrientation(1);
        return linearLayout;
    }

    @Override // com.huawei.flexiblelayout.card.ContainerNode, com.huawei.flexiblelayout.card.FLNode, com.huawei.flexiblelayout.card.FLCell
    public String getType() {
        return f27847h;
    }
}
