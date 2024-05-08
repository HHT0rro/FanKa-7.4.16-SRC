package javax.net.ssl;

import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class KeyStoreBuilderParameters implements ManagerFactoryParameters {
    private final List<KeyStore.Builder> parameters;

    public KeyStoreBuilderParameters(KeyStore.Builder builder) {
        this.parameters = Collections.singletonList((KeyStore.Builder) Objects.requireNonNull(builder));
    }

    public KeyStoreBuilderParameters(List<KeyStore.Builder> parameters) {
        if (parameters.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.parameters = Collections.unmodifiableList(new ArrayList(parameters));
    }

    public List<KeyStore.Builder> getParameters() {
        return this.parameters;
    }
}
