package com.huawei.flexiblelayout.parser.directive;

import com.huawei.appgallery.agd.common.utils.StringUtils;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.o0;
import com.huawei.flexiblelayout.parser.expr.ExprException;
import com.huawei.flexiblelayout.parser.expr.ProcessorResult;
import com.huawei.flexiblelayout.t0;
import com.huawei.flexiblelayout.x0;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ImportData extends VarFormula {

    /* renamed from: d, reason: collision with root package name */
    private static final String f28375d = "ImportData";

    /* renamed from: c, reason: collision with root package name */
    private final x0 f28376c;

    public ImportData(String str) {
        x0 x0Var;
        try {
            str = a(str);
        } catch (Exception e2) {
            Log.e(f28375d, "Failed to parse 'var' for importing data: '" + str + "'.", e2);
        }
        if (str != null) {
            x0Var = (x0) t0.a(x0.f28668b, str);
            this.f28376c = x0Var;
        }
        x0Var = null;
        this.f28376c = x0Var;
    }

    public static String a(String str) throws ExprException {
        int a10 = a(str, c(str, a(str, b(str, a(str, b(str, a(str, str.length() - 1), "}}")), StringUtils.NO_PRINT_CODE)), "."));
        int b4 = b(str, a(str, b(str, 0), "{{"));
        if (b4 >= a10) {
            return null;
        }
        return "{{" + str.substring(b4, a10 + 1) + "}}";
    }

    public static int b(String str, int i10, String str2) throws ExprException {
        int i11 = i10;
        for (int length = str2.length() - 1; length >= 0; length--) {
            if (str.charAt(i11) != str2.charAt(length)) {
                throw new ExprException("Not found string '" + str2 + "', at " + i10 + ".");
            }
            i11--;
        }
        return i11;
    }

    public static int c(String str, int i10, String str2) throws ExprException {
        int i11 = i10;
        for (int length = str2.length() - 1; length >= 0; length--) {
            if (str.charAt(i11) != str2.charAt(length)) {
                return i10;
            }
            i11--;
        }
        return i11;
    }

    @Override // com.huawei.flexiblelayout.parser.directive.VarFormula, com.huawei.flexiblelayout.parser.expr.Processor
    public void process(o0 o0Var, ProcessorResult processorResult) {
        x0 x0Var = this.f28376c;
        if (x0Var != null) {
            x0Var.process(o0Var, processorResult);
        }
    }

    public static int b(String str, int i10) throws ExprException {
        int length = str.length();
        while (i10 < length && a(str.charAt(i10))) {
            i10++;
        }
        if (i10 < length) {
            return i10;
        }
        throw new ExprException("Unexpected end.");
    }

    public static boolean a(char c4) {
        return Character.isWhitespace(c4);
    }

    public static int a(String str, int i10) throws ExprException {
        while (i10 >= 0 && a(str.charAt(i10))) {
            i10--;
        }
        if (i10 >= 0) {
            return i10;
        }
        throw new ExprException("Unexpected end.");
    }

    public static int a(String str, int i10, String str2) throws ExprException {
        int i11 = i10;
        for (int i12 = 0; i12 < str2.length(); i12++) {
            if (str.charAt(i11) != str2.charAt(i12)) {
                throw new ExprException("Not found string '" + str2 + "', at " + i10 + ".");
            }
            i11++;
        }
        return i11;
    }
}
