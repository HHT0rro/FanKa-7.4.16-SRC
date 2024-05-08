package com.huawei.flexiblelayout.layoutstrategy.container;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.FLContext;
import com.huawei.flexiblelayout.adapter.ViewContainer;
import com.huawei.flexiblelayout.adapter.Visit;
import com.huawei.flexiblelayout.adapter.Visitor;
import com.huawei.flexiblelayout.card.FLNode;
import com.huawei.flexiblelayout.common.c;
import com.huawei.flexiblelayout.creator.FLResolverRegistry;
import com.huawei.flexiblelayout.creator.NodeResolver;
import com.huawei.flexiblelayout.css.CSSRule;
import com.huawei.flexiblelayout.css.adapter.CSSPropertyName;
import com.huawei.flexiblelayout.css.adapter.value.integrate.space.CSSSpaceValue;
import com.huawei.flexiblelayout.data.FLCardData;
import com.huawei.flexiblelayout.data.FLDataGroup;
import com.huawei.flexiblelayout.data.FLNodeData;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ReactContainer implements ViewContainer, Visit {

    /* renamed from: a, reason: collision with root package name */
    private final int f28205a;

    /* renamed from: b, reason: collision with root package name */
    private final int f28206b;
    public List<FLNode> mNodeLists = new ArrayList();
    public int mBindCount = 0;

    public ReactContainer(int i10, int i11) {
        this.f28205a = i10;
        this.f28206b = i11;
    }

    public void a(ViewGroup viewGroup, View view, LinearLayout.LayoutParams layoutParams, int i10) {
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            layoutParams = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams2);
            layoutParams.weight = 1.0f;
        }
        viewGroup.addView(view, i10, layoutParams);
    }

    @Override // com.huawei.flexiblelayout.adapter.ViewContainer
    public View createView(FLContext fLContext, FLDataGroup.Cursor cursor, ViewGroup viewGroup) {
        FLNode create;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.weight = 1.0f;
        FLNodeData current = cursor.current();
        NodeResolver nodeResolver = FLResolverRegistry.getNodeResolver(current.getType());
        ViewGroup viewGroup2 = null;
        int i10 = 0;
        while (i10 < this.f28205a && (create = nodeResolver.create()) != null) {
            this.mNodeLists.add(create);
            if (this.f28205a == 1) {
                return a(fLContext, create, current, viewGroup, true);
            }
            if (viewGroup2 == null) {
                viewGroup2 = a(fLContext.getContext());
            }
            ViewGroup viewGroup3 = viewGroup2;
            View a10 = a(fLContext, create, current, viewGroup3, false);
            if (a10 != null) {
                if (i10 != 0) {
                    a(viewGroup3, current);
                }
                a(viewGroup3, a10, layoutParams, -1);
            }
            i10++;
            viewGroup2 = viewGroup3;
        }
        return viewGroup2;
    }

    public int getCount() {
        return this.f28205a;
    }

    public int getSpacing() {
        return this.f28206b;
    }

    @Override // com.huawei.flexiblelayout.adapter.ViewContainer
    public void setData(FLContext fLContext, FLDataGroup.Cursor cursor) {
        int size = this.mNodeLists.size();
        this.mBindCount = 0;
        FLNodeData fLNodeData = null;
        int i10 = 0;
        while (i10 < size) {
            FLNode fLNode = this.mNodeLists.get(i10);
            if (cursor.hasNext()) {
                FLNodeData next = cursor.next();
                if (!a(fLNodeData, next)) {
                    while (i10 < size) {
                        this.mNodeLists.get(i10).setVisibility(4);
                        i10++;
                    }
                    return;
                } else {
                    fLNode.bind(fLContext, cursor.getDataGroup(), (FLDataGroup) next);
                    this.mBindCount++;
                    fLNode.setVisibility(0);
                    fLNodeData = next;
                }
            } else {
                fLNode.setVisibility(4);
            }
            i10++;
        }
    }

    @Override // com.huawei.flexiblelayout.adapter.ViewContainer
    public void unsetData(FLContext fLContext) {
        for (int i10 = 0; i10 < this.mBindCount; i10++) {
            this.mNodeLists.get(i10).unbind(fLContext);
        }
        this.mBindCount = 0;
    }

    @Override // com.huawei.flexiblelayout.adapter.Visit
    public void visit(@NonNull Visitor visitor) {
        for (FLNode fLNode : this.mNodeLists) {
            if (fLNode.getRootView() != null && fLNode.getRootView().getVisibility() == 0) {
                fLNode.visit(visitor);
            }
        }
    }

    public void a(ViewGroup viewGroup, FLNodeData fLNodeData) {
        CSSSpaceValue cSSSpaceValue;
        View space = new Space(viewGroup.getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getSpacing(), -2);
        CSSRule cssRule = fLNodeData.getCssRule();
        if (cssRule != null && (cSSSpaceValue = (CSSSpaceValue) cssRule.getPropertyValue(CSSPropertyName.FL_MARGIN)) != null) {
            int leftSpace = cSSSpaceValue.getLeftSpace();
            int rightSpace = cSSSpaceValue.getRightSpace();
            int a10 = c.a(viewGroup.getContext(), -leftSpace);
            int a11 = c.a(viewGroup.getContext(), -rightSpace);
            layoutParams.setMarginStart(a10);
            layoutParams.setMarginEnd(a11);
        }
        space.setLayoutParams(layoutParams);
        viewGroup.addView(space);
    }

    public View a(FLContext fLContext, FLNode fLNode, FLNodeData fLNodeData, ViewGroup viewGroup, boolean z10) {
        View build = fLNode.build(fLContext, (FLContext) fLNodeData, viewGroup);
        return (z10 && build == null) ? new View(viewGroup.getContext()) : build;
    }

    public boolean a(FLCardData fLCardData, FLCardData fLCardData2) {
        if (fLCardData == null || fLCardData2 == null) {
            return true;
        }
        return fLCardData.getReuseIdentifier().equals(fLCardData2.getReuseIdentifier());
    }

    public ViewGroup a(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return linearLayout;
    }
}
