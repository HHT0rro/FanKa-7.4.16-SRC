package java.io;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Formatter;
import sun.nio.cs.StreamDecoder;
import sun.nio.cs.StreamEncoder;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Console implements Flushable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static Console cons;
    private static boolean echoOff;
    private Charset cs;
    private Formatter formatter;
    private Writer out;
    private PrintWriter pw;
    private char[] rcb;
    private Object readLock;
    private Reader reader;
    private Object writeLock;

    private static native boolean echo(boolean z10) throws IOException;

    private static native String encoding();

    private static native boolean istty();

    public PrintWriter writer() {
        return this.pw;
    }

    public Reader reader() {
        return this.reader;
    }

    public Console format(String fmt, Object... args) {
        this.formatter.format(fmt, args).flush();
        return this;
    }

    public Console printf(String format, Object... args) {
        return format(format, args);
    }

    public String readLine(String fmt, Object... args) {
        String line = null;
        synchronized (this.writeLock) {
            synchronized (this.readLock) {
                if (fmt.length() != 0) {
                    this.pw.format(fmt, args);
                }
                try {
                    char[] ca2 = readline(false);
                    if (ca2 != null) {
                        line = new String(ca2);
                    }
                } catch (IOException x10) {
                    throw new IOError(x10);
                }
            }
        }
        return line;
    }

    public String readLine() {
        return readLine("", new Object[0]);
    }

    public char[] readPassword(String fmt, Object... args) {
        char[] passwd;
        synchronized (this.writeLock) {
            synchronized (this.readLock) {
                try {
                    try {
                        echoOff = echo(false);
                        IOError ioe = null;
                        try {
                            try {
                                if (fmt.length() != 0) {
                                    this.pw.format(fmt, args);
                                }
                                passwd = readline(true);
                                try {
                                    echoOff = echo(true);
                                } catch (IOException x10) {
                                    if (0 == 0) {
                                        ioe = new IOError(x10);
                                    } else {
                                        ioe.addSuppressed(x10);
                                    }
                                }
                                if (ioe != null) {
                                    throw ioe;
                                }
                                this.pw.println();
                            } catch (IOException x11) {
                                IOError ioe2 = new IOError(x11);
                                try {
                                    echoOff = echo(true);
                                    throw ioe2;
                                } catch (IOException x12) {
                                    ioe2.addSuppressed(x12);
                                    throw ioe2;
                                }
                            }
                        } catch (Throwable th) {
                            try {
                                echoOff = echo(true);
                            } catch (IOException x13) {
                                if (0 == 0) {
                                    ioe = new IOError(x13);
                                } else {
                                    ioe.addSuppressed(x13);
                                }
                            }
                            if (ioe != null) {
                                throw ioe;
                            }
                            throw th;
                        }
                    } catch (IOException x14) {
                        throw new IOError(x14);
                    }
                } catch (Throwable ioe3) {
                    throw ioe3;
                }
            }
        }
        return passwd;
    }

    public char[] readPassword() {
        return readPassword("", new Object[0]);
    }

    @Override // java.io.Flushable
    public void flush() {
        this.pw.flush();
    }

    private char[] readline(boolean zeroOut) throws IOException {
        Reader reader = this.reader;
        char[] cArr = this.rcb;
        int len = reader.read(cArr, 0, cArr.length);
        if (len < 0) {
            return null;
        }
        char[] cArr2 = this.rcb;
        if (cArr2[len - 1] == '\r') {
            len--;
        } else if (cArr2[len - 1] == '\n' && len - 1 > 0 && cArr2[len - 1] == '\r') {
            len--;
        }
        char[] b4 = new char[len];
        if (len > 0) {
            System.arraycopy((Object) cArr2, 0, (Object) b4, 0, len);
            if (zeroOut) {
                Arrays.fill(this.rcb, 0, len, ' ');
            }
        }
        return b4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public char[] grow() {
        char[] cArr = this.rcb;
        char[] t2 = new char[cArr.length * 2];
        System.arraycopy((Object) cArr, 0, (Object) t2, 0, cArr.length);
        this.rcb = t2;
        return t2;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    class LineReader extends Reader {
        private Reader in;

        /* renamed from: cb, reason: collision with root package name */
        private char[] f50351cb = new char[1024];
        private int nChars = 0;
        private int nextChar = 0;
        boolean leftoverLF = false;

        LineReader(Reader in) {
            this.in = in;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Reader
        public boolean ready() throws IOException {
            return this.in.ready();
        }

        /* JADX WARN: Code restructure failed: missing block: B:68:0x008c, code lost:
        
            if (r6 != r1) goto L59;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x0094, code lost:
        
            if (r13 != r12.this$0.rcb) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x0096, code lost:
        
            r13 = r12.this$0.grow();
            r5 = r13.length;
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x00a0, code lost:
        
            r12.leftoverLF = true;
            r0 = r6 - r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x00a5, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x00aa, code lost:
        
            if (r12.nextChar != r12.nChars) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x00b2, code lost:
        
            if (r12.in.ready() == false) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x00b4, code lost:
        
            r5 = r12.in;
            r7 = r12.f50351cb;
            r12.nChars = r5.read(r7, 0, r7.length);
            r12.nextChar = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x00c1, code lost:
        
            r5 = r12.nextChar;
         */
        /* JADX WARN: Code restructure failed: missing block: B:81:0x00c5, code lost:
        
            if (r5 >= r12.nChars) goto L73;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x00cb, code lost:
        
            if (r12.f50351cb[r5] != '\n') goto L73;
         */
        /* JADX WARN: Code restructure failed: missing block: B:84:0x00cd, code lost:
        
            r7 = r6 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:86:0x00cf, code lost:
        
            r13[r6] = '\n';
            r12.nextChar = r5 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x00d4, code lost:
        
            r0 = r7;
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x00da, code lost:
        
            r5 = r0 - r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x00dd, code lost:
        
            return r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:92:0x00d6, code lost:
        
            r3 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:95:0x0106, code lost:
        
            throw r3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:96:0x00d9, code lost:
        
            r0 = r6;
         */
        @Override // java.io.Reader
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int read(char[] r13, int r14, int r15) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 269
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: java.io.Console.LineReader.read(char[], int, int):int");
        }
    }

    public static Console console() {
        if (istty()) {
            if (cons == null) {
                cons = new Console();
            }
            return cons;
        }
        return null;
    }

    private Console() {
        this(new FileInputStream(FileDescriptor.in), new FileOutputStream(FileDescriptor.out));
    }

    private Console(InputStream inStream, OutputStream outStream) {
        this.readLock = new Object();
        this.writeLock = new Object();
        String csname = encoding();
        if (csname != null) {
            try {
                this.cs = Charset.forName(csname);
            } catch (Exception e2) {
            }
        }
        if (this.cs == null) {
            this.cs = Charset.defaultCharset();
        }
        StreamEncoder forOutputStreamWriter = StreamEncoder.forOutputStreamWriter(outStream, this.writeLock, this.cs);
        this.out = forOutputStreamWriter;
        this.pw = new PrintWriter(forOutputStreamWriter, true) { // from class: java.io.Console.1
            @Override // java.io.PrintWriter, java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }
        };
        this.formatter = new Formatter(this.out);
        this.reader = new LineReader(StreamDecoder.forInputStreamReader(inStream, this.readLock, this.cs));
        this.rcb = new char[1024];
    }
}
