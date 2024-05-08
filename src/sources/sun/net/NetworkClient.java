package sun.net;

import androidx.exifinterface.media.ExifInterface;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamConstants;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import okio.Utf8;
import sun.security.util.DerValue;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class NetworkClient {
    public static final int DEFAULT_CONNECT_TIMEOUT = -1;
    public static final int DEFAULT_READ_TIMEOUT = -1;
    protected static int defaultConnectTimeout;
    protected static int defaultSoTimeout;
    protected static String encoding;
    public InputStream serverInput;
    public PrintStream serverOutput;
    protected Proxy proxy = Proxy.NO_PROXY;
    protected Socket serverSocket = null;
    protected int readTimeout = -1;
    protected int connectTimeout = -1;

    static {
        final int[] vals = {0, 0};
        final String[] encs = {null};
        AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: sun.net.NetworkClient.1
            @Override // java.security.PrivilegedAction
            public Void run() {
                vals[0] = Integer.getInteger("sun.net.client.defaultReadTimeout", 0).intValue();
                vals[1] = Integer.getInteger("sun.net.client.defaultConnectTimeout", 0).intValue();
                encs[0] = System.getProperty("file.encoding", "ISO8859_1");
                return null;
            }
        });
        if (vals[0] != 0) {
            defaultSoTimeout = vals[0];
        }
        if (vals[1] != 0) {
            defaultConnectTimeout = vals[1];
        }
        String str = encs[0];
        encoding = str;
        try {
            if (!isASCIISuperset(str)) {
                encoding = "ISO8859_1";
            }
        } catch (Exception e2) {
            encoding = "ISO8859_1";
        }
    }

    private static boolean isASCIISuperset(String encoding2) throws Exception {
        byte[] chkB = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, ObjectStreamConstants.TC_REFERENCE, ObjectStreamConstants.TC_CLASSDESC, ObjectStreamConstants.TC_OBJECT, ObjectStreamConstants.TC_STRING, ObjectStreamConstants.TC_ARRAY, ObjectStreamConstants.TC_CLASS, ObjectStreamConstants.TC_BLOCKDATA, ObjectStreamConstants.TC_ENDBLOCKDATA, ObjectStreamConstants.TC_RESET, ObjectStreamConstants.TC_BLOCKDATALONG, 45, 95, 46, 33, 126, ExifInterface.START_CODE, 39, 40, 41, 59, 47, Utf8.REPLACEMENT_BYTE, 58, DerValue.TAG_APPLICATION, 38, 61, 43, 36, 44};
        byte[] b4 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz-_.!~*'();/?:@&=+$,".getBytes(encoding2);
        return Arrays.equals(b4, chkB);
    }

    public void openServer(String server, int port) throws IOException, UnknownHostException {
        if (this.serverSocket != null) {
            closeServer();
        }
        Socket doConnect = doConnect(server, port);
        this.serverSocket = doConnect;
        try {
            this.serverOutput = new PrintStream((OutputStream) new BufferedOutputStream(doConnect.getOutputStream()), true, encoding);
            this.serverInput = new BufferedInputStream(this.serverSocket.getInputStream());
        } catch (UnsupportedEncodingException e2) {
            throw new InternalError(encoding + "encoding not found", e2);
        }
    }

    protected Socket doConnect(String server, int port) throws IOException, UnknownHostException {
        Socket s2;
        Proxy proxy = this.proxy;
        if (proxy != null) {
            if (proxy.type() == Proxy.Type.SOCKS) {
                s2 = (Socket) AccessController.doPrivileged(new PrivilegedAction<Socket>() { // from class: sun.net.NetworkClient.2
                    @Override // java.security.PrivilegedAction
                    public Socket run() {
                        return new Socket(NetworkClient.this.proxy);
                    }
                });
            } else if (this.proxy.type() == Proxy.Type.DIRECT) {
                s2 = createSocket();
            } else {
                s2 = new Socket(Proxy.NO_PROXY);
            }
        } else {
            s2 = createSocket();
        }
        if (this.connectTimeout >= 0) {
            s2.connect(new InetSocketAddress(server, port), this.connectTimeout);
        } else if (defaultConnectTimeout > 0) {
            s2.connect(new InetSocketAddress(server, port), defaultConnectTimeout);
        } else {
            s2.connect(new InetSocketAddress(server, port));
        }
        int i10 = this.readTimeout;
        if (i10 >= 0) {
            s2.setSoTimeout(i10);
        } else {
            int i11 = defaultSoTimeout;
            if (i11 > 0) {
                s2.setSoTimeout(i11);
            }
        }
        return s2;
    }

    protected Socket createSocket() throws IOException {
        return new Socket();
    }

    protected InetAddress getLocalAddress() throws IOException {
        if (this.serverSocket == null) {
            throw new IOException("not connected");
        }
        return (InetAddress) AccessController.doPrivileged(new PrivilegedAction<InetAddress>() { // from class: sun.net.NetworkClient.3
            @Override // java.security.PrivilegedAction
            public InetAddress run() {
                return NetworkClient.this.serverSocket.getLocalAddress();
            }
        });
    }

    public void closeServer() throws IOException {
        if (!serverIsOpen()) {
            return;
        }
        this.serverSocket.close();
        this.serverSocket = null;
        this.serverInput = null;
        this.serverOutput = null;
    }

    public boolean serverIsOpen() {
        return this.serverSocket != null;
    }

    public NetworkClient(String host, int port) throws IOException {
        openServer(host, port);
    }

    public NetworkClient() {
    }

    public void setConnectTimeout(int timeout) {
        this.connectTimeout = timeout;
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public void setReadTimeout(int timeout) {
        if (timeout == -1) {
            timeout = defaultSoTimeout;
        }
        Socket socket = this.serverSocket;
        if (socket != null && timeout >= 0) {
            try {
                socket.setSoTimeout(timeout);
            } catch (IOException e2) {
            }
        }
        this.readTimeout = timeout;
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }
}
