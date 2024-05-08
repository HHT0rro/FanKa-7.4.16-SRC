package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.event.DownloadServiceConnectChangedEvent;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class e extends com.kwad.framework.filedownloader.event.c {
    private DownloadServiceConnectChangedEvent.ConnectStatus aey;

    @Override // com.kwad.framework.filedownloader.event.c
    public final boolean a(com.kwad.framework.filedownloader.event.b bVar) {
        if (!(bVar instanceof DownloadServiceConnectChangedEvent)) {
            return false;
        }
        DownloadServiceConnectChangedEvent.ConnectStatus vT = ((DownloadServiceConnectChangedEvent) bVar).vT();
        this.aey = vT;
        if (vT == DownloadServiceConnectChangedEvent.ConnectStatus.connected) {
            uw();
            return false;
        }
        ux();
        return false;
    }

    public abstract void uw();

    public abstract void ux();

    public final DownloadServiceConnectChangedEvent.ConnectStatus uy() {
        return this.aey;
    }
}
