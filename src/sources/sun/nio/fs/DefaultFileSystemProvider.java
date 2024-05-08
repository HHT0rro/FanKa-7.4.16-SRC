package sun.nio.fs;

import java.nio.file.spi.FileSystemProvider;
import java.security.AccessController;
import sun.security.action.GetPropertyAction;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DefaultFileSystemProvider {
    private DefaultFileSystemProvider() {
    }

    private static FileSystemProvider createProvider(String cn2) {
        try {
            try {
                return (FileSystemProvider) Class.forName(cn2).newInstance();
            } catch (IllegalAccessException | InstantiationException x10) {
                throw new AssertionError(x10);
            }
        } catch (ClassNotFoundException x11) {
            throw new AssertionError(x11);
        }
    }

    public static FileSystemProvider create() {
        String osname = (String) AccessController.doPrivileged(new GetPropertyAction("os.name"));
        if (osname.equals("SunOS")) {
            return createProvider("sun.nio.fs.SolarisFileSystemProvider");
        }
        if (osname.equals("Linux") || osname.equals("Fuchsia")) {
            return createProvider("sun.nio.fs.LinuxFileSystemProvider");
        }
        if (osname.contains("OS X")) {
            return createProvider("sun.nio.fs.MacOSXFileSystemProvider");
        }
        if (osname.equals("AIX")) {
            return createProvider("sun.nio.fs.AixFileSystemProvider");
        }
        throw new AssertionError((Object) "Platform not recognized");
    }
}
