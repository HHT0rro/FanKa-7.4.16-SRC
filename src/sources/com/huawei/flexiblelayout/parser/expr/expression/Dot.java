package com.huawei.flexiblelayout.parser.expr.expression;

import com.huawei.flexiblelayout.data.primitive.MapModel;
import com.huawei.flexiblelayout.o0;
import com.huawei.flexiblelayout.parser.expr.ExprException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class Dot extends Var implements Operator {

    /* renamed from: a, reason: collision with root package name */
    public Var f28408a;

    /* renamed from: b, reason: collision with root package name */
    public Identifier f28409b;

    @Override // com.huawei.flexiblelayout.parser.expr.expression.Expr
    public Object getModel(o0 o0Var) throws ExprException {
        Object model = this.f28408a.getModel(o0Var);
        if (model == null) {
            return null;
        }
        if (model instanceof MapModel) {
            try {
                return ((MapModel) model).get(this.f28409b.getName(o0Var));
            } catch (Exception e2) {
                throw new ExprException("Failed to get value of '" + this.f28409b.getName(o0Var) + "'.", e2);
            }
        }
        throw new ExprException("Expected '" + this.f28408a.getName(o0Var) + "' is a MapModel, but " + model.getClass().getName() + ".");
    }

    @Override // com.huawei.flexiblelayout.parser.expr.expression.Var
    public String getName(o0 o0Var) throws ExprException {
        return this.f28409b.getName(o0Var);
    }

    @Override // com.huawei.flexiblelayout.parser.expr.expression.Expr
    public boolean isOk() {
        return (this.f28408a == null || this.f28409b == null) ? false : true;
    }

    @Override // com.huawei.flexiblelayout.parser.expr.expression.Operator
    public void setLeft(Expr expr) throws ExprException {
        if (expr instanceof Var) {
            this.f28408a = (Var) expr;
            return;
        }
        throw new ExprException("Expected variable to the left of dot.");
    }

    @Override // com.huawei.flexiblelayout.parser.expr.expression.Operator
    public void setRight(Expr expr) throws ExprException {
        if (expr instanceof Identifier) {
            this.f28409b = (Identifier) expr;
            return;
        }
        throw new ExprException("Expected identifier to the right of dot.");
    }
}
