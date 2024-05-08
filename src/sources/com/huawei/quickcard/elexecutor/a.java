package com.huawei.quickcard.elexecutor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final /* synthetic */ class a {
    public static void a(IExpressionContext iExpressionContext) {
    }

    public static Object b(IExpressionContext iExpressionContext, @NonNull String str, @Nullable Collection collection, @Nullable Collection collection2) {
        return iExpressionContext.evaluate(str);
    }

    public static int c(IExpressionContext iExpressionContext) {
        return iExpressionContext.hashCode();
    }
}
