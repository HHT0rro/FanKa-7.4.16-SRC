package com.kwad.framework.filedownloader.download;

import android.os.Process;
import com.kwad.framework.filedownloader.download.ConnectTask;
import com.kwad.framework.filedownloader.download.e;
import com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException;
import java.io.IOException;
import java.net.SocketException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c implements Runnable {
    private final String VM;
    private final int afG;
    private final ConnectTask agC;
    private final f agD;
    private e agE;
    public final int agF;
    private final boolean agd;
    private volatile boolean kH;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {
        private String VM;
        private Boolean agA;
        private f agD;
        private final ConnectTask.a agG = new ConnectTask.a();
        private Integer agH;

        public final a a(f fVar) {
            this.agD = fVar;
            return this;
        }

        public final a b(com.kwad.framework.filedownloader.download.a aVar) {
            this.agG.a(aVar);
            return this;
        }

        public final a bd(boolean z10) {
            this.agA = Boolean.valueOf(z10);
            return this;
        }

        public final a bi(String str) {
            this.agG.bf(str);
            return this;
        }

        public final a bj(String str) {
            this.agG.bg(str);
            return this;
        }

        public final a bk(String str) {
            this.VM = str;
            return this;
        }

        public final a bt(int i10) {
            this.agG.bs(i10);
            return this;
        }

        public final a c(com.kwad.framework.filedownloader.d.b bVar) {
            this.agG.a(bVar);
            return this;
        }

        public final a d(Integer num) {
            this.agH = num;
            return this;
        }

        public final c vF() {
            if (this.agD != null && this.VM != null && this.agA != null && this.agH != null) {
                ConnectTask vn = this.agG.vn();
                return new c(vn.afG, this.agH.intValue(), vn, this.agD, this.agA.booleanValue(), this.VM, (byte) 0);
            }
            throw new IllegalArgumentException(com.kwad.framework.filedownloader.f.f.b("%s %s %B", this.agD, this.VM, this.agA));
        }
    }

    public /* synthetic */ c(int i10, int i11, ConnectTask connectTask, f fVar, boolean z10, String str, byte b4) {
        this(i10, i11, connectTask, fVar, z10, str);
    }

    public final void pause() {
        this.kH = true;
        e eVar = this.agE;
        if (eVar != null) {
            eVar.pause();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z10;
        Exception e2;
        Process.setThreadPriority(10);
        long j10 = this.agC.vm().afP;
        com.kwad.framework.filedownloader.a.b bVar = null;
        boolean z11 = false;
        while (!this.kH) {
            try {
                try {
                    bVar = this.agC.vj();
                    int responseCode = bVar.getResponseCode();
                    if (com.kwad.framework.filedownloader.f.d.ail) {
                        com.kwad.framework.filedownloader.f.d.c(this, "the connection[%d] for %d, is connected %s with requestHttpCode[%d]", Integer.valueOf(this.agF), Integer.valueOf(this.afG), this.agC.vm(), Integer.valueOf(responseCode));
                    }
                    if (responseCode != 206 && responseCode != 200) {
                        throw new SocketException(com.kwad.framework.filedownloader.f.f.b("Connection failed with request[%s] response[%s] http-state[%d] on task[%d-%d], which is changed after verify connection, so please try again.", this.agC.getRequestHeader(), bVar.vd(), Integer.valueOf(responseCode), Integer.valueOf(this.afG), Integer.valueOf(this.agF)));
                        break;
                    }
                    try {
                        e.a aVar = new e.a();
                        if (this.kH) {
                            bVar.ve();
                            return;
                        }
                        e vS = aVar.bw(this.afG).bv(this.agF).b(this.agD).a(this).bf(this.agd).d(bVar).c(this.agC.vm()).bl(this.VM).vS();
                        this.agE = vS;
                        vS.run();
                        if (this.kH) {
                            this.agE.pause();
                        }
                        bVar.ve();
                        return;
                    } catch (FileDownloadGiveUpRetryException | IOException | ArrayIndexOutOfBoundsException | IllegalAccessException | IllegalArgumentException e10) {
                        e2 = e10;
                        z10 = true;
                        try {
                            if (!this.agD.a(e2)) {
                                this.agD.b(e2);
                                if (bVar != null) {
                                    bVar.ve();
                                    return;
                                }
                                return;
                            }
                            if (!z10) {
                                this.agD.a(e2, 0L);
                            } else {
                                e eVar = this.agE;
                                if (eVar != null) {
                                    this.agD.a(e2, eVar.afP - j10);
                                } else {
                                    com.kwad.framework.filedownloader.f.d.d(this, "it is valid to retry and connection is valid but create fetch-data-task failed, so give up directly with %s", e2);
                                    this.agD.b(e2);
                                    if (bVar != null) {
                                        return;
                                    } else {
                                        return;
                                    }
                                }
                            }
                            if (bVar != null) {
                                bVar.ve();
                            }
                            z11 = z10;
                        } finally {
                            if (bVar != null) {
                                bVar.ve();
                            }
                        }
                    }
                } catch (FileDownloadGiveUpRetryException | IOException | ArrayIndexOutOfBoundsException | IllegalAccessException | IllegalArgumentException e11) {
                    e2 = e11;
                    z10 = false;
                }
            } catch (FileDownloadGiveUpRetryException | IOException | ArrayIndexOutOfBoundsException | IllegalAccessException | IllegalArgumentException e12) {
                z10 = z11;
                e2 = e12;
            }
        }
        if (bVar != null) {
            bVar.ve();
        }
    }

    public final void uK() {
        pause();
    }

    private c(int i10, int i11, ConnectTask connectTask, f fVar, boolean z10, String str) {
        this.afG = i10;
        this.agF = i11;
        this.kH = false;
        this.agD = fVar;
        this.VM = str;
        this.agC = connectTask;
        this.agd = z10;
    }
}
