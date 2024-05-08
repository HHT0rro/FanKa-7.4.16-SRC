package com.kwad.sdk.components;

import android.content.Intent;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface l {
    void a(n nVar);

    void callTKBridge(String str);

    void callbackDismiss();

    void callbackPageStatus(boolean z10, String str);

    String getClassName();

    Intent getIntent();

    String getTemplateString();

    String getUrl();

    String getViewKey();
}
