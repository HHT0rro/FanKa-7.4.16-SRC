package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class h {
    private final ArrayList<a.InterfaceC0494a> aeA;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class a {
        private static final h aeB = new h(0);
    }

    public /* synthetic */ h(byte b4) {
        this();
    }

    public static h uB() {
        return a.aeB;
    }

    public final boolean a(a.InterfaceC0494a interfaceC0494a) {
        return this.aeA.isEmpty() || !this.aeA.contains(interfaceC0494a);
    }

    public final int aZ(int i10) {
        int i11;
        synchronized (this.aeA) {
            Iterator<a.InterfaceC0494a> iterator2 = this.aeA.iterator2();
            i11 = 0;
            while (iterator2.hasNext()) {
                if (iterator2.next().aY(i10)) {
                    i11++;
                }
            }
        }
        return i11;
    }

    public final void b(a.InterfaceC0494a interfaceC0494a) {
        if (!interfaceC0494a.ud().tO()) {
            interfaceC0494a.ug();
        }
        if (interfaceC0494a.ue().ut().uG()) {
            c(interfaceC0494a);
        }
    }

    public final List<a.InterfaceC0494a> ba(int i10) {
        byte tV;
        ArrayList arrayList = new ArrayList();
        synchronized (this.aeA) {
            Iterator<a.InterfaceC0494a> iterator2 = this.aeA.iterator2();
            while (iterator2.hasNext()) {
                a.InterfaceC0494a next = iterator2.next();
                if (next.aY(i10) && !next.isOver() && (tV = next.ud().tV()) != 0 && tV != 10) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public final List<a.InterfaceC0494a> bb(int i10) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.aeA) {
            Iterator<a.InterfaceC0494a> iterator2 = this.aeA.iterator2();
            while (iterator2.hasNext()) {
                a.InterfaceC0494a next = iterator2.next();
                if (next.aY(i10) && !next.isOver()) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public final void c(a.InterfaceC0494a interfaceC0494a) {
        if (interfaceC0494a.uh()) {
            return;
        }
        synchronized (this.aeA) {
            if (this.aeA.contains(interfaceC0494a)) {
                com.kwad.framework.filedownloader.f.d.d(this, "already has %s", interfaceC0494a);
            } else {
                interfaceC0494a.ui();
                this.aeA.add(interfaceC0494a);
                if (com.kwad.framework.filedownloader.f.d.ail) {
                    com.kwad.framework.filedownloader.f.d.e(this, "add list in all %s %d %d", interfaceC0494a, Byte.valueOf(interfaceC0494a.ud().tV()), Integer.valueOf(this.aeA.size()));
                }
            }
        }
    }

    public final void o(List<a.InterfaceC0494a> list) {
        synchronized (this.aeA) {
            Iterator<a.InterfaceC0494a> iterator2 = this.aeA.iterator2();
            while (iterator2.hasNext()) {
                a.InterfaceC0494a next = iterator2.next();
                if (!list.contains(next)) {
                    list.add(next);
                }
            }
            this.aeA.clear();
        }
    }

    public final int size() {
        return this.aeA.size();
    }

    private h() {
        this.aeA = new ArrayList<>();
    }

    public final boolean a(a.InterfaceC0494a interfaceC0494a, MessageSnapshot messageSnapshot) {
        boolean remove;
        byte tV = messageSnapshot.tV();
        synchronized (this.aeA) {
            remove = this.aeA.remove(interfaceC0494a);
        }
        if (com.kwad.framework.filedownloader.f.d.ail && this.aeA.size() == 0) {
            com.kwad.framework.filedownloader.f.d.e(this, "remove %s left %d %d", interfaceC0494a, Byte.valueOf(tV), Integer.valueOf(this.aeA.size()));
        }
        if (remove) {
            t ut = interfaceC0494a.ue().ut();
            if (tV == -4) {
                ut.l(messageSnapshot);
            } else if (tV == -3) {
                ut.j(com.kwad.framework.filedownloader.message.f.t(messageSnapshot));
            } else if (tV == -2) {
                ut.n(messageSnapshot);
            } else if (tV == -1) {
                ut.m(messageSnapshot);
            }
        } else {
            com.kwad.framework.filedownloader.f.d.a(this, "remove error, not exist: %s %d", interfaceC0494a, Byte.valueOf(tV));
        }
        return remove;
    }
}
