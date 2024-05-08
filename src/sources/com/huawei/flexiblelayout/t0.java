package com.huawei.flexiblelayout;

import com.android.internal.accessibility.common.ShortcutConstants;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.parser.expr.ExprException;
import com.huawei.flexiblelayout.parser.expr.expression.Add;
import com.huawei.flexiblelayout.parser.expr.expression.And;
import com.huawei.flexiblelayout.parser.expr.expression.Constant;
import com.huawei.flexiblelayout.parser.expr.expression.Divide;
import com.huawei.flexiblelayout.parser.expr.expression.Dot;
import com.huawei.flexiblelayout.parser.expr.expression.Equals;
import com.huawei.flexiblelayout.parser.expr.expression.Expr;
import com.huawei.flexiblelayout.parser.expr.expression.ExprBuilder;
import com.huawei.flexiblelayout.parser.expr.expression.Greater;
import com.huawei.flexiblelayout.parser.expr.expression.GreaterEquals;
import com.huawei.flexiblelayout.parser.expr.expression.Identifier;
import com.huawei.flexiblelayout.parser.expr.expression.Index;
import com.huawei.flexiblelayout.parser.expr.expression.LeftParenthesis;
import com.huawei.flexiblelayout.parser.expr.expression.Less;
import com.huawei.flexiblelayout.parser.expr.expression.LessEquals;
import com.huawei.flexiblelayout.parser.expr.expression.MethodCaller;
import com.huawei.flexiblelayout.parser.expr.expression.Mod;
import com.huawei.flexiblelayout.parser.expr.expression.Multiply;
import com.huawei.flexiblelayout.parser.expr.expression.Not;
import com.huawei.flexiblelayout.parser.expr.expression.NotEquals;
import com.huawei.flexiblelayout.parser.expr.expression.Or;
import com.huawei.flexiblelayout.parser.expr.expression.Range;
import com.huawei.flexiblelayout.parser.expr.expression.RightParenthesis;
import com.huawei.flexiblelayout.parser.expr.expression.Sub;
import com.huawei.flexiblelayout.parser.expr.expression.TernaryOperator;
import com.huawei.flexiblelayout.parser.expr.expression.Var;
import com.huawei.quickcard.base.Attributes;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.io.IOUtils;

