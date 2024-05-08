package com.kwad.components.core.webview.jshandler;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.bn;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class bc implements com.kwad.sdk.core.webview.c.a {

    @Nullable
    private com.kwad.sdk.core.webview.c.c WB;
    private b Yd;

    @KsJson
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public int visibility;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface b {
        @MainThread
        void a(a aVar);
    }

    public bc(b bVar) {
        this.Yd = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        b bVar = this.Yd;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "setHeaderBar";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.Yd = null;
        this.WB = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.WB = cVar;
        final a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(str));
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
        bn.postOnUiThread(new com.kwad.sdk.utils.ay() { // from class: com.kwad.components.core.webview.jshandler.bc.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                bc.this.b(aVar);
                if (bc.this.WB != null) {
                    bc.this.WB.a(null);
                }
            }
        });
    }
}
