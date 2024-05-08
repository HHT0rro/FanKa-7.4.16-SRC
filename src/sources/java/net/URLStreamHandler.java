package java.net;

import com.huawei.openalliance.ad.constant.u;
import java.io.IOException;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class URLStreamHandler {
    /* JADX INFO: Access modifiers changed from: protected */
    public abstract URLConnection openConnection(URL url) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public URLConnection openConnection(URL u10, Proxy p10) throws IOException {
        throw new UnsupportedOperationException("Method not implemented.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Failed to find 'out' block for switch in B:24:0x007e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x036d  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02b9 A[LOOP:1: B:72:0x02b0->B:74:0x02b9, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02d6 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void parseURL(java.net.URL r27, java.lang.String r28, int r29, int r30) {
        /*
            Method dump skipped, instructions count: 944
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.net.URLStreamHandler.parseURL(java.net.URL, java.lang.String, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getDefaultPort() {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean equals(URL u12, URL u22) {
        return Objects.equals(u12.getRef(), u22.getRef()) && Objects.equals(u12.getQuery(), u22.getQuery()) && sameFile(u12, u22);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int hashCode(URL u10) {
        return Objects.hash(u10.getRef(), u10.getQuery(), u10.getProtocol(), u10.getFile(), u10.getHost(), Integer.valueOf(u10.getPort()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean sameFile(URL u12, URL u22) {
        if (u12.getProtocol() != u22.getProtocol() && (u12.getProtocol() == null || !u12.getProtocol().equalsIgnoreCase(u22.getProtocol()))) {
            return false;
        }
        if (u12.getFile() != u22.getFile() && (u12.getFile() == null || !u12.getFile().equals(u22.getFile()))) {
            return false;
        }
        int port1 = u12.getPort() != -1 ? u12.getPort() : u12.handler.getDefaultPort();
        int port2 = u22.getPort() != -1 ? u22.getPort() : u22.handler.getDefaultPort();
        return port1 == port2 && hostsEqual(u12, u22);
    }

    protected synchronized InetAddress getHostAddress(URL u10) {
        if (u10.hostAddress != null) {
            return u10.hostAddress;
        }
        String host = u10.getHost();
        if (host == null || host.equals("")) {
            return null;
        }
        try {
            try {
                try {
                    u10.hostAddress = InetAddress.getByName(host);
                    return u10.hostAddress;
                } catch (UnknownHostException e2) {
                    return null;
                }
            } catch (SecurityException e10) {
                return null;
            }
        } catch (UnknownHostException e11) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean hostsEqual(URL u12, URL u22) {
        if (u12.getHost() == null || u22.getHost() == null) {
            return u12.getHost() == null && u22.getHost() == null;
        }
        return u12.getHost().equalsIgnoreCase(u22.getHost());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String toExternalForm(URL u10) {
        int len = u10.getProtocol().length() + 1;
        if (u10.getAuthority() != null && u10.getAuthority().length() > 0) {
            len += u10.getAuthority().length() + 2;
        }
        if (u10.getPath() != null) {
            len += u10.getPath().length();
        }
        if (u10.getQuery() != null) {
            len += u10.getQuery().length() + 1;
        }
        if (u10.getRef() != null) {
            len += u10.getRef().length() + 1;
        }
        StringBuilder result = new StringBuilder(len);
        result.append(u10.getProtocol());
        result.append(u.bD);
        if (u10.getAuthority() != null) {
            result.append("//");
            result.append(u10.getAuthority());
        }
        String fileAndQuery = u10.getFile();
        if (fileAndQuery != null) {
            result.append(fileAndQuery);
        }
        if (u10.getRef() != null) {
            result.append("#");
            result.append(u10.getRef());
        }
        return result.toString();
    }

    protected void setURL(URL u10, String protocol, String host, int port, String authority, String userInfo, String path, String query, String ref) {
        if (this != u10.handler) {
            throw new SecurityException("handler for url different from this handler");
        }
        u10.set(u10.getProtocol(), host, port, authority, userInfo, path, query, ref);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public void setURL(URL u10, String protocol, String host, int port, String file, String ref) {
        String host2;
        String authority;
        String userInfo;
        String path;
        String query;
        if (host != null && host.length() != 0) {
            String authority2 = port == -1 ? host : host + u.bD + port;
            int at = host.lastIndexOf(64);
            if (at == -1) {
                host2 = host;
                authority = authority2;
                userInfo = null;
            } else {
                String userInfo2 = host.substring(0, at);
                host2 = host.substring(at + 1);
                authority = authority2;
                userInfo = userInfo2;
            }
        } else {
            host2 = host;
            authority = null;
            userInfo = null;
        }
        if (file == null) {
            path = null;
            query = null;
        } else {
            int q10 = file.lastIndexOf(63);
            if (q10 != -1) {
                String query2 = file.substring(q10 + 1);
                String path2 = file.substring(0, q10);
                path = path2;
                query = query2;
            } else {
                path = file;
                query = null;
            }
        }
        setURL(u10, protocol, host2, port, authority, userInfo, path, query, ref);
    }
}
