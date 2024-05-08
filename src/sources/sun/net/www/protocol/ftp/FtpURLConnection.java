package sun.net.www.protocol.ftp;

import com.huawei.openalliance.ad.constant.u;
import com.kuaishou.weapon.p0.t;
import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketPermission;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.AccessController;
import java.security.Permission;
import java.security.PrivilegedAction;
import java.util.Iterator;
import java.util.StringTokenizer;
import libcore.net.NetworkSecurityPolicy;
import sun.net.ftp.FtpClient;
import sun.net.ftp.FtpLoginException;
import sun.net.ftp.FtpProtocolException;
import sun.net.www.ParseUtil;
import sun.net.www.URLConnection;
import sun.security.action.GetPropertyAction;
import sun.security.util.SecurityConstants;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class FtpURLConnection extends URLConnection {
    static final int ASCII = 1;
    static final int BIN = 2;
    static final int DIR = 3;
    static final int NONE = 0;
    private int connectTimeout;
    String filename;
    FtpClient ftp;
    String fullpath;
    String host;
    private Proxy instProxy;
    InputStream is;
    OutputStream os;
    String password;
    String pathname;
    Permission permission;
    int port;
    private int readTimeout;
    int type;
    String user;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    protected class FtpInputStream extends FilterInputStream {
        FtpClient ftp;

        FtpInputStream(FtpClient cl, InputStream fd2) {
            super(new BufferedInputStream(fd2));
            this.ftp = cl;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            FtpClient ftpClient = this.ftp;
            if (ftpClient != null) {
                ftpClient.close();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    protected class FtpOutputStream extends FilterOutputStream {
        FtpClient ftp;

        FtpOutputStream(FtpClient cl, OutputStream fd2) {
            super(fd2);
            this.ftp = cl;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            FtpClient ftpClient = this.ftp;
            if (ftpClient != null) {
                ftpClient.close();
            }
        }
    }

    public FtpURLConnection(URL url) throws IOException {
        this(url, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FtpURLConnection(URL url, Proxy p10) throws IOException {
        super(url);
        this.is = null;
        this.os = null;
        this.ftp = null;
        this.type = 0;
        this.connectTimeout = -1;
        this.readTimeout = -1;
        this.instProxy = p10;
        this.host = url.getHost();
        this.port = url.getPort();
        String userInfo = url.getUserInfo();
        if (!NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
            throw new IOException("Cleartext traffic not permitted: " + url.getProtocol() + "://" + this.host + (url.getPort() >= 0 ? u.bD + url.getPort() : ""));
        }
        if (userInfo != null) {
            int delimiter = userInfo.indexOf(58);
            if (delimiter != -1) {
                this.user = ParseUtil.decode(userInfo.substring(0, delimiter));
                this.password = ParseUtil.decode(userInfo.substring(delimiter + 1));
            } else {
                this.user = ParseUtil.decode(userInfo);
                this.password = null;
            }
        }
    }

    private void setTimeouts() {
        FtpClient ftpClient = this.ftp;
        if (ftpClient != null) {
            int i10 = this.connectTimeout;
            if (i10 >= 0) {
                ftpClient.setConnectTimeout(i10);
            }
            int i11 = this.readTimeout;
            if (i11 >= 0) {
                this.ftp.setReadTimeout(i11);
            }
        }
    }

    @Override // java.net.URLConnection
    public synchronized void connect() throws IOException {
        if (this.connected) {
            return;
        }
        Proxy p10 = null;
        Proxy proxy = this.instProxy;
        if (proxy == null) {
            ProxySelector sel = (ProxySelector) AccessController.doPrivileged(new PrivilegedAction<ProxySelector>() { // from class: sun.net.www.protocol.ftp.FtpURLConnection.1
                @Override // java.security.PrivilegedAction
                public ProxySelector run() {
                    return ProxySelector.getDefault();
                }
            });
            if (sel != null) {
                URI uri = ParseUtil.toURI(this.url);
                Iterator<Proxy> it = sel.select(uri).iterator2();
                while (it.hasNext() && (p10 = it.next()) != null && p10 != Proxy.NO_PROXY && p10.type() != Proxy.Type.SOCKS) {
                    if (p10.type() == Proxy.Type.HTTP && (p10.address() instanceof InetSocketAddress)) {
                        sel.connectFailed(uri, p10.address(), new IOException("FTP connections over HTTP proxy not supported"));
                    }
                    sel.connectFailed(uri, p10.address(), new IOException("Wrong proxy type"));
                }
            }
        } else {
            p10 = proxy;
        }
        if (this.user == null) {
            this.user = "anonymous";
            String vers = (String) AccessController.doPrivileged(new GetPropertyAction("java.version"));
            this.password = (String) AccessController.doPrivileged(new GetPropertyAction("ftp.protocol.user", "Java" + vers + "@"));
        }
        try {
            try {
                FtpClient create = FtpClient.create();
                this.ftp = create;
                if (p10 != null) {
                    create.setProxy(p10);
                }
                setTimeouts();
                if (this.port != -1) {
                    this.ftp.connect(new InetSocketAddress(this.host, this.port));
                } else {
                    this.ftp.connect(new InetSocketAddress(this.host, FtpClient.defaultPort()));
                }
                try {
                    FtpClient ftpClient = this.ftp;
                    String str = this.user;
                    String str2 = this.password;
                    ftpClient.login(str, str2 == null ? null : str2.toCharArray());
                    this.connected = true;
                } catch (FtpProtocolException e2) {
                    this.ftp.close();
                    throw new FtpLoginException("Invalid username/password");
                }
            } catch (UnknownHostException e10) {
                throw e10;
            }
        } catch (FtpProtocolException fe2) {
            throw new IOException(fe2);
        }
    }

    private void decodePath(String path) {
        int i10 = path.indexOf(";type=");
        if (i10 >= 0) {
            String s12 = path.substring(i10 + 6, path.length());
            if (t.f36220e.equalsIgnoreCase(s12)) {
                this.type = 2;
            }
            if ("a".equalsIgnoreCase(s12)) {
                this.type = 1;
            }
            if ("d".equalsIgnoreCase(s12)) {
                this.type = 3;
            }
            path = path.substring(0, i10);
        }
        if (path != null && path.length() > 1 && path.charAt(0) == '/') {
            path = path.substring(1);
        }
        if (path == null || path.length() == 0) {
            path = "./";
        }
        if (path.endsWith("/")) {
            this.pathname = path.substring(0, path.length() - 1);
            this.filename = null;
        } else {
            int i11 = path.lastIndexOf(47);
            if (i11 > 0) {
                String substring = path.substring(i11 + 1, path.length());
                this.filename = substring;
                this.filename = ParseUtil.decode(substring);
                this.pathname = path.substring(0, i11);
            } else {
                this.filename = ParseUtil.decode(path);
                this.pathname = null;
            }
        }
        if (this.pathname != null) {
            StringBuilder append = new StringBuilder().append(this.pathname).append("/");
            String str = this.filename;
            if (str == null) {
                str = "";
            }
            this.fullpath = append.append(str).toString();
            return;
        }
        this.fullpath = this.filename;
    }

    private void cd(String path) throws FtpProtocolException, IOException {
        if (path == null || path.isEmpty()) {
            return;
        }
        if (path.indexOf(47) == -1) {
            this.ftp.changeDirectory(ParseUtil.decode(path));
            return;
        }
        StringTokenizer token = new StringTokenizer(path, "/");
        while (token.hasMoreTokens()) {
            this.ftp.changeDirectory(ParseUtil.decode(token.nextToken()));
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:10|(2:11|12)|(9:17|(1:19)(1:42)|20|21|22|(3:24|(1:26)|27)|(1:30)(3:33|(1:37)|(1:39))|31|32)|43|(1:45)(1:46)|21|22|(0)|(0)(0)|31|32) */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b7, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b8, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0095 A[Catch: Exception -> 0x00b7, FtpProtocolException -> 0x00e6, FileNotFoundException -> 0x00ed, TryCatch #2 {Exception -> 0x00b7, blocks: (B:22:0x0080, B:24:0x0095, B:26:0x00a2, B:27:0x00ad), top: B:21:0x0080, outer: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bd A[Catch: FtpProtocolException -> 0x00e6, FileNotFoundException -> 0x00ed, TryCatch #5 {FileNotFoundException -> 0x00ed, FtpProtocolException -> 0x00e6, blocks: (B:12:0x0021, B:14:0x002e, B:19:0x0037, B:20:0x0042, B:22:0x0080, B:24:0x0095, B:26:0x00a2, B:27:0x00ad, B:30:0x00bd, B:33:0x00c4, B:35:0x00d1, B:37:0x00d9, B:39:0x00e2, B:41:0x00b8, B:42:0x003d, B:43:0x0057, B:45:0x0065, B:46:0x0073), top: B:11:0x0021, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c4 A[Catch: FtpProtocolException -> 0x00e6, FileNotFoundException -> 0x00ed, TryCatch #5 {FileNotFoundException -> 0x00ed, FtpProtocolException -> 0x00e6, blocks: (B:12:0x0021, B:14:0x002e, B:19:0x0037, B:20:0x0042, B:22:0x0080, B:24:0x0095, B:26:0x00a2, B:27:0x00ad, B:30:0x00bd, B:33:0x00c4, B:35:0x00d1, B:37:0x00d9, B:39:0x00e2, B:41:0x00b8, B:42:0x003d, B:43:0x0057, B:45:0x0065, B:46:0x0073), top: B:11:0x0021, inners: #2 }] */
    @Override // java.net.URLConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.io.InputStream getInputStream() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.protocol.ftp.FtpURLConnection.getInputStream():java.io.InputStream");
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        if (!this.connected) {
            connect();
        }
        if (this.is != null) {
            throw new IOException("Already opened for input");
        }
        OutputStream outputStream = this.os;
        if (outputStream != null) {
            return outputStream;
        }
        decodePath(this.url.getPath());
        String str = this.filename;
        if (str == null || str.length() == 0) {
            throw new IOException("illegal filename for a PUT");
        }
        try {
            String str2 = this.pathname;
            if (str2 != null) {
                cd(str2);
            }
            if (this.type == 1) {
                this.ftp.setAsciiType();
            } else {
                this.ftp.setBinaryType();
            }
            FtpClient ftpClient = this.ftp;
            FtpOutputStream ftpOutputStream = new FtpOutputStream(ftpClient, ftpClient.putFileStream(this.filename, false));
            this.os = ftpOutputStream;
            return ftpOutputStream;
        } catch (FtpProtocolException e2) {
            throw new IOException(e2);
        }
    }

    String guessContentTypeFromFilename(String fname) {
        return guessContentTypeFromName(fname);
    }

    @Override // java.net.URLConnection
    public Permission getPermission() {
        if (this.permission == null) {
            int urlport = this.url.getPort();
            String urlhost = this.host + u.bD + (urlport < 0 ? FtpClient.defaultPort() : urlport);
            this.permission = new SocketPermission(urlhost, SecurityConstants.SOCKET_CONNECT_ACTION);
        }
        return this.permission;
    }

    @Override // sun.net.www.URLConnection, java.net.URLConnection
    public void setRequestProperty(String key, String value) {
        super.setRequestProperty(key, value);
        if ("type".equals(key)) {
            if (t.f36220e.equalsIgnoreCase(value)) {
                this.type = 2;
            } else if ("a".equalsIgnoreCase(value)) {
                this.type = 1;
            } else {
                if ("d".equalsIgnoreCase(value)) {
                    this.type = 3;
                    return;
                }
                throw new IllegalArgumentException("Value of '" + key + "' request property was '" + value + "' when it must be either 'i', 'a' or 'd'");
            }
        }
    }

    @Override // sun.net.www.URLConnection, java.net.URLConnection
    public String getRequestProperty(String key) {
        String value = super.getRequestProperty(key);
        if (value == null && "type".equals(key)) {
            int i10 = this.type;
            return i10 == 1 ? "a" : i10 == 3 ? "d" : t.f36220e;
        }
        return value;
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int timeout) {
        if (timeout < 0) {
            throw new IllegalArgumentException("timeouts can't be negative");
        }
        this.connectTimeout = timeout;
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        int i10 = this.connectTimeout;
        if (i10 < 0) {
            return 0;
        }
        return i10;
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int timeout) {
        if (timeout < 0) {
            throw new IllegalArgumentException("timeouts can't be negative");
        }
        this.readTimeout = timeout;
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        int i10 = this.readTimeout;
        if (i10 < 0) {
            return 0;
        }
        return i10;
    }
}
