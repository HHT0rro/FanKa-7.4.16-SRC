package sun.security.provider.certpath;

import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.PKIXCertPathBuilderResult;
import java.security.cert.PolicyNode;
import java.security.cert.TrustAnchor;
import sun.security.util.Debug;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class SunCertPathBuilderResult extends PKIXCertPathBuilderResult {
    private static final Debug debug = Debug.getInstance("certpath");
    private AdjacencyList adjList;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SunCertPathBuilderResult(CertPath certPath, TrustAnchor trustAnchor, PolicyNode policyTree, PublicKey subjectPublicKey, AdjacencyList adjList) {
        super(certPath, trustAnchor, policyTree, subjectPublicKey);
        this.adjList = adjList;
    }

    public AdjacencyList getAdjacencyList() {
        return this.adjList;
    }
}
