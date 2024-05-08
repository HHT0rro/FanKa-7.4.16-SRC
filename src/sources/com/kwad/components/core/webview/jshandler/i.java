package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.sdk.service.ServiceProvider;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class i implements com.kwad.sdk.core.webview.c.a {
    private static String aI(String str) {
        s.a aVar = new s.a();
        try {
            aVar.parseJson(new JSONObject(str));
        } catch (JSONException unused) {
        }
        return TextUtils.isEmpty(aVar.key) ? "" : com.kwad.sdk.utils.y.b(ServiceProvider.getContext(), "ksadsdk_js_storage_cache_name", aVar.key, "");
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (!TextUtils.isEmpty(str)) {
            String aI = aI(str);
            s.a aVar = new s.a();
            aVar.value = aI;
            cVar.a(aVar);
            return;
        }
        cVar.onError(-1, "data is empty");
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getStorageItem";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
