package android.webkit;

import android.annotation.SystemApi;
import android.net.Network;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
@SystemApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface PacProcessor {
    String findProxyForUrl(String str);

    boolean setProxyScript(String str);

    static PacProcessor getInstance() {
        return WebViewFactory.getProvider().getPacProcessor();
    }

    static PacProcessor createInstance() {
        return WebViewFactory.getProvider().createPacProcessor();
    }

    default void release() {
        throw new UnsupportedOperationException("Not implemented");
    }

    default void setNetwork(Network network) {
        throw new UnsupportedOperationException("Not implemented");
    }

    default Network getNetwork() {
        throw new UnsupportedOperationException("Not implemented");
    }
}
