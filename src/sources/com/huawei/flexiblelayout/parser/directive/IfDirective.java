package com.huawei.flexiblelayout.parser.directive;

import com.huawei.flexiblelayout.data.FLCardData;
import com.huawei.flexiblelayout.data.FLayoutSpec;
import com.huawei.flexiblelayout.data.b;
import com.huawei.flexiblelayout.data.d;
import com.huawei.flexiblelayout.data.e;
import com.huawei.flexiblelayout.data.f;
import com.huawei.flexiblelayout.data.g;
import com.huawei.flexiblelayout.t0;
import com.huawei.flexiblelayout.v0;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class IfDirective implements g, f {

    /* renamed from: a, reason: collision with root package name */
    private final v0 f28371a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class IfDirectiveResult extends e {

        /* renamed from: a, reason: collision with root package name */
        private final FLayoutSpec.Spec f28372a;

        /* renamed from: b, reason: collision with root package name */
        private final b f28373b;

        /* renamed from: c, reason: collision with root package name */
        private FLCardData f28374c;

        public IfDirectiveResult(FLayoutSpec.Spec spec, b bVar) {
            this.f28372a = spec;
            this.f28373b = bVar;
        }

        public FLCardData get() {
            return this.f28374c;
        }

        @Override // com.huawei.flexiblelayout.data.e, com.huawei.flexiblelayout.parser.expr.ProcessorResult
        public void processed(Object obj) {
            this.f28374c = e.buildSelf(this.f28372a, this.f28373b);
        }
    }

    public IfDirective(String str) {
        this.f28371a = (v0) t0.a("if", str);
    }

    @Override // com.huawei.flexiblelayout.data.d
    public FLCardData execute(FLayoutSpec.Spec spec, b bVar) {
        IfDirectiveResult ifDirectiveResult = new IfDirectiveResult(spec, bVar);
        this.f28371a.process(bVar, ifDirectiveResult);
        return ifDirectiveResult.get();
    }

    @Override // com.huawei.flexiblelayout.data.d
    public void setTarget(d dVar) {
    }

    public IfDirective() {
        this.f28371a = null;
    }
}
