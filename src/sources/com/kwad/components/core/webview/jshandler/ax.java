package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ax implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c VX;
    private final Handler WA = new Handler(Looper.getMainLooper());
    private final c XT;

    @KsJson
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public int likeUserCount;
        public long liveDuration;
        public int status;
        public long totalWatchingDuration;
        public int watchingUserCount;
        public String displayWatchingUserCount = "0";
        public String displayLikeUserCount = "0";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class b {
        public WeakReference<com.kwad.sdk.core.webview.c.c> XV;

        public b(com.kwad.sdk.core.webview.c.c cVar) {
            this.XV = new WeakReference<>(cVar);
        }

        public final void a(a aVar) {
            com.kwad.sdk.core.webview.c.c cVar = this.XV.get();
            if (cVar != null) {
                cVar.a(aVar);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface c {
        void a(b bVar);
    }

    public ax(c cVar) {
        this.XT = cVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerLiveListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.VX = null;
        this.WA.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.VX = cVar;
        this.WA.post(new com.kwad.sdk.utils.ay() { // from class: com.kwad.components.core.webview.jshandler.ax.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                ax.this.XT.a(new b(ax.this.VX));
            }
        });
    }
}
