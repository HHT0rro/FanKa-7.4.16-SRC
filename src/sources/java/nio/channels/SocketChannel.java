package java.nio.channels;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketOption;
import java.nio.ByteBuffer;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.channels.spi.SelectorProvider;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class SocketChannel extends AbstractSelectableChannel implements ByteChannel, ScatteringByteChannel, GatheringByteChannel, NetworkChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @Override // java.nio.channels.NetworkChannel
    public abstract SocketChannel bind(SocketAddress socketAddress) throws IOException;

    public abstract boolean connect(SocketAddress socketAddress) throws IOException;

    public abstract boolean finishConnect() throws IOException;

    @Override // java.nio.channels.NetworkChannel
    public abstract SocketAddress getLocalAddress() throws IOException;

    public abstract SocketAddress getRemoteAddress() throws IOException;

    public abstract boolean isConnected();

    public abstract boolean isConnectionPending();

    @Override // java.nio.channels.ReadableByteChannel
    public abstract int read(ByteBuffer byteBuffer) throws IOException;

    @Override // java.nio.channels.ScatteringByteChannel
    public abstract long read(ByteBuffer[] byteBufferArr, int i10, int i11) throws IOException;

    @Override // java.nio.channels.NetworkChannel
    public abstract <T> SocketChannel setOption(SocketOption<T> socketOption, T t2) throws IOException;

    public abstract SocketChannel shutdownInput() throws IOException;

    public abstract SocketChannel shutdownOutput() throws IOException;

    public abstract Socket socket();

    @Override // java.nio.channels.WritableByteChannel
    public abstract int write(ByteBuffer byteBuffer) throws IOException;

    @Override // java.nio.channels.GatheringByteChannel
    public abstract long write(ByteBuffer[] byteBufferArr, int i10, int i11) throws IOException;

    @Override // java.nio.channels.NetworkChannel
    public /* bridge */ /* synthetic */ NetworkChannel setOption(SocketOption socketOption, Object obj) throws IOException {
        return setOption((SocketOption<SocketOption>) socketOption, (SocketOption) obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SocketChannel(SelectorProvider provider) {
        super(provider);
    }

    public static SocketChannel open() throws IOException {
        return SelectorProvider.provider().openSocketChannel();
    }

    public static SocketChannel open(SocketAddress remote) throws IOException {
        SocketChannel sc2 = open();
        try {
            sc2.connect(remote);
            return sc2;
        } catch (Throwable x10) {
            try {
                sc2.close();
            } catch (Throwable suppressed) {
                x10.addSuppressed(suppressed);
            }
            throw x10;
        }
    }

    @Override // java.nio.channels.SelectableChannel
    public final int validOps() {
        return 13;
    }

    @Override // java.nio.channels.ScatteringByteChannel
    public final long read(ByteBuffer[] dsts) throws IOException {
        return read(dsts, 0, dsts.length);
    }

    @Override // java.nio.channels.GatheringByteChannel
    public final long write(ByteBuffer[] srcs) throws IOException {
        return write(srcs, 0, srcs.length);
    }
}
