package com.huawei.hmf.services.interception;

import android.os.Bundle;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class CreateOptions {
    public static final String DoNotIntercept = "DoNotIntercept";

    public static boolean doNotIntercept(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return bundle.getBoolean(DoNotIntercept, false);
    }
}
