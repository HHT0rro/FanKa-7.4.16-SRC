package com.huawei.hms.support.api.safetydetect;

import android.content.Context;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class SafetyDetectClientBuilder extends AbstractClientBuilder<SafetyDetectHmsClient, SafetyDetectOptions> {
    @Override // com.huawei.hms.common.internal.AbstractClientBuilder
    public SafetyDetectHmsClient buildClient(Context context, ClientSettings clientSettings, BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        return new SafetyDetectHmsClient(context, clientSettings, onConnectionFailedListener, connectionCallbacks);
    }
}
