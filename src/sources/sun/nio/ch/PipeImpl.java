package sun.nio.ch;

import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.channels.Pipe;
import java.nio.channels.spi.SelectorProvider;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class PipeImpl extends Pipe {
    private final Pipe.SinkChannel sink;
    private final Pipe.SourceChannel source;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PipeImpl(SelectorProvider sp) throws IOException {
        long pipeFds = IOUtil.makePipe(true);
        int readFd = (int) (pipeFds >>> 32);
        int writeFd = (int) pipeFds;
        FileDescriptor sourcefd = new FileDescriptor();
        IOUtil.setfdVal(sourcefd, readFd);
        this.source = new SourceChannelImpl(sp, sourcefd);
        FileDescriptor sinkfd = new FileDescriptor();
        IOUtil.setfdVal(sinkfd, writeFd);
        this.sink = new SinkChannelImpl(sp, sinkfd);
    }

    @Override // java.nio.channels.Pipe
    public Pipe.SourceChannel source() {
        return this.source;
    }

    @Override // java.nio.channels.Pipe
    public Pipe.SinkChannel sink() {
        return this.sink;
    }
}
