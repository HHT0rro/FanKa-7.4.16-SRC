package sun.net.www.protocol.ftp;

import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Handler extends URLStreamHandler {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.URLStreamHandler
    public int getDefaultPort() {
        return 21;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.URLStreamHandler
    public boolean equals(URL u12, URL u22) {
        String userInfo1 = u12.getUserInfo();
        String userInfo2 = u22.getUserInfo();
        return super.equals(u12, u22) && (userInfo1 != null ? userInfo1.equals(userInfo2) : userInfo2 == null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.URLStreamHandler
    public URLConnection openConnection(URL u10) throws IOException {
        return openConnection(u10, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.net.URLStreamHandler
    public URLConnection openConnection(URL u10, Proxy p10) throws IOException {
        return new FtpURLConnection(u10, p10);
    }
}
