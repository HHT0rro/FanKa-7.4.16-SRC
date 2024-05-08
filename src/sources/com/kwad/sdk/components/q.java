package com.kwad.sdk.components;

import android.view.View;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface q {
    void a(j jVar);

    void a(o oVar);

    void a(String str, String str2, p pVar);

    m aY(String str);

    void b(com.kwad.sdk.core.webview.c.g gVar);

    void c(com.kwad.sdk.core.webview.c.a aVar);

    Object execute(String str);

    int getUniqId();

    View getView();

    void onDestroy();

    void setCustomEnv(Map<String, Object> map);
}
