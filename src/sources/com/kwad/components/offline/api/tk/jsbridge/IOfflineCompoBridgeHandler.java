package com.kwad.components.offline.api.tk.jsbridge;

import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface IOfflineCompoBridgeHandler {
    @NonNull
    String getKey();

    void handleJsCall(String str, @NonNull IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction);

    void onDestroy();
}
