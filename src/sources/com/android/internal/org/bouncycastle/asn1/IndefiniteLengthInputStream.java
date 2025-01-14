package com.android.internal.org.bouncycastle.asn1;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class IndefiniteLengthInputStream extends LimitedInputStream {
    private int _b1;
    private int _b2;
    private boolean _eofOn00;
    private boolean _eofReached;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IndefiniteLengthInputStream(InputStream in, int limit) throws IOException {
        super(in, limit);
        this._eofReached = false;
        this._eofOn00 = true;
        this._b1 = in.read();
        int read = in.read();
        this._b2 = read;
        if (read < 0) {
            throw new EOFException();
        }
        checkForEof();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setEofOn00(boolean eofOn00) {
        this._eofOn00 = eofOn00;
        checkForEof();
    }

    private boolean checkForEof() {
        if (!this._eofReached && this._eofOn00 && this._b1 == 0 && this._b2 == 0) {
            this._eofReached = true;
            setParentEofDetect(true);
        }
        return this._eofReached;
    }

    @Override // java.io.InputStream
    public int read(byte[] b4, int off, int len) throws IOException {
        if (this._eofOn00 || len < 3) {
            return super.read(b4, off, len);
        }
        if (this._eofReached) {
            return -1;
        }
        int numRead = this._in.read(b4, off + 2, len - 2);
        if (numRead < 0) {
            throw new EOFException();
        }
        b4[off] = (byte) this._b1;
        b4[off + 1] = (byte) this._b2;
        this._b1 = this._in.read();
        int read = this._in.read();
        this._b2 = read;
        if (read < 0) {
            throw new EOFException();
        }
        return numRead + 2;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (checkForEof()) {
            return -1;
        }
        int b4 = this._in.read();
        if (b4 < 0) {
            throw new EOFException();
        }
        int v2 = this._b1;
        this._b1 = this._b2;
        this._b2 = b4;
        return v2;
    }
}
