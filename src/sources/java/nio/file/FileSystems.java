package java.nio.file;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.URI;
import java.nio.file.spi.FileSystemProvider;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import sun.nio.fs.DefaultFileSystemProvider;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class FileSystems {
    private FileSystems() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class DefaultFileSystemHolder {
        static final FileSystem defaultFileSystem = defaultFileSystem();

        /* renamed from: -$$Nest$smgetDefaultProvider, reason: not valid java name */
        static /* bridge */ /* synthetic */ FileSystemProvider m3256$$Nest$smgetDefaultProvider() {
            return getDefaultProvider();
        }

        private DefaultFileSystemHolder() {
        }

        private static FileSystem defaultFileSystem() {
            FileSystemProvider provider = (FileSystemProvider) AccessController.doPrivileged(new PrivilegedAction<FileSystemProvider>() { // from class: java.nio.file.FileSystems.DefaultFileSystemHolder.1
                @Override // java.security.PrivilegedAction
                public FileSystemProvider run() {
                    return DefaultFileSystemHolder.m3256$$Nest$smgetDefaultProvider();
                }
            });
            return provider.getFileSystem(URI.create("file:///"));
        }

        private static FileSystemProvider getDefaultProvider() {
            FileSystemProvider provider = DefaultFileSystemProvider.create();
            String propValue = System.getProperty("java.nio.file.spi.DefaultFileSystemProvider");
            if (propValue != null) {
                for (String cn2 : propValue.split(",")) {
                    try {
                        Class<?> c4 = Class.forName(cn2, true, ClassLoader.getSystemClassLoader());
                        Constructor<?> ctor = c4.getDeclaredConstructor(FileSystemProvider.class);
                        provider = (FileSystemProvider) ctor.newInstance(provider);
                        if (!provider.getScheme().equals("file")) {
                            throw new Error("Default provider must use scheme 'file'");
                        }
                    } catch (Exception x10) {
                        throw new Error(x10);
                    }
                }
            }
            return provider;
        }
    }

    public static FileSystem getDefault() {
        return DefaultFileSystemHolder.defaultFileSystem;
    }

    public static FileSystem getFileSystem(URI uri) {
        String scheme = uri.getScheme();
        for (FileSystemProvider provider : FileSystemProvider.installedProviders()) {
            if (scheme.equalsIgnoreCase(provider.getScheme())) {
                return provider.getFileSystem(uri);
            }
        }
        throw new ProviderNotFoundException("Provider \"" + scheme + "\" not found");
    }

    public static FileSystem newFileSystem(URI uri, Map<String, ?> env) throws IOException {
        return newFileSystem(uri, env, null);
    }

    public static FileSystem newFileSystem(URI uri, Map<String, ?> env, ClassLoader loader) throws IOException {
        String scheme = uri.getScheme();
        for (FileSystemProvider provider : FileSystemProvider.installedProviders()) {
            if (scheme.equalsIgnoreCase(provider.getScheme())) {
                return provider.newFileSystem(uri, env);
            }
        }
        if (loader != null) {
            ServiceLoader<FileSystemProvider> sl = ServiceLoader.load(FileSystemProvider.class, loader);
            Iterator<FileSystemProvider> iterator2 = sl.iterator2();
            while (iterator2.hasNext()) {
                FileSystemProvider provider2 = iterator2.next();
                if (scheme.equalsIgnoreCase(provider2.getScheme())) {
                    return provider2.newFileSystem(uri, env);
                }
            }
        }
        throw new ProviderNotFoundException("Provider \"" + scheme + "\" not found");
    }

    public static FileSystem newFileSystem(Path path, ClassLoader loader) throws IOException {
        if (path == null) {
            throw new NullPointerException();
        }
        Map<String, ?> env = Collections.emptyMap();
        Iterator<FileSystemProvider> iterator2 = FileSystemProvider.installedProviders().iterator2();
        while (iterator2.hasNext()) {
            FileSystemProvider provider = iterator2.next();
            try {
                return provider.newFileSystem(path, env);
            } catch (UnsupportedOperationException e2) {
            }
        }
        if (loader != null) {
            ServiceLoader<FileSystemProvider> sl = ServiceLoader.load(FileSystemProvider.class, loader);
            Iterator<FileSystemProvider> iterator22 = sl.iterator2();
            while (iterator22.hasNext()) {
                FileSystemProvider provider2 = iterator22.next();
                try {
                    return provider2.newFileSystem(path, env);
                } catch (UnsupportedOperationException e10) {
                }
            }
        }
        throw new ProviderNotFoundException("Provider not found");
    }
}
