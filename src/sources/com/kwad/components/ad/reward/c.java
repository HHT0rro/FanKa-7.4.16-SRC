package com.kwad.components.ad.reward;

import androidx.annotation.Nullable;
import com.kwad.components.core.webview.tachikoma.b.q;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class c {
    private final Set<com.kwad.components.ad.reward.e.m> oo;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a {
        private static final c or = new c(0);
    }

    public /* synthetic */ c(byte b4) {
        this();
    }

    public static c fe() {
        return a.or;
    }

    public final void b(com.kwad.components.ad.reward.e.m mVar) {
        this.oo.remove(mVar);
    }

    public final void c(@Nullable final q qVar) {
        bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.reward.c.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                c.this.b(qVar);
            }
        });
    }

    private c() {
        this.oo = new HashSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(@Nullable q qVar) {
        if (this.oo.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.e.m> iterator2 = this.oo.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().a(qVar);
        }
    }

    public final void a(com.kwad.components.ad.reward.e.m mVar) {
        if (mVar != null) {
            this.oo.add(mVar);
        }
    }
}
