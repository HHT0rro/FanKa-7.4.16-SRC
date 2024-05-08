package com.huawei.flexiblelayout.parser.directive;

import com.huawei.flexiblelayout.data.FLCardData;
import com.huawei.flexiblelayout.data.FLNodeData;
import com.huawei.flexiblelayout.data.FLayoutSpec;
import com.huawei.flexiblelayout.data.b;
import com.huawei.flexiblelayout.data.d;
import com.huawei.flexiblelayout.data.e;
import com.huawei.flexiblelayout.data.g;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class BuildChildrenDirective extends e implements g {

    /* renamed from: a, reason: collision with root package name */
    private d f28350a;

    @Override // com.huawei.flexiblelayout.data.d
    public FLCardData execute(FLayoutSpec.Spec spec, b bVar) {
        d dVar = this.f28350a;
        if (dVar == null || !(spec instanceof FLayoutSpec.FNodeSpec)) {
            return null;
        }
        FLCardData execute = dVar.execute(spec, bVar);
        if (!(execute instanceof FLNodeData)) {
            return null;
        }
        e.buildChildren((FLayoutSpec.FNodeSpec) spec, (FLNodeData) execute, bVar);
        return execute;
    }

    @Override // com.huawei.flexiblelayout.data.e, com.huawei.flexiblelayout.parser.expr.ProcessorResult
    public void processed(Object obj) {
    }

    @Override // com.huawei.flexiblelayout.data.d
    public void setTarget(d dVar) {
        this.f28350a = dVar;
    }
}
