package java.util.zip;

import java.lang.ref.Reference;
import java.nio.ByteBuffer;
import java.util.Objects;
import sun.nio.ch.DirectBuffer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class CRC32 implements Checksum {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int crc;

    private static native int update(int i10, int i11);

    private static native int updateByteBuffer0(int i10, long j10, int i11, int i12);

    private static native int updateBytes0(int i10, byte[] bArr, int i11, int i12);

    @Override // java.util.zip.Checksum
    public void update(int b4) {
        this.crc = update(this.crc, b4);
    }

    @Override // java.util.zip.Checksum
    public void update(byte[] b4, int off, int len) {
        if (b4 == null) {
            throw new NullPointerException();
        }
        if (off < 0 || len < 0 || off > b4.length - len) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.crc = updateBytes(this.crc, b4, off, len);
    }

    @Override // java.util.zip.Checksum
    public void update(byte[] b4) {
        this.crc = updateBytes(this.crc, b4, 0, b4.length);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.zip.Checksum
    public void update(ByteBuffer byteBuffer) {
        int pos = byteBuffer.position();
        int limit = byteBuffer.limit();
        int rem = limit - pos;
        if (rem <= 0) {
            return;
        }
        if (byteBuffer.isDirect()) {
            try {
                this.crc = updateByteBuffer(this.crc, ((DirectBuffer) byteBuffer).address(), pos, rem);
            } finally {
                Reference.reachabilityFence(byteBuffer);
            }
        } else if (byteBuffer.hasArray()) {
            this.crc = updateBytes(this.crc, byteBuffer.array(), byteBuffer.arrayOffset() + pos, rem);
        } else {
            byte[] b4 = new byte[Math.min(byteBuffer.remaining(), 4096)];
            while (byteBuffer.hasRemaining()) {
                int length = Math.min(byteBuffer.remaining(), b4.length);
                byteBuffer.get(b4, 0, length);
                update(b4, 0, length);
            }
        }
        byteBuffer.position(limit);
    }

    @Override // java.util.zip.Checksum
    public void reset() {
        this.crc = 0;
    }

    @Override // java.util.zip.Checksum
    public long getValue() {
        return this.crc & 4294967295L;
    }

    private static int updateBytes(int crc, byte[] b4, int off, int len) {
        updateBytesCheck(b4, off, len);
        return updateBytes0(crc, b4, off, len);
    }

    private static void updateBytesCheck(byte[] b4, int off, int len) {
        if (len <= 0) {
            return;
        }
        Objects.requireNonNull(b4);
        if (off < 0 || off >= b4.length) {
            throw new ArrayIndexOutOfBoundsException(off);
        }
        int endIndex = (off + len) - 1;
        if (endIndex < 0 || endIndex >= b4.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
    }

    private static int updateByteBuffer(int alder, long addr, int off, int len) {
        updateByteBufferCheck(addr);
        return updateByteBuffer0(alder, addr, off, len);
    }

    private static void updateByteBufferCheck(long addr) {
        if (addr == 0) {
            throw new NullPointerException();
        }
    }
}
