package sun.security.provider.certpath;

import com.huawei.hms.feature.dynamic.f.e;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URLConnection;
import java.security.AccessController;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.cert.CRLException;
import java.security.cert.CRLSelector;
import java.security.cert.CertSelector;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.CertStoreParameters;
import java.security.cert.CertStoreSpi;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLSelector;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import sun.security.action.GetIntegerAction;
import sun.security.provider.certpath.PKIX;
import sun.security.util.Cache;
import sun.security.util.Debug;
import sun.security.x509.AccessDescription;
import sun.security.x509.GeneralNameInterface;
import sun.security.x509.URIName;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class URICertStore extends CertStoreSpi {
    private static final int CACHE_SIZE = 185;
    private static final int CHECK_INTERVAL = 30000;
    private static final int DEFAULT_CRL_CONNECT_TIMEOUT = 15000;
    private Collection<X509Certificate> certs;
    private X509CRL crl;
    private final CertificateFactory factory;
    private long lastChecked;
    private long lastModified;
    private boolean ldap;
    private CertStore ldapCertStore;
    private CertStoreHelper ldapHelper;
    private String ldapPath;
    private URI uri;
    private static final Debug debug = Debug.getInstance("certpath");
    private static final int CRL_CONNECT_TIMEOUT = initializeTimeout();
    private static final Cache<URICertStoreParameters, CertStore> certStoreCache = Cache.newSoftMemoryCache(185);

    private static int initializeTimeout() {
        Integer tmp = (Integer) AccessController.doPrivileged(new GetIntegerAction("com.sun.security.crl.timeout"));
        if (tmp == null || tmp.intValue() < 0) {
            return DEFAULT_CRL_CONNECT_TIMEOUT;
        }
        return tmp.intValue() * 1000;
    }

    URICertStore(CertStoreParameters params) throws InvalidAlgorithmParameterException, NoSuchAlgorithmException {
        super(params);
        this.certs = Collections.emptySet();
        this.ldap = false;
        if (!(params instanceof URICertStoreParameters)) {
            throw new InvalidAlgorithmParameterException("params must be instanceof URICertStoreParameters");
        }
        URI uri = ((URICertStoreParameters) params).uri;
        this.uri = uri;
        if (uri.getScheme().toLowerCase(Locale.ENGLISH).equals("ldap")) {
            this.ldap = true;
            CertStoreHelper certStoreHelper = CertStoreHelper.getInstance("LDAP");
            this.ldapHelper = certStoreHelper;
            this.ldapCertStore = certStoreHelper.getCertStore(this.uri);
            String path = this.uri.getPath();
            this.ldapPath = path;
            if (path.charAt(0) == '/') {
                this.ldapPath = this.ldapPath.substring(1);
            }
        }
        try {
            this.factory = CertificateFactory.getInstance(e.f29912b);
        } catch (CertificateException e2) {
            throw new RuntimeException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized CertStore getInstance(URICertStoreParameters params) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        CertStore ucs;
        synchronized (URICertStore.class) {
            Debug debug2 = debug;
            if (debug2 != null) {
                debug2.println("CertStore URI:" + ((Object) params.uri));
            }
            Cache<URICertStoreParameters, CertStore> cache = certStoreCache;
            ucs = cache.get(params);
            if (ucs == null) {
                ucs = new UCS(new URICertStore(params), null, "URI", params);
                cache.put(params, ucs);
            } else if (debug2 != null) {
                debug2.println("URICertStore.getInstance: cache hit");
            }
        }
        return ucs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CertStore getInstance(AccessDescription ad2) {
        if (!ad2.getAccessMethod().equals((Object) AccessDescription.Ad_CAISSUERS_Id)) {
            return null;
        }
        GeneralNameInterface gn = ad2.getAccessLocation().getName();
        if (!(gn instanceof URIName)) {
            return null;
        }
        URI uri = ((URIName) gn).getURI();
        try {
            return getInstance(new URICertStoreParameters(uri));
        } catch (Exception ex) {
            Debug debug2 = debug;
            if (debug2 != null) {
                debug2.println("exception creating CertStore: " + ((Object) ex));
                ex.printStackTrace();
            }
            return null;
        }
    }

    @Override // java.security.cert.CertStoreSpi
    public synchronized Collection<X509Certificate> engineGetCertificates(CertSelector selector) throws CertStoreException {
        long lastModified;
        if (this.ldap) {
            X509CertSelector xsel = (X509CertSelector) selector;
            try {
                return this.ldapCertStore.getCertificates(this.ldapHelper.wrap(xsel, xsel.getSubject(), this.ldapPath));
            } catch (IOException ioe) {
                throw new CertStoreException(ioe);
            }
        }
        long time = System.currentTimeMillis();
        if (time - this.lastChecked < 30000) {
            Debug debug2 = debug;
            if (debug2 != null) {
                debug2.println("Returning certificates from cache");
            }
            return getMatchingCerts(this.certs, selector);
        }
        this.lastChecked = time;
        try {
            URLConnection connection = this.uri.toURL().openConnection();
            long j10 = this.lastModified;
            if (j10 != 0) {
                connection.setIfModifiedSince(j10);
            }
            long oldLastModified = this.lastModified;
            InputStream in = connection.getInputStream();
            try {
                lastModified = connection.getLastModified();
                this.lastModified = lastModified;
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (oldLastModified != 0) {
                    if (oldLastModified == lastModified) {
                        Debug debug3 = debug;
                        if (debug3 != null) {
                            debug3.println("Not modified, using cached copy");
                        }
                        Collection<X509Certificate> matchingCerts = getMatchingCerts(this.certs, selector);
                        if (in != null) {
                            in.close();
                        }
                        return matchingCerts;
                    }
                    if (connection instanceof HttpURLConnection) {
                        HttpURLConnection hconn = (HttpURLConnection) connection;
                        if (hconn.getResponseCode() == 304) {
                            Debug debug4 = debug;
                            if (debug4 != null) {
                                debug4.println("Not modified, using cached copy");
                            }
                            Collection<X509Certificate> matchingCerts2 = getMatchingCerts(this.certs, selector);
                            if (in != null) {
                                in.close();
                            }
                            return matchingCerts2;
                        }
                    }
                }
                Debug debug5 = debug;
                if (debug5 != null) {
                    debug5.println("Downloading new certificates...");
                }
                this.certs = this.factory.generateCertificates(in);
                if (in != null) {
                    in.close();
                }
                return getMatchingCerts(this.certs, selector);
            } catch (Throwable th2) {
                th = th2;
                if (in != null) {
                    try {
                        in.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th;
            }
        } catch (IOException | CertificateException e2) {
            Debug debug6 = debug;
            if (debug6 != null) {
                debug6.println("Exception fetching certificates:");
                e2.printStackTrace();
            }
            this.lastModified = 0L;
            Set emptySet = Collections.emptySet();
            this.certs = emptySet;
            return emptySet;
        }
    }

    private static Collection<X509Certificate> getMatchingCerts(Collection<X509Certificate> certs, CertSelector selector) {
        if (selector == null) {
            return certs;
        }
        List<X509Certificate> matchedCerts = new ArrayList<>(certs.size());
        for (X509Certificate cert : certs) {
            if (selector.match(cert)) {
                matchedCerts.add(cert);
            }
        }
        return matchedCerts;
    }

    @Override // java.security.cert.CertStoreSpi
    public synchronized Collection<X509CRL> engineGetCRLs(CRLSelector selector) throws CertStoreException {
        long lastModified;
        if (this.ldap) {
            X509CRLSelector xsel = (X509CRLSelector) selector;
            try {
                try {
                    return this.ldapCertStore.getCRLs(this.ldapHelper.wrap(xsel, (Collection<X500Principal>) null, this.ldapPath));
                } catch (CertStoreException cse) {
                    throw new PKIX.CertStoreTypeException("LDAP", cse);
                }
            } catch (IOException ioe) {
                throw new CertStoreException(ioe);
            }
        }
        long time = System.currentTimeMillis();
        if (time - this.lastChecked < 30000) {
            Debug debug2 = debug;
            if (debug2 != null) {
                debug2.println("Returning CRL from cache");
            }
            return getMatchingCRLs(this.crl, selector);
        }
        this.lastChecked = time;
        try {
            URLConnection connection = this.uri.toURL().openConnection();
            long j10 = this.lastModified;
            if (j10 != 0) {
                connection.setIfModifiedSince(j10);
            }
            long oldLastModified = this.lastModified;
            connection.setConnectTimeout(CRL_CONNECT_TIMEOUT);
            connection.setReadTimeout(601000);
            InputStream in = connection.getInputStream();
            try {
                lastModified = connection.getLastModified();
                this.lastModified = lastModified;
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (oldLastModified != 0) {
                    if (oldLastModified == lastModified) {
                        Debug debug3 = debug;
                        if (debug3 != null) {
                            debug3.println("Not modified, using cached copy");
                        }
                        Collection<X509CRL> matchingCRLs = getMatchingCRLs(this.crl, selector);
                        if (in != null) {
                            in.close();
                        }
                        return matchingCRLs;
                    }
                    if (connection instanceof HttpURLConnection) {
                        HttpURLConnection hconn = (HttpURLConnection) connection;
                        if (hconn.getResponseCode() == 304) {
                            Debug debug4 = debug;
                            if (debug4 != null) {
                                debug4.println("Not modified, using cached copy");
                            }
                            Collection<X509CRL> matchingCRLs2 = getMatchingCRLs(this.crl, selector);
                            if (in != null) {
                                in.close();
                            }
                            return matchingCRLs2;
                        }
                    }
                }
                Debug debug5 = debug;
                if (debug5 != null) {
                    debug5.println("Downloading new CRL...");
                }
                this.crl = (X509CRL) this.factory.generateCRL(in);
                if (in != null) {
                    in.close();
                }
                return getMatchingCRLs(this.crl, selector);
            } catch (Throwable th2) {
                th = th2;
                if (in != null) {
                    try {
                        in.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th;
            }
        } catch (IOException | CRLException e2) {
            Debug debug6 = debug;
            if (debug6 != null) {
                debug6.println("Exception fetching CRL:");
                e2.printStackTrace();
            }
            this.lastModified = 0L;
            this.crl = null;
            throw new PKIX.CertStoreTypeException("URI", new CertStoreException(e2));
        }
    }

    private static Collection<X509CRL> getMatchingCRLs(X509CRL crl, CRLSelector selector) {
        if (selector == null || (crl != null && selector.match(crl))) {
            return Collections.singletonList(crl);
        }
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class URICertStoreParameters implements CertStoreParameters {
        private volatile int hashCode = 0;
        private final URI uri;

        /* JADX INFO: Access modifiers changed from: package-private */
        public URICertStoreParameters(URI uri) {
            this.uri = uri;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof URICertStoreParameters)) {
                return false;
            }
            URICertStoreParameters params = (URICertStoreParameters) obj;
            return this.uri.equals(params.uri);
        }

        public int hashCode() {
            if (this.hashCode == 0) {
                int result = (17 * 37) + this.uri.hashCode();
                this.hashCode = result;
            }
            return this.hashCode;
        }

        @Override // java.security.cert.CertStoreParameters
        public Object clone() {
            try {
                return super.clone();
            } catch (CloneNotSupportedException e2) {
                throw new InternalError(e2.toString(), e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class UCS extends CertStore {
        protected UCS(CertStoreSpi spi, Provider p10, String type, CertStoreParameters params) {
            super(spi, p10, type, params);
        }
    }
}
