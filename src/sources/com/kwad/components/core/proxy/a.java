package com.kwad.components.core.proxy;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.proxy.IActivityProxy;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a extends IActivityProxy {
    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        finish();
    }
}
