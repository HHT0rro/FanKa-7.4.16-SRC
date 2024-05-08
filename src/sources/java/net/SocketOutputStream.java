package java.net;

import dalvik.system.BlockGuard;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class SocketOutputStream extends FileOutputStream {
    private boolean closing;
    private AbstractPlainSocketImpl impl;
    private Socket socket;
    private byte[] temp;

    private native void socketWrite0(FileDescriptor fileDescriptor, byte[] bArr, int i10, int i11) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SocketOutputStream(AbstractPlainSocketImpl impl) throws IOException {
        super(impl.getFileDescriptor());
        this.impl = null;
        this.temp = new byte[1];
        this.socket = null;
        this.closing = false;
        this.impl = impl;
        this.socket = impl.getSocket();
    }

    @Override // java.io.FileOutputStream
    public final FileChannel getChannel() {
        return null;
    }

    private void socketWrite(byte[] b4, int off, int len) throws IOException {
        if (len <= 0 || off < 0 || len > b4.length - off) {
            if (len == 0) {
                return;
            } else {
                throw new ArrayIndexOutOfBoundsException("len == " + len + " off == " + off + " buffer length == " + b4.length);
            }
        }
        FileDescriptor fd2 = this.impl.acquireFD();
        try {
            try {
                BlockGuard.getThreadPolicy().onNetwork();
                socketWrite0(fd2, b4, off, len);
            } catch (SocketException se) {
                if (!this.impl.isClosedOrPending()) {
                    throw se;
                }
                throw new SocketException("Socket closed");
            }
        } finally {
            this.impl.releaseFD();
        }
    }

    @Override // java.io.FileOutputStream, java.io.OutputStream
    public void write(int b4) throws IOException {
        byte[] bArr = this.temp;
        bArr[0] = (byte) b4;
        socketWrite(bArr, 0, 1);
    }

    @Override // java.io.FileOutputStream, java.io.OutputStream
    public void write(byte[] b4) throws IOException {
        socketWrite(b4, 0, b4.length);
    }

    @Override // java.io.FileOutputStream, java.io.OutputStream
    public void write(byte[] b4, int off, int len) throws IOException {
        socketWrite(b4, off, len);
    }

    @Override // java.io.FileOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
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

    @Override // java.io.FileOutputStream
    protected void finalize() {
    }
}
