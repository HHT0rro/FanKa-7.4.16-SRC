package com.huawei.flexiblelayout.parser.expr.expression;

import com.huawei.flexiblelayout.data.primitive.ListModel;
import com.huawei.flexiblelayout.o0;
import com.huawei.flexiblelayout.parser.expr.ExprException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class Index extends Var implements UnaryOperator {

    /* renamed from: a, reason: collision with root package name */
    private Var f28419a;

    /* renamed from: b, reason: collision with root package name */
    private final Var f28420b;

    public Index(Var var) {
        this.f28420b = var;
    }

    @Override // com.huawei.flexiblelayout.parser.expr.expression.Expr
    public Object getModel(o0 o0Var) throws ExprException {
        Object model = this.f28419a.getModel(o0Var);
        if (model == null) {
            return null;
        }
        if (model instanceof ListModel) {
            Object model2 = this.f28420b.getModel(o0Var);
            if (model2 == null) {
                return null;
            }
            if (model2 instanceof Integer) {
                Integer num = (Integer) model2;
                try {
                    return ((ListModel) model).get(num.intValue());
                } catch (Exception e2) {
                    throw new ExprException("Failed to get value of '" + this.f28419a.getName(o0Var) + "[" + ((Object) num) + "]'.", e2);
                }
            }
            throw new ExprException("Expected '" + this.f28420b.getName(o0Var) + "' is a Integer, but " + model2.getClass().getName() + ".");
        }
        throw new ExprException("Expected '" + this.f28419a.getName(o0Var) + "' is a ListModel, but " + model.getClass().getName() + ".");
    }

    @Override // com.huawei.flexiblelayout.parser.expr.expression.Var
    public String getName(o0 o0Var) throws ExprException {
        return this.f28419a.getName(o0Var);
    }

    @Override // com.huawei.flexiblelayout.parser.expr.expression.Expr
    public boolean isOk() {
        return (this.f28419a == null || this.f28420b == null) ? false : true;
    }

    @Override // com.huawei.flexiblelayout.parser.expr.expression.UnaryOperator
    public void setTarget(Expr expr) throws ExprException {
        if (expr instanceof Var) {
            this.f28419a = (Var) expr;
            return;
        }
        throw new ExprException("Expected variant to the target of index.");
    }
}
