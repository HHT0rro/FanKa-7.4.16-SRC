package java.io;

import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import com.kuaishou.weapon.p0.t;
import dalvik.annotation.optimization.ReachabilitySensitive;
import dalvik.system.CloseGuard;
import java.nio.channels.FileChannel;
import libcore.io.IoBridge;
import libcore.io.IoTracker;
import libcore.io.IoUtils;
import libcore.io.Libcore;
import sun.nio.ch.FileChannelImpl;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class RandomAccessFile implements DataOutput, DataInput, Closeable {
    private static final int FLUSH_FDATASYNC = 2;
    private static final int FLUSH_FSYNC = 1;
    private static final int FLUSH_NONE = 0;
    private FileChannel channel;
    private Object closeLock;
    private volatile boolean closed;

    /* renamed from: fd, reason: collision with root package name */
    @ReachabilitySensitive
    private FileDescriptor f50355fd;
    private int flushAfterWrite;

    @ReachabilitySensitive
    private final CloseGuard guard;
    private final IoTracker ioTracker;
    private int mode;
    private final String path;
    private boolean rw;
    private final byte[] scratch;

    public RandomAccessFile(String name, String mode) throws FileNotFoundException {
        this(name != null ? new File(name) : null, mode);
    }

    public RandomAccessFile(File file, String mode) throws FileNotFoundException {
        CloseGuard closeGuard = CloseGuard.get();
        this.guard = closeGuard;
        this.scratch = new byte[8];
        this.flushAfterWrite = 0;
        this.channel = null;
        this.closeLock = new Object();
        this.closed = false;
        this.ioTracker = new IoTracker();
        String name = file != null ? file.getPath() : null;
        int imode = -1;
        if (mode.equals(t.f36226k)) {
            imode = OsConstants.O_RDONLY;
        } else if (mode.startsWith("rw")) {
            imode = OsConstants.O_RDWR | OsConstants.O_CREAT;
            this.rw = true;
            if (mode.length() > 2) {
                if (mode.equals("rws")) {
                    this.flushAfterWrite = 1;
                } else if (mode.equals("rwd")) {
                    this.flushAfterWrite = 2;
                } else {
                    imode = -1;
                }
            }
        }
        if (imode < 0) {
            throw new IllegalArgumentException("Illegal mode \"" + mode + "\" must be one of \"r\", \"rw\", \"rws\", or \"rwd\"");
        }
        if (name == null) {
            throw new NullPointerException("file == null");
        }
        if (file.isInvalid()) {
            throw new FileNotFoundException("Invalid file path");
        }
        this.path = name;
        this.mode = imode;
        FileDescriptor open = IoBridge.open(name, imode);
        this.f50355fd = open;
        IoUtils.setFdOwner(open, this);
        maybeSync();
        closeGuard.open("close");
    }

    private void maybeSync() {
        int i10 = this.flushAfterWrite;
        if (i10 == 1) {
            try {
                this.f50355fd.sync();
            } catch (IOException e2) {
            }
        } else if (i10 == 2) {
            try {
                Os.fdatasync(this.f50355fd);
            } catch (ErrnoException e10) {
            }
        }
    }

    public final FileDescriptor getFD() throws IOException {
        FileDescriptor fileDescriptor = this.f50355fd;
        if (fileDescriptor != null) {
            return fileDescriptor;
        }
        throw new IOException();
    }

    public final FileChannel getChannel() {
        FileChannel fileChannel;
        synchronized (this) {
            if (this.channel == null) {
                this.channel = FileChannelImpl.open(this.f50355fd, this.path, true, this.rw, this);
            }
            fileChannel = this.channel;
        }
        return fileChannel;
    }

    public int read() throws IOException {
        if (read(this.scratch, 0, 1) != -1) {
            return this.scratch[0] & 255;
        }
        return -1;
    }

    private int readBytes(byte[] b4, int off, int len) throws IOException {
        this.ioTracker.trackIo(len, IoTracker.Mode.READ);
        return IoBridge.read(this.f50355fd, b4, off, len);
    }

    public int read(byte[] b4, int off, int len) throws IOException {
        return readBytes(b4, off, len);
    }

    public int read(byte[] b4) throws IOException {
        return readBytes(b4, 0, b4.length);
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] b4) throws IOException {
        readFully(b4, 0, b4.length);
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] b4, int off, int len) throws IOException {
        int n10 = 0;
        do {
            int count = read(b4, off + n10, len - n10);
            if (count < 0) {
                throw new EOFException();
            }
            n10 += count;
        } while (n10 < len);
    }

    @Override // java.io.DataInput
    public int skipBytes(int n10) throws IOException {
        if (n10 <= 0) {
            return 0;
        }
        long pos = getFilePointer();
        long len = length();
        long newpos = n10 + pos;
        if (newpos > len) {
            newpos = len;
        }
        seek(newpos);
        return (int) (newpos - pos);
    }

    @Override // java.io.DataOutput
    public void write(int b4) throws IOException {
        byte[] bArr = this.scratch;
        bArr[0] = (byte) (b4 & 255);
        write(bArr, 0, 1);
    }

    private void writeBytes(byte[] b4, int off, int len) throws IOException {
        this.ioTracker.trackIo(len, IoTracker.Mode.WRITE);
        IoBridge.write(this.f50355fd, b4, off, len);
        maybeSync();
    }

    @Override // java.io.DataOutput
    public void write(byte[] b4) throws IOException {
        writeBytes(b4, 0, b4.length);
    }

    @Override // java.io.DataOutput
    public void write(byte[] b4, int off, int len) throws IOException {
        writeBytes(b4, off, len);
    }

    public long getFilePointer() throws IOException {
        try {
            return Libcore.os.lseek(this.f50355fd, 0L, OsConstants.SEEK_CUR);
        } catch (ErrnoException errnoException) {
            throw errnoException.rethrowAsIOException();
        }
    }

    public void seek(long pos) throws IOException {
        if (pos < 0) {
            throw new IOException("offset < 0: " + pos);
        }
        try {
            Libcore.os.lseek(this.f50355fd, pos, OsConstants.SEEK_SET);
            this.ioTracker.reset();
        } catch (ErrnoException errnoException) {
            throw errnoException.rethrowAsIOException();
        }
    }

    public long length() throws IOException {
        try {
            return Libcore.os.fstat(this.f50355fd).st_size;
        } catch (ErrnoException errnoException) {
            throw errnoException.rethrowAsIOException();
        }
    }

    public void setLength(long newLength) throws IOException {
        if (newLength < 0) {
            throw new IllegalArgumentException("newLength < 0");
        }
        try {
            Libcore.os.ftruncate(this.f50355fd, newLength);
            long filePointer = getFilePointer();
            if (filePointer > newLength) {
                seek(newLength);
            }
            maybeSync();
        } catch (ErrnoException errnoException) {
            throw errnoException.rethrowAsIOException();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.guard.close();
        synchronized (this.closeLock) {
            if (this.closed) {
                return;
            }
            this.closed = true;
            FileChannel fileChannel = this.channel;
            if (fileChannel != null && fileChannel.isOpen()) {
                this.channel.close();
            }
            IoBridge.closeAndSignalBlockedThreads(this.f50355fd);
        }
    }

    @Override // java.io.DataInput
    public final boolean readBoolean() throws IOException {
        int ch = read();
        if (ch >= 0) {
            return ch != 0;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public final byte readByte() throws IOException {
        int ch = read();
        if (ch < 0) {
            throw new EOFException();
        }
        return (byte) ch;
    }

    @Override // java.io.DataInput
    public final int readUnsignedByte() throws IOException {
        int ch = read();
        if (ch < 0) {
            throw new EOFException();
        }
        return ch;
    }

    @Override // java.io.DataInput
    public final short readShort() throws IOException {
        int ch1 = read();
        int ch2 = read();
        if ((ch1 | ch2) < 0) {
            throw new EOFException();
        }
        return (short) ((ch1 << 8) + (ch2 << 0));
    }

    @Override // java.io.DataInput
    public final int readUnsignedShort() throws IOException {
        int ch1 = read();
        int ch2 = read();
        if ((ch1 | ch2) < 0) {
            throw new EOFException();
        }
        return (ch1 << 8) + (ch2 << 0);
    }

    @Override // java.io.DataInput
    public final char readChar() throws IOException {
        int ch1 = read();
        int ch2 = read();
        if ((ch1 | ch2) < 0) {
            throw new EOFException();
        }
        return (char) ((ch1 << 8) + (ch2 << 0));
    }

    @Override // java.io.DataInput
    public final int readInt() throws IOException {
        int ch1 = read();
        int ch2 = read();
        int ch3 = read();
        int ch4 = read();
        if ((ch1 | ch2 | ch3 | ch4) < 0) {
            throw new EOFException();
        }
        return (ch1 << 24) + (ch2 << 16) + (ch3 << 8) + (ch4 << 0);
    }

    @Override // java.io.DataInput
    public final long readLong() throws IOException {
        return (readInt() << 32) + (readInt() & 4294967295L);
    }

    @Override // java.io.DataInput
    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public final String readLine() throws IOException {
        StringBuffer input = new StringBuffer();
        int c4 = -1;
        boolean eol = false;
        while (!eol) {
            int read = read();
            c4 = read;
            switch (read) {
                case -1:
                case 10:
                    eol = true;
                    break;
                case 13:
                    eol = true;
                    long cur = getFilePointer();
                    if (read() == 10) {
                        break;
                    } else {
                        seek(cur);
                        break;
                    }
                default:
                    input.append((char) c4);
                    break;
            }
        }
        if (c4 == -1 && input.length() == 0) {
            return null;
        }
        return input.toString();
    }

    @Override // java.io.DataInput
    public final String readUTF() throws IOException {
        return DataInputStream.readUTF(this);
    }

    @Override // java.io.DataOutput
    public final void writeBoolean(boolean z10) throws IOException {
        write(z10 ? 1 : 0);
    }

    @Override // java.io.DataOutput
    public final void writeByte(int v2) throws IOException {
        write(v2);
    }

    @Override // java.io.DataOutput
    public final void writeShort(int v2) throws IOException {
        write((v2 >>> 8) & 255);
        write((v2 >>> 0) & 255);
    }

    @Override // java.io.DataOutput
    public final void writeChar(int v2) throws IOException {
        write((v2 >>> 8) & 255);
        write((v2 >>> 0) & 255);
    }

    @Override // java.io.DataOutput
    public final void writeInt(int v2) throws IOException {
        write((v2 >>> 24) & 255);
        write((v2 >>> 16) & 255);
        write((v2 >>> 8) & 255);
        write((v2 >>> 0) & 255);
    }

    @Override // java.io.DataOutput
    public final void writeLong(long v2) throws IOException {
        write(((int) (v2 >>> 56)) & 255);
        write(((int) (v2 >>> 48)) & 255);
        write(((int) (v2 >>> 40)) & 255);
        write(((int) (v2 >>> 32)) & 255);
        write(((int) (v2 >>> 24)) & 255);
        write(((int) (v2 >>> 16)) & 255);
        write(((int) (v2 >>> 8)) & 255);
        write(((int) (v2 >>> 0)) & 255);
    }

    @Override // java.io.DataOutput
    public final void writeFloat(float v2) throws IOException {
        writeInt(Float.floatToIntBits(v2));
    }

    @Override // java.io.DataOutput
    public final void writeDouble(double v2) throws IOException {
        writeLong(Double.doubleToLongBits(v2));
    }

    @Override // java.io.DataOutput
    public final void writeBytes(String s2) throws IOException {
        int len = s2.length();
        byte[] b4 = new byte[len];
        s2.getBytes(0, len, b4, 0);
        writeBytes(b4, 0, len);
    }

    @Override // java.io.DataOutput
    public final void writeChars(String s2) throws IOException {
        int clen = s2.length();
        int blen = clen * 2;
        byte[] b4 = new byte[blen];
        char[] c4 = new char[clen];
        s2.getChars(0, clen, c4, 0);
        int j10 = 0;
        for (int i10 = 0; i10 < clen; i10++) {
            int j11 = j10 + 1;
            b4[j10] = (byte) (c4[i10] >>> '\b');
            j10 = j11 + 1;
            b4[j11] = (byte) (c4[i10] >>> 0);
        }
        writeBytes(b4, 0, blen);
    }

    @Override // java.io.DataOutput
    public final void writeUTF(String str) throws IOException {
        DataOutputStream.writeUTF(str, this);
    }

    protected void finalize() throws Throwable {
        try {
            CloseGuard closeGuard = this.guard;
            if (closeGuard != null) {
                closeGuard.warnIfOpen();
            }
            close();
        } finally {
            super.finalize();
        }
    }
}
