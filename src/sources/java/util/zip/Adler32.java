package java.util.zip;

import java.lang.ref.Reference;
import java.nio.ByteBuffer;
import sun.nio.ch.DirectBuffer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Adler32 implements Checksum {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int adler = 1;

    private static native int update(int i10, int i11);

    private static native int updateByteBuffer(int i10, long j10, int i11, int i12);

    private static native int updateBytes(int i10, byte[] bArr, int i11, int i12);

    @Override // java.util.zip.Checksum
    public void update(int b4) {
        this.adler = update(this.adler, b4);
    }

    @Override // java.util.zip.Checksum
    public void update(byte[] b4, int off, int len) {
        if (b4 == null) {
            throw new NullPointerException();
        }
        if (off < 0 || len < 0 || off > b4.length - len) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.adler = updateBytes(this.adler, b4, off, len);
    }

    @Override // java.util.zip.Checksum
    public void update(byte[] b4) {
        this.adler = updateBytes(this.adler, b4, 0, b4.length);
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
                this.adler = updateByteBuffer(this.adler, ((DirectBuffer) byteBuffer).address(), pos, rem);
            } finally {
                Reference.reachabilityFence(byteBuffer);
            }
        } else if (byteBuffer.hasArray()) {
            this.adler = updateBytes(this.adler, byteBuffer.array(), byteBuffer.arrayOffset() + pos, rem);
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
        this.adler = 1;
    }

    @Override // java.util.zip.Checksum
    public long getValue() {
        return this.adler & 4294967295L;
    }
}
