package com.ss.android.socialbase.appdownloader.m;

import android.content.Context;
import android.content.Intent;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class n extends m {
    public n(Context context) {
        super(context, null, null);
    }

    @Override // com.ss.android.socialbase.appdownloader.m.np
    public Intent dk() {
        Intent intent = new Intent("android.settings.SECURITY_SETTINGS");
        intent.addFlags(268435456);
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        return intent;
    }
}
