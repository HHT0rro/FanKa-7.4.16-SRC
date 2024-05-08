package com.huawei.quickcard.elexecutor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.quickcard.base.utils.Utils;
import java.util.Collection;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final /* synthetic */ class b {
    public static Object a(IExpressionContextProxy iExpressionContextProxy, @NonNull String str, @Nullable Collection collection, @Nullable Collection collection2) {
        Utils.collectSetterVarPath(collection);
        Utils.collectGetterVarPath(collection2);
        try {
            return iExpressionContextProxy.evaluate(str);
        } finally {
            Utils.stopCollectGetterVarPath(collection2);
            Utils.stopCollectSetterVarPath(collection);
        }
    }

    public static Object[] b(IExpressionContextProxy iExpressionContextProxy, @NonNull String[] strArr, int i10) {
        return iExpressionContextProxy.evaluate(strArr);
    }
}
