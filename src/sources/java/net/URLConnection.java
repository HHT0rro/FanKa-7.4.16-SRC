package java.net;

import com.alipay.sdk.packet.e;
import com.huawei.openalliance.ad.constant.bb;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.quickcard.base.http.ContentType;
import io.grpc.internal.GrpcUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.AccessController;
import java.security.Permission;
import java.util.Collections;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.zip.ZipUtils;
import sun.net.www.MessageHeader;
import sun.security.action.GetPropertyAction;
import sun.security.util.SecurityConstants;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class URLConnection {
    private static final String contentClassPrefix = "sun.net.www.content";
    private static final String contentPathProp = "java.content.handler.pkgs";
    static ContentHandlerFactory factory;
    private static FileNameMap fileNameMap;
    private int connectTimeout;
    private int readTimeout;
    private MessageHeader requests;
    protected URL url;
    private static boolean defaultAllowUserInteraction = false;
    private static boolean defaultUseCaches = true;
    private static Hashtable<String, ContentHandler> handlers = new Hashtable<>();
    protected boolean doInput = true;
    protected boolean doOutput = false;
    protected boolean allowUserInteraction = defaultAllowUserInteraction;
    protected boolean useCaches = defaultUseCaches;
    protected long ifModifiedSince = 0;
    protected boolean connected = false;

    public abstract void connect() throws IOException;

    public static synchronized FileNameMap getFileNameMap() {
        FileNameMap fileNameMap2;
        synchronized (URLConnection.class) {
            if (fileNameMap == null) {
                fileNameMap = new DefaultFileNameMap();
            }
            fileNameMap2 = fileNameMap;
        }
        return fileNameMap2;
    }

    public static void setFileNameMap(FileNameMap map) {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkSetFactory();
        }
        fileNameMap = map;
    }

    public void setConnectTimeout(int timeout) {
        if (timeout < 0) {
            throw new IllegalArgumentException("timeout can not be negative");
        }
        this.connectTimeout = timeout;
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public void setReadTimeout(int timeout) {
        if (timeout < 0) {
            throw new IllegalArgumentException("timeout can not be negative");
        }
        this.readTimeout = timeout;
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public URLConnection(URL url) {
        this.url = url;
    }

    public URL getURL() {
        return this.url;
    }

    public int getContentLength() {
        long l10 = getContentLengthLong();
        if (l10 > ZipUtils.UPPER_UNIXTIME_BOUND) {
            return -1;
        }
        return (int) l10;
    }

    public long getContentLengthLong() {
        return getHeaderFieldLong("content-length", -1L);
    }

    public String getContentType() {
        return getHeaderField(e.f4632d);
    }

    public String getContentEncoding() {
        return getHeaderField(GrpcUtil.CONTENT_ENCODING);
    }

    public long getExpiration() {
        return getHeaderFieldDate("expires", 0L);
    }

    public long getDate() {
        return getHeaderFieldDate("date", 0L);
    }

    public long getLastModified() {
        return getHeaderFieldDate("last-modified", 0L);
    }

    public String getHeaderField(String name) {
        return null;
    }

    public Map<String, List<String>> getHeaderFields() {
        return Collections.emptyMap();
    }

    public int getHeaderFieldInt(String name, int Default) {
        String value = getHeaderField(name);
        try {
            return Integer.parseInt(value);
        } catch (Exception e2) {
            return Default;
        }
    }

    public long getHeaderFieldLong(String name, long Default) {
        String value = getHeaderField(name);
        try {
            return Long.parseLong(value);
        } catch (Exception e2) {
            return Default;
        }
    }

    public long getHeaderFieldDate(String name, long Default) {
        String value = getHeaderField(name);
        try {
            return Date.parse(value);
        } catch (Exception e2) {
            return Default;
        }
    }

    public String getHeaderFieldKey(int n10) {
        return null;
    }

    public String getHeaderField(int n10) {
        return null;
    }

    public Object getContent() throws IOException {
        getInputStream();
        return getContentHandler().getContent(this);
    }

    public Object getContent(Class[] classes) throws IOException {
        getInputStream();
        return getContentHandler().getContent(this, classes);
    }

    public Permission getPermission() throws IOException {
        return SecurityConstants.ALL_PERMISSION;
    }

    public InputStream getInputStream() throws IOException {
        throw new UnknownServiceException("protocol doesn't support input");
    }

    public OutputStream getOutputStream() throws IOException {
        throw new UnknownServiceException("protocol doesn't support output");
    }

    public String toString() {
        return getClass().getName() + u.bD + ((Object) this.url);
    }

    public void setDoInput(boolean doinput) {
        if (this.connected) {
            throw new IllegalStateException("Already connected");
        }
        this.doInput = doinput;
    }

    public boolean getDoInput() {
        return this.doInput;
    }

    public void setDoOutput(boolean dooutput) {
        if (this.connected) {
            throw new IllegalStateException("Already connected");
        }
        this.doOutput = dooutput;
    }

    public boolean getDoOutput() {
        return this.doOutput;
    }

    public void setAllowUserInteraction(boolean allowuserinteraction) {
        if (this.connected) {
            throw new IllegalStateException("Already connected");
        }
        this.allowUserInteraction = allowuserinteraction;
    }

    public boolean getAllowUserInteraction() {
        return this.allowUserInteraction;
    }

    public static void setDefaultAllowUserInteraction(boolean defaultallowuserinteraction) {
        defaultAllowUserInteraction = defaultallowuserinteraction;
    }

    public static boolean getDefaultAllowUserInteraction() {
        return defaultAllowUserInteraction;
    }

    public void setUseCaches(boolean usecaches) {
        if (this.connected) {
            throw new IllegalStateException("Already connected");
        }
        this.useCaches = usecaches;
    }

    public boolean getUseCaches() {
        return this.useCaches;
    }

    public void setIfModifiedSince(long ifmodifiedsince) {
        if (this.connected) {
            throw new IllegalStateException("Already connected");
        }
        this.ifModifiedSince = ifmodifiedsince;
    }

    public long getIfModifiedSince() {
        return this.ifModifiedSince;
    }

    public boolean getDefaultUseCaches() {
        return defaultUseCaches;
    }

    public void setDefaultUseCaches(boolean defaultusecaches) {
        defaultUseCaches = defaultusecaches;
    }

    public void setRequestProperty(String key, String value) {
        if (this.connected) {
            throw new IllegalStateException("Already connected");
        }
        if (key == null) {
            throw new NullPointerException("key is null");
        }
        if (this.requests == null) {
            this.requests = new MessageHeader();
        }
        this.requests.set(key, value);
    }

    public void addRequestProperty(String key, String value) {
        if (this.connected) {
            throw new IllegalStateException("Already connected");
        }
        if (key == null) {
            throw new NullPointerException("key is null");
        }
        if (this.requests == null) {
            this.requests = new MessageHeader();
        }
        this.requests.add(key, value);
    }

    public String getRequestProperty(String key) {
        if (this.connected) {
            throw new IllegalStateException("Already connected");
        }
        MessageHeader messageHeader = this.requests;
        if (messageHeader == null) {
            return null;
        }
        return messageHeader.findValue(key);
    }

    public Map<String, List<String>> getRequestProperties() {
        if (this.connected) {
            throw new IllegalStateException("Already connected");
        }
        MessageHeader messageHeader = this.requests;
        if (messageHeader == null) {
            return Collections.emptyMap();
        }
        return messageHeader.getHeaders(null);
    }

    @Deprecated
    public static void setDefaultRequestProperty(String key, String value) {
    }

    @Deprecated
    public static String getDefaultRequestProperty(String key) {
        return null;
    }

    public static synchronized void setContentHandlerFactory(ContentHandlerFactory fac) {
        synchronized (URLConnection.class) {
            if (factory != null) {
                throw new Error("factory already defined");
            }
            SecurityManager security = System.getSecurityManager();
            if (security != null) {
                security.checkSetFactory();
            }
            factory = fac;
        }
    }

    synchronized ContentHandler getContentHandler() throws IOException {
        String contentType = stripOffParameters(getContentType());
        ContentHandler handler = null;
        if (contentType == null) {
            String guessContentTypeFromName = guessContentTypeFromName(this.url.getFile());
            contentType = guessContentTypeFromName;
            if (guessContentTypeFromName == null) {
                contentType = guessContentTypeFromStream(getInputStream());
            }
        }
        if (contentType == null) {
            return UnknownContentHandler.INSTANCE;
        }
        try {
            handler = handlers.get(contentType);
            if (handler != null) {
                return handler;
            }
        } catch (Exception e2) {
        }
        ContentHandlerFactory contentHandlerFactory = factory;
        if (contentHandlerFactory != null) {
            handler = contentHandlerFactory.createContentHandler(contentType);
        }
        if (handler == null) {
            try {
                handler = lookupContentHandlerClassFor(contentType);
            } catch (Exception e10) {
                e10.printStackTrace();
                handler = UnknownContentHandler.INSTANCE;
            }
            handlers.put(contentType, handler);
        }
        return handler;
    }

    private String stripOffParameters(String contentType) {
        if (contentType == null) {
            return null;
        }
        int index = contentType.indexOf(59);
        if (index > 0) {
            return contentType.substring(0, index);
        }
        return contentType;
    }

    private ContentHandler lookupContentHandlerClassFor(String contentType) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class<?> cls;
        String contentHandlerClassName = typeToPackageName(contentType);
        String contentHandlerPkgPrefixes = getContentHandlerPkgPrefixes();
        StringTokenizer packagePrefixIter = new StringTokenizer(contentHandlerPkgPrefixes, "|");
        while (packagePrefixIter.hasMoreTokens()) {
            String packagePrefix = packagePrefixIter.nextToken().trim();
            try {
                String clsName = packagePrefix + "." + contentHandlerClassName;
                cls = null;
                try {
                    cls = Class.forName(clsName);
                } catch (ClassNotFoundException e2) {
                    ClassLoader cl = ClassLoader.getSystemClassLoader();
                    if (cl != null) {
                        cls = cl.loadClass(clsName);
                    }
                }
            } catch (Exception e10) {
            }
            if (cls != null) {
                ContentHandler handler = (ContentHandler) cls.newInstance();
                return handler;
            }
            continue;
        }
        return UnknownContentHandler.INSTANCE;
    }

    private String typeToPackageName(String contentType) {
        String contentType2 = contentType.toLowerCase();
        int len = contentType2.length();
        char[] nm = new char[len];
        contentType2.getChars(0, len, nm, 0);
        for (int i10 = 0; i10 < len; i10++) {
            char c4 = nm[i10];
            if (c4 == '/') {
                nm[i10] = '.';
            } else if (('A' > c4 || c4 > 'Z') && (('a' > c4 || c4 > 'z') && ('0' > c4 || c4 > '9'))) {
                nm[i10] = '_';
            }
        }
        return new String(nm);
    }

    private String getContentHandlerPkgPrefixes() {
        String packagePrefixList = (String) AccessController.doPrivileged(new GetPropertyAction(contentPathProp, ""));
        if (packagePrefixList != "") {
            packagePrefixList = packagePrefixList + "|";
        }
        return packagePrefixList + contentClassPrefix;
    }

    public static String guessContentTypeFromName(String fname) {
        return getFileNameMap().getContentTypeFor(fname);
    }

    public static String guessContentTypeFromStream(InputStream is) throws IOException {
        int c16;
        if (!is.markSupported()) {
            return null;
        }
        is.mark(16);
        int c12 = is.read();
        int c22 = is.read();
        int c32 = is.read();
        int c4 = is.read();
        int c52 = is.read();
        int c62 = is.read();
        int c72 = is.read();
        int c82 = is.read();
        int c92 = is.read();
        int c10 = is.read();
        int c11 = is.read();
        int c122 = is.read();
        int c13 = is.read();
        int c14 = is.read();
        int c15 = is.read();
        int c162 = is.read();
        is.reset();
        if (c12 == 202 && c22 == 254 && c32 == 186 && c4 == 190) {
            return "application/java-vm";
        }
        if (c12 == 172 && c22 == 237) {
            return "application/x-java-serialized-object";
        }
        if (c12 == 60) {
            if (c22 == 33) {
                return "text/html";
            }
            if (c22 == 104) {
                if (c32 == 116 && c4 == 109 && c52 == 108) {
                    return "text/html";
                }
                if (c32 == 101 && c4 == 97 && c52 == 100) {
                    return "text/html";
                }
            }
            if (c22 == 98 && c32 == 111 && c4 == 100 && c52 == 121) {
                return "text/html";
            }
            if (c22 == 72) {
                if (c32 == 84 && c4 == 77 && c52 == 76) {
                    return "text/html";
                }
                if (c32 == 69 && c4 == 65 && c52 == 68) {
                    return "text/html";
                }
            }
            if (c22 == 66 && c32 == 79 && c4 == 68 && c52 == 89) {
                return "text/html";
            }
            if (c22 == 63 && c32 == 120 && c4 == 109 && c52 == 108 && c62 == 32) {
                return ContentType.XML;
            }
        }
        if (c12 == 239 && c22 == 187 && c32 == 191 && c4 == 60 && c52 == 63 && c62 == 120) {
            return ContentType.XML;
        }
        if (c12 == 254 && c22 == 255 && c32 == 0 && c4 == 60 && c52 == 0 && c62 == 63 && c72 == 0 && c82 == 120) {
            return ContentType.XML;
        }
        if (c12 == 255 && c22 == 254 && c32 == 60 && c4 == 0 && c52 == 63 && c62 == 0 && c72 == 120 && c82 == 0) {
            return ContentType.XML;
        }
        if (c12 != 0 || c22 != 0 || c32 != 254 || c4 != 255) {
            c16 = c162;
        } else if (c52 == 0 && c62 == 0 && c72 == 0 && c82 == 60 && c92 == 0 && c10 == 0 && c11 == 0 && c122 == 63 && c13 == 0 && c14 == 0 && c15 == 0) {
            c16 = c162;
            if (c16 == 120) {
                return ContentType.XML;
            }
        } else {
            c16 = c162;
        }
        if (c12 == 255 && c22 == 254 && c32 == 0 && c4 == 0 && c52 == 60 && c62 == 0 && c72 == 0 && c82 == 0 && c92 == 63 && c10 == 0 && c11 == 0 && c122 == 0 && c13 == 120 && c14 == 0 && c15 == 0 && c16 == 0) {
            return ContentType.XML;
        }
        if (c12 == 71 && c22 == 73 && c32 == 70 && c4 == 56) {
            return bb.B;
        }
        if (c12 == 35 && c22 == 100 && c32 == 101 && c4 == 102) {
            return "image/x-bitmap";
        }
        if (c12 == 33 && c22 == 32 && c32 == 88 && c4 == 80 && c52 == 77 && c62 == 50) {
            return "image/x-pixmap";
        }
        if (c12 == 137 && c22 == 80 && c32 == 78 && c4 == 71 && c52 == 13 && c62 == 10 && c72 == 26 && c82 == 10) {
            return bb.Z;
        }
        if (c12 == 255 && c22 == 216 && c32 == 255) {
            if (c4 == 224 || c4 == 238) {
                return bb.V;
            }
            if (c4 == 225 && c72 == 69 && c82 == 120 && c92 == 105 && c10 == 102 && c11 == 0) {
                return bb.V;
            }
        }
        if (c12 == 208 && c22 == 207 && c32 == 17 && c4 == 224 && c52 == 161 && c62 == 177 && c72 == 26 && c82 == 225 && checkfpx(is)) {
            return "image/vnd.fpx";
        }
        if (c12 == 46 && c22 == 115 && c32 == 110 && c4 == 100) {
            return "audio/basic";
        }
        if (c12 == 100 && c22 == 110 && c32 == 115 && c4 == 46) {
            return "audio/basic";
        }
        if (c12 == 82 && c22 == 73 && c32 == 70 && c4 == 70) {
            return "audio/x-wav";
        }
        return null;
    }

    private static boolean checkfpx(InputStream is) throws IOException {
        int uSectorShift;
        int sectDirStart;
        is.mark(256);
        long posn = skipForward(is, 28L);
        if (posn < 28) {
            is.reset();
            return false;
        }
        int[] c4 = new int[16];
        if (readBytes(c4, 2, is) < 0) {
            is.reset();
            return false;
        }
        int byteOrder = c4[0];
        long posn2 = posn + 2;
        if (readBytes(c4, 2, is) < 0) {
            is.reset();
            return false;
        }
        if (byteOrder == 254) {
            int uSectorShift2 = c4[0];
            uSectorShift = uSectorShift2 + (c4[1] << 8);
        } else {
            int uSectorShift3 = c4[0];
            uSectorShift = (uSectorShift3 << 8) + c4[1];
        }
        long posn3 = posn2 + 2;
        long toSkip = 48 - posn3;
        long skipped = skipForward(is, toSkip);
        if (skipped < toSkip) {
            is.reset();
            return false;
        }
        long posn4 = posn3 + skipped;
        if (readBytes(c4, 4, is) >= 0) {
            if (byteOrder == 254) {
                int sectDirStart2 = c4[0];
                sectDirStart = sectDirStart2 + (c4[1] << 8) + (c4[2] << 16) + (c4[3] << 24);
            } else {
                int sectDirStart3 = c4[0];
                sectDirStart = (sectDirStart3 << 24) + (c4[1] << 16) + (c4[2] << 8) + c4[3];
            }
            long j10 = posn4 + 4;
            is.reset();
            long toSkip2 = ((1 << uSectorShift) * sectDirStart) + 512 + 80;
            if (toSkip2 < 0) {
                return false;
            }
            is.mark(((int) toSkip2) + 48);
            if (skipForward(is, toSkip2) >= toSkip2) {
                if (readBytes(c4, 16, is) >= 0) {
                    if (byteOrder == 254 && c4[0] == 0 && c4[2] == 97 && c4[3] == 86 && c4[4] == 84 && c4[5] == 193 && c4[6] == 206 && c4[7] == 17 && c4[8] == 133 && c4[9] == 83 && c4[10] == 0 && c4[11] == 170 && c4[12] == 0 && c4[13] == 161 && c4[14] == 249 && c4[15] == 91) {
                        is.reset();
                        return true;
                    }
                    if (c4[3] == 0 && c4[1] == 97 && c4[0] == 86 && c4[5] == 84 && c4[4] == 193 && c4[7] == 206 && c4[6] == 17 && c4[8] == 133 && c4[9] == 83 && c4[10] == 0 && c4[11] == 170 && c4[12] == 0 && c4[13] == 161 && c4[14] == 249 && c4[15] == 91) {
                        is.reset();
                        return true;
                    }
                    is.reset();
                    return false;
                }
                is.reset();
                return false;
            }
            is.reset();
            return false;
        }
        is.reset();
        return false;
    }

    private static int readBytes(int[] c4, int len, InputStream is) throws IOException {
        byte[] buf = new byte[len];
        if (is.read(buf, 0, len) < len) {
            return -1;
        }
        for (int i10 = 0; i10 < len; i10++) {
            c4[i10] = buf[i10] & 255;
        }
        return 0;
    }

    private static long skipForward(InputStream is, long toSkip) throws IOException {
        long skipped = 0;
        while (skipped != toSkip) {
            long eachSkip = is.skip(toSkip - skipped);
            if (eachSkip <= 0) {
                if (is.read() == -1) {
                    return skipped;
                }
                skipped++;
            }
            skipped += eachSkip;
        }
        return skipped;
    }
}
