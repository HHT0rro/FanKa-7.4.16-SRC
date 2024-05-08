package com.huawei.openalliance.ad.activity;

import android.app.Activity;
import android.os.Bundle;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.hx;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PPSNotificationActivity extends Activity {
    private static final String Code = "PPSNotificationActivity";

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        gl.Code(Code, "PPSNotification onCreate");
        hx.Code(this).Code(this, getIntent());
        finish();
    }
}
