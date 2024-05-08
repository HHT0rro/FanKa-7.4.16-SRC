package com.huawei.hms.support.api.safetydetect;

import android.content.Context;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;
import com.huawei.hms.common.internal.HmsClient;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class SafetyDetectHmsClient extends HmsClient {
    public static final int HMS_VERSION_MIN = 40000000;

    public SafetyDetectHmsClient(Context context, ClientSettings clientSettings, BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        super(context, clientSettings, onConnectionFailedListener, connectionCallbacks);
    }

    @Override // com.huawei.hms.common.internal.BaseHmsClient
    public int getMinApkVersion() {
        return 40000000;
    }
}
