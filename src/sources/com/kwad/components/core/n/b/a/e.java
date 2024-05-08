package com.kwad.components.core.n.b.a;

import com.kwad.components.offline.api.core.api.IFlowUuid;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e implements IFlowUuid {
    @Override // com.kwad.components.offline.api.core.api.IFlowUuid
    public final long decryptLongFromBase64(String str) {
        try {
            return com.kwad.components.core.e.b.a.ac(str);
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
            return 0L;
        }
    }

    @Override // com.kwad.components.offline.api.core.api.IFlowUuid
    public final String encryptLongToBase64(long j10) {
        try {
            return com.kwad.components.core.e.b.a.t(j10);
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
            return null;
        }
    }
}
