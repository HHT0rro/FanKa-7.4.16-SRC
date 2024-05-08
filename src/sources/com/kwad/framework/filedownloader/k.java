package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.x;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class k implements t {
    private a.InterfaceC0494a aeL;
    private a.c aeM;
    private Queue<MessageSnapshot> aeN;
    private boolean aeO = false;

    public k(a.InterfaceC0494a interfaceC0494a, a.c cVar) {
        a(interfaceC0494a, cVar);
    }

    private void a(a.InterfaceC0494a interfaceC0494a, a.c cVar) {
        this.aeL = interfaceC0494a;
        this.aeM = cVar;
        this.aeN = new LinkedBlockingQueue();
    }

    private void bc(int i10) {
        if (com.kwad.framework.filedownloader.d.d.bF(i10)) {
            if (!this.aeN.isEmpty()) {
                MessageSnapshot peek = this.aeN.peek();
                com.kwad.framework.filedownloader.f.d.d(this, "the messenger[%s](with id[%d]) has already accomplished all his job, but there still are some messages in parcel queue[%d] queue-top-status[%d]", this, Integer.valueOf(peek.getId()), Integer.valueOf(this.aeN.size()), Byte.valueOf(peek.tV()));
            }
            this.aeL = null;
        }
    }

    private void o(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify completed %s", this.aeL);
        }
        this.aeM.um();
        p(messageSnapshot);
    }

    private void p(MessageSnapshot messageSnapshot) {
        a.InterfaceC0494a interfaceC0494a = this.aeL;
        if (interfaceC0494a == null) {
            if (com.kwad.framework.filedownloader.f.d.ail) {
                com.kwad.framework.filedownloader.f.d.c(this, "occur this case, it would be the host task of this messenger has been over(paused/warn/completed/error) on the other thread before receiving the snapshot(id[%d], status[%d])", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.tV()));
            }
        } else {
            if (!this.aeO && interfaceC0494a.ud().tS() != null) {
                this.aeN.offer(messageSnapshot);
                j.uD().a(this);
                return;
            }
            if ((l.isValid() || this.aeL.uk()) && messageSnapshot.tV() == 4) {
                this.aeM.um();
            }
            bc(messageSnapshot.tV());
        }
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void b(a.InterfaceC0494a interfaceC0494a, a.c cVar) {
        if (this.aeL == null) {
            a(interfaceC0494a, cVar);
            return;
        }
        throw new IllegalStateException(com.kwad.framework.filedownloader.f.f.b("the messenger is working, can't re-appointment for %s", interfaceC0494a));
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void f(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify pending %s", this.aeL);
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void g(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify started %s", this.aeL);
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void h(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify connected %s", this.aeL);
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void i(MessageSnapshot messageSnapshot) {
        a ud2 = this.aeL.ud();
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify progress %s %d %d", ud2, Long.valueOf(ud2.tT()), Long.valueOf(ud2.tU()));
        }
        if (ud2.tP() <= 0) {
            if (com.kwad.framework.filedownloader.f.d.ail) {
                com.kwad.framework.filedownloader.f.d.c(this, "notify progress but client not request notify %s", this.aeL);
                return;
            }
            return;
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void j(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify block completed %s %s", this.aeL, Thread.currentThread().getName());
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void k(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.ail) {
            a ud2 = this.aeL.ud();
            com.kwad.framework.filedownloader.f.d.c(this, "notify retry %s %d %d %s", this.aeL, Integer.valueOf(ud2.tY()), Integer.valueOf(ud2.tZ()), ud2.tX());
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void l(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify warn %s", this.aeL);
        }
        this.aeM.um();
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void m(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.ail) {
            a.InterfaceC0494a interfaceC0494a = this.aeL;
            com.kwad.framework.filedownloader.f.d.c(this, "notify error %s %s", interfaceC0494a, interfaceC0494a.ud().tX());
        }
        this.aeM.um();
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void n(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify paused %s", this.aeL);
        }
        this.aeM.um();
        p(messageSnapshot);
    }

    public final String toString() {
        Object[] objArr = new Object[2];
        a.InterfaceC0494a interfaceC0494a = this.aeL;
        objArr[0] = Integer.valueOf(interfaceC0494a == null ? -1 : interfaceC0494a.ud().getId());
        objArr[1] = super.toString();
        return com.kwad.framework.filedownloader.f.f.b("%d:%s", objArr);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final boolean uG() {
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify begin %s", this.aeL);
        }
        if (this.aeL == null) {
            com.kwad.framework.filedownloader.f.d.d(this, "can't begin the task, the holder fo the messenger is nil, %d", Integer.valueOf(this.aeN.size()));
            return false;
        }
        this.aeM.onBegin();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.framework.filedownloader.t
    public final void uH() {
        if (this.aeO) {
            return;
        }
        MessageSnapshot poll = this.aeN.poll();
        byte tV = poll.tV();
        a.InterfaceC0494a interfaceC0494a = this.aeL;
        if (interfaceC0494a == null) {
            return;
        }
        a ud2 = interfaceC0494a.ud();
        i tS = ud2.tS();
        x.a ue = interfaceC0494a.ue();
        bc(tV);
        if (tS == null) {
            return;
        }
        if (tV == 4) {
            try {
                tS.b(ud2);
                o(((com.kwad.framework.filedownloader.message.a) poll).vX());
                return;
            } catch (Throwable th) {
                m(ue.g(th));
                return;
            }
        }
        g gVar = tS instanceof g ? (g) tS : null;
        if (tV == -4) {
            tS.d(ud2);
            return;
        }
        if (tV == -3) {
            tS.c(ud2);
            return;
        }
        if (tV == -2) {
            if (gVar != null) {
                poll.wc();
                poll.wa();
                return;
            } else {
                tS.c(ud2, poll.vY(), poll.vZ());
                return;
            }
        }
        if (tV == -1) {
            tS.a(ud2, poll.wd());
            return;
        }
        if (tV == 1) {
            if (gVar != null) {
                poll.wc();
                poll.wa();
                return;
            } else {
                tS.a(ud2, poll.vY(), poll.vZ());
                return;
            }
        }
        if (tV == 2) {
            if (gVar != null) {
                poll.getEtag();
                poll.vQ();
                poll.wa();
                return;
            }
            tS.a(ud2, poll.getEtag(), poll.vQ(), ud2.getSmallFileSoFarBytes(), poll.vZ());
            return;
        }
        if (tV == 3) {
            if (gVar != null) {
                poll.wc();
                return;
            } else {
                tS.b(ud2, poll.vY(), ud2.getSmallFileTotalBytes());
                return;
            }
        }
        if (tV != 5) {
            if (tV != 6) {
                return;
            }
            tS.a(ud2);
        } else if (gVar != null) {
            poll.wd();
            poll.tZ();
            poll.wc();
        } else {
            poll.wd();
            poll.tZ();
            poll.vY();
        }
    }

    @Override // com.kwad.framework.filedownloader.t
    public final boolean uI() {
        return this.aeL.ud().ua();
    }

    @Override // com.kwad.framework.filedownloader.t
    public final boolean uJ() {
        return this.aeN.peek().tV() == 4;
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void uK() {
        this.aeO = true;
    }
}
