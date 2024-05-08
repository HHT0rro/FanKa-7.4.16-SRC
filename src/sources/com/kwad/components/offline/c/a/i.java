package com.kwad.components.offline.c.a;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.tk.IOfflineCompoTachikomaContext;
import com.kwad.components.offline.api.tk.IOfflineTKView;
import com.kwad.sdk.components.j;
import com.kwad.sdk.components.m;
import com.kwad.sdk.components.o;
import com.kwad.sdk.components.p;
import com.kwad.sdk.components.q;
import com.kwad.sdk.utils.ap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class i implements q {
    private final IOfflineCompoTachikomaContext ads;

    public i(@NonNull IOfflineCompoTachikomaContext iOfflineCompoTachikomaContext) {
        ap.checkNotNull(iOfflineCompoTachikomaContext);
        this.ads = iOfflineCompoTachikomaContext;
    }

    @Override // com.kwad.sdk.components.q
    public final void a(String str, String str2, p pVar) {
        this.ads.execute(str, str2, new h(pVar));
    }

    @Override // com.kwad.sdk.components.q
    public final m aY(String str) {
        final IOfflineTKView tKView = this.ads.getTKView(str, new Object[0]);
        return new m() { // from class: com.kwad.components.offline.c.a.i.1
            @Override // com.kwad.sdk.components.m
            public final void bindActivity(Activity activity) {
                tKView.bindActivity(activity);
            }

            @Override // com.kwad.sdk.components.m
            public final View getView() {
                return tKView.getView();
            }

            @Override // com.kwad.sdk.components.m
            public final boolean onBackPressed() {
                return tKView.onBackPressed();
            }

            @Override // com.kwad.sdk.components.m
            public final void render() {
                tKView.render();
            }
        };
    }

    @Override // com.kwad.sdk.components.q
    public final void b(com.kwad.sdk.core.webview.c.g gVar) {
        if (gVar == null) {
            return;
        }
        this.ads.registerTKBridge(new f(gVar));
    }

    @Override // com.kwad.sdk.components.q
    public final void c(com.kwad.sdk.core.webview.c.a aVar) {
        if (aVar == null) {
            return;
        }
        this.ads.registerJsBridge(new b(aVar));
    }

    @Override // com.kwad.sdk.components.q
    public final Object execute(String str) {
        return this.ads.execute(str);
    }

    @Override // com.kwad.sdk.components.q
    public final int getUniqId() {
        return this.ads.getUniqId();
    }

    @Override // com.kwad.sdk.components.q
    public final View getView() {
        return this.ads.getView();
    }

    @Override // com.kwad.sdk.components.q
    public final void onDestroy() {
        this.ads.onDestroy();
    }

    @Override // com.kwad.sdk.components.q
    public final void setCustomEnv(Map<String, Object> map) {
        this.ads.setCustomEnv(map);
    }

    @Override // com.kwad.sdk.components.q
    public final void a(o oVar) {
        if (oVar != null) {
            this.ads.registerHostActionHandler(new c(oVar));
        }
    }

    @Override // com.kwad.sdk.components.q
    public final void a(j jVar) {
        if (jVar != null) {
            this.ads.registerApkLoadCreator(new e(jVar));
        }
    }
}
