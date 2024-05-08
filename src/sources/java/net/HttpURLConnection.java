package java.net;

import com.huawei.openalliance.ad.constant.u;
import java.io.IOException;
import java.io.InputStream;
import java.security.Permission;
import java.util.Date;
import org.apache.commons.lang3.time.TimeZones;
import sun.security.util.SecurityConstants;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class HttpURLConnection extends URLConnection {
    private static final int DEFAULT_CHUNK_SIZE = 4096;
    public static final int HTTP_ACCEPTED = 202;
    public static final int HTTP_BAD_GATEWAY = 502;
    public static final int HTTP_BAD_METHOD = 405;
    public static final int HTTP_BAD_REQUEST = 400;
    public static final int HTTP_CLIENT_TIMEOUT = 408;
    public static final int HTTP_CONFLICT = 409;
    public static final int HTTP_CREATED = 201;
    public static final int HTTP_ENTITY_TOO_LARGE = 413;
    public static final int HTTP_FORBIDDEN = 403;
    public static final int HTTP_GATEWAY_TIMEOUT = 504;
    public static final int HTTP_GONE = 410;
    public static final int HTTP_INTERNAL_ERROR = 500;
    public static final int HTTP_LENGTH_REQUIRED = 411;
    public static final int HTTP_MOVED_PERM = 301;
    public static final int HTTP_MOVED_TEMP = 302;
    public static final int HTTP_MULT_CHOICE = 300;
    public static final int HTTP_NOT_ACCEPTABLE = 406;
    public static final int HTTP_NOT_AUTHORITATIVE = 203;
    public static final int HTTP_NOT_FOUND = 404;
    public static final int HTTP_NOT_IMPLEMENTED = 501;
    public static final int HTTP_NOT_MODIFIED = 304;
    public static final int HTTP_NO_CONTENT = 204;
    public static final int HTTP_OK = 200;
    public static final int HTTP_PARTIAL = 206;
    public static final int HTTP_PAYMENT_REQUIRED = 402;
    public static final int HTTP_PRECON_FAILED = 412;
    public static final int HTTP_PROXY_AUTH = 407;
    public static final int HTTP_REQ_TOO_LONG = 414;
    public static final int HTTP_RESET = 205;
    public static final int HTTP_SEE_OTHER = 303;

    @Deprecated
    public static final int HTTP_SERVER_ERROR = 500;
    public static final int HTTP_UNAUTHORIZED = 401;
    public static final int HTTP_UNAVAILABLE = 503;
    public static final int HTTP_UNSUPPORTED_TYPE = 415;
    public static final int HTTP_USE_PROXY = 305;
    public static final int HTTP_VERSION = 505;
    private static boolean followRedirects = true;
    private static final String[] methods = {"GET", "POST", "HEAD", "OPTIONS", "PUT", "DELETE", "TRACE"};
    protected int chunkLength;
    protected int fixedContentLength;
    protected long fixedContentLengthLong;
    protected boolean instanceFollowRedirects;
    protected String method;
    protected int responseCode;
    protected String responseMessage;

    public abstract void disconnect();

    public abstract boolean usingProxy();

    @Override // java.net.URLConnection
    public String getHeaderFieldKey(int n10) {
        return null;
    }

    public void setFixedLengthStreamingMode(int contentLength) {
        if (this.connected) {
            throw new IllegalStateException("Already connected");
        }
        if (this.chunkLength != -1) {
            throw new IllegalStateException("Chunked encoding streaming mode set");
        }
        if (contentLength < 0) {
            throw new IllegalArgumentException("invalid content length");
        }
        this.fixedContentLength = contentLength;
    }

    public void setFixedLengthStreamingMode(long contentLength) {
        if (this.connected) {
            throw new IllegalStateException("Already connected");
        }
        if (this.chunkLength != -1) {
            throw new IllegalStateException("Chunked encoding streaming mode set");
        }
        if (contentLength < 0) {
            throw new IllegalArgumentException("invalid content length");
        }
        this.fixedContentLengthLong = contentLength;
    }

    public void setChunkedStreamingMode(int chunklen) {
        if (this.connected) {
            throw new IllegalStateException("Can't set streaming mode: already connected");
        }
        if (this.fixedContentLength != -1 || this.fixedContentLengthLong != -1) {
            throw new IllegalStateException("Fixed length streaming mode set");
        }
        this.chunkLength = chunklen <= 0 ? 4096 : chunklen;
    }

    @Override // java.net.URLConnection
    public String getHeaderField(int n10) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HttpURLConnection(URL u10) {
        super(u10);
        this.method = "GET";
        this.chunkLength = -1;
        this.fixedContentLength = -1;
        this.fixedContentLengthLong = -1L;
        this.responseCode = -1;
        this.responseMessage = null;
        this.instanceFollowRedirects = followRedirects;
    }

    public static void setFollowRedirects(boolean set) {
        SecurityManager sec = System.getSecurityManager();
        if (sec != null) {
            sec.checkSetFactory();
        }
        followRedirects = set;
    }

    public static boolean getFollowRedirects() {
        return followRedirects;
    }

    public void setInstanceFollowRedirects(boolean followRedirects2) {
        this.instanceFollowRedirects = followRedirects2;
    }

    public boolean getInstanceFollowRedirects() {
        return this.instanceFollowRedirects;
    }

    public void setRequestMethod(String method) throws ProtocolException {
        SecurityManager s2;
        if (this.connected) {
            throw new ProtocolException("Can't reset method: already connected");
        }
        int i10 = 0;
        while (true) {
            String[] strArr = methods;
            if (i10 < strArr.length) {
                if (!strArr[i10].equals(method)) {
                    i10++;
                } else {
                    if (method.equals("TRACE") && (s2 = System.getSecurityManager()) != null) {
                        s2.checkPermission(new NetPermission("allowHttpTrace"));
                    }
                    this.method = method;
                    return;
                }
            } else {
                throw new ProtocolException("Invalid HTTP method: " + method);
            }
        }
    }

    public String getRequestMethod() {
        return this.method;
    }

    public int getResponseCode() throws IOException {
        int codePos;
        int i10 = this.responseCode;
        if (i10 != -1) {
            return i10;
        }
        Exception exc = null;
        try {
            getInputStream();
        } catch (Exception e2) {
            exc = e2;
        }
        String statusLine = getHeaderField(0);
        if (statusLine == null) {
            if (exc == null) {
                return -1;
            }
            if (exc instanceof RuntimeException) {
                throw ((RuntimeException) exc);
            }
            throw ((IOException) exc);
        }
        if (statusLine.startsWith("HTTP/1.") && (codePos = statusLine.indexOf(32)) > 0) {
            int phrasePos = statusLine.indexOf(32, codePos + 1);
            if (phrasePos > 0 && phrasePos < statusLine.length()) {
                this.responseMessage = statusLine.substring(phrasePos + 1);
            }
            if (phrasePos < 0) {
                phrasePos = statusLine.length();
            }
            try {
                int parseInt = Integer.parseInt(statusLine.substring(codePos + 1, phrasePos));
                this.responseCode = parseInt;
                return parseInt;
            } catch (NumberFormatException e10) {
            }
        }
        return -1;
    }

    public String getResponseMessage() throws IOException {
        getResponseCode();
        return this.responseMessage;
    }

    @Override // java.net.URLConnection
    public long getHeaderFieldDate(String name, long Default) {
        String dateString = getHeaderField(name);
        try {
            if (dateString.indexOf(TimeZones.GMT_ID) == -1) {
                dateString = dateString + " GMT";
            }
            return Date.parse(dateString);
        } catch (Exception e2) {
            return Default;
        }
    }

    @Override // java.net.URLConnection
    public Permission getPermission() throws IOException {
        int port = this.url.getPort();
        String host = this.url.getHost() + u.bD + (port < 0 ? 80 : port);
        Permission permission = new SocketPermission(host, SecurityConstants.SOCKET_CONNECT_ACTION);
        return permission;
    }

    public InputStream getErrorStream() {
        return null;
    }
}
