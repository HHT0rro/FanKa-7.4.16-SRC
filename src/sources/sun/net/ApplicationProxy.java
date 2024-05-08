package sun.net;

import java.net.Proxy;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class ApplicationProxy extends Proxy {
    private ApplicationProxy(Proxy proxy) {
        super(proxy.type(), proxy.address());
    }

    public static ApplicationProxy create(Proxy proxy) {
        return new ApplicationProxy(proxy);
    }
}
