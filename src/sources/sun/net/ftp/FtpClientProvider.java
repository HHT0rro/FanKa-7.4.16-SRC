package sun.net.ftp;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ServiceConfigurationError;
import sun.net.ftp.impl.DefaultFtpClientProvider;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class FtpClientProvider {
    private static final Object lock = new Object();
    private static FtpClientProvider provider = null;

    /* renamed from: -$$Nest$smloadProviderAsService, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3774$$Nest$smloadProviderAsService() {
        return loadProviderAsService();
    }

    /* renamed from: -$$Nest$smloadProviderFromProperty, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3775$$Nest$smloadProviderFromProperty() {
        return loadProviderFromProperty();
    }

    public abstract FtpClient createFtpClient();

    /* JADX INFO: Access modifiers changed from: protected */
    public FtpClientProvider() {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(new RuntimePermission("ftpClientProvider"));
        }
    }

    private static boolean loadProviderFromProperty() {
        String cm = System.getProperty("sun.net.ftpClientProvider");
        if (cm == null) {
            return false;
        }
        try {
            Class<?> c4 = Class.forName(cm, true, null);
            provider = (FtpClientProvider) c4.newInstance();
            return true;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SecurityException x10) {
            throw new ServiceConfigurationError(x10.toString());
        }
    }

    private static boolean loadProviderAsService() {
        return false;
    }

    public static FtpClientProvider provider() {
        synchronized (lock) {
            FtpClientProvider ftpClientProvider = provider;
            if (ftpClientProvider != null) {
                return ftpClientProvider;
            }
            return (FtpClientProvider) AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: sun.net.ftp.FtpClientProvider.1
                @Override // java.security.PrivilegedAction
                public Object run() {
                    if (FtpClientProvider.m3775$$Nest$smloadProviderFromProperty()) {
                        return FtpClientProvider.provider;
                    }
                    if (FtpClientProvider.m3774$$Nest$smloadProviderAsService()) {
                        return FtpClientProvider.provider;
                    }
                    FtpClientProvider.provider = new DefaultFtpClientProvider();
                    return FtpClientProvider.provider;
                }
            });
        }
    }
}
