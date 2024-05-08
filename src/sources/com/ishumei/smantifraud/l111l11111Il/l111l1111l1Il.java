package com.ishumei.smantifraud.l111l11111Il;

import com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l111l1111lIl;
import com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111lIIl;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l111l1111l1Il {
    private static l111l1111l1Il l1111l111111Il;
    private boolean l111l11111I1l = true;
    private l111l1111lIl l111l11111lIl;

    private l111l1111l1Il() {
    }

    public static synchronized l111l1111l1Il l1111l111111Il() {
        l111l1111l1Il l111l1111l1il;
        synchronized (l111l1111l1Il.class) {
            if (l1111l111111Il == null) {
                l1111l111111Il = new l111l1111l1Il();
            }
            l111l1111l1il = l1111l111111Il;
        }
        return l111l1111l1il;
    }

    public final synchronized void l1111l111111Il(com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l111l1111lI1l<?> l111l1111li1l) {
        if (this.l111l11111I1l) {
            l111l1111lIl l111l11111lIl = l11l1111lIIl.l111l11111lIl();
            this.l111l11111lIl = l111l11111lIl;
            l111l11111lIl.l1111l111111Il();
            this.l111l11111I1l = false;
        }
        this.l111l11111lIl.l1111l111111Il((com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l111l1111lI1l) l111l1111li1l);
    }

    public final synchronized void l111l11111lIl() {
        this.l111l11111lIl.l111l11111lIl();
        this.l111l11111I1l = true;
    }
}
