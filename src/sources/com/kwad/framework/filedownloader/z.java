package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.event.DownloadServiceConnectChangedEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class z extends e implements v {
    private final ArrayList<a.InterfaceC0494a> afg = new ArrayList<>();

    @Override // com.kwad.framework.filedownloader.v
    public final boolean d(a.InterfaceC0494a interfaceC0494a) {
        return !this.afg.isEmpty() && this.afg.contains(interfaceC0494a);
    }

    @Override // com.kwad.framework.filedownloader.v
    public final void e(a.InterfaceC0494a interfaceC0494a) {
        if (this.afg.isEmpty()) {
            return;
        }
        synchronized (this.afg) {
            this.afg.remove(interfaceC0494a);
        }
    }

    @Override // com.kwad.framework.filedownloader.v
    public final boolean f(a.InterfaceC0494a interfaceC0494a) {
        r.uU();
        if (!r.uW()) {
            synchronized (this.afg) {
                r.uU();
                if (!r.uW()) {
                    if (com.kwad.framework.filedownloader.f.d.ail) {
                        com.kwad.framework.filedownloader.f.d.c(this, "Waiting for connecting with the downloader service... %d", Integer.valueOf(interfaceC0494a.ud().getId()));
                    }
                    n.uM().ak(com.kwad.framework.filedownloader.f.c.wL());
                    if (!this.afg.contains(interfaceC0494a)) {
                        interfaceC0494a.free();
                        this.afg.add(interfaceC0494a);
                    }
                    return true;
                }
            }
        }
        e(interfaceC0494a);
        return false;
    }

    @Override // com.kwad.framework.filedownloader.e
    public final void uw() {
        w uX = r.uU().uX();
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.c(this, "The downloader service is connected.", new Object[0]);
        }
        synchronized (this.afg) {
            List<a.InterfaceC0494a> list = (List) this.afg.clone();
            this.afg.clear();
            ArrayList arrayList = new ArrayList(uX.vb());
            for (a.InterfaceC0494a interfaceC0494a : list) {
                int uf = interfaceC0494a.uf();
                if (uX.bh(uf)) {
                    interfaceC0494a.ud().tM().ul();
                    if (!arrayList.contains(Integer.valueOf(uf))) {
                        arrayList.add(Integer.valueOf(uf));
                    }
                } else {
                    interfaceC0494a.uj();
                }
            }
            uX.p(arrayList);
        }
    }

    @Override // com.kwad.framework.filedownloader.e
    public final void ux() {
        if (uy() == DownloadServiceConnectChangedEvent.ConnectStatus.lost) {
            w uX = r.uU().uX();
            if (com.kwad.framework.filedownloader.f.d.ail) {
                com.kwad.framework.filedownloader.f.d.c(this, "lost the connection to the file download service, and current active task size is %d", Integer.valueOf(h.uB().size()));
            }
            if (h.uB().size() > 0) {
                synchronized (this.afg) {
                    h.uB().o(this.afg);
                    Iterator<a.InterfaceC0494a> iterator2 = this.afg.iterator2();
                    while (iterator2.hasNext()) {
                        iterator2.next().free();
                    }
                    uX.va();
                }
                r.uU().uV();
                return;
            }
            return;
        }
        if (h.uB().size() > 0) {
            com.kwad.framework.filedownloader.f.d.d(this, "file download service has be unbound but the size of active tasks are not empty %d ", Integer.valueOf(h.uB().size()));
        }
    }
}
