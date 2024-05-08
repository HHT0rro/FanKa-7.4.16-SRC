package com.kwad.components.ad.draw.b.b;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class a {
    private InterfaceC0400a cF;

    @Nullable
    private b cG;
    private boolean cH = false;
    private AdTemplate mAdTemplate;

    /* renamed from: com.kwad.components.ad.draw.b.b.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface InterfaceC0400a {
        void aq();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface b {
        boolean ar();
    }

    public a(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    @MainThread
    public final void a(InterfaceC0400a interfaceC0400a) {
        this.cF = interfaceC0400a;
    }

    public final void ap() {
        InterfaceC0400a interfaceC0400a;
        if (this.cH) {
            return;
        }
        this.cH = true;
        if (e.dQ(this.mAdTemplate).status == 1 || e.dQ(this.mAdTemplate).status == 2 || e.dQ(this.mAdTemplate).status == 3) {
            return;
        }
        b bVar = this.cG;
        if ((bVar == null || !bVar.ar()) && (interfaceC0400a = this.cF) != null) {
            interfaceC0400a.aq();
        }
    }

    @MainThread
    public final void a(b bVar) {
        this.cG = bVar;
    }
}
