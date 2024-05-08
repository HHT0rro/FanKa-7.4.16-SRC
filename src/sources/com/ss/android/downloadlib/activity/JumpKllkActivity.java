package com.ss.android.downloadlib.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.t;
import com.ss.android.downloadlib.addownload.c;
import com.ss.android.downloadlib.hc.e;
import com.ss.android.downloadlib.np.ej;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class JumpKllkActivity extends TTDelegateActivity {
    @Override // com.ss.android.downloadlib.activity.TTDelegateActivity
    public void m() {
        Intent intent = getIntent();
        if (getIntent() == null) {
            ej.m().m("handleIntent is null");
            com.ss.android.socialbase.appdownloader.ej.m((Activity) this);
            return;
        }
        String stringExtra = intent.getStringExtra(t.f36217b);
        long longExtra = intent.getLongExtra("id", 0L);
        if (TextUtils.isEmpty(stringExtra) || longExtra == 0) {
            ej.m().m("getPackage or id is null");
            com.ss.android.socialbase.appdownloader.ej.m((Activity) this);
        }
        boolean booleanExtra = intent.getBooleanExtra("dl", false);
        String stringExtra2 = intent.getStringExtra("bk");
        if (booleanExtra & (!TextUtils.isEmpty(stringExtra2))) {
            e.m((Context) this, stringExtra, longExtra, stringExtra2, true);
            com.ss.android.socialbase.appdownloader.ej.m((Activity) this);
            return;
        }
        int optInt = c.w().optInt("ab", 0);
        e.m(this, stringExtra, longExtra, optInt == 1);
        if (optInt != 1) {
            com.ss.android.socialbase.appdownloader.ej.m((Activity) this);
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        com.ss.android.socialbase.appdownloader.ej.m((Activity) this);
    }
}
