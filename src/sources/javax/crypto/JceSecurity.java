package javax.crypto;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.security.AccessController;
import java.security.CodeSource;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.security.Provider;
import java.security.SecureRandom;
import java.util.Enumeration;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import sun.security.jca.GetInstance;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class JceSecurity {
    private static final URL NULL_URL;
    private static final Map<Class<?>, URL> codeBaseCacheRef;
    static final SecureRandom RANDOM = new SecureRandom();
    private static CryptoPermissions defaultPolicy = null;
    private static CryptoPermissions exemptPolicy = null;
    private static final Map<Provider, Object> verificationResults = new IdentityHashMap();
    private static final Map<Provider, Object> verifyingProviders = new IdentityHashMap();
    private static final Object PROVIDER_VERIFIED = Boolean.TRUE;

    static {
        try {
            NULL_URL = new URL("http://null.sun.com/");
            codeBaseCacheRef = new WeakHashMap();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    private JceSecurity() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GetInstance.Instance getInstance(String type, Class<?> clazz, String algorithm, String provider) throws NoSuchAlgorithmException, NoSuchProviderException {
        Provider.Service s2 = GetInstance.getService(type, algorithm, provider);
        Exception ve = getVerificationResult(s2.getProvider());
        if (ve != null) {
            String msg = "JCE cannot authenticate the provider " + provider;
            throw ((NoSuchProviderException) new NoSuchProviderException(msg).initCause(ve));
        }
        return GetInstance.getInstance(s2, clazz);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GetInstance.Instance getInstance(String type, Class<?> clazz, String algorithm, Provider provider) throws NoSuchAlgorithmException {
        Provider.Service s2 = GetInstance.getService(type, algorithm, provider);
        Exception ve = getVerificationResult(provider);
        if (ve != null) {
            String msg = "JCE cannot authenticate the provider " + provider.getName();
            throw new SecurityException(msg, ve);
        }
        return GetInstance.getInstance(s2, clazz);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GetInstance.Instance getInstance(String type, Class<?> clazz, String algorithm) throws NoSuchAlgorithmException {
        List<Provider.Service> services = GetInstance.getServices(type, algorithm);
        NoSuchAlgorithmException failure = null;
        Iterator<Provider.Service> iterator2 = services.iterator2();
        while (iterator2.hasNext()) {
            Provider.Service s2 = iterator2.next();
            if (canUseProvider(s2.getProvider())) {
                try {
                    GetInstance.Instance instance = GetInstance.getInstance(s2, clazz);
                    return instance;
                } catch (NoSuchAlgorithmException e2) {
                    failure = e2;
                }
            }
        }
        throw new NoSuchAlgorithmException("Algorithm " + algorithm + " not available", failure);
    }

    static CryptoPermissions verifyExemptJar(URL codeBase) throws Exception {
        JarVerifier jv = new JarVerifier(codeBase, true);
        jv.verify();
        return jv.getPermissions();
    }

    static void verifyProviderJar(URL codeBase) throws Exception {
        JarVerifier jv = new JarVerifier(codeBase, false);
        jv.verify();
    }

    static synchronized Exception getVerificationResult(Provider p10) {
        synchronized (JceSecurity.class) {
            Map<Provider, Object> map = verificationResults;
            Object o10 = map.get(p10);
            Object obj = PROVIDER_VERIFIED;
            if (o10 == obj) {
                return null;
            }
            if (o10 != null) {
                return (Exception) o10;
            }
            Map<Provider, Object> map2 = verifyingProviders;
            try {
                if (map2.get(p10) != null) {
                    return new NoSuchProviderException("Recursion during verification");
                }
                try {
                    map2.put(p10, Boolean.FALSE);
                    URL providerURL = getCodeBase(p10.getClass());
                    verifyProviderJar(providerURL);
                    map.put(p10, obj);
                    map2.remove(p10);
                    return null;
                } catch (Exception e2) {
                    verificationResults.put(p10, e2);
                    verifyingProviders.remove(p10);
                    return e2;
                }
            } catch (Throwable th) {
                verifyingProviders.remove(p10);
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean canUseProvider(Provider p10) {
        return true;
    }

    static URL getCodeBase(final Class<?> clazz) {
        URL url;
        Map<Class<?>, URL> map = codeBaseCacheRef;
        synchronized (map) {
            URL url2 = map.get(clazz);
            if (url2 == null) {
                url2 = (URL) AccessController.doPrivileged(new PrivilegedAction<URL>() { // from class: javax.crypto.JceSecurity.1
                    @Override // java.security.PrivilegedAction
                    public URL run() {
                        CodeSource cs;
                        ProtectionDomain pd2 = Class.this.getProtectionDomain();
                        if (pd2 != null && (cs = pd2.getCodeSource()) != null) {
                            return cs.getLocation();
                        }
                        return JceSecurity.NULL_URL;
                    }
                });
                map.put(clazz, url2);
            }
            url = url2 == NULL_URL ? null : url2;
        }
        return url;
    }

    private static void loadPolicies(File jarPathName, CryptoPermissions defaultPolicy2, CryptoPermissions exemptPolicy2) throws Exception {
        InputStream is;
        JarFile jf = new JarFile(jarPathName);
        Enumeration<JarEntry> entries = jf.entries();
        while (entries.hasMoreElements()) {
            JarEntry je2 = entries.nextElement();
            InputStream is2 = null;
            try {
                if (je2.getName().startsWith("default_")) {
                    is = jf.getInputStream(je2);
                    defaultPolicy2.load(is);
                } else if (je2.getName().startsWith("exempt_")) {
                    is = jf.getInputStream(je2);
                    exemptPolicy2.load(is);
                } else if (is2 != null) {
                    is2.close();
                }
                JarVerifier.verifyPolicySigned(je2.getCertificates());
            } finally {
                if (is2 != null) {
                    is2.close();
                }
            }
        }
        jf.close();
    }

    static CryptoPermissions getDefaultPolicy() {
        return defaultPolicy;
    }

    static CryptoPermissions getExemptPolicy() {
        return exemptPolicy;
    }
}
