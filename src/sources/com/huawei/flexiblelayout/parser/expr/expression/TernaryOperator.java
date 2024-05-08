package com.huawei.flexiblelayout.parser.expr.expression;

import com.huawei.flexiblelayout.o0;
import com.huawei.flexiblelayout.parser.expr.ExprException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class TernaryOperator extends Var implements Operator {

    /* renamed from: a, reason: collision with root package name */
    private final Expr f28429a;

    /* renamed from: b, reason: collision with root package name */
    private Expr f28430b;

    /* renamed from: c, reason: collision with root package name */
    private Expr f28431c;

    public TernaryOperator(Expr expr) {
        this.f28429a = expr;
    }

    @Override // com.huawei.flexiblelayout.parser.expr.expression.Expr
    public Object getModel(o0 o0Var) throws ExprException {
        if (LogicalTester.isTrue(this.f28430b.getModel(o0Var))) {
            return this.f28429a.getModel(o0Var);
        }
        return this.f28431c.getModel(o0Var);
    }

    @Override // com.huawei.flexiblelayout.parser.expr.expression.Var
    public String getName(o0 o0Var) throws ExprException {
        return "ternary";
    }

    @Override // com.huawei.flexiblelayout.parser.expr.expression.Expr
    public boolean isOk() {
        return (this.f28430b == null || this.f28429a == null || this.f28431c == null) ? false : true;
    }

    @Override // com.huawei.flexiblelayout.parser.expr.expression.Operator
    public void setLeft(Expr expr) {
        this.f28430b = expr;
    }

    @Override // com.huawei.flexiblelayout.parser.expr.expression.Operator
    public void setRight(Expr expr) {
        this.f28431c = expr;
    }
}
