package com.kwad.components.core.webview.tachikoma;

import android.widget.FrameLayout;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.b.m;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.q;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface j {
    void a(a.C0481a c0481a);

    void a(aw awVar);

    void a(TKRenderFailReason tKRenderFailReason);

    void a(o oVar);

    void a(p pVar);

    void a(m mVar);

    void a(t tVar);

    void a(WebCloseStatus webCloseStatus);

    void a(q qVar, com.kwad.sdk.core.webview.b bVar);

    void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar);

    void b(ac.a aVar);

    @MainThread
    void bF();

    void bG();

    FrameLayout getTKContainer();

    String getTKReaderScene();

    String getTkTemplateId();

    com.kwad.sdk.widget.e getTouchCoordsView();
}
