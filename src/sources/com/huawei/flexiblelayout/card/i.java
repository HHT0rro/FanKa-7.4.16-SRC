package com.huawei.flexiblelayout.card;

import android.view.View;
import android.view.ViewGroup;
import com.huawei.flexiblelayout.FLContext;
import com.huawei.flexiblelayout.data.FLNodeData;

/* compiled from: NotExistentNode.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class i extends FLNode {

    /* renamed from: g, reason: collision with root package name */
    public static final String f27849g = "flNotExistentNode";

    @Override // com.huawei.flexiblelayout.card.FLNode
    public View build(FLContext fLContext, FLNodeData fLNodeData, ViewGroup viewGroup) {
        return new View(fLContext.getContext());
    }

    @Override // com.huawei.flexiblelayout.card.FLNode, com.huawei.flexiblelayout.card.FLCell
    public String getType() {
        return f27849g;
    }
}
