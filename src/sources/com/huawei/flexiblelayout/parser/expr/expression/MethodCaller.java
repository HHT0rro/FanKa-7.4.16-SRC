package com.huawei.flexiblelayout.parser.expr.expression;

import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.l0;
import com.huawei.flexiblelayout.n0;
import com.huawei.flexiblelayout.o0;
import com.huawei.flexiblelayout.parser.expr.ExprException;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class MethodCaller extends Var implements UnaryOperator {

    /* renamed from: a, reason: collision with root package name */
    private final List<Expr> f28423a;

    /* renamed from: b, reason: collision with root package name */
    private Var f28424b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface Method {
        Object invoke(@NonNull o0 o0Var, @NonNull Object... objArr) throws Exception;

        @NonNull
        String name();

        int phase();
    }

    public MethodCaller(List<Expr> list) {
        this.f28423a = list;
    }

    @NonNull
    private Method a(o0 o0Var) throws ExprException {
        Method a10;
        Var var = this.f28424b;
        if (var instanceof Dot) {
            String name = ((Dot) var).f28409b.getName(o0Var);
            Object model = ((Dot) this.f28424b).f28408a.getModel(o0Var);
            if (model == null && (a10 = a(o0Var, ((Dot) this.f28424b).f28408a.getName(o0Var), name)) != null) {
                return a10;
            }
            if (model != null) {
                l0 a11 = l0.a(model, name);
                if (a11 != null) {
                    return a11;
                }
                throw new ExprException("Not supported method '" + name + "' for class '" + ((Object) model.getClass()) + "'.");
            }
            throw new ExprException("Attempt to invoke method '" + name + "' on a null object.");
        }
        if (var instanceof Identifier) {
            String name2 = var.getName(o0Var);
            Method a12 = a(o0Var, "", name2);
            if (a12 != null) {
                return a12;
            }
            throw new ExprException("Not supported global function '" + name2 + "'.");
        }
        throw new ExprException("Expected the target of method caller is a dot or identifier.");
    }

    @Override // com.huawei.flexiblelayout.parser.expr.expression.Expr
    public Object getModel(o0 o0Var) throws ExprException {
        Object[] objArr = new Object[this.f28423a.size()];
        for (int i10 = 0; i10 < this.f28423a.size(); i10++) {
            objArr[i10] = this.f28423a.get(i10).getModel(o0Var);
        }
        Method a10 = a(o0Var);
        try {
            return a10.invoke(o0Var, objArr);
        } catch (Exception e2) {
            throw new ExprException("Exception when invoking '" + ((Object) a10) + "'.", e2);
        }
    }

    @Override // com.huawei.flexiblelayout.parser.expr.expression.Var
    public String getName(o0 o0Var) throws ExprException {
        return this.f28424b.getName(o0Var);
    }

    public int getPhase(Object obj) throws ExprException {
        try {
            return a((o0) obj).phase();
        } catch (ClassCastException unused) {
            return 0;
        }
    }

    @Override // com.huawei.flexiblelayout.parser.expr.expression.Expr
    public boolean isOk() {
        return (this.f28423a == null || this.f28424b == null) ? false : true;
    }

    @Override // com.huawei.flexiblelayout.parser.expr.expression.UnaryOperator
    public void setTarget(Expr expr) throws ExprException {
        if (!(expr instanceof Dot) && !(expr instanceof Identifier)) {
            throw new ExprException("Expected the target of function or method caller is a dot or identifier.");
        }
        this.f28424b = (Var) expr;
    }

    private Method a(o0 o0Var, String str, String str2) {
        n0 a10 = o0Var.a(str);
        if (a10 != null) {
            return a10.a(str2);
        }
        return null;
    }
}
