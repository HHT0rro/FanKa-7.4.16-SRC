package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import com.huawei.hianalytics.framework.constant.FrameworkConstant;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class i0 {
    public static String a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(z.a(str, str2))) {
            return z.a(str, str2);
        }
        v.c("hmsSdk", "getAndroidId(): to getConfigByType()");
        return c(context, str, str2);
    }

    public static String b(Context context, String str, String str2) {
        if (!str2.equals(FrameworkConstant.DataType.STRING_OPER) && !str2.equals(FrameworkConstant.DataType.STRING_MAINT) && !str2.equals(FrameworkConstant.DataType.STRING_DIFFPRIVACY) && !str2.equals(FrameworkConstant.DataType.STRING_PREINS)) {
            v.f("hmsSdk", "getChannel(): Invalid type: " + str2);
            return "";
        }
        return d(context, str, str2);
    }

    private static String c(Context context, String str, String str2) {
        if (!z.b(str, str2)) {
            return "";
        }
        if (TextUtils.isEmpty(q0.d())) {
            s.c().b().b(o.a(context));
        }
        return q0.d();
    }

    private static String d(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(a1.d(str, str2))) {
            return a1.d(str, str2);
        }
        g1 b4 = s.c().b();
        if (TextUtils.isEmpty(b4.h())) {
            String b10 = o.b(context);
            if (!e1.a(TTLiveConstants.INIT_CHANNEL, b10, 256)) {
                b10 = "";
            }
            b4.f(b10);
        }
        return b4.h();
    }
}
