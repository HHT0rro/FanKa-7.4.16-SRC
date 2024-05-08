package java.util.logging;

import com.huawei.openalliance.ad.constant.u;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import libcore.net.NetworkSecurityPolicy;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class SocketHandler extends StreamHandler {
    private String host;
    private int port;
    private Socket sock;

    private void configure() {
        LogManager manager = LogManager.getLogManager();
        String cname = getClass().getName();
        setLevel(manager.getLevelProperty(cname + ".level", Level.ALL));
        setFilter(manager.getFilterProperty(cname + ".filter", null));
        setFormatter(manager.getFormatterProperty(cname + ".formatter", new XMLFormatter()));
        try {
            setEncoding(manager.getStringProperty(cname + ".encoding", null));
        } catch (Exception e2) {
            try {
                setEncoding(null);
            } catch (Exception e10) {
            }
        }
        this.port = manager.getIntProperty(cname + ".port", 0);
        this.host = manager.getStringProperty(cname + ".host", null);
    }

    public SocketHandler() throws IOException {
        this.sealed = false;
        configure();
        try {
            connect();
            this.sealed = true;
        } catch (IOException ix) {
            System.err.println("SocketHandler: connect failed to " + this.host + u.bD + this.port);
            throw ix;
        }
    }

    public SocketHandler(String host, int port) throws IOException {
        this.sealed = false;
        configure();
        this.sealed = true;
        this.port = port;
        this.host = host;
        connect();
    }

    private void connect() throws IOException {
        if (this.port == 0) {
            throw new IllegalArgumentException("Bad port: " + this.port);
        }
        if (this.host == null) {
            throw new IllegalArgumentException("Null host name: " + this.host);
        }
        if (!NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
            throw new IOException("Cleartext traffic not permitted");
        }
        Socket socket = new Socket(this.host, this.port);
        this.sock = socket;
        OutputStream out = socket.getOutputStream();
        BufferedOutputStream bout = new BufferedOutputStream(out);
        setOutputStream(bout);
    }

    @Override // java.util.logging.StreamHandler, java.util.logging.Handler
    public synchronized void close() throws SecurityException {
        super.close();
        Socket socket = this.sock;
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e2) {
            }
        }
        this.sock = null;
    }

    @Override // java.util.logging.StreamHandler, java.util.logging.Handler
    public synchronized void publish(LogRecord record) {
        if (isLoggable(record)) {
            super.publish(record);
            flush();
        }
    }
}
