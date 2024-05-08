package java.io;

import android.support.v4.media.session.PlaybackStateCompat;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class LineNumberReader extends BufferedReader {
    private static final int maxSkipBufferSize = 8192;
    private int lineNumber;
    private int markedLineNumber;
    private boolean markedSkipLF;
    private char[] skipBuffer;
    private boolean skipLF;

    public LineNumberReader(Reader in) {
        super(in);
        this.lineNumber = 0;
        this.skipBuffer = null;
    }

    public LineNumberReader(Reader in, int sz) {
        super(in, sz);
        this.lineNumber = 0;
        this.skipBuffer = null;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0018. Please report as an issue. */
    @Override // java.io.BufferedReader, java.io.Reader
    public int read() throws IOException {
        synchronized (this.lock) {
            int c4 = super.read();
            if (this.skipLF) {
                if (c4 == 10) {
                    c4 = super.read();
                }
                this.skipLF = false;
            }
            switch (c4) {
                case 13:
                    this.skipLF = true;
                case 10:
                    this.lineNumber++;
                    return 10;
                default:
                    return c4;
            }
        }
    }

    @Override // java.io.BufferedReader, java.io.Reader
    public int read(char[] cbuf, int off, int len) throws IOException {
        int n10;
        synchronized (this.lock) {
            n10 = super.read(cbuf, off, len);
            for (int i10 = off; i10 < off + n10; i10++) {
                char c4 = cbuf[i10];
                if (this.skipLF) {
                    this.skipLF = false;
                    if (c4 == '\n') {
                    }
                }
                switch (c4) {
                    case '\n':
                        break;
                    case '\r':
                        this.skipLF = true;
                        break;
                    default:
                        continue;
                }
                this.lineNumber++;
            }
        }
        return n10;
    }

    @Override // java.io.BufferedReader
    public String readLine() throws IOException {
        String l10;
        synchronized (this.lock) {
            l10 = super.readLine(this.skipLF);
            this.skipLF = false;
            if (l10 != null) {
                this.lineNumber++;
            }
        }
        return l10;
    }

    @Override // java.io.BufferedReader, java.io.Reader
    public long skip(long n10) throws IOException {
        long j10;
        int nc2;
        if (n10 < 0) {
            throw new IllegalArgumentException("skip() value is negative");
        }
        int nn = (int) Math.min(n10, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
        synchronized (this.lock) {
            char[] cArr = this.skipBuffer;
            if (cArr == null || cArr.length < nn) {
                this.skipBuffer = new char[nn];
            }
            long r10 = n10;
            while (r10 > 0 && (nc2 = read(this.skipBuffer, 0, (int) Math.min(r10, nn))) != -1) {
                r10 -= nc2;
            }
            j10 = n10 - r10;
        }
        return j10;
    }

    @Override // java.io.BufferedReader, java.io.Reader
    public void mark(int readAheadLimit) throws IOException {
        synchronized (this.lock) {
            if (this.skipLF) {
                readAheadLimit++;
            }
            super.mark(readAheadLimit);
            this.markedLineNumber = this.lineNumber;
            this.markedSkipLF = this.skipLF;
        }
    }

    @Override // java.io.BufferedReader, java.io.Reader
    public void reset() throws IOException {
        synchronized (this.lock) {
            super.reset();
            this.lineNumber = this.markedLineNumber;
            this.skipLF = this.markedSkipLF;
        }
    }
}
