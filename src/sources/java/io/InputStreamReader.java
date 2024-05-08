package java.io;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import sun.nio.cs.StreamDecoder;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class InputStreamReader extends Reader {

    /* renamed from: sd, reason: collision with root package name */
    private final StreamDecoder f50354sd;

    public InputStreamReader(InputStream in) {
        super(in);
        this.f50354sd = StreamDecoder.forInputStreamReader(in, this, Charset.defaultCharset());
    }

    public InputStreamReader(InputStream in, String charsetName) throws UnsupportedEncodingException {
        super(in);
        if (charsetName == null) {
            throw new NullPointerException("charsetName");
        }
        this.f50354sd = StreamDecoder.forInputStreamReader(in, this, charsetName);
    }

    public InputStreamReader(InputStream in, Charset cs) {
        super(in);
        if (cs == null) {
            throw new NullPointerException("charset");
        }
        this.f50354sd = StreamDecoder.forInputStreamReader(in, this, cs);
    }

    public InputStreamReader(InputStream in, CharsetDecoder dec) {
        super(in);
        if (dec == null) {
            throw new NullPointerException("charset decoder");
        }
        this.f50354sd = StreamDecoder.forInputStreamReader(in, this, dec);
    }

    public String getEncoding() {
        return this.f50354sd.getEncoding();
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        return this.f50354sd.read();
    }

    @Override // java.io.Reader
    public int read(char[] cbuf, int offset, int length) throws IOException {
        return this.f50354sd.read(cbuf, offset, length);
    }

    @Override // java.io.Reader
    public boolean ready() throws IOException {
        return this.f50354sd.ready();
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f50354sd.close();
    }
}
