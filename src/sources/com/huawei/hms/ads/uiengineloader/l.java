package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import com.huawei.hms.hmsscankit.ScanUtil;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class l extends k {

    /* renamed from: a, reason: collision with root package name */
    public static final String f29452a = "l";

    @Override // com.huawei.hms.ads.uiengineloader.k
    public final void a() {
    }

    @Override // com.huawei.hms.ads.uiengineloader.k
    public final void a(Context context) {
        try {
            context.getClassLoader().loadClass("com.huawei.hms.ads.DynamicModuleInitializer").getDeclaredMethod(ScanUtil.CONTEXT_METHOD, Context.class).invoke(null, context);
        } catch (Exception e2) {
            aa.b(f29452a, "failed to init Module " + e2.getClass().getSimpleName());
        }
    }
}
