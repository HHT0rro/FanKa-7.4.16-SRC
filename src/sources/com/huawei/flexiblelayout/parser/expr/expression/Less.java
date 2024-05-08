package com.huawei.flexiblelayout.parser.expr.expression;

import com.huawei.flexiblelayout.o0;
import com.huawei.flexiblelayout.parser.expr.ExprException;
import com.huawei.flexiblelayout.y0;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class Less extends LogicalOperator {
    @Override // com.huawei.flexiblelayout.parser.expr.expression.LogicalOperator, com.huawei.flexiblelayout.parser.expr.expression.Var
    public String getName(o0 o0Var) throws ExprException {
        return "less";
    }

    @Override // com.huawei.flexiblelayout.parser.expr.expression.LogicalOperator
    public boolean isTrue(Object obj, Object obj2) throws ExprException {
        if ((obj instanceof Number) && (obj2 instanceof Number)) {
            return y0.b((Number) obj, (Number) obj2) < 0;
        }
        throw new ExprException("Expected Number to the left and right of '<' operator.");
    }
}
