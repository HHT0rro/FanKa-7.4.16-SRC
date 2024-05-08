package com.huawei.flexiblelayout.data;

import androidx.annotation.Nullable;
import com.huawei.flexiblelayout.css.CSSRule;
import com.huawei.flexiblelayout.css.adapter.CSSPropertyName;
import com.huawei.flexiblelayout.css.adapter.type.CSSPrimitive;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FLDNodeData extends FLNodeData {

    /* renamed from: n, reason: collision with root package name */
    private boolean f28033n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f28034o;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    private Integer f28035p;

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    private Integer f28036q;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    private b f28037r;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public FLNodeData f28038s;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class b implements com.huawei.flexiblelayout.data.a {

        /* renamed from: a, reason: collision with root package name */
        private final Set<com.huawei.flexiblelayout.data.a> f28039a;

        private b() {
            this.f28039a = new HashSet();
        }

        @Override // com.huawei.flexiblelayout.data.a
        public void update(FLCardData fLCardData) {
            Iterator<com.huawei.flexiblelayout.data.a> iterator2 = this.f28039a.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().update(fLCardData);
            }
        }
    }

    public FLDNodeData(String str) {
        super(str);
        this.f28033n = false;
        this.f28034o = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(FLCardData fLCardData) {
        getParent().update();
    }

    private void d() {
        CSSPrimitive cSSPrimitive;
        if (this.f28034o) {
            return;
        }
        this.f28034o = true;
        CSSRule cssRule = getCssRule();
        if (cssRule == null) {
            return;
        }
        CSSPrimitive cSSPrimitive2 = (CSSPrimitive) cssRule.getPropertyValue(CSSPropertyName.TOP_DOCKING_DISTANCE);
        if (cSSPrimitive2 != null) {
            this.f28035p = cSSPrimitive2.asInt();
        }
        if (this.f28035p != null || (cSSPrimitive = (CSSPrimitive) cssRule.getPropertyValue(CSSPropertyName.BOTTOM_DOCKING_DISTANCE)) == null) {
            return;
        }
        this.f28036q = cSSPrimitive.asInt();
    }

    @Override // com.huawei.flexiblelayout.data.FLCardData
    public void a(com.huawei.flexiblelayout.data.a aVar) {
        if (aVar == null) {
            this.f28037r = null;
            super.a((com.huawei.flexiblelayout.data.a) null);
            return;
        }
        if (this.f28037r == null) {
            b bVar = new b();
            this.f28037r = bVar;
            super.a(bVar);
            if (getParent() != null) {
                this.f28037r.f28039a.add(new com.huawei.flexiblelayout.data.a() { // from class: com.huawei.flexiblelayout.data.i
                    @Override // com.huawei.flexiblelayout.data.a
                    public final void update(FLCardData fLCardData) {
                        FLDNodeData.this.c(fLCardData);
                    }
                });
            }
        }
        this.f28037r.f28039a.add(aVar);
    }

    @Nullable
    public Integer getBottomDockingDistance() {
        d();
        return this.f28036q;
    }

    @Nullable
    public FLCardData getDockingCardData() {
        FLNodeData dockingNodeData = getDockingNodeData();
        if (dockingNodeData == null || dockingNodeData.getSize() == 0) {
            return null;
        }
        return dockingNodeData.getChild(0);
    }

    @Nullable
    public FLNodeData getDockingNodeData() {
        FLNodeData fLNodeData = this.f28038s;
        if (fLNodeData != null) {
            return fLNodeData;
        }
        int size = getSize();
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            this.f28038s = this;
            return this;
        }
        FLNodeData build = FLayoutSpec.node().build();
        this.f28038s = build;
        build.addChild(getChild(1));
        return this.f28038s;
    }

    @Nullable
    public Integer getTopDockingDistance() {
        d();
        return this.f28035p;
    }

    public boolean isDocking() {
        return this.f28033n;
    }

    public void setDocking(boolean z10) {
        this.f28033n = z10;
    }
}
