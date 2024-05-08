package com.kwad.components.core.webview.jshandler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class o implements com.kwad.sdk.core.webview.c.a {
    private BroadcastReceiver Wg = new BroadcastReceiver() { // from class: com.kwad.components.core.webview.jshandler.o.1
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra("data");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            a aVar = new a();
            aVar.message = stringExtra;
            o.this.ns.a(aVar);
        }
    };
    private com.kwad.sdk.core.webview.c.c ns;

    @KsJson
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public String message;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "onMessage";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        try {
            LocalBroadcastManager.getInstance(ServiceProvider.getContext()).unregisterReceiver(this.Wg);
        } catch (Throwable th) {
            com.kwad.sdk.crash.b.n(th);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.ns = cVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ksad_webView_local_broadcast");
        try {
            LocalBroadcastManager.getInstance(ServiceProvider.getContext()).registerReceiver(this.Wg, intentFilter);
        } catch (Throwable th) {
            com.kwad.sdk.crash.b.n(th);
        }
        cVar.a(null);
    }
}
