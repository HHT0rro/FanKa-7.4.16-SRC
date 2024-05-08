package sun.nio.ch;

import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class IOUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int IOV_MAX = iovMax();

    public static native void configureBlocking(FileDescriptor fileDescriptor, boolean z10) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean drain(int i10) throws IOException;

    static native int fdLimit();

    public static native int fdVal(FileDescriptor fileDescriptor);

    static native int iovMax();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native long makePipe(boolean z10);

    static native boolean randomBytes(byte[] bArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void setfdVal(FileDescriptor fileDescriptor, int i10);

    private IOUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int write(FileDescriptor fd2, ByteBuffer src, long position, NativeDispatcher nd2) throws IOException {
        if (src instanceof DirectBuffer) {
            return writeFromNativeBuffer(fd2, src, position, nd2);
        }
        int pos = src.position();
        int lim = src.limit();
        int rem = pos <= lim ? lim - pos : 0;
        ByteBuffer bb2 = Util.getTemporaryDirectBuffer(rem);
        try {
            bb2.put(src);
            bb2.flip();
            src.position(pos);
            int n10 = writeFromNativeBuffer(fd2, bb2, position, nd2);
            if (n10 > 0) {
                src.position(pos + n10);
            }
            return n10;
        } finally {
            Util.offerFirstTemporaryDirectBuffer(bb2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static int writeFromNativeBuffer(FileDescriptor fd2, ByteBuffer byteBuffer, long position, NativeDispatcher nd2) throws IOException {
        int written;
        int pos = byteBuffer.position();
        int lim = byteBuffer.limit();
        int rem = pos <= lim ? lim - pos : 0;
        if (rem == 0) {
            return 0;
        }
        if (position != -1) {
            written = nd2.pwrite(fd2, pos + ((DirectBuffer) byteBuffer).address(), rem, position);
        } else {
            written = nd2.write(fd2, ((DirectBuffer) byteBuffer).address() + pos, rem);
        }
        if (written > 0) {
            byteBuffer.position(pos + written);
        }
        return written;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long write(FileDescriptor fd2, ByteBuffer[] bufs, NativeDispatcher nd2) throws IOException {
        return write(fd2, bufs, 0, bufs.length, nd2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long write(FileDescriptor fd2, ByteBuffer[] bufs, int offset, int length, NativeDispatcher nd2) throws IOException {
        IOVecWrapper vec = IOVecWrapper.get(length);
        int count = offset + length;
        int iov_len = 0;
        for (int iov_len2 = offset; iov_len2 < count; iov_len2++) {
            try {
                if (iov_len >= IOV_MAX) {
                    break;
                }
                ByteBuffer buf = bufs[iov_len2];
                int pos = buf.position();
                int lim = buf.limit();
                int rem = pos <= lim ? lim - pos : 0;
                if (rem > 0) {
                    vec.setBuffer(iov_len, buf, pos, rem);
                    if (!(buf instanceof DirectBuffer)) {
                        ByteBuffer shadow = Util.getTemporaryDirectBuffer(rem);
                        shadow.put(buf);
                        shadow.flip();
                        vec.setShadow(iov_len, shadow);
                        buf.position(pos);
                        buf = shadow;
                        pos = shadow.position();
                    }
                    vec.putBase(iov_len, ((DirectBuffer) buf).address() + pos);
                    vec.putLen(iov_len, rem);
                    iov_len++;
                }
            } finally {
                if (0 == 0) {
                    for (int j10 = 0; j10 < iov_len; j10++) {
                        ByteBuffer shadow2 = vec.getShadow(j10);
                        if (shadow2 != null) {
                            Util.offerLastTemporaryDirectBuffer(shadow2);
                        }
                        vec.clearRefs(j10);
                    }
                }
            }
        }
        long j11 = 0;
        if (iov_len == 0) {
            return 0L;
        }
        long bytesWritten = nd2.writev(fd2, vec.address, iov_len);
        long left = bytesWritten;
        int j12 = 0;
        while (j12 < iov_len) {
            if (left > j11) {
                ByteBuffer buf2 = vec.getBuffer(j12);
                int pos2 = vec.getPosition(j12);
                int rem2 = vec.getRemaining(j12);
                int n10 = left > ((long) rem2) ? rem2 : (int) left;
                buf2.position(pos2 + n10);
                left -= n10;
            }
            ByteBuffer shadow3 = vec.getShadow(j12);
            if (shadow3 != null) {
                Util.offerLastTemporaryDirectBuffer(shadow3);
            }
            vec.clearRefs(j12);
            j12++;
            j11 = 0;
        }
        if (1 == 0) {
            for (int j13 = 0; j13 < iov_len; j13++) {
                ByteBuffer shadow4 = vec.getShadow(j13);
                if (shadow4 != null) {
                    Util.offerLastTemporaryDirectBuffer(shadow4);
                }
                vec.clearRefs(j13);
            }
        }
        return bytesWritten;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int read(FileDescriptor fd2, ByteBuffer dst, long position, NativeDispatcher nd2) throws IOException {
        if (dst.isReadOnly()) {
            throw new IllegalArgumentException("Read-only buffer");
        }
        if (dst instanceof DirectBuffer) {
            return readIntoNativeBuffer(fd2, dst, position, nd2);
        }
        ByteBuffer bb2 = Util.getTemporaryDirectBuffer(dst.remaining());
        try {
            int n10 = readIntoNativeBuffer(fd2, bb2, position, nd2);
            bb2.flip();
            if (n10 > 0) {
                dst.put(bb2);
            }
            return n10;
        } finally {
            Util.offerFirstTemporaryDirectBuffer(bb2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static int readIntoNativeBuffer(FileDescriptor fd2, ByteBuffer byteBuffer, long position, NativeDispatcher nd2) throws IOException {
        int n10;
        int pos = byteBuffer.position();
        int lim = byteBuffer.limit();
        int rem = pos <= lim ? lim - pos : 0;
        if (rem == 0) {
            return 0;
        }
        if (position != -1) {
            n10 = nd2.pread(fd2, pos + ((DirectBuffer) byteBuffer).address(), rem, position);
        } else {
            n10 = nd2.read(fd2, ((DirectBuffer) byteBuffer).address() + pos, rem);
        }
        if (n10 > 0) {
            byteBuffer.position(pos + n10);
        }
        return n10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long read(FileDescriptor fd2, ByteBuffer[] bufs, NativeDispatcher nd2) throws IOException {
        return read(fd2, bufs, 0, bufs.length, nd2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long read(FileDescriptor fd2, ByteBuffer[] bufs, int offset, int length, NativeDispatcher nd2) throws IOException {
        IOVecWrapper vec = IOVecWrapper.get(length);
        int count = offset + length;
        int iov_len = 0;
        for (int iov_len2 = offset; iov_len2 < count; iov_len2++) {
            try {
                if (iov_len >= IOV_MAX) {
                    break;
                }
                ByteBuffer buf = bufs[iov_len2];
                if (buf.isReadOnly()) {
                    throw new IllegalArgumentException("Read-only buffer");
                }
                int pos = buf.position();
                int lim = buf.limit();
                int rem = pos <= lim ? lim - pos : 0;
                if (rem > 0) {
                    vec.setBuffer(iov_len, buf, pos, rem);
                    if (!(buf instanceof DirectBuffer)) {
                        ByteBuffer shadow = Util.getTemporaryDirectBuffer(rem);
                        vec.setShadow(iov_len, shadow);
                        buf = shadow;
                        pos = shadow.position();
                    }
                    vec.putBase(iov_len, ((DirectBuffer) buf).address() + pos);
                    vec.putLen(iov_len, rem);
                    iov_len++;
                }
            } finally {
                if (0 == 0) {
                    for (int j10 = 0; j10 < iov_len; j10++) {
                        ByteBuffer shadow2 = vec.getShadow(j10);
                        if (shadow2 != null) {
                            Util.offerLastTemporaryDirectBuffer(shadow2);
                        }
                        vec.clearRefs(j10);
                    }
                }
            }
        }
        long j11 = 0;
        if (iov_len == 0) {
            return 0L;
        }
        long bytesRead = nd2.readv(fd2, vec.address, iov_len);
        long left = bytesRead;
        int j12 = 0;
        while (j12 < iov_len) {
            ByteBuffer shadow3 = vec.getShadow(j12);
            if (left > j11) {
                ByteBuffer buf2 = vec.getBuffer(j12);
                int rem2 = vec.getRemaining(j12);
                int n10 = left > ((long) rem2) ? rem2 : (int) left;
                if (shadow3 == null) {
                    buf2.position(vec.getPosition(j12) + n10);
                } else {
                    shadow3.limit(shadow3.position() + n10);
                    buf2.put(shadow3);
                }
                left -= n10;
            }
            if (shadow3 != null) {
                Util.offerLastTemporaryDirectBuffer(shadow3);
            }
            vec.clearRefs(j12);
            j12++;
            j11 = 0;
        }
        if (1 == 0) {
            for (int j13 = 0; j13 < iov_len; j13++) {
                ByteBuffer shadow4 = vec.getShadow(j13);
                if (shadow4 != null) {
                    Util.offerLastTemporaryDirectBuffer(shadow4);
                }
                vec.clearRefs(j13);
            }
        }
        return bytesRead;
    }

    public static FileDescriptor newFD(int i10) {
        FileDescriptor fd2 = new FileDescriptor();
        setfdVal(fd2, i10);
        return fd2;
    }
}
