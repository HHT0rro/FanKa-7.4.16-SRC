package com.huawei.flexiblelayout.parser.directive;

import com.huawei.flexiblelayout.data.FLCardData;
import com.huawei.flexiblelayout.data.FLayoutSpec;
import com.huawei.flexiblelayout.data.b;
import com.huawei.flexiblelayout.data.d;
import com.huawei.flexiblelayout.data.e;
import com.huawei.flexiblelayout.data.f;
import com.huawei.flexiblelayout.data.g;
import com.huawei.flexiblelayout.json.Jsons;
import com.huawei.flexiblelayout.t0;
import com.huawei.flexiblelayout.u0;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class SelfForDirective implements g, f {

    /* renamed from: a, reason: collision with root package name */
    private final u0 f28383a;

    /* renamed from: b, reason: collision with root package name */
    private d f28384b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class SelfForDirectiveResult extends e {

        /* renamed from: a, reason: collision with root package name */
        private final FLayoutSpec.Spec f28385a;

        /* renamed from: b, reason: collision with root package name */
        private final d f28386b;

        /* renamed from: c, reason: collision with root package name */
        private final b f28387c;

        public SelfForDirectiveResult(FLayoutSpec.Spec spec, d dVar, b bVar) {
            this.f28385a = spec;
            this.f28386b = dVar;
            this.f28387c = bVar;
        }

        @Override // com.huawei.flexiblelayout.data.e, com.huawei.flexiblelayout.parser.expr.ProcessorResult
        public void processed(Object obj) {
            this.f28386b.execute(this.f28385a, new b.C0271b(this.f28387c).a(Jsons.toJson(obj)).a());
        }
    }

    public SelfForDirective(String str) {
        this.f28383a = (u0) t0.a("for", str);
    }

    @Override // com.huawei.flexiblelayout.data.d
    public FLCardData execute(FLayoutSpec.Spec spec, b bVar) {
        d dVar = this.f28384b;
        if (dVar == null) {
            return null;
        }
        this.f28383a.process(bVar, new SelfForDirectiveResult(spec, dVar, bVar));
        return null;
    }

    @Override // com.huawei.flexiblelayout.data.d
    public void setTarget(d dVar) {
        this.f28384b = dVar;
    }
}
