package com.huawei.flexiblelayout.parser.expr.expression;

import com.huawei.flexiblelayout.parser.expr.ExprException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ExprBuilder {

    /* renamed from: a, reason: collision with root package name */
    private static final Class<?>[][] f28410a = {new Class[]{Dot.class, Index.class, Range.class, MethodCaller.class}, new Class[]{Not.class}, new Class[]{Multiply.class, Divide.class, Mod.class}, new Class[]{Add.class, Sub.class}, new Class[]{Greater.class, GreaterEquals.class, Less.class, LessEquals.class}, new Class[]{Equals.class, NotEquals.class}, new Class[]{And.class}, new Class[]{Or.class}, new Class[]{TernaryOperator.class}};

    /* renamed from: b, reason: collision with root package name */
    private static final String f28411b = "Mismatch parentheses.";

    /* renamed from: c, reason: collision with root package name */
    private static final String f28412c = "Empty parentheses.";

    /* renamed from: d, reason: collision with root package name */
    private static final String f28413d = "Missing expression to left of operator.";

    /* renamed from: e, reason: collision with root package name */
    private static final String f28414e = "Missing expression to right of operator.";

    /* renamed from: f, reason: collision with root package name */
    private static final String f28415f = "Syntax error in expression.";

    /* renamed from: g, reason: collision with root package name */
    private static final String f28416g = "Parser error in expression.";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class SubExpr extends EmptyExpr {

        /* renamed from: a, reason: collision with root package name */
        private final LinkedList<Expr> f28417a = new LinkedList<>();

        public boolean add(Expr expr) {
            return this.f28417a.add(expr);
        }

        public LinkedList<Expr> exprList() {
            return this.f28417a;
        }

        public boolean isEmpty() {
            return this.f28417a.isEmpty();
        }
    }

    private static void a(List<Expr> list) throws ExprException {
        ListIterator<Expr> listIterator = list.listIterator();
        while (true) {
            Parenthesis b4 = b(listIterator);
            if (b4 == null) {
                return;
            }
            if (!(b4 instanceof RightParenthesis)) {
                listIterator.remove();
                SubExpr subExpr = new SubExpr();
                int i10 = 1;
                while (listIterator.hasNext()) {
                    Expr next = listIterator.next();
                    listIterator.remove();
                    if (!(next instanceof LeftParenthesis)) {
                        if ((next instanceof RightParenthesis) && i10 - 1 == 0) {
                            break;
                        }
                    } else {
                        i10++;
                    }
                    subExpr.add(next);
                }
                if (i10 <= 0) {
                    if (!subExpr.isEmpty()) {
                        a(subExpr.exprList());
                        listIterator.add(subExpr);
                    } else {
                        throw new ExprException(f28412c);
                    }
                } else {
                    throw new ExprException(f28411b);
                }
            } else {
                throw new ExprException(f28411b);
            }
        }
    }

    private static Parenthesis b(ListIterator<Expr> listIterator) {
        while (listIterator.hasNext()) {
            Expr next = listIterator.next();
            if (next instanceof Parenthesis) {
                return (Parenthesis) next;
            }
        }
        return null;
    }

    public static Expr build(List<Expr> list) throws ExprException {
        a(list);
        return buildExpr(list);
    }

    public static Expr buildExpr(List<Expr> list) throws ExprException {
        int i10 = 0;
        while (list.size() > 1) {
            Class<?>[][] clsArr = f28410a;
            if (i10 >= clsArr.length) {
                break;
            }
            a(list, clsArr[i10]);
            i10++;
        }
        if (list.size() == 1) {
            Expr expr = list.get(0);
            if (expr instanceof SubExpr) {
                expr = buildExpr(((SubExpr) expr).exprList());
            }
            if (expr != null) {
                if (expr.isOk()) {
                    return expr;
                }
                throw new ExprException(f28416g);
            }
            throw new ExprException(f28415f);
        }
        throw new ExprException(f28415f);
    }

    private static Expr c(ListIterator<Expr> listIterator) throws ExprException {
        if (listIterator.hasPrevious()) {
            Expr previous = listIterator.previous();
            listIterator.remove();
            return previous;
        }
        throw new ExprException(f28413d);
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0004, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(java.util.List<com.huawei.flexiblelayout.parser.expr.expression.Expr> r6, java.lang.Class<?>[] r7) throws com.huawei.flexiblelayout.parser.expr.ExprException {
        /*
            java.util.ListIterator r6 = r6.listIterator()
        L4:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L8b
            java.lang.Object r0 = r6.next()
            com.huawei.flexiblelayout.parser.expr.expression.Expr r0 = (com.huawei.flexiblelayout.parser.expr.expression.Expr) r0
            boolean r1 = r0 instanceof com.huawei.flexiblelayout.parser.expr.expression.ExprBuilder.SubExpr
            if (r1 == 0) goto L22
            com.huawei.flexiblelayout.parser.expr.expression.ExprBuilder$SubExpr r0 = (com.huawei.flexiblelayout.parser.expr.expression.ExprBuilder.SubExpr) r0
            java.util.LinkedList r0 = r0.exprList()
            com.huawei.flexiblelayout.parser.expr.expression.Expr r0 = buildExpr(r0)
            r6.set(r0)
            goto L4
        L22:
            java.lang.Class r1 = r0.getClass()
            int r2 = r7.length
            r3 = 0
        L28:
            if (r3 >= r2) goto L4
            r4 = r7[r3]
            if (r1 != r4) goto L88
            boolean r4 = r0 instanceof com.huawei.flexiblelayout.parser.expr.expression.Operator
            if (r4 == 0) goto L50
            r4 = r0
            com.huawei.flexiblelayout.parser.expr.expression.Operator r4 = (com.huawei.flexiblelayout.parser.expr.expression.Operator) r4
            boolean r5 = r4.isOk()
            if (r5 != 0) goto L88
            r6.previous()
            com.huawei.flexiblelayout.parser.expr.expression.Expr r0 = c(r6)
            r6.next()
            com.huawei.flexiblelayout.parser.expr.expression.Expr r1 = a(r6)
            r4.setLeft(r0)
            r4.setRight(r1)
            goto L4
        L50:
            boolean r4 = r0 instanceof com.huawei.flexiblelayout.parser.expr.expression.LeftOperator
            if (r4 == 0) goto L65
            r4 = r0
            com.huawei.flexiblelayout.parser.expr.expression.UnaryOperator r4 = (com.huawei.flexiblelayout.parser.expr.expression.UnaryOperator) r4
            boolean r5 = r4.isOk()
            if (r5 != 0) goto L88
            com.huawei.flexiblelayout.parser.expr.expression.Expr r0 = a(r6)
            r4.setTarget(r0)
            goto L4
        L65:
            boolean r4 = r0 instanceof com.huawei.flexiblelayout.parser.expr.expression.UnaryOperator
            if (r4 == 0) goto L80
            r4 = r0
            com.huawei.flexiblelayout.parser.expr.expression.UnaryOperator r4 = (com.huawei.flexiblelayout.parser.expr.expression.UnaryOperator) r4
            boolean r5 = r4.isOk()
            if (r5 != 0) goto L88
            r6.previous()
            com.huawei.flexiblelayout.parser.expr.expression.Expr r0 = c(r6)
            r6.next()
            r4.setTarget(r0)
            goto L4
        L80:
            com.huawei.flexiblelayout.parser.expr.ExprException r6 = new com.huawei.flexiblelayout.parser.expr.ExprException
            java.lang.String r7 = "Parser error in expression."
            r6.<init>(r7)
            throw r6
        L88:
            int r3 = r3 + 1
            goto L28
        L8b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.flexiblelayout.parser.expr.expression.ExprBuilder.a(java.util.List, java.lang.Class[]):void");
    }

    private static Expr a(ListIterator<Expr> listIterator) throws ExprException {
        if (listIterator.hasNext()) {
            Expr next = listIterator.next();
            listIterator.remove();
            return next instanceof SubExpr ? buildExpr(((SubExpr) next).exprList()) : next;
        }
        throw new ExprException(f28414e);
    }
}
