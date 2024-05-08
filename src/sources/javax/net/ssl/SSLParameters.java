package javax.net.ssl;

import java.security.AlgorithmConstraints;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class SSLParameters {
    private AlgorithmConstraints algorithmConstraints;
    private String[] applicationProtocols;
    private String[] cipherSuites;
    private String identificationAlgorithm;
    private boolean needClientAuth;
    private boolean preferLocalCipherSuites;
    private String[] protocols;
    private Map<Integer, SNIMatcher> sniMatchers;
    private Map<Integer, SNIServerName> sniNames;
    private boolean wantClientAuth;

    public SSLParameters() {
        this.sniNames = null;
        this.sniMatchers = null;
        this.applicationProtocols = new String[0];
    }

    public SSLParameters(String[] cipherSuites) {
        this.sniNames = null;
        this.sniMatchers = null;
        this.applicationProtocols = new String[0];
        setCipherSuites(cipherSuites);
    }

    public SSLParameters(String[] cipherSuites, String[] protocols) {
        this.sniNames = null;
        this.sniMatchers = null;
        this.applicationProtocols = new String[0];
        setCipherSuites(cipherSuites);
        setProtocols(protocols);
    }

    private static String[] clone(String[] s2) {
        if (s2 == null) {
            return null;
        }
        return (String[]) s2.clone();
    }

    public String[] getCipherSuites() {
        return clone(this.cipherSuites);
    }

    public void setCipherSuites(String[] cipherSuites) {
        this.cipherSuites = clone(cipherSuites);
    }

    public String[] getProtocols() {
        return clone(this.protocols);
    }

    public void setProtocols(String[] protocols) {
        this.protocols = clone(protocols);
    }

    public boolean getWantClientAuth() {
        return this.wantClientAuth;
    }

    public void setWantClientAuth(boolean wantClientAuth) {
        this.wantClientAuth = wantClientAuth;
        this.needClientAuth = false;
    }

    public boolean getNeedClientAuth() {
        return this.needClientAuth;
    }

    public void setNeedClientAuth(boolean needClientAuth) {
        this.wantClientAuth = false;
        this.needClientAuth = needClientAuth;
    }

    public AlgorithmConstraints getAlgorithmConstraints() {
        return this.algorithmConstraints;
    }

    public void setAlgorithmConstraints(AlgorithmConstraints constraints) {
        this.algorithmConstraints = constraints;
    }

    public String getEndpointIdentificationAlgorithm() {
        return this.identificationAlgorithm;
    }

    public void setEndpointIdentificationAlgorithm(String algorithm) {
        this.identificationAlgorithm = algorithm;
    }

    public final void setServerNames(List<SNIServerName> serverNames) {
        if (serverNames != null) {
            if (!serverNames.isEmpty()) {
                this.sniNames = new LinkedHashMap(serverNames.size());
                for (SNIServerName serverName : serverNames) {
                    if (this.sniNames.put(Integer.valueOf(serverName.getType()), serverName) != null) {
                        throw new IllegalArgumentException("Duplicated server name of type " + serverName.getType());
                    }
                }
                return;
            }
            this.sniNames = Collections.emptyMap();
            return;
        }
        this.sniNames = null;
    }

    public final List<SNIServerName> getServerNames() {
        Map<Integer, SNIServerName> map = this.sniNames;
        if (map != null) {
            if (!map.isEmpty()) {
                return Collections.unmodifiableList(new ArrayList(this.sniNames.values()));
            }
            return Collections.emptyList();
        }
        return null;
    }

    public final void setSNIMatchers(Collection<SNIMatcher> matchers) {
        if (matchers != null) {
            if (!matchers.isEmpty()) {
                this.sniMatchers = new HashMap(matchers.size());
                for (SNIMatcher matcher : matchers) {
                    if (this.sniMatchers.put(Integer.valueOf(matcher.getType()), matcher) != null) {
                        throw new IllegalArgumentException("Duplicated server name of type " + matcher.getType());
                    }
                }
                return;
            }
            this.sniMatchers = Collections.emptyMap();
            return;
        }
        this.sniMatchers = null;
    }

    public final Collection<SNIMatcher> getSNIMatchers() {
        Map<Integer, SNIMatcher> map = this.sniMatchers;
        if (map != null) {
            if (!map.isEmpty()) {
                return Collections.unmodifiableList(new ArrayList(this.sniMatchers.values()));
            }
            return Collections.emptyList();
        }
        return null;
    }

    public final void setUseCipherSuitesOrder(boolean honorOrder) {
        this.preferLocalCipherSuites = honorOrder;
    }

    public final boolean getUseCipherSuitesOrder() {
        return this.preferLocalCipherSuites;
    }

    public String[] getApplicationProtocols() {
        return (String[]) this.applicationProtocols.clone();
    }

    public void setApplicationProtocols(String[] protocols) {
        if (protocols == null) {
            throw new IllegalArgumentException("protocols was null");
        }
        String[] tempProtocols = (String[]) protocols.clone();
        for (String p10 : tempProtocols) {
            if (p10 == null || p10.equals("")) {
                throw new IllegalArgumentException("An element of protocols was null/empty");
            }
        }
        this.applicationProtocols = tempProtocols;
    }
}
