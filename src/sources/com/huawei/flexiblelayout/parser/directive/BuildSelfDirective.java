package com.huawei.flexiblelayout.parser.directive;

import com.huawei.flexiblelayout.data.FLCardData;
import com.huawei.flexiblelayout.data.FLayoutSpec;
import com.huawei.flexiblelayout.data.b;
import com.huawei.flexiblelayout.data.d;
import com.huawei.flexiblelayout.data.e;
import com.huawei.flexiblelayout.data.f;
import com.huawei.flexiblelayout.data.g;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class BuildSelfDirective extends e implements g, f {
    @Override // com.huawei.flexiblelayout.data.d
    public FLCardData execute(FLayoutSpec.Spec spec, b bVar) {
        return e.buildSelf(spec, bVar);
    }

    @Override // com.huawei.flexiblelayout.data.e, com.huawei.flexiblelayout.parser.expr.ProcessorResult
    public void processed(Object obj) {
    }

    @Override // com.huawei.flexiblelayout.data.d
    public void setTarget(d dVar) {
    }
}
