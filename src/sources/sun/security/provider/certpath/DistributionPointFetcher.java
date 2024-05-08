package sun.security.provider.certpath;

import java.io.IOException;
import java.net.URI;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.CertificateException;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLSelector;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import sun.security.provider.certpath.PKIX;
import sun.security.provider.certpath.URICertStore;
import sun.security.util.Debug;
import sun.security.x509.AuthorityKeyIdentifierExtension;
import sun.security.x509.CRLDistributionPointsExtension;
import sun.security.x509.DistributionPoint;
import sun.security.x509.GeneralName;
import sun.security.x509.GeneralNames;
import sun.security.x509.RDN;
import sun.security.x509.URIName;
import sun.security.x509.X500Name;
import sun.security.x509.X509CRLImpl;
import sun.security.x509.X509CertImpl;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DistributionPointFetcher {
    private static final Debug debug = Debug.getInstance("certpath");
    private static final boolean[] ALL_REASONS = {true, true, true, true, true, true, true, true, true};

    private DistributionPointFetcher() {
    }

    public static Collection<X509CRL> getCRLs(X509CRLSelector selector, boolean signFlag, PublicKey prevKey, String provider, List<CertStore> certStores, boolean[] reasonsMask, Set<TrustAnchor> trustAnchors, Date validity) throws CertStoreException {
        return getCRLs(selector, signFlag, prevKey, null, provider, certStores, reasonsMask, trustAnchors, validity);
    }

    public static Collection<X509CRL> getCRLs(X509CRLSelector selector, boolean signFlag, PublicKey prevKey, X509Certificate prevCert, String provider, List<CertStore> certStores, boolean[] reasonsMask, Set<TrustAnchor> trustAnchors, Date validity) throws CertStoreException {
        X509Certificate cert = selector.getCertificateChecking();
        if (cert == null) {
            return Collections.emptySet();
        }
        try {
            X509CertImpl certImpl = X509CertImpl.toImpl(cert);
            Debug debug2 = debug;
            if (debug2 != null) {
                debug2.println("DistributionPointFetcher.getCRLs: Checking CRLDPs for " + ((Object) certImpl.getSubjectX500Principal()));
            }
            CRLDistributionPointsExtension ext = certImpl.getCRLDistributionPointsExtension();
            if (ext == null) {
                if (debug2 != null) {
                    debug2.println("No CRLDP ext");
                }
                return Collections.emptySet();
            }
            List<DistributionPoint> points = ext.get(CRLDistributionPointsExtension.POINTS);
            Set<X509CRL> results = new HashSet<>();
            Iterator<DistributionPoint> t2 = points.iterator2();
            while (t2.hasNext() && !Arrays.equals(reasonsMask, ALL_REASONS)) {
                DistributionPoint point = t2.next();
                Collection<X509CRL> crls = getCRLs(selector, certImpl, point, reasonsMask, signFlag, prevKey, prevCert, provider, certStores, trustAnchors, validity);
                results.addAll(crls);
            }
            Debug debug3 = debug;
            if (debug3 != null) {
                debug3.println("Returning " + results.size() + " CRLs");
            }
            return results;
        } catch (IOException | CertificateException e2) {
            return Collections.emptySet();
        }
    }

    private static Collection<X509CRL> getCRLs(X509CRLSelector selector, X509CertImpl certImpl, DistributionPoint point, boolean[] reasonsMask, boolean signFlag, PublicKey prevKey, X509Certificate prevCert, String provider, List<CertStore> certStores, Set<TrustAnchor> trustAnchors, Date validity) throws CertStoreException {
        GeneralNames fullName = point.getFullName();
        if (fullName == null) {
            RDN relativeName = point.getRelativeName();
            if (relativeName == null) {
                return Collections.emptySet();
            }
            try {
                GeneralNames crlIssuers = point.getCRLIssuer();
                if (crlIssuers == null) {
                    fullName = getFullNames((X500Name) certImpl.getIssuerDN(), relativeName);
                } else {
                    if (crlIssuers.size() != 1) {
                        return Collections.emptySet();
                    }
                    fullName = getFullNames((X500Name) crlIssuers.get(0).getName(), relativeName);
                }
            } catch (IOException e2) {
                return Collections.emptySet();
            }
        }
        Collection<X509CRL> possibleCRLs = new ArrayList<>();
        Iterator<GeneralName> t2 = fullName.iterator();
        CertStoreException savedCSE = null;
        while (t2.hasNext()) {
            try {
                GeneralName name = t2.next();
                if (name.getType() == 4) {
                    X500Name x500Name = (X500Name) name.getName();
                    try {
                        possibleCRLs.addAll(getCRLs(x500Name, certImpl.getIssuerX500Principal(), certStores));
                    } catch (CertStoreException e10) {
                        cse = e10;
                        savedCSE = cse;
                    }
                } else if (name.getType() == 6) {
                    URIName uriName = (URIName) name.getName();
                    X509CRL crl = getCRL(uriName);
                    if (crl != null) {
                        possibleCRLs.add(crl);
                    }
                }
            } catch (CertStoreException e11) {
                cse = e11;
            }
        }
        if (possibleCRLs.isEmpty() && savedCSE != null) {
            throw savedCSE;
        }
        Collection<X509CRL> crls = new ArrayList<>(2);
        for (X509CRL crl2 : possibleCRLs) {
            try {
                selector.setIssuerNames(null);
                if (selector.match(crl2) && verifyCRL(certImpl, point, crl2, reasonsMask, signFlag, prevKey, prevCert, provider, trustAnchors, certStores, validity)) {
                    crls.add(crl2);
                }
            } catch (IOException | CRLException e12) {
                Debug debug2 = debug;
                if (debug2 != null) {
                    debug2.println("Exception verifying CRL: " + e12.getMessage());
                    e12.printStackTrace();
                }
            }
        }
        return crls;
    }

    private static X509CRL getCRL(URIName name) throws CertStoreException {
        URI uri = name.getURI();
        Debug debug2 = debug;
        if (debug2 != null) {
            debug2.println("Trying to fetch CRL from DP " + ((Object) uri));
        }
        try {
            CertStore ucs = URICertStore.getInstance(new URICertStore.URICertStoreParameters(uri));
            Collection<? extends CRL> crls = ucs.getCRLs(null);
            if (crls.isEmpty()) {
                return null;
            }
            return (X509CRL) crls.iterator2().next();
        } catch (InvalidAlgorithmParameterException | NoSuchAlgorithmException e2) {
            Debug debug3 = debug;
            if (debug3 != null) {
                debug3.println("Can't create URICertStore: " + e2.getMessage());
            }
            return null;
        }
    }

    private static Collection<X509CRL> getCRLs(X500Name name, X500Principal certIssuer, List<CertStore> certStores) throws CertStoreException {
        Debug debug2 = debug;
        if (debug2 != null) {
            debug2.println("Trying to fetch CRL from DP " + ((Object) name));
        }
        X509CRLSelector xcs = new X509CRLSelector();
        xcs.addIssuer(name.asX500Principal());
        xcs.addIssuer(certIssuer);
        Collection<X509CRL> crls = new ArrayList<>();
        CertStoreException savedCSE = null;
        for (CertStore store : certStores) {
            try {
                for (CRL crl : store.getCRLs(xcs)) {
                    crls.add((X509CRL) crl);
                }
            } catch (CertStoreException cse) {
                Debug debug3 = debug;
                if (debug3 != null) {
                    debug3.println("Exception while retrieving CRLs: " + ((Object) cse));
                    cse.printStackTrace();
                }
                savedCSE = new PKIX.CertStoreTypeException(store.getType(), cse);
            }
        }
        if (crls.isEmpty() && savedCSE != null) {
            throw savedCSE;
        }
        return crls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0392 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x03a5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x03a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean verifyCRL(sun.security.x509.X509CertImpl r25, sun.security.x509.DistributionPoint r26, java.security.cert.X509CRL r27, boolean[] r28, boolean r29, java.security.PublicKey r30, java.security.cert.X509Certificate r31, java.lang.String r32, java.util.Set<java.security.cert.TrustAnchor> r33, java.util.List<java.security.cert.CertStore> r34, java.util.Date r35) throws java.security.cert.CRLException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 1278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.DistributionPointFetcher.verifyCRL(sun.security.x509.X509CertImpl, sun.security.x509.DistributionPoint, java.security.cert.X509CRL, boolean[], boolean, java.security.PublicKey, java.security.cert.X509Certificate, java.lang.String, java.util.Set, java.util.List, java.util.Date):boolean");
    }

    private static GeneralNames getFullNames(X500Name issuer, RDN rdn) throws IOException {
        List<RDN> rdns = new ArrayList<>(issuer.rdns());
        rdns.add(rdn);
        X500Name fullName = new X500Name((RDN[]) rdns.toArray(new RDN[0]));
        GeneralNames fullNames = new GeneralNames();
        fullNames.add(new GeneralName(fullName));
        return fullNames;
    }

    private static boolean issues(X509CertImpl cert, X509CRLImpl crl, String provider) throws IOException {
        AdaptableX509CertSelector issuerSelector = new AdaptableX509CertSelector();
        boolean[] usages = cert.getKeyUsage();
        if (usages != null) {
            usages[6] = true;
            issuerSelector.setKeyUsage(usages);
        }
        X500Principal crlIssuer = crl.getIssuerX500Principal();
        issuerSelector.setSubject(crlIssuer);
        AuthorityKeyIdentifierExtension crlAKID = crl.getAuthKeyIdExtension();
        issuerSelector.setSkiAndSerialNumber(crlAKID);
        boolean matched = issuerSelector.match(cert);
        if (matched) {
            if (crlAKID == null || cert.getAuthorityKeyIdentifierExtension() == null) {
                try {
                    crl.verify(cert.getPublicKey(), provider);
                    return true;
                } catch (GeneralSecurityException e2) {
                    return false;
                }
            }
            return matched;
        }
        return matched;
    }
}
