package com.huawei.flexiblelayout.card;

import android.view.View;
import android.view.ViewGroup;
import com.huawei.flexiblelayout.FLContext;
import com.huawei.flexiblelayout.data.FLDataGroup;
import com.huawei.flexiblelayout.data.FLDynamicChildrenData;

/* compiled from: FLDynamicChildren.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class d extends FLCell<FLDynamicChildrenData> {

    /* renamed from: e, reason: collision with root package name */
    public static final String f27830e = "dynamicchildren";

    @Override // com.huawei.flexiblelayout.card.FLCell
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public View build(FLContext fLContext, FLDynamicChildrenData fLDynamicChildrenData, ViewGroup viewGroup) {
        throw new IllegalStateException("can not support operation");
    }

    @Override // com.huawei.flexiblelayout.card.FLCell
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bind(FLContext fLContext, FLDataGroup fLDataGroup, FLDynamicChildrenData fLDynamicChildrenData) {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.huawei.flexiblelayout.card.FLCell
    public FLDynamicChildrenData getData() {
        return null;
    }

    @Override // com.huawei.flexiblelayout.card.FLCell
    public String getType() {
        return f27830e;
    }

    @Override // com.huawei.flexiblelayout.card.FLCell
    public void setVisibility(int i10) {
    }
}
