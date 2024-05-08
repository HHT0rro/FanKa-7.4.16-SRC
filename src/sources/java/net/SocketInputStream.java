package java.net;

import dalvik.system.BlockGuard;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import sun.net.ConnectionResetException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class SocketInputStream extends FileInputStream {
    private boolean closing;
    private boolean eof;
    private AbstractPlainSocketImpl impl;
    private Socket socket;
    private byte[] temp;

    private native int socketRead0(FileDescriptor fileDescriptor, byte[] bArr, int i10, int i11, int i12) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SocketInputStream(AbstractPlainSocketImpl impl) throws IOException {
        super(impl.getFileDescriptor());
        this.impl = null;
        this.socket = null;
        this.closing = false;
        this.impl = impl;
        this.socket = impl.getSocket();
    }

    @Override // java.io.FileInputStream
    public final FileChannel getChannel() {
        return null;
    }

    private int socketRead(FileDescriptor fd2, byte[] b4, int off, int len, int timeout) throws IOException {
        return socketRead0(fd2, b4, off, len, timeout);
    }

    @Override // java.io.FileInputStream, java.io.InputStream
    public int read(byte[] b4) throws IOException {
        return read(b4, 0, b4.length);
    }

    @Override // java.io.FileInputStream, java.io.InputStream
    public int read(byte[] b4, int off, int length) throws IOException {
        return read(b4, off, length, this.impl.getTimeout());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int read(byte[] b4, int off, int length, int timeout) throws IOException {
        int n10;
        if (this.eof) {
            return -1;
        }
        if (this.impl.isConnectionReset()) {
            throw new SocketException("Connection reset");
        }
        if (length <= 0 || off < 0 || length > b4.length - off) {
            if (length == 0) {
                return 0;
            }
            throw new ArrayIndexOutOfBoundsException("length == " + length + " off == " + off + " buffer length == " + b4.length);
        }
        FileDescriptor fd2 = this.impl.acquireFD();
        try {
            BlockGuard.getThreadPolicy().onNetwork();
            n10 = socketRead(fd2, b4, off, length, timeout);
        } catch (ConnectionResetException e2) {
            this.impl.setConnectionReset();
        } finally {
            this.impl.releaseFD();
        }
        if (n10 > 0) {
            return n10;
        }
        if (this.impl.isClosedOrPending()) {
            throw new SocketException("Socket closed");
        }
        if (this.impl.isConnectionReset()) {
            throw new SocketException("Connection reset");
        }
        this.eof = true;
        return -1;
    }

    @Override // java.io.FileInputStream, java.io.InputStream
    public int read() throws IOException {
        if (this.eof) {
            return -1;
        }
        byte[] bArr = new byte[1];
        this.temp = bArr;
        int n10 = read(bArr, 0, 1);
        if (n10 <= 0) {
            return -1;
        }
        return this.temp[0] & 255;
    }

    @Override // java.io.FileInputStream, java.io.InputStream
    public long skip(long numbytes) throws IOException {
        int r10;
        if (numbytes <= 0) {
            return 0L;
        }
        long n10 = numbytes;
        int buflen = (int) Math.min(1024L, n10);
        byte[] data = new byte[buflen];
        while (n10 > 0 && (r10 = read(data, 0, (int) Math.min(buflen, n10))) >= 0) {
            n10 -= r10;
        }
        return numbytes - n10;
    }

    @Override // java.io.FileInputStream, java.io.InputStream
    public int available() throws IOException {
        if (this.eof) {
            return 0;
        }
        return this.impl.available();
    }

    @Override // java.io.FileInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closing) {
            return;
        }
        this.closing = true;
        Socket socket = this.socket;
        if (socket != null) {
            if (!socket.isClosed()) {
                this.socket.close();
            }
        } else {
            this.impl.close();
        }
        this.closing = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setEOF(boolean eof) {
        this.eof = eof;
    }

    @Override // java.io.FileInputStream
    protected void finalize() {
    }
}
