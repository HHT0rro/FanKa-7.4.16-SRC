package sun.misc;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.security.CodeSigner;
import java.security.cert.Certificate;
import java.util.Arrays;
import java.util.jar.Manifest;
import sun.nio.ByteBuffered;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class Resource {
    private InputStream cis;

    public abstract URL getCodeSourceURL();

    public abstract int getContentLength() throws IOException;

    public abstract InputStream getInputStream() throws IOException;

    public abstract String getName();

    public abstract URL getURL();

    private synchronized InputStream cachedInputStream() throws IOException {
        if (this.cis == null) {
            this.cis = getInputStream();
        }
        return this.cis;
    }

    public byte[] getBytes() throws IOException {
        int len;
        int bytesToRead;
        InputStream in = cachedInputStream();
        boolean isInterrupted = Thread.interrupted();
        while (true) {
            try {
                len = getContentLength();
                break;
            } catch (InterruptedIOException e2) {
                Thread.interrupted();
                isInterrupted = true;
            }
        }
        try {
            byte[] b4 = new byte[0];
            if (len == -1) {
                len = Integer.MAX_VALUE;
            }
            int pos = 0;
            while (pos < len) {
                if (pos >= b4.length) {
                    bytesToRead = Math.min(len - pos, b4.length + 1024);
                    if (b4.length < pos + bytesToRead) {
                        b4 = Arrays.copyOf(b4, pos + bytesToRead);
                    }
                } else {
                    int bytesToRead2 = b4.length;
                    bytesToRead = bytesToRead2 - pos;
                }
                int cc2 = 0;
                try {
                    cc2 = in.read(b4, pos, bytesToRead);
                } catch (InterruptedIOException e10) {
                    Thread.interrupted();
                    isInterrupted = true;
                }
                if (cc2 < 0) {
                    if (len != Integer.MAX_VALUE) {
                        throw new EOFException("Detect premature EOF");
                    }
                    if (b4.length != pos) {
                        b4 = Arrays.copyOf(b4, pos);
                    }
                } else {
                    pos += cc2;
                }
            }
            try {
                in.close();
            } catch (InterruptedIOException e11) {
                isInterrupted = true;
            } catch (IOException e12) {
            }
            if (isInterrupted) {
                Thread.currentThread().interrupt();
            }
            return b4;
        } finally {
        }
    }

    public ByteBuffer getByteBuffer() throws IOException {
        Closeable cachedInputStream = cachedInputStream();
        if (cachedInputStream instanceof ByteBuffered) {
            return ((ByteBuffered) cachedInputStream).getByteBuffer();
        }
        return null;
    }

    public Manifest getManifest() throws IOException {
        return null;
    }

    public Certificate[] getCertificates() {
        return null;
    }

    public CodeSigner[] getCodeSigners() {
        return null;
    }
}
