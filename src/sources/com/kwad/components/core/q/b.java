package com.kwad.components.core.q;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.tachikoma.c.e;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b extends e {
    public com.kwad.components.core.webview.tachikoma.e.c Sy;

    public static b a(e.b bVar) {
        b bVar2 = new b();
        bVar2.mAdResultData = bVar.hk();
        bVar2.xn = bVar.getTemplateId();
        Bundle bundle = new Bundle();
        bundle.putString("templateId", bVar.getTemplateId());
        bVar2.setArguments(bundle);
        return bVar2;
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.e
    public final com.kwad.components.core.webview.tachikoma.c.b jk() {
        return super.jk();
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.e
    public final com.kwad.components.core.webview.tachikoma.c.c jl() {
        return new c();
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.e, android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        com.kwad.components.core.webview.tachikoma.e.c cVar = this.Sy;
        if (cVar != null) {
            cVar.fZ();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.e, android.app.Fragment
    public final void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        com.kwad.components.core.webview.tachikoma.e.c cVar = this.Sy;
        if (cVar != null) {
            cVar.fR();
        }
    }

    @Nullable
    public static b a(b bVar, Activity activity, com.kwad.components.core.webview.tachikoma.e.c cVar) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        bVar.Sy = cVar;
        bVar.show(activity.getFragmentManager(), "webTKCloseDialog");
        return bVar;
    }
}
