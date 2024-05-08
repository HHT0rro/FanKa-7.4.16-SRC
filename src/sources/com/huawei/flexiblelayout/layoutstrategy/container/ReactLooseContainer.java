package com.huawei.flexiblelayout.layoutstrategy.container;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.huawei.flexiblelayout.FLContext;
import com.huawei.flexiblelayout.card.FLNode;
import com.huawei.flexiblelayout.creator.FLResolverRegistry;
import com.huawei.flexiblelayout.data.FLDataGroup;
import com.huawei.flexiblelayout.data.FLNodeData;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ReactLooseContainer extends ReactContainer {

    /* renamed from: c, reason: collision with root package name */
    private ViewGroup f28207c;

    public ReactLooseContainer(int i10, int i11) {
        super(i10, i11);
    }

    @Override // com.huawei.flexiblelayout.layoutstrategy.container.ReactContainer, com.huawei.flexiblelayout.adapter.ViewContainer
    public View createView(FLContext fLContext, FLDataGroup.Cursor cursor, ViewGroup viewGroup) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.weight = 1.0f;
        FLNodeData current = cursor.current();
        this.f28207c = null;
        for (int i10 = 0; i10 < getCount(); i10++) {
            FLNodeData next = cursor.next();
            if (next != null) {
                current = next;
            }
            FLNode create = FLResolverRegistry.getNodeResolver(current.getType()).create();
            if (create == null) {
                break;
            }
            this.mNodeLists.add(create);
            if (getCount() == 1) {
                return a(fLContext, create, current, viewGroup, true);
            }
            if (this.f28207c == null) {
                this.f28207c = a(fLContext.getContext());
            }
            View a10 = a(fLContext, create, current, this.f28207c, false);
            if (a10 != null) {
                if (i10 != 0) {
                    a(this.f28207c, current);
                }
                a(this.f28207c, a10, layoutParams, -1);
            }
        }
        return this.f28207c;
    }

    @Override // com.huawei.flexiblelayout.layoutstrategy.container.ReactContainer, com.huawei.flexiblelayout.adapter.ViewContainer
    public void setData(FLContext fLContext, FLDataGroup.Cursor cursor) {
        int size = this.mNodeLists.size();
        this.mBindCount = 0;
        for (int i10 = 0; i10 < size; i10++) {
            FLNode fLNode = this.mNodeLists.get(i10);
            if (cursor.hasNext()) {
                FLNodeData next = cursor.next();
                if (!a(fLNode.getData(), next)) {
                    int indexOfChild = this.f28207c.indexOfChild(fLNode.getRootView());
                    FLNode create = FLResolverRegistry.getNodeResolver(next.getType()).create();
                    this.f28207c.removeViewAt(indexOfChild);
                    this.mNodeLists.set(i10, create);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams.weight = 1.0f;
                    ViewGroup viewGroup = this.f28207c;
                    a(viewGroup, a(fLContext, create, next, viewGroup, true), layoutParams, indexOfChild);
                    fLNode = create;
                }
                fLNode.bind(fLContext, cursor.getDataGroup(), (FLDataGroup) next);
                this.mBindCount++;
                fLNode.setVisibility(0);
            } else {
                fLNode.setVisibility(4);
            }
        }
    }
}
