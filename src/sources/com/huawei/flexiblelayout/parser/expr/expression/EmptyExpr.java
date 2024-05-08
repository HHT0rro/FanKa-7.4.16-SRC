package com.huawei.flexiblelayout.parser.expr.expression;

import com.huawei.flexiblelayout.o0;
import com.huawei.flexiblelayout.parser.expr.ExprException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class EmptyExpr implements Expr {
    @Override // com.huawei.flexiblelayout.parser.expr.expression.Expr
    public Object getModel(o0 o0Var) throws ExprException {
        throw new RuntimeException("Unreachable.");
    }

    @Override // com.huawei.flexiblelayout.parser.expr.expression.Expr
    public boolean isOk() {
        throw new RuntimeException("Unreachable.");
    }
}
