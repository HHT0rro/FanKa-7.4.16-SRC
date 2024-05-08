package sun.security.provider.certpath;

import com.huawei.hms.feature.dynamic.f.e;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.PublicKey;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathBuilderResult;
import java.security.cert.CertPathBuilderSpi;
import java.security.cert.CertPathChecker;
import java.security.cert.CertPathParameters;
import java.security.cert.CertSelector;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.PKIXCertPathBuilderResult;
import java.security.cert.PolicyNode;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import sun.security.provider.certpath.PKIX;
import sun.security.util.Debug;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class SunCertPathBuilder extends CertPathBuilderSpi {
    private static final Debug debug = Debug.getInstance("certpath");
    private PKIX.BuilderParams buildParams;
    private CertificateFactory cf;
    private PublicKey finalPublicKey;
    private boolean pathCompleted = false;
    private PolicyNode policyTreeResult;
    private TrustAnchor trustAnchor;

    public SunCertPathBuilder() throws CertPathBuilderException {
        try {
            this.cf = CertificateFactory.getInstance(e.f29912b);
        } catch (CertificateException e2) {
            throw new CertPathBuilderException(e2);
        }
    }

    @Override // java.security.cert.CertPathBuilderSpi
    public CertPathChecker engineGetRevocationChecker() {
        return new RevocationChecker();
    }

    @Override // java.security.cert.CertPathBuilderSpi
    public CertPathBuilderResult engineBuild(CertPathParameters params) throws CertPathBuilderException, InvalidAlgorithmParameterException {
        Debug debug2 = debug;
        if (debug2 != null) {
            debug2.println("SunCertPathBuilder.engineBuild(" + ((Object) params) + ")");
        }
        this.buildParams = PKIX.checkBuilderParams(params);
        return build();
    }

    private PKIXCertPathBuilderResult build() throws CertPathBuilderException {
        List<List<Vertex>> adjList = new ArrayList<>();
        PKIXCertPathBuilderResult result = buildCertPath(false, adjList);
        if (result == null) {
            Debug debug2 = debug;
            if (debug2 != null) {
                debug2.println("SunCertPathBuilder.engineBuild: 2nd pass; try building again searching all certstores");
            }
            adjList.clear();
            result = buildCertPath(true, adjList);
            if (result == null) {
                throw new SunCertPathBuilderException("unable to find valid certification path to requested target", new AdjacencyList(adjList));
            }
        }
        return result;
    }

    private PKIXCertPathBuilderResult buildCertPath(boolean searchAllCertStores, List<List<Vertex>> adjList) throws CertPathBuilderException {
        this.pathCompleted = false;
        this.trustAnchor = null;
        this.finalPublicKey = null;
        this.policyTreeResult = null;
        LinkedList<X509Certificate> certPathList = new LinkedList<>();
        try {
            buildForward(adjList, certPathList, searchAllCertStores);
            try {
                if (!this.pathCompleted) {
                    return null;
                }
                Debug debug2 = debug;
                if (debug2 != null) {
                    debug2.println("SunCertPathBuilder.engineBuild() pathCompleted");
                }
                Collections.reverse(certPathList);
                return new SunCertPathBuilderResult(this.cf.generateCertPath(certPathList), this.trustAnchor, this.policyTreeResult, this.finalPublicKey, new AdjacencyList(adjList));
            } catch (CertificateException e2) {
                Debug debug3 = debug;
                if (debug3 != null) {
                    debug3.println("SunCertPathBuilder.engineBuild() exception in wrap-up");
                    e2.printStackTrace();
                }
                throw new SunCertPathBuilderException("unable to find valid certification path to requested target", e2, new AdjacencyList(adjList));
            }
        } catch (IOException | GeneralSecurityException e10) {
            Debug debug4 = debug;
            if (debug4 != null) {
                debug4.println("SunCertPathBuilder.engineBuild() exception in build");
                e10.printStackTrace();
            }
            throw new SunCertPathBuilderException("unable to find valid certification path to requested target", e10, new AdjacencyList(adjList));
        }
    }

    private void buildForward(List<List<Vertex>> adjacencyList, LinkedList<X509Certificate> certPathList, boolean searchAllCertStores) throws GeneralSecurityException, IOException {
        Debug debug2 = debug;
        if (debug2 != null) {
            debug2.println("SunCertPathBuilder.buildForward()...");
        }
        ForwardState currentState = new ForwardState();
        currentState.initState(this.buildParams.certPathCheckers());
        adjacencyList.clear();
        adjacencyList.add(new LinkedList());
        depthFirstSearchForward(this.buildParams.targetSubject(), currentState, new ForwardBuilder(this.buildParams, searchAllCertStores), adjacencyList, certPathList);
    }

    /* JADX WARN: Incorrect condition in loop: B:46:0x0188 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void depthFirstSearchForward(javax.security.auth.x500.X500Principal r34, sun.security.provider.certpath.ForwardState r35, sun.security.provider.certpath.ForwardBuilder r36, java.util.List<java.util.List<sun.security.provider.certpath.Vertex>> r37, java.util.LinkedList<java.security.cert.X509Certificate> r38) throws java.security.GeneralSecurityException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 1076
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.security.provider.certpath.SunCertPathBuilder.depthFirstSearchForward(javax.security.auth.x500.X500Principal, sun.security.provider.certpath.ForwardState, sun.security.provider.certpath.ForwardBuilder, java.util.List, java.util.LinkedList):void");
    }

    private static List<Vertex> addVertices(Collection<X509Certificate> certs, List<List<Vertex>> adjList) {
        List<Vertex> l10 = adjList.get(adjList.size() - 1);
        for (X509Certificate cert : certs) {
            Vertex v2 = new Vertex(cert);
            l10.add(v2);
        }
        return l10;
    }

    private static boolean anchorIsTarget(TrustAnchor anchor, CertSelector sel) {
        X509Certificate anchorCert = anchor.getTrustedCert();
        if (anchorCert != null) {
            return sel.match(anchorCert);
        }
        return false;
    }
}
