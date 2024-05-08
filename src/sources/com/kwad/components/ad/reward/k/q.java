package com.kwad.components.ad.reward.k;

import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class q extends x {
    private long vz;
    private WeakReference<com.kwad.components.ad.reward.g> xp;

    public q(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.components.ad.reward.g gVar, long j10, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, @Nullable DialogInterface.OnDismissListener onDismissListener) {
        super(bVar, cVar, aVar, onDismissListener);
        this.vz = j10;
        if (gVar != null) {
            this.xp = new WeakReference<>(gVar);
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.x
    public final a.C0461a a(a.C0461a c0461a, com.kwad.sdk.core.webview.d.b.a aVar, AdTemplate adTemplate) {
        WeakReference<com.kwad.components.ad.reward.g> weakReference = this.xp;
        long j10 = 0;
        if (weakReference != null && weakReference.get() != null) {
            j10 = this.xp.get().oJ.getPlayDuration();
        } else {
            long j11 = this.vz;
            if (j11 > 0) {
                j10 = j11;
            }
        }
        return super.a(c0461a, aVar, adTemplate).w(j10);
    }

    @Override // com.kwad.components.core.webview.jshandler.x
    public final void jh() {
        super.jh();
        if (this.Wf != null) {
            com.kwad.components.ad.reward.c.a.gL().c(this.Wf.getAdTemplate(), com.kwad.components.ad.reward.c.b.STATUS_NONE);
        }
    }
}
