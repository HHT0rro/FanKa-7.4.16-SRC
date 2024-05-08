package com.kwad.components.offline.api.core.api;

import com.kwad.components.offline.api.tk.model.report.TKExceptionUploadParams;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface ICrash {
    void addCustomKeyValue(ICrashCustomKeyValue iCrashCustomKeyValue);

    void addOnCrashListener(ICrashOccurListener iCrashOccurListener);

    void gatherException(TKExceptionUploadParams tKExceptionUploadParams);

    void gatherException(Throwable th);
}
