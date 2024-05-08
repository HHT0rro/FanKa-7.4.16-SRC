package com.huawei.hms.support.api.safetydetect;

import android.app.Activity;
import android.content.Context;
import com.huawei.hms.utils.Checker;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class SafetyDetect {
    public static SafetyDetectClient getClient(Activity activity) {
        Checker.assertNonNull(activity);
        return new SafetyDetectClientImpl(activity, new SafetyDetectOptions());
    }

    public static SafetyDetectClient getClient(Context context) {
        Checker.assertNonNull(context);
        return new SafetyDetectClientImpl(context, new SafetyDetectOptions());
    }
}
