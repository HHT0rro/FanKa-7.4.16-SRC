package com.huawei.flexiblelayout.parser.expr.expression;

import com.huawei.flexiblelayout.o0;
import com.huawei.flexiblelayout.parser.expr.ExprException;
import com.huawei.flexiblelayout.y0;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class Add extends ArithmeticOperator {
    @Override // com.huawei.flexiblelayout.parser.expr.expression.ArithmeticOperator
    public Object evaluation(Object obj, Object obj2) throws ExprException {
        if ((obj instanceof Number) && (obj2 instanceof Number)) {
            try {
                return y0.a((Number) obj, (Number) obj2);
            } catch (ExprException unused) {
            }
        }
        return "" + obj + obj2;
    }

    @Override // com.huawei.flexiblelayout.parser.expr.expression.ArithmeticOperator, com.huawei.flexiblelayout.parser.expr.expression.Var
    public String getName(o0 o0Var) throws ExprException {
        return "addition";
    }
}
