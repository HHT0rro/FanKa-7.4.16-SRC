package java.nio.channels;

import java.io.IOException;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.channels.spi.SelectorProvider;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class Pipe {
    public abstract SinkChannel sink();

    public abstract SourceChannel source();

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class SourceChannel extends AbstractSelectableChannel implements ReadableByteChannel, ScatteringByteChannel {
        /* JADX INFO: Access modifiers changed from: protected */
        public SourceChannel(SelectorProvider provider) {
            super(provider);
        }

        @Override // java.nio.channels.SelectableChannel
        public final int validOps() {
            return 1;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class SinkChannel extends AbstractSelectableChannel implements WritableByteChannel, GatheringByteChannel {
        /* JADX INFO: Access modifiers changed from: protected */
        public SinkChannel(SelectorProvider provider) {
            super(provider);
        }

        @Override // java.nio.channels.SelectableChannel
        public final int validOps() {
            return 4;
        }
    }

    public static Pipe open() throws IOException {
        return SelectorProvider.provider().openPipe();
    }
}
