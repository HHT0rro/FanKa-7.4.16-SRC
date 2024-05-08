package com.tencent.cloud.huiyansdkface.wehttp2;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ContextHelper {

    /* renamed from: a, reason: collision with root package name */
    private static volatile Context f42215a;

    public static Context getContext() {
        return f42215a;
    }

    public static void setContext(Context context) {
        if (context != null) {
            f42215a = context.getApplicationContext();
        }
    }
}
