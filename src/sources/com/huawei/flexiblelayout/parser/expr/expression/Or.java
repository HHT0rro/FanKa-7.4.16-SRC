package com.huawei.flexiblelayout.parser.expr.expression;

import com.huawei.flexiblelayout.o0;
import com.huawei.flexiblelayout.parser.expr.ExprException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class Or extends LogicalOperator {
    @Override // com.huawei.flexiblelayout.parser.expr.expression.LogicalOperator, com.huawei.flexiblelayout.parser.expr.expression.Var
    public String getName(o0 o0Var) throws ExprException {
        return "or";
    }

    @Override // com.huawei.flexiblelayout.parser.expr.expression.LogicalOperator
    public boolean isTrue(Object obj, Object obj2) throws ExprException {
        return LogicalTester.isTrue(obj) || LogicalTester.isTrue(obj2);
    }
}
