package com.kwad.components.core.n.b.a;

import com.kwad.components.offline.api.core.network.IIdc;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class m implements IIdc {
    @Override // com.kwad.components.offline.api.core.network.IIdc
    public final String hostForAPI(String str) {
        if (str.equals("api")) {
            return com.kwad.sdk.g.xV();
        }
        return "https://" + com.kwad.sdk.core.network.idc.a.DU().W(str, null);
    }
}
