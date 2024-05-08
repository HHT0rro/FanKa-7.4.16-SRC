package com.huawei.hms.activity.internal;

import android.app.Activity;
import android.content.Intent;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface BusResponseCallback {
    BusResponseResult innerError(Activity activity, int i10, String str);

    BusResponseResult succeedReturn(Activity activity, int i10, Intent intent);
}
