package sun.nio.cs;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.IllegalCharsetNameException;
import sun.nio.ch.ChannelInputStream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class StreamDecoder extends Reader {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int DEFAULT_BYTE_BUFFER_SIZE = 8192;
    private static final int MIN_BYTE_BUFFER_SIZE = 32;
    private static volatile boolean channelsAvailable = true;

    /* renamed from: bb, reason: collision with root package name */
    private ByteBuffer f53736bb;
    private ReadableByteChannel ch;
    private Charset cs;
    private CharsetDecoder decoder;
    private boolean haveLeftoverChar;
    private InputStream in;
    private volatile boolean isOpen;
    private char leftoverChar;
    private boolean needsFlush;

    private void ensureOpen() throws IOException {
        if (!this.isOpen) {
            throw new IOException("Stream closed");
        }
    }

    public static StreamDecoder forInputStreamReader(InputStream in, Object lock, String charsetName) throws UnsupportedEncodingException {
        String csn = charsetName;
        if (csn == null) {
            csn = Charset.defaultCharset().name();
        }
        try {
            if (Charset.isSupported(csn)) {
                return new StreamDecoder(in, lock, Charset.forName(csn));
            }
        } catch (IllegalCharsetNameException e2) {
        }
        throw new UnsupportedEncodingException(csn);
    }

    public static StreamDecoder forInputStreamReader(InputStream in, Object lock, Charset cs) {
        return new StreamDecoder(in, lock, cs);
    }

    public static StreamDecoder forInputStreamReader(InputStream in, Object lock, CharsetDecoder dec) {
        return new StreamDecoder(in, lock, dec);
    }

    public static StreamDecoder forDecoder(ReadableByteChannel ch, CharsetDecoder dec, int minBufferCap) {
        return new StreamDecoder(ch, dec, minBufferCap);
    }

    public String getEncoding() {
        if (isOpen()) {
            return encodingName();
        }
        return null;
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        return read0();
    }

    private int read0() throws IOException {
        synchronized (this.lock) {
            if (this.haveLeftoverChar) {
                this.haveLeftoverChar = false;
                return this.leftoverChar;
            }
            char[] cb2 = new char[2];
            int n10 = read(cb2, 0, 2);
            switch (n10) {
                case -1:
                    return -1;
                case 0:
                default:
                    return -1;
                case 1:
                    break;
                case 2:
                    this.leftoverChar = cb2[1];
                    this.haveLeftoverChar = true;
                    break;
            }
            return cb2[0];
        }
    }

    @Override // java.io.Reader
    public int read(char[] cbuf, int offset, int length) throws IOException {
        int off = offset;
        int len = length;
        synchronized (this.lock) {
            ensureOpen();
            if (off < 0 || off > cbuf.length || len < 0 || off + len > cbuf.length || off + len < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (len == 0) {
                return 0;
            }
            int n10 = 0;
            if (this.haveLeftoverChar) {
                cbuf[off] = this.leftoverChar;
                off++;
                len--;
                this.haveLeftoverChar = false;
                n10 = 1;
                if (len == 0 || !implReady()) {
                    return 1;
                }
            }
            if (len == 1) {
                int c4 = read0();
                int i10 = -1;
                if (c4 == -1) {
                    if (n10 != 0) {
                        i10 = n10;
                    }
                    return i10;
                }
                cbuf[off] = (char) c4;
                return n10 + 1;
            }
            return implRead(cbuf, off, off + len) + n10;
        }
    }

    @Override // java.io.Reader
    public boolean ready() throws IOException {
        boolean z10;
        synchronized (this.lock) {
            ensureOpen();
            z10 = this.haveLeftoverChar || implReady();
        }
        return z10;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.lock) {
            if (this.isOpen) {
                implClose();
                this.isOpen = false;
            }
        }
    }

    private boolean isOpen() {
        return this.isOpen;
    }

    private static FileChannel getChannel(FileInputStream in) {
        if (!channelsAvailable) {
            return null;
        }
        try {
            return in.getChannel();
        } catch (UnsatisfiedLinkError e2) {
            channelsAvailable = false;
            return null;
        }
    }

    StreamDecoder(InputStream in, Object lock, Charset cs) {
        this(in, lock, cs.newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE));
    }

    StreamDecoder(InputStream in, Object lock, CharsetDecoder dec) {
        super(lock);
        this.isOpen = true;
        this.haveLeftoverChar = false;
        this.needsFlush = false;
        this.cs = dec.charset();
        this.decoder = dec;
        if (this.ch == null) {
            this.in = in;
            this.ch = null;
            this.f53736bb = ByteBuffer.allocate(8192);
        }
        this.f53736bb.flip();
    }

    StreamDecoder(ReadableByteChannel ch, CharsetDecoder dec, int mbc) {
        int i10;
        this.isOpen = true;
        this.haveLeftoverChar = false;
        this.needsFlush = false;
        this.in = null;
        this.ch = ch;
        this.decoder = dec;
        this.cs = dec.charset();
        if (mbc < 0) {
            i10 = 8192;
        } else {
            i10 = 32;
            if (mbc >= 32) {
                i10 = mbc;
            }
        }
        ByteBuffer allocate = ByteBuffer.allocate(i10);
        this.f53736bb = allocate;
        allocate.flip();
    }

    private int readBytes() throws IOException {
        this.f53736bb.compact();
        try {
            ReadableByteChannel readableByteChannel = this.ch;
            if (readableByteChannel != null) {
                int n10 = ChannelInputStream.read(readableByteChannel, this.f53736bb, true);
                if (n10 < 0) {
                    return n10;
                }
            } else {
                int lim = this.f53736bb.limit();
                int pos = this.f53736bb.position();
                int rem = pos <= lim ? lim - pos : 0;
                int n11 = this.in.read(this.f53736bb.array(), this.f53736bb.arrayOffset() + pos, rem);
                if (n11 < 0) {
                    return n11;
                }
                if (n11 == 0) {
                    throw new IOException("Underlying input stream returned zero bytes");
                }
                this.f53736bb.position(pos + n11);
            }
            this.f53736bb.flip();
            int rem2 = this.f53736bb.remaining();
            return rem2;
        } finally {
            this.f53736bb.flip();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0073, code lost:
    
        r3 = r5.decoder.flush(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007d, code lost:
    
        if (r3.isOverflow() == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007f, code lost:
    
        r5.needsFlush = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0086, code lost:
    
        return r0.position();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0087, code lost:
    
        r5.decoder.reset();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0090, code lost:
    
        if (r3.isUnderflow() != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0092, code lost:
    
        r3.throwException();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    int implRead(char[] r6, int r7, int r8) throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r8 - r7
            java.nio.CharBuffer r0 = java.nio.CharBuffer.wrap(r6, r7, r0)
            int r1 = r0.position()
            if (r1 == 0) goto L11
            java.nio.CharBuffer r0 = r0.slice()
        L11:
            boolean r1 = r5.needsFlush
            r2 = -1
            if (r1 == 0) goto L3c
            java.nio.charset.CharsetDecoder r1 = r5.decoder
            java.nio.charset.CoderResult r1 = r1.flush(r0)
            boolean r3 = r1.isOverflow()
            if (r3 == 0) goto L27
            int r2 = r0.position()
            return r2
        L27:
            boolean r3 = r1.isUnderflow()
            if (r3 == 0) goto L39
            int r3 = r0.position()
            if (r3 != 0) goto L34
            return r2
        L34:
            int r2 = r0.position()
            return r2
        L39:
            r1.throwException()
        L3c:
            r1 = 0
        L3d:
            java.nio.charset.CharsetDecoder r3 = r5.decoder
            java.nio.ByteBuffer r4 = r5.f53736bb
            java.nio.charset.CoderResult r3 = r3.decode(r4, r0, r1)
            boolean r4 = r3.isUnderflow()
            if (r4 == 0) goto L6a
            if (r1 == 0) goto L4e
            goto L71
        L4e:
            boolean r4 = r0.hasRemaining()
            if (r4 != 0) goto L55
            goto L71
        L55:
            int r4 = r0.position()
            if (r4 <= 0) goto L62
            boolean r4 = r5.inReady()
            if (r4 != 0) goto L62
            goto L71
        L62:
            int r4 = r5.readBytes()
            if (r4 >= 0) goto L3d
            r1 = 1
            goto L3d
        L6a:
            boolean r4 = r3.isOverflow()
            if (r4 == 0) goto La4
        L71:
            if (r1 == 0) goto L95
            java.nio.charset.CharsetDecoder r3 = r5.decoder
            java.nio.charset.CoderResult r3 = r3.flush(r0)
            boolean r4 = r3.isOverflow()
            if (r4 == 0) goto L87
            r2 = 1
            r5.needsFlush = r2
            int r2 = r0.position()
            return r2
        L87:
            java.nio.charset.CharsetDecoder r4 = r5.decoder
            r4.reset()
            boolean r4 = r3.isUnderflow()
            if (r4 != 0) goto L95
            r3.throwException()
        L95:
            int r3 = r0.position()
            if (r3 != 0) goto L9f
            if (r1 == 0) goto L9e
            return r2
        L9e:
        L9f:
            int r2 = r0.position()
            return r2
        La4:
            r3.throwException()
            goto L3d
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.cs.StreamDecoder.implRead(char[], int, int):int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    String encodingName() {
        Charset charset = this.cs;
        if (charset instanceof HistoricallyNamedCharset) {
            return ((HistoricallyNamedCharset) charset).historicalName();
        }
        return charset.name();
    }

    private boolean inReady() {
        try {
            InputStream inputStream = this.in;
            if (inputStream == null || inputStream.available() <= 0) {
                if (!(this.ch instanceof FileChannel)) {
                    return false;
                }
            }
            return true;
        } catch (IOException e2) {
            return false;
        }
    }

    boolean implReady() {
        return this.f53736bb.hasRemaining() || inReady();
    }

    void implClose() throws IOException {
        ReadableByteChannel readableByteChannel = this.ch;
        if (readableByteChannel != null) {
            readableByteChannel.close();
        } else {
            this.in.close();
        }
    }
}
