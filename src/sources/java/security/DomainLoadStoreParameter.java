package java.security;

import java.net.URI;
import java.security.KeyStore;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class DomainLoadStoreParameter implements KeyStore.LoadStoreParameter {
    private final URI configuration;
    private final Map<String, KeyStore.ProtectionParameter> protectionParams;

    public DomainLoadStoreParameter(URI configuration, Map<String, KeyStore.ProtectionParameter> protectionParams) {
        if (configuration == null || protectionParams == null) {
            throw new NullPointerException("invalid null input");
        }
        this.configuration = configuration;
        this.protectionParams = Collections.unmodifiableMap(new HashMap(protectionParams));
    }

    public URI getConfiguration() {
        return this.configuration;
    }

    public Map<String, KeyStore.ProtectionParameter> getProtectionParams() {
        return this.protectionParams;
    }

    @Override // java.security.KeyStore.LoadStoreParameter
    public KeyStore.ProtectionParameter getProtectionParameter() {
        return null;
    }
}
