package com.huawei.flexiblelayout;

import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.parser.expr.ExprException;
import com.huawei.flexiblelayout.parser.expr.ProcessorResult;
import com.huawei.flexiblelayout.parser.expr.expression.Expr;
import com.huawei.flexiblelayout.parser.expr.expression.LogicalTester;

/* compiled from: IfStatement.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class v0 implements w0 {

    /* renamed from: b, reason: collision with root package name */
    public static final String f28642b = "if";

    /* renamed from: c, reason: collision with root package name */
    private static final String f28643c = "IfStatement";

    /* renamed from: a, reason: collision with root package name */
    private final Expr f28644a;

    public v0(Expr expr) {
        this.f28644a = expr;
    }

    @Override // com.huawei.flexiblelayout.parser.expr.Processor
    public void process(o0 o0Var, ProcessorResult processorResult) {
        Expr expr = this.f28644a;
        if (expr == null) {
            Log.w(f28643c, "Undefined condition.");
            return;
        }
        try {
            if (!LogicalTester.isTrue(expr.getModel(o0Var)) || processorResult == null) {
                return;
            }
            processorResult.processed(o0Var.a());
        } catch (ExprException e2) {
            Log.w(f28643c, "Failed to get result of condition.", e2);
        }
    }
}
