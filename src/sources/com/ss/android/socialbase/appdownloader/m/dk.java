package com.ss.android.socialbase.appdownloader.m;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.RequiresApi;

@RequiresApi(api = 26)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class dk extends m {
    public dk(Context context) {
        super(context, null, null);
    }

    @Override // com.ss.android.socialbase.appdownloader.m.np
    public Intent dk() {
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + this.f38895m.getPackageName()));
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        intent.addFlags(268435456);
        return intent;
    }
}
