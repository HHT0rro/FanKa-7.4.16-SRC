package com.huawei.flexiblelayout.parser.expr.expression;

import com.huawei.flexiblelayout.o0;
import com.huawei.flexiblelayout.parser.expr.ExprException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class Identifier extends Var {

    /* renamed from: a, reason: collision with root package name */
    private final String f28418a;

    public Identifier(String str) {
        this.f28418a = str;
    }

    @Override // com.huawei.flexiblelayout.parser.expr.expression.Expr
    public Object getModel(o0 o0Var) throws ExprException {
        try {
            return o0Var.a().get(this.f28418a);
        } catch (Exception e2) {
            throw new ExprException("Failed to get value of '" + this.f28418a + "'.", e2);
        }
    }

    @Override // com.huawei.flexiblelayout.parser.expr.expression.Var
    public String getName(o0 o0Var) throws ExprException {
        return this.f28418a;
    }

    @Override // com.huawei.flexiblelayout.parser.expr.expression.Expr
    public boolean isOk() {
        String str = this.f28418a;
        return (str == null || str.isEmpty()) ? false : true;
    }
}
