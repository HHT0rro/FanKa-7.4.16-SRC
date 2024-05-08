package sun.nio.ch;

import java.io.FileDescriptor;
import java.io.IOException;
import java.net.BindException;
import java.net.NetPermission;
import java.net.SocketAddress;
import java.net.UnixDomainSocketAddress;
import java.nio.channels.UnsupportedAddressTypeException;
import java.nio.file.FileSystems;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.spi.FileSystemProvider;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import sun.nio.fs.AbstractFileSystemProvider;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class UnixDomainSockets {
    static final UnixDomainSocketAddress UNNAMED = UnixDomainSocketAddress.of("");
    private static final String tempDir = UnixDomainSocketsUtil.getTempDir();
    private static final NetPermission accessUnixDomainSocket = new NetPermission("accessUnixDomainSocket");
    private static final Random random = getRandom();
    private static final boolean supported = init();

    private static native int accept0(FileDescriptor fileDescriptor, FileDescriptor fileDescriptor2, Object[] objArr) throws IOException;

    private static native void bind0(FileDescriptor fileDescriptor, byte[] bArr) throws IOException;

    private static native int connect0(FileDescriptor fileDescriptor, byte[] bArr) throws IOException;

    private static native boolean init();

    private static native byte[] localAddress0(FileDescriptor fileDescriptor) throws IOException;

    private static native int socket0() throws IOException;

    private UnixDomainSockets() {
    }

    static boolean isSupported() {
        return supported;
    }

    static void checkPermission() {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(accessUnixDomainSocket);
        }
    }

    static UnixDomainSocketAddress getRevealedLocalAddress(SocketAddress sa2) {
        UnixDomainSocketAddress addr = (UnixDomainSocketAddress) sa2;
        try {
            checkPermission();
            return addr;
        } catch (SecurityException e2) {
            UnixDomainSocketAddress addr2 = UNNAMED;
            return addr2;
        }
    }

    static UnixDomainSocketAddress localAddress(FileDescriptor fd2) throws IOException {
        String path = new String(localAddress0(fd2), UnixDomainSocketsUtil.getCharset());
        return UnixDomainSocketAddress.of(path);
    }

    static String getRevealedLocalAddressAsString(SocketAddress sa2) {
        return System.getSecurityManager() != null ? sa2.toString() : "";
    }

    static UnixDomainSocketAddress checkAddress(SocketAddress sa2) {
        if (sa2 == null) {
            throw new NullPointerException();
        }
        if (!(sa2 instanceof UnixDomainSocketAddress)) {
            throw new UnsupportedAddressTypeException();
        }
        return (UnixDomainSocketAddress) sa2;
    }

    static byte[] getPathBytes(Path path) {
        FileSystemProvider provider = FileSystems.getDefault().provider();
        return ((AbstractFileSystemProvider) provider).getSunPathForSocketFile(path);
    }

    static FileDescriptor socket() throws IOException {
        return IOUtil.newFD(socket0());
    }

    static void bind(FileDescriptor fd2, Path addr) throws IOException {
        byte[] path = getPathBytes(addr);
        if (path.length == 0) {
            throw new BindException("Server socket cannot bind to unnamed address");
        }
        bind0(fd2, path);
    }

    private static Random getRandom() {
        try {
            return SecureRandom.getInstance("NativePRNGNonBlocking");
        } catch (NoSuchAlgorithmException e2) {
            return new SecureRandom();
        }
    }

    static UnixDomainSocketAddress generateTempName() throws IOException {
        String dir = tempDir;
        if (dir == null) {
            throw new BindException("Could not locate temporary directory for sockets");
        }
        int rnd = random.nextInt(Integer.MAX_VALUE);
        try {
            Path path = Path.of(dir, "socket_" + rnd);
            return UnixDomainSocketAddress.of(path);
        } catch (InvalidPathException e2) {
            throw new BindException("Invalid temporary directory");
        }
    }

    static int connect(FileDescriptor fd2, SocketAddress sa2) throws IOException {
        return connect(fd2, ((UnixDomainSocketAddress) sa2).getPath());
    }

    static int connect(FileDescriptor fd2, Path path) throws IOException {
        return connect0(fd2, getPathBytes(path));
    }

    static int accept(FileDescriptor fd2, FileDescriptor newfd, String[] paths) throws IOException {
        Object[] array = new Object[1];
        int n10 = accept0(fd2, newfd, array);
        if (n10 > 0) {
            byte[] bytes = (byte[]) array[0];
            paths[0] = new String(bytes, UnixDomainSocketsUtil.getCharset());
        }
        return n10;
    }
}
