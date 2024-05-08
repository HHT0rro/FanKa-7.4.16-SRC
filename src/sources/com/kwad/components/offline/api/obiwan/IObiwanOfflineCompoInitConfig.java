package com.kwad.components.offline.api.obiwan;

import com.kwad.components.offline.api.IOfflineCompoInitConfig;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface IObiwanOfflineCompoInitConfig extends IOfflineCompoInitConfig {
    String getLogDirPath();

    String getLogObiwanData();

    long getLogObiwanStorageQuota();

    boolean isLogObiwanEnableNow();

    boolean isLogObiwanRecordAll();
}
