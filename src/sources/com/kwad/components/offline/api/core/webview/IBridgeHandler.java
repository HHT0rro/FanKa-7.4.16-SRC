package com.kwad.components.offline.api.core.webview;

import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface IBridgeHandler {
    @NonNull
    String getKey();

    void handleJsCall(String str);

    void onDestroy();
}
