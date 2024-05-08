package com.kwad.components.offline.api.tk;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface IOfflineTKDialog {
    void callTKBridge(String str);

    void callbackDialogDismiss();

    void callbackPageStatus(boolean z10, String str);

    int getDialogId();

    String getStyleTemplate();

    String getViewKey();

    void registerJSCallHandler(IOfflineTKCallHandler iOfflineTKCallHandler);
}
