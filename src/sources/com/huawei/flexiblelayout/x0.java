package com.huawei.flexiblelayout;

import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.parser.expr.Evaluable;
import com.huawei.flexiblelayout.parser.expr.ExprException;
import com.huawei.flexiblelayout.parser.expr.ProcessorResult;
import com.huawei.flexiblelayout.parser.expr.expression.Expr;
import com.huawei.flexiblelayout.parser.expr.expression.Var;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: VarStatement.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class x0 implements w0, Evaluable {

    /* renamed from: b, reason: collision with root package name */
    public static final String f28668b = "var";

    /* renamed from: c, reason: collision with root package name */
    private static final String f28669c = "VarStatement";

    /* renamed from: a, reason: collision with root package name */
    private final Var f28670a;

    /* compiled from: VarStatement.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements ProcessorResult {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f28671a;

        public a(AtomicReference atomicReference) {
            this.f28671a = atomicReference;
        }

        @Override // com.huawei.flexiblelayout.parser.expr.ProcessorResult
        public void processed(Object obj) {
            this.f28671a.set(obj);
        }
    }

    public x0(Var var) {
        this.f28670a = var;
    }

    public Expr a() {
        return this.f28670a;
    }

    @Override // com.huawei.flexiblelayout.parser.expr.Evaluable
    public Object evaluate(o0 o0Var) {
        AtomicReference atomicReference = new AtomicReference();
        process(o0Var, new a(atomicReference));
        return atomicReference.get();
    }

    @Override // com.huawei.flexiblelayout.parser.expr.Processor
    public void process(o0 o0Var, ProcessorResult processorResult) {
        Var var = this.f28670a;
        if (var == null) {
            return;
        }
        try {
            Object model = var.getModel(o0Var);
            if (processorResult != null) {
                processorResult.processed(model);
            }
        } catch (ExprException e2) {
            try {
                Log.e(f28669c, "Failed to get value of variable '" + this.f28670a.getName(o0Var) + "'.", e2);
            } catch (ExprException e10) {
                Log.e(f28669c, "Failed to get value of variable, and it's name.", e10);
            }
        }
    }
}
