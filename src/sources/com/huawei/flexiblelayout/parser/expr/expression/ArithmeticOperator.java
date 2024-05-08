package com.huawei.flexiblelayout.parser.expr.expression;

import com.huawei.flexiblelayout.o0;
import com.huawei.flexiblelayout.parser.expr.ExprException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class ArithmeticOperator extends Var implements Operator {

    /* renamed from: a, reason: collision with root package name */
    private Expr f28405a;

    /* renamed from: b, reason: collision with root package name */
    private Expr f28406b;

    public abstract Object evaluation(Object obj, Object obj2) throws ExprException;

    @Override // com.huawei.flexiblelayout.parser.expr.expression.Expr
    public Object getModel(o0 o0Var) throws ExprException {
        return evaluation(this.f28405a.getModel(o0Var), this.f28406b.getModel(o0Var));
    }

    @Override // com.huawei.flexiblelayout.parser.expr.expression.Var
    public abstract String getName(o0 o0Var) throws ExprException;

    @Override // com.huawei.flexiblelayout.parser.expr.expression.Expr
    public boolean isOk() {
        return (this.f28405a == null || this.f28406b == null) ? false : true;
    }

    @Override // com.huawei.flexiblelayout.parser.expr.expression.Operator
    public void setLeft(Expr expr) throws ExprException {
        this.f28405a = expr;
    }

    @Override // com.huawei.flexiblelayout.parser.expr.expression.Operator
    public void setRight(Expr expr) throws ExprException {
        this.f28406b = expr;
    }
}
