package com.kwad.components.ad.reward.k.a;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.c.f;
import com.kwad.components.core.webview.jshandler.h;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.sdk.components.q;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class c extends com.kwad.components.core.webview.tachikoma.c.c implements e {
    private a xu;

    public final void a(com.kwad.components.ad.reward.c.b bVar) {
        a aVar = this.xu;
        if (aVar != null) {
            aVar.b(bVar);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.a
    public final i hN() {
        this.xu = (a) this.aay;
        return new d(this.xu.ji(), this.xu.xs, getContext());
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        super.a(aVar);
        a aVar2 = this.xu;
        if (aVar2 == null || aVar2.ji() == null) {
            return;
        }
        this.xu.ji().oI.bJ();
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(q qVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(qVar, bVar);
        qVar.c(new f(new com.kwad.components.ad.reward.c.d() { // from class: com.kwad.components.ad.reward.k.a.c.1
            @Override // com.kwad.components.ad.reward.c.d
            public final void a(com.kwad.components.ad.reward.c.b bVar2) {
                com.kwad.sdk.core.e.c.d("RewardTKDialogFragmentPresenter", "onUpdateExtraReward : " + bVar2.gO());
                c.this.a(bVar2);
            }
        }));
        qVar.c(new h(new n() { // from class: com.kwad.components.ad.reward.k.a.c.2
            @Override // com.kwad.components.core.webview.jshandler.n
            public final void a(h hVar, String str) {
                if (TextUtils.equals(str, "getExtraReward")) {
                    hVar.a(com.kwad.components.ad.reward.c.a.gL().gM());
                    com.kwad.components.ad.reward.c.a.gL().a(hVar);
                }
            }
        }));
    }
}
