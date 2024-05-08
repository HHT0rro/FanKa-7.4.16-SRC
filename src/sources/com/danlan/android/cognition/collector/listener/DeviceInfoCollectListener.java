package com.danlan.android.cognition.collector.listener;

import com.danlan.android.cognition.Cognition;
import com.danlan.android.cognition.collector.base.BaseDeviceInfoCollector;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface DeviceInfoCollectListener {
    void onAllDone(Cognition cognition);

    void onSingleFailure(BaseDeviceInfoCollector baseDeviceInfoCollector, String str);

    void onSingleSuccess(BaseDeviceInfoCollector baseDeviceInfoCollector);

    void onStart();
}
