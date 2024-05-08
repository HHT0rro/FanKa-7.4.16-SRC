package java.nio;

import java.io.FileDescriptor;
import sun.misc.Unsafe;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class MappedByteBuffer extends ByteBuffer {
    private static byte unused;

    /* renamed from: fd, reason: collision with root package name */
    private final FileDescriptor f50383fd;

    private native void force0(FileDescriptor fileDescriptor, long j10, long j11);

    private native boolean isLoaded0(long j10, long j11, int i10);

    private native void load0(long j10, long j11);

    @Override // java.nio.ByteBuffer, java.nio.Buffer
    public abstract ByteBuffer duplicate();

    @Override // java.nio.ByteBuffer, java.nio.Buffer
    public abstract ByteBuffer slice();

    @Override // java.nio.ByteBuffer, java.nio.Buffer
    public abstract MappedByteBuffer slice(int i10, int i11);

    /* JADX INFO: Access modifiers changed from: package-private */
    public MappedByteBuffer(int mark, int pos, int lim, int cap, FileDescriptor fd2) {
        super(mark, pos, lim, cap);
        this.f50383fd = fd2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MappedByteBuffer(int mark, int pos, int lim, int cap, byte[] buf, int offset) {
        super(mark, pos, lim, cap, buf, offset);
        this.f50383fd = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MappedByteBuffer(int mark, int pos, int lim, int cap) {
        super(mark, pos, lim, cap);
        this.f50383fd = null;
    }

    private void checkMapped() {
        if (this.f50383fd == null) {
            throw new UnsupportedOperationException();
        }
    }

    private long mappingOffset() {
        int ps = Bits.pageSize();
        long offset = this.address % ps;
        return offset >= 0 ? offset : ps + offset;
    }

    private long mappingAddress(long mappingOffset) {
        return this.address - mappingOffset;
    }

    private long mappingLength(long mappingOffset) {
        return capacity() + mappingOffset;
    }

    public final boolean isLoaded() {
        checkMapped();
        if (this.address == 0 || capacity() == 0) {
            return true;
        }
        long offset = mappingOffset();
        long length = mappingLength(offset);
        return isLoaded0(mappingAddress(offset), length, Bits.pageCount(length));
    }

    public final MappedByteBuffer load() {
        checkMapped();
        if (this.address == 0 || capacity() == 0) {
            return this;
        }
        long offset = mappingOffset();
        long length = mappingLength(offset);
        load0(mappingAddress(offset), length);
        Unsafe unsafe = Unsafe.getUnsafe();
        int ps = Bits.pageSize();
        int count = Bits.pageCount(length);
        long a10 = mappingAddress(offset);
        byte x10 = 0;
        for (int i10 = 0; i10 < count; i10++) {
            x10 = (byte) (unsafe.getByte(a10) ^ x10);
            a10 += ps;
        }
        int i11 = unused;
        if (i11 != 0) {
            unused = x10;
        }
        return this;
    }

    public final MappedByteBuffer force() {
        checkMapped();
        if (this.address != 0 && capacity() != 0) {
            long offset = mappingOffset();
            force0(this.f50383fd, mappingAddress(offset), mappingLength(offset));
        }
        return this;
    }
}
