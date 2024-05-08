package com.kwad.components.offline.api.obiwan;

import com.kwad.components.offline.api.IOfflineCompo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface IObiwanOfflineCompo extends IOfflineCompo<IObiwanOfflineCompoInitConfig> {
    public static final String IMPL = "com.kwad.sdk.core.log.ObiwanOfflineCompoImpl";
    public static final String PACKAGE_NAME = "com.kwad.components.obiwan";

    IObiwanLogcat getLog();

    void updateConfigs();
}
