package sun.nio.ch;

import java.nio.channels.spi.AsynchronousChannelProvider;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DefaultAsynchronousChannelProvider {
    private DefaultAsynchronousChannelProvider() {
    }

    private static AsynchronousChannelProvider createProvider(String cn2) {
        try {
            try {
                return (AsynchronousChannelProvider) Class.forName(cn2).newInstance();
            } catch (IllegalAccessException | InstantiationException x10) {
                throw new AssertionError(x10);
            }
        } catch (ClassNotFoundException x11) {
            throw new AssertionError(x11);
        }
    }

    public static AsynchronousChannelProvider create() {
        return createProvider("sun.nio.ch.LinuxAsynchronousChannelProvider");
    }
}
