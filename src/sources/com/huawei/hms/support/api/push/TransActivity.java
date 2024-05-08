package com.huawei.hms.support.api.push;

import android.app.Activity;
import android.os.Bundle;
import com.huawei.android.hms.push.R;
import com.huawei.hms.push.t;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class TransActivity extends Activity {
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.hwpush_trans_activity);
        getWindow().addFlags(67108864);
        t.a(this, getIntent());
        finish();
    }
}
