package com.huawei.hms.ads.dynamicloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.huawei.hms.ads.uiengineloader.y;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class i extends e {
    public i(Context context, String str, int i10) {
        super(context, str, i10);
        ((e) this).f29157a.applicationInfo.processName = getBaseContext().getApplicationInfo().processName;
    }

    private void a() {
        ((e) this).f29157a.applicationInfo.processName = getBaseContext().getApplicationInfo().processName;
    }

    @Override // com.huawei.hms.ads.dynamicloader.e, android.content.ContextWrapper, android.content.Context
    public final ApplicationInfo getApplicationInfo() {
        return ((e) this).f29157a.applicationInfo;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final File getFilesDir() {
        return new File(y.c(((e) this).f29158b));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final String getPackageCodePath() {
        return ((e) this).f29158b;
    }

    @Override // com.huawei.hms.ads.dynamicloader.e, android.content.ContextWrapper, android.content.Context
    public final String getPackageName() {
        return getApplicationInfo().packageName;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final String getPackageResourcePath() {
        return ((e) this).f29158b;
    }
}
