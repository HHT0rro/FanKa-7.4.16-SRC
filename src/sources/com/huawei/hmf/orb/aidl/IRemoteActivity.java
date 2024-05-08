package com.huawei.hmf.orb.aidl;

import android.app.PendingIntent;
import com.huawei.hmf.annotation.NamedMethod;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface IRemoteActivity {
    public static final String Uri = "com.huawei.hmf.orb.aidl.IRemoteActivity";

    @NamedMethod("getActivity")
    PendingIntent getActivity(int i10);
}
