package com.huawei.flexiblelayout.parser.directive;

import com.huawei.flexiblelayout.data.FLCardData;
import com.huawei.flexiblelayout.data.FLNodeData;
import com.huawei.flexiblelayout.data.FLayoutSpec;
import com.huawei.flexiblelayout.data.b;
import com.huawei.flexiblelayout.data.d;
import com.huawei.flexiblelayout.data.e;
import com.huawei.flexiblelayout.data.g;
import com.huawei.flexiblelayout.json.Jsons;
import com.huawei.flexiblelayout.t0;
import com.huawei.flexiblelayout.u0;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ForDirective implements g {

    /* renamed from: a, reason: collision with root package name */
    private final u0 f28359a;

    /* renamed from: b, reason: collision with root package name */
    private d f28360b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class ForDirectiveResult extends e {

        /* renamed from: a, reason: collision with root package name */
        private final FLayoutSpec.FNodeSpec f28361a;

        /* renamed from: b, reason: collision with root package name */
        private final FLNodeData f28362b;

        /* renamed from: c, reason: collision with root package name */
        private final b f28363c;

        public ForDirectiveResult(FLayoutSpec.FNodeSpec fNodeSpec, FLNodeData fLNodeData, b bVar) {
            this.f28361a = fNodeSpec;
            this.f28362b = fLNodeData;
            this.f28363c = bVar;
        }

        @Override // com.huawei.flexiblelayout.data.e, com.huawei.flexiblelayout.parser.expr.ProcessorResult
        public void processed(Object obj) {
            e.buildChildren(this.f28361a, this.f28362b, new b.C0271b(this.f28363c).a(Jsons.toJson(obj)).a());
        }
    }

    public ForDirective(String str) {
        this.f28359a = (u0) t0.a("for", str);
    }

    @Override // com.huawei.flexiblelayout.data.d
    public FLCardData execute(FLayoutSpec.Spec spec, b bVar) {
        d dVar = this.f28360b;
        if (dVar == null || !(spec instanceof FLayoutSpec.FNodeSpec)) {
            return null;
        }
        FLCardData execute = dVar.execute(spec, bVar);
        if (!(execute instanceof FLNodeData)) {
            return null;
        }
        this.f28359a.process(bVar, new ForDirectiveResult((FLayoutSpec.FNodeSpec) spec, (FLNodeData) execute, bVar));
        return execute;
    }

    @Override // com.huawei.flexiblelayout.data.d
    public void setTarget(d dVar) {
        this.f28360b = dVar;
    }
}
