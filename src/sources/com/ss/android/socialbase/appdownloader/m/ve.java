package com.ss.android.socialbase.appdownloader.m;

import android.content.Context;
import android.content.Intent;
import com.kuaishou.weapon.p0.t;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ve extends m {
    public ve(Context context, DownloadSetting downloadSetting, String str) {
        super(context, downloadSetting, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.m.np
    public Intent dk() {
        String optString = this.dk.optString(t.f36222g);
        String m10 = com.ss.android.socialbase.appdownloader.n.ej.m(this.dk.optString("ag"), optString);
        String m11 = com.ss.android.socialbase.appdownloader.n.ej.m(this.dk.optString("ah"), optString);
        String m12 = com.ss.android.socialbase.appdownloader.n.ej.m(this.dk.optString("ai"), optString);
        String m13 = com.ss.android.socialbase.appdownloader.n.ej.m(this.dk.optString("aj"), optString);
        Intent intent = new Intent();
        intent.putExtra(m10, this.ej);
        intent.putExtra(m11, "*/*");
        intent.putExtra(m12, true);
        intent.setAction(m13);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        return intent;
    }
}
