package com.kwad.framework.filedownloader;

import android.content.Context;
import android.content.Intent;
import com.kwad.framework.filedownloader.event.DownloadServiceConnectChangedEvent;
import com.kwad.framework.filedownloader.services.e;
import com.kwad.sdk.api.proxy.app.FileDownloadService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class o implements e.a, u {
    private static Class<?> aeS;
    private final ArrayList<Runnable> aeT = new ArrayList<>();
    private com.kwad.framework.filedownloader.services.e aeU;

    private static Class<?> uP() {
        if (aeS == null) {
            aeS = FileDownloadService.SharedMainProcessService.class;
        }
        return aeS;
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean a(String str, String str2, boolean z10, int i10, int i11, int i12, boolean z11, com.kwad.framework.filedownloader.d.b bVar, boolean z12) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.h(str, str2, z10);
        }
        this.aeU.b(str, str2, z10, i10, i11, i12, z11, bVar, z12);
        return true;
    }

    @Override // com.kwad.framework.filedownloader.u
    public final void ak(Context context) {
        a(context, null);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean bd(int i10) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.bd(i10);
        }
        return this.aeU.bd(i10);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final byte be(int i10) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.be(i10);
        }
        return this.aeU.be(i10);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean bf(int i10) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.bf(i10);
        }
        return this.aeU.bf(i10);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean isConnected() {
        return this.aeU != null;
    }

    @Override // com.kwad.framework.filedownloader.services.e.a
    public final void onDisconnected() {
        this.aeU = null;
        f.uz().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.disconnected, uP()));
    }

    private void a(Context context, Runnable runnable) {
        context.startService(new Intent(context, uP()));
    }

    @Override // com.kwad.framework.filedownloader.services.e.a
    public final void a(com.kwad.framework.filedownloader.services.e eVar) {
        this.aeU = eVar;
        List list = (List) this.aeT.clone();
        this.aeT.clear();
        Iterator iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            ((Runnable) iterator2.next()).run();
        }
        f.uz().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.connected, uP()));
    }
}
