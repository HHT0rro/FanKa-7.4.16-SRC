package javax.net.ssl;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.security.AccessController;
import java.security.NoSuchAlgorithmException;
import java.security.PrivilegedAction;
import java.security.Security;
import java.util.Locale;
import javax.net.SocketFactory;
import sun.security.action.GetPropertyAction;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class SSLSocketFactory extends SocketFactory {
    static final boolean DEBUG;
    private static SSLSocketFactory defaultSocketFactory;
    private static int lastVersion = -1;

    public abstract Socket createSocket(Socket socket, String str, int i10, boolean z10) throws IOException;

    public abstract String[] getDefaultCipherSuites();

    public abstract String[] getSupportedCipherSuites();

    static {
        String s2 = ((String) AccessController.doPrivileged(new GetPropertyAction("javax.net.debug", ""))).toLowerCase(Locale.ENGLISH);
        DEBUG = s2.contains("all") || s2.contains("ssl");
    }

    private static void log(String msg) {
        if (DEBUG) {
            System.out.println(msg);
        }
    }

    public static synchronized SocketFactory getDefault() {
        synchronized (SSLSocketFactory.class) {
            if (defaultSocketFactory != null && lastVersion == Security.getVersion()) {
                return defaultSocketFactory;
            }
            lastVersion = Security.getVersion();
            SSLSocketFactory previousDefaultSocketFactory = defaultSocketFactory;
            defaultSocketFactory = null;
            String clsName = getSecurityProperty("ssl.SocketFactory.provider");
            if (clsName != null) {
                if (previousDefaultSocketFactory != null && clsName.equals(previousDefaultSocketFactory.getClass().getName())) {
                    defaultSocketFactory = previousDefaultSocketFactory;
                    return previousDefaultSocketFactory;
                }
                log("setting up default SSLSocketFactory");
                Class<?> cls = null;
                try {
                    try {
                        cls = Class.forName(clsName);
                    } catch (Exception e2) {
                        log("SSLSocketFactory instantiation failed: " + e2.toString());
                    }
                } catch (ClassNotFoundException e10) {
                    ClassLoader cl = Thread.currentThread().getContextClassLoader();
                    if (cl == null) {
                        cl = ClassLoader.getSystemClassLoader();
                    }
                    if (cl != null) {
                        cls = Class.forName(clsName, true, cl);
                    }
                }
                log("class " + clsName + " is loaded");
                SSLSocketFactory fac = (SSLSocketFactory) cls.newInstance();
                log("instantiated an instance of class " + clsName);
                defaultSocketFactory = fac;
                return fac;
            }
            try {
                SSLContext context = SSLContext.getDefault();
                if (context != null) {
                    defaultSocketFactory = context.getSocketFactory();
                } else {
                    defaultSocketFactory = new DefaultSSLSocketFactory(new IllegalStateException("No factory found."));
                }
                return defaultSocketFactory;
            } catch (NoSuchAlgorithmException e11) {
                return new DefaultSSLSocketFactory(e11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getSecurityProperty(final String name) {
        return (String) AccessController.doPrivileged(new PrivilegedAction<String>() { // from class: javax.net.ssl.SSLSocketFactory.1
            @Override // java.security.PrivilegedAction
            public String run() {
                String s2 = Security.getProperty(String.this);
                if (s2 != null) {
                    String s10 = s2.trim();
                    if (s10.length() == 0) {
                        return null;
                    }
                    return s10;
                }
                return s2;
            }
        });
    }

    public Socket createSocket(Socket s2, InputStream consumed, boolean autoClose) throws IOException {
        throw new UnsupportedOperationException();
    }
}
