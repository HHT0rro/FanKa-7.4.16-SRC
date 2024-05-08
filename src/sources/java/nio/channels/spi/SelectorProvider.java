package java.nio.channels.spi;

import java.io.IOException;
import java.net.ProtocolFamily;
import java.nio.channels.Channel;
import java.nio.channels.DatagramChannel;
import java.nio.channels.Pipe;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import sun.nio.ch.DefaultSelectorProvider;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class SelectorProvider {
    private static final Object lock = new Object();
    private static SelectorProvider provider = null;

    /* renamed from: -$$Nest$smloadProviderAsService, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3252$$Nest$smloadProviderAsService() {
        return loadProviderAsService();
    }

    /* renamed from: -$$Nest$smloadProviderFromProperty, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3253$$Nest$smloadProviderFromProperty() {
        return loadProviderFromProperty();
    }

    public abstract DatagramChannel openDatagramChannel() throws IOException;

    public abstract DatagramChannel openDatagramChannel(ProtocolFamily protocolFamily) throws IOException;

    public abstract Pipe openPipe() throws IOException;

    public abstract AbstractSelector openSelector() throws IOException;

    public abstract ServerSocketChannel openServerSocketChannel() throws IOException;

    public abstract SocketChannel openSocketChannel() throws IOException;

    private static Void checkPermission() {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(new RuntimePermission("selectorProvider"));
            return null;
        }
        return null;
    }

    private SelectorProvider(Void ignore) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SelectorProvider() {
        this(checkPermission());
    }

    private static boolean loadProviderFromProperty() {
        String cn2 = System.getProperty("java.nio.channels.spi.SelectorProvider");
        if (cn2 == null) {
            return false;
        }
        try {
            Object tmp = Class.forName(cn2, true, ClassLoader.getSystemClassLoader()).newInstance();
            provider = (SelectorProvider) tmp;
            return true;
        } catch (ClassNotFoundException x10) {
            throw new ServiceConfigurationError(null, x10);
        } catch (IllegalAccessException x11) {
            throw new ServiceConfigurationError(null, x11);
        } catch (InstantiationException x12) {
            throw new ServiceConfigurationError(null, x12);
        } catch (SecurityException x13) {
            throw new ServiceConfigurationError(null, x13);
        }
    }

    private static boolean loadProviderAsService() {
        ServiceLoader<SelectorProvider> sl = ServiceLoader.load(SelectorProvider.class, ClassLoader.getSystemClassLoader());
        Iterator<SelectorProvider> i10 = sl.iterator2();
        while (i10.hasNext()) {
            try {
                provider = i10.next();
                return true;
            } catch (ServiceConfigurationError sce) {
                if (!(sce.getCause() instanceof SecurityException)) {
                    throw sce;
                }
            }
        }
        return false;
    }

    public static SelectorProvider provider() {
        synchronized (lock) {
            SelectorProvider selectorProvider = provider;
            if (selectorProvider != null) {
                return selectorProvider;
            }
            return (SelectorProvider) AccessController.doPrivileged(new PrivilegedAction<SelectorProvider>() { // from class: java.nio.channels.spi.SelectorProvider.1
                @Override // java.security.PrivilegedAction
                public SelectorProvider run() {
                    if (SelectorProvider.m3253$$Nest$smloadProviderFromProperty()) {
                        return SelectorProvider.provider;
                    }
                    if (SelectorProvider.m3252$$Nest$smloadProviderAsService()) {
                        return SelectorProvider.provider;
                    }
                    SelectorProvider.provider = DefaultSelectorProvider.create();
                    return SelectorProvider.provider;
                }
            });
        }
    }

    public Channel inheritedChannel() throws IOException {
        return null;
    }
}
