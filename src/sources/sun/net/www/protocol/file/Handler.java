package sun.net.www.protocol.file;

import java.io.File;
import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import org.apache.commons.io.IOUtils;
import sun.net.www.ParseUtil;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Handler extends URLStreamHandler {
    private String getHost(URL url) {
        String host = url.getHost();
        if (host == null) {
            return "";
        }
        return host;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.URLStreamHandler
    public void parseURL(URL u10, String spec, int start, int limit) {
        super.parseURL(u10, spec.replace(File.separatorChar, IOUtils.DIR_SEPARATOR_UNIX), start, limit);
    }

    @Override // java.net.URLStreamHandler
    public synchronized URLConnection openConnection(URL u10) throws IOException {
        return openConnection(u10, null);
    }

    @Override // java.net.URLStreamHandler
    public synchronized URLConnection openConnection(URL u10, Proxy p10) throws IOException {
        URLConnection uc2;
        String host = u10.getHost();
        if (host == null || host.equals("") || host.equals("~") || host.equalsIgnoreCase("localhost")) {
            File file = new File(ParseUtil.decode(u10.getPath()));
            return createFileURLConnection(u10, file);
        }
        try {
            URL ru = new URL("ftp", host, u10.getFile() + (u10.getRef() == null ? "" : "#" + u10.getRef()));
            if (p10 != null) {
                uc2 = ru.openConnection(p10);
            } else {
                uc2 = ru.openConnection();
            }
        } catch (IOException e2) {
            uc2 = null;
        }
        if (uc2 != null) {
            return uc2;
        }
        throw new IOException("Unable to connect to: " + u10.toExternalForm());
    }

    protected URLConnection createFileURLConnection(URL u10, File file) {
        return new FileURLConnection(u10, file);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.URLStreamHandler
    public boolean hostsEqual(URL u12, URL u22) {
        String s12 = u12.getHost();
        String s2 = u22.getHost();
        if ("localhost".equalsIgnoreCase(s12) && (s2 == null || "".equals(s2))) {
            return true;
        }
        if ("localhost".equalsIgnoreCase(s2) && (s12 == null || "".equals(s12))) {
            return true;
        }
        return super.hostsEqual(u12, u22);
    }
}
