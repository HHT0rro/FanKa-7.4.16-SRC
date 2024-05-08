package com.kwad.framework.filedownloader.message;

import com.kwad.framework.filedownloader.message.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class g {
    private final e.b aht;
    private final List<a> ahv = new ArrayList();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a {
        private final List<Integer> ahw = new ArrayList();
        private final Executor ahx;

        public a(int i10) {
            this.ahx = com.kwad.framework.filedownloader.f.b.o(1, "Flow-" + i10);
        }

        public final void bB(int i10) {
            this.ahw.add(Integer.valueOf(i10));
        }

        public final void u(final MessageSnapshot messageSnapshot) {
            this.ahx.execute(new Runnable() { // from class: com.kwad.framework.filedownloader.message.g.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    g.this.aht.r(messageSnapshot);
                    try {
                        a.this.ahw.remove(Integer.valueOf(messageSnapshot.getId()));
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    public g(int i10, e.b bVar) {
        this.aht = bVar;
        for (int i11 = 0; i11 < 5; i11++) {
            this.ahv.add(new a(i11));
        }
    }

    public final void u(MessageSnapshot messageSnapshot) {
        a aVar = null;
        try {
            synchronized (this.ahv) {
                int id2 = messageSnapshot.getId();
                Iterator<a> iterator2 = this.ahv.iterator2();
                while (true) {
                    if (!iterator2.hasNext()) {
                        break;
                    }
                    a next = iterator2.next();
                    if (next.ahw.contains(Integer.valueOf(id2))) {
                        aVar = next;
                        break;
                    }
                }
                if (aVar == null) {
                    int i10 = 0;
                    Iterator<a> iterator22 = this.ahv.iterator2();
                    while (true) {
                        if (!iterator22.hasNext()) {
                            break;
                        }
                        a next2 = iterator22.next();
                        if (next2.ahw.size() <= 0) {
                            aVar = next2;
                            break;
                        } else if (i10 == 0 || next2.ahw.size() < i10) {
                            i10 = next2.ahw.size();
                            aVar = next2;
                        }
                    }
                }
                if (aVar != null) {
                    aVar.bB(id2);
                }
            }
        } finally {
            if (aVar != null) {
                aVar.u(messageSnapshot);
            }
        }
    }
}
