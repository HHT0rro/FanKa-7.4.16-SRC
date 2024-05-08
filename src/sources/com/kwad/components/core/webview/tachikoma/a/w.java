package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class w implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c ZU;

    @NonNull
    private CopyOnWriteArrayList<com.kwad.sdk.core.b> ZV = new CopyOnWriteArrayList<>();

    public final void b(final com.kwad.sdk.core.b bVar) {
        if (this.ZU != null) {
            bn.runOnUiThread(new ay() { // from class: com.kwad.components.core.webview.tachikoma.a.w.1
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    if (w.this.ZU != null) {
                        w.this.ZU.a(bVar);
                    }
                }
            });
        } else {
            this.ZV.add(bVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public void onDestroy() {
        this.ZU = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.ZU = cVar;
        if (this.ZV.size() > 0) {
            Iterator<com.kwad.sdk.core.b> iterator2 = this.ZV.iterator2();
            while (iterator2.hasNext()) {
                com.kwad.sdk.core.b next = iterator2.next();
                b(next);
                this.ZV.remove(next);
            }
        }
    }
}
