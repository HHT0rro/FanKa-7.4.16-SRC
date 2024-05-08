package com.huawei.flexiblelayout.parser.expr.expression;

import com.huawei.flexiblelayout.data.primitive.ListModel;
import com.huawei.flexiblelayout.data.primitive.MapModel;
import com.huawei.flexiblelayout.parser.expr.ExprException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class LogicalTester {
    public static boolean isTrue(Object obj) throws ExprException {
        if (obj == null) {
            return false;
        }
        if (obj instanceof ListModel) {
            return !((ListModel) obj).isEmpty();
        }
        if (obj instanceof MapModel) {
            return !((MapModel) obj).isEmpty();
        }
        if (obj instanceof String) {
            return !((String) obj).isEmpty();
        }
        if (obj instanceof Number) {
            return ((Number) obj).intValue() != 0;
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return obj.toString().isEmpty();
    }
}
