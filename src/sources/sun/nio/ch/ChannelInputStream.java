package sun.nio.ch;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.IllegalBlockingModeException;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.channels.SelectableChannel;
import java.util.Objects;
import java.util.zip.ZipUtils;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ChannelInputStream extends InputStream {
    protected final ReadableByteChannel ch;

    /* renamed from: bb, reason: collision with root package name */
    private ByteBuffer f53716bb = null;
    private byte[] bs = null;

    /* renamed from: b1, reason: collision with root package name */
    private byte[] f53715b1 = null;

    /* JADX WARN: Multi-variable type inference failed */
    public static int read(ReadableByteChannel readableByteChannel, ByteBuffer bb2, boolean block) throws IOException {
        int n10;
        if (readableByteChannel instanceof SelectableChannel) {
            SelectableChannel sc2 = (SelectableChannel) readableByteChannel;
            synchronized (sc2.blockingLock()) {
                boolean bm = sc2.isBlocking();
                if (!bm) {
                    throw new IllegalBlockingModeException();
                }
                if (bm != block) {
                    sc2.configureBlocking(block);
                }
                n10 = readableByteChannel.read(bb2);
                if (bm != block) {
                    sc2.configureBlocking(bm);
                }
            }
            return n10;
        }
        return readableByteChannel.read(bb2);
    }

    public ChannelInputStream(ReadableByteChannel ch) {
        this.ch = ch;
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        if (this.f53715b1 == null) {
            this.f53715b1 = new byte[1];
        }
        int n10 = read(this.f53715b1);
        if (n10 != 1) {
            return -1;
        }
        return this.f53715b1[0] & 255;
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bs, int off, int len) throws IOException {
        ByteBuffer bb2;
        Objects.checkFromIndexSize(off, len, bs.length);
        if (len == 0) {
            return 0;
        }
        if (this.bs == bs) {
            bb2 = this.f53716bb;
        } else {
            bb2 = ByteBuffer.wrap(bs);
        }
        bb2.limit(Math.min(off + len, bb2.capacity()));
        bb2.position(off);
        this.f53716bb = bb2;
        this.bs = bs;
        return read(bb2);
    }

    protected int read(ByteBuffer bb2) throws IOException {
        return read(this.ch, bb2, true);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        ReadableByteChannel readableByteChannel = this.ch;
        if (readableByteChannel instanceof SeekableByteChannel) {
            SeekableByteChannel sbc = (SeekableByteChannel) readableByteChannel;
            long rem = Math.max(0L, sbc.size() - sbc.position());
            if (rem > ZipUtils.UPPER_UNIXTIME_BOUND) {
                return Integer.MAX_VALUE;
            }
            return (int) rem;
        }
        return 0;
    }

    @Override // java.io.InputStream
    public synchronized long skip(long n10) throws IOException {
        long newPos;
        ReadableByteChannel readableByteChannel = this.ch;
        if (readableByteChannel instanceof SeekableByteChannel) {
            SeekableByteChannel sbc = (SeekableByteChannel) readableByteChannel;
            long pos = sbc.position();
            if (n10 > 0) {
                newPos = pos + n10;
                long size = sbc.size();
                if (newPos < 0 || newPos > size) {
                    newPos = size;
                }
            } else {
                long newPos2 = pos + n10;
                newPos = Long.max(newPos2, 0L);
            }
            sbc.position(newPos);
            return newPos - pos;
        }
        return super.skip(n10);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.ch.close();
    }
}
