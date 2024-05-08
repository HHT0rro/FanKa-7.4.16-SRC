package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.chunk.w;
import java.io.Closeable;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class o implements Closeable {
    public ErrorBehaviour aKj = ErrorBehaviour.STRICT;
    public final boolean aLF;
    public final c aLG;
    public final a aLH;
    public final w aLI;
    public int aLJ;
    private i<? extends Object> aLK;
    public final k aLj;

    public o(InputStream inputStream, boolean z10) {
        this.aLJ = -1;
        a aVar = new a(inputStream);
        this.aLH = aVar;
        boolean z11 = true;
        aVar.bF(true);
        c Kj = Kj();
        this.aLG = Kj;
        try {
            if (aVar.b(Kj, 36) != 36) {
                com.kwad.sdk.core.e.c.printStackTrace(new PngjException("Could not read first 36 bytes (PNG signature+IHDR chunk)"));
            }
            this.aLj = Kj.JJ();
            if (Kj.JK() == null) {
                z11 = false;
            }
            this.aLF = z11;
            aC(5024024L);
            aA(901001001L);
            aB(2024024L);
            this.aLI = new w(Kj.aKp);
            a(m.Kc());
            this.aLJ = -1;
        } catch (RuntimeException e2) {
            this.aLH.close();
            this.aLG.close();
            throw e2;
        }
    }

    private void Kf() {
        while (true) {
            c cVar = this.aLG;
            if (cVar.aKo >= 4) {
                return;
            }
            if (this.aLH.a(cVar) <= 0) {
                com.kwad.sdk.core.e.c.printStackTrace(new PngjException("Premature ending reading first chunks"));
            }
        }
    }

    private void Ki() {
        this.aLG.bH(false);
    }

    private static c Kj() {
        return new c(false);
    }

    private void a(i<? extends Object> iVar) {
        this.aLK = iVar;
    }

    private void aA(long j10) {
        this.aLG.aA(901001001L);
    }

    private void aB(long j10) {
        this.aLG.aB(2024024L);
    }

    private void aC(long j10) {
        this.aLG.aC(5024024L);
    }

    public final w Kg() {
        if (this.aLG.JH()) {
            Kf();
        }
        return this.aLI;
    }

    public final void Kh() {
        Ki();
        if (this.aLG.JH()) {
            Kf();
        }
        end();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        com.kwad.sdk.crash.utils.b.closeQuietly(this.aLG);
        com.kwad.sdk.crash.utils.b.closeQuietly(this.aLH);
    }

    public final void end() {
        try {
            if (this.aLG.JH()) {
                Kf();
            }
            if (this.aLG.JI() != null && !this.aLG.JI().isDone()) {
                this.aLG.JI().JP();
            }
            while (!this.aLG.isDone() && this.aLH.a(this.aLG) > 0) {
            }
        } finally {
            close();
        }
    }

    public final String toString() {
        return this.aLj.toString() + " interlaced=" + this.aLF;
    }
}
