package sun.nio.ch;

import java.io.IOException;
import java.nio.channels.Channel;
import java.nio.channels.spi.AbstractSelector;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class PollSelectorProvider extends SelectorProviderImpl {
    @Override // sun.nio.ch.SelectorProviderImpl, java.nio.channels.spi.SelectorProvider
    public AbstractSelector openSelector() throws IOException {
        return new PollSelectorImpl(this);
    }

    @Override // java.nio.channels.spi.SelectorProvider
    public Channel inheritedChannel() throws IOException {
        return null;
    }
}
