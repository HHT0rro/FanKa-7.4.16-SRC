package com.huawei.flexiblelayout.parser.expr.expression;

import com.huawei.flexiblelayout.data.primitive.ListModel;
import com.huawei.flexiblelayout.o0;
import com.huawei.flexiblelayout.p0;
import com.huawei.flexiblelayout.parser.expr.ExprException;
import com.huawei.openalliance.ad.constant.u;
import java.util.ArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class Range extends Var implements UnaryOperator {

    /* renamed from: a, reason: collision with root package name */
    private Var f28426a;

    /* renamed from: b, reason: collision with root package name */
    private final Var f28427b;

    /* renamed from: c, reason: collision with root package name */
    private final Var f28428c;

    public Range(Var var, Var var2) {
        this.f28427b = var;
        this.f28428c = var2;
    }

    @Override // com.huawei.flexiblelayout.parser.expr.expression.Expr
    public Object getModel(o0 o0Var) throws ExprException {
        Object model = this.f28426a.getModel(o0Var);
        if (model == null) {
            return null;
        }
        if (model instanceof ListModel) {
            Object model2 = this.f28427b.getModel(o0Var);
            if (model2 == null) {
                return null;
            }
            if (model2 instanceof Integer) {
                Object model3 = this.f28428c.getModel(o0Var);
                if (model3 == null) {
                    return null;
                }
                if (model3 instanceof Integer) {
                    int size = ((ListModel) model).size();
                    int intValue = ((Integer) model2).intValue();
                    int intValue2 = ((Integer) model3).intValue();
                    if (intValue2 != -1 && intValue2 <= size) {
                        size = intValue2;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i10 = intValue; i10 < size; i10++) {
                        try {
                            arrayList.add(((ListModel) model).get(i10));
                        } catch (Exception e2) {
                            throw new ExprException("Failed to get value of '" + this.f28426a.getName(o0Var) + "[" + intValue + u.bD + size + "]'.", e2);
                        }
                    }
                    return new p0(arrayList);
                }
                throw new ExprException("Expected '" + this.f28428c.getName(o0Var) + "' is a Integer, but " + model3.getClass().getName() + ".");
            }
            throw new ExprException("Expected '" + this.f28427b.getName(o0Var) + "' is a Integer, but " + model2.getClass().getName() + ".");
        }
        throw new ExprException("Expected '" + this.f28426a.getName(o0Var) + "' is a ListModel, but " + model.getClass().getName() + ".");
    }

    @Override // com.huawei.flexiblelayout.parser.expr.expression.Var
    public String getName(o0 o0Var) throws ExprException {
        return this.f28426a.getName(o0Var);
    }

    @Override // com.huawei.flexiblelayout.parser.expr.expression.Expr
    public boolean isOk() {
        return (this.f28426a == null || this.f28427b == null) ? false : true;
    }

    @Override // com.huawei.flexiblelayout.parser.expr.expression.UnaryOperator
    public void setTarget(Expr expr) throws ExprException {
        if (expr instanceof Var) {
            this.f28426a = (Var) expr;
            return;
        }
        throw new ExprException("Expected variable to the target of index.");
    }
}
