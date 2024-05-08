package java.net;

import com.huawei.appgallery.agd.common.constant.SymbolValues;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.quickcard.framework.bean.CardElement;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.net.Proxy;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.SeempLog;
import java.util.Set;
import java.util.StringTokenizer;
import sun.net.ApplicationProxy;
import sun.net.www.protocol.file.Handler;
import sun.security.util.SecurityConstants;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class URL implements Serializable {
    static URLStreamHandlerFactory factory = null;
    private static final String protocolPathProp = "java.protocol.handler.pkgs";
    static final long serialVersionUID = -7627629688361524110L;
    private String authority;
    private String file;
    transient URLStreamHandler handler;
    private int hashCode;
    private String host;
    transient InetAddress hostAddress;
    private transient String path;
    private int port;
    private String protocol;
    private transient String query;
    private String ref;
    private transient UrlDeserializedState tempState;
    private transient String userInfo;
    private static final Set<String> BUILTIN_HANDLER_CLASS_NAMES = createBuiltinHandlerClassNames();
    static Hashtable<String, URLStreamHandler> handlers = new Hashtable<>();
    private static Object streamHandlerLock = new Object();
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("protocol", String.class), new ObjectStreamField("host", String.class), new ObjectStreamField("port", Integer.TYPE), new ObjectStreamField("authority", String.class), new ObjectStreamField("file", String.class), new ObjectStreamField(CardElement.Field.REF, String.class)};

    public URL(String protocol, String host, int port, String file) throws MalformedURLException {
        this(protocol, host, port, file, null);
    }

    public URL(String protocol, String host, String file) throws MalformedURLException {
        this(protocol, host, -1, file);
    }

    public URL(String protocol, String host, int port, String file, URLStreamHandler handler) throws MalformedURLException {
        SecurityManager sm;
        this.port = -1;
        this.hashCode = -1;
        if (handler != null && (sm = System.getSecurityManager()) != null) {
            checkSpecifyHandler(sm);
        }
        String protocol2 = protocol.toLowerCase();
        this.protocol = protocol2;
        if (host != null) {
            if (host.indexOf(58) >= 0 && !host.startsWith("[")) {
                host = "[" + host + "]";
            }
            this.host = host;
            if (port < -1) {
                throw new MalformedURLException("Invalid port number :" + port);
            }
            this.port = port;
            this.authority = port == -1 ? host : host + u.bD + port;
        }
        Parts parts = new Parts(file, host);
        this.path = parts.getPath();
        String query = parts.getQuery();
        this.query = query;
        if (query != null) {
            this.file = this.path + SymbolValues.QUESTION_EN_SYMBOL + this.query;
        } else {
            this.file = this.path;
        }
        this.ref = parts.getRef();
        if (handler == null) {
            URLStreamHandler uRLStreamHandler = getURLStreamHandler(protocol2);
            handler = uRLStreamHandler;
            if (uRLStreamHandler == null) {
                throw new MalformedURLException("unknown protocol: " + protocol2);
            }
        }
        this.handler = handler;
    }

    public URL(String spec) throws MalformedURLException {
        this(null, spec);
    }

    public URL(URL context, String spec) throws MalformedURLException {
        this(context, spec, (URLStreamHandler) null);
    }

    public URL(URL context, String spec, URLStreamHandler handler) throws MalformedURLException {
        SecurityManager sm;
        this.port = -1;
        this.hashCode = -1;
        int start = 0;
        String newProtocol = null;
        boolean aRef = false;
        boolean isRelative = false;
        if (handler != null && (sm = System.getSecurityManager()) != null) {
            checkSpecifyHandler(sm);
        }
        try {
            int limit = spec.length();
            while (limit > 0 && spec.charAt(limit - 1) <= ' ') {
                limit--;
            }
            while (start < limit && spec.charAt(start) <= ' ') {
                start++;
            }
            start = spec.regionMatches(true, start, "url:", 0, 4) ? start + 4 : start;
            if (start < spec.length() && spec.charAt(start) == '#') {
                aRef = true;
            }
            int i10 = start;
            while (true) {
                if (aRef || i10 >= limit) {
                    break;
                }
                int c4 = spec.charAt(i10);
                if (c4 == 47) {
                    break;
                }
                if (c4 != 58) {
                    i10++;
                } else {
                    String s2 = spec.substring(start, i10).toLowerCase();
                    if (isValidProtocol(s2)) {
                        newProtocol = s2;
                        start = i10 + 1;
                    }
                }
            }
            this.protocol = newProtocol;
            if (context != null && (newProtocol == null || newProtocol.equalsIgnoreCase(context.protocol))) {
                handler = handler == null ? context.handler : handler;
                String str = context.path;
                if (str != null && str.startsWith("/")) {
                    newProtocol = null;
                }
                if (newProtocol == null) {
                    this.protocol = context.protocol;
                    this.authority = context.authority;
                    this.userInfo = context.userInfo;
                    this.host = context.host;
                    this.port = context.port;
                    this.file = context.file;
                    this.path = context.path;
                    isRelative = true;
                }
            }
            String str2 = this.protocol;
            if (str2 == null) {
                throw new MalformedURLException("no protocol: " + spec);
            }
            if (handler == null) {
                URLStreamHandler uRLStreamHandler = getURLStreamHandler(str2);
                handler = uRLStreamHandler;
                if (uRLStreamHandler == null) {
                    throw new MalformedURLException("unknown protocol: " + this.protocol);
                }
            }
            this.handler = handler;
            int i11 = spec.indexOf(35, start);
            if (i11 >= 0) {
                this.ref = spec.substring(i11 + 1, limit);
                limit = i11;
            }
            if (isRelative && start == limit) {
                this.query = context.query;
                if (this.ref == null) {
                    this.ref = context.ref;
                }
            }
            handler.parseURL(this, spec, start, limit);
        } catch (MalformedURLException e2) {
            throw e2;
        } catch (Exception e10) {
            MalformedURLException exception = new MalformedURLException(e10.getMessage());
            exception.initCause(e10);
            throw exception;
        }
    }

    private boolean isValidProtocol(String protocol) {
        int len = protocol.length();
        if (len < 1 || !Character.isLetter(protocol.charAt(0))) {
            return false;
        }
        for (int i10 = 1; i10 < len; i10++) {
            char c4 = protocol.charAt(i10);
            if (!Character.isLetterOrDigit(c4) && c4 != '.' && c4 != '+' && c4 != '-') {
                return false;
            }
        }
        return true;
    }

    private void checkSpecifyHandler(SecurityManager sm) {
        sm.checkPermission(SecurityConstants.SPECIFY_HANDLER_PERMISSION);
    }

    void set(String protocol, String host, int port, String file, String ref) {
        synchronized (this) {
            this.protocol = protocol;
            this.host = host;
            this.authority = port == -1 ? host : host + u.bD + port;
            this.port = port;
            this.file = file;
            this.ref = ref;
            this.hashCode = -1;
            this.hostAddress = null;
            int q10 = file.lastIndexOf(63);
            if (q10 != -1) {
                this.query = file.substring(q10 + 1);
                this.path = file.substring(0, q10);
            } else {
                this.path = file;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void set(String protocol, String host, int port, String authority, String userInfo, String path, String query, String ref) {
        String str;
        synchronized (this) {
            this.protocol = protocol;
            this.host = host;
            this.port = port;
            if (query != null && !query.isEmpty()) {
                str = path + SymbolValues.QUESTION_EN_SYMBOL + query;
                this.file = str;
                this.userInfo = userInfo;
                this.path = path;
                this.ref = ref;
                this.hashCode = -1;
                this.hostAddress = null;
                this.query = query;
                this.authority = authority;
            }
            str = path;
            this.file = str;
            this.userInfo = userInfo;
            this.path = path;
            this.ref = ref;
            this.hashCode = -1;
            this.hostAddress = null;
            this.query = query;
            this.authority = authority;
        }
    }

    public String getQuery() {
        return this.query;
    }

    public String getPath() {
        return this.path;
    }

    public String getUserInfo() {
        return this.userInfo;
    }

    public String getAuthority() {
        return this.authority;
    }

    public int getPort() {
        return this.port;
    }

    public int getDefaultPort() {
        return this.handler.getDefaultPort();
    }

    public String getProtocol() {
        return this.protocol;
    }

    public String getHost() {
        return this.host;
    }

    public String getFile() {
        return this.file;
    }

    public String getRef() {
        return this.ref;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof URL)) {
            return false;
        }
        URL u22 = (URL) obj;
        return this.handler.equals(this, u22);
    }

    public synchronized int hashCode() {
        int i10 = this.hashCode;
        if (i10 != -1) {
            return i10;
        }
        int hashCode = this.handler.hashCode(this);
        this.hashCode = hashCode;
        return hashCode;
    }

    public boolean sameFile(URL other) {
        return this.handler.sameFile(this, other);
    }

    public String toString() {
        return toExternalForm();
    }

    public String toExternalForm() {
        return this.handler.toExternalForm(this);
    }

    public URI toURI() throws URISyntaxException {
        return new URI(toString());
    }

    public URLConnection openConnection() throws IOException {
        SeempLog.record_str(91, "URL:" + this.query);
        return this.handler.openConnection(this);
    }

    public URLConnection openConnection(Proxy proxy) throws IOException {
        if (proxy == null) {
            throw new IllegalArgumentException("proxy can not be null");
        }
        Proxy p10 = proxy == Proxy.NO_PROXY ? Proxy.NO_PROXY : ApplicationProxy.create(proxy);
        SecurityManager sm = System.getSecurityManager();
        if (p10.type() != Proxy.Type.DIRECT && sm != null) {
            InetSocketAddress epoint = (InetSocketAddress) p10.address();
            if (epoint.isUnresolved()) {
                sm.checkConnect(epoint.getHostName(), epoint.getPort());
            } else {
                sm.checkConnect(epoint.getAddress().getHostAddress(), epoint.getPort());
            }
        }
        return this.handler.openConnection(this, p10);
    }

    public final InputStream openStream() throws IOException {
        return openConnection().getInputStream();
    }

    public final Object getContent() throws IOException {
        return openConnection().getContent();
    }

    public final Object getContent(Class[] classes) throws IOException {
        return openConnection().getContent(classes);
    }

    public static void setURLStreamHandlerFactory(URLStreamHandlerFactory fac) {
        synchronized (streamHandlerLock) {
            if (factory != null) {
                throw new Error("factory already defined");
            }
            SecurityManager security = System.getSecurityManager();
            if (security != null) {
                security.checkSetFactory();
            }
            handlers.clear();
            factory = fac;
        }
    }

    static URLStreamHandler getURLStreamHandler(String protocol) {
        URLStreamHandlerFactory uRLStreamHandlerFactory;
        URLStreamHandler handler = handlers.get(protocol);
        if (handler == null) {
            boolean checkedWithFactory = false;
            URLStreamHandlerFactory uRLStreamHandlerFactory2 = factory;
            if (uRLStreamHandlerFactory2 != null) {
                handler = uRLStreamHandlerFactory2.createURLStreamHandler(protocol);
                checkedWithFactory = true;
            }
            if (handler == null) {
                String packagePrefixList = System.getProperty(protocolPathProp, "");
                StringTokenizer packagePrefixIter = new StringTokenizer(packagePrefixList, "|");
                while (handler == null && packagePrefixIter.hasMoreTokens()) {
                    String packagePrefix = packagePrefixIter.nextToken().trim();
                    try {
                        String clsName = packagePrefix + "." + protocol + ".Handler";
                        Class<?> cls = null;
                        try {
                            ClassLoader cl = ClassLoader.getSystemClassLoader();
                            cls = Class.forName(clsName, true, cl);
                        } catch (ClassNotFoundException e2) {
                            ClassLoader contextLoader = Thread.currentThread().getContextClassLoader();
                            if (contextLoader != null) {
                                cls = Class.forName(clsName, true, contextLoader);
                            }
                        }
                        if (cls != null) {
                            handler = (URLStreamHandler) cls.newInstance();
                        }
                    } catch (ReflectiveOperationException e10) {
                    }
                }
            }
            if (handler == null) {
                try {
                    handler = createBuiltinHandler(protocol);
                } catch (Exception e11) {
                    throw new AssertionError(e11);
                }
            }
            synchronized (streamHandlerLock) {
                URLStreamHandler handler2 = handlers.get(protocol);
                if (handler2 != null) {
                    return handler2;
                }
                if (!checkedWithFactory && (uRLStreamHandlerFactory = factory) != null) {
                    handler2 = uRLStreamHandlerFactory.createURLStreamHandler(protocol);
                }
                if (handler2 != null) {
                    handler = handler2;
                }
                if (handler != null) {
                    handlers.put(protocol, handler);
                }
            }
        }
        return handler;
    }

    private static URLStreamHandler createBuiltinHandler(String protocol) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        if (protocol.equals("file")) {
            URLStreamHandler handler = new Handler();
            return handler;
        }
        if (protocol.equals("ftp")) {
            URLStreamHandler handler2 = new sun.net.www.protocol.ftp.Handler();
            return handler2;
        }
        if (protocol.equals("jar")) {
            URLStreamHandler handler3 = new sun.net.www.protocol.jar.Handler();
            return handler3;
        }
        if (protocol.equals("http")) {
            URLStreamHandler handler4 = (URLStreamHandler) Class.forName("com.android.okhttp.HttpHandler").newInstance();
            return handler4;
        }
        if (!protocol.equals("https")) {
            return null;
        }
        URLStreamHandler handler5 = (URLStreamHandler) Class.forName("com.android.okhttp.HttpsHandler").newInstance();
        return handler5;
    }

    private static Set<String> createBuiltinHandlerClassNames() {
        Set<String> result = new HashSet<>();
        result.add("sun.net.www.protocol.file.Handler");
        result.add("sun.net.www.protocol.ftp.Handler");
        result.add("sun.net.www.protocol.jar.Handler");
        result.add("com.android.okhttp.HttpHandler");
        result.add("com.android.okhttp.HttpsHandler");
        return Collections.unmodifiableSet(result);
    }

    private synchronized void writeObject(ObjectOutputStream s2) throws IOException {
        s2.defaultWriteObject();
    }

    private synchronized void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        String host;
        String authority;
        ObjectInputStream.GetField gf = s2.readFields();
        String protocol = (String) gf.get("protocol", (Object) null);
        if (getURLStreamHandler(protocol) == null) {
            throw new IOException("unknown protocol: " + protocol);
        }
        String host2 = (String) gf.get("host", (Object) null);
        int port = gf.get("port", -1);
        String authority2 = (String) gf.get("authority", (Object) null);
        String file = (String) gf.get("file", (Object) null);
        String ref = (String) gf.get(CardElement.Field.REF, (Object) null);
        if (authority2 == null && ((host2 != null && host2.length() > 0) || port != -1)) {
            if (host2 == null) {
                host2 = "";
            }
            host = host2;
            authority = port == -1 ? host2 : host2 + u.bD + port;
        } else {
            host = host2;
            authority = authority2;
        }
        this.tempState = new UrlDeserializedState(protocol, host, port, authority, file, ref, -1);
    }

    private Object readResolve() throws ObjectStreamException {
        URLStreamHandler handler = getURLStreamHandler(this.tempState.getProtocol());
        if (isBuiltinStreamHandler(handler.getClass().getName())) {
            URL replacementURL = fabricateNewURL();
            return replacementURL;
        }
        URL replacementURL2 = setDeserializedFields(handler);
        return replacementURL2;
    }

    private URL setDeserializedFields(URLStreamHandler handler) {
        int ind;
        String userInfo = null;
        String protocol = this.tempState.getProtocol();
        String host = this.tempState.getHost();
        int port = this.tempState.getPort();
        String authority = this.tempState.getAuthority();
        String file = this.tempState.getFile();
        String ref = this.tempState.getRef();
        int hashCode = this.tempState.getHashCode();
        if (authority == null && ((host != null && host.length() > 0) || port != -1)) {
            if (host == null) {
                host = "";
            }
            authority = port == -1 ? host : host + u.bD + port;
            int at = host.lastIndexOf(64);
            if (at != -1) {
                userInfo = host.substring(0, at);
                host = host.substring(at + 1);
            }
        } else if (authority != null && (ind = authority.indexOf(64)) != -1) {
            userInfo = authority.substring(0, ind);
        }
        String path = null;
        String query = null;
        if (file != null) {
            int q10 = file.lastIndexOf(63);
            if (q10 != -1) {
                query = file.substring(q10 + 1);
                path = file.substring(0, q10);
            } else {
                path = file;
            }
        }
        this.protocol = protocol;
        this.host = host;
        this.port = port;
        this.file = file;
        this.authority = authority;
        this.ref = ref;
        this.hashCode = hashCode;
        this.handler = handler;
        this.query = query;
        this.path = path;
        this.userInfo = userInfo;
        return this;
    }

    private URL fabricateNewURL() throws InvalidObjectException {
        String urlString = this.tempState.reconstituteUrlString();
        try {
            URL replacementURL = new URL(urlString);
            replacementURL.setSerializedHashCode(this.tempState.getHashCode());
            resetState();
            return replacementURL;
        } catch (MalformedURLException mEx) {
            resetState();
            InvalidObjectException invoEx = new InvalidObjectException("Malformed URL: " + urlString);
            invoEx.initCause(mEx);
            throw invoEx;
        }
    }

    private boolean isBuiltinStreamHandler(String handlerClassName) {
        return BUILTIN_HANDLER_CLASS_NAMES.contains(handlerClassName);
    }

    private void resetState() {
        this.protocol = null;
        this.host = null;
        this.port = -1;
        this.file = null;
        this.authority = null;
        this.ref = null;
        this.hashCode = -1;
        this.handler = null;
        this.query = null;
        this.path = null;
        this.userInfo = null;
        this.tempState = null;
    }

    private void setSerializedHashCode(int hc2) {
        this.hashCode = hc2;
    }
}
