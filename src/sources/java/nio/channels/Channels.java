package java.nio.channels;

import com.huawei.flexiblelayout.u0;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import sun.nio.ch.ChannelInputStream;
import sun.nio.cs.StreamDecoder;
import sun.nio.cs.StreamEncoder;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Channels {
    private Channels() {
        throw new Error("no instances");
    }

    private static void writeFullyImpl(WritableByteChannel ch, ByteBuffer bb2) throws IOException {
        while (bb2.remaining() > 0) {
            int n10 = ch.write(bb2);
            if (n10 <= 0) {
                throw new RuntimeException("no bytes written");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static void writeFully(WritableByteChannel writableByteChannel, ByteBuffer bb2) throws IOException {
        if (writableByteChannel instanceof SelectableChannel) {
            SelectableChannel sc2 = (SelectableChannel) writableByteChannel;
            synchronized (sc2.blockingLock()) {
                if (!sc2.isBlocking()) {
                    throw new IllegalBlockingModeException();
                }
                writeFullyImpl(writableByteChannel, bb2);
            }
            return;
        }
        writeFullyImpl(writableByteChannel, bb2);
    }

    public static InputStream newInputStream(ReadableByteChannel ch) {
        Objects.requireNonNull(ch, "ch");
        return new ChannelInputStream(ch);
    }

    public static OutputStream newOutputStream(final WritableByteChannel ch) {
        Objects.requireNonNull(ch, "ch");
        return new OutputStream() { // from class: java.nio.channels.Channels.1

            /* renamed from: b1, reason: collision with root package name */
            private byte[] f50385b1;

            /* renamed from: bb, reason: collision with root package name */
            private ByteBuffer f50386bb;
            private byte[] bs;

            @Override // java.io.OutputStream
            public synchronized void write(int b4) throws IOException {
                if (this.f50385b1 == null) {
                    this.f50385b1 = new byte[1];
                }
                byte[] bArr = this.f50385b1;
                bArr[0] = (byte) b4;
                write(bArr);
            }

            @Override // java.io.OutputStream
            public synchronized void write(byte[] bs, int off, int len) throws IOException {
                ByteBuffer bb2;
                if (off >= 0) {
                    if (off <= bs.length && len >= 0 && off + len <= bs.length && off + len >= 0) {
                        if (len == 0) {
                            return;
                        }
                        if (this.bs == bs) {
                            bb2 = this.f50386bb;
                        } else {
                            bb2 = ByteBuffer.wrap(bs);
                        }
                        bb2.limit(Math.min(off + len, bb2.capacity()));
                        bb2.position(off);
                        this.f50386bb = bb2;
                        this.bs = bs;
                        Channels.writeFully(WritableByteChannel.this, bb2);
                        return;
                    }
                }
                throw new IndexOutOfBoundsException();
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                WritableByteChannel.this.close();
            }
        };
    }

    public static InputStream newInputStream(final AsynchronousByteChannel ch) {
        Objects.requireNonNull(ch, "ch");
        return new InputStream() { // from class: java.nio.channels.Channels.2

            /* renamed from: b1, reason: collision with root package name */
            private byte[] f50387b1;

            /* renamed from: bb, reason: collision with root package name */
            private ByteBuffer f50388bb;
            private byte[] bs;

            @Override // java.io.InputStream
            public synchronized int read() throws IOException {
                if (this.f50387b1 == null) {
                    this.f50387b1 = new byte[1];
                }
                int n10 = read(this.f50387b1);
                if (n10 != 1) {
                    return -1;
                }
                return this.f50387b1[0] & 255;
            }

            @Override // java.io.InputStream
            public synchronized int read(byte[] bs, int off, int len) throws IOException {
                ByteBuffer bb2;
                int intValue;
                if (off >= 0) {
                    if (off <= bs.length && len >= 0 && off + len <= bs.length && off + len >= 0) {
                        if (len == 0) {
                            return 0;
                        }
                        if (this.bs == bs) {
                            bb2 = this.f50388bb;
                        } else {
                            bb2 = ByteBuffer.wrap(bs);
                        }
                        bb2.position(off);
                        bb2.limit(Math.min(off + len, bb2.capacity()));
                        this.f50388bb = bb2;
                        this.bs = bs;
                        boolean interrupted = false;
                        while (true) {
                            try {
                                try {
                                    intValue = AsynchronousByteChannel.this.read(bb2).get().intValue();
                                    break;
                                } catch (InterruptedException e2) {
                                    interrupted = true;
                                } catch (ExecutionException ee2) {
                                    throw new IOException(ee2.getCause());
                                }
                            } finally {
                                if (interrupted) {
                                    Thread.currentThread().interrupt();
                                }
                            }
                        }
                        return intValue;
                    }
                }
                throw new IndexOutOfBoundsException();
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                AsynchronousByteChannel.this.close();
            }
        };
    }

    public static OutputStream newOutputStream(final AsynchronousByteChannel ch) {
        Objects.requireNonNull(ch, "ch");
        return new OutputStream() { // from class: java.nio.channels.Channels.3

            /* renamed from: b1, reason: collision with root package name */
            private byte[] f50389b1;

            /* renamed from: bb, reason: collision with root package name */
            private ByteBuffer f50390bb;
            private byte[] bs;

            @Override // java.io.OutputStream
            public synchronized void write(int b4) throws IOException {
                if (this.f50389b1 == null) {
                    this.f50389b1 = new byte[1];
                }
                byte[] bArr = this.f50389b1;
                bArr[0] = (byte) b4;
                write(bArr);
            }

            @Override // java.io.OutputStream
            public synchronized void write(byte[] bs, int off, int len) throws IOException {
                ByteBuffer bb2;
                if (off >= 0) {
                    if (off <= bs.length && len >= 0 && off + len <= bs.length && off + len >= 0) {
                        if (len == 0) {
                            return;
                        }
                        if (this.bs == bs) {
                            bb2 = this.f50390bb;
                        } else {
                            bb2 = ByteBuffer.wrap(bs);
                        }
                        bb2.limit(Math.min(off + len, bb2.capacity()));
                        bb2.position(off);
                        this.f50390bb = bb2;
                        this.bs = bs;
                        boolean interrupted = false;
                        while (bb2.remaining() > 0) {
                            try {
                                try {
                                    AsynchronousByteChannel.this.write(bb2).get();
                                } catch (InterruptedException e2) {
                                    interrupted = true;
                                } catch (ExecutionException ee2) {
                                    throw new IOException(ee2.getCause());
                                } catch (Throwable th) {
                                    th = th;
                                    if (interrupted) {
                                        Thread.currentThread().interrupt();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                        if (interrupted) {
                            Thread.currentThread().interrupt();
                        }
                        return;
                    }
                }
                throw new IndexOutOfBoundsException();
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                AsynchronousByteChannel.this.close();
            }
        };
    }

    public static ReadableByteChannel newChannel(InputStream in) {
        Objects.requireNonNull(in, u0.f28637e);
        if (in.getClass() == FileInputStream.class) {
            return ((FileInputStream) in).getChannel();
        }
        return new ReadableByteChannelImpl(in);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class ReadableByteChannelImpl extends AbstractInterruptibleChannel implements ReadableByteChannel {
        private static final int TRANSFER_SIZE = 8192;
        private final InputStream in;
        private byte[] buf = new byte[0];
        private final Object readLock = new Object();

        ReadableByteChannelImpl(InputStream in) {
            this.in = in;
        }

        @Override // java.nio.channels.ReadableByteChannel
        public int read(ByteBuffer dst) throws IOException {
            boolean z10;
            if (!isOpen()) {
                throw new ClosedChannelException();
            }
            int len = dst.remaining();
            int totalRead = 0;
            int bytesRead = 0;
            synchronized (this.readLock) {
                while (totalRead < len) {
                    try {
                        int bytesToRead = Math.min(len - totalRead, 8192);
                        if (this.buf.length < bytesToRead) {
                            this.buf = new byte[bytesToRead];
                        }
                        if (totalRead > 0 && this.in.available() <= 0) {
                            break;
                        }
                        begin();
                        bytesRead = this.in.read(this.buf, 0, bytesToRead);
                        end(bytesRead > 0);
                        if (bytesRead >= 0) {
                            totalRead += bytesRead;
                            dst.put(this.buf, 0, bytesRead);
                        }
                    } catch (Throwable th) {
                        if (bytesRead <= 0) {
                            z10 = false;
                        }
                        end(z10);
                        throw th;
                    } finally {
                    }
                }
                if (bytesRead >= 0 || totalRead != 0) {
                    return totalRead;
                }
                return -1;
            }
        }

        @Override // java.nio.channels.spi.AbstractInterruptibleChannel
        protected void implCloseChannel() throws IOException {
            this.in.close();
        }
    }

    public static WritableByteChannel newChannel(OutputStream out) {
        Objects.requireNonNull(out, "out");
        return new WritableByteChannelImpl(out);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class WritableByteChannelImpl extends AbstractInterruptibleChannel implements WritableByteChannel {
        private static final int TRANSFER_SIZE = 8192;
        private final OutputStream out;
        private byte[] buf = new byte[0];
        private final Object writeLock = new Object();

        WritableByteChannelImpl(OutputStream out) {
            this.out = out;
        }

        @Override // java.nio.channels.WritableByteChannel
        public int write(ByteBuffer src) throws IOException {
            if (!isOpen()) {
                throw new ClosedChannelException();
            }
            int len = src.remaining();
            int totalWritten = 0;
            synchronized (this.writeLock) {
                while (totalWritten < len) {
                    int bytesToWrite = Math.min(len - totalWritten, 8192);
                    if (this.buf.length < bytesToWrite) {
                        this.buf = new byte[bytesToWrite];
                    }
                    src.get(this.buf, 0, bytesToWrite);
                    try {
                        begin();
                        this.out.write(this.buf, 0, bytesToWrite);
                        if (bytesToWrite > 0) {
                            r5 = true;
                        }
                        end(r5);
                        totalWritten += bytesToWrite;
                    } catch (Throwable th) {
                        end(bytesToWrite > 0);
                        throw th;
                    }
                }
            }
            return totalWritten;
        }

        @Override // java.nio.channels.spi.AbstractInterruptibleChannel
        protected void implCloseChannel() throws IOException {
            this.out.close();
        }
    }

    public static Reader newReader(ReadableByteChannel ch, CharsetDecoder dec, int minBufferCap) {
        Objects.requireNonNull(ch, "ch");
        return StreamDecoder.forDecoder(ch, dec.reset(), minBufferCap);
    }

    public static Reader newReader(ReadableByteChannel ch, String csName) {
        Objects.requireNonNull(csName, "csName");
        return newReader(ch, Charset.forName(csName).newDecoder(), -1);
    }

    public static Reader newReader(ReadableByteChannel ch, Charset charset) {
        Objects.requireNonNull(charset, "charset");
        return newReader(ch, charset.newDecoder(), -1);
    }

    public static Writer newWriter(WritableByteChannel ch, CharsetEncoder enc, int minBufferCap) {
        Objects.requireNonNull(ch, "ch");
        return StreamEncoder.forEncoder(ch, enc.reset(), minBufferCap);
    }

    public static Writer newWriter(WritableByteChannel ch, String csName) {
        Objects.requireNonNull(csName, "csName");
        return newWriter(ch, Charset.forName(csName).newEncoder(), -1);
    }

    public static Writer newWriter(WritableByteChannel ch, Charset charset) {
        Objects.requireNonNull(charset, "charset");
        return newWriter(ch, charset.newEncoder(), -1);
    }
}
