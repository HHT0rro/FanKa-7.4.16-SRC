package com.kwad.components.offline.b;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.obiwan.IObiwanLogcat;
import com.kwad.components.offline.api.obiwan.IObiwanOfflineCompo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a implements com.kwad.components.core.n.a.c.a {
    private final IObiwanOfflineCompo acL;

    public a(@NonNull IObiwanOfflineCompo iObiwanOfflineCompo) {
        this.acL = iObiwanOfflineCompo;
    }

    @Override // com.kwad.sdk.components.a
    public final Class getComponentsType() {
        return a.class;
    }

    public final IObiwanLogcat getLog() {
        return this.acL.getLog();
    }

    @Override // com.kwad.sdk.components.a
    public final void init(Context context) {
    }

    @Override // com.kwad.sdk.components.a
    public final int priority() {
        return this.acL.priority();
    }

    public final void updateConfigs() {
        this.acL.updateConfigs();
    }
}
