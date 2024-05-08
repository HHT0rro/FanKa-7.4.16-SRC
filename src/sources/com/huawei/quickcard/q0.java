package com.huawei.quickcard;

import androidx.annotation.Nullable;
import com.huawei.quickcard.base.log.CardLogUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class q0 {

    /* renamed from: a, reason: collision with root package name */
    private static final String f34188a = "IsNotNullImpl";

    public static boolean a(CardContext cardContext, @Nullable Object obj) {
        if (cardContext == null || obj == null) {
            return false;
        }
        if (!(obj instanceof String)) {
            return true;
        }
        String obj2 = obj.toString();
        try {
            return cardContext.executeExpr(obj2, false) != null;
        } catch (Throwable unused) {
            CardLogUtils.d(f34188a, "context don't has " + obj2);
            return false;
        }
    }
}
