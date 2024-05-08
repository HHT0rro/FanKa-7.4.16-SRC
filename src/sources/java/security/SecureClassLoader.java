package java.security;

import java.nio.ByteBuffer;
import java.util.HashMap;
import sun.security.util.Debug;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class SecureClassLoader extends ClassLoader {
    private static final Debug debug = Debug.getInstance("scl");
    private final boolean initialized;
    private final HashMap<CodeSource, ProtectionDomain> pdcache;

    static {
        ClassLoader.registerAsParallelCapable();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SecureClassLoader(ClassLoader parent) {
        super(parent);
        this.pdcache = new HashMap<>(11);
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkCreateClassLoader();
        }
        this.initialized = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SecureClassLoader() {
        this.pdcache = new HashMap<>(11);
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkCreateClassLoader();
        }
        this.initialized = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Class<?> defineClass(String name, byte[] b4, int off, int len, CodeSource cs) {
        return defineClass(name, b4, off, len, getProtectionDomain(cs));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Class<?> defineClass(String name, ByteBuffer b4, CodeSource cs) {
        return defineClass(name, b4, getProtectionDomain(cs));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PermissionCollection getPermissions(CodeSource codesource) {
        check();
        return new Permissions();
    }

    private ProtectionDomain getProtectionDomain(CodeSource cs) {
        ProtectionDomain pd2;
        if (cs == null) {
            return null;
        }
        synchronized (this.pdcache) {
            pd2 = this.pdcache.get(cs);
            if (pd2 == null) {
                PermissionCollection perms = getPermissions(cs);
                pd2 = new ProtectionDomain(cs, perms, this, null);
                this.pdcache.put(cs, pd2);
                Debug debug2 = debug;
                if (debug2 != null) {
                    debug2.println(" getPermissions " + ((Object) pd2));
                    debug2.println("");
                }
            }
        }
        return pd2;
    }

    private void check() {
        if (!this.initialized) {
            throw new SecurityException("ClassLoader object not initialized");
        }
    }
}
