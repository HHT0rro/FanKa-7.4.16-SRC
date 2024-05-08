package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.bn;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {
    private b VO;

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class C0481a extends com.kwad.sdk.core.response.a.a {
        public String Jj;
        public String VR;
        public String VS;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface b {
        void c(C0481a c0481a);
    }

    @KsJson
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class c extends com.kwad.sdk.core.response.a.a {
        public int VT;
        public long VU;
        public boolean VV;
        public int errorCode;
    }

    public a(b bVar) {
        this.VO = bVar;
    }

    private void b(final C0481a c0481a) {
        bn.postOnUiThread(new com.kwad.sdk.utils.ay() { // from class: com.kwad.components.core.webview.jshandler.a.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                if (a.this.VO != null) {
                    a.this.VO.c(c0481a);
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "adOutCallback";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            C0481a c0481a = new C0481a();
            c0481a.parseJson(new JSONObject(str));
            b(c0481a);
        } catch (Throwable unused) {
        }
    }
}
