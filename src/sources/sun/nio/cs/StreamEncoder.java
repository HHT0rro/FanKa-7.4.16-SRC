package sun.nio.cs;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.IllegalCharsetNameException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class StreamEncoder extends Writer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int DEFAULT_BYTE_BUFFER_SIZE = 8192;

    /* renamed from: bb, reason: collision with root package name */
    private ByteBuffer f53737bb;
    private WritableByteChannel ch;
    private Charset cs;
    private CharsetEncoder encoder;
    private boolean haveLeftoverChar;
    private volatile boolean isOpen;
    private CharBuffer lcb;
    private char leftoverChar;
    private final OutputStream out;

    private void ensureOpen() throws IOException {
        if (!this.isOpen) {
            throw new IOException("Stream closed");
        }
    }

    public static StreamEncoder forOutputStreamWriter(OutputStream out, Object lock, String charsetName) throws UnsupportedEncodingException {
        String csn = charsetName;
        if (csn == null) {
            csn = Charset.defaultCharset().name();
        }
        try {
            if (Charset.isSupported(csn)) {
                return new StreamEncoder(out, lock, Charset.forName(csn));
            }
        } catch (IllegalCharsetNameException e2) {
        }
        throw new UnsupportedEncodingException(csn);
    }

    public static StreamEncoder forOutputStreamWriter(OutputStream out, Object lock, Charset cs) {
        return new StreamEncoder(out, lock, cs);
    }

    public static StreamEncoder forOutputStreamWriter(OutputStream out, Object lock, CharsetEncoder enc) {
        return new StreamEncoder(out, lock, enc);
    }

    public static StreamEncoder forEncoder(WritableByteChannel ch, CharsetEncoder enc, int minBufferCap) {
        return new StreamEncoder(ch, enc, minBufferCap);
    }

    public String getEncoding() {
        if (isOpen()) {
            return encodingName();
        }
        return null;
    }

    public void flushBuffer() throws IOException {
        synchronized (this.lock) {
            if (isOpen()) {
                implFlushBuffer();
            } else {
                throw new IOException("Stream closed");
            }
        }
    }

    @Override // java.io.Writer
    public void write(int c4) throws IOException {
        char[] cbuf = {(char) c4};
        write(cbuf, 0, 1);
    }

    @Override // java.io.Writer
    public void write(char[] cbuf, int off, int len) throws IOException {
        synchronized (this.lock) {
            ensureOpen();
            if (off < 0 || off > cbuf.length || len < 0 || off + len > cbuf.length || off + len < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (len == 0) {
                return;
            }
            implWrite(cbuf, off, len);
        }
    }

    @Override // java.io.Writer
    public void write(String str, int off, int len) throws IOException {
        if (len < 0) {
            throw new IndexOutOfBoundsException();
        }
        char[] cbuf = new char[len];
        str.getChars(off, off + len, cbuf, 0);
        write(cbuf, 0, len);
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        synchronized (this.lock) {
            ensureOpen();
            implFlush();
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
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

    private StreamEncoder(OutputStream out, Object lock, Charset cs) {
        this(out, lock, cs.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE));
    }

    private StreamEncoder(OutputStream out, Object lock, CharsetEncoder enc) {
        super(lock);
        this.isOpen = true;
        this.haveLeftoverChar = false;
        this.lcb = null;
        this.out = out;
        this.ch = null;
        this.cs = enc.charset();
        this.encoder = enc;
        if (this.ch == null) {
            this.f53737bb = ByteBuffer.allocate(8192);
        }
    }

    private StreamEncoder(WritableByteChannel ch, CharsetEncoder enc, int mbc) {
        int i10;
        this.isOpen = true;
        this.haveLeftoverChar = false;
        this.lcb = null;
        this.out = null;
        this.ch = ch;
        this.cs = enc.charset();
        this.encoder = enc;
        if (mbc < 0) {
            i10 = 8192;
        } else {
            i10 = mbc;
        }
        this.f53737bb = ByteBuffer.allocate(i10);
    }

    private void writeBytes() throws IOException {
        this.f53737bb.flip();
        int lim = this.f53737bb.limit();
        int pos = this.f53737bb.position();
        int rem = pos <= lim ? lim - pos : 0;
        if (rem > 0) {
            WritableByteChannel writableByteChannel = this.ch;
            if (writableByteChannel != null) {
                if (writableByteChannel.write(this.f53737bb) != rem) {
                }
            } else {
                this.out.write(this.f53737bb.array(), this.f53737bb.arrayOffset() + pos, rem);
            }
        }
        this.f53737bb.clear();
    }

    private void flushLeftoverChar(CharBuffer cb2, boolean endOfInput) throws IOException {
        if (!this.haveLeftoverChar && !endOfInput) {
            return;
        }
        CharBuffer charBuffer = this.lcb;
        if (charBuffer == null) {
            this.lcb = CharBuffer.allocate(2);
        } else {
            charBuffer.clear();
        }
        if (this.haveLeftoverChar) {
            this.lcb.put(this.leftoverChar);
        }
        if (cb2 != null && cb2.hasRemaining()) {
            this.lcb.put(cb2.get());
        }
        this.lcb.flip();
        while (true) {
            if (!this.lcb.hasRemaining() && !endOfInput) {
                break;
            }
            CoderResult cr = this.encoder.encode(this.lcb, this.f53737bb, endOfInput);
            if (cr.isUnderflow()) {
                if (this.lcb.hasRemaining()) {
                    this.leftoverChar = this.lcb.get();
                    if (cb2 != null && cb2.hasRemaining()) {
                        flushLeftoverChar(cb2, endOfInput);
                        return;
                    }
                    return;
                }
            } else if (cr.isOverflow()) {
                writeBytes();
            } else {
                cr.throwException();
            }
        }
        this.haveLeftoverChar = false;
    }

    void implWrite(char[] cbuf, int off, int len) throws IOException {
        CharBuffer cb2 = CharBuffer.wrap(cbuf, off, len);
        if (this.haveLeftoverChar) {
            flushLeftoverChar(cb2, false);
        }
        while (cb2.hasRemaining()) {
            CoderResult cr = this.encoder.encode(cb2, this.f53737bb, false);
            if (cr.isUnderflow()) {
                if (cb2.remaining() == 1) {
                    this.haveLeftoverChar = true;
                    this.leftoverChar = cb2.get();
                    return;
                }
                return;
            }
            if (cr.isOverflow()) {
                writeBytes();
            } else {
                cr.throwException();
            }
        }
    }

    void implFlushBuffer() throws IOException {
        if (this.f53737bb.position() > 0) {
            writeBytes();
        }
    }

    void implFlush() throws IOException {
        implFlushBuffer();
        OutputStream outputStream = this.out;
        if (outputStream != null) {
            outputStream.flush();
        }
    }

    void implClose() throws IOException {
        flushLeftoverChar(null, true);
        while (true) {
            try {
                CoderResult cr = this.encoder.flush(this.f53737bb);
                if (cr.isUnderflow()) {
                    break;
                } else if (cr.isOverflow()) {
                    writeBytes();
                } else {
                    cr.throwException();
                }
            } catch (IOException x10) {
                this.encoder.reset();
                throw x10;
            }
        }
        if (this.f53737bb.position() > 0) {
            writeBytes();
        }
        WritableByteChannel writableByteChannel = this.ch;
        if (writableByteChannel != null) {
            writableByteChannel.close();
        } else {
            this.out.close();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    String encodingName() {
        Charset charset = this.cs;
        if (charset instanceof HistoricallyNamedCharset) {
            return ((HistoricallyNamedCharset) charset).historicalName();
        }
        return charset.name();
    }
}
