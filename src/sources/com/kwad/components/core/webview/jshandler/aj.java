package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class aj implements com.kwad.sdk.core.webview.c.a {
    private final WebView NY;
    private Handler WA;

    @Nullable
    private com.kwad.sdk.core.webview.c.c WB;
    private boolean Xo;

    @Nullable
    private b cS;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class a implements com.kwad.sdk.core.b {
        public int bottomMargin;
        public int height;
        public int leftMargin;
        public int rightMargin;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.height = jSONObject.optInt("height");
            this.leftMargin = jSONObject.optInt("leftMargin");
            this.rightMargin = jSONObject.optInt("rightMargin");
            this.bottomMargin = jSONObject.optInt("bottomMargin");
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.putValue(jSONObject, "height", this.height);
            com.kwad.sdk.utils.t.putValue(jSONObject, "leftMargin", this.leftMargin);
            com.kwad.sdk.utils.t.putValue(jSONObject, "rightMargin", this.rightMargin);
            com.kwad.sdk.utils.t.putValue(jSONObject, "bottomMargin", this.bottomMargin);
            return jSONObject;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface b {
        @MainThread
        void a(@NonNull a aVar);
    }

    public aj(com.kwad.sdk.core.webview.b bVar, @Nullable b bVar2) {
        this(bVar, bVar2, true);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "initKsAdFrame";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.WB = null;
        this.cS = null;
        this.WA.removeCallbacksAndMessages(null);
    }

    private aj(com.kwad.sdk.core.webview.b bVar, @Nullable b bVar2, boolean z10) {
        this.Xo = true;
        this.WA = new Handler(Looper.getMainLooper());
        this.NY = bVar.NY;
        this.cS = bVar2;
        this.Xo = true;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.WB = cVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            final a aVar = new a();
            aVar.parseJson(jSONObject);
            this.WA.post(new com.kwad.sdk.utils.ay() { // from class: com.kwad.components.core.webview.jshandler.aj.1
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    if (aj.this.NY != null && aj.this.Xo) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) aj.this.NY.getLayoutParams();
                        marginLayoutParams.width = -1;
                        a aVar2 = aVar;
                        marginLayoutParams.height = aVar2.height;
                        marginLayoutParams.leftMargin = aVar2.leftMargin;
                        marginLayoutParams.rightMargin = aVar2.rightMargin;
                        marginLayoutParams.bottomMargin = aVar2.bottomMargin;
                        aj.this.NY.setLayoutParams(marginLayoutParams);
                    }
                    if (aj.this.cS != null) {
                        aj.this.cS.a(aVar);
                    }
                }
            });
            this.WA.post(new com.kwad.sdk.utils.ay() { // from class: com.kwad.components.core.webview.jshandler.aj.2
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    if (aj.this.WB != null) {
                        aj.this.WB.a(null);
                    }
                }
            });
        } catch (JSONException e2) {
            com.kwad.sdk.core.e.c.printStackTrace(e2);
            cVar.onError(-1, e2.getMessage());
        }
    }
}
