package java.security.cert;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class PKIXRevocationChecker extends PKIXCertPathChecker {
    private URI ocspResponder;
    private X509Certificate ocspResponderCert;
    private List<Extension> ocspExtensions = Collections.emptyList();
    private Map<X509Certificate, byte[]> ocspResponses = Collections.emptyMap();
    private Set<Option> options = Collections.emptySet();

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public enum Option {
        ONLY_END_ENTITY,
        PREFER_CRLS,
        NO_FALLBACK,
        SOFT_FAIL
    }

    public abstract List<CertPathValidatorException> getSoftFailExceptions();

    public void setOcspResponder(URI uri) {
        this.ocspResponder = uri;
    }

    public URI getOcspResponder() {
        return this.ocspResponder;
    }

    public void setOcspResponderCert(X509Certificate cert) {
        this.ocspResponderCert = cert;
    }

    public X509Certificate getOcspResponderCert() {
        return this.ocspResponderCert;
    }

    public void setOcspExtensions(List<Extension> extensions) {
        List<Extension> arrayList;
        if (extensions == null) {
            arrayList = Collections.emptyList();
        } else {
            arrayList = new ArrayList<>(extensions);
        }
        this.ocspExtensions = arrayList;
    }

    public List<Extension> getOcspExtensions() {
        return Collections.unmodifiableList(this.ocspExtensions);
    }

    public void setOcspResponses(Map<X509Certificate, byte[]> responses) {
        if (responses == null) {
            this.ocspResponses = Collections.emptyMap();
            return;
        }
        Map<X509Certificate, byte[]> copy = new HashMap<>(responses.size());
        for (Map.Entry<X509Certificate, byte[]> e2 : responses.entrySet()) {
            copy.put(e2.getKey(), (byte[]) e2.getValue().clone());
        }
        this.ocspResponses = copy;
    }

    public Map<X509Certificate, byte[]> getOcspResponses() {
        Map<X509Certificate, byte[]> copy = new HashMap<>(this.ocspResponses.size());
        for (Map.Entry<X509Certificate, byte[]> e2 : this.ocspResponses.entrySet()) {
            copy.put(e2.getKey(), (byte[]) e2.getValue().clone());
        }
        return copy;
    }

    public void setOptions(Set<Option> options) {
        Set<Option> hashSet;
        if (options == null) {
            hashSet = Collections.emptySet();
        } else {
            hashSet = new HashSet<>(options);
        }
        this.options = hashSet;
    }

    public Set<Option> getOptions() {
        return Collections.unmodifiableSet(this.options);
    }

    @Override // java.security.cert.PKIXCertPathChecker
    public PKIXRevocationChecker clone() {
        PKIXRevocationChecker copy = (PKIXRevocationChecker) super.clone();
        copy.ocspExtensions = new ArrayList(this.ocspExtensions);
        HashMap hashMap = new HashMap(this.ocspResponses);
        copy.ocspResponses = hashMap;
        for (Map.Entry<X509Certificate, byte[]> entry : hashMap.entrySet()) {
            byte[] encoded = entry.getValue();
            entry.setValue((byte[]) encoded.clone());
        }
        copy.options = new HashSet(this.options);
        return copy;
    }
}
