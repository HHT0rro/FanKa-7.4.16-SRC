package com.huawei.flexiblelayout.parser.directive;

import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.o0;
import com.huawei.flexiblelayout.parser.expr.Evaluable;
import com.huawei.flexiblelayout.parser.expr.ExprException;
import com.huawei.flexiblelayout.parser.expr.Processor;
import com.huawei.flexiblelayout.parser.expr.ProcessorResult;
import com.huawei.flexiblelayout.parser.expr.expression.Expr;
import com.huawei.flexiblelayout.parser.expr.expression.MethodCaller;
import com.huawei.flexiblelayout.t0;
import com.huawei.flexiblelayout.x0;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class VarFormula implements Processor, Evaluable {

    /* renamed from: b, reason: collision with root package name */
    private static final String f28400b = "VarFormula";

    /* renamed from: a, reason: collision with root package name */
    private x0 f28401a;

    public VarFormula() {
    }

    @Override // com.huawei.flexiblelayout.parser.expr.Evaluable
    public Object evaluate(o0 o0Var) {
        final AtomicReference atomicReference = new AtomicReference();
        process(o0Var, new ProcessorResult() { // from class: com.huawei.flexiblelayout.parser.directive.VarFormula.1
            @Override // com.huawei.flexiblelayout.parser.expr.ProcessorResult
            public void processed(Object obj) {
                atomicReference.set(obj);
            }
        });
        return atomicReference.get();
    }

    public int getPhase(Object obj) {
        Expr a10 = this.f28401a.a();
        if (!(a10 instanceof MethodCaller)) {
            return 0;
        }
        try {
            return ((MethodCaller) a10).getPhase(obj);
        } catch (ExprException e2) {
            Log.e(f28400b, "Unreachable.", e2);
            return 0;
        }
    }

    @Override // com.huawei.flexiblelayout.parser.expr.Processor
    public void process(o0 o0Var, ProcessorResult processorResult) {
        x0 x0Var = this.f28401a;
        if (x0Var != null) {
            x0Var.process(o0Var, processorResult);
        }
    }

    public VarFormula(String str) {
        this.f28401a = (x0) t0.a(x0.f28668b, str);
    }
}
