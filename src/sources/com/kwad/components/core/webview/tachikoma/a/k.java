package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class k extends w {
    public b ZK = new b() { // from class: com.kwad.components.core.webview.tachikoma.a.k.1
        @Override // com.kwad.components.core.webview.tachikoma.a.k.b
        public final void L(final long j10) {
            if (k.this.ns != null) {
                bn.runOnUiThread(new ay() { // from class: com.kwad.components.core.webview.tachikoma.a.k.1.1
                    @Override // com.kwad.sdk.utils.ay
                    public final void doTask() {
                        a aVar = new a((byte) 0);
                        aVar.creativeId = j10;
                        k.this.ns.a(aVar);
                    }
                });
            }
        }
    };
    private com.kwad.sdk.core.webview.c.c ns;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a implements com.kwad.sdk.core.b {
        public long creativeId;

        private a() {
        }

        public /* synthetic */ a(byte b4) {
            this();
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.putValue(jSONObject, "creativeId", this.creativeId);
            return jSONObject;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface b {
        void L(long j10);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerAdConvertListener";
    }

    @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        com.kwad.components.core.e.d.a.b(this.ZK);
    }

    @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.ns = cVar;
        com.kwad.components.core.e.d.a.a(this.ZK);
    }
}
