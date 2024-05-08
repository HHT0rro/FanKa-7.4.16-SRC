package com.kwad.components.core.p;

import com.kwad.sdk.api.core.SpeedLimitApi;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a implements SpeedLimitApi {
    @Override // com.kwad.sdk.api.core.SpeedLimitApi
    public InputStream wrapInputStream(InputStream inputStream) {
        b.qA();
        return b.wrapInputStream(inputStream);
    }
}
