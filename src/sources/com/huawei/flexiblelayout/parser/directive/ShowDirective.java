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
public class ShowDirective implements g, f {

    /* renamed from: a, reason: collision with root package name */
    private final v0 f28388a;

    /* renamed from: b, reason: collision with root package name */
    private d f28389b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class ShowDirectiveResult extends e {

        /* renamed from: a, reason: collision with root package name */
        private boolean f28390a = false;

        public void a(FLCardData fLCardData) {
            fLCardData.setVisible(this.f28390a);
        }

        @Override // com.huawei.flexiblelayout.data.e, com.huawei.flexiblelayout.parser.expr.ProcessorResult
        public void processed(Object obj) {
            this.f28390a = true;
        }
    }

    public ShowDirective(String str) {
        this.f28388a = (v0) t0.a("if", str);
    }

    @Override // com.huawei.flexiblelayout.data.d
    public FLCardData execute(FLayoutSpec.Spec spec, b bVar) {
        FLCardData execute;
        d dVar = this.f28389b;
        if (dVar == null || (execute = dVar.execute(spec, bVar)) == null) {
            return null;
        }
        ShowDirectiveResult showDirectiveResult = new ShowDirectiveResult();
        this.f28388a.process(bVar, showDirectiveResult);
        showDirectiveResult.a(execute);
        return execute;
    }

    @Override // com.huawei.flexiblelayout.data.d
    public void setTarget(d dVar) {
        this.f28389b = dVar;
    }
}
