package java.net;

import android.system.ErrnoException;
import android.system.OsConstants;
import java.io.FileDescriptor;
import java.io.IOException;
import jdk.net.ExtendedSocketOptions;
import jdk.net.SocketFlow;
import libcore.io.AsynchronousCloseMonitor;
import libcore.io.IoBridge;
import libcore.io.IoUtils;
import libcore.io.Libcore;
import sun.net.ExtendedOptionsImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class PlainSocketImpl extends AbstractPlainSocketImpl {
    /* JADX INFO: Access modifiers changed from: package-private */
    public PlainSocketImpl() {
        this.f50370fd = new FileDescriptor();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.net.SocketImpl
    public <T> void setOption(SocketOption<T> name, T t2) throws IOException {
        if (!name.equals(ExtendedSocketOptions.SO_FLOW_SLA)) {
            super.setOption((SocketOption<SocketOption<T>>) name, (SocketOption<T>) t2);
        } else {
            if (isClosedOrPending()) {
                throw new SocketException("Socket closed");
            }
            ExtendedOptionsImpl.checkSetOptionPermission(name);
            ExtendedOptionsImpl.checkValueType(t2, SocketFlow.class);
            ExtendedOptionsImpl.setFlowOption(getFileDescriptor(), (SocketFlow) t2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r0v4, types: [T, jdk.net.SocketFlow] */
    @Override // java.net.SocketImpl
    public <T> T getOption(SocketOption<T> socketOption) throws IOException {
        if (!socketOption.equals(ExtendedSocketOptions.SO_FLOW_SLA)) {
            return (T) super.getOption(socketOption);
        }
        if (isClosedOrPending()) {
            throw new SocketException("Socket closed");
        }
        ExtendedOptionsImpl.checkGetOptionPermission(socketOption);
        ?? r02 = (T) SocketFlow.create();
        ExtendedOptionsImpl.getFlowOption(getFileDescriptor(), r02);
        return r02;
    }

    @Override // java.net.AbstractPlainSocketImpl
    protected void socketSetOption(int opt, Object val) throws SocketException {
        try {
            socketSetOption0(opt, val);
        } catch (SocketException se) {
            if (this.socket == null || !this.socket.isConnected()) {
                throw se;
            }
        }
    }

    @Override // java.net.AbstractPlainSocketImpl
    void socketCreate(boolean isStream) throws IOException {
        this.f50370fd.setInt$(IoBridge.socket(OsConstants.AF_INET6, isStream ? OsConstants.SOCK_STREAM : OsConstants.SOCK_DGRAM, 0).getInt$());
        IoUtils.setFdOwner(this.f50370fd, this);
        if (this.serverSocket != null) {
            IoUtils.setBlocking(this.f50370fd, false);
            IoBridge.setSocketOption(this.f50370fd, 4, true);
        }
    }

    @Override // java.net.AbstractPlainSocketImpl
    void socketConnect(InetAddress address, int port, int timeout) throws IOException {
        if (this.f50370fd == null || !this.f50370fd.valid()) {
            throw new SocketException("Socket closed");
        }
        IoBridge.connect(this.f50370fd, address, port, timeout);
        this.address = address;
        this.port = port;
        if (this.localport == 0 && !isClosedOrPending()) {
            this.localport = IoBridge.getLocalInetSocketAddress(this.f50370fd).getPort();
        }
    }

    @Override // java.net.AbstractPlainSocketImpl
    void socketBind(InetAddress address, int port) throws IOException {
        if (this.f50370fd == null || !this.f50370fd.valid()) {
            throw new SocketException("Socket closed");
        }
        IoBridge.bind(this.f50370fd, address, port);
        this.address = address;
        if (port == 0) {
            this.localport = IoBridge.getLocalInetSocketAddress(this.f50370fd).getPort();
        } else {
            this.localport = port;
        }
    }

    @Override // java.net.AbstractPlainSocketImpl
    void socketListen(int count) throws IOException {
        if (this.f50370fd == null || !this.f50370fd.valid()) {
            throw new SocketException("Socket closed");
        }
        try {
            Libcore.os.listen(this.f50370fd, count);
        } catch (ErrnoException errnoException) {
            throw errnoException.rethrowAsSocketException();
        }
    }

    @Override // java.net.AbstractPlainSocketImpl
    void socketAccept(SocketImpl s2) throws IOException {
        if (this.f50370fd == null || !this.f50370fd.valid()) {
            throw new SocketException("Socket closed");
        }
        if (this.timeout <= 0) {
            IoBridge.poll(this.f50370fd, OsConstants.POLLIN | OsConstants.POLLERR, -1);
        } else {
            IoBridge.poll(this.f50370fd, OsConstants.POLLIN | OsConstants.POLLERR, this.timeout);
        }
        InetSocketAddress peerAddress = new InetSocketAddress();
        try {
            FileDescriptor newfd = Libcore.os.accept(this.f50370fd, peerAddress);
            s2.f50370fd.setInt$(newfd.getInt$());
            IoUtils.setFdOwner(s2.f50370fd, s2);
            s2.address = peerAddress.getAddress();
            s2.port = peerAddress.getPort();
        } catch (ErrnoException errnoException) {
            if (errnoException.errno == OsConstants.EAGAIN) {
                SocketTimeoutException e2 = new SocketTimeoutException();
                e2.initCause(errnoException);
                throw e2;
            }
            if (errnoException.errno == OsConstants.EINVAL || errnoException.errno == OsConstants.EBADF) {
                throw new SocketException("Socket closed");
            }
            errnoException.rethrowAsSocketException();
        }
        s2.localport = IoBridge.getLocalInetSocketAddress(s2.f50370fd).getPort();
    }

    @Override // java.net.AbstractPlainSocketImpl
    int socketAvailable() throws IOException {
        return IoBridge.available(this.f50370fd);
    }

    @Override // java.net.AbstractPlainSocketImpl
    void socketClose0(boolean useDeferredClose) throws IOException {
        if (this.f50370fd == null || !this.f50370fd.valid()) {
            throw new SocketException("socket already closed");
        }
        FileDescriptor markerFD = null;
        if (useDeferredClose) {
            markerFD = getMarkerFD();
        }
        if (useDeferredClose && markerFD != null) {
            try {
                Libcore.os.dup2(markerFD, this.f50370fd.getInt$());
                Libcore.os.close(markerFD);
                AsynchronousCloseMonitor.signalBlockedThreads(this.f50370fd);
                return;
            } catch (ErrnoException e2) {
                return;
            }
        }
        IoBridge.closeAndSignalBlockedThreads(this.f50370fd);
    }

    private FileDescriptor getMarkerFD() throws SocketException {
        FileDescriptor fd1 = new FileDescriptor();
        FileDescriptor fd2 = new FileDescriptor();
        try {
            Libcore.os.socketpair(OsConstants.AF_UNIX, OsConstants.SOCK_STREAM, 0, fd1, fd2);
            Libcore.os.shutdown(fd1, OsConstants.SHUT_RDWR);
            Libcore.os.close(fd2);
            return fd1;
        } catch (ErrnoException e2) {
            return null;
        }
    }

    @Override // java.net.AbstractPlainSocketImpl
    void socketShutdown(int howto) throws IOException {
        try {
            Libcore.os.shutdown(this.f50370fd, howto);
        } catch (ErrnoException errnoException) {
            throw errnoException.rethrowAsIOException();
        }
    }

    void socketSetOption0(int cmd, Object value) throws SocketException {
        if (cmd == 4102) {
            return;
        }
        IoBridge.setSocketOption(this.f50370fd, cmd, value);
    }

    @Override // java.net.AbstractPlainSocketImpl
    Object socketGetOption(int opt) throws SocketException {
        return IoBridge.getSocketOption(this.f50370fd, opt);
    }

    @Override // java.net.AbstractPlainSocketImpl
    void socketSendUrgentData(int data) throws IOException {
        if (this.f50370fd == null || !this.f50370fd.valid()) {
            throw new SocketException("Socket closed");
        }
        try {
            byte[] buffer = {(byte) data};
            Libcore.os.sendto(this.f50370fd, buffer, 0, 1, OsConstants.MSG_OOB, (InetAddress) null, 0);
        } catch (ErrnoException errnoException) {
            throw errnoException.rethrowAsSocketException();
        }
    }
}
