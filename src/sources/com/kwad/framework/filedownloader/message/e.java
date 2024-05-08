package com.kwad.framework.filedownloader.message;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e {
    private volatile g ahs;
    private volatile b aht;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class a {
        private static final e ahu = new e();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface b {
        void r(MessageSnapshot messageSnapshot);
    }

    public static e wf() {
        return a.ahu;
    }

    public final void a(b bVar) {
        this.aht = bVar;
        if (bVar == null) {
            this.ahs = null;
        } else {
            this.ahs = new g(5, bVar);
        }
    }

    public final void s(MessageSnapshot messageSnapshot) {
        if (messageSnapshot instanceof com.kwad.framework.filedownloader.message.b) {
            if (this.aht != null) {
                this.aht.r(messageSnapshot);
            }
        } else if (this.ahs != null) {
            this.ahs.u(messageSnapshot);
        }
    }
}
