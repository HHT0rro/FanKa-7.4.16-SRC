package com.kwad.components.offline.c;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a implements com.kwad.components.core.n.a.d.b {
    @Override // com.kwad.components.core.n.a.d.b
    public final void a(com.kwad.components.core.n.a.d.a aVar) {
        c.tJ().a(aVar);
    }

    @Override // com.kwad.components.core.n.a.d.b
    public final void b(com.kwad.components.core.n.a.d.a aVar) {
        c.tJ().b(aVar);
    }

    @Override // com.kwad.sdk.components.a
    public final Class<?> getComponentsType() {
        return com.kwad.components.core.n.a.d.b.class;
    }

    @Override // com.kwad.sdk.components.a
    public final void init(Context context) {
    }

    @Override // com.kwad.sdk.components.a
    public final int priority() {
        return 100;
    }
}
