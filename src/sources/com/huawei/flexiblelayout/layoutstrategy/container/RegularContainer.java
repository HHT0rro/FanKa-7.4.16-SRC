package com.huawei.flexiblelayout.layoutstrategy.container;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.FLContext;
import com.huawei.flexiblelayout.adapter.ViewContainer;
import com.huawei.flexiblelayout.adapter.Visit;
import com.huawei.flexiblelayout.adapter.Visitor;
import com.huawei.flexiblelayout.card.FLNode;
import com.huawei.flexiblelayout.creator.FLResolverRegistry;
import com.huawei.flexiblelayout.data.FLDataGroup;
import com.huawei.flexiblelayout.data.FLNodeData;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class RegularContainer implements ViewContainer, Visit {

    /* renamed from: a, reason: collision with root package name */
    private FLNode f28208a;

    /* renamed from: b, reason: collision with root package name */
    private int f28209b = 0;

    @Override // com.huawei.flexiblelayout.adapter.ViewContainer
    public View createView(FLContext fLContext, FLDataGroup.Cursor cursor, ViewGroup viewGroup) {
        FLNodeData current = cursor.current();
        FLNode create = FLResolverRegistry.getNodeResolver(current.getType()).create();
        this.f28208a = create;
        if (create == null) {
            return new View(fLContext.getContext());
        }
        View build = create.build(fLContext, (FLContext) current, viewGroup);
        if (build != null) {
            return build;
        }
        View view = new View(viewGroup.getContext());
        this.f28208a = null;
        return view;
    }

    @Override // com.huawei.flexiblelayout.adapter.ViewContainer
    public void setData(FLContext fLContext, FLDataGroup.Cursor cursor) {
        FLNodeData next;
        this.f28209b = 0;
        if (this.f28208a == null || (next = cursor.next()) == null) {
            return;
        }
        this.f28208a.bind(fLContext, cursor.getDataGroup(), (FLDataGroup) next);
        this.f28209b++;
        this.f28208a.setVisibility(0);
    }

    @Override // com.huawei.flexiblelayout.adapter.ViewContainer
    public void unsetData(FLContext fLContext) {
        FLNode fLNode = this.f28208a;
        if (fLNode == null || this.f28209b <= 0) {
            return;
        }
        fLNode.unbind(fLContext);
        this.f28209b = 0;
    }

    @Override // com.huawei.flexiblelayout.adapter.Visit
    public void visit(@NonNull Visitor visitor) {
        FLNode fLNode = this.f28208a;
        if (fLNode != null) {
            fLNode.visit(visitor);
        }
    }
}
