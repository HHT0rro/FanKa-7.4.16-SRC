package java.io;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import sun.nio.cs.StreamEncoder;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class OutputStreamWriter extends Writer {
    private final StreamEncoder se;

    public OutputStreamWriter(OutputStream out, String charsetName) throws UnsupportedEncodingException {
        super(out);
        if (charsetName == null) {
            throw new NullPointerException("charsetName");
        }
        this.se = StreamEncoder.forOutputStreamWriter(out, this, charsetName);
    }

    public OutputStreamWriter(OutputStream out) {
        super(out);
        try {
            this.se = StreamEncoder.forOutputStreamWriter(out, this, (String) null);
        } catch (UnsupportedEncodingException e2) {
            throw new Error(e2);
        }
    }

    public OutputStreamWriter(OutputStream out, Charset cs) {
        super(out);
        if (cs == null) {
            throw new NullPointerException("charset");
        }
        this.se = StreamEncoder.forOutputStreamWriter(out, this, cs);
    }

    public OutputStreamWriter(OutputStream out, CharsetEncoder enc) {
        super(out);
        if (enc == null) {
            throw new NullPointerException("charset encoder");
        }
        this.se = StreamEncoder.forOutputStreamWriter(out, this, enc);
    }

    public String getEncoding() {
        return this.se.getEncoding();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void flushBuffer() throws IOException {
        this.se.flushBuffer();
    }

    @Override // java.io.Writer
    public void write(int c4) throws IOException {
        this.se.write(c4);
    }

    @Override // java.io.Writer
    public void write(char[] cbuf, int off, int len) throws IOException {
        this.se.write(cbuf, off, len);
    }

    @Override // java.io.Writer
    public void write(String str, int off, int len) throws IOException {
        this.se.write(str, off, len);
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        this.se.flush();
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.se.close();
    }
}
