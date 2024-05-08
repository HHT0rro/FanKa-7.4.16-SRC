package java.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class InputStream implements Closeable {
    private static final int DEFAULT_BUFFER_SIZE = 8192;
    private static final int MAX_BUFFER_SIZE = 2147483639;
    private static final int MAX_SKIP_BUFFER_SIZE = 2048;

    public abstract int read() throws IOException;

    public static InputStream nullInputStream() {
        return new InputStream() { // from class: java.io.InputStream.1
            private volatile boolean closed;

            private void ensureOpen() throws IOException {
                if (this.closed) {
                    throw new IOException("Stream closed");
                }
            }

            @Override // java.io.InputStream
            public int available() throws IOException {
                ensureOpen();
                return 0;
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                ensureOpen();
                return -1;
            }

            @Override // java.io.InputStream
            public int read(byte[] b4, int off, int len) throws IOException {
                Objects.checkFromIndexSize(off, len, b4.length);
                if (len == 0) {
                    return 0;
                }
                ensureOpen();
                return -1;
            }

            @Override // java.io.InputStream
            public byte[] readAllBytes() throws IOException {
                ensureOpen();
                return new byte[0];
            }

            @Override // java.io.InputStream
            public int readNBytes(byte[] b4, int off, int len) throws IOException {
                Objects.checkFromIndexSize(off, len, b4.length);
                ensureOpen();
                return 0;
            }

            @Override // java.io.InputStream
            public byte[] readNBytes(int len) throws IOException {
                if (len < 0) {
                    throw new IllegalArgumentException("len < 0");
                }
                ensureOpen();
                return new byte[0];
            }

            @Override // java.io.InputStream
            public long skip(long n10) throws IOException {
                ensureOpen();
                return 0L;
            }

            @Override // java.io.InputStream
            public void skipNBytes(long n10) throws IOException {
                ensureOpen();
                if (n10 > 0) {
                    throw new EOFException();
                }
            }

            @Override // java.io.InputStream
            public long transferTo(OutputStream out) throws IOException {
                Objects.requireNonNull(out);
                ensureOpen();
                return 0L;
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                this.closed = true;
            }
        };
    }

    public int read(byte[] b4) throws IOException {
        return read(b4, 0, b4.length);
    }

    public int read(byte[] b4, int off, int len) throws IOException {
        Objects.checkFromIndexSize(off, len, b4.length);
        if (len == 0) {
            return 0;
        }
        int c4 = read();
        if (c4 == -1) {
            return -1;
        }
        b4[off] = (byte) c4;
        int i10 = 1;
        while (i10 < len) {
            try {
                int c10 = read();
                if (c10 == -1) {
                    break;
                }
                b4[off + i10] = (byte) c10;
                i10++;
            } catch (IOException e2) {
            }
        }
        return i10;
    }

    public byte[] readAllBytes() throws IOException {
        return readNBytes(Integer.MAX_VALUE);
    }

    public byte[] readNBytes(int len) throws IOException {
        int n10;
        if (len < 0) {
            throw new IllegalArgumentException("len < 0");
        }
        List<byte[]> bufs = null;
        byte[] result = null;
        int total = 0;
        int remaining = len;
        do {
            byte[] buf = new byte[Math.min(remaining, 8192)];
            int nread = 0;
            while (true) {
                n10 = read(buf, nread, Math.min(buf.length - nread, remaining));
                if (n10 <= 0) {
                    break;
                }
                nread += n10;
                remaining -= n10;
            }
            if (nread > 0) {
                if (2147483639 - total < nread) {
                    throw new OutOfMemoryError("Required array size too large");
                }
                if (nread < buf.length) {
                    buf = Arrays.copyOfRange(buf, 0, nread);
                }
                total += nread;
                if (result == null) {
                    result = buf;
                } else {
                    if (bufs == null) {
                        bufs = new ArrayList<>();
                        bufs.add(result);
                    }
                    bufs.add(buf);
                }
            }
            if (n10 < 0) {
                break;
            }
        } while (remaining > 0);
        if (bufs == null) {
            if (result == null) {
                return new byte[0];
            }
            return result.length == total ? result : Arrays.copyOf(result, total);
        }
        byte[] result2 = new byte[total];
        int offset = 0;
        int remaining2 = total;
        for (byte[] b4 : bufs) {
            int count = Math.min(b4.length, remaining2);
            System.arraycopy((Object) b4, 0, (Object) result2, offset, count);
            offset += count;
            remaining2 -= count;
        }
        return result2;
    }

    public int readNBytes(byte[] b4, int off, int len) throws IOException {
        Objects.checkFromIndexSize(off, len, b4.length);
        int n10 = 0;
        while (n10 < len) {
            int count = read(b4, off + n10, len - n10);
            if (count < 0) {
                break;
            }
            n10 += count;
        }
        return n10;
    }

    public long skip(long n10) throws IOException {
        int nr;
        long remaining = n10;
        if (n10 <= 0) {
            return 0L;
        }
        int size = (int) Math.min(2048L, remaining);
        byte[] skipBuffer = new byte[size];
        while (remaining > 0 && (nr = read(skipBuffer, 0, (int) Math.min(size, remaining))) >= 0) {
            remaining -= nr;
        }
        return n10 - remaining;
    }

    public void skipNBytes(long n10) throws IOException {
        while (n10 > 0) {
            long ns = skip(n10);
            if (ns > 0 && ns <= n10) {
                n10 -= ns;
            } else if (ns == 0) {
                if (read() == -1) {
                    throw new EOFException();
                }
                n10--;
            } else {
                throw new IOException("Unable to skip exactly");
            }
        }
    }

    public int available() throws IOException {
        return 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    public synchronized void mark(int readlimit) {
    }

    public synchronized void reset() throws IOException {
        throw new IOException("mark/reset not supported");
    }

    public boolean markSupported() {
        return false;
    }

    public long transferTo(OutputStream out) throws IOException {
        Objects.requireNonNull(out, "out");
        long transferred = 0;
        byte[] buffer = new byte[8192];
        while (true) {
            int read = read(buffer, 0, 8192);
            if (read >= 0) {
                out.write(buffer, 0, read);
                transferred += read;
            } else {
                return transferred;
            }
        }
    }
}