/* compiled from: StatementParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class t0 extends s0 {

    /* renamed from: g, reason: collision with root package name */
    private static final String f28631g = "StatementParser";

    /* renamed from: f, reason: collision with root package name */
    private int f28632f;

    private t0(String str) {
        super(str);
    }

    public static <T extends w0> T a(String str, String str2) {
        t0 t0Var = new t0(str2);
        try {
            if ("if".equals(str)) {
                return t0Var.h();
            }
            if ("for".equals(str)) {
                return t0Var.g();
            }
            if (x0.f28668b.equals(str)) {
                return t0Var.l();
            }
            return null;
        } catch (Exception e2) {
            Log.e(f28631g, "Failed to parse '" + str + "': '" + str2 + "'.", e2);
            return null;
        }
    }

    private List<Expr> b(boolean z10) throws ExprException {
        this.f28632f = 0;
        Expr a10 = a(false, z10);
        if (a10 != null) {
            LinkedList linkedList = new LinkedList();
            while (a10 != null) {
                linkedList.add(a10);
                a10 = a(a10 instanceof Identifier, z10);
            }
            return linkedList;
        }
        throw new ExprException("Invalid expression.");
    }

    private Identifier n() throws ExprException {
        return new Identifier(c());
    }

    private Expr o() throws ExprException {
        if (c("==")) {
            return new Equals();
        }
        if (c("!=")) {
            return new NotEquals();
        }
        if (c(">=")) {
            return new GreaterEquals();
        }
        if (c("<=")) {
            return new LessEquals();
        }
        if (c("&&")) {
            return new And();
        }
        if (c("||")) {
            return new Or();
        }
        if (c('.')) {
            return new Dot();
        }
        if (c('[')) {
            return i();
        }
        if (c('!')) {
            return new Not();
        }
        if (c(">")) {
            return new Greater();
        }
        if (c("<")) {
            return new Less();
        }
        if (c('+')) {
            return new Add();
        }
        if (c('-')) {
            return new Sub();
        }
        if (c('*')) {
            return new Multiply();
        }
        if (c(IOUtils.DIR_SEPARATOR_UNIX)) {
            return new Divide();
        }
        if (c('%')) {
            return new Mod();
        }
        if (c('?')) {
            return k();
        }
        return null;
    }

    public Expr f() throws ExprException {
        return a(false);
    }

    public u0 g() throws ExprException {
        Identifier identifier;
        b();
        e();
        Identifier n10 = n();
        if (b(',')) {
            e();
            identifier = n();
        } else {
            identifier = n10;
            n10 = new Identifier(Attributes.Style.INDEX);
        }
        a(u0.f28637e);
        Var m10 = m();
        a();
        return new u0(n10, identifier, m10);
    }

    public v0 h() throws ExprException {
        b();
        Expr f10 = f();
        a();
        return new v0(f10);
    }

    public Expr i() throws ExprException {
        Var var;
        Var m10;
        boolean z10 = true;
        if (b(ShortcutConstants.SERVICES_SEPARATOR)) {
            var = new Constant(0);
        } else {
            Var m11 = m();
            if (b(ShortcutConstants.SERVICES_SEPARATOR)) {
                var = m11;
            } else {
                a(']');
                var = m11;
                z10 = false;
            }
        }
        if (z10) {
            if (b(']')) {
                m10 = new Constant(-1);
            } else {
                m10 = m();
                a(']');
            }
            return new Range(var, m10);
        }
        return new Index(var);
    }

    public MethodCaller j() throws ExprException {
        ArrayList arrayList = new ArrayList();
        int i10 = this.f28444c;
        this.f28444c = i10 + 1;
        while (this.f28444c < this.f28443b && !c(')')) {
            try {
                arrayList.add(a(true));
                c(',');
            } catch (ExprException e2) {
                throw new ExprException("Syntax error in method-caller " + s0.a(i10) + ".", e2);
            }
        }
        return new MethodCaller(arrayList);
    }

    public Expr k() throws ExprException {
        Expr f10 = f();
        a(ShortcutConstants.SERVICES_SEPARATOR);
        return new TernaryOperator(f10);
    }

    public x0 l() throws ExprException {
        b();
        Var m10 = m();
        a();
        return new x0(m10);
    }

    public Var m() throws ExprException {
        int i10 = this.f28444c;
        Expr f10 = f();
        if (f10 instanceof Var) {
            return (Var) f10;
        }
        throw new ExprException("Expected variable, " + s0.a(i10) + ".");
    }

    public Expr a(boolean z10) throws ExprException {
        int i10 = this.f28444c;
        try {
            return ExprBuilder.build(b(z10));
        } catch (ExprException e2) {
            throw new ExprException("Syntax error, " + s0.a(i10) + ": " + e2.getMessage(), e2);
        }
    }

    private String i(char c4) throws ExprException {
        boolean z10;
        StringBuilder sb2 = new StringBuilder();
        int i10 = this.f28444c;
        this.f28444c = i10 + 1;
        while (true) {
            int i11 = this.f28444c;
            z10 = true;
            if (i11 >= this.f28443b) {
                z10 = false;
                break;
            }
            char charAt = this.f28442a.charAt(i11);
            if (charAt == c4) {
                this.f28444c++;
                break;
            }
            if (charAt == '\\') {
                int i12 = this.f28444c + 1;
                this.f28444c = i12;
                if (i12 < this.f28443b) {
                    sb2.append(this.f28442a.charAt(i12));
                }
            } else {
                sb2.append(charAt);
            }
            this.f28444c++;
        }
        if (z10) {
            return sb2.toString();
        }
        throw new ExprException("Unterminated string " + s0.a(i10) + ".");
    }

    private Expr a(boolean z10, boolean z11) throws ExprException {
        e();
        char charAt = this.f28442a.charAt(this.f28444c);
        if (s0.f(charAt)) {
            String c4 = c();
            if ("true".equalsIgnoreCase(c4)) {
                return new Constant(Boolean.TRUE);
            }
            if ("false".equalsIgnoreCase(c4)) {
                return new Constant(Boolean.FALSE);
            }
            return new Identifier(c4);
        }
        if (s0.h(charAt)) {
            return new Constant(d());
        }
        if (charAt == '\"' || charAt == '\'') {
            return new Constant(i(charAt));
        }
        if (charAt == '(') {
            if (z10) {
                return j();
            }
            this.f28632f++;
            this.f28444c++;
            return new LeftParenthesis();
        }
        if (charAt == ')') {
            int i10 = this.f28632f - 1;
            this.f28632f = i10;
            if (z11 && i10 < 0) {
                return null;
            }
            this.f28444c++;
            return new RightParenthesis();
        }
        return o();
    }
}
