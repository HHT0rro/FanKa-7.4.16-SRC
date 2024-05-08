package java.net;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import org.apache.commons.lang3.CharEncoding;
import sun.security.action.GetPropertyAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class SocksSocketImpl extends PlainSocketImpl implements SocksConsts {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private boolean applicationSetProxy;
    private InputStream cmdIn;
    private OutputStream cmdOut;
    private Socket cmdsock;
    private InetSocketAddress external_address;
    private String server;
    private int serverPort;
    private boolean useV4;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SocksSocketImpl() {
        this.server = null;
        this.serverPort = 1080;
        this.useV4 = false;
        this.cmdsock = null;
        this.cmdIn = null;
        this.cmdOut = null;
    }

    SocksSocketImpl(String server, int port) {
        this.server = null;
        this.serverPort = 1080;
        this.useV4 = false;
        this.cmdsock = null;
        this.cmdIn = null;
        this.cmdOut = null;
        this.server = server;
        this.serverPort = port != -1 ? port : 1080;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SocksSocketImpl(Proxy proxy) {
        this.server = null;
        this.serverPort = 1080;
        this.useV4 = false;
        this.cmdsock = null;
        this.cmdIn = null;
        this.cmdOut = null;
        SocketAddress a10 = proxy.address();
        if (a10 instanceof InetSocketAddress) {
            InetSocketAddress ad2 = (InetSocketAddress) a10;
            this.server = ad2.getHostString();
            this.serverPort = ad2.getPort();
        }
    }

    void setV4() {
        this.useV4 = true;
    }

    private synchronized void privilegedConnect(final String host, final int port, final int timeout) throws IOException {
        try {
            AccessController.doPrivileged(new PrivilegedExceptionAction<Void>() { // from class: java.net.SocksSocketImpl.1
                @Override // java.security.PrivilegedExceptionAction
                public Void run() throws IOException {
                    SocksSocketImpl.this.superConnectServer(host, port, timeout);
                    SocksSocketImpl socksSocketImpl = SocksSocketImpl.this;
                    socksSocketImpl.cmdIn = socksSocketImpl.getInputStream();
                    SocksSocketImpl socksSocketImpl2 = SocksSocketImpl.this;
                    socksSocketImpl2.cmdOut = socksSocketImpl2.getOutputStream();
                    return null;
                }
            });
        } catch (PrivilegedActionException pae) {
            throw ((IOException) pae.getException());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void superConnectServer(String host, int port, int timeout) throws IOException {
        super.connect(new InetSocketAddress(host, port), timeout);
    }

    private static int remainingMillis(long deadlineMillis) throws IOException {
        if (deadlineMillis == 0) {
            return 0;
        }
        long remaining = deadlineMillis - System.currentTimeMillis();
        if (remaining > 0) {
            return (int) remaining;
        }
        throw new SocketTimeoutException();
    }

    private int readSocksReply(InputStream in, byte[] data) throws IOException {
        return readSocksReply(in, data, 0L);
    }

    private int readSocksReply(InputStream in, byte[] data, long deadlineMillis) throws IOException {
        int len = data.length;
        int received = 0;
        for (int attempts = 0; received < len && attempts < 3; attempts++) {
            try {
                int count = ((SocketInputStream) in).read(data, received, len - received, remainingMillis(deadlineMillis));
                if (count < 0) {
                    throw new SocketException("Malformed reply from SOCKS server");
                }
                received += count;
            } catch (SocketTimeoutException e2) {
                throw new SocketTimeoutException("Connect timed out");
            }
        }
        return received;
    }

    private boolean authenticate(byte method, InputStream in, BufferedOutputStream out) throws IOException {
        return authenticate(method, in, out, 0L);
    }

    private boolean authenticate(byte method, InputStream in, BufferedOutputStream out, long deadlineMillis) throws IOException {
        String userName;
        if (method == 0) {
            return true;
        }
        if (method != 2) {
            return false;
        }
        String password = null;
        final InetAddress addr = InetAddress.getByName(this.server);
        PasswordAuthentication pw = (PasswordAuthentication) AccessController.doPrivileged(new PrivilegedAction<PasswordAuthentication>() { // from class: java.net.SocksSocketImpl.2
            @Override // java.security.PrivilegedAction
            public PasswordAuthentication run() {
                return Authenticator.requestPasswordAuthentication(SocksSocketImpl.this.server, addr, SocksSocketImpl.this.serverPort, "SOCKS5", "SOCKS authentication", null);
            }
        });
        if (pw != null) {
            userName = pw.getUserName();
            password = new String(pw.getPassword());
        } else {
            userName = (String) AccessController.doPrivileged(new GetPropertyAction("user.name"));
        }
        if (userName == null) {
            return false;
        }
        out.write(1);
        out.write(userName.length());
        try {
            out.write(userName.getBytes(CharEncoding.ISO_8859_1));
        } catch (UnsupportedEncodingException e2) {
        }
        if (password != null) {
            out.write(password.length());
            try {
                out.write(password.getBytes(CharEncoding.ISO_8859_1));
            } catch (UnsupportedEncodingException e10) {
            }
        } else {
            out.write(0);
        }
        out.flush();
        byte[] data = new byte[2];
        int i10 = readSocksReply(in, data, deadlineMillis);
        if (i10 == 2 && data[1] == 0) {
            return true;
        }
        out.close();
        in.close();
        return false;
    }

    private void connectV4(InputStream in, OutputStream out, InetSocketAddress endpoint, long deadlineMillis) throws IOException {
        if (!(endpoint.getAddress() instanceof Inet4Address)) {
            throw new SocketException("SOCKS V4 requires IPv4 only addresses");
        }
        out.write(4);
        out.write(1);
        out.write((endpoint.getPort() >> 8) & 255);
        out.write((endpoint.getPort() >> 0) & 255);
        out.write(endpoint.getAddress().getAddress());
        String userName = getUserName();
        try {
            out.write(userName.getBytes(CharEncoding.ISO_8859_1));
        } catch (UnsupportedEncodingException e2) {
        }
        out.write(0);
        out.flush();
        byte[] data = new byte[8];
        int n10 = readSocksReply(in, data, deadlineMillis);
        if (n10 != 8) {
            throw new SocketException("Reply from SOCKS server has bad length: " + n10);
        }
        if (data[0] != 0 && data[0] != 4) {
            throw new SocketException("Reply from SOCKS server has bad version");
        }
        SocketException ex = null;
        switch (data[1]) {
            case 90:
                this.external_address = endpoint;
                break;
            case 91:
                ex = new SocketException("SOCKS request rejected");
                break;
            case 92:
                ex = new SocketException("SOCKS server couldn't reach destination");
                break;
            case 93:
                ex = new SocketException("SOCKS authentication failed");
                break;
            default:
                ex = new SocketException("Reply from SOCKS server contains bad status");
                break;
        }
        if (ex != null) {
            in.close();
            out.close();
            throw ex;
        }
    }

    @Override // java.net.AbstractPlainSocketImpl, java.net.SocketImpl
    protected void connect(SocketAddress endpoint, int timeout) throws IOException {
        long deadlineMillis;
        if (timeout == 0) {
            deadlineMillis = 0;
        } else {
            long deadlineMillis2 = System.currentTimeMillis();
            long finish = deadlineMillis2 + timeout;
            deadlineMillis = finish < 0 ? Long.MAX_VALUE : finish;
        }
        SecurityManager security = System.getSecurityManager();
        if (endpoint == null || !(endpoint instanceof InetSocketAddress)) {
            throw new IllegalArgumentException("Unsupported address type");
        }
        InetSocketAddress epoint = (InetSocketAddress) endpoint;
        if (security != null) {
            if (epoint.isUnresolved()) {
                security.checkConnect(epoint.getHostName(), epoint.getPort());
            } else {
                security.checkConnect(epoint.getAddress().getHostAddress(), epoint.getPort());
            }
        }
        String str = this.server;
        if (str == null) {
            super.connect(epoint, remainingMillis(deadlineMillis));
            return;
        }
        try {
            privilegedConnect(str, this.serverPort, remainingMillis(deadlineMillis));
            BufferedOutputStream out = new BufferedOutputStream(this.cmdOut, 512);
            InputStream in = this.cmdIn;
            if (this.useV4) {
                if (epoint.isUnresolved()) {
                    throw new UnknownHostException(epoint.toString());
                }
                connectV4(in, out, epoint, deadlineMillis);
                return;
            }
            out.write(5);
            out.write(2);
            out.write(0);
            out.write(2);
            out.flush();
            byte[] data = new byte[2];
            int i10 = readSocksReply(in, data, deadlineMillis);
            if (i10 == 2 && data[0] == 5) {
                if (data[1] == -1) {
                    throw new SocketException("SOCKS : No acceptable methods");
                }
                if (!authenticate(data[1], in, out, deadlineMillis)) {
                    throw new SocketException("SOCKS : authentication failed");
                }
                out.write(5);
                out.write(1);
                out.write(0);
                if (epoint.isUnresolved()) {
                    out.write(3);
                    out.write(epoint.getHostName().length());
                    try {
                        out.write(epoint.getHostName().getBytes(CharEncoding.ISO_8859_1));
                    } catch (UnsupportedEncodingException e2) {
                    }
                    out.write((epoint.getPort() >> 8) & 255);
                    out.write((epoint.getPort() >> 0) & 255);
                } else if (epoint.getAddress() instanceof Inet6Address) {
                    out.write(4);
                    out.write(epoint.getAddress().getAddress());
                    out.write((epoint.getPort() >> 8) & 255);
                    out.write((epoint.getPort() >> 0) & 255);
                } else {
                    out.write(1);
                    out.write(epoint.getAddress().getAddress());
                    out.write((epoint.getPort() >> 8) & 255);
                    out.write((epoint.getPort() >> 0) & 255);
                }
                out.flush();
                byte[] bArr = new byte[4];
                int i11 = readSocksReply(in, bArr, deadlineMillis);
                if (i11 != 4) {
                    throw new SocketException("Reply from SOCKS server has bad length");
                }
                SocketException ex = null;
                switch (bArr[1]) {
                    case 0:
                        switch (bArr[3]) {
                            case 1:
                                byte[] addr = new byte[4];
                                int i12 = readSocksReply(in, addr, deadlineMillis);
                                if (i12 != 4) {
                                    throw new SocketException("Reply from SOCKS server badly formatted");
                                }
                                int i13 = readSocksReply(in, new byte[2], deadlineMillis);
                                if (i13 != 2) {
                                    throw new SocketException("Reply from SOCKS server badly formatted");
                                }
                                break;
                            case 2:
                            default:
                                ex = new SocketException("Reply from SOCKS server contains wrong code");
                                break;
                            case 3:
                                int i14 = bArr[1];
                                byte[] host = new byte[i14];
                                int i15 = readSocksReply(in, host, deadlineMillis);
                                if (i15 != i14) {
                                    throw new SocketException("Reply from SOCKS server badly formatted");
                                }
                                int i16 = readSocksReply(in, new byte[2], deadlineMillis);
                                if (i16 != 2) {
                                    throw new SocketException("Reply from SOCKS server badly formatted");
                                }
                                break;
                            case 4:
                                int i17 = bArr[1];
                                byte[] addr2 = new byte[i17];
                                int i18 = readSocksReply(in, addr2, deadlineMillis);
                                if (i18 != i17) {
                                    throw new SocketException("Reply from SOCKS server badly formatted");
                                }
                                int i19 = readSocksReply(in, new byte[2], deadlineMillis);
                                if (i19 != 2) {
                                    throw new SocketException("Reply from SOCKS server badly formatted");
                                }
                                break;
                        }
                    case 1:
                        ex = new SocketException("SOCKS server general failure");
                        break;
                    case 2:
                        ex = new SocketException("SOCKS: Connection not allowed by ruleset");
                        break;
                    case 3:
                        ex = new SocketException("SOCKS: Network unreachable");
                        break;
                    case 4:
                        ex = new SocketException("SOCKS: Host unreachable");
                        break;
                    case 5:
                        ex = new SocketException("SOCKS: Connection refused");
                        break;
                    case 6:
                        ex = new SocketException("SOCKS: TTL expired");
                        break;
                    case 7:
                        ex = new SocketException("SOCKS: Command not supported");
                        break;
                    case 8:
                        ex = new SocketException("SOCKS: address type not supported");
                        break;
                }
                if (ex != null) {
                    in.close();
                    out.close();
                    throw ex;
                }
                this.external_address = epoint;
                return;
            }
            if (epoint.isUnresolved()) {
                throw new UnknownHostException(epoint.toString());
            }
            connectV4(in, out, epoint, deadlineMillis);
        } catch (IOException e10) {
            throw new SocketException(e10.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.SocketImpl
    public InetAddress getInetAddress() {
        InetSocketAddress inetSocketAddress = this.external_address;
        if (inetSocketAddress != null) {
            return inetSocketAddress.getAddress();
        }
        return super.getInetAddress();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.SocketImpl
    public int getPort() {
        InetSocketAddress inetSocketAddress = this.external_address;
        if (inetSocketAddress != null) {
            return inetSocketAddress.getPort();
        }
        return super.getPort();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.SocketImpl
    public int getLocalPort() {
        if (this.socket != null) {
            return super.getLocalPort();
        }
        InetSocketAddress inetSocketAddress = this.external_address;
        if (inetSocketAddress != null) {
            return inetSocketAddress.getPort();
        }
        return super.getLocalPort();
    }

    @Override // java.net.AbstractPlainSocketImpl, java.net.SocketImpl
    protected void close() throws IOException {
        Socket socket = this.cmdsock;
        if (socket != null) {
            socket.close();
        }
        this.cmdsock = null;
        super.close();
    }

    private String getUserName() {
        if (this.applicationSetProxy) {
            try {
                String userName = System.getProperty("user.name");
                return userName;
            } catch (SecurityException e2) {
                return "";
            }
        }
        String userName2 = (String) AccessController.doPrivileged(new GetPropertyAction("user.name"));
        return userName2;
    }
}
