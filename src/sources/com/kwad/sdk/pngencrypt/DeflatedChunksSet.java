package com.kwad.sdk.pngencrypt;

import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DeflatedChunksSet {
    public byte[] aKG;
    private int aKH;
    private int aKI;
    private int aKJ;
    public State aKK;
    private final boolean aKL;
    private d aKM;
    private long aKN;
    private long aKO;
    public int aKP;
    public int aKQ;
    public final String aKR;
    public final boolean aKq;
    private Inflater inf;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum State {
        WAITING_FOR_INPUT,
        ROW_READY,
        DONE,
        CLOSED;

        public final boolean isClosed() {
            return this == CLOSED;
        }

        public final boolean isDone() {
            return this == DONE || this == CLOSED;
        }
    }

    public DeflatedChunksSet(String str, boolean z10, int i10, int i11, Inflater inflater, byte[] bArr) {
        State state = State.WAITING_FOR_INPUT;
        this.aKK = state;
        this.aKN = 0L;
        this.aKO = 0L;
        this.aKP = -1;
        this.aKQ = -1;
        this.aKR = str;
        this.aKq = z10;
        this.aKI = i10;
        if (i10 > 0 && i11 >= i10) {
            if (inflater != null) {
                this.inf = inflater;
                this.aKL = false;
            } else {
                this.inf = new Inflater();
                this.aKL = true;
            }
            this.aKG = (bArr == null || bArr.length < i10) ? new byte[i11] : bArr;
            this.aKJ = -1;
            this.aKK = state;
            try {
                dE(i10);
                return;
            } catch (RuntimeException e2) {
                close();
                throw e2;
            }
        }
        throw new PngjException("bad inital row len " + i10);
    }

    private boolean JM() {
        State state;
        int i10;
        try {
            if (this.aKK == State.ROW_READY) {
                com.kwad.sdk.core.e.c.printStackTrace(new PngjException("invalid state"));
            }
            if (this.aKK.isDone()) {
                return false;
            }
            byte[] bArr = this.aKG;
            if (bArr == null || bArr.length < this.aKI) {
                this.aKG = new byte[this.aKI];
            }
            if (this.aKH < this.aKI && !this.inf.finished()) {
                try {
                    Inflater inflater = this.inf;
                    byte[] bArr2 = this.aKG;
                    int i11 = this.aKH;
                    i10 = inflater.inflate(bArr2, i11, this.aKI - i11);
                } catch (DataFormatException e2) {
                    com.kwad.sdk.core.e.c.printStackTrace(new PngjException("error decompressing zlib stream ", e2));
                    i10 = 0;
                }
                this.aKH += i10;
                this.aKO += i10;
            }
            if (this.aKH == this.aKI) {
                state = State.ROW_READY;
            } else if (!this.inf.finished()) {
                state = State.WAITING_FOR_INPUT;
            } else if (this.aKH > 0) {
                state = State.ROW_READY;
            } else {
                state = State.DONE;
            }
            this.aKK = state;
            if (state != State.ROW_READY) {
                return false;
            }
            JN();
            return true;
        } catch (RuntimeException e10) {
            close();
            throw e10;
        }
    }

    public void JN() {
    }

    public int JO() {
        throw new PngjException("not implemented");
    }

    public final void JP() {
        if (isDone()) {
            return;
        }
        this.aKK = State.DONE;
    }

    public final int JQ() {
        return this.aKJ;
    }

    public final void a(d dVar) {
        if (!this.aKR.equals(dVar.Jz().ahi)) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("Bad chunk inside IdatSet, id:" + dVar.Jz().ahi + ", expected:" + this.aKR));
        }
        this.aKM = dVar;
        int i10 = this.aKP + 1;
        this.aKP = i10;
        int i11 = this.aKQ;
        if (i11 >= 0) {
            dVar.dD(i10 + i11);
        }
    }

    public final void c(byte[] bArr, int i10, int i11) {
        this.aKN += i11;
        if (i11 <= 0 || this.aKK.isDone()) {
            return;
        }
        if (this.aKK == State.ROW_READY) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("this should only be called if waitingForMoreInput"));
        }
        if (!this.inf.needsDictionary() && this.inf.needsInput()) {
            this.inf.setInput(bArr, i10, i11);
            if (this.aKq) {
                while (JM()) {
                    dE(JO());
                    isDone();
                }
                return;
            }
            JM();
            return;
        }
        throw new RuntimeException("should not happen");
    }

    public void close() {
        Inflater inflater;
        try {
            if (!this.aKK.isClosed()) {
                this.aKK = State.CLOSED;
            }
            if (!this.aKL || (inflater = this.inf) == null) {
                return;
            }
            inflater.end();
            this.inf = null;
        } catch (Exception unused) {
        }
    }

    public final void dE(int i10) {
        this.aKH = 0;
        this.aKJ++;
        if (i10 <= 0) {
            this.aKI = 0;
            JP();
        } else {
            if (this.inf.finished()) {
                this.aKI = 0;
                JP();
                return;
            }
            this.aKK = State.WAITING_FOR_INPUT;
            this.aKI = i10;
            if (this.aKq) {
                return;
            }
            JM();
        }
    }

    public final boolean gh(String str) {
        if (this.aKK.isClosed()) {
            return false;
        }
        if (str.equals(this.aKR)) {
            return true;
        }
        if (this.aKK.isDone()) {
            if (!this.aKK.isClosed()) {
                close();
            }
            return false;
        }
        throw new PngjException("Unexpected chunk " + str + " while " + this.aKR + " set is not done");
    }

    public final boolean isClosed() {
        return this.aKK.isClosed();
    }

    public final boolean isDone() {
        return this.aKK.isDone();
    }

    public String toString() {
        return new StringBuilder("idatSet : " + this.aKM.Jz().ahi + " state=" + ((Object) this.aKK) + " rows=" + this.aKJ + " bytes=" + this.aKN + "/" + this.aKO).toString();
    }
}
