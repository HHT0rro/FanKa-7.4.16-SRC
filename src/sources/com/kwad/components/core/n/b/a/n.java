package com.kwad.components.core.n.b.a;

import com.kwad.components.offline.api.core.api.ISystemProperties;
import com.kwad.sdk.utils.bh;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class n implements ISystemProperties {
    @Override // com.kwad.components.offline.api.core.api.ISystemProperties
    public final String get(String str, String str2) {
        return bh.get(str, str2);
    }

    @Override // com.kwad.components.offline.api.core.api.ISystemProperties
    public final boolean getBoolean(String str, boolean z10) {
        return bh.getBoolean(str, z10);
    }

    @Override // com.kwad.components.offline.api.core.api.ISystemProperties
    public final int getInt(String str, int i10) {
        return bh.getInt(str, i10);
    }

    @Override // com.kwad.components.offline.api.core.api.ISystemProperties
    public final long getLong(String str, long j10) {
        return bh.getLong(str, j10);
    }
}
