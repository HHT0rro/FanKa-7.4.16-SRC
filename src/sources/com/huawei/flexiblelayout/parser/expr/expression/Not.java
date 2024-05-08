package com.huawei.flexiblelayout.parser.expr.expression;

import com.huawei.flexiblelayout.o0;
import com.huawei.flexiblelayout.parser.expr.ExprException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class Not extends Var implements LeftOperator {

    /* renamed from: a, reason: collision with root package name */
    private Expr f28425a;

    @Override // com.huawei.flexiblelayout.parser.expr.expression.Expr
    public Object getModel(o0 o0Var) throws ExprException {
        return Boolean.valueOf(!LogicalTester.isTrue(this.f28425a.getModel(o0Var)));
    }

    @Override // com.huawei.flexiblelayout.parser.expr.expression.Var
    public String getName(o0 o0Var) throws ExprException {
        return "not";
    }

    @Override // com.huawei.flexiblelayout.parser.expr.expression.Expr
    public boolean isOk() {
        return this.f28425a != null;
    }

    @Override // com.huawei.flexiblelayout.parser.expr.expression.UnaryOperator
    public void setTarget(Expr expr) throws ExprException {
        this.f28425a = expr;
    }
}
