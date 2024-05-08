package com.huawei.flexiblelayout.creator;

import com.huawei.flexiblelayout.card.FLNode;
import com.huawei.flexiblelayout.common.b;
import com.huawei.flexiblelayout.data.FLNodeData;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FLDefaultNodeResolver implements NodeResolver {

    /* renamed from: a, reason: collision with root package name */
    private final Class<? extends FLNode> f27935a;

    /* renamed from: b, reason: collision with root package name */
    private Class f27936b;

    public FLDefaultNodeResolver(Class<? extends FLNode> cls) {
        this.f27935a = cls;
    }

    @Override // com.huawei.flexiblelayout.creator.NodeResolver
    public <T extends FLNode> T create() {
        return (T) ObjectCreator.create(this.f27935a);
    }

    @Override // com.huawei.flexiblelayout.creator.NodeResolver
    public <T extends FLNodeData> T createData(String str) {
        if (this.f27936b == null) {
            this.f27936b = b.a((Class) this.f27935a);
        }
        if (this.f27936b == null) {
            this.f27936b = FLNodeData.class;
        }
        return (T) ObjectCreator.create(this.f27936b, str);
    }
}
