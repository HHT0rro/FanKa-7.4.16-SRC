package com.huawei.flexiblelayout.parser.expr.expression;

import com.huawei.flexiblelayout.parser.expr.ExprException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface Operator extends Expr {
    void setLeft(Expr expr) throws ExprException;

    void setRight(Expr expr) throws ExprException;
}
