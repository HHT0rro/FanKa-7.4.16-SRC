package sun.security.provider.certpath;

import java.io.IOException;
import java.net.URI;
import java.security.AccessController;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.X509CRLSelector;
import java.security.cert.X509CertSelector;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.security.auth.x500.X500Principal;
import sun.security.util.Cache;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class CertStoreHelper {
    private static final int NUM_TYPES = 2;
    private static Cache<String, CertStoreHelper> cache;
    private static final Map<String, String> classMap;

    public abstract CertStore getCertStore(URI uri) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException;

    public abstract boolean isCausedByNetworkIssue(CertStoreException certStoreException);

    public abstract X509CRLSelector wrap(X509CRLSelector x509CRLSelector, Collection<X500Principal> collection, String str) throws IOException;

    public abstract X509CertSelector wrap(X509CertSelector x509CertSelector, X500Principal x500Principal, String str) throws IOException;

    static {
        HashMap hashMap = new HashMap(2);
        classMap = hashMap;
        hashMap.put("LDAP", "sun.security.provider.certpath.ldap.LDAPCertStoreHelper");
        hashMap.put("SSLServer", "sun.security.provider.certpath.ssl.SSLServerCertStoreHelper");
        cache = Cache.newSoftMemoryCache(2);
    }

    public static CertStoreHelper getInstance(final String type) throws NoSuchAlgorithmException {
        CertStoreHelper helper = cache.get(type);
        if (helper != null) {
            return helper;
        }
        final String cl = classMap.get(type);
        if (cl == null) {
            throw new NoSuchAlgorithmException(type + " not available");
        }
        try {
            return (CertStoreHelper) AccessController.doPrivileged(new PrivilegedExceptionAction<CertStoreHelper>() { // from class: sun.security.provider.certpath.CertStoreHelper.1
                @Override // java.security.PrivilegedExceptionAction
                public CertStoreHelper run() throws ClassNotFoundException {
                    try {
                        Class<?> c4 = Class.forName(String.this, true, null);
                        CertStoreHelper csh = (CertStoreHelper) c4.newInstance();
                        CertStoreHelper.cache.put(type, csh);
                        return csh;
                    } catch (IllegalAccessException | InstantiationException e2) {
                        throw new AssertionError(e2);
                    }
                }
            });
        } catch (PrivilegedActionException e2) {
            throw new NoSuchAlgorithmException(type + " not available", e2.getException());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static boolean isCausedByNetworkIssue(String type, CertStoreException cse) {
        char c4;
        switch (type.hashCode()) {
            case 84300:
                if (type.equals("URI")) {
                    c4 = 2;
                    break;
                }
                c4 = 65535;
                break;
            case 2331559:
                if (type.equals("LDAP")) {
                    c4 = 0;
                    break;
                }
                c4 = 65535;
                break;
            case 133315663:
                if (type.equals("SSLServer")) {
                    c4 = 1;
                    break;
                }
                c4 = 65535;
                break;
            default:
                c4 = 65535;
                break;
        }
        switch (c4) {
            case 0:
            case 1:
                try {
                    CertStoreHelper csh = getInstance(type);
                    return csh.isCausedByNetworkIssue(cse);
                } catch (NoSuchAlgorithmException e2) {
                    return false;
                }
            case 2:
                Throwable t2 = cse.getCause();
                return t2 != null && (t2 instanceof IOException);
            default:
                return false;
        }
    }
}
