package com.kwad.components.offline.b;

import com.kwad.components.offline.api.obiwan.IObiwanLogcat;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c implements com.kwad.sdk.core.e.a.a {
    private final IObiwanLogcat acR;

    public c(IObiwanLogcat iObiwanLogcat) {
        this.acR = iObiwanLogcat;
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void d(String str, String str2) {
        this.acR.d(str, str2);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void e(String str, String str2) {
        this.acR.e(str, str2);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void i(String str, String str2) {
        this.acR.i(str, str2);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void printStackTraceOnly(Throwable th) {
        this.acR.printStackTraceOnly(th);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void v(String str, String str2) {
        this.acR.v(str, str2);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void w(String str, String str2) {
        this.acR.w(str, str2);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void v(String str, String str2, boolean z10) {
        this.acR.v(str, str2, true);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void w(String str, String str2, boolean z10) {
        this.acR.w(str, str2, z10);
    }
}
