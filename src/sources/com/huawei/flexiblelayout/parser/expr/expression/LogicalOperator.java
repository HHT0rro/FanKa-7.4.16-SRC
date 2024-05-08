package com.huawei.flexiblelayout.parser.expr.expression;

import com.huawei.flexiblelayout.o0;
import com.huawei.flexiblelayout.parser.expr.ExprException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class LogicalOperator extends Var implements Operator {

    /* renamed from: a, reason: collision with root package name */
    private Expr f28421a;

    /* renamed from: b, reason: collision with root package name */
    private Expr f28422b;

    @Override // com.huawei.flexiblelayout.parser.expr.expression.Expr
    public Object getModel(o0 o0Var) throws ExprException {
        return Boolean.valueOf(isTrue(this.f28421a.getModel(o0Var), this.f28422b.getModel(o0Var)));
    }

    @Override // com.huawei.flexiblelayout.parser.expr.expression.Var
    public abstract String getName(o0 o0Var) throws ExprException;

    @Override // com.huawei.flexiblelayout.parser.expr.expression.Expr
    public boolean isOk() {
        return (this.f28421a == null || this.f28422b == null) ? false : true;
    }

    public abstract boolean isTrue(Object obj, Object obj2) throws ExprException;

    @Override // com.huawei.flexiblelayout.parser.expr.expression.Operator
    public void setLeft(Expr expr) throws ExprException {
        this.f28421a = expr;
    }

    @Override // com.huawei.flexiblelayout.parser.expr.expression.Operator
    public void setRight(Expr expr) throws ExprException {
        this.f28422b = expr;
    }
}
