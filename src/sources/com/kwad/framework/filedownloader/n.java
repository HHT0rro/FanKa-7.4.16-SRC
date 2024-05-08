package com.kwad.framework.filedownloader;

import android.content.Context;
import com.kwad.framework.filedownloader.services.e;
import com.kwad.sdk.api.proxy.app.FileDownloadService;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class n implements u {
    private final u aeQ;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class a {
        private static final n aeR = new n(0);
    }

    public /* synthetic */ n(byte b4) {
        this();
    }

    public static n uM() {
        return a.aeR;
    }

    public static e.a uN() {
        if (uM().aeQ instanceof o) {
            return (e.a) uM().aeQ;
        }
        return null;
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean a(String str, String str2, boolean z10, int i10, int i11, int i12, boolean z11, com.kwad.framework.filedownloader.d.b bVar, boolean z12) {
        return this.aeQ.a(str, str2, z10, i10, i11, i12, z11, bVar, z12);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final void ak(Context context) {
        this.aeQ.ak(context);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean bd(int i10) {
        return this.aeQ.bd(i10);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final byte be(int i10) {
        return this.aeQ.be(i10);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean bf(int i10) {
        return this.aeQ.bf(i10);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean isConnected() {
        return this.aeQ.isConnected();
    }

    private n() {
        this.aeQ = com.kwad.framework.filedownloader.f.e.wN().aip ? new o() : new p(FileDownloadService.SeparateProcessService.class);
    }
}
