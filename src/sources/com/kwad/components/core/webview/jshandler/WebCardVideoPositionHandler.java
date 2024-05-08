package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class WebCardVideoPositionHandler implements com.kwad.sdk.core.webview.c.a {
    private a Yj;
    private VideoPosition Yi = new VideoPosition();
    private Handler fS = new Handler(Looper.getMainLooper());

    @KsJson
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class VideoPosition extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = -3445790097441569428L;
        public int borderRadius;
        public KSAdJSCornerModel cornerRadius;
        public int height;
        public double heightWidthRation;
        public int leftMargin;
        public double leftMarginRation;
        public int topMargin;
        public double topMarginRation;
        public int width;
        public double widthRation;

        @KsJson
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
        public static class KSAdJSCornerModel extends com.kwad.sdk.core.response.a.a implements Serializable {
            private static final long serialVersionUID = -1503191931449786332L;
            public double bottomLeft;
            public double bottomRight;
            public double topLeft;
            public double topRight;
        }

        @Override // com.kwad.sdk.core.response.a.a
        public final void afterParseJson(@Nullable JSONObject jSONObject) {
            super.afterParseJson(jSONObject);
            if (jSONObject.has("cornerRadius")) {
                KSAdJSCornerModel kSAdJSCornerModel = new KSAdJSCornerModel();
                this.cornerRadius = kSAdJSCornerModel;
                kSAdJSCornerModel.parseJson(jSONObject.optJSONObject("cornerRadius"));
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void a(VideoPosition videoPosition);
    }

    public WebCardVideoPositionHandler(a aVar) {
        this.Yj = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "videoPosition";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.fS.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            this.Yi.parseJson(new JSONObject(str));
            if (this.Yj != null) {
                this.fS.post(new com.kwad.sdk.utils.ay() { // from class: com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler.1
                    @Override // com.kwad.sdk.utils.ay
                    public final void doTask() {
                        WebCardVideoPositionHandler.this.Yj.a(WebCardVideoPositionHandler.this.Yi);
                    }
                });
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        cVar.a(null);
    }
}
