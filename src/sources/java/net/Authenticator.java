package java.net;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class Authenticator {
    private static Authenticator theAuthenticator;
    private RequestorType requestingAuthType;
    private String requestingHost;
    private int requestingPort;
    private String requestingPrompt;
    private String requestingProtocol;
    private String requestingScheme;
    private InetAddress requestingSite;
    private URL requestingURL;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public enum RequestorType {
        PROXY,
        SERVER
    }

    private void reset() {
        this.requestingHost = null;
        this.requestingSite = null;
        this.requestingPort = -1;
        this.requestingProtocol = null;
        this.requestingPrompt = null;
        this.requestingScheme = null;
        this.requestingURL = null;
        this.requestingAuthType = RequestorType.SERVER;
    }

    public static synchronized void setDefault(Authenticator a10) {
        synchronized (Authenticator.class) {
            SecurityManager sm = System.getSecurityManager();
            if (sm != null) {
                NetPermission setDefaultPermission = new NetPermission("setDefaultAuthenticator");
                sm.checkPermission(setDefaultPermission);
            }
            theAuthenticator = a10;
        }
    }

    public static PasswordAuthentication requestPasswordAuthentication(InetAddress addr, int port, String protocol, String prompt, String scheme) {
        PasswordAuthentication passwordAuthentication;
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            NetPermission requestPermission = new NetPermission("requestPasswordAuthentication");
            sm.checkPermission(requestPermission);
        }
        Authenticator a10 = theAuthenticator;
        if (a10 == null) {
            return null;
        }
        synchronized (a10) {
            a10.reset();
            a10.requestingSite = addr;
            a10.requestingPort = port;
            a10.requestingProtocol = protocol;
            a10.requestingPrompt = prompt;
            a10.requestingScheme = scheme;
            passwordAuthentication = a10.getPasswordAuthentication();
        }
        return passwordAuthentication;
    }

    public static PasswordAuthentication requestPasswordAuthentication(String host, InetAddress addr, int port, String protocol, String prompt, String scheme) {
        PasswordAuthentication passwordAuthentication;
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            NetPermission requestPermission = new NetPermission("requestPasswordAuthentication");
            sm.checkPermission(requestPermission);
        }
        Authenticator a10 = theAuthenticator;
        if (a10 == null) {
            return null;
        }
        synchronized (a10) {
            a10.reset();
            a10.requestingHost = host;
            a10.requestingSite = addr;
            a10.requestingPort = port;
            a10.requestingProtocol = protocol;
            a10.requestingPrompt = prompt;
            a10.requestingScheme = scheme;
            passwordAuthentication = a10.getPasswordAuthentication();
        }
        return passwordAuthentication;
    }

    public static PasswordAuthentication requestPasswordAuthentication(String host, InetAddress addr, int port, String protocol, String prompt, String scheme, URL url, RequestorType reqType) {
        PasswordAuthentication passwordAuthentication;
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            NetPermission requestPermission = new NetPermission("requestPasswordAuthentication");
            sm.checkPermission(requestPermission);
        }
        Authenticator a10 = theAuthenticator;
        if (a10 == null) {
            return null;
        }
        synchronized (a10) {
            a10.reset();
            a10.requestingHost = host;
            a10.requestingSite = addr;
            a10.requestingPort = port;
            a10.requestingProtocol = protocol;
            a10.requestingPrompt = prompt;
            a10.requestingScheme = scheme;
            a10.requestingURL = url;
            a10.requestingAuthType = reqType;
            passwordAuthentication = a10.getPasswordAuthentication();
        }
        return passwordAuthentication;
    }

    protected final String getRequestingHost() {
        return this.requestingHost;
    }

    protected final InetAddress getRequestingSite() {
        return this.requestingSite;
    }

    protected final int getRequestingPort() {
        return this.requestingPort;
    }

    protected final String getRequestingProtocol() {
        return this.requestingProtocol;
    }

    protected final String getRequestingPrompt() {
        return this.requestingPrompt;
    }

    protected final String getRequestingScheme() {
        return this.requestingScheme;
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return null;
    }

    protected URL getRequestingURL() {
        return this.requestingURL;
    }

    protected RequestorType getRequestorType() {
        return this.requestingAuthType;
    }
}
