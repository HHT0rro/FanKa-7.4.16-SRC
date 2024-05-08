package java.nio.channels.spi;

import java.io.IOException;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import sun.nio.ch.DefaultAsynchronousChannelProvider;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class AsynchronousChannelProvider {
    public abstract AsynchronousChannelGroup openAsynchronousChannelGroup(int i10, ThreadFactory threadFactory) throws IOException;

    public abstract AsynchronousChannelGroup openAsynchronousChannelGroup(ExecutorService executorService, int i10) throws IOException;

    public abstract AsynchronousServerSocketChannel openAsynchronousServerSocketChannel(AsynchronousChannelGroup asynchronousChannelGroup) throws IOException;

    public abstract AsynchronousSocketChannel openAsynchronousSocketChannel(AsynchronousChannelGroup asynchronousChannelGroup) throws IOException;

    private static Void checkPermission() {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(new RuntimePermission("asynchronousChannelProvider"));
            return null;
        }
        return null;
    }

    private AsynchronousChannelProvider(Void ignore) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AsynchronousChannelProvider() {
        this(checkPermission());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class ProviderHolder {
        static final AsynchronousChannelProvider provider = load();

        /* renamed from: -$$Nest$smloadProviderAsService, reason: not valid java name */
        static /* bridge */ /* synthetic */ AsynchronousChannelProvider m3248$$Nest$smloadProviderAsService() {
            return loadProviderAsService();
        }

        /* renamed from: -$$Nest$smloadProviderFromProperty, reason: not valid java name */
        static /* bridge */ /* synthetic */ AsynchronousChannelProvider m3249$$Nest$smloadProviderFromProperty() {
            return loadProviderFromProperty();
        }

        private ProviderHolder() {
        }

        private static AsynchronousChannelProvider load() {
            return (AsynchronousChannelProvider) AccessController.doPrivileged(new PrivilegedAction<AsynchronousChannelProvider>() { // from class: java.nio.channels.spi.AsynchronousChannelProvider.ProviderHolder.1
                @Override // java.security.PrivilegedAction
                public AsynchronousChannelProvider run() {
                    AsynchronousChannelProvider p10 = ProviderHolder.m3249$$Nest$smloadProviderFromProperty();
                    if (p10 != null) {
                        return p10;
                    }
                    AsynchronousChannelProvider p11 = ProviderHolder.m3248$$Nest$smloadProviderAsService();
                    if (p11 != null) {
                        return p11;
                    }
                    return DefaultAsynchronousChannelProvider.create();
                }
            });
        }

        private static AsynchronousChannelProvider loadProviderFromProperty() {
            String cn2 = System.getProperty("java.nio.channels.spi.AsynchronousChannelProvider");
            if (cn2 == null) {
                return null;
            }
            try {
                Object tmp = Class.forName(cn2, true, ClassLoader.getSystemClassLoader()).newInstance();
                return (AsynchronousChannelProvider) tmp;
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

        private static AsynchronousChannelProvider loadProviderAsService() {
            ServiceLoader<AsynchronousChannelProvider> sl = ServiceLoader.load(AsynchronousChannelProvider.class, ClassLoader.getSystemClassLoader());
            Iterator<AsynchronousChannelProvider> i10 = sl.iterator2();
            while (i10.hasNext()) {
                try {
                    return i10.next();
                } catch (ServiceConfigurationError sce) {
                    if (!(sce.getCause() instanceof SecurityException)) {
                        throw sce;
                    }
                }
            }
            return null;
        }
    }

    public static AsynchronousChannelProvider provider() {
        return ProviderHolder.provider;
    }
}
