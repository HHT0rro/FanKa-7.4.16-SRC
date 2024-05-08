package com.huawei.flexiblelayout.parser.expr.expression;

import com.huawei.flexiblelayout.o0;
import com.huawei.flexiblelayout.parser.expr.ExprException;
import com.huawei.flexiblelayout.y0;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class Sub extends ArithmeticOperator {
    @Override // com.huawei.flexiblelayout.parser.expr.expression.ArithmeticOperator
    public Object evaluation(Object obj, Object obj2) throws ExprException {
        if ((obj instanceof Number) && (obj2 instanceof Number)) {
            return y0.f((Number) obj, (Number) obj2);
        }
        throw new ExprException("Expected Number to the left and right of '-'.");
    }

    @Override // com.huawei.flexiblelayout.parser.expr.expression.ArithmeticOperator, com.huawei.flexiblelayout.parser.expr.expression.Var
    public String getName(o0 o0Var) throws ExprException {
        return "subtraction";
    }
}
