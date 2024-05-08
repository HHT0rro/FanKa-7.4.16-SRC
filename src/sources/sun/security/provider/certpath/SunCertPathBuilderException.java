package sun.security.provider.certpath;

import java.security.cert.CertPathBuilderException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class SunCertPathBuilderException extends CertPathBuilderException {
    private static final long serialVersionUID = -7814288414129264709L;
    private transient AdjacencyList adjList;

    public SunCertPathBuilderException() {
    }

    public SunCertPathBuilderException(String msg) {
        super(msg);
    }

    public SunCertPathBuilderException(Throwable cause) {
        super(cause);
    }

    public SunCertPathBuilderException(String msg, Throwable cause) {
        super(msg, cause);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SunCertPathBuilderException(String msg, AdjacencyList adjList) {
        this(msg);
        this.adjList = adjList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SunCertPathBuilderException(String msg, Throwable cause, AdjacencyList adjList) {
        this(msg, cause);
        this.adjList = adjList;
    }

    public AdjacencyList getAdjacencyList() {
        return this.adjList;
    }
}
