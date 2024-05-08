package sun.security.jca;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.security.AccessController;
import java.security.GeneralSecurityException;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.security.ProviderException;
import sun.security.util.Debug;
import sun.security.util.PropertyExpander;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class ProviderConfig {
    private static final int MAX_LOAD_TRIES = 30;
    private static final String P11_SOL_ARG = "${java.home}/lib/security/sunpkcs11-solaris.cfg";
    private static final String P11_SOL_NAME = "sun.security.pkcs11.SunPKCS11";
    private final String argument;
    private final String className;
    private boolean isLoading;
    private volatile Provider provider;
    private int tries;
    private static final Debug debug = Debug.getInstance("jca", "ProviderConfig");
    private static final Class[] CL_STRING = {String.class};

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProviderConfig(String className, String argument) {
        if (className.equals(P11_SOL_NAME) && argument.equals(P11_SOL_ARG)) {
            checkSunPKCS11Solaris();
        }
        this.className = className;
        this.argument = expand(argument);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProviderConfig(String className) {
        this(className, "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProviderConfig(Provider provider) {
        this.className = provider.getClass().getName();
        this.argument = "";
        this.provider = provider;
    }

    private void checkSunPKCS11Solaris() {
        Boolean o10 = (Boolean) AccessController.doPrivileged(new PrivilegedAction<Boolean>() { // from class: sun.security.jca.ProviderConfig.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public Boolean run() {
                File file = new File("/usr/lib/libpkcs11.so");
                if (!file.exists()) {
                    return Boolean.FALSE;
                }
                if ("false".equalsIgnoreCase(System.getProperty("sun.security.pkcs11.enable-solaris"))) {
                    return Boolean.FALSE;
                }
                return Boolean.TRUE;
            }
        });
        if (o10 == Boolean.FALSE) {
            this.tries = 30;
        }
    }

    private boolean hasArgument() {
        return this.argument.length() != 0;
    }

    private boolean shouldLoad() {
        return this.tries < 30;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disableLoad() {
        this.tries = 30;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isLoaded() {
        return this.provider != null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProviderConfig)) {
            return false;
        }
        ProviderConfig other = (ProviderConfig) obj;
        return this.className.equals(other.className) && this.argument.equals(other.argument);
    }

    public int hashCode() {
        return this.className.hashCode() + this.argument.hashCode();
    }

    public String toString() {
        if (hasArgument()) {
            return this.className + "('" + this.argument + "')";
        }
        return this.className;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Provider getProvider() {
        Provider p10 = this.provider;
        if (p10 != null) {
            return p10;
        }
        if (!shouldLoad()) {
            return null;
        }
        if (this.isLoading) {
            Debug debug2 = debug;
            if (debug2 != null) {
                debug2.println("Recursion loading provider: " + ((Object) this));
                new Exception("Call trace").printStackTrace();
            }
            return null;
        }
        try {
            this.isLoading = true;
            this.tries++;
            Provider p11 = doLoadProvider();
            this.isLoading = false;
            this.provider = p11;
            return p11;
        } catch (Throwable th) {
            this.isLoading = false;
            throw th;
        }
    }

    private Provider doLoadProvider() {
        return (Provider) AccessController.doPrivileged(new PrivilegedAction<Provider>() { // from class: sun.security.jca.ProviderConfig.2
            @Override // java.security.PrivilegedAction
            public Provider run() {
                Throwable t2;
                if (ProviderConfig.debug != null) {
                    ProviderConfig.debug.println("Loading provider: " + ((Object) ProviderConfig.this));
                }
                try {
                    ProviderConfig providerConfig = ProviderConfig.this;
                    return providerConfig.initProvider(providerConfig.className, Object.class.getClassLoader());
                } catch (Exception e2) {
                    try {
                        ProviderConfig providerConfig2 = ProviderConfig.this;
                        return providerConfig2.initProvider(providerConfig2.className, ClassLoader.getSystemClassLoader());
                    } catch (Exception e10) {
                        if (e10 instanceof InvocationTargetException) {
                            t2 = ((InvocationTargetException) e10).getCause();
                        } else {
                            t2 = e10;
                        }
                        if (ProviderConfig.debug != null) {
                            ProviderConfig.debug.println("Error loading provider " + ((Object) ProviderConfig.this));
                            t2.printStackTrace();
                        }
                        if (t2 instanceof ProviderException) {
                            throw ((ProviderException) t2);
                        }
                        if (t2 instanceof UnsupportedOperationException) {
                            ProviderConfig.this.disableLoad();
                            return null;
                        }
                        return null;
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Provider initProvider(String className, ClassLoader cl) throws Exception {
        Class<?> provClass;
        Object obj;
        if (cl != null) {
            provClass = cl.loadClass(className);
        } else {
            provClass = Class.forName(className);
        }
        if (!hasArgument()) {
            obj = provClass.newInstance();
        } else {
            Constructor<?> cons = provClass.getConstructor(CL_STRING);
            obj = cons.newInstance(this.argument);
        }
        if (obj instanceof Provider) {
            Debug debug2 = debug;
            if (debug2 != null) {
                debug2.println("Loaded provider " + obj);
            }
            return (Provider) obj;
        }
        Debug debug3 = debug;
        if (debug3 != null) {
            debug3.println(className + " is not a provider");
        }
        disableLoad();
        return null;
    }

    private static String expand(final String value) {
        if (!value.contains("${")) {
            return value;
        }
        return (String) AccessController.doPrivileged(new PrivilegedAction<String>() { // from class: sun.security.jca.ProviderConfig.3
            @Override // java.security.PrivilegedAction
            public String run() {
                try {
                    return PropertyExpander.expand(String.this);
                } catch (GeneralSecurityException e2) {
                    throw new ProviderException(e2);
                }
            }
        });
    }
}
